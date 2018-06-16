/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import webapp.common.constants.HTTPConstants;
import webapp.common.exception.ITSException;
import webapp.common.exception.ITSRuntimeException;
import webapp.common.result.BaseResult;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 基础Controller, 包装了一些公用的方法,也包含一些公共的非业务数据级别的服务, 比如枚举和字典服务。
 *
 * @author feng.sun
 * @version $Id: BaseController.java, v 0.1 2017-1-10 下午2:05:26 feng.sun Exp $
 */
@Controller
public class BaseController implements ServletContextAware, HTTPConstants {

    private Logger logger = Logger.getLogger(BaseController.class);

    protected ServletContext servletContext;
    protected VelocityEngine velocityEngine;


//    @ExceptionHandler
//    @ResponseBody
//    public Object Exceptionhandlder(HttpServletRequest request, HttpServletResponse response, Exception ex) {
//        logger.error("客户端请求处理发生异常,异常信息:" + ex);
//        if (isAjaxRequest(request)) {
//            return handleAjaxRequest(ex);
//        } else {
//            return handleNotAjaxRequest(ex);
//        }
//    }

    /**
     * 处理非Ajax请求,返回统一的异常处理类
     *
     * @param ex
     * @return
     */
    private BaseResult handleAjaxRequest(Exception ex) {
        if (ex instanceof ITSRuntimeException) {
            return new BaseResult(false, ex.getMessage());
        } else if (ex instanceof ITSException) {
            return new BaseResult(false, ex.getMessage());
        }
        return new BaseResult(false, "系统发生异常,请联系系统管理员!");
    }

    /**
     * 处理Ajax请求
     *
     * @param ex
     * @return
     */
    private ModelAndView handleNotAjaxRequest(Exception ex) {
        return new ModelAndView("500"); // 返回500错误页面
    }

    /**
     * 判断是否Ajax请求.
     * 可以看到Ajax请求多了个 x-requested-with
     * request.getHeader("x-requested-with"); 为 null，则为传统同步请求，为 XMLHttpRequest，则为Ajax 异步请求。
     *
     * @param request HttpServletRequest
     * @return 是否Ajax请求.
     */
    private boolean isAjaxRequest(HttpServletRequest request) {
        String xr = request.getHeader(X_REQUESTED_WIDTH);
        return (xr != null && XML_HTTP_REQUEST.equalsIgnoreCase(xr));
    }


    /**
     * @see ServletContextAware#setServletContext(ServletContext)
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * Getter method for property <tt>servletContext</tt>.
     *
     * @return property value of servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * Setter method for property <tt>velocityEngine</tt>.
     *
     * @param velocityEngine value to be assigned to property velocityEngine
     */
    @Autowired
    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    /**
     * 利用反射遍历类 将所有null 设为“暂无信息”
     *
     * @param model
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static void reflectTackNull(Object model) throws NoSuchMethodException,
            IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        // 获取实体类的所有属性，返回Field数组
        Field[] field = model.getClass().getDeclaredFields();
        // 遍历所有属性
        for (int j = 0; j < field.length; j++) {
            // 获取属性的名字
            String name = field[j].getName();
            // 将属性的首字符大写，方便构造get，set方法
            name = name.substring(0, 1).toUpperCase() + name.substring(1);

            model.getClass().getMethods();
            // 获取属性的类型
            String type = field[j].getGenericType().toString();
            // 如果type是类类型，则前面包含"class "，后面跟类名
            if (type.equals("class java.lang.String")) {
                Method m = model.getClass().getMethod("get" + name);
                // 调用getter方法获取属性值
                String value = (String) m.invoke(model);

                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, String.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = model.getClass().getMethod("get" + name);
                Integer value = (Integer) m.invoke(model);
                System.out.println("数据类型为：Integer");
                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, Integer.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
            if (type.equals("class java.lang.Short")) {
                Method m = model.getClass().getMethod("get" + name);
                Short value = (Short) m.invoke(model);
                System.out.println("数据类型为：Short");
                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, Short.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
            if (type.equals("class java.lang.Double")) {
                Method m = model.getClass().getMethod("get" + name);
                Double value = (Double) m.invoke(model);
                System.out.println("数据类型为：Double");
                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, Double.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = model.getClass().getMethod("get" + name);
                Boolean value = (Boolean) m.invoke(model);
                System.out.println("数据类型为：Boolean");
                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, Boolean.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
            if (type.equals("class java.util.Date")) {
                Method m = model.getClass().getMethod("get" + name);
                Date value = (Date) m.invoke(model);
                System.out.println("数据类型为：Date");
                if (value == null) {
                    Method setReadOnly = model.getClass().getMethod("set" + name, Date.class);
                    String replace = "暂无信息";
                    setReadOnly.invoke(model, replace);
                }
            }
        }
    }
}
/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.result;

import webapp.common.constants.ITSExceptionConstants;

/**
 * 操作结果返回标识
 * <p>
 * <p>使用到此返回类的一般都是更新数据的服务，此类服务拥有参数强校检等需求，所以需要
 * 有返回标识来标识各种错误 </p>
 *
 * @author feng.sun
 * @version $Id: BaseResult.java, v 0.1 2017-1-13 下午3:19:06 feng.sun Exp $
 */
public class BaseResult {

    private boolean success; // 处理是否成功
    private String message;

    /**
     * @param success
     * @param message
     */
    public BaseResult(boolean success, String message) {
        super();
        this.success = success;
        this.message = message;
    }

    /**
     * 构造一个默认的操作成功结果类
     *
     * @return
     */
    public static BaseResult createSuccessResult() {
        return new BaseResult(true, "处理成功");
    }

    /*  构造一个默认的失败结果类 */

    public static BaseResult creatErrorResult(String msg) {
        return new BaseResult(false, msg);
    }

    public static BaseResult createSystemErrorResult() {
        return creatErrorResult(ITSExceptionConstants.ERROR_SYSTEM);
    }

    /**
     * Getter method for property <tt>success</tt>.
     *
     * @return property value of success
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter method for property <tt>success</tt>.
     *
     * @param success value to be assigned to property success
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter method for property <tt>message</tt>.
     *
     * @return property value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter method for property <tt>message</tt>.
     *
     * @param message value to be assigned to property message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}

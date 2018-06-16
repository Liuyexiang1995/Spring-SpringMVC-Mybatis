/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.result;

import org.apache.commons.beanutils.BeanUtils;
import org.codehaus.jackson.map.ObjectMapper;

import webapp.common.exception.ITSRuntimeException;
import webapp.model.PageModel;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回结果封装类
 *
 * @author feng.sun
 * @version $Id: PageResult.java, v 0.1 2017-1-11 下午1:06:33 feng.sun Exp $
 */
public class PageResult {

    private int total;  //总页数
    private int records; //查询出的记录数
    private int page;   //当前页

    private List<PageResultRow> rows;   //包含实际数据的数组

    /**
     * 根据PageModel创建PageResult
     *
     * @param pageModel
     * @param fieldNames
     * @return
     */
    public static PageResult createPageResult(PageModel<?> pageModel, String[] fieldNames) {

        PageResult pageResult = new PageResult();

        pageResult.setPage(pageModel.getPageIndex());
        pageResult.setRecords(pageModel.getTotalRecords());
        pageResult.setTotal(pageModel.getTotalPages());

        List<PageResultRow> rows = new ArrayList<PageResultRow>();

        if (pageModel.getResult() != null) {
            for (Object object : pageModel.getResult()) {
                PageResultRow row = new PageResultRow();
                List<Object> objects = new ArrayList<Object>();
                try {
                    for (String fieldName : fieldNames) {

                        PropertyDescriptor pd = new PropertyDescriptor(fieldName, object.getClass());
                        Method getMethod = pd.getReadMethod();
                        Object fieldValue = getMethod.invoke(object);

                        // 判断一下是否是枚举
                        if (fieldValue instanceof Enum) {
                            // 如果是枚举重置
                            fieldValue = BeanUtils.getProperty(fieldValue, "value");
                        }
                        if (fieldName.equals("id")) {
                            row.setId(fieldValue);
                        }
                        objects.add(fieldValue);
                    }
                } catch (Exception e) {
                    throw new ITSRuntimeException("对象转换PageResult失败:" + object.getClass());
                }
                row.setCell(objects);
                rows.add(row);
            }
        }
        pageResult.setRows(rows);
        return pageResult;
    }

    /**
     * 转换为Json
     *
     * @return
     * @throws IOException
     */
    public String toJsonString() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    /**
     * Getter method for property <tt>rows</tt>.
     *
     * @return property value of rows
     */
    public List<PageResultRow> getRows() {
        return rows;
    }

    /**
     * Setter method for property <tt>rows</tt>.
     *
     * @param rows value to be assigned to property rows
     */
    public void setRows(List<PageResultRow> rows) {
        this.rows = rows;
    }

    /**
     * Getter method for property <tt>total</tt>.
     *
     * @return property value of total
     */
    public int getTotal() {
        return total;
    }

    /**
     * Setter method for property <tt>total</tt>.
     *
     * @param total value to be assigned to property total
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * Getter method for property <tt>records</tt>.
     *
     * @return property value of records
     */
    public int getRecords() {
        return records;
    }

    /**
     * Setter method for property <tt>records</tt>.
     *
     * @param records value to be assigned to property records
     */
    public void setRecords(int records) {
        this.records = records;
    }

    /**
     * Getter method for property <tt>page</tt>.
     *
     * @return property value of page
     */
    public int getPage() {
        return page;
    }

    /**
     * Setter method for property <tt>page</tt>.
     *
     * @param page value to be assigned to property page
     */
    public void setPage(int page) {
        this.page = page;
    }

}

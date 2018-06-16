/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.model;

import com.easytec.mybatis.plugins.Page;

import java.util.List;

/**
 * 分页模型
 *
 * @author feng.sun
 * @version $Id: PageBean.java, v 0.1 2017-1-10 下午3:47:13 feng.sun Exp $
 */
public class PageModel<T> extends BaseModel {

    /**  */
    private static final long serialVersionUID = 7198797665428854759L;

    private static final int DEFAULT_PAGE_SIZE = 10;       //默认大小
    private static final int DEFAULT_MAX_PAGE_SIZE = 50;        //最大值

    private int totalRecords = 0;        //查询记录数
    private int totalPages = 0;        //总页数

    private int pageIndex = 0;        //第几页
    private int pageSize = 20;        //每页多少条数据

    private List<T> result;

    /**
     * 默认构造函数
     */
    public PageModel() {
        super();
    }

    /**
     * 默认构造函数
     *
     * @param pageIndex
     * @param pageSize
     */
    public PageModel(int pageIndex, int pageSize) {

        if (pageIndex <= 0) {
            this.pageIndex = 0;
        } else {
            this.pageIndex = pageIndex;
        }

        if (pageSize <= 0 || pageSize > DEFAULT_MAX_PAGE_SIZE) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * 生成MyBaties使用的Page对象
     *
     * @return
     */
    public Page createPage() {
        return new Page(getStartDBRow(), getPageSize());
    }

    /**
     * 获得起始数据行数
     *
     * @return
     */
    public int getStartDBRow() {
        return (pageIndex - 1) * pageSize;
    }

    /**
     * Getter method for property <tt>totalRecords</tt>.
     *
     * @return property value of totalRecords
     */
    public int getTotalRecords() {
        return totalRecords;
    }

    /**
     * Setter method for property <tt>totalRecords</tt>.
     *
     * @param totalRecords value to be assigned to property totalRecords
     */
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;

        if (totalRecords == 0) {
            this.pageIndex = 0;
            this.totalPages = 0;
        } else {
            if (this.totalRecords % this.pageSize == 0) {
                this.totalPages = this.totalRecords / this.pageSize;
            } else {
                this.totalPages = (this.totalRecords / this.pageSize) + 1;
            }
        }
    }

    /**
     * Getter method for property <tt>totalPages</tt>.
     *
     * @return property value of totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * Getter method for property <tt>pageIndex</tt>.
     *
     * @return property value of pageIndex
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * Setter method for property <tt>pageIndex</tt>.
     *
     * @param pageIndex value to be assigned to property pageIndex
     */
    public void setPageIndex(int pageIndex) {
        if (this.pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }
    }

    /**
     * Getter method for property <tt>pageSize</tt>.
     *
     * @return property value of pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Setter method for property <tt>pageSize</tt>.
     *
     * @param pageSize value to be assigned to property pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Getter method for property <tt>result</tt>.
     *
     * @return property value of result
     */
    public List<T> getResult() {
        return result;
    }

    /**
     * Setter method for property <tt>result</tt>.
     *
     * @param result value to be assigned to property result
     */
    public void setResult(List<T> result) {
        this.result = result;
    }

}

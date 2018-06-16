/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.result;

import java.util.List;

/**
 *  代表一行
 * 
 * @author feng.sun
 * @version $Id: PageResultRow.java, v 0.1 2017-1-11 下午1:12:31 feng.sun Exp $
 */
public class PageResultRow {

    private Object       id;  //行id
    private List<Object> cell; //当前行的所有单元格

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public Object getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(Object id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>cell</tt>.
     * 
     * @return property value of cell
     */
    public List<Object> getCell() {
        return cell;
    }

    /**
     * Setter method for property <tt>cell</tt>.
     * 
     * @param cell value to be assigned to property cell
     */
    public void setCell(List<Object> cell) {
        this.cell = cell;
    }

}

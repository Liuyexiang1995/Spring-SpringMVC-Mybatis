/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2016 All Rights Reserved.
 */
package webapp.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 
 *  基本的数据模型，从BPM的BaseDataObject中抽离出来，因为在EazyWork里, DO层不再起到Model的作用了。
 * 
 * @author feng.sun
 * @version $Id: BaseModel.java, v 0.1 2016-12-19 下午1:48:46 feng.sun Exp $
 */
public abstract class BaseModel implements Serializable {

    /**  */
    private static final long serialVersionUID = -5916434928736342770L;

    /**
     * Returns a multi-line String with key=value pairs.
     * @return a String representation of this class.
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).toString();
    }

}

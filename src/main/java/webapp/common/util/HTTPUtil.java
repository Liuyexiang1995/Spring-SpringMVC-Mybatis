/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * HTTP工具类
 *
 * @author feng.sun
 * @version $Id: HTTPUtil.java, v 0.1 2017-1-11 上午10:13:30 feng.sun Exp $
 */
public class HTTPUtil {

    /**
     * 创建默认的请求路径
     *
     * @param url
     * @return
     */
    public static String createHttpRequestUrl(String url) {
        return "/request/" + url;
    }

}

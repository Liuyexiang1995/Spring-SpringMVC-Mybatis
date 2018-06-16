/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 提供标准的日期格式
 * <p>
 * 如果是分布式的系统建议获取数据库的时间, 这个工具方法可能有问题
 *
 * @author feng.sun
 * @version $Id: DateUtil.java, v 0.1 2017-2-28 下午3:05:12 feng.sun Exp $
 */
public class DateUtil {

    public static final String SHORT_SIMPLE_DATE_PATTERN = "yyyy/MM/dd";

    public static final String FULL_SIMPLE_DATE_PATTERN = "yyyy/MM/dd HH:mm:ss";

    public static final String ID_SIMPLE_DATE_PATTERN = "yyyyMMdd";

    /**
     * 相差多少小时X.X
     *
     * @param endTime
     * @param startTime
     * @return
     */
    public static String diffDate(Date endTime, Date startTime) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;

        long diff = endTime.getTime() - startTime.getTime();
        long hour = diff % nd / nh;
        long min = diff % nd % nh / nm;

        return hour + "." + min * 10 / 60;
    }


    public static Date getDateByString(String string, String pattern) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成统一的当前时间yyyy-MM-dd格式
     *
     * @return
     */
    public static String getCurrentDateShort() {
        return getCurrentDateString(SHORT_SIMPLE_DATE_PATTERN);
    }

    /**
     * 一般给生成ID用
     * @return
     */
    public static String getCurrentDateForID() {
        return getCurrentDateString(ID_SIMPLE_DATE_PATTERN);
    }

    /**
     * 当前日期转换的通用方法
     *
     * @param pattern
     * @return
     */
    public static String getCurrentDateString(String pattern) {
        return getDateString(new Date(), pattern);
    }

    /**
     * 日期转换通用方法
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateString(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(date);
        return dateString;
    }


    /**
     * 任务专用的日期格式,精确到时分秒
     *
     * @return
     */
    public static String getCurrentDateFull() {
        return getCurrentDateString(FULL_SIMPLE_DATE_PATTERN);
    }


    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getCurrentYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;
    }

}

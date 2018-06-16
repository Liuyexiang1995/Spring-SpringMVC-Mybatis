/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.util;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  jqgrid工具方法
 *
 * @author feng.sun
 * @version $Id: JQGridUtil.java, v 0.1 2017-1-11 上午9:05:28 feng.sun Exp $
 */
public class JQGridUtil {

    public final static String DEFAULT_GRID_ENCODED     = "UTF-8";

    public final static String CONTEXT_TITLE            = "title";
    public final static String CONTEXT_GRID_ID          = "gridId";
    public final static String CONTEXT_NEED_CB          = "needCheckbox";
    public final static String CONTEXT_REURL            = "reurl";
    public final static String CONTEXT_COLUMN_NAMES     = "columnNames";
    public final static String CONTEXT_RECORD_NUM       = "noOfRecords";
    public final static String CONTEXT_LINK             = "link";
    public final static String CONTEXT_FIELDNAME_LIST   = "fieldNameList";
    public final static String CONTEXT_HEIGHT           = "height";

    public final static String DEFAULT_RECORD_NUM       = "10";

    public final static String FIELD_NAME_INDEX         = "index";
    public final static String FIELD_NAME_WIDTH         = "width";
    public final static String FIELD_NAME_TEXTALIGN     = "textAlign";
    public final static String FIELD_NAME_ONRENDEREVENT = "onRenderEvent";
    public final static String FIELD_NAME_IS_HIDDEN     = "isHidden";

    public final static String TEXT_ALIGN_CENTER        = "center";
    public final static String TEXT_ALIGN_LEFT          = "left";
    public final static String TEXT_ALIGN_RIGHT         = "right";

    /**
     * Create grid column attributes
     *
     * @param fieldNameList
     * @param index
     * @param width
     * @param textAlign
     * @param isHidden
     */
    public static void createFieldNameList(List<Map<String, Object>> fieldNameList, String index, String width, String textAlign, String onRenderEvent, String isHidden) {
        Map<String, Object> fieldNameMap = new HashMap<String, Object>();
        fieldNameMap.put(FIELD_NAME_INDEX, index);
        fieldNameMap.put(FIELD_NAME_WIDTH, width);
        fieldNameMap.put(FIELD_NAME_TEXTALIGN, textAlign);
        fieldNameMap.put(FIELD_NAME_ONRENDEREVENT, onRenderEvent);
        fieldNameMap.put(FIELD_NAME_IS_HIDDEN, isHidden);
        fieldNameList.add(fieldNameMap);
    }

    /**
     *  创建没有RenderEvent的Field
     *
     * @param fieldNameList
     * @param index
     * @param width
     * @param textAlign
     * @param isHidden
     */
    public static void createFieldNameListNonEvent(List<Map<String, Object>> fieldNameList, String index, String width, String textAlign, String isHidden) {
        createFieldNameList(fieldNameList, index, width, textAlign, "", isHidden);
    }

    /**
     *  动态创建Grid脚本
     *
     * @param velocityEngine
     * @param context
     * @return
     */
    public static String generateScriptDy(VelocityEngine velocityEngine, Map<String, Object> context) {
        if (null == context.get(CONTEXT_RECORD_NUM)) {
            context.put(CONTEXT_RECORD_NUM, DEFAULT_RECORD_NUM);
        }
        if (null == context.get(CONTEXT_LINK)) {
            context.put(CONTEXT_LINK, "");
        }
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/GridTemplatePager.vm", DEFAULT_GRID_ENCODED, context);
    }
}

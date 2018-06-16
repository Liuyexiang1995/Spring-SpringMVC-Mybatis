/**
 * eazytec.com Inc.
 * Copyright (c) 2009-2017 All Rights Reserved.
 */
package webapp.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jstree 框架工具类方法
 *
 * @author feng.sun
 * @version $Id: JSTreeUtil.java, v 0.1 2017-1-12 下午6:29:50 feng.sun Exp $
 */
public class JSTreeUtil {

    public final static String DEFAULT_TREE_ENCODED = "UTF-8";

    public final static String CONTEXT_TREE_ID = "treeId";

    /**
     * 以为JSTree的URL是拼接而成的,所以统一在末尾?, 如果有参数也需要 XXXXXXXX?a=a& , 末尾加&
     */
    public final static String CONTEXT_LOAD_URL = "loadUrl";
    public final static String CONTEXT_HAS_CHILD = "hasChild";
    public final static String CONTEXT_MULTIPLE = "multiple";
    public final static String CONTEXT_CHECKBOX = "checkbox";


    public static String FA_USER_ICON = "fa fa-user";
    public static String FA_PROJECT_ICON = "fa fa-pie-chart";
    public static String FA_GOVERNMENT_FILE_ICON = "fa fa-file-o";
    /**
     * 动态创建Grid脚本
     *
     * @param velocityEngine
     * @param context
     * @return
     */
    public static String generateScriptDy(VelocityEngine velocityEngine, Map<String, Object> context) {

        if (!context.containsKey(CONTEXT_HAS_CHILD)) {
            context.put(CONTEXT_HAS_CHILD, true);
        }

        if (!context.containsKey(CONTEXT_MULTIPLE)) {
            context.put(CONTEXT_MULTIPLE, false);
        }
        if (!context.containsKey(CONTEXT_CHECKBOX)) {
            context.put(CONTEXT_CHECKBOX, false);
        }

        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "META-INF/velocity/TreeTemplatePager.vm", DEFAULT_TREE_ENCODED, context);
    }

    /**
     * 新增nocheckbox属性
     *
     * @param attr
     * @return
     */
    public static Map<String, Object> createNoCheckBoxAttr(Map<String, Object> attr) {
        attr.put("class", "no_checkbox");
        return attr;
    }

    /**
     * 创建树节点模型
     *
     * @param nodeList
     * @param name
     * @param id
     * @param partent
     * @return
     */
    public static void createTreeNode(List<Map<String, Object>> nodeList, Map<String, Object> aattr, String icon, String name, String id, String partent, boolean opened, boolean disabled, boolean selected, boolean chidren) {
        Map<String, Object> attr = new HashMap<String, Object>();

        attr.put("id", id);
        attr.put("text", name);

        if (StringUtils.isNotBlank(icon)) {
            attr.put("icon", icon);
        }

        if (StringUtils.isBlank(partent)) {
            attr.put("parent", "#");
        } else {
            attr.put("parent", partent);
        }

        Map<String, Object> stateattr = new HashMap<String, Object>();
        stateattr.put("opened", opened);
        stateattr.put("disabled", disabled);
        stateattr.put("selected", selected);
        attr.put("state", stateattr);

        attr.put("children", chidren);

        if (attr != null) {
            attr.put("a_attr", aattr);
        }
        nodeList.add(attr);
    }

    /**
     * 默认不选中的增值方法
     *
     * @param nodeList
     * @param name
     * @param id
     * @param partent
     */
    public static void createTreeNode(List<Map<String, Object>> nodeList, String icon, String name, String id, String partent) {
        createTreeNode(nodeList, null, icon, name, id, partent, false, false, false, true);
    }

    /**
     * 默认不选中的增值方法
     *
     * @param nodeList
     * @param name
     * @param id
     * @param partent
     */
    public static void createTreeNode(List<Map<String, Object>> nodeList, Map<String, Object> aattr, String icon, String name, String id, String partent) {
        createTreeNode(nodeList, aattr, icon, name, id, partent, false, false, false, true);
    }

    /**
     * 默认不选中的增值方法
     *
     * @param nodeList
     * @param name
     * @param id
     * @param partent
     */
    public static void createTreeNode(List<Map<String, Object>> nodeList, String icon, String name, String id, Long partent) {
        if (partent == null) {
            createTreeNode(nodeList, null, icon, name, id, null, false, false, false, true);
        } else {
            createTreeNode(nodeList, null, icon, name, id, partent.toString(), false, false, false, true);
        }
    }
}

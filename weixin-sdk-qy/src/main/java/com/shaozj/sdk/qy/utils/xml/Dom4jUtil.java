package com.shaozj.sdk.qy.utils.xml;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * <p>
 * ClassName: Dom4jUtil
 * </p>
 * <p>
 * Description: Xml解析工具类
 * </p>
 * <p>
 * Author: szj
 * </p>
 * <p>
 * Date: 2018年9月21日
 * </p>
 */
public class Dom4jUtil {
    
    /**
     * <p>
     * Description: 获取某个节点内容
     * </p>
     * 
     * @param xml
     * @param element
     * @return
     */
    public static String getElementText(String xml, String element) {
        try {
            Document doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String text = rootElt.elementText(element);
            if (!StringUtils.isEmpty(text)) {
                return text;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}

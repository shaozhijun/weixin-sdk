package com.shaozj.sdk.qy.utils.xml;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

/**
 * 
 * 文件描述: xml操作工具类，对常用对象进行对应的xstream进行缓存<br>
 * 版权所有: Copyright (c) 2019年5月22日 YAPPAM, LTD.CO<br>
 * 完成日期: 2019年5月22日 下午3:37:20<br>
 *
 * @author szj
 * @since 1.1.0
 *
 */
public class XStreamTransformer {

    private static final Map<Class<?>, XStream> XSTREAM_INSTANCE = new HashMap<>();

    static {
        /*
         * registerClass(TextXmlMessage.class);
         * registerClass(NewsXmlMessage.class);
         * registerClass(EventScanXmlMessage.class);
         * registerClass(EventSubscribeXmlMessage.class);
         * registerClass(EventUnSubscribeXmlMessage.class);
         * registerClass(TextResponse.class);
         * registerClass(VoiceXmlMessage.class);
         */
    }

    /**
     * 
     * 方法描述: xml转换对象 <br>
     * 完成时间: 2019年5月22日 下午3:36:31<br>
     * 作者: szj<br>
     *
     * @param xml
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToBean(String xml, Class<T> clazz) {
        T object = (T) XSTREAM_INSTANCE.get(clazz).fromXML(xml);
        return object;
    }

    /**
     * 
     * 方法描述: 对象转换xml<br>
     * 完成时间: 2019年5月22日 下午3:37:03<br>
     * 作者: xml<br>
     *
     * @param clazz
     * @param object
     * @return
     */
    public static <T> String beanToXml(Class<T> clazz, T object) {
        return XSTREAM_INSTANCE.get(clazz).toXML(object);
    }

    /**
     * 注册扩展消息的解析器, 避免 后期使用不必要的新建Xstream对象
     *
     * @param clz 类型
     * @param xStream xml解析器
     */
    public static void register(Class<?> clz, XStream xStream) {
        XSTREAM_INSTANCE.put(clz, xStream);
    }

    /**
     * 会自动注册该类及其子类
     * 
     * @param clz 要注册的类
     */
    public static void registerClass(Class<?> clz) {
        XStream xstream = getXStream();
        xstream.processAnnotations(clz);
        xstream.processAnnotations(getInnerClasses(clz));
        register(clz, xstream);
    }

    /**
     * 方法描述: xstream扩展,bean转xml自动加上![CDATA[]]<br>
     * 完成时间: 2019年5月22日 下午3:31:34<br>
     * 作者: szj<br>
     *
     * @return
     */
    public static XStream getXStream() {
        XStream xstream = new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, getNameCoder()) {
                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (text.startsWith("<![CDATA[") && text.endsWith("]]>")) {
                            writer.write(text);
                        } else {
                            super.writeText(writer, text);
                        }
                    }
                };
            }
        });
        xstream.ignoreUnknownElements();
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(NullPermission.NULL);
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
        return xstream;
    }

    private static Class<?>[] getInnerClasses(Class<?> clz) {
        Class<?>[] innerClasses = clz.getClasses();
        if (innerClasses == null) {
            return null;
        }
        List<Class<?>> result = new ArrayList<>();
        result.addAll(Arrays.asList(innerClasses));
        for (Class<?> inner : innerClasses) {
            Class<?>[] innerClz = getInnerClasses(inner);
            if (innerClz == null) {
                continue;
            }
            result.addAll(Arrays.asList(innerClz));
        }
        return result.toArray(new Class<?>[0]);
    }
}

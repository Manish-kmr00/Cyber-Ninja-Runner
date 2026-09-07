package net.pubnative.lite.sdk.vpaid.xml;

import android.text.TextUtils;
import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes11.dex */
public class XmlParser {
    public static <T> T parse(String str, Class<T> cls) throws Exception {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        return (T) parseTag(xmlPullParserNewPullParser, cls);
    }

    private static <T> T parseTag(XmlPullParser xmlPullParser, Class<T> cls) throws Exception {
        T tNewInstance = cls.newInstance();
        parseAttributes(xmlPullParser, tNewInstance);
        xmlPullParser.next();
        parseElements(xmlPullParser, tNewInstance);
        xmlPullParser.next();
        return tNewInstance;
    }

    private static <T> void parseAttributes(XmlPullParser xmlPullParser, T t) throws IllegalAccessException {
        for (Field field : t.getClass().getDeclaredFields()) {
            Attribute attribute = (Attribute) getAnnotation(field, Attribute.class);
            if (attribute != null) {
                String strValue = attribute.value();
                if (TextUtils.isEmpty(strValue)) {
                    strValue = field.getName();
                }
                String attributeValue = xmlPullParser.getAttributeValue(null, strValue);
                if (!TextUtils.isEmpty(attributeValue)) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    if (type.equals(String.class)) {
                        field.set(t, attributeValue);
                    } else if (Long.class.equals(type) || Long.TYPE.equals(type)) {
                        field.setLong(t, Long.parseLong(attributeValue));
                    } else if (Integer.class.equals(type) || Integer.TYPE.equals(type)) {
                        field.setInt(t, Integer.parseInt(attributeValue));
                    } else if (Byte.class.equals(type) || Byte.TYPE.equals(type)) {
                        field.setByte(t, Byte.parseByte(attributeValue));
                    } else if (Double.class.equals(type) || Double.TYPE.equals(type)) {
                        field.setDouble(t, Double.parseDouble(attributeValue));
                    } else if (Float.class.equals(type) || Float.TYPE.equals(type)) {
                        field.setFloat(t, Float.parseFloat(attributeValue));
                    } else if (Boolean.class.equals(type) || Boolean.TYPE.equals(type)) {
                        field.setBoolean(t, Boolean.parseBoolean(attributeValue));
                    }
                }
            }
        }
    }

    private static <T> void parseElements(XmlPullParser xmlPullParser, T t) throws Exception {
        while (true) {
            if (xmlPullParser.getEventType() != 2 && xmlPullParser.getEventType() != 4) {
                return;
            }
            if (xmlPullParser.getEventType() == 4) {
                parseText(xmlPullParser, t);
            } else {
                parseSubTag(xmlPullParser, t);
            }
        }
    }

    private static <T> void parseText(XmlPullParser xmlPullParser, T t) throws Exception {
        if (xmlPullParser.getEventType() != 4) {
            return;
        }
        Field fieldForText = getFieldForText(t);
        if (fieldForText != null) {
            fieldForText.setAccessible(true);
            fieldForText.set(t, xmlPullParser.getText());
        }
        xmlPullParser.next();
    }

    private static <T> void parseSubTag(XmlPullParser xmlPullParser, T t) throws Exception {
        String name = xmlPullParser.getName();
        int depth = xmlPullParser.getDepth();
        Field fieldForTag = getFieldForTag(t, name);
        if (fieldForTag == null) {
            skipTag(xmlPullParser, name, depth);
            return;
        }
        if (List.class.isAssignableFrom(fieldForTag.getType())) {
            Object tag = parseTag(xmlPullParser, (Class) ((ParameterizedType) fieldForTag.getGenericType()).getActualTypeArguments()[0]);
            fieldForTag.setAccessible(true);
            List arrayList = (List) fieldForTag.get(t);
            if (arrayList == null) {
                arrayList = new ArrayList();
                fieldForTag.set(t, arrayList);
            }
            arrayList.add(tag);
            return;
        }
        Object tag2 = parseTag(xmlPullParser, fieldForTag.getType());
        fieldForTag.setAccessible(true);
        fieldForTag.set(t, tag2);
    }

    private static <T> Field getFieldForTag(T t, String str) {
        for (Field field : t.getClass().getDeclaredFields()) {
            Tag tag = (Tag) getAnnotation(field, Tag.class);
            if (tag != null) {
                String strValue = tag.value();
                if (TextUtils.isEmpty(strValue)) {
                    strValue = field.getName();
                }
                if (strValue.equalsIgnoreCase(str)) {
                    return field;
                }
            }
        }
        return null;
    }

    private static <T> Field getFieldForText(T t) {
        for (Field field : t.getClass().getDeclaredFields()) {
            if (((Text) getAnnotation(field, Text.class)) != null) {
                return field;
            }
        }
        return null;
    }

    private static void skipTag(XmlPullParser xmlPullParser, String str, int i) throws Exception {
        while (true) {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 3 && xmlPullParser.getName().equalsIgnoreCase(str) && xmlPullParser.getDepth() == i) {
                xmlPullParser.next();
                return;
            }
        }
    }

    private static <T extends Annotation> T getAnnotation(AnnotatedElement annotatedElement, Class<? extends Annotation> cls) {
        for (Annotation annotation : annotatedElement.getDeclaredAnnotations()) {
            T t = (T) annotation;
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }
}

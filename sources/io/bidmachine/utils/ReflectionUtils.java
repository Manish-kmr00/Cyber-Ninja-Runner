package io.bidmachine.utils;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes10.dex */
public class ReflectionUtils {
    public static Object findValueByPath(Object obj, String[] strArr) {
        if (strArr.length == 0) {
            return null;
        }
        for (String str : strArr) {
            obj = findValue(obj, str);
            if (obj == null) {
                return null;
            }
        }
        return obj;
    }

    public static Object findValue(Object obj, String str) {
        return findValue(obj.getClass(), str, obj);
    }

    public static Object findValue(Class<?> cls, String str, Object obj) {
        try {
            return getValue(cls, str, obj);
        } catch (Throwable unused) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return findValue(superclass, str, obj);
        }
    }

    public static Object getValue(Class<?> cls, String str, Object obj) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}

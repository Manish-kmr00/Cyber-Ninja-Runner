package com.apm.insight.h;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: JavaCalls.java */
/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f212a;

    /* JADX INFO: renamed from: com.apm.insight.h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JavaCalls.java */
    public static class C0121a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f213a;
        public final T b;
    }

    static {
        HashMap map = new HashMap();
        f212a = map;
        map.put(Boolean.class, Boolean.TYPE);
        map.put(Byte.class, Byte.TYPE);
        map.put(Character.class, Character.TYPE);
        map.put(Short.class, Short.TYPE);
        map.put(Integer.class, Integer.TYPE);
        map.put(Float.class, Float.TYPE);
        map.put(Long.class, Long.TYPE);
        map.put(Double.class, Double.TYPE);
        Class cls = Boolean.TYPE;
        map.put(cls, cls);
        Class cls2 = Byte.TYPE;
        map.put(cls2, cls2);
        Class cls3 = Character.TYPE;
        map.put(cls3, cls3);
        Class cls4 = Short.TYPE;
        map.put(cls4, cls4);
        Class cls5 = Integer.TYPE;
        map.put(cls5, cls5);
        Class cls6 = Float.TYPE;
        map.put(cls6, cls6);
        Class cls7 = Long.TYPE;
        map.put(cls7, cls7);
        Class cls8 = Double.TYPE;
        map.put(cls8, cls8);
    }

    public static <T> T a(String str, String str2, Object... objArr) {
        Method method;
        Class<?>[] parameterTypes;
        Class<?> cls;
        try {
            Class<?> cls2 = Class.forName(str);
            Class<?>[] clsArr = new Class[4];
            for (int i = 0; i < 4; i++) {
                Object obj = objArr[i];
                if (obj != null && (obj instanceof C0121a)) {
                    cls = ((C0121a) obj).f213a;
                } else {
                    cls = obj == null ? null : obj.getClass();
                }
                clsArr[i] = cls;
            }
            while (true) {
                Method[] declaredMethods = cls2.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        method = null;
                        break;
                    }
                    method = declaredMethods[i2];
                    if (method.getName().equals(str2) && (parameterTypes = method.getParameterTypes()) != null && parameterTypes.length == 4) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= parameterTypes.length) {
                                break;
                            }
                            if (!parameterTypes[i3].isAssignableFrom(clsArr[i3])) {
                                Map<Class<?>, Class<?>> map = f212a;
                                if (!map.containsKey(parameterTypes[i3]) || !map.get(parameterTypes[i3]).equals(map.get(clsArr[i3]))) {
                                    break;
                                    break;
                                }
                            }
                            i3++;
                        }
                    }
                    i2++;
                }
                if (method == null) {
                    if (cls2.getSuperclass() != null) {
                        cls2 = cls2.getSuperclass();
                    } else {
                        throw new NoSuchMethodException();
                    }
                } else {
                    method.setAccessible(true);
                    Object[] objArr2 = new Object[4];
                    for (int i4 = 0; i4 < 4; i4++) {
                        Object obj2 = objArr[i4];
                        if (obj2 != null && (obj2 instanceof C0121a)) {
                            objArr2[i4] = ((C0121a) obj2).b;
                        } else {
                            objArr2[i4] = obj2;
                        }
                    }
                    return (T) method.invoke(null, objArr2);
                }
            }
        } catch (Exception e) {
            Log.w("JavaCalls", "Meet exception when call Method '" + str2 + "' in " + str, e);
            return null;
        }
    }
}

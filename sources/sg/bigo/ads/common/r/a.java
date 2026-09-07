package sg.bigo.ads.common.r;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import sg.bigo.ads.common.utils.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static Object a(Object obj, String str) {
        Field field;
        try {
            try {
                field = obj.getClass().getDeclaredField(str);
            } catch (Exception unused) {
                field = obj.getClass().getField(str);
            }
            field.setAccessible(true);
            return field.get(obj);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            sg.bigo.ads.common.t.a.a(0, "ReflectionHelper", Log.getStackTraceString(e));
            return null;
        }
    }

    public static Object a(Object obj, String str, Class cls) {
        boolean z;
        if (obj == null) {
            return null;
        }
        for (Method method : obj.getClass().getMethods()) {
            if (TextUtils.equals(str, method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (!k.a((Object[]) null)) {
                    throw null;
                }
                if ((k.a(parameterTypes) ? 0 : parameterTypes.length) != 0) {
                    z = false;
                    break;
                }
                int i = 0;
                while (true) {
                    if (i >= 0) {
                        z = true;
                        break;
                    }
                    if (!Objects.equals(null, parameterTypes[i])) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    Class<?> returnType = method.getReturnType();
                    if ((a(cls) && a(returnType)) || returnType == cls) {
                        try {
                            method.setAccessible(true);
                            return method.invoke(obj, null);
                        } catch (Exception e) {
                            sg.bigo.ads.common.t.a.a(0, "ReflectionHelper", Log.getStackTraceString(e));
                            return null;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static <T> T a(String str, Class<T> cls) {
        try {
            Constructor declaredConstructor = Class.forName(str).asSubclass(cls).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (T) declaredConstructor.newInstance(new Object[0]);
        } catch (Exception unused) {
            sg.bigo.ads.common.t.a.a(0, 5, "ReflectionHelper", "Cannot find class: ".concat(String.valueOf(str)));
            return null;
        }
    }

    private static boolean a(Class cls) {
        return cls == null || Void.class == cls;
    }

    public static boolean a(Class<?> cls, String... strArr) {
        Class<?> cls2;
        if (k.a(strArr)) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            try {
                cls2 = Class.forName(strArr[i]);
            } catch (Exception unused) {
                cls2 = null;
            }
            if (cls2 != null && cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}

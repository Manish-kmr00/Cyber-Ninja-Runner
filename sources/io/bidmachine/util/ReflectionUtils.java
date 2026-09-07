package io.bidmachine.util;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReflectionUtils.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007JO\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000eJ?\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\u00112\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010\u0010\u001a\u00020\u00112\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007J-\u0010\u0014\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J*\u0010\u0019\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J%\u0010\u001a\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0007¢\u0006\u0002\u0010\u001bJ\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001d\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007J\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J*\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007JO\u0010\u001f\u001a\u0004\u0018\u00010\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u000eJ\u001c\u0010 \u001a\u00020\u00182\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J$\u0010!\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00182\b\u0010\r\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007J&\u0010\"\u001a\u00020\u00112\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0007J2\u0010\"\u001a\u00020\u00112\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006#"}, d2 = {"Lio/bidmachine/util/ReflectionUtils;", "", "()V", "createClassSafely", "Ljava/lang/Class;", "className", "", "findAndInvokeMethod", "clazz", "methodName", "parameterTypes", "", "parameterObjects", "obj", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;", "findAndSetValue", "", "fieldName", "newValue", "findAndSetValueByPath", "path", "(Ljava/lang/Object;[Ljava/lang/String;Ljava/lang/Object;)Z", "findField", "Ljava/lang/reflect/Field;", "findValue", "findValueByPath", "(Ljava/lang/Object;[Ljava/lang/String;)Ljava/lang/Object;", "getSafely", "field", "getValue", "invokeMethod", "peekField", "setSafely", "setValue", "bidmachine-android-util_d_0_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    private ReflectionUtils() {
    }

    @JvmStatic
    public static final Class<?> createClassSafely(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            return Class.forName(className);
        } catch (Throwable unused) {
            return null;
        }
    }

    @JvmStatic
    public static final Object getSafely(Field field, Object obj) {
        Intrinsics.checkNotNullParameter(field, "field");
        return ReflectionUtilsKt.getSafely(field, obj);
    }

    @JvmStatic
    public static final boolean setSafely(Field field, Object obj, Object newValue) {
        Intrinsics.checkNotNullParameter(field, "field");
        return ReflectionUtilsKt.setSafely(field, obj, newValue);
    }

    @JvmStatic
    public static final Field peekField(Class<?> clazz, String fieldName) throws NoSuchFieldException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.peekField(clazz, fieldName);
    }

    @JvmStatic
    public static final Field findField(Class<?> clazz, String fieldName) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findField(clazz, fieldName);
    }

    @JvmStatic
    public static final Field findField(Object obj, String fieldName) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findField(obj, fieldName);
    }

    public static /* synthetic */ Object getValue$default(Class cls, String str, Object obj, int i, Object obj2) throws NoSuchFieldException, SecurityException {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getValue(cls, str, obj);
    }

    @JvmStatic
    public static final Object getValue(Class<?> clazz, String fieldName, Object obj) throws NoSuchFieldException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.getValue(clazz, fieldName, obj);
    }

    @JvmStatic
    public static final Object getValue(Class<?> clazz, String fieldName) throws NoSuchFieldException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.getValue(clazz, fieldName, null);
    }

    public static /* synthetic */ Object findValue$default(Class cls, String str, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return findValue(cls, str, obj);
    }

    @JvmStatic
    public static final Object findValue(Class<?> clazz, String fieldName, Object obj) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findValue(clazz, fieldName, obj);
    }

    @JvmStatic
    public static final Object findValue(Class<?> clazz, String fieldName) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findValue(clazz, fieldName, null);
    }

    @JvmStatic
    public static final Object findValue(Object obj, String fieldName) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findValue(obj, fieldName);
    }

    @JvmStatic
    public static final Object findValueByPath(Object obj, String[] path) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(path, "path");
        return ReflectionUtilsKt.findValueByPath(obj, path);
    }

    public static /* synthetic */ boolean setValue$default(Class cls, String str, Object obj, Object obj2, int i, Object obj3) throws NoSuchFieldException, SecurityException {
        if ((i & 8) != 0) {
            obj2 = null;
        }
        return setValue(cls, str, obj, obj2);
    }

    @JvmStatic
    public static final boolean setValue(Class<?> clazz, String fieldName, Object newValue, Object obj) throws NoSuchFieldException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.setValue(clazz, fieldName, newValue, obj);
    }

    @JvmStatic
    public static final boolean setValue(Class<?> clazz, String fieldName, Object newValue) throws NoSuchFieldException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.setValue(clazz, fieldName, newValue, null);
    }

    public static /* synthetic */ boolean findAndSetValue$default(Class cls, String str, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 8) != 0) {
            obj2 = null;
        }
        return findAndSetValue(cls, str, obj, obj2);
    }

    @JvmStatic
    public static final boolean findAndSetValue(Class<?> clazz, String fieldName, Object newValue, Object obj) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findAndSetValue(clazz, fieldName, newValue, obj);
    }

    @JvmStatic
    public static final boolean findAndSetValue(Class<?> clazz, String fieldName, Object newValue) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findAndSetValue(clazz, fieldName, newValue, null);
    }

    @JvmStatic
    public static final boolean findAndSetValue(Object obj, String fieldName, Object newValue) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtilsKt.findAndSetValue(obj, fieldName, newValue);
    }

    @JvmStatic
    public static final boolean findAndSetValueByPath(Object obj, String[] path, Object newValue) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(path, "path");
        return ReflectionUtilsKt.findAndSetValueByPath(obj, path, newValue);
    }

    public static /* synthetic */ Object invokeMethod$default(Class cls, String str, Class[] clsArr, Object[] objArr, Object obj, int i, Object obj2) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if ((i & 16) != 0) {
            obj = null;
        }
        return invokeMethod(cls, str, clsArr, objArr, obj);
    }

    @JvmStatic
    public static final Object invokeMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] parameterObjects, Object obj) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(parameterObjects, "parameterObjects");
        return ReflectionUtilsKt.invokeMethod(clazz, methodName, parameterTypes, parameterObjects, obj);
    }

    public static /* synthetic */ Object findAndInvokeMethod$default(Class cls, String str, Class[] clsArr, Object[] objArr, Object obj, int i, Object obj2) {
        if ((i & 16) != 0) {
            obj = null;
        }
        return findAndInvokeMethod(cls, str, clsArr, objArr, obj);
    }

    @JvmStatic
    public static final Object findAndInvokeMethod(Class<?> clazz, String methodName, Class<?>[] parameterTypes, Object[] parameterObjects, Object obj) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(parameterObjects, "parameterObjects");
        return ReflectionUtilsKt.findAndInvokeMethod(clazz, methodName, parameterTypes, parameterObjects, obj);
    }

    @JvmStatic
    public static final Object findAndInvokeMethod(Object obj, String methodName, Class<?>[] parameterTypes, Object[] parameterObjects) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(parameterTypes, "parameterTypes");
        Intrinsics.checkNotNullParameter(parameterObjects, "parameterObjects");
        return ReflectionUtilsKt.findAndInvokeMethod(obj, methodName, parameterTypes, parameterObjects);
    }
}

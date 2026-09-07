package com.yandex.mobile.ads.impl;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class w0 {
    public static String a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread", false, m11.class.getClassLoader());
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("getProcessName", new Class[0]);
            declaredMethod2.setAccessible(true);
            Object objInvoke = declaredMethod2.invoke(declaredMethod.invoke(null, new Object[0]), new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }

    public static String b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread", false, m11.class.getClassLoader());
            Intrinsics.checkNotNullExpressionValue(cls, "forName(...)");
            Method declaredMethod = cls.getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            return (String) objInvoke;
        } catch (Throwable unused) {
            op0.c(new Object[0]);
            return null;
        }
    }
}

package com.yandex.mobile.ads.impl;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class vp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f10501a;
    private final Method b;
    private final Method c;

    public static final class a {
        public static vp a() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod("get", new Class[0]);
                method3 = cls.getMethod("open", String.class);
                method2 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new vp(method, method3, method2);
        }
    }

    public final Object a() {
        Intrinsics.checkNotNullParameter("response.body().close()", "closer");
        Method method = this.f10501a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, new Object[0]);
                Method method2 = this.b;
                Intrinsics.checkNotNull(method2);
                method2.invoke(objInvoke, "response.body().close()");
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public vp(Method method, Method method2, Method method3) {
        this.f10501a = method;
        this.b = method2;
        this.c = method3;
    }

    public final boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.c;
            Intrinsics.checkNotNull(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}

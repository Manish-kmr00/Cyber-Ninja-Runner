package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class im {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f9242a;

    public static IBinder a(Bundle bundle, String str) {
        if (x82.f10629a >= 18) {
            return bundle.getBinder(str);
        }
        Method method = f9242a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                f9242a = method2;
                method2.setAccessible(true);
                method = f9242a;
            } catch (NoSuchMethodException e) {
                at0.a("Failed to retrieve getIBinder method", (Exception) e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            at0.a("Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }
}

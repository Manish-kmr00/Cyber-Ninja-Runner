package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public class WQf {
    public static Method pA(String str, String str2, Class<?>... clsArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Class<?> clsPA = pA(str);
            if (clsPA != null) {
                return clsPA.getMethod(str2, clsArr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> pA(String str) {
        try {
            try {
                try {
                    return Class.forName(str, true, pA());
                } catch (ClassNotFoundException unused) {
                    return Class.forName(str, true, WQf.class.getClassLoader());
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return Class.forName(str);
        }
    }

    private static ClassLoader pA() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader == null ? WQf.class.getClassLoader() : contextClassLoader;
    }
}

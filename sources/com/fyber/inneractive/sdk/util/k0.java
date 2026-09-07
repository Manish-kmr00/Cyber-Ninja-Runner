package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.AbstractC3081k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k0 {
    public static boolean a(String str) {
        int i = AbstractC3081k.f1710a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        return property != null && property.trim().length() > 0 && str != null && str.toLowerCase().startsWith("fyberInternalTesting".toLowerCase()) && str.contains("crash");
    }
}

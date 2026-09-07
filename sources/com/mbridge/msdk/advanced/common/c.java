package com.mbridge.msdk.advanced.common;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MBNativeAdvancedWebViewCache.java */
/* JADX INFO: loaded from: classes12.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f4674a = new HashMap();

    public static void a(String str, boolean z) {
        f4674a.put(str, Boolean.valueOf(z));
    }

    public static void b(String str) {
        f4674a.remove(str);
    }

    public static boolean a(String str) {
        if (f4674a.containsKey(str)) {
            return f4674a.get(str).booleanValue();
        }
        return false;
    }
}

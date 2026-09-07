package com.mbridge.msdk.util;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBConfiguration;

/* JADX INFO: compiled from: CommonUtils.java */
/* JADX INFO: loaded from: classes13.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f5669a;
    private static volatile Boolean b;

    public static boolean a() {
        if (f5669a == null) {
            try {
                Boolean boolValueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2);
                f5669a = boolValueOf;
                return boolValueOf.booleanValue();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonUtils", "isChina", e);
                }
            }
        }
        return f5669a != null && f5669a.booleanValue();
    }

    public static boolean b() {
        if (b == null) {
            try {
                Boolean boolValueOf = Boolean.valueOf(Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1);
                b = boolValueOf;
                return boolValueOf.booleanValue();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("CommonUtils", "isOversea", e);
                }
            }
        }
        return b != null && b.booleanValue();
    }
}

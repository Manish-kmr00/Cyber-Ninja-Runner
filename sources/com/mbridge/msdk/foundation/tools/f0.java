package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* JADX INFO: compiled from: NetManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f5058a;

    public static synchronized ConnectivityManager a() {
        try {
            if (f5058a == null && com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                f5058a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.c.m().d().getSystemService("connectivity");
            }
        } catch (Exception e) {
            o0.b("NetManager", e.getMessage());
        }
        return f5058a;
    }
}

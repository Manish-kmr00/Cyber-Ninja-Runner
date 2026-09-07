package com.mbridge.msdk.foundation.controller;

/* JADX INFO: compiled from: MBSDKContext.java */
/* JADX INFO: loaded from: classes10.dex */
public class c extends a {
    private static volatile c s;

    private c() {
    }

    public static c m() {
        if (s == null) {
            synchronized (c.class) {
                if (s == null) {
                    s = new c();
                }
            }
        }
        return s;
    }

    @Override // com.mbridge.msdk.foundation.controller.a
    protected void a(a.e eVar) {
    }
}

package com.applovin.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f400a;
    private final String b;
    private final Map c;
    private final boolean d;

    public e(String str, String str2) {
        this(str, str2, null, false);
    }

    public String a() {
        return this.b;
    }

    public Map b() {
        return this.c;
    }

    public String c() {
        return this.f400a;
    }

    public boolean d() {
        return this.d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f400a + "', backupUrl='" + this.b + "', headers='" + this.c + "', shouldFireInWebView='" + this.d + "'}";
    }

    public e(String str, String str2, Map map, boolean z) {
        this.f400a = str;
        this.b = str2;
        this.c = map;
        this.d = z;
    }
}

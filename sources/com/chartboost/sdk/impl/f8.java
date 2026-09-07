package com.chartboost.sdk.impl;

/* JADX INFO: loaded from: classes5.dex */
public class f8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1015a;
    public final String b;

    public f8(String str, String str2) {
        this.f1015a = str;
        this.b = str2;
    }

    public static f8 a(String str, String str2) {
        ld.a(str, "Name is null or empty");
        ld.a(str2, "Version is null or empty");
        return new f8(str, str2);
    }

    public String b() {
        return this.b;
    }

    public String a() {
        return this.f1015a;
    }
}

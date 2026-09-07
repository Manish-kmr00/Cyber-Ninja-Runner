package com.safedk.android.analytics.brandsafety;

/* JADX INFO: loaded from: classes6.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8116a;
    private String b;
    private long c;

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public long b() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    private t() {
        this.c = 0L;
    }

    public t(String str, String str2, long j) {
        this.c = 0L;
        this.f8116a = str;
        this.b = str2;
        this.c = j;
    }

    public String c() {
        return a(this.f8116a, this.c);
    }

    public static String a(String str, long j) {
        return str + "_" + j;
    }
}

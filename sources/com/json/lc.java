package com.json;

/* JADX INFO: loaded from: classes10.dex */
public class lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3854a;
    private String b;
    private int c;
    private String d;

    public lc(int i, String str, String str2, String str3) {
        this.c = i;
        this.b = str2;
        this.f3854a = str;
        this.d = str3;
    }

    public lc(String str, String str2, String str3) {
        this.c = -1;
        this.b = str2;
        this.f3854a = str;
        this.d = str3;
    }

    public void a() {
        fa.a(this);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.f3854a;
    }
}

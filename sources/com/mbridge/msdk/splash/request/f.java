package com.mbridge.msdk.splash.request;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: SplashV3ParamsEntity.java */
/* JADX INFO: loaded from: classes13.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5451a;
    private String b;
    private int c;
    private int d;
    private int e;

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.f5451a;
    }

    public String e() {
        return this.b;
    }

    public String toString() {
        return "NativeAdvancedV3ParamsEntity{reqType=" + this.f5451a + ", session_id='" + this.b + "', offset=" + this.c + ", expectWidth=" + this.d + ", expectHeight=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }

    public int a() {
        return this.e;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.f5451a = i;
    }

    public void a(int i) {
        this.e = i;
    }
}

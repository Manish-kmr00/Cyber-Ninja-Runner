package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class j7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f468a;
    private String b;
    private final String c = a(x4.k);
    private final String d = a(x4.l);
    private String e = (String) y4.a(x4.m, (Object) null, com.applovin.impl.sdk.k.o());
    private String f = (String) y4.a(x4.n, (Object) null, com.applovin.impl.sdk.k.o());

    public j7(com.applovin.impl.sdk.k kVar) {
        this.f468a = kVar;
        a(f());
    }

    private String f() {
        if (!((Boolean) this.f468a.a(v4.H3)).booleanValue()) {
            this.f468a.c(x4.j);
        }
        String str = (String) this.f468a.a(x4.j);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.f468a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f468a.O().a("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.b;
    }

    private String a(x4 x4Var) {
        String str = (String) y4.a(x4Var, (Object) null, com.applovin.impl.sdk.k.o());
        if (StringUtils.isValidString(str)) {
            return str;
        }
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        y4.b(x4Var, lowerCase, com.applovin.impl.sdk.k.o());
        return lowerCase;
    }

    public void b(String str) {
        this.e = str;
        y4.b(x4.m, str, com.applovin.impl.sdk.k.o());
    }

    public void c(String str) {
        this.f = str;
        y4.b(x4.n, str, com.applovin.impl.sdk.k.o());
    }

    public void a(String str) {
        if (((Boolean) this.f468a.a(v4.H3)).booleanValue()) {
            this.f468a.b(x4.j, str);
        }
        this.b = str;
        this.f468a.u().b(str, a());
    }

    public static String a(com.applovin.impl.sdk.k kVar) {
        x4 x4Var = x4.o;
        String str = (String) kVar.a(x4Var);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        kVar.b(x4Var, strValueOf);
        return strValueOf;
    }
}

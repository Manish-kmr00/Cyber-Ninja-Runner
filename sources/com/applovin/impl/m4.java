package com.applovin.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f506a;
    private final String b;
    private final boolean c;

    m4(String str, String str2, Context context) {
        this.f506a = str.replace("android.permission.", "");
        this.b = str2;
        this.c = o0.a(str, context);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f506a;
    }

    public boolean c() {
        return this.c;
    }
}

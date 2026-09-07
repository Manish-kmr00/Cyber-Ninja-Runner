package com.yandex.mobile.ads.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public final class hf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9088a;
    private final String b;

    public final String toString() {
        return "Header[name=" + this.f9088a + ",value=" + this.b + com.ironsource.b9.i.e;
    }

    public hf0(String str, String str2) {
        this.f9088a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f9088a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hf0.class != obj.getClass()) {
            return false;
        }
        hf0 hf0Var = (hf0) obj;
        return TextUtils.equals(this.f9088a, hf0Var.f9088a) && TextUtils.equals(this.b, hf0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f9088a.hashCode() * 31);
    }
}

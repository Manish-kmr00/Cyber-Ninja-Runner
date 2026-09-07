package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public final class wa2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10549a;
    private final URL b;
    private final String c;

    private wa2(String str, URL url, String str2) {
        this.f10549a = str;
        this.b = url;
        this.c = str2;
    }

    public final String b() {
        return this.f10549a;
    }

    public final String c() {
        return this.c;
    }

    public static wa2 a(String str, URL url, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("VendorKey is null or empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("VerificationParameters is null or empty");
        }
        return new wa2(str, url, str2);
    }

    public static wa2 a(URL url) {
        return new wa2(null, url, null);
    }

    public final URL a() {
        return this.b;
    }
}

package com.yandex.mobile.ads.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class bg1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8509a = "Yandex";
    private final String b = "7.12.1";

    public final String b() {
        return this.f8509a;
    }

    public final String c() {
        return this.b;
    }

    private bg1() {
    }

    public static bg1 a() {
        if (TextUtils.isEmpty("Yandex")) {
            throw new IllegalArgumentException("Name is null or empty");
        }
        if (!TextUtils.isEmpty("7.12.1")) {
            return new bg1();
        }
        throw new IllegalArgumentException("Version is null or empty");
    }
}

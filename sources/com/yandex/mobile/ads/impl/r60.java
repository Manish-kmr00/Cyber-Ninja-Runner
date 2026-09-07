package com.yandex.mobile.ads.impl;

import java.util.HashSet;

/* JADX INFO: loaded from: classes11.dex */
public final class r60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f10076a = new HashSet<>();
    private static String b = "goog.exo.core";

    public static synchronized String a() {
        return b;
    }

    public static synchronized void a(String str) {
        if (f10076a.add(str)) {
            b += ", " + str;
        }
    }
}

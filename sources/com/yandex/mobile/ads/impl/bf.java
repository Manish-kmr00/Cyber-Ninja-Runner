package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class bf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final cf f8502a = new cf();

    public static String b() {
        return a("Incorrect integration");
    }

    private static String a(String str) {
        return "Internal state wasn't completely configured. " + str + ".";
    }

    public final String a(mf reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.f8502a.getClass();
        return a(cf.a(reason));
    }

    public static String a() {
        return a("Connection timeout");
    }
}

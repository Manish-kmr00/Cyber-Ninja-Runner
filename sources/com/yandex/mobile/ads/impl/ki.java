package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class ki {
    public static Set a(ot nativeAdAssets) {
        Intrinsics.checkNotNullParameter(nativeAdAssets, "nativeAdAssets");
        Set setCreateSetBuilder = SetsKt.createSetBuilder();
        if (nativeAdAssets.a() != null) {
            setCreateSetBuilder.add("age");
        }
        if (nativeAdAssets.b() != null) {
            setCreateSetBuilder.add("body");
        }
        if (nativeAdAssets.c() != null) {
            setCreateSetBuilder.add("call_to_action");
        }
        if (nativeAdAssets.d() != null) {
            setCreateSetBuilder.add("domain");
        }
        if (nativeAdAssets.e() != null) {
            setCreateSetBuilder.add("favicon");
        }
        if (nativeAdAssets.g() != null) {
            setCreateSetBuilder.add("icon");
        }
        if (nativeAdAssets.h() != null) {
            setCreateSetBuilder.add("media");
        }
        if (nativeAdAssets.i() != null) {
            setCreateSetBuilder.add("media");
        }
        if (nativeAdAssets.j() != null) {
            setCreateSetBuilder.add("price");
        }
        if (nativeAdAssets.k() != null) {
            setCreateSetBuilder.add("rating");
        }
        if (nativeAdAssets.l() != null) {
            setCreateSetBuilder.add("review_count");
        }
        if (nativeAdAssets.m() != null) {
            setCreateSetBuilder.add("sponsored");
        }
        if (nativeAdAssets.n() != null) {
            setCreateSetBuilder.add("title");
        }
        if (nativeAdAssets.o() != null) {
            setCreateSetBuilder.add("warning");
        }
        if (nativeAdAssets.f()) {
            setCreateSetBuilder.add("feedback");
        }
        return SetsKt.build(setCreateSetBuilder);
    }
}

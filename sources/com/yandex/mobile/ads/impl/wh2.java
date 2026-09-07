package com.yandex.mobile.ads.impl;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
public final class wh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<f92.a, String> f10566a = MapsKt.mapOf(TuplesKt.to(f92.a.d, "Screen is locked"), TuplesKt.to(f92.a.e, "Asset value %s doesn't match view value"), TuplesKt.to(f92.a.f, "No ad view"), TuplesKt.to(f92.a.g, "No valid ads in ad unit"), TuplesKt.to(f92.a.h, "No visible required assets"), TuplesKt.to(f92.a.i, "Ad view is not added to hierarchy"), TuplesKt.to(f92.a.j, "Ad is not visible for percent"), TuplesKt.to(f92.a.k, "Required asset %s is not visible in ad view"), TuplesKt.to(f92.a.l, "Required asset %s is not subview of ad view"), TuplesKt.to(f92.a.c, "Unknown error, that shouldn't happen"), TuplesKt.to(f92.a.m, "Ad view is hidden"), TuplesKt.to(f92.a.n, "View is too small"), TuplesKt.to(f92.a.o, "Visible area of an ad view is too small"));

    public static String a(f92 validationResult) {
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        String strA = validationResult.a();
        String str = f10566a.get(validationResult.b());
        if (str == null) {
            return "Visibility error";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return z0.a(new Object[]{strA}, 1, str, "format(...)");
    }
}

package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class j20 {
    public static y00 a(m61 nativeAdPrivate, wr contentCloseListener, pt nativeAdEventListener, to clickConnector, lp1 reporter) {
        Intrinsics.checkNotNullParameter(nativeAdPrivate, "nativeAdPrivate");
        Intrinsics.checkNotNullParameter(contentCloseListener, "contentCloseListener");
        Intrinsics.checkNotNullParameter(nativeAdEventListener, "nativeAdEventListener");
        Intrinsics.checkNotNullParameter(clickConnector, "clickConnector");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        if (!(nativeAdPrivate instanceof uz1)) {
            return new i51(nativeAdPrivate, contentCloseListener, nativeAdEventListener, clickConnector, reporter, new h41(), new n61(), new dh(n61.a(nativeAdPrivate)));
        }
        uz1 uz1Var = (uz1) nativeAdPrivate;
        return new tz1(uz1Var, contentCloseListener, nativeAdEventListener, clickConnector, reporter, new h41(), new n61(), new dh(n61.b(uz1Var)));
    }
}

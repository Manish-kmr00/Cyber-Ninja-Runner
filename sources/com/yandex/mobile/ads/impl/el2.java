package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.common.AdRequest;
import com.yandex.mobile.ads.common.AdTheme;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class el2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hq1 f8811a;

    public final v7 a(String adUnitId, AdRequest adRequest) {
        gq1 gq1VarA;
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adRequest, "adRequest");
        AdTheme preferredTheme = adRequest.getPreferredTheme();
        if (preferredTheme != null) {
            this.f8811a.getClass();
            gq1VarA = hq1.a(preferredTheme);
        } else {
            gq1VarA = null;
        }
        return new v7.a(adUnitId).a(adRequest.getAge()).d(adRequest.getBiddingData()).c(adRequest.getGender()).b(adRequest.getContextQuery()).a(adRequest.getContextTags()).a(adRequest.getLocation()).a(adRequest.getParameters()).a(gq1VarA).a();
    }

    public /* synthetic */ el2() {
        this(new hq1());
    }

    public el2(hq1 requestedAdThemeFactory) {
        Intrinsics.checkNotNullParameter(requestedAdThemeFactory, "requestedAdThemeFactory");
        this.f8811a = requestedAdThemeFactory;
    }
}

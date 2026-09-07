package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class w91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y61 f10545a;

    public final u61 a(o8<String> adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        String strI = adResponse.I();
        if (strI == null || strI.length() == 0) {
            return null;
        }
        return this.f10545a.a(strI, new uj(adResponse, adResponse.C(), adResponse.y()));
    }

    public /* synthetic */ w91(Context context, lp1 lp1Var) {
        this(context, lp1Var, new y61(context, lp1Var));
    }

    public w91(Context context, lp1 reporter, y61 nativeAdResponseParser) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdResponseParser, "nativeAdResponseParser");
        this.f10545a = nativeAdResponseParser;
    }
}

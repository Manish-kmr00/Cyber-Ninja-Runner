package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class ub2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final do0 f10374a;

    public ub2(do0 videoAd) {
        Intrinsics.checkNotNullParameter(videoAd, "videoAd");
        this.f10374a = videoAd;
    }

    public final String a() {
        JSONObject jSONObjectD = this.f10374a.d();
        String strOptString = jSONObjectD != null ? jSONObjectD.optString(com.ironsource.b9.h.m) : null;
        if (strOptString == null || strOptString.length() <= 0) {
            return null;
        }
        return strOptString;
    }
}

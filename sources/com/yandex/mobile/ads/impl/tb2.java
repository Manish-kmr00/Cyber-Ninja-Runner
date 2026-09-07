package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class tb2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kc2<T> f10283a;

    public tb2(kc2<T> videoAdPlaybackInfoCreator) {
        Intrinsics.checkNotNullParameter(videoAdPlaybackInfoCreator, "videoAdPlaybackInfoCreator");
        this.f10283a = videoAdPlaybackInfoCreator;
    }

    public final rb2<T> a(ja2 vastVideoAdData, int i, int i2) {
        Intrinsics.checkNotNullParameter(vastVideoAdData, "vastVideoAdData");
        eb2 eb2VarE = vastVideoAdData.e();
        ru ruVarB = vastVideoAdData.b();
        aw0 aw0VarC = vastVideoAdData.c();
        b12 b12VarD = vastVideoAdData.d();
        String strF = vastVideoAdData.f();
        JSONObject jSONObjectG = vastVideoAdData.g();
        rc2 rc2Var = new rc2(i, i2 + 1);
        w9 w9VarA = vastVideoAdData.a();
        return new rb2<>(ruVarB, eb2VarE, aw0VarC, this.f10283a.a(eb2VarE, ruVarB, aw0VarC, rc2Var, strF, w9VarA != null ? x9.a(w9VarA) : null, jSONObjectG), b12VarD, String.valueOf(ti0.a()), w9VarA);
    }
}

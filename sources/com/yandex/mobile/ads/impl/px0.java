package com.yandex.mobile.ads.impl;

import com.monetization.ads.mediation.base.MediatedAdapterInfo;
import com.monetization.ads.mediation.base.model.MediatedAdObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class px0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.monetization.ads.mediation.base.a f9957a;

    public px0(com.monetization.ads.mediation.base.a mediatedAd) {
        Intrinsics.checkNotNullParameter(mediatedAd, "mediatedAd");
        this.f9957a = mediatedAd;
    }

    public final MediatedAdapterInfo b() {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(this.f9957a.getAdapterInfo());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            objM7904constructorimpl = new MediatedAdapterInfo.Builder().setAdapterVersion("null").setNetworkName("null").setNetworkSdkVersion("null").build();
        }
        return (MediatedAdapterInfo) objM7904constructorimpl;
    }

    public final boolean c() {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(Boolean.valueOf(this.f9957a.getShouldTrackImpressionAutomatically()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            objM7904constructorimpl = Boolean.TRUE;
        }
        return ((Boolean) objM7904constructorimpl).booleanValue();
    }

    public final MediatedAdObject a() {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(this.f9957a.getAdObject());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = null;
        }
        return (MediatedAdObject) objM7904constructorimpl;
    }
}

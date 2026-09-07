package com.yandex.mobile.ads.impl;

import com.monetization.ads.quality.base.AdQualityVerifierAdapter;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j7 {
    public static AdQualityVerifierAdapter a() {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter("com.yandex.mobile.ads.quality.AdQualityVerifierAdapter", "adapterName");
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objA = co1.a.a("com.yandex.mobile.ads.quality.AdQualityVerifierAdapter", new Object[0]);
            objM7904constructorimpl = Result.m7904constructorimpl(objA instanceof AdQualityVerifierAdapter ? (AdQualityVerifierAdapter) objA : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            String str = "Couldn't create ad quality adapter with unknown error: " + thM7907exceptionOrNullimpl.getMessage();
            op0.b(new Object[0]);
        }
        return (AdQualityVerifierAdapter) (Result.m7910isFailureimpl(objM7904constructorimpl) ? null : objM7904constructorimpl);
    }
}

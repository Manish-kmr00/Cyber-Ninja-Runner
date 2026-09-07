package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.model.MediatedAdObjectInfo;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes6.dex */
public final class x6 implements p7 {
    @Override // com.yandex.mobile.ads.impl.p7
    public final Object a(Context context, Object obj, o8<?> o8Var, o3 o3Var, MediatedAdObjectInfo mediatedAdObjectInfo, Continuation<? super AdQualityVerificationResult> continuation) {
        return AdQualityVerificationResult.NotImplemented.INSTANCE;
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdClicked() {
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdClosed() {
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onAdWillDisplay() {
    }

    @Override // com.yandex.mobile.ads.impl.p7
    public final void onInvalidated() {
    }
}

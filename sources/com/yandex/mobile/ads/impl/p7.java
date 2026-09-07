package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.mediation.base.model.MediatedAdObjectInfo;
import com.monetization.ads.quality.base.result.AdQualityVerificationResult;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
public interface p7 {
    Object a(Context context, Object obj, o8<?> o8Var, o3 o3Var, MediatedAdObjectInfo mediatedAdObjectInfo, Continuation<? super AdQualityVerificationResult> continuation);

    void onAdClicked();

    void onAdClosed();

    void onAdWillDisplay();

    void onInvalidated();
}

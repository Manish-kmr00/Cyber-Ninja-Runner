package com.bytedance.sdk.openadsdk.api;

import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public interface PAGExpressAdWrapperListener extends PAGAdWrapperListener {
    void onAdDismissed();

    void onAdShow(View view, int i);

    void onRenderFail(View view, String str, int i);

    void onRenderSuccess(View view, float f, float f2);
}

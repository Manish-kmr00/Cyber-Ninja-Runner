package com.bytedance.sdk.openadsdk.api;

import com.bytedance.sdk.openadsdk.common.JG;

/* JADX INFO: loaded from: classes11.dex */
public interface PAGLoadListener<Ad> extends JG {
    void onAdLoaded(Ad ad);

    @Override // com.bytedance.sdk.openadsdk.common.JG
    void onError(int i, String str);
}

package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.PAGRequest;

/* JADX INFO: loaded from: classes6.dex */
public class PAGBannerRequest extends PAGRequest {
    private PAGBannerSize pA;

    public PAGBannerRequest(PAGBannerSize pAGBannerSize) {
        this.pA = pAGBannerSize;
    }

    public PAGBannerSize getAdSize() {
        return this.pA;
    }

    public void setAdSize(PAGBannerSize pAGBannerSize) {
        this.pA = pAGBannerSize;
    }
}

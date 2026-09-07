package com.bytedance.sdk.openadsdk.api.factory;

import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.common.JG;

/* JADX INFO: loaded from: classes12.dex */
public interface IADLoader<R extends PAGRequest, L extends JG> {
    void loadAd(String str, R r, L l);
}

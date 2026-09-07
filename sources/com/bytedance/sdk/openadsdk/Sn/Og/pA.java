package com.bytedance.sdk.openadsdk.Sn.Og;

import com.bytedance.sdk.component.omh.KZx;
import com.bytedance.sdk.openadsdk.Sn.Og;
import com.bytedance.sdk.openadsdk.Sn.pA.ZZv;
import com.bytedance.sdk.openadsdk.core.aBv;

/* JADX INFO: loaded from: classes4.dex */
public class pA implements KZx {
    @Override // com.bytedance.sdk.component.omh.KZx
    public void pA(final com.bytedance.sdk.component.omh.Og.pA pAVar) {
        com.bytedance.sdk.openadsdk.Sn.KZx.pA();
        com.bytedance.sdk.openadsdk.Sn.KZx.pA("stats_sdk_thread_num", false, new Og() { // from class: com.bytedance.sdk.openadsdk.Sn.Og.pA.1
            @Override // com.bytedance.sdk.openadsdk.Sn.Og
            public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                com.bytedance.sdk.component.omh.Og.pA pAVar2;
                if (!aBv.ZZv().fJy() || (pAVar2 = pAVar) == null || pAVar2.pA() == null) {
                    return null;
                }
                return ZZv.Og().pA("stats_sdk_thread_num").Og(pAVar.pA().toString());
            }
        });
    }
}

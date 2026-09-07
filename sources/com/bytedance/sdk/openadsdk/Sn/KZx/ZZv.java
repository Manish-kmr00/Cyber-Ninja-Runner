package com.bytedance.sdk.openadsdk.Sn.KZx;

/* JADX INFO: loaded from: classes12.dex */
class ZZv implements Og {
    private static volatile ZZv pA;

    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.Og
    public void pA(com.bytedance.sdk.openadsdk.Sn.Og og) {
    }

    @Override // com.bytedance.sdk.openadsdk.Sn.KZx.Og
    public void pA(com.bytedance.sdk.openadsdk.Sn.Og og, boolean z) {
    }

    public static ZZv pA() {
        if (pA == null) {
            synchronized (ZZv.class) {
                if (pA == null) {
                    pA = new ZZv();
                }
            }
        }
        return pA;
    }

    private ZZv() {
    }
}

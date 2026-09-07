package com.bytedance.sdk.openadsdk.core.pA;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.Og;
import com.bytedance.sdk.openadsdk.core.yFO;
import com.bytedance.sdk.openadsdk.oX.KZx;
import com.bytedance.sdk.openadsdk.oX.ZZv;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes7.dex */
public class pA implements yFO.pA {
    private final AdSlot Og;
    private final yFO.pA pA;

    public pA(yFO.pA pAVar, AdSlot adSlot) {
        this.pA = pAVar;
        this.Og = adSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
    public void pA(final int i, final String str) {
        AdSlot adSlot;
        if (this.pA != null) {
            if (xy.ML() || ((adSlot = this.Og) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.vZF.pA.pA("start_activity_async", 0) == 1)) {
                this.pA.pA(i, str);
            } else {
                xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pA.pA.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.pA.pA(i, str);
                    }
                });
            }
            AdSlot adSlot2 = this.Og;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            KZx.KZx(new ZZv() { // from class: com.bytedance.sdk.openadsdk.core.pA.pA.2
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar.Og("load_ad");
                    pAVar.KZx(pA.this.Og.getCodeId());
                    pAVar.ZZv(gbA.KZx(pA.this.Og.getDurationSlotType()));
                    pAVar.pA(BuildConfig.VERSION_NAME);
                    pAVar.SD(gbA.pA(pA.this.Og).toString());
                    return pAVar;
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
    public void pA(final com.bytedance.sdk.openadsdk.core.model.pA pAVar, final Og og) {
        AdSlot adSlot;
        if (this.pA != null) {
            if (xy.ML() || ((adSlot = this.Og) != null && adSlot.getDurationSlotType() != 5 && com.bytedance.sdk.openadsdk.vZF.pA.pA("start_activity_async", 0) == 1)) {
                this.pA.pA(pAVar, og);
            } else {
                xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pA.pA.3
                    @Override // java.lang.Runnable
                    public void run() {
                        pA.this.pA.pA(pAVar, og);
                    }
                });
            }
            AdSlot adSlot2 = this.Og;
            if (adSlot2 == null || adSlot2.isPreload()) {
                return;
            }
            KZx.Og(new ZZv() { // from class: com.bytedance.sdk.openadsdk.core.pA.pA.4
                @Override // com.bytedance.sdk.openadsdk.oX.ZZv
                public com.bytedance.sdk.openadsdk.oX.Og.pA generatorModel() {
                    com.bytedance.sdk.openadsdk.oX.Og.pA pAVar2 = new com.bytedance.sdk.openadsdk.oX.Og.pA();
                    pAVar2.Og("load_ad");
                    pAVar2.KZx(pA.this.Og.getCodeId());
                    pAVar2.ZZv(gbA.KZx(pA.this.Og.getDurationSlotType()));
                    pAVar2.pA(BuildConfig.VERSION_NAME);
                    pAVar2.SD(gbA.pA(pA.this.Og).toString());
                    return pAVar2;
                }
            });
        }
    }
}

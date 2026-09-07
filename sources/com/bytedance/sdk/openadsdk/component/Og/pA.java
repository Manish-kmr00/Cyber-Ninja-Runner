package com.bytedance.sdk.openadsdk.component.Og;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.Sn.KZx;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.common.JG;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.Og;
import com.bytedance.sdk.openadsdk.core.model.TX;
import com.bytedance.sdk.openadsdk.core.omh;
import com.bytedance.sdk.openadsdk.core.yFO;
import com.bytedance.sdk.openadsdk.oem.IPMiBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.qmB;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pA {
    private static volatile pA pA;
    private final yFO Og = aBv.KZx();

    public static pA pA() {
        if (pA == null) {
            synchronized (pA.class) {
                if (pA == null) {
                    pA = new pA();
                }
            }
        }
        return pA;
    }

    private pA() {
    }

    public void pA(final Context context, final AdSlot adSlot, final JG jg) {
        final qmB qmbOg = qmB.Og();
        this.Og.pA(adSlot, new TX(), 5, new yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.Og.pA.1
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                jg.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, Og og) {
                if (pAVar.ZZv() != null && !pAVar.ZZv().isEmpty()) {
                    List<com.bytedance.sdk.openadsdk.core.model.yFO> listZZv = pAVar.ZZv();
                    ArrayList arrayList = new ArrayList(listZZv.size());
                    for (com.bytedance.sdk.openadsdk.core.model.yFO yfo : listZZv) {
                        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo) || (yfo != null && yfo.Uz())) {
                            PAGNativeAd pAGNativeAdPA = pA(context, yfo, adSlot);
                            if (jg instanceof PAGNativeAdLoadListener) {
                                arrayList.add(pAGNativeAdPA);
                            }
                        }
                        if (com.bytedance.sdk.openadsdk.core.model.yFO.ML(yfo) && yfo.Bf() != null && yfo.Bf().BSW() != null) {
                            if (aBv.ZZv().ML(String.valueOf(yfo.Wf())) && aBv.ZZv().YkC()) {
                                if (yfo.Bf() != null) {
                                    yfo.Bf().JG(1);
                                }
                                if (yfo.Qd() != null) {
                                    yfo.Qd().JG(1);
                                }
                                com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = com.bytedance.sdk.openadsdk.core.model.yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).KZx(), yfo);
                                ogPA.pA("material_meta", yfo);
                                ogPA.pA("ad_slot", adSlot);
                                com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, null);
                            }
                            IPMiBroadcastReceiver.pA(context, yfo);
                        }
                    }
                    if ((jg instanceof PAGNativeAdLoadListener) && !arrayList.isEmpty()) {
                        AdSlot adSlot2 = adSlot;
                        if (adSlot2 != null && !TextUtils.isEmpty(adSlot2.getBidAdm())) {
                            KZx.pA(listZZv.get(0), qmbOg.ZZv());
                        }
                        JG jg2 = jg;
                        if (jg2 instanceof PAGNativeAdLoadListener) {
                            ((PAGNativeAdLoadListener) jg2).onAdLoaded(arrayList.get(0));
                        }
                        if (og.ML() == null || og.ML().isEmpty()) {
                            return;
                        }
                        Og.pA(og);
                        return;
                    }
                    jg.onError(-4, omh.pA(-4));
                    og.pA(-4);
                    Og.pA(og);
                    return;
                }
                jg.onError(-3, omh.pA(-3));
                og.pA(-3);
                Og.pA(og);
            }

            private PAGNativeAd pA(Context context2, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot2) {
                if (yfo.BF() == 2) {
                    if (yfo.Bf() != null) {
                        return new com.bytedance.sdk.openadsdk.pA.Og.pA.Og(context2, yfo, adSlot2);
                    }
                    return new com.bytedance.sdk.openadsdk.pA.Og.pA.KZx(context2, yfo, adSlot2);
                }
                return new com.bytedance.sdk.openadsdk.pA.Og.Og(context2, yfo, 5, adSlot2);
            }
        });
    }
}

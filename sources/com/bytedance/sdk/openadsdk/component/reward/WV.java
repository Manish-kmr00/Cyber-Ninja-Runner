package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.TX;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WV {
    private static volatile WV pA;
    private com.bytedance.sdk.component.omh.omh ML;
    private final Context Og;
    private final AtomicBoolean KZx = new AtomicBoolean(false);
    private final List<Og> ZZv = Collections.synchronizedList(new ArrayList());
    private final BF.pA JG = new BF.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.7
        @Override // com.bytedance.sdk.component.utils.BF.pA
        public void pA(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (WV.this.ML == null) {
                    WV.this.ML = new com.bytedance.sdk.openadsdk.component.reward.Og("net connect task", WV.this.ZZv);
                }
                com.bytedance.sdk.component.utils.SD.pA().post(WV.this.ML);
            }
        }
    };

    public static WV pA(Context context) {
        if (pA == null) {
            synchronized (WV.class) {
                if (pA == null) {
                    pA = new WV(context);
                }
            }
        }
        return pA;
    }

    private WV(Context context) {
        this.Og = context == null ? aBv.pA() : context.getApplicationContext();
        Og();
    }

    public void pA(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || BSW.pA(this.Og).pA(adSlot.getCodeId(), false) != null) {
            return;
        }
        pA(adSlot, true, null);
    }

    public void pA(String str, yFO yfo) {
        BSW.pA(this.Og).pA(str, yfo);
    }

    public void pA() {
        try {
            BSW.pA(this.Og).pA();
        } catch (Throwable unused) {
        }
    }

    public void pA(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        Og(adSlot, pAGRewardedAdLoadListener);
    }

    private void Og(AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarPA;
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (pAVarPA = BSW.pA(this.Og).pA(adSlot.getCodeId(), true)) != null && pAVarPA.ML()) {
            yFO yfoJG = pAVarPA.JG();
            for (yFO yfo : pAVarPA.ZZv()) {
                if (yfo.rB() == null) {
                    yfo.pA(adSlot);
                }
            }
            Sn sn = new Sn(this.Og, pAVarPA, adSlot);
            if (!pAVarPA.SD() && !WQf.KZx(yfoJG)) {
                sn.Og();
            }
            if (pAGRewardedAdLoadListener != null) {
                if (!pAVarPA.SD() && aBv.ZZv().yFO() == 0) {
                    pA(adSlot, pAVarPA, pAGRewardedAdLoadListener, (PAGRewardedAd) sn.pA(), true);
                }
                KZx kZx = new KZx(new pA(this.Og, adSlot, pAVarPA, pAGRewardedAdLoadListener, true), pAVarPA);
                for (int i = 0; i < pAVarPA.ZZv().size(); i++) {
                    pA(pAVarPA.ZZv().get(i), adSlot, kZx, sn, pAVarPA.SD());
                    if (pAVarPA.WV()) {
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < pAVarPA.ZZv().size(); i2++) {
                com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pAVarPA.ZZv().get(i2), new com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.InterfaceC0236pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.1
                });
            }
            return;
        }
        pA(adSlot, false, pAGRewardedAdLoadListener);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    private void pA(yFO yfo, AdSlot adSlot, final KZx kZx, final Sn sn, final boolean z) {
        boolean z2;
        boolean z3 = false;
        if (kZx != null) {
            z2 = true;
            if (!z && aBv.ZZv().yFO() != 1) {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (WQf.KZx(yfo)) {
            z3 = z2;
        } else {
            com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).pA(), yfo);
            ogPA.pA("material_meta", yfo);
            ogPA.pA("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.2
                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i) {
                    Log.d("RewardVideoLoadManager", "onVideoPreloadSuccess: ");
                    if (kZx != null) {
                        if (z || aBv.ZZv().yFO() == 1) {
                            kZx.onAdLoaded(sn.pA());
                        }
                    }
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i, String str) {
                    if (kZx != null) {
                        if (z || aBv.ZZv().yFO() == 1) {
                            kZx.onError(i, str);
                        }
                    }
                }
            });
        }
        if (z3) {
            kZx.onAdLoaded(sn.pA());
        }
    }

    private void pA(final AdSlot adSlot, final boolean z, final PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        if (com.bytedance.sdk.component.utils.WV.ZZv()) {
            com.bykv.vk.openvk.pA.pA.pA.SD.Og.pA(adSlot.getBidAdm());
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        TX tx = new TX();
        tx.Og = z ? 2 : 1;
        if (aBv.ZZv().WV(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            tx.omh = 2;
        }
        aBv.KZx().pA(adSlot, tx, 7, new com.bytedance.sdk.openadsdk.core.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.3
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (z || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                    return;
                }
                pAGRewardedAdLoadListener2.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                PAGRewardedAdLoadListener pAGRewardedAdLoadListener2;
                if (pAVar.ZZv() != null && !pAVar.ZZv().isEmpty()) {
                    Sn sn = new Sn(WV.this.Og, pAVar, adSlot);
                    if (!z) {
                        if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                            com.bytedance.sdk.openadsdk.yFO.pA.ZZv.pA().pA(pAVar.ZZv().isEmpty() ? null : pAVar.ZZv().get(0));
                            com.bytedance.sdk.openadsdk.Sn.KZx.pA(pAVar.JG(), System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        if (!pAVar.SD() && pAGRewardedAdLoadListener != null && aBv.ZZv().yFO() == 0) {
                            WV.this.pA(adSlot, pAVar, pAGRewardedAdLoadListener, (PAGRewardedAd) sn.pA(), false);
                        }
                    }
                    KZx kZx = new KZx(new pA(WV.this.Og, adSlot, pAVar, pAGRewardedAdLoadListener, false), pAVar);
                    for (int i = 0; i < pAVar.ZZv().size(); i++) {
                        WV.this.pA(pAVar, pAVar.ZZv().get(i), sn, adSlot, z, kZx, pAVar.SD());
                        if (pAVar.WV()) {
                            return;
                        }
                    }
                    return;
                }
                if (z || (pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener) == null) {
                    return;
                }
                pAGRewardedAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.omh.pA(-3));
                og.pA(-3);
                com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final com.bytedance.sdk.openadsdk.core.model.pA pAVar, yFO yfo, final Sn sn, final AdSlot adSlot, final boolean z, final KZx kZx, final boolean z2) {
        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(yfo, new com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.InterfaceC0236pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.4
        });
        boolean z3 = true;
        if (z && !WQf.KZx(yfo) && aBv.ZZv().eG(adSlot.getCodeId()).ZZv == 1 && !DX.ZZv(this.Og)) {
            pA(new Og(yfo, adSlot, pAVar));
            return;
        }
        boolean z4 = false;
        if (kZx == null || (!z2 && aBv.ZZv().yFO() != 1)) {
            z3 = false;
        }
        if (!WQf.KZx(yfo)) {
            if (yfo.Bf() != null) {
                com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).pA(), yfo);
                ogPA.pA("material_meta", yfo);
                ogPA.pA("ad_slot", adSlot);
                com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.5
                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i) {
                        sn.Og();
                        if (z) {
                            BSW.pA(WV.this.Og).pA(adSlot, pAVar);
                        } else if (kZx != null) {
                            if (z2 || aBv.ZZv().yFO() == 1) {
                                kZx.onAdLoaded(sn.pA());
                            }
                        }
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx2, int i, String str) {
                        if (kZx != null) {
                            if (z2 || aBv.ZZv().yFO() == 1) {
                                kZx.onError(i, str);
                            }
                        }
                    }
                });
            } else {
                z4 = z3;
            }
            z3 = z4;
        } else if (z) {
            BSW.pA(this.Og).pA(adSlot, pAVar);
        }
        if (z3) {
            kZx.onAdLoaded(sn.pA());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.component.reward.WV$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA<Object> {
        final /* synthetic */ boolean JG;
        final /* synthetic */ AdSlot KZx;
        final /* synthetic */ KZx ML;
        final /* synthetic */ Sn Og;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.model.pA ZZv;
        final /* synthetic */ boolean pA;

        AnonymousClass6(boolean z, Sn sn, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, KZx kZx, boolean z2) {
            this.pA = z;
            this.Og = sn;
            this.KZx = adSlot;
            this.ZZv = pAVar;
            this.ML = kZx;
            this.JG = z2;
        }

        @Override // com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA
        public void pA(boolean z, Object obj) {
            if (z) {
                this.Og.Og();
            }
            if (this.pA) {
                if (z) {
                    BSW.pA(WV.this.Og).pA(this.KZx, this.ZZv);
                }
            } else {
                if (z) {
                    if (this.ML != null) {
                        if (this.JG || aBv.ZZv().yFO() == 1) {
                            this.ML.onAdLoaded(this.Og.pA());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.ML != null) {
                    if (this.JG || aBv.ZZv().yFO() == 1) {
                        this.ML.onError(-1, "");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, PAGRewardedAd pAGRewardedAd, boolean z) {
        if (pAGRewardedAdLoadListener != null) {
            pAGRewardedAdLoadListener.onAdLoaded(pAGRewardedAd);
        }
        int iOg = ML.Og();
        if (!z) {
            if (iOg == 2) {
                BSW.pA(this.Og).pA(adSlot, pAVar);
                Og(adSlot);
                return;
            }
            return;
        }
        if (iOg == 2) {
            Og(adSlot);
        } else if (iOg == 1) {
            BSW.pA(this.Og).pA(adSlot.getCodeId(), (yFO) null);
        }
    }

    private void Og(AdSlot adSlot) {
        if (ML.Og() != 2) {
            return;
        }
        BSW.pA(this.Og).pA(adSlot.getCodeId());
    }

    private void pA(Og og) {
        if (og == null) {
            return;
        }
        if (this.ZZv.size() > 0) {
            this.ZZv.remove(0);
        }
        this.ZZv.add(og);
    }

    private void Og() {
        if (this.KZx.get()) {
            return;
        }
        this.KZx.set(true);
        BF.pA(this.JG, this.Og);
    }

    private void KZx() {
        if (this.KZx.get()) {
            this.KZx.set(false);
            try {
                BF.pA(this.JG);
            } catch (Exception unused) {
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.ML != null) {
            try {
                com.bytedance.sdk.component.utils.SD.pA().removeCallbacks(this.ML);
            } catch (Exception unused) {
            }
            this.ML = null;
        }
        KZx();
    }

    public static class Og extends com.bytedance.sdk.component.omh.omh {
        final com.bytedance.sdk.openadsdk.core.model.pA KZx;
        final AdSlot Og;
        final yFO pA;

        Og(yFO yfo, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
            super("Reward Task");
            this.pA = yfo;
            this.Og = adSlot;
            this.KZx = pAVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pA == null || this.pA.Bf() == null) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(this.pA.FK()).pA(), this.pA);
            ogPA.pA("material_meta", this.pA);
            ogPA.pA("ad_slot", this.Og);
            com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.Og.1
                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
                    BSW.pA(aBv.pA()).pA(Og.this.Og, Og.this.KZx);
                }
            });
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.component.reward.WV$Og$2, reason: invalid class name */
        class AnonymousClass2 implements com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA<Object> {
            AnonymousClass2() {
            }

            @Override // com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA
            public void pA(boolean z, Object obj) {
                if (z) {
                    BSW.pA(aBv.pA()).pA(Og.this.Og, Og.this.KZx);
                }
            }
        }
    }

    private static class pA implements PAGRewardedAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.pA KZx;
        private final boolean ML;
        private final AdSlot Og;
        private final PAGRewardedAdLoadListener ZZv;
        private final Context pA;

        public pA(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, PAGRewardedAdLoadListener pAGRewardedAdLoadListener, boolean z) {
            this.pA = context;
            this.Og = adSlot;
            this.KZx = pAVar;
            this.ZZv = pAGRewardedAdLoadListener;
            this.ML = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
        public void onError(int i, String str) {
            PAGRewardedAdLoadListener pAGRewardedAdLoadListener = this.ZZv;
            if (pAGRewardedAdLoadListener != null) {
                pAGRewardedAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            WV.pA(this.pA).pA(this.Og, this.KZx, this.ZZv, pAGRewardedAd, this.ML);
        }
    }

    private static class KZx implements PAGRewardedAdLoadListener {
        private final AtomicInteger KZx;
        private final AtomicBoolean Og;
        private final com.bytedance.sdk.openadsdk.core.model.pA ZZv;
        private final PAGRewardedAdLoadListener pA;

        private KZx(PAGRewardedAdLoadListener pAGRewardedAdLoadListener, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
            this.Og = new AtomicBoolean(false);
            this.pA = pAGRewardedAdLoadListener;
            this.ZZv = pAVar;
            this.KZx = new AtomicInteger(pA());
        }

        private int pA() {
            if (!this.ZZv.ML()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.ZZv.ZZv().size(); i2++) {
                yFO yfo = this.ZZv.ZZv().get(i2);
                if (yfo != null && !WQf.KZx(yfo) && yfo.Bf() != null) {
                    i++;
                }
            }
            return i;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
        public void onError(int i, String str) {
            if (this.KZx.decrementAndGet() > 0 || this.pA == null || !this.Og.compareAndSet(false, true)) {
                return;
            }
            this.pA.onError(i, str);
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.WV.KZx.1
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", KZx.this.ZZv.Og());
                    return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("choose_ad_load_error").Og(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
            this.KZx.decrementAndGet();
            if (this.pA == null || !this.Og.compareAndSet(false, true)) {
                return;
            }
            this.pA.onAdLoaded(pAGRewardedAd);
        }
    }
}

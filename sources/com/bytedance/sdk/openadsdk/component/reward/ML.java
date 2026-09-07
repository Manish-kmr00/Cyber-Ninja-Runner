package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.BF;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.TX;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.qmB;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class ML {
    private static volatile ML pA;
    private com.bytedance.sdk.component.omh.omh ML;
    private final Context Og;
    private final AtomicBoolean KZx = new AtomicBoolean(false);
    private final List<KZx> ZZv = Collections.synchronizedList(new ArrayList());
    private final BF.pA JG = new BF.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.7
        @Override // com.bytedance.sdk.component.utils.BF.pA
        public void pA(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (ML.this.ML == null) {
                    ML.this.ML = new com.bytedance.sdk.openadsdk.component.reward.Og("fsv net connect task", ML.this.ZZv);
                }
                com.bytedance.sdk.component.utils.SD.pA().post(ML.this.ML);
            }
        }
    };

    public static ML pA(Context context) {
        if (pA == null) {
            synchronized (ML.class) {
                if (pA == null) {
                    pA = new ML(context);
                }
            }
        }
        return pA;
    }

    private ML(Context context) {
        this.Og = context == null ? aBv.pA() : context.getApplicationContext();
        KZx();
    }

    public void pA() {
        try {
            ZZv.pA(this.Og).pA();
        } catch (Throwable unused) {
        }
    }

    public void pA(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getCodeId()) || !TextUtils.isEmpty(adSlot.getBidAdm()) || ZZv.pA(this.Og).pA(adSlot.getCodeId(), false) != null) {
            return;
        }
        pA(adSlot, true, qmB.Og(), null);
    }

    public void pA(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        Og(adSlot, pAGInterstitialAdLoadListener);
    }

    private void Og(AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        com.bytedance.sdk.openadsdk.core.model.pA pAVarPA;
        qmB qmbOg = qmB.Og();
        if (TextUtils.isEmpty(adSlot.getBidAdm()) && (pAVarPA = ZZv.pA(this.Og).pA(adSlot.getCodeId(), true)) != null && pAVarPA.ML()) {
            yFO yfoJG = pAVarPA.JG();
            for (yFO yfo : pAVarPA.ZZv()) {
                if (yfo.rB() == null) {
                    yfo.pA(adSlot);
                }
            }
            Wx wx = new Wx(this.Og, pAVarPA);
            if (!pAVarPA.SD() && !WQf.KZx(yfoJG)) {
                wx.Og();
            }
            if (pAGInterstitialAdLoadListener != null) {
                if (!pAVarPA.SD() && aBv.ZZv().yFO() == 0) {
                    pA(adSlot, pAVarPA, pAGInterstitialAdLoadListener, wx.pA(), true);
                }
                Og og = new Og(new pA(this.Og, adSlot, pAVarPA, pAGInterstitialAdLoadListener, true), pAVarPA);
                for (int i = 0; i < pAVarPA.ZZv().size(); i++) {
                    pA(pAVarPA.ZZv().get(i), adSlot, og, qmbOg, wx, pAVarPA.SD());
                    if (pAVarPA.WV()) {
                        break;
                    }
                }
            }
            for (int i2 = 0; i2 < pAVarPA.ZZv().size(); i2++) {
                com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(pAVarPA.ZZv().get(i2), new com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.InterfaceC0236pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.1
                });
            }
            return;
        }
        pA(adSlot, false, qmbOg, pAGInterstitialAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, PAGInterstitialAd pAGInterstitialAd, boolean z) {
        if (pAGInterstitialAdLoadListener != null) {
            pAGInterstitialAdLoadListener.onAdLoaded(pAGInterstitialAd);
        }
        int iOg = Og();
        if (!z) {
            if (iOg == 2) {
                ZZv.pA(this.Og).pA(adSlot, pAVar);
                Og(adSlot);
                return;
            }
            return;
        }
        if (iOg == 2) {
            Og(adSlot);
        } else if (iOg == 1) {
            ZZv.pA(this.Og).pA(adSlot.getCodeId(), (yFO) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0011  */
    private void pA(yFO yfo, AdSlot adSlot, final Og og, qmB qmb, final Wx wx, final boolean z) {
        boolean z2;
        boolean z3 = false;
        if (og != null) {
            z2 = true;
            if (!z && aBv.ZZv().yFO() != 1) {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (WQf.KZx(yfo) || !yFO.ML(yfo)) {
            z3 = z2;
        } else {
            yfo.Bf();
            com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).pA(), yfo);
            ogPA.pA("material_meta", yfo);
            ogPA.pA("ad_slot", adSlot);
            com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.2
                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
                    if (og != null) {
                        if (z || aBv.ZZv().yFO() == 1) {
                            og.onAdLoaded(wx.pA());
                        }
                    }
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
                    if (og != null) {
                        if (z || aBv.ZZv().yFO() == 1) {
                            og.onError(i, str);
                        }
                    }
                }
            });
        }
        if (z3) {
            og.onAdLoaded(wx.pA());
        }
    }

    private void pA(final AdSlot adSlot, final boolean z, final qmB qmb, final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        TX tx = new TX();
        tx.KZx = z ? 2 : 1;
        if (aBv.ZZv().WV(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            tx.omh = 2;
        }
        aBv.KZx().pA(adSlot, tx, 8, new com.bytedance.sdk.openadsdk.core.yFO.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.3
            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(int i, String str) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (z || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                    return;
                }
                pAGInterstitialAdLoadListener2.onError(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yFO.pA
            public void pA(com.bytedance.sdk.openadsdk.core.model.pA pAVar, com.bytedance.sdk.openadsdk.core.model.Og og) {
                PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2;
                if (pAVar.ZZv() != null && !pAVar.ZZv().isEmpty()) {
                    Wx wx = new Wx(ML.this.Og, pAVar);
                    if (!z) {
                        if (!TextUtils.isEmpty(adSlot.getBidAdm())) {
                            com.bytedance.sdk.openadsdk.yFO.pA.ZZv.pA().pA(pAVar.ZZv().isEmpty() ? null : pAVar.ZZv().get(0));
                            com.bytedance.sdk.openadsdk.Sn.KZx.pA(pAVar.JG(), System.currentTimeMillis() - jCurrentTimeMillis);
                        }
                        if (!pAVar.SD() && pAGInterstitialAdLoadListener != null && aBv.ZZv().yFO() == 0) {
                            ML.this.pA(adSlot, pAVar, pAGInterstitialAdLoadListener, wx.pA(), false);
                        }
                    }
                    Og og2 = new Og(new pA(ML.this.Og, adSlot, pAVar, pAGInterstitialAdLoadListener, false), pAVar);
                    for (int i = 0; i < pAVar.ZZv().size(); i++) {
                        ML.this.pA(pAVar, pAVar.ZZv().get(i), wx, adSlot, z, qmb, og2, pAVar.SD());
                        if (pAVar.WV()) {
                            return;
                        }
                    }
                    return;
                }
                if (z || (pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener) == null) {
                    return;
                }
                pAGInterstitialAdLoadListener2.onError(-3, com.bytedance.sdk.openadsdk.core.omh.pA(-3));
                og.pA(-3);
                com.bytedance.sdk.openadsdk.core.model.Og.pA(og);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(final com.bytedance.sdk.openadsdk.core.model.pA pAVar, yFO yfo, final Wx wx, final AdSlot adSlot, final boolean z, qmB qmb, final Og og, final boolean z2) {
        com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.pA().pA(yfo, new com.bytedance.sdk.openadsdk.core.Wx.KZx.pA.InterfaceC0236pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.4
        });
        boolean z3 = true;
        if (z && !WQf.KZx(yfo) && yFO.ML(yfo) && aBv.ZZv().eG(adSlot.getCodeId()).ZZv == 1 && !DX.ZZv(this.Og)) {
            pA(new KZx(yfo, adSlot, pAVar));
            return;
        }
        boolean z4 = false;
        if (og == null || (!z2 && aBv.ZZv().yFO() != 1)) {
            z3 = false;
        }
        if (WQf.KZx(yfo)) {
            if (z) {
                ZZv.pA(this.Og).pA(adSlot, pAVar);
            }
        } else if (yFO.ML(yfo)) {
            if (yfo.Bf() != null) {
                com.bytedance.sdk.openadsdk.core.Wx.pA.Og ogPA = yFO.pA(CacheDirFactory.getICacheDir(yfo.FK()).pA(), yfo);
                ogPA.pA("material_meta", yfo);
                ogPA.pA("ad_slot", adSlot);
                com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.5
                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
                        wx.Og();
                        if (z) {
                            ZZv.pA(ML.this.Og).pA(adSlot, pAVar);
                        } else if (og != null) {
                            if (z2 || aBv.ZZv().yFO() == 1) {
                                og.onAdLoaded(wx.pA());
                            }
                        }
                    }

                    @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                    public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
                        if (og != null) {
                            if (z2 || aBv.ZZv().yFO() == 1) {
                                og.onError(i, str);
                            }
                        }
                    }
                });
            } else {
                z4 = z3;
            }
            z3 = z4;
        } else if (z) {
            ZZv.pA(this.Og).pA(adSlot, pAVar);
        }
        if (z3) {
            og.onAdLoaded(wx.pA());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.component.reward.ML$6, reason: invalid class name */
    class AnonymousClass6 implements com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA<Object> {
        final /* synthetic */ boolean JG;
        final /* synthetic */ AdSlot KZx;
        final /* synthetic */ Og ML;
        final /* synthetic */ Wx Og;
        final /* synthetic */ com.bytedance.sdk.openadsdk.core.model.pA ZZv;
        final /* synthetic */ boolean pA;

        AnonymousClass6(boolean z, Wx wx, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, Og og, boolean z2) {
            this.pA = z;
            this.Og = wx;
            this.KZx = adSlot;
            this.ZZv = pAVar;
            this.ML = og;
            this.JG = z2;
        }

        @Override // com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA
        public void pA(boolean z, Object obj) {
            if (z) {
                this.Og.Og();
            }
            if (this.pA) {
                if (z) {
                    ZZv.pA(ML.this.Og).pA(this.KZx, this.ZZv);
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

    private void Og(AdSlot adSlot) {
        if (Og() != 2) {
            return;
        }
        ZZv.pA(this.Og).pA(adSlot.getCodeId());
    }

    private void pA(KZx kZx) {
        if (kZx == null) {
            return;
        }
        if (this.ZZv.size() > 0) {
            this.ZZv.remove(0);
        }
        this.ZZv.add(kZx);
    }

    private void KZx() {
        if (this.KZx.get()) {
            return;
        }
        this.KZx.set(true);
        BF.pA(this.JG, this.Og);
    }

    private void ZZv() {
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
        ZZv();
    }

    private static class KZx extends com.bytedance.sdk.component.omh.omh {
        final com.bytedance.sdk.openadsdk.core.model.pA KZx;
        final AdSlot Og;
        final yFO pA;

        KZx(yFO yfo, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
            super("Fullscreen Task");
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
            com.bytedance.sdk.openadsdk.core.Wx.ML.pA.pA(ogPA, new com.bykv.vk.openvk.pA.pA.pA.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.KZx.1
                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i, String str) {
                }

                @Override // com.bykv.vk.openvk.pA.pA.pA.ML.pA.InterfaceC0159pA
                public void pA(com.bykv.vk.openvk.pA.pA.pA.KZx.KZx kZx, int i) {
                    ZZv.pA(aBv.pA()).pA(KZx.this.Og, KZx.this.KZx);
                }
            });
        }

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.component.reward.ML$KZx$2, reason: invalid class name */
        class AnonymousClass2 implements com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA<Object> {
            AnonymousClass2() {
            }

            @Override // com.bytedance.sdk.openadsdk.common.pA.InterfaceC0223pA
            public void pA(boolean z, Object obj) {
                if (z) {
                    ZZv.pA(aBv.pA()).pA(KZx.this.Og, KZx.this.KZx);
                }
            }
        }
    }

    private static class pA implements PAGInterstitialAdLoadListener {
        private final com.bytedance.sdk.openadsdk.core.model.pA KZx;
        private final boolean ML;
        private final AdSlot Og;
        private final PAGInterstitialAdLoadListener ZZv;
        private final Context pA;

        public pA(Context context, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.model.pA pAVar, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, boolean z) {
            this.pA = context;
            this.Og = adSlot;
            this.KZx = pAVar;
            this.ZZv = pAGInterstitialAdLoadListener;
            this.ML = z;
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.JG
        public void onError(int i, String str) {
            PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = this.ZZv;
            if (pAGInterstitialAdLoadListener != null) {
                pAGInterstitialAdLoadListener.onError(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            ML.pA(this.pA).pA(this.Og, this.KZx, this.ZZv, pAGInterstitialAd, this.ML);
        }
    }

    private static class Og implements PAGInterstitialAdLoadListener {
        private final AtomicInteger KZx;
        private final AtomicBoolean Og;
        private final com.bytedance.sdk.openadsdk.core.model.pA ZZv;
        private final PAGInterstitialAdLoadListener pA;

        private Og(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener, com.bytedance.sdk.openadsdk.core.model.pA pAVar) {
            this.Og = new AtomicBoolean(false);
            this.pA = pAGInterstitialAdLoadListener;
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
            if (this.KZx.decrementAndGet() > 0 || !this.Og.compareAndSet(false, true)) {
                return;
            }
            this.pA.onError(i, str);
            com.bytedance.sdk.openadsdk.Sn.KZx.pA("choose_ad_load_error", false, new com.bytedance.sdk.openadsdk.Sn.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.ML.Og.1
                @Override // com.bytedance.sdk.openadsdk.Sn.Og
                public com.bytedance.sdk.openadsdk.Sn.pA.KZx getLogStats() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("req_id", Og.this.ZZv.Og());
                    return com.bytedance.sdk.openadsdk.Sn.pA.ZZv.Og().pA("choose_ad_load_error").Og(jSONObject.toString());
                }
            });
        }

        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
        /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.KZx.decrementAndGet();
            if (this.pA == null || !this.Og.compareAndSet(false, true)) {
                return;
            }
            this.pA.onAdLoaded(pAGInterstitialAd);
        }
    }

    public void pA(String str, yFO yfo) {
        ZZv.pA(this.Og).pA(str, yfo);
    }

    public static int Og() {
        return com.bytedance.sdk.openadsdk.vZF.pA.pA("ivrv_load_ad_cache_strategy", 0);
    }
}

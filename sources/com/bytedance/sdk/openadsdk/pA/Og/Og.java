package com.bytedance.sdk.openadsdk.pA.Og;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bytedance.sdk.component.utils.DX;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.aBv;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.core.oX;
import com.bytedance.sdk.openadsdk.utils.gbA;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class Og extends omh implements com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx, com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv, com.bytedance.sdk.openadsdk.multipro.Og.pA.InterfaceC0252pA {
    private boolean BSW;
    private final com.bytedance.sdk.openadsdk.multipro.Og.pA Bzk;
    private boolean SGo;
    private AdSlot WV;
    private long Wx;
    private KZx omh;

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void h_() {
    }

    public Og(Context context, yFO yfo, int i, AdSlot adSlot) {
        super(context, yfo, i, true);
        this.SGo = false;
        this.BSW = true;
        this.ML = i;
        this.WV = adSlot;
        this.Bzk = new com.bytedance.sdk.openadsdk.multipro.Og.pA();
        pA(this.JG);
        pA("embeded_ad");
        this.ZZv.pA(this);
    }

    public Og(Context context, yFO yfo, int i, AdSlot adSlot, pA pAVar, oX oXVar) {
        super(context, yfo, i, false);
        this.SGo = false;
        this.BSW = true;
        this.ZZv = pAVar;
        this.pA = oXVar;
        this.ML = i;
        this.WV = adSlot;
        this.Bzk = new com.bytedance.sdk.openadsdk.multipro.Og.pA();
        pA(this.JG);
        pA("embeded_ad");
        pAVar.pA(this);
    }

    public View ML() {
        com.bytedance.sdk.openadsdk.core.Wx.Og.JG jg;
        if (this.Og != null && this.KZx != null) {
            if (yFO.ML(this.Og)) {
                try {
                    jg = new com.bytedance.sdk.openadsdk.core.Wx.Og.JG(this.KZx, this.Og, this.pA.pA());
                    if (this.Og != null && this.Og.rjD()) {
                        com.bytedance.sdk.openadsdk.core.WV.JG jgPA = jg.pA((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        if (this.ZZv != null) {
                            this.ZZv.pA(jgPA);
                        }
                    }
                    this.pA.pA(jg.getNativeVideoController());
                    if (this.ZZv != null) {
                        this.ZZv.pA(jg);
                    }
                    jg.setVideoAdClickListenerTTNativeAd(this);
                    jg.setAdCreativeClickListener(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA() { // from class: com.bytedance.sdk.openadsdk.pA.Og.Og.1
                        @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.pA
                        public void pA(View view, int i) {
                            if (Og.this.pA != null) {
                                Og.this.pA.pA(view, i);
                            }
                        }
                    });
                    jg.setControllerStatusCallBack(new com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og() { // from class: com.bytedance.sdk.openadsdk.pA.Og.Og.2
                        @Override // com.bytedance.sdk.openadsdk.core.Wx.Og.JG.Og
                        public void pA(boolean z, long j, long j2, long j3, boolean z2) {
                            Og.this.Bzk.pA = z;
                            Og.this.Bzk.ML = j;
                            Og.this.Bzk.JG = j2;
                            Og.this.Bzk.SD = j3;
                            Og.this.Bzk.ZZv = z2;
                        }
                    });
                    jg.setVideoAdLoadListener(this);
                    jg.setVideoAdInteractionListener(this);
                    if (5 == this.ML) {
                        jg.setIsAutoPlay(this.SGo ? this.WV.isAutoPlay() : this.BSW);
                    } else {
                        jg.setIsAutoPlay(this.BSW);
                    }
                    jg.setIsQuiet(aBv.ZZv().KZx(String.valueOf(this.JG)));
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                    jg = null;
                }
            } else {
                jg = null;
            }
            if (yFO.ML(this.Og) && jg != null && jg.pA(0L, true, false)) {
                return jg;
            }
            ApmHelper.reportCustomError(this.Og.RS() + StringUtils.COMMA + jg, "getAdView null", new RuntimeException());
        }
        return null;
    }

    private void pA(int i) {
        int iOg = aBv.ZZv().Og(i);
        int iKZx = DX.KZx(aBv.pA());
        if (3 == iOg) {
            this.SGo = false;
            this.BSW = false;
        } else {
            if (1 == iOg && gbA.ZZv(iKZx)) {
                this.SGo = false;
            } else if (2 == iOg) {
                if (gbA.ML(iKZx) || gbA.ZZv(iKZx) || gbA.JG(iKZx)) {
                    this.SGo = false;
                }
            } else if (4 == iOg) {
                this.SGo = true;
            } else if (5 == iOg && (gbA.ZZv(iKZx) || gbA.JG(iKZx))) {
            }
            this.BSW = true;
        }
        if (this.ZZv != null) {
            this.ZZv.pA(this.SGo);
        }
    }

    public void pA(KZx kZx) {
        this.omh = kZx;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.ZZv
    public void pA(int i, int i2) {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.pA(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void d_() {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.pA(this);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void g_() {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.Og(this);
        }
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void pA(long j, long j2) {
        this.Wx = j;
    }

    @Override // com.bykv.vk.openvk.pA.pA.pA.ZZv.KZx.InterfaceC0160KZx
    public void i_() {
        KZx kZx = this.omh;
        if (kZx != null) {
            kZx.KZx(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.Og.pA.InterfaceC0252pA
    public com.bytedance.sdk.openadsdk.multipro.Og.pA JG() {
        return this.Bzk;
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.omh
    protected void pA(String str) {
        super.pA(str);
    }

    @Override // com.bytedance.sdk.openadsdk.pA.Og.omh, com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        if (this.ZZv != null) {
            this.ZZv.WV();
        }
    }
}

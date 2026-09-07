package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.json.b9;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes12.dex */
public class DX {
    private String Bzk;
    private volatile long JG;
    private FrameLayout KZx;
    private final pA Og;
    private volatile long SD;
    private com.bytedance.adsdk.ugeno.Og.KZx Sn;
    private com.bytedance.adsdk.ugeno.Og.KZx Wx;
    private boolean aBv;
    private volatile long omh;
    final com.bytedance.sdk.openadsdk.core.model.yFO pA;
    private final AtomicBoolean ZZv = new AtomicBoolean(false);
    private final AtomicBoolean ML = new AtomicBoolean(false);
    private final AtomicBoolean SGo = new AtomicBoolean(false);
    private long BSW = 0;
    private long WV = 0;
    private String DX = null;
    private boolean oX = false;

    public DX(pA pAVar) {
        this.Og = pAVar;
        this.pA = pAVar.Og;
        this.Bzk = pAVar.ML;
    }

    public void pA() {
        if (this.aBv) {
            return;
        }
        this.aBv = true;
        Og();
    }

    void Og() {
        this.KZx = (FrameLayout) this.Og.CIG.findViewById(com.bytedance.sdk.openadsdk.utils.Sn.DX);
    }

    public void KZx() {
        com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVarMx;
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo == null || (pAVarMx = yfo.Mx()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.BSW.KZx.Og og = new com.bytedance.sdk.openadsdk.core.BSW.KZx.Og(this.Og.SzT, this.pA, pAVarMx, this.Bzk, new com.bytedance.sdk.openadsdk.core.BSW.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.DX.1
            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void pA(String str) {
                DX.this.BSW = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void pA(int i, String str, String str2) {
                DX.this.DX = str2;
                DX.this.ZZv.set(false);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, false, DX.this.Bzk, b9.f.e, SystemClock.elapsedRealtime() - DX.this.BSW, str2, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void Og(String str) {
                DX.this.DX = str;
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, false, DX.this.Bzk, "success", SystemClock.elapsedRealtime() - DX.this.BSW, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA() {
                DX.this.ML();
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA(int i, String str) {
                DX.this.ZZv.set(false);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, DX.this.Bzk, SystemClock.elapsedRealtime() - DX.this.JG, i, str, (String) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA(com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
                DX.this.Wx = kZx;
                DX.this.ZZv.set(true);
                DX.this.SD = SystemClock.elapsedRealtime();
                if (DX.this.Og.rB.du()) {
                    View viewSGo = DX.this.Og.Vgu.SGo();
                    if (viewSGo instanceof com.bytedance.sdk.openadsdk.core.ML.ZZv) {
                        ((com.bytedance.sdk.openadsdk.core.ML.ZZv) viewSGo).setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(DX.this.Og.Gx, "tt_skip_btn"));
                    }
                }
                DX.this.Sn();
                DX.this.Bzk();
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, DX.this.Bzk, DX.this.SD - DX.this.JG);
            }
        });
        if (this.pA.ZDE() != null) {
            og.pA(new com.bytedance.sdk.openadsdk.core.BSW.ML.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.DX.2
                @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.pA
                public void Og() {
                }

                @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.pA
                public String pA() {
                    return Constants.NORMAL;
                }
            });
        }
        og.pA();
        og.pA(this.Og.Vgu.SGo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sn() {
        com.bytedance.sdk.openadsdk.core.BSW.JG.pA pAVarZDE;
        com.bytedance.sdk.openadsdk.core.model.yFO yfo = this.pA;
        if (yfo == null || (pAVarZDE = yfo.ZDE()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.BSW.KZx.Og og = new com.bytedance.sdk.openadsdk.core.BSW.KZx.Og(this.Og.SzT, this.pA, pAVarZDE, this.Bzk, new com.bytedance.sdk.openadsdk.core.BSW.ML.Og() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.DX.3
            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void pA(String str) {
                DX.this.WV = SystemClock.elapsedRealtime();
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void pA(int i, String str, String str2) {
                DX.this.ML.set(false);
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, true, DX.this.Bzk, b9.f.e, SystemClock.elapsedRealtime() - DX.this.WV, str2, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.KZx
            public void Og(String str) {
                com.bytedance.sdk.openadsdk.ZZv.KZx.pA(DX.this.pA, true, DX.this.Bzk, "success", SystemClock.elapsedRealtime() - DX.this.WV, str, CampaignEx.JSON_NATIVE_VIDEO_ENDCARD, 0, null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA(int i, String str) {
                DX.this.ML.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.Og
            public void pA(com.bytedance.adsdk.ugeno.Og.KZx<View> kZx) {
                DX.this.Sn = kZx;
                DX.this.ML.set(true);
            }
        });
        og.pA(new com.bytedance.sdk.openadsdk.core.BSW.ML.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.DX.4
            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.pA
            public String pA() {
                return "overlay";
            }

            @Override // com.bytedance.sdk.openadsdk.core.BSW.ML.pA
            public void Og() {
                DX.this.oX = true;
                DX.this.Og.Vgu.SGo().performClick();
            }
        });
        og.pA();
        og.pA(this.Og.Vgu.SGo());
    }

    public boolean ZZv() {
        return this.oX;
    }

    public void pA(int i) {
        Vgu.pA((View) this.KZx, i);
    }

    public void ML() {
        this.JG = SystemClock.elapsedRealtime();
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(this.pA, this.Bzk);
    }

    public void JG() {
        this.omh = SystemClock.elapsedRealtime();
    }

    public void SD() {
        SGo();
        Bzk();
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.Wx;
        if (kZx != null) {
            this.KZx.addView(kZx.Bzk(), new FrameLayout.LayoutParams(this.Wx.rB(), this.Wx.xy()));
        }
    }

    public void omh() {
        com.bytedance.adsdk.ugeno.Og.KZx kZx = this.Sn;
        if (kZx != null) {
            this.KZx.addView(kZx.Bzk(), new FrameLayout.LayoutParams(this.Sn.rB(), this.Sn.xy()));
        }
    }

    public void Bzk() {
        if (this.omh <= 0 || this.SD <= 0 || this.SGo.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.ZZv.KZx.Og(this.SD - this.omh, this.pA, this.Bzk, this.DX);
    }

    public void SGo() {
        com.bytedance.sdk.openadsdk.ZZv.KZx.KZx(this.pA, this.Bzk);
    }

    public void BSW() {
        com.bytedance.sdk.openadsdk.ZZv.KZx.pA(SystemClock.elapsedRealtime() - this.omh, this.pA, this.Bzk);
    }

    public boolean WV() {
        return this.ZZv.get();
    }

    public boolean Wx() {
        return this.ML.get();
    }
}

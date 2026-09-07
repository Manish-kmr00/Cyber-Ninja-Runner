package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: loaded from: classes13.dex */
public class KZx {
    private TTAdDislikeToast KZx;
    private com.bytedance.sdk.openadsdk.common.DX Og;
    private final pA pA;

    public KZx(pA pAVar) {
        this.pA = pAVar;
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        if (this.pA.SzT.isFinishing()) {
            return;
        }
        if (this.pA.WV.get()) {
            this.KZx.show(TTAdDislikeToast.getDislikeTip());
            return;
        }
        if (this.Og == null) {
            try {
                Og(og);
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "RewardFullDislikeManager", th);
            }
        }
        com.bytedance.sdk.openadsdk.common.DX dx = this.Og;
        if (dx != null) {
            dx.pA();
        }
    }

    public void pA() {
        TTAdDislikeToast tTAdDislikeToast = this.KZx;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.hide();
        }
    }

    public void Og() {
        TTAdDislikeToast tTAdDislikeToast = this.KZx;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.onDestroy();
        }
    }

    private void Og(final com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        if (this.Og == null) {
            com.bytedance.sdk.openadsdk.common.DX dx = new com.bytedance.sdk.openadsdk.common.DX(this.pA.SzT, this.pA.Og);
            this.Og = dx;
            dx.setCallback(new com.bytedance.sdk.openadsdk.common.DX.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.KZx.1
                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void pA(View view) {
                    KZx.this.pA.BSW.set(true);
                    String str = "landing_page";
                    if (!com.bytedance.sdk.openadsdk.core.model.aBv.Og(KZx.this.pA.Og) && !com.bytedance.sdk.openadsdk.core.model.aBv.ZZv(KZx.this.pA.Og) && !com.bytedance.sdk.openadsdk.core.model.aBv.ML(KZx.this.pA.Og)) {
                        if (KZx.this.pA.SGo.get()) {
                            if (!WQf.Og(KZx.this.pA.Og)) {
                                if (!KZx.this.pA.Og.gbA()) {
                                    str = CampaignEx.JSON_NATIVE_VIDEO_ENDCARD;
                                }
                            } else {
                                str = "playable";
                            }
                        } else {
                            str = "video_player";
                        }
                    }
                    KZx.this.Og.setDislikeSource(str);
                    if (KZx.this.pA.BF.ML) {
                        if (KZx.this.pA.du != null) {
                            KZx.this.pA.du.pA(8, false);
                        }
                    } else {
                        og.oX();
                        if (KZx.this.pA.BF.Og()) {
                            KZx.this.pA.BF.DX();
                        }
                        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(KZx.this.pA.Og, 8);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void Og(View view) {
                    KZx.this.pA.BSW.set(false);
                    if (KZx.this.pA.BF.ML) {
                        if (KZx.this.pA.du != null) {
                            KZx.this.pA.du.pA(0, true);
                        }
                    } else {
                        KZx.this.pA.BF.pA(og);
                        if (KZx.this.pA.BF.ZZv()) {
                            KZx.this.pA.BF.Sn();
                        }
                        com.bytedance.sdk.openadsdk.BF.pA.KZx.pA(KZx.this.pA.Og, 4);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.DX.pA
                public void pA(FilterWord filterWord) {
                    if (KZx.this.pA.WV.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    KZx.this.pA.WV.set(true);
                    KZx.this.KZx();
                }
            });
            ((FrameLayout) this.pA.SzT.findViewById(R.id.content)).addView(this.Og);
        }
        if (this.KZx == null) {
            this.KZx = new TTAdDislikeToast(this.pA.SzT);
            ((FrameLayout) this.pA.SzT.findViewById(R.id.content)).addView(this.KZx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        this.KZx.show(TTAdDislikeToast.getDislikeSendTip());
    }
}

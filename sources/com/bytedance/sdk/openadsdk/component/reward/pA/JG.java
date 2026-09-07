package com.bytedance.sdk.openadsdk.component.reward.pA;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.model.WQf;
import com.bytedance.sdk.openadsdk.utils.gbA;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public class JG {
    private final pA pA;

    public JG(pA pAVar) {
        this.pA = pAVar;
    }

    public void pA(float[] fArr, final com.bytedance.sdk.openadsdk.core.Wx.ZZv.Og og, final com.bytedance.sdk.openadsdk.component.reward.Og.Og og2) {
        FrameLayout.LayoutParams layoutParams;
        Arrays.toString(fArr);
        this.pA.du.pA(new AdSlot.Builder().setCodeId(String.valueOf(this.pA.Og.Wf())).setExpressViewAcceptedSize(fArr[0], fArr[1]).build(), this.pA.Vgu.DX);
        if (this.pA.qmB != null && this.pA.du != null) {
            this.pA.qmB.pA(this.pA.du.pA());
        }
        this.pA.du.pA(new com.bytedance.sdk.openadsdk.core.omh.Sn() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.1
            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA(boolean z) {
                if (JG.this.pA.agB != z) {
                    JG.this.pA.qmB.ML();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA() {
                JG.this.pA.qmB.ZZv();
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA(String str, JSONObject jSONObject) {
                if (JG.this.pA == null || JG.this.pA.FQ == null) {
                    return;
                }
                JG.this.pA.FQ.pA(str, jSONObject);
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void Og() {
                if (JG.this.pA.Vgu == null || JG.this.pA.Vgu.SGo() == null) {
                    return;
                }
                JG.this.pA.Vgu.SGo().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA(int i) {
                if (i != 1) {
                    if (i == 2) {
                        JG.this.pA.BF.du();
                        return;
                    }
                    if (i == 3) {
                        JG.this.pA.BF.pA(og);
                        return;
                    } else if (i == 4) {
                        JG.this.pA.BF.WV();
                        return;
                    } else if (i != 5) {
                        return;
                    }
                }
                if (JG.this.pA.BF.Og() || JG.this.pA.BF.ZZv()) {
                    return;
                }
                og.pA(0L, false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public long KZx() {
                return JG.this.pA.BF.omh();
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public int ZZv() {
                if (JG.this.pA.du.KZx()) {
                    return 4;
                }
                if (JG.this.pA.du.ZZv()) {
                    return 5;
                }
                if (JG.this.pA.BF.ML()) {
                    return 1;
                }
                if (JG.this.pA.BF.Og()) {
                    return 2;
                }
                JG.this.pA.BF.ZZv();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void ML() {
                JG.this.pA.IG.pA(og2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void Og(int i) {
                JG.this.pA.dmv = i;
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA(int i, String str) {
                JG.this.pA.BF.pA(i, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.omh.Sn
            public void pA(int i, com.bytedance.sdk.component.adexpress.Og.Sn sn) {
                JG.this.pA.Vgu.pA(i, sn);
            }
        });
        this.pA.du.pA(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
            public void onAdClicked() {
                if (JG.this.pA == null || JG.this.pA.Og == null || !JG.this.pA.Og.qQU()) {
                    return;
                }
                og.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderFail(View view, String str, int i) {
                if (!JG.this.pA.Og.qH()) {
                    JG.this.pA.rB.pA(true);
                    JG.this.pA.rB.ML();
                }
                JG.this.pA.du.ML().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        og2.pA(false, false, false, 90);
                    }
                });
                JG.this.pA.Vgu.Wx();
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
            public void onRenderSuccess(View view, float f, float f2) {
                com.bytedance.sdk.openadsdk.core.model.aBv abv;
                if (WQf.XT(JG.this.pA.Og)) {
                    return;
                }
                if (!JG.this.pA.Og.qH()) {
                    if (!JG.this.pA.du.omh()) {
                        JG.this.pA.BF.ZZv(true);
                    } else {
                        og2.pA(true);
                        JG.this.pA.BF.ZZv(false);
                    }
                    JG.this.pA.Vgu.pA(8);
                    JG.this.pA.rB.pA(true);
                    JG.this.pA.rB.ML();
                    if (JG.this.pA.du.omh()) {
                        JG.this.pA.du.Og().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                        og2.pA(JG.this.pA.Vgu.JG());
                    } else if (JG.this.pA.Og.Bf() != null && og2.pA()) {
                        JG.this.pA.fJy = true;
                    }
                }
                og2.du();
                if (com.bytedance.sdk.openadsdk.core.model.aBv.KZx(JG.this.pA.Og) && (abv = JG.this.pA.Vgu.DX) != null) {
                    abv.KZx();
                }
                if (og2 instanceof com.bytedance.sdk.openadsdk.component.reward.Og.JG) {
                    com.bytedance.sdk.openadsdk.component.reward.Og.JG.pA(JG.this.pA.Og, JG.this.pA.du.omh(), JG.this.pA.ML);
                    if (!JG.this.pA.du.omh()) {
                        JG.this.pA.FQ.JG();
                    }
                }
                JG.this.pA.Vgu.Wx();
            }
        });
        com.bytedance.sdk.openadsdk.core.omh.Bzk bzk = new com.bytedance.sdk.openadsdk.core.omh.Bzk(this.pA.SzT, this.pA.Og, this.pA.ML, gbA.pA(this.pA.ML)) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.3
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                super.pA(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        bzk.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.4
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                og.c_();
            }
        });
        HashMap map = new HashMap();
        if (WQf.XT(this.pA.Og)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        if (this.pA.Itl && this.pA.RS != null) {
            map.put("ad_show_order", Integer.valueOf(this.pA.RS.Bzk + 1));
        }
        bzk.pA(map);
        com.bytedance.sdk.openadsdk.core.omh.omh omhVar = new com.bytedance.sdk.openadsdk.core.omh.omh(this.pA.SzT, this.pA.Og, this.pA.ML, gbA.pA(this.pA.ML)) { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.5
            @Override // com.bytedance.sdk.openadsdk.core.Og.pA, com.bytedance.sdk.openadsdk.core.Og.Og, com.bytedance.sdk.openadsdk.core.Og.KZx
            public void pA(View view, float f, float f2, float f3, float f4, SparseArray<com.bytedance.sdk.openadsdk.core.Og.KZx.pA> sparseArray, boolean z) {
                HashMap map2 = new HashMap();
                map2.put("duration", Long.valueOf(JG.this.pA.BF.SD()));
                pA(map2);
                super.pA(view, f, f2, f3, f4, sparseArray, z);
            }
        };
        omhVar.pA(new com.bytedance.sdk.openadsdk.core.Og.Og.pA() { // from class: com.bytedance.sdk.openadsdk.component.reward.pA.JG.6
            @Override // com.bytedance.sdk.openadsdk.core.Og.Og.pA
            public void pA(View view, int i) {
                og.c_();
            }
        });
        HashMap map2 = new HashMap();
        if (WQf.XT(this.pA.Og)) {
            map2.put("click_scence", 3);
        } else {
            map2.put("click_scence", 1);
        }
        omhVar.pA(map2);
        this.pA.du.pA(bzk, omhVar);
        if (this.pA.Og.qH() || com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(this.pA.Og.du()) || com.bytedance.sdk.openadsdk.core.model.aBv.KZx(this.pA.Og)) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams.gravity = 17;
        this.pA.Vgu.JG().addView(this.pA.du.pA(), layoutParams);
        if (!this.pA.du.omh()) {
            og2.pA(false);
        }
        this.pA.du.BSW();
    }
}

package com.bytedance.sdk.openadsdk.pA.Og.pA;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.core.omh.XT;
import com.bytedance.sdk.openadsdk.core.omh.yFO;
import com.bytedance.sdk.openadsdk.pA.Og.omh;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes5.dex */
public class KZx extends omh {
    protected String BSW;
    protected AdSlot Bzk;
    protected yFO SGo;
    private boolean WV;
    protected final Context omh;

    public KZx(Context context, com.bytedance.sdk.openadsdk.core.model.yFO yfo, AdSlot adSlot) {
        super(context, yfo, 5, true);
        this.BSW = "embeded_ad";
        this.WV = false;
        this.Og.omh(1);
        this.ZZv.pA(this);
        this.omh = context;
        this.Bzk = adSlot;
        pA();
        Og();
    }

    protected void pA() {
        this.SGo = new yFO(this.omh, this.Og, this.Bzk, this.BSW);
        KZx();
    }

    private void Og() {
        yFO yfo = this.SGo;
        if (yfo != null) {
            yfo.setBackupListener(new com.bytedance.sdk.component.adexpress.Og.KZx() { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.KZx.1
                @Override // com.bytedance.sdk.component.adexpress.Og.KZx
                public boolean pA(ViewGroup viewGroup, int i) {
                    pA pAVar = new pA(KZx.this.SGo.getContext());
                    pAVar.setExtraFuncationHelper(KZx.this.ZZv);
                    pAVar.pA(KZx.this.SGo);
                    return true;
                }
            });
        }
    }

    protected void KZx() {
        yFO yfo = this.SGo;
        if (yfo != null) {
            yfo.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.pA.Og.pA.KZx.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (!KZx.this.SGo.Wx()) {
                        KZx.this.pA(f, f2);
                        if (KZx.this.WV) {
                            KZx.this.SGo.omh();
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.pA.Og.Og og = new com.bytedance.sdk.openadsdk.pA.Og.Og(KZx.this.omh, KZx.this.Og, 5, KZx.this.Bzk, KZx.this.ZZv, KZx.this.pA);
                    KZx kZx = KZx.this;
                    if (kZx instanceof Og) {
                        og.pA(((XT) kZx.ZZv()).getVideoAdListener());
                    }
                    KZx.this.ZZv.pA((com.bytedance.sdk.openadsdk.core.Og.pA) KZx.this.SGo.getClickCreativeListener());
                    PAGMediaView pAGMediaViewBzk = KZx.this.ZZv.Bzk();
                    if (pAGMediaViewBzk == null) {
                        pAGMediaViewBzk = new PAGMediaView(KZx.this.omh);
                    }
                    KZx.this.SGo.addView(pAGMediaViewBzk);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(float f, float f2) {
        yFO yfo = this.SGo;
        if (yfo != null && com.bytedance.sdk.openadsdk.core.BSW.KZx.pA(yfo.getDynamicShowType())) {
            ViewGroup.LayoutParams layoutParams = this.SGo.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.SGo.setLayoutParams(layoutParams);
            return;
        }
        int iKZx = Vgu.KZx(this.omh, f);
        int iKZx2 = Vgu.KZx(this.omh, f2);
        ViewGroup.LayoutParams layoutParams2 = this.SGo.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(iKZx, iKZx2);
        } else {
            layoutParams2.width = iKZx;
            layoutParams2.height = iKZx2;
        }
        this.SGo.setLayoutParams(layoutParams2);
    }

    public yFO ZZv() {
        return this.SGo;
    }

    public void pA(boolean z) {
        this.WV = z;
    }

    public void ML() {
        yFO yfo = this.SGo;
        if (yfo != null) {
            yfo.Bzk();
        }
    }
}

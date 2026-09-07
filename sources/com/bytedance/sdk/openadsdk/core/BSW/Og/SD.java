package com.bytedance.sdk.openadsdk.core.BSW.Og;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.Og.DX;
import com.bytedance.sdk.component.adexpress.Og.SGo;
import com.bytedance.sdk.component.adexpress.Og.Sn;
import com.bytedance.sdk.component.adexpress.Og.Wx;
import com.bytedance.sdk.component.adexpress.Og.omh;
import com.bytedance.sdk.component.utils.WV;
import com.bytedance.sdk.openadsdk.utils.xy;
import com.vungle.ads.internal.protos.Sdk;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes9.dex */
public class SD implements SGo {
    private Wx KZx;
    private AtomicBoolean ML = new AtomicBoolean(false);
    private com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx Og;
    private ScheduledFuture<?> ZZv;
    private Context pA;

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public void pA() {
    }

    public SD(Context context, com.bytedance.sdk.openadsdk.core.BSW.ZZv.KZx kZx, omh omhVar, Wx wx) {
        this.pA = context;
        this.Og = kZx;
        this.KZx = wx;
        this.Og.pA(omhVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public boolean pA(final SGo.pA pAVar) {
        int iJG = this.KZx.JG();
        if (iJG < 0) {
            pA(pAVar, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "time is ".concat(String.valueOf(iJG)));
        } else {
            this.ZZv = xy.pA().schedule(new pA(1, pAVar), iJG, TimeUnit.MILLISECONDS);
            this.Og.pA(new com.bytedance.sdk.component.adexpress.Og.SD() { // from class: com.bytedance.sdk.openadsdk.core.BSW.Og.SD.1
                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(View view, Sn sn) {
                    SD.this.Og();
                    if (pAVar.KZx()) {
                        return;
                    }
                    com.bytedance.adsdk.ugeno.core.Sn sn2 = new com.bytedance.adsdk.ugeno.core.Sn();
                    sn2.pA(0);
                    ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA) SD.this.KZx).Mc().pA(sn2);
                    SD.this.KZx.ML().SGo();
                    DX dxOg = pAVar.Og();
                    if (dxOg == null) {
                        return;
                    }
                    dxOg.pA(SD.this.Og, sn);
                    pAVar.pA(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(int i, String str) {
                    SD.this.pA(pAVar, i, str);
                }
            });
        }
        return true;
    }

    private class pA implements Runnable {
        private int KZx;
        SGo.pA pA;

        pA(int i, SGo.pA pAVar) {
            this.KZx = i;
            this.pA = pAVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.KZx == 1) {
                SD.this.Og.pA(true);
                SD.this.pA(this.pA, Sdk.SDKError.Reason.TPAT_RETRY_FAILED_VALUE, "real time out" + SD.this.KZx.JG());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(SGo.pA pAVar, int i, String str) {
        DX dxOg;
        if (pAVar.KZx() || this.ML.get()) {
            return;
        }
        Og();
        com.bytedance.adsdk.ugeno.core.Sn sn = new com.bytedance.adsdk.ugeno.core.Sn();
        sn.pA(i);
        sn.pA(str);
        ((com.bytedance.sdk.openadsdk.core.BSW.ZZv.pA) this.KZx).Mc().pA(sn);
        if (pAVar.Og(this)) {
            pAVar.pA(this);
        } else {
            if (pAVar.KZx() || (dxOg = pAVar.Og()) == null) {
                return;
            }
            pAVar.pA(true);
            dxOg.a_(i);
        }
        this.ML.getAndSet(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ZZv;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ZZv.cancel(false);
            this.ZZv = null;
        } catch (Throwable th) {
            WV.pA("RenderInterceptor", "remove ugen time out task fail", th.getMessage());
        }
    }
}

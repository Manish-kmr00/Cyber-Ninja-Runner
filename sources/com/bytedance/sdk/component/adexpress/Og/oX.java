package com.bytedance.sdk.component.adexpress.Og;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class oX implements SGo {
    private AtomicBoolean JG = new AtomicBoolean(false);
    private omh KZx;
    private ScheduledFuture<?> ML;
    private com.bytedance.sdk.component.adexpress.ML.pA Og;
    private Wx ZZv;
    private Context pA;

    public oX(Context context, Wx wx, com.bytedance.sdk.component.adexpress.ML.pA pAVar, omh omhVar) {
        this.pA = context;
        this.ZZv = wx;
        this.KZx = omhVar;
        this.Og = pAVar;
        pAVar.pA(this.KZx);
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public boolean pA(final SGo.pA pAVar) {
        int iJG = this.ZZv.JG();
        if (iJG < 0) {
            pA(pAVar, 107, "time is ".concat(String.valueOf(iJG)));
        } else {
            this.ML = com.bytedance.sdk.component.adexpress.ZZv.ZZv.pA(new pA(1, pAVar), iJG, TimeUnit.MILLISECONDS);
            this.Og.pA(new SD() { // from class: com.bytedance.sdk.component.adexpress.Og.oX.1
                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(View view, Sn sn) {
                    DX dxOg;
                    oX.this.KZx();
                    if (pAVar.KZx() || (dxOg = pAVar.Og()) == null) {
                        return;
                    }
                    dxOg.pA(oX.this.Og, sn);
                    pAVar.pA(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.Og.SD
                public void pA(int i, String str) {
                    oX.this.pA(pAVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public void pA() {
        this.Og.ZZv();
        KZx();
    }

    public com.bytedance.sdk.component.adexpress.ML.pA Og() {
        return this.Og;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KZx() {
        try {
            ScheduledFuture<?> scheduledFuture = this.ML;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.ML.cancel(false);
            this.ML = null;
        } catch (Throwable unused) {
        }
    }

    private class pA implements Runnable {
        private int KZx;
        SGo.pA pA;

        public pA(int i, SGo.pA pAVar) {
            this.KZx = i;
            this.pA = pAVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.KZx == 1) {
                oX.this.Og.pA(true);
                oX.this.pA(this.pA, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pA(SGo.pA pAVar, int i, String str) {
        DX dxOg;
        if (pAVar.KZx() || this.JG.get()) {
            return;
        }
        KZx();
        this.ZZv.ML().pA(i, str);
        if (pAVar.Og(this)) {
            pAVar.pA(this);
        } else {
            if (pAVar.KZx() || (dxOg = pAVar.Og()) == null) {
                return;
            }
            pAVar.pA(true);
            dxOg.a_(i);
        }
        this.JG.getAndSet(true);
    }
}

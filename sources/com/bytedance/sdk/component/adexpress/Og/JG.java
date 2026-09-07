package com.bytedance.sdk.component.adexpress.Og;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public class JG implements SGo {
    private Wx KZx;
    private pA Og;
    private Context pA;

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public void pA() {
    }

    public JG(Context context, Wx wx, pA pAVar) {
        this.pA = context;
        this.Og = pAVar;
        this.KZx = wx;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public boolean pA(final SGo.pA pAVar) {
        this.KZx.ML().JG();
        this.Og.pA(new SD() { // from class: com.bytedance.sdk.component.adexpress.Og.JG.1
            @Override // com.bytedance.sdk.component.adexpress.Og.SD
            public void pA(View view, Sn sn) {
                if (pAVar.KZx()) {
                    return;
                }
                DX dxOg = pAVar.Og();
                if (dxOg != null) {
                    dxOg.pA(JG.this.Og, sn);
                }
                pAVar.pA(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.Og.SD
            public void pA(int i, String str) {
                DX dxOg = pAVar.Og();
                if (dxOg != null) {
                    dxOg.a_(i);
                }
            }
        });
        return true;
    }

    public void pA(KZx kZx) {
        this.Og.pA(kZx);
    }
}

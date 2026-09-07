package com.bytedance.sdk.component.adexpress.Og;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* JADX INFO: loaded from: classes.dex */
public class Og implements SGo {
    private int JG;
    private ThemeStatusBroadcastReceiver KZx;
    private Wx ML;
    private com.bytedance.sdk.component.adexpress.dynamic.pA.pA Og;
    private omh ZZv;
    private Context pA;

    public Og(Context context, Wx wx, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.ML.omh omhVar, omh omhVar2, com.bytedance.sdk.component.adexpress.dynamic.JG.pA pAVar, com.bytedance.sdk.component.adexpress.dynamic.pA.pA pAVar2) {
        this.pA = context;
        this.ML = wx;
        this.KZx = themeStatusBroadcastReceiver;
        this.ZZv = omhVar2;
        if (pAVar2 != null) {
            this.Og = pAVar2;
        } else {
            this.Og = new com.bytedance.sdk.component.adexpress.dynamic.pA.pA(this.pA, this.KZx, z, omhVar, this.ML, pAVar);
        }
        this.Og.pA(this.ZZv);
        if (omhVar instanceof com.bytedance.sdk.component.adexpress.dynamic.ML.SD) {
            this.JG = 3;
        } else {
            this.JG = 2;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public boolean pA(final SGo.pA pAVar) {
        this.ML.ML().pA(this.JG);
        this.Og.pA(new SD() { // from class: com.bytedance.sdk.component.adexpress.Og.Og.1
            @Override // com.bytedance.sdk.component.adexpress.Og.SD
            public void pA(View view, Sn sn) {
                if (pAVar.KZx()) {
                    return;
                }
                Og.this.ML.ML().ML(Og.this.JG);
                Og.this.ML.ML().JG(Og.this.JG);
                Og.this.ML.ML().SGo();
                DX dxOg = pAVar.Og();
                if (dxOg == null) {
                    return;
                }
                dxOg.pA(Og.this.Og, sn);
                pAVar.pA(true);
            }

            @Override // com.bytedance.sdk.component.adexpress.Og.SD
            public void pA(int i, String str) {
                Og.this.ML.ML().pA(Og.this.JG, i, str, pAVar.Og(Og.this));
                if (pAVar.Og(Og.this)) {
                    pAVar.pA(Og.this);
                    return;
                }
                DX dxOg = pAVar.Og();
                if (dxOg == null) {
                    return;
                }
                dxOg.a_(i);
            }
        });
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.SGo
    public void pA() {
        com.bytedance.sdk.component.adexpress.dynamic.pA.pA pAVar = this.Og;
        if (pAVar != null) {
            pAVar.Og();
        }
    }

    public com.bytedance.sdk.component.adexpress.dynamic.ZZv Og() {
        com.bytedance.sdk.component.adexpress.dynamic.pA.pA pAVar = this.Og;
        if (pAVar != null) {
            return pAVar.ZZv();
        }
        return null;
    }
}

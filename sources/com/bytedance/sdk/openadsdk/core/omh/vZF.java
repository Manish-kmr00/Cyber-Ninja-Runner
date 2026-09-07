package com.bytedance.sdk.openadsdk.core.omh;

import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.xy;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class vZF extends com.bytedance.sdk.component.adexpress.Og.pA<pA> {
    private final com.bytedance.sdk.component.adexpress.Og.Wx JG;
    private final View KZx;
    private com.bytedance.sdk.component.adexpress.Og.SD ML;
    private pA Og;
    private com.bytedance.sdk.component.adexpress.Og.KZx ZZv;
    AtomicBoolean pA = new AtomicBoolean(false);

    public vZF(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.Og.Wx wx) {
        this.KZx = view;
        this.JG = wx;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(com.bytedance.sdk.component.adexpress.Og.SD sd) {
        this.ML = sd;
        xy.pA(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.vZF.1
            @Override // java.lang.Runnable
            public void run() {
                vZF.this.Og();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Og() {
        if (this.pA.get()) {
            return;
        }
        com.bytedance.sdk.component.adexpress.Og.KZx kZx = this.ZZv;
        if (kZx == null || !kZx.pA((yFO) this.KZx, 0)) {
            this.ML.pA(107, "backup false");
            return;
        }
        this.JG.ML().SD();
        pA pAVar = (pA) this.KZx.findViewWithTag("tt_express_backup_fl_tag_26");
        this.Og = pAVar;
        if (pAVar != null) {
            com.bytedance.sdk.component.adexpress.Og.Sn sn = new com.bytedance.sdk.component.adexpress.Og.Sn();
            pA pAVar2 = this.Og;
            float realWidth = pAVar2 == null ? 0.0f : pAVar2.getRealWidth();
            pA pAVar3 = this.Og;
            float realHeight = pAVar3 != null ? pAVar3.getRealHeight() : 0.0f;
            sn.pA(true);
            sn.pA(realWidth);
            sn.Og(realHeight);
            this.ML.pA(this.Og, sn);
            return;
        }
        this.ML.pA(107, "backupview is null");
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.ZZv
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public pA ML() {
        return this.Og;
    }

    @Override // com.bytedance.sdk.component.adexpress.Og.pA
    public void pA(com.bytedance.sdk.component.adexpress.Og.KZx kZx) {
        this.ZZv = kZx;
    }
}

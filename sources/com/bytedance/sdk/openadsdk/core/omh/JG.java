package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.utils.xy;

/* JADX INFO: loaded from: classes10.dex */
public class JG extends com.bytedance.sdk.component.adexpress.dynamic.pA.pA {
    private final com.bytedance.sdk.component.omh.omh KZx;
    private com.bytedance.sdk.component.adexpress.Og.SD Og;
    private final Runnable ZZv;
    private final com.bytedance.sdk.component.adexpress.Og.Wx pA;

    public JG(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, com.bytedance.sdk.component.adexpress.dynamic.ML.omh omhVar, com.bytedance.sdk.component.adexpress.Og.Wx wx, com.bytedance.sdk.component.adexpress.dynamic.JG.pA pAVar) {
        super(context, themeStatusBroadcastReceiver, z, omhVar, wx, pAVar);
        this.KZx = new com.bytedance.sdk.component.omh.omh("dynamic_render_template") { // from class: com.bytedance.sdk.openadsdk.core.omh.JG.1
            @Override // java.lang.Runnable
            public void run() {
                JG.this.pA.KZx();
                com.bytedance.sdk.openadsdk.core.Sn.KZx().post(JG.this.ZZv);
            }
        };
        this.ZZv = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.omh.JG.2
            @Override // java.lang.Runnable
            public void run() {
                if (JG.this.Og != null) {
                    JG jg = JG.this;
                    JG.super.pA(jg.Og);
                }
            }
        };
        this.pA = wx;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pA.pA, com.bytedance.sdk.component.adexpress.Og.ZZv
    public void pA(com.bytedance.sdk.component.adexpress.Og.SD sd) {
        this.Og = sd;
        xy.Og(this.KZx);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.pA.pA
    public void Og() {
        super.Og();
        com.bytedance.sdk.openadsdk.core.Sn.KZx().removeCallbacks(this.ZZv);
    }
}

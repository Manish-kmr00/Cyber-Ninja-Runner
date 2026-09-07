package com.bytedance.sdk.openadsdk.yFO.pA;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.WV.ML;
import com.bytedance.sdk.openadsdk.core.model.yFO;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes9.dex */
public class Og extends pA {
    private String JG;
    private ML KZx;
    private FrameLayout ML;
    private volatile boolean Og;
    private final FrameLayout ZZv;

    public Og(Context context, yFO yfo, int i, boolean z, FrameLayout frameLayout, String str) {
        super(context, yfo, i, z, frameLayout);
        this.ZZv = frameLayout;
        this.JG = str;
        Og(false);
        int iKZx = Vgu.KZx(context);
        int iZZv = Vgu.ZZv(context);
        if (i == 1) {
            if (iKZx <= iZZv) {
                this.pA.layout(0, 0, iKZx, iZZv);
                return;
            }
        } else {
            if (i != 2) {
                return;
            }
            if (iKZx > iZZv) {
                this.pA.layout(0, 0, iKZx, iZZv);
                return;
            }
        }
        this.pA.layout(0, 0, iZZv, iKZx);
    }

    public void SD() {
        super.pA(true, new ML() { // from class: com.bytedance.sdk.openadsdk.yFO.pA.Og.1
            @Override // com.bytedance.sdk.openadsdk.WV.ML
            public void pA() {
                if (Og.this.KZx != null) {
                    Og.this.KZx.pA();
                } else {
                    Og.this.Og = true;
                }
            }
        });
    }

    public void pA(FrameLayout frameLayout, ML ml) {
        this.ML = frameLayout;
        frameLayout.addView(this.ZZv);
        this.KZx = ml;
        if (this.Og) {
            this.KZx.pA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.yFO.pA.pA
    public void pA() {
        this.ML.setVisibility(0);
        super.pA();
    }

    public String omh() {
        return this.JG;
    }
}

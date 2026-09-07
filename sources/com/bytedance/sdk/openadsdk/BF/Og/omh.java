package com.bytedance.sdk.openadsdk.BF.Og;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes10.dex */
public class omh extends Og {
    private int ZZv;

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    public int JG() {
        return 200;
    }

    public omh(Integer num, View view, yFO yfo, ML.pA pAVar) {
        super(num, view, yfo, 2000, pAVar);
        this.ZZv = 0;
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected boolean KZx() {
        return JG.pA(this.pA.get(), this.Og.FHA()) && this.ZZv == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected void ZZv() {
        super.ZZv();
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    public void pA() {
        if (this.ZZv != 1) {
            return;
        }
        super.pA();
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected void Og(int i) {
        if (Bzk()) {
            return;
        }
        if (i == 6 || i == 5) {
            this.ZZv = 0;
            omh();
        }
        if (i == 3 || i == 2) {
            this.ZZv = 2;
            omh();
        }
        if (this.ZZv == 1 || i != 0) {
            return;
        }
        this.ZZv = 1;
        pA();
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    public boolean WV() {
        int i = this.ZZv;
        boolean z = i == 2 || i == 0;
        if (z) {
            this.KZx.set(false);
        }
        return !z || super.WV();
    }
}

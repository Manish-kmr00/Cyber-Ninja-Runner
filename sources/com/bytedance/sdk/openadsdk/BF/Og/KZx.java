package com.bytedance.sdk.openadsdk.BF.Og;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.model.yFO;

/* JADX INFO: loaded from: classes6.dex */
public class KZx extends Og {
    private int ZZv;

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    public int JG() {
        return 100;
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected void Og(int i) {
    }

    public KZx(Integer num, View view, yFO yfo, ML.pA pAVar) {
        super(num, view, yfo, 1000, pAVar);
        this.ZZv = -1;
        Og(view);
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected boolean KZx() {
        if (this.pA == null || this.pA.get() == null) {
            return false;
        }
        View view = this.pA.get();
        if (this.ZZv == -1) {
            Og(view);
        }
        return JG.pA(view, this.ZZv == 1, this.Og.FHA());
    }

    private void Og(View view) {
        if (view != null) {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            this.ZZv = width * height >= 242500 ? 1 : 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.BF.Og.Og
    protected void ZZv() {
        super.ZZv();
    }
}

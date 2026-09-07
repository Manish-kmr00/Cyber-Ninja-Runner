package com.bytedance.sdk.openadsdk.core.BSW.Og;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;

/* JADX INFO: loaded from: classes13.dex */
public class ML extends com.bytedance.adsdk.ugeno.Og.KZx<FrameLayout> {
    public ML(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public FrameLayout ZZv() {
        FrameLayout frameLayout = new FrameLayout(this.ML);
        frameLayout.addView(new PAGLogoView(this.ML));
        return frameLayout;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
    }
}

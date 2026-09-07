package com.bytedance.sdk.openadsdk.core.BSW.Og;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes13.dex */
public class KZx extends com.bytedance.adsdk.ugeno.Og.KZx<com.bytedance.sdk.openadsdk.core.widget.ML> {
    protected ImageView.ScaleType Og;
    protected String pA;

    public KZx(Context context) {
        super(context);
        this.Og = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    /* JADX INFO: renamed from: pA, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.openadsdk.core.widget.ML ZZv() {
        this.omh = new com.bytedance.sdk.openadsdk.core.widget.ML(this.ML);
        return (com.bytedance.sdk.openadsdk.core.widget.ML) this.omh;
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void Og() {
        super.Og();
        KZx();
        ((com.bytedance.sdk.openadsdk.core.widget.ML) this.omh).setScaleType(this.Og);
    }

    private void KZx() {
        if (TextUtils.isEmpty(this.pA)) {
            return;
        }
        if (this.pA.startsWith("local://")) {
            ((com.bytedance.sdk.openadsdk.core.widget.ML) this.omh).pA(com.bytedance.adsdk.ugeno.SD.ZZv.pA(this.ML, this.pA.replace("local://", "")), false);
        } else {
            com.bytedance.adsdk.ugeno.ZZv.pA().Og().pA(this.WV, this.pA, (ImageView) this.omh);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Og.KZx
    public void pA(String str, String str2) {
        super.pA(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.Og = SD(str2);
        } else if (str.equals("src")) {
            this.pA = str2;
        }
    }

    private ImageView.ScaleType SD(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }
}

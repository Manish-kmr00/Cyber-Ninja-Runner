package com.bytedance.sdk.openadsdk.component.Bzk;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aBv;
import com.bytedance.sdk.openadsdk.core.widget.oX;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes13.dex */
public abstract class KZx extends com.bytedance.sdk.openadsdk.core.ML.SD {
    com.bytedance.sdk.openadsdk.core.ML.omh BSW;
    aBv Bzk;
    aBv JG;
    com.bytedance.sdk.openadsdk.core.ML.ZZv KZx;
    com.bytedance.sdk.openadsdk.core.ML.omh ML;
    com.bytedance.sdk.openadsdk.core.ML.KZx Og;
    com.bytedance.sdk.openadsdk.core.ML.omh SD;
    com.bytedance.sdk.openadsdk.core.ML.omh SGo;
    com.bytedance.sdk.openadsdk.core.widget.KZx WV;
    PAGLogoView ZZv;
    final SD omh;
    com.bytedance.sdk.openadsdk.core.ML.ZZv pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public abstract com.bytedance.sdk.openadsdk.core.ML.ZZv getAdIconView();

    public abstract com.bytedance.sdk.openadsdk.core.ML.omh getAdTitleTextView();

    public com.bytedance.sdk.openadsdk.core.ML.ML getOverlayLayout() {
        return null;
    }

    public abstract oX getScoreBar();

    public abstract View getUserInfo();

    @Override // com.bytedance.sdk.openadsdk.core.ML.SD, android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public KZx(Context context) {
        super(context);
        this.omh = new SD(context);
    }

    public aBv getIconOnlyView() {
        return this.Bzk;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getTitle() {
        return this.SGo;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getContent() {
        return this.BSW;
    }

    public com.bytedance.sdk.openadsdk.core.ML.ZZv getBackImage() {
        return this.pA;
    }

    public com.bytedance.sdk.openadsdk.core.ML.KZx getVideoContainer() {
        return this.Og;
    }

    public com.bytedance.sdk.openadsdk.core.ML.ZZv getImageView() {
        return this.KZx;
    }

    public PAGLogoView getAdLogo() {
        return this.ZZv;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getClickButton() {
        return this.ML;
    }

    public aBv getHostAppIcon() {
        return this.JG;
    }

    public com.bytedance.sdk.openadsdk.core.ML.omh getHostAppName() {
        return this.SD;
    }

    public com.bytedance.sdk.openadsdk.core.widget.KZx getDspAdChoice() {
        return this.WV;
    }

    public View getTopDisLike() {
        SD sd = this.omh;
        if (sd != null) {
            return sd.getTopDislike();
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.core.ML.ZZv getTopSkip() {
        SD sd = this.omh;
        if (sd != null) {
            return sd.getTopSkip();
        }
        return null;
    }
}

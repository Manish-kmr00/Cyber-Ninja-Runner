package com.bytedance.sdk.openadsdk.component.reward.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes7.dex */
public class SD extends com.bytedance.sdk.openadsdk.core.ML.KZx {
    private final com.bytedance.sdk.openadsdk.component.reward.pA.pA pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.KZx, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(com.bytedance.sdk.openadsdk.component.reward.pA.pA pAVar) {
        super(pAVar.Gx);
        this.pA = pAVar;
        if (pAVar.RS != null || Build.VERSION.SDK_INT < 35) {
            return;
        }
        setFitsSystemWindows(true);
    }

    public void pA(com.bytedance.sdk.openadsdk.component.reward.Og.Og og) {
        RFEndCardBackUpLayout rFEndCardBackUpLayoutOmh;
        og.pA(this);
        if (this.pA.pA != 1 && (rFEndCardBackUpLayoutOmh = og.omh()) != null) {
            addView(rFEndCardBackUpLayoutOmh, new FrameLayout.LayoutParams(-1, -1));
        }
        pA(og.Bzk(), this);
        pA(og.SGo(), this);
    }

    private void pA(View view, ViewGroup viewGroup) {
        if (view != null) {
            viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}

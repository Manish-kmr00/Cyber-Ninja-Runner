package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes11.dex */
public class SD extends com.bytedance.sdk.openadsdk.core.ML.ZZv {
    private int Og;
    private float pA;

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(Context context) {
        super(context);
        this.pA = 2.25f;
        this.Og = 12;
        pA();
    }

    public SD(Context context, int i, float f) {
        super(context);
        this.pA = f;
        this.Og = i;
        pA();
    }

    private void pA() {
        setBackground(ZZv.pA());
        setImageResource(com.bytedance.sdk.component.utils.yFO.ZZv(getContext(), "tt_close_btn"));
        int iKZx = Vgu.KZx(getContext(), this.pA);
        setPadding(iKZx, iKZx, iKZx, iKZx);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ML.ZZv, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            int iKZx = Vgu.KZx(getContext(), this.Og);
            layoutParams.width = iKZx;
            layoutParams.height = iKZx;
        }
        super.setLayoutParams(layoutParams);
    }

    public static com.bytedance.sdk.openadsdk.core.ML.ZZv pA(Context context) {
        return new SD(context);
    }

    public static com.bytedance.sdk.openadsdk.core.ML.ZZv Og(Context context) {
        return new SD(context, 28, 5.0f);
    }
}

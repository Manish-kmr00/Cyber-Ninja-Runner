package com.bytedance.sdk.openadsdk.KZx;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class SD extends LinearLayout {
    private final SGo KZx;
    private omh Og;
    private final FilterWord pA;

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            CreativeInfoManager.viewOnMeasure(h.u, this, widthMeasureSpec, heightMeasureSpec);
        }
    }

    public SD(Context context, FilterWord filterWord, SGo sGo) {
        super(context);
        setOrientation(1);
        this.pA = filterWord;
        this.KZx = sGo;
        pA();
    }

    private void pA() {
        KZx();
        Og();
    }

    private void Og() {
        this.Og = new omh(getContext(), this.KZx);
        new LinearLayout.LayoutParams(-1, -2);
        this.Og.pA(this.pA.getOptions());
        addView(this.Og);
    }

    private void KZx() {
        String name = this.pA.getName();
        com.bytedance.sdk.openadsdk.core.ML.omh omhVar = new com.bytedance.sdk.openadsdk.core.ML.omh(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = Vgu.KZx(getContext(), 12.0f);
        layoutParams.gravity = 17;
        omhVar.setGravity(17);
        omhVar.setText(name);
        omhVar.setTextColor(Color.argb(85, 22, 24, 35));
        omhVar.setTextSize(this.KZx.Bzk() ? 14 : 10);
        addView(omhVar, layoutParams);
    }
}

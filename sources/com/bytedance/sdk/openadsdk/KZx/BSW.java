package com.bytedance.sdk.openadsdk.KZx;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes.dex */
public class BSW extends View {
    private final int pA;

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.u, this, me);
        return super.dispatchTouchEvent(me);
    }

    public BSW(Context context) {
        this(context, Color.parseColor("#25000000"));
    }

    public BSW(Context context, int i) {
        super(context);
        setBackgroundColor(i);
        this.pA = Vgu.KZx(getContext(), 0.66f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), this.pA);
    }
}

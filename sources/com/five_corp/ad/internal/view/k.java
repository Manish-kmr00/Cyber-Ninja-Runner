package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class k extends FrameLayout implements com.five_corp.ad.internal.layouter.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.cache.b f1574a;

    public k(Context context, com.five_corp.ad.internal.cache.f fVar, com.five_corp.ad.internal.ad.custom_layout.j jVar) {
        super(context);
        com.five_corp.ad.internal.cache.b bVarA = fVar.a(context, jVar.b);
        com.five_corp.ad.internal.cache.b bVarA2 = fVar.a(context, jVar.f1283a);
        this.f1574a = bVarA2;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        bVarA.setScaleType(scaleType);
        bVarA2.setScaleType(scaleType);
        addView(bVarA, new FrameLayout.LayoutParams(-1, -1));
        addView(bVarA2, new FrameLayout.LayoutParams(0, -1));
    }

    @Override // com.five_corp.ad.internal.layouter.k
    public final void a(com.five_corp.ad.internal.layouter.h hVar) {
        ViewGroup.LayoutParams layoutParams = this.f1574a.getLayoutParams();
        layoutParams.width = (int) (getWidth() * hVar.d);
        this.f1574a.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

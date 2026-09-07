package com.five_corp.ad.internal.cache;

import android.content.Context;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1337a;
    public final com.five_corp.ad.internal.ad.s b;

    public b(Context context, f fVar, com.five_corp.ad.internal.ad.s sVar) {
        super(context);
        this.f1337a = fVar;
        this.b = sVar;
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes10.dex */
public class MBLogoTextView extends MBTextView {
    public MBLogoTextView(Context context) {
        super(context);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // com.mbridge.msdk.dycreator.baseview.MBTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public MBLogoTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MBLogoTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}

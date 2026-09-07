package com.mbridge.msdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes12.dex */
public class FeedbackRadioGroup extends RadioGroup {
    public FeedbackRadioGroup(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.o, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Logger.d("Mintegral|SafeDK: Execution> Lcom/mbridge/msdk/widget/FeedbackRadioGroup;->onLayout(ZIIII)V");
        safedk_FeedbackRadioGroup_onLayout_7883610c66cd8de959c7c07045d65d0c(z, i, i2, i3, i4);
        CreativeInfoManager.onFeedbackPopup(h.o);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int iMax;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        measureChildren(i, i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int iMax2 = 0;
        int i5 = 0;
        int iMax3 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i6 = i5 + measuredWidth;
            if (getPaddingLeft() + i6 + getPaddingRight() > size) {
                iMax = Math.max(i5, iMax2);
                i4 += iMax3;
                iMax3 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                Log.v("FeedbackRadioGroup", "maxHeight:" + i4 + "---maxWidth:" + iMax);
            } else {
                iMax3 = Math.max(iMax3, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                measuredWidth = i6;
                iMax = iMax2;
            }
            if (i3 == childCount - 1) {
                i4 += iMax3;
                iMax2 = Math.max(measuredWidth, iMax2);
            } else {
                iMax2 = iMax;
            }
            i3++;
            i5 = measuredWidth;
        }
        int paddingLeft = iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = i4 + getPaddingTop() + getPaddingBottom();
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    protected void safedk_FeedbackRadioGroup_onLayout_7883610c66cd8de959c7c07045d65d0c(boolean p0, int p1, int p2, int p3, int p4) {
        int childCount = getChildCount();
        int p5 = getPaddingLeft();
        int p6 = getPaddingTop();
        int iMax = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams.leftMargin + p5 + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin + getPaddingRight() > p3 - p1) {
                p5 = getPaddingLeft();
                p6 += iMax;
                iMax = getChildAt(i).getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            } else {
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            }
            int i2 = marginLayoutParams.leftMargin + p5;
            int i3 = marginLayoutParams.topMargin + p6;
            childAt.layout(i2, i3, childAt.getMeasuredWidth() + i2, childAt.getMeasuredHeight() + i3);
            p5 += marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
    }

    public FeedbackRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

package io.bidmachine.rendering.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import io.bidmachine.rendering.model.ElementLayoutParams;
import io.bidmachine.rendering.model.SideBindParams;
import io.bidmachine.rendering.model.SideType;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class e extends RelativeLayout {

    public static class a extends RelativeLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12380a;
        private final int b;
        private float c;
        private float d;

        public a(int i, int i2) {
            super(i, i2);
            this.c = 1.0f;
            this.d = 1.0f;
            this.f12380a = i;
            this.b = i2;
        }

        private boolean a(SideBindParams sideBindParams, SideBindParams sideBindParams2, int i, int i2) {
            if (i2 <= 0 || sideBindParams == null || sideBindParams2 == null) {
                return false;
            }
            addRule(i);
            return true;
        }

        private void b(SideBindParams sideBindParams, SideBindParams sideBindParams2, List list) {
            a(sideBindParams, SideType.Top, 6, 3, 10, list);
            a(sideBindParams2, SideType.Bottom, 8, 2, 12, list);
        }

        private void a(SideBindParams sideBindParams, SideBindParams sideBindParams2, List list) {
            a(sideBindParams, SideType.Left, 5, 1, 9, list);
            a(sideBindParams2, SideType.Right, 7, 0, 11, list);
        }

        public void b(float f) {
            this.c = f;
        }

        private void a(SideBindParams sideBindParams, SideType sideType, int i, int i2, int i3, List list) {
            if (sideBindParams == null) {
                return;
            }
            View viewA = io.bidmachine.rendering.internal.e.a(list, sideBindParams.getTargetName());
            if (viewA == null) {
                addRule(i3);
                return;
            }
            if (sideBindParams.getTargetSideType() != sideType) {
                i = i2;
            }
            addRule(i, viewA.getId());
        }

        public void a(float f) {
            this.d = f;
        }

        public void a(Context context, ElementLayoutParams elementLayoutParams, List list) {
            b(elementLayoutParams.getWidthPercent());
            a(elementLayoutParams.getHeightPercent());
            setMargins(elementLayoutParams.getMarginLeftPx(context), elementLayoutParams.getMarginTopPx(context), -elementLayoutParams.getMarginRightPx(context), -elementLayoutParams.getMarginBottomPx(context));
            SideBindParams topSideBindParams = elementLayoutParams.getTopSideBindParams();
            SideBindParams bottomSideBindParams = elementLayoutParams.getBottomSideBindParams();
            if (!a(topSideBindParams, bottomSideBindParams, 15, elementLayoutParams.getWidthPx(context))) {
                b(topSideBindParams, bottomSideBindParams, list);
            }
            SideBindParams leftSideBindParams = elementLayoutParams.getLeftSideBindParams();
            SideBindParams rightSideBindParams = elementLayoutParams.getRightSideBindParams();
            if (a(leftSideBindParams, rightSideBindParams, 14, elementLayoutParams.getHeightPx(context))) {
                return;
            }
            a(leftSideBindParams, rightSideBindParams, list);
        }
    }

    public e(Context context) {
        super(context);
    }

    void a(int i, int i2) {
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams instanceof a) {
                a(size, size2, childAt, (a) layoutParams);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("io.bidmachine", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        a(i, i2);
        super.onMeasure(i, i2);
    }

    private void a(int i, int i2, View view, a aVar) {
        Integer numA;
        Integer numA2;
        float f = aVar.c;
        if (f > 0.0f && f < 1.0f && (numA2 = a(aVar.f12380a, i, view.getMeasuredWidth(), f)) != null) {
            ((RelativeLayout.LayoutParams) aVar).width = numA2.intValue();
        }
        float f2 = aVar.d;
        if (f2 <= 0.0f || f2 >= 1.0f || (numA = a(aVar.b, i2, view.getMeasuredHeight(), f2)) == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) aVar).height = numA.intValue();
    }

    Integer a(int i, int i2, int i3, float f) {
        if (i <= 0) {
            if (i == -1) {
                i = i2;
            } else {
                if (i != -2 || i3 == 0) {
                    return null;
                }
                i = i3;
            }
        }
        if (i == 0) {
            return null;
        }
        return Integer.valueOf(Math.round(i * f));
    }
}

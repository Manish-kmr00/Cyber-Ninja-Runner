package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public class WrapContentViewFlow extends ViewFlow {
    public WrapContentViewFlow(Context context) {
        this(context, null);
    }

    public WrapContentViewFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // sg.bigo.ads.common.view.ViewFlow, android.view.View
    protected void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(Integer.MIN_VALUE, i);
        int defaultSize2 = getDefaultSize(Integer.MIN_VALUE, i2);
        this.j = Math.min(defaultSize / 10, this.i);
        this.f13327a = Math.min(Math.max(0, this.f13327a), this.b - 1);
        int i3 = defaultSize - (this.d * 2);
        int childCount = getChildCount();
        int iMax = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                if (childAt == this.e || childAt == this.f) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 0), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
                } else {
                    ViewFlow.b bVar = (ViewFlow.b) childAt.getLayoutParams();
                    if (bVar != null) {
                        int i5 = bVar.width;
                        childAt.measure(i5 != -2 ? i5 != -1 ? View.MeasureSpec.makeMeasureSpec(bVar.width, 1073741824) : View.MeasureSpec.makeMeasureSpec(i3, 1073741824) : getChildMeasureSpec(i, this.d * 2, bVar.width), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 0));
                        iMax = Math.max(iMax, childAt.getMeasuredHeight());
                    }
                }
            }
        }
        setMeasuredDimension(defaultSize, Math.min(iMax, defaultSize2));
    }
}

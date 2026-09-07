package sg.bigo.ads.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
public class AutoNextLineLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13311a;
    int b;
    int c;
    int d;
    Hashtable e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13312a;
        int b;
        int c;
        int d;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public AutoNextLineLinearLayout(Context context) {
        super(context);
        this.e = new Hashtable();
    }

    public AutoNextLineLinearLayout(Context context, int i, int i2) {
        super(context);
        this.e = new Hashtable();
    }

    public AutoNextLineLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Hashtable();
    }

    private int a(int i, int i2) {
        if (i <= 0) {
            return getPaddingLeft();
        }
        int i3 = i2 - 1;
        return a(i - 1, i3) + getChildAt(i3).getMeasuredWidth() + 30;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LinearLayout.LayoutParams(0, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            a aVar = (a) this.e.get(childAt);
            if (aVar != null) {
                childAt.layout(aVar.f13312a, aVar.b, aVar.c, aVar.d);
            } else {
                Log.i("MyLayout", "error");
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int childCount = getChildCount();
        byte b = 0;
        this.f13311a = 0;
        this.b = 0;
        this.c = 5;
        this.d = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            childAt.measure(0, 0);
            int measuredWidth = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight();
            i3 += measuredWidth;
            a aVar = new a(b);
            int iA = a(i6 - i4, i6);
            this.f13311a = iA;
            this.b = iA + childAt.getMeasuredWidth();
            if (i3 >= size) {
                this.f13311a = 0;
                this.b = childAt.getMeasuredWidth();
                this.c = i5 + measuredHeight + layoutParams.topMargin;
                i4 = i6;
                i3 = measuredWidth;
            }
            this.d = this.c + childAt.getMeasuredHeight() + layoutParams.bottomMargin;
            i5 = this.c;
            aVar.f13312a = this.f13311a;
            aVar.b = this.c + 3;
            aVar.c = this.b;
            aVar.d = this.d;
            this.e.put(childAt, aVar);
        }
        setMeasuredDimension(size, this.d);
    }
}

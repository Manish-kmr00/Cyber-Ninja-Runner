package sg.bigo.ads.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes11.dex */
public class MaxWidthMediaView extends MediaView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13086a;

    public MaxWidthMediaView(Context context) {
        super(context);
    }

    public MaxWidthMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxWidthMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.f13086a;
        if (i3 > 0 && size > i3) {
            i = View.MeasureSpec.makeMeasureSpec(this.f13086a, View.MeasureSpec.getMode(i));
        }
        super.onMeasure(i, i2);
    }

    public void setMaxWidth(int i) {
        this.f13086a = i;
    }
}

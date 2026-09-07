package sg.bigo.ads.ad.interstitial.e.b;

import android.content.Context;
import android.view.View;
import sg.bigo.ads.ad.interstitial.e.d;
import sg.bigo.ads.ad.interstitial.e.j;
import sg.bigo.ads.common.view.RealtimeBlurLinearLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends RealtimeBlurLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f12797a;

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        this(context, (char) 0);
    }

    private a(Context context, char c) {
        super(context, null, 0);
    }

    public final d getIconAdsRenderStyle() {
        return this.f12797a;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        d dVar = this.f12797a;
        if ((dVar instanceof j) && dVar.b() == 4) {
            int defaultSize = getDefaultSize(Integer.MIN_VALUE, i);
            int i3 = ((j) this.f12797a).i;
            int i4 = (int) ((i3 * 2) + (((defaultSize - (i3 * 3.0f)) / 4.0f) * 3.0f));
            setMeasuredDimension(i4, getMeasuredHeight());
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                measureChildWithMargins(getChildAt(i5), iMakeMeasureSpec, 0, i2, 0);
            }
        }
    }
}

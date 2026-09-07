package com.five_corp.ad.internal.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.viewability.a f1575a;
    public final com.five_corp.ad.internal.layouter.e b;

    public l(Context context, com.five_corp.ad.internal.logger.a aVar, G g, com.five_corp.ad.internal.layouter.d dVar, com.five_corp.ad.internal.context.l lVar, String str, com.five_corp.ad.internal.viewability.a aVar2, com.five_corp.ad.internal.ad.custom_layout.d dVar2, com.five_corp.ad.internal.layouter.j jVar) {
        super(context);
        this.f1575a = aVar2;
        this.b = new com.five_corp.ad.internal.layouter.e(this, context, aVar, g, dVar, lVar, str, aVar2, dVar2, jVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    public com.five_corp.ad.internal.ad.custom_layout.d getCustomLayoutConfig() {
        return this.b.g;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        com.five_corp.ad.internal.layouter.e eVar = this.b;
        eVar.getClass();
        try {
            if (eVar.i != i || eVar.j != i2) {
                eVar.i = i;
                eVar.j = i2;
                eVar.a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
            }
        } catch (Exception e) {
            eVar.d.a(e);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.five_corp.ad.internal.viewability.a aVar = this.f1575a;
        synchronized (aVar.g) {
            aVar.h = z;
        }
    }
}

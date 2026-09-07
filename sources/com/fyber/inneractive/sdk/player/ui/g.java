package com.fyber.inneractive.sdk.player.ui;

import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import com.fyber.inneractive.sdk.util.AbstractC3256u;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes13.dex */
public final class g extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f2236a;

    public g(t tVar) {
        super(tVar.getContext());
        this.f2236a = new WeakReference(tVar);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(com.safedk.android.utils.h.p, this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        t tVar = (t) AbstractC3256u.a(this.f2236a);
        if (tVar instanceof i) {
            tVar = ((i) tVar).A;
        }
        if (tVar != null) {
            i = View.MeasureSpec.makeMeasureSpec(tVar.t.f2365a, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(tVar.t.b, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}

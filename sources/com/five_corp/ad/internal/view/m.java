package com.five_corp.ad.internal.view;

import android.app.Activity;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;

/* JADX INFO: loaded from: classes10.dex */
public final class m extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.five_corp.ad.internal.layouter.g f1576a;

    static {
        m.class.toString();
    }

    public m(Activity activity, com.five_corp.ad.internal.E e, com.five_corp.ad.internal.logger.a aVar, G g, com.five_corp.ad.internal.context.l lVar, com.five_corp.ad.internal.layouter.f fVar, com.five_corp.ad.internal.fullscreen.c cVar, com.five_corp.ad.internal.viewability.a aVar2, com.five_corp.ad.internal.layouter.j jVar) {
        super(activity);
        this.f1576a = new com.five_corp.ad.internal.layouter.g(this, activity, e, aVar, g, lVar, fVar, cVar, aVar2, jVar);
    }

    public final void a() {
        com.five_corp.ad.internal.layouter.g gVar = this.f1576a;
        gVar.g.b.a();
        com.five_corp.ad.internal.ad.s sVar = gVar.f1418a.getWidth() > gVar.f1418a.getHeight() ? gVar.c.h : gVar.c.g;
        if (sVar != null) {
            com.five_corp.ad.internal.cache.b bVarA = gVar.e.a(gVar.b, sVar);
            gVar.h = bVarA;
            gVar.f1418a.addView(bVarA, new FrameLayout.LayoutParams(-1, -1, 17));
            gVar.h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        gVar.f1418a.addView(gVar.g, new FrameLayout.LayoutParams(0, 0, 17));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch("com.five_corp.ad", this, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            com.five_corp.ad.internal.layouter.g gVar = this.f1576a;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            gVar.getClass();
            try {
                com.five_corp.ad.internal.ad.custom_layout.d customLayoutConfig = gVar.g.getCustomLayoutConfig();
                com.five_corp.ad.internal.ad.custom_layout.d dVar = i5 > i6 ? gVar.c.f : gVar.c.e;
                if (customLayoutConfig != dVar) {
                    gVar.g.b.a(dVar);
                }
                gVar.g.setLayoutParams(gVar.a(i5, i6));
                gVar.b(i5, i6);
            } catch (Throwable th) {
                gVar.n.a(th);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}

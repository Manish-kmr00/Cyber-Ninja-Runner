package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
final class m52 extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, jf1.a {
    private final a c;
    private final GestureDetector e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PointF f9598a = new PointF();
    private final PointF b = new PointF();
    private final float d = 25.0f;
    private volatile float f = 3.1415927f;

    public interface a {
    }

    public m52(Context context, a aVar) {
        this.c = aVar;
        this.e = new GestureDetector(context, this);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.e.onTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f9598a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.f9598a.x) / this.d;
        float y = motionEvent2.getY();
        PointF pointF = this.f9598a;
        float f3 = (y - pointF.y) / this.d;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.f;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        PointF pointF2 = this.b;
        pointF2.x -= (fCos * x) - (fSin * f3);
        float f4 = (fCos * f3) + (fSin * x) + pointF2.y;
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        ((j12.a) this.c).a(this.b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return ((j12.a) this.c).a(motionEvent);
    }

    @Override // com.yandex.mobile.ads.impl.jf1.a
    public final void a(float[] fArr, float f) {
        this.f = -f;
    }
}

package com.fyber.inneractive.sdk.player.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.h0;

/* JADX INFO: loaded from: classes13.dex */
public final class r extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2240a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ int c;
    public final /* synthetic */ t d;

    public r(t tVar, View view, int[] iArr, int i) {
        this.d = tVar;
        this.f2240a = view;
        this.b = iArr;
        this.c = i;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        onSingleTapConfirmed(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2240a.getRootView().getLocationOnScreen(this.b);
            float rawX = motionEvent.getRawX() - this.b[0];
            float rawY = motionEvent.getRawY() - this.b[1];
            h0 h0Var = this.d.f2235a;
            h0Var.f2364a = rawX;
            h0Var.b = rawY;
        }
        t tVar = this.d;
        n nVar = tVar.g;
        if (nVar != null) {
            ((z) nVar).a(this.c, tVar.f2235a);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}

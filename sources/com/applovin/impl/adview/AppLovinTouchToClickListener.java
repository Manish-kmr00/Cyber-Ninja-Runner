package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.o0;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes6.dex */
public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f327a;
    private final int b;
    private final int c;
    private final ClickRecognitionState d;
    private long e;
    private PointF f;
    private boolean g;
    private final Context h;
    private final OnClickListener i;

    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    public interface OnClickListener {
        void onClick(View view, MotionEvent motionEvent);
    }

    public AppLovinTouchToClickListener(com.applovin.impl.sdk.k kVar, v4 v4Var, Context context, OnClickListener onClickListener) {
        this.f327a = ((Long) kVar.a(v4.f0)).longValue();
        this.b = ((Integer) kVar.a(v4.g0)).intValue();
        this.c = AppLovinSdkUtils.dpToPx(context, ((Integer) kVar.a(v4.k0)).intValue());
        this.d = ClickRecognitionState.values()[((Integer) kVar.a(v4Var)).intValue()];
        this.h = context;
        this.i = onClickListener;
    }

    private void a(View view, MotionEvent motionEvent) {
        this.i.onClick(view, motionEvent);
        this.g = true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 6 && !this.g && this.d == ClickRecognitionState.ACTION_POINTER_UP) {
                    a(view, motionEvent);
                }
            } else if (!this.g && this.d == ClickRecognitionState.ACTION_UP) {
                a(view, motionEvent);
            } else if (this.d == ClickRecognitionState.DISABLED) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.e;
                float fA = a(this.f, new PointF(motionEvent.getX(), motionEvent.getY()));
                if (!this.g) {
                    long j = this.f327a;
                    if ((j < 0 || jElapsedRealtime < j) && ((i = this.b) < 0 || fA < i)) {
                        a(view, motionEvent);
                    }
                }
            }
        } else if (this.d != ClickRecognitionState.ACTION_DOWN) {
            this.e = SystemClock.elapsedRealtime();
            this.f = new PointF(motionEvent.getX(), motionEvent.getY());
            this.g = false;
        } else if (a(motionEvent)) {
            a(view, motionEvent);
        }
        return true;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f = pointF.x - pointF2.x;
        float f2 = pointF.y - pointF2.y;
        return a((float) Math.sqrt((f * f) + (f2 * f2)));
    }

    private float a(float f) {
        return f / this.h.getResources().getDisplayMetrics().density;
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.c <= 0) {
            return true;
        }
        Point pointB = o0.b(this.h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = this.c;
        float f = i;
        return rawX >= f && rawY >= f && rawX <= ((float) (pointB.x - i)) && rawY <= ((float) (pointB.y - i));
    }
}

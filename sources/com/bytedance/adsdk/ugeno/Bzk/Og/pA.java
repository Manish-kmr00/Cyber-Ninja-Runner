package com.bytedance.adsdk.ugeno.Bzk.Og;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.KZx;
import com.bytedance.adsdk.ugeno.core.SGo;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class pA extends FrameLayout {
    private Map<Integer, SGo> Og;
    private KZx pA;

    public pA(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, SGo> map) {
        this.Og = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        KZx kZx = this.pA;
        if (kZx != null) {
            int[] iArrPA = kZx.pA(i, i2);
            super.onMeasure(iArrPA[0], iArrPA[1]);
        } else {
            super.onMeasure(i, i2);
        }
        KZx kZx2 = this.pA;
        if (kZx2 != null) {
            kZx2.ML();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.JG();
        }
        super.onLayout(z, i, i2, i3, i4);
        KZx kZx2 = this.pA;
        if (kZx2 != null) {
            kZx2.pA(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, SGo> map = this.Og;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void pA(KZx kZx) {
        this.pA = kZx;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.SD();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.omh();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        KZx kZx = this.pA;
        if (kZx != null) {
            kZx.Og(i, i2, i3, i4);
        }
    }
}

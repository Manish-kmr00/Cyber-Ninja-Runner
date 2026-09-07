package com.bytedance.sdk.openadsdk.core.omh;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes4.dex */
public class BF extends GestureDetector {
    private final com.bytedance.sdk.openadsdk.core.Og.JG Og;
    private final pA pA;

    public BF(Context context) {
        this(context, new pA());
    }

    public BF(Context context, pA pAVar) {
        super(context, pAVar);
        this.pA = pAVar;
        this.Og = new com.bytedance.sdk.openadsdk.core.Og.JG();
        setIsLongpressEnabled(false);
    }

    void pA() {
        this.pA.pA();
    }

    public boolean Og() {
        return this.pA.Og();
    }

    public com.bytedance.sdk.openadsdk.core.model.SGo pA(Context context, View view, View view2) {
        if (this.Og == null) {
            return new com.bytedance.sdk.openadsdk.core.model.SGo.pA().pA();
        }
        return new com.bytedance.sdk.openadsdk.core.model.SGo.pA().JG(this.Og.pA).ML(this.Og.Og).ZZv(this.Og.KZx).KZx(this.Og.ZZv).Og(this.Og.ML).pA(this.Og.JG).Og(Vgu.pA(view)).pA(Vgu.pA(view2)).KZx(Vgu.KZx(view)).ZZv(Vgu.KZx(view2)).ZZv(this.Og.SD).ML(this.Og.omh).JG(this.Og.Bzk).pA(this.Og.WV).Og(com.bytedance.sdk.openadsdk.core.Bzk.Og().pA() ? 1 : 2).pA("vessel").pA(Vgu.ML(context)).KZx(Vgu.SD(context)).Og(Vgu.JG(context)).pA();
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.Og.pA(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    static class pA extends GestureDetector.SimpleOnGestureListener {
        boolean pA = false;

        pA() {
        }

        void pA() {
            this.pA = false;
        }

        boolean Og() {
            return this.pA;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.pA = true;
            return super.onSingleTapUp(motionEvent);
        }
    }
}

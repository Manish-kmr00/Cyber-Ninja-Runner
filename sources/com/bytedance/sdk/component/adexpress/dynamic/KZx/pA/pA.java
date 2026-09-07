package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes8.dex */
public class pA implements View.OnTouchListener {
    private static int KZx = 10;
    private int ML;
    private float Og;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh ZZv;
    private float pA;
    private RectF JG = new RectF();
    private long SD = 0;
    private final int omh = 200;
    private final int Bzk = 3;
    private SoftReference<ViewGroup> SGo = new SoftReference<>(null);

    public pA(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, int i, final ViewGroup viewGroup) {
        this.ML = KZx;
        this.ZZv = omhVar;
        if (i > 0) {
            this.ML = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.pA.1
                @Override // java.lang.Runnable
                public void run() {
                    pA.this.SGo = new SoftReference(viewGroup);
                }
            });
        }
    }

    private RectF pA(View view) {
        if (view == null) {
            return new RectF();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        return new RectF(i, iArr[1], i + view.getWidth(), iArr[1] + view.getHeight());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.JG = pA(this.SGo.get());
            this.pA = motionEvent.getRawX();
            this.Og = motionEvent.getRawY();
            this.SD = System.currentTimeMillis();
        } else if (action == 1) {
            RectF rectF = this.JG;
            if (rectF != null && !rectF.contains(this.pA, this.Og)) {
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float fAbs = Math.abs(rawX - this.pA);
            float fAbs2 = Math.abs(rawY - this.Og);
            int i = this.ML;
            if (fAbs >= i && fAbs2 >= i) {
                com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar2 = this.ZZv;
                if (omhVar2 != null) {
                    omhVar2.pA();
                }
            } else if ((System.currentTimeMillis() - this.SD < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (omhVar = this.ZZv) != null) {
                omhVar.pA();
            }
        }
        return true;
    }
}

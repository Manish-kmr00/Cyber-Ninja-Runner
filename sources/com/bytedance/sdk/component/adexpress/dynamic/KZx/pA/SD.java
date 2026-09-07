package com.bytedance.sdk.component.adexpress.dynamic.KZx.pA;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes12.dex */
public class SD implements View.OnTouchListener {
    private static int KZx = 10;
    private int ML;
    private float Og;
    private com.bytedance.sdk.component.adexpress.dynamic.KZx.omh ZZv;
    private float pA;
    private RectF JG = new RectF();
    private long SD = 0;
    private final int omh = 200;
    private final int Bzk = 3;
    private SoftReference<View> SGo = new SoftReference<>(null);

    public SD(com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar, int i, final ViewGroup viewGroup) {
        this.ML = KZx;
        this.ZZv = omhVar;
        if (i > 0) {
            this.ML = i;
        }
        if (viewGroup != null) {
            viewGroup.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.KZx.pA.SD.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewFindViewById = viewGroup.findViewById(2097610746);
                    SD.this.SGo = new SoftReference(viewFindViewById);
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
        com.bytedance.sdk.component.adexpress.dynamic.KZx.omh omhVar2;
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
            int iOg = com.bytedance.sdk.component.adexpress.ZZv.omh.Og(com.bytedance.sdk.component.adexpress.ZZv.pA(), Math.abs(rawX - this.pA));
            int i = KZx;
            if (fAbs < i || fAbs2 < i) {
                if ((System.currentTimeMillis() - this.SD < 200 || (fAbs < 3.0f && fAbs2 < 3.0f)) && (omhVar = this.ZZv) != null) {
                    omhVar.pA();
                }
            } else if (rawX > this.pA && iOg > this.ML && (omhVar2 = this.ZZv) != null) {
                omhVar2.pA();
            }
        }
        return true;
    }
}

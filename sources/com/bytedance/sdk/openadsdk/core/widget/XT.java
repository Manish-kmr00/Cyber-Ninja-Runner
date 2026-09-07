package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.Vgu;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class XT {
    private boolean BSW;
    private int JG;
    private float ML;
    private int SD;
    private float ZZv;
    private final pA pA;
    private final boolean Og = false;
    private boolean KZx = false;
    private boolean omh = true;
    private boolean Bzk = false;
    private final View.OnTouchListener SGo = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.XT.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Logger.d("Pangle|SafeDK: Execution> Lcom/bytedance/sdk/openadsdk/core/widget/XT$1;->onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            CreativeInfoManager.onViewTouched(h.u, view, motionEvent);
            return safedk_XT$1_onTouch_da2988f2d339f32f56605d5d2033da8b(view, motionEvent);
        }

        public boolean safedk_XT$1_onTouch_da2988f2d339f32f56605d5d2033da8b(View p0, MotionEvent p1) {
            if (XT.this.pA.BF()) {
                return !XT.this.KZx;
            }
            float x = p1.getX();
            float y = p1.getY();
            int action = p1.getAction();
            if (action == 0) {
                XT xt = XT.this;
                xt.BSW = xt.pA(p1);
                XT.this.ZZv = x;
                XT.this.ML = y;
                XT.this.JG = (int) x;
                XT.this.SD = (int) y;
                XT.this.omh = true;
                if (XT.this.pA != null && XT.this.KZx) {
                    XT.this.pA.pA(p0, true);
                }
            } else if (action == 1) {
                if (Math.abs(x - XT.this.JG) > 20.0f || Math.abs(y - XT.this.SD) > 20.0f) {
                    XT.this.omh = false;
                }
                XT.this.omh = true;
                XT.this.Bzk = false;
                XT.this.ZZv = 0.0f;
                XT.this.ML = 0.0f;
                XT.this.JG = 0;
                if (XT.this.pA != null) {
                    XT.this.pA.pA(p0, XT.this.omh);
                }
                XT.this.BSW = false;
            } else if (action == 3) {
                XT.this.BSW = false;
            }
            return !XT.this.KZx;
        }
    };

    public interface pA {
        boolean BF();

        void pA(View view, boolean z);
    }

    public XT(pA pAVar) {
        this.pA = pAVar;
    }

    public void pA(View view) {
        if (view != null) {
            view.setOnTouchListener(this.SGo);
        }
    }

    public void pA(boolean z) {
        this.KZx = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pA(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iKZx = Vgu.KZx(com.bytedance.sdk.openadsdk.core.aBv.pA().getApplicationContext());
        int iZZv = Vgu.ZZv(com.bytedance.sdk.openadsdk.core.aBv.pA().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f = iKZx;
        if (rawX <= f * 0.01f || rawX >= f * 0.99f) {
            return true;
        }
        float f2 = iZZv;
        return rawY <= 0.01f * f2 || rawY >= f2 * 0.99f;
    }
}

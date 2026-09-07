package com.bytedance.adsdk.ugeno.ZZv.KZx;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.SD.omh;

/* JADX INFO: loaded from: classes10.dex */
public class KZx extends pA {
    private int BSW;
    private float Bzk;
    private float SGo;
    private String WV;

    public KZx(Context context) {
        super(context);
        this.BSW = 0;
        this.WV = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.ZZv.KZx.pA
    public boolean pA(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.ML != null) {
            this.WV = TextUtils.isEmpty(this.ML.get("direction")) ? "all" : this.ML.get("direction");
            this.BSW = com.bytedance.adsdk.ugeno.SD.KZx.pA(this.ML.get("distance"), 0);
        }
        return pA(this.Og, (MotionEvent) objArr[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x007d  */
    private boolean pA(com.bytedance.adsdk.ugeno.Og.KZx kZx, MotionEvent motionEvent) {
        byte b;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Bzk = motionEvent.getX();
            this.SGo = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.BSW == 0 && this.pA != null) {
                this.pA.pA(kZx, this.JG, this.KZx.Og());
                return true;
            }
            int iOg = omh.Og(this.omh, x - this.Bzk);
            int iOg2 = omh.Og(this.omh, y - this.SGo);
            switch (this.WV) {
                case "up":
                    b = 0;
                    break;
                case "all":
                    b = 4;
                    break;
                case "down":
                    b = 1;
                    break;
                case "left":
                    b = 2;
                    break;
                case "right":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                iOg = -iOg2;
            } else if (b == 1) {
                iOg = iOg2;
            } else if (b == 2) {
                iOg = -iOg;
            } else if (b != 3) {
                iOg = (int) Math.abs(Math.sqrt(Math.pow(iOg, 2.0d) + Math.pow(iOg2, 2.0d)));
            }
            if (iOg < this.BSW) {
                return false;
            }
            if (this.pA != null) {
                this.Bzk = 0.0f;
                this.SGo = 0.0f;
                this.pA.pA(kZx, this.JG, this.KZx.Og());
                return true;
            }
        }
        return true;
    }
}

package com.bytedance.adsdk.Og.JG;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.Og.KZx.Og.Sn;

/* JADX INFO: loaded from: classes8.dex */
public class ML {
    private static final PointF pA = new PointF();

    public static boolean KZx(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float pA(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int pA(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF pA(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void pA(Sn sn, Path path) {
        path.reset();
        PointF pointFPA = sn.pA();
        path.moveTo(pointFPA.x, pointFPA.y);
        pA.set(pointFPA.x, pointFPA.y);
        for (int i = 0; i < sn.KZx().size(); i++) {
            com.bytedance.adsdk.Og.KZx.pA pAVar = sn.KZx().get(i);
            PointF pointFPA2 = pAVar.pA();
            PointF pointFOg = pAVar.Og();
            PointF pointFKZx = pAVar.KZx();
            PointF pointF = pA;
            if (pointFPA2.equals(pointF) && pointFOg.equals(pointFKZx)) {
                path.lineTo(pointFKZx.x, pointFKZx.y);
            } else {
                path.cubicTo(pointFPA2.x, pointFPA2.y, pointFOg.x, pointFOg.y, pointFKZx.x, pointFKZx.y);
            }
            pointF.set(pointFKZx.x, pointFKZx.y);
        }
        if (sn.Og()) {
            path.close();
        }
    }

    static int pA(float f, float f2) {
        return pA((int) f, (int) f2);
    }

    private static int pA(int i, int i2) {
        return i - (i2 * Og(i, i2));
    }

    private static int Og(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int pA(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float Og(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}

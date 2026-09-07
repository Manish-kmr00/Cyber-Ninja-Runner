package com.bytedance.sdk.openadsdk.core.omh.pA;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import com.bytedance.sdk.openadsdk.utils.Vgu;

/* JADX INFO: loaded from: classes10.dex */
public class pA {
    public static Pair<Float, Float> pA(Window window, int i) {
        View decorView = window.getDecorView();
        float[] fArrPA = {decorView.getWidth() - (decorView.getPaddingLeft() * 2), decorView.getHeight() - (decorView.getPaddingTop() * 2)};
        fArrPA[0] = Vgu.ZZv(window.getContext(), fArrPA[0]);
        float fZZv = Vgu.ZZv(window.getContext(), fArrPA[1]);
        fArrPA[1] = fZZv;
        if (fArrPA[0] < 10.0f || fZZv < 10.0f) {
            fArrPA = pA(window.getContext(), Vgu.ZZv(window.getContext(), Vgu.pA()), i);
        }
        float fMax = Math.max(fArrPA[0], fArrPA[1]);
        float fMin = Math.min(fArrPA[0], fArrPA[1]);
        if (i == 1) {
            fArrPA[0] = fMin;
            fArrPA[1] = fMax;
        } else {
            fArrPA[0] = fMax;
            fArrPA[1] = fMin;
        }
        return new Pair<>(Float.valueOf(fArrPA[0]), Float.valueOf(fArrPA[1]));
    }

    private static float[] pA(Context context, int i, int i2) {
        float fPA = pA(context);
        float fOg = Og(context);
        if ((i2 == 1) != (fPA > fOg)) {
            float f = fPA + fOg;
            fOg = f - fOg;
            fPA = f - fOg;
        }
        if (i2 == 1) {
            fPA -= i;
        } else {
            fOg -= i;
        }
        return new float[]{fOg, fPA};
    }

    public static float pA(Context context) {
        return Vgu.ZZv(context, Vgu.Bzk(context));
    }

    public static float Og(Context context) {
        return Vgu.ZZv(context, Vgu.SGo(context));
    }
}

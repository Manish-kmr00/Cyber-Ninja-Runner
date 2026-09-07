package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;

/* JADX INFO: loaded from: classes.dex */
public abstract class n0 {
    public static void a(UnitDisplayType unitDisplayType, i0 i0Var, int i, int i2, int i3, int i4) {
        if (i > 0 && i2 > 0) {
            float f = i;
            float f2 = i2;
            float f3 = f / f2;
            if (unitDisplayType == UnitDisplayType.SQUARE) {
                i3 = (int) (i4 * f3);
            } else {
                if (Math.abs(f3 - 1.7777778f) >= 0.1f) {
                    Math.abs(f3 - 1.3333334f);
                }
                float fMin = Math.min(i3 / f, 10.0f);
                float f4 = i4;
                float f5 = fMin * f2;
                if (f4 > f5) {
                    i3 = (int) (fMin * f);
                    i4 = (int) f5;
                } else {
                    float fMin2 = Math.min(f4 / f2, 10.0f);
                    i3 = (int) (f * fMin2);
                    i4 = (int) (fMin2 * f2);
                }
            }
        }
        i0Var.f2365a = i3;
        i0Var.b = i4;
    }
}

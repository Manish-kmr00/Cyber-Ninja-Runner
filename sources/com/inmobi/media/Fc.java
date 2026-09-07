package com.inmobi.media;

import android.graphics.Point;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Fc {
    public static final Hc a(C3426j8 videoAsset, C3455l7 asset) {
        double d;
        double d2;
        double d3;
        Intrinsics.checkNotNullParameter(videoAsset, "videoAsset");
        Intrinsics.checkNotNullParameter(asset, "asset");
        Rc rcD = videoAsset.d();
        Point point = asset.d.f3375a;
        Hc hc = null;
        ArrayList arrayList = rcD != null ? ((Qc) rcD).i : null;
        float f = AbstractC3565t3.d().c;
        double d4 = point.y / f;
        double d5 = point.x / f;
        double d6 = d5 / d4;
        double d7 = d5 * d4;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            double d8 = -1.0d;
            double d9 = 0.0d;
            while (it.hasNext()) {
                Hc hc2 = (Hc) it.next();
                int i = hc2.b;
                it = it;
                double d10 = hc2.f3091a;
                Hc hc3 = hc;
                double d11 = i;
                if (d6 > d10 / d11) {
                    d2 = (d4 / d11) * d10;
                    d = d4;
                } else {
                    d = (d5 / d10) * d11;
                    d2 = d5;
                }
                if (d11 >= d * 0.33d && d10 >= 0.33d * d2) {
                    double d12 = d2 * d;
                    if (d12 > 0.5d * d7) {
                        if (d12 > d8) {
                            d9 = d11 / d;
                            hc = hc2;
                            d8 = d12;
                        } else if (d12 == d8) {
                            float f2 = AbstractC3565t3.d().c;
                            double d13 = d11 / d;
                            d3 = d4;
                            if (d13 <= d9 || d9 >= f2) {
                                double d14 = f2;
                                if (d9 <= d14 || d13 >= d9 || d13 <= d14) {
                                    hc = hc3;
                                    d4 = d3;
                                }
                            }
                            d9 = d13;
                            d4 = d3;
                            hc = hc2;
                        }
                    }
                }
                d3 = d4;
                hc = hc3;
                d4 = d3;
            }
        }
        return hc;
    }
}

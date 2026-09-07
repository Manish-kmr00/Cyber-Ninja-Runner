package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d02 f8415a = new d02();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final c02 a(RectF viewSize, uj0 imageValue) {
        List<c02> listC;
        Intrinsics.checkNotNullParameter(viewSize, "viewRect");
        Intrinsics.checkNotNullParameter(imageValue, "imageValue");
        RectF imageSize = new RectF(0.0f, 0.0f, imageValue.g(), imageValue.a());
        k02 k02VarE = imageValue.e();
        Object first = 0;
        if (k02VarE == null || (listC = k02VarE.c()) == null) {
            return null;
        }
        Iterator<T> it = listC.iterator();
        if (it.hasNext()) {
            first = it.next();
            while (it.hasNext()) {
                c02 second = (c02) it.next();
                first = (c02) first;
                this.f8415a.getClass();
                Intrinsics.checkNotNullParameter(first, "first");
                Intrinsics.checkNotNullParameter(second, "second");
                Intrinsics.checkNotNullParameter(imageSize, "imageSize");
                Intrinsics.checkNotNullParameter(viewSize, "viewSize");
                float fA = g02.a(first, viewSize, imageSize);
                float fA2 = g02.a(second, viewSize, imageSize);
                if (fA != Float.MAX_VALUE) {
                    if (fA == fA2) {
                        if (first.a() > second.a()) {
                        }
                    } else if (fA > fA2) {
                    }
                }
                first = second;
            }
        }
        return (c02) first;
    }
}

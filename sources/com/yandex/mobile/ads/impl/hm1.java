package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class hm1 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f9114a;
    private final ou0.a b;
    private final gg c;

    public hm1(float f) {
        this(f, new ou0.a());
    }

    public /* synthetic */ hm1(float f, ou0.a aVar) {
        this(f, aVar, new gg(f));
    }

    public hm1(float f, ou0.a measureSpecHolder, gg aspectRatioResolver) {
        Intrinsics.checkNotNullParameter(measureSpecHolder, "measureSpecHolder");
        Intrinsics.checkNotNullParameter(aspectRatioResolver, "aspectRatioResolver");
        this.f9114a = f;
        this.b = measureSpecHolder;
        this.c = aspectRatioResolver;
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            int iA = this.c.a(size);
            if (mode2 == Integer.MIN_VALUE) {
                iA = (int) Math.min(size2, iA);
            }
            i2 = View.MeasureSpec.makeMeasureSpec(iA, 1073741824);
        } else if (mode2 == 1073741824 && (mode == Integer.MIN_VALUE || mode == 0)) {
            int iB = this.c.b(size2);
            if (mode == Integer.MIN_VALUE) {
                iB = (int) Math.min(size, iB);
            }
            i = View.MeasureSpec.makeMeasureSpec(iB, 1073741824);
        } else if (mode2 == Integer.MIN_VALUE && mode == Integer.MIN_VALUE && size2 != 0 && size != 0) {
            if (size / size2 > this.f9114a) {
                i = View.MeasureSpec.makeMeasureSpec(this.c.b(size2), 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
            } else {
                int iA2 = this.c.a(size);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(iA2, 1073741824);
                i = iMakeMeasureSpec;
            }
        }
        ou0.a aVar = this.b;
        aVar.f9859a = i;
        aVar.b = i2;
        return aVar;
    }
}

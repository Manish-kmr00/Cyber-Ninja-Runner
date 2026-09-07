package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes9.dex */
public final class o70 implements pq0 {
    private final int b;
    private final RectF c;

    public o70(int i, RectF rectF) {
        this.b = i;
        this.c = rectF;
    }

    @Override // com.yandex.mobile.ads.impl.pq0
    public final String a() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Integer numValueOf = Integer.valueOf(this.b);
        RectF rectF = this.c;
        return z0.a(new Object[]{numValueOf, rectF != null ? z0.a(new Object[]{Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.width()), Float.valueOf(rectF.height())}, 4, "{x:%s,y:%s,width:%s,height:%s}", "format(...)") : null}, 2, "exposure:{exposedPercentage:%s,visibleRectangle:%s,occlusionRectangles:[]}", "format(...)");
    }
}

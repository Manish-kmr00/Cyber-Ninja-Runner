package com.yandex.mobile.ads.impl;

import android.view.View;
import com.monetization.ads.video.playback.view.ExtendedVideoAdControlsContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes11.dex */
public final class hb0 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9080a;
    private final ou0.a b;

    public hb0(ExtendedVideoAdControlsContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f9080a = container;
        this.b = new ou0.a();
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int iRoundToInt = MathKt.roundToInt(this.f9080a.getHeight() * 0.1f);
        ou0.a aVar = this.b;
        aVar.f9859a = i;
        aVar.b = View.MeasureSpec.makeMeasureSpec(iRoundToInt, 1073741824);
        return this.b;
    }
}

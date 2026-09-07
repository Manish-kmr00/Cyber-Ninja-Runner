package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.fullscreen.template.view.ExtendedViewContainer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k31 f8754a = new k31();

    public final ExtendedViewContainer a(Context context, List<uj0> imageValues) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageValues, "imageValues");
        ExtendedViewContainer extendedViewContainer = new ExtendedViewContainer(context, null, 0, 6, null);
        this.f8754a.getClass();
        extendedViewContainer.setMeasureSpecProvider(new hm1((float) k31.a(imageValues), new ou0.a()));
        return extendedViewContainer;
    }
}

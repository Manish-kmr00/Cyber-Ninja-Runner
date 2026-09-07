package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ob1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final lv f9804a;

    public final qf2 a(CustomizableMediaView mediaView) {
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        this.f9804a.getClass();
        Intrinsics.checkNotNullParameter(mediaView, "mediaView");
        qf2 videoScaleType = mediaView.getVideoScaleType();
        return videoScaleType == null ? qf2.b : videoScaleType;
    }

    public /* synthetic */ ob1() {
        this(new lv());
    }

    public ob1(lv customizableMediaViewManager) {
        Intrinsics.checkNotNullParameter(customizableMediaViewManager, "customizableMediaViewManager");
        this.f9804a = customizableMediaViewManager;
    }
}

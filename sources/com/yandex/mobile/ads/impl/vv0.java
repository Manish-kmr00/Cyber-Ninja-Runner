package com.yandex.mobile.ads.impl;

import android.content.Context;
import com.monetization.ads.nativeads.video.view.CorePlaybackControlsContainer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class vv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uv0 f10511a;
    private final zs1<CorePlaybackControlsContainer> b;

    public final wv0 a(Context context, int i, wv0 controls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(controls, "customControls");
        this.f10511a.getClass();
        Intrinsics.checkNotNullParameter(controls, "controls");
        if (controls.getMuteControl() != null || controls.getVideoProgress() != null || controls.getCountDownProgress() != null) {
            return new kv(controls.getMuteControl(), controls.getVideoProgress(), controls.getCountDownProgress());
        }
        this.b.getClass();
        return (wv0) zs1.a(context, CorePlaybackControlsContainer.class, i, null);
    }

    public /* synthetic */ vv0() {
        this(new uv0(), new zs1());
    }

    public vv0(uv0 controlsAvailabilityChecker, zs1<CorePlaybackControlsContainer> safeLayoutInflater) {
        Intrinsics.checkNotNullParameter(controlsAvailabilityChecker, "controlsAvailabilityChecker");
        Intrinsics.checkNotNullParameter(safeLayoutInflater, "safeLayoutInflater");
        this.f10511a = controlsAvailabilityChecker;
        this.b = safeLayoutInflater;
    }
}

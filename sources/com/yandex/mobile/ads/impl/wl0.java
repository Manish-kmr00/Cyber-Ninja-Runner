package com.yandex.mobile.ads.impl;

import android.view.View;
import android.widget.ProgressBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class wl0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn0 f10573a;

    public wl0(zn0 instreamVastAdPlayer) {
        Intrinsics.checkNotNullParameter(instreamVastAdPlayer, "instreamVastAdPlayer");
        this.f10573a = instreamVastAdPlayer;
    }

    public final in0 a(gb2 uiElements, in0 initialControlsState) {
        Intrinsics.checkNotNullParameter(uiElements, "uiElements");
        Intrinsics.checkNotNullParameter(initialControlsState, "initialControlsState");
        boolean z = this.f10573a.getVolume() == 0.0f;
        View viewL = uiElements.l();
        Float fValueOf = null;
        Boolean boolValueOf = viewL != null ? Boolean.valueOf(viewL.isEnabled()) : null;
        ProgressBar progressBarJ = uiElements.j();
        if (progressBarJ != null) {
            int progress = progressBarJ.getProgress();
            int max = progressBarJ.getMax();
            if (max != 0) {
                fValueOf = Float.valueOf(progress / max);
            }
        }
        in0.a aVar = new in0.a();
        aVar.b(z);
        if (boolValueOf != null) {
            aVar.a(boolValueOf.booleanValue());
        }
        if (fValueOf != null) {
            aVar.b(fValueOf.floatValue());
        }
        aVar.a(initialControlsState.a());
        return new in0(aVar);
    }
}

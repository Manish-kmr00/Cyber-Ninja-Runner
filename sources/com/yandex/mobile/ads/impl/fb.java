package com.yandex.mobile.ads.impl;

import androidx.media3.common.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ol f8880a;
    private final o5 b;
    private final ge2 c;
    private final pj1 d;
    private boolean e;

    public fb(ol bindingControllerHolder, o5 adPlaybackStateController, ge2 videoDurationHolder, pj1 positionProviderHolder) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        this.f8880a = bindingControllerHolder;
        this.b = adPlaybackStateController;
        this.c = videoDurationHolder;
        this.d = positionProviderHolder;
    }

    public final boolean a() {
        return this.e;
    }

    public final void b() {
        kl klVarA = this.f8880a.a();
        if (klVarA != null) {
            ki1 ki1VarB = this.d.b();
            if (ki1VarB != null) {
                this.e = true;
                int adGroupIndexForPositionUs = this.b.a().getAdGroupIndexForPositionUs(Util.msToUs(ki1VarB.a()), Util.msToUs(this.c.a()));
                if (adGroupIndexForPositionUs != -1) {
                    if (adGroupIndexForPositionUs == this.b.a().adGroupCount) {
                        this.f8880a.c();
                        return;
                    } else {
                        klVarA.a();
                        return;
                    }
                }
                klVarA.a();
                return;
            }
            op0.b(new Object[0]);
        }
    }
}

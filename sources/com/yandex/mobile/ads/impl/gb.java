package com.yandex.mobile.ads.impl;

import com.google.android.exoplayer2.util.Util;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final pl f8982a;
    private final p5 b;
    private final he2 c;
    private final qj1 d;
    private boolean e;

    public gb(pl bindingControllerHolder, p5 adPlaybackStateController, he2 videoDurationHolder, qj1 positionProviderHolder) {
        Intrinsics.checkNotNullParameter(bindingControllerHolder, "bindingControllerHolder");
        Intrinsics.checkNotNullParameter(adPlaybackStateController, "adPlaybackStateController");
        Intrinsics.checkNotNullParameter(videoDurationHolder, "videoDurationHolder");
        Intrinsics.checkNotNullParameter(positionProviderHolder, "positionProviderHolder");
        this.f8982a = bindingControllerHolder;
        this.b = adPlaybackStateController;
        this.c = videoDurationHolder;
        this.d = positionProviderHolder;
    }

    public final boolean a() {
        return this.e;
    }

    public final void b() {
        ll llVarA = this.f8982a.a();
        if (llVarA != null) {
            li1 li1VarB = this.d.b();
            if (li1VarB != null) {
                this.e = true;
                int adGroupIndexForPositionUs = this.b.a().getAdGroupIndexForPositionUs(Util.msToUs(li1VarB.a()), Util.msToUs(this.c.a()));
                if (adGroupIndexForPositionUs != -1) {
                    if (adGroupIndexForPositionUs == this.b.a().adGroupCount) {
                        this.f8982a.c();
                        return;
                    } else {
                        llVarA.a();
                        return;
                    }
                }
                llVarA.a();
                return;
            }
            op0.b(new Object[0]);
        }
    }
}

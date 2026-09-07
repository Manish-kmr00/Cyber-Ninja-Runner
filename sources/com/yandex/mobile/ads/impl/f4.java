package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b4 f8864a;
    private final vm0 b;
    private final j4 c;
    private final h4 d;

    public f4(b4 adGroupController, vm0 uiElementsManager, j4 adGroupPlaybackEventsListener, h4 adGroupPlaybackController) {
        Intrinsics.checkNotNullParameter(adGroupController, "adGroupController");
        Intrinsics.checkNotNullParameter(uiElementsManager, "uiElementsManager");
        Intrinsics.checkNotNullParameter(adGroupPlaybackEventsListener, "adGroupPlaybackEventsListener");
        Intrinsics.checkNotNullParameter(adGroupPlaybackController, "adGroupPlaybackController");
        this.f8864a = adGroupController;
        this.b = uiElementsManager;
        this.c = adGroupPlaybackEventsListener;
        this.d = adGroupPlaybackController;
    }

    public final void a() {
        ao0 ao0VarC = this.f8864a.c();
        if (ao0VarC != null) {
            ao0VarC.a();
        }
        k4 k4VarF = this.f8864a.f();
        if (k4VarF != null) {
            this.b.a(k4VarF.c());
            int iOrdinal = k4VarF.b().a().ordinal();
            if (iOrdinal == 0) {
                this.d.b();
                this.b.a();
                this.c.c();
                this.d.e();
                return;
            }
            if (iOrdinal == 1) {
                this.d.b();
                this.b.a();
                this.c.c();
                return;
            } else {
                if (iOrdinal != 2) {
                    if (iOrdinal != 4 && iOrdinal != 5) {
                        if (iOrdinal == 6) {
                            this.c.b();
                            this.d.f();
                            return;
                        } else if (iOrdinal != 8 && iOrdinal != 9) {
                            return;
                        }
                    }
                    a();
                    return;
                }
                this.c.a();
                this.d.d();
                return;
            }
        }
        this.b.a();
        this.c.g();
    }
}

package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ni1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f9732a;
    private final n3 b;
    private final ee2 c;
    private final z5 d;
    private boolean e;

    public ni1(r9 adStateHolder, n3 adCompletionListener, ee2 videoCompletedNotifier, z5 adPlayerEventsController) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adCompletionListener, "adCompletionListener");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        this.f9732a = adStateHolder;
        this.b = adCompletionListener;
        this.c = videoCompletedNotifier;
        this.d = adPlayerEventsController;
    }

    public final void a(boolean z, int i) {
        yi1 yi1VarC = this.f9732a.c();
        if (yi1VarC == null) {
            return;
        }
        v4 v4VarA = yi1VarC.a();
        do0 do0VarB = yi1VarC.b();
        if (tm0.b == this.f9732a.a(do0VarB)) {
            if (z && i == 2) {
                this.c.c();
                return;
            }
            return;
        }
        if (i == 2) {
            this.e = true;
            this.d.i(do0VarB);
        } else if (i == 3 && this.e) {
            this.e = false;
            this.d.h(do0VarB);
        } else if (i == 4) {
            this.b.a(v4VarA, do0VarB);
        }
    }
}

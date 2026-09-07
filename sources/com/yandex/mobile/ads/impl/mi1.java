package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class mi1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q9 f9642a;
    private final m3 b;
    private final de2 c;
    private final y5 d;
    private boolean e;

    public mi1(q9 adStateHolder, m3 adCompletionListener, de2 videoCompletedNotifier, y5 adPlayerEventsController) {
        Intrinsics.checkNotNullParameter(adStateHolder, "adStateHolder");
        Intrinsics.checkNotNullParameter(adCompletionListener, "adCompletionListener");
        Intrinsics.checkNotNullParameter(videoCompletedNotifier, "videoCompletedNotifier");
        Intrinsics.checkNotNullParameter(adPlayerEventsController, "adPlayerEventsController");
        this.f9642a = adStateHolder;
        this.b = adCompletionListener;
        this.c = videoCompletedNotifier;
        this.d = adPlayerEventsController;
    }

    public final void a(boolean z, int i) {
        xi1 xi1VarC = this.f9642a.c();
        if (xi1VarC == null) {
            return;
        }
        u4 u4VarA = xi1VarC.a();
        do0 do0VarB = xi1VarC.b();
        if (sm0.b == this.f9642a.a(do0VarB)) {
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
            this.b.a(u4VarA, do0VarB);
        }
    }
}

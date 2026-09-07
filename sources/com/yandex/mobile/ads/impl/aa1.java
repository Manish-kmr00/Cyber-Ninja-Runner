package com.yandex.mobile.ads.impl;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class aa1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final sr1 f8385a;
    private final vc0 b;
    private View c;

    public /* synthetic */ aa1(h52 h52Var, j91 j91Var, y42 y42Var) {
        this(h52Var, j91Var, y42Var, new tr1(), new sr1(h52Var));
    }

    public aa1(h52 timerViewProvider, j91 nativeMediaContent, y42 timeProviderContainer, tr1 rewardViewControllerProvider, sr1 rewardTimerViewController) {
        Intrinsics.checkNotNullParameter(timerViewProvider, "timerViewProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(rewardViewControllerProvider, "rewardViewControllerProvider");
        Intrinsics.checkNotNullParameter(rewardTimerViewController, "rewardTimerViewController");
        this.f8385a = rewardTimerViewController;
        a aVar = new a();
        rewardViewControllerProvider.getClass();
        this.b = tr1.a(aVar, nativeMediaContent, timeProviderContainer);
    }

    public final void c() {
        vc0 vc0Var = this.b;
        if (vc0Var != null) {
            vc0Var.resume();
        }
    }

    private final class a implements ul1 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.ul1
        public final void a(long j, long j2) {
            View view = aa1.this.c;
            if (view != null) {
                aa1.this.f8385a.a(view, j, j2);
            }
        }

        @Override // com.yandex.mobile.ads.impl.ul1
        public final void a() {
            View view = aa1.this.c;
            if (view == null) {
                return;
            }
            view.setVisibility(8);
        }
    }

    public final void b() {
        vc0 vc0Var = this.b;
        if (vc0Var != null) {
            vc0Var.pause();
        }
    }

    public final void a() {
        this.c = null;
        vc0 vc0Var = this.b;
        if (vc0Var != null) {
            vc0Var.invalidate();
        }
    }

    public final void a(View view) {
        this.c = view;
        vc0 vc0Var = this.b;
        if (vc0Var != null) {
            vc0Var.start();
        }
    }
}

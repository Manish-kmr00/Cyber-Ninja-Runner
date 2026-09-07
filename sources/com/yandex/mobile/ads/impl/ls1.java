package com.yandex.mobile.ads.impl;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class ls1<V extends ViewGroup> implements y00<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e1 f9565a;
    private final g52 b;
    private final aa1 c;
    private final f1 d;

    @Override // com.yandex.mobile.ads.impl.y00
    public final void a(V container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.f9565a.a(this.d);
        this.c.a(this.b.b(container));
    }

    public /* synthetic */ ls1(e1 e1Var, h52 h52Var, j91 j91Var, y42 y42Var) {
        aa1 aa1Var = new aa1(h52Var, j91Var, y42Var);
        this(e1Var, h52Var, j91Var, y42Var, aa1Var, new a(aa1Var));
    }

    public ls1(e1 adActivityEventController, h52 timerViewProvider, j91 nativeMediaContent, y42 timeProviderContainer, aa1 nativeRewardViewController, f1 adActivityFocusListener) {
        Intrinsics.checkNotNullParameter(adActivityEventController, "adActivityEventController");
        Intrinsics.checkNotNullParameter(timerViewProvider, "timerViewProvider");
        Intrinsics.checkNotNullParameter(nativeMediaContent, "nativeMediaContent");
        Intrinsics.checkNotNullParameter(timeProviderContainer, "timeProviderContainer");
        Intrinsics.checkNotNullParameter(nativeRewardViewController, "nativeRewardViewController");
        Intrinsics.checkNotNullParameter(adActivityFocusListener, "adActivityFocusListener");
        this.f9565a = adActivityEventController;
        this.b = timerViewProvider;
        this.c = nativeRewardViewController;
        this.d = adActivityFocusListener;
    }

    @Override // com.yandex.mobile.ads.impl.y00
    public final void c() {
        this.f9565a.b(this.d);
        this.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class a implements f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final aa1 f9566a;

        public a(aa1 nativeRewardViewController) {
            Intrinsics.checkNotNullParameter(nativeRewardViewController, "nativeRewardViewController");
            this.f9566a = nativeRewardViewController;
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void a() {
            this.f9566a.c();
        }

        @Override // com.yandex.mobile.ads.impl.f1
        public final void b() {
            this.f9566a.b();
        }
    }
}

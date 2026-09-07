package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt f9059a;
    private final vm0 b;
    private final j4 c;
    private final xn0 d;
    private final b4 e;
    private final fb2 f;
    private final g4 g;
    private final f4 h;
    private final uk1 i;
    private boolean j;
    private boolean k;
    private boolean l;

    public h4(Context context, dt coreInstreamAdBreak, gm0 adPlayerController, vm0 uiElementsManager, zm0 adViewsHolderManager, j4 adGroupPlaybackEventsListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coreInstreamAdBreak, "coreInstreamAdBreak");
        Intrinsics.checkNotNullParameter(adPlayerController, "adPlayerController");
        Intrinsics.checkNotNullParameter(uiElementsManager, "uiElementsManager");
        Intrinsics.checkNotNullParameter(adViewsHolderManager, "adViewsHolderManager");
        Intrinsics.checkNotNullParameter(adGroupPlaybackEventsListener, "adGroupPlaybackEventsListener");
        this.f9059a = coreInstreamAdBreak;
        this.b = uiElementsManager;
        this.c = adGroupPlaybackEventsListener;
        int i = xn0.g;
        this.d = xn0.a.a();
        uk1 uk1Var = new uk1(context);
        this.i = uk1Var;
        fb2 fb2Var = new fb2();
        this.f = fb2Var;
        i4 i4Var = new i4(fb2Var, new a(this, adGroupPlaybackEventsListener));
        b4 b4VarA = new c4(context, coreInstreamAdBreak, adPlayerController, uk1Var, adViewsHolderManager, i4Var).a();
        this.e = b4VarA;
        i4Var.a(b4VarA);
        this.g = new g4(b4VarA);
        this.h = new f4(b4VarA, uiElementsManager, adGroupPlaybackEventsListener, this);
    }

    public static final void a(h4 h4Var) {
        rb2<do0> rb2VarB = h4Var.e.b();
        eg2 eg2VarD = h4Var.e.d();
        if (rb2VarB == null || eg2VarD == null) {
            op0.b(new Object[0]);
        } else {
            h4Var.b.a(h4Var.f9059a, rb2VarB, eg2VarD, h4Var.f, h4Var.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements hv {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final j4 f9060a;
        final /* synthetic */ h4 b;

        public a(h4 h4Var, j4 adGroupPlaybackListener) {
            Intrinsics.checkNotNullParameter(adGroupPlaybackListener, "adGroupPlaybackListener");
            this.b = h4Var;
            this.f9060a = adGroupPlaybackListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(h4 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(h4 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.j();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void b(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            this.f9060a.e();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void d(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            if (!this.b.l) {
                this.b.l = true;
                this.f9060a.h();
            }
            this.f9060a.i();
            if (this.b.j) {
                this.b.j = false;
                this.b.d();
            }
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void e(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            if (this.b.e.e() != null) {
                this.b.b.a();
                return;
            }
            final h4 h4Var = this.b;
            Runnable runnable = new Runnable() { // from class: com.yandex.mobile.ads.impl.h4$a$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    h4.a.e(h4Var);
                }
            };
            this.b.b.a();
            runnable.run();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void f(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            this.f9060a.d();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void g(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            final h4 h4Var = this.b;
            Runnable runnable = new Runnable() { // from class: com.yandex.mobile.ads.impl.h4$a$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    h4.a.a(h4Var);
                }
            };
            if (this.b.e.e() != null) {
                this.b.h.a();
            } else {
                this.b.b.a();
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(h4 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(h4 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(h4 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.c.k();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void a(rb2<do0> videoAdInfo, pc2 videoAdPlayerError) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            Intrinsics.checkNotNullParameter(videoAdPlayerError, "videoAdPlayerError");
            k4 k4VarA = this.b.e.a(videoAdInfo);
            id2 id2VarB = k4VarA != null ? k4VarA.b() : null;
            if ((id2VarB != null ? id2VarB.a() : null) == hd2.k) {
                this.b.g.c();
                final h4 h4Var = this.b;
                Runnable runnable = new Runnable() { // from class: com.yandex.mobile.ads.impl.h4$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        h4.a.b(h4Var);
                    }
                };
                this.b.b.a();
                runnable.run();
                return;
            }
            final h4 h4Var2 = this.b;
            Runnable runnable2 = new Runnable() { // from class: com.yandex.mobile.ads.impl.h4$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    h4.a.c(h4Var2);
                }
            };
            if (this.b.e.e() != null) {
                this.b.h.a();
            } else {
                this.b.b.a();
                runnable2.run();
            }
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void c(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            if (!this.b.k) {
                this.b.k = true;
                this.f9060a.f();
            }
            this.b.j = false;
            h4.a(this.b);
            this.f9060a.a();
        }

        @Override // com.yandex.mobile.ads.impl.hv
        public final void a(rb2<do0> videoAdInfo) {
            Intrinsics.checkNotNullParameter(videoAdInfo, "videoAdInfo");
            if (this.b.d.f()) {
                this.b.g.c();
                this.b.e.a();
            }
            final h4 h4Var = this.b;
            Runnable runnable = new Runnable() { // from class: com.yandex.mobile.ads.impl.h4$a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    h4.a.d(h4Var);
                }
            };
            if (this.b.e.e() != null) {
                this.b.h.a();
            } else {
                this.b.b.a();
                runnable.run();
            }
        }
    }

    public final void f() {
        Unit unit;
        rb2<do0> rb2VarB = this.e.b();
        eg2 eg2VarD = this.e.d();
        if (rb2VarB != null && eg2VarD != null) {
            this.b.a(this.f9059a, rb2VarB, eg2VarD, this.f, this.i);
        } else {
            op0.b(new Object[0]);
        }
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            ao0VarC.f();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            op0.b(new Object[0]);
        }
    }

    public final void e() {
        Unit unit;
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            ao0VarC.d();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            op0.b(new Object[0]);
        }
    }

    public final void d() {
        Unit unit;
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            this.j = false;
            ao0VarC.c();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            op0.b(new Object[0]);
        }
        this.g.b();
    }

    public final void b() {
        this.j = true;
    }

    public final void g() {
        Unit unit;
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            ao0VarC.g();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            op0.b(new Object[0]);
        }
        this.g.c();
    }

    public final void c() {
        Unit unit;
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            ao0VarC.b();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            op0.b(new Object[0]);
        }
    }

    public final void a() {
        ao0 ao0VarC = this.e.c();
        if (ao0VarC != null) {
            ao0VarC.a();
        }
        this.g.a();
        this.j = false;
        this.l = false;
        this.k = false;
    }

    public final void a(io0 io0Var) {
        this.f.a(io0Var);
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dt f10351a;
    private final vm0 b;
    private final z2 c;
    private final h4 d;
    private final d3 e;
    private v2 f;
    private boolean g;

    public u2(Context context, dt instreamAdBreak, gm0 adPlayerController, vm0 instreamAdUiElementsManager, zm0 instreamAdViewsHolderManager, z2 adBreakStatusController) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(instreamAdBreak, "instreamAdBreak");
        Intrinsics.checkNotNullParameter(adPlayerController, "adPlayerController");
        Intrinsics.checkNotNullParameter(instreamAdUiElementsManager, "instreamAdUiElementsManager");
        Intrinsics.checkNotNullParameter(instreamAdViewsHolderManager, "instreamAdViewsHolderManager");
        Intrinsics.checkNotNullParameter(adBreakStatusController, "adBreakStatusController");
        this.f10351a = instreamAdBreak;
        this.b = instreamAdUiElementsManager;
        this.c = adBreakStatusController;
        this.d = new h4(context, instreamAdBreak, adPlayerController, instreamAdUiElementsManager, instreamAdViewsHolderManager, new a());
        this.e = new d3(context, instreamAdBreak.a());
    }

    public static final void g(u2 u2Var) {
        if (u2Var.c.a(u2Var.f10351a) == y2.d) {
            v2 v2Var = u2Var.f;
            if (v2Var != null) {
                v2Var.d();
            }
            u2Var.d.d();
        }
    }

    public final void g() {
        if (this.c.a(this.f10351a) == y2.d) {
            v2 v2Var = this.f;
            if (v2Var != null) {
                v2Var.d();
            }
            this.d.d();
        }
    }

    public final void d() {
        if (this.c.a(this.f10351a) == y2.b) {
            this.c.a(this.f10351a, y2.c);
            this.d.e();
        }
    }

    public final void a() {
        int iOrdinal = this.c.a(this.f10351a).ordinal();
        if (iOrdinal == 6 || iOrdinal == 7) {
            this.c.a(this.f10351a, y2.h);
            this.d.c();
        }
    }

    public final void c() {
        int iOrdinal = this.c.a(this.f10351a).ordinal();
        if (iOrdinal == 1) {
            this.c.a(this.f10351a, y2.b);
            this.d.g();
        } else if (iOrdinal == 6 || iOrdinal == 7) {
            this.c.a(this.f10351a, y2.h);
            this.d.c();
        }
        this.b.a();
    }

    public final void b() {
        int iOrdinal = this.c.a(this.f10351a).ordinal();
        if (iOrdinal == 1) {
            this.c.a(this.f10351a, y2.b);
            this.d.g();
            this.d.a();
        } else if (iOrdinal == 2) {
            this.g = false;
            this.c.a(this.f10351a, y2.b);
            this.d.g();
            this.d.a();
        } else if (iOrdinal == 5) {
            this.c.a(this.f10351a, y2.b);
            this.d.a();
        } else if (iOrdinal == 6 || iOrdinal == 7) {
            this.g = true;
            this.c.a(this.f10351a, y2.b);
            this.d.g();
            this.d.a();
        }
        this.b.a();
    }

    public final void a(v2 v2Var) {
        this.f = v2Var;
    }

    public final void f() {
        int iOrdinal = this.c.a(this.f10351a).ordinal();
        if (iOrdinal == 0) {
            if (this.c.a(this.f10351a) == y2.b) {
                this.c.a(this.f10351a, y2.c);
                this.d.e();
                return;
            }
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 6 || iOrdinal == 7) {
                this.d.f();
                return;
            }
            return;
        }
        if (this.c.a(this.f10351a) == y2.d) {
            v2 v2Var = this.f;
            if (v2Var != null) {
                v2Var.d();
            }
            this.d.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    public final void e() {
        int iOrdinal = this.c.a(this.f10351a).ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            this.c.a(this.f10351a, y2.b);
            this.d.g();
            this.d.a();
        } else if (iOrdinal == 5) {
            this.c.a(this.f10351a, y2.b);
            this.d.a();
        } else if (iOrdinal == 6 || iOrdinal == 7) {
            this.c.a(this.f10351a, y2.b);
            this.d.g();
            this.d.a();
        }
        this.g = false;
        this.b.a();
    }

    public final void a(io0 io0Var) {
        this.d.a(io0Var);
    }

    private final class a implements j4 {
        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void c() {
            u2.this.c.a(u2.this.f10351a, y2.c);
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void h() {
            boolean z = u2.this.g;
            u2.this.g = false;
            if (y2.c == u2.this.c.a(u2.this.f10351a)) {
                u2.this.c.a(u2.this.f10351a, y2.d);
                if (!z) {
                    v2 v2Var = u2.this.f;
                    if (v2Var != null) {
                        v2Var.a();
                        return;
                    }
                    return;
                }
                u2.g(u2.this);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void i() {
            if (y2.c == u2.this.c.a(u2.this.f10351a)) {
                u2.this.c.a(u2.this.f10351a, y2.d);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void f() {
            if (u2.this.c.a(u2.this.f10351a) == y2.d) {
                u2.this.c.a(u2.this.f10351a, y2.i);
                u2.this.e.c();
                v2 v2Var = u2.this.f;
                if (v2Var != null) {
                    v2Var.b();
                }
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void a() {
            if (u2.this.c.a(u2.this.f10351a) == y2.d) {
                u2.this.c.a(u2.this.f10351a, y2.i);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void b() {
            if (u2.this.c.a(u2.this.f10351a) == y2.h) {
                u2.this.c.a(u2.this.f10351a, y2.i);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void e() {
            if (u2.this.c.a(u2.this.f10351a) == y2.i) {
                u2.this.c.a(u2.this.f10351a, y2.h);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void d() {
            if (u2.this.c.a(u2.this.f10351a) == y2.h) {
                u2.this.c.a(u2.this.f10351a, y2.i);
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void j() {
            u2.this.c.a(u2.this.f10351a, y2.g);
            u2.this.e.b();
            v2 v2Var = u2.this.f;
            if (v2Var != null) {
                v2Var.g();
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void k() {
            u2.this.c.a(u2.this.f10351a, y2.g);
            u2.this.e.b();
            v2 v2Var = u2.this.f;
            if (v2Var != null) {
                v2Var.g();
            }
        }

        @Override // com.yandex.mobile.ads.impl.j4
        public final void g() {
            y2 y2VarA = u2.this.c.a(u2.this.f10351a);
            if (y2VarA == y2.i || y2VarA == y2.h) {
                u2.this.c.a(u2.this.f10351a, y2.e);
                u2.this.e.a();
                v2 v2Var = u2.this.f;
                if (v2Var != null) {
                    v2Var.e();
                }
            }
        }
    }
}

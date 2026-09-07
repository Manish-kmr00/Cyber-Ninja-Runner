package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class fn2 implements eg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8913a;
    private final sc2 b;
    private final gd2 c;
    private final List<oa2> d;
    private final cg2 e;
    private final se1 f;
    private final lp1 g;
    private b9 h;
    private zv0 i;
    private p3 j;
    private boolean k;

    public fn2(Context context, sc2 videoAdPosition, gd2 gd2Var, List<oa2> verifications, cg2 eventsTracker, se1 omSdkVastPropertiesCreator, lp1 reporter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoAdPosition, "videoAdPosition");
        Intrinsics.checkNotNullParameter(verifications, "verifications");
        Intrinsics.checkNotNullParameter(eventsTracker, "eventsTracker");
        Intrinsics.checkNotNullParameter(omSdkVastPropertiesCreator, "omSdkVastPropertiesCreator");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f8913a = context;
        this.b = videoAdPosition;
        this.c = gd2Var;
        this.d = verifications;
        this.e = eventsTracker;
        this.f = omSdkVastPropertiesCreator;
        this.g = reporter;
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void g() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void h() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void i() {
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void l() {
    }

    public static final void a(fn2 fn2Var, pa2 pa2Var) {
        fn2Var.getClass();
        fn2Var.e.a(pa2Var.b(), "verificationNotExecuted", MapsKt.mapOf(TuplesKt.to("[REASON]", String.valueOf(pa2Var.a().a()))));
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(View view, List<pb2> friendlyOverlays) {
        rc0 rc0Var;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(friendlyOverlays, "friendlyOverlays");
        k();
        this.k = false;
        Unit unit = Unit.INSTANCE;
        try {
            Context context = this.f8913a;
            en2 en2Var = new en2(this);
            he1 he1Var = new he1(context, en2Var);
            int i = ie1.e;
            pe1 pe1VarA = new qe1(context, en2Var, he1Var, ie1.a.a(), new re1()).a(this.d);
            if (pe1VarA != null) {
                b9 b9VarB = pe1VarA.b();
                b9VarB.a(view);
                this.h = b9VarB;
                this.i = pe1VarA.c();
                this.j = pe1VarA.a();
            }
        } catch (Exception e) {
            op0.c(new Object[0]);
            this.g.reportError("Failed to execute safely", e);
        }
        b9 b9Var = this.h;
        if (b9Var != null) {
            for (pb2 pb2Var : friendlyOverlays) {
                View viewC = pb2Var.c();
                if (viewC != null) {
                    Unit unit2 = Unit.INSTANCE;
                    try {
                        pb2.a purpose = pb2Var.b();
                        Intrinsics.checkNotNullParameter(purpose, "purpose");
                        int iOrdinal = purpose.ordinal();
                        if (iOrdinal == 0) {
                            rc0Var = rc0.b;
                        } else if (iOrdinal == 1) {
                            rc0Var = rc0.c;
                        } else if (iOrdinal != 2) {
                            if (iOrdinal != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            rc0Var = rc0.e;
                        } else {
                            rc0Var = rc0.d;
                        }
                        b9Var.a(viewC, rc0Var, pb2Var.a());
                    } catch (Exception e2) {
                        op0.c(new Object[0]);
                        this.g.reportError("Failed to execute safely", e2);
                    }
                }
            }
        }
        b9 b9Var2 = this.h;
        if (b9Var2 != null) {
            try {
                if (!this.k) {
                    b9Var2.b();
                }
            } catch (Exception e3) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e3);
            }
        }
        p3 p3Var = this.j;
        if (p3Var != null) {
            try {
                if (this.k) {
                    return;
                }
                se1 se1Var = this.f;
                gd2 gd2Var = this.c;
                sc2 sc2Var = this.b;
                se1Var.getClass();
                p3Var.a(se1.a(gd2Var, sc2Var));
            } catch (Exception e4) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e4);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void n() {
        p3 p3Var = this.j;
        if (p3Var != null) {
            try {
                if (this.k) {
                    return;
                }
                p3Var.a();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void m() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.a();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void f() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.c();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void j() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.b();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void d() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.g();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void c() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.h();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void b() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.d();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void e() {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.i();
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void k() {
        b9 b9Var = this.h;
        if (b9Var != null) {
            try {
                if (this.k) {
                    return;
                }
                b9Var.a();
                this.h = null;
                this.i = null;
                this.j = null;
                this.k = true;
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        m();
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(pc2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(eg2.a quartile) {
        Intrinsics.checkNotNullParameter(quartile, "quartile");
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (!this.k) {
                    int iOrdinal = quartile.ordinal();
                    if (iOrdinal == 0) {
                        zv0Var.e();
                    } else if (iOrdinal == 1) {
                        zv0Var.f();
                    } else if (iOrdinal == 2) {
                        zv0Var.j();
                    }
                }
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f, long j) {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.a(j / 1000, f);
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.eg2
    public final void a(float f) {
        zv0 zv0Var = this.i;
        if (zv0Var != null) {
            try {
                if (this.k) {
                    return;
                }
                zv0Var.a(f);
            } catch (Exception e) {
                op0.c(new Object[0]);
                this.g.reportError("Failed to execute safely", e);
            }
        }
    }
}

package com.ogury.ad.internal;

import android.app.Application;
import android.content.Context;
import android.widget.FrameLayout;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import com.ogury.core.internal.IntegrationLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f7300a;
    public final a3 b;
    public h c;
    public final r0 d;
    public final t0 e;
    public j4 f;
    public boolean g;
    public FrameLayout h;

    public static final class a implements r {
        public a() {
        }

        @Override // com.ogury.ad.internal.r
        public final void a(j4 adController, h adLayout) {
            Intrinsics.checkNotNullParameter(adLayout, "adLayout");
            Intrinsics.checkNotNullParameter(adController, "adController");
            g0 g0Var = g0.this;
            g0Var.c.d();
            j4 j4Var = g0Var.f;
            if (j4Var != null) {
                j4Var.g();
            }
            g0Var.f = null;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function2<c, List<c>, Unit> {
        public b(Object obj) {
            super(2, obj, g0.class, "showNextAd", "showNextAd(Lcom/ogury/ad/common/network/models/Ad;Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(c cVar, List<c> list) {
            c p0 = cVar;
            List<c> p1 = list;
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            g0 g0Var = (g0) this.receiver;
            Application context = g0Var.f7300a;
            Intrinsics.checkNotNullParameter(context, "context");
            h hVar = new h(context);
            hVar.setupDrag(false);
            g0Var.c = hVar;
            t0 t0Var = g0Var.e;
            t0Var.getClass();
            Intrinsics.checkNotNullParameter(hVar, "<set-?>");
            t0Var.f7403a = hVar;
            g0Var.f = g0Var.a();
            g0Var.a(p0, g0Var.h, p1, false);
            return Unit.INSTANCE;
        }
    }

    public g0(Application application) {
        InterstitialActivity.a interstitialShowCommand = InterstitialActivity.d;
        Intrinsics.checkNotNullParameter(application, "context");
        h adLayout = new h(application);
        adLayout.setupDrag(false);
        r0 adControllerFactory = new r0();
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        t0 sizeCalculator = new t0(adLayout, applicationContext);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(interstitialShowCommand, "interstitialShowCommand");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(adControllerFactory, "adControllerFactory");
        Intrinsics.checkNotNullParameter(sizeCalculator, "sizeCalculator");
        this.f7300a = application;
        this.b = interstitialShowCommand;
        this.c = adLayout;
        this.d = adControllerFactory;
        this.e = sizeCalculator;
        this.f = a();
    }

    public final j4 a() {
        r0 r0Var = this.d;
        Application application = this.f7300a;
        h adLayout = this.c;
        r0Var.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        q0 q0Var = new q0(adLayout, new z9());
        j4.a aVar = new j4.a(application, adLayout, new b2(o.SMALL_BANNER), false);
        Intrinsics.checkNotNullParameter(q0Var, "<set-?>");
        aVar.j = q0Var;
        j4 j4Var = new j4(aVar);
        a aVar2 = new a();
        Intrinsics.checkNotNullParameter(aVar2, "<set-?>");
        j4Var.D = aVar2;
        j4Var.C = new t8(new b(this));
        s0 s0Var = new s0();
        Intrinsics.checkNotNullParameter(s0Var, "<set-?>");
        j4Var.B = s0Var;
        return j4Var;
    }

    public final void b() {
        String str;
        j4 j4Var = this.f;
        if (j4Var == null) {
            return;
        }
        d5 d5Var = j4Var.q;
        if (d5Var == null || !d5Var.l) {
            j4Var.D.a(j4Var, j4Var.h);
        } else {
            c cVar = j4Var.v;
            if (cVar != null && (str = cVar.b) != null) {
                v4 v4Var = j4Var.g;
                u4 u4Var = new u4(str, "adClosed");
                v4Var.getClass();
                v4.a(u4Var);
            }
            j4Var.F = true;
        }
        j4Var.j();
    }

    public final void a(c cVar, FrameLayout frameLayout, List<c> list, boolean z) {
        j4 j4Var;
        if (frameLayout != null) {
            j4 j4Var2 = this.f;
            if (j4Var2 != null) {
                j4Var2.a(cVar, list);
            }
            this.g = cVar.d().a();
            frameLayout.addView(this.c);
            IntegrationLogger.d("[Ads][" + cVar.k().b() + "][show][" + cVar.b().a() + "] Ad succefully attached to the banner view");
            IntegrationLogger.d("[Ads][" + cVar.k().b() + "][show][" + cVar.b().a() + "] Waiting for adding banner view in a layout...");
            if ((!frameLayout.hasWindowFocus() || z) && (j4Var = this.f) != null) {
                j4Var.h();
            }
        }
    }
}

package com.ogury.ad.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import com.ogury.ad.interstitial.ui.InterstitialActivity;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f7374a;
    public final a7 b;
    public final a3 c;
    public z6 d;
    public h e;
    public final c7 f;
    public final g3 g;
    public j4 h;
    public final e8 i;
    public Activity j;

    public static final class a implements r {
        public a() {
        }

        @Override // com.ogury.ad.internal.r
        public final void a(j4 adController, h adLayout) {
            Intrinsics.checkNotNullParameter(adLayout, "adLayout");
            Intrinsics.checkNotNullParameter(adController, "adController");
            o6.this.a();
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function2<c, List<c>, Unit> {
        public b(Object obj) {
            super(2, obj, o6.class, "showNextAd", "showNextAd(Lcom/ogury/ad/common/network/models/Ad;Ljava/util/List;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(c cVar, List<c> list) {
            c p0 = cVar;
            List<c> p1 = list;
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            o6 o6Var = (o6) this.receiver;
            Activity activity = o6Var.j;
            if (activity != null) {
                h hVar = new h(o6Var.f7374a);
                o6Var.e = hVar;
                hVar.setContainsOverlayAd(true);
                o6Var.h = o6Var.b();
                o6Var.a(p0, p1, activity, true);
            }
            return Unit.INSTANCE;
        }
    }

    public o6(Application application, a7 overlayInjectorFactory) {
        InterstitialActivity.a interstitialShowCommand = InterstitialActivity.d;
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        h adLayout = new h(applicationContext);
        c7 mraidAdControllerFactory = new c7();
        g3 positionManager = g3.f7304a;
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(overlayInjectorFactory, "overlayInjectorFactory");
        Intrinsics.checkNotNullParameter(interstitialShowCommand, "interstitialShowCommand");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        Intrinsics.checkNotNullParameter(mraidAdControllerFactory, "mraidAdControllerFactory");
        Intrinsics.checkNotNullParameter(positionManager, "positionManager");
        this.f7374a = application;
        this.b = overlayInjectorFactory;
        this.c = interstitialShowCommand;
        this.d = null;
        this.e = adLayout;
        this.f = mraidAdControllerFactory;
        this.g = positionManager;
        this.i = new e8();
        this.e.setContainsOverlayAd(true);
        this.h = b();
    }

    public final void a(c cVar, List<c> list, Activity activity, boolean z) {
        z6 z6Var;
        z6 z6Var2 = this.d;
        if (z6Var2 != null) {
            z6Var2.a();
        }
        j4 j4Var = this.h;
        if (j4Var == null) {
            return;
        }
        this.d = this.b.a(activity, this.e, j4Var);
        String adUnitId = cVar.n.f7379a;
        g3 g3Var = this.g;
        h hVar = this.e;
        g3Var.getClass();
        g3.a(hVar, adUnitId);
        this.g.getClass();
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Rect rect = (Rect) g3.b.get(adUnitId);
        if (rect != null) {
            e8 e8Var = this.i;
            e8Var.d = rect.left;
            e8Var.e = rect.top;
        }
        j4 j4Var2 = this.h;
        if (j4Var2 != null) {
            e8 e8Var2 = this.i;
            int i = e8Var2.d;
            int i2 = e8Var2.e;
            e8 e8Var3 = j4Var2.y;
            e8Var3.d = i;
            e8Var3.e = i2;
        }
        j4Var.a(cVar, list);
        if (z && (z6Var = this.d) != null) {
            z6Var.b();
        }
        z6 z6Var3 = this.d;
        if (z6Var3 != null) {
            z6Var3.c();
        }
    }

    public final j4 b() {
        c7 c7Var = this.f;
        Application application = this.f7374a;
        h adLayout = this.e;
        c7Var.getClass();
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        j4 j4Var = new j4(new j4.a(application, adLayout, new b2(o.OVERLAY_THUMBNAIL), false));
        f7 f7Var = new f7();
        Intrinsics.checkNotNullParameter(f7Var, "<set-?>");
        j4Var.B = f7Var;
        a aVar = new a();
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        j4Var.D = aVar;
        j4Var.C = new u8(new b(this));
        return j4Var;
    }

    public final void a() {
        z6 z6Var = this.d;
        if (z6Var != null) {
            z6Var.a();
        }
        this.d = null;
        this.e.d();
        j4 j4Var = this.h;
        if (j4Var != null) {
            j4Var.g();
        }
        this.h = null;
    }
}

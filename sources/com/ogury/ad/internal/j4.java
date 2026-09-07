package com.ogury.ad.internal;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.iab.omid.library.ogury.Omid;
import com.iab.omid.library.ogury.adsession.AdSession;
import com.iab.omid.library.ogury.adsession.AdSessionConfiguration;
import com.ogury.ad.mraid.browser.listeners.CloseSystemDialogsListener;
import com.ogury.ad.mraid.browser.listeners.OrientationListener;
import com.ogury.core.internal.network.NetworkClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class j4 implements c5 {
    public r B;
    public s8 C;
    public r D;
    public r E;
    public boolean F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f7328a;
    public final t7 d;
    public final j9 e;
    public final e1 f;
    public final v4 g;
    public final h h;
    public final r i;
    public final f8 j;
    public boolean k;
    public final c2 l;
    public final z m;
    public final com.ogury.ad.internal.g n;
    public final d4 o;
    public boolean p;
    public d5 q;
    public n4 r;
    public boolean s;
    public i5 u;
    public com.ogury.ad.internal.c v;
    public d1 x;
    public final i5.a b = i5.l;
    public final t9.a c = t9.f;
    public boolean t = true;
    public List<com.ogury.ad.internal.c> w = new ArrayList();
    public final e8 y = new e8();
    public final View.OnLayoutChangeListener z = f();
    public int A = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Application f7329a;
        public final h b;
        public final r c;
        public final boolean d;
        public final t7 e;
        public final j9 f;
        public final e1 g;
        public final v4 h;
        public final f8 i;
        public c2 j;
        public final z k;
        public final com.ogury.ad.internal.g l;
        public final d4 m;

        public a(Application application, h adLayout, r expandCommand, boolean z) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(adLayout, "adLayout");
            Intrinsics.checkNotNullParameter(expandCommand, "expandCommand");
            this.f7329a = application;
            this.b = adLayout;
            this.c = expandCommand;
            this.d = z;
            this.e = t7.f7405a;
            this.f = new j9(new j6());
            this.g = e1.f7287a;
            this.h = v4.f7421a;
            Intrinsics.checkNotNullParameter(application, "application");
            this.i = new f8();
            this.j = new x2(adLayout);
            this.k = new z(application);
            this.l = new com.ogury.ad.internal.g(application);
            d4.a aVar = d4.e;
            Context applicationContext = application.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            this.m = aVar.a(applicationContext);
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, j4.class, "handleNewOguryBrowserWebViewCreated", "handleNewOguryBrowserWebViewCreated()V", 0);
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        /* JADX WARN: Code duplicated, block: B:12:0x0025  */
        /* JADX WARN: Code duplicated, block: B:14:0x0029  */
        /* JADX WARN: Code duplicated, block: B:17:0x0034  */
        /* JADX WARN: Code duplicated, block: B:18:0x0038  */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            d5 d5Var;
            d5 d5Var2;
            j4 j4Var = (j4) this.receiver;
            d5 d5Var3 = null;
            if (j4Var.k) {
                d5 d5Var4 = j4Var.q;
                if (d5Var4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    d5Var4 = null;
                }
                if (!Intrinsics.areEqual(d5Var4.getAdState(), "default")) {
                    d5Var = j4Var.q;
                    if (d5Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                        d5Var = null;
                    }
                    d5Var.setMultiBrowserOpened(true);
                    d5Var2 = j4Var.q;
                    if (d5Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        d5Var3 = d5Var2;
                    }
                    d5Var3.setVisibility(4);
                    j4Var.h();
                    j4Var.b();
                } else if (!j4Var.k) {
                    d5Var = j4Var.q;
                    if (d5Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                        d5Var = null;
                    }
                    d5Var.setMultiBrowserOpened(true);
                    d5Var2 = j4Var.q;
                    if (d5Var2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                    } else {
                        d5Var3 = d5Var2;
                    }
                    d5Var3.setVisibility(4);
                    j4Var.h();
                    j4Var.b();
                }
            } else if (!j4Var.k) {
                d5Var = j4Var.q;
                if (d5Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    d5Var = null;
                }
                d5Var.setMultiBrowserOpened(true);
                d5Var2 = j4Var.q;
                if (d5Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    d5Var3 = d5Var2;
                }
                d5Var3.setVisibility(4);
                j4Var.h();
                j4Var.b();
            }
            com.ogury.ad.internal.c cVar = j4Var.v;
            if (cVar != null) {
                Intrinsics.checkNotNullParameter(cVar, "<this>");
                if (!cVar.x.c()) {
                    j4Var.k = true;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, j4.class, "closeAd", "closeAd()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            j4 j4Var = (j4) this.receiver;
            j4Var.D.a(j4Var, j4Var.h);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function0<Unit> {
        public d(Object obj) {
            super(0, obj, j4.class, "resumeAd", "resumeAd()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((j4) this.receiver).i();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function0<Unit> {
        public e(Object obj) {
            super(0, obj, j4.class, "pauseAd", "pauseAd()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((j4) this.receiver).h();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function0<Unit> {
        public f(Object obj) {
            super(0, obj, j4.class, "onAttachToWindow", "onAttachToWindow()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            j4 j4Var = (j4) this.receiver;
            if (j4Var.h.b()) {
                j4Var.i();
            }
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class g extends FunctionReferenceImpl implements Function0<Unit> {
        public g(Object obj) {
            super(0, obj, j4.class, "pauseAd", "pauseAd()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((j4) this.receiver).h();
            return Unit.INSTANCE;
        }
    }

    public j4(a aVar) {
        this.f7328a = aVar.f7329a;
        this.d = aVar.e;
        this.e = aVar.f;
        this.f = aVar.g;
        this.g = aVar.h;
        this.h = aVar.b;
        this.i = aVar.c;
        this.j = aVar.i;
        this.k = aVar.d;
        this.l = aVar.j;
        this.m = aVar.k;
        this.n = aVar.l;
        this.o = aVar.m;
        r5 r5Var = r5.f7394a;
        this.B = r5Var;
        this.D = r5Var;
        this.E = r5Var;
    }

    public final void a(int i) {
        if (this.A != 4) {
            this.A = i;
        }
    }

    @Override // com.ogury.ad.internal.c5
    public final void b() {
        if (e()) {
            return;
        }
        this.i.a(this, this.h);
        String state = this.k ? "default" : "expanded";
        n4 n4Var = this.r;
        if (n4Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
            n4Var = null;
        }
        n4Var.getClass();
        Intrinsics.checkNotNullParameter(state, "state");
        h5.a(n4Var.f7364a, o4.c(state));
        n4Var.f7364a.setAdState(state);
    }

    @Override // com.ogury.ad.internal.c5
    public final void c() {
        e8 resizeProps = this.h.getResizeProps();
        if (resizeProps == null) {
            throw new IllegalStateException("setResizeProperties must be called first".toString());
        }
        if (!this.j.a(this.h, resizeProps)) {
            throw new IllegalArgumentException("Invalid resize command".toString());
        }
        n4 n4Var = this.r;
        if (n4Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
            n4Var = null;
        }
        n4Var.getClass();
        Intrinsics.checkNotNullParameter("resized", "state");
        h5.a(n4Var.f7364a, o4.c("resized"));
        n4Var.f7364a.setAdState("resized");
        this.B.a(this, this.h);
    }

    @Override // com.ogury.ad.internal.c5
    public final void d() {
        d1 d1Var = this.x;
        if (d1Var != null) {
            d1Var.f.removeCallbacksAndMessages(null);
            d1Var.e.setVisibility(8);
        }
    }

    public final boolean e() {
        d5 d5Var = this.q;
        d5 d5Var2 = null;
        if (d5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var = null;
        }
        if (!Intrinsics.areEqual(d5Var.getAdState(), "expanded")) {
            if (this.k) {
                d5 d5Var3 = this.q;
                if (d5Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                } else {
                    d5Var2 = d5Var3;
                }
                if (Intrinsics.areEqual(d5Var2.getAdState(), "default")) {
                }
            }
            return false;
        }
        return true;
    }

    public final View.OnLayoutChangeListener f() {
        return new View.OnLayoutChangeListener() { // from class: com.ogury.ad.internal.j4$$ExternalSyntheticLambda2
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                j4.a(this.f$0, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
    }

    public final void g() {
        String str;
        h6 h6Var;
        AdSession adSession;
        String str2;
        if (this.A != 4) {
            u3.f7411a.getClass();
            Intrinsics.checkNotNullParameter("destroying ad", "message");
            a(4);
            this.l.a();
            i5 i5Var = this.u;
            if (i5Var != null) {
                for (d5 webView : i5Var.e.a()) {
                    w4 w4Var = webView.p;
                    w4Var.getClass();
                    Intrinsics.checkNotNullParameter(webView, "webView");
                    w4Var.c.a(webView.getMraidCommandExecutor());
                }
                OrientationListener orientationListener = i5Var.f;
                orientationListener.getClass();
                try {
                    orientationListener.f7483a.unregisterReceiver(orientationListener.d);
                } catch (Exception e2) {
                    Intrinsics.checkNotNullParameter(e2, "<this>");
                    u3.f7411a.getClass();
                }
                CloseSystemDialogsListener closeSystemDialogsListener = i5Var.i;
                closeSystemDialogsListener.getClass();
                try {
                    closeSystemDialogsListener.f7481a.unregisterReceiver(closeSystemDialogsListener.c);
                } catch (Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "<this>");
                    u3.f7411a.getClass();
                }
                m5 m5Var = i5Var.j;
                if (m5Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiWebViewUrlHandler");
                    m5Var = null;
                }
                m5Var.c = null;
            }
            d1 d1Var = this.x;
            if (d1Var != null) {
                d1Var.f.removeCallbacksAndMessages(null);
            }
            com.ogury.ad.internal.c cVar = this.v;
            if (cVar == null || (str = cVar.b) == null) {
                str = "";
            }
            if (!this.p && cVar != null) {
                d4 d4Var = this.o;
                o7 o7Var = o7.SI_013_SDK_EVENT_AD_CLOSED;
                Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
                r3 r3Var = cVar.A.f7388a;
                Intrinsics.checkNotNullParameter(r3Var, "<this>");
                int iOrdinal = r3Var.ordinal();
                if (iOrdinal == 0) {
                    str2 = "format";
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str2 = "sdk";
                }
                Pair pair2 = TuplesKt.to("loaded_source", str2);
                Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
                int i = cVar.K;
                d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
            }
            v4 v4Var = this.g;
            u4 u4Var = new u4(str, "adClosed");
            v4Var.getClass();
            v4.a(u4Var);
            j6 j6Var = this.e.f7333a;
            j6Var.getClass();
            if (Omid.isActive() && (h6Var = j6Var.f7331a) != null && (adSession = h6Var.f7315a) != null) {
                adSession.finish();
            }
            h hVar = this.h;
            hVar.f = null;
            hVar.h = null;
            hVar.i = null;
            hVar.j = null;
            hVar.k = null;
            hVar.g = null;
            hVar.l = null;
            hVar.removeAllViews();
            this.B = r5.f7394a;
            d5 d5Var = this.q;
            if (d5Var != null) {
                d5Var.d = null;
                d5Var.setClientAdapter(null);
                d5Var.i = j1.b;
                d5Var.g = null;
            }
        }
    }

    public final void h() {
        d5 d5Var = this.q;
        n4 n4Var = null;
        if (d5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var = null;
        }
        if (!d5Var.k) {
            u3.f7411a.getClass();
            Intrinsics.checkNotNullParameter("ad already paused", "message");
            return;
        }
        u3.f7411a.getClass();
        Intrinsics.checkNotNullParameter("pauseAd", "message");
        d5 d5Var2 = this.q;
        if (d5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var2 = null;
        }
        d5Var2.setResumed(false);
        ViewGroup parentAsViewGroup = this.h.getParentAsViewGroup();
        if (parentAsViewGroup != null) {
            parentAsViewGroup.removeOnLayoutChangeListener(this.z);
        }
        com.ogury.ad.internal.e eVar = new com.ogury.ad.internal.e();
        eVar.c = 0.0f;
        n4 n4Var2 = this.r;
        if (n4Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
        } else {
            n4Var = n4Var2;
        }
        n4Var.a(eVar);
    }

    public final void i() {
        ViewGroup parentAsViewGroup;
        d5 d5Var = this.q;
        d5 d5Var2 = null;
        if (d5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var = null;
        }
        if (d5Var.k) {
            u3.f7411a.getClass();
            Intrinsics.checkNotNullParameter("ad already resumed", "message");
            return;
        }
        u3.f7411a.getClass();
        Intrinsics.checkNotNullParameter("resumeAd", "message");
        d5 d5Var3 = this.q;
        if (d5Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        } else {
            d5Var2 = d5Var3;
        }
        d5Var2.setResumed(true);
        if (this.k && (parentAsViewGroup = this.h.getParentAsViewGroup()) != null) {
            parentAsViewGroup.addOnLayoutChangeListener(this.z);
        }
        if (this.A != 2) {
            a(1);
        }
        this.l.b();
    }

    public final void j() {
        String str;
        com.ogury.ad.internal.c cVar = this.v;
        if (cVar == null || (str = cVar.b) == null) {
            str = "";
        }
        v4 v4Var = this.g;
        u4 u4Var = new u4(str, "closeWhithoutShowNextAd");
        v4Var.getClass();
        v4.a(u4Var);
    }

    public final void k() {
        this.h.setAdLayoutChangeListener(new Function1() { // from class: com.ogury.ad.internal.j4$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return j4.a(this.f$0, (h) obj);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0204  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.iab.omid.library.ogury.adsession.AdSession] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.iab.omid.library.ogury.adsession.AdSessionContext] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24, types: [com.iab.omid.library.ogury.adsession.AdSessionConfiguration] */
    /* JADX WARN: Type inference failed for: r4v27 */
    public final void a(final com.ogury.ad.internal.c ad, List<com.ogury.ad.internal.c> notDisplayedAds) {
        String str;
        d5 d5Var;
        d5 adWebView;
        d5 d5Var2;
        d5 d5Var3;
        ?? r0;
        ?? r4;
        ?? r1;
        AdSessionConfiguration adSessionConfiguration;
        d1 d1Var;
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(notDisplayedAds, "notDisplayedAds");
        d4 d4Var = this.o;
        o7 o7Var = o7.SI_003_SDK_EVENT_AD_DISPLAYING;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(ad.H));
        r3 r3Var = ad.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str = "format";
        } else if (iOrdinal == 1) {
            str = "sdk";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Pair pair2 = TuplesKt.to("loaded_source", str);
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(ad.J));
        int i = ad.K;
        d4Var.a(o7Var, ad, p7.a(pair, pair2, pair3, TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null)));
        this.w = notDisplayedAds;
        this.v = ad;
        com.ogury.ad.internal.g gVar = this.n;
        gVar.f = ad;
        c2 c2Var = this.l;
        if (c2Var != null) {
            c2Var.a(gVar);
        }
        gVar.g = c2Var;
        this.E.a(this, this.h);
        h frameLayout = this.h;
        Intrinsics.checkNotNullParameter(ad, "<this>");
        if (!ad.x.c()) {
            e1 e1Var = this.f;
            Application context = this.f7328a;
            Intrinsics.checkNotNullParameter(context, "context");
            if (x5.c == null) {
                int millis = (int) TimeUnit.SECONDS.toMillis(t7.b.b.f7468a);
                Context context2 = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getApplicationContext(...)");
                Intrinsics.checkNotNullParameter(context2, "context");
                Context applicationContext = context2.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                x5.c = new x5(new m2(applicationContext), new NetworkClient(millis, millis * 5));
            }
            x5 oguryApi = x5.c;
            Intrinsics.checkNotNull(oguryApi);
            String closeButtonUrl = ad.r;
            e1Var.getClass();
            Intrinsics.checkNotNullParameter(this, "adController");
            Intrinsics.checkNotNullParameter(frameLayout, "frameLayout");
            Intrinsics.checkNotNullParameter(oguryApi, "oguryApi");
            Intrinsics.checkNotNullParameter(closeButtonUrl, "closeButtonUrl");
            this.x = new d1(this, frameLayout, oguryApi, closeButtonUrl);
        }
        i2 foregroundHandlerFactory = new i2(this.f7328a, this);
        i5.a aVar = this.b;
        Application context3 = this.f7328a;
        h activityRoot = this.h;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context3, "context");
        Intrinsics.checkNotNullParameter(ad, "ad");
        Intrinsics.checkNotNullParameter(activityRoot, "activityRoot");
        Intrinsics.checkNotNullParameter(foregroundHandlerFactory, "mraidHandlersFactory");
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        Map mapSynchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap2, "synchronizedMap(...)");
        y0 y0Var = new y0(context3, activityRoot, ad);
        k5 k5Var = new k5(mapSynchronizedMap, mapSynchronizedMap2);
        OrientationListener orientationListener = new OrientationListener(context3, k5Var);
        CloseSystemDialogsListener closeSystemDialogsListener = new CloseSystemDialogsListener(context3, k5Var);
        z3 z3Var = z3.f7460a;
        i5 multiWebViewBrowser = new i5(ad, mapSynchronizedMap, mapSynchronizedMap2, y0Var, k5Var, orientationListener, d4.e.a(context3), foregroundHandlerFactory, closeSystemDialogsListener);
        multiWebViewBrowser.j = new m5(multiWebViewBrowser, k5Var);
        this.u = multiWebViewBrowser;
        b newWebViewCreatedCallback = new b(this);
        Intrinsics.checkNotNullParameter(newWebViewCreatedCallback, "newWebViewCreatedCallback");
        m5 m5Var = multiWebViewBrowser.j;
        if (m5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiWebViewUrlHandler");
            m5Var = null;
        }
        m5Var.c = newWebViewCreatedCallback;
        c newForceCloseCallback = new c(this);
        Intrinsics.checkNotNullParameter(newForceCloseCallback, "newForceCloseCallback");
        Intrinsics.checkNotNullParameter(ad, "<this>");
        if (!ad.x.c()) {
            m5 m5Var2 = multiWebViewBrowser.j;
            if (m5Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiWebViewUrlHandler");
                m5Var2 = null;
            }
            m5Var2.d = newForceCloseCallback;
        }
        t9.a aVar2 = this.c;
        Function2 handleOnRenderProcessGone = new Function2() { // from class: com.ogury.ad.internal.j4$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return j4.a(this.f$0, ad, ((Boolean) obj).booleanValue(), (Uri) obj2);
            }
        };
        aVar2.getClass();
        Intrinsics.checkNotNullParameter(multiWebViewBrowser, "multiWebViewBrowser");
        Intrinsics.checkNotNullParameter(foregroundHandlerFactory, "foregroundHandlerFactory");
        Intrinsics.checkNotNullParameter(handleOnRenderProcessGone, "handleOnRenderProcessGone");
        m4 m4Var = m4.f7354a;
        m5 m5Var3 = multiWebViewBrowser.j;
        if (m5Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiWebViewUrlHandler");
            m5Var3 = null;
        }
        t9 t9Var = new t9(m5Var3, foregroundHandlerFactory, handleOnRenderProcessGone);
        Intrinsics.checkNotNullParameter(ad, "ad");
        t9Var.e = ad;
        String cacheId = ad.f7272a;
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        ConcurrentHashMap concurrentHashMap = m4.b;
        if (concurrentHashMap.containsKey(cacheId)) {
            l4 l4Var = (l4) concurrentHashMap.get(cacheId);
            d5Var = l4Var != null ? l4Var.b : null;
            concurrentHashMap.remove(cacheId);
            if (d5Var != null && d5Var.f) {
                d5Var = null;
            }
        } else {
            d5Var = null;
        }
        if (d5Var == null) {
            adWebView = null;
        } else {
            t9Var.d = d5Var;
            d5Var.setMraidUrlHandler(new j1(new b5[]{t9Var.f7407a, t9Var.b.a(d5Var)}));
            WebSettings settings = d5Var.getSettings();
            if (settings != null) {
                settings.setJavaScriptEnabled(true);
            }
            ca.b((WebView) d5Var);
            ca.c(d5Var);
            d5 d5Var4 = t9Var.d;
            if (d5Var4 != null) {
                d5Var4.setClientAdapter(new u9(t9Var));
            }
            d5 webView = t9Var.d;
            if (webView != null) {
                w4 w4Var = webView.p;
                w4Var.getClass();
                Intrinsics.checkNotNullParameter(webView, "webView");
                w4Var.f7429a.a(webView.getMraidCommandExecutor());
            }
            adWebView = t9Var.d;
        }
        if (adWebView != null) {
            this.q = adWebView;
            this.r = adWebView.getMraidCommandExecutor();
            String webViewName = ad.k;
            if (webViewName.length() == 0) {
                webViewName = "controller";
            }
            boolean z = ad.w;
            Intrinsics.checkNotNullParameter(webViewName, "webViewName");
            Intrinsics.checkNotNullParameter(adWebView, "webView");
            adWebView.setTag(webViewName);
            mapSynchronizedMap.put(webViewName, adWebView);
            mapSynchronizedMap2.put(webViewName, new aa(false, z, "", true, 48));
            this.d.getClass();
            z7 profig = t7.b;
            z7.o oVar = profig.d.e;
            this.s = oVar.f7475a;
            this.t = oVar.b;
            d1 d1Var2 = this.x;
            if (d1Var2 != null) {
                d1Var2.a(TimeUnit.SECONDS.toMillis(oVar.d));
            }
            if (adWebView.getShowSdkCloseButton() || (d1Var = this.x) == null) {
                d5Var2 = null;
            } else {
                d5Var2 = null;
                d1Var.f.removeCallbacksAndMessages(null);
                d1Var.e.setVisibility(8);
            }
            this.h.addView(adWebView, new FrameLayout.LayoutParams(-1, -1));
            if (ad.x.e() && !this.k) {
                e8 e8Var = this.y;
                r6 r6Var = ad.m;
                e8Var.b = r6Var.b;
                e8Var.c = r6Var.c;
                this.h.setInitialSize(e8Var);
                this.h.setupDrag(ad.m.f7395a);
            }
            j9 j9Var = this.e;
            j9Var.getClass();
            Intrinsics.checkNotNullParameter(profig, "profig");
            Intrinsics.checkNotNullParameter(ad, "ad");
            Intrinsics.checkNotNullParameter(adWebView, "webView");
            if (profig.f.f7470a && ad.p) {
                j6 j6Var = j9Var.f7333a;
                boolean z2 = ad.q;
                j6Var.getClass();
                Intrinsics.checkNotNullParameter(adWebView, "webView");
                if (Omid.isActive()) {
                    h6 h6Var = new h6();
                    j6Var.f7331a = h6Var;
                    Intrinsics.checkNotNullParameter(adWebView, "adWebView");
                    h6Var.b.getClass();
                    Intrinsics.checkNotNullParameter(adWebView, "adWebView");
                    try {
                        d6 d6VarA = c6.a(adWebView, z2);
                        if (d6VarA != null) {
                            adSessionConfiguration = d6VarA.b;
                        } else {
                            r4 = d5Var2;
                        }
                        if (d6VarA != null) {
                            r4 = adSessionConfiguration;
                            r1 = d6VarA.f7281a;
                        } else {
                            r4 = adSessionConfiguration;
                            r1 = d5Var2;
                        }
                        AdSession adSessionCreateAdSession = AdSession.createAdSession(r4, r1);
                        adSessionCreateAdSession.registerAdView(adWebView);
                        r0 = adSessionCreateAdSession;
                    } catch (Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        r0 = d5Var2;
                    }
                    h6Var.f7315a = r0;
                    if (r0 != 0) {
                        r0.start();
                    }
                }
            }
            k();
            d5 d5Var5 = this.q;
            if (d5Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                d5Var3 = d5Var2;
            } else {
                d5Var3 = d5Var5;
            }
            d5Var3.setVisibilityChangedListener(new k4(this));
            this.h.setOnWindowGainFocusListener(new d(this));
            this.h.setOnWindowLoseFocusListener(new e(this));
            this.h.setOnAttachToWindowListener(new f(this));
            this.h.setOnDetachFromWindowListener(new g(this));
            return;
        }
        throw new IllegalStateException("WebView must not be null".toString());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:13:0x0024  */
    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0060  */
    /* JADX WARN: Code duplicated, block: B:28:0x0066  */
    @Override // com.ogury.ad.internal.c5
    public final void b(boolean z) {
        d5 d5Var;
        d5 d5Var2;
        d5 d5Var3;
        n4 n4Var;
        d5 d5Var4 = this.q;
        n4 n4Var2 = null;
        if (d5Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var4 = null;
        }
        if (d5Var4.l) {
            com.ogury.ad.internal.c cVar = this.v;
            if (cVar != null) {
                Intrinsics.checkNotNullParameter(cVar, "<this>");
                if (cVar.x.c()) {
                    d5Var = this.q;
                    if (d5Var == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("webView");
                        d5Var = null;
                    }
                    if (!Intrinsics.areEqual(d5Var.getAdState(), "default")) {
                        d5Var2 = this.q;
                        if (d5Var2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("webView");
                            d5Var2 = null;
                        }
                        d5Var2.setMultiBrowserOpened(false);
                        d5Var3 = this.q;
                        if (d5Var3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("webView");
                            d5Var3 = null;
                        }
                        d5Var3.setVisibility(0);
                        this.h.e();
                        this.B.a(this, this.h);
                        n4Var = this.r;
                        if (n4Var == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
                        } else {
                            n4Var2 = n4Var;
                        }
                        n4Var2.getClass();
                        Intrinsics.checkNotNullParameter("default", "state");
                        h5.a(n4Var2.f7364a, o4.c("default"));
                        n4Var2.f7364a.setAdState("default");
                        return;
                    }
                }
            }
        } else {
            d5Var = this.q;
            if (d5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                d5Var = null;
            }
            if (!Intrinsics.areEqual(d5Var.getAdState(), "default") && !this.k) {
                d5Var2 = this.q;
                if (d5Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    d5Var2 = null;
                }
                d5Var2.setMultiBrowserOpened(false);
                d5Var3 = this.q;
                if (d5Var3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                    d5Var3 = null;
                }
                d5Var3.setVisibility(0);
                this.h.e();
                this.B.a(this, this.h);
                n4Var = this.r;
                if (n4Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
                } else {
                    n4Var2 = n4Var;
                }
                n4Var2.getClass();
                Intrinsics.checkNotNullParameter("default", "state");
                h5.a(n4Var2.f7364a, o4.c("default"));
                n4Var2.f7364a.setAdState("default");
                return;
            }
        }
        a(z);
    }

    public static final Unit a(j4 j4Var, com.ogury.ad.internal.c cVar, boolean z, Uri failingUri) {
        String str;
        Intrinsics.checkNotNullParameter(failingUri, "failingUri");
        d4 d4Var = j4Var.o;
        o7 o7Var = o7.SI_017_SDK_EVENT_WEBVIEW_TERMINATED;
        Pair pair = TuplesKt.to("from_ad_markup", Boolean.valueOf(cVar.H));
        r3 r3Var = cVar.A.f7388a;
        Intrinsics.checkNotNullParameter(r3Var, "<this>");
        int iOrdinal = r3Var.ordinal();
        if (iOrdinal == 0) {
            str = "format";
        } else if (iOrdinal == 1) {
            str = "sdk";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Pair pair2 = TuplesKt.to("loaded_source", str);
        Pair pair3 = TuplesKt.to("reload", Boolean.valueOf(cVar.J));
        int i = cVar.K;
        Uri uriBuild = null;
        Pair pair4 = TuplesKt.to("webview_termination", i > 0 ? Integer.valueOf(i) : null);
        Pair pair5 = TuplesKt.to("cause", z ? "WebView crash" : "WebView removed");
        if (z) {
            Uri.Builder builder = new Uri.Builder();
            builder.scheme(failingUri.getScheme());
            builder.authority(failingUri.getAuthority());
            builder.path(failingUri.getPath());
            Unit unit = Unit.INSTANCE;
            uriBuild = builder.build();
        }
        d4Var.a(o7Var, cVar, p7.a(pair, pair2, pair3, pair4, pair5, TuplesKt.to("failing_url", uriBuild)));
        j4Var.p = true;
        j4Var.b(false);
        return Unit.INSTANCE;
    }

    public static final Unit a(j4 j4Var, h adLayout) {
        Intrinsics.checkNotNullParameter(adLayout, "adLayout");
        n4 n4Var = j4Var.r;
        n4 n4Var2 = null;
        if (n4Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
            n4Var = null;
        }
        h5.a(n4Var.f7364a, o4.a(j7.b(adLayout.getWidth()), j7.b(adLayout.getHeight()), j7.a(adLayout.getX()), j7.a(adLayout.getY())));
        j4Var.l.b();
        z zVar = j4Var.m;
        d5 d5Var = j4Var.q;
        if (d5Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var = null;
        }
        Rect rectA = zVar.a(d5Var);
        n4 n4Var3 = j4Var.r;
        if (n4Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mraidCommandExecutor");
        } else {
            n4Var2 = n4Var3;
        }
        h5.a(n4Var2.f7364a, o4.b(j7.b(rectA.width()), j7.b(rectA.height())));
        return Unit.INSTANCE;
    }

    public static final void a(j4 j4Var, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        d5 d5Var = j4Var.q;
        if (d5Var == null || Intrinsics.areEqual(d5Var.getAdState(), "hidden")) {
            return;
        }
        d5 d5Var2 = j4Var.q;
        if (d5Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
            d5Var2 = null;
        }
        if (ca.b(d5Var2)) {
            j4Var.l.b();
        }
    }

    @Override // com.ogury.ad.internal.c5
    public final void a() {
        d1 d1Var = this.x;
        if (d1Var != null) {
            d1Var.e.setVisibility(0);
        }
    }

    @Override // com.ogury.ad.internal.c5
    public final void a(String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        if (!this.k) {
            d5 d5Var = this.q;
            if (d5Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
                d5Var = null;
            }
            if (!Intrinsics.areEqual(d5Var.getAdState(), "hidden")) {
                return;
            }
        }
        s8 s8Var = this.C;
        if (s8Var == null || !s8Var.a(this.f7328a, this.w, adId)) {
            j();
        }
    }

    @Override // com.ogury.ad.internal.c5
    public final void a(e8 e8Var) {
        this.h.setResizeProps(e8Var);
    }

    @Override // com.ogury.ad.internal.c5
    public final void a(boolean z) {
        this.D.a(this, this.h);
        if (z) {
            return;
        }
        j();
    }
}

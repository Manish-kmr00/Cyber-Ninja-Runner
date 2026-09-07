package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ut1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10418a;
    private final uu1 b;
    private final o3 c;
    private final o8<String> d;
    private final jp0 e;
    private final nj f;
    private final bj g;
    private final h21 h;
    private final wg0 i;
    private final qj j;
    private final xi k;
    private a l;

    public ut1(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, o8 adResponse, jp0 adView, zi bannerShowEventListener, bj sizeValidator, h21 mraidCompatibilityDetector, wg0 htmlWebViewAdapterFactoryProvider, qj bannerWebViewFactory, xi bannerAdContentControllerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(bannerShowEventListener, "bannerShowEventListener");
        Intrinsics.checkNotNullParameter(sizeValidator, "sizeValidator");
        Intrinsics.checkNotNullParameter(mraidCompatibilityDetector, "mraidCompatibilityDetector");
        Intrinsics.checkNotNullParameter(htmlWebViewAdapterFactoryProvider, "htmlWebViewAdapterFactoryProvider");
        Intrinsics.checkNotNullParameter(bannerWebViewFactory, "bannerWebViewFactory");
        Intrinsics.checkNotNullParameter(bannerAdContentControllerFactory, "bannerAdContentControllerFactory");
        this.f10418a = context;
        this.b = sdkEnvironmentModule;
        this.c = adConfiguration;
        this.d = adResponse;
        this.e = adView;
        this.f = bannerShowEventListener;
        this.g = sizeValidator;
        this.h = mraidCompatibilityDetector;
        this.i = htmlWebViewAdapterFactoryProvider;
        this.j = bannerWebViewFactory;
        this.k = bannerAdContentControllerFactory;
    }

    public final void a(zy1 configurationSizeInfo, String htmlResponse, ie2 videoEventController, dv1<ut1> creationListener) throws lj2 {
        Intrinsics.checkNotNullParameter(configurationSizeInfo, "configurationSizeInfo");
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Intrinsics.checkNotNullParameter(videoEventController, "videoEventController");
        Intrinsics.checkNotNullParameter(creationListener, "creationListener");
        pj pjVarA = this.j.a(this.d, configurationSizeInfo);
        this.h.getClass();
        boolean zA = h21.a(htmlResponse);
        xi xiVar = this.k;
        Context context = this.f10418a;
        o8<String> adResponse = this.d;
        o3 adConfiguration = this.c;
        jp0 adView = this.e;
        nj bannerShowEventListener = this.f;
        xiVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(bannerShowEventListener, "bannerShowEventListener");
        wi wiVar = new wi(context, adResponse, adConfiguration, adView, bannerShowEventListener, new et0());
        mk0 mk0VarJ = wiVar.j();
        Context context2 = this.f10418a;
        uu1 uu1Var = this.b;
        o3 o3Var = this.c;
        b bVar = new b(context2, uu1Var, o3Var, this.d, this, wiVar, creationListener, new rg0(context2, o3Var));
        this.i.getClass();
        ug0 ug0VarA = (zA ? new m21() : new lk()).a(pjVarA, bVar, videoEventController, mk0VarJ);
        this.l = new a(wiVar, ug0VarA, bVar);
        ug0VarA.a(htmlResponse);
    }

    public static final class b implements ah0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f10420a;
        private final uu1 b;
        private final o3 c;
        private final o8<String> d;
        private final ut1 e;
        private final wi f;
        private dv1<ut1> g;
        private final rg0 h;
        private WebView i;
        private Map<String, String> j;

        public b(Context context, uu1 sdkEnvironmentModule, o3 adConfiguration, o8<String> adResponse, ut1 bannerHtmlAd, wi contentController, dv1<ut1> creationListener, rg0 htmlClickHandler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
            Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
            Intrinsics.checkNotNullParameter(adResponse, "adResponse");
            Intrinsics.checkNotNullParameter(bannerHtmlAd, "bannerHtmlAd");
            Intrinsics.checkNotNullParameter(contentController, "contentController");
            Intrinsics.checkNotNullParameter(creationListener, "creationListener");
            Intrinsics.checkNotNullParameter(htmlClickHandler, "htmlClickHandler");
            this.f10420a = context;
            this.b = sdkEnvironmentModule;
            this.c = adConfiguration;
            this.d = adResponse;
            this.e = bannerHtmlAd;
            this.f = contentController;
            this.g = creationListener;
            this.h = htmlClickHandler;
        }

        @Override // com.yandex.mobile.ads.impl.ah0
        public final void a(boolean z) {
        }

        public final WebView b() {
            return this.i;
        }

        public final Map<String, String> a() {
            return this.j;
        }

        @Override // com.yandex.mobile.ads.impl.ah0
        public final void a(w3 adFetchRequestError) {
            Intrinsics.checkNotNullParameter(adFetchRequestError, "adFetchRequestError");
            this.g.a(adFetchRequestError);
        }

        @Override // com.yandex.mobile.ads.impl.ah0
        public final void a(uf1 webView, Map trackingParameters) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
            this.i = webView;
            this.j = trackingParameters;
            this.g.a(this.e);
        }

        @Override // com.yandex.mobile.ads.impl.ah0
        public final void a(String clickUrl) {
            Intrinsics.checkNotNullParameter(clickUrl, "clickUrl");
            Context context = this.f10420a;
            uu1 uu1Var = this.b;
            this.h.a(clickUrl, this.d, new u1(context, this.d, this.f.i(), uu1Var, this.c));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final wi f10419a;
        private final ug0 b;
        private final b c;

        public a(wi contentController, ug0 htmlWebViewAdapter, b webViewListener) {
            Intrinsics.checkNotNullParameter(contentController, "contentController");
            Intrinsics.checkNotNullParameter(htmlWebViewAdapter, "htmlWebViewAdapter");
            Intrinsics.checkNotNullParameter(webViewListener, "webViewListener");
            this.f10419a = contentController;
            this.b = htmlWebViewAdapter;
            this.c = webViewListener;
        }

        public final wi a() {
            return this.f10419a;
        }

        public final ug0 b() {
            return this.b;
        }

        public final b c() {
            return this.c;
        }
    }

    public final void a() {
        a aVar = this.l;
        if (aVar != null) {
            aVar.b().invalidate();
            aVar.a().c();
        }
        this.l = null;
    }

    public final void a(rt1 showEventListener) {
        Intrinsics.checkNotNullParameter(showEventListener, "showEventListener");
        a aVar = this.l;
        if (aVar == null) {
            showEventListener.a(w7.i());
            return;
        }
        wi wiVarA = aVar.a();
        WebView contentView = aVar.c().b();
        Map<String, String> mapA = aVar.c().a();
        if (contentView instanceof pj) {
            pj pjVar = (pj) contentView;
            zy1 zy1VarO = pjVar.o();
            zy1 zy1VarR = this.c.r();
            if (zy1VarO != null && zy1VarR != null && bz1.a(this.f10418a, this.d, zy1VarO, this.g, zy1VarR)) {
                this.e.setVisibility(0);
                jp0 jp0Var = this.e;
                wt1 wt1Var = new wt1(jp0Var, wiVarA, new et0(), new wt1.a(jp0Var));
                Context context = this.f10418a;
                jp0 jp0Var2 = this.e;
                zy1 zy1VarO2 = pjVar.o();
                int i = rg2.b;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(contentView, "contentView");
                if (jp0Var2 != null && jp0Var2.indexOfChild(contentView) == -1) {
                    RelativeLayout.LayoutParams layoutParamsA = m8.a(context, zy1VarO2);
                    jp0Var2.setVisibility(0);
                    contentView.setVisibility(0);
                    jp0Var2.addView(contentView, layoutParamsA);
                    oh2.a(contentView, wt1Var);
                }
                wiVarA.a(mapA);
                showEventListener.a();
                return;
            }
        }
        showEventListener.a(w7.b());
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes7.dex */
public final class i21 implements we1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uf1 f9167a;
    private final c21 b;
    private final p21 c;
    private final qh2 d;
    private final o82 e;
    private final n70 f;
    private final v21 g;
    private final p70<?> h;
    private final String i;
    private q21 j;
    private o11 k;
    private n11 l;
    private ve1 m;
    private ne2 n;
    private lh2 o;
    private m70 p;

    public final void b(String url) throws g21 {
        Intrinsics.checkNotNullParameter(url, "url");
        this.e.getClass();
        if (!o82.a(url)) {
            String str = "Invalid MRAID URL: " + url;
            op0.f(new Object[0]);
            this.b.a(o21.d, "Mraid command sent an invalid URL");
            return;
        }
        Uri uri = Uri.parse(url);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        if (!Intrinsics.areEqual("mraid", scheme) && !Intrinsics.areEqual("mobileads", scheme)) {
            a(MapsKt.mapOf(TuplesKt.to("url", url)));
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : uri.getQueryParameterNames()) {
            String queryParameter = uri.getQueryParameter(str2);
            Intrinsics.checkNotNull(str2);
            linkedHashMap.put(str2, queryParameter);
        }
        o21.c.getClass();
        o21 o21VarA = o21.a.a(host);
        try {
            a(o21VarA, linkedHashMap);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = "Unknown exception";
            }
            this.b.a(o21VarA, message);
        }
        this.b.a(o21VarA);
    }

    public /* synthetic */ i21(uf1 uf1Var) {
        this(uf1Var, new c21(uf1Var), new p21(), new qh2(), new o82(), new n70());
    }

    public i21(uf1 mraidWebView, c21 mraidBridge, p21 mraidJsControllerLoader, qh2 viewableChecker, o82 urlUtils, n70 exposureProvider) {
        Intrinsics.checkNotNullParameter(mraidWebView, "mraidWebView");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        Intrinsics.checkNotNullParameter(mraidJsControllerLoader, "mraidJsControllerLoader");
        Intrinsics.checkNotNullParameter(viewableChecker, "viewableChecker");
        Intrinsics.checkNotNullParameter(urlUtils, "urlUtils");
        Intrinsics.checkNotNullParameter(exposureProvider, "exposureProvider");
        this.f9167a = mraidWebView;
        this.b = mraidBridge;
        this.c = mraidJsControllerLoader;
        this.d = viewableChecker;
        this.e = urlUtils;
        this.f = exposureProvider;
        v21 v21Var = new v21(new a());
        this.g = v21Var;
        this.o = lh2.d;
        mraidWebView.setWebViewClient(v21Var);
        this.h = new p70<>(mraidWebView, exposureProvider, this);
        this.i = oa.a(this);
    }

    private final void a(o21 o21Var, LinkedHashMap linkedHashMap) throws g21 {
        if (this.j != null) {
            switch (o21Var.ordinal()) {
                case 0:
                    ne2 ne2Var = this.n;
                    if (ne2Var != null) {
                        ne2Var.onVideoComplete();
                        return;
                    }
                    return;
                case 1:
                    n11 n11Var = this.l;
                    if (n11Var != null) {
                        n11Var.e();
                        return;
                    }
                    return;
                case 2:
                    n11 n11Var2 = this.l;
                    if (n11Var2 != null) {
                        n11Var2.b();
                        return;
                    }
                    return;
                case 3:
                    if (lh2.c == this.o) {
                        lh2 lh2Var = lh2.e;
                        this.o = lh2Var;
                        this.b.a(lh2Var);
                        ve1 ve1Var = this.m;
                        if (ve1Var != null) {
                            ve1Var.c();
                            return;
                        }
                        return;
                    }
                    return;
                case 4:
                    a(linkedHashMap);
                    return;
                case 5:
                    o11 o11Var = this.k;
                    if (o11Var != null) {
                        o11Var.a();
                        return;
                    }
                    return;
                case 6:
                    boolean z = Boolean.parseBoolean((String) linkedHashMap.get("shouldUseCustomClose"));
                    ve1 ve1Var2 = this.m;
                    if (ve1Var2 != null) {
                        ve1Var2.a(z);
                        return;
                    }
                    return;
                case 7:
                default:
                    throw new g21("Unspecified MRAID Javascript command");
                case 8:
                    int i = iw1.l;
                    cu1 cu1VarA = iw1.a.a().a(this.f9167a.i());
                    if (cu1VarA == null || !cu1VarA.N()) {
                        return;
                    }
                    this.f9167a.a();
                    return;
            }
        }
        throw new g21("Invalid state to execute this command");
    }

    public final void b() {
        if (lh2.c == this.o) {
            lh2 lh2Var = lh2.e;
            this.o = lh2Var;
            this.b.a(lh2Var);
        }
    }

    private final class a implements yg0 {
        @Override // com.yandex.mobile.ads.impl.yg0
        public final void a(Context context, String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            i21.this.f9167a.a(context, url);
        }

        public a() {
        }

        @Override // com.yandex.mobile.ads.impl.yg0
        public final void a() {
            i21.this.f9167a.a();
        }

        @Override // com.yandex.mobile.ads.impl.yg0
        public final void a(int i) {
            i21.this.f9167a.a(i);
        }
    }

    private final void a(Map<String, String> map) throws g21 {
        if (this.j != null) {
            String str = map.get("url");
            if (str != null && str.length() > 0) {
                q21 q21Var = this.j;
                if (q21Var != null) {
                    q21Var.a(str);
                }
                Object[] args = {str};
                int i = op0.b;
                Intrinsics.checkNotNullParameter(args, "args");
                return;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            throw new g21(z0.a(new Object[]{str}, 1, "Mraid open command sent an invalid URL: %s", "format(...)"));
        }
    }

    public final void a() {
        this.h.b();
        p21 p21Var = this.c;
        Context context = this.f9167a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String requestTag = this.i;
        p21Var.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestTag, "requestTag");
        int i = zp1.c;
        zp1.a.a();
        zp1.a(context, requestTag);
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
    }

    public final void a(final String htmlResponse) {
        Intrinsics.checkNotNullParameter(htmlResponse, "htmlResponse");
        Context context = this.f9167a.getContext();
        p21 p21Var = this.c;
        Intrinsics.checkNotNull(context);
        String str = this.i;
        p21.a aVar = new p21.a() { // from class: com.yandex.mobile.ads.impl.i21$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.p21.a
            public final void a(String str2) {
                i21.a(this.f$0, htmlResponse, str2);
            }
        };
        p21Var.getClass();
        p21.a(context, str, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(i21 this$0, String htmlResponse, String mraidJavascript) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(htmlResponse, "$htmlResponse");
        Intrinsics.checkNotNullParameter(mraidJavascript, "mraidJavascript");
        this$0.g.a(mraidJavascript);
        this$0.b.b(htmlResponse);
    }

    public final void a(uf1 webView, Map trackingParameters) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(trackingParameters, "trackingParameters");
        n32 n32Var = new n32(this.f9167a);
        qh2 qh2Var = this.d;
        uf1 uf1Var = this.f9167a;
        qh2Var.getClass();
        uh2 uh2Var = new uh2(qh2.a(uf1Var));
        m70 m70VarA = this.f.a(this.f9167a);
        o70 o70Var = new o70(m70VarA.a(), m70VarA.b());
        lh2 lh2Var = lh2.c;
        this.o = lh2Var;
        this.b.a(lh2Var, uh2Var, o70Var, n32Var);
        this.b.a();
        q21 q21Var = this.j;
        if (q21Var != null) {
            q21Var.a(webView, trackingParameters);
        }
    }

    @Override // com.yandex.mobile.ads.impl.we1
    public final void a(m70 exposure) {
        Intrinsics.checkNotNullParameter(exposure, "exposure");
        if (Intrinsics.areEqual(exposure, this.p)) {
            return;
        }
        this.p = exposure;
        this.b.a(new o70(exposure.a(), exposure.b()));
    }

    public final void a(boolean z) {
        this.b.a(new uh2(z));
        if (z) {
            this.h.a();
            return;
        }
        this.h.b();
        m70 m70VarA = this.f.a(this.f9167a);
        if (Intrinsics.areEqual(m70VarA, this.p)) {
            return;
        }
        this.p = m70VarA;
        this.b.a(new o70(m70VarA.a(), m70VarA.b()));
    }

    public final void a(n11 n11Var) {
        this.l = n11Var;
    }

    public final void a(o11 o11Var) {
        this.k = o11Var;
    }

    public final void a(q21 q21Var) {
        this.j = q21Var;
    }

    public final void a(ve1 ve1Var) {
        this.m = ve1Var;
    }

    public final void a(ne2 ne2Var) {
        this.n = ne2Var;
    }
}

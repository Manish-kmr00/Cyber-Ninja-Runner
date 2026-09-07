package com.json.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import com.json.a3;
import com.json.b9;
import com.json.bh;
import com.json.c4;
import com.json.cc;
import com.json.d9;
import com.json.dp;
import com.json.e9;
import com.json.eh;
import com.json.ep;
import com.json.er;
import com.json.fe;
import com.json.fh;
import com.json.fr;
import com.json.gb;
import com.json.gh;
import com.json.gv;
import com.json.h9;
import com.json.hg;
import com.json.hs;
import com.json.i9;
import com.json.ik;
import com.json.jh;
import com.json.jw;
import com.json.k1;
import com.json.kk;
import com.json.kw;
import com.json.l9;
import com.json.lh;
import com.json.m0;
import com.json.mediationsdk.logger.IronLog;
import com.json.mm;
import com.json.nf;
import com.json.nh;
import com.json.nv;
import com.json.o9;
import com.json.om;
import com.json.po;
import com.json.q9;
import com.json.qe;
import com.json.rk;
import com.json.s3;
import com.json.s9;
import com.json.sdk.utils.IronSourceStorageUtils;
import com.json.sdk.utils.Logger;
import com.json.sdk.utils.SDKUtils;
import com.json.so;
import com.json.t9;
import com.json.te;
import com.json.to;
import com.json.u3;
import com.json.u9;
import com.json.ue;
import com.json.uo;
import com.json.v8;
import com.json.v9;
import com.json.va;
import com.json.vg;
import com.json.vh;
import com.json.vk;
import com.json.wa;
import com.json.x8;
import com.json.y8;
import com.json.y9;
import com.json.z2;
import com.json.za;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.unity3d.services.core.di.ServiceProvider;
import com.vungle.ads.internal.Constants;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class v implements com.json.sdk.controller.l, po, DownloadListener {
    private static final String b0 = "about:blank";
    public static int c0 = 0;
    public static String d0 = "is_store";
    public static String e0 = "external_url";
    public static String f0 = "secondary_web_view";
    private static String g0 = "success";
    private static String h0 = "fail";
    private String A;
    private com.json.sdk.controller.d B;
    private nv C;
    private a3 D;
    private wa G;
    private com.json.sdk.controller.o H;
    private com.json.sdk.controller.q I;
    private com.json.sdk.controller.u J;
    private com.json.sdk.controller.i K;
    private com.json.sdk.controller.a L;
    private com.json.sdk.controller.j M;
    private s3 N;
    private y9 O;
    private jw P;
    private com.json.sdk.controller.c Q;
    private v8 R;
    private JSONObject S;
    private com.ironsource.sdk.controller.l.a T;
    private com.ironsource.sdk.controller.l.b U;
    private l9 V;
    private boolean W;
    e9 Y;
    final kk Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hg f4355a;
    private so a0;
    private h9 b;
    private String f;
    private String g;
    private final gb h;
    private boolean i;
    private p j;
    private boolean k;
    private CountDownTimer l;
    public CountDownTimer m;
    private final o q;
    private View r;
    private FrameLayout s;
    private WebChromeClient.CustomViewCallback t;
    private FrameLayout u;
    private u v;
    private String w;
    private v9 x;
    private u9 y;
    private t9 z;
    private String c = "v";
    private String d = "IronSource";
    private final String e = "We're sorry, some error occurred. we will investigate it";
    private int n = 50;
    private int o = 50;
    private String p = "top-right";
    private Object E = new Object();
    private boolean F = false;
    private final nf X = mm.S().f();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ fh f4357a;

        b(fh fhVar) {
            this.f4357a = fhVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.Q.b("controller html - failed to download - " + this.f4357a.b());
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4358a;

        c(Context context) {
            this.f4358a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.e(this.f4358a);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4359a;

        d(Context context) {
            this.f4359a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.f(this.f4359a);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ eh.e f4360a;
        final /* synthetic */ String b;

        e(eh.e eVar, String str) {
            this.f4360a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            s9 s9VarA;
            eh.e eVar = this.f4360a;
            if ((eVar == eh.e.RewardedVideo || eVar == eh.e.Interstitial) && (s9VarA = v.this.a(eVar)) != null) {
                s9VarA.a(this.f4360a, this.b);
            }
        }
    }

    class f extends v8 {
        f(JSONObject jSONObject, Context context) {
            super(jSONObject, context);
        }

        @Override // com.json.v8, com.json.Cif
        public void a() {
            if (v.this.i) {
                v.this.m("none");
            }
        }

        @Override // com.json.v8, com.json.Cif
        public void a(String str, JSONObject jSONObject) {
            if (v.this.i) {
                v.this.m(str);
            }
        }

        @Override // com.json.v8, com.json.Cif
        public void b(String str, JSONObject jSONObject) {
            if (jSONObject == null || !v.this.i) {
                return;
            }
            try {
                jSONObject.put(b9.i.t, str);
                v.this.e(jSONObject);
            } catch (JSONException e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    class g implements jw {
        g() {
        }

        @Override // com.json.jw
        public void a(String str, JSONObject jSONObject) {
            v.this.i(v.this.e(str, jSONObject.toString()));
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f4362a;
        final /* synthetic */ WebView b;
        final /* synthetic */ String c;

        h(JSONObject jSONObject, WebView webView, String str) {
            this.f4362a = jSONObject;
            this.b = webView;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(this.f4362a, this.b);
            v.this.l("about:blank");
            v.this.l(this.c);
        }
    }

    class i extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4363a;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Q.b(b9.c.j);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j, long j2, int i) {
            super(j, j2);
            this.f4363a = i;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(v.this.c, "Loading Controller Timer Finish");
            int i = this.f4363a;
            if (i == 3) {
                v.this.b(new a());
            } else {
                v.this.a(i + 1);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Logger.i(v.this.c, "Loading Controller Timer Tick " + j);
        }
    }

    class j implements s {
        j() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, eh.e eVar, va vaVar) {
            v.this.a(str, eVar, vaVar);
        }
    }

    class k implements s {
        k() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, eh.e eVar, va vaVar) {
            v.this.a(str, eVar, vaVar);
        }
    }

    class l implements s {
        l() {
        }

        @Override // com.ironsource.sdk.controller.v.s
        public void a(String str, eh.e eVar, va vaVar) {
            v.this.a(str, eVar, vaVar);
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ eh.e f4368a;
        final /* synthetic */ va b;
        final /* synthetic */ String c;

        m(eh.e eVar, va vaVar, String str) {
            this.f4368a = eVar;
            this.b = vaVar;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            va vaVar;
            eh.e eVar = eh.e.RewardedVideo;
            eh.e eVar2 = this.f4368a;
            if ((eVar != eVar2 && eh.e.Interstitial != eVar2 && eh.e.Banner != eVar2) || (vaVar = this.b) == null || TextUtils.isEmpty(vaVar.h())) {
                return;
            }
            s9 s9VarA = v.this.a(this.f4368a);
            Log.d(v.this.c, "onAdProductInitFailed (message:" + this.c + ")(" + this.f4368a + ")");
            if (s9VarA != null) {
                s9VarA.a(this.f4368a, this.b.h(), this.c);
            }
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.this.a(1);
        }
    }

    private class o extends WebChromeClient {
        private o() {
        }

        /* synthetic */ o(v vVar, f fVar) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public View getVideoLoadingProgressView() {
            FrameLayout frameLayout = new FrameLayout(v.this.Z.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            return frameLayout;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            Logger.i("MyApplication", consoleMessage.message() + " -- From line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$o;->onCreateWindow(Landroid/webkit/WebView;ZZLandroid/os/Message;)Z");
            boolean zSafedk_v$o_onCreateWindow_c705636200c84daf8fad60dc6f2939d9 = safedk_v$o_onCreateWindow_c705636200c84daf8fad60dc6f2939d9(webView, z, z2, message);
            BrandSafetyUtils.onWebChromeClientCreateWindow(com.safedk.android.utils.h.f, webView, message, zSafedk_v$o_onCreateWindow_c705636200c84daf8fad60dc6f2939d9);
            return zSafedk_v$o_onCreateWindow_c705636200c84daf8fad60dc6f2939d9;
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            Logger.i("Test", "onHideCustomView");
            if (v.this.r == null) {
                return;
            }
            v.this.r.setVisibility(8);
            v.this.s.removeView(v.this.r);
            v.this.r = null;
            v.this.s.setVisibility(8);
            v.this.t.onCustomViewHidden();
            v.this.Z.setVisibility(0);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            Logger.i("Test", "onShowCustomView");
            v.this.Z.setVisibility(8);
            if (v.this.r != null) {
                Logger.i("Test", "mCustomView != null");
                customViewCallback.onCustomViewHidden();
                return;
            }
            Logger.i("Test", "mCustomView == null");
            v.this.s.addView(view);
            v.this.r = view;
            v.this.t = customViewCallback;
            v.this.s.setVisibility(0);
        }

        public boolean safedk_v$o_onCreateWindow_c705636200c84daf8fad60dc6f2939d9(WebView p0, boolean p1, boolean p2, Message p3) {
            WebView webView = new WebView(p0.getContext());
            webView.setWebChromeClient(this);
            webView.setWebViewClient(new q(v.this, null));
            ((WebView.WebViewTransport) p3.obj).setWebView(webView);
            p3.sendToTarget();
            Logger.i("onCreateWindow", "onCreateWindow");
            return true;
        }
    }

    static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        eh.e f4371a;
        String b;

        public p(eh.e eVar, String str) {
            this.f4371a = eVar;
            this.b = str;
        }

        String a() {
            return this.b;
        }

        eh.e b() {
            return this.f4371a;
        }
    }

    private class q extends WebViewClient {
        private q() {
        }

        /* synthetic */ q(v vVar, f fVar) {
            this();
        }

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            com.safedk.android.utils.Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.f);
            p0.startActivity(p1);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.f, view, errorCode, description, failingUrl);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Logger.e(v.this.c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            return true;
        }

        public boolean safedk_v$q_shouldOverrideUrlLoading_680acaebe0aa5248a467f75da7c82dcd(WebView p0, String p1) {
            Context contextQ = v.this.q();
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(contextQ, new OpenUrlActivity.e(new com.ironsource.sdk.controller.k.b()).a(p1).b(false).a(contextQ));
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(com.safedk.android.utils.h.f, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$q;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_v$q_shouldOverrideUrlLoading_680acaebe0aa5248a467f75da7c82dcd = safedk_v$q_shouldOverrideUrlLoading_680acaebe0aa5248a467f75da7c82dcd(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.f, webView, str, zSafedk_v$q_shouldOverrideUrlLoading_680acaebe0aa5248a467f75da7c82dcd);
            return zSafedk_v$q_shouldOverrideUrlLoading_680acaebe0aa5248a467f75da7c82dcd;
        }
    }

    public class r {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4374a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.f4374a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f4374a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onRVShowFail(message:" + this.f4374a + ")");
                v.this.x.d(this.b, str);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4375a;

            b(String str) {
                this.f4375a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onInterstitialInitSuccess()");
                v.this.y.a(eh.e.Interstitial, this.f4375a, (z2) null);
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4376a;
            final /* synthetic */ String b;

            c(String str, String str2) {
                this.f4376a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f4376a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onInterstitialInitFail(message:" + str + ")");
                v.this.y.a(eh.e.Interstitial, this.b, str);
            }
        }

        class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ s9 f4377a;
            final /* synthetic */ eh.e b;
            final /* synthetic */ String c;

            d(s9 s9Var, eh.e eVar, String str) {
                this.f4377a = s9Var;
                this.b = eVar;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4377a.c(this.b, this.c);
            }
        }

        class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4378a;
            final /* synthetic */ JSONObject b;

            e(String str, JSONObject jSONObject) {
                this.f4378a = str;
                this.b = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.a(this.f4378a, this.b);
            }
        }

        class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4379a;
            final /* synthetic */ String b;

            f(String str, String str2) {
                this.f4379a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f4379a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.c(this.b, str);
            }
        }

        class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4380a;

            g(String str) {
                this.f4380a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onBannerInitSuccess()");
                v.this.z.a(eh.e.Banner, this.f4380a, (z2) null);
            }
        }

        class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4381a;
            final /* synthetic */ String b;

            h(String str, String str2) {
                this.f4381a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f4381a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onBannerInitFail(message:" + str + ")");
                v.this.z.a(eh.e.Banner, this.b, str);
            }
        }

        class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4382a;
            final /* synthetic */ vg b;

            i(String str, vg vgVar) {
                this.f4382a = str;
                this.b = vgVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onBannerLoadSuccess()");
                v.this.z.a(this.f4382a, this.b);
            }
        }

        class j implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4383a;
            final /* synthetic */ String b;

            j(String str, String str2) {
                this.f4383a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(v.this.c, "onLoadBannerFail()");
                String str = this.f4383a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.z.a(this.b, str);
            }
        }

        class k implements Runnable {
            k() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.F();
            }
        }

        class l implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4385a;

            l(String str) {
                this.f4385a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (IronSourceNetworkBridge.jsonObjectInit(this.f4385a).has(com.ironsource.sdk.controller.f.b.MSG_ID)) {
                        v.this.T.a(com.ironsource.sdk.controller.f.a.a(this.f4385a));
                    } else {
                        v.this.U.a(om.a(this.f4385a));
                    }
                } catch (JSONException e) {
                    o9.d().a(e);
                    Logger.e(v.this.c, "failed to parse received message");
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        class m implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ eh.e f4386a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ JSONObject d;

            m(eh.e eVar, String str, String str2, JSONObject jSONObject) {
                this.f4386a = eVar;
                this.b = str;
                this.c = str2;
                this.d = jSONObject;
            }

            @Override // java.lang.Runnable
            public void run() {
                s9 s9VarA;
                eh.e eVar = this.f4386a;
                if ((eVar == eh.e.Interstitial || eVar == eh.e.RewardedVideo || eVar == eh.e.Banner) && (s9VarA = v.this.a(eVar)) != null) {
                    s9VarA.a(this.f4386a, this.b, this.c, this.d);
                }
            }
        }

        class n implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4387a;

            n(String str) {
                this.f4387a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logger.i(v.this.c, "omidAPI(" + this.f4387a + ")");
                    v.this.H.a(new fr(this.f4387a).toString(), r.this.new w());
                } catch (Exception e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.c, "omidAPI failed with exception " + e.getMessage());
                }
            }
        }

        class o implements Runnable {
            o() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.B();
            }
        }

        class p implements Runnable {
            p() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.removeJavascriptInterface(b9.e);
            }
        }

        class q implements Runnable {
            q() {
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.Z.getSettings().setMixedContentMode(0);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$r, reason: collision with other inner class name */
        class RunnableC0407r implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f4391a;
            final /* synthetic */ String b;
            final /* synthetic */ z2 c;

            RunnableC0407r(int i, String str, z2 z2Var) {
                this.f4391a = i;
                this.b = str;
                this.c = z2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4391a <= 0) {
                    v.this.x.c(this.b);
                } else {
                    Log.d(v.this.c, "onRVInitSuccess()");
                    v.this.x.a(eh.e.RewardedVideo, this.b, this.c);
                }
            }
        }

        class s implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4392a;

            s(String str) {
                this.f4392a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    v.this.M.a(IronSourceNetworkBridge.jsonObjectInit(this.f4392a), r.this.new w());
                } catch (Exception e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                    Logger.i(v.this.c, "fileSystemAPI failed with exception " + e.getMessage());
                }
            }
        }

        class t implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4393a;
            final /* synthetic */ String b;
            final /* synthetic */ int c;

            t(String str, String str2, int i) {
                this.f4393a = str;
                this.b = str2;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4393a.equalsIgnoreCase(eh.e.RewardedVideo.toString())) {
                    v.this.x.a(this.b, this.c);
                }
            }
        }

        class u implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4394a;
            final /* synthetic */ int b;

            u(String str, int i) {
                this.f4394a = str;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                v.this.y.onInterstitialAdRewarded(this.f4394a, this.b);
            }
        }

        /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$r$v, reason: collision with other inner class name */
        class RunnableC0408v implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4395a;
            final /* synthetic */ String b;

            RunnableC0408v(String str, String str2) {
                this.f4395a = str;
                this.b = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str = this.f4395a;
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                Log.d(v.this.c, "onRVInitFail(message:" + str + ")");
                v.this.x.a(eh.e.RewardedVideo, this.b, str);
            }
        }

        public class w implements rk {
            public w() {
            }

            @Override // com.json.rk
            public void a(boolean z, String str, fr frVar) {
                frVar.b(z ? v.g0 : v.h0, str);
                v.this.a(frVar.toString(), z, (String) null, (String) null);
            }

            @Override // com.json.rk
            public void a(boolean z, String str, String str2) {
                fr frVar = new fr();
                frVar.b(z ? v.g0 : v.h0, str);
                frVar.b("data", str2);
                v.this.a(frVar.toString(), z, (String) null, (String) null);
            }

            @Override // com.json.rk
            public void a(boolean z, String str, JSONObject jSONObject) {
                try {
                    jSONObject.put(z ? v.g0 : v.h0, str);
                    v.this.a(jSONObject.toString(), z, (String) null, (String) null);
                } catch (JSONException e) {
                    o9.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }

        public r() {
        }

        private void a(String str, int i2) {
            va vaVarA;
            v vVar = v.this;
            eh.e eVar = eh.e.Interstitial;
            if (vVar.q(eVar.toString()) && (vaVarA = v.this.G.a(eVar, str)) != null && vaVarA.k()) {
                v.this.b(new u(str, i2));
            }
        }

        private void a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            v.this.i(v.this.e(str, str2));
        }

        private void a(String str, boolean z) {
            va vaVarA = v.this.G.a(eh.e.Interstitial, str);
            if (vaVarA != null) {
                vaVarA.a(z);
            }
        }

        private void a(JSONObject jSONObject) {
            try {
                jSONObject.put("controllerSourceData", v.this.B.f());
            } catch (Exception e2) {
                o9.d().a(e2);
                Logger.d(v.this.c, "Unable to add controller source data into controllerConfig");
            }
        }

        private void a(JSONObject jSONObject, String str) {
            if (a(str)) {
                try {
                    JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
                    jSONObject.putOpt("testerABGroup", jSONObjectJsonObjectInit.get("testerABGroup"));
                    jSONObject.putOpt("testFriendlyName", jSONObjectJsonObjectInit.get("testFriendlyName"));
                } catch (JSONException e2) {
                    o9.d().a(e2);
                    Logger.d(v.this.c, "getControllerConfig Error while parsing Tester AB Group parameters");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, String str) {
            if (z) {
                v.this.y.b(eh.e.Interstitial, str);
                v.this.y.b(str);
            }
            a(str, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z, String str, String str2) {
            if (z) {
                if (str == null) {
                    str = "We're sorry, some error occurred. we will investigate it";
                }
                v.this.y.b(str2, str);
            }
            a(str2, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            try {
                s3.a aVarA = v.this.N.a(v.this.Z.getContext(), u3.a(str));
                v.this.i(v.this.e(aVarA.f(), aVarA.i().toString()));
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        private void b(JSONObject jSONObject) {
            try {
                FeaturesManager featuresManager = FeaturesManager.getInstance();
                if (featuresManager.a().isEmpty()) {
                    return;
                }
                jSONObject.put(b9.a.h, new JSONArray((Collection) featuresManager.a()));
            } catch (Exception e2) {
                o9.d().a(e2);
                lh.a(er.p, new gh().a(cc.A, e2.getMessage()).a());
                Logger.d(v.this.c, "getControllerConfig Error while adding supported features data from FeaturesManager");
            }
        }

        private void c(JSONObject jSONObject) {
            b(jSONObject);
            a(jSONObject, SDKUtils.getTesterParameters());
            if (v.this.W) {
                return;
            }
            a(jSONObject);
        }

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            com.safedk.android.utils.Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            BrandSafetyUtils.detectAdClick(p1, com.safedk.android.utils.h.f);
            p0.startActivity(p1);
        }

        boolean a(String str) {
            if (TextUtils.isEmpty(str) || str.contains("-1")) {
                return false;
            }
            try {
                JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit(str);
                return (jSONObjectJsonObjectInit.getString("testerABGroup").isEmpty() || jSONObjectJsonObjectInit.getString("testFriendlyName").isEmpty()) ? false : true;
            } catch (JSONException e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                return false;
            }
        }

        @JavascriptInterface
        public void adClicked(String str) {
            Logger.i(v.this.c, "adClicked(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d(b9.h.m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            eh.e eVarG = v.this.g(strD);
            s9 s9VarA = v.this.a(eVarG);
            if (eVarG == null || s9VarA == null) {
                return;
            }
            v.this.b(new d(s9VarA, eVarG, strFetchDemandSourceId));
        }

        @JavascriptInterface
        public void adCredited(String str) {
            Log.d(v.this.d, "adCredited(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d(b9.h.k);
            int i2 = strD != null ? Integer.parseInt(strD) : 0;
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            String strD2 = frVar.d(b9.h.m);
            if (TextUtils.isEmpty(strD2)) {
                Log.d(v.this.d, "adCredited | product type is missing");
            }
            if (eh.e.Interstitial.toString().equalsIgnoreCase(strD2)) {
                a(strFetchDemandSourceId, i2);
            } else if (v.this.q(strD2)) {
                v.this.b(new t(strD2, strFetchDemandSourceId, i2));
            }
        }

        @JavascriptInterface
        public void adUnitsReady(String str) {
            Logger.i(v.this.c, "adUnitsReady(" + str + ")");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new fr(str));
            z2 z2Var = new z2(str);
            if (!z2Var.g()) {
                v.this.a(str, false, b9.c.r, (String) null);
                return;
            }
            v.this.a(str, true, (String) null, (String) null);
            String strD = z2Var.d();
            if (eh.e.RewardedVideo.toString().equalsIgnoreCase(strD) && v.this.q(strD)) {
                v.this.b(new RunnableC0407r(Integer.parseInt(z2Var.c()), strFetchDemandSourceId, z2Var));
            }
        }

        @JavascriptInterface
        public void adViewAPI(String str) {
            try {
                Logger.i(v.this.c, "adViewAPI(" + str + ")");
                v.this.L.a(new fr(str).toString(), new w());
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "adViewAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void androidSandboxApi(final String str) {
            hg.f3748a.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(str);
                }
            });
        }

        @JavascriptInterface
        public void bannerViewAPI(String str) {
            Logger.i(v.this.c, "bannerViewAPI is not supported in this native version, only adview API");
        }

        void c(String str) {
            v.this.i(v.this.a(b9.g.d, str, (String) null, (String) null));
        }

        @JavascriptInterface
        public void cleanAdInstance(String str) {
            eh.e eVarG;
            try {
                Logger.i(v.this.c, "cleanAdInstance(" + str + ")");
                fr frVar = new fr(str);
                String strD = frVar.d(b9.h.m);
                String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
                if (TextUtils.isEmpty(strFetchDemandSourceId) || (eVarG = v.this.g(strD)) == null) {
                    return;
                }
                v.this.G.b(eVarG, strFetchDemandSourceId);
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void clearLastUpdateTimeData(String str) {
            try {
                ArrayList<String> arrayListA = ik.e().a();
                fr frVar = new fr(str);
                if (!arrayListA.isEmpty()) {
                    frVar.b(b9.h.x0, arrayListA.toString());
                }
                v.this.a(frVar.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        void d(String str) {
            v.this.i(v.this.a(b9.g.e, str, (String) null, (String) null));
        }

        @JavascriptInterface
        public void deleteFile(String str) {
            try {
                Logger.i(v.this.c, "deleteFile(" + str + ")");
                fr frVar = new fr(str);
                String strD = frVar.d("file");
                String strD2 = frVar.d("path");
                if (strD2 != null && !TextUtils.isEmpty(strD)) {
                    nh nhVar = new nh(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD2), strD);
                    IronSourceStorageUtils.ensurePathSafety(nhVar, v.this.A);
                    if (!nhVar.exists()) {
                        v.this.a(str, false, b9.c.f, "1");
                        return;
                    } else {
                        v.this.a(str, IronSourceStorageUtils.deleteFile(nhVar), (String) null, (String) null);
                        return;
                    }
                }
                v.this.a(str, false, b9.c.g, "1");
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void deleteFolder(String str) {
            try {
                Logger.i(v.this.c, "deleteFolder(" + str + ")");
                String strD = new fr(str).d("path");
                if (strD == null) {
                    v.this.a(str, false, b9.c.g, "1");
                    return;
                }
                nh nhVar = new nh(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD));
                IronSourceStorageUtils.ensurePathSafety(nhVar, v.this.A);
                if (!nhVar.exists()) {
                    v.this.a(str, false, b9.c.e, "1");
                } else {
                    v.this.a(str, IronSourceStorageUtils.deleteFolder(nhVar.getPath()), (String) null, (String) null);
                }
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void deviceDataAPI(String str) {
            try {
                Logger.i(v.this.c, "deviceDataAPI(" + str + ")");
                v.this.K.a(new fr(str).toString(), new w());
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "deviceDataAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void displayWebView(String str) {
            Logger.i(v.this.c, "displayWebView(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            fr frVar = new fr(str);
            boolean zBooleanValue = ((Boolean) frVar.b("display")).booleanValue();
            String strD = frVar.d(b9.h.m);
            boolean zC = frVar.c(b9.h.u);
            String strD2 = frVar.d("adViewId");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            boolean zC2 = frVar.c(b9.h.z0);
            if (!zBooleanValue) {
                v.this.a(u.Gone);
                v.this.o();
                return;
            }
            v.this.F = frVar.c(b9.h.v);
            boolean zC3 = frVar.c(b9.h.y);
            u uVarV = v.this.v();
            u uVar = u.Display;
            if (uVarV == uVar) {
                Logger.i(v.this.c, "State: " + v.this.v);
                return;
            }
            v.this.a(uVar);
            Logger.i(v.this.c, "State: " + v.this.v);
            Context contextQ = v.this.q();
            String strT = v.this.t();
            int iL = v.this.X.L(contextQ);
            if (zC) {
                com.json.sdk.controller.h hVar = new com.json.sdk.controller.h(contextQ);
                hVar.addView(v.this.u);
                hVar.a(v.this);
                return;
            }
            Intent intent = zC3 ? new Intent(contextQ, (Class<?>) InterstitialActivity.class) : new Intent(contextQ, (Class<?>) ControllerActivity.class);
            eh.e eVar = eh.e.RewardedVideo;
            if (eVar.toString().equalsIgnoreCase(strD)) {
                if ("application".equals(strT)) {
                    strT = SDKUtils.translateRequestedOrientation(v.this.X.N(contextQ));
                }
                intent.putExtra(b9.h.m, eVar.toString());
                v.this.D.a(eVar.ordinal());
                v.this.D.f(strFetchDemandSourceId);
                if (v.this.q(eVar.toString())) {
                    v.this.x.b(eVar, strFetchDemandSourceId);
                }
            } else {
                eh.e eVar2 = eh.e.Interstitial;
                if (eVar2.toString().equalsIgnoreCase(strD)) {
                    if ("application".equals(strT)) {
                        strT = SDKUtils.translateRequestedOrientation(v.this.X.N(contextQ));
                    }
                    intent.putExtra(b9.h.m, eVar2.toString());
                }
            }
            if (strD2 != null) {
                intent.putExtra("adViewId", strD2);
            }
            intent.putExtra(b9.h.z0, zC2);
            intent.setFlags(536870912);
            intent.putExtra(b9.h.v, v.this.F);
            intent.putExtra(b9.h.A, strT);
            intent.putExtra(b9.h.B, iL);
            v vVar = v.this;
            vVar.j = new p(vVar.g(strD), strFetchDemandSourceId);
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(contextQ, intent);
        }

        @JavascriptInterface
        public void dsSharedSignalsAPI(String str) {
            try {
                Logger.i(v.this.c, "dsSharedSignalsAPI(" + str + ")");
                v.this.O.a(new fr(str).toString(), new w());
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "dsSharedSignalsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void fileSystemAPI(String str) {
            Logger.i(v.this.c, "fileSystemAPI(" + str + ")");
            v.this.a(new s(str));
        }

        /* JADX WARN: Code duplicated, block: B:10:0x005e  */
        @JavascriptInterface
        public void getApplicationInfo(String str) {
            Logger.i(v.this.c, "getApplicationInfo(" + str + ")");
            String strE = v.this.e(str);
            String strD = v.this.d(str);
            fr frVar = new fr(str);
            Object[] objArrF = v.this.f(frVar.d(b9.h.m), SDKUtils.fetchDemandSourceId(frVar));
            String str2 = (String) objArrF[0];
            if (((Boolean) objArrF[1]).booleanValue()) {
                if (TextUtils.isEmpty(strD)) {
                    strE = null;
                } else {
                    strE = strD;
                }
            } else if (TextUtils.isEmpty(strE)) {
                strE = null;
            }
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            v.this.i(v.this.a(strE, str2, b9.g.n, b9.g.o));
        }

        @JavascriptInterface
        public void getCachedFilesMap(String str) {
            v vVar;
            String str2;
            Logger.i(v.this.c, "getCachedFilesMap(" + str + ")");
            String strE = v.this.e(str);
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            fr frVar = new fr(str);
            if (frVar.a("path")) {
                String str3 = (String) frVar.b("path");
                if (IronSourceStorageUtils.isPathExist(v.this.A, str3)) {
                    v.this.i(v.this.a(strE, IronSourceStorageUtils.getCachedFilesMap(v.this.A, str3), b9.g.s, b9.g.r));
                    return;
                }
                vVar = v.this;
                str2 = b9.c.t;
            } else {
                vVar = v.this;
                str2 = b9.c.s;
            }
            vVar.a(str, false, str2, (String) null);
        }

        @JavascriptInterface
        public void getConnectivityInfo(String str) {
            String strE;
            Logger.i(v.this.c, "getConnectivityInfo(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d(v.g0);
            String strD2 = frVar.d(v.h0);
            JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
            if (v.this.R != null) {
                jSONObjectJsonObjectInit = v.this.R.a(v.this.Z.getContext());
            }
            if (jSONObjectJsonObjectInit.length() > 0) {
                strE = v.this.e(strD, jSONObjectJsonObjectInit.toString());
            } else {
                strE = v.this.e(strD2, v.this.a("errMsg", b9.c.A, null, null, null, null, null, null, null, false));
            }
            v.this.i(strE);
        }

        @JavascriptInterface
        public void getControllerConfig(String str) {
            Logger.i(v.this.c, "getControllerConfig(" + str + ")");
            String strD = new fr(str).d(v.g0);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
            c(controllerConfigAsJSONObject);
            v.this.i(v.this.e(strD, controllerConfigAsJSONObject.toString()));
        }

        @JavascriptInterface
        public void getDemandSourceState(String str) {
            String strD;
            Logger.i(v.this.c, "getMediationState(" + str + ")");
            fr frVar = new fr(str);
            String strD2 = frVar.d("demandSourceName");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            String strD3 = frVar.d(b9.h.m);
            if (strD3 == null || strD2 == null) {
                return;
            }
            try {
                eh.e productType = SDKUtils.getProductType(strD3);
                if (productType != null) {
                    va vaVarA = v.this.G.a(productType, strFetchDemandSourceId);
                    JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
                    jSONObjectJsonObjectInit.put(b9.h.m, strD3);
                    jSONObjectJsonObjectInit.put("demandSourceName", strD2);
                    jSONObjectJsonObjectInit.put("demandSourceId", strFetchDemandSourceId);
                    if (vaVarA == null || vaVarA.a(-1)) {
                        strD = v.this.d(str);
                    } else {
                        strD = v.this.e(str);
                        jSONObjectJsonObjectInit.put("state", vaVarA.j());
                    }
                    a(strD, jSONObjectJsonObjectInit.toString());
                }
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0055  */
        @JavascriptInterface
        public void getDeviceStatus(String str) {
            Logger.i(v.this.c, "getDeviceStatus(" + str + ")");
            String strE = v.this.e(str);
            String strD = v.this.d(str);
            v vVar = v.this;
            Object[] objArrD = vVar.d(vVar.Z.getContext());
            String str2 = (String) objArrD[0];
            if (((Boolean) objArrD[1]).booleanValue()) {
                if (TextUtils.isEmpty(strD)) {
                    strE = null;
                } else {
                    strE = strD;
                }
            } else if (TextUtils.isEmpty(strE)) {
                strE = null;
            }
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            v.this.i(v.this.a(strE, str2, b9.g.l, b9.g.m));
        }

        @JavascriptInterface
        public void getDeviceVolume(String str) {
            Logger.i(v.this.c, "getDeviceVolume(" + str + ")");
            try {
                Context context = v.this.Z.getContext();
                float fA = za.b(context).a(context);
                fr frVar = new fr(str);
                frVar.b(b9.i.P, String.valueOf(fA));
                v.this.a(frVar.toString(), true, (String) null, (String) null);
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void getInitSummery(String str) {
            Logger.i(v.this.c, "getInitSummery(" + str + ")");
            fr frVar = new fr(str);
            frVar.a(b9.i.r0, v.this.S);
            v.this.a(frVar.toString(), true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void getOrientation(String str) {
            lh.a(er.z, new gh().a(cc.y, str).a());
            String strE = v.this.e(str);
            String string = SDKUtils.getOrientation(v.this.Z.getContext()).toString();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            v.this.i(v.this.a(strE, string, b9.g.X, b9.g.Y));
        }

        @JavascriptInterface
        public void getUserData(String str) {
            Logger.i(v.this.c, "getUserData(" + str + ")");
            fr frVar = new fr(str);
            if (!frVar.a("key")) {
                v.this.a(str, false, b9.c.F, (String) null);
                return;
            }
            String strE = v.this.e(str);
            String strD = frVar.d("key");
            v.this.i(v.this.e(strE, v.this.a(strD, ik.e().a(strD), null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void iabTokenAPI(String str) {
            try {
                Logger.i(v.this.c, "iabTokenAPI(" + str + ")");
                v.this.J.a(new fr(str).toString(), new w());
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "iabTokenAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void initController(String str) {
            Logger.i(v.this.c, "initController(" + str + ")");
            fr frVar = new fr(str);
            CountDownTimer countDownTimer = v.this.m;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                v.this.m = null;
            }
            if (frVar.a(b9.h.q)) {
                String strD = frVar.d(b9.h.q);
                if (b9.h.s.equalsIgnoreCase(strD)) {
                    v.this.i = true;
                    v.this.Q.c();
                } else if (b9.h.r.equalsIgnoreCase(strD)) {
                    v.this.Q.b();
                } else if (!b9.h.t.equalsIgnoreCase(strD)) {
                    Logger.i(v.this.c, "No STAGE mentioned! should not get here!");
                } else {
                    v.this.Q.b("controller js failed to initialize : " + frVar.d("errMsg"));
                }
            }
        }

        @JavascriptInterface
        public void omidAPI(String str) {
            v.this.c(new n(str));
        }

        @JavascriptInterface
        public void onAdWindowsClosed(String str) {
            Logger.i(v.this.c, "onAdWindowsClosed(" + str + ")");
            v.this.D.a();
            v.this.D.f(null);
            v.this.j = null;
            fr frVar = new fr(str);
            String strD = frVar.d(b9.h.m);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            eh.e eVarG = v.this.g(strD);
            Log.d(v.this.d, "onAdClosed() with type " + eVarG);
            if (v.this.q(strD)) {
                v.this.a(eVarG, strFetchDemandSourceId);
            }
        }

        @JavascriptInterface
        public void onCleanUpNonDisplayBannersSuccess(String str) {
            Logger.i(v.this.c, "onCleanUpNonDisplayBannersSuccess() value=" + str);
        }

        @JavascriptInterface
        public void onGetApplicationInfoFail(String str) {
            Logger.i(v.this.c, "onGetApplicationInfoFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetApplicationInfoSuccess(String str) {
            Logger.i(v.this.c, "onGetApplicationInfoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapFail(String str) {
            Logger.i(v.this.c, "onGetCachedFilesMapFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetCachedFilesMapSuccess(String str) {
            Logger.i(v.this.c, "onGetCachedFilesMapSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusFail(String str) {
            Logger.i(v.this.c, "onGetDeviceStatusFail(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onGetDeviceStatusSuccess(String str) {
            Logger.i(v.this.c, "onGetDeviceStatusSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerFail(String str) {
            Logger.i(v.this.c, "onInitBannerFail(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitBannerFail failed with no demand source");
                return;
            }
            wa waVar = v.this.G;
            eh.e eVar = eh.e.Banner;
            va vaVarA = waVar.a(eVar, strFetchDemandSourceId);
            if (vaVarA != null) {
                vaVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new h(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitBannerSuccess(String str) {
            Logger.i(v.this.c, "onInitBannerSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new fr(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitBannerSuccess failed with no demand source");
            } else if (v.this.q(eh.e.Banner.toString())) {
                v.this.b(new g(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitInterstitialFail(String str) {
            Logger.i(v.this.c, "onInitInterstitialFail(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitInterstitialSuccess failed with no demand source");
                return;
            }
            wa waVar = v.this.G;
            eh.e eVar = eh.e.Interstitial;
            va vaVarA = waVar.a(eVar, strFetchDemandSourceId);
            if (vaVarA != null) {
                vaVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new c(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onInitInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onInitInterstitialSuccess()");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new fr(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.c, "onInitInterstitialSuccess failed with no demand source");
            } else if (v.this.q(eh.e.Interstitial.toString())) {
                v.this.b(new b(strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onInitRewardedVideoFail(String str) {
            Logger.i(v.this.c, "onInitRewardedVideoFail(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            wa waVar = v.this.G;
            eh.e eVar = eh.e.RewardedVideo;
            va vaVarA = waVar.a(eVar, strFetchDemandSourceId);
            if (vaVarA != null) {
                vaVarA.b(3);
            }
            if (v.this.q(eVar.toString())) {
                v.this.b(new RunnableC0408v(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onLoadBannerFail(String str) {
            Logger.i(v.this.c, "onLoadBannerFail()");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            v.this.a(str, true, (String) null, (String) null);
            if (!TextUtils.isEmpty(strFetchDemandSourceId) && v.this.q(eh.e.Banner.toString())) {
                v.this.b(new j(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadBannerSuccess(String str) {
            Logger.i(v.this.c, "onLoadBannerSuccess()");
            fr frVar = new fr(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            String strD = frVar.d("adViewId");
            v.this.a(str, true, (String) null, (String) null);
            vh vhVarA = bh.a().a(strD);
            if (vhVarA == null) {
                v.this.z.a(strFetchDemandSourceId, "not found view for the current adViewId= " + strD);
            } else if (vhVarA instanceof vg) {
                vg vgVar = (vg) vhVarA;
                if (v.this.q(eh.e.Banner.toString())) {
                    v.this.b(new i(strFetchDemandSourceId, vgVar));
                }
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialFail(String str) {
            Logger.i(v.this.c, "onLoadInterstitialFail(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            a(strFetchDemandSourceId, false);
            if (v.this.q(eh.e.Interstitial.toString())) {
                v.this.b(new f(strD, strFetchDemandSourceId));
            }
        }

        @JavascriptInterface
        public void onLoadInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onLoadInterstitialSuccess(" + str + ")");
            fr frVar = new fr(str);
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            JSONObject jSONObjectA = frVar.a();
            a(strFetchDemandSourceId, true);
            v.this.a(str, true, (String) null, (String) null);
            if (v.this.q(eh.e.Interstitial.toString())) {
                v.this.b(new e(strFetchDemandSourceId, jSONObjectA));
            }
        }

        @JavascriptInterface
        public void onReceivedMessage(String str) {
            Logger.i(v.this.c, "onReceivedMessage(" + str + ")");
            hg.f3748a.b(new l(str));
        }

        @JavascriptInterface
        public void onShowInterstitialFail(String str) {
            Logger.i(v.this.c, "onShowInterstitialFail(" + str + ")");
            fr frVar = new fr(str);
            final String strD = frVar.d("errMsg");
            final String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            v.this.a(str, true, (String) null, (String) null);
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                return;
            }
            final boolean zQ = v.this.q(eh.e.Interstitial.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(zQ, strD, strFetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowInterstitialSuccess(String str) {
            Logger.i(v.this.c, "onShowInterstitialSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
            final String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(new fr(str));
            if (TextUtils.isEmpty(strFetchDemandSourceId)) {
                Logger.i(v.this.c, "onShowInterstitialSuccess called with no demand");
                return;
            }
            a3 a3Var = v.this.D;
            eh.e eVar = eh.e.Interstitial;
            a3Var.a(eVar.ordinal());
            v.this.D.f(strFetchDemandSourceId);
            final boolean zQ = v.this.q(eVar.toString());
            v.this.b(new Runnable() { // from class: com.ironsource.sdk.controller.v$r$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(zQ, strFetchDemandSourceId);
                }
            });
        }

        @JavascriptInterface
        public void onShowRewardedVideoFail(String str) {
            Logger.i(v.this.c, "onShowRewardedVideoFail(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("errMsg");
            String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
            if (v.this.q(eh.e.RewardedVideo.toString())) {
                v.this.b(new a(strD, strFetchDemandSourceId));
            }
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onShowRewardedVideoSuccess(String str) {
            Logger.i(v.this.c, "onShowRewardedVideoSuccess(" + str + ")");
            v.this.a(str, true, (String) null, (String) null);
        }

        @JavascriptInterface
        public void onVideoStatusChanged(String str) {
            Log.d(v.this.c, "onVideoStatusChanged(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d(b9.h.m);
            if (v.this.C == null || TextUtils.isEmpty(strD)) {
                return;
            }
            String strD2 = frVar.d("status");
            if (b9.h.d0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStarted();
                return;
            }
            if ("paused".equalsIgnoreCase(strD2)) {
                v.this.C.onVideoPaused();
                return;
            }
            if ("playing".equalsIgnoreCase(strD2)) {
                v.this.C.onVideoResumed();
                return;
            }
            if (b9.h.g0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoEnded();
            } else if (b9.h.h0.equalsIgnoreCase(strD2)) {
                v.this.C.onVideoStopped();
            } else {
                Logger.i(v.this.c, "onVideoStatusChanged: unknown status: " + strD2);
            }
        }

        @JavascriptInterface
        public void openUrl(String str) {
            try {
                Logger.i(v.this.c, "openUrl(" + str + ")");
                fr frVar = new fr(str);
                com.ironsource.sdk.controller.p.c cVarA = new com.ironsource.sdk.controller.p.a(frVar.d("method"), new uo(v.this.F, C.ENCODING_PCM_32BIT)).a(frVar.c(b9.h.L0) ? v.this.Z.getContext() : v.this.q(), new to(frVar.d("url"), frVar.d("package_name")));
                if (cVarA instanceof com.ironsource.sdk.controller.p.c.a) {
                    v.this.a(str, false, ((com.ironsource.sdk.controller.p.c.a) cVarA).b(), (String) null);
                } else {
                    v.this.a(str, true, (String) null, (String) null);
                }
            } catch (Exception e2) {
                v.this.a(str, false, e2.getLocalizedMessage(), (String) null);
            }
        }

        @JavascriptInterface
        public void pauseControllerWebview() {
            v.this.c(new o());
        }

        @JavascriptInterface
        public void permissionsAPI(String str) {
            try {
                Logger.i(v.this.c, "permissionsAPI(" + str + ")");
                v.this.I.a(new fr(str).toString(), new w());
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
                Logger.i(v.this.c, "permissionsAPI failed with exception " + e2.getMessage());
            }
        }

        @JavascriptInterface
        public void postAdEventNotification(String str) {
            try {
                Logger.i(v.this.c, "postAdEventNotification(" + str + ")");
                fr frVar = new fr(str);
                String strD = frVar.d(b9.h.j0);
                if (TextUtils.isEmpty(strD)) {
                    v.this.a(str, false, b9.c.w, (String) null);
                    return;
                }
                String strD2 = frVar.d(b9.h.k0);
                String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(frVar);
                String str2 = !TextUtils.isEmpty(strFetchDemandSourceId) ? strFetchDemandSourceId : strD2;
                JSONObject jSONObject = (JSONObject) frVar.b(b9.h.l0);
                String strD3 = frVar.d(b9.h.m);
                eh.e eVarG = v.this.g(strD3);
                if (!v.this.q(strD3)) {
                    v.this.a(str, false, b9.c.v, (String) null);
                    return;
                }
                String strE = v.this.e(str);
                if (!TextUtils.isEmpty(strE)) {
                    v.this.i(v.this.a(strE, v.this.a(b9.h.m, strD3, b9.h.j0, strD, "demandSourceName", strD2, "demandSourceId", str2, null, false), b9.g.c0, b9.g.d0));
                }
                v.this.b(new m(eVarG, str2, strD, jSONObject));
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void removeCloseEventHandler(String str) {
            Logger.i(v.this.c, "removeCloseEventHandler(" + str + ")");
            if (v.this.l != null) {
                v.this.l.cancel();
            }
            v.this.k = true;
        }

        @JavascriptInterface
        public void removeMessagingInterface(String str) {
            v.this.c(new p());
        }

        @JavascriptInterface
        public void requestToDestroyBanner(String str) {
            Logger.i(v.this.c, "onCleanUpNonDisplayBannersFail() value=" + str);
        }

        @JavascriptInterface
        public void resumeControllerWebview() {
            v.this.c(new k());
        }

        @JavascriptInterface
        public void saveFile(String str) {
            try {
                Logger.i(v.this.c, "saveFile(" + str + ")");
                fr frVar = new fr(str);
                String strD = frVar.d("path");
                String strD2 = frVar.d("file");
                if (TextUtils.isEmpty(strD2)) {
                    v.this.a(str, false, b9.c.g, "1");
                    return;
                }
                nh nhVar = new nh(IronSourceStorageUtils.buildAbsolutePathToDirInCache(v.this.A, strD), SDKUtils.getFileName(strD2));
                IronSourceStorageUtils.ensurePathSafety(nhVar, v.this.A);
                if (v.this.X.a(v.this.A) <= 0) {
                    v.this.a(str, false, d9.A, (String) null);
                    return;
                }
                if (nhVar.exists()) {
                    v.this.a(str, false, d9.z, (String) null);
                    return;
                }
                if (!x8.h(v.this.Z.getContext())) {
                    v.this.a(str, false, d9.C, (String) null);
                    return;
                }
                v.this.a(str, true, (String) null, (String) null);
                v.this.h.a(nhVar, strD2, frVar.a("connectionTimeout", 0), frVar.a("readTimeout", 0));
            } catch (Exception e2) {
                o9.d().a(e2);
                v.this.a(str, false, e2.getMessage(), (String) null);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void setBackButtonState(String str) {
            Logger.i(v.this.c, "setBackButtonState(" + str + ")");
            ik.e().c(new fr(str).d("state"));
        }

        @JavascriptInterface
        public void setForceClose(String str) {
            Logger.i(v.this.c, "setForceClose(" + str + ")");
            fr frVar = new fr(str);
            String strD = frVar.d("width");
            String strD2 = frVar.d("height");
            v.this.n = Integer.parseInt(strD);
            v.this.o = Integer.parseInt(strD2);
            v.this.p = frVar.d(b9.h.L);
        }

        @JavascriptInterface
        public void setMixedContentAlwaysAllow(String str) {
            Logger.i(v.this.c, "setMixedContentAlwaysAllow(" + str + ")");
            v.this.c(new q());
        }

        @JavascriptInterface
        public void setOrientation(String str) {
            try {
                Logger.i(v.this.c, "setOrientation(" + str + ")");
                String strD = new fr(str).d("orientation");
                v.this.n(strD);
                if (v.this.a0 != null) {
                    v.this.a0.onOrientationChanged(strD, v.this.X.L(v.this.Z.getContext()));
                }
            } catch (Exception e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
        }

        @JavascriptInterface
        public void setStoreSearchKeys(String str) {
            Logger.i(v.this.c, "setStoreSearchKeys(" + str + ")");
            ik.e().e(str);
        }

        @JavascriptInterface
        public void setUserData(String str) {
            Logger.i(v.this.c, "setUserData(" + str + ")");
            fr frVar = new fr(str);
            if (!frVar.a("key")) {
                v.this.a(str, false, b9.c.F, (String) null);
                return;
            }
            if (!frVar.a("value")) {
                v.this.a(str, false, b9.c.G, (String) null);
                return;
            }
            String strD = frVar.d("key");
            String strD2 = frVar.d("value");
            ik.e().a(strD, strD2);
            v.this.i(v.this.e(v.this.e(str), v.this.a(strD, strD2, null, null, null, null, null, null, null, false)));
        }

        @JavascriptInterface
        public void setWebviewBackgroundColor(String str) {
            Logger.i(v.this.c, "setWebviewBackgroundColor(" + str + ")");
            v.this.p(str);
        }

        @JavascriptInterface
        public void stillAlive(String str) {
            Logger.i(v.this.c, "stillAlive(" + str + ")");
            v.this.b.a();
        }
    }

    private interface s {
        void a(String str, eh.e eVar, va vaVar);
    }

    static class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4397a;
        String b;

        t() {
        }
    }

    public enum u {
        Display,
        Gone
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.v$v, reason: collision with other inner class name */
    private class C0409v extends WebViewClient {
        private C0409v() {
        }

        /* synthetic */ C0409v(v vVar, f fVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(com.safedk.android.utils.h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$v;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(com.safedk.android.utils.h.f, webView, str);
            safedk_v$v_onPageFinished_0744fe5b193fadbba4c5f244a35a6708(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$v;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(com.safedk.android.utils.h.f, webView, str);
            safedk_v$v_onPageStarted_3f2eb5566946e49013a48351da6c4cdb(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$v;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(com.safedk.android.utils.h.f, webView, i, str, str2);
            safedk_v$v_onReceivedError_d842d06439809a8ea200b78c671fd35e(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.e(v.this.c, "Chromium process crashed - detail.didCrash(): " + renderProcessGoneDetail.didCrash());
            String str = renderProcessGoneDetail.didCrash() ? "Render process was observed to crash" : "Render process was killed by the system";
            if (v.this.Q != null) {
                v.this.Q.c(str);
            }
            v.this.w();
            return true;
        }

        public void safedk_v$v_onPageFinished_0744fe5b193fadbba4c5f244a35a6708(WebView p0, String p1) {
            Logger.i("onPageFinished", p1);
            if (p1.contains("adUnit") || p1.contains(Constants.AD_INDEX_FILE_NAME)) {
                v.this.A();
            }
            super.onPageFinished(p0, p1);
        }

        public void safedk_v$v_onPageStarted_3f2eb5566946e49013a48351da6c4cdb(WebView p0, String p1, Bitmap p2) {
            Logger.i("onPageStarted", p1);
            super.onPageStarted(p0, p1, p2);
        }

        public void safedk_v$v_onReceivedError_d842d06439809a8ea200b78c671fd35e(WebView p0, int p1, String p2, String p3) {
            Logger.i("onReceivedError", p3 + " " + p2);
            if (p3.contains(b9.f) && v.this.Q != null) {
                v.this.Q.b("controller html - web-view receivedError on loading - " + p2 + " (errorCode: " + p1 + ")");
            }
            super.onReceivedError(p0, p1, p2, p3);
        }

        public WebResourceResponse safedk_v$v_shouldInterceptRequest_5c461aa1e9e69284a9030fd53419845e(WebView p0, String p1) {
            boolean zContains;
            Logger.i("shouldInterceptRequest", p1);
            try {
                zContains = new URL(p1).getFile().contains("mraid.js");
            } catch (MalformedURLException e) {
                o9.d().a(e);
                zContains = false;
            }
            if (zContains) {
                String str = AdPayload.FILE_SCHEME + v.this.A + File.separator + "mraid.js";
                try {
                    new FileInputStream(new File(str));
                    return new WebResourceResponse(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT, "UTF-8", getClass().getResourceAsStream(str));
                } catch (FileNotFoundException e2) {
                    o9.d().a(e2);
                }
            }
            return super.shouldInterceptRequest(p0, p1);
        }

        public boolean safedk_v$v_shouldOverrideUrlLoading_4b37c78883c9cf18ce250534c1de11cd(WebView p0, String p1) {
            Logger.i("shouldOverrideUrlLoading", p1);
            try {
                if (v.this.h(p1)) {
                    v.this.z();
                    return true;
                }
            } catch (Exception e) {
                o9.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
            return super.shouldOverrideUrlLoading(p0, p1);
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$v;->shouldInterceptRequest(Landroid/webkit/WebView;Ljava/lang/String;)Landroid/webkit/WebResourceResponse;");
            return CreativeInfoManager.onWebViewResponse(com.safedk.android.utils.h.f, webView, str, safedk_v$v_shouldInterceptRequest_5c461aa1e9e69284a9030fd53419845e(webView, str));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/v$v;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_v$v_shouldOverrideUrlLoading_4b37c78883c9cf18ce250534c1de11cd = safedk_v$v_shouldOverrideUrlLoading_4b37c78883c9cf18ce250534c1de11cd(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(com.safedk.android.utils.h.f, webView, str, zSafedk_v$v_shouldOverrideUrlLoading_4b37c78883c9cf18ce250534c1de11cd);
            return zSafedk_v$v_shouldOverrideUrlLoading_4b37c78883c9cf18ce250534c1de11cd;
        }
    }

    public v(Context context, wa waVar, e9 e9Var, com.json.sdk.controller.c cVar, hg hgVar, int i2, gb gbVar, String str, com.ironsource.sdk.controller.l.a aVar, com.ironsource.sdk.controller.l.b bVar, String str2, String str3) throws Throwable {
        kk kkVar = new kk(context, new vk.a());
        this.Z = kkVar;
        Logger.i(this.c, "C'tor");
        this.Y = e9Var;
        this.Q = cVar;
        this.f4355a = hgVar;
        this.G = waVar;
        a(context, kkVar);
        this.A = str;
        this.D = new a3();
        this.S = IronSourceNetworkBridge.jsonObjectInit();
        this.h = gbVar;
        this.T = aVar;
        this.U = bVar;
        boolean zOptBoolean = SDKUtils.getNetworkConfiguration().optBoolean(b9.a.i, false);
        this.W = zOptBoolean;
        if (zOptBoolean) {
            this.V = new l9(new i9(SDKUtils.getControllerUrl(), this.A, SDKUtils.getNetworkConfiguration().optBoolean("useWebViewUserAgent", false), new ep(SDKUtils.getControllerUrl())), new Function1() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.c((nh) obj);
                }
            }, gbVar, new q9.a());
        } else {
            gbVar.a(this);
            this.B = new com.json.sdk.controller.d(SDKUtils.getNetworkConfiguration(), this.A, SDKUtils.getControllerUrl(), gbVar);
        }
        f fVar = null;
        o oVar = new o(this, fVar);
        this.q = oVar;
        kkVar.setWebViewClient(new C0409v(this, fVar));
        kkVar.setWebChromeClient(oVar);
        kw.a(kkVar);
        a(kkVar);
        kkVar.setDownloadListener(this);
        this.R = c(context);
        b(context);
        b(i2);
        this.f = str2;
        this.g = str3;
        this.b = h9.a(FeaturesManager.getInstance().getFeatureFlagHealthCheck());
    }

    private void G() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public s9 a(eh.e eVar) {
        if (eVar == eh.e.Interstitial) {
            return this.y;
        }
        if (eVar == eh.e.RewardedVideo) {
            return this.x;
        }
        if (eVar == eh.e.Banner) {
            return this.z;
        }
        return null;
    }

    private t a(eh.e eVar, va vaVar) {
        t tVar = new t();
        if (eVar == eh.e.RewardedVideo || eVar == eh.e.Interstitial || eVar == eh.e.Banner) {
            HashMap map = new HashMap();
            map.put(b9.i.g, this.f);
            if (!TextUtils.isEmpty(this.g)) {
                map.put(b9.i.f, this.g);
            }
            if (vaVar != null) {
                if (vaVar.g() != null) {
                    map.putAll(vaVar.g());
                    map.put(b9.h.y0, String.valueOf(m0.f3880a.c(vaVar.h())));
                }
                map.put("demandSourceName", vaVar.f());
                map.put("demandSourceId", vaVar.h());
            }
            String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
            b9.g gVarA = b9.g.a(eVar);
            String strA = a(gVarA.f3551a, strFlatMapToJsonAsString, gVarA.b, gVarA.c);
            tVar.f4397a = gVarA.f3551a;
            tVar.b = strA;
        }
        return tVar;
    }

    private String a(eh.e eVar, JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("sessionDepth", Integer.toString(jSONObject.optInt("sessionDepth")));
        String strOptString = jSONObject.optString("demandSourceName");
        String strFetchDemandSourceId = SDKUtils.fetchDemandSourceId(jSONObject);
        va vaVarA = this.G.a(eVar, strFetchDemandSourceId);
        if (vaVarA != null) {
            if (vaVarA.g() != null) {
                map.putAll(vaVarA.g());
            }
            if (!TextUtils.isEmpty(strOptString)) {
                map.put("demandSourceName", strOptString);
            }
            if (!TextUtils.isEmpty(strFetchDemandSourceId)) {
                map.put("demandSourceId", strFetchDemandSourceId);
            }
        }
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        b9.g gVarB = b9.g.b(eVar);
        return a(gVarB.f3551a, strFlatMapToJsonAsString, gVarB.b, gVarB.c);
    }

    private String a(String str, String str2) {
        return a(str, str2, b9.h.g);
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            return IronSourceNetworkBridge.jsonObjectInit(str).put(str3, str2).toString();
        } catch (JSONException e2) {
            o9.d().a(e2);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4) {
        return new com.ironsource.sdk.controller.m.a(str, str2, str3, str4).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                jSONObjectJsonObjectInit.put(str, SDKUtils.encodeString(str2));
            }
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                jSONObjectJsonObjectInit.put(str3, SDKUtils.encodeString(str4));
            }
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                jSONObjectJsonObjectInit.put(str5, SDKUtils.encodeString(str6));
            }
            if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str8)) {
                jSONObjectJsonObjectInit.put(str7, SDKUtils.encodeString(str8));
            }
            if (!TextUtils.isEmpty(str9)) {
                jSONObjectJsonObjectInit.put(str9, z);
            }
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        return jSONObjectJsonObjectInit.toString();
    }

    private void a(Context context, WebView webView) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.u = new FrameLayout(context);
        this.s = new FrameLayout(context);
        this.s.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.s.setVisibility(8);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(webView);
        this.u.addView(this.s, layoutParams);
        this.u.addView(frameLayout);
    }

    private void a(WebSettings webSettings) {
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }

    private void a(WebView webView) {
        com.json.sdk.controller.s sVar = new com.json.sdk.controller.s(com.json.sdk.controller.s.a());
        IronSourceNetworkBridge.onAddedJavascriptInterface(webView, a(sVar), "Android");
        IronSourceNetworkBridge.onAddedJavascriptInterface(webView, b(sVar), b9.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(qe qeVar) {
        try {
            this.Q.a(qeVar);
        } catch (Exception e2) {
            o9.d().a(e2);
            Logger.e(this.c, "handleLoadAd: " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(te teVar) {
        teVar.a(new ue() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda3
            @Override // com.json.ue
            public final void a(qe qeVar) {
                this.f$0.a(qeVar);
            }
        });
    }

    private void a(va vaVar, Map<String, String> map) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, vaVar.b()});
        if (map.containsKey("adm")) {
            this.b.a(new h9.d() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda0
                @Override // com.ironsource.h9.d
                public final void a(te teVar) {
                    this.f$0.a(teVar);
                }
            });
        }
        this.D.d(vaVar.h(), true);
        i(a(b9.g.E, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), b9.g.F, b9.g.G));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, eh.e eVar, va vaVar) {
        if (q(eVar.toString())) {
            b(new m(eVar, vaVar, str));
        }
    }

    private void a(String str, eh.e eVar, va vaVar, s sVar) {
        if (TextUtils.isEmpty(str)) {
            sVar.a("Application key are missing", eVar, vaVar);
        } else {
            i(a(eVar, vaVar).b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, String str2, String str3) {
        String strD = new fr(str).d(z ? g0 : h0);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        i(e(strD, a(b(str, str2), str3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, WebView webView) {
        boolean zOptBoolean = jSONObject.optBoolean("inspectWebview");
        if (zOptBoolean) {
            WebView.setWebContentsDebuggingEnabled(zOptBoolean);
        }
    }

    private String b(String str) {
        String str2 = this.A + File.separator;
        return str.contains(str2) ? str.substring(str2.length()) : str;
    }

    private String b(String str, String str2) {
        return a(str, str2, "errMsg");
    }

    private v8 c(Context context) {
        return new f(SDKUtils.getControllerConfigAsJSONObject(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(nh nhVar) {
        this.h.a(this);
        if (nhVar == null || !nhVar.exists()) {
            a(new nh(b9.f), new fh(1, "Unable to download Html file"));
            return null;
        }
        a(nhVar);
        return null;
    }

    private String c(String str, String str2, String str3) {
        return new com.ironsource.sdk.controller.m.a(str, null, str2, str3).a();
    }

    private void c(JSONObject jSONObject) throws JSONException {
        jSONObject.put(SDKUtils.encodeString("gpi"), dp.d(this.Z.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        return new fr(str).d(h0);
    }

    private String d(JSONObject jSONObject) {
        za zaVarB = za.b(this.Z.getContext());
        StringBuilder sb = new StringBuilder();
        String sDKVersion = SDKUtils.getSDKVersion();
        if (!TextUtils.isEmpty(sDKVersion)) {
            sb.append("SDKVersion=").append(sDKVersion).append(b9.i.c);
        }
        String strE = zaVarB.e();
        if (!TextUtils.isEmpty(strE)) {
            sb.append("deviceOs=").append(strE);
        }
        Uri uri = Uri.parse(SDKUtils.getControllerUrl());
        if (uri != null) {
            String str = uri.getScheme() + ":";
            String host = uri.getHost();
            int port = uri.getPort();
            if (port != -1) {
                host = host + ":" + port;
            }
            sb.append("&protocol=").append(str);
            sb.append("&domain=").append(host);
            if (jSONObject.keys().hasNext()) {
                try {
                    String string = new JSONObject(jSONObject, new String[]{b9.i.Z, b9.i.g}).toString();
                    if (!TextUtils.isEmpty(string)) {
                        sb.append(b9.i.c).append("controllerConfig").append("=").append(string);
                    }
                } catch (JSONException e2) {
                    o9.d().a(e2);
                    IronLog.INTERNAL.error(e2.toString());
                }
            }
            sb.append("&debug=").append(r());
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] d(Context context) {
        za zaVarB = za.b(context);
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        boolean z = false;
        try {
            jSONObjectJsonObjectInit.put(b9.i.z, "none");
            jSONObjectJsonObjectInit.put(b9.i.A, SDKUtils.translateDeviceOrientation(this.X.H(context)));
            String strD = zaVarB.d();
            if (strD != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.k), SDKUtils.encodeString(strD));
            }
            String strC = zaVarB.c();
            if (strC != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.l), SDKUtils.encodeString(strC));
            } else {
                z = true;
            }
            SDKUtils.loadGoogleAdvertiserInfo(context);
            String advertiserId = SDKUtils.getAdvertiserId();
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(this.c, "add AID");
                jSONObjectJsonObjectInit.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
            }
            String limitAdTracking = SDKUtils.getLimitAdTracking();
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(this.c, "add LAT");
                jSONObjectJsonObjectInit.put(b9.i.M, Boolean.parseBoolean(limitAdTracking));
            }
            String strE = zaVarB.e();
            if (strE != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.m), SDKUtils.encodeString(strE));
            } else {
                z = true;
            }
            String strF = zaVarB.f();
            if (strF != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.n), strF.replaceAll("[^0-9/.]", ""));
            } else {
                z = true;
            }
            String strF2 = zaVarB.f();
            if (strF2 != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.o), SDKUtils.encodeString(strF2));
            }
            String strValueOf = String.valueOf(zaVarB.a());
            if (strValueOf != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.p), strValueOf);
            } else {
                z = true;
            }
            jSONObjectJsonObjectInit.put(fe.e0, String.valueOf(k1.a()));
            String sDKVersion = SDKUtils.getSDKVersion();
            if (sDKVersion != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.q), SDKUtils.encodeString(sDKVersion));
            }
            if (zaVarB.b() != null && zaVarB.b().length() > 0) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.r), SDKUtils.encodeString(zaVarB.b()));
            }
            String strB = y8.b(context);
            if (strB.equals("none")) {
                z = true;
            } else {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.t), SDKUtils.encodeString(strB));
            }
            String strD2 = y8.d(context);
            if (strD2 != null) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.u), SDKUtils.encodeString(strD2));
            } else {
                z = true;
            }
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.v), y8.e(context));
            jSONObjectJsonObjectInit.put("uxt", IronSourceStorageUtils.isUxt());
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
            }
            jSONObjectJsonObjectInit.put(b9.i.y, SDKUtils.encodeString(String.valueOf(this.X.a(this.A))));
            String strValueOf2 = String.valueOf(this.X.s());
            if (TextUtils.isEmpty(strValueOf2)) {
                z = true;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(SDKUtils.encodeString(b9.i.G)).append(b9.i.d).append(SDKUtils.encodeString("width")).append(b9.i.e);
                jSONObjectJsonObjectInit.put(sb.toString(), SDKUtils.encodeString(strValueOf2));
            }
            String strValueOf3 = String.valueOf(this.X.a());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SDKUtils.encodeString(b9.i.G)).append(b9.i.d).append(SDKUtils.encodeString("height")).append(b9.i.e);
            jSONObjectJsonObjectInit.put(sb2.toString(), SDKUtils.encodeString(strValueOf3));
            String strG = c4.g(this.Z.getContext());
            if (!TextUtils.isEmpty(strG)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(strG));
            }
            String strValueOf4 = String.valueOf(this.X.h());
            if (!TextUtils.isEmpty(strValueOf4)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.K), SDKUtils.encodeString(strValueOf4));
            }
            String strValueOf5 = String.valueOf(this.X.f());
            if (!TextUtils.isEmpty(strValueOf5)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.O), SDKUtils.encodeString(strValueOf5));
            }
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.P), za.b(context).a(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.Y), this.X.y(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("mcc"), x8.b(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("mnc"), x8.c(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.S), x8.f(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.R), SDKUtils.encodeString(x8.g(context)));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.V), c4.f(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.X), c4.d(context));
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(c4.b(context)));
            String strE2 = c4.e(context);
            if (!TextUtils.isEmpty(strE2)) {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.c0), SDKUtils.encodeString(strE2));
            }
            c(jSONObjectJsonObjectInit);
            jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.p0), this.X.C(context));
        } catch (JSONException e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
        }
        return new Object[]{jSONObjectJsonObjectInit.toString(), Boolean.valueOf(z)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        return new fr(str).d(g0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str, String str2) {
        return new com.ironsource.sdk.controller.m.a(str, str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        try {
            v8 v8Var = this.R;
            if (v8Var == null) {
                return;
            }
            v8Var.b(context);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    private String f(String str) {
        return new com.ironsource.sdk.controller.m.a(str).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        try {
            v8 v8Var = this.R;
            if (v8Var == null) {
                return;
            }
            v8Var.c(context);
        } catch (Throwable th) {
            o9.d().a(th);
            IronLog.INTERNAL.error(th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] f(String str, String str2) {
        boolean z;
        JSONObject jSONObjectJsonObjectInit = IronSourceNetworkBridge.jsonObjectInit();
        boolean z2 = true;
        Map<String, String> mapG = null;
        if (TextUtils.isEmpty(str)) {
            z = true;
        } else {
            va vaVarA = this.G.a(g(str), str2);
            if (vaVarA != null) {
                mapG = vaVarA.g();
                mapG.put("demandSourceName", vaVarA.f());
                mapG.put("demandSourceId", vaVarA.h());
            }
            try {
                jSONObjectJsonObjectInit.put(b9.h.m, str);
            } catch (JSONException e2) {
                o9.d().a(e2);
                IronLog.INTERNAL.error(e2.toString());
            }
            z = false;
            try {
                Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
                if (initSDKParams != null) {
                    jSONObjectJsonObjectInit = SDKUtils.mergeJSONObjects(jSONObjectJsonObjectInit, new JSONObject(initSDKParams));
                }
            } catch (Exception e3) {
                o9.d().a(e3);
                IronLog.INTERNAL.error(e3.toString());
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            try {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.f), SDKUtils.encodeString(this.g));
            } catch (JSONException e4) {
                o9.d().a(e4);
                IronLog.INTERNAL.error(e4.toString());
            }
        }
        if (!TextUtils.isEmpty(this.f)) {
            try {
                jSONObjectJsonObjectInit.put(SDKUtils.encodeString(b9.i.g), SDKUtils.encodeString(this.f));
            } catch (JSONException e5) {
                o9.d().a(e5);
                IronLog.INTERNAL.error(e5.toString());
            }
            z2 = z;
        }
        if (mapG != null && !mapG.isEmpty()) {
            for (Map.Entry<String, String> entry : mapG.entrySet()) {
                if (entry.getKey().equalsIgnoreCase("sdkWebViewCache")) {
                    o(entry.getValue());
                }
                try {
                    jSONObjectJsonObjectInit.put(SDKUtils.encodeString(entry.getKey()), SDKUtils.encodeString(entry.getValue()));
                } catch (JSONException e6) {
                    o9.d().a(e6);
                    IronLog.INTERNAL.error(e6.toString());
                }
            }
        }
        return new Object[]{jSONObjectJsonObjectInit.toString(), Boolean.valueOf(z2)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public eh.e g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        eh.e eVar = eh.e.Interstitial;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        eh.e eVar2 = eh.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        eh.e eVar3 = eh.e.Banner;
        if (str.equalsIgnoreCase(eVar3.toString())) {
            return eVar3;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c(new Runnable() { // from class: com.ironsource.sdk.controller.v$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.j(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str) {
        this.Z.a(new com.ironsource.sdk.controller.m.b(str, r()).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        try {
            Logger.i(this.c, "load(): " + str);
            IronSourceNetworkBridge.webviewLoadUrl(this.Z, str);
        } catch (Throwable th) {
            o9.d().a(th);
            Logger.e(this.c, "WebViewController::load: " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        so soVar = this.a0;
        if (soVar != null) {
            soVar.onCloseRequested();
        }
    }

    private void o(String str) {
        WebSettings settings;
        int i2;
        if (str.equalsIgnoreCase("0")) {
            settings = this.Z.getSettings();
            i2 = 2;
        } else {
            settings = this.Z.getSettings();
            i2 = -1;
        }
        settings.setCacheMode(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        WebView presentingView;
        fr frVar = new fr(str);
        String strD = frVar.d("color");
        String strD2 = frVar.d("adViewId");
        int color = !b9.h.T.equalsIgnoreCase(strD) ? Color.parseColor(strD) : 0;
        if (strD2 != null) {
            presentingView = bh.a().a(strD2).getPresentingView();
            if (presentingView == null) {
                return;
            }
        } else {
            presentingView = this.Z;
        }
        presentingView.setBackgroundColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            Logger.d(this.c, "Trying to trigger a listener - no product was found");
            return false;
        }
        if (!str.equalsIgnoreCase(eh.e.Interstitial.toString()) ? !(!str.equalsIgnoreCase(eh.e.RewardedVideo.toString()) ? !str.equalsIgnoreCase(eh.e.Banner.toString()) || this.z == null : this.x == null) : this.y != null) {
            z = true;
        }
        if (!z) {
            Logger.d(this.c, "Trying to trigger a listener - no listener was found for product " + str);
        }
        return z;
    }

    public void A() {
        i(f(b9.g.A));
    }

    public void B() {
        try {
            this.Z.onPause();
        } catch (Throwable th) {
            o9.d().a(th);
            Logger.i(this.c, "WebViewController: onPause() - " + th);
        }
    }

    public void C() {
        this.C = null;
    }

    public void D() {
        this.Z.a();
        this.a0 = null;
    }

    public void E() {
        this.Z.requestFocus();
    }

    public void F() {
        try {
            this.Z.onResume();
        } catch (Throwable th) {
            o9.d().a(th);
            Logger.i(this.c, "WebViewController: onResume() - " + th);
        }
    }

    com.json.sdk.controller.g a(com.json.sdk.controller.s sVar) {
        return new com.json.sdk.controller.g(new com.json.sdk.controller.b(new r()), sVar);
    }

    @Override // com.json.sdk.controller.l
    public void a() {
        if (this.W) {
            this.V.a();
            return;
        }
        this.B.a(new gh());
        if (this.B.k()) {
            a(1);
        }
    }

    public void a(int i2) {
        if (!this.W && !this.B.m()) {
            Logger.i(this.c, "load(): Mobile Controller HTML Does not exist");
            return;
        }
        JSONObject controllerConfigAsJSONObject = SDKUtils.getControllerConfigAsJSONObject();
        String strD = d(controllerConfigAsJSONObject);
        Map<String, String> initSDKParams = SDKUtils.getInitSDKParams();
        if (initSDKParams != null && initSDKParams.containsKey("sessionid")) {
            strD = String.format("%s&sessionid=%s", strD, initSDKParams.get("sessionid"));
        }
        this.f4355a.d(new h(controllerConfigAsJSONObject, this.Z, (this.W ? this.V.getHtmlFile() : this.B.g()).toURI().toString() + "?" + strD));
        this.m = new i(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, 1000L, i2).start();
    }

    @Override // com.json.sdk.controller.l
    public void a(Activity activity) {
        this.Y.a(activity);
    }

    @Override // com.json.sdk.controller.l
    public void a(Context context) {
        a(new d(context));
    }

    public void a(a3 a3Var) {
        String strB;
        s9 s9VarA;
        synchronized (this.E) {
            if (a3Var.j() && this.i) {
                Log.d(this.c, "restoreState(state:" + a3Var + ")");
                int iC = a3Var.c();
                if (iC != -1) {
                    eh.e eVar = eh.e.RewardedVideo;
                    if (iC == eVar.ordinal()) {
                        Log.d(this.c, "onRVAdClosed()");
                        strB = a3Var.b();
                        s9VarA = a(eVar);
                        if (s9VarA != null && !TextUtils.isEmpty(strB)) {
                            s9VarA.a(eVar, strB);
                        }
                    } else {
                        eVar = eh.e.Interstitial;
                        if (iC == eVar.ordinal()) {
                            Log.d(this.c, "onInterstitialAdClosed()");
                            strB = a3Var.b();
                            s9VarA = a(eVar);
                            if (s9VarA != null && !TextUtils.isEmpty(strB)) {
                                s9VarA.a(eVar, strB);
                            }
                        }
                    }
                    a3Var.a(-1);
                    a3Var.f(null);
                } else {
                    Log.d(this.c, "No ad was opened");
                }
                String strD = a3Var.d();
                String strF = a3Var.f();
                for (va vaVar : this.G.a(eh.e.Interstitial)) {
                    if (vaVar.e() == 2) {
                        Log.d(this.c, "initInterstitial(appKey:" + strD + ", userId:" + strF + ", demandSource:" + vaVar.f() + ")");
                        a(strD, strF, vaVar, this.y);
                    }
                }
                String strG = a3Var.g();
                String strH = a3Var.h();
                for (va vaVar2 : this.G.a(eh.e.RewardedVideo)) {
                    if (vaVar2.e() == 2) {
                        String strF2 = vaVar2.f();
                        Log.d(this.c, "onRVNoMoreOffers()");
                        this.x.c(strF2);
                        Log.d(this.c, "initRewardedVideo(appKey:" + strG + ", userId:" + strH + ", demandSource:" + strF2 + ")");
                        a(strG, strH, vaVar2, this.x);
                    }
                }
                a3Var.a(false);
            }
            this.D = a3Var;
        }
    }

    void a(eh.e eVar, String str) {
        b(new e(eVar, str));
    }

    @Override // com.json.po
    public void a(nh nhVar) {
        if (this.W && this.V.a(nhVar)) {
            a(1);
        } else if (nhVar.getName().contains(b9.f)) {
            this.B.a(new n());
        } else {
            c(nhVar.getName(), nhVar.getParent());
        }
    }

    @Override // com.json.po
    public void a(nh nhVar, fh fhVar) {
        if (this.W && this.V.a(nhVar)) {
            this.Q.b("controller html - failed to download - " + fhVar.b());
        } else if (nhVar.getName().contains(b9.f)) {
            this.B.a(new a(), new b(fhVar));
        } else {
            b(nhVar.getName(), nhVar.getParent(), fhVar.b());
        }
    }

    public void a(nv nvVar) {
        this.C = nvVar;
    }

    public void a(s3 s3Var) {
        this.N = s3Var;
    }

    public void a(com.json.sdk.controller.a aVar) {
        this.L = aVar;
        aVar.a(p());
    }

    @Override // com.json.sdk.controller.l
    public void a(com.ironsource.sdk.controller.f.c cVar, com.ironsource.sdk.controller.l.a aVar) {
        i(a(cVar.e(), cVar.h(), b9.g.U, b9.g.U));
    }

    public void a(com.json.sdk.controller.i iVar) {
        this.K = iVar;
    }

    public void a(com.json.sdk.controller.j jVar) {
        this.M = jVar;
    }

    public void a(com.json.sdk.controller.o oVar) {
        this.H = oVar;
    }

    public void a(com.json.sdk.controller.q qVar) {
        this.I = qVar;
    }

    public void a(com.json.sdk.controller.u uVar) {
        this.J = uVar;
    }

    public void a(u uVar) {
        this.v = uVar;
    }

    public void a(so soVar) {
        this.a0 = soVar;
        this.Z.a(soVar);
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar) {
        Map<String, String> mapB = vaVar.b();
        if (mapB != null) {
            i(a(b9.g.S, SDKUtils.flatMapToJsonAsString(mapB), b9.g.P, b9.g.Q));
        }
        this.G.b(eh.e.Banner, vaVar.h());
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, t9 t9Var) {
        Map<String, String> mapMergeHashMaps = SDKUtils.mergeHashMaps(new Map[]{map, vaVar.b()});
        if (map != null) {
            i(a(b9.g.N, SDKUtils.flatMapToJsonAsString(mapMergeHashMaps), b9.g.O, b9.g.R));
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(va vaVar, Map<String, String> map, u9 u9Var) {
        i(a(eh.e.Interstitial, new JSONObject(SDKUtils.mergeHashMaps(new Map[]{map, vaVar.b()}))));
    }

    public void a(y9 y9Var) {
        this.O = y9Var;
    }

    void a(Runnable runnable) {
        hg hgVar = this.f4355a;
        if (hgVar != null) {
            hgVar.b(runnable);
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, u9 u9Var) {
        HashMap map = new HashMap();
        map.put("demandSourceName", str);
        String strFlatMapToJsonAsString = SDKUtils.flatMapToJsonAsString(map);
        this.D.d(str, true);
        i(a(b9.g.E, strFlatMapToJsonAsString, b9.g.F, b9.g.G));
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, t9 t9Var) {
        this.f = str;
        this.g = str2;
        this.z = t9Var;
        a(str, eh.e.Banner, vaVar, new l());
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, u9 u9Var) {
        this.f = str;
        this.g = str2;
        this.y = u9Var;
        this.D.g(str);
        this.D.h(this.g);
        a(this.f, eh.e.Interstitial, vaVar, new k());
    }

    @Override // com.json.sdk.controller.l
    public void a(String str, String str2, va vaVar, v9 v9Var) {
        this.f = str;
        this.g = str2;
        this.x = v9Var;
        this.D.i(str);
        this.D.j(str2);
        a(str, eh.e.RewardedVideo, vaVar, new j());
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.S = jSONObject;
        }
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, t9 t9Var) {
        i(a(b9.g.N, jSONObject.toString(), b9.g.O, b9.g.R));
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, u9 u9Var) {
        i(a(eh.e.Interstitial, jSONObject));
    }

    @Override // com.json.sdk.controller.l
    public void a(JSONObject jSONObject, v9 v9Var) {
        i(a(eh.e.RewardedVideo, jSONObject));
    }

    public void a(boolean z, String str) {
        i(e(b9.g.V, a(b9.h.K, str, null, null, null, null, null, null, b9.h.o, z)));
    }

    @Override // com.json.sdk.controller.l
    public boolean a(String str) {
        va vaVarA = this.G.a(eh.e.Interstitial, str);
        return vaVarA != null && vaVarA.d();
    }

    com.json.sdk.controller.r b(com.json.sdk.controller.s sVar) {
        return new com.json.sdk.controller.r(sVar);
    }

    public void b(int i2) {
        c0 = i2;
    }

    @Override // com.json.sdk.controller.l
    public void b(Context context) {
        a(new c(context));
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar) {
        Map<String, String> mapB = vaVar.b();
        if (mapB != null) {
            i(e(b9.g.T, SDKUtils.flatMapToJsonAsString(mapB)));
        }
        this.G.b(eh.e.Interstitial, vaVar.h());
    }

    @Override // com.json.sdk.controller.l
    public void b(va vaVar, Map<String, String> map, u9 u9Var) {
        a(vaVar, map);
    }

    void b(Runnable runnable) {
        hg hgVar = this.f4355a;
        if (hgVar != null) {
            hgVar.c(runnable);
        }
    }

    public void b(String str, String str2, String str3) {
        try {
            i(e(b9.g.q, a("file", str, "path", b(str2), "errMsg", str3, null, null, null, false)));
        } catch (Exception e2) {
            o9.d().a(e2);
        }
    }

    @Override // com.json.sdk.controller.l
    public void b(JSONObject jSONObject) {
        i(e(b9.g.e0, jSONObject != null ? jSONObject.toString() : null));
    }

    void c(Runnable runnable) {
        hg hgVar = this.f4355a;
        if (hgVar != null) {
            hgVar.d(runnable);
        }
    }

    public void c(String str) {
        if (str.equals(b9.h.i)) {
            o();
        }
        i(e(b9.g.z, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void c(String str, String str2) {
        try {
            i(e(b9.g.p, a("file", str, "path", b(str2), null, null, null, null, null, false)));
        } catch (Exception e2) {
            o9.d().a(e2);
            b(str, str2, e2.getMessage());
        }
    }

    @Override // com.json.sdk.controller.l
    public void d() {
        i(f(b9.g.t));
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = b9.c.z;
        }
        i(e(b9.g.a0, a("errMsg", str, "url", str2, null, null, null, null, null, false)));
    }

    @Override // com.json.sdk.controller.l
    public void destroy() {
        this.Z.destroy();
        gb gbVar = this.h;
        if (gbVar != null) {
            gbVar.d();
        }
        v8 v8Var = this.R;
        if (v8Var != null) {
            v8Var.b();
        }
        CountDownTimer countDownTimer = this.m;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // com.json.sdk.controller.l
    public void e() {
        a(this.D);
    }

    public void e(JSONObject jSONObject) {
        Logger.i(this.c, "device connection info changed: " + jSONObject.toString());
        i(e(b9.g.y, a(b9.i.h0, jSONObject.toString(), null, null, null, null, null, null, null, false)));
    }

    @Override // com.json.sdk.controller.l
    public void f() {
        i(f(b9.g.u));
    }

    @Override // com.json.sdk.controller.l
    public eh.c g() {
        return eh.c.Web;
    }

    public void g(String str, String str2) {
        i(e(b9.g.W, a(b9.h.p, str2, b9.h.m, str, null, null, null, null, null, false)));
    }

    public boolean h(String str) {
        try {
            if (!new hs(str, ik.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().c()).a()) {
                return false;
            }
            gv.a(q(), str);
            return true;
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return false;
        }
    }

    public void k(String str) {
        i(e(b9.g.w, a("action", str, null, null, null, null, null, null, null, false)));
    }

    public void m(String str) {
        try {
            String strD = y8.d(this.Z.getContext());
            Logger.i(this.c, "device status changed, connection type " + str);
            jh.a(str);
            jh.b(strD);
            i(e(b9.g.x, a(b9.i.t, str, b9.i.u, strD, null, null, null, null, null, false)));
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e2));
        }
    }

    public void n(String str) {
        this.w = str;
    }

    @Override // android.webkit.DownloadListener
    public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
        Logger.i(this.c, str + " " + str4);
    }

    public jw p() {
        if (this.P == null) {
            this.P = new g();
        }
        return this.P;
    }

    public Context q() {
        return this.Y.a();
    }

    public int r() {
        return c0;
    }

    public FrameLayout s() {
        return this.u;
    }

    public String t() {
        return this.w;
    }

    public a3 u() {
        return this.D;
    }

    public u v() {
        return this.v;
    }

    public void w() {
        if (this.j == null) {
            return;
        }
        o();
        eh.e eVarB = this.j.b();
        String strA = this.j.a();
        if (q(eVarB.toString())) {
            a(eVarB, strA);
        }
    }

    public void x() {
        this.q.onHideCustomView();
    }

    public boolean y() {
        return this.r != null;
    }

    public void z() {
        i(f(b9.g.Z));
    }
}

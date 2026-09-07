package com.json.sdk.controller;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.json.b9;
import com.json.gv;
import com.json.hs;
import com.json.ik;
import com.json.mediationsdk.logger.IronLog;
import com.json.o8;
import com.json.o9;
import com.json.sdk.utils.SDKUtils;
import com.json.vj;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.IronSourceNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;

/* JADX INFO: loaded from: classes6.dex */
public class OpenUrlActivity extends Activity {
    private static final String j = "OpenUrlActivity";
    private static final int k = SDKUtils.generateViewId();
    private static final int l = SDKUtils.generateViewId();
    private v b;
    private ProgressBar c;
    boolean d;
    private RelativeLayout e;
    private String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebView f4280a = null;
    private final Handler g = new Handler(Looper.getMainLooper());
    private boolean h = false;
    private final Runnable i = new b();

    class a implements View.OnSystemUiVisibilityChangeListener {
        a() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            if ((i & 4098) == 0) {
                OpenUrlActivity.this.g.removeCallbacks(OpenUrlActivity.this.i);
                OpenUrlActivity.this.g.postDelayed(OpenUrlActivity.this.i, 500L);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OpenUrlActivity.this.getWindow().getDecorView().setSystemUiVisibility(SDKUtils.getActivityUIFlags(OpenUrlActivity.this.h));
        }
    }

    private class c extends WebViewClient {
        private c() {
        }

        /* synthetic */ c(OpenUrlActivity openUrlActivity, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.f, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/OpenUrlActivity$c;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.f, webView, str);
            safedk_OpenUrlActivity$c_onPageFinished_9fad83dd06a646b10fca49eceda7481c(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/OpenUrlActivity$c;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(h.f, webView, str);
            safedk_OpenUrlActivity$c_onPageStarted_c4b32d45bcee73f84e3034882f9b4fe5(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/OpenUrlActivity$c;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.f, webView, i, str, str2);
            safedk_OpenUrlActivity$c_onReceivedError_bd764cf9b7792911f2a6b9a9b2c60c80(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            com.json.sdk.utils.Logger.e(OpenUrlActivity.j, "Chromium process crashed - detail.didCrash():" + renderProcessGoneDetail.didCrash());
            OpenUrlActivity.this.finish();
            return true;
        }

        public void safedk_OpenUrlActivity$c_onPageFinished_9fad83dd06a646b10fca49eceda7481c(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            OpenUrlActivity.this.c.setVisibility(4);
        }

        public void safedk_OpenUrlActivity$c_onPageStarted_c4b32d45bcee73f84e3034882f9b4fe5(WebView p0, String p1, Bitmap p2) {
            super.onPageStarted(p0, p1, p2);
            OpenUrlActivity.this.c.setVisibility(0);
        }

        public void safedk_OpenUrlActivity$c_onReceivedError_bd764cf9b7792911f2a6b9a9b2c60c80(WebView p0, int p1, String p2, String p3) {
            super.onReceivedError(p0, p1, p2, p3);
            try {
                o8 featureFlagCatchUrlError = FeaturesManager.getInstance().getFeatureFlagCatchUrlError();
                if (featureFlagCatchUrlError.c()) {
                    if (featureFlagCatchUrlError.e() && OpenUrlActivity.this.b != null) {
                        OpenUrlActivity.this.b.d(p2, p3);
                    }
                    if (featureFlagCatchUrlError.d()) {
                        OpenUrlActivity.this.finish();
                    }
                }
            } catch (Throwable th) {
                o9.d().a(th);
            }
        }

        public boolean safedk_OpenUrlActivity$c_shouldOverrideUrlLoading_40992ed28c4c47c03c78f7969ca723df(WebView p0, String p1) {
            if (!new hs(p1, ik.e().d(), FeaturesManager.getInstance().getFeatureFlagClickCheck().c()).a()) {
                return super.shouldOverrideUrlLoading(p0, p1);
            }
            try {
                gv.a(OpenUrlActivity.this, p1);
                OpenUrlActivity.this.b.z();
            } catch (Exception e) {
                o9.d().a(e);
                StringBuilder sb = new StringBuilder();
                sb.append(e instanceof ActivityNotFoundException ? b9.c.x : b9.c.y);
                if (OpenUrlActivity.this.b != null) {
                    OpenUrlActivity.this.b.d(sb.toString(), p1);
                }
            }
            OpenUrlActivity.this.finish();
            return true;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.f, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("IronSource|SafeDK: Execution> Lcom/ironsource/sdk/controller/OpenUrlActivity$c;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_OpenUrlActivity$c_shouldOverrideUrlLoading_40992ed28c4c47c03c78f7969ca723df = safedk_OpenUrlActivity$c_shouldOverrideUrlLoading_40992ed28c4c47c03c78f7969ca723df(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.f, webView, str, zSafedk_OpenUrlActivity$c_shouldOverrideUrlLoading_40992ed28c4c47c03c78f7969ca723df);
            return zSafedk_OpenUrlActivity$c_shouldOverrideUrlLoading_40992ed28c4c47c03c78f7969ca723df;
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final String f4284a = "is_store";
        static final String b = "external_url";
        static final String c = "secondary_web_view";
        static final String d = "immersive";
        static final String e = "no activity to handle url";
        static final String f = "activity failed to open with unspecified reason";

        private d() {
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.json.h f4285a;
        private int b;
        private String c;
        private boolean d = false;
        private boolean e = false;
        private boolean f = false;

        public e(com.json.h hVar) {
            this.f4285a = hVar;
        }

        public Intent a(Context context) {
            Intent intentA = this.f4285a.a(context);
            intentA.putExtra("external_url", this.c);
            intentA.putExtra("secondary_web_view", this.d);
            intentA.putExtra("is_store", this.e);
            intentA.putExtra(b9.h.v, this.f);
            if (!(context instanceof Activity)) {
                intentA.setFlags(this.b);
            }
            return intentA;
        }

        e a(int i) {
            this.b = i;
            return this;
        }

        public e a(String str) {
            this.c = str;
            return this;
        }

        e a(boolean z) {
            this.f = z;
            return this;
        }

        public e b(boolean z) {
            this.d = z;
            return this;
        }

        public e c(boolean z) {
            this.e = z;
            return this;
        }
    }

    private void a() {
        if (this.c == null) {
            ProgressBar progressBar = new ProgressBar(new ContextThemeWrapper(this, R.style.Theme.Holo.Light.Dialog));
            this.c = progressBar;
            progressBar.setId(l);
        }
        if (findViewById(l) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.c.setLayoutParams(layoutParams);
            this.c.setVisibility(4);
            this.e.addView(this.c);
        }
    }

    private void b() {
        if (this.f4280a == null) {
            WebView webView = new WebView(getApplicationContext());
            this.f4280a = webView;
            webView.setId(k);
            this.f4280a.getSettings().setJavaScriptEnabled(true);
            this.f4280a.setWebViewClient(new c(this, null));
            loadUrl(this.f);
        }
        if (findViewById(k) == null) {
            this.e.addView(this.f4280a, new RelativeLayout.LayoutParams(-1, -1));
        }
        a();
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(true, b9.h.Y);
        }
    }

    private void c() {
        WebView webView = this.f4280a;
        if (webView != null) {
            webView.destroy();
        }
    }

    private void d() {
        getWindow().addFlags(16);
    }

    private void e() {
        requestWindowFeature(1);
    }

    private void f() {
        getWindow().setFlags(1024, 1024);
    }

    private void g() {
        ViewGroup viewGroup;
        v vVar = this.b;
        if (vVar != null) {
            vVar.a(false, b9.h.Y);
            if (this.e == null || (viewGroup = (ViewGroup) this.f4280a.getParent()) == null) {
                return;
            }
            if (viewGroup.findViewById(k) != null) {
                viewGroup.removeView(this.f4280a);
            }
            if (viewGroup.findViewById(l) != null) {
                viewGroup.removeView(this.c);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.f, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void finish() {
        v vVar;
        if (this.d && (vVar = this.b) != null) {
            vVar.c(b9.h.j);
        }
        super.finish();
    }

    public void loadUrl(String str) {
        this.f4280a.stopLoading();
        this.f4280a.clearHistory();
        try {
            IronSourceNetworkBridge.webviewLoadUrl(this.f4280a, str);
        } catch (Throwable th) {
            o9.d().a(th);
            com.json.sdk.utils.Logger.e(j, "OpenUrlActivity:: loadUrl: " + th.toString());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.f4280a.canGoBack()) {
            this.f4280a.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.json.sdk.utils.Logger.i(j, "onCreate()");
        try {
            this.b = (v) vj.b((Context) this).a().j();
            e();
            f();
            Bundle extras = getIntent().getExtras();
            this.f = extras.getString("external_url");
            this.d = extras.getBoolean("secondary_web_view");
            boolean booleanExtra = getIntent().getBooleanExtra(b9.h.v, false);
            this.h = booleanExtra;
            if (booleanExtra) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new a());
                runOnUiThread(this.i);
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            this.e = relativeLayout;
            setContentView(relativeLayout, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception e2) {
            o9.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        c();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.h && (i == 25 || i == 24)) {
            this.g.postDelayed(this.i, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        g();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.h && z) {
            runOnUiThread(this.i);
        }
    }
}

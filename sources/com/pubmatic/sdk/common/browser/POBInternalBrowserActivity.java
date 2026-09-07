package com.pubmatic.sdk.common.browser;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.utility.POBAlertDialog;
import com.pubmatic.sdk.common.utility.POBDeepLinkUtil;
import com.pubmatic.sdk.common.utility.POBUtils;
import com.pubmatic.sdk.common.view.POBWebView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.internal.partials.PubMaticNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class POBInternalBrowserActivity extends Activity {
    private static List h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f7557a;
    private ImageView b;
    private WebView c;
    private ProgressBar d;
    private int e;
    private AlertDialog f;
    private ViewGroup g;

    public interface InternalBrowserListener {
        void onBrowserDismiss();

        void onBrowserStart();

        void onExternalBrowserClick(String str);
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBInternalBrowserActivity.this.finish();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBInternalBrowserActivity.this.l();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBInternalBrowserActivity.this.c != null) {
                POBInternalBrowserActivity.this.c.goForward();
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (POBInternalBrowserActivity.this.c != null) {
                POBInternalBrowserActivity.this.c.reload();
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            POBInternalBrowserActivity.this.j();
        }
    }

    private class f extends WebViewClient {

        class a implements POBAlertDialog.POBDialogListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SslErrorHandler f7564a;

            a(SslErrorHandler sslErrorHandler) {
                this.f7564a = sslErrorHandler;
            }

            @Override // com.pubmatic.sdk.common.utility.POBAlertDialog.POBDialogListener
            public void onCancel(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f7564a.cancel();
                if (POBInternalBrowserActivity.this.c == null || POBInternalBrowserActivity.this.c.copyBackForwardList().getCurrentIndex() >= 0) {
                    return;
                }
                POBInternalBrowserActivity.this.l();
            }

            @Override // com.pubmatic.sdk.common.utility.POBAlertDialog.POBDialogListener
            public void onSuccess(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.f7564a.proceed();
            }
        }

        private f() {
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.F, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.F, webView, str);
            safedk_POBInternalBrowserActivity$f_onPageFinished_c9390060b9cd2a4209280f0ed5fe90ed(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(h.F, webView, str);
            safedk_POBInternalBrowserActivity$f_onPageStarted_5072d965cde511e3cee1dbefb5e80af9(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.F, webView, i, str, str2);
            safedk_POBInternalBrowserActivity$f_onReceivedError_ca0af953dcb34007a59b11ae38ba4e7b(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.F, webView, webResourceRequest, webResourceError);
            safedk_POBInternalBrowserActivity$f_onReceivedError_df1baed107be9d337488f8e7935ea0e3(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            POBLog.warn("POBInternalBrowserActivity", "SSL error: %s", sslError);
            if (POBInternalBrowserActivity.this.d != null) {
                POBInternalBrowserActivity.this.d.setVisibility(8);
            }
            String str = "Connection to this site is not secure: " + POBInternalBrowserActivity.this.b(sslError.getPrimaryError());
            if (POBInternalBrowserActivity.this.isFinishing()) {
                POBLog.warn("POBInternalBrowserActivity", "Error showing ssl error dialog as activity is finishing!", new Object[0]);
                return;
            }
            if (POBInternalBrowserActivity.this.f != null) {
                if (POBInternalBrowserActivity.this.f.isShowing()) {
                    return;
                }
                POBInternalBrowserActivity.this.f.setMessage(str);
                POBInternalBrowserActivity.this.f.show();
                return;
            }
            AlertDialog.Builder builderBuild = POBAlertDialog.build(POBInternalBrowserActivity.this, "Warning!", str, new a(sslErrorHandler));
            if (builderBuild != null) {
                try {
                    POBInternalBrowserActivity.this.f = builderBuild.create();
                    POBInternalBrowserActivity.this.f.show();
                } catch (Exception unused) {
                    POBLog.error("POBInternalBrowserActivity", "Error showing ssl error dialog.", new Object[0]);
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            POBInternalBrowserActivity.this.h();
            POBInternalBrowserActivity.this.finish();
            return true;
        }

        public void safedk_POBInternalBrowserActivity$f_onPageFinished_c9390060b9cd2a4209280f0ed5fe90ed(WebView p0, String p1) {
            if (POBInternalBrowserActivity.this.d != null) {
                POBInternalBrowserActivity.this.d.setVisibility(8);
            }
            WebView p2 = POBInternalBrowserActivity.this.c;
            if (p2 != null) {
                if (POBInternalBrowserActivity.this.f7557a != null) {
                    POBInternalBrowserActivity pOBInternalBrowserActivity = POBInternalBrowserActivity.this;
                    pOBInternalBrowserActivity.a(pOBInternalBrowserActivity.f7557a, POBInternalBrowserActivity.this.c.canGoBack());
                }
                if (POBInternalBrowserActivity.this.b != null) {
                    POBInternalBrowserActivity pOBInternalBrowserActivity2 = POBInternalBrowserActivity.this;
                    pOBInternalBrowserActivity2.a(pOBInternalBrowserActivity2.b, POBInternalBrowserActivity.this.c.canGoForward());
                }
            }
        }

        public void safedk_POBInternalBrowserActivity$f_onPageStarted_5072d965cde511e3cee1dbefb5e80af9(WebView p0, String p1, Bitmap p2) {
            if (POBInternalBrowserActivity.this.d != null) {
                POBInternalBrowserActivity.this.d.setVisibility(0);
            }
            super.onPageStarted(p0, p1, p2);
        }

        public void safedk_POBInternalBrowserActivity$f_onReceivedError_ca0af953dcb34007a59b11ae38ba4e7b(WebView p0, int p1, String p2, String p3) {
            ProgressBar unused = POBInternalBrowserActivity.this.d;
            super.onReceivedError(p0, p1, p2, p3);
        }

        public boolean safedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_022da127f4dd21087d587990820ff972(WebView p0, String p1) {
            return false;
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest webResourceRequest) {
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.F, view, webResourceRequest, super.shouldInterceptRequest(view, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Z");
            boolean zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_380c8661952228bbfd9bc6eebdc7382d = safedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_380c8661952228bbfd9bc6eebdc7382d(webView, webResourceRequest);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.F, webView, webResourceRequest, zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_380c8661952228bbfd9bc6eebdc7382d);
            return zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_380c8661952228bbfd9bc6eebdc7382d;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Logger.d("PubMatic|SafeDK: Execution> Lcom/pubmatic/sdk/common/browser/POBInternalBrowserActivity$f;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_022da127f4dd21087d587990820ff972 = safedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_022da127f4dd21087d587990820ff972(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.F, webView, str, zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_022da127f4dd21087d587990820ff972);
            return zSafedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_022da127f4dd21087d587990820ff972;
        }

        /* synthetic */ f(POBInternalBrowserActivity pOBInternalBrowserActivity, a aVar) {
            this();
        }

        public boolean safedk_POBInternalBrowserActivity$f_shouldOverrideUrlLoading_380c8661952228bbfd9bc6eebdc7382d(WebView p0, WebResourceRequest p1) {
            return POBDeepLinkUtil.validateAndRedirect(POBInternalBrowserActivity.this, p1.getUrl().toString());
        }

        public void safedk_POBInternalBrowserActivity$f_onReceivedError_df1baed107be9d337488f8e7935ea0e3(WebView p0, WebResourceRequest p1, WebResourceError p2) {
            if (POBInternalBrowserActivity.this.d != null) {
                POBInternalBrowserActivity.this.d.setVisibility(8);
            }
            super.onReceivedError(p0, p1, p2);
        }
    }

    private void i() {
        List<InternalBrowserListener> list = h;
        if (list != null) {
            for (InternalBrowserListener internalBrowserListener : list) {
                if (this.e == internalBrowserListener.hashCode()) {
                    internalBrowserListener.onBrowserDismiss();
                    a(internalBrowserListener);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        List<InternalBrowserListener> list = h;
        if (list != null) {
            for (InternalBrowserListener internalBrowserListener : list) {
                if (this.c != null && internalBrowserListener.hashCode() == this.e) {
                    String url = this.c.getUrl();
                    if (url != null) {
                        internalBrowserListener.onExternalBrowserClick(url);
                    } else {
                        POBLog.debug("POBInternalBrowserActivity", "Can't open external browser as url is not available.", new Object[0]);
                    }
                }
            }
        }
    }

    private void k() {
        List<InternalBrowserListener> list = h;
        if (list != null) {
            for (InternalBrowserListener internalBrowserListener : list) {
                if (this.e == internalBrowserListener.hashCode()) {
                    internalBrowserListener.onBrowserStart();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        WebView webView = this.c;
        if (webView == null || !webView.canGoBack()) {
            super.onBackPressed();
        } else {
            this.c.goBack();
        }
    }

    public static void safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(Context p0, Intent p1) throws Exception {
        Logger.d("SafeDK-Special|SafeDK: Call> Lcom/pubmatic/sdk/common/utility/POBUtils;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.F);
        POBUtils.startActivity(p0, p1);
    }

    public static void startNewActivity(Context context, String str, InternalBrowserListener internalBrowserListener) {
        if (h == null) {
            h = new ArrayList();
        }
        h.add(internalBrowserListener);
        Intent intent = new Intent(context, (Class<?>) POBInternalBrowserActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("url", str);
        intent.putExtra("listener_hash_code", internalBrowserListener.hashCode());
        try {
            safedk_POBUtils_startActivity_77a045103a3f673fe5e6fdc8c1e6b82c(context, intent);
        } catch (Exception e2) {
            POBLog.error("POBInternalBrowserActivity", "Error starting internal browser activity: %s", e2.getMessage());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.F, me);
        return super.dispatchTouchEvent(me);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        l();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayoutC = c();
        if (Build.VERSION.SDK_INT >= 30) {
            POBUtils.setSystemFitWindowsForEdgeToEdge(relativeLayoutC, getWindow());
        }
        setContentView(relativeLayoutC);
        this.g = (ViewGroup) findViewById(R.id.content);
        this.e = getIntent().getIntExtra("listener_hash_code", 0);
        a(getIntent().getStringExtra("url"));
        k();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        POBLog.debug("POBInternalBrowserActivity", "Activity on destroy called.", new Object[0]);
        h();
        AlertDialog alertDialog = this.f;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f = null;
        }
        super.onDestroy();
        i();
    }

    private ImageView b() {
        ImageView imageViewA = a(com.pubmatic.sdk.common.R.drawable.pob_ic_action_cancel);
        imageViewA.setOnClickListener(new a());
        return imageViewA;
    }

    private RelativeLayout c() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setBackgroundColor(-1);
        a(relativeLayout);
        return relativeLayout;
    }

    private ImageView d() {
        ImageView imageViewA = a(com.pubmatic.sdk.common.R.drawable.pob_ic_action_web_site);
        imageViewA.setOnClickListener(new e());
        return imageViewA;
    }

    private ImageView e() {
        ImageView imageViewA = a(com.pubmatic.sdk.common.R.drawable.pob_ic_action_forward);
        this.b = imageViewA;
        a(imageViewA, false);
        this.b.setOnClickListener(new c());
        return this.b;
    }

    private ImageView f() {
        ImageView imageViewA = a(com.pubmatic.sdk.common.R.drawable.pob_ic_action_refresh);
        imageViewA.setOnClickListener(new d());
        return imageViewA;
    }

    private WebView g() {
        POBWebView pOBWebViewCreateInstance = POBWebView.createInstance(POBUtils.resolveWebViewContext(this));
        if (pOBWebViewCreateInstance != null) {
            WebSettings settings = pOBWebViewCreateInstance.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            pOBWebViewCreateInstance.setWebViewClient(new f(this, null));
        }
        return pOBWebViewCreateInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ViewGroup viewGroup = this.g;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.g = null;
        }
        WebView webView = this.c;
        if (webView != null) {
            webView.setWebViewClient(null);
            this.c.destroy();
            this.c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        if (i == 0) {
            return "Certificate Invalid.";
        }
        if (i == 1) {
            return "Certificate Expired.";
        }
        if (i == 2) {
            return "Domain Name Mismatched.";
        }
        if (i == 3) {
            return "Untrusted Certificate.";
        }
        if (i == 4) {
            return "Invalid Date.";
        }
        if (i != 5) {
            return "SSL Error.";
        }
        return "Certificate Invalid.";
    }

    private void a(InternalBrowserListener internalBrowserListener) {
        List list = h;
        if (list != null) {
            list.remove(internalBrowserListener);
            if (h.isEmpty()) {
                h = null;
            }
        }
    }

    private void a(String str) {
        if (this.c != null && !POBUtils.isNullOrEmpty(str)) {
            POBLog.debug("POBInternalBrowserActivity", "Loading url in internal browser : %s", str);
            PubMaticNetworkBridge.webviewLoadUrl(this.c, str);
        } else {
            POBLog.warn("POBInternalBrowserActivity", "Unable to open internal browser : %s", "Invalid url");
        }
    }

    private void a(RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, POBUtils.convertDpToPixel(40));
        layoutParams.addRule(12);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setId(com.pubmatic.sdk.common.R.id.pob_dialog_id);
        linearLayout.setBackgroundColor(-12303292);
        linearLayout.setOrientation(0);
        linearLayout.setVerticalGravity(16);
        relativeLayout.addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1, 1.0f);
        layoutParams2.setMargins(2, 4, 2, 2);
        linearLayout.addView(b(), layoutParams2);
        linearLayout.addView(a(), layoutParams2);
        linearLayout.addView(e(), layoutParams2);
        linearLayout.addView(f(), layoutParams2);
        linearLayout.addView(d(), layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 0);
        layoutParams3.addRule(10);
        layoutParams3.addRule(2, linearLayout.getId());
        WebView webViewG = g();
        this.c = webViewG;
        if (webViewG != null) {
            relativeLayout.addView(webViewG, layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(13);
            ProgressBar progressBar = new ProgressBar(this, null, R.attr.progressBarStyle);
            this.d = progressBar;
            relativeLayout.addView(progressBar, layoutParams4);
            return;
        }
        finish();
    }

    private ImageView a() {
        ImageView imageViewA = a(com.pubmatic.sdk.common.R.drawable.pob_ic_action_back);
        this.f7557a = imageViewA;
        a(imageViewA, false);
        this.f7557a.setOnClickListener(new b());
        return this.f7557a;
    }

    private ImageView a(int i) {
        ImageView imageView = new ImageView(this);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_CENTER;
        imageView.setImageResource(i);
        imageView.setBackgroundColor(getResources().getColor(R.color.background_dark, getTheme()));
        imageView.setScaleType(scaleType);
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, boolean z) {
        if (z) {
            imageView.setEnabled(true);
            imageView.setImageAlpha(255);
        } else {
            imageView.setEnabled(false);
            imageView.setImageAlpha(160);
        }
    }
}

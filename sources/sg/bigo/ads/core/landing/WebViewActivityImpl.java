package sg.bigo.ads.core.landing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.safedk.android.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.R;
import sg.bigo.ads.api.core.BaseAdActivityImpl;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.common.utils.q;
import sg.bigo.ads.common.utils.u;
import sg.bigo.ads.core.h.c;
import sg.bigo.ads.core.h.d;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewActivityImpl extends BaseAdActivityImpl implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13620a;
    private boolean b;
    private AtomicBoolean c;
    private FileChooser d;
    private sg.bigo.ads.common.e.a.AbstractC0861a e;
    private final b f;
    protected TextView r;
    protected ProgressBar s;
    public ImageView t;
    protected ImageView u;
    protected WebView v;
    protected String w;
    protected long x;

    class CustomWebChromeClient extends c {
        private CustomWebChromeClient() {
        }

        /* synthetic */ CustomWebChromeClient(WebViewActivityImpl webViewActivityImpl, byte b) {
            this();
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            if (WebViewActivityImpl.this.s != null) {
                WebViewActivityImpl.this.s.setProgress(i);
            }
            WebViewActivityImpl.this.f(i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            WebViewActivityImpl.this.a(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (WebViewActivityImpl.this.d == null) {
                WebViewActivityImpl.this.d = new FileChooser(WebViewActivityImpl.this.I);
            }
            FileChooser fileChooser = WebViewActivityImpl.this.d;
            sg.bigo.ads.common.t.a.a(0, 3, "FileChooser", "onShowFileChooser");
            if (fileChooser.c != null) {
                fileChooser.c.onReceiveValue(null);
            }
            fileChooser.c = valueCallback;
            fileChooser.a(fileChooserParams.getAcceptTypes());
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (WebViewActivityImpl.this.d == null) {
                WebViewActivityImpl.this.d = new FileChooser(WebViewActivityImpl.this.I);
            }
            WebViewActivityImpl.this.d.openFileChooser(valueCallback, str, str2);
        }
    }

    class a extends d {
        private int b;

        private a() {
        }

        /* synthetic */ a(WebViewActivityImpl webViewActivityImpl, byte b) {
            this();
        }

        private void a(WebView webView, String str) {
            onPageFinished(webView, str);
            WebViewActivityImpl.this.a(0);
        }

        private boolean a(WebView webView, String str, boolean z) {
            boolean zA;
            if (WebViewActivityImpl.this.f13620a) {
                return true;
            }
            sg.bigo.ads.common.t.a.a(0, 3, "WebView", "shouldOverrideUrlLoading url= " + str + ", isRedirectOnStart=" + z);
            if (z && this.b > 1) {
                WebViewActivityImpl.this.c(str);
            }
            if (sg.bigo.ads.core.landing.a.a(str)) {
                boolean zA2 = a(str);
                if (zA2 && z) {
                    a(webView, str);
                }
                return zA2;
            }
            if (str.startsWith("intent://")) {
                try {
                    Intent uri = Intent.parseUri(str, 1);
                    Uri data = uri.getData();
                    if (data != null && WebViewActivityImpl.this.a(data)) {
                        if (z) {
                            a(webView, str);
                        }
                        return true;
                    }
                    uri.addCategory("android.intent.category.BROWSABLE");
                    uri.setComponent(null);
                    uri.setSelector(null);
                    if (safedk_Activity_startActivityIfNeeded_1fa5b5a8a78954a2b40c04a0ca5c037b(WebViewActivityImpl.this.I, uri, -1)) {
                        if (z) {
                            a(webView, str);
                        }
                        return true;
                    }
                    sg.bigo.ads.common.t.a.b("WebView", "queryIntentActivities: null");
                    String stringExtra = uri.getStringExtra("browser_fallback_url");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        if (sg.bigo.ads.core.landing.a.a(stringExtra)) {
                            zA = a(stringExtra);
                            if (zA && z) {
                                a(webView, stringExtra);
                            }
                        } else {
                            zA = false;
                        }
                        if (!zA) {
                            webView.loadUrl(stringExtra);
                        }
                        return true;
                    }
                } catch (Exception e) {
                    sg.bigo.ads.common.t.a.a(0, "WebView", "shouldOverrideUrlLoading: " + e.getMessage());
                }
            } else if (!URLUtil.isValidUrl(str)) {
                if (WebViewActivityImpl.this.e(str) && z) {
                    a(webView, str);
                }
                return true;
            }
            String strD = WebViewActivityImpl.this.d(str);
            if (str.equals(strD)) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
            webView.loadUrl(strD);
            return true;
        }

        private boolean a(String str) {
            e eVar = new e();
            boolean zA = sg.bigo.ads.core.landing.a.a(Uri.parse(str), WebViewActivityImpl.this.I, eVar);
            WebViewActivityImpl.this.a(eVar);
            return zA;
        }

        public static boolean safedk_Activity_startActivityIfNeeded_1fa5b5a8a78954a2b40c04a0ca5c037b(Activity p0, Intent p1, int p2) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivityIfNeeded(Landroid/content/Intent;I)Z");
            if (p1 == null) {
                return false;
            }
            return p0.startActivityIfNeeded(p1, p2);
        }

        @Override // sg.bigo.ads.core.h.d
        public final void a(RenderProcessGoneDetail renderProcessGoneDetail) {
            sg.bigo.ads.core.d.b.a(3002, 10105, "The render process was gone.");
            WebViewActivityImpl.this.a(0);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (WebViewActivityImpl.this.s != null) {
                WebViewActivityImpl.this.s.setAlpha(0.0f);
            }
            sg.bigo.ads.common.t.a.a(0, 3, "WebView", "onPageFinished  ".concat(String.valueOf(str)));
            WebViewActivityImpl.this.b(str);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            boolean z = false;
            sg.bigo.ads.common.t.a.a(0, 3, "WebView", "onPageStarted ".concat(String.valueOf(str)));
            if (WebViewActivityImpl.this.s != null) {
                WebViewActivityImpl.this.s.animate().alpha(1.0f).setDuration(100L).setListener(null);
                WebViewActivityImpl.this.s.setProgress(0);
            }
            if (WebViewActivityImpl.this.x < 0) {
                WebViewActivityImpl.this.x = SystemClock.elapsedRealtime();
                z = true;
            }
            WebViewActivityImpl.this.a(str, z);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            sg.bigo.ads.common.t.a.b("WebView", "onReceivedError: " + i + " " + str);
            WebViewActivityImpl.this.a(i, str, str2);
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }
        }

        @Override // sg.bigo.ads.core.h.d, android.webkit.WebViewClient
        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                onReceivedError(webView, webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceRequest.getUrl().toString());
            }
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.b++;
            return a(webView, str, !(WebViewActivityImpl.this.x >= 0 && WebViewActivityImpl.this.b));
        }
    }

    class b implements View.OnTouchListener, sg.bigo.ads.core.h.e.a {
        private b() {
        }

        /* synthetic */ b(WebViewActivityImpl webViewActivityImpl, byte b) {
            this();
        }

        @Override // sg.bigo.ads.core.h.e.a
        public final void a(MotionEvent motionEvent) {
            onTouch(WebViewActivityImpl.this.v, motionEvent);
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                WebViewActivityImpl.a(WebViewActivityImpl.this);
            }
            return WebViewActivityImpl.this.a(motionEvent);
        }
    }

    protected WebViewActivityImpl(Activity activity) {
        super(activity);
        this.x = -1L;
        this.f13620a = false;
        this.b = false;
        this.c = new AtomicBoolean(true);
        this.e = new sg.bigo.ads.common.e.a.AbstractC0861a() { // from class: sg.bigo.ads.core.landing.WebViewActivityImpl.1
            @Override // sg.bigo.ads.common.e.a.AbstractC0861a
            public final void a(boolean z) {
                if (z) {
                    WebViewActivityImpl.this.U();
                } else {
                    WebViewActivityImpl.this.V();
                }
            }
        };
        this.f = new b(this, (byte) 0);
        Intent intent = this.I.getIntent();
        this.w = intent != null ? intent.getStringExtra("url") : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Uri uri) {
        e eVar = new e();
        boolean zA = sg.bigo.ads.core.landing.a.a(uri, this.I, eVar, "");
        if (eVar.b != 0 || eVar.c != 0) {
            a(eVar);
        }
        return zA;
    }

    static /* synthetic */ boolean a(WebViewActivityImpl webViewActivityImpl) {
        webViewActivityImpl.b = true;
        return true;
    }

    private void c(int i) {
        if (this.v == null || !s()) {
            d(i);
        } else {
            this.v.goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return a(Uri.parse(str));
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void D() {
        WebView webView = this.v;
        if (webView != null) {
            sg.bigo.ads.common.e.a.b(webView, this.e);
            WebView webView2 = this.v;
            if (webView2 instanceof sg.bigo.ads.core.h.e) {
                ((sg.bigo.ads.core.h.e) webView2).setOnWebViewTouchListener(null);
            } else {
                webView2.setOnTouchListener(null);
            }
            this.v.destroy();
            this.v = null;
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void N() {
        if (TextUtils.isEmpty(this.w)) {
            sg.bigo.ads.common.t.a.a(0, "WebView", "url is null.");
            a(0);
            return;
        }
        a_(R.layout.bigo_ad_activity_webview);
        try {
            d();
        } catch (RuntimeException unused) {
        }
        p();
        if (q.a((CharSequence) this.w) || e(this.w)) {
            a(0);
        } else {
            q();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void U() {
        if (this.c.compareAndSet(true, false)) {
            a();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void V() {
        if (this.c.compareAndSet(false, true)) {
            b();
        }
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void W() {
        c(1);
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void X() {
    }

    protected void a() {
        WebView webView = this.v;
        if (webView != null) {
            webView.onResume();
        }
    }

    public void a(int i) {
        this.f13620a = true;
        e(i);
        WebView webView = this.v;
        if (webView != null) {
            webView.stopLoading();
        }
        super.ap();
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public final void a(int i, int i2, Intent intent) {
        String dataString;
        FileChooser fileChooser = this.d;
        if (fileChooser != null) {
            Uri[] uriArr = (i2 != -1 || i != 101 || intent == null || intent.getData() == null || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)};
            if (fileChooser.c != null) {
                fileChooser.c.onReceiveValue(uriArr);
                fileChooser.c = null;
            }
        }
    }

    protected void a(int i, String str, String str2) {
    }

    protected void a(String str) {
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(str);
        }
    }

    protected void a(String str, boolean z) {
    }

    protected void a(e eVar) {
    }

    protected boolean a(MotionEvent motionEvent) {
        return false;
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    @Deprecated
    public final void ap() {
        d(0);
    }

    protected void b() {
        WebView webView = this.v;
        if (webView != null) {
            webView.onPause();
        }
    }

    protected void b(String str) {
    }

    protected void c(String str) {
        sg.bigo.ads.common.t.a.a(0, 3, "WebView", "onAutoRedirectStart url= ".concat(String.valueOf(str)));
    }

    protected String d(String str) {
        return str;
    }

    protected void d() {
        this.s = (ProgressBar) l(R.id.inter_webview_progress_bar);
        this.r = (TextView) l(R.id.inter_webview_title);
        this.u = (ImageView) l(R.id.inter_webview_back);
        this.t = (ImageView) l(R.id.inter_webview_close);
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.t;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        WebView webViewO = o();
        this.v = webViewO;
        if (webViewO != null) {
            byte b2 = 0;
            webViewO.setWebViewClient(new a(this, b2));
            this.v.setWebChromeClient(new CustomWebChromeClient(this, b2));
            u.a(this.v, (ViewGroup) l(R.id.inter_webview_container), new ViewGroup.LayoutParams(-1, -1), -1);
            WebView webView = this.v;
            if (webView instanceof sg.bigo.ads.core.h.e) {
                ((sg.bigo.ads.core.h.e) webView).setOnWebViewTouchListener(this.f);
            } else {
                webView.setOnTouchListener(this.f);
            }
            sg.bigo.ads.common.e.a.a(this.v, this.e);
        }
    }

    protected void d(int i) {
        a(i);
    }

    protected void e(int i) {
    }

    protected void f(int i) {
    }

    @Override // sg.bigo.ads.api.core.BaseAdActivityImpl
    public void g(boolean z) {
    }

    protected WebView o() {
        return sg.bigo.ads.core.h.e.a(this.I);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof String) {
            if (tag.equals(sg.bigo.ads.common.utils.a.a(this.I, R.string.bigo_ad_tag_close, new Object[0]))) {
                d(3);
            } else if (tag.equals(sg.bigo.ads.common.utils.a.a(this.I, R.string.bigo_ad_tag_back, new Object[0]))) {
                c(2);
            }
        }
    }

    protected void p() {
    }

    protected void q() {
        WebView webView = this.v;
        if (webView != null) {
            webView.loadUrl(this.w);
        }
    }

    protected boolean s() {
        WebView webView = this.v;
        return webView != null && webView.canGoBack();
    }
}

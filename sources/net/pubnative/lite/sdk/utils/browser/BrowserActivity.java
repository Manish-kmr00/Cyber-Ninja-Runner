package net.pubnative.lite.sdk.utils.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import net.pubnative.lite.sdk.core.R;

/* JADX INFO: loaded from: classes2.dex */
public class BrowserActivity extends Activity implements BrowserView {
    private static final String KEY_CTA_URL = "KEY_CTA_URL";
    private static final String TAG = "net.pubnative.lite.sdk.utils.browser.BrowserActivity";
    private BrowserPresenter browserPresenter;
    private View btnNavigationBackward;
    private View btnNavigationForward;
    private ProgressBar progressBar;
    private TextView tvHostname;
    private WebView webView;

    public interface WebViewCloseListener {
        void onWebViewCloseRequested();
    }

    public static void safedk_BrowserActivity_startActivity_7ba1ed50c78d7bda977b7095063824e6(BrowserActivity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Lnet/pubnative/lite/sdk/utils/browser/BrowserActivity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.C);
        p0.startActivity(p1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.C, me);
        return super.dispatchTouchEvent(me);
    }

    public static Intent createIntent(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BrowserActivity.class);
        intent.addFlags(536870912);
        intent.putExtra(KEY_CTA_URL, str);
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.browserPresenter = new BrowserPresenter(new BrowserModel(new BaseWebViewClient(new WebViewCloseListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity$$ExternalSyntheticLambda0
            @Override // net.pubnative.lite.sdk.utils.browser.BrowserActivity.WebViewCloseListener
            public final void onWebViewCloseRequested() {
                this.f$0.onWebViewCloseRequested();
            }
        }), new BaseWebChromeClient(), new BrowserCookieManager(CookieManager.getInstance())), new UrlCreator(), (ClipboardManager) getApplication().getSystemService("clipboard"));
        setContentView(R.layout.activity_internal_browser);
        initViews();
        initWebView();
        initLogic();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        BrowserPresenter browserPresenter = this.browserPresenter;
        if (browserPresenter != null) {
            browserPresenter.onResume();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        BrowserPresenter browserPresenter = this.browserPresenter;
        if (browserPresenter != null) {
            browserPresenter.onPause();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.webView;
        if (webView != null) {
            webView.destroy();
        }
        BrowserPresenter browserPresenter = this.browserPresenter;
        if (browserPresenter != null) {
            browserPresenter.dropView();
        }
    }

    private void initViews() {
        this.webView = (WebView) findViewById(R.id.webView);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        findViewById(R.id.btnClose).setOnClickListener(new DoubleClickPreventionListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity.1
            @Override // net.pubnative.lite.sdk.utils.browser.DoubleClickPreventionListener
            protected void processClick() {
                BrowserActivity.this.finish();
            }
        });
        findViewById(R.id.btnRefresh).setOnClickListener(new DoubleClickPreventionListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity.2
            @Override // net.pubnative.lite.sdk.utils.browser.DoubleClickPreventionListener
            protected void processClick() {
                if (BrowserActivity.this.browserPresenter != null) {
                    BrowserActivity.this.browserPresenter.onReloadClicked();
                }
            }
        });
        View viewFindViewById = findViewById(R.id.btnBackward);
        this.btnNavigationBackward = viewFindViewById;
        viewFindViewById.setOnClickListener(new DoubleClickPreventionListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity.3
            @Override // net.pubnative.lite.sdk.utils.browser.DoubleClickPreventionListener
            protected void processClick() {
                if (BrowserActivity.this.browserPresenter != null) {
                    BrowserActivity.this.browserPresenter.onPageNavigationBackClicked();
                }
            }
        });
        View viewFindViewById2 = findViewById(R.id.btnForward);
        this.btnNavigationForward = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new DoubleClickPreventionListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity.4
            @Override // net.pubnative.lite.sdk.utils.browser.DoubleClickPreventionListener
            protected void processClick() {
                if (BrowserActivity.this.browserPresenter != null) {
                    BrowserActivity.this.browserPresenter.onPageNavigationForwardClicked();
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.tvHostname);
        this.tvHostname = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: net.pubnative.lite.sdk.utils.browser.BrowserActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.m9759xa26a86e4(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initViews$0$net-pubnative-lite-sdk-utils-browser-BrowserActivity, reason: not valid java name */
    /* synthetic */ boolean m9759xa26a86e4(View view) {
        BrowserPresenter browserPresenter = this.browserPresenter;
        if (browserPresenter == null) {
            return false;
        }
        browserPresenter.onCopyHostnameClicked();
        return true;
    }

    private void initWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setDomStorageEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
        }
    }

    private void initLogic() {
        BrowserPresenter browserPresenter;
        WebView webView = this.webView;
        if (webView != null && (browserPresenter = this.browserPresenter) != null) {
            browserPresenter.initWithView(this, webView);
        }
        String stringExtra = getIntent().getStringExtra(KEY_CTA_URL);
        BrowserPresenter browserPresenter2 = this.browserPresenter;
        if (browserPresenter2 != null) {
            browserPresenter2.loadUrl(stringExtra);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void showHostname(String str) {
        TextView textView = this.tvHostname;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void showConnectionSecure(boolean z) {
        int i = z ? R.drawable.browser_secure_connection : 0;
        TextView textView = this.tvHostname;
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void setPageNavigationBackEnabled(boolean z) {
        View view = this.btnNavigationBackward;
        if (view != null) {
            view.setEnabled(z);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void setPageNavigationForwardEnabled(boolean z) {
        View view = this.btnNavigationForward;
        if (view != null) {
            view.setEnabled(z);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void launchExternalBrowser(Intent intent) {
        try {
            safedk_BrowserActivity_startActivity_7ba1ed50c78d7bda977b7095063824e6(this, intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            net.pubnative.lite.sdk.utils.Logger.e(TAG, "The url seems to be invalid while launching external browser");
        }
        finish();
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void redirectToExternalApp(Intent intent) {
        try {
            safedk_BrowserActivity_startActivity_7ba1ed50c78d7bda977b7095063824e6(this, intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            net.pubnative.lite.sdk.utils.Logger.e(TAG, "The url seems to be invalid while redirecting to external app");
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void showProgressIndicator() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void hideProgressIndicator() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void updateProgressIndicator(int i) {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
    }

    @Override // net.pubnative.lite.sdk.utils.browser.BrowserView
    public void closeBrowser() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onWebViewCloseRequested() {
        finish();
    }
}

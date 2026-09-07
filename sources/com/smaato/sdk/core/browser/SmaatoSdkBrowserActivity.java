package com.smaato.sdk.core.browser;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.utils.h;
import com.smaato.sdk.core.AndroidsInjector;
import com.smaato.sdk.core.R;
import com.smaato.sdk.core.log.LogDomain;
import com.smaato.sdk.core.log.Logger;
import com.smaato.sdk.core.util.Objects;
import com.smaato.sdk.core.util.diinjection.Inject;
import com.smaato.sdk.core.util.fi.Consumer;
import com.smaato.sdk.core.webview.WebViewHelperUtil;

/* JADX INFO: loaded from: classes4.dex */
public class SmaatoSdkBrowserActivity extends Activity implements BrowserView {
    private static final String LOG_TAG = "com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity";

    @Inject
    private BrowserPresenter browserPresenter;
    private View btnNavigationBackward;
    private View btnNavigationForward;

    @Inject
    private Logger logger;
    private ProgressBar progressBar;
    private TextView tvHostname;
    private WebView webView;

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        com.safedk.android.utils.Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.v);
        p0.startActivity(p1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.activityOnTouch(h.v, me);
        return super.dispatchTouchEvent(me);
    }

    public static Intent createIntent(Context context, String str) {
        Objects.requireNonNull(context, "Parameter context cannot be null for SmaatoSdkBrowserActivity::createIntent");
        Objects.requireNonNull(str, "Parameter url cannot be null for SmaatoSdkBrowserActivity::createIntent");
        Intent intent = new Intent(context, (Class<?>) SmaatoSdkBrowserActivity.class);
        intent.addFlags(536870912);
        intent.putExtra("KEY_CTA_URL", str);
        return intent;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AndroidsInjector.inject(this);
        if (this.browserPresenter == null) {
            Log.e(LOG_TAG, "SmaatoSdk is not initialized.");
            finish();
        } else {
            setContentView(R.layout.smaato_sdk_core_activity_internal_browser);
            initViews();
            initWebView();
            initLogic();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda9
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).onStart();
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda8
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).onResume();
            }
        });
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda14
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).onPause();
            }
        });
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda12
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).onStop();
            }
        });
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Objects.onNotNull(this.webView, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                WebViewHelperUtil.resetAndDestroyWebViewSafely((WebView) obj);
            }
        });
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).dropView();
            }
        });
    }

    private void initViews() {
        this.webView = (WebView) findViewById(R.id.webView);
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        findViewById(R.id.btnClose).setOnClickListener(new DoubleClickPreventionListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity.1
            @Override // com.smaato.sdk.core.browser.DoubleClickPreventionListener
            protected void processClick() {
                SmaatoSdkBrowserActivity.this.finish();
            }
        });
        findViewById(R.id.btnRefresh).setOnClickListener(new DoubleClickPreventionListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity.2
            @Override // com.smaato.sdk.core.browser.DoubleClickPreventionListener
            protected void processClick() {
                Objects.onNotNull(SmaatoSdkBrowserActivity.this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$2$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((BrowserPresenter) obj).onReloadClicked();
                    }
                });
            }
        });
        View viewFindViewById = findViewById(R.id.btnBackward);
        this.btnNavigationBackward = viewFindViewById;
        viewFindViewById.setOnClickListener(new DoubleClickPreventionListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity.3
            @Override // com.smaato.sdk.core.browser.DoubleClickPreventionListener
            protected void processClick() {
                Objects.onNotNull(SmaatoSdkBrowserActivity.this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$3$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((BrowserPresenter) obj).onPageNavigationBackClicked();
                    }
                });
            }
        });
        View viewFindViewById2 = findViewById(R.id.btnForward);
        this.btnNavigationForward = viewFindViewById2;
        viewFindViewById2.setOnClickListener(new DoubleClickPreventionListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity.4
            @Override // com.smaato.sdk.core.browser.DoubleClickPreventionListener
            protected void processClick() {
                Objects.onNotNull(SmaatoSdkBrowserActivity.this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$4$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((BrowserPresenter) obj).onPageNavigationForwardClicked();
                    }
                });
            }
        });
        findViewById(R.id.btnOpenExternal).setOnClickListener(new DoubleClickPreventionListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity.5
            @Override // com.smaato.sdk.core.browser.DoubleClickPreventionListener
            protected void processClick() {
                Objects.onNotNull(SmaatoSdkBrowserActivity.this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$5$$ExternalSyntheticLambda0
                    @Override // com.smaato.sdk.core.util.fi.Consumer
                    public final void accept(Object obj) {
                        ((BrowserPresenter) obj).onOpenExternalBrowserClicked();
                    }
                });
            }
        });
        TextView textView = (TextView) findViewById(R.id.tvHostname);
        this.tvHostname = textView;
        textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f$0.m5521x155b4c1d(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initViews$0$com-smaato-sdk-core-browser-SmaatoSdkBrowserActivity, reason: not valid java name */
    /* synthetic */ boolean m5521x155b4c1d(View view) {
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda16
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).onCopyHostnameClicked();
            }
        });
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
        if (this.webView != null) {
            Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda4
                @Override // com.smaato.sdk.core.util.fi.Consumer
                public final void accept(Object obj) {
                    this.f$0.m5520x4ff027cc((BrowserPresenter) obj);
                }
            });
        }
        final String stringExtra = getIntent().getStringExtra("KEY_CTA_URL");
        Objects.onNotNull(this.browserPresenter, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda5
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((BrowserPresenter) obj).loadUrl(stringExtra);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initLogic$1$com-smaato-sdk-core-browser-SmaatoSdkBrowserActivity, reason: not valid java name */
    /* synthetic */ void m5520x4ff027cc(BrowserPresenter browserPresenter) {
        browserPresenter.initWithView(this, this.webView);
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void showHostname(final String str) {
        Objects.onNotNull(this.tvHostname, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda13
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((TextView) obj).setText(str);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void showConnectionSecure(boolean z) {
        final int i = z ? R.drawable.smaato_sdk_core_ic_browser_secure_connection : 0;
        Objects.onNotNull(this.tvHostname, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda3
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((TextView) obj).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void setPageNavigationBackEnabled(final boolean z) {
        Objects.onNotNull(this.btnNavigationBackward, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda15
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((View) obj).setEnabled(z);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void setPageNavigationForwardEnabled(final boolean z) {
        Objects.onNotNull(this.btnNavigationForward, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda6
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((View) obj).setEnabled(z);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void launchExternalBrowser(Intent intent) {
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this, intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            if (this.logger != null) {
                this.logger.error(LogDomain.AD, "The url seems to be invalid", new Object[0]);
            }
        }
        finish();
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void redirectToExternalApp(Intent intent) {
        try {
            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(this, intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            if (this.logger != null) {
                this.logger.error(LogDomain.AD, "The url seems to be invalid", new Object[0]);
            }
        }
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void showProgressIndicator() {
        Objects.onNotNull(this.progressBar, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda7
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ProgressBar) obj).setVisibility(0);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void hideProgressIndicator() {
        Objects.onNotNull(this.progressBar, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda11
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ProgressBar) obj).setVisibility(4);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void updateProgressIndicator(final int i) {
        Objects.onNotNull(this.progressBar, new Consumer() { // from class: com.smaato.sdk.core.browser.SmaatoSdkBrowserActivity$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Consumer
            public final void accept(Object obj) {
                ((ProgressBar) obj).setProgress(i);
            }
        });
    }

    @Override // com.smaato.sdk.core.browser.BrowserView
    public void closeBrowser() {
        finish();
    }
}

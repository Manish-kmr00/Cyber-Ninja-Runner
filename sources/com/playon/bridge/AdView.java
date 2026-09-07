package com.playon.bridge;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.facebook.internal.AnalyticsEvents;
import com.json.cc;
import com.playon.bridge.common.Log;
import com.playon.bridge.common.util.Assert;
import com.playon.bridge.common.util.PluginUtils;
import com.playon.bridge.common.util.Preconditions;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.utils.Logger;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;

/* JADX INFO: loaded from: classes11.dex */
public class AdView extends FrameLayout {
    private static final String ABOUT_BLANK = "about:blank";
    public static final int ERROR_ADVIEW_SIZE_NOT_SET = 8012;
    public static final int ERROR_LOAD_AFTER_RELEASE = 8006;
    public static final int ERROR_NETWORK_NOT_AVAILABLE = 8054;
    public static final int ERROR_NO_ADS = 8010;
    public static final int ERROR_NO_AD_RIGHT_SIZE = 8011;
    public static final int ERROR_NO_INVENTORY = 8004;
    public static final int ERROR_TIMEOUT = 8013;
    public static final int ERROR_UNKNOWN = 8003;
    public static final int ERROR_UNKNOWN_HOST = 8001;
    private final float DENSITY_PIXELS_TO_PIXEL_SCALE;
    protected final String TAG;
    private final AdView instance;
    private int mAdHeight;
    private int mAdWidth;
    private Bundle mCompanion;
    private boolean mDestroyed;
    private int mErrorCode;
    private FrameLayout.LayoutParams mLayoutParams;
    private AdViewListener mListener;
    private RoundedWebView mWebView;
    private WebClient mWebViewClient;

    public interface AdViewListener {
        void onAdViewCleared(AdView adView);

        void onAdViewClicked(AdView adView);

        void onAdViewError(AdView adView, int i);

        void onAdViewLoaded(AdView adView);
    }

    public AdView(Context context) {
        this(context, null);
    }

    public AdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.instance = this;
        this.TAG = Log.makeTag("AdView");
        this.mCompanion = new Bundle();
        this.DENSITY_PIXELS_TO_PIXEL_SCALE = PluginUtils.getDeviceDensityPixelScale(context);
    }

    public void onPause() {
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.onPause();
        }
    }

    public void onResume() {
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.onResume();
        }
    }

    public void release() {
        this.mDestroyed = true;
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            removeView(roundedWebView);
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public void setListener(AdViewListener adViewListener) {
        this.mListener = adViewListener;
    }

    public AdViewListener getListener() {
        return this.mListener;
    }

    protected void onError(int i) {
        clearWebView();
        if (this.mErrorCode != 0 || i == 0) {
            return;
        }
        String str = "AdView error: " + debugErrorToStr(i);
        if (i == 8011) {
            str = (str + " (" + this.mAdWidth + 'x' + this.mAdHeight) + ")";
        }
        Log.w(this.TAG, str);
        this.mErrorCode = i;
        AdViewListener adViewListener = this.mListener;
        if (adViewListener != null) {
            adViewListener.onAdViewError(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoaded() {
        AdViewListener adViewListener = this.mListener;
        if (adViewListener == null || this.mErrorCode != 0) {
            return;
        }
        adViewListener.onAdViewLoaded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCleared() {
        AdViewListener adViewListener = this.mListener;
        if (adViewListener == null || this.mErrorCode != 0) {
            return;
        }
        adViewListener.onAdViewCleared(this);
    }

    public int getAdWidth() {
        return this.mAdWidth;
    }

    public int getAdHeight() {
        return this.mAdHeight;
    }

    public void setAdSize(int i, int i2) {
        Log.d(this.TAG, "AdLayout creating with width " + i + " and height " + i2);
        if (this.mAdWidth == i && this.mAdHeight == i2) {
            return;
        }
        this.mAdWidth = i;
        this.mAdHeight = i2;
        this.mLayoutParams = createLayoutParams(i, i2);
    }

    private FrameLayout.LayoutParams createLayoutParams(int i, int i2) {
        return new FrameLayout.LayoutParams(PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i), PluginUtils.densityPixelsToPixels(this.DENSITY_PIXELS_TO_PIXEL_SCALE, i2), 17);
    }

    public Bundle getCompanion() {
        return this.mCompanion;
    }

    public void showAd(Bundle bundle, int i, int i2) {
        String string;
        Preconditions.checkNotNull(bundle);
        this.mCompanion = bundle;
        setAdSize(i, i2);
        String string2 = this.mCompanion.getString("url");
        if (string2 != null) {
            loadUrl(string2);
        } else {
            String string3 = this.mCompanion.getString("html");
            if (string3 != null) {
                loadHTML(string3);
            }
        }
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.setLayoutParams(this.mLayoutParams);
            if (string2 == null || (string = this.mCompanion.getString(Ad.COMPANION_CLICK_THROUGH_EVENT)) == null || string.isEmpty()) {
                return;
            }
            this.mWebViewClient.SetClickURL(string);
        }
    }

    public void clearAd() {
        if (this.mDestroyed) {
            return;
        }
        hideWebView();
        this.mErrorCode = 0;
        clearWebView();
    }

    public boolean isAdLoaded() {
        RoundedWebView roundedWebView = this.mWebView;
        return roundedWebView != null && roundedWebView.getVisibility() == 0;
    }

    public void clearWithColor(int i, int i2) {
        clearWebView();
        this.mWebView.loadData("<HTML><BODY></BODY></HTML>", POBCommonConstants.CONTENT_TYPE_HTML, cc.N);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i2});
        this.mWebView.setBackgroundColor(0);
        this.mWebView.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebView() {
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideWebView() {
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.setVisibility(8);
        }
    }

    private void clearWebView() {
        WebClient webClient = this.mWebViewClient;
        if (webClient == null) {
            onCleared();
        } else {
            webClient.clearAd();
        }
    }

    private void loadUrl(String str) {
        createWebViewIfNeeded(str);
        WebClient webClient = this.mWebViewClient;
        if (webClient != null) {
            webClient.loadAd(str);
        }
    }

    public void setWebViewCornerRadius(int i) {
        RoundedWebView roundedWebView = this.mWebView;
        if (roundedWebView != null) {
            roundedWebView.setRadius(i);
        }
    }

    private void loadHTML(String str) {
        createWebViewIfNeeded("http");
        if (this.mWebViewClient != null) {
            if (str.toLowerCase().indexOf("<html>") == -1) {
                str = "<html><meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"><head><style type=\"text/css\">\nhtml, body {\nwidth: 100%;\nheight: 100%;\nmargin: 0px;\npadding: 0px;\n}\n</style></head><body>" + str + "</body><html>";
            }
            this.mWebViewClient.loadHTML(str);
        }
    }

    private void createWebViewIfNeeded(String str) {
        if (this.mWebView == null && str != null && str.startsWith("http")) {
            RoundedWebView roundedWebView = new RoundedWebView(getContext());
            this.mWebView = roundedWebView;
            roundedWebView.setFocusable(false);
            this.mWebView.setHorizontalScrollBarEnabled(false);
            this.mWebView.setOverScrollMode(2);
            this.mWebView.setScrollBarStyle(33554432);
            this.mWebView.setVerticalScrollBarEnabled(false);
            this.mWebView.setVisibility(8);
            this.mWebView.getSettings().setUseWideViewPort(true);
            this.mWebView.getSettings().setLoadWithOverviewMode(true);
            WebClientV11 webClientV11 = new WebClientV11();
            this.mWebViewClient = webClientV11;
            this.mWebView.setWebViewClient(webClientV11);
            WebSettings settings = this.mWebView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
            addView(this.mWebView, this.mLayoutParams);
        }
    }

    public static String debugErrorToStr(int i) {
        if (i == 0) {
            return "No error";
        }
        if (i == 8001) {
            return "Unknown host";
        }
        if (i == 8006) {
            return "Load called after released";
        }
        if (i == 8054) {
            return "Network not available";
        }
        if (i == 8003) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        if (i == 8004) {
            return "No ad inventory";
        }
        switch (i) {
            case 8010:
                return "No ads";
            case 8011:
                return "No ad with right size";
            case 8012:
                return "Ad size not set";
            case ERROR_TIMEOUT /* 8013 */:
                return AndroidInitializeBoldSDK.MSG_TIMEOUT;
            default:
                Assert.failUnhandledValue(Log.makeTag("AdView"), i, "debugErrorToStr");
                return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
    }

    private class WebClient extends WebViewClient implements View.OnTouchListener {
        protected String clickURL;
        protected boolean mWebViewClicked;

        public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
            Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
            if (p1 == null) {
                return;
            }
            p0.startActivity(p1);
        }

        private int webViewToAdError(int i) {
            if (i != -8) {
                return i != -2 ? -1 : 8001;
            }
            return -8;
        }

        WebClient() {
            if (AdView.this.mWebView != null) {
                AdView.this.mWebView.setOnTouchListener(this);
            }
        }

        void clearAd() {
            loadAd("about:blank");
        }

        void loadAd(String str) {
            if (AdView.this.mWebView == null) {
                AdView.this.onError(8006);
                return;
            }
            if (!"about:blank".equals(str) && !"about:blank".equals(AdView.this.mWebView.getUrl())) {
                Log.d(AdView.this.TAG, "Loading Ad: " + str);
            }
            this.mWebViewClicked = false;
            AdView.this.mWebView.loadData("<html><head><meta name='viewport' content='width=" + PluginUtils.densityPixelsToPixels(AdView.this.DENSITY_PIXELS_TO_PIXEL_SCALE, AdView.this.mAdWidth) + ", height=" + PluginUtils.densityPixelsToPixels(AdView.this.DENSITY_PIXELS_TO_PIXEL_SCALE, AdView.this.mAdHeight) + "'/></head><body style=\"margin: 0px;\"><img id=\"resizeImage\" src=\"" + str + "\" height=100% width=100% border=0px alt=\"\" align=\"center\" /></body></html>", "text/html; charset=UTF-8", null);
        }

        void SetClickURL(String str) {
            this.clickURL = str;
        }

        void loadHTML(String str) {
            if (AdView.this.mWebView == null) {
                AdView.this.onError(8006);
                return;
            }
            Log.d(AdView.this.TAG, "Loading ad html ");
            this.mWebViewClicked = false;
            AdView.this.mWebView.loadData(str, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8");
        }

        @Override // android.view.View.OnTouchListener
        public synchronized boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                return action != 1;
            }
            Log.d(AdView.this.TAG, "Ad Clicked:" + this.clickURL);
            this.mWebViewClicked = true;
            String str = this.clickURL;
            if (str != null) {
                onAdClicked(str);
            }
            return false;
        }

        @Override // android.webkit.WebViewClient
        public synchronized boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() != 23) {
                return true;
            }
            this.mWebViewClicked = true;
            return false;
        }

        @Override // android.webkit.WebViewClient
        public synchronized boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!this.mWebViewClicked) {
                return false;
            }
            onAdClicked(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public synchronized void onReceivedError(WebView webView, int i, String str, String str2) {
            Log.w(AdView.this.TAG, "Ad error: " + str2 + " Description:" + str);
            AdView.this.hideWebView();
            AdView.this.onError(webViewToAdError(i));
            clearAd();
        }

        @Override // android.webkit.WebViewClient
        public synchronized void onPageFinished(WebView webView, String str) {
            if (str == null) {
                AdView.this.hideWebView();
                AdView.this.onCleared();
            } else if (str.equals("about:blank")) {
                AdView.this.hideWebView();
                AdView.this.onCleared();
            } else {
                AdView.this.showWebView();
                AdView.this.onLoaded();
            }
            throw th;
        }

        protected synchronized void onAdClicked(String str) {
            this.mWebViewClicked = false;
            if (AdView.this.mListener != null) {
                AdView.this.mListener.onAdViewClicked(AdView.this.instance);
            }
            launchBrowser(str);
        }

        private void launchBrowser(String str) {
            if (str == null || str.isEmpty()) {
                return;
            }
            Log.d(AdView.this.TAG, "Launching external ad: " + str);
            try {
                if (!str.startsWith("https://") && !str.startsWith(d.v)) {
                    str = d.v + str;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(32768);
                safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(AdView.this.getContext(), intent);
            } catch (ActivityNotFoundException e) {
                Log.w(AdView.this.TAG, "ClickThroughURL Issue: " + e.getMessage());
            }
        }
    }

    private class WebClientV11 extends WebClient {
        WebClientV11() {
            super();
        }

        @Override // android.webkit.WebViewClient
        public synchronized WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (this.mWebViewClicked) {
                onAdClicked(str);
            }
            return null;
        }
    }

    public class RoundedWebView extends WebView {
        private Context context;
        private int height;
        private int radius;
        private int width;

        public RoundedWebView(Context context) {
            super(context);
            initialize(context);
        }

        public RoundedWebView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            initialize(context);
        }

        public RoundedWebView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            initialize(context);
        }

        private void initialize(Context context) {
            this.context = context;
            this.radius = 0;
        }

        public void setRadius(int i) {
            this.radius = PluginUtils.densityPixelsToPixels(AdView.this.DENSITY_PIXELS_TO_PIXEL_SCALE, i);
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            this.width = i;
            this.height = i2;
        }

        @Override // android.webkit.WebView, android.view.View
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Path path = new Path();
            path.setFillType(Path.FillType.INVERSE_WINDING);
            RectF rectF = new RectF(0.0f, getScrollY(), this.width, getScrollY() + this.height);
            int i = this.radius;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
            canvas.drawPath(path, createPorterDuffClearPaint());
        }

        private Paint createPorterDuffClearPaint() {
            Paint paint = new Paint();
            paint.setColor(0);
            paint.setStyle(Paint.Style.FILL);
            paint.setAntiAlias(true);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            return paint;
        }
    }
}

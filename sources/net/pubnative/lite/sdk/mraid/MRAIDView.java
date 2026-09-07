package net.pubnative.lite.sdk.mraid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.location.Location;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import coil.util.Utils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.iab.omid.library.pubnativenet.adsession.FriendlyObstructionPurpose;
import com.json.b9;
import com.json.sdk.controller.f;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.pubmatic.sdk.openwrap.core.POBConstants;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.DetectTouchUtils;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.discoveries.d;
import com.safedk.android.internal.partials.VerveNetworkBridge;
import com.safedk.android.utils.h;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.pubnative.lite.sdk.CountdownStyle;
import net.pubnative.lite.sdk.DeviceInfo;
import net.pubnative.lite.sdk.HyBid;
import net.pubnative.lite.sdk.core.R;
import net.pubnative.lite.sdk.location.HyBidLocationManager;
import net.pubnative.lite.sdk.mraid.internal.MRAIDHtmlProcessor;
import net.pubnative.lite.sdk.mraid.internal.MRAIDLog;
import net.pubnative.lite.sdk.mraid.internal.MRAIDNativeFeatureManager;
import net.pubnative.lite.sdk.mraid.internal.MRAIDParser;
import net.pubnative.lite.sdk.mraid.properties.MRAIDOrientationProperties;
import net.pubnative.lite.sdk.mraid.properties.MRAIDResizeProperties;
import net.pubnative.lite.sdk.utils.Logger;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityFriendlyObstruction;
import net.pubnative.lite.sdk.viewability.HyBidViewabilityWebAdSession;
import net.pubnative.lite.sdk.views.PNWebView;
import net.pubnative.lite.sdk.vpaid.helpers.BitmapHelper;
import net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer;
import net.pubnative.lite.sdk.vpaid.widget.CountDownView;
import net.pubnative.lite.sdk.vpaid.widget.CountDownViewFactory;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class MRAIDView extends FrameLayout {
    private static final int CLOSE_REGION_SIZE = 50;
    private static final int LANDING_PAGE_CLOSE_DELAY = 30000;
    private static final String MRAID_LOG_TAG = "MRAIDView";
    private static final String MRAID_VERSION = "3.0";
    public static final int STATE_DEFAULT = 1;
    public static final int STATE_EXPANDED = 2;
    public static final int STATE_HIDDEN = 4;
    public static final int STATE_LOADING = 0;
    public static final int STATE_RESIZED = 3;
    private int activityInitialOrientation;
    private final String baseUrl;
    private MRAIDViewCloseLayoutListener closeLayoutListener;
    private ImageButton closeRegion;
    private final ViewGroup contentInfo;
    private boolean contentInfoAdded;
    private int contentViewTop;
    private final Context context;
    private Rect currentPosition;
    private WebView currentWebView;
    private Rect defaultPosition;
    private final DisplayMetrics displayMetrics;
    private RelativeLayout expandedView;
    private final GestureDetector gestureDetector;
    protected final Handler handler;
    private final int injections;
    private boolean isActionBarShowing;
    private Boolean isBackClickable;
    private boolean isClosing;
    private final boolean isExpandEnabled;
    private boolean isExpanded;
    private boolean isExpandingFromDefault;
    private boolean isExpandingPart2;
    private boolean isFinalPage;
    private boolean isForceNotFullScreen;
    private boolean isForcingFullScreen;
    private boolean isFullScreen;
    private final boolean isInterstitial;
    protected boolean isLaidOut;
    private boolean isLandingPageEnabled;
    protected boolean isPageFinished;
    protected boolean isViewabilityConfirmed;
    protected boolean isViewable;
    private String landingBehaviourString;
    private Integer landingPageDelay;
    protected final MRAIDViewListener listener;
    private SimpleTimer mAntilockTimer;
    private Integer mClickCounter;
    private SimpleTimer mExpirationTimer;
    private boolean mIsExpanding;
    private Integer mNativeCloseButtonDelay;
    private SimpleTimer mNativeCloseButtonTimer;
    private CountDownView mSkipCountdownView;
    private Integer mSkipTimeMillis;
    private HyBidViewabilityWebAdSession mViewabilityAdSession;
    private final List<HyBidViewabilityFriendlyObstruction> mViewabilityFriendlyObstructions;
    private final Size maxSize;
    private String mraidJs;
    private final MRAIDWebChromeClient mraidWebChromeClient;
    private final MRAIDWebViewClient mraidWebViewClient;
    private final MRAIDNativeFeatureListener nativeFeatureListener;
    private final MRAIDNativeFeatureManager nativeFeatureManager;
    private final MRAIDOrientationProperties orientationProperties;
    private int origTitleBarVisibility;
    private final int originalRequestedOrientation;
    private final MRAIDResizeProperties resizeProperties;
    private RelativeLayout resizedView;
    private final Size screenSize;
    private String setCustomisationString;
    private Activity showActivity;
    private final Boolean showTimerBeforeEndCard;
    protected int state;
    private View titleBar;
    private boolean useCustomClose;
    private boolean wasTouched;
    protected final WebView webView;
    private boolean webViewLoaded;
    private WebView webViewPart2;
    private static final CountdownStyle COUNTDOWN_STYLE_DEFAULT = CountdownStyle.PIE_CHART;
    private static final String[] COMMANDS_WITH_NO_PARAM = {"close", "resize"};
    private static final String[] COMMANDS_WITH_STRING = {"createCalendarEvent", "expand", "open", MraidJsMethods.PLAY_VIDEO, "storePicture", MraidJsMethods.USE_CUSTOM_CLOSE};
    private static final String[] COMMANDS_WITH_MAP = {"setOrientationProperties", "setResizeProperties"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface MRAIDState {
    }

    public interface OnExpandCreativeFailListener {
        void onExpandFailed();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent me) {
        DetectTouchUtils.viewOnTouch(h.C, this, me);
        return super.dispatchTouchEvent(me);
    }

    protected void onLayoutCompleted() {
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (1 == 0) {
            setMeasuredDimension(0, 0);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void handleNativeCloseButtonDelay() {
        SimpleTimer simpleTimer = new SimpleTimer(this.mNativeCloseButtonDelay.intValue(), new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.1
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                if (MRAIDView.this.listener != null) {
                    MRAIDView.this.listener.mraidShowCloseButton();
                }
                MRAIDView.this.showDefaultCloseButton();
                MRAIDView.this.isBackClickable = true;
            }
        }, 1000L);
        this.mNativeCloseButtonTimer = simpleTimer;
        simpleTimer.start();
    }

    public int getState() {
        return this.state;
    }

    private static class Size {
        public int height;
        public int width;

        private Size() {
        }
    }

    public MRAIDView(Context context, String str, String str2, Boolean bool, String[] strArr, MRAIDViewListener mRAIDViewListener, MRAIDNativeFeatureListener mRAIDNativeFeatureListener, ViewGroup viewGroup, boolean z, boolean z2) {
        super(context);
        this.mSkipTimeMillis = -1;
        this.mNativeCloseButtonDelay = -1;
        this.mClickCounter = 0;
        this.isBackClickable = false;
        this.landingPageDelay = 30000;
        this.isFinalPage = false;
        this.activityInitialOrientation = -1;
        this.wasTouched = false;
        this.contentInfoAdded = false;
        this.webViewLoaded = false;
        this.isViewabilityConfirmed = false;
        this.mIsExpanding = false;
        this.injections = 0;
        this.context = context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            this.showActivity = activity;
            this.activityInitialOrientation = activity.getRequestedOrientation();
        }
        String str3 = (str == null || str.isEmpty()) ? "https://example.com" : str;
        this.baseUrl = str3;
        this.isInterstitial = z;
        this.isExpandEnabled = z2;
        this.contentInfo = viewGroup;
        this.state = 0;
        this.isViewable = false;
        this.useCustomClose = false;
        this.orientationProperties = new MRAIDOrientationProperties();
        this.resizeProperties = new MRAIDResizeProperties();
        this.nativeFeatureManager = new MRAIDNativeFeatureManager(context, new ArrayList(Arrays.asList(strArr)));
        this.listener = mRAIDViewListener;
        this.nativeFeatureListener = mRAIDNativeFeatureListener;
        this.showTimerBeforeEndCard = bool;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.displayMetrics = displayMetrics;
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        } else {
            this.displayMetrics = null;
        }
        this.currentPosition = new Rect();
        this.defaultPosition = new Rect();
        this.maxSize = new Size();
        this.screenSize = new Size();
        if (context instanceof Activity) {
            this.originalRequestedOrientation = ((Activity) context).getRequestedOrientation();
        } else {
            this.originalRequestedOrientation = -1;
        }
        MRAIDLog.d(MRAID_LOG_TAG, "originalRequestedOrientation " + getOrientationString(this.originalRequestedOrientation));
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return true;
            }
        });
        this.handler = new Handler(Looper.getMainLooper());
        this.mViewabilityAdSession = new HyBidViewabilityWebAdSession(HyBid.getViewabilityManager());
        this.mViewabilityFriendlyObstructions = new ArrayList();
        this.mraidWebChromeClient = new MRAIDWebChromeClient();
        this.mraidWebViewClient = new MRAIDWebViewClient();
        WebView webViewCreateWebView = createWebView();
        this.webView = webViewCreateWebView;
        if (webViewCreateWebView == null) {
            if (mRAIDViewListener != null) {
                mRAIDViewListener.mraidViewError(this);
                return;
            }
            return;
        }
        webViewCreateWebView.setId(R.id.mraid_ad_view);
        this.currentWebView = webViewCreateWebView;
        if (TextUtils.isEmpty(str2)) {
            if (str != null) {
                MRAIDLog.d("hz-m loading mraid from url: " + str);
                VerveNetworkBridge.webviewLoadUrl(webViewCreateWebView, str);
                return;
            }
            return;
        }
        try {
            String strProcessRawHtml = MRAIDHtmlProcessor.processRawHtml(str2);
            MRAIDLog.d("hz-m loading mraid " + strProcessRawHtml);
            VerveNetworkBridge.webviewLoadDataWithBaseURL(webViewCreateWebView, str3, strProcessRawHtml, POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
            handleAntilockDelay();
        } catch (Throwable th) {
            HyBid.reportException(th);
            this.listener.mraidViewError(this);
        }
    }

    private WebView createWebView() {
        try {
            PNWebView pNWebView = new PNWebView(this.context) { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.3
                private static final String TAG = "MRAIDView-WebView";

                @Override // net.pubnative.lite.sdk.views.PNWebView, android.view.ViewGroup, android.view.View
                public boolean dispatchTouchEvent(MotionEvent me) {
                    DetectTouchUtils.viewOnTouch(h.C, this, me);
                    return super.dispatchTouchEvent(me);
                }

                @Override // net.pubnative.lite.sdk.views.PNWebView, android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
                protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                    if (1 == 0) {
                        setMeasuredDimension(0, 0);
                    } else {
                        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                    }
                }

                @Override // android.widget.AbsoluteLayout, android.view.ViewGroup, android.view.View
                protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                    super.onLayout(z, i, i2, i3, i4);
                    MRAIDView.this.onLayoutWebView(this, z, i, i2, i3, i4);
                }

                @Override // android.webkit.WebView, android.view.View
                public void onConfigurationChanged(Configuration configuration) {
                    super.onConfigurationChanged(configuration);
                    MRAIDLog.d(TAG, "onConfigurationChanged ".concat(configuration.orientation == 1 ? "portrait" : "landscape"));
                    if (MRAIDView.this.isInterstitial) {
                        if (Build.VERSION.SDK_INT >= 30) {
                            if (MRAIDView.this.context.getDisplay() != null) {
                                MRAIDView.this.context.getDisplay().getMetrics(MRAIDView.this.displayMetrics);
                            }
                        } else {
                            WindowManager windowManager = (WindowManager) MRAIDView.this.context.getSystemService("window");
                            if (windowManager != null) {
                                windowManager.getDefaultDisplay().getMetrics(MRAIDView.this.displayMetrics);
                            }
                        }
                    }
                }

                @Override // android.webkit.WebView, android.view.View
                protected void onVisibilityChanged(View view, int i) {
                    super.onVisibilityChanged(view, i);
                    MRAIDLog.d(TAG, "onVisibilityChanged " + MRAIDView.getVisibilityString(i));
                    if (MRAIDView.this.isInterstitial) {
                        MRAIDView.this.setViewable(i);
                    }
                }

                @Override // android.webkit.WebView, android.view.View
                protected void onWindowVisibilityChanged(int i) {
                    super.onWindowVisibilityChanged(i);
                    int visibility = getVisibility();
                    MRAIDLog.d(TAG, "onWindowVisibilityChanged " + MRAIDView.getVisibilityString(i) + " (actual " + MRAIDView.getVisibilityString(visibility) + ')');
                    if (MRAIDView.this.isInterstitial) {
                        MRAIDView.this.setViewable(visibility);
                    }
                }

                @Override // android.view.View
                public boolean performClick() {
                    return super.performClick();
                }
            };
            pNWebView.setScrollContainer(false);
            pNWebView.setVerticalScrollBarEnabled(false);
            pNWebView.setHorizontalScrollBarEnabled(false);
            pNWebView.setScrollBarStyle(33554432);
            pNWebView.setOnTouchListener(new View.OnTouchListener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.4
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    MRAIDView.this.wasTouched = true;
                    int action = motionEvent.getAction();
                    if ((action != 0 && action != 1) || view.hasFocus()) {
                        return false;
                    }
                    view.requestFocus();
                    return false;
                }
            });
            pNWebView.getSettings().setJavaScriptEnabled(true);
            pNWebView.getSettings().setDomStorageEnabled(true);
            pNWebView.getSettings().setAllowContentAccess(false);
            pNWebView.enablePlugins(true);
            pNWebView.getSettings().setSupportZoom(false);
            pNWebView.setWebChromeClient(this.mraidWebChromeClient);
            pNWebView.setWebViewClient(this.mraidWebViewClient);
            pNWebView.setLayerType(2, null);
            pNWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
            return pNWebView;
        } catch (RuntimeException e) {
            HyBid.reportException((Exception) e);
            return null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gestureDetector.onTouchEvent(motionEvent)) {
            motionEvent.setAction(3);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCloseLayoutListener(MRAIDViewCloseLayoutListener mRAIDViewCloseLayoutListener) {
        this.closeLayoutListener = mRAIDViewCloseLayoutListener;
    }

    public void clearView() {
        WebView webView = this.webView;
        if (webView != null) {
            webView.setWebChromeClient(null);
            this.webView.setWebViewClient(null);
            VerveNetworkBridge.webviewLoadUrl(this.webView, AndroidWebViewClient.BLANK_PAGE);
        }
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void destroy() {
        if (this.webView != null) {
            MRAIDLog.i("Destroying Main WebView");
            this.webView.destroy();
        }
        if (this.webViewPart2 != null) {
            MRAIDLog.i("Destroying Secondary WebView");
            this.webViewPart2.destroy();
        }
        RelativeLayout relativeLayout = this.expandedView;
        if (relativeLayout != null) {
            ViewGroup viewGroup = (ViewGroup) relativeLayout.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.expandedView);
            }
            this.expandedView = null;
        }
        this.currentWebView = null;
        this.contentInfoAdded = false;
        SimpleTimer simpleTimer = this.mExpirationTimer;
        if (simpleTimer != null) {
            simpleTimer.onFinish();
            this.mExpirationTimer = null;
        }
        SimpleTimer simpleTimer2 = this.mNativeCloseButtonTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.onFinish();
            this.mNativeCloseButtonTimer = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x009b  */
    public void parseCommandUrl(String str) {
        byte b;
        MRAIDLog.d(MRAID_LOG_TAG, "parseCommandUrl " + str);
        Map<String, String> commandUrl = new MRAIDParser().parseCommandUrl(str);
        if (commandUrl == null) {
            return;
        }
        String str2 = commandUrl.get(f.b.COMMAND);
        try {
            if (Arrays.asList(COMMANDS_WITH_NO_PARAM).contains(str2)) {
                try {
                    getClass().getDeclaredMethod(str2, new Class[0]).invoke(this, new Object[0]);
                    return;
                } catch (NoSuchMethodException unused) {
                    if (getClass().getSuperclass() != null) {
                        getClass().getSuperclass().getDeclaredMethod(str2, new Class[0]).invoke(this, new Object[0]);
                        return;
                    }
                    return;
                }
            }
            if (Arrays.asList(COMMANDS_WITH_STRING).contains(str2)) {
                String str3 = "url";
                if (str2 != null) {
                    int iHashCode = str2.hashCode();
                    if (iHashCode != -733616544) {
                        if (iHashCode == 1614272768 && str2.equals(MraidJsMethods.USE_CUSTOM_CLOSE)) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (str2.equals("createCalendarEvent")) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                    if (b == 0) {
                        str3 = "eventJSON";
                    } else if (b == 1) {
                        str3 = MraidJsMethods.USE_CUSTOM_CLOSE;
                    }
                }
                String str4 = commandUrl.get(str3);
                try {
                    getClass().getDeclaredMethod(str2, String.class).invoke(this, str4);
                    return;
                } catch (NoSuchMethodException unused2) {
                    if (getClass().getSuperclass() != null) {
                        getClass().getSuperclass().getDeclaredMethod(str2, String.class).invoke(this, str4);
                        return;
                    }
                    return;
                }
            }
            if (Arrays.asList(COMMANDS_WITH_MAP).contains(str2)) {
                try {
                    getClass().getDeclaredMethod(str2, Map.class).invoke(this, commandUrl);
                    return;
                } catch (NoSuchMethodException unused3) {
                    if (getClass().getSuperclass() != null) {
                        getClass().getSuperclass().getDeclaredMethod(str2, Map.class).invoke(this, commandUrl);
                        return;
                    }
                    return;
                }
            }
            return;
        } catch (Exception e) {
            HyBid.reportException(e);
            Logger.e(MRAID_LOG_TAG, e.getMessage());
        }
        HyBid.reportException(e);
        Logger.e(MRAID_LOG_TAG, e.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseAdExperienceUrl(String str) {
        MRAIDLog.d(MRAID_LOG_TAG, "parseAdExperienceUrl " + str);
        try {
            if (str.matches("verveadexperience://setcustomisation\\?text=(.+)")) {
                String str2 = new String(Base64.decode(str.replaceFirst("verveadexperience://setcustomisation\\?text=(.+)", "$1"), 0));
                this.setCustomisationString = str2;
                if (str2.isEmpty()) {
                    return;
                }
                this.useCustomClose = false;
                SimpleTimer simpleTimer = this.mNativeCloseButtonTimer;
                if (simpleTimer != null) {
                    simpleTimer.cancel();
                    this.mNativeCloseButtonTimer = null;
                    postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.startSkipTimer();
                        }
                    }, 1000L);
                    return;
                }
                return;
            }
            if (str.matches("verveadexperience://landingbehaviour\\?text=(.+)")) {
                this.landingBehaviourString = new String(Base64.decode(str.replaceFirst("verveadexperience://landingbehaviour\\?text=(.+)", "$1"), 0));
                return;
            }
            if (str.matches("verveadexperience://closedelay\\?text=(.+)")) {
                try {
                    this.landingPageDelay = Integer.valueOf(Integer.parseInt(new String(Base64.decode(str.replaceFirst("verveadexperience://closedelay\\?text=(.+)", "$1"), 0))));
                } catch (NumberFormatException unused) {
                }
                validateDelay();
            } else if (str.matches("verveadexperience://setfinalpage")) {
                this.isFinalPage = true;
                handleLandingPageBehavior();
            }
        } catch (RuntimeException e) {
            Logger.d(MRAID_LOG_TAG, "Error parsing Ad Experience: " + e);
        }
    }

    public boolean onBackPressed() {
        MRAIDLog.d("hz-m MRAIDView - onBackPressed");
        int i = this.state;
        if (i == 0 || i == 4) {
            MRAIDLog.d("hz-m MRAIDView - onBackPressed - loading or hidden");
            return false;
        }
        if (!this.isBackClickable.booleanValue()) {
            return true;
        }
        close();
        return true;
    }

    protected void close() {
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "close");
        MRAIDLog.d("hz-m closing wv: " + this.webView);
        this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9694lambda$close$0$netpubnativelitesdkmraidMRAIDView();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$close$0$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9694lambda$close$0$netpubnativelitesdkmraidMRAIDView() {
        int i = this.state;
        if (i != 1 && i != 2) {
            if (i == 3) {
                closeFromResized();
            }
        } else {
            MRAIDViewCloseLayoutListener mRAIDViewCloseLayoutListener = this.closeLayoutListener;
            if (mRAIDViewCloseLayoutListener != null) {
                mRAIDViewCloseLayoutListener.onClose();
            } else {
                closeFromExpanded();
            }
        }
    }

    private void createCalendarEvent(String str) {
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "createCalendarEvent " + str);
        MRAIDNativeFeatureListener mRAIDNativeFeatureListener = this.nativeFeatureListener;
        if (mRAIDNativeFeatureListener != null) {
            mRAIDNativeFeatureListener.mraidNativeFeatureCreateCalendarEvent(str);
        }
    }

    protected void unload() {
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", MraidJsMethods.UNLOAD);
        MRAIDLog.d("hz-m unload wv: " + this.webView);
        MRAIDViewListener mRAIDViewListener = this.listener;
        if (mRAIDViewListener != null) {
            mRAIDViewListener.mraidViewError(this);
        }
    }

    @Deprecated
    protected void expand(String str) {
        if (this.isExpandEnabled && this.wasTouched) {
            expandCreative(str, false, false);
        }
    }

    private void expandCreative(String str, boolean z, Boolean bool) {
        expandCreative(str, z, bool, null);
    }

    protected void expand(String str, Boolean bool, OnExpandCreativeFailListener onExpandCreativeFailListener) {
        expandCreative(str, false, bool, onExpandCreativeFailListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void expandCreative(String str, boolean z, Boolean bool, OnExpandCreativeFailListener onExpandCreativeFailListener) {
        MRAIDLog.d("hz-m MRAIDView - expand " + str);
        StringBuilder sb = new StringBuilder();
        String str2 = MRAID_LOG_TAG;
        MRAIDLog.d(sb.append(str2).append("-JS callback").toString(), "expand " + (str != null ? str : "(1-part)"));
        MRAIDOrientationProperties mRAIDOrientationProperties = this.orientationProperties;
        if (mRAIDOrientationProperties != null) {
            mRAIDOrientationProperties.allowOrientationChange = false;
            applyOrientationProperties();
        }
        if (!this.isExpandEnabled && !bool.booleanValue()) {
            MRAIDLog.d(str2 + "-JS callback", "expand disabled by the developer");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            int i = this.state;
            if (i == 0 || i == 1) {
                if (this.webView.getParent() != null) {
                    ((ViewGroup) this.webView.getParent()).removeView(this.webView);
                } else {
                    removeView(this.webView);
                }
            } else if (i == 3) {
                removeResizeView();
            }
            expandHelper(this.webView);
            MRAIDLog.d("hz-m MRAIDView - expand - empty url");
            if (onExpandCreativeFailListener != null) {
                onExpandCreativeFailListener.onExpandFailed();
                return;
            }
            return;
        }
        decodeURL(str, z);
    }

    private void decodeURL(String str, final boolean z) {
        try {
            final String strDecode = URLDecoder.decode(str, "UTF-8");
            if (!strDecode.startsWith(d.v) && !strDecode.startsWith("https://")) {
                strDecode = this.baseUrl + strDecode;
            }
            new Thread(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9700lambda$decodeURL$3$netpubnativelitesdkmraidMRAIDView(z, strDecode);
                }
            }, "2-part-content").start();
        } catch (UnsupportedEncodingException e) {
            HyBid.reportException((Exception) e);
            MRAIDLog.d("hz-m MRAIDView - expand - UnsupportedEncodingException " + e);
        }
    }

    /* JADX INFO: renamed from: lambda$decodeURL$3$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9700lambda$decodeURL$3$netpubnativelitesdkmraidMRAIDView(boolean z, final String str) {
        MRAIDLog.d("hz-m MRAIDView - expand - url loading thread");
        if (z) {
            Context context = this.context;
            if (context instanceof Activity) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9698lambda$decodeURL$1$netpubnativelitesdkmraidMRAIDView(str);
                    }
                });
                return;
            } else {
                MRAIDLog.e("Could not load part 2 expanded content for URL: " + str);
                return;
            }
        }
        Context context2 = this.context;
        if (context2 instanceof Activity) {
            ((Activity) context2).runOnUiThread(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m9699lambda$decodeURL$2$netpubnativelitesdkmraidMRAIDView(str);
                }
            });
        } else {
            MRAIDLog.e("Could not load part 2 expanded content for URL: " + str);
        }
    }

    /* JADX INFO: renamed from: lambda$decodeURL$1$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9698lambda$decodeURL$1$netpubnativelitesdkmraidMRAIDView(String str) {
        if (this.state == 3) {
            removeResizeView();
            addView(this.webView);
        }
        this.webView.setWebChromeClient(null);
        this.webView.setWebViewClient(null);
        WebView webViewCreateWebView = createWebView();
        this.webViewPart2 = webViewCreateWebView;
        VerveNetworkBridge.webviewLoadUrl(webViewCreateWebView, str);
        MRAIDLog.d("hz-m MRAIDView - expand - switching out currentwebview for " + this.webViewPart2);
        WebView webView = this.webViewPart2;
        this.currentWebView = webView;
        this.isExpandingPart2 = true;
        expandHelper(webView);
    }

    /* JADX INFO: renamed from: lambda$decodeURL$2$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9699lambda$decodeURL$2$netpubnativelitesdkmraidMRAIDView(String str) {
        if (this.state == 3) {
            removeResizeView();
            addView(this.webView);
        }
        this.webView.setWebChromeClient(null);
        this.webView.setWebViewClient(null);
        WebView webViewCreateWebView = createWebView();
        this.webViewPart2 = webViewCreateWebView;
        this.mIsExpanding = true;
        VerveNetworkBridge.webviewLoadUrl(webViewCreateWebView, str);
        MRAIDLog.d("hz-m MRAIDView - expand - switching out currentwebview for " + this.webViewPart2);
        WebView webView = this.webViewPart2;
        this.currentWebView = webView;
        this.isExpandingPart2 = true;
        expandHelper(webView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void open(String str) {
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            StringBuilder sb = new StringBuilder();
            String str2 = MRAID_LOG_TAG;
            MRAIDLog.d(sb.append(str2).append("-JS callback").toString(), "open " + strDecode + " touched: " + this.wasTouched);
            if (!this.wasTouched) {
                MRAIDLog.d(str2 + "- JS callback", "open called, but no touch recorded, aborting");
                return;
            }
            if (this.nativeFeatureListener != null) {
                if (strDecode.startsWith("sms")) {
                    this.nativeFeatureListener.mraidNativeFeatureSendSms(strDecode);
                } else if (strDecode.startsWith("tel")) {
                    this.nativeFeatureListener.mraidNativeFeatureCallTel(strDecode);
                } else {
                    this.nativeFeatureListener.mraidNativeFeatureOpenBrowser(strDecode);
                }
            }
        } catch (UnsupportedEncodingException e) {
            HyBid.reportException((Exception) e);
            Logger.e(MRAID_LOG_TAG, e.getMessage());
        }
    }

    private void playVideo(String str) {
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "playVideo " + strDecode);
            MRAIDNativeFeatureListener mRAIDNativeFeatureListener = this.nativeFeatureListener;
            if (mRAIDNativeFeatureListener != null) {
                mRAIDNativeFeatureListener.mraidNativeFeaturePlayVideo(strDecode);
            }
        } catch (UnsupportedEncodingException e) {
            HyBid.reportException((Exception) e);
            Logger.e(MRAID_LOG_TAG, e.getMessage());
        }
    }

    private void resize() {
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "resize");
        MRAIDViewListener mRAIDViewListener = this.listener;
        if (mRAIDViewListener != null && mRAIDViewListener.mraidViewResize(this, this.resizeProperties.width, this.resizeProperties.height, this.resizeProperties.offsetX, this.resizeProperties.offsetY)) {
            this.state = 3;
            if (this.resizedView == null) {
                this.resizedView = new RelativeLayout(this.context);
                removeView(this.webView);
                this.resizedView.addView(this.webView);
                addCloseRegion(this.resizedView);
                ((FrameLayout) getRootView().findViewById(android.R.id.content)).addView(this.resizedView);
            }
            setCloseRegionPosition(this.resizedView);
            setResizedViewSize();
            setResizedViewPosition();
            this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.fireStateChangeEvent();
                }
            });
        }
    }

    protected void setOrientationProperties(Map<String, String> map) {
        boolean z = Boolean.parseBoolean(map.get("allowOrientationChange"));
        String str = map.get("forceOrientation");
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "setOrientationProperties " + z + " " + str);
        this.orientationProperties.allowOrientationChange = z;
        this.orientationProperties.forceOrientation = MRAIDOrientationProperties.forceOrientationFromString(str);
        if ((this instanceof MRAIDInterstitial) || this.state == 2) {
            applyOrientationProperties();
        }
    }

    private void setResizeProperties(Map<String, String> map) {
        int i = Integer.parseInt(map.get("width"));
        int i2 = Integer.parseInt(map.get("height"));
        int i3 = Integer.parseInt(map.get("offsetX"));
        int i4 = Integer.parseInt(map.get("offsetY"));
        String str = map.get("customClosePosition");
        boolean z = Boolean.parseBoolean(map.get("allowOffscreen"));
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "setResizeProperties " + i + " " + i2 + " " + i3 + " " + i4 + " " + str + " " + z);
        this.resizeProperties.width = i;
        this.resizeProperties.height = i2;
        this.resizeProperties.offsetX = i3;
        this.resizeProperties.offsetY = i4;
        this.resizeProperties.customClosePosition = MRAIDResizeProperties.customClosePositionFromString(str);
        this.resizeProperties.allowOffscreen = z;
    }

    private void storePicture(String str) {
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "storePicture " + strDecode);
            MRAIDNativeFeatureListener mRAIDNativeFeatureListener = this.nativeFeatureListener;
            if (mRAIDNativeFeatureListener != null) {
                mRAIDNativeFeatureListener.mraidNativeFeatureStorePicture(strDecode);
            }
        } catch (UnsupportedEncodingException e) {
            HyBid.reportException((Exception) e);
            Logger.e(MRAID_LOG_TAG, e.getMessage());
        }
    }

    @Deprecated
    private void useCustomClose(String str) {
        MRAIDLog.d(MRAID_LOG_TAG + "-JS callback", "useCustomClose " + str);
        boolean z = Boolean.parseBoolean(str);
        if (this.useCustomClose != z) {
            this.useCustomClose = z;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00cb A[Catch: IOException -> 0x009f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {IOException -> 0x009f, blocks: (B:24:0x009b, B:36:0x00cb), top: B:53:0x0012 }] */
    private String getStringFromUrl(String str) throws Throwable {
        String str2 = "getContentLength ";
        if (str.startsWith("file:///")) {
            return getStringFromFileUrl(str);
        }
        InputStream inputStream = null;
        String string = null;
        inputStream = null;
        inputStream = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    int iHttpUrlConnectionGetResponseCode = VerveNetworkBridge.httpUrlConnectionGetResponseCode(httpURLConnection);
                    String str3 = MRAID_LOG_TAG;
                    MRAIDLog.d(str3, "response code " + iHttpUrlConnectionGetResponseCode);
                    try {
                        if (iHttpUrlConnectionGetResponseCode == 200) {
                            MRAIDLog.d(str3, "getContentLength " + httpURLConnection.getContentLength());
                            InputStream inputStreamUrlConnectionGetInputStream = VerveNetworkBridge.urlConnectionGetInputStream(httpURLConnection);
                            try {
                                byte[] bArr = new byte[1500];
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    int i = inputStreamUrlConnectionGetInputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    }
                                    sb.append(new String(bArr, 0, i));
                                    HyBid.reportException((Exception) e);
                                    MRAIDLog.e(MRAID_LOG_TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return str2;
                                }
                                string = sb.toString();
                                MRAIDLog.d(MRAID_LOG_TAG, "getStringFromUrl ok, length=" + string.length());
                                inputStream = inputStreamUrlConnectionGetInputStream;
                                str2 = string;
                            } catch (IOException e) {
                                e = e;
                                String str4 = string;
                                inputStream = inputStreamUrlConnectionGetInputStream;
                                str2 = str4;
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStreamUrlConnectionGetInputStream;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                        HyBid.reportException((Exception) e2);
                                    }
                                }
                                throw th;
                            }
                        } else {
                            str2 = null;
                        }
                        VerveNetworkBridge.httpUrlConnectionDisconnect(httpURLConnection);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        HyBid.reportException((Exception) e);
                        MRAIDLog.e(MRAID_LOG_TAG, "getStringFromUrl failed " + e.getLocalizedMessage());
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return str2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
                str2 = null;
            }
        } catch (IOException e5) {
            HyBid.reportException((Exception) e5);
        }
        return str2;
    }

    private String getStringFromFileUrl(String str) {
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit = str.split(RemoteSettings.FORWARD_SLASH_STRING);
        if (strArrSplit[3].equals(Utils.ASSET_FILE_PATH_ROOT)) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.context.getAssets().open(strArrSplit[4])));
                try {
                    String line = bufferedReader.readLine();
                    sb.append(line);
                    while (line != null) {
                        line = bufferedReader.readLine();
                        sb.append(line);
                    }
                    bufferedReader.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e) {
                MRAIDLog.e("Error fetching file: " + e.getMessage());
                HyBid.reportException((Exception) e);
            }
            return sb.toString();
        }
        MRAIDLog.e("Unknown location to fetch file content");
        return "";
    }

    protected void showAsInterstitial(Activity activity, Boolean bool, OnExpandCreativeFailListener onExpandCreativeFailListener) {
        MRAIDLog.d("hz-m MRAIDVIEW - showAsInterstitial");
        this.showActivity = activity;
        expand(null, bool, onExpandCreativeFailListener);
    }

    protected void showAsInterstitial(Activity activity, Boolean bool, OnExpandCreativeFailListener onExpandCreativeFailListener, String str) {
        MRAIDLog.d("hz-m MRAIDVIEW - showAsInterstitial");
        this.showActivity = activity;
        expand(str, bool, onExpandCreativeFailListener);
    }

    protected void expandHelper(WebView webView) {
        applyOrientationProperties();
        forceFullScreen();
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        this.expandedView = relativeLayout;
        relativeLayout.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
        if (this.isInterstitial) {
            addContentInfo(this.expandedView);
        }
        addCloseRegion(this.expandedView);
        setCloseRegionPosition(this.expandedView);
        MRAIDLog.d("hz-m MRAIDView - expandHelper - adding contentview to activity " + this.context);
        this.showActivity.addContentView(this.expandedView, new RelativeLayout.LayoutParams(-1, -1));
        this.isExpandingFromDefault = true;
        this.isExpanded = true;
    }

    public void expandContentInfo(String str) {
        decodeURL(str, false);
    }

    private void setResizedViewSize() {
        if (this.displayMetrics != null) {
            String str = MRAID_LOG_TAG;
            MRAIDLog.d(str, "setResizedViewSize");
            int i = this.resizeProperties.width;
            int i2 = this.resizeProperties.height;
            MRAIDLog.d(str, "setResizedViewSize " + i + VastAttributes.HORIZONTAL_POSITION + i2);
            this.resizedView.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, i, this.displayMetrics), (int) TypedValue.applyDimension(1, i2, this.displayMetrics)));
        }
    }

    public void setUseCustomClose(Boolean bool) {
        if (this.useCustomClose != bool.booleanValue()) {
            this.useCustomClose = bool.booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResizedViewPosition() {
        if (this.displayMetrics != null) {
            MRAIDLog.d(MRAID_LOG_TAG, "setResizedViewPosition");
            if (this.resizedView == null) {
                return;
            }
            int i = this.resizeProperties.width;
            int i2 = this.resizeProperties.height;
            int i3 = this.resizeProperties.offsetX;
            int i4 = this.resizeProperties.offsetY;
            int iApplyDimension = (int) TypedValue.applyDimension(1, i, this.displayMetrics);
            int iApplyDimension2 = (int) TypedValue.applyDimension(1, i2, this.displayMetrics);
            int iApplyDimension3 = (int) TypedValue.applyDimension(1, i3, this.displayMetrics);
            int iApplyDimension4 = (int) TypedValue.applyDimension(1, i4, this.displayMetrics);
            int i5 = this.defaultPosition.left + iApplyDimension3;
            int i6 = this.defaultPosition.top + iApplyDimension4;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.resizedView.getLayoutParams();
            layoutParams.leftMargin = i5;
            layoutParams.topMargin = i6;
            this.resizedView.setLayoutParams(layoutParams);
            if (i5 == this.currentPosition.left && i6 == this.currentPosition.top && iApplyDimension == this.currentPosition.width() && iApplyDimension2 == this.currentPosition.height()) {
                return;
            }
            this.currentPosition.left = i5;
            this.currentPosition.top = i6;
            this.currentPosition.right = i5 + iApplyDimension;
            this.currentPosition.bottom = i6 + iApplyDimension2;
            setCurrentPosition();
        }
    }

    protected void closeFromExpanded() {
        FrameLayout frameLayout;
        int i = this.state;
        if (i == 2 || i == 3) {
            this.state = 1;
        }
        MRAIDOrientationProperties mRAIDOrientationProperties = this.orientationProperties;
        if (mRAIDOrientationProperties != null) {
            mRAIDOrientationProperties.allowOrientationChange = true;
        }
        setOrientationInitialState();
        this.isClosing = true;
        this.isExpanded = false;
        RelativeLayout relativeLayout = this.expandedView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        Context context = this.context;
        if (!(context instanceof Activity) || (frameLayout = (FrameLayout) ((Activity) context).findViewById(android.R.id.content)) == null) {
            return;
        }
        frameLayout.removeView(this.expandedView);
        this.expandedView = null;
        this.closeRegion = null;
        this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9695xe4d8e473();
            }
        });
        WebView webView = this.webViewPart2;
        if (webView == null) {
            if (findViewById(R.id.mraid_ad_view) != null) {
                removeView(this.webView);
            }
            addView(this.webView, 0, new FrameLayout.LayoutParams(-1, -2));
        } else {
            webView.destroy();
            this.webView.setWebChromeClient(this.mraidWebChromeClient);
            this.webView.setWebViewClient(this.mraidWebViewClient);
            MRAIDLog.d("hz-m MRAIDView - closeFromExpanded - setting currentwebview to " + this.webView);
            WebView webView2 = this.webView;
            this.currentWebView = webView2;
            webView2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9696x3bf6d552();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$closeFromExpanded$4$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9695xe4d8e473() {
        restoreOriginalOrientation();
        restoreOriginalScreenState();
    }

    /* JADX INFO: renamed from: lambda$closeFromExpanded$5$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9696x3bf6d552() {
        fireStateChangeEvent();
        MRAIDViewListener mRAIDViewListener = this.listener;
        if (mRAIDViewListener != null) {
            mRAIDViewListener.mraidViewClose(this);
        }
    }

    protected void closeFromResized() {
        this.state = 1;
        this.isClosing = true;
        removeResizeView();
        addView(this.webView, 0);
        this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9697lambda$closeFromResized$6$netpubnativelitesdkmraidMRAIDView();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$closeFromResized$6$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9697lambda$closeFromResized$6$netpubnativelitesdkmraidMRAIDView() {
        fireStateChangeEvent();
        MRAIDViewListener mRAIDViewListener = this.listener;
        if (mRAIDViewListener != null) {
            mRAIDViewListener.mraidViewClose(this);
        }
    }

    private void removeResizeView() {
        RelativeLayout relativeLayout = this.resizedView;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            Context context = this.context;
            if (context instanceof Activity) {
                ((FrameLayout) ((Activity) context).findViewById(android.R.id.content)).removeView(this.resizedView);
                this.resizedView = null;
                this.closeRegion = null;
            }
        }
    }

    private void forceFullScreen() {
        if (this.context instanceof Activity) {
            MRAIDLog.d(MRAID_LOG_TAG, "forceFullScreen");
            Activity activity = (Activity) this.context;
            int i = activity.getWindow().getAttributes().flags;
            this.isFullScreen = (i & 1024) != 0;
            this.isForceNotFullScreen = (i & 2048) != 0;
            this.origTitleBarVisibility = -9;
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                this.isActionBarShowing = actionBar.isShowing();
                actionBar.hide();
            } else {
                this.titleBar = null;
                try {
                    if (activity.findViewById(android.R.id.title) != null) {
                        this.titleBar = (View) activity.findViewById(android.R.id.title).getParent();
                    }
                } catch (NullPointerException e) {
                    HyBid.reportException((Exception) e);
                }
                View view = this.titleBar;
                if (view != null) {
                    this.origTitleBarVisibility = view.getVisibility();
                    this.titleBar.setVisibility(8);
                }
            }
            String str = MRAID_LOG_TAG;
            MRAIDLog.d(str, "isFullScreen " + this.isFullScreen);
            MRAIDLog.d(str, "isForceNotFullScreen " + this.isForceNotFullScreen);
            MRAIDLog.d(str, "isActionBarShowing " + this.isActionBarShowing);
            MRAIDLog.d(str, "origTitleBarVisibility " + getVisibilityString(this.origTitleBarVisibility));
            ((Activity) this.context).getWindow().addFlags(1024);
            ((Activity) this.context).getWindow().clearFlags(2048);
            this.isForcingFullScreen = !this.isFullScreen;
        }
    }

    private void restoreOriginalScreenState() {
        Context context = this.context;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!this.isFullScreen) {
                activity.getWindow().clearFlags(1024);
            }
            if (this.isForceNotFullScreen) {
                activity.getWindow().addFlags(2048);
            }
            if (this.isActionBarShowing) {
                ActionBar actionBar = activity.getActionBar();
                if (actionBar != null) {
                    actionBar.show();
                    return;
                }
                return;
            }
            View view = this.titleBar;
            if (view != null) {
                view.setVisibility(this.origTitleBarVisibility);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getVisibilityString(int i) {
        if (i == 0) {
            return "VISIBLE";
        }
        if (i == 4) {
            return "INVISIBLE";
        }
        if (i == 8) {
            return "GONE";
        }
        return "UNKNOWN";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addContentInfo(View view) {
        ViewGroup viewGroup = this.contentInfo;
        if (viewGroup == null || this.contentInfoAdded) {
            return;
        }
        ((ViewGroup) view).addView(viewGroup);
        this.contentInfoAdded = true;
    }

    private void addCloseRegion(View view) {
        ImageButton imageButton = new ImageButton(this.context);
        this.closeRegion = imageButton;
        imageButton.setId(R.id.close_view);
        this.closeRegion.setBackgroundColor(0);
        this.closeRegion.setOnClickListener(new View.OnClickListener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m9693lambda$addCloseRegion$7$netpubnativelitesdkmraidMRAIDView(view2);
            }
        });
        if (view == this.expandedView && !this.useCustomClose) {
            showDefaultCloseButton();
        }
        ((ViewGroup) view).addView(this.closeRegion);
    }

    /* JADX INFO: renamed from: lambda$addCloseRegion$7$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9693lambda$addCloseRegion$7$netpubnativelitesdkmraidMRAIDView(View view) {
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultCloseButton() {
        ImageButton imageButton = this.closeRegion;
        if (imageButton != null) {
            Bitmap bitmap = BitmapHelper.toBitmap(imageButton.getContext(), HyBid.getNormalCloseXmlResource(), Integer.valueOf(R.mipmap.close));
            if (bitmap != null) {
                this.closeRegion.setImageBitmap(bitmap);
            } else {
                ImageButton imageButton2 = this.closeRegion;
                imageButton2.setImageBitmap(BitmapHelper.decodeResource(imageButton2.getContext(), Integer.valueOf(R.mipmap.close)));
            }
            this.closeRegion.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void removeDefaultCloseButton() {
        ImageButton imageButton = this.closeRegion;
        if (imageButton != null) {
            imageButton.setImageResource(android.R.color.transparent);
        }
    }

    private void setCloseRegionPosition(View view) {
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics != null) {
            int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
            if (view == this.expandedView) {
                layoutParams.addRule(10);
                layoutParams.addRule(20);
            } else if (view == this.resizedView) {
                switch (this.resizeProperties.customClosePosition) {
                    case 0:
                    case 4:
                        layoutParams.addRule(9);
                        break;
                    case 1:
                    case 3:
                    case 5:
                        layoutParams.addRule(14);
                        break;
                    case 2:
                    case 6:
                        layoutParams.addRule(11);
                        break;
                }
                switch (this.resizeProperties.customClosePosition) {
                    case 0:
                    case 1:
                    case 2:
                        layoutParams.addRule(10);
                        break;
                    case 3:
                        layoutParams.addRule(15);
                        break;
                    case 4:
                    case 5:
                    case 6:
                        layoutParams.addRule(12);
                        break;
                }
            }
            this.closeRegion.setLayoutParams(layoutParams);
        }
    }

    private void injectMraidJs(WebView webView) {
        if (TextUtils.isEmpty(this.mraidJs)) {
            this.mraidJs = new String(Base64.decode(Assets.mraidJS, 0));
        }
        injectJavaScript(this.mraidJs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InputStream getMraidJsStream() {
        if (TextUtils.isEmpty(this.mraidJs)) {
            this.mraidJs = new String(Base64.decode(Assets.mraidJS, 0));
        }
        return new ByteArrayInputStream(this.mraidJs.getBytes(StandardCharsets.UTF_8));
    }

    public void injectJavaScript(String str) {
        injectJavaScript(this.currentWebView, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void injectJavaScript(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return;
        }
        MRAIDLog.d(MRAID_LOG_TAG, "evaluating js: " + str);
        webView.evaluateJavascript(str, new ValueCallback() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda5
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                MRAIDLog.d("Evaluated JS: " + ((String) obj));
            }
        });
    }

    protected void fireReadyEvent() {
        MRAIDLog.d(MRAID_LOG_TAG, "fireReadyEvent");
        injectJavaScript("mraid.fireReadyEvent();");
    }

    protected void fireStateChangeEvent() {
        MRAIDLog.d(MRAID_LOG_TAG, "fireStateChangeEvent");
        injectJavaScript("mraid.fireStateChangeEvent('" + new String[]{"loading", "default", "expanded", "resized", "hidden"}[this.state] + "');");
    }

    protected void fireViewableChangeEvent() {
        MRAIDLog.d(MRAID_LOG_TAG, "fireViewableChangeEvent");
        injectJavaScript("mraid.fireViewableChangeEvent(" + this.isViewable + ");");
    }

    protected void fireExposureChangeEvent() {
        double d = this.isViewable ? 100.0d : 0.0d;
        MRAIDLog.d(MRAID_LOG_TAG, "fireExposureChangeEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VastAttributes.HORIZONTAL_POSITION, getX());
            jSONObject.put(VastAttributes.VERTICAL_POSITION, getY());
            jSONObject.put("width", (((double) getWidth()) * d) / 100.0d);
            jSONObject.put("height", (((double) getHeight()) * d) / 100.0d);
        } catch (JSONException e) {
            HyBid.reportException((Exception) e);
            Logger.e(MRAID_LOG_TAG, e.getMessage());
        }
        injectJavaScript("mraid.fireExposureChangeEvent(" + d + StringUtils.COMMA + jSONObject + ",null);");
    }

    private int px2dip(int i) {
        DisplayMetrics displayMetrics = this.displayMetrics;
        return displayMetrics != null ? (i * 160) / displayMetrics.densityDpi : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentPosition() {
        int i = this.currentPosition.left;
        int i2 = this.currentPosition.top;
        int iWidth = this.currentPosition.width();
        int iHeight = this.currentPosition.height();
        MRAIDLog.d(MRAID_LOG_TAG, "setCurrentPosition [" + i + StringUtils.COMMA + i2 + "] (" + iWidth + VastAttributes.HORIZONTAL_POSITION + iHeight + ")");
        injectJavaScript("mraid.setCurrentPosition(" + px2dip(i) + StringUtils.COMMA + px2dip(i2) + StringUtils.COMMA + px2dip(iWidth) + StringUtils.COMMA + px2dip(iHeight) + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPosition() {
        int i = this.defaultPosition.left;
        int i2 = this.defaultPosition.top;
        int iWidth = this.defaultPosition.width();
        int iHeight = this.defaultPosition.height();
        MRAIDLog.d(MRAID_LOG_TAG, "setDefaultPosition [" + i + StringUtils.COMMA + i2 + "] (" + iWidth + VastAttributes.HORIZONTAL_POSITION + iHeight + ")");
        injectJavaScript("mraid.setDefaultPosition(" + px2dip(i) + StringUtils.COMMA + px2dip(i2) + StringUtils.COMMA + px2dip(iWidth) + StringUtils.COMMA + px2dip(iHeight) + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMaxSize() {
        String str = MRAID_LOG_TAG;
        MRAIDLog.d(str, "setMaxSize");
        int i = this.maxSize.width;
        int i2 = this.maxSize.height;
        MRAIDLog.d(str, "setMaxSize " + i + VastAttributes.HORIZONTAL_POSITION + i2);
        injectJavaScript("mraid.setMaxSize(" + px2dip(i) + StringUtils.COMMA + px2dip(i2) + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScreenSize() {
        String str = MRAID_LOG_TAG;
        MRAIDLog.d(str, "setScreenSize");
        int i = this.screenSize.width;
        int i2 = this.screenSize.height;
        MRAIDLog.d(str, "setScreenSize " + i + VastAttributes.HORIZONTAL_POSITION + i2);
        injectJavaScript("mraid.setScreenSize(" + px2dip(i) + StringUtils.COMMA + px2dip(i2) + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSupportedServices() {
        MRAIDLog.d(MRAID_LOG_TAG, "setSupportedServices");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.CALENDAR, " + this.nativeFeatureManager.isCalendarSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.INLINEVIDEO, " + this.nativeFeatureManager.isInlineVideoSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.SMS, " + this.nativeFeatureManager.isSmsSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.STOREPICTURE, " + this.nativeFeatureManager.isStorePictureSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.TEL, " + this.nativeFeatureManager.isTelSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.LOCATION, " + this.nativeFeatureManager.isLocationSupported() + ");");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnvironmentVariables() {
        DeviceInfo deviceInfo = HyBid.getDeviceInfo();
        if (getContext() != null && getContext().getApplicationContext() != null && !TextUtils.isEmpty(getContext().getApplicationContext().getPackageName())) {
            injectJavaScript("mraid.setAppId(\"" + getContext().getApplicationContext().getPackageName() + "\");");
        }
        injectJavaScript("mraid.setSdkVersion(\"3.3.0\");");
        injectJavaScript("mraid.setCoppa(" + HyBid.isCoppaEnabled() + ");");
        if (deviceInfo != null) {
            if (!deviceInfo.limitTracking() && !TextUtils.isEmpty(deviceInfo.getAdvertisingId())) {
                injectJavaScript("mraid.setIfa(\"" + deviceInfo.getAdvertisingId() + "\");");
            }
            injectJavaScript("mraid.setLimitAdTracking(" + deviceInfo.limitTracking() + ");");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocation() {
        if (this.nativeFeatureManager.isLocationSupported()) {
            HyBidLocationManager locationManager = HyBid.getLocationManager();
            if (locationManager != null && locationManager.getUserLocation() != null) {
                Location userLocation = locationManager.getUserLocation();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("lat", Math.round(userLocation.getLatitude() * 100.0d) / 100.0d);
                    jSONObject.put(POBConstants.KEY_LONGITUDE, Math.round(userLocation.getLongitude() * 100.0d) / 100.0d);
                    jSONObject.put("type", 1);
                    jSONObject.put(POBConstants.KEY_ACCURACY, userLocation.getAccuracy());
                    jSONObject.put(POBConstants.KEY_LAST_FIX, (SystemClock.elapsedRealtimeNanos() - userLocation.getElapsedRealtimeNanos()) / 1000000000);
                    injectJavaScript("mraid.setLocation(" + jSONObject + ");");
                    return;
                } catch (JSONException e) {
                    HyBid.reportException((Exception) e);
                    Logger.e(MRAID_LOG_TAG, "Error passing location to MRAID interface");
                    injectJavaScript("mraid.setLocation(-1);");
                    return;
                }
            }
            injectJavaScript("mraid.setLocation(-1);");
            return;
        }
        injectJavaScript("mraid.setLocation(-1);");
    }

    private class MRAIDWebChromeClient extends WebChromeClient {
        private MRAIDWebChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (consoleMessage == null || consoleMessage.message() == null) {
                return false;
            }
            MRAIDLog.i("JS console", consoleMessage.message() + (consoleMessage.sourceId() == null ? "" : " at " + consoleMessage.sourceId()) + ":" + consoleMessage.lineNumber());
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            MRAIDLog.d("hz-m MRAIDView ChromeClient - onJsBeforeUnload");
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            MRAIDLog.d("JS alert", str2);
            return handlePopups(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            MRAIDLog.d("JS confirm", str2);
            return handlePopups(jsResult);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            MRAIDLog.d("JS prompt", str2);
            return handlePopups(jsPromptResult);
        }

        private boolean handlePopups(JsResult jsResult) {
            jsResult.cancel();
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            MRAIDLog.d("hz-m MRAIDView ChromeClient - onProgressChanged " + i + " wv: " + MRAIDView.this.webView + " view: " + MRAIDView.this);
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            MRAIDLog.d("hz-m MRAIDView ChromeClient - showCustomView");
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            MRAIDLog.d("hz-m MRAIDView ChromeClient - onCloseWindow");
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onExceededDatabaseQuota");
            quotaUpdater.updateQuota(j);
        }

        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReachedMaxAppCacheSize");
            quotaUpdater.updateQuota(j2);
        }

        @Override // android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onPermissionRequest");
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onJsTimeout");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class MRAIDWebViewClient extends WebViewClient {
        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            CreativeInfoManager.onResourceLoaded(h.C, view, url);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewPageFinished(h.C, webView, str);
            safedk_MRAIDView$MRAIDWebViewClient_onPageFinished_ca7a906c106a889ada2926e18ca18b4a(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V");
            BrandSafetyUtils.onWebViewPageStarted(h.C, webView, str);
            safedk_MRAIDView$MRAIDWebViewClient_onPageStarted_3240da91eff9dc7f80384c1bda0cf9ca(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.C, webView, i, str, str2);
            safedk_MRAIDView$MRAIDWebViewClient_onReceivedError_7317c023adec5792c7466faa2a3fd68d(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->onReceivedError(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V");
            BrandSafetyUtils.onWebViewReceivedError(h.C, webView, webResourceRequest, webResourceError);
            safedk_MRAIDView$MRAIDWebViewClient_onReceivedError_0f1489e4cacb31c776ae8979427734a6(webView, webResourceRequest, webResourceError);
        }

        /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->shouldInterceptRequest(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;)Landroid/webkit/WebResourceResponse;");
            return CreativeInfoManager.onWebViewResponseWithHeaders(h.C, webView, webResourceRequest, safedk_MRAIDView$MRAIDWebViewClient_shouldInterceptRequest_4dbb65cf53715a47b2a3df1ba5ea9f3c(webView, webResourceRequest));
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.safedk.android.utils.Logger.d("Verve|SafeDK: Execution> Lnet/pubnative/lite/sdk/mraid/MRAIDView$MRAIDWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z");
            boolean zSafedk_MRAIDView$MRAIDWebViewClient_shouldOverrideUrlLoading_47459d4302f584d15663e70eff655513 = safedk_MRAIDView$MRAIDWebViewClient_shouldOverrideUrlLoading_47459d4302f584d15663e70eff655513(webView, str);
            BrandSafetyUtils.onShouldOverrideUrlLoading(h.C, webView, str, zSafedk_MRAIDView$MRAIDWebViewClient_shouldOverrideUrlLoading_47459d4302f584d15663e70eff655513);
            return zSafedk_MRAIDView$MRAIDWebViewClient_shouldOverrideUrlLoading_47459d4302f584d15663e70eff655513;
        }

        private MRAIDWebViewClient() {
        }

        public void safedk_MRAIDView$MRAIDWebViewClient_onPageFinished_ca7a906c106a889ada2926e18ca18b4a(WebView p0, String p1) {
            super.onPageFinished(p0, p1);
            if (MRAIDView.this.hasLandingPage()) {
                MRAIDView.this.handleSetCustomisationInjection();
            }
            MRAIDView.this.cancelAntilockTimer();
            MRAIDLog.d(MRAIDView.MRAID_LOG_TAG, "onPageFinished: " + p1);
            if (MRAIDView.this.state == 0) {
                MRAIDView.this.isPageFinished = true;
                if (MRAIDView.this.isExpandEnabled) {
                    MRAIDView.this.injectJavaScript("mraid.setPlacementType('" + (MRAIDView.this.isInterstitial ? "interstitial" : POBCommonConstants.BANNER_PLACEMENT_TYPE) + "');");
                } else {
                    MRAIDView.this.injectJavaScript("mraid.setPlacementType('" + (MRAIDView.this.isInterstitial ? "interstitial" : "") + "');");
                }
                MRAIDView.this.setEnvironmentVariables();
                MRAIDView.this.setSupportedServices();
                MRAIDView.this.setLocation();
                if (MRAIDView.this.isLaidOut) {
                    MRAIDView.this.setScreenSize();
                    MRAIDView.this.setMaxSize();
                    MRAIDView.this.setCurrentPosition();
                    MRAIDView.this.setDefaultPosition();
                    if (MRAIDView.this.isInterstitial) {
                        MRAIDView mRAIDView = MRAIDView.this;
                        mRAIDView.showAsInterstitial(mRAIDView.showActivity, false, null);
                    } else {
                        MRAIDView.this.state = 1;
                        MRAIDView.this.fireStateChangeEvent();
                        MRAIDView.this.fireReadyEvent();
                        MRAIDView mRAIDView2 = MRAIDView.this;
                        mRAIDView2.setViewable(mRAIDView2.isViewable ? 0 : 8);
                    }
                }
                if (!MRAIDView.this.isInterstitial) {
                    MRAIDView mRAIDView3 = MRAIDView.this;
                    mRAIDView3.addContentInfo(mRAIDView3);
                }
                if (MRAIDView.this.listener != null && !MRAIDView.this.webViewLoaded) {
                    if (MRAIDView.this.mViewabilityAdSession != null) {
                        MRAIDView.this.mViewabilityAdSession.initAdSession(p0, false);
                        if (MRAIDView.this.contentInfo != null && MRAIDView.this.contentInfoAdded) {
                            MRAIDView mRAIDView4 = MRAIDView.this;
                            mRAIDView4.addViewabilityFriendlyObstruction(mRAIDView4.contentInfo, FriendlyObstructionPurpose.OTHER, "Content info description for the ad");
                            if (MRAIDView.this.mViewabilityFriendlyObstructions != null) {
                                for (HyBidViewabilityFriendlyObstruction hyBidViewabilityFriendlyObstruction : MRAIDView.this.mViewabilityFriendlyObstructions) {
                                    if (MRAIDView.this.mViewabilityAdSession != null) {
                                        MRAIDView.this.mViewabilityAdSession.addFriendlyObstruction(hyBidViewabilityFriendlyObstruction.getView(), hyBidViewabilityFriendlyObstruction.getPurpose(), hyBidViewabilityFriendlyObstruction.getReason());
                                    }
                                }
                            }
                        }
                        MRAIDView.this.webViewLoaded = true;
                        if (MRAIDView.this.mViewabilityAdSession != null) {
                            MRAIDView.this.mViewabilityAdSession.fireLoaded();
                            MRAIDView.this.mViewabilityAdSession.fireImpression();
                        }
                    }
                    MRAIDView.this.listener.mraidViewLoaded(MRAIDView.this);
                    MRAIDView.this.mSkipCountdownView = new CountDownViewFactory().createCountdownView(MRAIDView.this.context, MRAIDView.COUNTDOWN_STYLE_DEFAULT, MRAIDView.this);
                    MRAIDView mRAIDView5 = MRAIDView.this;
                    mRAIDView5.addView(mRAIDView5.mSkipCountdownView);
                    MRAIDView.this.mSkipCountdownView.setVisibility(8);
                    final MRAIDView mRAIDView6 = MRAIDView.this;
                    mRAIDView6.postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$MRAIDWebViewClient$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            mRAIDView6.startSkipTimer();
                        }
                    }, 500L);
                }
            }
            if (MRAIDView.this.isExpandingPart2) {
                MRAIDView.this.isExpandingPart2 = false;
                MRAIDView.this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$MRAIDWebViewClient$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m9702x34e9b5a();
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$onPageFinished$1$net-pubnative-lite-sdk-mraid-MRAIDView$MRAIDWebViewClient, reason: not valid java name */
        /* synthetic */ void m9702x34e9b5a() {
            MRAIDView.this.injectJavaScript("mraid.setPlacementType('" + (MRAIDView.this.isInterstitial ? "interstitial" : POBCommonConstants.BANNER_PLACEMENT_TYPE) + "');");
            MRAIDView.this.setSupportedServices();
            MRAIDView.this.setEnvironmentVariables();
            MRAIDView.this.setLocation();
            MRAIDView.this.setScreenSize();
            MRAIDView.this.setDefaultPosition();
            MRAIDLog.d(MRAIDView.MRAID_LOG_TAG, "calling fireStateChangeEvent 2");
            MRAIDView.this.fireStateChangeEvent();
            MRAIDView.this.fireReadyEvent();
            MRAIDView mRAIDView = MRAIDView.this;
            mRAIDView.setViewable(mRAIDView.isViewable ? 0 : 8);
        }

        public void safedk_MRAIDView$MRAIDWebViewClient_onPageStarted_3240da91eff9dc7f80384c1bda0cf9ca(WebView p0, String p1, Bitmap p2) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onPageStarted");
        }

        @Override // android.webkit.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onPageCommitVisibile");
        }

        public void safedk_MRAIDView$MRAIDWebViewClient_onReceivedError_0f1489e4cacb31c776ae8979427734a6(WebView p0, WebResourceRequest p1, WebResourceError p2) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedError code: " + p2.getErrorCode());
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedError: " + ((Object) p2.getDescription()));
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedHttpError");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedSslError");
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            message.sendToTarget();
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onTooManyRedirects");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedClientCertRequest");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedHttpAuthRequest");
            httpAuthHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - shouldOverrideKeyEvent");
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onScaleChanged");
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onReceivedLoginRequest");
        }

        public void safedk_MRAIDView$MRAIDWebViewClient_onReceivedError_7317c023adec5792c7466faa2a3fd68d(WebView p0, int p1, String p2, String p3) {
            MRAIDLog.d(MRAIDView.MRAID_LOG_TAG, "onReceivedError: " + p2);
            super.onReceivedError(p0, p1, p2, p3);
        }

        public boolean safedk_MRAIDView$MRAIDWebViewClient_shouldOverrideUrlLoading_47459d4302f584d15663e70eff655513(WebView p0, String p1) {
            MRAIDLog.d(MRAIDView.MRAID_LOG_TAG, "shouldOverrideUrlLoading: " + p1);
            if (MRAIDView.this.isFinalPage) {
                MRAIDView.this.cancelLandingPageBehaviour();
            }
            if (p1.startsWith("mraid://")) {
                MRAIDView.this.parseCommandUrl(p1);
            } else if (p1.startsWith("verveadexperience://")) {
                if (MRAIDView.this.isLandingPageEnabled) {
                    MRAIDView.this.parseAdExperienceUrl(p1);
                }
            } else {
                if (MRAIDView.this.hasLandingPage() && !MRAIDView.this.isFinalPage) {
                    return false;
                }
                if (MRAIDView.this.isVerveCustomExpand(p1)) {
                    MRAIDView.this.expandCreative(p1, true, false, null);
                } else if (MRAIDView.this.isCloseSignal(p1)) {
                    MRAIDView.this.closeOnMainThread();
                } else {
                    if (MRAIDView.this.mIsExpanding) {
                        MRAIDView.this.mIsExpanding = false;
                        return false;
                    }
                    try {
                        MRAIDView.this.open(URLEncoder.encode(p1, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        Logger.e(MRAIDView.MRAID_LOG_TAG, e.getMessage());
                    }
                }
            }
            return true;
        }

        public WebResourceResponse safedk_MRAIDView$MRAIDWebViewClient_shouldInterceptRequest_4dbb65cf53715a47b2a3df1ba5ea9f3c(WebView p0, WebResourceRequest p1) {
            if (p1 != null && p1.getUrl() != null) {
                String string = p1.getUrl().toString();
                MRAIDLog.d("hz-m shouldInterceptRequest - " + string);
                if (string.contains("mraid.js")) {
                    MRAIDLog.d("hz-m shouldInterceptRequest - intercepting mraid - " + string);
                    MRAIDView.this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$MRAIDWebViewClient$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m9703x1388d6bb();
                        }
                    });
                    return new WebResourceResponse("application/javascript", "UTF-8", MRAIDView.this.getMraidJsStream());
                }
            }
            return super.shouldInterceptRequest(p0, p1);
        }

        /* JADX INFO: renamed from: lambda$shouldInterceptRequest$2$net-pubnative-lite-sdk-mraid-MRAIDView$MRAIDWebViewClient, reason: not valid java name */
        /* synthetic */ void m9703x1388d6bb() {
            MRAIDView.injectJavaScript(MRAIDView.this.webView, "mraid.logLevel = mraid.LogLevelEnum.DEBUG;");
        }

        @Override // android.webkit.WebViewClient
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            MRAIDLog.d("hz-m MRAIDView WebViewClient - onRenderProcessGone");
            if (MRAIDView.this.listener == null) {
                return true;
            }
            MRAIDView.this.listener.mraidViewError(MRAIDView.this);
            return true;
        }
    }

    public void stopAdSession() {
        HyBidViewabilityWebAdSession hyBidViewabilityWebAdSession = this.mViewabilityAdSession;
        if (hyBidViewabilityWebAdSession != null) {
            hyBidViewabilityWebAdSession.stopAdSession();
            this.mViewabilityAdSession = null;
        }
    }

    public boolean isLoaded() {
        return this.isPageFinished;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVerveCustomExpand(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("tags-prod.vrvm.com") || str.contains("ad.vrvm.com")) && str.contains("type=expandable");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCloseSignal(String str) {
        Uri uri;
        List<String> pathSegments;
        if (!str.contains("https://feedback.verve.com") || (uri = Uri.parse(str)) == null || (pathSegments = uri.getPathSegments()) == null || pathSegments.isEmpty()) {
            return false;
        }
        return uri.getPathSegments().contains("close");
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        MRAIDLog.d(MRAID_LOG_TAG, "onConfigurationChanged ".concat(configuration.orientation == 1 ? "portrait" : "landscape"));
        WindowManager windowManager = (WindowManager) this.context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(this.displayMetrics);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        MRAIDLog.d(MRAID_LOG_TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        MRAIDLog.d(MRAID_LOG_TAG, "onDetachedFromWindow");
        stopAdSession();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        MRAIDLog.d(MRAID_LOG_TAG, "onVisibilityChanged " + getVisibilityString(i));
        setViewable(i);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        int visibility = getVisibility();
        MRAIDLog.d(MRAID_LOG_TAG, "onWindowVisibilityChanged " + getVisibilityString(i) + " (actual " + getVisibilityString(visibility) + ")");
        setViewable(visibility);
    }

    protected void setViewable(final int i) {
        post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m9701lambda$setViewable$9$netpubnativelitesdkmraidMRAIDView(i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setViewable$9$net-pubnative-lite-sdk-mraid-MRAIDView, reason: not valid java name */
    /* synthetic */ void m9701lambda$setViewable$9$netpubnativelitesdkmraidMRAIDView(int i) {
        boolean z = i == 0;
        if (z == this.isViewable && this.isViewabilityConfirmed) {
            return;
        }
        this.isViewable = z;
        if (this.isPageFinished && this.isLaidOut) {
            fireViewableChangeEvent();
            fireExposureChangeEvent();
            this.isViewabilityConfirmed = true;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        String str = MRAID_LOG_TAG;
        MRAIDLog.w(str, "onLayout (" + this.state + ") " + z + " " + i + " " + i2 + " " + i3 + " " + i4);
        if (this.isForcingFullScreen) {
            MRAIDLog.d(str, "onLayout ignored");
            return;
        }
        int i5 = this.state;
        if (i5 == 2 || i5 == 3) {
            calculateScreenSize();
            calculateMaxSize();
        }
        if (this.isClosing) {
            this.isClosing = false;
            this.currentPosition = new Rect(this.defaultPosition);
            setCurrentPosition();
        } else {
            calculatePosition(false);
        }
        if (this.state == 3 && z) {
            this.handler.post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.setResizedViewPosition();
                }
            });
        }
        this.isLaidOut = true;
        onLayoutCompleted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLayoutWebView(WebView webView, boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = webView == this.currentWebView;
        String str = MRAID_LOG_TAG;
        MRAIDLog.w(str, "onLayoutWebView " + (webView == this.webView ? "1 " : "2 ") + z2 + " (" + this.state + ") " + z + " " + i + " " + i2 + " " + i3 + " " + i4);
        if (!z2) {
            MRAIDLog.d(str, "onLayoutWebView ignored, not current");
            return;
        }
        int i5 = this.state;
        if (i5 == 0 || i5 == 1) {
            calculateScreenSize();
            calculateMaxSize();
        }
        if (!this.isClosing) {
            calculatePosition(true);
            if (this.isInterstitial && !this.defaultPosition.equals(this.currentPosition)) {
                this.defaultPosition = new Rect(this.currentPosition);
                setDefaultPosition();
            }
        }
        if (this.isExpandingFromDefault) {
            this.isExpandingFromDefault = false;
            if (this.isInterstitial) {
                this.state = 1;
                this.isLaidOut = true;
            }
            if (!this.isExpandingPart2) {
                MRAIDLog.d(str, "calling fireStateChangeEvent 1");
                fireStateChangeEvent();
            }
            if (this.isInterstitial) {
                fireReadyEvent();
                setViewable(this.isViewable ? 0 : 8);
            }
            MRAIDViewListener mRAIDViewListener = this.listener;
            if (mRAIDViewListener != null) {
                mRAIDViewListener.mraidViewExpand(this);
            }
        }
    }

    private void calculateScreenSize() {
        boolean z = getResources().getConfiguration().orientation == 1;
        String str = MRAID_LOG_TAG;
        MRAIDLog.d(str, "calculateScreenSize orientation ".concat(z ? "portrait" : "landscape"));
        DisplayMetrics displayMetrics = this.displayMetrics;
        if (displayMetrics != null) {
            int i = displayMetrics.widthPixels;
            int i2 = this.displayMetrics.heightPixels;
            MRAIDLog.d(str, "calculateScreenSize screen size " + i + VastAttributes.HORIZONTAL_POSITION + i2);
            if (i == this.screenSize.width && i2 == this.screenSize.height) {
                return;
            }
            this.screenSize.width = i;
            this.screenSize.height = i2;
            if (this.isPageFinished) {
                setScreenSize();
            }
        }
    }

    private void calculateMaxSize() {
        if (this.context instanceof Activity) {
            Rect rect = new Rect();
            Window window = ((Activity) this.context).getWindow();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            String str = MRAID_LOG_TAG;
            MRAIDLog.d(str, "calculateMaxSize frame [" + rect.left + StringUtils.COMMA + rect.top + "][" + rect.right + StringUtils.COMMA + rect.bottom + "] (" + rect.width() + VastAttributes.HORIZONTAL_POSITION + rect.height() + ")");
            if (window.findViewById(android.R.id.content) != null) {
                this.contentViewTop = window.findViewById(android.R.id.content).getTop();
            } else {
                this.contentViewTop = rect.top;
            }
            int i = rect.top;
            int i2 = this.contentViewTop - i;
            MRAIDLog.d(str, "calculateMaxSize statusHeight " + i);
            MRAIDLog.d(str, "calculateMaxSize titleHeight " + i2);
            MRAIDLog.d(str, "calculateMaxSize contentViewTop " + this.contentViewTop);
            int iWidth = rect.width();
            int i3 = this.screenSize.height - this.contentViewTop;
            MRAIDLog.d(str, "calculateMaxSize max size " + iWidth + VastAttributes.HORIZONTAL_POSITION + i3);
            if (iWidth == this.maxSize.width && i3 == this.maxSize.height) {
                return;
            }
            this.maxSize.width = iWidth;
            this.maxSize.height = i3;
            if (this.isPageFinished) {
                setMaxSize();
            }
        }
    }

    private void calculatePosition(boolean z) {
        View view = z ? this.currentWebView : this;
        String str = z ? "current" : "default";
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        String str2 = MRAID_LOG_TAG;
        MRAIDLog.d(str2, "calculatePosition " + str + " locationOnScreen [" + i + StringUtils.COMMA + i2 + b9.i.e);
        MRAIDLog.d(str2, "calculatePosition " + str + " contentViewTop " + this.contentViewTop);
        int i3 = i2 - this.contentViewTop;
        int width = view.getWidth();
        int height = view.getHeight();
        MRAIDLog.d(str2, "calculatePosition " + str + " position [" + i + StringUtils.COMMA + i3 + "] (" + width + VastAttributes.HORIZONTAL_POSITION + height + ")");
        Rect rect = z ? this.currentPosition : this.defaultPosition;
        if (i == rect.left && i3 == rect.top && width == rect.width() && height == rect.height()) {
            return;
        }
        if (z) {
            this.currentPosition = new Rect(i, i3, width + i, height + i3);
        } else {
            this.defaultPosition = new Rect(i, i3, width + i, height + i3);
        }
        if (this.isPageFinished) {
            if (z) {
                setCurrentPosition();
            } else {
                setDefaultPosition();
            }
        }
    }

    private static String getOrientationString(int i) {
        if (i == -1) {
            return "UNSPECIFIED";
        }
        if (i == 0) {
            return "LANDSCAPE";
        }
        if (i == 1) {
            return "PORTRAIT";
        }
        return "UNKNOWN";
    }

    protected void applyOrientationProperties() {
        if (this.context instanceof Activity) {
            String str = MRAID_LOG_TAG;
            MRAIDLog.d(str, "applyOrientationProperties " + this.orientationProperties.allowOrientationChange + " " + this.orientationProperties.forceOrientationString());
            Activity activity = (Activity) this.context;
            int i = 0;
            int i2 = getResources().getConfiguration().orientation == 1 ? 1 : 0;
            MRAIDLog.d(str, "currentOrientation ".concat(i2 != 0 ? "portrait" : "landscape"));
            if (this.orientationProperties.forceOrientation == 0) {
                i = 1;
            } else if (this.orientationProperties.forceOrientation != 1) {
                i = this.orientationProperties.allowOrientationChange ? -1 : i2;
            }
            activity.setRequestedOrientation(i);
        }
    }

    private void setOrientationInitialState() {
        Context context = this.context;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).setRequestedOrientation(this.activityInitialOrientation);
    }

    private void restoreOriginalOrientation() {
        if (this.context instanceof Activity) {
            MRAIDLog.d(MRAID_LOG_TAG, "restoreOriginalOrientation");
            Activity activity = (Activity) this.context;
            int requestedOrientation = activity.getRequestedOrientation();
            int i = this.originalRequestedOrientation;
            if (requestedOrientation != i) {
                activity.setRequestedOrientation(i);
            }
        }
    }

    public void addViewabilityFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        if (this.mViewabilityFriendlyObstructions == null || view == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.mViewabilityFriendlyObstructions.add(new HyBidViewabilityFriendlyObstruction(view, friendlyObstructionPurpose, str));
    }

    public void setSkipOffset(Integer num) {
        this.mSkipTimeMillis = Integer.valueOf(num.intValue() * 1000);
    }

    public void setNativeCloseButtonDelay(Integer num) {
        this.mNativeCloseButtonDelay = Integer.valueOf(num.intValue() * 1000);
    }

    public void setIsLandingPageEnabled(boolean z) {
        this.isLandingPageEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSkipTimer() {
        Integer num;
        if (hasLandingPage()) {
            if (this.landingPageDelay.intValue() >= 1000) {
                this.landingPageDelay = Integer.valueOf(this.landingPageDelay.intValue() - 1000);
            }
            num = this.landingPageDelay;
            this.mNativeCloseButtonDelay = num;
            handleNativeCloseButtonDelay();
            this.useCustomClose = false;
            this.mSkipTimeMillis = this.landingPageDelay;
            CountDownView countDownView = this.mSkipCountdownView;
            if (countDownView != null) {
                countDownView.setVisibility(4);
            }
        } else if (this.useCustomClose) {
            handleNativeCloseButtonDelay();
            num = this.mNativeCloseButtonDelay;
            CountDownView countDownView2 = this.mSkipCountdownView;
            if (countDownView2 != null) {
                countDownView2.setVisibility(8);
            }
        } else {
            num = this.mSkipTimeMillis;
            CountDownView countDownView3 = this.mSkipCountdownView;
            if (countDownView3 != null) {
                countDownView3.setVisibility(0);
            }
        }
        if (num.intValue() > 0 && this.showTimerBeforeEndCard.booleanValue()) {
            SimpleTimer simpleTimer = new SimpleTimer(num.intValue(), new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.5
                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onFinish() {
                    MRAIDView.this.listener.mraidShowCloseButton();
                    MRAIDView.this.isBackClickable = true;
                    if (MRAIDView.this.mSkipCountdownView != null) {
                        MRAIDView.this.mSkipCountdownView.setVisibility(8);
                    }
                }

                @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
                public void onTick(long j) {
                    if (MRAIDView.this.mSkipCountdownView != null) {
                        MRAIDView.this.mSkipCountdownView.setProgress((int) (((long) MRAIDView.this.mSkipTimeMillis.intValue()) - j), MRAIDView.this.mSkipTimeMillis.intValue());
                    }
                }
            }, 10L);
            this.mExpirationTimer = simpleTimer;
            simpleTimer.start();
        } else if (num.intValue() == 0) {
            this.listener.mraidShowCloseButton();
            this.isBackClickable = true;
        }
    }

    public void pause() {
        SimpleTimer simpleTimer = this.mExpirationTimer;
        if (simpleTimer != null) {
            simpleTimer.pause();
        }
        SimpleTimer simpleTimer2 = this.mNativeCloseButtonTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.pause();
        }
        SimpleTimer simpleTimer3 = this.mAntilockTimer;
        if (simpleTimer3 != null) {
            simpleTimer3.pause();
        }
    }

    public void resume() {
        SimpleTimer simpleTimer = this.mExpirationTimer;
        if (simpleTimer != null) {
            simpleTimer.resume();
        }
        SimpleTimer simpleTimer2 = this.mNativeCloseButtonTimer;
        if (simpleTimer2 != null) {
            simpleTimer2.resume();
        }
        SimpleTimer simpleTimer3 = this.mAntilockTimer;
        if (simpleTimer3 != null) {
            simpleTimer3.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeOnMainThread() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.close();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetCustomisationInjection() {
        this.webView.evaluateJavascript(this.setCustomisationString, null);
    }

    private void handleLandingPageBehavior() {
        String str = this.landingBehaviourString;
        if (str != null) {
            str.hashCode();
            switch (str) {
                case "c":
                    CountDownView countDownView = this.mSkipCountdownView;
                    if (countDownView != null) {
                        countDownView.setVisibility(0);
                        break;
                    }
                    break;
                case "ic":
                    cancelLandingPageBehaviour();
                    break;
                case "nc":
                    CountDownView countDownView2 = this.mSkipCountdownView;
                    if (countDownView2 != null) {
                        countDownView2.setVisibility(8);
                        break;
                    }
                    break;
            }
        }
        CountDownView countDownView3 = this.mSkipCountdownView;
        if (countDownView3 != null) {
            countDownView3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelLandingPageBehaviour() {
        CountDownView countDownView = this.mSkipCountdownView;
        if (countDownView != null) {
            countDownView.setVisibility(8);
            this.mSkipCountdownView = null;
        }
        postDelayed(new Runnable() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showClose();
            }
        }, 600L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showClose() {
        SimpleTimer simpleTimer = this.mNativeCloseButtonTimer;
        if (simpleTimer != null) {
            simpleTimer.onFinish();
            this.mNativeCloseButtonTimer = null;
        }
        MRAIDViewListener mRAIDViewListener = this.listener;
        if (mRAIDViewListener != null) {
            mRAIDViewListener.mraidShowCloseButton();
        }
        showDefaultCloseButton();
        this.isBackClickable = true;
    }

    private void validateDelay() {
        if (this.landingPageDelay.intValue() < 0 || this.landingPageDelay.intValue() > 30000) {
            this.landingPageDelay = 30000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasLandingPage() {
        String str;
        return (!this.isLandingPageEnabled || (str = this.setCustomisationString) == null || str.isEmpty()) ? false : true;
    }

    private void handleAntilockDelay() {
        SimpleTimer simpleTimer = new SimpleTimer(5000, new SimpleTimer.Listener() { // from class: net.pubnative.lite.sdk.mraid.MRAIDView.6
            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onTick(long j) {
            }

            @Override // net.pubnative.lite.sdk.vpaid.helpers.SimpleTimer.Listener
            public void onFinish() {
                if (MRAIDView.this.listener != null) {
                    MRAIDView.this.listener.mraidShowCloseButton();
                }
                MRAIDView.this.showDefaultCloseButton();
                MRAIDView.this.isBackClickable = true;
            }
        }, 1000L);
        this.mAntilockTimer = simpleTimer;
        simpleTimer.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAntilockTimer() {
        SimpleTimer simpleTimer = this.mAntilockTimer;
        if (simpleTimer != null) {
            simpleTimer.pause();
            this.mAntilockTimer.cancel();
            this.mAntilockTimer = null;
        }
    }
}

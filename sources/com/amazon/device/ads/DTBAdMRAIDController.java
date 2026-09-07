package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.aps.ads.R;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.ktx.BuildConfig;
import com.iab.omid.library.amazon.adsession.FriendlyObstructionPurpose;
import com.json.b9;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import com.smaato.sdk.richmedia.mraid.bridge.MraidJsMethods;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public abstract class DTBAdMRAIDController implements DTBActivityListener {
    static final String LOG_TAG = "DTBAdMRAIDController";
    public static final String MRAID_CLOSE = "window.mraid.close();";
    private static final String MRAID_READY = "window.mraidBridge.event.ready();";
    DTBAdView adView;
    LinearLayout closeIndicatorRegion;
    DTBMRAIDCloseButtonListener customButtonListener;
    private DtbOmSdkSessionManager dtbOmSdkSessionManager;
    private Rect lastRect;
    private MraidExposure lastReportedExposure;
    private Boolean lastViewabilityState;
    private boolean loadReportSubmitted;
    boolean pageLoaded = false;
    protected boolean useCustomClose = false;
    private int lastReportedSizeChangeWidth = -1;
    private int lastReportedSizeChangeHeight = -1;
    protected MraidStateType state = MraidStateType.LOADING;
    private boolean jsReady = false;
    private boolean isTwoPartExpand = false;

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    public static void safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(Context p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/content/Context;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    public static void safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(CustomTabsIntent p0, Context p1, Uri p2) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroidx/browser/customtabs/CustomTabsIntent;->launchUrl(Landroid/content/Context;Landroid/net/Uri;)V");
        if (p2 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p2, h.A);
        p0.launchUrl(p1, p2);
    }

    void closeExpandedPartTwo() {
    }

    protected abstract void expand(Map<String, Object> map);

    @Override // com.amazon.device.ads.DTBActivityListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.amazon.device.ads.DTBActivityListener
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.amazon.device.ads.DTBActivityListener
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.amazon.device.ads.DTBActivityListener
    public void onActivityStopped(Activity activity) {
    }

    public void onAdClicked() {
    }

    public void onAdFailedToLoad() {
    }

    public abstract void onAdLeftApplication();

    public void onAdLoaded() {
    }

    public void onAdOpened() {
    }

    public void onAdRemoved() {
    }

    protected abstract void onMRAIDClose();

    public abstract void onPageLoad();

    protected abstract void onResize(Map<String, Object> map);

    public void onVideoCompleted() {
    }

    void passLoadError() {
    }

    public void startEndCardDisplayOMSDKSession() {
    }

    public void startOMSDKSession() {
    }

    public void stopOMSDKSession() {
    }

    static {
        MraidCommand.registerCommand(MraidOpenCommand.getMraidName(), MraidOpenCommand.class);
        MraidCommand.registerCommand(MraidCloseCommand.getMraidName(), MraidCloseCommand.class);
        MraidCommand.registerCommand(MraidUnloadCommand.getMraidName(), MraidUnloadCommand.class);
        MraidCommand.registerCommand(MraidResizeCommand.getMraidName(), MraidResizeCommand.class);
        MraidCommand.registerCommand(MraidExpandCommand.getMraidName(), MraidExpandCommand.class);
        MraidCommand.registerCommand(MraidUseCustomCloseCommand.getMraidName(), MraidUseCustomCloseCommand.class);
        MraidCommand.registerCommand(MraidJSReadyCommand.getMraidName(), MraidJSReadyCommand.class);
        MraidCommand.registerCommand(MraidFirePixelCommand.getMraidName(), MraidFirePixelCommand.class);
    }

    protected DTBAdView getAdView() {
        return this.adView;
    }

    public void cleanup() {
        this.closeIndicatorRegion = null;
        this.adView = null;
        this.customButtonListener = null;
    }

    public void setCustomButtonListener(DTBMRAIDCloseButtonListener dTBMRAIDCloseButtonListener) {
        this.customButtonListener = dTBMRAIDCloseButtonListener;
    }

    public boolean isUseCustomClose() {
        return this.useCustomClose;
    }

    protected DTBAdMRAIDController(DTBAdView dTBAdView) {
        this.adView = dTBAdView;
        this.dtbOmSdkSessionManager = dTBAdView.getOmSdkManager();
    }

    public DtbOmSdkSessionManager getDtbOmSdkSessionManager() {
        return this.dtbOmSdkSessionManager;
    }

    public void setUseCustomClose(boolean z) {
        DtbLog.debug("Set useCustomClose to " + z);
        this.useCustomClose = z;
        commandCompleted(MraidJsMethods.USE_CUSTOM_CLOSE);
        DTBMRAIDCloseButtonListener dTBMRAIDCloseButtonListener = this.customButtonListener;
        if (dTBMRAIDCloseButtonListener != null) {
            dTBMRAIDCloseButtonListener.useCustomButtonUpdated();
        }
    }

    void onLoadError(String str, int i) {
        onLoadError();
    }

    public void onLoadError() {
        String bidId = this.adView.getBidId();
        String hostname = this.adView.getHostname();
        if (bidId != null) {
            DTBMetricsProcessor.getInstance().submitSimpleReportBidId(DTBMetricReport.addBid(bidId, hostname), DTBMetricsProcessor.REPORT_LOAD_FAILURE);
        }
        passLoadError();
    }

    protected String getPlacementType() {
        return "";
    }

    protected void createLoadReport() {
        String bidId = this.adView.getBidId();
        String hostname = this.adView.getHostname();
        if (bidId == null || this.loadReportSubmitted) {
            return;
        }
        DTBMetricsProcessor.getInstance().submitLatencyReportBidId(DTBMetricReport.addBid(bidId, hostname), DTBMetricsProcessor.REPORT_LOAD_LATENCY, (int) (new Date().getTime() - this.adView.getStartTime()));
        this.loadReportSubmitted = true;
    }

    void prepareMraid() throws JSONException {
        createLoadReport();
        this.pageLoaded = true;
        fireMaxSizeEvent();
        fireScreenSizeEvent();
        if (getAdView().getIsAdViewVisible()) {
            setCurrentPositionProperty();
        }
        fireMRAIDSupports();
        firePlacementType();
        setCurrentAppOrientation();
        setState(getInitialStateType());
        fireMRAIDReadyEvent();
        if (AdRegistration.isTestMode()) {
            evaluateJavascript("window.mraidBridge.service.debug('enable');");
        }
    }

    protected MraidStateType getInitialStateType() {
        return MraidStateType.DEFAULT;
    }

    private JSONObject formProperties(MraidProperty[] mraidPropertyArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (MraidProperty mraidProperty : mraidPropertyArr) {
            mraidProperty.formJSON(jSONObject);
        }
        return jSONObject;
    }

    protected void setCurrentAppOrientation() throws JSONException {
        String str;
        int iDetermineSimpleOrientation = DisplayUtils.determineSimpleOrientation();
        if (iDetermineSimpleOrientation == 1) {
            str = "portrait";
        } else if (iDetermineSimpleOrientation == 2) {
            str = "landscape";
        } else {
            str = BuildConfig.VERSION_NAME;
        }
        boolean zIsRotationLocked = DisplayUtils.isRotationLocked();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("orientation", str);
        jSONObject.put("locked", zIsRotationLocked);
        evaluateJavascriptMethod("window.mraidBridge.property.setCurrentAppOrientation", jSONObject);
    }

    Context getContext() {
        return getAdView().getContext();
    }

    public void setCurrentPositionProperty() {
        if (this.pageLoaded) {
            int[] iArr = new int[2];
            getAdView().getLocationOnScreen(iArr);
            setCurrentPositionProperty(iArr[0], iArr[1], getAdView().getWidth(), getAdView().getHeight());
        }
    }

    void setCurrentPositionProperty(float f, float f2) {
        if (this.pageLoaded) {
            int[] iArr = new int[2];
            getAdView().getLocationOnScreen(iArr);
            setCurrentPositionProperty(iArr[0], iArr[1], f, f2);
        }
    }

    void setCurrentPositionProperty(int i, int i2, float f, float f2) {
        if (this.pageLoaded) {
            evaluateJavascript(String.format("window.mraidBridge.property.setCurrentPosition({'xPos':%.1f, 'yPos':%.1f, 'width': %.1f, 'height': %.1f});", Float.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(i)), Float.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(i2)), Float.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels((int) f)), Float.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels((int) f2))));
        }
    }

    private void fireMaxSizeEvent() {
        SDKUtilities.SimpleSize maxSize = DTBAdUtil.getMaxSize(getAdView());
        evaluateJavascript(String.format("window.mraidBridge.property.setMaxSize({'width':%d, 'height':%d});", Integer.valueOf(maxSize.getWidth()), Integer.valueOf(maxSize.getHeight())));
    }

    void fireScreenSizeEvent() {
        SDKUtilities.SimpleSize screenSize = DTBAdUtil.getScreenSize(getAdView());
        evaluateJavascript(String.format("window.mraidBridge.property.setScreenSize({'width':%d, 'height':%d});", Integer.valueOf(screenSize.getWidth()), Integer.valueOf(screenSize.getHeight())));
    }

    void fireViewableChange(boolean z) {
        Boolean bool = this.lastViewabilityState;
        if (bool == null || bool.booleanValue() != z) {
            if (this.jsReady) {
                fireEnforcedViewableChange(z);
            }
            this.lastViewabilityState = Boolean.valueOf(z);
        }
    }

    void fireEnforcedViewableChange(boolean z) {
        evaluateJavascript(String.format("window.mraidBridge.event.viewableChange(%s);", z ? "true" : "false"));
    }

    protected void firePlacementType() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", getPlacementType());
        evaluateJavascriptMethod("window.mraidBridge.property.setPlacementType", jSONObject);
    }

    protected void fireMRAIDSupports() {
        evaluateJavascriptMethod("window.mraidBridge.property.setSupports", MraidProperty.SUPPORTS_PROPERTY.getData());
    }

    public void fireErrorEvent(String str, String str2) {
        evaluateJavascript(String.format("window.mraidBridge.event.error('%s','%s');", str2, str));
    }

    private void evaluateJavascriptMethod(String str, JSONObject jSONObject) {
        evaluateJavascript(String.format(str + "(%s);", jSONObject.toString()));
    }

    protected void evaluateJavascript(final String str) {
        DtbLog.debug(LOG_TAG, "MRAID Evaluate JSScript:" + str);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4398xbe1b85ea(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$evaluateJavascript$0$com-amazon-device-ads-DTBAdMRAIDController, reason: not valid java name */
    /* synthetic */ void m4398xbe1b85ea(final String str) {
        if (getAdView() != null) {
            getAdView().evaluateJavascript(str, new ValueCallback<String>() { // from class: com.amazon.device.ads.DTBAdMRAIDController.1
                @Override // android.webkit.ValueCallback
                public void onReceiveValue(String str2) {
                    if (str2 == null || "null".equals(str2)) {
                        return;
                    }
                    DtbLog.debug(DTBAdMRAIDController.LOG_TAG, "Value received:" + str2 + " for script " + str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.amazon.device.ads.DTBAdMRAIDController$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$amazon$device$ads$MraidStateType;

        static {
            int[] iArr = new int[MraidStateType.values().length];
            $SwitchMap$com$amazon$device$ads$MraidStateType = iArr;
            try {
                iArr[MraidStateType.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MraidStateType[MraidStateType.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MraidStateType[MraidStateType.RESIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MraidStateType[MraidStateType.EXPANDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$amazon$device$ads$MraidStateType[MraidStateType.HIDDEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private MraidProperty getCurrentStateProperty() {
        int i = AnonymousClass2.$SwitchMap$com$amazon$device$ads$MraidStateType[this.state.ordinal()];
        if (i == 1) {
            return MraidProperty.STATE_LOADING_PROPERTY;
        }
        if (i == 2) {
            return MraidProperty.STATE_DEFAULT_PROPERTY;
        }
        if (i == 3) {
            return MraidProperty.STATE_RESIZED_PROPERTY;
        }
        if (i == 4) {
            return MraidProperty.STATE_EXPANDED_PROPERTY;
        }
        if (i == 5) {
            return MraidProperty.STATE_HIDDEN_PROPERTY;
        }
        return MraidProperty.STATE_DEFAULT_PROPERTY;
    }

    void fireStateChangeEvent() {
        try {
            JSONObject jSONObjectFormProperties = formProperties(new MraidProperty[]{getCurrentStateProperty()});
            DtbLog.debug(LOG_TAG, "State was changed to " + jSONObjectFormProperties.toString() + " for controller " + this);
            evaluateJavascript(String.format("window.mraidBridge.event.stateChange(%s);", jSONObjectFormProperties.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    class MraidExposure {
        int percent;
        Rect rect;

        MraidExposure(int i, Rect rect) {
            this.percent = i;
            this.rect = new Rect(rect);
        }
    }

    public void fireExposureChange(int i, Rect rect) {
        int i2 = rect.right;
        int i3 = rect.left;
        int i4 = rect.bottom;
        int i5 = rect.top;
        if (this.jsReady) {
            fireEnforcedExposureChange(i, rect);
        } else {
            this.lastReportedExposure = new MraidExposure(i, rect);
        }
    }

    private void fireEnforcedExposureChange(int i, Rect rect) {
        evaluateJavascript(String.format("window.mraidBridge.event.exposureChange(%d, { x:%d, y:%d, width:%d, height: %d}, null);", Integer.valueOf(i), Integer.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(rect.left)), Integer.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(rect.top)), Integer.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(rect.right - rect.left)), Integer.valueOf(DTBAdUtil.pixelsToDeviceIndependenPixels(rect.bottom - rect.top))));
    }

    void fireSizeChange(int i, int i2) {
        if (this.lastReportedSizeChangeWidth == i && this.lastReportedSizeChangeHeight == i2) {
            return;
        }
        this.lastReportedSizeChangeWidth = i;
        this.lastReportedSizeChangeHeight = i2;
        if (this.jsReady) {
            fireEnforcedSizeChange(i, i2);
        }
    }

    void fireEnforcedSizeChange(int i, int i2) {
        evaluateJavascript(String.format("window.mraidBridge.event.sizeChange(%d, %d);", Integer.valueOf(i), Integer.valueOf(i2)));
    }

    void fireMRAIDReadyEvent() {
        evaluateJavascript(MRAID_READY);
    }

    public void onPositionChanged(Rect rect) {
        Rect rect2 = this.lastRect;
        if (rect2 == null || !rect2.equals(rect)) {
            int i = rect.right - rect.left;
            int i2 = rect.bottom - rect.top;
            Rect rect3 = this.lastRect;
            boolean z = true;
            if (rect3 != null) {
                int i3 = rect3.right - this.lastRect.left;
                int i4 = this.lastRect.bottom - this.lastRect.top;
                if (Math.abs(i3 - i) <= 1 && Math.abs(i4 - i2) <= 1) {
                    z = false;
                }
            }
            setCurrentPositionProperty();
            if (z) {
                fireSizeChange(DTBAdUtil.pixelsToDeviceIndependenPixels(i), DTBAdUtil.pixelsToDeviceIndependenPixels(i2));
            }
            this.lastRect = rect;
        }
    }

    void setState(MraidStateType mraidStateType) {
        this.state = mraidStateType;
        if (mraidStateType == MraidStateType.HIDDEN) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDController$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m4401lambda$setState$1$comamazondeviceadsDTBAdMRAIDController();
                }
            });
        }
        fireStateChangeEvent();
    }

    /* JADX INFO: renamed from: lambda$setState$1$com-amazon-device-ads-DTBAdMRAIDController, reason: not valid java name */
    /* synthetic */ void m4401lambda$setState$1$comamazondeviceadsDTBAdMRAIDController() {
        DTBAdView adView = getAdView();
        if (adView != null) {
            adView.setVisibility(8);
        }
    }

    protected void onMRAIDUnload() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.ads.DTBAdMRAIDController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m4399xd4333b11();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onMRAIDUnload$2$com-amazon-device-ads-DTBAdMRAIDController, reason: not valid java name */
    /* synthetic */ void m4399xd4333b11() {
        AmazonPublisherServicesNetworkBridge.webviewLoadUrl(getAdView(), AndroidWebViewClient.BLANK_PAGE);
    }

    public void commandCompleted(String str) {
        evaluateJavascript(String.format("window.mraidBridge.service.acknowledgement('%s');", str));
    }

    void openUrl(String str) {
        openUrl(str, false);
    }

    void openUrl(String str, boolean z) {
        PackageManager packageManager = this.adView.getContext().getPackageManager();
        try {
            Uri uri = Uri.parse(str);
            if ("amazonmobile".equals(uri.getScheme()) && uri.getHost().equals(SDKConstants.PARAM_INTENT)) {
                String[] strArrSplit = str.split("intent=");
                if (strArrSplit.length > 1) {
                    String strDecode = null;
                    for (int i = 1; i < strArrSplit.length; i++) {
                        try {
                            String strSubstring = strArrSplit[i];
                            if (strSubstring.lastIndexOf(b9.i.c) == strSubstring.length() - 1) {
                                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                            }
                            strDecode = URLDecoder.decode(strSubstring, "UTF-8");
                            safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(strDecode)));
                            onAdLeftApplication();
                            break;
                        } catch (ActivityNotFoundException unused) {
                            DtbLog.debug("Intent:" + strDecode + " not found.");
                            fireErrorEvent("open", "requested activity not found");
                        } catch (UnsupportedEncodingException unused2) {
                            DtbLog.debug("Unsupported encoding");
                        }
                    }
                }
            } else if (ApsAdWebViewSupportClient.MOBILE_SHOPPING_SCHEME.equals(uri.getScheme())) {
                try {
                    if (packageManager.getLaunchIntentForPackage("com.amazon.mShop.android.shopping") != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(uri);
                        safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(AdRegistration.getCurrentActivity(), intent);
                    } else {
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setData(uri);
                        int iIndexOf = str.indexOf("products/");
                        if (iIndexOf > 0) {
                            intent2.setData(Uri.parse("https://www.amazon.com/dp/" + str.substring(iIndexOf + "products/".length())));
                            safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(AdRegistration.getCurrentActivity(), intent2);
                        }
                    }
                    onAdLeftApplication();
                } catch (ActivityNotFoundException unused3) {
                    DtbLog.debug(LOG_TAG, "Activity not found com.amazon.mobile.shopping");
                    fireErrorEvent("open", "mshop activity not found");
                } catch (NullPointerException unused4) {
                    DtbLog.debug(LOG_TAG, "Current activity from AdRegistration not found");
                    fireErrorEvent("open", "current activity from AdRegistration not found");
                }
            } else if (ApsAdWebViewSupportClient.MARKET_SCHEME.equals(uri.getScheme()) || ApsAdWebViewSupportClient.AMAZON_SCHEME.equals(uri.getScheme())) {
                try {
                    try {
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setData(uri);
                        safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(AdRegistration.getCurrentActivity(), intent3);
                        onAdLeftApplication();
                    } catch (ActivityNotFoundException unused5) {
                        DTBAdUtil.directAppStoreLinkToBrowser(this, uri);
                    } catch (NullPointerException unused6) {
                        DtbLog.debug(LOG_TAG, "Current activity from AdRegistration not found");
                        fireErrorEvent("open", "current activity from AdRegistration not found");
                    }
                } catch (ActivityNotFoundException unused7) {
                    DtbLog.debug(LOG_TAG, "App stores and browsers not found");
                    fireErrorEvent("open", "app stores and browsers not found");
                } catch (NullPointerException unused8) {
                    DtbLog.debug(LOG_TAG, "Current activity from AdRegistration not found");
                    fireErrorEvent("open", "current activity from AdRegistration not found");
                }
            } else {
                if (uri.getScheme() == null) {
                    uri = Uri.parse("https:" + str);
                }
                if (z) {
                    try {
                        safedk_CustomTabsIntent_launchUrl_46a735ad316dd66561bc1347435a4f91(new CustomTabsIntent.Builder().build(), getContext(), uri);
                        onAdLeftApplication();
                    } catch (Exception e) {
                        String str2 = "Failed to execute open command: invalid url " + str;
                        fireErrorEvent("open", str2);
                        APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, str2, e);
                    }
                } else {
                    try {
                        Intent intent4 = new Intent("android.intent.action.VIEW", uri);
                        intent4.addFlags(268435456);
                        safedk_Context_startActivity_97cb3195734cf5c9cc3418feeafa6dd6(getContext(), intent4);
                        onAdLeftApplication();
                    } catch (Exception e2) {
                        String str3 = "Failed to execute open command: invalid url " + str;
                        fireErrorEvent("open", str3);
                        APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, str3, e2);
                    }
                }
            }
            commandCompleted("open");
        } catch (Exception unused9) {
            fireErrorEvent("open", "invalid url " + str);
            commandCompleted("open");
        }
    }

    protected void removeCloseIndicator() {
        ViewGroup viewGroup;
        LinearLayout linearLayout = this.closeIndicatorRegion;
        if (linearLayout == null || (viewGroup = (ViewGroup) linearLayout.getParent()) == null) {
            return;
        }
        viewGroup.removeView(this.closeIndicatorRegion);
    }

    void addCloseIndicator(int i, int i2) {
        removeCloseIndicator();
        addCloseIndicator(i, i2, false);
    }

    protected void addCloseIndicator(int i, int i2, boolean z) {
        removeCloseIndicator();
        addCloseIndicator(i, i2, null, z);
    }

    protected void setCloseIndicatorContent(View.OnTouchListener onTouchListener) {
        this.closeIndicatorRegion.setBackgroundColor(0);
        this.closeIndicatorRegion.setId(R.id.mraid_close_indicator);
        ImageView imageView = new ImageView(getAdView().getContext());
        imageView.setId(R.id.mraid_close_indicator);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DTBAdUtil.sizeToDevicePixels(24), DTBAdUtil.sizeToDevicePixels(24));
        layoutParams.setMargins(DTBAdUtil.sizeToDevicePixels(14), DTBAdUtil.sizeToDevicePixels(14), 0, 0);
        this.closeIndicatorRegion.addView(imageView, layoutParams);
        if (getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().addFriendlyObstruction(this.closeIndicatorRegion.findViewById(R.id.mraid_close_indicator), FriendlyObstructionPurpose.CLOSE_AD);
        }
        imageView.setImageDrawable(AppCompatResources.getDrawable(getAdView().getContext(), R.drawable.mraid_close));
        if (onTouchListener != null) {
            this.closeIndicatorRegion.setOnTouchListener(onTouchListener);
        } else {
            this.closeIndicatorRegion.setOnTouchListener(new View.OnTouchListener() { // from class: com.amazon.device.ads.DTBAdMRAIDController$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.f$0.m4400x15d656ad(view, motionEvent);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$setCloseIndicatorContent$3$com-amazon-device-ads-DTBAdMRAIDController, reason: not valid java name */
    /* synthetic */ boolean m4400x15d656ad(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return true;
        }
        evaluateJavascript(MRAID_CLOSE);
        ((ViewGroup) view.getParent()).removeView(view);
        this.closeIndicatorRegion = null;
        return true;
    }

    protected void createContentIndicator() {
        LinearLayout linearLayout = new LinearLayout(getAdView().getContext());
        this.closeIndicatorRegion = linearLayout;
        linearLayout.setVisibility(this.useCustomClose ? 4 : 0);
        this.closeIndicatorRegion.setOrientation(1);
    }

    protected void addCloseIndicator(int i, int i2, View.OnTouchListener onTouchListener, boolean z) {
        createContentIndicator();
        DTBAdUtil.getRootView(getAdView()).addView(this.closeIndicatorRegion, DTBAdUtil.sizeToDevicePixels(50), DTBAdUtil.sizeToDevicePixels(50));
        this.closeIndicatorRegion.setX(i - DTBAdUtil.sizeToDevicePixels(50));
        this.closeIndicatorRegion.setY(i2);
        setCloseIndicatorContent(onTouchListener);
    }

    public boolean isTwoPartExpand() {
        return this.isTwoPartExpand;
    }

    void setTwoPartExpand(boolean z) {
        this.isTwoPartExpand = z;
    }

    void jsReady() {
        int i;
        commandCompleted("jsready");
        this.jsReady = true;
        Boolean bool = this.lastViewabilityState;
        if (bool != null) {
            fireEnforcedViewableChange(bool.booleanValue());
        }
        MraidExposure mraidExposure = this.lastReportedExposure;
        if (mraidExposure != null) {
            fireEnforcedExposureChange(mraidExposure.percent, this.lastReportedExposure.rect);
        }
        int i2 = this.lastReportedSizeChangeWidth;
        if (i2 <= 0 || (i = this.lastReportedSizeChangeHeight) <= 0) {
            return;
        }
        fireEnforcedSizeChange(i2, i);
    }

    public void onViewabilityChanged(boolean z) {
        DtbLog.debug("SET MRAID Visible " + z);
        fireViewableChange(z);
    }

    public void impressionFired() {
        if (!getAdView().getIsVideo() && getDtbOmSdkSessionManager() != null) {
            getDtbOmSdkSessionManager().impressionOccured();
        }
        commandCompleted(MraidFirePixelCommand.getMraidName());
    }
}

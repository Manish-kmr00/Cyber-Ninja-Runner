package com.amazon.device.ads;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amazon.aps.ads.util.adview.ApsAdWebViewSupportClient;
import com.amazon.aps.shared.APSAnalytics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.h;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DTBAdUtil {
    private static final String CUSTOM_EVENT = "amazon_custom_event";
    public static final DTBAdUtil INSTANCE = new DTBAdUtil();
    static final String LOG_TAG = "DTBAdUtil";

    public static void safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(Activity p0, Intent p1) {
        Logger.d("SafeDK-Special|SafeDK: Call> Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V");
        if (p1 == null) {
            return;
        }
        BrandSafetyUtils.detectAdClick(p1, h.A);
        p0.startActivity(p1);
    }

    private DTBAdUtil() {
    }

    public AdManagerAdRequest loadDTBParams(AdManagerAdRequest adManagerAdRequest, DTBAdResponse dTBAdResponse) {
        if (dTBAdResponse.getAdCount() == 0) {
            return adManagerAdRequest;
        }
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        builder.setContentUrl(adManagerAdRequest.getContentUrl());
        builder.setLocation(adManagerAdRequest.getLocation());
        builder.setPublisherProvidedId(adManagerAdRequest.getPublisherProvidedId());
        loadDTBParameters(dTBAdResponse, builder);
        return builder.build();
    }

    public void loadDTBParams(AdManagerAdRequest.Builder builder, DTBAdResponse dTBAdResponse) {
        if (dTBAdResponse.getAdCount() > 0) {
            loadDTBParameters(dTBAdResponse, builder);
        }
    }

    public AdManagerAdRequest.Builder createAdManagerAdRequestBuilder(DTBAdResponse dTBAdResponse) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        if (dTBAdResponse.getAdCount() > 0) {
            loadDTBParameters(dTBAdResponse, builder);
        }
        return builder;
    }

    private void loadDTBParameters(DTBAdResponse dTBAdResponse, AdManagerAdRequest.Builder builder) {
        for (Map.Entry<String, List<String>> entry : (dTBAdResponse.isVideo() ? dTBAdResponse.getVideoAdsRequestCustomParamsAsList() : dTBAdResponse.getDefaultDisplayAdsRequestCustomParams()).entrySet()) {
            builder.addCustomTargeting(entry.getKey(), entry.getValue());
        }
    }

    public static List<View> findViewsOfType(ViewGroup viewGroup, Class cls) {
        ArrayList arrayList = new ArrayList();
        findViewsOfType(viewGroup, cls, arrayList);
        return arrayList;
    }

    public static View findAncestorOfType(View view, Class cls) {
        while (!cls.isInstance(view)) {
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return view;
    }

    static void findViewsOfType(ViewGroup viewGroup, Class cls, List<View> list) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                list.add(childAt);
            }
            if (childAt instanceof ViewGroup) {
                findViewsOfType((ViewGroup) childAt, cls, list);
            }
        }
    }

    public static String buildMopubTargeting(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append(StringUtils.COMMA).append(entry.getKey()).append(AbstractJsonLexerKt.COLON).append(entry.getValue());
            }
        }
        DtbLog.debug(LOG_TAG, "Targeting String:" + sb.toString());
        return sb.toString();
    }

    static boolean isInstalledFromAppStore(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null && installerPackageName.length() > 0;
    }

    public static Activity getActivity(View view) {
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static int sizeToDevicePixels(int i) {
        try {
            return (int) ((i * AdRegistration.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to convert size into device pixel", e);
            return 0;
        }
    }

    static int sizeToDevicePixels(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int pixelsToDeviceIndependenPixels(int i) {
        try {
            return (int) ((i / AdRegistration.getContext().getResources().getDisplayMetrics().density) + 0.5f);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to convert device pixel into device independent pixel", e);
            return 0;
        }
    }

    public static ViewGroup getRootView(View view) {
        Activity activity = getActivity(view);
        if (activity == null) {
            return null;
        }
        return (ViewGroup) activity.findViewById(R.id.content);
    }

    static SDKUtilities.SimpleSize getMaxSize(View view) {
        ViewGroup rootView = getRootView(view);
        if (rootView == null) {
            return getScreenSize();
        }
        return new SDKUtilities.SimpleSize(pixelsToDeviceIndependenPixels(rootView.getWidth()), pixelsToDeviceIndependenPixels(rootView.getHeight()));
    }

    public static SDKUtilities.SimpleSize getScreenSize() {
        return getScreenSize(null);
    }

    public static SDKUtilities.SimpleSize getScreenSize(View view) {
        int i;
        int i2;
        int i3 = AdRegistration.getContext().getResources().getConfiguration().orientation;
        Activity activity = view != null ? getActivity(view) : null;
        if (activity != null) {
            Point point = new Point();
            activity.getWindowManager().getDefaultDisplay().getRealSize(point);
            i2 = point.x;
            i = point.y;
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) AdRegistration.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i4 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
            i2 = i4;
        }
        int iPixelsToDeviceIndependenPixels = pixelsToDeviceIndependenPixels(i2);
        int iPixelsToDeviceIndependenPixels2 = pixelsToDeviceIndependenPixels(i);
        if (i3 == 1) {
            return new SDKUtilities.SimpleSize(iPixelsToDeviceIndependenPixels, iPixelsToDeviceIndependenPixels2);
        }
        return new SDKUtilities.SimpleSize(iPixelsToDeviceIndependenPixels2, iPixelsToDeviceIndependenPixels);
    }

    public static void setRectShape(View view) {
        setRectShape(view, -16711936, 3.0f);
    }

    public static void setRectShape(View view, int i, float f) {
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setStrokeWidth(f);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        view.setBackground(shapeDrawable);
    }

    public static Bundle getBidFromFetchManager(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        DtbLog.debug("RELOAD CUSTOM EVENT", "NO QUEUE");
        return bundle;
    }

    public static boolean validateAdMobCustomEvent(String str, Bundle bundle) {
        DtbLog.debug(CUSTOM_EVENT, "AdMob Server Price Point is checked in:" + str + "in AdMob Single Price Custom Event Class");
        return validateAdMobCustomEvent(str, bundle, false);
    }

    public static boolean validateSinglePriceAdMobCustomEvent(String str, Bundle bundle) {
        DtbLog.debug(CUSTOM_EVENT, "AdMob Server Price Point is checked in:" + str + "in AdMob Custom Event Class");
        return validateAdMobCustomEvent(str, bundle, true);
    }

    private static boolean validateAdMobCustomEvent(String str, Bundle bundle, boolean z) {
        String str2;
        boolean zEquals;
        if (z) {
            str2 = "Amazon Single Price Custom Event";
        } else {
            str2 = "Amazon Custom Event";
        }
        if (bundle != null) {
            String string = bundle.getString("event_server_parameter", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            String string2 = bundle.getString("bid_html_template", null);
            if (string != null && str != null && string2 != null) {
                if (z) {
                    zEquals = compareEncodedPrice(string, str);
                } else {
                    zEquals = str.equals(string);
                }
                if (!zEquals) {
                    DtbLog.debug(CUSTOM_EVENT, str2 + " ignored (server " + str + " is not matched with expected parameter " + string + ")");
                } else {
                    String string3 = bundle.getString("bid_identifier", null);
                    String string4 = bundle.getString("hostname_identifier", null);
                    long j = bundle.getLong("start_load_time");
                    if (j > 0) {
                        DTBMetricsProcessor.getInstance().submitLatencyReportBidId(DTBMetricReport.addBid(string3, string4), DTBMetricsProcessor.REPORT_MEDIATION_LATENCY, (int) (new Date().getTime() - j));
                    }
                    DtbLog.debug(CUSTOM_EVENT, str2.concat(" Completed/Accepted"));
                    return true;
                }
            }
            if (string == null) {
                DtbLog.debug(CUSTOM_EVENT, str2.concat(" ignored (expected server parameter is null"));
            }
            if (str == null) {
                DtbLog.debug(CUSTOM_EVENT, str2.concat(" ignored (server parameter is null"));
            }
            if (string2 == null) {
                DtbLog.debug(CUSTOM_EVENT, str2.concat(" ignored (payload is not defined)"));
            }
        }
        DtbLog.debug(CUSTOM_EVENT, str2.concat(" Completed/Ignored "));
        return false;
    }

    static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static ViewGroup getAdViewWrapper(View view, int i, int i2, int i3, int i4) {
        AdContainer adContainer = new AdContainer(view.getContext());
        if (i4 != 0 && i3 != 0) {
            adContainer.addView(view, sizeToDevicePixels(i3), sizeToDevicePixels(i4));
        } else {
            adContainer.addView(view, sizeToDevicePixels(i), sizeToDevicePixels(i2));
        }
        adContainer.setAdView(view);
        return adContainer;
    }

    static void directAppStoreLinkToBrowser(DTBAdMRAIDController dTBAdMRAIDController, Uri uri) throws ActivityNotFoundException, NullPointerException {
        String str;
        if (ApsAdWebViewSupportClient.AMAZON_SCHEME.equals(uri.getScheme())) {
            DtbLog.debug(LOG_TAG, "Amazon app store unavailable in the device");
            str = ApsAdWebViewSupportClient.AMAZON_APP_STORE_LINK + uri.getQuery();
        } else {
            DtbLog.debug(LOG_TAG, "App store unavailable in the device");
            str = ApsAdWebViewSupportClient.GOOGLE_PLAY_STORE_LINK + uri.getHost() + "?" + uri.getQuery();
        }
        Uri uri2 = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri2);
        safedk_Activity_startActivity_9d898b58165fa4ba0e12c3900a2b8533(AdRegistration.getCurrentActivity(), intent);
        dTBAdMRAIDController.onAdLeftApplication();
    }

    static synchronized String loadFile(String str, String str2) throws IOException {
        Context context = AdRegistration.getContext();
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str2 + RemoteSettings.FORWARD_SLASH_STRING + str);
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                sb.append(line.trim()).append("\n");
            } else {
                bufferedReader.close();
                fileInputStream.close();
                return sb.toString();
            }
        }
    }

    static void createDirIfDoesNotExist(String str) {
        Context context = AdRegistration.getContext();
        if (context != null) {
            File file = new File(context.getFilesDir().getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + str);
            if (file.isDirectory() || file.exists()) {
                return;
            }
            file.mkdir();
        }
    }

    static String loadFromAssets(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (AdRegistration.getContext() != null && AdRegistration.getContext().getAssets() != null) {
            InputStream inputStreamOpen = AdRegistration.getContext().getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line.trim()).append("\n");
            }
            bufferedReader.close();
            inputStreamOpen.close();
        }
        return sb.toString();
    }

    static JSONObject loadJsonFromAsset(String str) {
        try {
            return new JSONObject(loadFromAssets(str));
        } catch (IOException unused) {
            DtbLog.debug("Fail to load " + str + "from asset folder");
            return null;
        } catch (JSONException unused2) {
            DtbLog.debug("Fail to parse " + str + " to JSON from asset folder");
            return null;
        }
    }

    public static String generateRequestId() {
        String str = UUID.randomUUID().toString() + "-" + new Date().getTime();
        if (AdRegistration.getAdMobCache(str) != null) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.LOG, "Generate a conflict request id which already in request id map");
            AdRegistration.removeAdMobCache(str);
        }
        return str;
    }

    static boolean compareEncodedPrice(String str, String str2) {
        if (DtbCommonUtils.isNullOrEmpty(str) || DtbCommonUtils.isNullOrEmpty(str2)) {
            return false;
        }
        if (str.length() < 8 || str2.length() < 8 || !str.contains("_spp") || !str2.contains("_spp")) {
            return str.compareTo(str2) == 0;
        }
        String strReplace = str.replace("_spp", "");
        String strReplace2 = str2.replace("_spp", "");
        String string = new StringBuilder(strReplace).reverse().toString();
        String string2 = new StringBuilder(strReplace2).reverse().toString();
        String clientConfigVal = DTBMetricsConfiguration.getClientConfigVal("leq", "spp_flag");
        if (!DtbCommonUtils.isNullOrEmpty(clientConfigVal)) {
            if ("eq".equals(clientConfigVal)) {
                return string2.compareTo(string) == 0;
            }
            if ("geq".equals(clientConfigVal)) {
                return string2.compareTo(string) >= 0;
            }
        }
        return string2.compareTo(string) <= 0;
    }

    public static Bundle createAdMobBannerRequestBundle(String str, int i, int i2) {
        return createAdMobBannerRequestBundle(str, i, i2, null);
    }

    public static Bundle createAdMobBannerRequestBundle(String str, int i, int i2, Map<String, String> map) {
        Bundle bundleCreateBundleWithExtras = createBundleWithExtras(map);
        try {
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_SLOTUUID_KEY, str);
            bundleCreateBundleWithExtras.putInt(DtbConstants.ADMOB_WIDTH_KEY, i);
            bundleCreateBundleWithExtras.putInt(DtbConstants.ADMOB_HEIGHT_KEY, i2);
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_REQUEST_ID_KEY, generateRequestId());
            bundleCreateBundleWithExtras.putString(DtbConstants.APS_ADAPTER_VERSION, "2.0");
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute createAdMobBannerRequestBundle method to create bundle for non smart banner ads", e);
        }
        return bundleCreateBundleWithExtras;
    }

    public static Bundle createAdMobBannerRequestBundle(String str) {
        return createAdMobBannerRequestBundle(str, null);
    }

    public static Bundle createAdMobBannerRequestBundle(String str, Map<String, String> map) {
        Bundle bundleCreateBundleWithExtras = createBundleWithExtras(map);
        try {
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_SLOTGROUP_KEY, str);
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_REQUEST_ID_KEY, generateRequestId());
            bundleCreateBundleWithExtras.putString(DtbConstants.APS_ADAPTER_VERSION, "2.0");
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute createAdMobBannerRequestBundle method to create bundle for smart banner ads", e);
        }
        return bundleCreateBundleWithExtras;
    }

    public static Bundle createAdMobInterstitialRequestBundle(String str) {
        return createAdMobInterstitialRequestBundle(str, false, null);
    }

    public static Bundle createAdMobInterstitialVideoRequestBundle(String str) {
        return createAdMobInterstitialRequestBundle(str, true, null);
    }

    public static Bundle createAdMobInterstitialRequestBundle(String str, Map<String, String> map) {
        return createAdMobInterstitialRequestBundle(str, false, map);
    }

    public static Bundle createAdMobInterstitialVideoRequestBundle(String str, Map<String, String> map) {
        return createAdMobInterstitialRequestBundle(str, true, map);
    }

    private static Bundle createAdMobInterstitialRequestBundle(String str, boolean z, Map<String, String> map) {
        Bundle bundleCreateBundleWithExtras = createBundleWithExtras(map);
        try {
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_SLOTUUID_KEY, str);
            bundleCreateBundleWithExtras.putString(DtbConstants.ADMOB_REQUEST_ID_KEY, generateRequestId());
            bundleCreateBundleWithExtras.putString(DtbConstants.APS_ADAPTER_VERSION, "2.0");
            bundleCreateBundleWithExtras.putBoolean(DtbConstants.ADMOB_iSVIDEO_KEY, z);
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute createAdMobInterstitialRequestBundle method", e);
        }
        return bundleCreateBundleWithExtras;
    }

    private static Bundle createBundleWithExtras(Map<String, String> map) {
        Bundle bundleInitializeEmptyBundle = DtbCommonUtils.initializeEmptyBundle();
        try {
            if (!DtbCommonUtils.isNullOrEmpty(map)) {
                if (map.containsKey(DtbConstants.APS_ADMOB_CONST_CCPA_APS_PRIVACY) && !DtbCommonUtils.isNullOrEmpty(map.get(DtbConstants.APS_ADMOB_CONST_CCPA_APS_PRIVACY))) {
                    bundleInitializeEmptyBundle.putString(DtbConstants.APS_ADMOB_CONST_CCPA_APS_PRIVACY, map.get(DtbConstants.APS_ADMOB_CONST_CCPA_APS_PRIVACY));
                }
                if (map.containsKey("us_privacy") && !DtbCommonUtils.isNullOrEmpty(map.get("us_privacy"))) {
                    bundleInitializeEmptyBundle.putString("us_privacy", map.get("us_privacy"));
                }
            }
        } catch (RuntimeException e) {
            APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Failed to add CCPA consent to AdMob mediation bundle", e);
        }
        return bundleInitializeEmptyBundle;
    }
}

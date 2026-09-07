package com.amazon.aps.ads.util.adview;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import com.amazon.aps.ads.util.ApsAdExtensionsKt;
import com.amazon.aps.shared.ApsMetrics;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.device.ads.DTBAdBannerListener;
import com.amazon.device.ads.DTBAdMRAIDBannerController;
import com.amazon.device.ads.DTBAdMRAIDController;
import com.amazon.device.ads.DTBExpectedSizeProvider;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.amazon.device.ads.DtbCommonUtils;
import com.amazon.device.ads.DtbConstants;
import com.amazon.device.ads.DtbDeviceData;
import com.amazon.device.ads.DtbOmSdkSessionManager;
import com.amazon.device.ads.DtbSharedPreferences;
import com.amazon.device.ads.WebResourceService;
import com.pubmatic.sdk.common.POBCommonConstants;
import com.safedk.android.internal.partials.AmazonPublisherServicesNetworkBridge;
import com.smaato.sdk.richmedia.mraid.dataprovider.MraidEnvironmentProperties;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsAdViewFetchUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewFetchUtils;", "", "()V", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApsAdViewFetchUtils {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final void fetchAdWithLocation(Context context, WebView webView, boolean z, String str) {
        INSTANCE.fetchAdWithLocation(context, webView, z, str);
    }

    @JvmStatic
    public static final void getAdInfo(String str, Bundle bundle) {
        INSTANCE.getAdInfo(str, bundle);
    }

    @JvmStatic
    public static final String getEnvironment(Context context, Bundle bundle) {
        return INSTANCE.getEnvironment(context, bundle);
    }

    @JvmStatic
    public static final String getMobileDeviceInfo() {
        return INSTANCE.getMobileDeviceInfo();
    }

    @JvmStatic
    public static final void loadLocalFile(Context context, boolean z, String str, StringBuilder sb) {
        INSTANCE.loadLocalFile(context, z, str, sb);
    }

    /* JADX INFO: compiled from: ApsAdViewFetchUtils.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\r\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eJ*\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\fH\u0007J$\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001c\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\u001d\u001a\u00020\nH\u0007J,\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\n\u0010 \u001a\u00060!j\u0002`\"H\u0007¨\u0006#"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewFetchUtils$Companion;", "", "()V", "fetchAd", "", "webView", "Lcom/amazon/aps/ads/util/adview/ApsAdViewImpl;", "mraidListener", "Lcom/amazon/device/ads/DTBAdMRAIDController;", "adHtml", "", "extraData", "Landroid/os/Bundle;", "extra", "", "fetchAdWithLocation", "context", "Landroid/content/Context;", "Landroid/webkit/WebView;", "localOnly", "", "url", "getAdInfo", "adhtml", "adInfoBundle", "getBundleForFetchAd", "mraidHandler", "getEnvironment", "extras", "getMobileDeviceInfo", "loadLocalFile", "name", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void getAdInfo(String adhtml, Bundle adInfoBundle) {
            Intrinsics.checkNotNullParameter(adInfoBundle, "adInfoBundle");
            if (adhtml != null) {
                String str = adhtml;
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) "amzn.dtb.loadAd", false, 2, (Object) null)) {
                    Matcher matcher = Pattern.compile("amzn.dtb.loadAd\\(\\\"(.*)\\\", \\\"(.*)\\\", \\\"(.*)\\\".*isv: (\\w+)").matcher(str);
                    if (matcher.find() && matcher.groupCount() == 4) {
                        adInfoBundle.putString("event_server_parameter", matcher.group(1));
                        adInfoBundle.putString("bid_identifier", matcher.group(2));
                        adInfoBundle.putString("hostname_identifier", matcher.group(3));
                        adInfoBundle.putBoolean("video_flag", Boolean.parseBoolean(matcher.group(4)));
                    }
                }
            }
        }

        public final Bundle getBundleForFetchAd(DTBAdMRAIDController mraidHandler, String adHtml, Bundle extraData) {
            Intrinsics.checkNotNullParameter(mraidHandler, "mraidHandler");
            if (adHtml == null && extraData != null) {
                adHtml = extraData.getString("bid_html_template", null);
            }
            if (extraData != null && (mraidHandler instanceof DTBAdMRAIDBannerController)) {
                DTBAdBannerListener dTBAdBannerListener = ((DTBAdMRAIDBannerController) mraidHandler).bannerListener;
                int i = extraData.getInt("expected_width", 0);
                int i2 = extraData.getInt("expected_height", 0);
                if (i2 > 0 && i > 0 && (dTBAdBannerListener instanceof DTBExpectedSizeProvider)) {
                    DTBExpectedSizeProvider dTBExpectedSizeProvider = (DTBExpectedSizeProvider) dTBAdBannerListener;
                    dTBExpectedSizeProvider.setExpectedWidth(i);
                    dTBExpectedSizeProvider.setExpectedHeight(i2);
                }
            }
            if (!DTBMetricsConfiguration.getInstance().isFeatureEnabled("webviewAdInfo_feature") || extraData != null) {
                return extraData;
            }
            Bundle bundle = new Bundle();
            getAdInfo(adHtml, bundle);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("{bidID:'%s',aaxHost:'%s',pricePoint:'%s'}", Arrays.copyOf(new Object[]{bundle.getString("bid_identifier"), bundle.getString("hostname_identifier"), bundle.getString("event_server_parameter")}, 3));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            bundle.putString("amazon_ad_info", str);
            return bundle;
        }

        public final void fetchAd(ApsAdViewImpl webView, String adHtml, Map<String, ? extends Object> extra) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            try {
                Bundle bundleInitializeEmptyBundle = DtbCommonUtils.initializeEmptyBundle();
                if (extra != null) {
                    for (Map.Entry<String, ? extends Object> entry : extra.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value instanceof String) {
                            bundleInitializeEmptyBundle.putString(key, (String) value);
                        } else if (value instanceof Boolean) {
                            bundleInitializeEmptyBundle.putBoolean(key, ((Boolean) value).booleanValue());
                        } else if (value instanceof Integer) {
                            bundleInitializeEmptyBundle.putInt(key, ((Number) value).intValue());
                        } else if (value instanceof Long) {
                            bundleInitializeEmptyBundle.putLong(key, ((Number) value).longValue());
                        }
                    }
                }
                webView.fetchAd(adHtml, bundleInitializeEmptyBundle);
            } catch (RuntimeException e) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAd method with map bundle", e);
            }
        }

        public final void fetchAd(ApsAdViewImpl webView, DTBAdMRAIDController mraidListener, String adHtml, Bundle extraData) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            Intrinsics.checkNotNullParameter(mraidListener, "mraidListener");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("<!DOCTYPE html><html><head>");
                sb.append("<script>");
                sb.append(getEnvironment(webView.getAdViewContext(), extraData));
                sb.append("</script>");
                Context context = webView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "webView.context");
                loadLocalFile(context, webView.getLocalOnly(), "aps-mraid", sb);
                Context context2 = webView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "webView.context");
                loadLocalFile(context2, webView.getLocalOnly(), "dtb-m", sb);
                if (DtbOmSdkSessionManager.getFeatureEnableFlag()) {
                    Context context3 = webView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "webView.context");
                    loadLocalFile(context3, webView.getLocalOnly(), "omsdk-v1", sb);
                }
                sb.append("</head>");
                sb.append("<body style='margin:0;padding:0;'>");
                sb.append(adHtml);
                sb.append("</body></html>");
                if (DTBMetricsConfiguration.getInstance().isFeatureEnabled("additional_webview_metric")) {
                    if (mraidListener instanceof DTBAdMRAIDBannerController) {
                        ApsMetrics.INSTANCE.customEvent("bannerCreativeRenderingStart", webView.getBidId(), null);
                    } else {
                        ApsMetrics.INSTANCE.customEvent("interstitialCreativeRenderingStart", webView.getBidId(), null);
                    }
                }
                AmazonPublisherServicesNetworkBridge.webviewLoadDataWithBaseURL(webView, "https://c.amazon-adsystem.com/", sb.toString(), POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
            } catch (RuntimeException e) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAd method with bundle", e);
            }
        }

        @JvmStatic
        public final void fetchAdWithLocation(Context context, WebView webView, boolean localOnly, String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(webView, "webView");
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("<script>");
                sb.append(getEnvironment(context, null));
                sb.append("</script>");
                loadLocalFile(context, localOnly, "aps-mraid", sb);
                sb.append("<script>");
                sb.append("window.location=\"").append(url).append("\";");
                sb.append("</script>");
                AmazonPublisherServicesNetworkBridge.webviewLoadDataWithBaseURL(webView, "https://c.amazon-adsystem.com/", sb.toString(), POBCommonConstants.CONTENT_TYPE_HTML, "UTF-8", null);
            } catch (RuntimeException e) {
                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to execute fetchAdWithLocation method", e);
            }
        }

        @JvmStatic
        public final String getMobileDeviceInfo() throws JSONException {
            String string;
            String string2;
            String string3;
            String str;
            String str2;
            String str3;
            String str4;
            String str5 = "";
            try {
                JSONObject paramsJson = DtbDeviceData.getDeviceDataInstance().getParamsJson();
                if (paramsJson == null) {
                    str3 = "";
                    str2 = str3;
                    str = str2;
                    str4 = str;
                } else {
                    if (paramsJson.has(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY)) {
                        string3 = paramsJson.getString(DtbDeviceData.DEVICE_DATA_OS_VERSION_KEY);
                        Intrinsics.checkNotNullExpressionValue(string3, "it.getString(\n          …                        )");
                    } else {
                        string3 = "";
                    }
                    try {
                        if (paramsJson.has("model")) {
                            string2 = paramsJson.getString("model");
                            Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\n          …                        )");
                        } else {
                            string2 = "";
                        }
                        try {
                            if (paramsJson.has(DtbDeviceData.DEVICE_DATA_SCREEN_SIZE_KEY)) {
                                string = paramsJson.getString(DtbDeviceData.DEVICE_DATA_SCREEN_SIZE_KEY);
                                Intrinsics.checkNotNullExpressionValue(string, "it.getString(\n          …                        )");
                            } else {
                                string = "";
                            }
                            try {
                                if (paramsJson.has("orientation")) {
                                    String string4 = paramsJson.getString("orientation");
                                    Intrinsics.checkNotNullExpressionValue(string4, "it.getString(\n          …                        )");
                                    str5 = string4;
                                }
                            } catch (RuntimeException e) {
                                e = e;
                                ApsAdExtensionsKt.logEvent(this, APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Fail to parse deviceData in getMobileDeviceInfo method", e);
                            }
                        } catch (RuntimeException e2) {
                            e = e2;
                            string = "";
                        }
                    } catch (RuntimeException e3) {
                        e = e3;
                        string = "";
                        string2 = string;
                    }
                    str = string;
                    str2 = string2;
                    str3 = string3;
                    str4 = str5;
                }
            } catch (RuntimeException e4) {
                e = e4;
                string = "";
                string2 = string;
                string3 = string2;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str6 = String.format("{os:'%s',fwk:'%s',osVersion:'%s',model:'%s',screenSize:'%s',orientation:'%s'}", Arrays.copyOf(new Object[]{"android", DtbCommonUtils.getSDKFramework(), str3, str2, str, str4}, 6));
            Intrinsics.checkNotNullExpressionValue(str6, "format(format, *args)");
            return str6;
        }

        @JvmStatic
        public final String getEnvironment(Context context, Bundle extras) throws JSONException {
            String str;
            CharSequence applicationLabel;
            Intrinsics.checkNotNullParameter(context, "context");
            String string = extras != null ? extras.getString("amazon_ad_info") : null;
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (packageManager != null && (applicationLabel = packageManager.getApplicationLabel(applicationInfo)) != null) {
                str = (String) applicationLabel;
            } else {
                str = "";
            }
            String str2 = str;
            String idfa = DtbSharedPreferences.getInstance().getIdfa();
            if (DtbCommonUtils.isNullOrEmpty(idfa)) {
                idfa = "unknown";
            }
            String str3 = idfa;
            boolean optOut = DtbSharedPreferences.getInstance().getOptOut();
            if (optOut == null) {
                optOut = false;
            }
            Boolean bool = optOut;
            String mobileDeviceInfo = getMobileDeviceInfo();
            if (string == null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str4 = String.format("window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,impFired:true,mobileDeviceInfo:%s};", Arrays.copyOf(new Object[]{MraidEnvironmentProperties.VERSION, DtbCommonUtils.getSDKMRAIDVersion(), DtbConstants.SDK_VERSION, StringsKt.replace$default(str2, "'", "\\'", false, 4, (Object) null), str3, bool, false, mobileDeviceInfo}, 8));
                Intrinsics.checkNotNullExpressionValue(str4, "format(format, *args)");
                return str4;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str5 = String.format("window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,amznAdInfo:%s,impFired:true,mobileDeviceInfo:%s};", Arrays.copyOf(new Object[]{MraidEnvironmentProperties.VERSION, DtbCommonUtils.getSDKMRAIDVersion(), DtbConstants.SDK_VERSION, StringsKt.replace$default(str2, "'", "\\'", false, 4, (Object) null), str3, bool, false, string, mobileDeviceInfo}, 9));
            Intrinsics.checkNotNullExpressionValue(str5, "format(format, *args)");
            return str5;
        }

        @JvmStatic
        public final void loadLocalFile(Context context, boolean localOnly, String name, StringBuilder sb) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (!localOnly) {
                try {
                    String strLoadFile = WebResourceService.getInstance().loadFile(name);
                    if (strLoadFile != null) {
                        sb.append("<script>").append(strLoadFile).append("</script>");
                        return;
                    }
                } catch (Exception unused) {
                    ApsAdExtensionsKt.e(this, "Failed to read local file");
                }
            }
            sb.append("<script>");
            try {
                InputStream inputStreamOpen = context.getAssets().open(Intrinsics.stringPlus(name, ".js"));
                Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "context.assets.open(\"$name.js\")");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    } else {
                        sb.append(StringsKt.trim((CharSequence) line).toString()).append("\n");
                    }
                }
                bufferedReader.close();
                inputStreamOpen.close();
            } catch (Exception unused2) {
                ApsAdExtensionsKt.e(this, Intrinsics.stringPlus("Error reading file:", name));
            }
            sb.append("</script>");
        }
    }

    private ApsAdViewFetchUtils() {
    }
}

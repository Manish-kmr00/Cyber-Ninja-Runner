package com.safedk.android.analytics.brandsafety.creatives.discoveries;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.brandsafety.BannerFinder;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectDetails;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.u;
import com.safedk.android.analytics.events.BrandSafetyEvent;
import com.safedk.android.internal.SafeDKWebAppInterface;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.PersistentConcurrentHashMap;
import com.safedk.android.utils.SdksMapping;
import com.safedk.android.utils.SimpleConcurrentHashSet;
import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes8.dex */
public abstract class d implements AdNetworkDiscovery {
    public static final String A = "@!1:ad_fetch@!";
    public static final String B = "<title>Unity Ads WebView</title>";
    protected static final String F = "extra_url";
    private static final String b = "BaseDiscovery";
    private static final String c = "Liftoff.init";
    private static final String d = "LiftoffOuterEnv.init";
    private static final String e = "privacyButtonClick";
    private static final Map<String, ArrayList<String>> f = new HashMap();
    public static final String r = "com.applovin.mediation.nativeAds.MaxNativeAdView";
    public static final String s = "onDataLoadedToWebView";
    public static final String t = "onResourceLoaded";
    public static final String u = "https://";
    public static final String v = "http://";
    protected static final String w = "mraid://tpat?event";
    protected static final String x = "checkpoint.0";
    protected static final String y = "checkpoint.100";
    protected static final String z = "video.close";
    protected com.safedk.android.analytics.brandsafety.creatives.b C;
    protected ConcurrentHashMap<com.safedk.android.analytics.brandsafety.creatives.i, CreativeInfo> D;
    protected Set<String> E;
    protected String G;
    protected Map<String, CreativeInfo> H;
    protected Map<String, List<CreativeInfo>> I;
    protected Map<Integer, CreativeInfo> J;
    protected Map<String, CreativeInfo> K;
    protected Map<String, String> L;
    protected final ScheduledExecutorService M;
    protected final Map<com.safedk.android.analytics.brandsafety.creatives.i, ScheduledFuture<?>> N;
    protected final Map<com.safedk.android.analytics.brandsafety.d, WeakReference<View>> O;
    protected Set<String> P;
    protected String Q;
    private final Map<String, Set<String>> g;
    private u h;
    private u i;
    private String j;

    protected abstract boolean A(String str);

    protected abstract String a(String str, CreativeInfo creativeInfo);

    protected abstract List<CreativeInfo> a(String str, String str2, Map<String, List<String>> map, c.a aVar, byte[] bArr) throws JSONException;

    protected abstract boolean b(String str, Bundle bundle);

    private void h() {
        this.C = new com.safedk.android.analytics.brandsafety.creatives.b();
        this.C.b(AdNetworkConfiguration.SUPPORTS_PREFETCH_RECEIVING_BY_APPLOVIN, false);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST, true);
        this.C.b(AdNetworkConfiguration.SHOULD_UPDATE_CREATIVE_INFO_FROM_VAST, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_GZIP_CONTENT, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_VIDEO_STATE_DETECTION, false);
        this.C.a(AdNetworkConfiguration.BITMAP_SCAN_TOP_MARGIN_PERCENT, 0.15f);
        this.C.a(AdNetworkConfiguration.BITMAP_SCAN_RIGHT_MARGIN_PERCENT, 0.15f);
        this.C.a(AdNetworkConfiguration.BITMAP_SCAN_LEFT_MARGIN_PERCENT, 0.15f);
        this.C.a(AdNetworkConfiguration.BITMAP_SCAN_BOTTOM_MARGIN_PERCENT, 0.15f);
        this.C.b(AdNetworkConfiguration.BITMAP_SCAN_SHOULD_CHECK_FOR_GREYSCALE, false);
        this.C.b(AdNetworkConfiguration.ENFORCE_CLOSE_INPUT_STREAM_VAST_IN_VAST, false);
        this.C.b(AdNetworkConfiguration.ENFORCE_CLOSE_INPUT_STREAM, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BANNER_IMPRESSION_TRACKING, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_TRACKING, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_IMPRESSION_TRACKING, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_FULLSCREEN_ADS, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_MRECS, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_JAVASCRIPT_BASED_PRIVACY_BUTTON_CLICK_DETECTION_IN_BANNERS, false);
        this.C.b(AdNetworkConfiguration.AVOID_CLEANING_PENDING_CI_LIST_ON_AD_END, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_BIDDING_INTERSTITIAL_IMPRESSION_MATCHING_BY_MAX, false);
        this.C.b(AdNetworkConfiguration.SHOULD_SET_CI_AS_VIDEO_AD_ON_VIDEO_RESOURCE_LOAD, false);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_AD_ID_FROM_BANNER_WEB_VIEW, false);
        this.C.b(AdNetworkConfiguration.AD_ID_EXTRACTED_FROM_BANNER_WEB_VIEW_IS_MAX_CREATIVE_ID, false);
        this.C.b(AdNetworkConfiguration.USE_WEBVIEW_LOADURL_AS_RESOURCE_LOADED_INDICATION, false);
        this.C.b(AdNetworkConfiguration.USE_INPUT_STREAM_EVENT_AS_RESOURCE_LOADED_INDICATION, false);
        this.C.b(AdNetworkConfiguration.SDK_USES_PLACEMENT_ID_ARRAY, false);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE, false);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_BANNER_MULTIPLE_WEBVIEWS, false);
        this.C.b(AdNetworkConfiguration.SDK_INTERSTITIALS_RUN_ON_APP_ACTIVITY, false);
        this.C.b(AdNetworkConfiguration.SDK_CUSTOM_VIEW_TYPE_NAME, (String) null);
        this.C.a(AdNetworkConfiguration.SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE, SafeDK.getInstance().H());
        Logger.d(this.j, "SDK_SPECIFIC_MIN_UNIFORM_PIXELS_PERCENTAGE_FOR_UNIFORM_IMAGE setting set for " + this.j + ", value = " + SafeDK.getInstance().H());
        this.C.b(AdNetworkConfiguration.AD_NETWORK_INTERNAL_BROWSER_OPENS_IN_SAME_ACTIVITY, false);
        this.C.b(AdNetworkConfiguration.SHOULD_SCAN_OBJECT_USING_REFLECTION, false);
        this.C.b(AdNetworkConfiguration.AD_NETWORK_TO_IGNORE, (String) null);
        this.C.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_MAX_AGE, com.safedk.android.internal.d.N);
        this.C.b(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_EXPIRATION, true);
        this.C.a(AdNetworkConfiguration.SDK_SPECIFIC_CACHED_CI_THRESHOLD, SafeDK.getInstance().V());
        this.C.b(AdNetworkConfiguration.APP_OPEN_IMPRESSION_TRACKING_ENABLED, false);
        this.C.b(AdNetworkConfiguration.SHOULD_SCAN_INTERSTITIAL_VIEW_HIERARCHY_FOR_CI, false);
        this.C.b(AdNetworkConfiguration.DETECT_MULTIPLE_ADS_BY_WEB_VIEW_CHANGE, false);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_EARLY_VAST_AD_TAG_URI_PARSING, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MREC_IMPRESSION_EOV, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_AUTO_REDIRECTS_IDENTIFICATION, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_EXPANDED_ADS_IDENTIFICATION_BY_MAX_EVENT, false);
        this.C.b(AdNetworkConfiguration.SHOULD_REPORT_AD_ID_ON_CI_CREATION, true);
        this.C.b(AdNetworkConfiguration.SHOULD_INJECT_JS_TO_WEBVIEWS_NOT_YET_ATTACHED_TO_ACTIVITY, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_NATIVE_BANNERS_USING_BANNER_KEY, false);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_TEXT_FROM_NATIVE_BANNERS, false);
        this.C.b(AdNetworkConfiguration.SHOULD_EXTRACT_TEXT_FROM_NATIVE_BANNERS, false);
        this.C.a(AdNetworkConfiguration.NUMBER_OF_VIEWS_REMOVED_IN_FULL_SCREEN_AD_THAT_INDICATES_EOV, 0L);
        this.C.b(AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID, false);
        this.C.b(AdNetworkConfiguration.REPLACE_PREFETCH_CREATIVE_ID_WITH_MAX_CREATIVE_ID_MAX_NETWORK_NAMES, (String) null);
        this.C.b(AdNetworkConfiguration.SHOULD_IGNORE_BANNER_MULTI_AD_DID_CLICK_EVENT, false);
        this.C.b(AdNetworkConfiguration.SET_AD_FORMAT_FROM_APPLOVIN_BUNDLE, false);
        this.C.a(AdNetworkConfiguration.FULL_SCREEN_CI_MAX_AGE, com.safedk.android.internal.d.N);
        this.C.a(AdNetworkConfiguration.BANNER_CI_MAX_AGE, 600000L);
        this.C.b(AdNetworkConfiguration.SHOULD_INJECT_JS_TO_WEBVIEWS_FOR_TEXT_EXTRACTION, true);
        this.C.b(AdNetworkConfiguration.DONT_USE_PLACEMENT_ID_IN_BANNER_AD_INFO_KEY, "");
        this.C.b(AdNetworkConfiguration.DONT_REPORT_WEBVIEW_RESOURCE_LIST_IF_NO_CI, false);
        this.C.b(AdNetworkConfiguration.WEBVIEW_REPLACE_ON_AD_DISPLAY_FAIL, false);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_AD_TAG_TWICE, false);
        this.C.b(AdNetworkConfiguration.DO_NOT_ADD_CI_TO_FINDER_PENDING_CI_LIST, false);
        this.C.b(AdNetworkConfiguration.NOTIFY_DISCOVERY_CLASS_ABOUT_FULL_SCREEN_MATCHING, false);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_URLS_IN_CLICK_URL_RESOLUTION, true);
        this.C.b(AdNetworkConfiguration.AVOID_MATCHING_CI_FROM_BANNER_WEB_VIEW_BEFORE_SCANNING, false);
        this.C.b(AdNetworkConfiguration.MATCH_ON_BANNER_WEBVIEW_DETECTION, false);
        this.C.b(AdNetworkConfiguration.SHOULD_DELAY_BANNER_VIEWS_SCANNER, false);
        this.C.b(AdNetworkConfiguration.SHOULD_ALLOW_CI_MATCHING_WITH_INCOMPATIBLE_EVENT_IDS, false);
        this.C.b(AdNetworkConfiguration.SHOULD_ALLOW_REFLECTION_ON_OS_CLASSES, false);
        this.C.b(AdNetworkConfiguration.SHOULD_VIDEO_OBSERVER_TRAVERSE_IFRAMES, false);
        this.C.b(AdNetworkConfiguration.SHOULD_GET_HTML_TEXT_TRAVERSE_IFRAMES, false);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_FULLSCREEN, true);
        this.C.b(AdNetworkConfiguration.SHOULD_USE_RESOURCES_COLLECTION_SCRIPT_BANNERS, true);
        this.C.b(AdNetworkConfiguration.SUPPORTS_DIFFERENT_ADS_IN_CROSS_ORIGIN_IFRAMES, false);
        this.C.b(AdNetworkConfiguration.CLEAR_FULLSCREEN_PENDING_CANDIDATES_ON_DID_FAIL_DISPLAY, false);
        this.C.b(AdNetworkConfiguration.SUPPORTS_MEDIA_PLAYER_RELEASE_EOV, false);
        this.C.b(AdNetworkConfiguration.STORE_DECODED_QUESTION_MARK_IN_VIV_URL_LIST, false);
        this.C.a(AdNetworkConfiguration.MREC_SCREENSHOT_TAKING_DELAY, 0L);
        this.C.b(AdNetworkConfiguration.VAST_URL_QUERY_PARAMS_TO_IGNORE, (String) null);
        this.C.b(AdNetworkConfiguration.DOWNLOAD_INNER_VAST_URL_IF_NOT_LOADED, false);
        this.C.b(AdNetworkConfiguration.SHOULD_CAPTURE_SURFACE_VIEW_WHEN_USING_PIXELCOPY, false);
        this.C.b(AdNetworkConfiguration.SHOULD_CALL_RESOURCE_LOADED_FROM_SHOULD_INTERCEPT_REQUEST, false);
        this.C.b(AdNetworkConfiguration.PRINT_WEB_VIEW_CONTENTS_ON_HTML_LOAD, true);
        this.C.b(AdNetworkConfiguration.SUPPORT_WEBVIEW_COMMENT_EXTRACTION, false);
        this.C.b(AdNetworkConfiguration.SHOULD_ADD_BYTE_ARRAY_AS_PARAM_ON_AD_FETCHED, false);
        this.C.b(AdNetworkConfiguration.SHOULD_DECODE_BASE64_PREFECT_RECEIVED_BY_APPLOVIN, false);
        this.C.b(AdNetworkConfiguration.INJECT_SCRIPTS_IF_URL_IS_NULL, false);
        this.C.b(AdNetworkConfiguration.SHOULD_REPORT_VAST_ID_AS_CREATIVE_ID, false);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(CreativeInfo creativeInfo) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, Bundle bundle) {
        String strA = com.safedk.android.utils.n.A(str);
        D(str);
        boolean z2 = b(new com.safedk.android.analytics.brandsafety.creatives.i(strA)) || b(new com.safedk.android.analytics.brandsafety.creatives.i(str));
        boolean z3 = z2 || l.a(str) || b(str, bundle);
        if (z3) {
            Logger.d(this.j, "should follow input stream ? " + z3 + ", vast? " + z2 + ", url=" + str);
        }
        return z3;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean g(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(String str, String str2) {
        D(str);
        boolean zContains = this.E.contains(str);
        boolean z2 = zContains || A(str);
        Logger.d(this.j, "should follow get url? " + z2 + ", vast media? " + zContains + " url=" + str + " webviewAddress=" + str2);
        return z2;
    }

    protected void D(String str) {
        Set<String> setB = b(str, c());
        if (setB != null && setB.size() > 0) {
            str = a(str, setB);
            Logger.d(this.j, "trigger video completed event - event url without query params=" + str);
        }
        if (this.P.remove(str)) {
            Logger.d(this.j, "Video completed event sdk=" + this.Q + ", source " + str);
            SafeDK safeDK = SafeDK.getInstance();
            if (safeDK != null && safeDK.z() != null) {
                safeDK.z().f(this.Q, "url-event");
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(u uVar) {
        this.h = uVar;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(u uVar) {
        this.i = uVar;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x01c1 A[PHI: r0
  0x01c1: PHI (r0v5 com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo) = 
  (r0v4 com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo)
  (r0v26 com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo)
  (r0v26 com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo)
 binds: [B:9:0x0045, B:11:0x0067, B:13:0x0075] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(String str, String str2, byte[] bArr, Map<String, List<String>> map, c.a aVar) {
        CreativeInfo creativeInfoB;
        if (str2 != null) {
            try {
                if (str2.length() != 0) {
                    com.safedk.android.utils.n.b(this.j, "base generate info - url: " + str + ", vast URLs to follow: " + this.D.toString() + ", isOnUiThread: " + com.safedk.android.utils.n.c());
                    CreativeInfo creativeInfoB2 = B(str);
                    if (creativeInfoB2 == null) {
                        String strI = I(str);
                        com.safedk.android.utils.n.b(this.j, "decoded URL: " + strI);
                        creativeInfoB2 = B(strI);
                        if (creativeInfoB2 == null) {
                            String strReplace = strI.replace("(%20|+)", " ");
                            if (strReplace.equals(strI)) {
                                creativeInfoB = creativeInfoB2;
                            } else {
                                Logger.d(this.j, "decoded URL with spaces: " + strReplace);
                                creativeInfoB = B(strReplace);
                            }
                        } else {
                            creativeInfoB = creativeInfoB2;
                        }
                    } else {
                        creativeInfoB = creativeInfoB2;
                    }
                    if (creativeInfoB != null) {
                        com.safedk.android.utils.n.b(this.j, "found vast url: " + str + ", ci: " + creativeInfoB + ", content: " + str2);
                        a(creativeInfoB, str, str2, true);
                        Logger.d(this.j, "vast processing was done in base.");
                        creativeInfoB.j(false);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(creativeInfoB);
                        c(creativeInfoB);
                        return arrayList;
                    }
                    l.b(this.Q, str, str2);
                    List<CreativeInfo> listA = a(str, str2, map, aVar, bArr);
                    if ((listA == null || listA.isEmpty()) && com.safedk.android.analytics.brandsafety.creatives.h.a(str2)) {
                        this.L.put(str, str2);
                        this.L.put(I(str), str2);
                    }
                    if (listA != null && !listA.isEmpty()) {
                        for (CreativeInfo creativeInfo : listA) {
                            Logger.d(this.j, "ci saved id=" + creativeInfo.N() + ", is multi ad? " + creativeInfo.al() + ", video url=" + creativeInfo.J());
                            if (d(creativeInfo)) {
                                m(creativeInfo.N());
                            }
                            if (this.h != null) {
                                Logger.d(this.j, "Calling event listener onPrefetchReceived for " + this.Q);
                                this.h.a(this.Q, str2, creativeInfo.n() != null ? creativeInfo.n() : creativeInfo.N());
                            }
                        }
                        i();
                    }
                    return listA;
                }
            } catch (Throwable th) {
                Logger.d(this.j, "generate info error parsing. msg: " + th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String f(String str) {
        if (this.i == null || !z(str)) {
            return null;
        }
        Logger.d(this.j, "Calling event listener shouldOverridePrefetch for " + this.Q);
        return this.i.a(this.Q);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean z(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void c(CreativeInfo creativeInfo) {
        HashSet<String> hashSetU = creativeInfo.u();
        com.safedk.android.utils.n.b(this.j, "handle previously saved vast ad tag uri - ci VastAdTagUri list= " + hashSetU);
        if (hashSetU != null) {
            int size = hashSetU.size();
            for (String str : hashSetU) {
                String strRemove = this.L.remove(str);
                if (strRemove == null) {
                    strRemove = this.L.remove(I(str));
                }
                Logger.d(this.j, "handle previously saved vast ad tag uri - vastAdTagUriValue found?=" + strRemove);
                if (strRemove != null) {
                    Logger.d(this.j, "handle previously saved vast ad tag uri - vastAdTagUriValue found, updating vast ci");
                    a(creativeInfo, str, strRemove, true);
                }
            }
            if (size < hashSetU.size()) {
                c(creativeInfo);
            }
        }
    }

    private CreativeInfo B(String str) {
        CreativeInfo creativeInfoRemove = null;
        com.safedk.android.analytics.brandsafety.creatives.i iVarC = c(new com.safedk.android.analytics.brandsafety.creatives.i(str));
        if (this.D.containsKey(iVarC)) {
            Logger.d(this.j, "vasts redirect url found: " + str);
            synchronized (this.D) {
                creativeInfoRemove = this.D.remove(iVarC);
            }
            a(iVarC);
            ScheduledFuture<?> scheduledFutureRemove = this.N.remove(iVarC);
            if (scheduledFutureRemove != null) {
                Logger.d(this.j, "canceling vast ad url timer. url: " + iVarC);
                scheduledFutureRemove.cancel(true);
            }
        }
        return creativeInfoRemove;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(WeakReference<View> weakReference, String str, BrandSafetyUtils.AdType adType) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(Object obj) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(String str, String str2, WeakReference<WebView> weakReference) {
        return c(str, str2);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String c(String str, String str2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(Object obj, Object obj2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Pair<String, List<String>> a(Set<String> set) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public int h(String str) {
        return 0;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(String str, String str2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(FileInputStream fileInputStream, String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a() {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(Object obj, Object obj2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String b(Object obj) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(FileInputStream fileInputStream, FileDescriptor fileDescriptor) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String e(String str, String str2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void c(View view) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(View view) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public AdNetworkDiscovery.WebViewResourceMatchingMethod b() {
        return AdNetworkDiscovery.WebViewResourceMatchingMethod.DEFAULT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean e(View view) {
        if (!BannerFinder.c(view)) {
            return false;
        }
        Logger.d(this.j, "is ad view: " + view.getClass().getName() + " is an instance of a Max native ad view, isOnUiThread = " + com.safedk.android.utils.n.c());
        return true;
    }

    public static String E(String str) {
        String strA;
        String strA2 = null;
        try {
            if (str.contains(c) && (strA2 = a(com.safedk.android.utils.g.aL(), str)) == null) {
                strA2 = a(com.safedk.android.utils.g.aM(), str);
            }
            if (str.contains(d) && (strA2 = a(com.safedk.android.utils.g.aN(), str)) != null) {
                Logger.d(b, "LiftoffOuterEnv.init url found : " + strA2);
            }
            strA = com.safedk.android.utils.n.z(strA2);
        } catch (Throwable th) {
            Logger.d(b, "Exception while getting click_url from dsp ad : " + th.getMessage(), th);
            strA = strA2;
        }
        if (strA == null || strA.isEmpty()) {
            strA = a(com.safedk.android.utils.g.aQ(), str);
        }
        return com.safedk.android.utils.n.z(strA);
    }

    protected String F(String str) {
        if (!str.contains(c)) {
            return null;
        }
        String strA = a(com.safedk.android.utils.g.aO(), str);
        Logger.d(this.j, "packageName updated : " + strA);
        return strA;
    }

    protected static String a(Pattern pattern, String str) {
        try {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find() && matcher.groupCount() > 0) {
                Logger.d(b, "extract substring via pattern found pattern=" + pattern + " , value = " + matcher.group(1));
                return matcher.group(1);
            }
        } catch (Throwable th) {
            Logger.d(b, "Exception while extracting with regex : " + th.getMessage() + ", pattern : " + pattern, th);
        }
        return null;
    }

    protected boolean a(CreativeInfo creativeInfo, com.safedk.android.analytics.brandsafety.creatives.h.a aVar, String str) {
        return a(creativeInfo, aVar, str, (String) null);
    }

    protected boolean a(final CreativeInfo creativeInfo, final com.safedk.android.analytics.brandsafety.creatives.h.a aVar, String str, String str2) {
        if (aVar == null || creativeInfo == null) {
            return false;
        }
        com.safedk.android.utils.n.b(this.j, "updating vast, url : " + str + ", CI: " + creativeInfo.aa() + ", vast ad info: " + aVar);
        if (str2 == null) {
            creativeInfo.a("vst", new com.safedk.android.analytics.brandsafety.l.a[0]);
        } else {
            creativeInfo.a("vst", new com.safedk.android.analytics.brandsafety.l.a("typ", str2));
        }
        boolean z2 = !creativeInfo.B();
        creativeInfo.c(true);
        if (z2) {
            String strC = aVar.c();
            if (strC != null) {
                creativeInfo.l(strC);
                if (this.C.b(AdNetworkConfiguration.SHOULD_REPORT_VAST_ID_AS_CREATIVE_ID)) {
                    creativeInfo.k(strC);
                }
            }
            String strD = aVar.d();
            if (strD != null) {
                creativeInfo.o(strD);
            }
            List<String> listI = aVar.i();
            if (listI != null) {
                for (String str3 : listI) {
                    if (com.safedk.android.analytics.brandsafety.creatives.g.a(creativeInfo.S(), str3)) {
                        Logger.d(this.j, "adding impression url to dsp domains : " + str3);
                        creativeInfo.w(str3);
                    }
                }
            } else {
                Logger.d(this.j, "impression list is empty");
            }
            List<String> listP = aVar.p();
            if (listP != null) {
                for (String str4 : listP) {
                    if (com.safedk.android.analytics.brandsafety.creatives.g.a(creativeInfo.S(), str4)) {
                        Logger.d(this.j, "adding video tracking event url to dsp domains : " + str4);
                        creativeInfo.w(str4);
                    }
                    b(creativeInfo, str4);
                }
            } else {
                Logger.d(this.j, "No video tracking events");
            }
            List<String> listQ = aVar.q();
            if (listQ != null) {
                for (String str5 : listQ) {
                    if (com.safedk.android.analytics.brandsafety.creatives.g.a(creativeInfo.S(), str5)) {
                        Logger.d(this.j, "adding click tracking url to dsp domains : " + str5);
                        creativeInfo.w(str5);
                    }
                }
            } else {
                Logger.d(this.j, "no click tracking urls");
            }
            List<String> listR = aVar.r();
            if (listR != null) {
                for (String str6 : listR) {
                    if (com.safedk.android.analytics.brandsafety.creatives.g.a(creativeInfo.S(), str6)) {
                        Logger.d(this.j, "adding companion click tracking url to dsp domains : " + str6);
                        creativeInfo.w(str6);
                    }
                }
            } else {
                Logger.d(this.j, "no companion click tracking urls");
            }
        }
        String strE = aVar.e();
        if (strE != null) {
            String strReplace = strE.replace(Marker.ANY_NON_NULL_MARKER, "%2B");
            String strA = com.safedk.android.utils.n.A(strE);
            String strA2 = com.safedk.android.utils.n.A(strReplace);
            com.safedk.android.utils.n.b(this.j, "following vast uri: " + strA);
            com.safedk.android.utils.n.b(this.j, "following vast uri (replaced plus): " + strA2);
            com.safedk.android.analytics.brandsafety.creatives.f fVar = new com.safedk.android.analytics.brandsafety.creatives.f(strE);
            final com.safedk.android.analytics.brandsafety.creatives.f fVar2 = new com.safedk.android.analytics.brandsafety.creatives.f(strA);
            com.safedk.android.analytics.brandsafety.creatives.f fVar3 = new com.safedk.android.analytics.brandsafety.creatives.f(strA2);
            synchronized (this.D) {
                this.D.put(fVar, creativeInfo);
                this.D.put(fVar2, creativeInfo);
                this.D.put(fVar3, creativeInfo);
            }
            com.safedk.android.analytics.brandsafety.creatives.h.c.remove(fVar);
            com.safedk.android.analytics.brandsafety.creatives.h.c.remove(fVar2);
            com.safedk.android.analytics.brandsafety.creatives.h.c.remove(fVar3);
            a(str, (com.safedk.android.analytics.brandsafety.creatives.i) fVar);
            a(str, (com.safedk.android.analytics.brandsafety.creatives.i) fVar2);
            a(str, (com.safedk.android.analytics.brandsafety.creatives.i) fVar3);
            Logger.d(this.j, "adding vast ad url to list. url: " + fVar2 + ", ci: " + creativeInfo.aa());
            creativeInfo.B(strE);
            if (z2 || !this.C.b(AdNetworkConfiguration.DOWNLOAD_INNER_VAST_URL_IF_NOT_LOADED)) {
                return true;
            }
            Logger.d(this.j, "adding vast ad url timer. url: " + fVar2);
            this.N.put(fVar2, this.M.schedule(new Runnable() { // from class: com.safedk.android.analytics.brandsafety.creatives.discoveries.d.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.d(d.this.j, "timeout of vast ad url timer. url: " + fVar2);
                    String strE2 = aVar.e();
                    String strJ = d.this.J(strE2);
                    com.safedk.android.utils.n.b(d.this.j, "get vast info - ad tag uri content: " + strJ);
                    if (!TextUtils.isEmpty(strJ)) {
                        d.this.a(creativeInfo, com.safedk.android.analytics.brandsafety.creatives.h.b(strJ, true, d.this.Q), strE2, "manual");
                    }
                }
            }, 5L, TimeUnit.SECONDS));
            return true;
        }
        String strA3 = aVar.a();
        String strB = aVar.b();
        if (strA3 != null) {
            creativeInfo.a(strA3, true);
            Logger.d(this.j, "will update click url: " + strA3);
        } else {
            Logger.d(this.j, "click url is empty");
        }
        if (strB != null && !aVar.s()) {
            creativeInfo.p(strB);
            Logger.d(this.j, "will update video url : " + strB);
            if (com.safedk.android.utils.n.i(strB)) {
                String strJ = com.safedk.android.utils.n.j(strB);
                Logger.d(this.j, "google video added : " + strJ);
                this.E.add(strJ);
            } else {
                Logger.d(this.j, "video added : " + strB);
                a(strB, creativeInfo);
                this.E.add(strB);
            }
        } else {
            Logger.d(this.j, "video url is empty");
        }
        List<String> listJ = aVar.j();
        Logger.d(this.j, "vast prefetchResourceUrls : " + listJ);
        if (listJ != null) {
            for (String str7 : listJ) {
                Logger.d(this.j, "vast prefetchResourceUrls item : " + listJ);
                String strA4 = a(str7, creativeInfo);
                if (strA4 != null) {
                    Logger.d(this.j, "will add follow url : " + strA4);
                    this.E.add(strA4);
                }
            }
            creativeInfo.b(listJ);
        } else {
            Logger.d(this.j, "no prefetch resource urls");
        }
        List<String> listK = aVar.k();
        creativeInfo.c(listK);
        Logger.d(this.j, "added static resource : " + listK);
        List<String> listL = aVar.l();
        creativeInfo.c(listL);
        Logger.d(this.j, "added script resource : " + listL);
        List<String> listM = aVar.m();
        creativeInfo.c(listM);
        Logger.d(this.j, "added html resource : " + listM);
        a(creativeInfo, aVar.n());
        if (aVar.s()) {
            creativeInfo.ac();
            Logger.d(this.j, "set params " + aVar.f());
            creativeInfo.E(aVar.f());
        }
        List<String> listH = aVar.h();
        if (listH != null) {
            Logger.d(this.j, "vast media list contains " + listH.toString());
            for (String str8 : listH) {
                Logger.d(this.j, "vast media list item : " + str8);
                String strA5 = a(str8, creativeInfo);
                if (strA5 != null) {
                    Logger.d(this.j, "will add followUrl : " + strA5);
                    this.E.add(strA5);
                }
            }
            creativeInfo.c(listH);
        } else {
            Logger.d(this.j, "no prefetch resource urls");
        }
        com.safedk.android.utils.n.b(this.j, "updated vast CI = " + creativeInfo.aa());
        return true;
    }

    protected void a(String str, com.safedk.android.analytics.brandsafety.creatives.i iVar) {
    }

    protected void a(com.safedk.android.analytics.brandsafety.creatives.i iVar) {
    }

    protected String a(String str, Set<String> set) {
        if (set != null && set.size() > 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                str = com.safedk.android.utils.k.f(str, it.next());
            }
        }
        return str;
    }

    private static String i(String str, String str2) {
        return str.replaceAll("([?&;]+)(" + str2 + "=.*?)(&|$|;)", "$1");
    }

    protected Set<String> b(String str, Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        Map<String, String> mapA = com.safedk.android.utils.k.a(str, false);
        if (mapA != null) {
            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                if (set.contains(entry.getValue())) {
                    Logger.d(this.j, "identified macro : " + entry.getValue());
                    hashSet.add(entry.getKey());
                }
            }
        }
        if (hashSet.size() > 0) {
            Logger.d(this.j, "query params to ignore are " + hashSet);
        }
        return hashSet;
    }

    protected com.safedk.android.analytics.brandsafety.creatives.h.a a(CreativeInfo creativeInfo, String str, String str2, boolean z2) {
        Logger.v(this.j, "updating vast CI: " + creativeInfo.aa() + ", vast xml: " + str2 + ", scan for resources: " + z2);
        boolean zB = CreativeInfoManager.l ? true : CreativeInfoManager.j(creativeInfo.S()).b(AdNetworkConfiguration.SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST);
        Logger.d(this.j, "sdk " + creativeInfo.S() + " config item SHOULD_DECODE_EXTRACTED_EXPRESSIONS_FROM_VAST is " + zB);
        com.safedk.android.analytics.brandsafety.creatives.h.a aVarB = com.safedk.android.analytics.brandsafety.creatives.h.b(str2, zB, creativeInfo.S());
        a(creativeInfo, aVarB, str);
        return aVarB;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> c() {
        return com.safedk.android.utils.a.b;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public com.safedk.android.analytics.brandsafety.creatives.b d() {
        return this.C;
    }

    protected d(String str, String str2) {
        this.D = null;
        this.E = new HashSet();
        this.L = new HashMap();
        this.g = new HashMap();
        this.M = Executors.newScheduledThreadPool(1);
        this.N = new HashMap();
        this.O = new HashMap();
        this.h = null;
        this.i = null;
        this.P = new HashSet();
        this.Q = str;
        String sdkVersionByPackage = SdksMapping.getSdkVersionByPackage(str);
        Logger.d(this.j, "package version updated, package : " + str + ", version : " + sdkVersionByPackage);
        this.G = sdkVersionByPackage;
        this.j = str2;
        try {
            boolean zContains = SafeDK.getInstance().W().contains(str);
            Logger.d(this.j, "Discovery ctor started, packageName : " + str + ", Require data persistence = " + zContains);
            if (zContains) {
                this.D = new PersistentConcurrentHashMap(this.j + "_vastAdTagUriUrlsToFollow");
                Logger.d(this.j, "vast ad tag uri to follow loaded, key set=" + this.D.keySet());
                this.H = new PersistentConcurrentHashMap(this.j + "_adIdToCreatives");
                Logger.d(this.j, "ad id to creatives loaded, key set=" + this.H.keySet());
                this.I = new PersistentConcurrentHashMap(this.j + "_multiAdCreatives");
                Logger.d(this.j, "multi ad creatives loaded, key set=" + this.I.keySet());
                this.J = new PersistentConcurrentHashMap(this.j + "_contentHashCodeToCreatives");
                Logger.d(this.j, "content hash code to creatives loaded, key set=" + this.J.keySet());
                this.K = new PersistentConcurrentHashMap(this.j + "_webviewAddressToCreatives");
                Logger.d(this.j, "webview address to creatives loaded, key set=" + this.K.keySet());
            } else {
                this.D = new ConcurrentHashMap<>();
                Logger.d(this.j, "vast ad tag uri to follow loaded (no persistence)");
                this.H = new ConcurrentHashMap();
                Logger.d(this.j, "ad id to creatives loaded (no persistence)");
                this.I = new ConcurrentHashMap();
                Logger.d(this.j, "multi ad creatives loaded (no persistence)");
                this.J = new ConcurrentHashMap();
                Logger.d(this.j, "content hash code to creatives loaded (no persistence)");
                this.K = new ConcurrentHashMap();
                Logger.d(this.j, "webview address to creatives loaded (no persistence)");
            }
        } catch (InvalidParameterException e2) {
            Logger.e(this.j, "error initializing caching will not be available", e2);
        }
        h();
    }

    private d() {
        this.D = null;
        this.E = new HashSet();
        this.L = new HashMap();
        this.g = new HashMap();
        this.M = Executors.newScheduledThreadPool(1);
        this.N = new HashMap();
        this.O = new HashMap();
        this.h = null;
        this.i = null;
        this.P = new HashSet();
    }

    protected boolean G(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(".mp4") || lowerCase.endsWith(".webm") || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".webp");
    }

    public static String H(String str) {
        return com.safedk.android.utils.k.f(com.safedk.android.utils.n.z(str));
    }

    public static String I(String str) {
        return com.safedk.android.utils.k.f(com.safedk.android.utils.n.A(str));
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(String str, String str2, String str3, String str4) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean i(String str) {
        if (b(new com.safedk.android.analytics.brandsafety.creatives.i(str))) {
            return true;
        }
        return b(new com.safedk.android.analytics.brandsafety.creatives.i(I(str)));
    }

    public boolean b(com.safedk.android.analytics.brandsafety.creatives.i iVar) {
        com.safedk.android.analytics.brandsafety.creatives.i iVarC = c(iVar);
        boolean z2 = this.D.containsKey(iVarC) || com.safedk.android.analytics.brandsafety.creatives.h.c.contains(iVarC);
        if (z2) {
            Logger.d(this.j, "is VIV Url result is true for url " + iVarC);
        }
        return z2;
    }

    private com.safedk.android.analytics.brandsafety.creatives.i c(com.safedk.android.analytics.brandsafety.creatives.i iVar) {
        String[] strArrD = CreativeInfoManager.d(this.Q);
        if (strArrD != null && strArrD.length > 0) {
            String strA = com.safedk.android.utils.k.a(iVar.toString(), strArrD);
            if (!strA.equals(iVar.toString())) {
                com.safedk.android.utils.n.b(this.j, "removeVastAdTagUriQueryParamsIfNecessary , query params removed (" + Arrays.toString(strArrD) + ") in url " + iVar.toString());
                return new com.safedk.android.analytics.brandsafety.creatives.i(strA);
            }
            return iVar;
        }
        return iVar;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<String> e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(F);
        return arrayList;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(Bundle bundle) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean j(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(View view, BrandSafetyUtils.AdType adType) {
        String strA;
        if (!e(view)) {
            strA = null;
        } else {
            String name = view.getClass().getName();
            Logger.d(this.j, "get ad ID from view started, ad view: " + view);
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList<String> arrayList = f.get(name);
            if (arrayList == null) {
                strA = null;
            } else {
                Logger.d(this.j, "get ad ID from view, found previous traversal path of " + name + ": " + arrayList);
                strA = a(adType, arrayList, view);
            }
            if (strA == null) {
                HashSet hashSet = new HashSet();
                ArrayList<String> arrayList2 = new ArrayList<>();
                strA = a(adType, view, arrayList2, hashSet);
                if (strA != null) {
                    f.put(name, arrayList2);
                    com.safedk.android.utils.n.b(this.j, "get ad ID from view, saving traversal path of " + name + " for later use: " + arrayList2);
                }
            }
            Logger.d(this.j, "get ad ID from view - travel time " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms");
        }
        if (strA != null) {
            Logger.d(this.j, "get ad ID from view - ad ID: " + strA);
        }
        return strA;
    }

    protected String j() {
        return null;
    }

    protected String a(BrandSafetyUtils.AdType adType, Object obj, List<String> list, Set<Object> set) {
        String strJ = j();
        if (strJ == null || obj == null || set.contains(obj)) {
            return null;
        }
        set.add(obj);
        Class<?> superclass = obj.getClass();
        ArrayList<Field> arrayList = new ArrayList();
        boolean zA = CreativeInfoManager.a(this.Q, AdNetworkConfiguration.SHOULD_ALLOW_REFLECTION_ON_OS_CLASSES, false);
        while (true) {
            arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
            superclass = superclass.getSuperclass();
            if (superclass == null || (!superclass.getName().startsWith(strJ) && !zA)) {
                break;
            }
        }
        for (Field field : arrayList) {
            field.setAccessible(true);
            try {
                Object obj2 = field.get(obj);
                if (obj2 == null) {
                    continue;
                } else if (obj2.getClass().getName().startsWith(strJ)) {
                    list.add(field.getName());
                    String strA = a(adType, obj2, list, set);
                    if (strA == null) {
                        list.remove(list.size() - 1);
                    } else {
                        return strA;
                    }
                } else {
                    String strA2 = a(adType, obj2, field.getName());
                    if (strA2 != null) {
                        Logger.d(this.j, "extract ad info, adId =  " + strA2);
                        list.add(field.getName());
                        return strA2;
                    }
                    continue;
                }
            } catch (Throwable th) {
                Logger.d(this.j, "Exception in extract ad info : " + th.getClass().getName() + ", " + th.getMessage());
            }
        }
        return null;
    }

    private String a(BrandSafetyUtils.AdType adType, ArrayList<String> arrayList, Object obj) {
        Field declaredField;
        try {
            String strJ = j();
            if (strJ == null || arrayList == null || obj == null) {
                return null;
            }
            Logger.d(this.j, "extract ad info using saved traversal path: " + arrayList);
            Field field = null;
            for (String str : arrayList) {
                if (obj == null) {
                    return null;
                }
                Class<?> superclass = obj.getClass();
                Field field2 = null;
                while (true) {
                    try {
                        declaredField = superclass.getDeclaredField(str);
                    } catch (NoSuchFieldException e2) {
                        superclass = superclass.getSuperclass();
                        declaredField = field2;
                    }
                    if (declaredField != null || superclass == null || !superclass.getName().startsWith(strJ)) {
                        break;
                    }
                    field2 = declaredField;
                }
                if (declaredField == null) {
                    Logger.d(this.j, "extract ad info using saved traversal path, field not found");
                    return null;
                }
                declaredField.setAccessible(true);
                obj = declaredField.get(obj);
                field = declaredField;
            }
            if (obj != null && field != null) {
                return a(adType, obj, field.getName());
            }
        } catch (Throwable th) {
            Logger.e(this.j, "extract ad info exception: " + th.getMessage(), th);
        }
        return null;
    }

    protected String a(BrandSafetyUtils.AdType adType, Object obj, String str) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String f() {
        return this.j;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public WeakReference<WebView> a(List<WeakReference<WebView>> list, String str) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    public void i() {
        Logger.d(this.j, "base clear old CIs started");
        com.safedk.android.utils.e.a(this.D, this.j + ":vastAdTagUriUrlsToFollow");
        com.safedk.android.utils.e.a(this.H, this.j + ":adIdToCreatives");
        com.safedk.android.utils.e.a(this.I, this.j + ":multiAdCreatives");
        com.safedk.android.utils.e.a(this.J, this.j + ":contentHashCodeToCreatives");
        com.safedk.android.utils.e.a(this.K, this.j + ":webviewAddressToCreatives");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(View view) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(View view) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, String str2) {
        return true;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str) {
        return str.startsWith(w);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean b(String str) {
        return str.endsWith("checkpoint.0");
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean c(String str) {
        return str.endsWith(y) || str.endsWith(z);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean d(String str) {
        return str.endsWith(e);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public RedirectDetails.RedirectType k(String str) {
        return RedirectDetails.RedirectType.REDIRECT;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String l(String str) {
        return str;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void e(String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(com.safedk.android.analytics.brandsafety.e eVar, List<String> list, String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public BrandSafetyUtils.AdType f(View view) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public long a(CreativeInfo creativeInfo) {
        return SafeDK.getInstance().D();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, Object obj) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean m(String str) {
        return false;
    }

    public boolean a(String str, String str2, ConcurrentHashMap<String, WeakReference<WebView>> concurrentHashMap, ConcurrentHashMap<String, CreativeInfo> concurrentHashMap2, String str3) {
        try {
            com.safedk.android.utils.n.b(this.j, "try reverse matching: source: " + str);
            com.safedk.android.utils.n.b(this.j, "try reverse matching: dataToWebviewRef keys: " + concurrentHashMap.keySet());
            if (str == null || !concurrentHashMap.containsKey(str)) {
                Logger.d(this.j, "try reverse matching: source is null or not in sourceToWebviewRef");
                return false;
            }
            WeakReference<WebView> weakReference = concurrentHashMap.get(str);
            if (!com.safedk.android.utils.n.a((Reference<?>) weakReference)) {
                Logger.d(this.j, "try reverse matching: webViewRef is null or points to null - webviewRef: " + weakReference);
                return false;
            }
            com.safedk.android.utils.n.b(this.j, "try reverse matching: keyToCIsMap keys: " + concurrentHashMap2.keySet());
            WebView webView = weakReference.get();
            if (concurrentHashMap2.containsKey(str)) {
                CreativeInfo creativeInfo = concurrentHashMap2.get(str);
                if (creativeInfo != null) {
                    String strN = creativeInfo.N();
                    if ((str3.equals(s) && c(webView, strN)) || (str3.equals(t) && !a(webView, strN).isEmpty())) {
                        Logger.d(this.j, "try reverse matching: found a match using reverse! adId=" + strN);
                        return true;
                    }
                }
            } else {
                Logger.d(this.j, "try reverse matching: keyToCIsMap does not contain source");
                com.safedk.android.utils.n.b(this.j, "try reverse matching: keyToCIsMap keys are: " + concurrentHashMap2.keySet());
            }
            return false;
        } catch (Throwable th) {
            com.safedk.android.utils.n.b(this.j, "try reverse matching encountered exception: " + th);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void n(String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void o(String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public View g(View view) {
        return null;
    }

    public boolean h(View view) {
        if (view == null || !view.getClass().getName().contains("exoplayer")) {
            return false;
        }
        Logger.d(this.j, "native video player identified, view: " + view);
        return true;
    }

    public boolean i(View view) {
        boolean z2;
        if (view.getClass().getName().contains("exoplayer")) {
            return false;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z2 = true;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                z2 = z2 && i(viewGroup.getChildAt(i));
            }
        } else {
            z2 = true;
        }
        return z2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(WebView webView, Object obj) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(Object obj, String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public WeakReference<View> a(com.safedk.android.analytics.brandsafety.d dVar) {
        return this.O.get(dVar);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(com.safedk.android.analytics.brandsafety.d dVar, List<WeakReference<View>> list) {
        for (WeakReference<View> weakReference : list) {
            if (weakReference != null && weakReference.get() != null && (weakReference.get() instanceof MaxNativeAdView)) {
                Logger.d(this.j, "save screenshot view - saving view= " + weakReference.get() + ", with key= " + dVar);
                this.O.put(dVar, new WeakReference<>(weakReference.get()));
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(View view, int i, int i2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo c(Object obj, Object obj2) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean p(String str) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void f(String str, String str2) {
        Set<String> hashSet = this.g.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.g.put(str, hashSet);
        }
        hashSet.add(str2);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(WebView webView, String str) {
        String strA = BrandSafetyUtils.a((Object) webView);
        List<CreativeInfo> listS = s(str);
        Logger.d(this.j, "adIdFoundOnResource - ad id: " + str + " ci: " + listS);
        if (this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_BANNER_MULTIPLE_WEBVIEWS)) {
            f(str, strA);
        }
        if (listS.isEmpty()) {
            Logger.d(this.j, "adIdFoundOnResource - ci list is empty, exiting");
            return listS;
        }
        boolean z2 = false;
        Iterator<CreativeInfo> it = listS.iterator();
        while (true) {
            boolean z3 = z2;
            if (it.hasNext()) {
                CreativeInfo next = it.next();
                com.safedk.android.utils.n.b(this.j, "Ad identified, ci : " + next.aa());
                BrandSafetyUtils.AdType adTypeM = next.M();
                next.a((Object) webView);
                if (adTypeM == BrandSafetyUtils.AdType.INTERSTITIAL || adTypeM == BrandSafetyUtils.AdType.BANNER || adTypeM == BrandSafetyUtils.AdType.MREC) {
                    com.safedk.android.utils.n.b(this.j, "Ad identified, setting creative in ad finder, adType=" + adTypeM + ", click url=" + next.O());
                    boolean zA = z3 | CreativeInfoManager.a(next, CreativeInfo.l);
                    next.b(this.J);
                    z2 = zA;
                } else if (strA != null) {
                    Logger.d(this.j, "Linking ad id " + str + " to web view " + strA);
                    synchronized (this.K) {
                        this.K.put(strA, next);
                    }
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                n(str);
                return listS;
            }
        }
    }

    protected boolean c(WebView webView, String str) {
        boolean z2 = false;
        String strA = BrandSafetyUtils.a((Object) webView);
        List<CreativeInfo> listS = s(str);
        Logger.d(this.j, "ad ID found on data loaded - ad id: " + str + " ci: " + listS);
        if (listS.isEmpty()) {
            Logger.d(this.j, "ad ID found on data loaded - ci list is empty, exiting");
            return false;
        }
        Iterator<CreativeInfo> it = listS.iterator();
        while (true) {
            boolean zA = z2;
            if (it.hasNext()) {
                CreativeInfo next = it.next();
                if (next.M() == BrandSafetyUtils.AdType.INTERSTITIAL || next.M() == BrandSafetyUtils.AdType.BANNER || next.M() == BrandSafetyUtils.AdType.MREC) {
                    next.b(this.J);
                    next.a((Object) webView);
                    zA |= CreativeInfoManager.a(next, CreativeInfo.l);
                    if (next.M() == BrandSafetyUtils.AdType.INTERSTITIAL) {
                        SafeDKWebAppInterface.a(strA);
                    }
                }
                z2 = zA;
            } else {
                n(str);
                return true;
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(String str, com.safedk.android.analytics.brandsafety.e eVar) {
        if (eVar.x() != null) {
            Iterator<String> it = this.g.keySet().iterator();
            while (it.hasNext()) {
                Set<String> set = this.g.get(it.next());
                if (set != null && set.contains(str)) {
                    Iterator<String> it2 = eVar.x().iterator();
                    while (it2.hasNext()) {
                        if (set.contains(it2.next())) {
                            Logger.d(this.j, "should verify matching multiple webViews: found multiple webview addresses for one banner. webViewAddresses: " + set + ", views hierarchy: " + eVar.x());
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public Set<String> q(String str) {
        if (str != null) {
            Iterator<String> it = this.g.keySet().iterator();
            while (it.hasNext()) {
                Set<String> set = this.g.get(it.next());
                if (set != null && set.contains(str)) {
                    Logger.d(this.j, "getAllWebViewsForBanner: found multiple webviews. webviewAddress= " + str + ", addresses= " + set);
                    return set;
                }
            }
        }
        return new HashSet();
    }

    private void e(CreativeInfo creativeInfo) {
        a(creativeInfo, creativeInfo.N());
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(CreativeInfo creativeInfo, String str) {
        List<CreativeInfo> arrayList = this.I.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            synchronized (this.I) {
                this.I.put(str, arrayList);
            }
        }
        Logger.d(this.j, "storing creative info to multi ad CI list: " + creativeInfo.aa());
        synchronized (arrayList) {
            arrayList.add(creativeInfo);
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean d(CreativeInfo creativeInfo) {
        if (creativeInfo != null && creativeInfo.N() != null) {
            synchronized (this.H) {
                if (creativeInfo.al()) {
                    e(creativeInfo);
                    if (this.H.containsKey(creativeInfo.N())) {
                        return false;
                    }
                }
                if (this.H.containsKey(creativeInfo.N())) {
                    com.safedk.android.utils.n.b(this.j, "store creative info, ad key exists : " + creativeInfo.N());
                }
                this.H.put(creativeInfo.N(), creativeInfo);
                com.safedk.android.utils.n.b(this.j, "store creative info, CI stored, ID: " + creativeInfo.N());
                if (creativeInfo.a(this.J)) {
                    Logger.d(this.j, "store creative info, storing creative info with hashcode: " + creativeInfo.U() + ", CI: " + creativeInfo.aa());
                } else {
                    Logger.d(this.j, "store creative info, creative info content hashcode is null, cannot store it.");
                }
                return true;
            }
        }
        Logger.d(this.j, "store Creative Info creative info is null or CIs ID is null, cannot store it.");
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> s(String str) {
        CreativeInfo creativeInfo;
        ArrayList arrayList = new ArrayList();
        synchronized (this.H) {
            com.safedk.android.utils.n.b(this.j, "get CIs by ad id keys : " + this.H.keySet());
            creativeInfo = this.H.get(str);
        }
        if (creativeInfo != null) {
            if (this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE)) {
                Logger.d(this.j, "get CIs by ad id, reset expiration time as network support prefetch reuse. ci id = " + creativeInfo.N());
                creativeInfo.af();
            } else {
                com.safedk.android.utils.n.b(this.j, "get CIs by ad id retrieved ci for " + str + ", ci : " + creativeInfo.aa());
            }
            com.safedk.android.utils.n.b(this.j, "get CIs by ad id, ci: " + creativeInfo.aa() + ", is multiple ad: " + creativeInfo.al());
            List<CreativeInfo> listT = t(str);
            if (!creativeInfo.al() || listT == null || listT.isEmpty()) {
                arrayList.add(creativeInfo);
            } else {
                arrayList.addAll(listT);
                Iterator<CreativeInfo> it = listT.iterator();
                while (it.hasNext()) {
                    it.next().am();
                }
            }
        }
        Logger.d(this.j, "get CIs by ad id, number of CIs: " + arrayList.size() + ", ad id: " + str);
        return arrayList;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> t(String str) {
        return this.I.get(str);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(int i) {
        CreativeInfo creativeInfoRemove;
        List<CreativeInfo> listRemove;
        ArrayList arrayList = new ArrayList();
        synchronized (this.J) {
            creativeInfoRemove = this.J.remove(Integer.valueOf(i));
        }
        if (creativeInfoRemove != null) {
            arrayList.add(creativeInfoRemove);
            if (creativeInfoRemove.al()) {
                synchronized (this.I) {
                    listRemove = this.I.remove(creativeInfoRemove.N());
                }
                if (listRemove != null) {
                    arrayList.addAll(listRemove);
                }
            }
        }
        Logger.d(this.j, "get CIs by hash code, number of CIs: " + arrayList.size() + ", hash code: " + i);
        return arrayList;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> u(String str) {
        List<CreativeInfo> listRemove;
        if (str == null) {
            return null;
        }
        synchronized (this.I) {
            listRemove = this.I.remove(str);
        }
        return listRemove;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public List<CreativeInfo> a(String str, String str2, WebView webView) {
        String strA = a(str, str2, new WeakReference<>(webView));
        return strA != null ? a(webView, strA) : new ArrayList();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(String str, String str2, BrandSafetyEvent.AdFormatType adFormatType, Object obj) {
        String strC = c(str2, str2);
        if (strC != null) {
            com.safedk.android.utils.n.b(this.j, "handling shown ad by api, format: " + adFormatType + ", ad id: " + strC);
            if (adFormatType == BrandSafetyEvent.AdFormatType.INTER || adFormatType == BrandSafetyEvent.AdFormatType.NATIVE) {
                for (CreativeInfo creativeInfo : s(strC)) {
                    creativeInfo.a(obj);
                    CreativeInfoManager.a(creativeInfo, CreativeInfo.m);
                }
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void d(Object obj, Object obj2) {
        CreativeInfo creativeInfoA = a(obj);
        if (creativeInfoA != null) {
            Logger.d(this.j, "ad object ready impl, calling set creative in ad finder with " + creativeInfoA);
            AdNetworkDiscovery adNetworkDiscoveryI = CreativeInfoManager.i(this.Q);
            if (adNetworkDiscoveryI != null) {
                CreativeInfoManager.a(adNetworkDiscoveryI, creativeInfoA, obj2);
            }
            if ((BrandSafetyUtils.AdType.NATIVE.equals(creativeInfoA.M()) && obj2 == null) ? false : true) {
                r(creativeInfoA.N());
                return;
            }
            return;
        }
        Logger.d(this.j, "ad object ready impl, no CI returned.");
        a(obj, obj2);
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String a(WebView webView, String str, String str2) {
        return str2;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(String str, String str2, WebView webView) {
        String strL = com.safedk.android.utils.k.l(str2);
        Logger.d(this.j, "data loaded to webView: " + webView + ", package: " + this.Q);
        String strA = a(strL, str, new WeakReference<>(webView));
        Logger.d(this.j, "data loaded to webView ad id " + strA);
        String strA2 = BrandSafetyUtils.a((Object) webView);
        if (strA != null) {
            c(webView, strA);
            return;
        }
        int iH = h(str2);
        Logger.d(this.j, "Trying to match by hashcode: " + iH);
        for (CreativeInfo creativeInfo : a(iH)) {
            Logger.d(this.j, "getting Base64 resources");
            Iterator<String> it = com.safedk.android.utils.n.h(str2).iterator();
            while (it.hasNext()) {
                com.safedk.android.analytics.brandsafety.creatives.g.a(creativeInfo.S(), webView, it.next(), (Map<String, String>) null);
            }
            creativeInfo.a((Object) webView);
            if (!this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE)) {
                synchronized (this.H) {
                    this.H.remove(creativeInfo.N());
                }
            }
            if (creativeInfo.M() == BrandSafetyUtils.AdType.INTERSTITIAL) {
                SafeDKWebAppInterface.a(strA2);
            }
            if (TextUtils.isEmpty(strA2)) {
                Logger.d(this.j, "webView address is empty - can't link creative info to webview");
            }
            Logger.d(this.j, "linking " + creativeInfo.U() + " to web view " + strA2);
            synchronized (this.K) {
                this.K.put(strA2, creativeInfo);
            }
            if (creativeInfo.M() == BrandSafetyUtils.AdType.INTERSTITIAL || creativeInfo.M() == BrandSafetyUtils.AdType.BANNER || creativeInfo.M() == BrandSafetyUtils.AdType.MREC) {
                CreativeInfoManager.a(creativeInfo, CreativeInfo.j, String.valueOf(creativeInfo.U()));
            }
        }
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void r(String str) {
        CreativeInfo creativeInfoRemove;
        Logger.d(this.j, "remove CIs by ad id, started, ci id = " + str);
        if (str != null) {
            synchronized (this.H) {
                if (this.C.b(AdNetworkConfiguration.AD_NETWORK_SUPPORTS_PREFETCH_REUSE)) {
                    creativeInfoRemove = this.H.get(str);
                    if (creativeInfoRemove != null) {
                        Logger.d(this.j, "remove CIs by ad id, reset expiration time as network support prefetch reuse. ci id = " + creativeInfoRemove.N() + ", ad type = " + creativeInfoRemove.M());
                        creativeInfoRemove.af();
                    }
                } else {
                    creativeInfoRemove = this.H.remove(str);
                    if (creativeInfoRemove != null) {
                        Logger.d(this.j, "remove CIs by ad id, ci removed. ci id = " + creativeInfoRemove.N() + ", ad type = " + creativeInfoRemove.M());
                    } else {
                        Logger.d(this.j, "remove CIs by ad id, ci not found, id = " + str);
                    }
                }
            }
            if (creativeInfoRemove != null) {
                creativeInfoRemove.b(this.J);
                creativeInfoRemove.c(this.K);
            }
        }
    }

    protected static boolean a(String str, CreativeInfo creativeInfo, Map<Integer, Set<CreativeInfo>> map) {
        Iterator<Map.Entry<Integer, Set<CreativeInfo>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Set<CreativeInfo>> next = it.next();
            if (next.getValue() != null && next.getValue().contains(creativeInfo)) {
                Logger.d(str, "is matched by media player - removing ci id= " + creativeInfo.N() + ",   video url= " + next.getKey());
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected void b(CreativeInfo creativeInfo, String str) {
    }

    protected void a(CreativeInfo creativeInfo, List<String> list) {
    }

    protected static void b(String str, CreativeInfo creativeInfo, Map<String, CreativeInfo> map) {
        Iterator<Map.Entry<String, CreativeInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, CreativeInfo> next = it.next();
            if (next.getValue() == creativeInfo) {
                Logger.d(str, "remove ci from collection - key to remove: " + next.getKey() + ",    ci to remove: " + creativeInfo.aa());
                it.remove();
            }
        }
    }

    protected static void c(String str, CreativeInfo creativeInfo, Map<?, Set<CreativeInfo>> map) {
        Iterator<Map.Entry<?, Set<CreativeInfo>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, Set<CreativeInfo>> next = it.next();
            if (next.getValue() != null && next.getValue().contains(creativeInfo)) {
                Logger.d(str, "remove ci from collection set - key to remove: " + next.getKey() + ",    ci to remove: " + creativeInfo.aa());
                it.remove();
            }
        }
    }

    protected String J(String str) {
        InputStream inputStreamOpenStream = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            Logger.d(this.j, "downloadUrl fetching " + str);
            inputStreamOpenStream = new URL(str).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                stringBuffer.append(line);
            }
            inputStreamOpenStream.close();
        } catch (Throwable th) {
            try {
                Logger.d(this.j, "Exception in downloadUrl : " + th.getMessage(), th);
                if (inputStreamOpenStream != null) {
                    inputStreamOpenStream.close();
                }
            } catch (Throwable th2) {
                Logger.d(this.j, "Exception in downloadUrl inner : " + th.getMessage(), th);
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public boolean a(com.safedk.android.analytics.brandsafety.c cVar) {
        return false;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void b(WebView webView, String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public HashMap<Integer, String> g() {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String v(String str) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void w(String str) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void a(WebView webView) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo c(Object obj) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void g(String str, String str2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public String x(String str) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void h(String str, String str2) {
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public CreativeInfo a(SimpleConcurrentHashSet<String> simpleConcurrentHashSet) {
        return null;
    }

    @Override // com.safedk.android.analytics.brandsafety.creatives.AdNetworkDiscovery
    public void y(String str) {
        try {
            l.c(str);
        } catch (Exception e2) {
            Logger.d(this.j, "interceptXmlHttpRequest - encountered exception= " + e2);
        }
    }
}

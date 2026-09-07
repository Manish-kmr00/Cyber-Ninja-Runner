package com.safedk.android.analytics.events;

import android.os.Bundle;
import android.text.TextUtils;
import com.json.b9;
import com.safedk.android.SafeDK;
import com.safedk.android.analytics.StatsCollector;
import com.safedk.android.analytics.brandsafety.BrandSafetyUtils;
import com.safedk.android.analytics.brandsafety.RedirectData;
import com.safedk.android.analytics.brandsafety.creatives.AdNetworkConfiguration;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import com.safedk.android.analytics.brandsafety.creatives.infos.CreativeInfo;
import com.safedk.android.analytics.brandsafety.l;
import com.safedk.android.analytics.events.base.StatsEvent;
import com.safedk.android.utils.Logger;
import com.safedk.android.utils.SimpleConcurrentHashSet;
import com.safedk.android.utils.d;
import com.safedk.android.utils.h;
import com.safedk.android.utils.k;
import com.safedk.android.utils.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class BrandSafetyEvent extends StatsEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8120a = "click_url";
    public static final String aI = "revenue_event";
    public static final String aP = "webview_resource_urls";
    public static final String aQ = "webview_resource_urls_expanded";
    public static final String aR = "ci_matching_method";
    private static final String a_ = "BrandSafetyEvent";
    public static final String ac = "max_network_name";
    public static final String ad = "network_name";
    public static final String ae = "dsp_name";
    public static final String af = "custom_js_network_name";
    public static final String ag = "is_first_session";
    public static final String ah = "event_id";
    public static final String ao = "max_creative_id";
    public static final String ap = "creative_id";
    public static final String aq = "did_fail_display_received";
    public static final String ar = "will_display_received";
    public static final String as = "is_banner_view_detected";
    public static final String at = "image_slot";
    public static final String au = "interval_between_display_messages";
    public static final String av = "detected_view_proportions";
    public static final String aw = "device_orientation";
    public static final String ay = "multi_ad_uuid";
    public static final String b = "foreground_activity";
    private static final String bc = "REWARD";
    public static final String c = "impression_id";
    public static final String d = "viewing_time";
    public static final String f = "zone_id";
    public static final String g = "app_package_name";
    public static final String h = "dsp_domains";
    public static final String i = "ad_format";
    public static final String j = "ad_format_type";
    public static final String k = "third_party_ad_placement_id";
    public static final String m = "sdk_version";
    public static final String n = "impression";
    public static final String o = "image_file_size";
    public static final String p = "image_uniformity";
    public static final String q = "image_id";
    public static final String r = "image_orientation";
    public static final String s = "is_animated";
    private static final long serialVersionUID = 2;
    public static final String t = "is_clicked";
    public static final String u = "ad_recommendations";
    public static final String v = "is_next_session";
    private int L;
    private String M;
    private String N;
    private transient Bundle O;
    private String P;
    private String Q;
    private long R;
    private String S;
    private String T;
    private String U;
    private boolean V;
    private String W;
    private boolean X;
    private long Y;
    private float Z;
    private String aA;
    private String aB;
    private String aC;
    private String aD;
    private String aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    String aT;
    HashSet<String> aU;
    Boolean aV;
    HashSet<String> aW;
    HashSet<String> aX;
    HashSet<String> aY;
    HashSet<String> aZ;
    private BrandSafetyUtils.ScreenShotOrientation aa;
    private boolean ai;
    private boolean aj;
    private int ak;
    private long al;
    private float am;
    private String an;
    Boolean ba;
    HashSet<String> bb;
    private String be;
    private String bf;
    private String bg;
    private String bh;
    private boolean bi;
    private RedirectData bj;
    private int bk;
    public static final String e = "slot_number";
    public static final String l = "max_ad_unit_id";
    private static final Set<String> ab = new HashSet(Arrays.asList("impression_id", "event_type", "sdk_uuid", e, "ad_format_type", "zone_id", l));
    public static final String aJ = "is_cross_origin_iframe_in_webview";
    public static final String aK = "webpage_resource_url_list";
    public static final String aL = "network_resource_url_list";
    public static final String aM = "expanded_webpage_resource_url_list";
    public static final String aN = "expanded_network_resource_url_list";
    public static final String aS = "is_hidden_iframe_in_webview";
    public static final String aO = "webpage_hidden_resource_urls";
    private static final Set<String> bd = new HashSet(Arrays.asList(aJ, aK, aL, aM, aN, aS, aO));

    public enum AdFormatType {
        INTER,
        REWARD,
        BANNER,
        LEADER,
        MREC,
        APPOPEN,
        NATIVE
    }

    public BrandSafetyEvent() {
        this.P = null;
        this.Q = null;
        this.V = false;
        this.W = null;
        this.X = false;
        this.aE = null;
        this.aT = null;
        this.aF = false;
        this.bh = null;
        this.aV = null;
        this.ba = null;
        this.aG = false;
        this.bi = false;
        this.ai = false;
        this.aj = false;
        this.ak = 0;
        this.al = 0L;
        this.am = 0.0f;
        this.an = null;
        this.aH = false;
        this.bj = null;
        this.bk = 0;
        this.E = StatsCollector.EventType.BrandSafety;
    }

    public BrandSafetyEvent(String sdk, int slotNumber, String hashValue, boolean clicked, String clickUrl, CreativeInfo creativeInfo, long timestamp, String foregroundActivityName, String impressionMd5, String multiAdUuid, long viewingTime, boolean isMature, Bundle applovinData, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, boolean isAnimated, long imageFileSize, float imageUniformity, int imageSlot, boolean isScarAdMobAd, boolean isFirstSession, String eventId, String maxCreativeId, boolean didFailDisplayReceived, String revenueEventValue, String debugInfo, String impressionLog, RedirectData redirectData, int redirectCount, HashSet<String> dspUrlList, Boolean isCrossOriginIframeInWebpage, SimpleConcurrentHashSet<String> webPageResourceUrlList, SimpleConcurrentHashSet<String> networkResourceUrlList, SimpleConcurrentHashSet<String> expandedWebPageResourceUrlList, SimpleConcurrentHashSet<String> expandedNetworkResourceUrlList, Boolean isHiddenIframeInWebpage, SimpleConcurrentHashSet<String> hiddenWebPageResourceUrlList) {
        super(sdk, StatsCollector.EventType.BrandSafety);
        this.P = null;
        this.Q = null;
        this.V = false;
        this.W = null;
        this.X = false;
        this.aE = null;
        this.aT = null;
        this.aF = false;
        this.bh = null;
        this.aV = null;
        this.ba = null;
        this.aG = false;
        this.bi = false;
        this.ai = false;
        this.aj = false;
        this.ak = 0;
        this.al = 0L;
        this.am = 0.0f;
        this.an = null;
        this.aH = false;
        this.bj = null;
        this.bk = 0;
        synchronized (this) {
            this.L = slotNumber;
            if (timestamp > 0) {
                this.G = n.b(timestamp);
            }
            Logger.d(a_, "BrandSafetyEvent ctor creative info: " + creativeInfo + ", isOnUiThread = " + n.c());
            this.aU = new HashSet<>();
            if (creativeInfo != null) {
                Iterator<String> it = creativeInfo.ak().iterator();
                while (it.hasNext()) {
                    networkResourceUrlList.remove(it.next());
                }
                Iterator<String> it2 = creativeInfo.e().iterator();
                while (it2.hasNext()) {
                    networkResourceUrlList.remove(it2.next());
                }
                if (dspUrlList != null) {
                    creativeInfo.a(new ArrayList<>(dspUrlList));
                }
                Logger.d(a_, "webview_resource_urls setting dsp urls list = " + dspUrlList);
                if (creativeInfo.S().equals(sdk)) {
                    Logger.d(a_, "creative info sdk is equal to event SDK");
                    this.N = creativeInfo.I();
                    this.O = creativeInfo.b();
                    Logger.d(a_, "addedCreativeInfoValues " + this.O);
                    if (clickUrl == null) {
                        Logger.d(a_, "self click url is null, setting creative info click url");
                        clickUrl = creativeInfo.O();
                    }
                    Logger.d(a_, "webview_resource_urls removing resource urls list and dsp urls list.");
                    this.D = creativeInfo.t();
                    Logger.d(a_, "BrandSeftyEvent ctor , sdk : " + sdk + ", sdk_version set : " + this.D);
                } else {
                    Logger.d(a_, "creative info sdk != sdk. creative info sdk: " + creativeInfo.S() + ", actual sdk: " + creativeInfo.T() + ", sdk: " + sdk);
                }
            } else {
                boolean zA = CreativeInfoManager.a(sdk, AdNetworkConfiguration.DONT_REPORT_WEBVIEW_RESOURCE_LIST_IF_NO_CI, false);
                Logger.d(a_, "the don't report webview resource is: " + zA);
                if (!zA && dspUrlList != null) {
                    this.aU.addAll(dspUrlList);
                }
                Logger.d(a_, "webview_resource_urls setting dsp urls list = " + dspUrlList);
            }
            this.M = clickUrl;
            this.V = clicked;
            this.P = foregroundActivityName;
            this.Q = impressionMd5;
            this.be = multiAdUuid;
            this.R = viewingTime;
            this.aB = maxCreativeId;
            if (applovinData != null) {
                this.S = applovinData.getString(l);
                this.aA = applovinData.getString(ad);
                this.T = b(applovinData.getString("ad_format"));
                this.U = applovinData.getString(k);
                this.aC = applovinData.getString("dsp_name");
                this.aD = applovinData.getString(af);
                if (maxCreativeId == null) {
                    this.aB = applovinData.getString("creative_id");
                }
            }
            this.I = isMature;
            if (creativeInfo != null) {
                this.W = hashValue;
                this.aa = screenShotOrientation;
                this.X = isAnimated;
                if (hashValue != null) {
                    this.Y = imageFileSize;
                    this.Z = imageUniformity;
                    this.ak = imageSlot;
                }
            }
            this.az = isFirstSession;
            if (eventId != null) {
                Logger.d(a_, "eventId = " + eventId);
                this.aE = eventId;
            }
            this.aF = didFailDisplayReceived;
            this.bf = debugInfo;
            this.bg = impressionLog;
            Logger.d(a_, "impression log value = " + revenueEventValue);
            this.bj = redirectData;
            this.bk = redirectCount;
            this.aT = revenueEventValue;
            this.aH = isScarAdMobAd;
            Logger.d(a_, "revenue event value = " + revenueEventValue);
            if (creativeInfo != null && creativeInfo.Y() != null && this.bh == null) {
                this.bh = creativeInfo.Y();
            }
            Logger.d(a_, "matching method value = " + revenueEventValue);
            if (creativeInfo != null && isMature) {
                Logger.d(a_, "setting matching method for mature ci to null. ci = " + creativeInfo);
                creativeInfo.b((String) null, (String) null);
            }
            this.aV = isCrossOriginIframeInWebpage;
            this.aW = webPageResourceUrlList != null ? new HashSet<>(webPageResourceUrlList.keySet()) : new HashSet<>();
            this.aX = networkResourceUrlList != null ? new HashSet<>(networkResourceUrlList.keySet()) : new HashSet<>();
            this.aZ = expandedWebPageResourceUrlList != null ? new HashSet<>(expandedWebPageResourceUrlList.keySet()) : new HashSet<>();
            this.aY = expandedNetworkResourceUrlList != null ? new HashSet<>(expandedNetworkResourceUrlList.keySet()) : new HashSet<>();
            this.ba = isHiddenIframeInWebpage;
            this.bb = hiddenWebPageResourceUrlList != null ? new HashSet<>(hiddenWebPageResourceUrlList.keySet()) : new HashSet<>();
        }
    }

    public BrandSafetyEvent(String sdk, int slotNumber, String hashValue, boolean clicked, String clickUrl, CreativeInfo creativeInfo, long timestamp, String foregroundActivityName, String impressionMd5, String multiAdUuid, boolean isMature, Bundle applovinData, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, long imageFileSize, float imageUniformity, int imageSlot, boolean willDisplayReceived, boolean isBannerViewDetected, long intervalBetweenDisplayMessages, float detectedViewProportions, String deviceOrientation, boolean isScarAdMobAd, boolean isFirstSession, String eventId, String maxCreativeId, boolean didFailDisplayReceived, String revenueEventValue, String debugInfo, String impressionLog, RedirectData redirectData, int redirectCount, HashSet<String> dspUrlList, Boolean isCrossOriginIframeInWebpage, SimpleConcurrentHashSet<String> webPageResourceUrlList, SimpleConcurrentHashSet<String> networkResourceUrlList, SimpleConcurrentHashSet<String> expandedWebPageResourceUrlList, SimpleConcurrentHashSet<String> expandedNetworkResourceUrlList, Boolean isHiddenIframeInWebpage, SimpleConcurrentHashSet<String> hiddenWebPageResourceUrlList) {
        this(sdk, slotNumber, hashValue, clicked, clickUrl, creativeInfo, timestamp, foregroundActivityName, impressionMd5, multiAdUuid, 0L, isMature, applovinData, screenShotOrientation, false, imageFileSize, imageUniformity, imageSlot, isScarAdMobAd, isFirstSession, eventId, maxCreativeId, didFailDisplayReceived, revenueEventValue, debugInfo, impressionLog, redirectData, redirectCount, dspUrlList, isCrossOriginIframeInWebpage, webPageResourceUrlList, networkResourceUrlList, expandedWebPageResourceUrlList, expandedNetworkResourceUrlList, isHiddenIframeInWebpage, hiddenWebPageResourceUrlList);
        this.aG = true;
        this.ai = willDisplayReceived;
        this.aj = isBannerViewDetected;
        this.al = intervalBetweenDisplayMessages;
        this.am = detectedViewProportions;
        this.an = deviceOrientation;
    }

    public BrandSafetyEvent(String sdk, int slotNumber, String hashValue, boolean clicked, String clickUrl, CreativeInfo creativeInfo, long timestamp, String foregroundActivityName, String impressionMd5, String multiAdUuid, boolean isMature, Bundle applovinData, BrandSafetyUtils.ScreenShotOrientation screenShotOrientation, long imageFileSize, float imageUniformity, int imageSlot, boolean willDisplayReceived, boolean isAdViewDetected, long intervalBetweenDisplayMessages, float detectedViewProportions, String deviceOrientation, boolean isFirstSession, String eventId, String maxCreativeId, boolean didFailDisplayReceived, String revenueEventValue, String debugInfo, String impressionLog) {
        this(sdk, slotNumber, hashValue, clicked, clickUrl, creativeInfo, timestamp, foregroundActivityName, impressionMd5, multiAdUuid, 0L, isMature, applovinData, screenShotOrientation, false, imageFileSize, imageUniformity, imageSlot, false, isFirstSession, eventId, maxCreativeId, didFailDisplayReceived, revenueEventValue, debugInfo, impressionLog, null, 0, null, false, null, null, null, null, false, null);
        this.bi = true;
        this.ai = willDisplayReceived;
        this.aj = isAdViewDetected;
        this.al = intervalBetweenDisplayMessages;
        this.am = detectedViewProportions;
        this.an = deviceOrientation;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public StatsCollector.EventType a() {
        return StatsCollector.EventType.BrandSafety;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public String b() {
        return this.Q;
    }

    public void c() {
        this.W = null;
    }

    /* JADX WARN: Code duplicated, block: B:130:0x02f6 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02fe A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0306  */
    /* JADX WARN: Code duplicated, block: B:136:0x030c A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0314 A[Catch: all -> 0x02b8, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x031c  */
    /* JADX WARN: Code duplicated, block: B:141:0x0257 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:143:0x0266 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x0236 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0241 A[Catch: all -> 0x02b8, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x0245 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0250 A[Catch: all -> 0x02b8, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0254 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x025f A[Catch: all -> 0x02b8, TRY_ENTER, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0263 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x0272 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0276 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0286 A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x028a A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x029a A[Catch: all -> 0x02b8, TryCatch #3 {, blocks: (B:4:0x0005, B:6:0x003c, B:7:0x005a, B:9:0x0062, B:10:0x0064, B:12:0x006c, B:14:0x0072, B:15:0x0074, B:17:0x007a, B:19:0x0080, B:20:0x0082, B:22:0x0086, B:24:0x00cc, B:26:0x00d0, B:27:0x00f0, B:30:0x00f6, B:33:0x00fb, B:34:0x0117, B:36:0x0127, B:38:0x012b, B:39:0x0149, B:41:0x014d, B:43:0x0157, B:45:0x015b, B:46:0x01b7, B:48:0x01bb, B:50:0x01bf, B:51:0x01dd, B:53:0x01e1, B:54:0x01ff, B:56:0x0227, B:57:0x0229, B:117:0x02e9, B:60:0x0232, B:62:0x0236, B:63:0x0238, B:120:0x02ec, B:66:0x0241, B:68:0x0245, B:69:0x0247, B:123:0x02ef, B:72:0x0250, B:74:0x0254, B:75:0x0256, B:126:0x02f2, B:78:0x025f, B:80:0x0263, B:81:0x0265, B:129:0x02f5, B:84:0x026e, B:86:0x0272, B:88:0x0276, B:89:0x027c, B:130:0x02f6, B:132:0x02fe, B:90:0x0282, B:92:0x0286, B:94:0x028a, B:95:0x0290, B:136:0x030c, B:138:0x0314, B:96:0x0296, B:98:0x029a, B:99:0x029e, B:111:0x02d7, B:113:0x02db, B:109:0x02bb, B:102:0x02a4, B:104:0x02af, B:76:0x0257, B:77:0x025e, B:82:0x0266, B:83:0x026d, B:58:0x022a, B:59:0x0231, B:64:0x0239, B:65:0x0240, B:70:0x0248, B:71:0x024f), top: B:147:0x0005, inners: #0, #1, #2, #4, #5 }] */
    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public synchronized void a(StatsEvent statsEvent) {
        boolean zBooleanValue;
        boolean zBooleanValue2 = false;
        synchronized (this) {
            BrandSafetyEvent brandSafetyEvent = (BrandSafetyEvent) statsEvent;
            Logger.d(a_, "doAggregation removing dsp urls list. local dspUrlList = " + this.aU + ", isOnUiThread = " + n.c());
            this.aU = new HashSet<>();
            Bundle bundle = brandSafetyEvent.O;
            if (bundle != null) {
                Logger.d(a_, "Aggregating downstream struct. eventCreativeValues=" + bundle);
                this.O = bundle;
                this.N = brandSafetyEvent.N;
            } else {
                Logger.d(a_, "doAggregation setting dsp urls list");
                if (brandSafetyEvent.aU != null) {
                    this.aU.addAll(brandSafetyEvent.aU);
                }
            }
            String str = brandSafetyEvent.M;
            if (!TextUtils.isEmpty(str)) {
                this.M = str;
            }
            long jL = statsEvent.l();
            if (jL != 0 && jL < this.G) {
                this.G = jL;
            }
            long j2 = brandSafetyEvent.R;
            if (j2 > 0 && j2 > this.R) {
                this.R = j2;
            }
            if (brandSafetyEvent.W != null) {
                Logger.d(a_, "doAggregation updating screenShotHashValue to '" + brandSafetyEvent.W + "' , image_file_size to " + brandSafetyEvent.Y + " and image_max_uniform_pixels to " + brandSafetyEvent.Z);
                this.W = brandSafetyEvent.W;
                this.Y = brandSafetyEvent.Y;
                this.Z = brandSafetyEvent.Z;
                this.ak = brandSafetyEvent.ak;
                BrandSafetyUtils.ScreenShotOrientation screenShotOrientation = brandSafetyEvent.aa;
                if (screenShotOrientation != null && screenShotOrientation != BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED) {
                    Logger.d(a_, "doAggregation updating screenShotOrientation to '" + screenShotOrientation + "'");
                    this.aa = screenShotOrientation;
                }
            } else {
                Logger.d(a_, "doAggregation updating image hash to null");
                this.W = null;
                this.Y = 0L;
                this.ak = 0;
                this.aa = null;
                this.Z = 0.0f;
            }
            boolean z = brandSafetyEvent.V;
            if (z) {
                this.V = z && brandSafetyEvent.be == null;
                Logger.d(a_, "doAggregation updating clicked to " + this.V);
            } else if (brandSafetyEvent.be != null) {
                this.V = false;
                Logger.d(a_, "doAggregation reset clicked due to multi ad");
            }
            this.X = brandSafetyEvent.X;
            this.aB = brandSafetyEvent.aB;
            this.be = brandSafetyEvent.be;
            if (this.aE == null && brandSafetyEvent.aE != null) {
                this.aE = brandSafetyEvent.aE;
                Logger.d(a_, "doAggregation updating eventId to " + this.aE);
            }
            if (this.C != null && !this.C.equals(brandSafetyEvent.C) && this.O != null) {
                Logger.d(a_, "doAggregation incompatible SDK. current: " + this.C + ", new: " + brandSafetyEvent.C);
                this.O.putString(CreativeInfo.g, this.O.getString(CreativeInfo.g, "") + "|sdk=" + this.C + ";newSdk=" + brandSafetyEvent.C);
            }
            if (this.aT == null && brandSafetyEvent.aT != null) {
                this.aT = brandSafetyEvent.aT;
                Logger.d(a_, "doAggregation updating revenueEventValue to " + this.aT);
            }
            if (this.P == null) {
                this.P = brandSafetyEvent.P;
                Logger.d(a_, "doAggregation updating foregroundActivityName to " + this.P);
            }
            this.ai = brandSafetyEvent.ai;
            this.aj = brandSafetyEvent.aj;
            this.al = brandSafetyEvent.al;
            this.bj = brandSafetyEvent.bj;
            this.bk = brandSafetyEvent.bk;
            this.am = brandSafetyEvent.am;
            this.bf = brandSafetyEvent.bf;
            this.bg = brandSafetyEvent.bg;
            this.aF = brandSafetyEvent.aF;
            if (brandSafetyEvent.aW != null) {
                synchronized (this.aW) {
                    this.aW.addAll(brandSafetyEvent.aW);
                }
                if (brandSafetyEvent.aX != null) {
                    synchronized (this.aX) {
                        this.aX.addAll(brandSafetyEvent.aX);
                    }
                    if (brandSafetyEvent.aZ != null) {
                        synchronized (this.aZ) {
                            this.aZ.addAll(brandSafetyEvent.aZ);
                        }
                        if (brandSafetyEvent.aY != null) {
                            synchronized (this.aY) {
                                this.aY.addAll(brandSafetyEvent.aY);
                            }
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (!this.aV.booleanValue() || brandSafetyEvent.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = false;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue() || brandSafetyEvent.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        } else {
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (this.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                } else {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        }
                    } else if (brandSafetyEvent.aY != null) {
                        synchronized (this.aY) {
                            this.aY.addAll(brandSafetyEvent.aY);
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (this.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                } else {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        }
                    } else {
                        if (brandSafetyEvent.bb != null) {
                            synchronized (this.bb) {
                                this.bb.addAll(brandSafetyEvent.bb);
                            }
                        }
                        if (brandSafetyEvent.aV != null) {
                            if (this.aV == null) {
                                zBooleanValue = brandSafetyEvent.aV.booleanValue();
                            } else if (this.aV.booleanValue()) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = true;
                            }
                            this.aV = Boolean.valueOf(zBooleanValue);
                        }
                        if (brandSafetyEvent.ba != null) {
                            if (this.ba == null) {
                                zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                            } else if (this.ba.booleanValue()) {
                                zBooleanValue2 = true;
                            } else {
                                zBooleanValue2 = true;
                            }
                            this.ba = Boolean.valueOf(zBooleanValue2);
                        }
                        if (brandSafetyEvent.bh != null) {
                            this.bh = brandSafetyEvent.bh;
                        }
                        this.aH = brandSafetyEvent.aH;
                    }
                } else if (brandSafetyEvent.aZ != null) {
                    synchronized (this.aZ) {
                        this.aZ.addAll(brandSafetyEvent.aZ);
                        if (brandSafetyEvent.aY != null) {
                            synchronized (this.aY) {
                                this.aY.addAll(brandSafetyEvent.aY);
                                if (brandSafetyEvent.bb != null) {
                                    synchronized (this.bb) {
                                        this.bb.addAll(brandSafetyEvent.bb);
                                    }
                                }
                                if (brandSafetyEvent.aV != null) {
                                    if (this.aV == null) {
                                        zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                    } else if (this.aV.booleanValue()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                    this.aV = Boolean.valueOf(zBooleanValue);
                                }
                                if (brandSafetyEvent.ba != null) {
                                    if (this.ba == null) {
                                        zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                    } else if (this.ba.booleanValue()) {
                                        zBooleanValue2 = true;
                                    } else {
                                        zBooleanValue2 = true;
                                    }
                                    this.ba = Boolean.valueOf(zBooleanValue2);
                                }
                                if (brandSafetyEvent.bh != null) {
                                    this.bh = brandSafetyEvent.bh;
                                }
                                this.aH = brandSafetyEvent.aH;
                            }
                        } else {
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (this.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                } else {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        }
                    }
                } else if (brandSafetyEvent.aY != null) {
                    synchronized (this.aY) {
                        this.aY.addAll(brandSafetyEvent.aY);
                        if (brandSafetyEvent.bb != null) {
                            synchronized (this.bb) {
                                this.bb.addAll(brandSafetyEvent.bb);
                            }
                        }
                        if (brandSafetyEvent.aV != null) {
                            if (this.aV == null) {
                                zBooleanValue = brandSafetyEvent.aV.booleanValue();
                            } else if (this.aV.booleanValue()) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = true;
                            }
                            this.aV = Boolean.valueOf(zBooleanValue);
                        }
                        if (brandSafetyEvent.ba != null) {
                            if (this.ba == null) {
                                zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                            } else if (this.ba.booleanValue()) {
                                zBooleanValue2 = true;
                            } else {
                                zBooleanValue2 = true;
                            }
                            this.ba = Boolean.valueOf(zBooleanValue2);
                        }
                        if (brandSafetyEvent.bh != null) {
                            this.bh = brandSafetyEvent.bh;
                        }
                        this.aH = brandSafetyEvent.aH;
                    }
                } else {
                    if (brandSafetyEvent.bb != null) {
                        synchronized (this.bb) {
                            this.bb.addAll(brandSafetyEvent.bb);
                        }
                    }
                    if (brandSafetyEvent.aV != null) {
                        if (this.aV == null) {
                            zBooleanValue = brandSafetyEvent.aV.booleanValue();
                        } else if (this.aV.booleanValue()) {
                            zBooleanValue = true;
                        } else {
                            zBooleanValue = true;
                        }
                        this.aV = Boolean.valueOf(zBooleanValue);
                    }
                    if (brandSafetyEvent.ba != null) {
                        if (this.ba == null) {
                            zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                        } else if (this.ba.booleanValue()) {
                            zBooleanValue2 = true;
                        } else {
                            zBooleanValue2 = true;
                        }
                        this.ba = Boolean.valueOf(zBooleanValue2);
                    }
                    if (brandSafetyEvent.bh != null) {
                        this.bh = brandSafetyEvent.bh;
                    }
                    this.aH = brandSafetyEvent.aH;
                }
            } else if (brandSafetyEvent.aX != null) {
                synchronized (this.aX) {
                    this.aX.addAll(brandSafetyEvent.aX);
                    if (brandSafetyEvent.aZ != null) {
                        synchronized (this.aZ) {
                            this.aZ.addAll(brandSafetyEvent.aZ);
                            if (brandSafetyEvent.aY != null) {
                                synchronized (this.aY) {
                                    this.aY.addAll(brandSafetyEvent.aY);
                                    if (brandSafetyEvent.bb != null) {
                                        synchronized (this.bb) {
                                            this.bb.addAll(brandSafetyEvent.bb);
                                        }
                                    }
                                    if (brandSafetyEvent.aV != null) {
                                        if (this.aV == null) {
                                            zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                        } else if (this.aV.booleanValue()) {
                                            zBooleanValue = true;
                                        } else {
                                            zBooleanValue = true;
                                        }
                                        this.aV = Boolean.valueOf(zBooleanValue);
                                    }
                                    if (brandSafetyEvent.ba != null) {
                                        if (this.ba == null) {
                                            zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                        } else if (this.ba.booleanValue()) {
                                            zBooleanValue2 = true;
                                        } else {
                                            zBooleanValue2 = true;
                                        }
                                        this.ba = Boolean.valueOf(zBooleanValue2);
                                    }
                                    if (brandSafetyEvent.bh != null) {
                                        this.bh = brandSafetyEvent.bh;
                                    }
                                    this.aH = brandSafetyEvent.aH;
                                }
                            } else {
                                if (brandSafetyEvent.bb != null) {
                                    synchronized (this.bb) {
                                        this.bb.addAll(brandSafetyEvent.bb);
                                    }
                                }
                                if (brandSafetyEvent.aV != null) {
                                    if (this.aV == null) {
                                        zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                    } else if (this.aV.booleanValue()) {
                                        zBooleanValue = true;
                                    } else {
                                        zBooleanValue = true;
                                    }
                                    this.aV = Boolean.valueOf(zBooleanValue);
                                }
                                if (brandSafetyEvent.ba != null) {
                                    if (this.ba == null) {
                                        zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                    } else if (this.ba.booleanValue()) {
                                        zBooleanValue2 = true;
                                    } else {
                                        zBooleanValue2 = true;
                                    }
                                    this.ba = Boolean.valueOf(zBooleanValue2);
                                }
                                if (brandSafetyEvent.bh != null) {
                                    this.bh = brandSafetyEvent.bh;
                                }
                                this.aH = brandSafetyEvent.aH;
                            }
                        }
                    } else if (brandSafetyEvent.aY != null) {
                        synchronized (this.aY) {
                            this.aY.addAll(brandSafetyEvent.aY);
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (this.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                } else {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        }
                    } else {
                        if (brandSafetyEvent.bb != null) {
                            synchronized (this.bb) {
                                this.bb.addAll(brandSafetyEvent.bb);
                            }
                        }
                        if (brandSafetyEvent.aV != null) {
                            if (this.aV == null) {
                                zBooleanValue = brandSafetyEvent.aV.booleanValue();
                            } else if (this.aV.booleanValue()) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = true;
                            }
                            this.aV = Boolean.valueOf(zBooleanValue);
                        }
                        if (brandSafetyEvent.ba != null) {
                            if (this.ba == null) {
                                zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                            } else if (this.ba.booleanValue()) {
                                zBooleanValue2 = true;
                            } else {
                                zBooleanValue2 = true;
                            }
                            this.ba = Boolean.valueOf(zBooleanValue2);
                        }
                        if (brandSafetyEvent.bh != null) {
                            this.bh = brandSafetyEvent.bh;
                        }
                        this.aH = brandSafetyEvent.aH;
                    }
                }
            } else if (brandSafetyEvent.aZ != null) {
                synchronized (this.aZ) {
                    this.aZ.addAll(brandSafetyEvent.aZ);
                    if (brandSafetyEvent.aY != null) {
                        synchronized (this.aY) {
                            this.aY.addAll(brandSafetyEvent.aY);
                            if (brandSafetyEvent.bb != null) {
                                synchronized (this.bb) {
                                    this.bb.addAll(brandSafetyEvent.bb);
                                }
                            }
                            if (brandSafetyEvent.aV != null) {
                                if (this.aV == null) {
                                    zBooleanValue = brandSafetyEvent.aV.booleanValue();
                                } else if (this.aV.booleanValue()) {
                                    zBooleanValue = true;
                                } else {
                                    zBooleanValue = true;
                                }
                                this.aV = Boolean.valueOf(zBooleanValue);
                            }
                            if (brandSafetyEvent.ba != null) {
                                if (this.ba == null) {
                                    zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                                } else if (this.ba.booleanValue()) {
                                    zBooleanValue2 = true;
                                } else {
                                    zBooleanValue2 = true;
                                }
                                this.ba = Boolean.valueOf(zBooleanValue2);
                            }
                            if (brandSafetyEvent.bh != null) {
                                this.bh = brandSafetyEvent.bh;
                            }
                            this.aH = brandSafetyEvent.aH;
                        }
                    } else {
                        if (brandSafetyEvent.bb != null) {
                            synchronized (this.bb) {
                                this.bb.addAll(brandSafetyEvent.bb);
                            }
                        }
                        if (brandSafetyEvent.aV != null) {
                            if (this.aV == null) {
                                zBooleanValue = brandSafetyEvent.aV.booleanValue();
                            } else if (this.aV.booleanValue()) {
                                zBooleanValue = true;
                            } else {
                                zBooleanValue = true;
                            }
                            this.aV = Boolean.valueOf(zBooleanValue);
                        }
                        if (brandSafetyEvent.ba != null) {
                            if (this.ba == null) {
                                zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                            } else if (this.ba.booleanValue()) {
                                zBooleanValue2 = true;
                            } else {
                                zBooleanValue2 = true;
                            }
                            this.ba = Boolean.valueOf(zBooleanValue2);
                        }
                        if (brandSafetyEvent.bh != null) {
                            this.bh = brandSafetyEvent.bh;
                        }
                        this.aH = brandSafetyEvent.aH;
                    }
                }
            } else if (brandSafetyEvent.aY != null) {
                synchronized (this.aY) {
                    this.aY.addAll(brandSafetyEvent.aY);
                    if (brandSafetyEvent.bb != null) {
                        synchronized (this.bb) {
                            this.bb.addAll(brandSafetyEvent.bb);
                        }
                    }
                    if (brandSafetyEvent.aV != null) {
                        if (this.aV == null) {
                            zBooleanValue = brandSafetyEvent.aV.booleanValue();
                        } else if (this.aV.booleanValue()) {
                            zBooleanValue = true;
                        } else {
                            zBooleanValue = true;
                        }
                        this.aV = Boolean.valueOf(zBooleanValue);
                    }
                    if (brandSafetyEvent.ba != null) {
                        if (this.ba == null) {
                            zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                        } else if (this.ba.booleanValue()) {
                            zBooleanValue2 = true;
                        } else {
                            zBooleanValue2 = true;
                        }
                        this.ba = Boolean.valueOf(zBooleanValue2);
                    }
                    if (brandSafetyEvent.bh != null) {
                        this.bh = brandSafetyEvent.bh;
                    }
                    this.aH = brandSafetyEvent.aH;
                }
            } else {
                if (brandSafetyEvent.bb != null) {
                    synchronized (this.bb) {
                        this.bb.addAll(brandSafetyEvent.bb);
                    }
                }
                if (brandSafetyEvent.aV != null) {
                    if (this.aV == null) {
                        zBooleanValue = brandSafetyEvent.aV.booleanValue();
                    } else if (this.aV.booleanValue()) {
                        zBooleanValue = true;
                    } else {
                        zBooleanValue = true;
                    }
                    this.aV = Boolean.valueOf(zBooleanValue);
                }
                if (brandSafetyEvent.ba != null) {
                    if (this.ba == null) {
                        zBooleanValue2 = brandSafetyEvent.ba.booleanValue();
                    } else if (this.ba.booleanValue()) {
                        zBooleanValue2 = true;
                    } else {
                        zBooleanValue2 = true;
                    }
                    this.ba = Boolean.valueOf(zBooleanValue2);
                }
                if (brandSafetyEvent.bh != null) {
                    this.bh = brandSafetyEvent.bh;
                }
                this.aH = brandSafetyEvent.aH;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:169:0x036e A[Catch: all -> 0x039e, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0010, B:8:0x0018, B:9:0x001f, B:11:0x0023, B:13:0x002b, B:14:0x0030, B:16:0x0038, B:17:0x003f, B:19:0x004e, B:20:0x0055, B:22:0x005d, B:23:0x0064, B:25:0x006c, B:26:0x0073, B:28:0x007b, B:29:0x0082, B:31:0x008a, B:32:0x0091, B:34:0x0099, B:35:0x00a0, B:37:0x00a8, B:39:0x00b0, B:40:0x00b7, B:42:0x00bf, B:44:0x00c7, B:46:0x00d1, B:49:0x00e2, B:51:0x00ea, B:53:0x00f4, B:56:0x0105, B:58:0x010d, B:60:0x0111, B:62:0x0117, B:63:0x0124, B:65:0x0133, B:67:0x013e, B:69:0x0142, B:70:0x0149, B:72:0x014d, B:73:0x015c, B:74:0x0171, B:76:0x0187, B:78:0x018f, B:186:0x03c4, B:79:0x01ad, B:81:0x01b5, B:82:0x01bc, B:84:0x01da, B:95:0x0217, B:97:0x021b, B:99:0x021f, B:101:0x024c, B:103:0x0254, B:187:0x03cd, B:104:0x0274, B:106:0x0283, B:107:0x028a, B:109:0x0299, B:110:0x02a0, B:112:0x02a4, B:113:0x02af, B:115:0x02b3, B:116:0x02be, B:118:0x02c2, B:120:0x02ca, B:122:0x02ce, B:124:0x02d4, B:126:0x02da, B:127:0x02dc, B:130:0x02e5, B:131:0x02e7, B:194:0x03dd, B:191:0x03da, B:195:0x03de, B:134:0x02ee, B:136:0x02f2, B:138:0x02fa, B:139:0x0306, B:141:0x030a, B:143:0x0312, B:145:0x0316, B:147:0x031c, B:149:0x0322, B:150:0x0324, B:153:0x032d, B:154:0x032f, B:202:0x03f1, B:199:0x03ee, B:203:0x03f2, B:157:0x0336, B:159:0x033a, B:161:0x0342, B:162:0x034e, B:164:0x0352, B:166:0x035a, B:167:0x0366, B:169:0x036e, B:170:0x0375, B:86:0x01de, B:88:0x01f0, B:90:0x01fb, B:91:0x0202, B:93:0x0209, B:94:0x0210, B:55:0x00fe, B:48:0x00db, B:185:0x03bb, B:173:0x0391, B:175:0x0395, B:180:0x03a1, B:182:0x03a5, B:184:0x03ad, B:128:0x02dd, B:129:0x02e4, B:132:0x02e8, B:133:0x02ed, B:151:0x0325, B:152:0x032c, B:155:0x0330, B:156:0x0335), top: B:211:0x0001, inners: #0, #1, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x03f2 A[Catch: all -> 0x039e, TRY_LEAVE, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0009, B:6:0x0010, B:8:0x0018, B:9:0x001f, B:11:0x0023, B:13:0x002b, B:14:0x0030, B:16:0x0038, B:17:0x003f, B:19:0x004e, B:20:0x0055, B:22:0x005d, B:23:0x0064, B:25:0x006c, B:26:0x0073, B:28:0x007b, B:29:0x0082, B:31:0x008a, B:32:0x0091, B:34:0x0099, B:35:0x00a0, B:37:0x00a8, B:39:0x00b0, B:40:0x00b7, B:42:0x00bf, B:44:0x00c7, B:46:0x00d1, B:49:0x00e2, B:51:0x00ea, B:53:0x00f4, B:56:0x0105, B:58:0x010d, B:60:0x0111, B:62:0x0117, B:63:0x0124, B:65:0x0133, B:67:0x013e, B:69:0x0142, B:70:0x0149, B:72:0x014d, B:73:0x015c, B:74:0x0171, B:76:0x0187, B:78:0x018f, B:186:0x03c4, B:79:0x01ad, B:81:0x01b5, B:82:0x01bc, B:84:0x01da, B:95:0x0217, B:97:0x021b, B:99:0x021f, B:101:0x024c, B:103:0x0254, B:187:0x03cd, B:104:0x0274, B:106:0x0283, B:107:0x028a, B:109:0x0299, B:110:0x02a0, B:112:0x02a4, B:113:0x02af, B:115:0x02b3, B:116:0x02be, B:118:0x02c2, B:120:0x02ca, B:122:0x02ce, B:124:0x02d4, B:126:0x02da, B:127:0x02dc, B:130:0x02e5, B:131:0x02e7, B:194:0x03dd, B:191:0x03da, B:195:0x03de, B:134:0x02ee, B:136:0x02f2, B:138:0x02fa, B:139:0x0306, B:141:0x030a, B:143:0x0312, B:145:0x0316, B:147:0x031c, B:149:0x0322, B:150:0x0324, B:153:0x032d, B:154:0x032f, B:202:0x03f1, B:199:0x03ee, B:203:0x03f2, B:157:0x0336, B:159:0x033a, B:161:0x0342, B:162:0x034e, B:164:0x0352, B:166:0x035a, B:167:0x0366, B:169:0x036e, B:170:0x0375, B:86:0x01de, B:88:0x01f0, B:90:0x01fb, B:91:0x0202, B:93:0x0209, B:94:0x0210, B:55:0x00fe, B:48:0x00db, B:185:0x03bb, B:173:0x0391, B:175:0x0395, B:180:0x03a1, B:182:0x03a5, B:184:0x03ad, B:128:0x02dd, B:129:0x02e4, B:132:0x02e8, B:133:0x02ed, B:151:0x0325, B:152:0x032c, B:155:0x0330, B:156:0x0335), top: B:211:0x0001, inners: #0, #1, #2, #4 }] */
    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public synchronized Bundle d() {
        Bundle bundleD;
        bundleD = super.d();
        if (this.L > 0) {
            bundleD.putInt(e, this.L);
        }
        if (!TextUtils.isEmpty(this.M)) {
            bundleD.putString("click_url", this.M);
        }
        if (this.O != null && !this.O.isEmpty()) {
            bundleD.putAll(this.O);
        } else if (this.aH) {
            bundleD.putString(CreativeInfo.q, "/scar-admob");
        } else if (this.aU != null && !this.aU.isEmpty()) {
            bundleD.putStringArrayList(h, new ArrayList<>(this.aU));
        }
        if (!TextUtils.isEmpty(this.P)) {
            bundleD.putString("foreground_activity", this.P);
        }
        bundleD.putString("impression_id", this.Q);
        if (!TextUtils.isEmpty(this.be)) {
            bundleD.putString(ay, this.be);
        }
        if (this.R > 0) {
            bundleD.putLong(d, this.R);
        }
        if (!TextUtils.isEmpty(this.S)) {
            bundleD.putString(l, this.S);
        }
        if (!TextUtils.isEmpty(this.aA)) {
            bundleD.putString(ac, this.aA);
        }
        if (!TextUtils.isEmpty(this.aB)) {
            bundleD.putString(ao, this.aB);
        }
        if (!TextUtils.isEmpty(this.aD)) {
            bundleD.putString(af, this.aD);
        }
        if (!TextUtils.isEmpty(this.aC) && !bundleD.containsKey(CreativeInfo.L)) {
            bundleD.putString(CreativeInfo.L, this.aC);
        }
        if (!TextUtils.isEmpty(this.C)) {
            if (bundleD.getString("ad_format_type") == null || "com.unity3d.ads".equals(this.C) || h.p.equals(this.C)) {
                bundleD.putString("ad_format_type", this.T);
            }
            if (bundleD.getString("zone_id") == null || "com.unity3d.ads".equals(this.C) || h.p.equals(this.C)) {
                bundleD.putString("zone_id", this.U);
            }
        } else {
            Logger.d(a_, "Sdk field value is null.");
        }
        if (bundleD.getString("ad_format_type") == null && this.bj != null && this.bj.t != null) {
            bundleD.putString("ad_format_type", this.bj.t.name());
        }
        bundleD.putString("event_type", "impression");
        if (!TextUtils.isEmpty(this.W)) {
            bundleD.putString("image_id", this.W);
            if (!this.aG && !this.bi) {
                bundleD.putBoolean(s, this.X);
            }
            if (this.aa != null) {
                bundleD.putString("image_orientation", this.aa.name().toLowerCase());
            }
            bundleD.putLong(o, this.Y);
            bundleD.putFloat(p, this.Z);
            bundleD.putInt(at, this.ak);
        }
        bundleD.putBoolean(t, this.V);
        bundleD.putBoolean(v, this.J);
        if (!TextUtils.isEmpty(this.bf)) {
            String string = bundleD.getString(CreativeInfo.g);
            if (string != null) {
                bundleD.putString(CreativeInfo.g, string + l.ac + this.bf);
            } else {
                bundleD.putString(CreativeInfo.g, this.bf);
            }
        }
        if (!TextUtils.isEmpty(this.bg)) {
            bundleD.putString(CreativeInfo.f, this.bg);
        }
        Logger.d(a_, "add impression log to bundle: " + this.bg);
        if (this.aG || this.bi) {
            bundleD.putBoolean(ar, this.ai);
            bundleD.putBoolean(as, this.aj);
            if (this.aG && this.al != Long.MAX_VALUE) {
                bundleD.putLong(au, this.al);
            }
            if (this.am > 0.0f) {
                bundleD.putFloat(av, this.am);
            }
            bundleD.putString(aw, this.an);
        }
        if (!this.bi && this.bj != null) {
            bundleD.putAll(this.bj.a());
            this.bj.a("RedirectCount=" + this.bk);
            if (!TextUtils.isEmpty(this.bj.q)) {
                String string2 = bundleD.getString(CreativeInfo.g);
                if (string2 != null) {
                    bundleD.putString(CreativeInfo.g, string2 + l.ac + this.bj.q);
                } else {
                    bundleD.putString(CreativeInfo.g, this.bj.q);
                }
            }
        }
        bundleD.putBoolean(ag, this.az);
        if (!TextUtils.isEmpty(this.aE)) {
            bundleD.putString("event_id", this.aE);
        }
        bundleD.putBoolean(aq, this.aF);
        if (!TextUtils.isEmpty(this.aT)) {
            bundleD.putString("revenue_event", this.aT);
        }
        if (this.aV != null) {
            bundleD.putBoolean(aJ, this.aV.booleanValue());
        }
        if (this.ba != null) {
            bundleD.putBoolean(aS, this.ba.booleanValue());
        }
        if (this.aZ != null && !this.aZ.isEmpty()) {
            if (this.bj != null && !this.bj.j && !this.bj.k) {
                synchronized (this.aW) {
                    this.aW.addAll(this.aZ);
                }
                synchronized (this.aZ) {
                    this.aZ.clear();
                }
            } else {
                bundleD.putStringArrayList(aM, new ArrayList<>(this.aZ));
            }
            if (this.aW != null) {
                bundleD.putStringArrayList(aK, new ArrayList<>(this.aW));
            }
            if (this.aY != null) {
                if (this.bj == null) {
                    bundleD.putStringArrayList(aN, new ArrayList<>(this.aY));
                } else {
                    bundleD.putStringArrayList(aN, new ArrayList<>(this.aY));
                }
            }
            if (this.aX != null) {
                bundleD.putStringArrayList(aL, new ArrayList<>(this.aX));
            }
            if (this.bb != null) {
                bundleD.putStringArrayList(aO, new ArrayList<>(this.bb));
            }
            if (!TextUtils.isEmpty(this.bh)) {
                bundleD.putString(aR, this.bh);
            }
            Logger.d(a_, "add matching method to bundle: " + this.bh);
        } else {
            if (this.aW != null && !this.aW.isEmpty()) {
                bundleD.putStringArrayList(aK, new ArrayList<>(this.aW));
            }
            if (this.aY != null && !this.aY.isEmpty()) {
                if (this.bj == null && !this.bj.j && !this.bj.k) {
                    synchronized (this.aX) {
                        this.aX.addAll(this.aY);
                    }
                    synchronized (this.aY) {
                        this.aY.clear();
                    }
                } else {
                    bundleD.putStringArrayList(aN, new ArrayList<>(this.aY));
                }
            }
            if (this.aX != null && !this.aX.isEmpty()) {
                bundleD.putStringArrayList(aL, new ArrayList<>(this.aX));
            }
            if (this.bb != null && !this.bb.isEmpty()) {
                bundleD.putStringArrayList(aO, new ArrayList<>(this.bb));
            }
            if (!TextUtils.isEmpty(this.bh)) {
                bundleD.putString(aR, this.bh);
            }
            Logger.d(a_, "add matching method to bundle: " + this.bh);
        }
        throw th;
        return bundleD;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public Set<String> e() {
        HashSet hashSet = new HashSet(ab);
        if (this.C != null && this.C.equals(h.h)) {
            hashSet.add("click_url");
        }
        return hashSet;
    }

    public static Set<String> f() {
        return bd;
    }

    private static Map<String, Object> b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (bundle.size() == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(bundle.size());
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    map.put(str, b((Bundle) obj));
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (!arrayList.isEmpty() && (arrayList.get(0) instanceof Bundle)) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : arrayList) {
                            if (obj2 instanceof Bundle) {
                                arrayList2.add(b((Bundle) obj2));
                            }
                        }
                        map.put(str, arrayList2);
                    } else {
                        map.put(str, arrayList);
                    }
                } else {
                    map.put(str, obj);
                }
            }
        }
        return map;
    }

    private static Bundle a(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof String) {
                bundle.putString(str, (String) obj);
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof ArrayList) {
                bundle.putStringArrayList(str, (ArrayList) obj);
            }
        }
        return bundle;
    }

    private String b(String str) {
        Logger.d(a_, "getAdFormatTypeFromMaxAdFormType called, input=" + str);
        String string = null;
        if (BrandSafetyUtils.j.equals(str)) {
            string = AdFormatType.INTER.toString();
        } else if (BrandSafetyUtils.k.equals(str)) {
            string = AdFormatType.REWARD.toString();
        } else if ("BANNER".equals(str) || BrandSafetyUtils.n.equals(str)) {
            string = AdFormatType.BANNER.toString();
        } else if (BrandSafetyUtils.l.equals(str)) {
            string = AdFormatType.APPOPEN.toString();
        } else if (BrandSafetyUtils.o.equals(str)) {
            string = AdFormatType.MREC.toString();
        } else if ("NATIVE".equals(str)) {
            string = AdFormatType.NATIVE.toString();
        }
        Logger.d(a_, "getAdFormatTypeFromMaxAdFormType returned  " + string);
        return string;
    }

    public String g() {
        return this.aT;
    }

    public void a(String str) {
        this.aT = str;
    }

    public String h() {
        return this.W;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent
    public Bundle a(Bundle bundle) {
        String strB;
        boolean z;
        try {
            String string = bundle.getString("ad_format_type");
            String string2 = bundle.getString("impression_id");
            String strB2 = n.b(bundle, ac);
            if (strB2 == null || strB2.isEmpty()) {
                strB = null;
            } else {
                strB = CreativeInfoManager.b(strB2);
            }
            Logger.d(a_, "_RESOURCES_ network name = " + strB2 + ", sdk package = " + strB + ", ad type = " + string);
            if (strB != null && string != null) {
                HashSet hashSet = new HashSet();
                HashSet<String> hashSet2 = new HashSet<>();
                HashSet hashSet3 = new HashSet();
                HashSet<String> hashSetC = n.c(bundle, aK);
                if (hashSetC != null && !hashSetC.isEmpty()) {
                    hashSet2.addAll(hashSetC);
                }
                HashSet<String> hashSetC2 = n.c(bundle, aM);
                if (hashSetC2 != null && !hashSetC2.isEmpty()) {
                    hashSet3.addAll(hashSetC2);
                }
                boolean zRemoveAll = false;
                HashSet<String> hashSetC3 = n.c(bundle, aO);
                if (hashSetC3 == null) {
                    z = false;
                } else {
                    hashSetC3.remove("");
                    z = !hashSetC3.isEmpty();
                }
                HashSet<String> hashSetC4 = n.c(bundle, aL);
                if (hashSetC4 != null && z) {
                    zRemoveAll = hashSetC4.removeAll(hashSetC3);
                }
                HashSet<String> hashSetC5 = n.c(bundle, aN);
                boolean zP = SafeDK.getInstance().P();
                boolean zA = CreativeInfoManager.a(strB, AdNetworkConfiguration.SUPPORTS_DIFFERENT_ADS_IN_CROSS_ORIGIN_IFRAMES, false);
                Logger.d(a_, "_JS_ _RESOURCES_ prepare bundle for reporting, package: " + strB + ", supportMergingWebviewNetworkResources: " + (zP ? "YES" : "NO") + ", supportDifferentAdsInCrossOriginIframes: " + (zA ? "YES" : "NO"));
                boolean z2 = Objects.equals(string, BrandSafetyUtils.j) || Objects.equals(string, bc);
                if (zP && (!z2 || !zA)) {
                    if (hashSetC4 != null && !hashSetC4.isEmpty()) {
                        hashSet2.addAll(hashSetC4);
                    }
                    if (hashSetC5 != null && !hashSetC5.isEmpty()) {
                        hashSet3.addAll(hashSetC5);
                    }
                }
                HashSet<String> hashSetA = z2 ? k.a(hashSet2, "text:") : hashSet2;
                if (!CreativeInfoManager.a(strB, AdNetworkConfiguration.SUPPORT_WEBVIEW_COMMENT_EXTRACTION, false)) {
                    hashSetA = k.a(hashSetA, CreativeInfo.aU);
                }
                if (hashSetA != null && !hashSetA.isEmpty()) {
                    hashSet.addAll(hashSetA);
                    bundle.putStringArrayList(aP, new ArrayList<>(hashSet));
                }
                if (hashSet3 != null && !hashSet3.isEmpty()) {
                    bundle.putStringArrayList(aQ, new ArrayList<>(hashSet3));
                }
                Logger.d(a_, "_RESOURCES_ prepare bundle for reporting, type: " + string + ", package: " + strB + ", impression id: " + string2);
                n.b(a_, "_JS_ _RESOURCES_ prepare bundle for reporting, webpage resources: " + hashSetC);
                n.b(a_, "_NW_ _RESOURCES_ prepare bundle for reporting, network resources: " + hashSetC4);
                n.b(a_, "_RESOURCES_ prepare bundle for reporting, final resources: " + hashSet);
                n.b(a_, "_JS_ _RESOURCES_ prepare bundle for reporting, expanded webpage resources: " + hashSetC2);
                n.b(a_, "_NW_ _RESOURCES_ prepare bundle for reporting, expanded network resources: " + hashSetC5);
                n.b(a_, "_RESOURCES_ prepare bundle for reporting, final expanded resources: " + hashSet3);
                String string3 = bundle.getString(CreativeInfo.g) != null ? bundle.getString(CreativeInfo.g) : "";
                if (bundle.getBoolean(aJ)) {
                    string3 = string3 + "|co1";
                }
                if (bundle.getBoolean(aS)) {
                    string3 = string3 + "|hi1";
                }
                if (z) {
                    String str = string3 + "|hr";
                    if (zRemoveAll) {
                        string3 = str + "2";
                    } else {
                        string3 = str + "1";
                    }
                }
                bundle.putString(CreativeInfo.g, string3);
                Set<String> setF = f();
                if (setF != null) {
                    for (String str2 : setF) {
                        if (bundle.containsKey(str2)) {
                            bundle.remove(str2);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Logger.d(a_, "caught exception: " + e2.getMessage() + " " + e2);
        }
        return bundle;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent, com.safedk.android.utils.f
    public JSONObject i() throws JSONException {
        JSONObject jSONObjectI = super.i();
        jSONObjectI.put("slotNumber", this.L);
        if (!TextUtils.isEmpty(this.M)) {
            jSONObjectI.put("clickUrl", this.M);
        }
        if (!TextUtils.isEmpty(this.N)) {
            jSONObjectI.put("addedCreativeInfoKey", this.N);
        }
        if (!TextUtils.isEmpty(this.P)) {
            jSONObjectI.put("foregroundActivityName", this.P);
        }
        if (!TextUtils.isEmpty(this.Q)) {
            jSONObjectI.put("impressionId", this.Q);
        }
        if (!TextUtils.isEmpty(this.be)) {
            jSONObjectI.put("multiAdUuid", this.be);
        }
        jSONObjectI.put("viewingTime", this.R);
        if (!TextUtils.isEmpty(this.S)) {
            jSONObjectI.put("maxAdUnitId", this.S);
        }
        if (!TextUtils.isEmpty(this.aA)) {
            jSONObjectI.put("maxNetworkName", this.aA);
        }
        if (!TextUtils.isEmpty(this.T)) {
            jSONObjectI.put("applovinDataAdFormatType", this.T);
        }
        if (!TextUtils.isEmpty(this.U)) {
            jSONObjectI.put("applovinData3rdPartyPlacementId", this.U);
        }
        if (!TextUtils.isEmpty(this.aB)) {
            jSONObjectI.put("maxCreativeId", this.aB);
        }
        if (!TextUtils.isEmpty(this.aC)) {
            jSONObjectI.put("dspName", this.aC);
        }
        if (!TextUtils.isEmpty(this.aD)) {
            jSONObjectI.put("customJsNetworkName", this.aD);
        }
        jSONObjectI.put(Reporting.EventType.VIDEO_AD_CLICKED, this.V);
        if (!TextUtils.isEmpty(this.W)) {
            jSONObjectI.put("screenShotHashValue", this.W);
        }
        jSONObjectI.put("isAnimated", this.X);
        jSONObjectI.put("imageFileSize", this.Y);
        jSONObjectI.put("imageUniformity", this.Z);
        if (!TextUtils.isEmpty(this.aE)) {
            jSONObjectI.put("eventId", this.aE);
        }
        if (!TextUtils.isEmpty(this.aT)) {
            jSONObjectI.put("revenueEventValue", this.aT);
        }
        if (this.aa != null) {
            jSONObjectI.put("screenShotOrientation", this.aa.name());
        }
        jSONObjectI.put("didFailDisplayReceived", this.aF);
        if (!TextUtils.isEmpty(this.bf)) {
            jSONObjectI.put("debugInfo", this.bf);
        }
        if (!TextUtils.isEmpty(this.bg)) {
            jSONObjectI.put("impressionLog", this.bg);
        }
        jSONObjectI.put(b9.v, this.aG);
        jSONObjectI.put("isNative", this.bi);
        jSONObjectI.put("willDisplayReceived", this.ai);
        jSONObjectI.put("isBannerViewDetected", this.aj);
        jSONObjectI.put("imageSlot", this.ak);
        jSONObjectI.put("intervalBetweenDisplayMessages", this.al);
        jSONObjectI.put("detectedViewProportions", this.am);
        if (!TextUtils.isEmpty(this.an)) {
            jSONObjectI.put(b9.i.A, this.an);
        }
        jSONObjectI.put("isScarAdMobAd", this.aH);
        if (this.bj != null) {
            jSONObjectI.put("redirectData", this.bj.i());
        }
        jSONObjectI.put("redirectCount", this.bk);
        if (this.aU != null) {
            jSONObjectI.put("dspUrlList", d.a(this.aU));
        }
        if (this.aV != null) {
            jSONObjectI.put("isCrossOriginIframeInWebpage", this.aV);
        }
        if (this.ba != null) {
            jSONObjectI.put("isHiddenIframeInWebpage", this.ba);
        }
        if (this.aW != null) {
            jSONObjectI.put("webPageResourceUrlList", d.a(this.aW));
        }
        if (this.aX != null) {
            jSONObjectI.put("networkResourceUrlList", d.a(this.aX));
        }
        if (this.aY != null) {
            jSONObjectI.put("expandedNetworkResourceUrlList", d.a(this.aY));
        }
        if (this.aZ != null) {
            jSONObjectI.put("expandedWebPageResourceUrlList", d.a(this.aZ));
        }
        if (this.bb != null) {
            jSONObjectI.put("hiddenWebPageResourceUrlList", d.a(this.bb));
        }
        if (!TextUtils.isEmpty(this.bh)) {
            jSONObjectI.put("matchingMethod", this.bh);
        }
        if (this.O != null) {
            jSONObjectI.put("addedCreativeInfoValues", d.a(this.O));
        }
        return jSONObjectI;
    }

    @Override // com.safedk.android.analytics.events.base.StatsEvent, com.safedk.android.utils.f
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            super.a(jSONObject);
            this.L = jSONObject.optInt("slotNumber", 0);
            this.M = jSONObject.optString("clickUrl", "");
            this.N = jSONObject.optString("addedCreativeInfoKey", "");
            this.P = jSONObject.optString("foregroundActivityName", "");
            this.Q = jSONObject.optString("impressionId", "");
            this.be = jSONObject.optString("multiAdUuid", "");
            this.R = jSONObject.optLong("viewingTime", 0L);
            this.S = jSONObject.optString("maxAdUnitId", "");
            this.aA = jSONObject.optString("maxNetworkName", "");
            this.T = jSONObject.optString("applovinDataAdFormatType", "");
            this.U = jSONObject.optString("applovinData3rdPartyPlacementId", "");
            this.aB = jSONObject.optString("maxCreativeId", "");
            this.aC = jSONObject.optString("dspName", "");
            this.aD = jSONObject.optString("customJsNetworkName", "");
            this.V = jSONObject.optBoolean(Reporting.EventType.VIDEO_AD_CLICKED, false);
            this.W = jSONObject.optString("screenShotHashValue", "");
            this.X = jSONObject.optBoolean("isAnimated", false);
            this.Y = jSONObject.optLong("imageFileSize", 0L);
            this.Z = (float) jSONObject.optDouble("imageUniformity", 0.0d);
            this.aE = jSONObject.optString("eventId", "");
            this.aT = jSONObject.optString("revenueEventValue", "");
            this.aa = BrandSafetyUtils.ScreenShotOrientation.valueOf(jSONObject.optString("screenShotOrientation", BrandSafetyUtils.ScreenShotOrientation.NOT_INITIALIZED.name()));
            this.aF = jSONObject.optBoolean("didFailDisplayReceived", false);
            this.bf = jSONObject.optString("debugInfo", "");
            this.bg = jSONObject.optString("impressionLog", "");
            this.bh = jSONObject.optString("matchingMethod", "");
            this.aG = jSONObject.optBoolean(b9.v, false);
            this.bi = jSONObject.optBoolean("isNative", false);
            this.ai = jSONObject.optBoolean("willDisplayReceived", false);
            this.aj = jSONObject.optBoolean("isBannerViewDetected", false);
            this.ak = jSONObject.optInt("imageSlot", 0);
            this.al = jSONObject.optLong("intervalBetweenDisplayMessages", 0L);
            this.am = (float) jSONObject.optDouble("detectedViewProportions", 0.0d);
            this.an = jSONObject.optString(b9.i.A, "");
            this.aH = jSONObject.optBoolean("isScarAdMobAd", false);
            this.bk = jSONObject.optInt("redirectCount", 0);
            if (jSONObject.has("isCrossOriginIframeInWebpage") && !jSONObject.isNull("isCrossOriginIframeInWebpage")) {
                this.aV = Boolean.valueOf(jSONObject.optBoolean("isCrossOriginIframeInWebpage"));
            }
            if (jSONObject.has("isHiddenIframeInWebpage") && !jSONObject.isNull("isHiddenIframeInWebpage")) {
                this.ba = Boolean.valueOf(jSONObject.optBoolean("isHiddenIframeInWebpage"));
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("dspUrlList");
            if (jSONArrayOptJSONArray != null) {
                this.aU = new HashSet<>(d.b(jSONArrayOptJSONArray));
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("webPageResourceUrlList");
            if (jSONArrayOptJSONArray2 != null) {
                this.aW = new HashSet<>(d.b(jSONArrayOptJSONArray2));
            }
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("networkResourceUrlList");
            if (jSONArrayOptJSONArray3 != null) {
                this.aX = new HashSet<>(d.b(jSONArrayOptJSONArray3));
            }
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("expandedNetworkResourceUrlList");
            if (jSONArrayOptJSONArray4 != null) {
                this.aY = new HashSet<>(d.b(jSONArrayOptJSONArray4));
            }
            JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray("expandedWebPageResourceUrlList");
            if (jSONArrayOptJSONArray5 != null) {
                this.aZ = new HashSet<>(d.b(jSONArrayOptJSONArray5));
            }
            JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray("hiddenWebageResourceUrlList");
            if (jSONArrayOptJSONArray6 != null) {
                this.bb = new HashSet<>(d.b(jSONArrayOptJSONArray6));
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("redirectData");
            if (jSONObjectOptJSONObject != null) {
                this.bj = new RedirectData();
                this.bj.a(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("addedCreativeInfoValues");
            if (jSONObjectOptJSONObject2 != null) {
                this.O = a(d.b(jSONObjectOptJSONObject2));
            }
        }
    }
}

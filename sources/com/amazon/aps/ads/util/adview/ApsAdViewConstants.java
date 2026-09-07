package com.amazon.aps.ads.util.adview;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: ApsAdViewConstants.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewConstants;", "", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ApsAdViewConstants {
    public static final String ADDITIONAL_WEBVIEW_METRICS = "additional_webview_metric";
    public static final String AD_INFO_FEATURE = "webviewAdInfo_feature";
    public static final int AD_INFO_MATCHER_NUMBER = 4;
    public static final String AD_INFO_PATTERN = "amzn.dtb.loadAd\\(\\\"(.*)\\\", \\\"(.*)\\\", \\\"(.*)\\\".*isv: (\\w+)";
    public static final String AMAZON_AD_INFO = "amazon_ad_info";
    public static final String AMAZON_BRIDGE = "amzn_bridge";
    public static final String AMAZON_INFO = "{bidID:'%s',aaxHost:'%s',pricePoint:'%s'}";
    public static final String BID_HTML = "bid_html_template";
    public static final String BID_IDENTIFIER = "bid_identifier";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String ENV_TEMPLATE = "window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,impFired:true,mobileDeviceInfo:%s};";
    public static final String ENV_TEMPLATE_INFO = "window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,amznAdInfo:%s,impFired:true,mobileDeviceInfo:%s};";
    public static final String EVENT_JSON_SUBTYPE = "subtype";
    public static final String EVENT_SERVER_PARAMETER = "event_server_parameter";
    public static final String EXPECTED_HEIGHT = "expected_height";
    public static final String EXPECTED_WIDTH = "expected_width";
    public static final String HOSTNAME_IDENTIFIER = "hostname_identifier";
    public static final String MOBILE_DEVICE_INFO = "{os:'%s',fwk:'%s',osVersion:'%s',model:'%s',screenSize:'%s',orientation:'%s'}";
    public static final String MRAID_IDENTIFIER = "MRAID_ENV";
    public static final String ON_DISPLAY_AD_FAILED_TO_LOAD = "onAdFailedToLoad";
    public static final String ON_DISPLAY_AD_LOADED = "onAdLoaded";
    public static final String ON_END_CARD_CLOSED = "END_CARD_VIDEO_CLOSED";
    public static final String ON_END_CARD_COMPANION_AD_START = "END_CARD_COMPANION_AD_START";
    public static final String ON_VIDEO_AD_FAILED_TO_LOAD = "AD_FAILED_TO_LOAD";
    public static final String ON_VIDEO_AD_LOADED = "AD_LOADED";
    public static final String REQUEST_QUEUE = "amazon_request_queue";
    public static final String SMARTBANNER_STATE = "smart_banner_state";
    public static final String START_LOAD_TIME = "start_load_time";
    public static final String VIDEO = "video_flag";
    public static final String VIDEO_CLICK_EVENT = "AD_VIDEO_PLAYER_CLICKED";
    public static final String VIDEO_COMPLETE_EVENT = "AD_VIDEO_PLAYER_COMPLETED";
    public static final String VIDEO_EVENT_JS_COMMAND_TYPE = "apsvid";

    /* JADX INFO: compiled from: ApsAdViewConstants.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/amazon/aps/ads/util/adview/ApsAdViewConstants$Companion;", "", "()V", "ADDITIONAL_WEBVIEW_METRICS", "", "AD_INFO_FEATURE", "AD_INFO_MATCHER_NUMBER", "", "AD_INFO_PATTERN", "AMAZON_AD_INFO", "AMAZON_BRIDGE", "AMAZON_INFO", "BID_HTML", "BID_IDENTIFIER", "ENV_TEMPLATE", "ENV_TEMPLATE_INFO", "EVENT_JSON_SUBTYPE", "EVENT_SERVER_PARAMETER", "EXPECTED_HEIGHT", "EXPECTED_WIDTH", "HOSTNAME_IDENTIFIER", "MOBILE_DEVICE_INFO", "MRAID_IDENTIFIER", "ON_DISPLAY_AD_FAILED_TO_LOAD", "ON_DISPLAY_AD_LOADED", "ON_END_CARD_CLOSED", "ON_END_CARD_COMPANION_AD_START", "ON_VIDEO_AD_FAILED_TO_LOAD", "ON_VIDEO_AD_LOADED", "REQUEST_QUEUE", "SMARTBANNER_STATE", "START_LOAD_TIME", ShareConstants.VIDEO_URL, "VIDEO_CLICK_EVENT", "VIDEO_COMPLETE_EVENT", "VIDEO_EVENT_JS_COMMAND_TYPE", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ADDITIONAL_WEBVIEW_METRICS = "additional_webview_metric";
        public static final String AD_INFO_FEATURE = "webviewAdInfo_feature";
        public static final int AD_INFO_MATCHER_NUMBER = 4;
        public static final String AD_INFO_PATTERN = "amzn.dtb.loadAd\\(\\\"(.*)\\\", \\\"(.*)\\\", \\\"(.*)\\\".*isv: (\\w+)";
        public static final String AMAZON_AD_INFO = "amazon_ad_info";
        public static final String AMAZON_BRIDGE = "amzn_bridge";
        public static final String AMAZON_INFO = "{bidID:'%s',aaxHost:'%s',pricePoint:'%s'}";
        public static final String BID_HTML = "bid_html_template";
        public static final String BID_IDENTIFIER = "bid_identifier";
        public static final String ENV_TEMPLATE = "window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,impFired:true,mobileDeviceInfo:%s};";
        public static final String ENV_TEMPLATE_INFO = "window.MRAID_ENV={version:'%s',sdk:'%s',sdkVersion:'%s',appId:'%s',ifa:'%s',limitAdTracking:%b,coppa:%b,amznAdInfo:%s,impFired:true,mobileDeviceInfo:%s};";
        public static final String EVENT_JSON_SUBTYPE = "subtype";
        public static final String EVENT_SERVER_PARAMETER = "event_server_parameter";
        public static final String EXPECTED_HEIGHT = "expected_height";
        public static final String EXPECTED_WIDTH = "expected_width";
        public static final String HOSTNAME_IDENTIFIER = "hostname_identifier";
        public static final String MOBILE_DEVICE_INFO = "{os:'%s',fwk:'%s',osVersion:'%s',model:'%s',screenSize:'%s',orientation:'%s'}";
        public static final String MRAID_IDENTIFIER = "MRAID_ENV";
        public static final String ON_DISPLAY_AD_FAILED_TO_LOAD = "onAdFailedToLoad";
        public static final String ON_DISPLAY_AD_LOADED = "onAdLoaded";
        public static final String ON_END_CARD_CLOSED = "END_CARD_VIDEO_CLOSED";
        public static final String ON_END_CARD_COMPANION_AD_START = "END_CARD_COMPANION_AD_START";
        public static final String ON_VIDEO_AD_FAILED_TO_LOAD = "AD_FAILED_TO_LOAD";
        public static final String ON_VIDEO_AD_LOADED = "AD_LOADED";
        public static final String REQUEST_QUEUE = "amazon_request_queue";
        public static final String SMARTBANNER_STATE = "smart_banner_state";
        public static final String START_LOAD_TIME = "start_load_time";
        public static final String VIDEO = "video_flag";
        public static final String VIDEO_CLICK_EVENT = "AD_VIDEO_PLAYER_CLICKED";
        public static final String VIDEO_COMPLETE_EVENT = "AD_VIDEO_PLAYER_COMPLETED";
        public static final String VIDEO_EVENT_JS_COMMAND_TYPE = "apsvid";

        private Companion() {
        }
    }
}

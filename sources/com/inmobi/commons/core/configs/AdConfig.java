package com.inmobi.commons.core.configs;

import android.graphics.Color;
import android.text.TextUtils;
import com.android.billingclient.api.BillingFlowParams;
import com.inmobi.media.AbstractC3420j2;
import com.inmobi.media.C3306b0;
import com.inmobi.media.C3460lc;
import com.inmobi.media.U3;
import com.safedk.android.analytics.brandsafety.l;
import com.smaato.sdk.video.vast.model.Ad;
import com.unity3d.services.UnityAdsConstants;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.pubnative.lite.sdk.analytics.Reporting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0007\u0018\u0000 \u0095\u00012\u00020\u0001:*\u0096\u0001\u0097\u0001\u0098\u0001\u0099\u0001\u009a\u0001\u009b\u0001\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001¡\u0001¢\u0001£\u0001¤\u0001¥\u0001¦\u0001§\u0001¨\u0001©\u0001ª\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\rR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\u0005R\"\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010&\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010&\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010)R\"\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010&\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010)R$\u00104\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010 \u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010 \u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010=R\u0016\u0010A\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010&R$\u0010C\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bC\u0010&\u001a\u0004\bD\u0010\rR\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010K\u001a\u00020J8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010[\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001a\u00020a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010i\u001a\u00020h8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010p\u001a\u00020o8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010w\u001a\u00020v8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R&\u0010~\u001a\u00020}8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u0087\u0001\u001a\u00030\u0086\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001a\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008d\u0001\u0010\"R,\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u00018F@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006«\u0001"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig;", "Lcom/inmobi/commons/core/configs/Config;", "", BillingFlowParams.EXTRA_PARAM_KEY_ACCOUNT_ID, "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "Lorg/json/JSONObject;", "toJson", "()Lorg/json/JSONObject;", "", "isValid", "()Z", "", "getMaxPoolSize", "()I", Ad.AD_TYPE, "Lcom/inmobi/commons/core/configs/AdConfig$CacheConfig;", "getCacheConfig", "(Ljava/lang/String;)Lcom/inmobi/commons/core/configs/AdConfig$CacheConfig;", "Lcom/inmobi/commons/core/configs/AdConfig$ImaiConfig;", "getImaiConfig", "()Lcom/inmobi/commons/core/configs/AdConfig$ImaiConfig;", "Lcom/inmobi/commons/core/configs/AdConfig$MraidConfig;", "getMraidConfig", "()Lcom/inmobi/commons/core/configs/AdConfig$MraidConfig;", "Lcom/inmobi/commons/core/configs/AdConfig$AssetCacheConfig;", "getAssetCacheConfig", "()Lcom/inmobi/commons/core/configs/AdConfig$AssetCacheConfig;", "isCCTEnabled", "maxPoolSize", "I", "url", "Ljava/lang/String;", "getUrl", "setUrl", "applyGzipReq", "Z", "getApplyGzipReq", "setApplyGzipReq", "(Z)V", "skipNetCheckHB", "getSkipNetCheckHB", "setSkipNetCheckHB", "enableCookiesOnInAppBrowser", "getEnableCookiesOnInAppBrowser", "setEnableCookiesOnInAppBrowser", "skipNetworkValidationFeatureEnabled", "getSkipNetworkValidationFeatureEnabled", "setSkipNetworkValidationFeatureEnabled", "Lcom/inmobi/commons/core/configs/AdConfig$CustomNetworkValidation;", "customNwValidation", "Lcom/inmobi/commons/core/configs/AdConfig$CustomNetworkValidation;", "getCustomNwValidation", "()Lcom/inmobi/commons/core/configs/AdConfig$CustomNetworkValidation;", "setCustomNwValidation", "(Lcom/inmobi/commons/core/configs/AdConfig$CustomNetworkValidation;)V", "minimumRefreshInterval", "getMinimumRefreshInterval", "setMinimumRefreshInterval", "(I)V", "defaultRefreshInterval", "getDefaultRefreshInterval", "setDefaultRefreshInterval", "cctEnabled", "<set-?>", "watermarkEnabled", "getWatermarkEnabled", "", Reporting.EventType.CACHE, "Ljava/util/Map;", "imai", "Lcom/inmobi/commons/core/configs/AdConfig$ImaiConfig;", "Lcom/inmobi/commons/core/configs/AdConfig$RenderingConfig;", "rendering", "Lcom/inmobi/commons/core/configs/AdConfig$RenderingConfig;", "getRendering", "()Lcom/inmobi/commons/core/configs/AdConfig$RenderingConfig;", "setRendering", "(Lcom/inmobi/commons/core/configs/AdConfig$RenderingConfig;)V", "mraid", "Lcom/inmobi/commons/core/configs/AdConfig$MraidConfig;", "Lcom/inmobi/commons/core/configs/AdConfig$ViewabilityConfig;", "viewability", "Lcom/inmobi/commons/core/configs/AdConfig$ViewabilityConfig;", "getViewability", "()Lcom/inmobi/commons/core/configs/AdConfig$ViewabilityConfig;", "setViewability", "(Lcom/inmobi/commons/core/configs/AdConfig$ViewabilityConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$ContextualDataConfig;", "contextualData", "Lcom/inmobi/commons/core/configs/AdConfig$ContextualDataConfig;", "getContextualData", "()Lcom/inmobi/commons/core/configs/AdConfig$ContextualDataConfig;", "setContextualData", "(Lcom/inmobi/commons/core/configs/AdConfig$ContextualDataConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$AdQualityConfig;", "adQuality", "Lcom/inmobi/commons/core/configs/AdConfig$AdQualityConfig;", "getAdQuality", "()Lcom/inmobi/commons/core/configs/AdConfig$AdQualityConfig;", "setAdQuality", "(Lcom/inmobi/commons/core/configs/AdConfig$AdQualityConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$AdReportConfig;", "adReport", "Lcom/inmobi/commons/core/configs/AdConfig$AdReportConfig;", "getAdReport", "()Lcom/inmobi/commons/core/configs/AdConfig$AdReportConfig;", "setAdReport", "(Lcom/inmobi/commons/core/configs/AdConfig$AdReportConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$AudioConfig;", "audio", "Lcom/inmobi/commons/core/configs/AdConfig$AudioConfig;", "getAudio", "()Lcom/inmobi/commons/core/configs/AdConfig$AudioConfig;", "setAudio", "(Lcom/inmobi/commons/core/configs/AdConfig$AudioConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;", "webAssetCache", "Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;", "getWebAssetCache", "()Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;", "setWebAssetCache", "(Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;)V", "Lcom/inmobi/commons/core/configs/AdConfig$VastVideoConfig;", "vastVideo", "Lcom/inmobi/commons/core/configs/AdConfig$VastVideoConfig;", "getVastVideo", "()Lcom/inmobi/commons/core/configs/AdConfig$VastVideoConfig;", "setVastVideo", "(Lcom/inmobi/commons/core/configs/AdConfig$VastVideoConfig;)V", "assetCache", "Lcom/inmobi/commons/core/configs/AdConfig$AssetCacheConfig;", "Lcom/inmobi/media/lc;", "timeouts", "Lcom/inmobi/media/lc;", "getTimeouts", "()Lcom/inmobi/media/lc;", "setTimeouts", "(Lcom/inmobi/media/lc;)V", "deprecate", "Lcom/inmobi/media/b0;", "adReqDeprecateChecker", "Lcom/inmobi/media/b0;", "getAdReqDeprecateChecker", "()Lcom/inmobi/media/b0;", "setAdReqDeprecateChecker", "(Lcom/inmobi/media/b0;)V", "Companion", "AdQualityConfig", "AdReportConfig", "AssetCacheConfig", "AudioConfig", "AudioViewabilityConfig", "BannerImpressionTypeConfig", "BitRateConfig", "CacheConfig", "com/inmobi/commons/core/configs/b", "ContextualDataConfig", "CustomNetworkValidation", "ImaiConfig", "InterstitialImpressionTypeConfig", "MraidConfig", "OmidConfig", "RenderingConfig", "VastVideoConfig", "VideoViewabilityConfig", "ViewabilityConfig", "WebAssetCacheConfig", "WebViewabilityConfig", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AdConfig extends Config {
    private static final String ALLOWED_CONTENT_TYPE = "allowedContentType";
    public static final long DEFAULT_AD_LOAD_RETRY_INTERVAL = 1000;
    public static final boolean DEFAULT_AD_QUALITY_KILL_SWITCH = true;
    public static final int DEFAULT_AD_QUALITY_MAX_IMAGE_SIZE = 153600;
    public static final int DEFAULT_AD_QUALITY_MAX_RETRIES = 3;
    public static final int DEFAULT_AD_QUALITY_RESIZE_PERCENTAGE = 100;
    public static final int DEFAULT_AD_QUALITY_RETRY_INTERVAL = 5000;
    public static final boolean DEFAULT_AD_REPORT_KILL_SWITCH = true;
    public static final int DEFAULT_AD_REPORT_LIST_SIZE = 10;
    public static final String DEFAULT_AD_SERVER_URL = "https://ads.inmobi.com/sdk";
    public static final boolean DEFAULT_CCT_ENABLED = false;
    public static final int DEFAULT_CONTEXTUAL_DATA_EXPIRY_TIME = 86400;
    public static final int DEFAULT_CONTEXTUAL_DATA_MAX_RECORDS = 1;
    public static final int DEFAULT_MAX_POOL_SIZE = 10;
    public static final int DEFAULT_MINIMUM_AUDIO_REFRESH_INTERVAL = 20;
    public static final int DEFAULT_MINIMUM_REFRESH_INTERVAL = 20;
    public static final int DEFAULT_MIN_VOLUME_AUDIO_REQUEST = 30;
    public static final short DEFAULT_NETWORK_LOAD_LIMIT = 50;
    public static final int DEFAULT_REFRESH_INTERVAL = 60;
    public static final int DEFAULT_TOUCH_RESET_TIME = 4;
    public static final boolean DEFAULT_WATERMARK_KILL_SWITCH = true;
    private static final String GESTURE_LIST = "gestures";
    public static final int MIN_IMPRESSION_POLL_INTERVAL_MILLIS = 50;
    public static final int MIN_VISIBILITY_THROTTLE_INTERVAL_MILLIS = 50;
    public static final byte NETWORK_LOAD_LIMIT_DISABLED = -1;
    private static final String SKIP_FIELDS = "skipFields";
    private AdQualityConfig adQuality;
    private AdReportConfig adReport;
    private C3306b0 adReqDeprecateChecker;
    private boolean applyGzipReq;
    private AssetCacheConfig assetCache;
    private AudioConfig audio;
    private Map<String, CacheConfig> cache;
    private boolean cctEnabled;
    private ContextualDataConfig contextualData;
    private CustomNetworkValidation customNwValidation;
    private int defaultRefreshInterval;
    private String deprecate;
    private boolean enableCookiesOnInAppBrowser;
    private ImaiConfig imai;
    private int maxPoolSize;
    private int minimumRefreshInterval;
    private MraidConfig mraid;
    private RenderingConfig rendering;
    private boolean skipNetCheckHB;
    private boolean skipNetworkValidationFeatureEnabled;
    private C3460lc timeouts;
    private String url;
    private VastVideoConfig vastVideo;
    private ViewabilityConfig viewability;
    private boolean watermarkEnabled;
    private WebAssetCacheConfig webAssetCache;
    public static final b Companion = new b();
    private static final List<String> DEFAULT_CONTEXTUAL_DATA_SKIP_FIELDS = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\bH\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$AdQualityConfig;", "", "()V", "<set-?>", "", "enabled", "getEnabled", "()Z", "", "maxImageSize", "getMaxImageSize", "()I", "maxRetries", "getMaxRetries", "resizedPercentage", "getResizedPercentage", "retryInterval", "getRetryInterval", "isValid", "setEnableAdQuality", "", com.json.mediationsdk.metadata.a.j, "setMaxImageSize", ContentDisposition.Parameters.Size, "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AdQualityConfig {
        private boolean enabled = true;
        private int maxRetries = 3;
        private int retryInterval = 5000;
        private int maxImageSize = AdConfig.DEFAULT_AD_QUALITY_MAX_IMAGE_SIZE;
        private final int resizedPercentage = 100;

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final int getMaxImageSize() {
            return this.maxImageSize;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final int getResizedPercentage() {
            return this.resizedPercentage;
        }

        public final int getRetryInterval() {
            return this.retryInterval;
        }

        public final boolean isValid() {
            return this.maxRetries >= 0 && this.retryInterval >= 0 && this.maxImageSize >= 1 && this.resizedPercentage <= 100;
        }

        public final void setEnableAdQuality(boolean enable) {
            this.enabled = enable;
        }

        public final void setMaxImageSize(int size) {
            this.maxImageSize = size;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$AdReportConfig;", "", "()V", "cridls", "", "getCridls", "()I", "setCridls", "(I)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AdReportConfig {
        private boolean enabled = true;
        private int cridls = 10;

        public final int getCridls() {
            return this.cridls;
        }

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final void setCridls(int i) {
            this.cridls = i;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$AssetCacheConfig;", "", "()V", "maxCacheSize", "", "maxRetries", "", "retryInterval", "timeToLive", "getMaxCacheSize", "getMaxRetries", "getRetryInterval", "getTimeToLive", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AssetCacheConfig {
        private int maxRetries = 3;
        private int retryInterval = 1;
        private long maxCacheSize = 104857600;
        private long timeToLive = CrashConfig.DEFAULT_EVENT_TTL_SEC;

        public final long getMaxCacheSize() {
            return this.maxCacheSize;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final int getRetryInterval() {
            return this.retryInterval;
        }

        public final long getTimeToLive() {
            return this.timeToLive;
        }

        public final boolean isValid() {
            return getRetryInterval() >= 0 && getTimeToLive() >= 0 && getMaxCacheSize() >= 0 && getMaxRetries() >= 0;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0004R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$AudioConfig;", "", "()V", "<set-?>", "", "isAudioEnabled", "()Z", "setAudioEnabled", "(Z)V", "", "minDeviceVolume", "getMinDeviceVolume", "()I", "setMinDeviceVolume", "(I)V", "minRefreshInterval", "getMinRefreshInterval", "setMinRefreshInterval", "isValid", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudioConfig {
        private boolean isAudioEnabled = true;
        private int minDeviceVolume = 30;
        private int minRefreshInterval = 20;

        public final int getMinDeviceVolume() {
            return this.minDeviceVolume;
        }

        public final int getMinRefreshInterval() {
            return this.minRefreshInterval;
        }

        /* JADX INFO: renamed from: isAudioEnabled, reason: from getter */
        public final boolean getIsAudioEnabled() {
            return this.isAudioEnabled;
        }

        public final boolean isValid() {
            return this.minDeviceVolume > 0 && this.minRefreshInterval > 0;
        }

        public final void setAudioEnabled(boolean z) {
            this.isAudioEnabled = z;
        }

        public final void setMinDeviceVolume(int i) {
            this.minDeviceVolume = i;
        }

        public final void setMinRefreshInterval(int i) {
            this.minRefreshInterval = i;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$AudioViewabilityConfig;", "", "()V", "impressionMinPercentageViewed", "", "getImpressionMinPercentageViewed", "()I", "setImpressionMinPercentageViewed", "(I)V", "impressionMinTimeViewed", "getImpressionMinTimeViewed", "setImpressionMinTimeViewed", "impressionType", "", "getImpressionType", "()B", "setImpressionType", "(B)V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudioViewabilityConfig {
        private byte impressionType = 1;
        private int impressionMinPercentageViewed = 90;
        private int impressionMinTimeViewed = 2000;

        public final int getImpressionMinPercentageViewed() {
            return this.impressionMinPercentageViewed;
        }

        public final int getImpressionMinTimeViewed() {
            return this.impressionMinTimeViewed;
        }

        public final byte getImpressionType() {
            return this.impressionType;
        }

        public final void setImpressionMinPercentageViewed(int i) {
            this.impressionMinPercentageViewed = i;
        }

        public final void setImpressionMinTimeViewed(int i) {
            this.impressionMinTimeViewed = i;
        }

        public final void setImpressionType(byte b) {
            this.impressionType = b;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$BannerImpressionTypeConfig;", "", "()V", "impressionType", "", "getImpressionType", "()B", "setImpressionType", "(B)V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BannerImpressionTypeConfig {
        private byte impressionType;

        public final byte getImpressionType() {
            return this.impressionType;
        }

        public final void setImpressionType(byte b) {
            this.impressionType = b;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$BitRateConfig;", "", "()V", "bitrate_mandatory", "", "headerTimeout", "", "getHeaderTimeout", "isBitRateMandatory", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BitRateConfig {
        private boolean bitrate_mandatory;
        private int headerTimeout = 2000;

        public final int getHeaderTimeout() {
            return this.headerTimeout;
        }

        /* JADX INFO: renamed from: isBitRateMandatory, reason: from getter */
        public final boolean getBitrate_mandatory() {
            return this.bitrate_mandatory;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$CacheConfig;", "", "()V", "timeToLive", "", "getTimeToLive", "()J", "setTimeToLive", "(J)V", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CacheConfig {
        private long timeToLive = 3300;

        public final long getTimeToLive() {
            return this.timeToLive;
        }

        public final boolean isValid() {
            return this.timeToLive >= 0;
        }

        public final void setTimeToLive(long j) {
            this.timeToLive = j;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$ContextualDataConfig;", "", "()V", "<set-?>", "", "expiryTime", "getExpiryTime", "()I", "maxAdRecords", "getMaxAdRecords", "", "", AdConfig.SKIP_FIELDS, "getSkipFields", "()Ljava/util/List;", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ContextualDataConfig {
        private int expiryTime;
        private int maxAdRecords = 1;
        private List<String> skipFields;

        public ContextualDataConfig() {
            AdConfig.Companion.getClass();
            this.skipFields = AdConfig.DEFAULT_CONTEXTUAL_DATA_SKIP_FIELDS;
            this.expiryTime = AdConfig.DEFAULT_CONTEXTUAL_DATA_EXPIRY_TIME;
        }

        public final int getExpiryTime() {
            return this.expiryTime;
        }

        public final int getMaxAdRecords() {
            return this.maxAdRecords;
        }

        public final List<String> getSkipFields() {
            return this.skipFields;
        }

        public final boolean isValid() {
            return this.maxAdRecords >= 0 && this.expiryTime >= 0;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$CustomNetworkValidation;", "", "()V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "nonValidatedExpiry", "", "getNonValidatedExpiry", "()J", "setNonValidatedExpiry", "(J)V", "refreshDebounceTime", "getRefreshDebounceTime", "setRefreshDebounceTime", "urlDomain", "", "getUrlDomain", "()Ljava/lang/String;", "setUrlDomain", "(Ljava/lang/String;)V", "validatedExpiry", "getValidatedExpiry", "setValidatedExpiry", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CustomNetworkValidation {
        private boolean enabled;
        private String urlDomain = "supply.inmobicdn.net";
        private long refreshDebounceTime = 1000;
        private long validatedExpiry = UnityAdsConstants.Timeout.INIT_TIMEOUT_MS;
        private long nonValidatedExpiry = 30000;

        public final boolean getEnabled() {
            return this.enabled;
        }

        public final long getNonValidatedExpiry() {
            return this.nonValidatedExpiry;
        }

        public final long getRefreshDebounceTime() {
            return this.refreshDebounceTime;
        }

        public final String getUrlDomain() {
            return this.urlDomain;
        }

        public final long getValidatedExpiry() {
            return this.validatedExpiry;
        }

        public final void setEnabled(boolean z) {
            this.enabled = z;
        }

        public final void setNonValidatedExpiry(long j) {
            this.nonValidatedExpiry = j;
        }

        public final void setRefreshDebounceTime(long j) {
            this.refreshDebounceTime = j;
        }

        public final void setUrlDomain(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.urlDomain = str;
        }

        public final void setValidatedExpiry(long j) {
            this.validatedExpiry = j;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$ImaiConfig;", "", "()V", "maxDbEvents", "", "maxEventBatch", "maxRetries", "pingCacheExpiry", "", "pingInterval", "pingTimeout", "getMaxDbEvents", "getMaxEventBatch", "getMaxRetries", "getPingCacheExpiry", "getPingInterval", "getPingTimeout", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ImaiConfig {
        private int maxRetries = 3;
        private int pingInterval = 60;
        private int pingTimeout = 120;
        private int maxDbEvents = 500;
        private int maxEventBatch = 10;
        private long pingCacheExpiry = 10800;

        public final int getMaxDbEvents() {
            return this.maxDbEvents;
        }

        public final int getMaxEventBatch() {
            return this.maxEventBatch;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final long getPingCacheExpiry() {
            return this.pingCacheExpiry;
        }

        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final int getPingTimeout() {
            return this.pingTimeout;
        }

        public final boolean isValid() {
            return getMaxDbEvents() >= 0 && getMaxEventBatch() >= 0 && getMaxRetries() >= 0 && getPingInterval() >= 0 && getPingTimeout() > 0 && getPingCacheExpiry() > 0;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$InterstitialImpressionTypeConfig;", "", "()V", "impressionType", "", "getImpressionType", "()B", "setImpressionType", "(B)V", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InterstitialImpressionTypeConfig {
        private byte impressionType = 1;

        public final byte getImpressionType() {
            return this.impressionType;
        }

        public final void setImpressionType(byte b) {
            this.impressionType = b;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$MraidConfig;", "", "()V", "expiry", "", "maxRetries", "", "retryInterval", "url", "", "getExpiry", "getMaxRetries", "getRetryInterval", "getUrl", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class MraidConfig {
        private long expiry = 432000;
        private int maxRetries = 3;
        private int retryInterval = 60;
        private String url = "https://supply.inmobicdn.net/sdk/sdk/1082/android/mraid.js";

        public final long getExpiry() {
            return this.expiry;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final int getRetryInterval() {
            return this.retryInterval;
        }

        public final String getUrl() {
            return this.url;
        }

        public final boolean isValid() {
            return getExpiry() >= 0 && getRetryInterval() >= 0 && getMaxRetries() >= 0 && !U3.a(this.url);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0006J\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$OmidConfig;", "", "()V", "expiry", "", "maxRetries", "", "omidEnabled", "", "getOmidEnabled", "()Z", "setOmidEnabled", "(Z)V", "partnerKey", "", "retryInterval", "url", "webViewRetainTime", "getExpiry", "getMaxRetries", "getPartnerKey", "getRetryInterval", "getUrl", "getWebViewRetainTime", "isOmidEnabled", "isValid", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class OmidConfig {
        private long expiry = 432000;
        private int maxRetries = 3;
        private int retryInterval = 60;
        private String partnerKey = "Inmobi";
        private String url = "https://supply.inmobicdn.net/javascript/1.3.37/omsdk-service.js";
        private boolean omidEnabled = true;
        private long webViewRetainTime = 1000;

        public final long getExpiry() {
            return this.expiry;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final boolean getOmidEnabled() {
            return this.omidEnabled;
        }

        public final String getPartnerKey() {
            return this.partnerKey;
        }

        public final int getRetryInterval() {
            return this.retryInterval;
        }

        public final String getUrl() {
            return this.url;
        }

        public final long getWebViewRetainTime() {
            return this.webViewRetainTime;
        }

        public final boolean isOmidEnabled() {
            return this.omidEnabled;
        }

        public final boolean isValid() {
            String url;
            String string;
            return getMaxRetries() >= 0 && getRetryInterval() >= 0 && (url = getUrl()) != null && (string = StringsKt.trim((CharSequence) url).toString()) != null && AbstractC3420j2.a(string) && !TextUtils.isEmpty(getPartnerKey());
        }

        public final void setOmidEnabled(boolean z) {
            this.omidEnabled = z;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dJ\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$RenderingConfig;", "", "()V", "audioNetworkLoadsLimit", "", "autoRedirectionEnforcement", "", "bannerNetworkLoadsLimit", "<set-?>", "enableDomStorage", "getEnableDomStorage", "()Z", "enableImmersive", "getEnableImmersive", "enablePubMuteControl", "getEnablePubMuteControl", AdConfig.GESTURE_LIST, "", "otherNetworkLoadsLimit", "shouldRenderPopup", "userTouchResetTime", "", "webviewBackground", "", "getAudioNetworkLoadsLimit", "getAutoRedirectionEnforcement", "getBannerNetworkLoadsLimit", "getOtherNetworkLoadsLimit", "getSupportedGestures", "", "getUserTouchResetTime", "getWebviewBackgroundColor", "isValid", "parseColor", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RenderingConfig {
        private boolean enableDomStorage;
        private boolean enableImmersive;
        private boolean enablePubMuteControl;
        private boolean shouldRenderPopup;
        private String webviewBackground = "#00000000";
        private boolean autoRedirectionEnforcement = true;
        private long userTouchResetTime = 4;
        private int bannerNetworkLoadsLimit = 50;
        private int audioNetworkLoadsLimit = 50;
        private int otherNetworkLoadsLimit = -1;
        private List<Integer> gestures = CollectionsKt.mutableListOf(0, 1, 2, 3, 4, 5);

        public final int getAudioNetworkLoadsLimit() {
            return this.audioNetworkLoadsLimit;
        }

        public final boolean getAutoRedirectionEnforcement() {
            return this.autoRedirectionEnforcement;
        }

        public final int getBannerNetworkLoadsLimit() {
            return this.bannerNetworkLoadsLimit;
        }

        public final boolean getEnableDomStorage() {
            return this.enableDomStorage;
        }

        public final boolean getEnableImmersive() {
            return this.enableImmersive;
        }

        public final boolean getEnablePubMuteControl() {
            return this.enablePubMuteControl;
        }

        public final int getOtherNetworkLoadsLimit() {
            return this.otherNetworkLoadsLimit;
        }

        public final List<Integer> getSupportedGestures() {
            return this.gestures;
        }

        public final long getUserTouchResetTime() {
            return this.userTouchResetTime * ((long) 1000);
        }

        public final int getWebviewBackgroundColor() {
            try {
                return parseColor();
            } catch (IllegalArgumentException unused) {
                return Color.parseColor("#00000000");
            }
        }

        public final boolean isValid() {
            String string;
            String str = this.webviewBackground;
            if (str != null && ((str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null || string.length() != 0) && getUserTouchResetTime() >= 0 && !getSupportedGestures().isEmpty())) {
                try {
                    parseColor();
                    return true;
                } catch (IllegalArgumentException unused) {
                }
            }
            return false;
        }

        public final int parseColor() throws IllegalArgumentException {
            return Color.parseColor(this.webviewBackground);
        }

        /* JADX INFO: renamed from: shouldRenderPopup, reason: from getter */
        public final boolean getShouldRenderPopup() {
            return this.shouldRenderPopup;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$VastVideoConfig;", "", "()V", AdConfig.ALLOWED_CONTENT_TYPE, "", "", "bitRate", "Lcom/inmobi/commons/core/configs/AdConfig$BitRateConfig;", "maxWrapperLimit", "", "optimalVastVideoSize", "", "vastMaxAssetSize", "getAllowedContentType", "getBitRate", "getMaxWrapperLimit", "getOptimalVastVideoSize", "getVastMaxAssetSize", "isValid", "", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VastVideoConfig {
        private int maxWrapperLimit = 3;
        private long optimalVastVideoSize = 3145728;
        private long vastMaxAssetSize = 31457280;
        private BitRateConfig bitRate = new BitRateConfig();
        private List<String> allowedContentType = CollectionsKt.mutableListOf("video/mp4", "video/3gp", "video/3gpp", "video/webm", "image/jpeg", "image/jpg", "image/gif", "image/png");

        public final List<String> getAllowedContentType() {
            return this.allowedContentType;
        }

        public final BitRateConfig getBitRate() {
            return this.bitRate;
        }

        public final int getMaxWrapperLimit() {
            return this.maxWrapperLimit;
        }

        public final long getOptimalVastVideoSize() {
            return this.optimalVastVideoSize;
        }

        public final long getVastMaxAssetSize() {
            return this.vastMaxAssetSize;
        }

        public final boolean isValid() {
            return getOptimalVastVideoSize() <= 31457280 && getOptimalVastVideoSize() > 0 && getMaxWrapperLimit() >= 0 && getVastMaxAssetSize() > 0 && getVastMaxAssetSize() <= 31457280;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$VideoViewabilityConfig;", "", "()V", "impressionMinPercentageViewed", "", "getImpressionMinPercentageViewed", "()I", "setImpressionMinPercentageViewed", "(I)V", "impressionMinTimeViewed", "getImpressionMinTimeViewed", "setImpressionMinTimeViewed", "videoMinPercentagePlay", "getVideoMinPercentagePlay", "setVideoMinPercentagePlay", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VideoViewabilityConfig {
        private int impressionMinPercentageViewed = 50;
        private int impressionMinTimeViewed = 2000;
        private int videoMinPercentagePlay = 50;

        public final int getImpressionMinPercentageViewed() {
            return this.impressionMinPercentageViewed;
        }

        public final int getImpressionMinTimeViewed() {
            return this.impressionMinTimeViewed;
        }

        public final int getVideoMinPercentagePlay() {
            return this.videoMinPercentagePlay;
        }

        public final void setImpressionMinPercentageViewed(int i) {
            this.impressionMinPercentageViewed = i;
        }

        public final void setImpressionMinTimeViewed(int i) {
            this.impressionMinTimeViewed = i;
        }

        public final void setVideoMinPercentagePlay(int i) {
            this.videoMinPercentagePlay = i;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\bJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\bJ\u0006\u0010 \u001a\u00020\bJ\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bJ\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$ViewabilityConfig;", "", "()V", "audio", "Lcom/inmobi/commons/core/configs/AdConfig$AudioViewabilityConfig;", "banner", "Lcom/inmobi/commons/core/configs/AdConfig$BannerImpressionTypeConfig;", "displayMinPercentageAnimate", "", "impressionMinPercentageViewed", "impressionMinTimeViewed", "impressionPollIntervalMillis", l.w, "Lcom/inmobi/commons/core/configs/AdConfig$InterstitialImpressionTypeConfig;", "omidConfig", "Lcom/inmobi/commons/core/configs/AdConfig$OmidConfig;", "getOmidConfig", "()Lcom/inmobi/commons/core/configs/AdConfig$OmidConfig;", "setOmidConfig", "(Lcom/inmobi/commons/core/configs/AdConfig$OmidConfig;)V", "video", "Lcom/inmobi/commons/core/configs/AdConfig$VideoViewabilityConfig;", "visibilityThrottleMillis", "web", "Lcom/inmobi/commons/core/configs/AdConfig$WebViewabilityConfig;", "getAudioImpressionMinPercentageViewed", "getAudioImpressionMinTimeViewed", "getAudioImpressionType", "", "getBannerImpressionType", "getDisplayMinPercentageAnimate", "getImpressionMinPercentageViewed", "getImpressionMinTimeViewed", "getImpressionPollIntervalMillis", "getInterstitialImpressionType", "getVideoImpressionMinPercentageViewed", "getVideoImpressionMinTimeViewed", "getVideoMinPercentagePlay", "getVisibilityThrottleMillis", "getWebImpressionMinPercentageViewed", "getWebImpressionMinTimeViewed", "getWebVisibilityThrottleMillis", "isValid", "", "setVideoImpressionMinTimeViewed", "", "videoImpressionMinTimeViewed", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewabilityConfig {
        private int impressionMinPercentageViewed = 50;
        private int impressionMinTimeViewed = 1000;
        private int visibilityThrottleMillis = 100;
        private int impressionPollIntervalMillis = 250;
        private int displayMinPercentageAnimate = 67;
        private VideoViewabilityConfig video = new VideoViewabilityConfig();
        private AudioViewabilityConfig audio = new AudioViewabilityConfig();
        private WebViewabilityConfig web = new WebViewabilityConfig();
        private OmidConfig omidConfig = new OmidConfig();
        private BannerImpressionTypeConfig banner = new BannerImpressionTypeConfig();
        private InterstitialImpressionTypeConfig int = new InterstitialImpressionTypeConfig();

        public final int getAudioImpressionMinPercentageViewed() {
            return this.audio.getImpressionMinPercentageViewed();
        }

        public final int getAudioImpressionMinTimeViewed() {
            return this.audio.getImpressionMinTimeViewed();
        }

        public final byte getAudioImpressionType() {
            return this.audio.getImpressionType();
        }

        public final byte getBannerImpressionType() {
            return this.banner.getImpressionType();
        }

        public final int getDisplayMinPercentageAnimate() {
            return this.displayMinPercentageAnimate;
        }

        public final int getImpressionMinPercentageViewed() {
            return this.impressionMinPercentageViewed;
        }

        public final int getImpressionMinTimeViewed() {
            return this.impressionMinTimeViewed;
        }

        public final int getImpressionPollIntervalMillis() {
            return this.impressionPollIntervalMillis;
        }

        public final byte getInterstitialImpressionType() {
            return this.int.getImpressionType();
        }

        public final OmidConfig getOmidConfig() {
            return this.omidConfig;
        }

        public final int getVideoImpressionMinPercentageViewed() {
            return this.video.getImpressionMinPercentageViewed();
        }

        public final int getVideoImpressionMinTimeViewed() {
            return this.video.getImpressionMinTimeViewed();
        }

        public final int getVideoMinPercentagePlay() {
            return this.video.getVideoMinPercentagePlay();
        }

        public final int getVisibilityThrottleMillis() {
            return this.visibilityThrottleMillis;
        }

        public final int getWebImpressionMinPercentageViewed() {
            return this.web.getImpressionMinPercentageViewed();
        }

        public final int getWebImpressionMinTimeViewed() {
            return this.web.getImpressionMinTimeViewed();
        }

        public final int getWebVisibilityThrottleMillis() {
            return this.web.getImpressionPollIntervalMillis();
        }

        public final boolean isValid() {
            return getImpressionMinPercentageViewed() > 0 && getImpressionMinPercentageViewed() <= 100 && getImpressionMinTimeViewed() >= 0 && getDisplayMinPercentageAnimate() > 0 && getDisplayMinPercentageAnimate() <= 100 && getVideoImpressionMinPercentageViewed() > 0 && getVideoImpressionMinPercentageViewed() <= 100 && getWebImpressionMinPercentageViewed() > 0 && getWebImpressionMinPercentageViewed() <= 100 && getWebVisibilityThrottleMillis() > 0 && getWebImpressionMinTimeViewed() >= 0 && getVideoImpressionMinTimeViewed() >= 0 && getVideoMinPercentagePlay() > 0 && getVideoMinPercentagePlay() <= 100 && getVisibilityThrottleMillis() >= 50 && getVisibilityThrottleMillis() * 5 <= getImpressionMinTimeViewed() && getImpressionPollIntervalMillis() >= 50 && getImpressionPollIntervalMillis() * 4 <= getImpressionMinTimeViewed() && this.omidConfig.isValid();
        }

        public final void setOmidConfig(OmidConfig omidConfig) {
            Intrinsics.checkNotNullParameter(omidConfig, "<set-?>");
            this.omidConfig = omidConfig;
        }

        public final void setVideoImpressionMinTimeViewed(int videoImpressionMinTimeViewed) {
            this.video.setImpressionMinTimeViewed(videoImpressionMinTimeViewed);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001!B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJB\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001c\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001e\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;", "", "", "cacheSize", "timeout", "maxRetries", "minAvailableDiskSpace", "cacheSizeToDiskSpaceMaxPercent", "<init>", "(IIIII)V", "component1", "()I", "component2", "component3", "component4", "component5", "copy", "(IIIII)Lcom/inmobi/commons/core/configs/AdConfig$WebAssetCacheConfig;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCacheSize", "getTimeout", "getMaxRetries", "getMinAvailableDiskSpace", "getCacheSizeToDiskSpaceMaxPercent", "Companion", "com/inmobi/commons/core/configs/c", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class WebAssetCacheConfig {
        public static final c Companion = new c();
        private static final int DEFAULT_CACHE_SIZE_MB = 15;
        private static final int DEFAULT_CACHE_SIZE_TO_DISK_SPACE_PERCENT = 10;
        private static final int DEFAULT_MAX_RETRIES = 1;
        private static final int DEFAULT_MIN_AVAILABLE_DISK_SPACE = 50;
        private static final int DEFAULT_TIMEOUT_MS = 5000;
        private final int cacheSize;
        private final int cacheSizeToDiskSpaceMaxPercent;
        private final int maxRetries;
        private final int minAvailableDiskSpace;
        private final int timeout;

        public WebAssetCacheConfig() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public static /* synthetic */ WebAssetCacheConfig copy$default(WebAssetCacheConfig webAssetCacheConfig, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = webAssetCacheConfig.cacheSize;
            }
            if ((i6 & 2) != 0) {
                i2 = webAssetCacheConfig.timeout;
            }
            int i7 = i2;
            if ((i6 & 4) != 0) {
                i3 = webAssetCacheConfig.maxRetries;
            }
            int i8 = i3;
            if ((i6 & 8) != 0) {
                i4 = webAssetCacheConfig.minAvailableDiskSpace;
            }
            int i9 = i4;
            if ((i6 & 16) != 0) {
                i5 = webAssetCacheConfig.cacheSizeToDiskSpaceMaxPercent;
            }
            return webAssetCacheConfig.copy(i, i7, i8, i9, i5);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getCacheSize() {
            return this.cacheSize;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getTimeout() {
            return this.timeout;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getMaxRetries() {
            return this.maxRetries;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getMinAvailableDiskSpace() {
            return this.minAvailableDiskSpace;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getCacheSizeToDiskSpaceMaxPercent() {
            return this.cacheSizeToDiskSpaceMaxPercent;
        }

        public final WebAssetCacheConfig copy(int cacheSize, int timeout, int maxRetries, int minAvailableDiskSpace, int cacheSizeToDiskSpaceMaxPercent) {
            return new WebAssetCacheConfig(cacheSize, timeout, maxRetries, minAvailableDiskSpace, cacheSizeToDiskSpaceMaxPercent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WebAssetCacheConfig)) {
                return false;
            }
            WebAssetCacheConfig webAssetCacheConfig = (WebAssetCacheConfig) other;
            return this.cacheSize == webAssetCacheConfig.cacheSize && this.timeout == webAssetCacheConfig.timeout && this.maxRetries == webAssetCacheConfig.maxRetries && this.minAvailableDiskSpace == webAssetCacheConfig.minAvailableDiskSpace && this.cacheSizeToDiskSpaceMaxPercent == webAssetCacheConfig.cacheSizeToDiskSpaceMaxPercent;
        }

        public final int getCacheSize() {
            return this.cacheSize;
        }

        public final int getCacheSizeToDiskSpaceMaxPercent() {
            return this.cacheSizeToDiskSpaceMaxPercent;
        }

        public final int getMaxRetries() {
            return this.maxRetries;
        }

        public final int getMinAvailableDiskSpace() {
            return this.minAvailableDiskSpace;
        }

        public final int getTimeout() {
            return this.timeout;
        }

        public int hashCode() {
            return Integer.hashCode(this.cacheSizeToDiskSpaceMaxPercent) + ((Integer.hashCode(this.minAvailableDiskSpace) + ((Integer.hashCode(this.maxRetries) + ((Integer.hashCode(this.timeout) + (Integer.hashCode(this.cacheSize) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "WebAssetCacheConfig(cacheSize=" + this.cacheSize + ", timeout=" + this.timeout + ", maxRetries=" + this.maxRetries + ", minAvailableDiskSpace=" + this.minAvailableDiskSpace + ", cacheSizeToDiskSpaceMaxPercent=" + this.cacheSizeToDiskSpaceMaxPercent + ')';
        }

        public WebAssetCacheConfig(int i, int i2, int i3, int i4, int i5) {
            this.cacheSize = i;
            this.timeout = i2;
            this.maxRetries = i3;
            this.minAvailableDiskSpace = i4;
            this.cacheSizeToDiskSpaceMaxPercent = i5;
        }

        public /* synthetic */ WebAssetCacheConfig(int i, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 15 : i, (i6 & 2) != 0 ? 5000 : i2, (i6 & 4) != 0 ? 1 : i3, (i6 & 8) != 0 ? 50 : i4, (i6 & 16) != 0 ? 10 : i5);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/inmobi/commons/core/configs/AdConfig$WebViewabilityConfig;", "", "()V", "impressionMinPercentageViewed", "", "getImpressionMinPercentageViewed", "()I", "setImpressionMinPercentageViewed", "(I)V", "impressionMinTimeViewed", "getImpressionMinTimeViewed", "setImpressionMinTimeViewed", "impressionPollIntervalMillis", "getImpressionPollIntervalMillis", "setImpressionPollIntervalMillis", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class WebViewabilityConfig {
        private int impressionMinPercentageViewed = 50;
        private int impressionMinTimeViewed = 1000;
        private int impressionPollIntervalMillis = 1000;

        public final int getImpressionMinPercentageViewed() {
            return this.impressionMinPercentageViewed;
        }

        public final int getImpressionMinTimeViewed() {
            return this.impressionMinTimeViewed;
        }

        public final int getImpressionPollIntervalMillis() {
            return this.impressionPollIntervalMillis;
        }

        public final void setImpressionMinPercentageViewed(int i) {
            this.impressionMinPercentageViewed = i;
        }

        public final void setImpressionMinTimeViewed(int i) {
            this.impressionMinTimeViewed = i;
        }

        public final void setImpressionPollIntervalMillis(int i) {
            this.impressionPollIntervalMillis = i;
        }
    }

    public AdConfig(String str) {
        super(str);
        this.maxPoolSize = 10;
        this.url = DEFAULT_AD_SERVER_URL;
        this.customNwValidation = new CustomNetworkValidation();
        this.minimumRefreshInterval = 20;
        this.defaultRefreshInterval = 60;
        this.watermarkEnabled = true;
        C3460lc.Companion.getClass();
        C3460lc c3460lc = new C3460lc();
        c3460lc.a0();
        this.timeouts = c3460lc;
        this.imai = new ImaiConfig();
        this.rendering = new RenderingConfig();
        this.mraid = new MraidConfig();
        this.viewability = new ViewabilityConfig();
        this.vastVideo = new VastVideoConfig();
        this.assetCache = new AssetCacheConfig();
        this.contextualData = new ContextualDataConfig();
        this.adQuality = new AdQualityConfig();
        this.adReport = new AdReportConfig();
        this.audio = new AudioConfig();
        this.webAssetCache = new WebAssetCacheConfig(0, 0, 0, 0, 0, 31, null);
        this.cache = MapsKt.mutableMapOf(TuplesKt.to("base", new CacheConfig()), TuplesKt.to("banner", new CacheConfig()), TuplesKt.to("audio", new CacheConfig()), TuplesKt.to(l.w, new CacheConfig()), TuplesKt.to("native", new CacheConfig()));
    }

    public final AdQualityConfig getAdQuality() {
        return this.adQuality;
    }

    public final AdReportConfig getAdReport() {
        return this.adReport;
    }

    public final C3306b0 getAdReqDeprecateChecker() {
        if (this.adReqDeprecateChecker == null) {
            String str = this.deprecate;
            C3306b0 c3306b0 = null;
            if (str != null) {
                if (!AbstractC3420j2.a(str)) {
                    str = null;
                }
                if (str != null) {
                    c3306b0 = new C3306b0(str);
                }
            }
            this.adReqDeprecateChecker = c3306b0;
        }
        return this.adReqDeprecateChecker;
    }

    public final boolean getApplyGzipReq() {
        return this.applyGzipReq;
    }

    /* JADX INFO: renamed from: getAssetCacheConfig, reason: from getter */
    public final AssetCacheConfig getAssetCache() {
        return this.assetCache;
    }

    public final AudioConfig getAudio() {
        return this.audio;
    }

    public final CacheConfig getCacheConfig(String adType) {
        Intrinsics.checkNotNullParameter(adType, "adType");
        CacheConfig cacheConfig = this.cache.get(adType);
        if (cacheConfig != null) {
            return cacheConfig;
        }
        CacheConfig cacheConfig2 = this.cache.get("base");
        return cacheConfig2 == null ? new CacheConfig() : cacheConfig2;
    }

    public final ContextualDataConfig getContextualData() {
        return this.contextualData;
    }

    public final CustomNetworkValidation getCustomNwValidation() {
        return this.customNwValidation;
    }

    public final int getDefaultRefreshInterval() {
        return this.defaultRefreshInterval;
    }

    public final boolean getEnableCookiesOnInAppBrowser() {
        return this.enableCookiesOnInAppBrowser;
    }

    /* JADX INFO: renamed from: getImaiConfig, reason: from getter */
    public final ImaiConfig getImai() {
        return this.imai;
    }

    public final int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    public final int getMinimumRefreshInterval() {
        return this.minimumRefreshInterval;
    }

    /* JADX INFO: renamed from: getMraidConfig, reason: from getter */
    public final MraidConfig getMraid() {
        return this.mraid;
    }

    public final RenderingConfig getRendering() {
        return this.rendering;
    }

    public final boolean getSkipNetCheckHB() {
        return this.skipNetCheckHB;
    }

    public final boolean getSkipNetworkValidationFeatureEnabled() {
        return this.skipNetworkValidationFeatureEnabled;
    }

    public final C3460lc getTimeouts() {
        return this.timeouts;
    }

    @Override // com.inmobi.commons.core.configs.Config
    public String getType() {
        return "ads";
    }

    public final String getUrl() {
        return this.url;
    }

    public final VastVideoConfig getVastVideo() {
        return this.vastVideo;
    }

    public final ViewabilityConfig getViewability() {
        return this.viewability;
    }

    public final boolean getWatermarkEnabled() {
        return this.watermarkEnabled;
    }

    public final WebAssetCacheConfig getWebAssetCache() {
        return this.webAssetCache;
    }

    /* JADX INFO: renamed from: isCCTEnabled, reason: from getter */
    public final boolean getCctEnabled() {
        return this.cctEnabled;
    }

    @Override // com.inmobi.commons.core.configs.Config
    public boolean isValid() {
        int i;
        int i2;
        if (this.maxPoolSize <= 0 || U3.a(this.url) || (i = this.minimumRefreshInterval) < 0 || (i2 = this.defaultRefreshInterval) < 0 || i > i2) {
            return false;
        }
        Iterator<Map.Entry<String, CacheConfig>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            if (!it.next().getValue().isValid()) {
                return false;
            }
        }
        this.timeouts.a0();
        return this.contextualData.isValid() && this.adQuality.isValid() && this.imai.isValid() && this.mraid.isValid() && this.timeouts.Z() && this.rendering.isValid() && this.vastVideo.isValid() && this.assetCache.isValid() && this.viewability.isValid() && this.audio.isValid();
    }

    public final void setAdQuality(AdQualityConfig adQualityConfig) {
        Intrinsics.checkNotNullParameter(adQualityConfig, "<set-?>");
        this.adQuality = adQualityConfig;
    }

    public final void setAdReport(AdReportConfig adReportConfig) {
        Intrinsics.checkNotNullParameter(adReportConfig, "<set-?>");
        this.adReport = adReportConfig;
    }

    public final void setAdReqDeprecateChecker(C3306b0 c3306b0) {
        this.adReqDeprecateChecker = c3306b0;
    }

    public final void setApplyGzipReq(boolean z) {
        this.applyGzipReq = z;
    }

    public final void setAudio(AudioConfig audioConfig) {
        Intrinsics.checkNotNullParameter(audioConfig, "<set-?>");
        this.audio = audioConfig;
    }

    public final void setContextualData(ContextualDataConfig contextualDataConfig) {
        Intrinsics.checkNotNullParameter(contextualDataConfig, "<set-?>");
        this.contextualData = contextualDataConfig;
    }

    public final void setCustomNwValidation(CustomNetworkValidation customNetworkValidation) {
        this.customNwValidation = customNetworkValidation;
    }

    public final void setDefaultRefreshInterval(int i) {
        this.defaultRefreshInterval = i;
    }

    public final void setEnableCookiesOnInAppBrowser(boolean z) {
        this.enableCookiesOnInAppBrowser = z;
    }

    public final void setMinimumRefreshInterval(int i) {
        this.minimumRefreshInterval = i;
    }

    public final void setRendering(RenderingConfig renderingConfig) {
        Intrinsics.checkNotNullParameter(renderingConfig, "<set-?>");
        this.rendering = renderingConfig;
    }

    public final void setSkipNetCheckHB(boolean z) {
        this.skipNetCheckHB = z;
    }

    public final void setSkipNetworkValidationFeatureEnabled(boolean z) {
        this.skipNetworkValidationFeatureEnabled = z;
    }

    public final void setTimeouts(C3460lc c3460lc) {
        Intrinsics.checkNotNullParameter(c3460lc, "<set-?>");
        this.timeouts = c3460lc;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setVastVideo(VastVideoConfig vastVideoConfig) {
        Intrinsics.checkNotNullParameter(vastVideoConfig, "<set-?>");
        this.vastVideo = vastVideoConfig;
    }

    public final void setViewability(ViewabilityConfig viewabilityConfig) {
        Intrinsics.checkNotNullParameter(viewabilityConfig, "<set-?>");
        this.viewability = viewabilityConfig;
    }

    public final void setWebAssetCache(WebAssetCacheConfig webAssetCacheConfig) {
        Intrinsics.checkNotNullParameter(webAssetCacheConfig, "<set-?>");
        this.webAssetCache = webAssetCacheConfig;
    }

    @Override // com.inmobi.commons.core.configs.Config
    public JSONObject toJson() {
        Companion.getClass();
        JSONObject jSONObjectA = b.a().a(this);
        if (jSONObjectA != null) {
            return jSONObjectA;
        }
        Intrinsics.checkNotNullExpressionValue("AdConfig", "access$getTAG$p(...)");
        return new JSONObject();
    }
}

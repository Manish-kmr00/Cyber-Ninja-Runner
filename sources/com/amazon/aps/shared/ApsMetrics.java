package com.amazon.aps.shared;

import android.content.Context;
import com.amazon.aps.ads.ApsLog;
import com.amazon.aps.ads.model.ApsLogLevel;
import com.amazon.aps.shared.analytics.APSEventSeverity;
import com.amazon.aps.shared.analytics.APSEventType;
import com.amazon.aps.shared.metrics.ApsMetricsCustomEventModelBuilder;
import com.amazon.aps.shared.metrics.ApsMetricsPerfEventModelBuilder;
import com.amazon.aps.shared.metrics.model.ApsMetricsDeviceInfo;
import com.amazon.aps.shared.metrics.model.ApsMetricsPerfAaxBidEvent;
import com.amazon.aps.shared.metrics.model.ApsMetricsSdkInfo;
import com.amazon.aps.shared.util.APSNetworkManager;
import com.amazon.aps.shared.util.APSSharedUtil;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.amazon.device.ads.DtbConstants;
import com.json.b9;
import com.json.bu;
import com.pubmatic.sdk.crashanalytics.POBCrashAnalyticsConstants;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApsMetrics.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/amazon/aps/shared/ApsMetrics;", "", "()V", "Companion", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ApsMetrics {
    private static final String CUSTOM_FAILURE_ERROR_DETAIL = "Error in sending the custom event";
    public static final int METRICS_API_SCHEMA_VERSION = 1;
    public static final double METRICS_DEFAULT_SAMPLING_RATE = 0.1d;
    private static final int SAMPLING_ALLOWED_FROM = 0;
    private static String adapterVersion;
    private static Context context;
    private static boolean isSamplingAllowed;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ApsMetricsDeviceInfo apsMetricsDeviceInfo = new ApsMetricsDeviceInfo(null, null, null, null, null, 31, null);
    private static ApsMetricsSdkInfo apsMetricsSdkInfo = new ApsMetricsSdkInfo(null, 1, null);
    private static double samplingPercentage = 0.1d;
    public static final String METRICS_DEFAULT_ENDPOINT_URL = "https://prod.tahoe-analytics.publishers.advertising.a2z.com/logevent/putRecord";
    private static String endpointUrl = METRICS_DEFAULT_ENDPOINT_URL;
    public static final String METRICS_DEFAULT_METRICS_API_KEY = "a5c71f6aff54eb34c826d952c285eaf0650b4259c83ae598962681a6429b63f6";
    private static String apiKey = METRICS_DEFAULT_METRICS_API_KEY;

    @JvmStatic
    public static final void adEvent(String str, ApsMetricsPerfEventModelBuilder apsMetricsPerfEventModelBuilder) {
        INSTANCE.adEvent(str, apsMetricsPerfEventModelBuilder);
    }

    @JvmStatic
    public static final void adapterEvent(String str, ApsMetricsPerfEventModelBuilder apsMetricsPerfEventModelBuilder) {
        INSTANCE.adapterEvent(str, apsMetricsPerfEventModelBuilder);
    }

    @JvmStatic
    public static final void bidEvent(String str, String str2, ApsMetricsPerfAaxBidEvent apsMetricsPerfAaxBidEvent) {
        INSTANCE.bidEvent(str, str2, apsMetricsPerfAaxBidEvent);
    }

    @JvmStatic
    public static final void customEvent(String str, String str2, JSONObject jSONObject) {
        INSTANCE.customEvent(str, str2, jSONObject);
    }

    @JvmStatic
    public static final void customEvent(String str, String str2, JSONObject jSONObject, String str3) {
        INSTANCE.customEvent(str, str2, jSONObject, str3);
    }

    @JvmStatic
    public static final void init(Context context2, ApsMetricsDeviceInfo apsMetricsDeviceInfo2, ApsMetricsSdkInfo apsMetricsSdkInfo2) {
        INSTANCE.init(context2, apsMetricsDeviceInfo2, apsMetricsSdkInfo2);
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return INSTANCE.isInitialized();
    }

    @JvmStatic
    private static final boolean isOkToSendData() {
        return INSTANCE.isOkToSendData();
    }

    /* JADX INFO: compiled from: ApsMetrics.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.H\u0007J\u001a\u0010/\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.H\u0007J$\u00100\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u00020+H\u0002J(\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u000109H\u0007J4\u00105\u001a\u00020+2\u0006\u00106\u001a\u00020\u00042\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010;\u001a\u00020+2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u001aH\u0007J\b\u0010>\u001a\u00020$H\u0007J\b\u0010?\u001a\u00020$H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006@"}, d2 = {"Lcom/amazon/aps/shared/ApsMetrics$Companion;", "", "()V", "CUSTOM_FAILURE_ERROR_DETAIL", "", "METRICS_API_SCHEMA_VERSION", "", "METRICS_DEFAULT_ENDPOINT_URL", "METRICS_DEFAULT_METRICS_API_KEY", "METRICS_DEFAULT_SAMPLING_RATE", "", "SAMPLING_ALLOWED_FROM", "value", bu.b, "getAdapterVersion", "()Ljava/lang/String;", "setAdapterVersion", "(Ljava/lang/String;)V", DTBMetricsConfiguration.APSMETRICS_APIKEY, "getApiKey", "setApiKey", "<set-?>", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsDeviceInfo;", "apsMetricsDeviceInfo", "getApsMetricsDeviceInfo", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsDeviceInfo;", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsSdkInfo;", "apsMetricsSdkInfo", "getApsMetricsSdkInfo", "()Lcom/amazon/aps/shared/metrics/model/ApsMetricsSdkInfo;", "context", "Landroid/content/Context;", "endpointUrl", "getEndpointUrl", "setEndpointUrl", "isSamplingAllowed", "", DTBMetricsConfiguration.APSMETRICS_SAMPLING_RATE, "getSamplingPercentage", "()D", "setSamplingPercentage", "(D)V", "adEvent", "", "bidId", "builder", "Lcom/amazon/aps/shared/metrics/ApsMetricsPerfEventModelBuilder;", "adapterEvent", "bidEvent", DtbConstants.MEDIATION_NAME, "aaxBid", "Lcom/amazon/aps/shared/metrics/model/ApsMetricsPerfAaxBidEvent;", "calculateSamplingAllowed", "customEvent", b9.h.j0, "eventValue", "extra", "Lorg/json/JSONObject;", "eventCategory", "init", POBCrashAnalyticsConstants.DEVICE_INFO_KEY, "sdkInfo", "isInitialized", "isOkToSendData", "DTBAndroidSDK_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ApsMetricsDeviceInfo getApsMetricsDeviceInfo() {
            return ApsMetrics.apsMetricsDeviceInfo;
        }

        public final ApsMetricsSdkInfo getApsMetricsSdkInfo() {
            return ApsMetrics.apsMetricsSdkInfo;
        }

        public final double getSamplingPercentage() {
            return ApsMetrics.samplingPercentage;
        }

        public final void setSamplingPercentage(double d) {
            if (0.0d > d || d > 100.0d) {
                return;
            }
            ApsMetrics.samplingPercentage = d;
            calculateSamplingAllowed();
        }

        public final String getEndpointUrl() {
            return ApsMetrics.endpointUrl;
        }

        public final void setEndpointUrl(String str) {
            if (APSSharedUtil.isNullOrEmpty(str)) {
                return;
            }
            ApsMetrics.endpointUrl = str;
        }

        public final String getApiKey() {
            return ApsMetrics.apiKey;
        }

        public final void setApiKey(String str) {
            if (APSSharedUtil.isNullOrEmpty(str)) {
                return;
            }
            ApsMetrics.apiKey = str;
        }

        public final String getAdapterVersion() {
            return ApsMetrics.adapterVersion;
        }

        public final void setAdapterVersion(String str) {
            if (str == null) {
                return;
            }
            ApsMetrics.adapterVersion = str;
        }

        public static /* synthetic */ void customEvent$default(Companion companion, String str, String str2, JSONObject jSONObject, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                jSONObject = null;
            }
            companion.customEvent(str, str2, jSONObject);
        }

        @JvmStatic
        public final void customEvent(String eventName, String eventValue, JSONObject extra) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            customEvent(eventName, eventValue, extra, null);
        }

        public static /* synthetic */ void customEvent$default(Companion companion, String str, String str2, JSONObject jSONObject, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                jSONObject = null;
            }
            if ((i & 8) != 0) {
                str3 = null;
            }
            companion.customEvent(str, str2, jSONObject, str3);
        }

        @JvmStatic
        public final void customEvent(String eventName, String eventValue, JSONObject extra, String eventCategory) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            try {
                ApsLog.d(Intrinsics.stringPlus("Logging custom event:", eventName));
                if (isOkToSendData()) {
                    ApsMetricsCustomEventModelBuilder apsMetricsCustomEventModelBuilder = new ApsMetricsCustomEventModelBuilder();
                    apsMetricsCustomEventModelBuilder.withEventName(eventName);
                    if (eventValue != null) {
                        apsMetricsCustomEventModelBuilder.withEventValue(eventValue);
                    }
                    if (extra != null) {
                        apsMetricsCustomEventModelBuilder.withEventDetail(extra);
                    }
                    if (eventCategory != null) {
                        apsMetricsCustomEventModelBuilder.withEventCategory(eventCategory);
                    }
                    JSONObject jSONObjectBuild = apsMetricsCustomEventModelBuilder.build();
                    if (jSONObjectBuild == null) {
                        return;
                    }
                    APSNetworkManager.getInstance(ApsMetrics.context).sendMetrics(jSONObjectBuild);
                }
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, ApsMetrics.CUSTOM_FAILURE_ERROR_DETAIL, e);
            }
        }

        @JvmStatic
        public final void bidEvent(String bidId, String mediationName, ApsMetricsPerfAaxBidEvent aaxBid) {
            Intrinsics.checkNotNullParameter(aaxBid, "aaxBid");
            ApsLog.d("Logging bid event");
            try {
                if (isOkToSendData()) {
                    APSNetworkManager.getInstance(ApsMetrics.context).sendMetrics(new ApsMetricsPerfEventModelBuilder().withMediationName(mediationName).withBidId(bidId).withEvent(aaxBid).build());
                }
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error sending the bid event", e);
            }
        }

        @JvmStatic
        public final void adEvent(String bidId, ApsMetricsPerfEventModelBuilder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            ApsLog.d("Logging perf metrics event");
            try {
                if (isOkToSendData()) {
                    APSNetworkManager.getInstance(ApsMetrics.context).sendMetrics(builder.withBidId(bidId).build());
                }
            } catch (RuntimeException e) {
                APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error sending the ad event", e);
            }
        }

        @JvmStatic
        public final void adapterEvent(String bidId, ApsMetricsPerfEventModelBuilder builder) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            ApsLog.d("Logging adapter event");
            adEvent(bidId, builder);
        }

        public static /* synthetic */ void init$default(Companion companion, Context context, ApsMetricsDeviceInfo apsMetricsDeviceInfo, ApsMetricsSdkInfo apsMetricsSdkInfo, int i, Object obj) {
            if ((i & 2) != 0) {
                apsMetricsDeviceInfo = null;
            }
            if ((i & 4) != 0) {
                apsMetricsSdkInfo = null;
            }
            companion.init(context, apsMetricsDeviceInfo, apsMetricsSdkInfo);
        }

        @JvmStatic
        public final void init(Context context, ApsMetricsDeviceInfo deviceInfo, ApsMetricsSdkInfo sdkInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            ApsLog.setLogLevel(ApsLogLevel.All);
            if (deviceInfo != null) {
                try {
                    Companion companion = ApsMetrics.INSTANCE;
                    ApsMetrics.apsMetricsDeviceInfo = ApsMetricsDeviceInfo.copy$default(deviceInfo, null, null, null, null, null, 31, null);
                } catch (RuntimeException e) {
                    APSAnalytics.logEvent(APSEventSeverity.FATAL, APSEventType.EXCEPTION, "Error in initializing the ApsMetrics", e);
                    return;
                }
            }
            if (sdkInfo != null) {
                Companion companion2 = ApsMetrics.INSTANCE;
                ApsMetrics.apsMetricsSdkInfo = ApsMetricsSdkInfo.copy$default(sdkInfo, null, 1, null);
            }
            Companion companion3 = ApsMetrics.INSTANCE;
            ApsMetrics.context = context;
            calculateSamplingAllowed();
        }

        @JvmStatic
        public final boolean isInitialized() {
            return ApsMetrics.context != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean isOkToSendData() {
            return isInitialized() && ApsMetrics.isSamplingAllowed && !APSSharedUtil.isNullOrEmpty(getApiKey()) && !APSSharedUtil.isNullOrEmpty(getEndpointUrl());
        }

        private final void calculateSamplingAllowed() {
            try {
                boolean z = true;
                if (new Random().nextInt(10000000) + 1 > MathKt.roundToInt(getSamplingPercentage() * ((double) 100000))) {
                    z = false;
                }
                ApsMetrics.isSamplingAllowed = z;
            } catch (RuntimeException e) {
                ApsLog.e(Intrinsics.stringPlus("Unable to set the sampling rate ", e));
            }
        }
    }

    private ApsMetrics() {
    }
}

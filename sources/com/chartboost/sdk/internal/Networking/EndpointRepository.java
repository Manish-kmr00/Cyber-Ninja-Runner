package com.chartboost.sdk.internal.Networking;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.URL;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0002\u000f\u0010J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/EndpointRepository;", "", "Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "endPoint", "", "host", "path", "", "setEndpoint", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "getEndPointUrl", "(Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;)Ljava/net/URL;", "restoreDefaults", "()V", "a", "EndPoint", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public interface EndpointRepository {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/EndpointRepository$EndPoint;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "getDefaultValue", "()Ljava/lang/String;", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CONFIG", "INSTALL", "PREFETCH", "INTERSTITIAL_GET", "INTERSTITIAL_SHOW", "REWARDED_GET", "REWARDED_SHOW", "BANNER_GET", "BANNER_SHOW", "CLICK", "VIDEO_COMPLETE", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum EndPoint {
        CONFIG("/api/config"),
        INSTALL("/api/install"),
        PREFETCH("/webview/v2/prefetch"),
        INTERSTITIAL_GET("/webview/v2/interstitial/get"),
        INTERSTITIAL_SHOW("/interstitial/show"),
        REWARDED_GET("/webview/v2/reward/get"),
        REWARDED_SHOW("/reward/show"),
        BANNER_GET("/auction/sdk/banner"),
        BANNER_SHOW("/banner/show"),
        CLICK("/api/click"),
        VIDEO_COMPLETE("/api/video-complete");


        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String defaultValue;

        EndPoint(String str) {
            this.defaultValue = str;
        }

        public final String getDefaultValue() {
            return this.defaultValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/internal/Networking/EndpointRepository$a;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "()Ljava/lang/String;", "defaultValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum a {
        AD_GET("live.chartboost.com"),
        DA("da.chartboost.com");


        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String defaultValue;

        a(String str) {
            this.defaultValue = str;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getDefaultValue() {
            return this.defaultValue;
        }
    }

    URL getEndPointUrl(EndPoint endPoint);

    void restoreDefaults();

    void setEndpoint(EndPoint endPoint, String host, String path);
}

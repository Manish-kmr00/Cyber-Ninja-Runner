package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0002\u000e\u0010Bg\u0012\f\b\u0002\u0010\u0012\u001a\u00060\fj\u0002`\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\f\b\u0002\u0010\u001a\u001a\u00060\fj\u0002`\u0018\u0012\f\b\u0002\u0010\u001c\u001a\u00060\fj\u0002`\u0018\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\f\b\u0002\u0010 \u001a\u00060\u0005j\u0002`\u001f\u0012\b\b\u0002\u0010%\u001a\u00020!¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u0012\u001a\u00060\fj\u0002`\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0017\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u0016\u0010\u0007R\u001b\u0010\u001a\u001a\u00060\fj\u0002`\u00188\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011R\u001b\u0010\u001c\u001a\u00060\fj\u0002`\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R\u0017\u0010\u001e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010 \u001a\u00060\u0005j\u0002`\u001f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010%\u001a\u00020!8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$¨\u0006)"}, d2 = {"Lcom/chartboost/sdk/impl/lb;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "Lcom/chartboost/sdk/internal/Model/Bytes;", "a", "J", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "()J", "maxBytes", "I", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "maxUnitsPerTimeWindow", "d", "maxUnitsPerTimeWindowCellular", "Lcom/chartboost/sdk/internal/Model/Seconds;", "e", "timeWindow", InneractiveMediationDefs.GENDER_FEMALE, "timeWindowCellular", "g", "ttl", "Lcom/chartboost/sdk/internal/Model/Percentage;", "bufferSize", "Lcom/chartboost/sdk/impl/lb$b;", "h", "Lcom/chartboost/sdk/impl/lb$b;", "()Lcom/chartboost/sdk/impl/lb$b;", "videoPlayer", "<init>", "(JIIJJJILcom/chartboost/sdk/impl/lb$b;)V", "i", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class lb {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long maxBytes;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int maxUnitsPerTimeWindow;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int maxUnitsPerTimeWindowCellular;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long timeWindow;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final long timeWindowCellular;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final long ttl;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final int bufferSize;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final b videoPlayer;

    public lb() {
        this(0L, 0, 0, 0L, 0L, 0L, 0, null, 255, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof lb)) {
            return false;
        }
        lb lbVar = (lb) other;
        return this.maxBytes == lbVar.maxBytes && this.maxUnitsPerTimeWindow == lbVar.maxUnitsPerTimeWindow && this.maxUnitsPerTimeWindowCellular == lbVar.maxUnitsPerTimeWindowCellular && this.timeWindow == lbVar.timeWindow && this.timeWindowCellular == lbVar.timeWindowCellular && this.ttl == lbVar.ttl && this.bufferSize == lbVar.bufferSize && this.videoPlayer == lbVar.videoPlayer;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.maxBytes) * 31) + Integer.hashCode(this.maxUnitsPerTimeWindow)) * 31) + Integer.hashCode(this.maxUnitsPerTimeWindowCellular)) * 31) + Long.hashCode(this.timeWindow)) * 31) + Long.hashCode(this.timeWindowCellular)) * 31) + Long.hashCode(this.ttl)) * 31) + Integer.hashCode(this.bufferSize)) * 31) + this.videoPlayer.hashCode();
    }

    public String toString() {
        return "VideoPreCachingModel(maxBytes=" + this.maxBytes + ", maxUnitsPerTimeWindow=" + this.maxUnitsPerTimeWindow + ", maxUnitsPerTimeWindowCellular=" + this.maxUnitsPerTimeWindowCellular + ", timeWindow=" + this.timeWindow + ", timeWindowCellular=" + this.timeWindowCellular + ", ttl=" + this.ttl + ", bufferSize=" + this.bufferSize + ", videoPlayer=" + this.videoPlayer + ')';
    }

    public lb(long j, int i, int i2, long j2, long j3, long j4, int i3, b videoPlayer) {
        Intrinsics.checkNotNullParameter(videoPlayer, "videoPlayer");
        this.maxBytes = j;
        this.maxUnitsPerTimeWindow = i;
        this.maxUnitsPerTimeWindowCellular = i2;
        this.timeWindow = j2;
        this.timeWindowCellular = j3;
        this.ttl = j4;
        this.bufferSize = i3;
        this.videoPlayer = videoPlayer;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getMaxBytes() {
        return this.maxBytes;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getMaxUnitsPerTimeWindow() {
        return this.maxUnitsPerTimeWindow;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getMaxUnitsPerTimeWindowCellular() {
        return this.maxUnitsPerTimeWindowCellular;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final long getTimeWindow() {
        return this.timeWindow;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getTimeWindowCellular() {
        return this.timeWindowCellular;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getTtl() {
        return this.ttl;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBufferSize() {
        return this.bufferSize;
    }

    @JvmStatic
    public static final lb a(JSONObject jSONObject) {
        return INSTANCE.a(jSONObject);
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final b getVideoPlayer() {
        return this.videoPlayer;
    }

    /* JADX INFO: renamed from: com.chartboost.sdk.impl.lb$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/chartboost/sdk/impl/lb$a;", "", "Lorg/json/JSONObject;", DTBMetricsConfiguration.CONFIG_DIR, "Lcom/chartboost/sdk/impl/lb;", "a", "(Lorg/json/JSONObject;)Lcom/chartboost/sdk/impl/lb;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        @JvmStatic
        public final lb a(JSONObject config) {
            Intrinsics.checkNotNullParameter(config, "config");
            long jOptLong = config.optLong("maxBytes", 52428800L);
            int iOptInt = config.optInt("maxUnitsPerTimeWindow", 10);
            int iOptInt2 = config.optInt("maxUnitsPerTimeWindowCellular", 10);
            long jOptLong2 = config.optLong("timeWindow", 18000L);
            long jOptLong3 = config.optLong("timeWindowCellular", 18000L);
            long jOptLong4 = config.optLong("ttl", TelemetryConfig.DEFAULT_EVENT_TTL_SEC);
            int iOptInt3 = config.optInt("bufferSize", 3);
            String it = config.optString("videoPlayer", mb.f1078a);
            b.Companion companion = b.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return new lb(jOptLong, iOptInt, iOptInt2, jOptLong2, jOptLong3, jOptLong4, iOptInt3, companion.a(it));
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/chartboost/sdk/impl/lb$b;", "", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "a", "d", "e", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum b {
        EXO_PLAYER("exoplayer"),
        MEDIA_PLAYER("mediaplayer");


        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final String value;

        b(String str) {
            this.value = str;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: com.chartboost.sdk.impl.lb$b$a, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/chartboost/sdk/impl/lb$b$a;", "", "", "value", "Lcom/chartboost/sdk/impl/lb$b;", "a", "(Ljava/lang/String;)Lcom/chartboost/sdk/impl/lb$b;", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
        public static final class Companion {
            /* JADX WARN: Code duplicated, block: B:10:0x0021  */
            /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
            public final b a(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                for (b bVar : b.values()) {
                    if (Intrinsics.areEqual(bVar.getValue(), value)) {
                        if (bVar == null) {
                            return b.EXO_PLAYER;
                        }
                        return bVar;
                    }
                }
                bVar = null;
                if (bVar == null) {
                    return b.EXO_PLAYER;
                }
                return bVar;
            }

            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    public /* synthetic */ lb(long j, int i, int i2, long j2, long j3, long j4, int i3, b bVar, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 52428800L : j, (i4 & 2) != 0 ? 10 : i, (i4 & 4) == 0 ? i2 : 10, (i4 & 8) != 0 ? 18000L : j2, (i4 & 16) == 0 ? j3 : 18000L, (i4 & 32) != 0 ? TelemetryConfig.DEFAULT_EVENT_TTL_SEC : j4, (i4 & 64) != 0 ? 3 : i3, (i4 & 128) != 0 ? b.EXO_PLAYER : bVar);
    }
}

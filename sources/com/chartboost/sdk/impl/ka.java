package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.chartboost.sdk.Mediation;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0006\u000bBw\b\u0004\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010)\u001a\u00020#\u0012\b\b\u0002\u0010+\u001a\u00020#\u0012\b\b\u0002\u00102\u001a\u00020,\u0012\b\b\u0002\u00107\u001a\u000203\u0012\u0006\u0010<\u001a\u000208¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000e\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0006\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u001b\u001a\u00020\u00178\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\u0006\u0010!R\"\u0010)\u001a\u00020#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b\u0006\u0010(R\"\u0010+\u001a\u00020#8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b*\u0010%\u001a\u0004\b$\u0010'\"\u0004\b\u000b\u0010(R\"\u00102\u001a\u00020,8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b*\u0010/\"\u0004\b0\u00101R\"\u00107\u001a\u0002038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u00104\u001a\u0004\b\u000b\u00105\"\u0004\b\u0006\u00106R\"\u0010<\u001a\u0002088\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0019\u00109\u001a\u0004\b\u001d\u0010:\"\u0004\b\u0006\u0010;R\u0018\u0010>\u001a\u00060,j\u0002`=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010/\u0082\u0001\u0003ABC¨\u0006D"}, d2 = {"Lcom/chartboost/sdk/impl/ka;", "", "", "toString", "()Ljava/lang/String;", "Lcom/chartboost/sdk/impl/ma;", "a", "Lcom/chartboost/sdk/impl/ma;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/ma;", "name", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Ljava/lang/String;", "e", "message", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "impressionAdType", "d", "location", "Lcom/chartboost/sdk/Mediation;", "Lcom/chartboost/sdk/Mediation;", "()Lcom/chartboost/sdk/Mediation;", "mediation", "Lcom/chartboost/sdk/impl/ka$b;", "Lcom/chartboost/sdk/impl/ka$b;", "l", "()Lcom/chartboost/sdk/impl/ka$b;", "type", "Lcom/chartboost/sdk/impl/da;", "g", "Lcom/chartboost/sdk/impl/da;", CampaignEx.JSON_KEY_AD_K, "()Lcom/chartboost/sdk/impl/da;", "(Lcom/chartboost/sdk/impl/da;)V", "trackAd", "", "h", "Z", "m", "()Z", "(Z)V", "isLatencyEvent", "i", "shouldCalculateLatency", "", "j", "J", "()J", "setTimestamp", "(J)V", "timestamp", "", "F", "()F", "(F)V", "latency", "Lcom/chartboost/sdk/impl/ka$a;", "Lcom/chartboost/sdk/impl/ka$a;", "()Lcom/chartboost/sdk/impl/ka$a;", "(Lcom/chartboost/sdk/impl/ka$a;)V", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "Lcom/chartboost/sdk/internal/utils/TimeStampSeconds;", "timestampInSeconds", "<init>", "(Lcom/chartboost/sdk/impl/ma;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/Mediation;Lcom/chartboost/sdk/impl/ka$b;Lcom/chartboost/sdk/impl/da;ZZJFLcom/chartboost/sdk/impl/ka$a;)V", "Lcom/chartboost/sdk/impl/r3;", "Lcom/chartboost/sdk/impl/j4;", "Lcom/chartboost/sdk/impl/r6;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public abstract class ka {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ma name;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String impressionAdType;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Mediation mediation;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final b type;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public da trackAd;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public boolean isLatencyEvent;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public boolean shouldCalculateLatency;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public long timestamp;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public float latency;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public a priority;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/chartboost/sdk/impl/ka$a;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum a {
        LOW,
        HIGH
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/chartboost/sdk/impl/ka$b;", "", "<init>", "(Ljava/lang/String;I)V", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "d", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public enum b {
        INFO,
        CRITICAL,
        ERROR
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TrackingEvent(name=");
        sb.append(getName().getValue()).append(", message='").append(getMessage()).append("', impressionAdType='").append(getImpressionAdType()).append("', location='").append(getLocation()).append("', mediation=").append(getMediation()).append(", type=").append(getType()).append(", trackAd=").append(getTrackAd()).append(", isLatencyEvent=").append(getIsLatencyEvent()).append(", shouldCalculateLatency=").append(getShouldCalculateLatency()).append(", timestamp=").append(getTimestamp()).append(", latency=").append(getLatency()).append(", priority=");
        sb.append(getPriority()).append(", timestampInSeconds=").append(j()).append(')');
        return sb.toString();
    }

    public ka(ma maVar, String str, String str2, String str3, Mediation mediation, b bVar, da daVar, boolean z, boolean z2, long j, float f, a aVar) {
        this.name = maVar;
        this.message = str;
        this.impressionAdType = str2;
        this.location = str3;
        this.mediation = mediation;
        this.type = bVar;
        this.trackAd = daVar;
        this.isLatencyEvent = z;
        this.shouldCalculateLatency = z2;
        this.timestamp = j;
        this.latency = f;
        this.priority = aVar;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public ma getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public String getImpressionAdType() {
        return this.impressionAdType;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public Mediation getMediation() {
        return this.mediation;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public b getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public da getTrackAd() {
        return this.trackAd;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public boolean getIsLatencyEvent() {
        return this.isLatencyEvent;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public boolean getShouldCalculateLatency() {
        return this.shouldCalculateLatency;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public float getLatency() {
        return this.latency;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public a getPriority() {
        return this.priority;
    }

    public long j() {
        return x9.a(getTimestamp());
    }

    public void a(float f) {
        this.latency = f;
    }

    public /* synthetic */ ka(ma maVar, String str, String str2, String str3, Mediation mediation, b bVar, da daVar, boolean z, boolean z2, long j, float f, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(maVar, str, str2, str3, mediation, bVar, (i & 64) != 0 ? new da(null, null, null, null, null, null, null, null, 255, null) : daVar, (i & 128) != 0 ? false : z, (i & 256) != 0 ? true : z2, (i & 512) != 0 ? System.currentTimeMillis() : j, (i & 1024) != 0 ? 0.0f : f, aVar, null);
    }

    public void b(boolean z) {
        this.shouldCalculateLatency = z;
    }

    public /* synthetic */ ka(ma maVar, String str, String str2, String str3, Mediation mediation, b bVar, da daVar, boolean z, boolean z2, long j, float f, a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(maVar, str, str2, str3, mediation, bVar, daVar, z, z2, j, f, aVar);
    }

    public void a(boolean z) {
        this.isLatencyEvent = z;
    }

    public void a(a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.priority = aVar;
    }

    public void a(da daVar) {
        this.trackAd = daVar;
    }
}

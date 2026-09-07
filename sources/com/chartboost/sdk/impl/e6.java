package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.smaato.sdk.video.vast.model.MediaFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0006\u0010(\u001a\u00020$\u0012\u0006\u0010-\u001a\u00020)\u0012\u0006\u00102\u001a\u00020.\u0012\u0006\u00107\u001a\u000203\u0012\u0006\u0010<\u001a\u000208\u0012\u0006\u0010B\u001a\u00020=\u0012\u0006\u0010H\u001a\u00020C\u0012\u0006\u0010L\u001a\u00020I\u0012\u0006\u0010P\u001a\u00020M\u0012\u0006\u0010S\u001a\u00020\u0002\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010[\u001a\u00020X\u0012\u0006\u0010_\u001a\u00020\\\u0012\u0006\u0010c\u001a\u00020`¢\u0006\u0004\bd\u0010eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b\u001b\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b!\u0010*\u001a\u0004\b+\u0010,R\u0017\u00102\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b&\u0010/\u001a\u0004\b0\u00101R\u0017\u00107\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b\u001f\u00106R\u0017\u0010<\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b4\u0010;R\u0017\u0010B\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0017\u0010H\u001a\u00020C8\u0006¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010L\u001a\u00020I8\u0006¢\u0006\f\n\u0004\bF\u0010J\u001a\u0004\b\u0013\u0010KR\u0017\u0010P\u001a\u00020M8\u0006¢\u0006\f\n\u0004\b\u0015\u0010N\u001a\u0004\b\r\u0010OR\u0017\u0010S\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bQ\u0010\u0004R\u0017\u0010W\u001a\u00020T8\u0006¢\u0006\f\n\u0004\b+\u0010U\u001a\u0004\b>\u0010VR\u0017\u0010[\u001a\u00020X8\u0006¢\u0006\f\n\u0004\b0\u0010Y\u001a\u0004\bD\u0010ZR\u0017\u0010_\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b\u000f\u0010]\u001a\u0004\b\u0019\u0010^R\u0017\u0010c\u001a\u00020`8\u0006¢\u0006\f\n\u0004\b@\u0010a\u001a\u0004\b9\u0010b¨\u0006f"}, d2 = {"Lcom/chartboost/sdk/impl/e6;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/impl/za;", "a", "Lcom/chartboost/sdk/impl/za;", CampaignEx.JSON_KEY_AD_Q, "()Lcom/chartboost/sdk/impl/za;", "urlResolver", "Lcom/chartboost/sdk/impl/w6;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/chartboost/sdk/impl/w6;", "m", "()Lcom/chartboost/sdk/impl/w6;", "intentResolver", "Lcom/chartboost/sdk/impl/c3;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Lcom/chartboost/sdk/impl/c3;", "e", "()Lcom/chartboost/sdk/impl/c3;", "clickRequest", "Lcom/chartboost/sdk/impl/f3;", "d", "Lcom/chartboost/sdk/impl/f3;", InneractiveMediationDefs.GENDER_FEMALE, "()Lcom/chartboost/sdk/impl/f3;", "clickTracking", "Lcom/chartboost/sdk/impl/k3;", "Lcom/chartboost/sdk/impl/k3;", "g", "()Lcom/chartboost/sdk/impl/k3;", "completeRequest", "Lcom/chartboost/sdk/impl/k6;", "Lcom/chartboost/sdk/impl/k6;", "o", "()Lcom/chartboost/sdk/impl/k6;", MediaFile.MEDIA_TYPE, "Lcom/chartboost/sdk/impl/s7;", "Lcom/chartboost/sdk/impl/s7;", "p", "()Lcom/chartboost/sdk/impl/s7;", "openMeasurementImpressionCallback", "Lcom/chartboost/sdk/impl/y0;", "h", "Lcom/chartboost/sdk/impl/y0;", "()Lcom/chartboost/sdk/impl/y0;", "appRequest", "Lcom/chartboost/sdk/impl/g4;", "i", "Lcom/chartboost/sdk/impl/g4;", "()Lcom/chartboost/sdk/impl/g4;", "downloader", "Lcom/chartboost/sdk/impl/o2;", "j", "Lcom/chartboost/sdk/impl/o2;", "r", "()Lcom/chartboost/sdk/impl/o2;", "viewProtocol", "Lcom/chartboost/sdk/impl/d6;", CampaignEx.JSON_KEY_AD_K, "Lcom/chartboost/sdk/impl/d6;", "l", "()Lcom/chartboost/sdk/impl/d6;", "impressionCounter", "Lcom/chartboost/sdk/impl/v;", "Lcom/chartboost/sdk/impl/v;", "()Lcom/chartboost/sdk/impl/v;", "adUnit", "Lcom/chartboost/sdk/impl/u;", "Lcom/chartboost/sdk/impl/u;", "()Lcom/chartboost/sdk/impl/u;", "adTypeTraits", "n", "Ljava/lang/String;", "location", "Lcom/chartboost/sdk/impl/j6;", "Lcom/chartboost/sdk/impl/j6;", "()Lcom/chartboost/sdk/impl/j6;", "impressionCallback", "Lcom/chartboost/sdk/impl/x5;", "Lcom/chartboost/sdk/impl/x5;", "()Lcom/chartboost/sdk/impl/x5;", "impressionClickCallback", "Lcom/chartboost/sdk/impl/j0;", "Lcom/chartboost/sdk/impl/j0;", "()Lcom/chartboost/sdk/impl/j0;", "adUnitRendererImpressionCallback", "Lcom/chartboost/sdk/impl/m4;", "Lcom/chartboost/sdk/impl/m4;", "()Lcom/chartboost/sdk/impl/m4;", "eventTracker", "<init>", "(Lcom/chartboost/sdk/impl/za;Lcom/chartboost/sdk/impl/w6;Lcom/chartboost/sdk/impl/c3;Lcom/chartboost/sdk/impl/f3;Lcom/chartboost/sdk/impl/k3;Lcom/chartboost/sdk/impl/k6;Lcom/chartboost/sdk/impl/s7;Lcom/chartboost/sdk/impl/y0;Lcom/chartboost/sdk/impl/g4;Lcom/chartboost/sdk/impl/o2;Lcom/chartboost/sdk/impl/d6;Lcom/chartboost/sdk/impl/v;Lcom/chartboost/sdk/impl/u;Ljava/lang/String;Lcom/chartboost/sdk/impl/j6;Lcom/chartboost/sdk/impl/x5;Lcom/chartboost/sdk/impl/j0;Lcom/chartboost/sdk/impl/m4;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final za urlResolver;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final w6 intentResolver;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final c3 clickRequest;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final f3 clickTracking;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final k3 completeRequest;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final k6 mediaType;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final s7 openMeasurementImpressionCallback;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final y0 appRequest;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final g4 downloader;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final o2 viewProtocol;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final d6 impressionCounter;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final v adUnit;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final u adTypeTraits;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final j6 impressionCallback;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final x5 impressionClickCallback;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final j0 adUnitRendererImpressionCallback;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final m4 eventTracker;

    public e6(za urlResolver, w6 intentResolver, c3 clickRequest, f3 clickTracking, k3 completeRequest, k6 mediaType, s7 openMeasurementImpressionCallback, y0 appRequest, g4 downloader, o2 viewProtocol, d6 impressionCounter, v adUnit, u adTypeTraits, String location, j6 impressionCallback, x5 impressionClickCallback, j0 adUnitRendererImpressionCallback, m4 eventTracker) {
        Intrinsics.checkNotNullParameter(urlResolver, "urlResolver");
        Intrinsics.checkNotNullParameter(intentResolver, "intentResolver");
        Intrinsics.checkNotNullParameter(clickRequest, "clickRequest");
        Intrinsics.checkNotNullParameter(clickTracking, "clickTracking");
        Intrinsics.checkNotNullParameter(completeRequest, "completeRequest");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(openMeasurementImpressionCallback, "openMeasurementImpressionCallback");
        Intrinsics.checkNotNullParameter(appRequest, "appRequest");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(viewProtocol, "viewProtocol");
        Intrinsics.checkNotNullParameter(impressionCounter, "impressionCounter");
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        Intrinsics.checkNotNullParameter(adTypeTraits, "adTypeTraits");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(impressionCallback, "impressionCallback");
        Intrinsics.checkNotNullParameter(impressionClickCallback, "impressionClickCallback");
        Intrinsics.checkNotNullParameter(adUnitRendererImpressionCallback, "adUnitRendererImpressionCallback");
        Intrinsics.checkNotNullParameter(eventTracker, "eventTracker");
        this.urlResolver = urlResolver;
        this.intentResolver = intentResolver;
        this.clickRequest = clickRequest;
        this.clickTracking = clickTracking;
        this.completeRequest = completeRequest;
        this.mediaType = mediaType;
        this.openMeasurementImpressionCallback = openMeasurementImpressionCallback;
        this.appRequest = appRequest;
        this.downloader = downloader;
        this.viewProtocol = viewProtocol;
        this.impressionCounter = impressionCounter;
        this.adUnit = adUnit;
        this.adTypeTraits = adTypeTraits;
        this.location = location;
        this.impressionCallback = impressionCallback;
        this.impressionClickCallback = impressionClickCallback;
        this.adUnitRendererImpressionCallback = adUnitRendererImpressionCallback;
        this.eventTracker = eventTracker;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e6)) {
            return false;
        }
        e6 e6Var = (e6) other;
        return Intrinsics.areEqual(this.urlResolver, e6Var.urlResolver) && Intrinsics.areEqual(this.intentResolver, e6Var.intentResolver) && Intrinsics.areEqual(this.clickRequest, e6Var.clickRequest) && Intrinsics.areEqual(this.clickTracking, e6Var.clickTracking) && Intrinsics.areEqual(this.completeRequest, e6Var.completeRequest) && this.mediaType == e6Var.mediaType && Intrinsics.areEqual(this.openMeasurementImpressionCallback, e6Var.openMeasurementImpressionCallback) && Intrinsics.areEqual(this.appRequest, e6Var.appRequest) && Intrinsics.areEqual(this.downloader, e6Var.downloader) && Intrinsics.areEqual(this.viewProtocol, e6Var.viewProtocol) && Intrinsics.areEqual(this.impressionCounter, e6Var.impressionCounter) && Intrinsics.areEqual(this.adUnit, e6Var.adUnit) && Intrinsics.areEqual(this.adTypeTraits, e6Var.adTypeTraits) && Intrinsics.areEqual(this.location, e6Var.location) && Intrinsics.areEqual(this.impressionCallback, e6Var.impressionCallback) && Intrinsics.areEqual(this.impressionClickCallback, e6Var.impressionClickCallback) && Intrinsics.areEqual(this.adUnitRendererImpressionCallback, e6Var.adUnitRendererImpressionCallback) && Intrinsics.areEqual(this.eventTracker, e6Var.eventTracker);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((this.urlResolver.hashCode() * 31) + this.intentResolver.hashCode()) * 31) + this.clickRequest.hashCode()) * 31) + this.clickTracking.hashCode()) * 31) + this.completeRequest.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + this.openMeasurementImpressionCallback.hashCode()) * 31) + this.appRequest.hashCode()) * 31) + this.downloader.hashCode()) * 31) + this.viewProtocol.hashCode()) * 31) + this.impressionCounter.hashCode()) * 31) + this.adUnit.hashCode()) * 31) + this.adTypeTraits.hashCode()) * 31) + this.location.hashCode()) * 31) + this.impressionCallback.hashCode()) * 31) + this.impressionClickCallback.hashCode()) * 31) + this.adUnitRendererImpressionCallback.hashCode()) * 31) + this.eventTracker.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImpressionDependency(urlResolver=");
        sb.append(this.urlResolver).append(", intentResolver=").append(this.intentResolver).append(", clickRequest=").append(this.clickRequest).append(", clickTracking=").append(this.clickTracking).append(", completeRequest=").append(this.completeRequest).append(", mediaType=").append(this.mediaType).append(", openMeasurementImpressionCallback=").append(this.openMeasurementImpressionCallback).append(", appRequest=").append(this.appRequest).append(", downloader=").append(this.downloader).append(", viewProtocol=").append(this.viewProtocol).append(", impressionCounter=").append(this.impressionCounter).append(", adUnit=");
        sb.append(this.adUnit).append(", adTypeTraits=").append(this.adTypeTraits).append(", location=").append(this.location).append(", impressionCallback=").append(this.impressionCallback).append(", impressionClickCallback=").append(this.impressionClickCallback).append(", adUnitRendererImpressionCallback=").append(this.adUnitRendererImpressionCallback).append(", eventTracker=").append(this.eventTracker).append(')');
        return sb.toString();
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final za getUrlResolver() {
        return this.urlResolver;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final w6 getIntentResolver() {
        return this.intentResolver;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final c3 getClickRequest() {
        return this.clickRequest;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final f3 getClickTracking() {
        return this.clickTracking;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final k3 getCompleteRequest() {
        return this.completeRequest;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final k6 getMediaType() {
        return this.mediaType;
    }

    /* JADX INFO: renamed from: p, reason: from getter */
    public final s7 getOpenMeasurementImpressionCallback() {
        return this.openMeasurementImpressionCallback;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final y0 getAppRequest() {
        return this.appRequest;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final g4 getDownloader() {
        return this.downloader;
    }

    /* JADX INFO: renamed from: r, reason: from getter */
    public final o2 getViewProtocol() {
        return this.viewProtocol;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final d6 getImpressionCounter() {
        return this.impressionCounter;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final v getAdUnit() {
        return this.adUnit;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final u getAdTypeTraits() {
        return this.adTypeTraits;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final j6 getImpressionCallback() {
        return this.impressionCallback;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final x5 getImpressionClickCallback() {
        return this.impressionClickCallback;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final j0 getAdUnitRendererImpressionCallback() {
        return this.adUnitRendererImpressionCallback;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final m4 getEventTracker() {
        return this.eventTracker;
    }
}

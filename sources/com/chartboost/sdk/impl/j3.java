package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/chartboost/sdk/impl/j3;", "", "", "a", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "location", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "adId", "cgn", "", "d", "I", "()I", IronSourceConstants.EVENTS_REWARD_AMOUNT, "e", "rewardCurrency", "", InneractiveMediationDefs.GENDER_FEMALE, "Ljava/lang/Float;", "g", "()Ljava/lang/Float;", "videoPostion", "videoDuration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String adId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String cgn;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int rewardAmount;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String rewardCurrency;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Float videoPostion;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final Float videoDuration;

    public j3(String location, String adId, String cgn, int i, String rewardCurrency, Float f, Float f2) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(cgn, "cgn");
        Intrinsics.checkNotNullParameter(rewardCurrency, "rewardCurrency");
        this.location = location;
        this.adId = adId;
        this.cgn = cgn;
        this.rewardAmount = i;
        this.rewardCurrency = rewardCurrency;
        this.videoPostion = f;
        this.videoDuration = f2;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdId() {
        return this.adId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCgn() {
        return this.cgn;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getRewardAmount() {
        return this.rewardAmount;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getRewardCurrency() {
        return this.rewardCurrency;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Float getVideoPostion() {
        return this.videoPostion;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Float getVideoDuration() {
        return this.videoDuration;
    }
}

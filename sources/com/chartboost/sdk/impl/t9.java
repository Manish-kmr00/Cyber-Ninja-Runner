package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0003\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/chartboost/sdk/impl/t9;", "", "", "a", "Ljava/lang/String;", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "()Ljava/lang/String;", "id", "", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "J", "()J", "duration", "", "I", InneractiveMediationDefs.GENDER_FEMALE, "()I", "sessionCounter", "d", "bannerImpressionCounter", "e", "rewardedImpressionCounter", "interstitialImpressionCounter", "<init>", "(Ljava/lang/String;JIIII)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class t9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String id;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final long duration;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int sessionCounter;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int bannerImpressionCounter;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int rewardedImpressionCounter;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final int interstitialImpressionCounter;

    public t9(String str, long j, int i, int i2, int i3, int i4) {
        this.id = str;
        this.duration = j;
        this.sessionCounter = i;
        this.bannerImpressionCounter = i2;
        this.rewardedImpressionCounter = i3;
        this.interstitialImpressionCounter = i4;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getSessionCounter() {
        return this.sessionCounter;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getBannerImpressionCounter() {
        return this.bannerImpressionCounter;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final int getRewardedImpressionCounter() {
        return this.rewardedImpressionCounter;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final int getInterstitialImpressionCounter() {
        return this.interstitialImpressionCounter;
    }
}

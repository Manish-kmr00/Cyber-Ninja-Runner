package com.yandex.mobile.ads.video.playback.model;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0007R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0007R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/yandex/mobile/ads/video/playback/model/VideoAdInfo;", "", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getAdId", "adId", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getCreativeId", "creativeId", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getBannerId", "bannerId", "d", "getData", "data", "e", "getAdvertiserInfo", "advertiserInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class VideoAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String adId;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String creativeId;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String bannerId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final String data;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final String advertiserInfo;

    public VideoAdInfo(String str, String str2, String str3, String str4, String str5) {
        this.adId = str;
        this.creativeId = str2;
        this.bannerId = str3;
        this.data = str4;
        this.advertiserInfo = str5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(VideoAdInfo.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.yandex.mobile.ads.video.playback.model.VideoAdInfo");
        VideoAdInfo videoAdInfo = (VideoAdInfo) other;
        return Intrinsics.areEqual(this.adId, videoAdInfo.adId) && Intrinsics.areEqual(this.creativeId, videoAdInfo.creativeId) && Intrinsics.areEqual(this.bannerId, videoAdInfo.bannerId) && Intrinsics.areEqual(this.data, videoAdInfo.data) && Intrinsics.areEqual(this.advertiserInfo, videoAdInfo.advertiserInfo);
    }

    public final String getAdId() {
        return this.adId;
    }

    public final String getAdvertiserInfo() {
        return this.advertiserInfo;
    }

    public final String getBannerId() {
        return this.bannerId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getData() {
        return this.data;
    }

    public int hashCode() {
        String str = this.adId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.creativeId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.bannerId;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.data;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.advertiserInfo;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        String str = this.adId;
        if (str == null) {
            str = "";
        }
        String str2 = this.creativeId;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.bannerId;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.data;
        if (str4 == null) {
            str4 = "";
        }
        String str5 = this.advertiserInfo;
        return "VideoAdInfo (adId: " + str + ", creativeId: " + str2 + ", bannerId: " + str3 + ", data: " + str4 + ", advertiserInfo: " + (str5 != null ? str5 : "") + ")";
    }
}

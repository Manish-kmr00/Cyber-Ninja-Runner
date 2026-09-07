package com.chartboost.sdk.impl;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.video.vast.model.Ad;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fB[\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\f\u0010\u0004R\u0017\u0010\u0017\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0016\u0010\u0004R\u0017\u0010\u001a\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u0004R\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010!\u001a\u0004\u0018\u00010\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u0013\u0010 R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006%"}, d2 = {"Lcom/chartboost/sdk/impl/da;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "e", "location", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "d", Ad.AD_TYPE, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "adImpressionId", "adCreativeId", "getAdCreativeType", "adCreativeType", InneractiveMediationDefs.GENDER_FEMALE, "getAdMarkup", "adMarkup", "g", "templateUrl", "Lcom/chartboost/sdk/impl/da$a;", "h", "Lcom/chartboost/sdk/impl/da$a;", "()Lcom/chartboost/sdk/impl/da$a;", "adSize", "shortImpressionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/chartboost/sdk/impl/da$a;)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final /* data */ class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String location;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String adType;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String adImpressionId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final String adCreativeId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String adCreativeType;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final String adMarkup;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final String templateUrl;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final a adSize;

    public da() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof da)) {
            return false;
        }
        da daVar = (da) other;
        return Intrinsics.areEqual(this.location, daVar.location) && Intrinsics.areEqual(this.adType, daVar.adType) && Intrinsics.areEqual(this.adImpressionId, daVar.adImpressionId) && Intrinsics.areEqual(this.adCreativeId, daVar.adCreativeId) && Intrinsics.areEqual(this.adCreativeType, daVar.adCreativeType) && Intrinsics.areEqual(this.adMarkup, daVar.adMarkup) && Intrinsics.areEqual(this.templateUrl, daVar.templateUrl) && Intrinsics.areEqual(this.adSize, daVar.adSize);
    }

    public int hashCode() {
        int iHashCode = ((this.location.hashCode() * 31) + this.adType.hashCode()) * 31;
        String str = this.adImpressionId;
        int iHashCode2 = (((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.adCreativeId.hashCode()) * 31) + this.adCreativeType.hashCode()) * 31) + this.adMarkup.hashCode()) * 31) + this.templateUrl.hashCode()) * 31;
        a aVar = this.adSize;
        return iHashCode2 + (aVar != null ? aVar.hashCode() : 0);
    }

    public String toString() {
        return "TrackAd: location: " + this.location + " adType: " + this.adType + " adImpressionId: " + f() + " adCreativeId: " + this.adCreativeId + " adCreativeType: " + this.adCreativeType + " adMarkup: " + this.adMarkup + " templateUrl: " + this.templateUrl;
    }

    public da(String location, String adType, String str, String adCreativeId, String adCreativeType, String adMarkup, String templateUrl, a aVar) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(adCreativeId, "adCreativeId");
        Intrinsics.checkNotNullParameter(adCreativeType, "adCreativeType");
        Intrinsics.checkNotNullParameter(adMarkup, "adMarkup");
        Intrinsics.checkNotNullParameter(templateUrl, "templateUrl");
        this.location = location;
        this.adType = adType;
        this.adImpressionId = str;
        this.adCreativeId = adCreativeId;
        this.adCreativeType = adCreativeType;
        this.adMarkup = adMarkup;
        this.templateUrl = templateUrl;
        this.adSize = aVar;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getAdType() {
        return this.adType;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getAdImpressionId() {
        return this.adImpressionId;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getAdCreativeId() {
        return this.adCreativeId;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getTemplateUrl() {
        return this.templateUrl;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final a getAdSize() {
        return this.adSize;
    }

    public /* synthetic */ da(String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) == 0 ? str7 : "", (i & 128) != 0 ? null : aVar);
    }

    public final String f() {
        String str = this.adImpressionId;
        if (str == null) {
            return null;
        }
        String strSubstring = str.substring(0, RangesKt.coerceAtMost(str.length(), 20));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\u0010\u000f\u001a\u00060\u0005j\u0002`\f\u0012\n\u0010\u0011\u001a\u00060\u0005j\u0002`\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001b\u0010\u000f\u001a\u00060\u0005j\u0002`\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u0007R\u001b\u0010\u0011\u001a\u00060\u0005j\u0002`\f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/chartboost/sdk/impl/da$a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/chartboost/sdk/tracking/Pixels;", "a", "I", "height", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "width", "<init>", "(II)V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
    public static final /* data */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int height;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final int width;

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            return this.height == aVar.height && this.width == aVar.width;
        }

        public int hashCode() {
            return (Integer.hashCode(this.height) * 31) + Integer.hashCode(this.width);
        }

        public String toString() {
            return "AdSize(height=" + this.height + ", width=" + this.width + ')';
        }

        public a(int i, int i2) {
            this.height = i;
            this.width = i2;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }
}

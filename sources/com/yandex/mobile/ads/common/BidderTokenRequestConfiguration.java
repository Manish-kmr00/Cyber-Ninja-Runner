package com.yandex.mobile.ads.common;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.mediationsdk.l;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.smaato.sdk.video.vast.model.Ad;
import com.yandex.mobile.ads.banner.BannerAdSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/yandex/mobile/ads/common/AdType;", "a", "Lcom/yandex/mobile/ads/common/AdType;", "getAdType", "()Lcom/yandex/mobile/ads/common/AdType;", Ad.AD_TYPE, "Lcom/yandex/mobile/ads/banner/BannerAdSize;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/yandex/mobile/ads/banner/BannerAdSize;", "getBannerAdSize", "()Lcom/yandex/mobile/ads/banner/BannerAdSize;", l.h, "", "", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "Ljava/util/Map;", "getParameters", "()Ljava/util/Map;", "parameters", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class BidderTokenRequestConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AdType adType;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final BannerAdSize bannerAdSize;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final Map<String, String> parameters;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u00002\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration$Builder;", "", "Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration;", "build", "()Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration;", "Lcom/yandex/mobile/ads/banner/BannerAdSize;", l.h, "setBannerAdSize", "(Lcom/yandex/mobile/ads/banner/BannerAdSize;)Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration$Builder;", "", "", "parameters", "setParameters", "(Ljava/util/Map;)Lcom/yandex/mobile/ads/common/BidderTokenRequestConfiguration$Builder;", "Lcom/yandex/mobile/ads/common/AdType;", Ad.AD_TYPE, "<init>", "(Lcom/yandex/mobile/ads/common/AdType;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdType f8332a;
        private BannerAdSize b;
        private Map<String, String> c;

        public Builder(AdType adType) {
            Intrinsics.checkNotNullParameter(adType, "adType");
            this.f8332a = adType;
        }

        public final BidderTokenRequestConfiguration build() {
            return new BidderTokenRequestConfiguration(this.f8332a, this.b, this.c, null);
        }

        public final Builder setBannerAdSize(BannerAdSize bannerAdSize) {
            this.b = bannerAdSize;
            return this;
        }

        public final Builder setParameters(Map<String, String> parameters) {
            this.c = parameters;
            return this;
        }
    }

    public /* synthetic */ BidderTokenRequestConfiguration(AdType adType, BannerAdSize bannerAdSize, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(adType, bannerAdSize, map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(BidderTokenRequestConfiguration.class, other.getClass())) {
            return false;
        }
        BidderTokenRequestConfiguration bidderTokenRequestConfiguration = (BidderTokenRequestConfiguration) other;
        if (this.adType == bidderTokenRequestConfiguration.adType && Intrinsics.areEqual(this.bannerAdSize, bidderTokenRequestConfiguration.bannerAdSize)) {
            return Intrinsics.areEqual(this.parameters, bidderTokenRequestConfiguration.parameters);
        }
        return false;
    }

    public final AdType getAdType() {
        return this.adType;
    }

    public final BannerAdSize getBannerAdSize() {
        return this.bannerAdSize;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        int iHashCode = this.adType.hashCode() * 31;
        BannerAdSize bannerAdSize = this.bannerAdSize;
        int iHashCode2 = (iHashCode + (bannerAdSize != null ? bannerAdSize.hashCode() : 0)) * 31;
        Map<String, String> map = this.parameters;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    private BidderTokenRequestConfiguration(AdType adType, BannerAdSize bannerAdSize, Map<String, String> map) {
        this.adType = adType;
        this.bannerAdSize = bannerAdSize;
        this.parameters = map;
    }
}

package com.monetization.ads.mediation.base;

import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.json.bu;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0010B'\b\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/monetization/ads/mediation/base/MediatedAdapterInfo;", "", "", "a", "Ljava/lang/String;", "getAdapterVersion", "()Ljava/lang/String;", bu.b, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getNetworkName", "networkName", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "getNetworkSdkVersion", "networkSdkVersion", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public final class MediatedAdapterInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String adapterVersion;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final String networkName;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final String networkSdkVersion;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\bJ\u0015\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/monetization/ads/mediation/base/MediatedAdapterInfo$Builder;", "", "Lcom/monetization/ads/mediation/base/MediatedAdapterInfo;", "build", "()Lcom/monetization/ads/mediation/base/MediatedAdapterInfo;", "", bu.b, "setAdapterVersion", "(Ljava/lang/String;)Lcom/monetization/ads/mediation/base/MediatedAdapterInfo$Builder;", "networkName", "setNetworkName", "networkSdkVersion", "setNetworkSdkVersion", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7227a;
        private String b;
        private String c;

        public final MediatedAdapterInfo build() {
            return new MediatedAdapterInfo(this.f7227a, this.b, this.c, null);
        }

        public final Builder setAdapterVersion(String adapterVersion) {
            Intrinsics.checkNotNullParameter(adapterVersion, "adapterVersion");
            this.f7227a = adapterVersion;
            return this;
        }

        public final Builder setNetworkName(String networkName) {
            Intrinsics.checkNotNullParameter(networkName, "networkName");
            this.b = networkName;
            return this;
        }

        public final Builder setNetworkSdkVersion(String networkSdkVersion) {
            Intrinsics.checkNotNullParameter(networkSdkVersion, "networkSdkVersion");
            this.c = networkSdkVersion;
            return this;
        }
    }

    public /* synthetic */ MediatedAdapterInfo(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public final String getAdapterVersion() {
        return this.adapterVersion;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final String getNetworkSdkVersion() {
        return this.networkSdkVersion;
    }

    private MediatedAdapterInfo(String str, String str2, String str3) {
        this.adapterVersion = str;
        this.networkName = str2;
        this.networkSdkVersion = str3;
    }
}

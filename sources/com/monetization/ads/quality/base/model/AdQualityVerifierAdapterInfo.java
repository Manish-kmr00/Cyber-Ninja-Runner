package com.monetization.ads.quality.base.model;

import com.json.bu;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u000bB%\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\f"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo;", "", bu.b, "", "verifierName", "verifierSdkVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdapterVersion", "()Ljava/lang/String;", "getVerifierName", "getVerifierSdkVersion", "Builder", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AdQualityVerifierAdapterInfo {
    private final String adapterVersion;
    private final String verifierName;
    private final String verifierSdkVersion;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo$Builder;", "", "Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo;", "build", "()Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo;", "", bu.b, "setAdapterVersion", "(Ljava/lang/String;)Lcom/monetization/ads/quality/base/model/AdQualityVerifierAdapterInfo$Builder;", "name", "setVerifierName", "version", "setVerifierSdkVersion", "<init>", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7245a;
        private String b;
        private String c;

        public final AdQualityVerifierAdapterInfo build() {
            return new AdQualityVerifierAdapterInfo(this.f7245a, this.b, this.c, null);
        }

        public final Builder setAdapterVersion(String adapterVersion) {
            this.f7245a = adapterVersion;
            return this;
        }

        public final Builder setVerifierName(String name) {
            this.b = name;
            return this;
        }

        public final Builder setVerifierSdkVersion(String version) {
            this.c = version;
            return this;
        }
    }

    public /* synthetic */ AdQualityVerifierAdapterInfo(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public final String getAdapterVersion() {
        return this.adapterVersion;
    }

    public final String getVerifierName() {
        return this.verifierName;
    }

    public final String getVerifierSdkVersion() {
        return this.verifierSdkVersion;
    }

    private AdQualityVerifierAdapterInfo(String str, String str2, String str3) {
        this.adapterVersion = str;
        this.verifierName = str2;
        this.verifierSdkVersion = str3;
    }
}

package com.monetization.ads.quality.base.model.configuration;

import com.amazon.device.ads.DTBMetricsConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifierAdapterConfiguration;", "", DTBMetricsConfiguration.APSMETRICS_APIKEY, "", "verificationTimeoutInSec", "", "debug", "", "(Ljava/lang/String;JZ)V", "getApiKey", "()Ljava/lang/String;", "getDebug", "()Z", "getVerificationTimeoutInSec", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class AdQualityVerifierAdapterConfiguration {
    private final String apiKey;
    private final boolean debug;
    private final long verificationTimeoutInSec;

    public AdQualityVerifierAdapterConfiguration(String apiKey, long j, boolean z) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        this.apiKey = apiKey;
        this.verificationTimeoutInSec = j;
        this.debug = z;
    }

    public static /* synthetic */ AdQualityVerifierAdapterConfiguration copy$default(AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfiguration, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adQualityVerifierAdapterConfiguration.apiKey;
        }
        if ((i & 2) != 0) {
            j = adQualityVerifierAdapterConfiguration.verificationTimeoutInSec;
        }
        if ((i & 4) != 0) {
            z = adQualityVerifierAdapterConfiguration.debug;
        }
        return adQualityVerifierAdapterConfiguration.copy(str, j, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getApiKey() {
        return this.apiKey;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getVerificationTimeoutInSec() {
        return this.verificationTimeoutInSec;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getDebug() {
        return this.debug;
    }

    public final AdQualityVerifierAdapterConfiguration copy(String apiKey, long verificationTimeoutInSec, boolean debug) {
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        return new AdQualityVerifierAdapterConfiguration(apiKey, verificationTimeoutInSec, debug);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdQualityVerifierAdapterConfiguration)) {
            return false;
        }
        AdQualityVerifierAdapterConfiguration adQualityVerifierAdapterConfiguration = (AdQualityVerifierAdapterConfiguration) other;
        return Intrinsics.areEqual(this.apiKey, adQualityVerifierAdapterConfiguration.apiKey) && this.verificationTimeoutInSec == adQualityVerifierAdapterConfiguration.verificationTimeoutInSec && this.debug == adQualityVerifierAdapterConfiguration.debug;
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final long getVerificationTimeoutInSec() {
        return this.verificationTimeoutInSec;
    }

    public int hashCode() {
        return Boolean.hashCode(this.debug) + ((Long.hashCode(this.verificationTimeoutInSec) + (this.apiKey.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "AdQualityVerifierAdapterConfiguration(apiKey=" + this.apiKey + ", verificationTimeoutInSec=" + this.verificationTimeoutInSec + ", debug=" + this.debug + ")";
    }

    public /* synthetic */ AdQualityVerifierAdapterConfiguration(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, (i & 4) != 0 ? false : z);
    }
}

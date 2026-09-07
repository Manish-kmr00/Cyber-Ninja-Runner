package com.monetization.ads.quality.base.model;

import com.facebook.internal.NativeProtocol;
import com.monetization.ads.quality.base.model.configuration.AdQualityVerifiableNetwork;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000f2\u00020\u0001:\n\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0019\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\u0004\u0082\u0001\t\u001a\u001b\u001c\u001d\u001e\u001f !\"¨\u0006#"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "", "", "toString", "()Ljava/lang/String;", "", "code", "I", "getCode", "()I", "description", "Ljava/lang/String;", "getDescription", "<init>", "(ILjava/lang/String;)V", "Code", "a", "DisabledError", "InitializationAlreadyInProcess", "InternalError", "InvalidAdObject", "InvalidInit", "LowUsagePercent", "TimeoutError", NativeProtocol.ERROR_UNKNOWN_ERROR, "UnsupportedNetwork", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$DisabledError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InitializationAlreadyInProcess;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InternalError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InvalidAdObject;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InvalidInit;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$LowUsagePercent;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$TimeoutError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$UnknownError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$UnsupportedNetwork;", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0})
public abstract class AdQualityVerificationError {
    private static final a Code = new a(0);

    @Deprecated
    public static final int INTERNAL_ERROR = 1;

    @Deprecated
    public static final int INVALID_REQUEST = 2;

    @Deprecated
    public static final int UNKNOWN_ERROR = 0;
    private final int code;
    private final String description;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$DisabledError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DisabledError extends AdQualityVerificationError {
        public DisabledError() {
            super(1, "The ad verification is disabled by configuration", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InitializationAlreadyInProcess;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InitializationAlreadyInProcess extends AdQualityVerificationError {
        public InitializationAlreadyInProcess() {
            super(1, "The verification initialization is already in progress", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InternalError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "description", "", "(Ljava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InternalError extends AdQualityVerificationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InternalError(String description) {
            super(1, "The ad verification build in error: " + description, null);
            Intrinsics.checkNotNullParameter(description, "description");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InvalidAdObject;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "network", "Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifiableNetwork;", "(Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifiableNetwork;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvalidAdObject extends AdQualityVerificationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidAdObject(AdQualityVerifiableNetwork network) {
            super(2, "The ad object for verification " + network.name() + " is invalid", null);
            Intrinsics.checkNotNullParameter(network, "network");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$InvalidInit;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "errorDescription", "", "(Ljava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvalidInit extends AdQualityVerificationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidInit(String errorDescription) {
            super(1, "The verifier initialization error: " + errorDescription, null);
            Intrinsics.checkNotNullParameter(errorDescription, "errorDescription");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$LowUsagePercent;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "()V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LowUsagePercent extends AdQualityVerificationError {
        public LowUsagePercent() {
            super(1, "The ad verification is not in percent usage", null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$TimeoutError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "timeout", "", "(J)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class TimeoutError extends AdQualityVerificationError {
        public TimeoutError(long j) {
            super(1, "The ad verifications timed out after " + j, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$UnknownError;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "description", "", "(Ljava/lang/String;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnknownError extends AdQualityVerificationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnknownError(String description) {
            super(0, "The ad verification failed with error: " + description, null);
            Intrinsics.checkNotNullParameter(description, "description");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/monetization/ads/quality/base/model/AdQualityVerificationError$UnsupportedNetwork;", "Lcom/monetization/ads/quality/base/model/AdQualityVerificationError;", "network", "Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifiableNetwork;", "(Lcom/monetization/ads/quality/base/model/configuration/AdQualityVerifiableNetwork;)V", "mobileads_externalRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnsupportedNetwork extends AdQualityVerificationError {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnsupportedNetwork(AdQualityVerifiableNetwork network) {
            super(2, "The " + network.name() + " is unsupported for verification", null);
            Intrinsics.checkNotNullParameter(network, "network");
        }
    }

    private static final class a {
        public /* synthetic */ a(int i) {
            this();
        }

        private a() {
        }
    }

    public /* synthetic */ AdQualityVerificationError(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Ad verification error: (code: " + this.code + ", description: " + this.description + ")";
    }

    private AdQualityVerificationError(int i, String str) {
        this.code = i;
        this.description = str;
    }
}

package com.moloco.sdk.publisher;

import com.moloco.sdk.internal.publisher.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001a\u001bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAdError;", "", "networkName", "", "adUnitId", "errorType", "Lcom/moloco/sdk/publisher/MolocoAdError$ErrorType;", "description", "(Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/publisher/MolocoAdError$ErrorType;Ljava/lang/String;)V", "getAdUnitId", "()Ljava/lang/String;", "getDescription", "getErrorType", "()Lcom/moloco/sdk/publisher/MolocoAdError$ErrorType;", "getNetworkName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "AdCreateError", "ErrorType", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MolocoAdError {
    public static final int $stable = 0;
    private final String adUnitId;
    private final String description;
    private final ErrorType errorType;
    private final String networkName;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAdError$AdCreateError;", "", "description", "", "errorCode", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDescription", "()Ljava/lang/String;", "getErrorCode", "()I", "SDK_INIT_FAILED", "SDK_INIT_WAS_NOT_COMPLETED", b.g, "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum AdCreateError {
        SDK_INIT_FAILED("Failed to create `ad` object due to SDK initialization failure.", 1011),
        SDK_INIT_WAS_NOT_COMPLETED("Failed to create `ad` object due to `Moloco.initialize()` not complete.", 1012),
        UNABLE_TO_CREATE_AD("Failed to create `ad` object due to `Moloco.initialize()` not complete in time", 1013);

        private final String description;
        private final int errorCode;

        AdCreateError(String str, int i) {
            this.description = str;
            this.errorCode = i;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAdError$ErrorType;", "", "description", "", "errorCode", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDescription", "()Ljava/lang/String;", "getErrorCode", "()I", "UNKNOWN", "SDK_INIT_ERROR", "SDK_PERSISTENT_HTTP_REQUEST_FAILED_TO_INIT", "SDK_INVALID_CONFIGURATION", "AD_LOAD_FAILED", "AD_LOAD_FAILED_SDK_NOT_INIT", "AD_LOAD_TIMEOUT_ERROR", "AD_LOAD_LIMIT_REACHED", "AD_LOAD_BID_FAILED", "AD_SHOW_ERROR", "AD_SHOW_ERROR_NOT_LOADED", "AD_SHOW_ERROR_ALREADY_DISPLAYING", "AD_BID_PARSE_ERROR", "AD_SIGNAL_COLLECTION_FAILED", "moloco-sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum ErrorType {
        UNKNOWN("Generic failure error code", -1),
        SDK_INIT_ERROR("SDK initialization error", 1000),
        SDK_PERSISTENT_HTTP_REQUEST_FAILED_TO_INIT("WorkManager crash that prevents us from creating a persistent http request client", 1001),
        SDK_INVALID_CONFIGURATION("Ad object cannot be created, due to invalid configuration", 1002),
        AD_LOAD_FAILED("Ad is not loaded", 2000),
        AD_LOAD_FAILED_SDK_NOT_INIT("Ad load failed because SDK was not initialized", 2001),
        AD_LOAD_TIMEOUT_ERROR("Ad failed to load because the request timed out", 2003),
        AD_LOAD_LIMIT_REACHED("Ad load limit reached", 2004),
        AD_LOAD_BID_FAILED("Ad failed to load because bid request failed or no fill", 2005),
        AD_SHOW_ERROR("Ad show failed despite a successful ad load. Internal renderer error", 3000),
        AD_SHOW_ERROR_NOT_LOADED("Ad show failed because ad load was not called", 3001),
        AD_SHOW_ERROR_ALREADY_DISPLAYING("Ad show failed because show() was invoked multiple times when ad was already rendering", 3002),
        AD_BID_PARSE_ERROR("The bid response received was not parseable by the SDK", 4000),
        AD_SIGNAL_COLLECTION_FAILED("The bid token couldn’t be retrieved.", 5000);

        private final String description;
        private final int errorCode;

        ErrorType(String str, int i) {
            this.description = str;
            this.errorCode = i;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    public MolocoAdError(String networkName, String adUnitId, ErrorType errorType, String description) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(description, "description");
        this.networkName = networkName;
        this.adUnitId = adUnitId;
        this.errorType = errorType;
        this.description = description;
    }

    public static /* synthetic */ MolocoAdError copy$default(MolocoAdError molocoAdError, String str, String str2, ErrorType errorType, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = molocoAdError.networkName;
        }
        if ((i & 2) != 0) {
            str2 = molocoAdError.adUnitId;
        }
        if ((i & 4) != 0) {
            errorType = molocoAdError.errorType;
        }
        if ((i & 8) != 0) {
            str3 = molocoAdError.description;
        }
        return molocoAdError.copy(str, str2, errorType, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNetworkName() {
        return this.networkName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final ErrorType getErrorType() {
        return this.errorType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final MolocoAdError copy(String networkName, String adUnitId, ErrorType errorType, String description) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(description, "description");
        return new MolocoAdError(networkName, adUnitId, errorType, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MolocoAdError)) {
            return false;
        }
        MolocoAdError molocoAdError = (MolocoAdError) other;
        return Intrinsics.areEqual(this.networkName, molocoAdError.networkName) && Intrinsics.areEqual(this.adUnitId, molocoAdError.adUnitId) && this.errorType == molocoAdError.errorType && Intrinsics.areEqual(this.description, molocoAdError.description);
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final ErrorType getErrorType() {
        return this.errorType;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public int hashCode() {
        return (((((this.networkName.hashCode() * 31) + this.adUnitId.hashCode()) * 31) + this.errorType.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "MolocoAdError(networkName=" + this.networkName + ", adUnitId=" + this.adUnitId + ", errorType=" + this.errorType + ", description=" + this.description + ')';
    }

    public /* synthetic */ MolocoAdError(String str, String str2, ErrorType errorType, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, errorType, (i & 8) != 0 ? errorType.getDescription() : str3);
    }
}

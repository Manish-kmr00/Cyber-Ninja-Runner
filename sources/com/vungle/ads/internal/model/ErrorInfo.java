package com.vungle.ads.internal.model;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ErrorInfo.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/vungle/ads/internal/model/ErrorInfo;", "", "reason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "description", "", "errorIsTerminal", "", "(Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;Ljava/lang/String;Z)V", "getDescription", "()Ljava/lang/String;", "getErrorIsTerminal", "()Z", "getReason", "()Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class ErrorInfo {
    private final String description;
    private final boolean errorIsTerminal;
    private final Sdk.SDKError.Reason reason;

    public static /* synthetic */ ErrorInfo copy$default(ErrorInfo errorInfo, Sdk.SDKError.Reason reason, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            reason = errorInfo.reason;
        }
        if ((i & 2) != 0) {
            str = errorInfo.description;
        }
        if ((i & 4) != 0) {
            z = errorInfo.errorIsTerminal;
        }
        return errorInfo.copy(reason, str, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Sdk.SDKError.Reason getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    public final ErrorInfo copy(Sdk.SDKError.Reason reason, String description, boolean errorIsTerminal) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(description, "description");
        return new ErrorInfo(reason, description, errorIsTerminal);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ErrorInfo)) {
            return false;
        }
        ErrorInfo errorInfo = (ErrorInfo) other;
        return this.reason == errorInfo.reason && Intrinsics.areEqual(this.description, errorInfo.description) && this.errorIsTerminal == errorInfo.errorIsTerminal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.reason.hashCode() * 31) + this.description.hashCode()) * 31;
        boolean z = this.errorIsTerminal;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "ErrorInfo(reason=" + this.reason + ", description=" + this.description + ", errorIsTerminal=" + this.errorIsTerminal + ')';
    }

    public ErrorInfo(Sdk.SDKError.Reason reason, String description, boolean z) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        Intrinsics.checkNotNullParameter(description, "description");
        this.reason = reason;
        this.description = description;
        this.errorIsTerminal = z;
    }

    public /* synthetic */ ErrorInfo(Sdk.SDKError.Reason reason, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reason, str, (i & 4) != 0 ? false : z);
    }

    public final Sdk.SDKError.Reason getReason() {
        return this.reason;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }
}

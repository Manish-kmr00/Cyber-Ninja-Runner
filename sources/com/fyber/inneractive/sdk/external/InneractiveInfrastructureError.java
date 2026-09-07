package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.flow.EnumC3104i;
import com.fyber.inneractive.sdk.network.EnumC3143t;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class InneractiveInfrastructureError extends InneractiveError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InneractiveErrorCode f1756a;
    public final EnumC3104i b;
    public final Throwable c;
    public Exception d;
    public final ArrayList e;

    public InneractiveInfrastructureError(InneractiveErrorCode inneractiveErrorCode, EnumC3104i enumC3104i) {
        this(inneractiveErrorCode, enumC3104i, null);
    }

    public void addReportedError(EnumC3143t enumC3143t) {
        this.e.add(enumC3143t);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveError
    public String description() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1756a);
        if (this.c != null) {
            sb.append(" : ").append(this.c);
        }
        return sb.toString();
    }

    public Throwable getCause() {
        Exception exc = this.d;
        return exc == null ? this.c : exc;
    }

    public InneractiveErrorCode getErrorCode() {
        return this.f1756a;
    }

    public EnumC3104i getFyberMarketplaceAdLoadFailureReason() {
        return this.b;
    }

    public boolean isErrorAlreadyReported(EnumC3143t enumC3143t) {
        return this.e.contains(enumC3143t);
    }

    public void setCause(Exception exc) {
        this.d = exc;
    }

    public InneractiveInfrastructureError(InneractiveErrorCode inneractiveErrorCode, EnumC3104i enumC3104i, Throwable th) {
        this.e = new ArrayList();
        this.f1756a = inneractiveErrorCode;
        this.b = enumC3104i;
        this.c = th;
    }
}

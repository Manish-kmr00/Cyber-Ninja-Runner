package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.B;

/* JADX INFO: loaded from: classes12.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1623a;
    public final /* synthetic */ Exception b;

    public u(B b, Exception exc) {
        this.f1623a = b;
        this.b = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B b = this.f1623a;
        if (b != null) {
            b.a(this.b, InneractiveErrorCode.INVALID_INPUT, new com.fyber.inneractive.sdk.response.e[0]);
        }
    }
}

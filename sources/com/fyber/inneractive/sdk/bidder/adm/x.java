package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.B;

/* JADX INFO: loaded from: classes12.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1626a;

    public x(B b) {
        this.f1626a = b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B b = this.f1626a;
        if (b != null) {
            b.a(new Exception("adm payload must contain ad url"), InneractiveErrorCode.INVALID_INPUT, new com.fyber.inneractive.sdk.response.e[0]);
        }
    }
}

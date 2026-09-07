package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.flow.B;

/* JADX INFO: loaded from: classes12.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ B f1622a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ y c;

    public t(y yVar, B b, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.c = yVar;
        this.f1622a = b;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f1622a, this.b);
    }
}

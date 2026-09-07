package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.network.P;

/* JADX INFO: loaded from: classes12.dex */
public final class w implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f1625a;

    public w(y yVar) {
        this.f1625a = yVar;
    }

    @Override // com.fyber.inneractive.sdk.network.P
    public final void a(String str) {
        str.hashCode();
        switch (str) {
            case "sdkInitNetworkRequest":
                com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
                dVar.a(this.f1625a.d).f();
                dVar.b(this.f1625a.d).c = System.currentTimeMillis();
                break;
            case "sdkGotServerResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1625a.d).h();
                break;
            case "sdkParsedResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1625a.d).d();
                break;
            case "sdkRequestEndedButWillBeRetried":
                com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.f1625a.d);
                iVarB.f1872a.put(new com.fyber.inneractive.sdk.metrics.h("retrying"), Long.valueOf(System.currentTimeMillis() - iVarB.c));
                break;
        }
    }
}

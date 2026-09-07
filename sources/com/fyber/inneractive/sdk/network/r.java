package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C3142s f1931a;

    public r(C3142s c3142s) {
        this.f1931a = c3142s;
    }

    @Override // com.fyber.inneractive.sdk.network.P
    public final void a(String str) {
        str.hashCode();
        switch (str) {
            case "sdkInitNetworkRequest":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1931a.d).f();
                break;
            case "sdkGotServerResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1931a.d).g();
                break;
            case "sdkParsedResponse":
                com.fyber.inneractive.sdk.metrics.d.d.a(this.f1931a.d).d();
                break;
        }
    }
}

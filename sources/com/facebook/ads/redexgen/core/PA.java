package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class PA implements InterfaceExecutorC2450ft {
    public final /* synthetic */ InterfaceC2399f3 A00;
    public final /* synthetic */ Executor A01;

    public PA(Executor executor, InterfaceC2399f3 interfaceC2399f3) {
        this.A01 = executor;
        this.A00 = interfaceC2399f3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceExecutorC2450ft
    public final void AGj() {
        this.A00.A2z(this.A01);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.A01.execute(runnable);
    }
}

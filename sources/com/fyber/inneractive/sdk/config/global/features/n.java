package com.fyber.inneractive.sdk.config.global.features;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes13.dex */
public final class n extends h implements p {
    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.toMillis(45L);
        timeUnit.toMillis(5L);
        timeUnit.toMillis(5L);
        timeUnit.toMillis(45L);
        timeUnit.toMillis(10L);
        timeUnit.toMillis(2L);
        timeUnit.toMillis(15L);
        timeUnit.toMillis(8L);
    }

    public n() {
        super("bid_net");
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h c() {
        n nVar = new n();
        a(nVar);
        return nVar;
    }
}

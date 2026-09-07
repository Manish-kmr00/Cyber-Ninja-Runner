package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import java.io.IOException;

/* JADX INFO: loaded from: classes9.dex */
public final class A extends IOException {
    public A(Throwable th) {
        super("Unexpected " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
    }
}

package com.fyber.inneractive.sdk.util;

import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3246j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2366a = new ConcurrentLinkedQueue();
    public final InterfaceC3245i b;

    public C3246j(int i, InterfaceC3245i interfaceC3245i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f2366a.offer(interfaceC3245i.a());
        }
        this.b = interfaceC3245i;
    }
}

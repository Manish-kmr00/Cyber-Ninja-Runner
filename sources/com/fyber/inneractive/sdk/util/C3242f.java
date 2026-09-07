package com.fyber.inneractive.sdk.util;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.util.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3242f {
    public static final C3242f b = new C3242f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue f2362a = new ConcurrentLinkedQueue();

    public C3242f() {
        for (int i = 0; i < 2; i++) {
            this.f2362a.offer(ByteBuffer.allocateDirect(16384));
        }
    }
}

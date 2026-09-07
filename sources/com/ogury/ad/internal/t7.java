package com.ogury.ad.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t7 f7405a = new t7();
    public static z7 b = new z7();

    public static z7 a() {
        return b;
    }

    public static void a(z7 newCachedProfigResponse) {
        Intrinsics.checkNotNullParameter(newCachedProfigResponse, "newCachedProfigResponse");
        b = newCachedProfigResponse;
    }
}

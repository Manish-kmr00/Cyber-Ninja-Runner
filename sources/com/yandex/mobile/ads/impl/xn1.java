package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes13.dex */
public final class xn1 extends sq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10667a;
    private final long b;
    private final BufferedSource c;

    public xn1(String str, long j, BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f10667a = str;
        this.b = j;
        this.c = source;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final long a() {
        return this.b;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final yw0 b() {
        String str = this.f10667a;
        if (str != null) {
            int i = yw0.d;
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return yw0.a.a(str);
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    @Override // com.yandex.mobile.ads.impl.sq1
    public final BufferedSource c() {
        return this.c;
    }
}

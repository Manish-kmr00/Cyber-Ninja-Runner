package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.io.Base64Utils;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.mn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4300mn implements Qn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final L8 f11676a;

    public C4300mn() {
        this(new L8());
    }

    @Override // io.appmetrica.analytics.impl.Qn
    public final byte[] a(R8 r8, C4045ch c4045ch) {
        byte[] bArrDecompressBase64GzipAsBytes = new byte[0];
        try {
            bArrDecompressBase64GzipAsBytes = Base64Utils.decompressBase64GzipAsBytes(r8.b);
        } catch (Throwable unused) {
        }
        byte[] bArrA = ((K8) this.f11676a.f11240a.a(r8.o)).a(bArrDecompressBase64GzipAsBytes);
        return bArrA == null ? new byte[0] : bArrA;
    }

    public C4300mn(L8 l8) {
        this.f11676a = l8;
    }

    public final L8 a() {
        return this.f11676a;
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import java.util.Arrays;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4355p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4330o3 f11712a;
    public final GZIPCompressor b;

    public C4355p3() {
        this(new C4330o3(), new GZIPCompressor());
    }

    public final byte[] a(byte[] bArr) {
        try {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
            C4330o3 c4330o3 = this.f11712a;
            byte[] bytes = "hBnBQbZrmjPXEWVJ".getBytes();
            c4330o3.getClass();
            AESEncrypter aESEncrypter = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, bytes, bArrCopyOfRange);
            if (bArr != null && bArr.length != 0) {
                return this.b.uncompress(aESEncrypter.decrypt(bArr, 16, bArr.length - 16));
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public C4355p3(C4330o3 c4330o3, GZIPCompressor gZIPCompressor) {
        this.f11712a = c4330o3;
        this.b = gZIPCompressor;
    }
}

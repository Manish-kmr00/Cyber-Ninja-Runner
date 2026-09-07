package io.appmetrica.analytics.impl;

import android.util.Base64;

/* JADX INFO: loaded from: classes4.dex */
public final class S9 implements K8 {
    @Override // io.appmetrica.analytics.impl.K8
    public final E8 a(C3984a6 c3984a6) {
        throw new UnsupportedOperationException();
    }

    @Override // io.appmetrica.analytics.impl.K8
    public final byte[] a(byte[] bArr) {
        try {
            return Base64.decode(bArr, 0);
        } catch (Throwable unused) {
            return new byte[0];
        }
    }

    public final M8 a() {
        return M8.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER;
    }
}

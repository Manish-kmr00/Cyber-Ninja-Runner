package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4002b implements K8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AESEncrypter f11470a;

    public C4002b() {
        this(new C3977a(C4486ua.j().f()));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    @Override // io.appmetrica.analytics.impl.K8
    public final E8 a(C3984a6 c3984a6) {
        String strEncodeToString;
        String value = c3984a6.getValue();
        if (TextUtils.isEmpty(value)) {
            strEncodeToString = null;
        } else {
            try {
                byte[] bArrEncrypt = this.f11470a.encrypt(value.getBytes("UTF-8"));
                if (bArrEncrypt != null) {
                    strEncodeToString = Base64.encodeToString(bArrEncrypt, 0);
                } else {
                    strEncodeToString = null;
                }
            } catch (Throwable unused) {
            }
        }
        c3984a6.setValue(strEncodeToString);
        return new E8(c3984a6, M8.AES_VALUE_ENCRYPTION);
    }

    public C4002b(C3977a c3977a) {
        this(new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c3977a.b(), c3977a.a()));
    }

    public C4002b(AESEncrypter aESEncrypter) {
        this.f11470a = aESEncrypter;
    }

    @Override // io.appmetrica.analytics.impl.K8
    public final byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null || bArr.length <= 0) {
            return bArr2;
        }
        try {
            return this.f11470a.decrypt(Base64.decode(bArr, 0));
        } catch (Throwable unused) {
            return bArr2;
        }
    }

    public final M8 a() {
        return M8.AES_VALUE_ENCRYPTION;
    }
}

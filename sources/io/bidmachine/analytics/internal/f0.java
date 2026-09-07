package io.bidmachine.analytics.internal;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes9.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f12086a = new f0();
    private static final ThreadLocal b = new a();

    public static final class a extends ThreadLocal {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return f0.f12086a.a();
        }
    }

    private f0() {
    }

    private final SecureRandom b() {
        SecureRandom secureRandom = (SecureRandom) b.get();
        return secureRandom == null ? a() : secureRandom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SecureRandom a() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public final byte[] a(int i) {
        byte[] bArr = new byte[i];
        f12086a.b().nextBytes(bArr);
        return bArr;
    }
}

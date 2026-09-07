package io.bidmachine.analytics.internal;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KeyPairGenerator f12173a;

    public r() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(new ECGenParameterSpec("secp256r1"));
        this.f12173a = keyPairGenerator;
    }

    @Override // io.bidmachine.analytics.internal.D
    public KeyPairGenerator a() {
        return this.f12173a;
    }

    public KeyPair b() {
        return D.a.a(this);
    }
}

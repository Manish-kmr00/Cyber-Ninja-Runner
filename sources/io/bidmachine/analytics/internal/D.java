package io.bidmachine.analytics.internal;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/* JADX INFO: loaded from: classes13.dex */
public interface D {

    public static final class a {
        public static KeyPair a(D d) {
            return d.a().generateKeyPair();
        }
    }

    KeyPairGenerator a();
}

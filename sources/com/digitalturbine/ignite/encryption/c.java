package com.digitalturbine.ignite.encryption;

import android.util.Pair;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public d b;
    public b c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecretKey f1239a = null;
    public final AlgorithmParameterSpec d = new com.digitalturbine.ignite.encryption.generator.a().a();

    public final void a() throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : init", "EncryptionManager");
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        if (!keyStore.containsAlias("dtx_ignite_service_storage")) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
            keyGenerator.init(this.d);
            keyGenerator.generateKey();
        }
        Key key = keyStore.getKey("dtx_ignite_service_storage", null);
        if (key instanceof SecretKey) {
            this.f1239a = (SecretKey) key;
            this.b = new d();
            this.c = new b();
        }
    }

    public final Pair a(String str) {
        if (this.b != null) {
            return d.a(this.f1239a, str);
        }
        return null;
    }

    public final String a(String str, byte[] bArr) {
        b bVar = this.c;
        if (bVar == null) {
            return null;
        }
        SecretKey secretKey = this.f1239a;
        bVar.getClass();
        return a.a(a.a(2, bArr, secretKey), str);
    }
}

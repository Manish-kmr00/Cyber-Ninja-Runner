package com.adjust.sdk.sig;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.json.gk;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f160a;

    public c(int i) {
        this.f160a = i;
    }

    public final void a(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        keyStore.deleteEntry("key2");
        context.getSharedPreferences("adjust_keys", 0).edit().remove("encrypted_key").apply();
    }

    public final void b(Context context) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, KeyStoreException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        int i = this.f160a;
        if (i >= 23) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias("key2")) {
                return;
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");
            keyGenerator.init(new KeyGenParameterSpec.Builder("key2", 4).build());
            keyGenerator.generateKey();
            return;
        }
        if (i < 18) {
            throw new b();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("adjust_keys", 0);
        if (sharedPreferences.contains("encrypted_key")) {
            return;
        }
        Date time = Calendar.getInstance().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.add(1, 1);
        KeyPairGeneratorSpec.Builder endDate = new KeyPairGeneratorSpec.Builder(context).setAlias("key2").setSubject(new X500Principal("CN=key2")).setSerialNumber(BigInteger.TEN).setStartDate(time).setEndDate(calendar.getTime());
        if (this.f160a >= 19) {
            endDate.setKeySize(1024);
        }
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
        keyPairGenerator.initialize(endDate.build());
        keyPairGenerator.genKeyPair();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        KeyStore keyStore2 = KeyStore.getInstance("AndroidKeyStore");
        keyStore2.load(null);
        KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore2.getEntry("key2", null);
        Cipher cipher = Cipher.getInstance(gk.b);
        cipher.init(1, privateKeyEntry.getCertificate().getPublicKey());
        String strEncodeToString = Base64.encodeToString(cipher.doFinal(bArr), 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("encrypted_key", strEncodeToString);
        editorEdit.apply();
    }

    public final byte[] a(Context context, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, UnrecoverableKeyException, IOException, InvalidKeyException, KeyStoreException, CertificateException {
        Key secretKeySpec;
        Mac mac = Mac.getInstance("HmacSHA256");
        int i = this.f160a;
        if (i >= 23) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            secretKeySpec = keyStore.getKey("key2", null);
        } else {
            if (i < 18) {
                throw new RuntimeException("Unsupported version");
            }
            String string = context.getSharedPreferences("adjust_keys", 0).getString("encrypted_key", null);
            if (string == null) {
                throw new RuntimeException("Failed to find encrypted key in SharedPreferences");
            }
            byte[] bArrDecode = Base64.decode(string, 0);
            KeyStore keyStore2 = KeyStore.getInstance("AndroidKeyStore");
            keyStore2.load(null);
            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore2.getEntry("key2", null);
            Cipher cipher = Cipher.getInstance(gk.b);
            cipher.init(2, privateKeyEntry.getPrivateKey());
            secretKeySpec = new SecretKeySpec(cipher.doFinal(bArrDecode), "AES");
        }
        mac.init(secretKeySpec);
        mac.update(bArr);
        return mac.doFinal();
    }
}

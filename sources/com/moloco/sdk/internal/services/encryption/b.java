package com.moloco.sdk.internal.services.encryption;

import android.util.Base64;
import com.moloco.sdk.BuildConfig;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.moloco.sdk.internal.services.encryption.a {
    public final Lazy b = LazyKt.lazy(c.f6373a);
    public final Lazy c = LazyKt.lazy(d.f6374a);
    public final Lazy d = LazyKt.lazy(a.f6371a);
    public final Lazy e = LazyKt.lazy(C0560b.f6372a);
    public final SecretKeySpec f = c();
    public final Lazy g = LazyKt.lazy(e.f6375a);

    public static final class a extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f6371a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return StringsKt.decodeToString(new byte[]{65, 69, 83});
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.encryption.b$b, reason: collision with other inner class name */
    public static final class C0560b extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0560b f6372a = new C0560b();

        public C0560b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            byte[] bArrDecode = Base64.decode(new byte[]{81, 85, 86, 84, 76, 48, 100, 68, 84, 83, 57, 79, 98, 49, 66, 104, 90, 71, 82, 112, 98, 109, 99, kotlin.io.encoding.Base64.padSymbol}, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(byteArrayOf(81, 8… 99, 61), Base64.DEFAULT)");
            return StringsKt.decodeToString(bArrDecode);
        }
    }

    public static final class c extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f6373a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            byte[] bArrDecode = Base64.decode(new byte[]{85, 108, 78, 66}, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(byteArrayOf(85, 1… 78, 66), Base64.DEFAULT)");
            return StringsKt.decodeToString(bArrDecode);
        }
    }

    public static final class d extends Lambda implements Function0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f6374a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return StringsKt.decodeToString(new byte[]{82, 83, 65, 47, 69, 67, 66, 47, 79, 65, 69, 80, 87, 105, 116, 104, 83, 72, 65, 45, 50, 53, 54, 65, 110, 100, 77, 71, 70, 49, 80, 97, 100, 100, 105, 110, 103});
        }
    }

    public static final class e extends Lambda implements Function0<IvParameterSpec> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f6375a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final IvParameterSpec invoke() {
            return new IvParameterSpec(Base64.decode(BuildConfig.MOLOCO_SDK_BIDTOKEN_SALT, 0));
        }
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public IvParameterSpec a() {
        return (IvParameterSpec) this.g.getValue();
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public SecretKeySpec b() {
        return this.f;
    }

    public final SecretKeySpec c() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(d());
        keyGenerator.init(256);
        return new SecretKeySpec(keyGenerator.generateKey().getEncoded(), d());
    }

    public final String d() {
        return (String) this.d.getValue();
    }

    public final String e() {
        return (String) this.e.getValue();
    }

    public final String f() {
        return (String) this.b.getValue();
    }

    public final String g() {
        return (String) this.c.getValue();
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(byte[] data) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Cipher cipher = Cipher.getInstance(e());
        cipher.init(1, b(), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
        return bArrDoFinal;
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public String b(byte[] data) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Cipher cipher = Cipher.getInstance(e());
        cipher.init(2, b(), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
        return StringsKt.decodeToString(bArrDoFinal);
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public String a(byte[] data, byte[] secret) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(secret, "secret");
        Cipher cipher = Cipher.getInstance(e());
        cipher.init(2, new SecretKeySpec(secret, d()), a());
        byte[] bArrDoFinal = cipher.doFinal(data);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(data)");
        return StringsKt.decodeToString(bArrDoFinal);
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] b(byte[] input, String publicKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Cipher cipher = Cipher.getInstance(g());
        cipher.init(1, c(publicKey));
        byte[] bArrDoFinal = cipher.doFinal(b().getEncoded());
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(aesSecret.encoded)");
        return bArrDoFinal;
    }

    public final PublicKey c(String str) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(f()).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "keyFactory.generatePublic(keySpec)");
        return publicKeyGeneratePublic;
    }

    public final PrivateKey b(String str) throws InvalidKeySpecException {
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance(f()).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "keyFactory.generatePrivate(keySpec)");
        return privateKeyGeneratePrivate;
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(String rsaPublicKey) {
        Intrinsics.checkNotNullParameter(rsaPublicKey, "rsaPublicKey");
        byte[] encoded = b().getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "aesSecret.encoded");
        return b(encoded, rsaPublicKey);
    }

    @Override // com.moloco.sdk.internal.services.encryption.a
    public byte[] a(byte[] input, String privateKey) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Cipher cipher = Cipher.getInstance(g());
        cipher.init(2, b(privateKey));
        byte[] bArrDoFinal = cipher.doFinal(input);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "cipher.doFinal(input)");
        return bArrDoFinal;
    }
}

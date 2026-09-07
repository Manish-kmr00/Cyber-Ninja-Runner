package com.yandex.mobile.ads.impl;

import android.util.Base64;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t01 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10252a;
    private final int b;

    public final byte[] a(byte[] input) {
        Intrinsics.checkNotNullParameter(input, "input");
        try {
            byte[] bArrDecode = Base64.decode(this.f10252a, 0);
            if (bArrDecode == null) {
                return null;
            }
            SecureRandom secureRandom = new SecureRandom();
            byte[] bArr = new byte[16];
            byte[] bArr2 = new byte[16];
            secureRandom.nextBytes(bArr2);
            secureRandom.nextBytes(bArr);
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArrDecode));
            Intrinsics.checkNotNull(publicKeyGeneratePublic);
            return a(input, bArr2, bArr, publicKeyGeneratePublic);
        } catch (Throwable th) {
            op0.b(th);
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public t01(int i, String publicKey) {
        this(i, publicKey, 0);
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
    }

    private t01(int i, String str, int i2) {
        this.f10252a = str;
        this.b = i;
    }

    private final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, PublicKey publicKey) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr2.length + bArr3.length);
            try {
                byteArrayOutputStream.write(bArr2);
                byteArrayOutputStream.write(bArr3);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                Cipher cipher = Cipher.getInstance(com.json.gk.b);
                xc xcVar = new xc(AESEncrypter.DEFAULT_ALGORITHM, bArr2, bArr3);
                cipher.init(1, publicKey);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(bArr.length);
                try {
                    byteArrayOutputStream2.write(ByteBuffer.allocate(4).putInt(this.b).array());
                    byteArrayOutputStream2.write(cipher.doFinal(byteArray));
                    byteArrayOutputStream2.write(xcVar.a(bArr));
                    byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream2, null);
                    return byteArray2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(byteArrayOutputStream2, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayOutputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            op0.b(th5);
            return null;
        }
    }
}

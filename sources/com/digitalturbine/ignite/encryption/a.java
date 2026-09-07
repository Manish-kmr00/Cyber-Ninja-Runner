package com.digitalturbine.ignite.encryption;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static Cipher a(int i, byte[] bArr, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(i, secretKey, new GCMParameterSpec(128, bArr));
        return cipher;
    }

    public static String a(Cipher cipher, String str) throws IOException {
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(Base64.decode(str, 0)), cipher);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = cipherInputStream.read();
            if (i == -1) {
                break;
            }
            arrayList.add(Byte.valueOf((byte) i));
        }
        byte[] bArr = new byte[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            bArr[i2] = ((Byte) arrayList.get(i2)).byteValue();
        }
        return new String(bArr, "UTF-8");
    }
}

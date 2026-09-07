package com.five_corp.ad.internal;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes11.dex */
public abstract class D {
    public static String a(String str) {
        byte[] bArrDigest;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            bArrDigest = messageDigest.digest();
        } catch (IllegalArgumentException | NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        String strEncodeToString = bArrDigest != null ? Base64.encodeToString(bArrDigest, 11) : null;
        return strEncodeToString != null ? strEncodeToString : str.replaceAll("[^a-zA-Z0-9]", "_");
    }
}

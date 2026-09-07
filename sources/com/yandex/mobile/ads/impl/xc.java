package com.yandex.mobile.ads.impl;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10640a;
    private final byte[] b;
    private final byte[] c;

    public xc(String algorithm, byte[] password, byte[] iV) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(iV, "iV");
        this.f10640a = algorithm;
        this.b = password;
        this.c = iV;
    }

    public final byte[] a(byte[] input) throws Exception {
        Intrinsics.checkNotNullParameter(input, "input");
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        Cipher cipher = Cipher.getInstance(this.f10640a);
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.c));
        byte[] bArrDoFinal = cipher.doFinal(input);
        Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
        return bArrDoFinal;
    }
}

package com.bytedance.sdk.openadsdk.core;

import android.util.Base64;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes13.dex */
public final class pA {
    private static final String pA = KZx();
    private static final String Og = aBv.ZZv().KZx();

    public static String pA() {
        return new String(Base64.decode(pA, 0)).substring(2);
    }

    public static String Og() {
        return new String(Base64.decode(Og, 0)).substring(2);
    }

    private static String KZx() {
        char[] cArr = {203, Typography.paragraph, 168, Typography.degree, 207, 148, 149, 178, 205, Typography.paragraph, 149, 166, 134, 178, 184, Typography.degree, 206, Typography.registered, 187, 178, 150, 185, Typography.section, 166};
        char[] cArr2 = new char[24];
        for (int i = 23; i >= 0; i--) {
            cArr2[23 - i] = (char) (cArr[i] ^ 255);
        }
        return new String(cArr2);
    }
}

package com.yandex.mobile.ads.impl;

import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes4.dex */
public final class rj {
    public static String a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] bytes = value.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return a(bytes);
    }

    public static String b(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = value.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        try {
            byte[] bArrDecode = Base64.decode(bytes, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            return new String(bArrDecode, charset);
        } catch (Exception unused) {
            Object[] args = new Object[0];
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            return null;
        }
    }

    public static String a(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            byte[] bArrDecode = Base64.decode(data, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
            return new String(bArrDecode, Charsets.UTF_8);
        } catch (Exception unused) {
            String str = new String(data, Charsets.UTF_8);
            Object[] args = new Object[0];
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            return str;
        }
    }
}

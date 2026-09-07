package com.yandex.mobile.ads.impl;

import android.util.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes5.dex */
public final class p50 implements o50 {
    @Override // com.yandex.mobile.ads.impl.o50
    public final String a() {
        byte[] bArrDecode = Base64.decode("b3NfbmFtZQ==", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @Override // com.yandex.mobile.ads.impl.o50
    public final String b() {
        byte[] bArrDecode = Base64.decode("bWFudWZhY3R1cmVy", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @Override // com.yandex.mobile.ads.impl.o50
    public final String c() {
        byte[] bArrDecode = Base64.decode("bW9kZWw=", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @Override // com.yandex.mobile.ads.impl.o50
    public final String d() {
        byte[] bArrDecode = Base64.decode("b3NfdmVyc2lvbg==", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @Override // com.yandex.mobile.ads.impl.o50
    public final String e() {
        byte[] bArrDecode = Base64.decode("ZGV2aWNlLWlk", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }

    @Override // com.yandex.mobile.ads.impl.o50
    public final String f() {
        byte[] bArrDecode = Base64.decode("ZGV2aWNlX3R5cGU=", 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        return new String(bArrDecode, Charsets.UTF_8);
    }
}

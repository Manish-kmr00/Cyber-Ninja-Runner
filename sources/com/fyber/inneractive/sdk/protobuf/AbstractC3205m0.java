package com.fyber.inneractive.sdk.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.m0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractC3205m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f2291a = Charset.forName("UTF-8");
    public static final byte[] b;

    static {
        Charset.forName(com.google.android.exoplayer2.C.ISO88591_NAME);
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static String a(byte[] bArr) {
        return new String(bArr, f2291a);
    }

    public static AbstractC3169a0 a(Object obj, Object obj2) {
        E0 e0 = (E0) obj2;
        U u = (U) ((E0) obj).toBuilder();
        if (!u.f2270a.getClass().isInstance(e0)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        u.c();
        U.a(u.b, (AbstractC3169a0) ((AbstractC3171b) e0));
        return u.b();
    }
}

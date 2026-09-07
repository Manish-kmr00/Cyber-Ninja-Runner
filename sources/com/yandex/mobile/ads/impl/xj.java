package com.yandex.mobile.ads.impl;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes6.dex */
public final class xj {
    @JvmStatic
    public static final byte[] a(String str) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
            try {
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    byte[] bytes = ByteStreamsKt.readBytes(gZIPInputStream);
                    CloseableKt.closeFinally(gZIPInputStream, null);
                    CloseableKt.closeFinally(byteArrayInputStream, null);
                    objM7904constructorimpl = Result.m7904constructorimpl(bytes);
                    if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
                        objM7904constructorimpl = new byte[0];
                    }
                    return (byte[]) objM7904constructorimpl;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(gZIPInputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(byteArrayInputStream, th3);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th5));
        }
    }

    @JvmStatic
    public static final String b(String str) {
        Object objM7904constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArrDecode = Base64.decode(str, 0);
            Intrinsics.checkNotNull(bArrDecode);
            Charset charset = Charsets.UTF_8;
            objM7904constructorimpl = Result.m7904constructorimpl(new String(a(new String(bArrDecode, charset)), charset));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7907exceptionOrNullimpl(objM7904constructorimpl) != null) {
            objM7904constructorimpl = "";
        }
        return (String) objM7904constructorimpl;
    }
}

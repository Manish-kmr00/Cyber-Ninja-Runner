package com.ogury.core.internal;

import com.ogury.core.internal.network.CloseableUtilKt;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GzipUtil.kt */
/* JADX INFO: loaded from: classes12.dex */
public final class f {
    public static final byte[] a(String str) throws Exception {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = str.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            gZIPOutputStream.write(bytes);
            CloseableUtilKt.closeSafely(gZIPOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
            return byteArray;
        } catch (Throwable th) {
            CloseableUtilKt.closeSafely(gZIPOutputStream);
            throw th;
        }
    }
}

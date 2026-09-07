package com.yandex.mobile.ads.impl;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes10.dex */
public abstract class rp1 {

    public static final class a {
        public static qp1 a(byte[] bArr) {
            int length = bArr.length;
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            long length2 = bArr.length;
            long j = 0;
            long j2 = length;
            byte[] bArr2 = y82.f10712a;
            if ((j | j2) < 0 || j > length2 || length2 - j < j2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return new qp1(null, bArr, length, 0);
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    public abstract long a() throws IOException;

    public abstract void a(BufferedSink bufferedSink) throws IOException;

    public abstract yw0 b();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"com.monetization.ads.embedded.okhttp.src.main.kotlin.okhttplib.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final qp1 a(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        int length = content.length;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(content, "<this>");
        long length2 = content.length;
        long j = 0;
        long j2 = length;
        byte[] bArr = y82.f10712a;
        if ((j | j2) < 0 || j > length2 || length2 - j < j2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return new qp1(null, content, length, 0);
    }
}

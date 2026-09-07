package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: loaded from: classes4.dex */
public abstract class sq1 implements Closeable {

    public static final class a {
        public static rq1 a(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Buffer bufferWrite = new Buffer().write(bArr);
            long length = bArr.length;
            Intrinsics.checkNotNullParameter(bufferWrite, "<this>");
            return new rq1(length, null, bufferWrite);
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    public abstract long a();

    public abstract yw0 b();

    public abstract BufferedSource c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        y82.a((Closeable) c());
    }
}

package com.apm.insight.k;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: DataWithoutCloseStream.java */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends DataOutputStream {
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    public f(OutputStream outputStream) {
        super(outputStream);
    }

    public final void a() throws IOException {
        super.close();
    }
}

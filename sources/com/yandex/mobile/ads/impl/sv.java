package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class sv extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qv f10239a;
    private final uv b;
    private boolean d = false;
    private boolean e = false;
    private final byte[] c = new byte[1];

    public sv(l22 l22Var, uv uvVar) {
        this.f10239a = l22Var;
        this.b = uvVar;
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] bArr = this.c;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return this.c[0] & 255;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.e) {
            return;
        }
        this.f10239a.close();
        this.e = true;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.e) {
            if (!this.d) {
                this.f10239a.a(this.b);
                this.d = true;
            }
            int i3 = this.f10239a.read(bArr, i, i2);
            if (i3 == -1) {
                return -1;
            }
            return i3;
        }
        throw new IllegalStateException();
    }
}

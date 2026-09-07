package com.bytedance.sdk.component.ML.KZx.pA.pA;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes12.dex */
class KZx implements Closeable {
    private byte[] KZx;
    private int ML;
    private final Charset Og;
    private int ZZv;
    private final InputStream pA;

    public KZx(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public KZx(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(ZZv.pA)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.pA = inputStream;
        this.Og = charset;
        this.KZx = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.pA) {
            if (this.KZx != null) {
                this.KZx = null;
                this.pA.close();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    public String pA() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.pA) {
            if (this.KZx == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.ZZv >= this.ML) {
                KZx();
            }
            for (int i3 = this.ZZv; i3 != this.ML; i3++) {
                byte[] bArr2 = this.KZx;
                if (bArr2[i3] == 10) {
                    if (i3 != this.ZZv) {
                        i2 = i3 - 1;
                        if (bArr2[i2] != 13) {
                            i2 = i3;
                        }
                    } else {
                        i2 = i3;
                    }
                    byte[] bArr3 = this.KZx;
                    int i4 = this.ZZv;
                    String str = new String(bArr3, i4, i2 - i4, this.Og.name());
                    this.ZZv = i3 + 1;
                    return str;
                }
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.ML - this.ZZv) + 80) { // from class: com.bytedance.sdk.component.ML.KZx.pA.pA.KZx.1
                @Override // java.io.ByteArrayOutputStream
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + (-1)] != 13) ? this.count : this.count - 1, KZx.this.Og.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr4 = this.KZx;
                int i5 = this.ZZv;
                byteArrayOutputStream.write(bArr4, i5, this.ML - i5);
                this.ML = -1;
                KZx();
                i = this.ZZv;
                while (i != this.ML) {
                    bArr = this.KZx;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.ZZv;
            if (i != i6) {
                byteArrayOutputStream.write(bArr, i6, i - i6);
            }
            this.ZZv = i + 1;
            return byteArrayOutputStream.toString();
        }
    }

    public boolean Og() {
        return this.ML == -1;
    }

    private void KZx() throws IOException {
        InputStream inputStream = this.pA;
        byte[] bArr = this.KZx;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.ZZv = 0;
        this.ML = i;
    }
}

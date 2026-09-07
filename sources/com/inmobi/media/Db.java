package com.inmobi.media;

import java.io.Closeable;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public final class Db implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileInputStream f3050a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    public Db(FileInputStream fileInputStream, Charset charset) {
        charset.getClass();
        if (!charset.equals(Dc.f3051a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f3050a = fileInputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003e  */
    public final String a() {
        int i;
        synchronized (this.f3050a) {
            byte[] bArr = this.c;
            if (bArr == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                int i2 = this.f3050a.read(bArr, 0, bArr.length);
                if (i2 == -1) {
                    throw new EOFException();
                }
                this.d = 0;
                this.e = i2;
            }
            for (int i3 = this.d; i3 != this.e; i3++) {
                byte[] bArr2 = this.c;
                if (bArr2[i3] == 10) {
                    int i4 = this.d;
                    if (i3 != i4) {
                        i = i3 - 1;
                        if (bArr2[i] != 13) {
                            i = i3;
                        }
                    } else {
                        i = i3;
                    }
                    String str = new String(bArr2, i4, i - i4, this.b.name());
                    this.d = i3 + 1;
                    return str;
                }
            }
            Cb cb = new Cb(this, (this.e - this.d) + 80);
            while (true) {
                byte[] bArr3 = this.c;
                int i5 = this.d;
                cb.write(bArr3, i5, this.e - i5);
                this.e = -1;
                FileInputStream fileInputStream = this.f3050a;
                byte[] bArr4 = this.c;
                int i6 = fileInputStream.read(bArr4, 0, bArr4.length);
                if (i6 == -1) {
                    throw new EOFException();
                }
                this.d = 0;
                this.e = i6;
                for (int i7 = 0; i7 != this.e; i7++) {
                    byte[] bArr5 = this.c;
                    if (bArr5[i7] == 10) {
                        int i8 = this.d;
                        if (i7 != i8) {
                            cb.write(bArr5, i8, i7 - i8);
                        }
                        this.d = i7 + 1;
                        return cb.toString();
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f3050a) {
            if (this.c != null) {
                this.c = null;
                this.f3050a.close();
            }
        }
    }
}

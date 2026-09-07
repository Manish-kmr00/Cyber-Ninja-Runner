package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class um implements pv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final rm f10403a;
    private final long b = 5242880;
    private final int c = 20480;
    private uv d;
    private long e;
    private File f;
    private OutputStream g;
    private long h;
    private long i;
    private hr1 j;

    public um(rm rmVar) {
        this.f10403a = (rm) hg.a(rmVar);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private rm f10404a;

        public final b a(rm rmVar) {
            this.f10404a = rmVar;
            return this;
        }

        public final um a() {
            rm rmVar = this.f10404a;
            rmVar.getClass();
            return new um(rmVar);
        }
    }

    public static final class a extends rm.a {
        public a(IOException iOException) {
            super(iOException);
        }
    }

    @Override // com.yandex.mobile.ads.impl.pv
    public final void write(byte[] bArr, int i, int i2) throws a {
        uv uvVar = this.d;
        if (uvVar == null) {
            return;
        }
        int i3 = 0;
        while (i3 < i2) {
            try {
                if (this.h == this.e) {
                    a();
                    b(uvVar);
                }
                int iMin = (int) Math.min(i2 - i3, this.e - this.h);
                OutputStream outputStream = this.g;
                int i4 = x82.f10629a;
                outputStream.write(bArr, i + i3, iMin);
                i3 += iMin;
                long j = iMin;
                this.h += j;
                this.i += j;
            } catch (IOException e) {
                throw new a(e);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.pv
    public final void close() throws a {
        if (this.d == null) {
            return;
        }
        try {
            a();
        } catch (IOException e) {
            throw new a(e);
        }
    }

    private void b(uv uvVar) throws IOException {
        long j = uvVar.g;
        long jMin = j != -1 ? Math.min(j - this.i, this.e) : -1L;
        rm rmVar = this.f10403a;
        String str = uvVar.h;
        int i = x82.f10629a;
        this.f = rmVar.a(str, uvVar.f + this.i, jMin);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.c > 0) {
            hr1 hr1Var = this.j;
            if (hr1Var == null) {
                this.j = new hr1(fileOutputStream, this.c);
            } else {
                hr1Var.a(fileOutputStream);
            }
            this.g = this.j;
        } else {
            this.g = fileOutputStream;
        }
        this.h = 0L;
    }

    private void a() throws IOException {
        OutputStream outputStream = this.g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            x82.a((Closeable) this.g);
            this.g = null;
            File file = this.f;
            this.f = null;
            this.f10403a.a(file, this.h);
        } catch (Throwable th) {
            x82.a((Closeable) this.g);
            this.g = null;
            File file2 = this.f;
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    @Override // com.yandex.mobile.ads.impl.pv
    public final void a(uv uvVar) throws a {
        uvVar.h.getClass();
        if (uvVar.g == -1 && (uvVar.i & 2) == 2) {
            this.d = null;
            return;
        }
        this.d = uvVar;
        this.e = (uvVar.i & 4) == 4 ? this.b : Long.MAX_VALUE;
        this.i = 0L;
        try {
            b(uvVar);
        } catch (IOException e) {
            throw new a(e);
        }
    }
}

package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.safedk.android.internal.partials.DTExchangeFilesBridge;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2149a;
    public final long b = 10485760;
    public final int c = 20480;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.k d;
    public File e;
    public OutputStream f;
    public FileOutputStream g;
    public long h;
    public long i;
    public p j;

    public c(l lVar) {
        this.f2149a = lVar;
    }

    public final void a() {
        OutputStream outputStream = this.f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.g.getFD().sync();
            z.a(this.f);
            this.f = null;
            File file = this.e;
            this.e = null;
            l lVar = this.f2149a;
            synchronized (lVar) {
                m mVarA = m.a(file, lVar.d);
                if (mVarA == null) {
                    throw new IllegalStateException();
                }
                if (!lVar.c.containsKey(mVarA.f2153a)) {
                    throw new IllegalStateException();
                }
                if (file.exists()) {
                    if (file.length() == 0) {
                        file.delete();
                        return;
                    }
                    long jA = lVar.a(mVarA.f2153a);
                    if (jA != -1 && mVarA.b + mVarA.c > jA) {
                        throw new IllegalStateException();
                    }
                    lVar.a(mVarA);
                    lVar.d.b();
                    lVar.notifyAll();
                }
            }
        } catch (Throwable th) {
            z.a(this.f);
            this.f = null;
            File file2 = this.e;
            this.e = null;
            file2.delete();
            throw th;
        }
    }

    public final void b() throws FileNotFoundException {
        File file;
        long j = this.d.d;
        long jMin = j == -1 ? this.b : Math.min(j - this.i, this.b);
        l lVar = this.f2149a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = this.d;
        String str = kVar.e;
        long j2 = kVar.b + this.i;
        synchronized (lVar) {
            if (!lVar.c.containsKey(str)) {
                throw new IllegalStateException();
            }
            if (!lVar.f2158a.exists()) {
                lVar.a();
                lVar.f2158a.mkdirs();
            }
            lVar.b.a(lVar, jMin);
            File file2 = lVar.f2158a;
            i iVar = lVar.d;
            h hVarA = (h) iVar.f2155a.get(str);
            if (hVarA == null) {
                hVarA = iVar.a(str, -1L);
            }
            int i = hVarA.f2154a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Pattern pattern = m.g;
            file = new File(file2, i + "." + j2 + "." + jCurrentTimeMillis + ".v3.exo");
        }
        this.e = file;
        FileOutputStream fileOutputStreamFileOutputStreamCtor = DTExchangeFilesBridge.fileOutputStreamCtor(this.e);
        this.g = fileOutputStreamFileOutputStreamCtor;
        if (this.c > 0) {
            p pVar = this.j;
            if (pVar == null) {
                this.j = new p(this.g, this.c);
            } else {
                pVar.a(fileOutputStreamFileOutputStreamCtor);
            }
            this.f = this.j;
        } else {
            this.f = fileOutputStreamFileOutputStreamCtor;
        }
        this.h = 0L;
    }
}

package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.E;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: classes12.dex */
public final class e implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2151a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final E c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h d;
    public final boolean e = false;
    public final boolean f = true;
    public final boolean g = false;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.h h;
    public boolean i;
    public Uri j;
    public int k;
    public String l;
    public long m;
    public long n;
    public m o;
    public boolean p;
    public boolean q;

    public e(l lVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar2, c cVar) {
        this.f2151a = lVar;
        this.b = hVar2;
        this.d = hVar;
        if (cVar != null) {
            this.c = new E(hVar, cVar);
        } else {
            this.c = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar) throws IOException {
        try {
            Uri uri = kVar.f2163a;
            this.j = uri;
            this.k = kVar.f;
            String string = kVar.e;
            if (string == null) {
                string = uri.toString();
            }
            this.l = string;
            this.m = kVar.c;
            boolean z = (this.f && this.p) || (kVar.d == -1 && this.g);
            this.q = z;
            long j = kVar.d;
            if (j != -1 || z) {
                this.n = j;
            } else {
                long jA = this.f2151a.a(string);
                this.n = jA;
                if (jA != -1) {
                    long j2 = jA - kVar.c;
                    this.n = j2;
                    if (j2 <= 0) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.i();
                    }
                }
            }
            a(true);
            return this.n;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    public final void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
            this.h = null;
            this.i = false;
            m mVar = this.o;
            if (mVar != null) {
                l lVar = this.f2151a;
                synchronized (lVar) {
                    if (mVar != lVar.c.remove(mVar.f2153a)) {
                        throw new IllegalStateException();
                    }
                    lVar.notifyAll();
                }
                this.o = null;
            }
        } catch (Throwable th) {
            m mVar2 = this.o;
            if (mVar2 != null) {
                this.f2151a.b(mVar2);
                this.o = null;
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() throws IOException {
        this.j = null;
        try {
            b();
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.n == 0) {
            return -1;
        }
        try {
            int i3 = this.h.read(bArr, i, i2);
            if (i3 >= 0) {
                long j = i3;
                this.m += j;
                long j2 = this.n;
                if (j2 != -1) {
                    this.n = j2 - j;
                }
            } else {
                if (this.i) {
                    a(this.m);
                    this.n = 0L;
                }
                b();
                long j3 = this.n;
                if ((j3 > 0 || j3 == -1) && a(false)) {
                    return read(bArr, i, i2);
                }
            }
            return i3;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        return hVar == this.d ? hVar.a() : this.j;
    }

    public final boolean a(boolean z) throws IOException {
        m mVarA;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2;
        long jA;
        IOException iOException = null;
        if (this.q) {
            mVarA = null;
        } else if (this.e) {
            try {
                l lVar = this.f2151a;
                String str = this.l;
                long j = this.m;
                synchronized (lVar) {
                    while (true) {
                        mVarA = lVar.a(str, j);
                        if (mVarA != null) {
                            break;
                        }
                        lVar.wait();
                    }
                }
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            mVarA = this.f2151a.a(this.l, this.m);
        }
        if (mVarA == null) {
            this.h = this.d;
            Uri uri = this.j;
            long j2 = this.m;
            kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri, j2, j2, this.n, this.l, this.k);
        } else {
            if (mVarA.d) {
                Uri uriFromFile = Uri.fromFile(mVarA.e);
                long j3 = this.m - mVarA.b;
                long jMin = mVarA.c - j3;
                long j4 = this.n;
                if (j4 != -1) {
                    jMin = Math.min(jMin, j4);
                }
                kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uriFromFile, this.m, j3, jMin, this.l, this.k);
                this.h = this.b;
            } else {
                long jMin2 = mVarA.c;
                if (jMin2 == -1) {
                    jMin2 = this.n;
                } else {
                    long j5 = this.n;
                    if (j5 != -1) {
                        jMin2 = Math.min(jMin2, j5);
                    }
                }
                Uri uri2 = this.j;
                long j6 = this.m;
                kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri2, j6, j6, jMin2, this.l, this.k);
                E e = this.c;
                if (e != null) {
                    this.h = e;
                    this.o = mVarA;
                } else {
                    this.h = this.d;
                    this.f2151a.b(mVarA);
                }
            }
            kVar2 = kVar;
        }
        boolean z2 = true;
        this.i = kVar2.d == -1;
        try {
            jA = this.h.a(kVar2);
        } catch (IOException e2) {
            if (!z && this.i) {
                Throwable cause = e2;
                while (true) {
                    if (cause == null) {
                        iOException = e2;
                        break;
                    }
                    if ((cause instanceof com.fyber.inneractive.sdk.player.exoplayer2.upstream.i) && ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.i) cause).f2161a == 0) {
                        break;
                    }
                    cause = cause.getCause();
                }
            } else {
                iOException = e2;
                break;
            }
            if (iOException != null) {
                throw iOException;
            }
            z2 = false;
            jA = 0;
        }
        if (this.i && jA != -1) {
            this.n = jA;
            a(kVar2.c + jA);
        }
        return z2;
    }

    public final void a(long j) {
        if (this.h == this.c) {
            l lVar = this.f2151a;
            String str = this.l;
            synchronized (lVar) {
                i iVar = lVar.d;
                h hVar = (h) iVar.f2155a.get(str);
                if (hVar == null) {
                    iVar.a(str, j);
                } else if (hVar.d != j) {
                    hVar.d = j;
                    iVar.f = true;
                }
                lVar.d.b();
            }
        }
    }
}

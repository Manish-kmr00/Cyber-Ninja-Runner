package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okio.r;
import com.mbridge.msdk.thrid.okio.s;
import com.mbridge.msdk.thrid.okio.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: Http2Stream.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    static final /* synthetic */ boolean l = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f5548a = 0;
    long b;
    final int c;
    final g d;
    private final Deque<p> e;
    private boolean f;
    private final b g;
    final a h;
    final c i;
    final c j;
    com.mbridge.msdk.thrid.okhttp.internal.http2.b k;

    /* JADX INFO: compiled from: Http2Stream.java */
    class c extends com.mbridge.msdk.thrid.okio.a {
        c() {
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.mbridge.msdk.thrid.okio.a
        protected void j() {
            i.this.c(com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
            i.this.d.l();
        }

        public void k() throws IOException {
            if (i()) {
                throw b((IOException) null);
            }
        }
    }

    i(int i, g gVar, boolean z, boolean z2, @Nullable p pVar) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        this.i = new c();
        this.j = new c();
        this.k = null;
        if (gVar == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i;
        this.d = gVar;
        this.b = gVar.u.c();
        b bVar = new b(gVar.t.c());
        this.g = bVar;
        a aVar = new a();
        this.h = aVar;
        bVar.e = z2;
        aVar.c = z;
        if (pVar != null) {
            arrayDeque.add(pVar);
        }
        if (f() && pVar != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!f() && pVar == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    static /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.c.a b(i iVar) {
        iVar.getClass();
        return null;
    }

    public int c() {
        return this.c;
    }

    public r d() {
        synchronized (this) {
            if (!this.f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    public s e() {
        return this.g;
    }

    public boolean f() {
        return this.d.f5543a == ((this.c & 1) == 1);
    }

    public synchronized boolean g() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.e || bVar.d) {
            a aVar = this.h;
            if ((aVar.c || aVar.b) && this.f) {
                return false;
            }
        }
        return true;
    }

    public t h() {
        return this.i;
    }

    void i() {
        boolean zG;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.g.e = true;
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.d.c(this.c);
    }

    public synchronized p j() throws IOException {
        this.i.h();
        while (this.e.isEmpty() && this.k == null) {
            try {
                k();
            } catch (Throwable th) {
                this.i.k();
                throw th;
            }
        }
        this.i.k();
        if (this.e.isEmpty()) {
            throw new n(this.k);
        }
        return this.e.removeFirst();
    }

    void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.j;
    }

    private boolean b(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.e && this.h.c) {
                return false;
            }
            this.k = bVar;
            notifyAll();
            this.d.c(this.c);
            return true;
        }
    }

    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        if (b(bVar)) {
            this.d.b(this.c, bVar);
        }
    }

    public void c(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (b(bVar)) {
            this.d.c(this.c, bVar);
        }
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    final class a implements r {
        static final /* synthetic */ boolean e = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f5549a = new com.mbridge.msdk.thrid.okio.c();
        boolean b;
        boolean c;

        a() {
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            if (!e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.f5549a.a(cVar, j);
            while (this.f5549a.size() >= 16384) {
                a(false);
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r
        public t b() {
            return i.this.j;
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.b) {
                    return;
                }
                if (!i.this.h.c) {
                    if (this.f5549a.size() > 0) {
                        while (this.f5549a.size() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.d.a(iVar.c, true, (com.mbridge.msdk.thrid.okio.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.b = true;
                }
                i.this.d.flush();
                i.this.a();
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.r, java.io.Flushable
        public void flush() throws IOException {
            if (!e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.b();
            }
            while (this.f5549a.size() > 0) {
                a(false);
                i.this.d.flush();
            }
        }

        private void a(boolean z) throws IOException {
            i iVar;
            long jMin;
            i iVar2;
            synchronized (i.this) {
                i.this.j.h();
                while (true) {
                    try {
                        iVar = i.this;
                        if (iVar.b > 0 || this.c || this.b || iVar.k != null) {
                            break;
                        } else {
                            iVar.k();
                        }
                    } catch (Throwable th) {
                        i.this.j.k();
                        throw th;
                    }
                }
                iVar.j.k();
                i.this.b();
                jMin = Math.min(i.this.b, this.f5549a.size());
                iVar2 = i.this;
                iVar2.b -= jMin;
            }
            iVar2.j.h();
            try {
                i iVar3 = i.this;
                iVar3.d.a(iVar3.c, z && jMin == this.f5549a.size(), this.f5549a, jMin);
            } finally {
                i.this.j.k();
            }
        }
    }

    void a(List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
        boolean zG;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f = true;
            this.e.add(com.mbridge.msdk.thrid.okhttp.internal.c.b(list));
            zG = g();
            notifyAll();
        }
        if (zG) {
            return;
        }
        this.d.c(this.c);
    }

    synchronized void d(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        if (this.k == null) {
            this.k = bVar;
            notifyAll();
        }
    }

    void b() throws IOException {
        a aVar = this.h;
        if (!aVar.b) {
            if (!aVar.c) {
                if (this.k != null) {
                    throw new n(this.k);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    void a(com.mbridge.msdk.thrid.okio.e eVar, int i) throws IOException {
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.g.a(eVar, i);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0028  */
    void a() throws IOException {
        boolean z;
        boolean zG;
        if (!l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            b bVar = this.g;
            if (bVar.e || !bVar.d) {
                z = false;
            } else {
                a aVar = this.h;
                if (aVar.c || aVar.b) {
                    z = true;
                } else {
                    z = false;
                }
            }
            zG = g();
        }
        if (z) {
            a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
        } else {
            if (zG) {
                return;
            }
            this.d.c(this.c);
        }
    }

    void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* JADX INFO: compiled from: Http2Stream.java */
    private final class b implements s {
        static final /* synthetic */ boolean g = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.thrid.okio.c f5550a = new com.mbridge.msdk.thrid.okio.c();
        private final com.mbridge.msdk.thrid.okio.c b = new com.mbridge.msdk.thrid.okio.c();
        private final long c;
        boolean d;
        boolean e;

        b(long j) {
            this.c = j;
        }

        private void f(long j) {
            if (!g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            i.this.d.g(j);
        }

        void a(com.mbridge.msdk.thrid.okio.e eVar, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long size;
            if (!g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j > 0) {
                synchronized (i.this) {
                    z = this.e;
                    z2 = true;
                    z3 = this.b.size() + j > this.c;
                }
                if (z3) {
                    eVar.skip(j);
                    i.this.c(com.mbridge.msdk.thrid.okhttp.internal.http2.b.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    eVar.skip(j);
                    return;
                }
                long jB = eVar.b(this.f5550a, j);
                if (jB == -1) {
                    throw new EOFException();
                }
                j -= jB;
                synchronized (i.this) {
                    if (this.d) {
                        size = this.f5550a.size();
                        this.f5550a.k();
                    } else {
                        if (this.b.size() != 0) {
                            z2 = false;
                        }
                        this.b.a(this.f5550a);
                        if (z2) {
                            i.this.notifyAll();
                        }
                        size = 0;
                    }
                }
                if (size > 0) {
                    f(size);
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:35:0x008e  */
        /* JADX WARN: Code duplicated, block: B:37:0x0092 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x0094 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:39:0x0095  */
        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar;
            long jB;
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            while (true) {
                synchronized (i.this) {
                    i.this.i.h();
                    try {
                        i iVar = i.this;
                        bVar = iVar.k;
                        if (bVar == null) {
                            bVar = null;
                        }
                        if (this.d) {
                            throw new IOException("stream closed");
                        }
                        if (!iVar.e.isEmpty()) {
                            i.b(i.this);
                        }
                        if (this.b.size() > 0) {
                            com.mbridge.msdk.thrid.okio.c cVar2 = this.b;
                            jB = cVar2.b(cVar, Math.min(j, cVar2.size()));
                            i iVar2 = i.this;
                            long j2 = iVar2.f5548a + jB;
                            iVar2.f5548a = j2;
                            if (bVar != null || j2 < iVar2.d.t.c() / 2) {
                                break;
                                break;
                            }
                            i iVar3 = i.this;
                            iVar3.d.a(iVar3.c, iVar3.f5548a);
                            i.this.f5548a = 0L;
                            break;
                        }
                        if (this.e || bVar != null) {
                            jB = -1;
                            break;
                        }
                        i.this.k();
                        i.this.i.k();
                    } catch (Throwable th) {
                        i.this.i.k();
                        throw th;
                    }
                }
                if (jB != -1) {
                    f(jB);
                    return jB;
                }
                if (bVar == null) {
                    return -1L;
                }
                throw new n(bVar);
            }
            i.this.i.k();
            if (jB != -1) {
                f(jB);
                return jB;
            }
            if (bVar == null) {
                return -1L;
            }
            throw new n(bVar);
        }

        @Override // com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (i.this) {
                this.d = true;
                size = this.b.size();
                this.b.k();
                if (!i.this.e.isEmpty()) {
                    i.b(i.this);
                }
                i.this.notifyAll();
            }
            if (size > 0) {
                f(size);
            }
            i.this.a();
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public t b() {
            return i.this.i;
        }
    }
}

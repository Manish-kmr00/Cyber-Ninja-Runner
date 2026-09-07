package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes11.dex */
public final class lh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9517a;
    private final eh0 b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final ArrayDeque<nf0> g;
    private boolean h;
    private final b i;
    private final a j;
    private final c k;
    private final c l;
    private q50 m;
    private IOException n;

    public final class b implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f9519a;
        private boolean b;
        private final Buffer c = new Buffer();
        private final Buffer d = new Buffer();
        private boolean e;

        @Override // okio.Source
        public final long read(Buffer sink, long j) throws IOException {
            IOException iOExceptionE;
            boolean z;
            long j2;
            Intrinsics.checkNotNullParameter(sink, "sink");
            long j3 = 0;
            if (j < 0) {
                throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
            }
            while (true) {
                lh0 lh0Var = lh0.this;
                synchronized (lh0Var) {
                    lh0Var.i().enter();
                    try {
                        if (lh0Var.d() != null) {
                            iOExceptionE = lh0Var.e();
                            if (iOExceptionE == null) {
                                q50 q50VarD = lh0Var.d();
                                Intrinsics.checkNotNull(q50VarD);
                                iOExceptionE = new s22(q50VarD);
                            }
                        } else {
                            iOExceptionE = null;
                        }
                        if (this.e) {
                            throw new IOException("stream closed");
                        }
                        z = false;
                        if (this.d.size() > j3) {
                            Buffer buffer = this.d;
                            j2 = buffer.read(sink, Math.min(j, buffer.size()));
                            lh0Var.c(lh0Var.h() + j2);
                            long jH = lh0Var.h() - lh0Var.g();
                            if (iOExceptionE == null && jH >= lh0Var.c().g().b() / 2) {
                                lh0Var.c().a(lh0Var.f(), jH);
                                lh0Var.b(lh0Var.h());
                            }
                        } else {
                            if (!this.b && iOExceptionE == null) {
                                lh0Var.t();
                                z = true;
                            }
                            j2 = -1;
                        }
                        lh0Var.i().a();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        lh0Var.i().a();
                        throw th;
                    }
                }
                if (!z) {
                    if (j2 != -1) {
                        a(j2);
                        return j2;
                    }
                    if (iOExceptionE == null) {
                        return -1L;
                    }
                    throw iOExceptionE;
                }
                j3 = 0;
            }
        }

        public final void c() {
            this.b = true;
        }

        public b(long j, boolean z) {
            this.f9519a = j;
            this.b = z;
        }

        public final boolean b() {
            return this.b;
        }

        public final boolean a() {
            return this.e;
        }

        public final void a(BufferedSource source, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            long size;
            Intrinsics.checkNotNullParameter(source, "source");
            lh0 lh0Var = lh0.this;
            if (y82.f && Thread.holdsLock(lh0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lh0Var);
            }
            while (j > 0) {
                synchronized (lh0.this) {
                    z = this.b;
                    z2 = true;
                    z3 = this.d.size() + j > this.f9519a;
                    Unit unit = Unit.INSTANCE;
                }
                if (z3) {
                    source.skip(j);
                    lh0.this.a(q50.g);
                    return;
                }
                if (z) {
                    source.skip(j);
                    return;
                }
                long j2 = source.read(this.c, j);
                if (j2 != -1) {
                    j -= j2;
                    lh0 lh0Var2 = lh0.this;
                    synchronized (lh0Var2) {
                        if (this.e) {
                            size = this.c.size();
                            this.c.clear();
                        } else {
                            if (this.d.size() != 0) {
                                z2 = false;
                            }
                            this.d.writeAll(this.c);
                            if (z2) {
                                Intrinsics.checkNotNull(lh0Var2, "null cannot be cast to non-null type java.lang.Object");
                                lh0Var2.notifyAll();
                            }
                            size = 0;
                        }
                    }
                    if (size > 0) {
                        a(size);
                    }
                } else {
                    throw new EOFException();
                }
            }
        }

        @Override // okio.Source
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return lh0.this.i();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            long size;
            lh0 lh0Var = lh0.this;
            synchronized (lh0Var) {
                this.e = true;
                size = this.d.size();
                this.d.clear();
                Intrinsics.checkNotNull(lh0Var, "null cannot be cast to non-null type java.lang.Object");
                lh0Var.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            if (size > 0) {
                a(size);
            }
            lh0.this.a();
        }

        private final void a(long j) {
            lh0 lh0Var = lh0.this;
            if (y82.f && Thread.holdsLock(lh0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lh0Var);
            }
            lh0.this.c().b(j);
        }
    }

    public lh0(int i, eh0 connection, boolean z, boolean z2, nf0 nf0Var) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.f9517a = i;
        this.b = connection;
        this.f = connection.h().b();
        ArrayDeque<nf0> arrayDeque = new ArrayDeque<>();
        this.g = arrayDeque;
        this.i = new b(connection.g().b(), z2);
        this.j = new a(z);
        this.k = new c();
        this.l = new c();
        if (nf0Var == null) {
            if (!p()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (p()) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(nf0Var);
        }
    }

    public final a j() {
        synchronized (this) {
            if (!this.h && !p()) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return this.j;
    }

    public final c r() {
        return this.k;
    }

    public final c u() {
        return this.l;
    }

    public final int f() {
        return this.f9517a;
    }

    public final eh0 c() {
        return this.b;
    }

    public final long h() {
        return this.c;
    }

    public final long g() {
        return this.d;
    }

    public final long n() {
        return this.e;
    }

    public final long m() {
        return this.f;
    }

    public final b l() {
        return this.i;
    }

    public final a k() {
        return this.j;
    }

    public final c i() {
        return this.k;
    }

    public final c o() {
        return this.l;
    }

    public final synchronized q50 d() {
        return this.m;
    }

    public final IOException e() {
        return this.n;
    }

    public final void c(long j) {
        this.c = j;
    }

    public final synchronized boolean q() {
        if (this.m != null) {
            return false;
        }
        return ((this.i.b() || this.i.a()) && (this.j.b() || this.j.a()) && this.h) ? false : true;
    }

    public final boolean p() {
        return this.b.b() == ((this.f9517a & 1) == 1);
    }

    public final synchronized nf0 s() throws IOException {
        nf0 nf0VarRemoveFirst;
        this.k.enter();
        while (this.g.isEmpty() && this.m == null) {
            try {
                t();
            } catch (Throwable th) {
                this.k.a();
                throw th;
            }
        }
        this.k.a();
        if (!this.g.isEmpty()) {
            nf0VarRemoveFirst = this.g.removeFirst();
            Intrinsics.checkNotNullExpressionValue(nf0VarRemoveFirst, "removeFirst(...)");
        } else {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            q50 q50Var = this.m;
            Intrinsics.checkNotNull(q50Var);
            throw new s22(q50Var);
        }
        return nf0VarRemoveFirst;
    }

    public final void d(long j) {
        this.e = j;
    }

    public final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9518a;
        private final Buffer b = new Buffer();
        private boolean c;

        @Override // okio.Sink
        public final void write(Buffer source, long j) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            lh0 lh0Var = lh0.this;
            if (y82.f && Thread.holdsLock(lh0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lh0Var);
            }
            this.b.write(source, j);
            while (this.b.size() >= 16384) {
                a(false);
            }
        }

        public a(boolean z) {
            this.f9518a = z;
        }

        public final boolean b() {
            return this.f9518a;
        }

        private final void a(boolean z) throws IOException {
            long jMin;
            boolean z2;
            lh0 lh0Var = lh0.this;
            synchronized (lh0Var) {
                lh0Var.o().enter();
                while (lh0Var.n() >= lh0Var.m() && !this.f9518a && !this.c && lh0Var.d() == null) {
                    try {
                        lh0Var.t();
                    } catch (Throwable th) {
                        lh0Var.o().a();
                        throw th;
                    }
                }
                lh0Var.o().a();
                lh0Var.b();
                jMin = Math.min(lh0Var.m() - lh0Var.n(), this.b.size());
                lh0Var.d(lh0Var.n() + jMin);
                z2 = z && jMin == this.b.size();
                Unit unit = Unit.INSTANCE;
            }
            lh0.this.o().enter();
            try {
                lh0.this.c().a(lh0.this.f(), z2, this.b, jMin);
            } finally {
                lh0.this.o().a();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public final void flush() throws IOException {
            lh0 lh0Var = lh0.this;
            if (y82.f && Thread.holdsLock(lh0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lh0Var);
            }
            lh0 lh0Var2 = lh0.this;
            synchronized (lh0Var2) {
                lh0Var2.b();
                Unit unit = Unit.INSTANCE;
            }
            while (this.b.size() > 0) {
                a(false);
                lh0.this.c().flush();
            }
        }

        @Override // okio.Sink
        /* JADX INFO: renamed from: timeout */
        public final Timeout getTimeout() {
            return lh0.this.o();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            lh0 lh0Var = lh0.this;
            if (y82.f && Thread.holdsLock(lh0Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + lh0Var);
            }
            lh0 lh0Var2 = lh0.this;
            synchronized (lh0Var2) {
                if (this.c) {
                    return;
                }
                boolean z = lh0Var2.d() == null;
                Unit unit = Unit.INSTANCE;
                if (!lh0.this.k().f9518a) {
                    if (this.b.size() > 0) {
                        while (this.b.size() > 0) {
                            a(true);
                        }
                    } else if (z) {
                        lh0.this.c().a(lh0.this.f(), true, (Buffer) null, 0L);
                    }
                }
                synchronized (lh0.this) {
                    this.c = true;
                    Unit unit2 = Unit.INSTANCE;
                }
                lh0.this.c().flush();
                lh0.this.a();
            }
        }

        public final boolean a() {
            return this.c;
        }
    }

    public final void a(long j) {
        this.f += j;
        if (j > 0) {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final void b() throws IOException {
        if (!this.j.a()) {
            if (!this.j.b()) {
                if (this.m != null) {
                    IOException iOException = this.n;
                    if (iOException != null) {
                        throw iOException;
                    }
                    q50 q50Var = this.m;
                    Intrinsics.checkNotNull(q50Var);
                    throw new s22(q50Var);
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final synchronized void b(q50 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (this.m == null) {
            this.m = errorCode;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    public final class c extends AsyncTimeout {
        public c() {
        }

        @Override // okio.AsyncTimeout
        protected final void timedOut() {
            lh0.this.a(q50.i);
            lh0.this.c().l();
        }

        @Override // okio.AsyncTimeout
        protected final IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void a() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }
    }

    public final void a(q50 rstStatusCode, IOException iOException) throws IOException {
        Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
        if (b(rstStatusCode, iOException)) {
            this.b.b(this.f9517a, rstStatusCode);
        }
    }

    public final void t() throws InterruptedIOException {
        try {
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void a(q50 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        if (b(errorCode, null)) {
            this.b.c(this.f9517a, errorCode);
        }
    }

    public final void a(BufferedSource source, int i) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        this.i.a(source, i);
    }

    public final void b(long j) {
        this.d = j;
    }

    private final boolean b(q50 q50Var, IOException iOException) {
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.m != null) {
                return false;
            }
            if (this.i.b() && this.j.b()) {
                return false;
            }
            this.m = q50Var;
            this.n = iOException;
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.INSTANCE;
            this.b.c(this.f9517a);
            return true;
        }
    }

    public final void a(nf0 headers, boolean z) {
        boolean zQ;
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.h && z) {
                this.i.getClass();
            } else {
                this.h = true;
                this.g.add(headers);
            }
            if (z) {
                this.i.c();
            }
            zQ = q();
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
            Unit unit = Unit.INSTANCE;
        }
        if (zQ) {
            return;
        }
        this.b.c(this.f9517a);
    }

    public final void a() throws IOException {
        boolean z;
        boolean zQ;
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z = !this.i.b() && this.i.a() && (this.j.b() || this.j.a());
            zQ = q();
            Unit unit = Unit.INSTANCE;
        }
        if (!z) {
            if (zQ) {
                return;
            }
            this.b.c(this.f9517a);
        } else {
            q50 rstStatusCode = q50.i;
            Intrinsics.checkNotNullParameter(rstStatusCode, "rstStatusCode");
            if (b(rstStatusCode, null)) {
                this.b.b(this.f9517a, rstStatusCode);
            }
        }
    }
}

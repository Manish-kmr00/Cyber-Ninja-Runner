package com.yandex.mobile.ads.impl;

import androidx.core.app.NotificationCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;

/* JADX INFO: loaded from: classes7.dex */
public final class sn1 implements mn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final be1 f10223a;
    private final op1 b;
    private final boolean c;
    private final vn1 d;
    private final t50 e;
    private final c f;
    private final AtomicBoolean g;
    private Object h;
    private a60 i;
    private tn1 j;
    private boolean k;
    private y50 l;
    private boolean m;
    private boolean n;
    private boolean o;
    private volatile boolean p;
    private volatile y50 q;
    private volatile tn1 r;

    public sn1(be1 client, op1 originalRequest, boolean z) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        this.f10223a = client;
        this.b = originalRequest;
        this.c = z;
        this.d = client.f().a();
        this.e = client.k().a(this);
        c cVar = new c();
        client.getClass();
        cVar.timeout(0, TimeUnit.MILLISECONDS);
        this.f = cVar;
        this.g = new AtomicBoolean();
        this.o = true;
    }

    public final Object clone() {
        return new sn1(this.f10223a, this.b, this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String o() {
        return (this.p ? "canceled " : "") + (this.c ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + this.b.g().j();
    }

    public final void a(tn1 connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        if (y82.f && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (this.j == null) {
            this.j = connection;
            connection.b().add(new b(this, this.h));
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final be1 c() {
        return this.f10223a;
    }

    public final op1 h() {
        return this.b;
    }

    public final boolean f() {
        return this.c;
    }

    public final t50 e() {
        return this.e;
    }

    public static final class c extends AsyncTimeout {
        c() {
        }

        @Override // okio.AsyncTimeout
        protected final void timedOut() {
            sn1.this.a();
        }
    }

    public final tn1 d() {
        return this.j;
    }

    public final y50 g() {
        return this.l;
    }

    public final boolean j() {
        return this.p;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009b  */
    public final oq1 i() throws Throwable {
        ArrayList arrayList = new ArrayList();
        CollectionsKt.addAll(arrayList, this.f10223a.p());
        arrayList.add(new fr1(this.f10223a));
        arrayList.add(new cm(this.f10223a.h()));
        this.f10223a.getClass();
        arrayList.add(new cn());
        arrayList.add(lr.f9562a);
        if (!this.c) {
            CollectionsKt.addAll(arrayList, this.f10223a.q());
        }
        arrayList.add(new nn(this.c));
        boolean z = false;
        try {
            oq1 oq1VarA = new wn1(this, arrayList, 0, null, this.b, this.f10223a.e(), this.f10223a.u(), this.f10223a.z()).a(this.b);
            if (!this.p) {
                b((IOException) null);
                return oq1VarA;
            }
            y82.a((Closeable) oq1VarA);
            throw new IOException("Canceled");
        } catch (IOException e) {
            try {
                IOException iOExceptionB = b(e);
                Intrinsics.checkNotNull(iOExceptionB, "null cannot be cast to non-null type kotlin.Throwable");
                throw iOExceptionB;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    b((IOException) null);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z) {
                b((IOException) null);
            }
            throw th;
        }
    }

    public final oq1 b() {
        if (this.g.compareAndSet(false, true)) {
            this.f.enter();
            this.h = nh1.f9731a.b();
            this.e.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
            try {
                this.f10223a.i().a(this);
                return i();
            } finally {
                this.f10223a.i().b(this);
            }
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final Socket l() {
        tn1 tn1Var = this.j;
        Intrinsics.checkNotNull(tn1Var);
        if (y82.f && !Thread.holdsLock(tn1Var)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + tn1Var);
        }
        ArrayList arrayListB = tn1Var.b();
        Iterator it = arrayListB.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(((Reference) it.next()).get(), this)) {
                break;
            }
            i++;
        }
        if (i != -1) {
            arrayListB.remove(i);
            this.j = null;
            if (arrayListB.isEmpty()) {
                tn1Var.a(System.nanoTime());
                if (this.d.a(tn1Var)) {
                    return tn1Var.m();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void n() {
        if (!this.k) {
            this.k = true;
            this.f.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final boolean m() {
        a60 a60Var = this.i;
        Intrinsics.checkNotNull(a60Var);
        return a60Var.b();
    }

    public final String k() {
        return this.b.g().j();
    }

    public final class a implements Runnable {
        private final un b;
        private volatile AtomicInteger c;
        final /* synthetic */ sn1 d;

        public a(sn1 sn1Var, un responseCallback) {
            Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
            this.d = sn1Var;
            this.b = responseCallback;
            this.c = new AtomicInteger(0);
        }

        public final void a(ExecutorService executorService) {
            Intrinsics.checkNotNullParameter(executorService, "executorService");
            p10 p10VarI = this.d.c().i();
            if (y82.f && Thread.holdsLock(p10VarI)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + p10VarI);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.d.b(interruptedIOException);
                    this.b.a(interruptedIOException);
                    this.d.c().i().b(this);
                }
            } catch (Throwable th) {
                this.d.c().i().b(this);
                throw th;
            }
        }

        public final AtomicInteger b() {
            return this.c;
        }

        public final String c() {
            return this.d.h().g().g();
        }

        @Override // java.lang.Runnable
        public final void run() {
            p10 p10VarI;
            String str = "OkHttp " + this.d.k();
            sn1 sn1Var = this.d;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(str);
            try {
                sn1Var.f.enter();
                boolean z = false;
                try {
                    try {
                        try {
                            this.b.a(sn1Var.i());
                            p10VarI = sn1Var.c().i();
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (z) {
                                int i = nh1.c;
                                nh1 nh1VarA = nh1.a.a();
                                String str2 = "Callback failure for " + sn1Var.o();
                                nh1VarA.getClass();
                                nh1.a(4, str2, e);
                            } else {
                                this.b.a(e);
                            }
                            p10VarI = sn1Var.c().i();
                        } catch (Throwable th) {
                            th = th;
                            z = true;
                            sn1Var.a();
                            if (!z) {
                                IOException iOException = new IOException("canceled due to " + th);
                                ExceptionsKt.addSuppressed(iOException, th);
                                this.b.a(iOException);
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    p10VarI.b(this);
                    threadCurrentThread.setName(name);
                } catch (Throwable th3) {
                    sn1Var.c().i().b(this);
                    throw th3;
                }
            } catch (Throwable th4) {
                threadCurrentThread.setName(name);
                throw th4;
            }
        }

        public final sn1 a() {
            return this.d;
        }

        public final void a(a other) {
            Intrinsics.checkNotNullParameter(other, "other");
            this.c = other.c;
        }
    }

    public final IOException b(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.o) {
                this.o = false;
                if (!this.m && !this.n) {
                    z = true;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return z ? a(iOException) : iOException;
    }

    public static final class b extends WeakReference<sn1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f10224a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sn1 referent, Object obj) {
            super(referent);
            Intrinsics.checkNotNullParameter(referent, "referent");
            this.f10224a = obj;
        }

        public final Object a() {
            return this.f10224a;
        }
    }

    public final void b(tn1 tn1Var) {
        this.r = tn1Var;
    }

    public final void a() {
        if (this.p) {
            return;
        }
        this.p = true;
        y50 y50Var = this.q;
        if (y50Var != null) {
            y50Var.a();
        }
        tn1 tn1Var = this.r;
        if (tn1Var != null) {
            tn1Var.a();
        }
        this.e.getClass();
        Intrinsics.checkNotNullParameter(this, "call");
    }

    public final void a(un responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        if (this.g.compareAndSet(false, true)) {
            this.h = nh1.f9731a.b();
            this.e.getClass();
            Intrinsics.checkNotNullParameter(this, "call");
            this.f10223a.i().a(new a(this, responseCallback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void a(op1 request, boolean z) {
        SSLSocketFactory sSLSocketFactoryX;
        ae1 ae1VarO;
        eo eoVarD;
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.l == null) {
            synchronized (this) {
                if (!this.n) {
                    if (!this.m) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                }
            }
            if (z) {
                vn1 vn1Var = this.d;
                di0 di0VarG = request.g();
                if (di0VarG.h()) {
                    sSLSocketFactoryX = this.f10223a.x();
                    ae1VarO = this.f10223a.o();
                    eoVarD = this.f10223a.d();
                } else {
                    sSLSocketFactoryX = null;
                    ae1VarO = null;
                    eoVarD = null;
                }
                String strG = di0VarG.g();
                int i = di0VarG.i();
                n30 n30VarJ = this.f10223a.j();
                SocketFactory socketFactoryW = this.f10223a.w();
                bi biVarS = this.f10223a.s();
                this.f10223a.getClass();
                this.i = new a60(vn1Var, new ab(strG, i, n30VarJ, socketFactoryW, sSLSocketFactoryX, ae1VarO, eoVarD, biVarS, this.f10223a.r(), this.f10223a.g(), this.f10223a.t()), this, this.e);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void a(boolean z) {
        y50 y50Var;
        synchronized (this) {
            if (this.o) {
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z && (y50Var = this.q) != null) {
            y50Var.b();
        }
        this.l = null;
    }

    public final y50 a(wn1 chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        synchronized (this) {
            if (this.o) {
                if (!this.n) {
                    if (!this.m) {
                        Unit unit = Unit.INSTANCE;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        a60 a60Var = this.i;
        Intrinsics.checkNotNull(a60Var);
        y50 y50Var = new y50(this, this.e, a60Var, a60Var.a(this.f10223a, chain));
        this.l = y50Var;
        this.q = y50Var;
        synchronized (this) {
            this.m = true;
            this.n = true;
        }
        if (this.p) {
            throw new IOException("Canceled");
        }
        return y50Var;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0021 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0025 A[Catch: all -> 0x0017, TryCatch #0 {all -> 0x0017, blocks: (B:8:0x0012, B:17:0x0021, B:19:0x0025, B:20:0x0027, B:22:0x002c, B:27:0x0035, B:29:0x0039, B:34:0x0042, B:14:0x001b), top: B:46:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0032  */
    public final <E extends IOException> E a(y50 exchange, boolean z, boolean z2, E e) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        if (!Intrinsics.areEqual(exchange, this.q)) {
            return e;
        }
        synchronized (this) {
            z3 = false;
            if (z) {
                try {
                    if (!this.m) {
                        if (z2 || !this.n) {
                            z4 = false;
                        } else {
                            if (z) {
                                this.m = false;
                            }
                            if (z2) {
                                this.n = false;
                            }
                            z5 = this.m;
                            if (!z5 || this.n) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            if (!z5 && !this.n && !this.o) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        }
                    } else {
                        if (z) {
                            this.m = false;
                        }
                        if (z2) {
                            this.n = false;
                        }
                        z5 = this.m;
                        if (z5) {
                            z6 = false;
                        } else {
                            z6 = false;
                        }
                        if (!z5) {
                            z3 = true;
                        }
                        z4 = z3;
                        z3 = z6;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z2) {
                }
                z4 = false;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (z3) {
            this.q = null;
            tn1 tn1Var = this.j;
            if (tn1Var != null) {
                tn1Var.g();
            }
        }
        return z4 ? (E) a(e) : e;
    }

    private final <E extends IOException> E a(E e) {
        E interruptedIOException;
        Socket socketL;
        boolean z = y82.f;
        if (z && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        tn1 tn1Var = this.j;
        if (tn1Var != null) {
            if (z && Thread.holdsLock(tn1Var)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + tn1Var);
            }
            synchronized (tn1Var) {
                socketL = l();
            }
            if (this.j == null) {
                if (socketL != null) {
                    y82.a(socketL);
                }
                this.e.getClass();
                t50.a(this, tn1Var);
            } else if (socketL != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        if (!this.k && this.f.exit()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            t50 t50Var = this.e;
            Intrinsics.checkNotNull(interruptedIOException);
            t50Var.getClass();
            t50.a(this, interruptedIOException);
        } else {
            this.e.getClass();
            t50.a((mn) this);
        }
        return interruptedIOException;
    }
}

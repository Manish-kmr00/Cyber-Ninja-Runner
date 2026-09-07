package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http2Connection.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Closeable {
    static final /* synthetic */ boolean A = true;
    private static final ExecutorService z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Http2Connection", true));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f5543a;
    final j b;
    final String d;
    int e;
    int f;
    private boolean g;
    private final ScheduledExecutorService h;
    private final ExecutorService i;
    final com.mbridge.msdk.thrid.okhttp.internal.http2.l j;
    long s;
    final m u;
    final Socket v;
    final com.mbridge.msdk.thrid.okhttp.internal.http2.j w;
    final l x;
    final Set<Integer> y;
    final Map<Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.i> c = new LinkedHashMap();
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    long r = 0;
    m t = new m();

    /* JADX INFO: compiled from: Http2Connection.java */
    class a extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, Object[] objArr, int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            super(str, objArr);
            this.b = i;
            this.c = bVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                g.this.b(this.b, this.c);
            } catch (IOException unused) {
                g.this.h();
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class b extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.b = i;
            this.c = j;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                g.this.w.a(this.b, this.c);
            } catch (IOException unused) {
                g.this.h();
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class c extends com.mbridge.msdk.thrid.okhttp.internal.b {
        c(String str, Object... objArr) {
            super(str, objArr);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.a(false, 2, 0);
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class d extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.b = i;
            this.c = list;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            if (g.this.j.a(this.b, this.c)) {
                try {
                    g.this.w.a(this.b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                    synchronized (g.this) {
                        try {
                            g.this.y.remove(Integer.valueOf(this.b));
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class e extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ List c;
        final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.b = i;
            this.c = list;
            this.d = z;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            boolean zA = g.this.j.a(this.b, this.c, this.d);
            if (zA) {
                try {
                    g.this.w.a(this.b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (zA || this.d) {
                synchronized (g.this) {
                    try {
                        g.this.y.remove(Integer.valueOf(this.b));
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class f extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ com.mbridge.msdk.thrid.okio.c c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(String str, Object[] objArr, int i, com.mbridge.msdk.thrid.okio.c cVar, int i2, boolean z) {
            super(str, objArr);
            this.b = i;
            this.c = cVar;
            this.d = i2;
            this.e = z;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            try {
                boolean zA = g.this.j.a(this.b, this.c, this.d, this.e);
                if (zA) {
                    g.this.w.a(this.b, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                }
                if (zA || this.e) {
                    synchronized (g.this) {
                        g.this.y.remove(Integer.valueOf(this.b));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.thrid.okhttp.internal.http2.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Http2Connection.java */
    class C0499g extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final /* synthetic */ int b;
        final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0499g(String str, Object[] objArr, int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            super(str, objArr);
            this.b = i;
            this.c = bVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.j.a(this.b, this.c);
            synchronized (g.this) {
                g.this.y.remove(Integer.valueOf(this.b));
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    final class i extends com.mbridge.msdk.thrid.okhttp.internal.b {
        i() {
            super("OkHttp %s ping", g.this.d);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            boolean z;
            synchronized (g.this) {
                if (g.this.l < g.this.k) {
                    z = true;
                } else {
                    g.e(g.this);
                    z = false;
                }
            }
            if (z) {
                g.this.h();
            } else {
                g.this.a(false, 1, 0);
            }
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    public static abstract class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f5545a = new a();

        /* JADX INFO: compiled from: Http2Connection.java */
        static class a extends j {
            a() {
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
            public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException {
                iVar.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
            }
        }

        public void a(g gVar) {
        }

        public abstract void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException;
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    final class k extends com.mbridge.msdk.thrid.okhttp.internal.b {
        final boolean b;
        final int c;
        final int d;

        k(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", g.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.b = z;
            this.c = i;
            this.d = i2;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        public void b() {
            g.this.a(this.b, this.c, this.d);
        }
    }

    g(h hVar) {
        m mVar = new m();
        this.u = mVar;
        this.y = new LinkedHashSet();
        this.j = hVar.f;
        boolean z2 = hVar.g;
        this.f5543a = z2;
        this.b = hVar.e;
        int i2 = z2 ? 1 : 2;
        this.f = i2;
        if (z2) {
            this.f = i2 + 2;
        }
        if (z2) {
            this.t.a(7, 16777216);
        }
        String str = hVar.b;
        this.d = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, com.mbridge.msdk.thrid.okhttp.internal.c.a(com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp %s Writer", str), false));
        this.h = scheduledThreadPoolExecutor;
        if (hVar.h != 0) {
            i iVar = new i();
            long j2 = hVar.h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(iVar, j2, j2, TimeUnit.MILLISECONDS);
        }
        this.i = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a(com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp %s Push Observer", str), true));
        mVar.a(7, 65535);
        mVar.a(5, 16384);
        this.s = mVar.c();
        this.v = hVar.f5544a;
        this.w = new com.mbridge.msdk.thrid.okhttp.internal.http2.j(hVar.d, z2);
        this.x = new l(new com.mbridge.msdk.thrid.okhttp.internal.http2.h(hVar.c, z2));
    }

    static /* synthetic */ long c(g gVar) {
        long j2 = gVar.l;
        gVar.l = 1 + j2;
        return j2;
    }

    static /* synthetic */ long e(g gVar) {
        long j2 = gVar.k;
        gVar.k = 1 + j2;
        return j2;
    }

    static /* synthetic */ long h(g gVar) {
        long j2 = gVar.n;
        gVar.n = 1 + j2;
        return j2;
    }

    static /* synthetic */ long i(g gVar) {
        long j2 = gVar.p;
        gVar.p = 1 + j2;
        return j2;
    }

    boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.NO_ERROR, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
    }

    public void flush() throws IOException {
        this.w.flush();
    }

    public synchronized int k() {
        return this.u.b(Integer.MAX_VALUE);
    }

    void l() {
        synchronized (this) {
            long j2 = this.n;
            long j3 = this.m;
            if (j2 < j3) {
                return;
            }
            this.m = j3 + 1;
            this.q = System.nanoTime() + 1000000000;
            try {
                this.h.execute(new c("OkHttp %s ping", this.d));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public void m() throws IOException {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        try {
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar = com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR;
            a(bVar, bVar);
        } catch (IOException unused) {
        }
    }

    void b(int i2, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        this.w.a(i2, bVar);
    }

    synchronized com.mbridge.msdk.thrid.okhttp.internal.http2.i c(int i2) {
        com.mbridge.msdk.thrid.okhttp.internal.http2.i iVarRemove;
        iVarRemove = this.c.remove(Integer.valueOf(i2));
        notifyAll();
        return iVarRemove;
    }

    public synchronized boolean f(long j2) {
        if (this.g) {
            return false;
        }
        return this.n >= this.m || j2 < this.q;
    }

    synchronized void g(long j2) {
        long j3 = this.r + j2;
        this.r = j3;
        if (j3 >= this.t.c() / 2) {
            a(0, this.r);
            this.r = 0L;
        }
    }

    synchronized com.mbridge.msdk.thrid.okhttp.internal.http2.i a(int i2) {
        return this.c.get(Integer.valueOf(i2));
    }

    void b(int i2, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list, boolean z2) {
        try {
            a(new e("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i2)}, i2, list, z2));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Socket f5544a;
        String b;
        com.mbridge.msdk.thrid.okio.e c;
        com.mbridge.msdk.thrid.okio.d d;
        j e = j.f5545a;
        com.mbridge.msdk.thrid.okhttp.internal.http2.l f = com.mbridge.msdk.thrid.okhttp.internal.http2.l.f5554a;
        boolean g;
        int h;

        public h(boolean z) {
            this.g = z;
        }

        public h a(Socket socket, String str, com.mbridge.msdk.thrid.okio.e eVar, com.mbridge.msdk.thrid.okio.d dVar) {
            this.f5544a = socket;
            this.b = str;
            this.c = eVar;
            this.d = dVar;
            return this;
        }

        public h a(j jVar) {
            this.e = jVar;
            return this;
        }

        public h a(int i) {
            this.h = i;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http2.i a(List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list, boolean z2) throws IOException {
        return a(0, list, z2);
    }

    void c(int i2, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        try {
            this.h.execute(new a("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i2)}, i2, bVar));
        } catch (RejectedExecutionException unused) {
        }
    }

    private com.mbridge.msdk.thrid.okhttp.internal.http2.i a(int i2, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list, boolean z2) throws IOException {
        int i3;
        com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar;
        boolean z3;
        boolean z4 = !z2;
        synchronized (this.w) {
            synchronized (this) {
                if (this.f > 1073741823) {
                    a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
                }
                if (!this.g) {
                    i3 = this.f;
                    this.f = i3 + 2;
                    iVar = new com.mbridge.msdk.thrid.okhttp.internal.http2.i(i3, this, z4, false, null);
                    z3 = !z2 || this.s == 0 || iVar.b == 0;
                    if (iVar.g()) {
                        this.c.put(Integer.valueOf(i3), iVar);
                    }
                } else {
                    throw new com.mbridge.msdk.thrid.okhttp.internal.http2.a();
                }
            }
            if (i2 == 0) {
                this.w.a(z4, i3, i2, list);
            } else if (!this.f5543a) {
                this.w.a(i2, i3, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
        }
        if (z3) {
            this.w.flush();
        }
        return iVar;
    }

    /* JADX INFO: compiled from: Http2Connection.java */
    class l extends com.mbridge.msdk.thrid.okhttp.internal.b implements com.mbridge.msdk.thrid.okhttp.internal.http2.h.b {
        final com.mbridge.msdk.thrid.okhttp.internal.http2.h b;

        /* JADX INFO: compiled from: Http2Connection.java */
        class a extends com.mbridge.msdk.thrid.okhttp.internal.b {
            final /* synthetic */ com.mbridge.msdk.thrid.okhttp.internal.http2.i b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Object[] objArr, com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) {
                super(str, objArr);
                this.b = iVar;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                try {
                    g.this.b.a(this.b);
                } catch (IOException e) {
                    com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(4, "Http2Connection.Listener failure for " + g.this.d, e);
                    try {
                        this.b.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* JADX INFO: compiled from: Http2Connection.java */
        class b extends com.mbridge.msdk.thrid.okhttp.internal.b {
            final /* synthetic */ boolean b;
            final /* synthetic */ m c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(String str, Object[] objArr, boolean z, m mVar) {
                super(str, objArr);
                this.b = z;
                this.c = mVar;
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                l.this.b(this.b, this.c);
            }
        }

        /* JADX INFO: compiled from: Http2Connection.java */
        class c extends com.mbridge.msdk.thrid.okhttp.internal.b {
            c(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // com.mbridge.msdk.thrid.okhttp.internal.b
            public void b() {
                g gVar = g.this;
                gVar.b.a(gVar);
            }
        }

        l(com.mbridge.msdk.thrid.okhttp.internal.http2.h hVar) {
            super("OkHttp %s", g.this.d);
            this.b = hVar;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a() {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z, int i, com.mbridge.msdk.thrid.okio.e eVar, int i2) throws IOException {
            if (g.this.b(i)) {
                g.this.a(i, eVar, i2, z);
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i iVarA = g.this.a(i);
            if (iVarA == null) {
                g.this.c(i, com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                long j = i2;
                g.this.g(j);
                eVar.skip(j);
                return;
            }
            iVarA.a(eVar, i2);
            if (z) {
                iVarA.i();
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.b
        protected void b() throws Throwable {
            Throwable th;
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar;
            com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar2 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.INTERNAL_ERROR;
            try {
                try {
                    this.b.a(this);
                    while (this.b.a(false, (com.mbridge.msdk.thrid.okhttp.internal.http2.h.b) this)) {
                    }
                    bVar = com.mbridge.msdk.thrid.okhttp.internal.http2.b.NO_ERROR;
                    try {
                        try {
                            g.this.a(bVar, com.mbridge.msdk.thrid.okhttp.internal.http2.b.CANCEL);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                g.this.a(bVar, bVar2);
                            } catch (IOException unused) {
                            }
                            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.b);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar3 = com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR;
                        g.this.a(bVar3, bVar3);
                    }
                } catch (IOException unused3) {
                    bVar = bVar2;
                } catch (Throwable th3) {
                    th = th3;
                    bVar = bVar2;
                    g.this.a(bVar, bVar2);
                    com.mbridge.msdk.thrid.okhttp.internal.c.a(this.b);
                    throw th;
                }
            } catch (IOException unused4) {
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.b);
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z, int i, int i2, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
            if (g.this.b(i)) {
                g.this.b(i, list, z);
                return;
            }
            synchronized (g.this) {
                com.mbridge.msdk.thrid.okhttp.internal.http2.i iVarA = g.this.a(i);
                if (iVarA == null) {
                    if (g.this.g) {
                        return;
                    }
                    g gVar = g.this;
                    if (i <= gVar.e) {
                        return;
                    }
                    if (i % 2 == gVar.f % 2) {
                        return;
                    }
                    com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar = new com.mbridge.msdk.thrid.okhttp.internal.http2.i(i, g.this, false, z, com.mbridge.msdk.thrid.okhttp.internal.c.b(list));
                    g gVar2 = g.this;
                    gVar2.e = i;
                    gVar2.c.put(Integer.valueOf(i), iVar);
                    g.z.execute(new a("OkHttp %s stream %d", new Object[]{g.this.d, Integer.valueOf(i)}, iVar));
                    return;
                }
                iVarA.a(list);
                if (z) {
                    iVarA.i();
                }
            }
        }

        void b(boolean z, m mVar) {
            com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr;
            long j;
            synchronized (g.this.w) {
                synchronized (g.this) {
                    int iC = g.this.u.c();
                    if (z) {
                        g.this.u.a();
                    }
                    g.this.u.a(mVar);
                    int iC2 = g.this.u.c();
                    iVarArr = null;
                    if (iC2 == -1 || iC2 == iC) {
                        j = 0;
                    } else {
                        j = iC2 - iC;
                        if (!g.this.c.isEmpty()) {
                            iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) g.this.c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[g.this.c.size()]);
                        }
                    }
                }
                try {
                    g gVar = g.this;
                    gVar.w.a(gVar.u);
                } catch (IOException unused) {
                    g.this.h();
                }
            }
            if (iVarArr != null) {
                for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(j);
                    }
                }
            }
            g.z.execute(new c("OkHttp %s settings", g.this.d));
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
            if (g.this.b(i)) {
                g.this.a(i, bVar);
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i iVarC = g.this.c(i);
            if (iVarC != null) {
                iVarC.d(bVar);
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z, m mVar) {
            try {
                g.this.h.execute(new b("OkHttp %s ACK Settings", new Object[]{g.this.d}, z, mVar));
            } catch (RejectedExecutionException unused) {
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    g.this.h.execute(g.this.new k(true, i, i2));
                    return;
                } catch (RejectedExecutionException unused) {
                    return;
                }
            }
            synchronized (g.this) {
                try {
                    if (i == 1) {
                        g.c(g.this);
                    } else if (i == 2) {
                        g.h(g.this);
                    } else if (i == 3) {
                        g.i(g.this);
                        g.this.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okio.f fVar) {
            com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr;
            fVar.e();
            synchronized (g.this) {
                iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) g.this.c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[g.this.c.size()]);
                g.this.g = true;
            }
            for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                if (iVar.c() > i && iVar.f()) {
                    iVar.d(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
                    g.this.c(iVar.c());
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (g.this) {
                    g gVar = g.this;
                    gVar.s += j;
                    gVar.notifyAll();
                }
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.http2.i iVarA = g.this.a(i);
            if (iVarA != null) {
                synchronized (iVarA) {
                    iVarA.a(j);
                }
            }
        }

        @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.h.b
        public void a(int i, int i2, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
            g.this.a(i2, list);
        }
    }

    public void a(int i2, boolean z2, com.mbridge.msdk.thrid.okio.c cVar, long j2) throws IOException {
        long j3;
        int iMin;
        long j4;
        if (j2 == 0) {
            this.w.a(z2, i2, cVar, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j3 = this.s;
                        if (j3 <= 0) {
                            if (this.c.containsKey(Integer.valueOf(i2))) {
                                wait();
                            } else {
                                throw new IOException("stream closed");
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                iMin = Math.min((int) Math.min(j2, j3), this.w.h());
                j4 = iMin;
                this.s -= j4;
            }
            j2 -= j4;
            this.w.a(z2 && j2 == 0, i2, cVar, iMin);
        }
    }

    void a(int i2, long j2) {
        try {
            this.h.execute(new b("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i2)}, i2, j2));
        } catch (RejectedExecutionException unused) {
        }
    }

    void a(boolean z2, int i2, int i3) {
        try {
            this.w.a(z2, i2, i3);
        } catch (IOException unused) {
            h();
        }
    }

    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) throws IOException {
        synchronized (this.w) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.w.a(this.e, bVar, com.mbridge.msdk.thrid.okhttp.internal.c.f5512a);
            }
        }
    }

    void a(com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar2) throws IOException {
        if (!A && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        com.mbridge.msdk.thrid.okhttp.internal.http2.i[] iVarArr = null;
        try {
            a(bVar);
            e = null;
        } catch (IOException e2) {
            e = e2;
        }
        synchronized (this) {
            if (!this.c.isEmpty()) {
                iVarArr = (com.mbridge.msdk.thrid.okhttp.internal.http2.i[]) this.c.values().toArray(new com.mbridge.msdk.thrid.okhttp.internal.http2.i[this.c.size()]);
                this.c.clear();
            }
        }
        if (iVarArr != null) {
            for (com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar : iVarArr) {
                try {
                    iVar.a(bVar2);
                } catch (IOException e3) {
                    if (e != null) {
                        e = e3;
                    }
                }
            }
        }
        try {
            this.w.close();
        } catch (IOException e4) {
            if (e == null) {
                e = e4;
            }
        }
        try {
            this.v.close();
        } catch (IOException e5) {
            e = e5;
        }
        this.h.shutdown();
        this.i.shutdown();
        if (e != null) {
            throw e;
        }
    }

    void a(boolean z2) throws IOException {
        if (z2) {
            this.w.d();
            this.w.b(this.t);
            int iC = this.t.c();
            if (iC != 65535) {
                this.w.a(0, iC - 65535);
            }
        }
        new Thread(this.x).start();
    }

    void a(int i2, List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
        synchronized (this) {
            if (this.y.contains(Integer.valueOf(i2))) {
                c(i2, com.mbridge.msdk.thrid.okhttp.internal.http2.b.PROTOCOL_ERROR);
                return;
            }
            this.y.add(Integer.valueOf(i2));
            try {
                a(new d("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i2)}, i2, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    void a(int i2, com.mbridge.msdk.thrid.okio.e eVar, int i3, boolean z2) throws IOException {
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        long j2 = i3;
        eVar.e(j2);
        eVar.b(cVar, j2);
        if (cVar.size() == j2) {
            a(new f("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i2)}, i2, cVar, i3, z2));
            return;
        }
        throw new IOException(cVar.size() + " != " + i3);
    }

    void a(int i2, com.mbridge.msdk.thrid.okhttp.internal.http2.b bVar) {
        a(new C0499g("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i2)}, i2, bVar));
    }

    private synchronized void a(com.mbridge.msdk.thrid.okhttp.internal.b bVar) {
        if (!this.g) {
            this.i.execute(bVar);
        }
    }
}

package com.yandex.mobile.ads.impl;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes9.dex */
public final class eh0 implements Closeable {
    private static final sx1 C;
    private final c A;
    private final LinkedHashSet B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f8798a;
    private final b b;
    private final LinkedHashMap c;
    private final String d;
    private int e;
    private int f;
    private boolean g;
    private final e42 h;
    private final d42 i;
    private final d42 j;
    private final d42 k;
    private final ym1 l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private final sx1 s;
    private sx1 t;
    private long u;
    private long v;
    private long w;
    private long x;
    private final Socket y;
    private final mh0 z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8799a;
        private final e42 b;
        public Socket c;
        public String d;
        public BufferedSource e;
        public BufferedSink f;
        private b g;
        private ym1 h;
        private int i;

        public a(e42 taskRunner) {
            Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
            this.f8799a = true;
            this.b = taskRunner;
            this.g = b.f8800a;
            this.h = ym1.f10753a;
        }

        public final a j() {
            this.i = 0;
            return this;
        }

        public final boolean a() {
            return this.f8799a;
        }

        public final a a(b listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.g = listener;
            return this;
        }

        public final e42 i() {
            return this.b;
        }

        public final Socket g() {
            Socket socket = this.c;
            if (socket != null) {
                return socket;
            }
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            return null;
        }

        public final String b() {
            String str = this.d;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            return null;
        }

        public final BufferedSource h() {
            BufferedSource bufferedSource = this.e;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            Intrinsics.throwUninitializedPropertyAccessException("source");
            return null;
        }

        public final BufferedSink f() {
            BufferedSink bufferedSink = this.f;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            return null;
        }

        public final b c() {
            return this.g;
        }

        public final ym1 e() {
            return this.h;
        }

        public final int d() {
            return this.i;
        }

        public final a a(Socket socket, String peerName, BufferedSource source, BufferedSink sink) throws IOException {
            String str;
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(peerName, "peerName");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(socket, "<set-?>");
            this.c = socket;
            if (this.f8799a) {
                str = y82.g + " " + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.d = str;
            Intrinsics.checkNotNullParameter(source, "<set-?>");
            this.e = source;
            Intrinsics.checkNotNullParameter(sink, "<set-?>");
            this.f = sink;
            return this;
        }
    }

    public final class c implements kh0.c, Function0<Unit> {
        private final kh0 b;
        final /* synthetic */ eh0 c;

        public c(eh0 eh0Var, kh0 reader) {
            Intrinsics.checkNotNullParameter(reader, "reader");
            this.c = eh0Var;
            this.b = reader;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v2, types: [T, com.yandex.mobile.ads.impl.sx1] */
        /* JADX WARN: Type inference failed for: r12v3 */
        public final void a(boolean z, sx1 settings) {
            ?? r12;
            long jB;
            int i;
            lh0[] lh0VarArr;
            Intrinsics.checkNotNullParameter(settings, "settings");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            mh0 mh0VarK = this.c.k();
            eh0 eh0Var = this.c;
            synchronized (mh0VarK) {
                synchronized (eh0Var) {
                    sx1 sx1VarH = eh0Var.h();
                    if (z) {
                        r12 = settings;
                    } else {
                        sx1 sx1Var = new sx1();
                        sx1Var.a(sx1VarH);
                        sx1Var.a(settings);
                        r12 = sx1Var;
                    }
                    objectRef.element = r12;
                    jB = ((long) r12.b()) - ((long) sx1VarH.b());
                    lh0VarArr = (jB == 0 || eh0Var.i().isEmpty()) ? null : (lh0[]) eh0Var.i().values().toArray(new lh0[0]);
                    eh0Var.a((sx1) objectRef.element);
                    eh0Var.k.a(new a(eh0Var.c() + " onSettings", eh0Var, objectRef), 0L);
                    Unit unit = Unit.INSTANCE;
                }
                try {
                    eh0Var.k().a((sx1) objectRef.element);
                } catch (IOException e) {
                    eh0.a(eh0Var, e);
                }
                Unit unit2 = Unit.INSTANCE;
            }
            if (lh0VarArr != null) {
                for (lh0 lh0Var : lh0VarArr) {
                    synchronized (lh0Var) {
                        lh0Var.a(jB);
                        Unit unit3 = Unit.INSTANCE;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.yandex.mobile.ads.impl.q50] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.Unit] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() throws Throwable {
            Throwable th;
            q50 q50Var;
            q50 q50Var2 = q50.f;
            IOException e = null;
            try {
                try {
                    this.b.a(this);
                    while (this.b.a(false, this)) {
                    }
                    q50 q50Var3 = q50.d;
                    try {
                        this.c.a(q50Var3, q50.i, (IOException) null);
                        y82.a(this.b);
                        q50Var = q50Var3;
                    } catch (IOException e2) {
                        e = e2;
                        q50 q50Var4 = q50.e;
                        eh0 eh0Var = this.c;
                        eh0Var.a(q50Var4, q50Var4, e);
                        y82.a(this.b);
                        q50Var = eh0Var;
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                    q50Var = q50Var2;
                    this.c.a(q50Var, q50Var2, e);
                    y82.a(this.b);
                    throw th;
                }
                q50Var2 = Unit.INSTANCE;
                return q50Var2;
            } catch (Throwable th3) {
                th = th3;
                this.c.a(q50Var, q50Var2, e);
                y82.a(this.b);
                throw th;
            }
        }

        public static final class a extends a42 {
            final /* synthetic */ eh0 e;
            final /* synthetic */ Ref.ObjectRef f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, eh0 eh0Var, Ref.ObjectRef objectRef) {
                super(str, true);
                this.e = eh0Var;
                this.f = objectRef;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.yandex.mobile.ads.impl.a42
            public final long e() {
                this.e.e().a(this.e, (sx1) this.f.element);
                return -1L;
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, int i2, BufferedSource source, boolean z) throws IOException {
            Intrinsics.checkNotNullParameter(source, "source");
            this.c.getClass();
            if (eh0.b(i)) {
                this.c.a(i, i2, source, z);
                return;
            }
            lh0 lh0VarA = this.c.a(i);
            if (lh0VarA == null) {
                this.c.c(i, q50.e);
                long j = i2;
                this.c.b(j);
                source.skip(j);
                return;
            }
            lh0VarA.a(source, i2);
            if (z) {
                lh0VarA.a(y82.b, true);
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, q50 errorCode, ByteString debugData) {
            int i2;
            Object[] array;
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            Intrinsics.checkNotNullParameter(debugData, "debugData");
            debugData.size();
            eh0 eh0Var = this.c;
            synchronized (eh0Var) {
                array = eh0Var.i().values().toArray(new lh0[0]);
                eh0Var.g = true;
                Unit unit = Unit.INSTANCE;
            }
            for (lh0 lh0Var : (lh0[]) array) {
                if (lh0Var.f() > i && lh0Var.p()) {
                    lh0Var.b(q50.h);
                    this.c.c(lh0Var.f());
                }
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(boolean z, int i, List headerBlock) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            this.c.getClass();
            if (eh0.b(i)) {
                this.c.a(i, (List<if0>) headerBlock, z);
                return;
            }
            eh0 eh0Var = this.c;
            synchronized (eh0Var) {
                lh0 lh0VarA = eh0Var.a(i);
                if (lh0VarA == null) {
                    if (eh0Var.g) {
                        return;
                    }
                    if (i <= eh0Var.d()) {
                        return;
                    }
                    if (i % 2 == eh0Var.f() % 2) {
                        return;
                    }
                    lh0 lh0Var = new lh0(i, eh0Var, false, z, y82.a((List<if0>) headerBlock));
                    eh0Var.d(i);
                    eh0Var.i().put(Integer.valueOf(i), lh0Var);
                    eh0Var.h.e().a(new fh0(eh0Var.c() + com.ironsource.b9.i.d + i + "] onStream", eh0Var, lh0Var), 0L);
                    return;
                }
                Unit unit = Unit.INSTANCE;
                lh0VarA.a(y82.a((List<if0>) headerBlock), z);
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, int i2, boolean z) {
            if (!z) {
                this.c.i.a(new gh0(this.c.c() + " ping", this.c, i, i2), 0L);
                return;
            }
            eh0 eh0Var = this.c;
            synchronized (eh0Var) {
                try {
                    if (i == 1) {
                        eh0Var.n++;
                    } else if (i == 2) {
                        eh0Var.p++;
                    } else {
                        if (i == 3) {
                            eh0Var.q++;
                            Intrinsics.checkNotNull(eh0Var, "null cannot be cast to non-null type java.lang.Object");
                            eh0Var.notifyAll();
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, List requestHeaders) {
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            this.c.a(i, (List<if0>) requestHeaders);
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, q50 errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            this.c.getClass();
            if (eh0.b(i)) {
                this.c.a(i, errorCode);
                return;
            }
            lh0 lh0VarC = this.c.c(i);
            if (lh0VarC != null) {
                lh0VarC.b(errorCode);
            }
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(sx1 settings) {
            Intrinsics.checkNotNullParameter(settings, "settings");
            this.c.i.a(new hh0(this.c.c() + " applyAndAckSettings", this, settings), 0L);
        }

        @Override // com.yandex.mobile.ads.impl.kh0.c
        public final void a(int i, long j) {
            if (i == 0) {
                eh0 eh0Var = this.c;
                synchronized (eh0Var) {
                    eh0Var.x = eh0Var.j() + j;
                    Intrinsics.checkNotNull(eh0Var, "null cannot be cast to non-null type java.lang.Object");
                    eh0Var.notifyAll();
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            lh0 lh0VarA = this.c.a(i);
            if (lh0VarA != null) {
                synchronized (lh0VarA) {
                    lh0VarA.a(j);
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }
    }

    static {
        sx1 sx1Var = new sx1();
        sx1Var.a(7, 65535);
        sx1Var.a(5, 16384);
        C = sx1Var;
    }

    public eh0(a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        boolean zA = builder.a();
        this.f8798a = zA;
        this.b = builder.c();
        this.c = new LinkedHashMap();
        String strB = builder.b();
        this.d = strB;
        this.f = builder.a() ? 3 : 2;
        e42 e42VarI = builder.i();
        this.h = e42VarI;
        d42 d42VarE = e42VarI.e();
        this.i = d42VarE;
        this.j = e42VarI.e();
        this.k = e42VarI.e();
        this.l = builder.e();
        sx1 sx1Var = new sx1();
        if (builder.a()) {
            sx1Var.a(7, 16777216);
        }
        this.s = sx1Var;
        sx1 sx1Var2 = C;
        this.t = sx1Var2;
        this.x = sx1Var2.b();
        this.y = builder.g();
        this.z = new mh0(builder.f(), zA);
        this.A = new c(this, new kh0(builder.h(), zA));
        this.B = new LinkedHashSet();
        if (builder.d() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.d());
            d42VarE.a(new h(strB + " ping", this, nanos), nanos);
        }
    }

    public static boolean b(int i2) {
        return i2 != 0 && (i2 & 1) == 0;
    }

    public static final void a(eh0 eh0Var, IOException iOException) {
        eh0Var.getClass();
        q50 q50Var = q50.e;
        eh0Var.a(q50Var, q50Var, iOException);
    }

    public final LinkedHashMap i() {
        return this.c;
    }

    public final boolean b() {
        return this.f8798a;
    }

    public final int f() {
        return this.f;
    }

    public final mh0 k() {
        return this.z;
    }

    public final sx1 g() {
        return this.s;
    }

    public final void a(q50 connectionCode, q50 streamCode, IOException iOException) {
        int i2;
        Object[] array;
        Intrinsics.checkNotNullParameter(connectionCode, "connectionCode");
        Intrinsics.checkNotNullParameter(streamCode, "streamCode");
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            a(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (this.c.isEmpty()) {
                array = null;
            } else {
                array = this.c.values().toArray(new lh0[0]);
                this.c.clear();
            }
            Unit unit = Unit.INSTANCE;
        }
        lh0[] lh0VarArr = (lh0[]) array;
        if (lh0VarArr != null) {
            for (lh0 lh0Var : lh0VarArr) {
                try {
                    lh0Var.a(streamCode, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.z.close();
        } catch (IOException unused3) {
        }
        try {
            this.y.close();
        } catch (IOException unused4) {
        }
        this.i.j();
        this.j.j();
        this.k.j();
    }

    public final sx1 h() {
        return this.t;
    }

    public final b e() {
        return this.b;
    }

    public final String c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final long j() {
        return this.x;
    }

    public static final class d extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str, eh0 eh0Var, int i, List list, boolean z) {
            super(str, true);
            this.e = eh0Var;
            this.f = i;
            this.g = list;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            ym1 ym1Var = this.e.l;
            List responseHeaders = this.g;
            ((xm1) ym1Var).getClass();
            Intrinsics.checkNotNullParameter(responseHeaders, "responseHeaders");
            try {
                this.e.k().a(this.f, q50.i);
                synchronized (this.e) {
                    this.e.B.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class e extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ int f;
        final /* synthetic */ List g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, eh0 eh0Var, int i, List list) {
            super(str, true);
            this.e = eh0Var;
            this.f = i;
            this.g = list;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            ym1 ym1Var = this.e.l;
            List requestHeaders = this.g;
            ((xm1) ym1Var).getClass();
            Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
            try {
                this.e.k().a(this.f, q50.i);
                synchronized (this.e) {
                    this.e.B.remove(Integer.valueOf(this.f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    public static final class f extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ int f;
        final /* synthetic */ q50 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, eh0 eh0Var, int i, q50 q50Var) {
            super(str, true);
            this.e = eh0Var;
            this.f = i;
            this.g = q50Var;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            ym1 ym1Var = this.e.l;
            q50 errorCode = this.g;
            ((xm1) ym1Var).getClass();
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            synchronized (this.e) {
                this.e.B.remove(Integer.valueOf(this.f));
                Unit unit = Unit.INSTANCE;
            }
            return -1L;
        }
    }

    public static final class g extends a42 {
        final /* synthetic */ eh0 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, eh0 eh0Var) {
            super(str, true);
            this.e = eh0Var;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            this.e.a(2, 0, false);
            return -1L;
        }
    }

    public static final class h extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ long f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, eh0 eh0Var, long j) {
            super(str);
            this.e = eh0Var;
            this.f = j;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            boolean z;
            synchronized (this.e) {
                if (this.e.n < this.e.m) {
                    z = true;
                } else {
                    this.e.m++;
                    z = false;
                }
            }
            if (z) {
                eh0.a(this.e, (IOException) null);
                return -1L;
            }
            this.e.a(1, 0, false);
            return this.f;
        }
    }

    public static final class i extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ int f;
        final /* synthetic */ q50 g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, eh0 eh0Var, int i, q50 q50Var) {
            super(str, true);
            this.e = eh0Var;
            this.f = i;
            this.g = q50Var;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            try {
                this.e.b(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                eh0.a(this.e, e);
                return -1L;
            }
        }
    }

    public static final class j extends a42 {
        final /* synthetic */ eh0 e;
        final /* synthetic */ int f;
        final /* synthetic */ long g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, eh0 eh0Var, int i, long j) {
            super(str, true);
            this.e = eh0Var;
            this.f = i;
            this.g = j;
        }

        @Override // com.yandex.mobile.ads.impl.a42
        public final long e() {
            try {
                this.e.k().a(this.f, this.g);
                return -1L;
            } catch (IOException e) {
                eh0.a(this.e, e);
                return -1L;
            }
        }
    }

    public final void d(int i2) {
        this.e = i2;
    }

    public final synchronized void b(long j2) {
        long j3 = this.u + j2;
        this.u = j3;
        long j4 = j3 - this.v;
        if (j4 >= this.s.b() / 2) {
            a(0, j4);
            this.v += j4;
        }
    }

    public final void b(int i2, q50 statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        this.z.a(i2, statusCode);
    }

    public final synchronized lh0 c(int i2) {
        lh0 lh0Var;
        lh0Var = (lh0) this.c.remove(Integer.valueOf(i2));
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return lh0Var;
    }

    public final void flush() throws IOException {
        this.z.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(q50.d, q50.i, (IOException) null);
    }

    public final void l() {
        synchronized (this) {
            long j2 = this.p;
            long j3 = this.o;
            if (j2 < j3) {
                return;
            }
            this.o = j3 + 1;
            this.r = System.nanoTime() + ((long) 1000000000);
            Unit unit = Unit.INSTANCE;
            this.i.a(new g(this.d + " ping", this), 0L);
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8800a = new a();

        public void a(eh0 connection, sx1 settings) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(settings, "settings");
        }

        public abstract void a(lh0 lh0Var) throws IOException;

        public static final class a extends b {
            @Override // com.yandex.mobile.ads.impl.eh0.b
            public final void a(lh0 stream) throws IOException {
                Intrinsics.checkNotNullParameter(stream, "stream");
                stream.a(q50.h, (IOException) null);
            }

            a() {
            }
        }
    }

    public static void l(eh0 eh0Var) throws IOException {
        e42 taskRunner = e42.h;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        eh0Var.z.a();
        eh0Var.z.b(eh0Var.s);
        int iB = eh0Var.s.b();
        if (iB != 65535) {
            eh0Var.z.a(0, iB - 65535);
        }
        taskRunner.e().a(new c42(eh0Var.d, eh0Var.A), 0L);
    }

    public final void c(int i2, q50 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.i.a(new i(this.d + com.ironsource.b9.i.d + i2 + "] writeSynReset", this, i2, errorCode), 0L);
    }

    public final synchronized lh0 a(int i2) {
        return (lh0) this.c.get(Integer.valueOf(i2));
    }

    public final synchronized boolean a(long j2) {
        if (this.g) {
            return false;
        }
        return this.p >= this.o || j2 < this.r;
    }

    public final lh0 a(ArrayList requestHeaders, boolean z) throws IOException {
        int i2;
        lh0 lh0Var;
        boolean z2;
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        boolean z3 = !z;
        synchronized (this.z) {
            synchronized (this) {
                if (this.f > 1073741823) {
                    a(q50.h);
                }
                if (!this.g) {
                    i2 = this.f;
                    this.f = i2 + 2;
                    lh0Var = new lh0(i2, this, z3, false, null);
                    z2 = !z || this.w >= this.x || lh0Var.n() >= lh0Var.m();
                    if (lh0Var.q()) {
                        this.c.put(Integer.valueOf(i2), lh0Var);
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    throw new nr();
                }
            }
            this.z.a(i2, requestHeaders, z3);
        }
        if (z2) {
            this.z.flush();
        }
        return lh0Var;
    }

    public final void a(int i2, int i3, BufferedSource source, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Buffer buffer = new Buffer();
        long j2 = i3;
        source.require(j2);
        source.read(buffer, j2);
        this.j.a(new ih0(this.d + com.ironsource.b9.i.d + i2 + "] onData", this, i2, buffer, i3, z), 0L);
    }

    public final void a(int i2, List<if0> requestHeaders, boolean z) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        this.j.a(new d(this.d + com.ironsource.b9.i.d + i2 + "] onHeaders", this, i2, requestHeaders, z), 0L);
    }

    public final void a(int i2, List<if0> requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.B.contains(Integer.valueOf(i2))) {
                c(i2, q50.e);
                return;
            }
            this.B.add(Integer.valueOf(i2));
            this.j.a(new e(this.d + com.ironsource.b9.i.d + i2 + "] onRequest", this, i2, requestHeaders), 0L);
        }
    }

    public final void a(int i2, q50 errorCode) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.j.a(new f(this.d + com.ironsource.b9.i.d + i2 + "] onReset", this, i2, errorCode), 0L);
    }

    public final void a(sx1 sx1Var) {
        Intrinsics.checkNotNullParameter(sx1Var, "<set-?>");
        this.t = sx1Var;
    }

    public final void a(q50 statusCode) throws IOException {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        synchronized (this.z) {
            Ref.IntRef intRef = new Ref.IntRef();
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                int i2 = this.e;
                intRef.element = i2;
                Unit unit = Unit.INSTANCE;
                this.z.a(i2, statusCode, y82.f10712a);
            }
        }
    }

    public final void a(int i2, boolean z, Buffer buffer, long j2) throws IOException {
        long j3;
        long j4;
        int iMin;
        long j5;
        if (j2 == 0) {
            this.z.a(z, i2, buffer, 0);
            return;
        }
        while (j2 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        j3 = this.w;
                        j4 = this.x;
                        if (j3 >= j4) {
                            if (this.c.containsKey(Integer.valueOf(i2))) {
                                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
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
                iMin = Math.min((int) Math.min(j2, j4 - j3), this.z.b());
                j5 = iMin;
                this.w += j5;
                Unit unit = Unit.INSTANCE;
            }
            j2 -= j5;
            this.z.a(z && j2 == 0, i2, buffer, iMin);
        }
    }

    public final void a(int i2, int i3, boolean z) {
        try {
            this.z.a(i2, i3, z);
        } catch (IOException e2) {
            q50 q50Var = q50.e;
            a(q50Var, q50Var, e2);
        }
    }

    public final void a(int i2, long j2) {
        this.i.a(new j(this.d + com.ironsource.b9.i.d + i2 + "] windowUpdate", this, i2, j2), 0L);
    }
}

package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Timeout;

/* JADX INFO: loaded from: classes13.dex */
public final class tn1 extends eh0.b {
    private final os1 b;
    private Socket c;
    private Socket d;
    private ff0 e;
    private im1 f;
    private eh0 g;
    private BufferedSource h;
    private BufferedSink i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private final ArrayList p;
    private long q;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10320a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f10320a = iArr;
        }
    }

    static final class b extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ eo b;
        final /* synthetic */ ff0 c;
        final /* synthetic */ ab d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(eo eoVar, ff0 ff0Var, ab abVar) {
            super(0);
            this.b = eoVar;
            this.c = ff0Var;
            this.d = abVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Certificate> invoke() {
            Cdo cdoA = this.b.a();
            Intrinsics.checkNotNull(cdoA);
            return cdoA.a(this.d.k().g(), this.c.c());
        }
    }

    static final class c extends Lambda implements Function0<List<? extends X509Certificate>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends X509Certificate> invoke() {
            ff0 ff0Var = tn1.this.e;
            Intrinsics.checkNotNull(ff0Var);
            List<Certificate> listC = ff0Var.c();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listC, 10));
            for (Certificate certificate : listC) {
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public tn1(vn1 connectionPool, os1 route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.b = route;
        this.o = 1;
        this.p = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    private final void n() throws IOException {
        Socket socket = this.d;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.h;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.i;
        Intrinsics.checkNotNull(bufferedSink);
        socket.setSoTimeout(0);
        eh0 eh0Var = new eh0(new eh0.a(e42.h).a(socket, this.b.a().k().g(), bufferedSource, bufferedSink).a(this).j());
        this.g = eh0Var;
        this.o = eh0.C.c();
        eh0.l(eh0Var);
    }

    public final ArrayList b() {
        return this.p;
    }

    public final void l() {
        this.j = true;
    }

    public final boolean d() {
        return this.j;
    }

    public final int e() {
        return this.l;
    }

    public final long c() {
        return this.q;
    }

    public final boolean h() {
        return this.g != null;
    }

    public final synchronized void j() {
        this.j = true;
    }

    public final synchronized void i() {
        this.k = true;
    }

    public final synchronized void g() {
        this.m++;
    }

    public final os1 k() {
        return this.b;
    }

    public final Socket m() {
        Socket socket = this.d;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    public final ff0 f() {
        return this.e;
    }

    public final void a() {
        Socket socket = this.c;
        if (socket != null) {
            y82.a(socket);
        }
    }

    public final void a(int i, int i2, int i3, boolean z, sn1 call, t50 eventListener) throws Throwable {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        if (this.f == null) {
            List<or> listB = this.b.a().b();
            pr prVar = new pr(listB);
            if (this.b.a().j() == null) {
                if (listB.contains(or.f)) {
                    String strG = this.b.a().k().g();
                    int i4 = nh1.c;
                    if (!nh1.a.a().a(strG)) {
                        throw new qs1(new UnknownServiceException("CLEARTEXT communication to " + strG + " not permitted by network security policy"));
                    }
                } else {
                    throw new qs1(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
                }
            } else if (this.b.a().e().contains(im1.h)) {
                throw new qs1(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
            qs1 qs1Var = null;
            while (true) {
                try {
                    if (this.b.c()) {
                        a(i, i2, i3, call, eventListener);
                        if (this.c != null) {
                            break;
                        } else {
                            break;
                        }
                    }
                    a(i, i2, call, eventListener);
                    a(prVar, call, eventListener);
                    InetSocketAddress inetSocketAddressD = this.b.d();
                    Proxy proxyB = this.b.b();
                    eventListener.getClass();
                    t50.a(call, inetSocketAddressD, proxyB);
                    break;
                } catch (IOException e) {
                    Socket socket = this.d;
                    if (socket != null) {
                        y82.a(socket);
                    }
                    Socket socket2 = this.c;
                    if (socket2 != null) {
                        y82.a(socket2);
                    }
                    this.d = null;
                    this.c = null;
                    this.h = null;
                    this.i = null;
                    this.e = null;
                    this.f = null;
                    this.g = null;
                    this.o = 1;
                    InetSocketAddress inetSocketAddressD2 = this.b.d();
                    Proxy proxyB2 = this.b.b();
                    eventListener.getClass();
                    t50.a(call, inetSocketAddressD2, proxyB2, e);
                    if (qs1Var == null) {
                        qs1Var = new qs1(e);
                    } else {
                        qs1Var.a(e);
                    }
                    if (z) {
                        if (!prVar.a(e)) {
                            throw qs1Var;
                        }
                    } else {
                        throw qs1Var;
                    }
                }
            }
            if (this.b.c() && this.c == null) {
                throw new qs1(new ProtocolException("Too many tunnel connections attempted: 21"));
            }
            this.q = System.nanoTime();
            return;
        }
        throw new IllegalStateException("already connected".toString());
    }

    public final String toString() {
        Object objA;
        String strG = this.b.a().k().g();
        int i = this.b.a().k().i();
        Proxy proxyB = this.b.b();
        InetSocketAddress inetSocketAddressD = this.b.d();
        ff0 ff0Var = this.e;
        if (ff0Var == null || (objA = ff0Var.a()) == null) {
            objA = "none";
        }
        return "Connection{" + strG + ":" + i + ", proxy=" + proxyB + " hostAddress=" + inetSocketAddressD + " cipherSuite=" + objA + " protocol=" + this.f + "}";
    }

    private final void a(int i, int i2, sn1 sn1Var, t50 t50Var) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyB = this.b.b();
        ab abVarA = this.b.a();
        Proxy.Type type = proxyB.type();
        int i3 = type == null ? -1 : a.f10320a[type.ordinal()];
        if (i3 != 1 && i3 != 2) {
            socketCreateSocket = new Socket(proxyB);
        } else {
            socketCreateSocket = abVarA.i().createSocket();
            Intrinsics.checkNotNull(socketCreateSocket);
        }
        this.c = socketCreateSocket;
        InetSocketAddress inetSocketAddressD = this.b.d();
        t50Var.getClass();
        t50.b(sn1Var, inetSocketAddressD, proxyB);
        socketCreateSocket.setSoTimeout(i2);
        try {
            int i4 = nh1.c;
            nh1.a.a().a(socketCreateSocket, this.b.d(), i);
            try {
                this.h = Okio.buffer(Okio.source(socketCreateSocket));
                this.i = Okio.buffer(Okio.sink(socketCreateSocket));
            } catch (NullPointerException e) {
                if (Intrinsics.areEqual(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.b.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private final void a(pr prVar) throws Throwable {
        im1 im1VarA;
        ab abVarA = this.b.a();
        SSLSocketFactory sSLSocketFactoryJ = abVarA.j();
        SSLSocket sSLSocket = null;
        String strB = null;
        try {
            Intrinsics.checkNotNull(sSLSocketFactoryJ);
            Socket socketCreateSocket = sSLSocketFactoryJ.createSocket(this.c, abVarA.k().g(), abVarA.k().i(), true);
            Intrinsics.checkNotNull(socketCreateSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                or orVarA = prVar.a(sSLSocket2);
                if (orVarA.b()) {
                    int i = nh1.c;
                    nh1.a.a().a(sSLSocket2, abVarA.k().g(), abVarA.e());
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Intrinsics.checkNotNull(session);
                ff0 ff0VarA = ff0.a.a(session);
                HostnameVerifier hostnameVerifierD = abVarA.d();
                Intrinsics.checkNotNull(hostnameVerifierD);
                if (!hostnameVerifierD.verify(abVarA.k().g(), session)) {
                    List<Certificate> listC = ff0VarA.c();
                    if (!listC.isEmpty()) {
                        Certificate certificate = listC.get(0);
                        Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                        X509Certificate x509Certificate = (X509Certificate) certificate;
                        String strG = abVarA.k().g();
                        eo eoVar = eo.c;
                        throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + strG + " not verified:\n              |    certificate: " + eo.b.a(x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + ae1.a(x509Certificate) + "\n              ", null, 1, null));
                    }
                    throw new SSLPeerUnverifiedException("Hostname " + abVarA.k().g() + " not verified (no certificates)");
                }
                eo eoVarA = abVarA.a();
                Intrinsics.checkNotNull(eoVarA);
                this.e = new ff0(ff0VarA.d(), ff0VarA.a(), ff0VarA.b(), new b(eoVarA, ff0VarA, abVarA));
                eoVarA.a(abVarA.k().g(), new c());
                if (orVarA.b()) {
                    int i2 = nh1.c;
                    strB = nh1.a.a().b(sSLSocket2);
                }
                this.d = sSLSocket2;
                this.h = Okio.buffer(Okio.source(sSLSocket2));
                this.i = Okio.buffer(Okio.sink(sSLSocket2));
                if (strB != null) {
                    im1.c.getClass();
                    im1VarA = im1.a.a(strB);
                } else {
                    im1VarA = im1.e;
                }
                this.f = im1VarA;
                int i3 = nh1.c;
                nh1.a.a().a(sSLSocket2);
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    int i4 = nh1.c;
                    nh1.a.a().a(sSLSocket);
                }
                if (sSLSocket != null) {
                    y82.a((Socket) sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final void a(int i, int i2, int i3, sn1 call, t50 t50Var) throws IOException {
        op1 op1VarA = new op1.a().a(this.b.a().k()).a("CONNECT", (rp1) null).b(HttpHeaders.HOST, y82.a(this.b.a().k(), true)).b("Proxy-Connection", HttpHeaders.KEEP_ALIVE).b("User-Agent", "okhttp/4.9.3").a();
        op1 op1VarA2 = this.b.a().g().a(this.b, new oq1.a().a(op1VarA).a(im1.e).a(407).a("Preemptive Authenticate").a(y82.c).b(-1L).a(-1L).c().a());
        if (op1VarA2 != null) {
            op1VarA = op1VarA2;
        }
        di0 di0VarG = op1VarA.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, call, t50Var);
            op1VarA = a(i2, i3, op1VarA, di0VarG);
            if (op1VarA == null) {
                return;
            }
            Socket socket = this.c;
            if (socket != null) {
                y82.a(socket);
            }
            this.c = null;
            this.i = null;
            this.h = null;
            InetSocketAddress inetSocketAddress = this.b.d();
            Proxy proxy = this.b.b();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
            Intrinsics.checkNotNullParameter(proxy, "proxy");
        }
    }

    private final op1 a(int i, int i2, op1 op1Var, di0 di0Var) throws IOException {
        String str = "CONNECT " + y82.a(di0Var, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.h;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.i;
            Intrinsics.checkNotNull(bufferedSink);
            ch0 ch0Var = new ch0(null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.getTimeout().timeout(i, timeUnit);
            bufferedSink.getTimeout().timeout(i2, timeUnit);
            ch0Var.a(op1Var.d(), str);
            ch0Var.a();
            oq1.a aVarA = ch0Var.a(false);
            Intrinsics.checkNotNull(aVarA);
            oq1 oq1VarA = aVarA.a(op1Var).a();
            ch0Var.c(oq1VarA);
            int iD = oq1VarA.d();
            if (iD == 200) {
                if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iD == 407) {
                op1 op1VarA = this.b.a().g().a(this.b, oq1VarA);
                if (op1VarA != null) {
                    if (StringsKt.equals("close", oq1.a(oq1VarA, "Connection"), true)) {
                        return op1VarA;
                    }
                    op1Var = op1VarA;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + oq1VarA.d());
            }
        }
    }

    private final void a(pr prVar, sn1 call, t50 t50Var) throws Throwable {
        if (this.b.a().j() == null) {
            List<im1> listE = this.b.a().e();
            im1 im1Var = im1.h;
            if (listE.contains(im1Var)) {
                this.d = this.c;
                this.f = im1Var;
                n();
                return;
            } else {
                this.d = this.c;
                this.f = im1.e;
                return;
            }
        }
        t50Var.getClass();
        Intrinsics.checkNotNullParameter(call, "call");
        a(prVar);
        Intrinsics.checkNotNullParameter(call, "call");
        if (this.f == im1.g) {
            n();
        }
    }

    public final boolean a(ab address, List<os1> list) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.p.size() >= this.o || this.j || !this.b.a().a(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.k().g(), this.b.a().k().g())) {
            return true;
        }
        if (this.g != null && list != null && !list.isEmpty()) {
            for (os1 os1Var : list) {
                Proxy.Type type = os1Var.b().type();
                Proxy.Type type2 = Proxy.Type.DIRECT;
                if (type == type2 && this.b.b().type() == type2 && Intrinsics.areEqual(this.b.d(), os1Var.d())) {
                    if (address.d() != ae1.f8398a || !a(address.k())) {
                        return false;
                    }
                    try {
                        eo eoVarA = address.a();
                        Intrinsics.checkNotNull(eoVarA);
                        String strG = address.k().g();
                        ff0 ff0Var = this.e;
                        Intrinsics.checkNotNull(ff0Var);
                        eoVarA.a(strG, ff0Var.c());
                        return true;
                    } catch (SSLPeerUnverifiedException unused) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    public final z50 a(be1 client, wn1 chain) throws SocketException {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.d;
        Intrinsics.checkNotNull(socket);
        BufferedSource bufferedSource = this.h;
        Intrinsics.checkNotNull(bufferedSource);
        BufferedSink bufferedSink = this.i;
        Intrinsics.checkNotNull(bufferedSink);
        eh0 eh0Var = this.g;
        if (eh0Var != null) {
            return new jh0(client, this, chain, eh0Var);
        }
        socket.setSoTimeout(chain.h());
        Timeout timeout = bufferedSource.getTimeout();
        long jE = chain.e();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.timeout(jE, timeUnit);
        bufferedSink.getTimeout().timeout(chain.g(), timeUnit);
        return new ch0(client, this, bufferedSource, bufferedSink);
    }

    @Override // com.yandex.mobile.ads.impl.eh0.b
    public final synchronized void a(eh0 connection, sx1 settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.o = settings.c();
    }

    @Override // com.yandex.mobile.ads.impl.eh0.b
    public final void a(lh0 stream) throws IOException {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.a(q50.h, (IOException) null);
    }

    public final void a(long j) {
        this.q = j;
    }

    public final synchronized void a(sn1 call, IOException failure) {
        Intrinsics.checkNotNullParameter(call, "call");
        if (failure instanceof s22) {
            q50 q50Var = ((s22) failure).b;
            if (q50Var == q50.h) {
                int i = this.n + 1;
                this.n = i;
                if (i > 1) {
                    this.j = true;
                    this.l++;
                }
            } else if (q50Var != q50.i || !call.j()) {
                this.j = true;
                this.l++;
            }
        } else if (!h() || (failure instanceof nr)) {
            this.j = true;
            if (this.m == 0) {
                if (failure != null) {
                    be1 client = call.c();
                    os1 failedRoute = this.b;
                    Intrinsics.checkNotNullParameter(client, "client");
                    Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
                    Intrinsics.checkNotNullParameter(failure, "failure");
                    if (failedRoute.b().type() != Proxy.Type.DIRECT) {
                        ab abVarA = failedRoute.a();
                        abVarA.h().connectFailed(abVarA.k().l(), failedRoute.b().address(), failure);
                    }
                    client.n().b(failedRoute);
                }
                this.l++;
            }
        }
    }

    private final boolean a(di0 di0Var) {
        ff0 ff0Var;
        if (y82.f && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        di0 di0VarK = this.b.a().k();
        if (di0Var.i() != di0VarK.i()) {
            return false;
        }
        if (Intrinsics.areEqual(di0Var.g(), di0VarK.g())) {
            return true;
        }
        if (this.k || (ff0Var = this.e) == null) {
            return false;
        }
        Intrinsics.checkNotNull(ff0Var);
        List<Certificate> listC = ff0Var.c();
        if (listC.isEmpty()) {
            return false;
        }
        String strG = di0Var.g();
        Certificate certificate = listC.get(0);
        Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        return ae1.a(strG, (X509Certificate) certificate);
    }

    public final boolean a(boolean z) {
        long j;
        if (y82.f && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.c;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.d;
        Intrinsics.checkNotNull(socket2);
        BufferedSource bufferedSource = this.h;
        Intrinsics.checkNotNull(bufferedSource);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        eh0 eh0Var = this.g;
        if (eh0Var != null) {
            return eh0Var.a(jNanoTime);
        }
        synchronized (this) {
            j = jNanoTime - this.q;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        return y82.a(socket2, bufferedSource);
    }
}

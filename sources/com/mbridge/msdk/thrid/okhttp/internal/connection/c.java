package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.i;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.o;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: RealConnection.java */
/* JADX INFO: loaded from: classes12.dex */
public final class c extends com.mbridge.msdk.thrid.okhttp.internal.http2.g.j implements com.mbridge.msdk.thrid.okhttp.g {
    private final h b;
    private final a0 c;
    private Socket d;
    private Socket e;
    private o f;
    private u g;
    private com.mbridge.msdk.thrid.okhttp.internal.http2.g h;
    private com.mbridge.msdk.thrid.okio.e i;
    private com.mbridge.msdk.thrid.okio.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(h hVar, a0 a0Var) {
        this.b = hVar;
        this.c = a0Var;
    }

    private w e() throws IOException {
        w wVarA = new w.a().a(this.c.a().k()).a("CONNECT", (x) null).b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(this.c.a().k(), true)).b("Proxy-Connection", HttpHeaders.KEEP_ALIVE).b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a()).a();
        w wVarA2 = this.c.a().g().a(this.c, new y.a().a(wVarA).a(u.HTTP_1_1).a(407).a("Preemptive Authenticate").a(com.mbridge.msdk.thrid.okhttp.internal.c.c).b(-1L).a(-1L).b("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return wVarA2 != null ? wVarA2 : wVarA;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x012e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0134  */
    /* JADX WARN: Code duplicated, block: B:58:0x0139  */
    /* JADX WARN: Code duplicated, block: B:76:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[LOOP:0: B:68:0x0087->B:78:?, LOOP_END, SYNTHETIC] */
    public void a(int i, int i2, int i3, int i4, boolean z, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws Throwable {
        if (this.g != null) {
            throw new IllegalStateException("already connected");
        }
        List<i> listB = this.c.a().b();
        b bVar = new b(listB);
        if (this.c.a().j() == null) {
            if (!listB.contains(i.j)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String strG = this.c.a().k().g();
            if (!com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().b(strG)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + strG + " not permitted by network security policy"));
            }
        } else if (this.c.a().e().contains(u.H2_PRIOR_KNOWLEDGE)) {
            throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        e eVar = null;
        while (true) {
            try {
                if (this.c.c()) {
                    a(i, i2, i3, dVar, nVar);
                    if (this.d == null) {
                        break;
                    }
                } else {
                    try {
                        a(i, i2, dVar, nVar);
                    } catch (IOException e) {
                        e = e;
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.e);
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
                        this.e = null;
                        this.d = null;
                        this.i = null;
                        this.j = null;
                        this.f = null;
                        this.g = null;
                        this.h = null;
                        nVar.connectFailed(dVar, this.c.d(), this.c.b(), null, e);
                        if (eVar == null) {
                            eVar = new e(e);
                        } else {
                            eVar.a(e);
                        }
                        if (z) {
                            throw eVar;
                        }
                        if (bVar.a(e)) {
                            throw eVar;
                        }
                    }
                }
                try {
                    a(bVar, i4, dVar, nVar);
                    nVar.connectEnd(dVar, this.c.d(), this.c.b(), this.g);
                    break;
                } catch (IOException e2) {
                    e = e2;
                    com.mbridge.msdk.thrid.okhttp.internal.c.a(this.e);
                    com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
                    this.e = null;
                    this.d = null;
                    this.i = null;
                    this.j = null;
                    this.f = null;
                    this.g = null;
                    this.h = null;
                    nVar.connectFailed(dVar, this.c.d(), this.c.b(), null, e);
                    if (eVar == null) {
                        eVar = new e(e);
                    } else {
                        eVar.a(e);
                    }
                    if (z) {
                        throw eVar;
                    }
                    if (bVar.a(e)) {
                        throw eVar;
                    }
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        if (this.c.c() && this.d == null) {
            throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
        }
        if (this.h != null) {
            synchronized (this.b) {
                this.m = this.h.k();
            }
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public o b() {
        return this.f;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public a0 c() {
        return this.c;
    }

    public void d() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
    }

    public boolean f() {
        return this.h != null;
    }

    public Socket g() {
        return this.e;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.c.a().k().g()).append(":").append(this.c.a().k().j()).append(", proxy=").append(this.c.b()).append(" hostAddress=").append(this.c.d()).append(" cipherSuite=");
        o oVar = this.f;
        return sbAppend.append(oVar != null ? oVar.a() : "none").append(" protocol=").append(this.g).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private void a(int i, int i2, int i3, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        w wVarE = e();
        q qVarG = wVarE.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, dVar, nVar);
            wVarE = a(i2, i3, wVarE, qVarG);
            if (wVarE == null) {
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
            this.d = null;
            this.j = null;
            this.i = null;
            nVar.connectEnd(dVar, this.c.d(), this.c.b(), null);
        }
    }

    private void a(int i, int i2, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        Proxy proxyB = this.c.b();
        this.d = (proxyB.type() == Proxy.Type.DIRECT || proxyB.type() == Proxy.Type.HTTP) ? this.c.a().i().createSocket() : new Socket(proxyB);
        nVar.connectStart(dVar, this.c.d(), proxyB);
        this.d.setSoTimeout(i2);
        try {
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(this.d, this.c.d(), i);
            try {
                this.i = l.a(l.b(this.d));
                this.j = l.a(l.a(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.c.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws Throwable {
        if (this.c.a().j() == null) {
            List<u> listE = this.c.a().e();
            u uVar = u.H2_PRIOR_KNOWLEDGE;
            if (listE.contains(uVar)) {
                this.e = this.d;
                this.g = uVar;
                a(i);
                return;
            } else {
                this.e = this.d;
                this.g = u.HTTP_1_1;
                return;
            }
        }
        nVar.secureConnectStart(dVar);
        a(bVar);
        nVar.secureConnectEnd(dVar, this.f);
        if (this.g == u.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.e.setSoTimeout(0);
        com.mbridge.msdk.thrid.okhttp.internal.http2.g gVarA = new com.mbridge.msdk.thrid.okhttp.internal.http2.g.h(true).a(this.e, this.c.a().k().g(), this.i, this.j).a(this).a(i).a();
        this.h = gVarA;
        gVarA.m();
    }

    private void a(b bVar) throws Throwable {
        com.mbridge.msdk.thrid.okhttp.a aVarA = this.c.a();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) aVarA.j().createSocket(this.d, aVarA.k().g(), aVarA.k().j(), true);
                try {
                    i iVarA = bVar.a(sSLSocket2);
                    if (iVarA.c()) {
                        com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket2, aVarA.k().g(), aVarA.e());
                    }
                    sSLSocket2.startHandshake();
                    SSLSession session = sSLSocket2.getSession();
                    o oVarA = o.a(session);
                    if (!aVarA.d().verify(aVarA.k().g(), session)) {
                        List<Certificate> listB = oVarA.b();
                        if (!listB.isEmpty()) {
                            X509Certificate x509Certificate = (X509Certificate) listB.get(0);
                            throw new SSLPeerUnverifiedException("Hostname " + aVarA.k().g() + " not verified:\n    certificate: " + com.mbridge.msdk.thrid.okhttp.e.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.mbridge.msdk.thrid.okhttp.internal.tls.d.a(x509Certificate));
                        }
                        throw new SSLPeerUnverifiedException("Hostname " + aVarA.k().g() + " not verified (no certificates)");
                    }
                    aVarA.a().a(aVarA.k().g(), oVarA.b());
                    String strB = iVarA.c() ? com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().b(sSLSocket2) : null;
                    this.e = sSLSocket2;
                    this.i = l.a(l.b(sSLSocket2));
                    this.j = l.a(l.a(this.e));
                    this.f = oVarA;
                    this.g = strB != null ? u.a(strB) : u.HTTP_1_1;
                    com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket2);
                } catch (AssertionError e) {
                    e = e;
                    if (!com.mbridge.msdk.thrid.okhttp.internal.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket);
                    }
                    com.mbridge.msdk.thrid.okhttp.internal.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (AssertionError e2) {
            e = e2;
        }
    }

    private w a(int i, int i2, w wVar, q qVar) throws IOException {
        String str = "CONNECT " + com.mbridge.msdk.thrid.okhttp.internal.c.a(qVar, true) + " HTTP/1.1";
        while (true) {
            com.mbridge.msdk.thrid.okhttp.internal.http1.a aVar = new com.mbridge.msdk.thrid.okhttp.internal.http1.a(null, null, this.i, this.j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.i.b().a(i, timeUnit);
            this.j.b().a(i2, timeUnit);
            aVar.a(wVar.c(), str);
            aVar.a();
            y yVarA = aVar.a(false).a(wVar).a();
            long jA = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(yVarA);
            if (jA == -1) {
                jA = 0;
            }
            s sVarB = aVar.b(jA);
            com.mbridge.msdk.thrid.okhttp.internal.c.b(sVarB, Integer.MAX_VALUE, timeUnit);
            sVarB.close();
            int iK = yVarA.k();
            if (iK == 200) {
                if (this.i.a().f() && this.j.a().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iK == 407) {
                w wVarA = this.c.a().g().a(this.c, yVarA);
                if (wVarA != null) {
                    if ("close".equalsIgnoreCase(yVarA.b("Connection"))) {
                        return wVarA;
                    }
                    wVar = wVarA;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + yVarA.k());
            }
        }
    }

    public boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, @Nullable a0 a0Var) {
        if (this.n.size() >= this.m || this.k || !com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(this.c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(c().a().k().g())) {
            return true;
        }
        if (this.h == null || a0Var == null || a0Var.b().type() != Proxy.Type.DIRECT || this.c.b().type() != Proxy.Type.DIRECT || !this.c.d().equals(a0Var.d()) || a0Var.a().d() != com.mbridge.msdk.thrid.okhttp.internal.tls.d.f5566a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), b().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(q qVar) {
        if (qVar.j() != this.c.a().k().j()) {
            return false;
        }
        if (qVar.g().equals(this.c.a().k().g())) {
            return true;
        }
        return this.f != null && com.mbridge.msdk.thrid.okhttp.internal.tls.d.f5566a.a(qVar.g(), (X509Certificate) this.f.b().get(0));
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c a(t tVar, r.a aVar, g gVar) throws SocketException {
        if (this.h != null) {
            return new com.mbridge.msdk.thrid.okhttp.internal.http2.f(tVar, aVar, gVar, this.h);
        }
        this.e.setSoTimeout(aVar.b());
        com.mbridge.msdk.thrid.okio.t tVarB = this.i.b();
        long jB = aVar.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        tVarB.a(jB, timeUnit);
        this.j.b().a(aVar.c(), timeUnit);
        return new com.mbridge.msdk.thrid.okhttp.internal.http1.a(tVar, gVar, this.i, this.j);
    }

    public boolean a(boolean z) {
        if (this.e.isClosed() || this.e.isInputShutdown() || this.e.isOutputShutdown()) {
            return false;
        }
        com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar = this.h;
        if (gVar != null) {
            return gVar.f(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.e.getSoTimeout();
                try {
                    this.e.setSoTimeout(1);
                    if (this.i.f()) {
                        this.e.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.e.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException {
        iVar.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar) {
        synchronized (this.b) {
            this.m = gVar.k();
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public u a() {
        return this.g;
    }
}

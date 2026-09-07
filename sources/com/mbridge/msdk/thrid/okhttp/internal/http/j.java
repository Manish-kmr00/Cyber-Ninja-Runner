package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f5530a;
    private final boolean b;
    private volatile com.mbridge.msdk.thrid.okhttp.internal.connection.g c;
    private Object d;
    private volatile boolean e;

    public j(t tVar, boolean z) {
        this.f5530a = tVar;
        this.b = z;
    }

    public void a() {
        this.e = true;
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean b() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        w wVarD = aVar.d();
        g gVar = (g) aVar;
        com.mbridge.msdk.thrid.okhttp.d dVarE = gVar.e();
        n nVarG = gVar.g();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar2 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f5530a.f(), a(wVarD.g()), dVarE, nVarG, this.d);
        this.c = gVar2;
        int i = 0;
        y yVar = null;
        while (!this.e) {
            try {
                try {
                    y yVarA = gVar.a(wVarD, gVar2, null, null);
                    if (yVar != null) {
                        yVarA = yVarA.o().d(yVar.o().a((z) null).a()).a();
                    }
                    try {
                        w wVarA = a(yVarA, gVar2.h());
                        if (wVarA == null) {
                            gVar2.f();
                            return yVarA;
                        }
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(yVarA.d());
                        int i2 = i + 1;
                        if (i2 <= 20) {
                            wVarA.a();
                            if (!a(yVarA, wVarA.g())) {
                                gVar2.f();
                                gVar2 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f5530a.f(), a(wVarA.g()), dVarE, nVarG, this.d);
                                this.c = gVar2;
                            } else if (gVar2.b() != null) {
                                throw new IllegalStateException("Closing the body of " + yVarA + " didn't close its backing stream. Bad interceptor?");
                            }
                            yVar = yVarA;
                            wVarD = wVarA;
                            i = i2;
                        } else {
                            gVar2.f();
                            throw new ProtocolException("Too many follow-up requests: " + i2);
                        }
                    } catch (IOException e) {
                        gVar2.f();
                        throw e;
                    }
                } catch (com.mbridge.msdk.thrid.okhttp.internal.connection.e e2) {
                    if (!a(e2.b(), gVar2, false, wVarD)) {
                        throw e2.a();
                    }
                } catch (IOException e3) {
                    if (!a(e3, gVar2, !(e3 instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.a), wVarD)) {
                        throw e3;
                    }
                }
            } catch (Throwable th) {
                gVar2.a((IOException) null);
                gVar2.f();
                throw th;
            }
        }
        gVar2.f();
        throw new IOException("Canceled");
    }

    private com.mbridge.msdk.thrid.okhttp.a a(q qVar) {
        SSLSocketFactory sSLSocketFactoryB;
        HostnameVerifier hostnameVerifierO;
        com.mbridge.msdk.thrid.okhttp.e eVarC;
        if (qVar.h()) {
            sSLSocketFactoryB = this.f5530a.B();
            hostnameVerifierO = this.f5530a.o();
            eVarC = this.f5530a.c();
        } else {
            sSLSocketFactoryB = null;
            hostnameVerifierO = null;
            eVarC = null;
        }
        return new com.mbridge.msdk.thrid.okhttp.a(qVar.g(), qVar.j(), this.f5530a.k(), this.f5530a.A(), sSLSocketFactoryB, hostnameVerifierO, eVarC, this.f5530a.w(), this.f5530a.v(), this.f5530a.u(), this.f5530a.g(), this.f5530a.x());
    }

    private boolean a(IOException iOException, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, boolean z, w wVar) {
        gVar.a(iOException);
        if (this.f5530a.z()) {
            return !(z && a(iOException, wVar)) && a(iOException, z) && gVar.d();
        }
        return false;
    }

    private boolean a(IOException iOException, w wVar) {
        wVar.a();
        return iOException instanceof FileNotFoundException;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return (iOException instanceof SocketTimeoutException) && !z;
        }
        return (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private w a(y yVar, a0 a0Var) throws IOException {
        String strB;
        q qVarE;
        if (yVar != null) {
            int iK = yVar.k();
            String strE = yVar.r().e();
            if (iK == 307 || iK == 308) {
                if (!strE.equals("GET") && !strE.equals("HEAD")) {
                    return null;
                }
            } else {
                if (iK == 401) {
                    return this.f5530a.a().a(a0Var, yVar);
                }
                if (iK == 503) {
                    if ((yVar.p() == null || yVar.p().k() != 503) && a(yVar, Integer.MAX_VALUE) == 0) {
                        return yVar.r();
                    }
                    return null;
                }
                if (iK == 407) {
                    if (a0Var.b().type() == Proxy.Type.HTTP) {
                        return this.f5530a.w().a(a0Var, yVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (iK == 408) {
                    if (!this.f5530a.z()) {
                        return null;
                    }
                    yVar.r().a();
                    if ((yVar.p() == null || yVar.p().k() != 408) && a(yVar, 0) <= 0) {
                        return yVar.r();
                    }
                    return null;
                }
                switch (iK) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f5530a.m() || (strB = yVar.b("Location")) == null || (qVarE = yVar.r().g().e(strB)) == null) {
                return null;
            }
            if (!qVarE.l().equals(yVar.r().g().l()) && !this.f5530a.n()) {
                return null;
            }
            w.a aVarF = yVar.r().f();
            if (f.a(strE)) {
                boolean zC = f.c(strE);
                if (f.b(strE)) {
                    aVarF.a("GET", (x) null);
                } else {
                    aVarF.a(strE, zC ? yVar.r().a() : null);
                }
                if (!zC) {
                    aVarF.a(HttpHeaders.TRANSFER_ENCODING);
                    aVarF.a("Content-Length");
                    aVarF.a("Content-Type");
                }
            }
            if (!a(yVar, qVarE)) {
                aVarF.a("Authorization");
            }
            return aVarF.a(qVarE).a();
        }
        throw new IllegalStateException();
    }

    private int a(y yVar, int i) {
        String strB = yVar.b(HttpHeaders.RETRY_AFTER);
        if (strB == null) {
            return i;
        }
        if (strB.matches("\\d+")) {
            return Integer.valueOf(strB).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(y yVar, q qVar) {
        q qVarG = yVar.r().g();
        return qVarG.g().equals(qVar.g()) && qVarG.j() == qVar.j() && qVarG.l().equals(qVar.l());
    }
}

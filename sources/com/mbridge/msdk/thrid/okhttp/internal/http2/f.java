package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.thrid.okio.s;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Http2Codec.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements com.mbridge.msdk.thrid.okhttp.internal.http.c {
    private static final List<String> f = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", CreativeInfoManager.b, "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> g = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", CreativeInfoManager.b, "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r.a f5542a;
    final com.mbridge.msdk.thrid.okhttp.internal.connection.g b;
    private final g c;
    private i d;
    private final u e;

    /* JADX INFO: compiled from: Http2Codec.java */
    class a extends com.mbridge.msdk.thrid.okio.h {
        boolean b;
        long c;

        a(s sVar) {
            super(sVar);
            this.b = false;
            this.c = 0L;
        }

        private void a(IOException iOException) {
            if (this.b) {
                return;
            }
            this.b = true;
            f fVar = f.this;
            fVar.b.a(false, fVar, this.c, iOException);
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            try {
                long jB = d().b(cVar, j);
                if (jB > 0) {
                    this.c += jB;
                }
                return jB;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.h, com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }
    }

    public f(t tVar, r.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, g gVar2) {
        this.f5542a = aVar;
        this.b = gVar;
        this.c = gVar2;
        List<u> listU = tVar.u();
        u uVar = u.H2_PRIOR_KNOWLEDGE;
        this.e = listU.contains(uVar) ? uVar : u.HTTP_2;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public com.mbridge.msdk.thrid.okio.r a(w wVar, long j) {
        return this.d.d();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void b() throws IOException {
        this.c.flush();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void cancel() {
        i iVar = this.d;
        if (iVar != null) {
            iVar.c(b.CANCEL);
        }
    }

    public static List<c> b(w wVar) {
        p pVarC = wVar.c();
        ArrayList arrayList = new ArrayList(pVarC.b() + 4);
        arrayList.add(new c(c.f, wVar.e()));
        arrayList.add(new c(c.g, com.mbridge.msdk.thrid.okhttp.internal.http.i.a(wVar.g())));
        String strA = wVar.a(HttpHeaders.HOST);
        if (strA != null) {
            arrayList.add(new c(c.i, strA));
        }
        arrayList.add(new c(c.h, wVar.g().l()));
        int iB = pVarC.b();
        for (int i = 0; i < iB; i++) {
            com.mbridge.msdk.thrid.okio.f fVarC = com.mbridge.msdk.thrid.okio.f.c(pVarC.a(i).toLowerCase(Locale.US));
            if (!f.contains(fVarC.h())) {
                arrayList.add(new c(fVarC, pVarC.b(i)));
            }
        }
        return arrayList;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a(w wVar) throws IOException {
        if (this.d != null) {
            return;
        }
        i iVarA = this.c.a(b(wVar), wVar.a() != null);
        this.d = iVarA;
        com.mbridge.msdk.thrid.okio.t tVarH = iVarA.h();
        long jB = this.f5542a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        tVarH.a(jB, timeUnit);
        this.d.l().a(this.f5542a.c(), timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a() throws IOException {
        this.d.d().close();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public y.a a(boolean z) throws IOException {
        y.a aVarA = a(this.d.j(), this.e);
        if (z && com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(aVarA) == 100) {
            return null;
        }
        return aVarA;
    }

    public static y.a a(p pVar, u uVar) throws IOException {
        p.a aVar = new p.a();
        int iB = pVar.b();
        com.mbridge.msdk.thrid.okhttp.internal.http.k kVarA = null;
        for (int i = 0; i < iB; i++) {
            String strA = pVar.a(i);
            String strB = pVar.b(i);
            if (strA.equals(":status")) {
                kVarA = com.mbridge.msdk.thrid.okhttp.internal.http.k.a("HTTP/1.1 " + strB);
            } else if (!g.contains(strA)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(aVar, strA, strB);
            }
        }
        if (kVarA != null) {
            return new y.a().a(uVar).a(kVarA.b).a(kVarA.c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public z a(y yVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.b;
        gVar.f.responseBodyStart(gVar.e);
        return new com.mbridge.msdk.thrid.okhttp.internal.http.h(yVar.b("Content-Type"), com.mbridge.msdk.thrid.okhttp.internal.http.e.a(yVar), com.mbridge.msdk.thrid.okio.l.a(new a(this.d.e())));
    }
}

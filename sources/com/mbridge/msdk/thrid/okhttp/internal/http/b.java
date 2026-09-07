package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: CallServerInterceptor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f5525a;

    /* JADX INFO: compiled from: CallServerInterceptor.java */
    static final class a extends com.mbridge.msdk.thrid.okio.g {
        long b;

        a(com.mbridge.msdk.thrid.okio.r rVar) {
            super(rVar);
        }

        @Override // com.mbridge.msdk.thrid.okio.g, com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.b += j;
        }
    }

    public b(boolean z) {
        this.f5525a = z;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        g gVar = (g) aVar;
        c cVarH = gVar.h();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVarI = gVar.i();
        com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar = (com.mbridge.msdk.thrid.okhttp.internal.connection.c) gVar.f();
        w wVarD = gVar.d();
        long jCurrentTimeMillis = System.currentTimeMillis();
        gVar.g().requestHeadersStart(gVar.e());
        cVarH.a(wVarD);
        gVar.g().requestHeadersEnd(gVar.e(), wVarD);
        y.a aVarA = null;
        if (f.a(wVarD.e()) && wVarD.a() != null) {
            if ("100-continue".equalsIgnoreCase(wVarD.a(HttpHeaders.EXPECT))) {
                cVarH.b();
                gVar.g().responseHeadersStart(gVar.e());
                aVarA = cVarH.a(true);
            }
            if (aVarA == null) {
                gVar.g().requestBodyStart(gVar.e());
                a aVar2 = new a(cVarH.a(wVarD, wVarD.a().a()));
                com.mbridge.msdk.thrid.okio.d dVarA = l.a(aVar2);
                wVarD.a().a(dVarA);
                dVarA.close();
                gVar.g().requestBodyEnd(gVar.e(), aVar2.b);
            } else if (!cVar.f()) {
                gVarI.e();
            }
        }
        cVarH.a();
        if (aVarA == null) {
            gVar.g().responseHeadersStart(gVar.e());
            aVarA = cVarH.a(false);
        }
        y yVarA = aVarA.a(wVarD).a(gVarI.c().b()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
        int iK = yVarA.k();
        if (iK == 100) {
            yVarA = cVarH.a(false).a(wVarD).a(gVarI.c().b()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
            iK = yVarA.k();
        }
        gVar.g().responseHeadersEnd(gVar.e(), yVarA);
        y yVarA2 = (this.f5525a && iK == 101) ? yVarA.o().a(com.mbridge.msdk.thrid.okhttp.internal.c.c).a() : yVarA.o().a(cVarH.a(yVarA)).a();
        if ("close".equalsIgnoreCase(yVarA2.r().a("Connection")) || "close".equalsIgnoreCase(yVarA2.b("Connection"))) {
            gVarI.e();
        }
        if ((iK == 204 || iK == 205) && yVarA2.d().h() > 0) {
            throw new ProtocolException("HTTP " + iK + " had non-zero Content-Length: " + yVarA2.d().h());
        }
        return yVarA2;
    }
}

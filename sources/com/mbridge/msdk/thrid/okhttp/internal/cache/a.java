package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.IOException;

/* JADX INFO: compiled from: CacheInterceptor.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements r {
    public a(c cVar) {
    }

    static boolean b(String str) {
        return ("Connection".equalsIgnoreCase(str) || HttpHeaders.KEEP_ALIVE.equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        b bVarC = new b.a(System.currentTimeMillis(), aVar.d(), null).c();
        w wVar = bVarC.f5514a;
        y yVar = bVarC.b;
        if (wVar == null && yVar == null) {
            return new y.a().a(aVar.d()).a(u.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.mbridge.msdk.thrid.okhttp.internal.c.c).b(-1L).a(System.currentTimeMillis()).a();
        }
        if (wVar == null) {
            return yVar.o().a(a(yVar)).a();
        }
        y yVarA = aVar.a(wVar);
        if (yVar != null) {
            if (yVarA.k() == 304) {
                yVar.o().a(a(yVar.m(), yVarA.m())).b(yVarA.s()).a(yVarA.q()).a(a(yVar)).c(a(yVarA)).a();
                yVarA.d().close();
                throw null;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(yVar.d());
        }
        return yVarA.o().a(a(yVar)).c(a(yVarA)).a();
    }

    private static y a(y yVar) {
        return (yVar == null || yVar.d() == null) ? yVar : yVar.o().a((z) null).a();
    }

    private static p a(p pVar, p pVar2) {
        p.a aVar = new p.a();
        int iB = pVar.b();
        for (int i = 0; i < iB; i++) {
            String strA = pVar.a(i);
            String strB = pVar.b(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(strA) || !strB.startsWith("1")) && (a(strA) || !b(strA) || pVar2.b(strA) == null)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(aVar, strA, strB);
            }
        }
        int iB2 = pVar2.b();
        for (int i2 = 0; i2 < iB2; i2++) {
            String strA2 = pVar2.a(i2);
            if (!a(strA2) && b(strA2)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f5510a.a(aVar, strA2, pVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}

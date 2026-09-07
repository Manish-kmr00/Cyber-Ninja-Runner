package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.json.cc;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: BridgeInterceptor.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.thrid.okhttp.k f5524a;

    public a(com.mbridge.msdk.thrid.okhttp.k kVar) {
        this.f5524a = kVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        w wVarD = aVar.d();
        w.a aVarF = wVarD.f();
        x xVarA = wVarD.a();
        if (xVarA != null) {
            xVarA.b();
            long jA = xVarA.a();
            if (jA != -1) {
                aVarF.b("Content-Length", Long.toString(jA));
                aVarF.a(HttpHeaders.TRANSFER_ENCODING);
            } else {
                aVarF.b(HttpHeaders.TRANSFER_ENCODING, "chunked");
                aVarF.a("Content-Length");
            }
        }
        boolean z = false;
        if (wVarD.a(HttpHeaders.HOST) == null) {
            aVarF.b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(wVarD.g(), false));
        }
        if (wVarD.a("Connection") == null) {
            aVarF.b("Connection", HttpHeaders.KEEP_ALIVE);
        }
        if (wVarD.a(HttpHeaders.ACCEPT_ENCODING) == null && wVarD.a("Range") == null) {
            aVarF.b(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> listA = this.f5524a.a(wVarD.g());
        if (!listA.isEmpty()) {
            aVarF.b(HttpHeaders.COOKIE, a(listA));
        }
        if (wVarD.a("User-Agent") == null) {
            aVarF.b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a());
        }
        y yVarA = aVar.a(aVarF.a());
        e.a(this.f5524a, wVarD.g(), yVarA.m());
        y.a aVarA = yVarA.o().a(wVarD);
        if (z && "gzip".equalsIgnoreCase(yVarA.b("Content-Encoding")) && e.b(yVarA)) {
            com.mbridge.msdk.thrid.okio.j jVar = new com.mbridge.msdk.thrid.okio.j(yVarA.d().k());
            aVarA.a(yVarA.m().a().b("Content-Encoding").b("Content-Length").a());
            aVarA.a(new h(yVarA.b("Content-Type"), -1L, l.a(jVar)));
        }
        return aVarA.a();
    }

    private String a(List<com.mbridge.msdk.thrid.okhttp.j> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            com.mbridge.msdk.thrid.okhttp.j jVar = list.get(i);
            sb.append(jVar.a()).append(cc.T).append(jVar.b());
        }
        return sb.toString();
    }
}

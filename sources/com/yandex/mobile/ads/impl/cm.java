package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.GzipSource;
import okio.Okio;

/* JADX INFO: loaded from: classes13.dex */
public final class cm implements ip0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ns f8624a;

    public cm(ns cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.f8624a = cookieJar;
    }

    @Override // com.yandex.mobile.ads.impl.ip0
    public final oq1 a(wn1 chain) throws IOException {
        boolean z;
        sq1 sq1VarA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        op1 op1VarI = chain.i();
        op1VarI.getClass();
        op1.a aVar = new op1.a(op1VarI);
        rp1 rp1VarA = op1VarI.a();
        if (rp1VarA != null) {
            yw0 yw0VarB = rp1VarA.b();
            if (yw0VarB != null) {
                aVar.b("Content-Type", yw0VarB.toString());
            }
            long jA = rp1VarA.a();
            if (jA != -1) {
                aVar.b("Content-Length", String.valueOf(jA));
                aVar.a(HttpHeaders.TRANSFER_ENCODING);
            } else {
                aVar.b(HttpHeaders.TRANSFER_ENCODING, "chunked");
                aVar.a("Content-Length");
            }
        }
        int i = 0;
        if (op1VarI.a(HttpHeaders.HOST) == null) {
            aVar.b(HttpHeaders.HOST, y82.a(op1VarI.g(), false));
        }
        if (op1VarI.a("Connection") == null) {
            aVar.b("Connection", HttpHeaders.KEEP_ALIVE);
        }
        if (op1VarI.a(HttpHeaders.ACCEPT_ENCODING) == null && op1VarI.a("Range") == null) {
            aVar.b(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        } else {
            z = false;
        }
        List<ls> listA = this.f8624a.a(op1VarI.g());
        if (!listA.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listA) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ls lsVar = (ls) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(lsVar.e()).append(com.json.cc.T).append(lsVar.f());
                i = i2;
            }
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            aVar.b(HttpHeaders.COOKIE, string);
        }
        if (op1VarI.a("User-Agent") == null) {
            aVar.b("User-Agent", "okhttp/4.9.3");
        }
        oq1 oq1VarA = chain.a(aVar.a());
        uh0.a(this.f8624a, op1VarI.g(), oq1VarA.g());
        oq1.a aVarA = new oq1.a(oq1VarA).a(op1VarI);
        if (z && StringsKt.equals("gzip", oq1.a(oq1VarA, "Content-Encoding"), true) && uh0.a(oq1VarA) && (sq1VarA = oq1VarA.a()) != null) {
            GzipSource gzipSource = new GzipSource(sq1VarA.c());
            aVarA.a(oq1VarA.g().b().a("Content-Encoding").a("Content-Length").a());
            aVarA.a(new xn1(oq1.a(oq1VarA, "Content-Type"), -1L, Okio.buffer(gzipSource)));
        }
        return aVarA.a();
    }
}

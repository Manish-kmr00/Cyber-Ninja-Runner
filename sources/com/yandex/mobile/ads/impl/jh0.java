package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import com.safedk.android.analytics.brandsafety.creatives.CreativeInfoManager;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okio.Sink;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class jh0 implements z50 {
    private static final List<String> g = y82.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", CreativeInfoManager.b, "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> h = y82.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", CreativeInfoManager.b, "upgrade");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final tn1 f9317a;
    private final wn1 b;
    private final eh0 c;
    private volatile lh0 d;
    private final im1 e;
    private volatile boolean f;

    public static final class a {
        public static oq1.a a(nf0 headerBlock, im1 protocol) throws IOException {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            nf0.a aVar = new nf0.a();
            int size = headerBlock.size();
            m22 m22VarA = null;
            for (int i = 0; i < size; i++) {
                String strA = headerBlock.a(i);
                String strB = headerBlock.b(i);
                if (Intrinsics.areEqual(strA, ":status")) {
                    m22VarA = m22.a.a("HTTP/1.1 " + strB);
                } else if (!jh0.h.contains(strA)) {
                    aVar.a(strA, strB);
                }
            }
            if (m22VarA != null) {
                return new oq1.a().a(protocol).a(m22VarA.b).a(m22VarA.c).a(aVar.a());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public jh0(be1 client, tn1 connection, wn1 chain, eh0 http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.f9317a = connection;
        this.b = chain;
        this.c = http2Connection;
        List<im1> listR = client.r();
        im1 im1Var = im1.h;
        this.e = listR.contains(im1Var) ? im1Var : im1.g;
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final Sink a(op1 request, long j) {
        Intrinsics.checkNotNullParameter(request, "request");
        lh0 lh0Var = this.d;
        Intrinsics.checkNotNull(lh0Var);
        return lh0Var.j();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final tn1 c() {
        return this.f9317a;
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void b() throws IOException {
        this.c.flush();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final long b(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (uh0.a(response)) {
            return y82.a(response);
        }
        return 0L;
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void cancel() {
        this.f = true;
        lh0 lh0Var = this.d;
        if (lh0Var != null) {
            lh0Var.a(q50.i);
        }
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void a() throws IOException {
        lh0 lh0Var = this.d;
        Intrinsics.checkNotNull(lh0Var);
        lh0Var.j().close();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final Source a(oq1 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        lh0 lh0Var = this.d;
        Intrinsics.checkNotNull(lh0Var);
        return lh0Var.l();
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final oq1.a a(boolean z) throws IOException {
        lh0 lh0Var = this.d;
        Intrinsics.checkNotNull(lh0Var);
        oq1.a aVarA = a.a(lh0Var.s(), this.e);
        if (z && aVarA.b() == 100) {
            return null;
        }
        return aVarA;
    }

    @Override // com.yandex.mobile.ads.impl.z50
    public final void a(op1 request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.d != null) {
            return;
        }
        boolean z = request.a() != null;
        Intrinsics.checkNotNullParameter(request, "request");
        nf0 nf0VarD = request.d();
        ArrayList arrayList = new ArrayList(nf0VarD.size() + 4);
        arrayList.add(new if0(if0.f, request.f()));
        arrayList.add(new if0(if0.g, vp1.a(request.g())));
        String strA = request.a(HttpHeaders.HOST);
        if (strA != null) {
            arrayList.add(new if0(if0.i, strA));
        }
        arrayList.add(new if0(if0.h, request.g().k()));
        int size = nf0VarD.size();
        for (int i = 0; i < size; i++) {
            String strA2 = nf0VarD.a(i);
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = strA2.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (!g.contains(lowerCase) || (Intrinsics.areEqual(lowerCase, "te") && Intrinsics.areEqual(nf0VarD.b(i), "trailers"))) {
                arrayList.add(new if0(lowerCase, nf0VarD.b(i)));
            }
        }
        this.d = this.c.a(arrayList, z);
        if (!this.f) {
            lh0 lh0Var = this.d;
            Intrinsics.checkNotNull(lh0Var);
            lh0.c cVarR = lh0Var.r();
            long jE = this.b.e();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            cVarR.timeout(jE, timeUnit);
            lh0 lh0Var2 = this.d;
            Intrinsics.checkNotNull(lh0Var2);
            lh0Var2.u().timeout(this.b.g(), timeUnit);
            return;
        }
        lh0 lh0Var3 = this.d;
        Intrinsics.checkNotNull(lh0Var3);
        lh0Var3.a(q50.i);
        throw new IOException("Canceled");
    }
}

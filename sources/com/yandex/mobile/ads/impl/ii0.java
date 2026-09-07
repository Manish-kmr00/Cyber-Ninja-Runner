package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ii0 extends mk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f9223a;
    private final ge1 b;

    @Override // com.yandex.mobile.ads.impl.mk
    public final zh0 a(np1<?> request, Map<String, String> additionalHeaders) throws zh, NoSuchAlgorithmException, IOException, KeyStoreException {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(additionalHeaders, "additionalHeaders");
        int iJ = request.j();
        int i = ce1.c;
        be1 be1VarA = ce1.a(iJ, iJ, this.f9223a);
        op1 request2 = this.b.a(request, additionalHeaders);
        Intrinsics.checkNotNullParameter(request2, "request");
        oq1 response = new sn1(be1VarA, request2, false).b();
        int iD = response.d();
        TreeMap requestHeaders = response.g().c();
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : requestHeaders.entrySet()) {
            String str = (String) entry.getKey();
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                arrayList.add(new hf0(str, (String) it.next()));
            }
        }
        if (request.f() == 4 || ((100 <= iD && iD < 200) || iD == 204 || iD == 304)) {
            return new zh0(iD, arrayList, -1, null);
        }
        sq1 sq1VarA = response.a();
        int iA = sq1VarA != null ? (int) sq1VarA.a() : 0;
        Intrinsics.checkNotNullParameter(response, "response");
        sq1 sq1VarA2 = response.a();
        return new zh0(iD, arrayList, iA, sq1VarA2 != null ? sq1VarA2.c().inputStream() : null);
    }

    public ii0(m82 m82Var, SSLSocketFactory sSLSocketFactory) {
        this.f9223a = sSLSocketFactory;
        this.b = new ge1(m82Var);
    }
}

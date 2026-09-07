package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class cn implements ip0 {

    public static final class a {
        public static final nf0 a(nf0 nf0Var, nf0 nf0Var2) {
            nf0.a aVar = new nf0.a();
            int size = nf0Var.size();
            for (int i = 0; i < size; i++) {
                String strA = nf0Var.a(i);
                String strB = nf0Var.b(i);
                if ((!StringsKt.equals(HttpHeaders.WARNING, strA, true) || !StringsKt.startsWith$default(strB, "1", false, 2, (Object) null)) && (StringsKt.equals("Content-Length", strA, true) || StringsKt.equals("Content-Encoding", strA, true) || StringsKt.equals("Content-Type", strA, true) || !a(strA) || nf0Var2.a(strA) == null)) {
                    aVar.a(strA, strB);
                }
            }
            int size2 = nf0Var2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strA2 = nf0Var2.a(i2);
                if (!StringsKt.equals("Content-Length", strA2, true) && !StringsKt.equals("Content-Encoding", strA2, true) && !StringsKt.equals("Content-Type", strA2, true) && a(strA2)) {
                    aVar.a(strA2, nf0Var2.b(i2));
                }
            }
            return aVar.a();
        }

        public static final oq1 a(oq1 oq1Var) {
            if ((oq1Var != null ? oq1Var.a() : null) == null) {
                return oq1Var;
            }
            oq1Var.getClass();
            return new oq1.a(oq1Var).a((sq1) null).a();
        }

        private static boolean a(String str) {
            return (StringsKt.equals("Connection", str, true) || StringsKt.equals(HttpHeaders.KEEP_ALIVE, str, true) || StringsKt.equals("Proxy-Authenticate", str, true) || StringsKt.equals(HttpHeaders.PROXY_AUTHORIZATION, str, true) || StringsKt.equals(HttpHeaders.TE, str, true) || StringsKt.equals("Trailers", str, true) || StringsKt.equals(HttpHeaders.TRANSFER_ENCODING, str, true) || StringsKt.equals(HttpHeaders.UPGRADE, str, true)) ? false : true;
        }

        private a() {
        }

        public /* synthetic */ a(int i) {
            this();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ip0
    public final oq1 a(wn1 chain) throws IOException {
        t50 t50VarE;
        Intrinsics.checkNotNullParameter(chain, "chain");
        sn1 call = chain.a();
        fn fnVarA = new fn.a(System.currentTimeMillis(), chain.i()).a();
        op1 op1VarB = fnVarA.b();
        oq1 cachedResponse = fnVarA.a();
        sn1 sn1Var = call instanceof sn1 ? call : null;
        if (sn1Var == null || (t50VarE = sn1Var.e()) == null) {
            t50VarE = t50.f10269a;
        }
        if (op1VarB == null && cachedResponse == null) {
            oq1 response = new oq1.a().a(chain.i()).a(im1.e).a(504).a("Unsatisfiable Request (only-if-cached)").a(y82.c).b(-1L).a(System.currentTimeMillis()).a();
            t50VarE.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            return response;
        }
        if (op1VarB == null) {
            Intrinsics.checkNotNull(cachedResponse);
            cachedResponse.getClass();
            oq1 response2 = new oq1.a(cachedResponse).a(a.a(cachedResponse)).a();
            t50VarE.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response2, "response");
            return response2;
        }
        if (cachedResponse != null) {
            t50VarE.getClass();
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
        }
        oq1 oq1VarA = chain.a(op1VarB);
        if (cachedResponse != null) {
            if (oq1VarA.d() == 304) {
                new oq1.a(cachedResponse).a(a.a(cachedResponse.g(), oq1VarA.g())).b(oq1VarA.p()).a(oq1VarA.n()).a(a.a(cachedResponse)).b(a.a(oq1VarA)).a();
                sq1 sq1VarA = oq1VarA.a();
                Intrinsics.checkNotNull(sq1VarA);
                y82.a((Closeable) sq1VarA.c());
                Intrinsics.checkNotNull(null);
                throw null;
            }
            sq1 sq1VarA2 = cachedResponse.a();
            if (sq1VarA2 != null) {
                y82.a(sq1VarA2);
            }
        }
        Intrinsics.checkNotNull(oq1VarA);
        return new oq1.a(oq1VarA).a(a.a(cachedResponse)).b(a.a(oq1VarA)).a();
    }
}

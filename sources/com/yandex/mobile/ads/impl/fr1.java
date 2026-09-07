package com.yandex.mobile.ads.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class fr1 implements ip0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final be1 f8921a;

    public fr1(be1 client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.f8921a = client;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x007b, code lost:
    
        if (r1.intValue() > 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.yandex.mobile.ads.impl.op1 a(com.yandex.mobile.ads.impl.oq1 r10, com.yandex.mobile.ads.impl.y50 r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.mobile.ads.impl.fr1.a(com.yandex.mobile.ads.impl.oq1, com.yandex.mobile.ads.impl.y50):com.yandex.mobile.ads.impl.op1");
    }

    @Override // com.yandex.mobile.ads.impl.ip0
    public final oq1 a(wn1 chain) throws IOException {
        oq1 oq1VarA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        op1 op1VarF = chain.f();
        sn1 sn1VarB = chain.b();
        List listEmptyList = CollectionsKt.emptyList();
        int i = 0;
        oq1 oq1Var = null;
        while (true) {
            boolean z = true;
            while (true) {
                sn1VarB.a(op1VarF, z);
                try {
                    if (!sn1VarB.j()) {
                        try {
                            oq1VarA = chain.a(op1VarF);
                        } catch (qs1 e) {
                            if (a(e.b(), sn1VarB, op1VarF, false)) {
                                listEmptyList = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList, e.a());
                                sn1VarB.a(true);
                                z = false;
                            } else {
                                throw y82.a(e.a(), listEmptyList);
                            }
                        } catch (IOException e2) {
                            if (a(e2, sn1VarB, op1VarF, !(e2 instanceof nr))) {
                                listEmptyList = CollectionsKt.plus((Collection<? extends IOException>) listEmptyList, e2);
                                sn1VarB.a(true);
                                z = false;
                            } else {
                                throw y82.a(e2, listEmptyList);
                            }
                        }
                    } else {
                        throw new IOException("Canceled");
                    }
                    z = false;
                } catch (Throwable th) {
                    sn1VarB.a(true);
                    throw th;
                }
            }
            if (oq1Var != null) {
                oq1VarA = oq1VarA.k().c(oq1Var.k().a((sq1) null).a()).a();
            }
            oq1Var = oq1VarA;
            y50 y50VarG = sn1VarB.g();
            op1 op1VarA = a(oq1Var, y50VarG);
            if (op1VarA == null) {
                if (y50VarG != null && y50VarG.j()) {
                    sn1VarB.n();
                }
                sn1VarB.a(false);
                return oq1Var;
            }
            sq1 sq1VarA = oq1Var.a();
            if (sq1VarA != null) {
                y82.a(sq1VarA);
            }
            i++;
            if (i <= 20) {
                sn1VarB.a(true);
                op1VarF = op1VarA;
            } else {
                throw new ProtocolException("Too many follow-up requests: " + i);
            }
        }
    }

    private final boolean a(IOException iOException, sn1 sn1Var, op1 op1Var, boolean z) {
        if (this.f8921a.v()) {
            return !(z && (iOException instanceof FileNotFoundException)) && !(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) : !((iOException instanceof SocketTimeoutException) && !z)) && sn1Var.m();
        }
        return false;
    }
}

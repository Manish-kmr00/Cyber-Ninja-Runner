package com.yandex.mobile.ads.impl;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.BufferedSink;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
public final class nn implements ip0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9745a;

    @Override // com.yandex.mobile.ads.impl.ip0
    public final oq1 a(wn1 chain) throws IOException {
        boolean z;
        oq1.a aVarA;
        Intrinsics.checkNotNullParameter(chain, "chain");
        y50 y50VarD = chain.d();
        Intrinsics.checkNotNull(y50VarD);
        op1 op1VarF = chain.f();
        rp1 rp1VarA = op1VarF.a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        y50VarD.b(op1VarF);
        if (!xh0.a(op1VarF.f()) || rp1VarA == null) {
            y50VarD.l();
            z = true;
            aVarA = null;
        } else {
            if (StringsKt.equals("100-continue", op1VarF.a(HttpHeaders.EXPECT), true)) {
                y50VarD.d();
                aVarA = y50VarD.a(true);
                y50VarD.m();
                z = false;
            } else {
                z = true;
                aVarA = null;
            }
            if (aVarA == null) {
                BufferedSink bufferedSinkBuffer = Okio.buffer(y50VarD.a(op1VarF));
                rp1VarA.a(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            } else {
                y50VarD.l();
                if (!y50VarD.f().h()) {
                    y50VarD.k();
                }
            }
        }
        y50VarD.c();
        if (aVarA == null) {
            aVarA = y50VarD.a(false);
            Intrinsics.checkNotNull(aVarA);
            if (z) {
                y50VarD.m();
                z = false;
            }
        }
        oq1 oq1VarA = aVarA.a(op1VarF).a(y50VarD.f().f()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
        int iD = oq1VarA.d();
        if (iD == 100) {
            oq1.a aVarA2 = y50VarD.a(false);
            Intrinsics.checkNotNull(aVarA2);
            if (z) {
                y50VarD.m();
            }
            oq1VarA = aVarA2.a(op1VarF).a(y50VarD.f().f()).b(jCurrentTimeMillis).a(System.currentTimeMillis()).a();
            iD = oq1VarA.d();
        }
        y50VarD.b(oq1VarA);
        oq1 oq1VarA2 = (this.f9745a && iD == 101) ? oq1VarA.k().a(y82.c).a() : oq1VarA.k().a(y50VarD.a(oq1VarA)).a();
        if (StringsKt.equals("close", oq1VarA2.o().a("Connection"), true) || StringsKt.equals("close", oq1.a(oq1VarA2, "Connection"), true)) {
            y50VarD.k();
        }
        if (iD == 204 || iD == 205) {
            sq1 sq1VarA = oq1VarA2.a();
            if ((sq1VarA != null ? sq1VarA.a() : -1L) > 0) {
                sq1 sq1VarA2 = oq1VarA2.a();
                throw new ProtocolException("HTTP " + iD + " had non-zero Content-Length: " + (sq1VarA2 != null ? Long.valueOf(sq1VarA2.a()) : null));
            }
        }
        return oq1VarA2;
    }

    public nn(boolean z) {
        this.f9745a = z;
    }
}

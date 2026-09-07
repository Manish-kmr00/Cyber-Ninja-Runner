package com.yandex.mobile.ads.impl;

import android.util.Pair;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
final class fj2 {

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f8902a;
        public final long b;

        public static a a(tz tzVar, wf1 wf1Var) throws IOException {
            tzVar.b(wf1Var.c(), 0, 8, false);
            wf1Var.e(0);
            return new a(wf1Var.h(), wf1Var.n());
        }

        private a(int i, long j) {
            this.f8902a = i;
            this.b = j;
        }
    }

    public static ej2 b(tz tzVar) throws IOException {
        byte[] bArr;
        wf1 wf1Var = new wf1(16);
        a aVarA = a(1718449184, tzVar, wf1Var);
        if (aVarA.b < 16) {
            throw new IllegalStateException();
        }
        tzVar.b(wf1Var.c(), 0, 16, false);
        wf1Var.e(0);
        int iO = wf1Var.o();
        int iO2 = wf1Var.o();
        int iK = wf1Var.k();
        if (iK < 0) {
            throw new IllegalStateException(oe.a("Top bit not zero: ", iK));
        }
        int iK2 = wf1Var.k();
        if (iK2 < 0) {
            throw new IllegalStateException(oe.a("Top bit not zero: ", iK2));
        }
        int iO3 = wf1Var.o();
        int iO4 = wf1Var.o();
        int i = ((int) aVarA.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            tzVar.b(bArr2, 0, i, false);
            bArr = bArr2;
        } else {
            bArr = x82.f;
        }
        tzVar.a((int) (tzVar.d() - tzVar.a()));
        return new ej2(iO, iO2, iK, iO3, iO4, bArr);
    }

    public static boolean a(tz tzVar) throws IOException {
        wf1 wf1Var = new wf1(8);
        int i = a.a(tzVar, wf1Var).f8902a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        tzVar.b(wf1Var.c(), 0, 4, false);
        wf1Var.e(0);
        int iH = wf1Var.h();
        if (iH == 1463899717) {
            return true;
        }
        at0.b("WavHeaderReader", "Unsupported form type: " + iH);
        return false;
    }

    public static Pair c(tz tzVar) throws IOException {
        tzVar.c();
        a aVarA = a(1684108385, tzVar, new wf1(8));
        tzVar.a(8);
        return Pair.create(Long.valueOf(tzVar.a()), Long.valueOf(aVarA.b));
    }

    private static a a(int i, tz tzVar, wf1 wf1Var) throws IOException {
        a aVarA = a.a(tzVar, wf1Var);
        while (aVarA.f8902a != i) {
            at0.d("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f8902a);
            long j = aVarA.b + 8;
            if (j <= 2147483647L) {
                tzVar.a((int) j);
                aVarA = a.a(tzVar, wf1Var);
            } else {
                throw ag1.a("Chunk is too large (~2GB+) to skip; id: " + aVarA.f8902a);
            }
        }
        return aVarA;
    }
}

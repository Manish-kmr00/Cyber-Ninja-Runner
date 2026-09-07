package com.yandex.mobile.ads.impl;

import io.ktor.util.date.GMTDateParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes13.dex */
final class bx1 {
    private static final r12 d = r12.a(AbstractJsonLexerKt.COLON);
    private static final r12 e = r12.a(GMTDateParser.ANY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f8544a = new ArrayList();
    private int b = 0;
    private int c;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f8545a;
        public final int b;

        public a(int i, long j) {
            this.f8545a = j;
            this.b = i;
        }
    }

    public final void a(x70 x70Var, lj1 lj1Var, ArrayList arrayList) throws IOException {
        char c;
        int i = this.b;
        if (i == 0) {
            long j = 0;
            long jB = x70Var.b();
            if (jB != -1 && jB >= 8) {
                j = jB - 8;
            }
            lj1Var.f9531a = j;
            this.b = 1;
            return;
        }
        if (i == 1) {
            wf1 wf1Var = new wf1(8);
            x70Var.b(wf1Var.c(), 0, 8);
            this.c = wf1Var.k() + 8;
            if (wf1Var.h() != 1397048916) {
                lj1Var.f9531a = 0L;
                return;
            } else {
                lj1Var.f9531a = x70Var.a() - ((long) (this.c - 12));
                this.b = 2;
                return;
            }
        }
        char c2 = 2820;
        short s = 2819;
        short s2 = 2817;
        short s3 = 2816;
        if (i == 2) {
            long jB2 = x70Var.b();
            int i2 = this.c - 20;
            wf1 wf1Var2 = new wf1(i2);
            x70Var.b(wf1Var2.c(), 0, i2);
            int i3 = 0;
            while (i3 < i2 / 12) {
                wf1Var2.f(2);
                short sM = wf1Var2.m();
                if (sM != 2192 && sM != s3 && sM != s2 && sM != s) {
                    if (sM != 2820) {
                        wf1Var2.f(8);
                    }
                    i3++;
                    s = 2819;
                    s2 = 2817;
                    s3 = 2816;
                }
                this.f8544a.add(new a(wf1Var2.k(), (jB2 - ((long) this.c)) - ((long) wf1Var2.k())));
                i3++;
                s = 2819;
                s2 = 2817;
                s3 = 2816;
            }
            if (this.f8544a.isEmpty()) {
                lj1Var.f9531a = 0L;
                return;
            } else {
                this.b = 3;
                lj1Var.f9531a = ((a) this.f8544a.get(0)).f8545a;
                return;
            }
        }
        if (i != 3) {
            throw new IllegalStateException();
        }
        long jA = x70Var.a();
        int iB = (int) ((x70Var.b() - x70Var.a()) - ((long) this.c));
        wf1 wf1Var3 = new wf1(iB);
        x70Var.b(wf1Var3.c(), 0, iB);
        int i4 = 0;
        while (i4 < this.f8544a.size()) {
            a aVar = (a) this.f8544a.get(i4);
            wf1Var3.e((int) (aVar.f8545a - jA));
            wf1Var3.f(4);
            int iK = wf1Var3.k();
            Charset charset = ko.c;
            String strA = wf1Var3.a(iK, charset);
            strA.hashCode();
            switch (strA) {
                case "SlowMotion_Data":
                    c = 2192;
                    break;
                case "Super_SlowMotion_Edit_Data":
                    c = 2819;
                    break;
                case "Super_SlowMotion_Data":
                    c = 2816;
                    break;
                case "Super_SlowMotion_Deflickering_On":
                    c = c2;
                    break;
                case "Super_SlowMotion_BGM":
                    c = 2817;
                    break;
                default:
                    throw ag1.a("Invalid SEF name", (Exception) null);
            }
            int i5 = aVar.b - (iK + 8);
            if (c == 2192) {
                ArrayList arrayList2 = new ArrayList();
                List<String> listA = e.a(wf1Var3.a(i5, charset));
                for (int i6 = 0; i6 < listA.size(); i6++) {
                    List<String> listA2 = d.a(listA.get(i6));
                    if (listA2.size() != 3) {
                        throw ag1.a((String) null, (Exception) null);
                    }
                    try {
                        arrayList2.add(new b02.b(1 << (Integer.parseInt(listA2.get(2)) - 1), Long.parseLong(listA2.get(0)), Long.parseLong(listA2.get(1))));
                    } catch (NumberFormatException e2) {
                        throw ag1.a((String) null, (Exception) e2);
                    }
                }
                arrayList.add(new b02(arrayList2));
            } else if (c != 2816 && c != 2817 && c != 2819 && c != c2) {
                throw new IllegalStateException();
            }
            i4++;
            c2 = 2820;
        }
        lj1Var.f9531a = 0L;
    }

    public final void a() {
        this.f8544a.clear();
        this.b = 0;
    }
}

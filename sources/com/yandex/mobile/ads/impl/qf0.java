package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public final class qf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f10014a;
    public final int b;
    public final float c;
    public final String d;

    private qf0(List list, int i, float f, String str) {
        this.f10014a = list;
        this.b = i;
        this.c = f;
        this.d = str;
    }

    public static qf0 a(wf1 wf1Var) throws ag1 {
        List listSingletonList;
        try {
            wf1Var.f(21);
            int iT = wf1Var.t() & 3;
            int iT2 = wf1Var.t();
            int iD = wf1Var.d();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < iT2; i3++) {
                wf1Var.f(1);
                int iZ = wf1Var.z();
                for (int i4 = 0; i4 < iZ; i4++) {
                    int iZ2 = wf1Var.z();
                    i2 += iZ2 + 4;
                    wf1Var.f(iZ2);
                }
            }
            wf1Var.e(iD);
            byte[] bArr = new byte[i2];
            float f = 1.0f;
            String strA = null;
            int i5 = 0;
            int i6 = 0;
            while (i5 < iT2) {
                int iT3 = wf1Var.t() & 127;
                int iZ3 = wf1Var.z();
                int i7 = i;
                while (i7 < iZ3) {
                    int iZ4 = wf1Var.z();
                    System.arraycopy(a41.f8364a, i, bArr, i6, 4);
                    int i8 = i6 + 4;
                    System.arraycopy(wf1Var.c(), wf1Var.d(), bArr, i8, iZ4);
                    if (iT3 == 33 && i7 == 0) {
                        a41.a aVarA = a41.a(bArr, i8, i8 + iZ4);
                        float f2 = aVarA.g;
                        strA = mq.a(aVarA.f8365a, aVarA.b, aVarA.c, aVarA.d, aVarA.e, aVarA.f);
                        f = f2;
                    }
                    i6 = i8 + iZ4;
                    wf1Var.f(iZ4);
                    i7++;
                    iT2 = iT2;
                    i = 0;
                }
                i5++;
                i = 0;
            }
            if (i2 == 0) {
                listSingletonList = Collections.emptyList();
            } else {
                listSingletonList = Collections.singletonList(bArr);
            }
            return new qf0(listSingletonList, iT + 1, f, strA);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ag1.a("Error parsing HEVC config", e);
        }
    }
}

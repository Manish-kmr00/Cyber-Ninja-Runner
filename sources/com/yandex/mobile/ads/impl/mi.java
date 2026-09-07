package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class mi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f9640a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;
    public final String f;

    private mi(ArrayList arrayList, int i, int i2, int i3, float f, String str) {
        this.f9640a = arrayList;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
        this.f = str;
    }

    public static mi a(wf1 wf1Var) throws ag1 {
        int i;
        int i2;
        float f;
        String str;
        try {
            wf1Var.f(4);
            int iT = (wf1Var.t() & 3) + 1;
            if (iT != 3) {
                ArrayList arrayList = new ArrayList();
                int iT2 = wf1Var.t() & 31;
                for (int i3 = 0; i3 < iT2; i3++) {
                    int iZ = wf1Var.z();
                    int iD = wf1Var.d();
                    wf1Var.f(iZ);
                    arrayList.add(mq.a(wf1Var.c(), iD, iZ));
                }
                int iT3 = wf1Var.t();
                for (int i4 = 0; i4 < iT3; i4++) {
                    int iZ2 = wf1Var.z();
                    int iD2 = wf1Var.d();
                    wf1Var.f(iZ2);
                    arrayList.add(mq.a(wf1Var.c(), iD2, iZ2));
                }
                if (iT2 > 0) {
                    a41.c cVarB = a41.b((byte[]) arrayList.get(0), iT, ((byte[]) arrayList.get(0)).length);
                    int i5 = cVarB.e;
                    int i6 = cVarB.f;
                    float f2 = cVarB.g;
                    str = String.format("avc1.%02X%02X%02X", Integer.valueOf(cVarB.f8367a), Integer.valueOf(cVarB.b), Integer.valueOf(cVarB.c));
                    i = i5;
                    i2 = i6;
                    f = f2;
                } else {
                    i = -1;
                    i2 = -1;
                    f = 1.0f;
                    str = null;
                }
                return new mi(arrayList, iT, i, i2, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ag1.a("Error parsing AVC config", e);
        }
    }
}

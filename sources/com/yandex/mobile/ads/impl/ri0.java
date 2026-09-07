package com.yandex.mobile.ads.impl;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public final class ri0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wf1 f10110a = new wf1(10);

    public final g01 a(tz tzVar, pi0.a aVar) throws IOException {
        g01 g01VarA = null;
        int i = 0;
        while (true) {
            try {
                tzVar.b(this.f10110a.c(), 0, 10, false);
                this.f10110a.e(0);
                if (this.f10110a.w() != 4801587) {
                    break;
                }
                this.f10110a.f(3);
                int iS = this.f10110a.s();
                int i2 = iS + 10;
                if (g01VarA == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f10110a.c(), 0, bArr, 0, 10);
                    tzVar.b(bArr, 10, iS, false);
                    g01VarA = new pi0(aVar).a(i2, bArr);
                } else {
                    tzVar.a(false, iS);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        tzVar.c();
        tzVar.a(false, i);
        return g01VarA;
    }
}

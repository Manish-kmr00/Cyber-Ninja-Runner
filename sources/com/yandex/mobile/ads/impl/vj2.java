package com.yandex.mobile.ads.impl;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes9.dex */
public final class vj2 extends ny1 {
    private final wf1 m = new wf1();
    private final rj2 n = new rj2();

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) throws i32 {
        tj2 tj2VarA;
        this.m.a(i, bArr);
        ArrayList arrayList = new ArrayList();
        try {
            wf1 wf1Var = this.m;
            int i2 = wj2.f10568a;
            int iD = wf1Var.d();
            String strJ = wf1Var.j();
            if (strJ != null && strJ.startsWith("WEBVTT")) {
                while (!TextUtils.isEmpty(this.m.j())) {
                }
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    wf1 wf1Var2 = this.m;
                    int iD2 = 0;
                    byte b = -1;
                    while (b == -1) {
                        iD2 = wf1Var2.d();
                        String strJ2 = wf1Var2.j();
                        if (strJ2 == null) {
                            b = 0;
                        } else if ("STYLE".equals(strJ2)) {
                            b = 2;
                        } else {
                            b = strJ2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                        }
                    }
                    wf1Var2.e(iD2);
                    if (b == 0) {
                        return new xj2(arrayList2);
                    }
                    if (b == 1) {
                        while (!TextUtils.isEmpty(this.m.j())) {
                        }
                    } else if (b == 2) {
                        if (arrayList2.isEmpty()) {
                            this.m.j();
                            arrayList.addAll(this.n.a(this.m));
                        } else {
                            throw new i32("A style block was found after the first cue.");
                        }
                    } else if (b == 3 && (tj2VarA = uj2.a(this.m, arrayList)) != null) {
                        arrayList2.add(tj2VarA);
                    }
                }
            } else {
                wf1Var.e(iD);
                throw ag1.a("Expected WEBVTT. Got " + wf1Var.j(), (Exception) null);
            }
        } catch (ag1 e) {
            throw new i32(e);
        }
    }
}

package com.yandex.mobile.ads.impl;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class se extends ly1 {
    @Override // com.yandex.mobile.ads.impl.ly1
    protected final g01 a(j01 j01Var, ByteBuffer byteBuffer) {
        if (byteBuffer.get() != 116) {
            return null;
        }
        vf1 vf1Var = new vf1(byteBuffer.limit(), byteBuffer.array());
        vf1Var.d(12);
        int iD = (vf1Var.d() + vf1Var.b(12)) - 4;
        vf1Var.d(44);
        vf1Var.e(vf1Var.b(12));
        vf1Var.d(16);
        ArrayList arrayList = new ArrayList();
        while (vf1Var.d() < iD) {
            vf1Var.d(48);
            int iB = vf1Var.b(8);
            vf1Var.d(4);
            int iD2 = vf1Var.d() + vf1Var.b(12);
            String strA = null;
            String strA2 = null;
            while (vf1Var.d() < iD2) {
                int iB2 = vf1Var.b(8);
                int iB3 = vf1Var.b(8);
                int iD3 = vf1Var.d() + iB3;
                if (iB2 == 2) {
                    int iB4 = vf1Var.b(16);
                    vf1Var.d(8);
                    if (iB4 == 3) {
                        while (vf1Var.d() < iD3) {
                            strA = vf1Var.a(vf1Var.b(8), ko.f9439a);
                            int iB5 = vf1Var.b(8);
                            for (int i = 0; i < iB5; i++) {
                                vf1Var.e(vf1Var.b(8));
                            }
                        }
                    }
                } else if (iB2 == 21) {
                    strA2 = vf1Var.a(iB3, ko.f9439a);
                }
                vf1Var.c(iD3 * 8);
            }
            vf1Var.c(iD2 * 8);
            if (strA != null && strA2 != null) {
                arrayList.add(new re(iB, strA.concat(strA2)));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new g01(arrayList);
    }
}

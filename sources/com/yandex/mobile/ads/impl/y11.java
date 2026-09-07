package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class y11 extends ny1 {
    private final wf1 m = new wf1();

    @Override // com.yandex.mobile.ads.impl.ny1
    protected final g32 a(byte[] bArr, int i, boolean z) throws i32 {
        ev evVarA;
        this.m.a(i, bArr);
        ArrayList arrayList = new ArrayList();
        while (this.m.a() > 0) {
            if (this.m.a() >= 8) {
                int iH = this.m.h();
                if (this.m.h() == 1987343459) {
                    wf1 wf1Var = this.m;
                    int i2 = iH - 8;
                    CharSequence charSequenceA = null;
                    ev.a aVarA = null;
                    while (i2 > 0) {
                        if (i2 >= 8) {
                            int iH2 = wf1Var.h();
                            int iH3 = wf1Var.h();
                            int i3 = iH2 - 8;
                            String strA = x82.a(wf1Var.c(), wf1Var.d(), i3);
                            wf1Var.f(i3);
                            i2 = (i2 - 8) - i3;
                            if (iH3 == 1937011815) {
                                aVarA = uj2.a(strA);
                            } else if (iH3 == 1885436268) {
                                charSequenceA = uj2.a(null, strA.trim(), Collections.emptyList());
                            }
                        } else {
                            throw new i32("Incomplete vtt cue box header found.");
                        }
                    }
                    if (charSequenceA == null) {
                        charSequenceA = "";
                    }
                    if (aVarA != null) {
                        evVarA = aVarA.a(charSequenceA).a();
                    } else {
                        Pattern pattern = uj2.f10393a;
                        uj2.d dVar = new uj2.d();
                        dVar.c = charSequenceA;
                        evVarA = dVar.a().a();
                    }
                    arrayList.add(evVarA);
                } else {
                    this.m.f(iH - 8);
                }
            } else {
                throw new i32("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new z11(arrayList);
    }
}

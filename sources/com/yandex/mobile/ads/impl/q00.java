package com.yandex.mobile.ads.impl;

import android.util.SparseArray;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class q00 implements i72.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9968a;
    private final List<gc0> b;

    public q00() {
        this(hk0.h());
    }

    public q00(List list) {
        this.f9968a = 0;
        this.b = list;
    }

    @Override // com.yandex.mobile.ads.impl.i72.c
    public final i72 a(int i, i72.b bVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new rg1(new a21(bVar.f9187a));
            }
            if (i == 21) {
                return new rg1(new si0());
            }
            if (i == 27) {
                if (a(4)) {
                    return null;
                }
                return new rg1(new bf0(new cx1(a(bVar)), a(1), a(8)));
            }
            if (i == 36) {
                return new rg1(new cf0(new cx1(a(bVar))));
            }
            if (i != 89) {
                if (i != 138) {
                    if (i == 172) {
                        return new rg1(new v(bVar.f9187a));
                    }
                    if (i == 257) {
                        return new ww1(new hg1("application/vnd.dvb.ait"));
                    }
                    if (i == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new ww1(new hg1("application/x-scte35"));
                    }
                    if (i != 135) {
                        switch (i) {
                            case 15:
                                if (a(2)) {
                                    return null;
                                }
                                return new rg1(new ib(bVar.f9187a, false));
                            case 16:
                                return new rg1(new af0(new w82(a(bVar))));
                            case 17:
                                if (a(2)) {
                                    return null;
                                }
                                return new rg1(new ar0(bVar.f9187a));
                            default:
                                switch (i) {
                                    case 128:
                                        break;
                                    case 129:
                                        break;
                                    case 130:
                                        if (!a(64)) {
                                            return null;
                                        }
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new rg1(new s(bVar.f9187a));
                }
                return new rg1(new k40(bVar.f9187a));
            }
            return new rg1(new u40(bVar.b));
        }
        return new rg1(new ze0(new w82(a(bVar))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4 */
    private List<gc0> a(i72.b bVar) {
        String str;
        int i;
        List<byte[]> listSingletonList;
        if (a(32)) {
            return this.b;
        }
        wf1 wf1Var = new wf1(bVar.c);
        ArrayList arrayList = this.b;
        while (wf1Var.a() > 0) {
            int iT = wf1Var.t();
            int iD = wf1Var.d() + wf1Var.t();
            if (iT == 134) {
                arrayList = new ArrayList();
                int iT2 = wf1Var.t() & 31;
                for (int i2 = 0; i2 < iT2; i2++) {
                    String strA = wf1Var.a(3, ko.c);
                    int iT3 = wf1Var.t();
                    boolean z = (iT3 & 128) != 0;
                    if (z) {
                        i = iT3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte bT = (byte) wf1Var.t();
                    wf1Var.f(1);
                    if (z) {
                        listSingletonList = Collections.singletonList((bT & SignedBytes.MAX_POWER_OF_TWO) != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    arrayList.add(new gc0.a().e(str).d(strA).a(i).a(listSingletonList).a());
                }
            }
            wf1Var.e(iD);
            arrayList = arrayList;
        }
        return arrayList;
    }

    private boolean a(int i) {
        return (i & this.f9968a) != 0;
    }

    @Override // com.yandex.mobile.ads.impl.i72.c
    public final SparseArray<i72> a() {
        return new SparseArray<>();
    }
}

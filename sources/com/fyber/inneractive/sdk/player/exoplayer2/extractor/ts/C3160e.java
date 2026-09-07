package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C3160e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2077a;
    public final List b;

    public C3160e(int i, List list) {
        this.f2077a = i;
        if (!a(32) && list.isEmpty()) {
            list = Collections.singletonList(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, "application/cea-608", 0, null, -1, null, Long.MAX_VALUE, Collections.emptyList()));
        }
        this.b = list;
    }

    public final F a(int i, D d) {
        if (i == 2) {
            return new s(new j());
        }
        if (i == 3 || i == 4) {
            return new s(new q(d.f2071a));
        }
        if (i == 15) {
            if (a(2)) {
                return null;
            }
            return new s(new C3159d(false, d.f2071a));
        }
        if (i == 21) {
            return new s(new p());
        }
        if (i == 27) {
            if (a(4)) {
                return null;
            }
            return new s(new m(a(d), a(1), a(8)));
        }
        if (i == 36) {
            return new s(new o(a(d)));
        }
        if (i == 89) {
            return new s(new g(d.b));
        }
        if (i != 138) {
            if (i != 129) {
                if (i != 130) {
                    if (i == 134) {
                        if (a(16)) {
                            return null;
                        }
                        return new w(new y());
                    }
                    if (i != 135) {
                        return null;
                    }
                }
            }
            return new s(new C3157b(d.f2071a));
        }
        return new s(new C3161f(d.f2071a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    public final x a(D d) {
        int i;
        String str;
        if (a(32)) {
            return new x(this.b);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(d.c);
        ArrayList arrayList = this.b;
        while (nVar.c - nVar.b > 0) {
            int iJ = nVar.j();
            int iJ2 = nVar.b + nVar.j();
            if (iJ == 134) {
                arrayList = new ArrayList();
                int iJ3 = nVar.j() & 31;
                for (int i2 = 0; i2 < iJ3; i2++) {
                    String strB = nVar.b(3);
                    int iJ4 = nVar.j();
                    if ((iJ4 & 128) != 0) {
                        i = iJ4 & 63;
                        str = "application/cea-708";
                    } else {
                        i = 1;
                        str = "application/cea-608";
                    }
                    arrayList.add(com.fyber.inneractive.sdk.player.exoplayer2.o.a(null, str, 0, strB, i, null, Long.MAX_VALUE, Collections.emptyList()));
                    nVar.e(nVar.b + 2);
                }
            }
            nVar.e(iJ2);
            arrayList = arrayList;
        }
        return new x(arrayList);
    }

    public final boolean a(int i) {
        return (i & this.f2077a) != 0;
    }
}

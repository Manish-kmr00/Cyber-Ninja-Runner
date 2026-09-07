package com.yandex.mobile.ads.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
final class xj2 implements g32 {
    private final List<tj2> b;
    private final long[] c;
    private final long[] d;

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.b.size(); i++) {
            long[] jArr = this.c;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                tj2 tj2Var = this.b.get(i);
                ev evVar = tj2Var.f10307a;
                if (evVar.f == -3.4028235E38f) {
                    arrayList2.add(tj2Var);
                } else {
                    arrayList.add(evVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.yandex.mobile.ads.impl.xj2$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return xj2.a((tj2) obj, (tj2) obj2);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((tj2) arrayList2.get(i3)).f10307a.a().a(1, (-1) - i3).a());
        }
        return arrayList;
    }

    public xj2(ArrayList arrayList) {
        this.b = Collections.unmodifiableList(new ArrayList(arrayList));
        this.c = new long[arrayList.size() * 2];
        for (int i = 0; i < arrayList.size(); i++) {
            tj2 tj2Var = (tj2) arrayList.get(i);
            int i2 = i * 2;
            long[] jArr = this.c;
            jArr[i2] = tj2Var.b;
            jArr[i2 + 1] = tj2Var.c;
        }
        long[] jArr2 = this.c;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.d = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        if (i >= 0) {
            long[] jArr = this.d;
            if (i < jArr.length) {
                return jArr[i];
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return this.d.length;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        int iA = x82.a(this.d, j, false);
        if (iA < this.d.length) {
            return iA;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(tj2 tj2Var, tj2 tj2Var2) {
        return Long.compare(tj2Var.b, tj2Var2.b);
    }
}

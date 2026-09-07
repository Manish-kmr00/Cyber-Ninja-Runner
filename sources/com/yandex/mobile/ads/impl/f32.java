package com.yandex.mobile.ads.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
final class f32 implements g32 {
    private final ev[] b;
    private final long[] c;

    public f32(ev[] evVarArr, long[] jArr) {
        this.b = evVarArr;
        this.c = jArr;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final long a(int i) {
        if (i >= 0) {
            long[] jArr = this.c;
            if (i < jArr.length) {
                return jArr[i];
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final List<ev> b(long j) {
        ev evVar;
        int iB = x82.b(this.c, j, false);
        if (iB != -1 && (evVar = this.b[iB]) != ev.s) {
            return Collections.singletonList(evVar);
        }
        return Collections.emptyList();
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a() {
        return this.c.length;
    }

    @Override // com.yandex.mobile.ads.impl.g32
    public final int a(long j) {
        int iA = x82.a(this.c, j, false);
        if (iA < this.c.length) {
            return iA;
        }
        return -1;
    }
}

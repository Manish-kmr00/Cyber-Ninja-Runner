package com.yandex.mobile.ads.impl;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes13.dex */
public final class kr0 implements ym {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9443a;
    private final TreeSet<en> b = new TreeSet<>(new Comparator() { // from class: com.yandex.mobile.ads.impl.kr0$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return kr0.a((en) obj, (en) obj2);
        }
    });
    private long c;

    public kr0(long j) {
        this.f9443a = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(en enVar, en enVar2) {
        long j = enVar.g;
        long j2 = enVar2.g;
        if (j - j2 != 0) {
            return j < j2 ? -1 : 1;
        }
        if (!enVar.b.equals(enVar2.b)) {
            return enVar.b.compareTo(enVar2.b);
        }
        long j3 = enVar.c - enVar2.c;
        if (j3 == 0) {
            return 0;
        }
        return j3 < 0 ? -1 : 1;
    }

    @Override // com.yandex.mobile.ads.impl.rm.b
    public final void a(rm rmVar, en enVar) {
        this.b.add(enVar);
        this.c += enVar.d;
        while (this.c > this.f9443a && !this.b.isEmpty()) {
            rmVar.a(this.b.first());
        }
    }

    @Override // com.yandex.mobile.ads.impl.rm.b
    public final void a(en enVar) {
        this.b.remove(enVar);
        this.c -= enVar.d;
    }

    @Override // com.yandex.mobile.ads.impl.rm.b
    public final void a(rm rmVar, en enVar, en enVar2) {
        a(enVar);
        a(rmVar, enVar2);
    }

    @Override // com.yandex.mobile.ads.impl.ym
    public final void a(rm rmVar, long j) {
        if (j != -1) {
            while (this.c + j > this.f9443a && !this.b.isEmpty()) {
                rmVar.a(this.b.first());
            }
        }
    }
}

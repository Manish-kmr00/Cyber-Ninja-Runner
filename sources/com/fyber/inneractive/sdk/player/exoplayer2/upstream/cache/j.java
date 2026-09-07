package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes12.dex */
public final class j implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeSet f2156a = new TreeSet(this);
    public long b;

    public final void a(l lVar, long j) {
        while (this.b + j > 10485760) {
            try {
                g gVar = (g) this.f2156a.first();
                synchronized (lVar) {
                    try {
                        lVar.a(gVar, true);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (a unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[ORIG_RETURN, RETURN] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        g gVar = (g) obj;
        g gVar2 = (g) obj2;
        long j = gVar.f;
        long j2 = gVar2.f;
        if (j - j2 != 0) {
            if (j < j2) {
                return -1;
            }
            return 1;
        }
        if (!gVar.f2153a.equals(gVar2.f2153a)) {
            return gVar.f2153a.compareTo(gVar2.f2153a);
        }
        long j3 = gVar.b - gVar2.b;
        if (j3 == 0) {
            return 0;
        }
        if (j3 < 0) {
            return -1;
        }
        return 1;
    }
}

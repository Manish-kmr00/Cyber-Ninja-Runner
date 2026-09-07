package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.Handler;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.source.v;
import com.fyber.inneractive.sdk.player.exoplayer2.source.y;
import com.fyber.inneractive.sdk.player.exoplayer2.source.z;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.InterfaceC3164b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k f2009a;
    public final b b;
    public final com.fyber.inneractive.sdk.player.exoplayer2.source.f d;
    public final InterfaceC3164b e;
    public final long i;
    public r j;
    public int k;
    public boolean l;
    public z m;
    public n[] n;
    public n[] o;
    public com.fyber.inneractive.sdk.player.exoplayer2.source.h p;
    public final int c = 3;
    public final IdentityHashMap f = new IdentityHashMap();
    public final o g = new o();
    public final Handler h = new Handler();

    public i(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.k kVar, b bVar, com.fyber.inneractive.sdk.player.exoplayer2.source.f fVar, InterfaceC3164b interfaceC3164b, long j) {
        this.f2009a = kVar;
        this.b = bVar;
        this.d = fVar;
        this.e = interfaceC3164b;
        this.i = j;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void a(r rVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar;
        this.f2009a.g.add(this);
        this.j = rVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b bVar = this.f2009a.j;
        ArrayList arrayList = new ArrayList(bVar.b);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        char c = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) arrayList.get(i);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar = aVar.b;
            if (oVar.k <= 0) {
                String str = oVar.c;
                if (!TextUtils.isEmpty(str)) {
                    String[] strArrSplit = str.split("(\\s*,\\s*)|(\\s*$)");
                    int length = strArrSplit.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            if (strArrSplit[i2].startsWith("avc")) {
                                arrayList2.add(aVar);
                            } else {
                                i2++;
                            }
                        }
                    }
                }
                String str2 = aVar.b.c;
                if (!TextUtils.isEmpty(str2)) {
                    for (String str3 : str2.split("(\\s*,\\s*)|(\\s*$)")) {
                        if (str3.startsWith("mp4a")) {
                            arrayList3.add(aVar);
                            break;
                        }
                    }
                }
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        } else if (arrayList3.size() < arrayList.size()) {
            arrayList.removeAll(arrayList3);
        }
        List list = bVar.c;
        List list2 = bVar.d;
        int size = list2.size() + list.size() + 1;
        this.n = new n[size];
        this.k = size;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException();
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] aVarArr = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        com.fyber.inneractive.sdk.player.exoplayer2.o oVar2 = bVar.e;
        f fVar = new f(this.f2009a, aVarArr, this.b, this.g, bVar.f);
        n nVar = new n(0, this, fVar, this.e, this.i, oVar2, this.c, this.d);
        this.n[0] = nVar;
        fVar.h = true;
        if (!nVar.o) {
            nVar.b(nVar.w);
        }
        int i3 = 0;
        int i4 = 1;
        while (i3 < list.size()) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[] aVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[1];
            aVarArr2[c] = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) list.get(i3);
            n nVar2 = new n(1, this, new f(this.f2009a, aVarArr2, this.b, this.g, Collections.emptyList()), this.e, this.i, null, this.c, this.d);
            int i5 = i4 + 1;
            this.n[i4] = nVar2;
            if (!nVar2.o) {
                nVar2.b(nVar2.w);
            }
            i3++;
            i4 = i5;
            c = 0;
        }
        int i6 = 0;
        while (i6 < list2.size()) {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a) list2.get(i6);
            f fVar2 = new f(this.f2009a, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a[]{aVar2}, this.b, this.g, Collections.emptyList());
            InterfaceC3164b interfaceC3164b = this.e;
            List list3 = list2;
            n nVar3 = new n(3, this, fVar2, interfaceC3164b, this.i, null, this.c, this.d);
            com.fyber.inneractive.sdk.player.exoplayer2.o oVar3 = aVar2.b;
            if (nVar3.j.indexOfKey(0) >= 0) {
                gVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar3.j.get(0);
            } else {
                gVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.g(interfaceC3164b);
                gVar.n = nVar3;
                gVar.c.r = nVar3.r;
                nVar3.j.put(0, gVar);
            }
            gVar.a(oVar3);
            nVar3.n = true;
            nVar3.h();
            this.n[i4] = nVar3;
            i6++;
            i4++;
            list2 = list3;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final boolean b(long j) {
        return this.p.b(j);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long c() {
        long jMax;
        long jMin = Long.MAX_VALUE;
        for (n nVar : this.o) {
            if (nVar.y) {
                jMax = Long.MIN_VALUE;
            } else {
                jMax = nVar.x;
                if (jMax == -9223372036854775807L) {
                    jMax = nVar.w;
                    h hVar = (h) nVar.k.getLast();
                    if (!hVar.F) {
                        if (nVar.k.size() > 1) {
                            LinkedList linkedList = nVar.k;
                            hVar = (h) linkedList.get(linkedList.size() - 2);
                        } else {
                            hVar = null;
                        }
                    }
                    if (hVar != null) {
                        jMax = Math.max(jMax, hVar.g);
                    }
                    int size = nVar.j.size();
                    for (int i = 0; i < size; i++) {
                        jMax = Math.max(jMax, ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i)).d());
                    }
                }
            }
            if (jMax != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jMax);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final void d() throws IOException {
        n[] nVarArr = this.n;
        if (nVarArr != null) {
            for (n nVar : nVarArr) {
                nVar.g.b();
                f fVar = nVar.c;
                com.fyber.inneractive.sdk.player.exoplayer2.source.g gVar = fVar.j;
                if (gVar != null) {
                    throw gVar;
                }
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar = fVar.k;
                if (aVar != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h hVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.h) fVar.e.d.get(aVar);
                    hVar.b.b();
                    IOException iOException = hVar.j;
                    if (iOException != null) {
                        throw iOException;
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.w
    public final long f() {
        return this.p.f();
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long g() {
        return -9223372036854775807L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final z a() {
        return this.m;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, v[] vVarArr, boolean[] zArr2, long j) {
        long j2;
        ArrayList arrayList;
        int i;
        v[] vVarArr2 = vVarArr;
        int[] iArr = new int[bVarArr.length];
        int[] iArr2 = new int[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            v vVar = vVarArr2[i2];
            iArr[i2] = vVar == null ? -1 : ((Integer) this.f.get(vVar)).intValue();
            iArr2[i2] = -1;
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar = bVarArr[i2];
            if (bVar != null) {
                y yVar = bVar.f2141a;
                int i3 = 0;
                while (true) {
                    n[] nVarArr = this.n;
                    if (i3 >= nVarArr.length) {
                        break;
                    }
                    z zVar = nVarArr[i3].t;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= zVar.f2137a) {
                            i4 = -1;
                            break;
                        }
                        if (zVar.b[i4] == yVar) {
                            break;
                        }
                        i4++;
                    }
                    if (i4 != -1) {
                        iArr2[i2] = i3;
                        break;
                    }
                    i3++;
                }
            }
        }
        this.f.clear();
        int length = bVarArr.length;
        v[] vVarArr3 = new v[length];
        v[] vVarArr4 = new v[bVarArr.length];
        int length2 = bVarArr.length;
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr2 = new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[length2];
        ArrayList arrayList2 = new ArrayList(this.n.length);
        int i5 = 0;
        boolean z = false;
        while (i5 < this.n.length) {
            for (int i6 = 0; i6 < bVarArr.length; i6++) {
                vVarArr4[i6] = iArr[i6] == i5 ? vVarArr2[i6] : null;
                bVarArr2[i6] = iArr2[i6] == i5 ? bVarArr[i6] : null;
            }
            n nVar = this.n[i5];
            boolean z2 = this.l;
            if (nVar.o) {
                for (int i7 = 0; i7 < length2; i7++) {
                    v vVar2 = vVarArr4[i7];
                    if (vVar2 != null && (bVarArr2[i7] == null || !zArr[i7])) {
                        int i8 = ((k) vVar2).f2011a;
                        boolean[] zArr3 = nVar.v;
                        if (zArr3[i8]) {
                            zArr3[i8] = false;
                            nVar.p--;
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i8)).b();
                            vVarArr4[i7] = null;
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                }
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar2 = null;
                int i9 = 0;
                boolean z3 = false;
                while (i9 < length2) {
                    if (vVarArr4[i9] == null) {
                        i = length2;
                        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b bVar3 = bVarArr2[i9];
                        if (bVar3 != null) {
                            z zVar2 = nVar.t;
                            y yVar2 = bVar3.f2141a;
                            length = length;
                            int i10 = 0;
                            while (true) {
                                if (i10 >= zVar2.f2137a) {
                                    i10 = -1;
                                    break;
                                }
                                if (zVar2.b[i10] == yVar2) {
                                    break;
                                }
                                i10++;
                            }
                            boolean[] zArr4 = nVar.v;
                            if (!zArr4[i10]) {
                                zArr4[i10] = true;
                                nVar.p++;
                                if (i10 == nVar.u) {
                                    nVar.c.p = bVar3;
                                    bVar2 = bVar3;
                                }
                                vVarArr4[i9] = new k(nVar, i10);
                                zArr2[i9] = true;
                                z3 = true;
                            } else {
                                throw new IllegalStateException();
                            }
                        }
                        i9++;
                        length2 = i;
                        bVarArr2 = bVarArr2;
                        length = length;
                        arrayList2 = arrayList2;
                    } else {
                        i = length2;
                    }
                    i9++;
                    length2 = i;
                    bVarArr2 = bVarArr2;
                    length = length;
                    arrayList2 = arrayList2;
                }
                int i11 = length;
                int i12 = length2;
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.b[] bVarArr3 = bVarArr2;
                ArrayList arrayList3 = arrayList2;
                if (!z2) {
                    int size = nVar.j.size();
                    for (int i13 = 0; i13 < size; i13++) {
                        if (!nVar.v[i13]) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) nVar.j.valueAt(i13)).b();
                        }
                    }
                    if (bVar2 != null && !nVar.k.isEmpty()) {
                        bVar2.d();
                        if (bVar2.c[bVar2.a()] != nVar.c.f.a(((h) nVar.k.getLast()).c)) {
                            nVar.c(nVar.w);
                        }
                    }
                }
                if (nVar.p == 0) {
                    nVar.c.j = null;
                    nVar.q = null;
                    nVar.k.clear();
                    if (nVar.g.a()) {
                        nVar.g.b.a(false);
                    }
                }
                z |= z3;
                boolean z4 = false;
                for (int i14 = 0; i14 < bVarArr.length; i14++) {
                    if (iArr2[i14] == i5) {
                        v vVar3 = vVarArr4[i14];
                        if (vVar3 != null) {
                            vVarArr3[i14] = vVar3;
                            this.f.put(vVarArr4[i14], Integer.valueOf(i5));
                            z4 = true;
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (iArr[i14] == i5 && vVarArr4[i14] != null) {
                        throw new IllegalStateException();
                    }
                }
                if (z4) {
                    arrayList = arrayList3;
                    arrayList.add(this.n[i5]);
                } else {
                    arrayList = arrayList3;
                }
                i5++;
                vVarArr2 = vVarArr;
                arrayList2 = arrayList;
                length2 = i12;
                bVarArr2 = bVarArr3;
                length = i11;
            } else {
                throw new IllegalStateException();
            }
        }
        ArrayList arrayList4 = arrayList2;
        System.arraycopy(vVarArr3, 0, vVarArr2, 0, length);
        n[] nVarArr2 = new n[arrayList4.size()];
        this.o = nVarArr2;
        arrayList4.toArray(nVarArr2);
        n[] nVarArr3 = this.o;
        if (nVarArr3.length > 0) {
            nVarArr3[0].c.h = true;
            int i15 = 1;
            while (true) {
                n[] nVarArr4 = this.o;
                if (i15 >= nVarArr4.length) {
                    break;
                }
                nVarArr4[i15].c.h = false;
                i15++;
            }
        }
        this.p = new com.fyber.inneractive.sdk.player.exoplayer2.source.h(this.o);
        if (this.l && z) {
            j2 = j;
            a(j2);
            for (int i16 = 0; i16 < bVarArr.length; i16++) {
                if (vVarArr2[i16] != null) {
                    zArr2[i16] = true;
                }
            }
        } else {
            j2 = j;
        }
        this.l = true;
        return j2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.s
    public final long a(long j) {
        this.g.f2014a.clear();
        for (n nVar : this.o) {
            nVar.c(j);
        }
        return j;
    }
}

package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.B;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3156a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3158c;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.C3160e;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.q;
import com.fyber.inneractive.sdk.player.exoplayer2.util.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public n D;
    public volatile boolean E;
    public volatile boolean F;
    public final int j;
    public final int k;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a l;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h m;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.k n;
    public final boolean o;
    public final boolean p;
    public final v q;
    public final String r;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i s;
    public final boolean t;
    public final boolean u;
    public final List v;
    public final boolean w;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n x;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.n y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.i z;

    /* JADX WARN: Illegal instructions before constructor call */
    public h(com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a aVar, List list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, v vVar, h hVar2, byte[] bArr, byte[] bArr2) {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h aVar2 = (bArr == null || bArr2 == null) ? hVar : new a(hVar, bArr, bArr2);
        super(i, i2, j, j2, aVar.b, aVar2, kVar, obj);
        this.k = i3;
        this.n = kVar2;
        this.l = aVar;
        this.v = list;
        this.p = z;
        this.q = vVar;
        this.o = aVar2 instanceof a;
        String lastPathSegment = kVar.f2163a.getLastPathSegment();
        this.r = lastPathSegment;
        boolean z2 = lastPathSegment.endsWith(".aac") || lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3") || lastPathSegment.endsWith(".mp3");
        this.w = z2;
        if (hVar2 != null) {
            this.x = hVar2.x;
            this.y = hVar2.y;
            this.s = hVar2.z;
            boolean z3 = hVar2.l != aVar;
            this.t = z3;
            this.u = hVar2.k != i3 || z3;
        } else {
            this.x = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n() : null;
            this.y = z2 ? new com.fyber.inneractive.sdk.player.exoplayer2.util.n(10) : null;
            this.s = null;
            this.t = false;
            this.u = true;
        }
        this.m = hVar;
        this.j = G.getAndIncrement();
    }

    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.b bVarA;
        bVar.e = 0;
        if (!bVar.a(this.y.f2184a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.y.c(10);
        if (this.y.l() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.n.b) {
            return -9223372036854775807L;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = this.y;
        nVar.e(nVar.b + 3);
        int i = this.y.i();
        int i2 = i + 10;
        if (i2 > this.y.a()) {
            com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar2 = this.y;
            byte[] bArr = nVar2.f2184a;
            nVar2.c(i2);
            System.arraycopy(bArr, 0, this.y.f2184a, 0, 10);
        }
        if (!bVar.a(this.y.f2184a, 10, i, true) || (bVarA = this.x.a(i, this.y.f2184a)) == null) {
            return -9223372036854775807L;
        }
        int length = bVarA.f2112a.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.o oVar = bVarA.f2112a[i3];
            if (oVar instanceof q) {
                q qVar = (q) oVar;
                if ("com.apple.streaming.transportStreamTimestamp".equals(qVar.b)) {
                    System.arraycopy(qVar.c, 0, this.y.f2184a, 0, 8);
                    this.y.c(8);
                    return this.y.g();
                }
            }
        }
        return -9223372036854775807L;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void b() {
        this.E = true;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a
    public final long c() {
        return this.B;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:116:0x01c6 A[Catch: all -> 0x01cc, TRY_LEAVE, TryCatch #3 {, blocks: (B:114:0x01c0, B:116:0x01c6), top: B:153:0x01c0 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:125:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:128:0x01f3 A[Catch: all -> 0x023c, TryCatch #2 {all -> 0x023c, blocks: (B:126:0x01e1, B:128:0x01f3, B:130:0x01fb, B:132:0x0204, B:131:0x0202, B:134:0x020c, B:143:0x022a, B:141:0x021f, B:142:0x0229, B:136:0x0213, B:138:0x0217), top: B:152:0x01e1, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x01fb A[Catch: all -> 0x023c, TryCatch #2 {all -> 0x023c, blocks: (B:126:0x01e1, B:128:0x01f3, B:130:0x01fb, B:132:0x0204, B:131:0x0202, B:134:0x020c, B:143:0x022a, B:141:0x021f, B:142:0x0229, B:136:0x0213, B:138:0x0217), top: B:152:0x01e1, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x0202 A[Catch: all -> 0x023c, TryCatch #2 {all -> 0x023c, blocks: (B:126:0x01e1, B:128:0x01f3, B:130:0x01fb, B:132:0x0204, B:131:0x0202, B:134:0x020c, B:143:0x022a, B:141:0x021f, B:142:0x0229, B:136:0x0213, B:138:0x0217), top: B:152:0x01e1, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x020c A[Catch: all -> 0x023c, TRY_LEAVE, TryCatch #2 {all -> 0x023c, blocks: (B:126:0x01e1, B:128:0x01f3, B:130:0x01fb, B:132:0x0204, B:131:0x0202, B:134:0x020c, B:143:0x022a, B:141:0x021f, B:142:0x0229, B:136:0x0213, B:138:0x0217), top: B:152:0x01e1, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x0217 A[Catch: all -> 0x021e, TRY_LEAVE, TryCatch #4 {all -> 0x021e, blocks: (B:136:0x0213, B:138:0x0217), top: B:155:0x0213, outer: #2 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x01c0 A[EXC_TOP_SPLITTER, LOOP:3: B:153:0x01c0->B:169:?, LOOP_START, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x0213 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x022a A[EDGE_INSN: B:171:0x022a->B:143:0x022a BREAK  A[LOOP:4: B:135:0x0211->B:173:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00f3  */
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final void load() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar;
        boolean z;
        v vVar;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
        long jA;
        long jB;
        v vVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar2;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i pVar;
        boolean z2;
        int i;
        String strA;
        String strA2;
        int iA = 0;
        if (this.z == null && !this.w) {
            if ("text/vtt".equals(this.l.b.f) || this.r.endsWith(".webvtt") || this.r.endsWith(".vtt")) {
                pVar = new p(this.c.y, this.q);
            } else {
                if (this.u) {
                    if (!this.r.endsWith(".mp4")) {
                        String str = this.r;
                        if (!str.startsWith(".m4", str.length() - 4)) {
                            List listEmptyList = this.v;
                            if (listEmptyList != null) {
                                i = 48;
                            } else {
                                listEmptyList = Collections.emptyList();
                                i = 16;
                            }
                            String str2 = this.c.c;
                            if (!TextUtils.isEmpty(str2)) {
                                if (str2 != null) {
                                    String[] strArrSplit = str2.split(StringUtils.COMMA);
                                    int length = strArrSplit.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            strA = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(strArrSplit[i2]);
                                            if (strA != null && "audio".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(strA))) {
                                                break;
                                            } else {
                                                i2++;
                                            }
                                        } else {
                                            strA = null;
                                            break;
                                        }
                                    }
                                } else {
                                    strA = null;
                                    break;
                                }
                                if (!"audio/mp4a-latm".equals(strA)) {
                                    i |= 2;
                                }
                                if (str2 != null) {
                                    String[] strArrSplit2 = str2.split(StringUtils.COMMA);
                                    int length2 = strArrSplit2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < length2) {
                                            strA2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(strArrSplit2[i3]);
                                            if (strA2 != null && "video".equals(com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(strA2))) {
                                                break;
                                            } else {
                                                i3++;
                                            }
                                        } else {
                                            strA2 = null;
                                            break;
                                        }
                                    }
                                } else {
                                    strA2 = null;
                                    break;
                                }
                                if (!"video/avc".equals(strA2)) {
                                    i |= 4;
                                }
                            }
                            B b = new B(2, this.q, new C3160e(i, listEmptyList));
                            z2 = true;
                            pVar = b;
                        }
                    }
                    pVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.m(this.q);
                } else {
                    pVar = this.s;
                    z2 = false;
                }
                if (z2) {
                    pVar.a(this.D);
                }
                this.z = pVar;
            }
            z2 = true;
            if (z2) {
                pVar.a(this.D);
            }
            this.z = pVar;
        }
        if (this.s != this.z && !this.C && (kVar2 = this.n) != null) {
            int i4 = this.A;
            int i5 = z.f2192a;
            if (i4 != 0) {
                long j = kVar2.d;
                long j2 = j == -1 ? -1L : j - ((long) i4);
                Uri uri = kVar2.f2163a;
                long j3 = kVar2.c + ((long) i4);
                kVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri, j3, j3, j2, kVar2.e, kVar2.f);
            }
            try {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.m;
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar, kVar2.b, hVar.a(kVar2));
                int iA2 = 0;
                while (iA2 == 0) {
                    try {
                        if (this.E) {
                            break;
                        } else {
                            iA2 = this.z.a(bVar2, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.o) null);
                        }
                    } catch (Throwable th) {
                        this.A = (int) (bVar2.c - this.n.b);
                        throw th;
                    }
                }
                this.A = (int) (bVar2.c - this.n.b);
                z.a(this.h);
                this.C = true;
            } catch (Throwable th2) {
                z.a(this.h);
                throw th2;
            }
        }
        if (this.E) {
            return;
        }
        try {
            if (this.o) {
                kVar = this.f2122a;
                if (this.B != 0) {
                    z = true;
                }
                if (this.p) {
                    vVar = this.q;
                    if (vVar.f2190a == Long.MAX_VALUE) {
                        vVar.c(this.f);
                    }
                } else {
                    vVar2 = this.q;
                    synchronized (vVar2) {
                        while (vVar2.c == -9223372036854775807L) {
                            vVar2.wait();
                        }
                    }
                }
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar2 = this.h;
                bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar2, kVar.b, hVar2.a(kVar));
                if (this.z == null) {
                    jA = a(bVar);
                    if (jA != -9223372036854775807L) {
                        jB = this.q.b(jA);
                    } else {
                        jB = this.f;
                    }
                    this.z = a(jB);
                }
                if (z) {
                    bVar.a(this.B);
                }
                while (iA == 0) {
                    try {
                        if (!this.E) {
                            break;
                        } else {
                            iA = this.z.a(bVar, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.o) null);
                        }
                    } catch (Throwable th3) {
                        this.B = (int) (bVar.c - this.f2122a.b);
                        throw th3;
                    }
                }
                this.B = (int) (bVar.c - this.f2122a.b);
                z.a(this.h);
                this.F = true;
                return;
            }
            kVar = this.f2122a;
            int i6 = this.B;
            int i7 = z.f2192a;
            if (i6 != 0) {
                long j4 = kVar.d;
                long j5 = j4 != -1 ? j4 - ((long) i6) : -1L;
                Uri uri2 = kVar.f2163a;
                long j6 = kVar.c + ((long) i6);
                kVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.k(uri2, j6, j6, j5, kVar.e, kVar.f);
            }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar3 = this.h;
            bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(hVar3, kVar.b, hVar3.a(kVar));
            if (this.z == null) {
                jA = a(bVar);
                if (jA != -9223372036854775807L) {
                    jB = this.q.b(jA);
                } else {
                    jB = this.f;
                }
                this.z = a(jB);
            }
            if (z) {
                bVar.a(this.B);
            }
            while (iA == 0) {
                if (!this.E) {
                    break;
                    break;
                }
                iA = this.z.a(bVar, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.o) null);
            }
            this.B = (int) (bVar.c - this.f2122a.b);
            z.a(this.h);
            this.F = true;
            return;
        } catch (Throwable th4) {
            z.a(this.h);
            throw th4;
        }
        z = false;
        if (this.p) {
            vVar2 = this.q;
            synchronized (vVar2) {
                while (vVar2.c == -9223372036854775807L) {
                    vVar2.wait();
                }
            }
        } else {
            vVar = this.q;
            if (vVar.f2190a == Long.MAX_VALUE) {
                vVar.c(this.f);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.z
    public final boolean a() {
        return this.E;
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.i a(long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.i c3156a;
        if (this.r.endsWith(".aac")) {
            c3156a = new C3158c(j);
        } else if (!this.r.endsWith(".ac3") && !this.r.endsWith(".ec3")) {
            if (this.r.endsWith(".mp3")) {
                c3156a = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c(j);
            } else {
                throw new IllegalArgumentException("Unkown extension for audio file: " + this.r);
            }
        } else {
            c3156a = new C3156a(j);
        }
        c3156a.a(this.D);
        return c3156a;
    }
}

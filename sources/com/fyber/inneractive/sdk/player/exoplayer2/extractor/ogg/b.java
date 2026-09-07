package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2056a = new g();
    public final long b;
    public final long c;
    public final l d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    public b(long j, long j2, l lVar, int i, long j3) {
        if (j < 0 || j2 <= j) {
            throw new IllegalArgumentException();
        }
        this.d = lVar;
        this.b = j;
        this.c = j2;
        if (i != j2 - j) {
            this.e = 0;
        } else {
            this.f = j3;
            this.e = 3;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar) throws InterruptedException, IOException {
        g gVar;
        long jMin;
        int i;
        int i2 = this.e;
        long j = 0;
        if (i2 == 0) {
            long j2 = bVar.c;
            this.g = j2;
            this.e = 1;
            long j3 = this.c - 65307;
            if (j3 > j2) {
                return j3;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j4 = this.h;
            if (j4 == 0) {
                i = 3;
            } else {
                long j5 = this.i;
                long j6 = this.j;
                if (j5 == j6) {
                    jMin = -(this.k + 2);
                } else {
                    long j7 = bVar.c;
                    if (a(bVar, j6)) {
                        this.f2056a.a(bVar, false);
                        bVar.e = 0;
                        g gVar2 = this.f2056a;
                        long j8 = gVar2.b;
                        long j9 = j4 - j8;
                        int i3 = gVar2.d + gVar2.e;
                        if (j9 < 0 || j9 > 72000) {
                            if (j9 < 0) {
                                this.j = j7;
                                this.l = j8;
                            } else {
                                long j10 = i3;
                                long j11 = bVar.c + j10;
                                this.i = j11;
                                this.k = j8;
                                if ((this.j - j11) + j10 < 100000) {
                                    bVar.a(i3);
                                    jMin = -(this.k + 2);
                                }
                                j = 0;
                            }
                            long j12 = this.j;
                            long j13 = this.i;
                            long j14 = j12 - j13;
                            if (j14 < 100000) {
                                this.j = j13;
                                jMin = j13;
                            } else {
                                jMin = Math.min(Math.max(((j14 * j9) / (this.l - this.k)) + (bVar.c - ((long) (i3 * (j9 <= 0 ? 2 : 1)))), j13), this.j - 1);
                            }
                            j = 0;
                        } else {
                            bVar.a(i3);
                            jMin = -(this.f2056a.b + 2);
                        }
                    } else {
                        jMin = this.i;
                        if (jMin == j7) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (jMin >= j) {
                    return jMin;
                }
                long j15 = this.h;
                long j16 = -(jMin + 2);
                this.f2056a.a(bVar, false);
                while (true) {
                    g gVar3 = this.f2056a;
                    if (gVar3.b >= j15) {
                        break;
                    }
                    bVar.a(gVar3.d + gVar3.e);
                    g gVar4 = this.f2056a;
                    long j17 = gVar4.b;
                    gVar4.a(bVar, false);
                    j16 = j17;
                }
                bVar.e = 0;
                j = j16;
                i = 3;
            }
            this.e = i;
            return -(j + 2);
        }
        if (!a(bVar, this.c)) {
            throw new EOFException();
        }
        g gVar5 = this.f2056a;
        gVar5.f2060a = 0;
        gVar5.b = 0L;
        gVar5.c = 0;
        gVar5.d = 0;
        gVar5.e = 0;
        while (true) {
            gVar = this.f2056a;
            if ((gVar.f2060a & 4) == 4 || bVar.c >= this.c) {
                break;
            }
            gVar.a(bVar, false);
            g gVar6 = this.f2056a;
            bVar.a(gVar6.d + gVar6.e);
        }
        this.f = gVar.b;
        this.e = 3;
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.q b() {
        if (this.f != 0) {
            return new a(this);
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h
    public final long c(long j) {
        int i = this.e;
        if (i != 3 && i != 2) {
            throw new IllegalArgumentException();
        }
        long j2 = j == 0 ? 0L : (((long) this.d.i) * j) / 1000000;
        this.h = j2;
        this.e = 2;
        this.i = this.b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
        return j2;
    }

    public final boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, long j) throws InterruptedException, EOFException {
        int i;
        long jMin = Math.min(j + 3, this.c);
        int i2 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            long j2 = bVar.c;
            int i3 = 0;
            if (((long) i2) + j2 > jMin && (i2 = (int) (jMin - j2)) < 4) {
                return false;
            }
            bVar.a(bArr, 0, i2, false);
            while (true) {
                i = i2 - 3;
                if (i3 < i) {
                    if (bArr[i3] == 79 && bArr[i3 + 1] == 103 && bArr[i3 + 2] == 103 && bArr[i3 + 3] == 83) {
                        bVar.a(i3);
                        return true;
                    }
                    i3++;
                }
            }
            bVar.a(i);
        }
    }
}

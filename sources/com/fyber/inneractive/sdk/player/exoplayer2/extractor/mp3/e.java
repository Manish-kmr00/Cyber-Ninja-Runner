package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.util.z;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2034a;
    public final long b;
    public final long c;
    public final long[] d;
    public final long e;
    public final int f;

    public e(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.f2034a = j;
        this.b = j2;
        this.c = j3;
        this.d = jArr;
        this.e = j4;
        this.f = i;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final boolean a() {
        return this.d != null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b
    public final long b(long j) {
        long j2;
        if (!a()) {
            return 0L;
        }
        long j3 = this.f2034a;
        if (j < j3) {
            return 0L;
        }
        double d = ((j - j3) * 256.0d) / this.e;
        int iA = z.a(this.d, (long) d, false);
        int i = iA + 1;
        long j4 = this.b;
        long j5 = (((long) i) * j4) / 100;
        long j6 = i == 0 ? 0L : this.d[iA];
        long j7 = i == 99 ? 256L : this.d[i];
        long j8 = (j4 * ((long) (iA + 2))) / 100;
        if (j7 == j6) {
            j2 = 0;
        } else {
            j2 = (long) (((d - j6) * (j8 - j5)) / (j7 - j6));
        }
        return j5 + j2;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long c() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.q
    public final long a(long j) {
        if (!a()) {
            return this.f2034a;
        }
        float f = (j * 100.0f) / this.b;
        float f2 = 0.0f;
        if (f > 0.0f) {
            if (f >= 100.0f) {
                f2 = 256.0f;
            } else {
                int i = (int) f;
                f2 = i != 0 ? this.d[i - 1] : 0.0f;
                f2 += (f - i) * ((i < 99 ? this.d[i] : 256.0f) - f2);
            }
        }
        long jRound = Math.round(((double) f2) * 0.00390625d * this.e);
        long j2 = this.f2034a;
        long j3 = jRound + j2;
        long j4 = this.c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - ((long) this.f)) + this.e) - 1);
    }
}

package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes9.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.t f2165a = new com.fyber.inneractive.sdk.player.exoplayer2.util.t();
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;

    public final synchronized void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.s sVar;
        int i;
        float f;
        if (this.b <= 0) {
            throw new IllegalStateException();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = (int) (jElapsedRealtime - this.c);
        long j = i2;
        this.e += j;
        long j2 = this.f;
        long j3 = this.d;
        this.f = j2 + j3;
        if (i2 > 0) {
            float f2 = (RtspMediaSource.DEFAULT_TIMEOUT_MS * j3) / j;
            com.fyber.inneractive.sdk.player.exoplayer2.util.t tVar = this.f2165a;
            int iSqrt = (int) Math.sqrt(j3);
            if (tVar.d != 1) {
                Collections.sort(tVar.b, com.fyber.inneractive.sdk.player.exoplayer2.util.t.h);
                tVar.d = 1;
            }
            int i3 = tVar.g;
            if (i3 > 0) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.s[] sVarArr = tVar.c;
                int i4 = i3 - 1;
                tVar.g = i4;
                sVar = sVarArr[i4];
            } else {
                sVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.s();
            }
            int i5 = tVar.e;
            tVar.e = i5 + 1;
            sVar.f2187a = i5;
            sVar.b = iSqrt;
            sVar.c = f2;
            tVar.b.add(sVar);
            tVar.f += iSqrt;
            while (true) {
                int i6 = tVar.f;
                int i7 = tVar.f2188a;
                i = 0;
                if (i6 <= i7) {
                    break;
                }
                int i8 = i6 - i7;
                com.fyber.inneractive.sdk.player.exoplayer2.util.s sVar2 = (com.fyber.inneractive.sdk.player.exoplayer2.util.s) tVar.b.get(0);
                int i9 = sVar2.b;
                if (i9 <= i8) {
                    tVar.f -= i9;
                    tVar.b.remove(0);
                    int i10 = tVar.g;
                    if (i10 < 5) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.s[] sVarArr2 = tVar.c;
                        tVar.g = i10 + 1;
                        sVarArr2[i10] = sVar2;
                    }
                } else {
                    sVar2.b = i9 - i8;
                    tVar.f -= i8;
                }
            }
            if (this.e >= 2000 || this.f >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.t tVar2 = this.f2165a;
                if (tVar2.d != 0) {
                    Collections.sort(tVar2.b, com.fyber.inneractive.sdk.player.exoplayer2.util.t.i);
                    tVar2.d = 0;
                }
                float f3 = 0.5f * tVar2.f;
                int i11 = 0;
                while (true) {
                    if (i >= tVar2.b.size()) {
                        if (!tVar2.b.isEmpty()) {
                            ArrayList arrayList = tVar2.b;
                            f = ((com.fyber.inneractive.sdk.player.exoplayer2.util.s) arrayList.get(arrayList.size() - 1)).c;
                            break;
                        } else {
                            f = Float.NaN;
                            break;
                        }
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.s sVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.util.s) tVar2.b.get(i);
                    i11 += sVar3.b;
                    if (i11 >= f3) {
                        f = sVar3.c;
                        break;
                    }
                    i++;
                }
                Float.isNaN(f);
            }
        }
        int i12 = this.b - 1;
        this.b = i12;
        if (i12 > 0) {
            this.c = jElapsedRealtime;
        }
        this.d = 0L;
    }
}

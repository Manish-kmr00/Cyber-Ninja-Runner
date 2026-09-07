package com.mbridge.msdk.thrid.okio;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: SegmentPool.java */
/* JADX INFO: loaded from: classes12.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static o f5604a;
    static long b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            o oVar = f5604a;
            if (oVar == null) {
                return new o();
            }
            f5604a = oVar.f;
            oVar.f = null;
            b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f == null && oVar.g == null) {
            if (oVar.d) {
                return;
            }
            synchronized (p.class) {
                long j = b + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                if (j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                    return;
                }
                b = j;
                oVar.f = f5604a;
                oVar.c = 0;
                oVar.b = 0;
                f5604a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

package com.bytedance.sdk.component.Og.pA.Og;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: classes8.dex */
final class JG {
    static long Og;
    static ML pA;

    private JG() {
    }

    static ML pA() {
        synchronized (JG.class) {
            ML ml = pA;
            if (ml != null) {
                pA = ml.JG;
                ml.JG = null;
                Og -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return ml;
            }
            return new ML();
        }
    }

    static void pA(ML ml) {
        if (ml.JG != null || ml.SD != null) {
            throw new IllegalArgumentException();
        }
        if (ml.ZZv) {
            return;
        }
        synchronized (JG.class) {
            long j = Og;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            Og = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            ml.JG = pA;
            ml.KZx = 0;
            ml.Og = 0;
            pA = ml;
        }
    }
}

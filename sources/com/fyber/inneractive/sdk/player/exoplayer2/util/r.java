package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.Comparator;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        float f = ((s) obj).c;
        float f2 = ((s) obj2).c;
        if (f < f2) {
            return -1;
        }
        return f2 < f ? 1 : 0;
    }
}

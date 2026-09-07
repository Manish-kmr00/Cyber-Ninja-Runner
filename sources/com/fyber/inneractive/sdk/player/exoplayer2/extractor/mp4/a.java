package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends c {
    public final long P0;
    public final ArrayList Q0;
    public final ArrayList R0;

    public a(int i, long j) {
        super(i);
        this.P0 = j;
        this.Q0 = new ArrayList();
        this.R0 = new ArrayList();
    }

    public final a b(int i) {
        int size = this.R0.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) this.R0.get(i2);
            if (aVar.f2035a == i) {
                return aVar;
            }
        }
        return null;
    }

    public final b c(int i) {
        int size = this.Q0.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.Q0.get(i2);
            if (bVar.f2035a == i) {
                return bVar;
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c
    public final String toString() {
        return c.a(this.f2035a) + " leaves: " + Arrays.toString(this.Q0.toArray()) + " containers: " + Arrays.toString(this.R0.toArray());
    }
}

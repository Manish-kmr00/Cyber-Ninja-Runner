package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import java.io.EOFException;

/* JADX INFO: loaded from: classes13.dex */
public final class h implements r {
    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(long j, int i, int i2, int i3, byte[] bArr) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(com.fyber.inneractive.sdk.player.exoplayer2.o oVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final void a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) {
        nVar.e(nVar.b + i);
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.extractor.r
    public final int a(b bVar, int i, boolean z) throws InterruptedException, EOFException {
        int iMin = Math.min(bVar.f, i);
        bVar.b(iMin);
        if (iMin == 0) {
            iMin = bVar.a(b.g, 0, Math.min(i, 4096), 0, true);
        }
        if (iMin != -1) {
            bVar.c += (long) iMin;
        }
        if (iMin != -1) {
            return iMin;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }
}

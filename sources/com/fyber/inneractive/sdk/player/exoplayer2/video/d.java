package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.r;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2196a;
    public final int b;

    public d(int i, List list) {
        this.f2196a = list;
        this.b = i;
    }

    public static d a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) throws r {
        try {
            nVar.e(nVar.b + 21);
            int iJ = nVar.j() & 3;
            int iJ2 = nVar.j();
            int i = nVar.b;
            int i2 = 0;
            for (int i3 = 0; i3 < iJ2; i3++) {
                nVar.e(nVar.b + 1);
                int iO = nVar.o();
                for (int i4 = 0; i4 < iO; i4++) {
                    int iO2 = nVar.o();
                    i2 += iO2 + 4;
                    nVar.e(nVar.b + iO2);
                }
            }
            nVar.e(i);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < iJ2; i6++) {
                nVar.e(nVar.b + 1);
                int iO3 = nVar.o();
                for (int i7 = 0; i7 < iO3; i7++) {
                    int iO4 = nVar.o();
                    System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.l.f2182a, 0, bArr, i5, 4);
                    int i8 = i5 + 4;
                    System.arraycopy(nVar.f2184a, nVar.b, bArr, i8, iO4);
                    i5 = i8 + iO4;
                    nVar.e(nVar.b + iO4);
                }
            }
            return new d(iJ + 1, i2 == 0 ? null : Collections.singletonList(bArr));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new r("Error parsing HEVC config", e);
        }
    }
}

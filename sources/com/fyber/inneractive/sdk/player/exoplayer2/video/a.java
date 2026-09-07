package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2194a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public a(ArrayList arrayList, int i, int i2, int i3, float f) {
        this.f2194a = arrayList;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static a a(com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar) throws r {
        int i;
        int i2;
        float f;
        try {
            nVar.e(nVar.b + 4);
            int iJ = (nVar.j() & 3) + 1;
            if (iJ == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iJ2 = nVar.j() & 31;
            for (int i3 = 0; i3 < iJ2; i3++) {
                int iO = nVar.o();
                int i4 = nVar.b;
                nVar.e(i4 + iO);
                byte[] bArr = nVar.f2184a;
                byte[] bArr2 = new byte[iO + 4];
                System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.d.f2176a, 0, bArr2, 0, 4);
                System.arraycopy(bArr, i4, bArr2, 4, iO);
                arrayList.add(bArr2);
            }
            int iJ3 = nVar.j();
            for (int i5 = 0; i5 < iJ3; i5++) {
                int iO2 = nVar.o();
                int i6 = nVar.b;
                nVar.e(i6 + iO2);
                byte[] bArr3 = nVar.f2184a;
                byte[] bArr4 = new byte[iO2 + 4];
                System.arraycopy(com.fyber.inneractive.sdk.player.exoplayer2.util.d.f2176a, 0, bArr4, 0, 4);
                System.arraycopy(bArr3, i6, bArr4, 4, iO2);
                arrayList.add(bArr4);
            }
            if (iJ2 > 0) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.k kVarA = com.fyber.inneractive.sdk.player.exoplayer2.util.l.a((byte[]) arrayList.get(0), iJ, ((byte[]) arrayList.get(0)).length);
                int i7 = kVarA.b;
                int i8 = kVarA.c;
                f = kVarA.d;
                i = i7;
                i2 = i8;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new a(arrayList, iJ, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new r("Error parsing AVC config", e);
        }
    }
}

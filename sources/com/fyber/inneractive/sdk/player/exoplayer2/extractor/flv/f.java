package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.m;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends e {
    public final n b;
    public final n c;
    public int d;
    public boolean e;
    public int f;

    public f(r rVar) {
        super(rVar);
        this.b = new n(l.f2182a);
        this.c = new n(4);
    }

    public final boolean a(n nVar) throws d {
        int iJ = nVar.j();
        int i = (iJ >> 4) & 15;
        int i2 = iJ & 15;
        if (i2 != 7) {
            throw new d(m.a("Video format not supported: ", i2));
        }
        this.f = i;
        return i != 5;
    }

    public final void a(n nVar, long j) throws com.fyber.inneractive.sdk.player.exoplayer2.r {
        int iJ = nVar.j();
        long jL = (((long) nVar.l()) * 1000) + j;
        if (iJ == 0 && !this.e) {
            byte[] bArr = new byte[nVar.c - nVar.b];
            n nVar2 = new n(bArr);
            nVar.a(bArr, 0, nVar.c - nVar.b);
            com.fyber.inneractive.sdk.player.exoplayer2.video.a aVarA = com.fyber.inneractive.sdk.player.exoplayer2.video.a.a(nVar2);
            this.d = aVarA.b;
            this.f2003a.a(o.a(null, "video/avc", -1, aVarA.c, aVarA.d, aVarA.f2194a, -1, aVarA.e, null, -1, null, null));
            this.e = true;
            return;
        }
        if (iJ == 1 && this.e) {
            byte[] bArr2 = this.c.f2184a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i = 4 - this.d;
            int i2 = 0;
            while (nVar.c - nVar.b > 0) {
                nVar.a(this.c.f2184a, i, this.d);
                this.c.e(0);
                int iM = this.c.m();
                this.b.e(0);
                this.f2003a.a(4, this.b);
                this.f2003a.a(iM, nVar);
                i2 = i2 + 4 + iM;
            }
            this.f2003a.a(jL, this.f == 1 ? 1 : 0, i2, 0, null);
        }
    }
}

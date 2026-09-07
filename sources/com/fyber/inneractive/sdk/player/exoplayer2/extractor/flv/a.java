package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.o;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;
import java.util.Collections;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends e {
    public static final int[] e = {5512, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public a(r rVar) {
        super(rVar);
    }

    public final boolean a(n nVar) throws d {
        if (this.b) {
            nVar.e(nVar.b + 1);
        } else {
            int iJ = nVar.j();
            int i = (iJ >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.f2003a.a(o.a(null, "audio/mpeg", -1, -1, 1, e[(iJ >> 2) & 3], null, null, null));
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.f2003a.a(o.a(null, i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", -1, -1, 1, 8000, (iJ & 1) == 1 ? 2 : 3, -1, -1, null, null, 0, null, null));
                this.c = true;
            } else if (i != 10) {
                throw new d("Audio format not supported: " + this.d);
            }
            this.b = true;
        }
        return true;
    }

    public final void a(n nVar, long j) {
        if (this.d == 2) {
            int i = nVar.c - nVar.b;
            this.f2003a.a(i, nVar);
            this.f2003a.a(j, 1, i, 0, null);
            return;
        }
        int iJ = nVar.j();
        if (iJ == 0 && !this.c) {
            int i2 = nVar.c - nVar.b;
            byte[] bArr = new byte[i2];
            nVar.a(bArr, 0, i2);
            Pair pairA = com.fyber.inneractive.sdk.player.exoplayer2.util.d.a(bArr);
            this.f2003a.a(o.a(null, "audio/mp4a-latm", -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), Collections.singletonList(bArr), null, null));
            this.c = true;
            return;
        }
        if (this.d != 10 || iJ == 1) {
            int i3 = nVar.c - nVar.b;
            this.f2003a.a(i3, nVar);
            this.f2003a.a(j, 1, i3, 0, null);
        }
    }
}

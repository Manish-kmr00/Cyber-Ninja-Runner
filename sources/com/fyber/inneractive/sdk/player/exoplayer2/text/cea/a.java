package com.fyber.inneractive.sdk.player.exoplayer2.text.cea;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.n;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {
    public static void a(long j, n nVar, r[] rVarArr) {
        int i;
        int iJ;
        while (nVar.c - nVar.b > 1) {
            int i2 = 0;
            while (true) {
                if (nVar.c - nVar.b == 0) {
                    i = -1;
                    break;
                }
                int iJ2 = nVar.j();
                i2 += iJ2;
                if (iJ2 != 255) {
                    i = i2;
                    break;
                }
            }
            int i3 = 0;
            do {
                if (nVar.c - nVar.b == 0) {
                    i3 = -1;
                    break;
                } else {
                    iJ = nVar.j();
                    i3 += iJ;
                }
            } while (iJ == 255);
            if (i3 != -1) {
                int i4 = nVar.c;
                int i5 = nVar.b;
                if (i3 <= i4 - i5) {
                    if (i == 4 && i3 >= 8) {
                        int iJ3 = nVar.j();
                        int iO = nVar.o();
                        int iB = nVar.b();
                        int iJ4 = nVar.j();
                        nVar.e(i5);
                        if (iJ3 == 181 && iO == 49 && iB == 1195456820 && iJ4 == 3) {
                            nVar.e(nVar.b + 8);
                            int iJ5 = nVar.j() & 31;
                            nVar.e(nVar.b + 1);
                            int i6 = iJ5 * 3;
                            int i7 = nVar.b;
                            for (r rVar : rVarArr) {
                                nVar.e(i7);
                                rVar.a(i6, nVar);
                                rVar.a(j, 1, i6, 0, null);
                            }
                            nVar.e(nVar.b + (i3 - (i6 + 10)));
                        }
                    }
                    nVar.e(nVar.b + i3);
                }
            }
            Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
            nVar.e(nVar.c);
        }
    }
}

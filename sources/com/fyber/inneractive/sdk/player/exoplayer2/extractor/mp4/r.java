package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import java.io.EOFException;

/* JADX INFO: loaded from: classes11.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f2048a = {z.a("isom"), z.a("iso2"), z.a("iso3"), z.a("iso4"), z.a("iso5"), z.a("iso6"), z.a("avc1"), z.a("hvc1"), z.a("hev1"), z.a("mp41"), z.a("mp42"), z.a("3g2a"), z.a("3g2b"), z.a("3gr6"), z.a("3gs6"), z.a("3ge6"), z.a("3gg6"), z.a("M4V "), z.a("M4A "), z.a("f4v "), z.a("kddi"), z.a("M4VP"), z.a("qt  "), z.a("MSNV")};

    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar, boolean z) throws InterruptedException, EOFException {
        boolean z2;
        boolean z3;
        int i;
        long j = bVar.b;
        if (j == -1 || j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = 4096;
        }
        int i2 = (int) j;
        com.fyber.inneractive.sdk.player.exoplayer2.util.n nVar = new com.fyber.inneractive.sdk.player.exoplayer2.util.n(64);
        int i3 = 0;
        boolean z4 = false;
        while (true) {
            if (i3 < i2) {
                nVar.c(8);
                bVar.a(nVar.f2184a, 0, 8, false);
                long jK = nVar.k();
                int iB = nVar.b();
                if (jK == 1) {
                    bVar.a(nVar.f2184a, 8, 8, false);
                    nVar.d(16);
                    i = 16;
                    jK = nVar.n();
                } else {
                    i = 8;
                }
                long j2 = i;
                if (jK < j2) {
                    return false;
                }
                i3 += i;
                if (iB != c.C) {
                    if (iB == c.L || iB == c.N) {
                        z2 = true;
                        z3 = true;
                        if (!z4 && z == z3) {
                            return z2;
                        }
                    }
                    if ((((long) i3) + jK) - j2 < i2) {
                        int i4 = (int) (jK - j2);
                        i3 += i4;
                        if (iB == c.b) {
                            if (i4 < 8) {
                                return false;
                            }
                            nVar.c(i4);
                            bVar.a(nVar.f2184a, 0, i4, false);
                            int i5 = i4 / 4;
                            for (int i6 = 0; i6 < i5; i6++) {
                                if (i6 != 1) {
                                    int iB2 = nVar.b();
                                    if ((iB2 >>> 8) != z.a("3gp")) {
                                        int[] iArr = f2048a;
                                        int length = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length) {
                                                continue;
                                            } else if (iArr[i7] != iB2) {
                                                i7++;
                                            }
                                        }
                                    }
                                    z4 = true;
                                    break;
                                }
                                nVar.e(nVar.b + 4);
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            bVar.a(i4, false);
                        }
                    }
                }
            }
            z2 = true;
            z3 = false;
            return !z4 ? false : false;
        }
    }
}

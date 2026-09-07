package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class S7 implements YK {
    public static String[] A05 = {"vfQptEavCBaQ4shb4qTQ2Im4Va5BuDnO", "JiQZW7nhM5jecL1Ppc", "hnwXp9bv64zC75tT", "dWpaD8T4ZQJ5Q0FNk1Z", "lRetC72ZWUiGcWxiU67VotPfpeJyuSHi", "OzCNbEqBWRgV3Rv1ObtqMLQClM1AAi", "9ecBBYmeQ8JsEZV55k", "KMfWSLnEN9JR6reOC5HqOSDCR3KuqNUo"};
    public final int A00;
    public final /* synthetic */ S6 A04;
    public final C2446fp A03 = new C2446fp(new byte[5]);
    public final SparseArray<YT> A01 = new SparseArray<>();
    public final SparseIntArray A02 = new SparseIntArray();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.YK
    public final void A50(C2447fq c2447fq) {
        C2461g4 c2461g4;
        if (c2447fq.A0I() != 2) {
            return;
        }
        if (this.A04.A09 == 1 || this.A04.A09 == 2 || this.A04.A02 == 1) {
            c2461g4 = (C2461g4) this.A04.A0I.get(0);
        } else {
            c2461g4 = new C2461g4(((C2461g4) this.A04.A0I.get(0)).A02());
            this.A04.A0I.add(c2461g4);
        }
        if ((c2447fq.A0I() & 128) == 0) {
            return;
        }
        c2447fq.A0g(1);
        int iA0M = c2447fq.A0M();
        int i = 3;
        c2447fq.A0g(3);
        c2447fq.A0h(this.A03, 2);
        this.A03.A09(3);
        int i2 = 13;
        this.A04.A01 = this.A03.A04(13);
        c2447fq.A0h(this.A03, 2);
        int i3 = 4;
        this.A03.A09(4);
        c2447fq.A0g(this.A03.A04(12));
        int i4 = 21;
        if (this.A04.A09 == 2 && this.A04.A05 == null) {
            this.A04.A05 = this.A04.A0G.A5L(21, new YP(21, null, null, AbstractC2471gE.A07));
            if (this.A04.A05 != null) {
                this.A04.A05.AA3(c2461g4, this.A04.A03, new YS(iA0M, 21, 8192));
            }
        }
        this.A01.clear();
        this.A02.clear();
        int iA07 = c2447fq.A07();
        while (iA07 > 0) {
            c2447fq.A0h(this.A03, 5);
            int iA04 = this.A03.A04(8);
            this.A03.A09(i);
            int iA05 = this.A03.A04(i2);
            this.A03.A09(i3);
            int iA06 = this.A03.A04(12);
            YP ypA00 = A00(c2447fq, iA06);
            if (iA04 == 6 || iA04 == 5) {
                iA04 = ypA00.A00;
            }
            iA07 -= iA06 + 5;
            int i5 = this.A04.A09 == 2 ? iA04 : iA05;
            if (!this.A04.A0C.get(i5)) {
                YT ytA5L = (this.A04.A09 == 2 && iA04 == i4) ? this.A04.A05 : this.A04.A0G.A5L(iA04, ypA00);
                if (this.A04.A09 != 2 || iA05 < this.A02.get(i5, 8192)) {
                    this.A02.put(i5, iA05);
                    this.A01.put(i5, ytA5L);
                }
            }
            i4 = 21;
            i = 3;
            i3 = 4;
            i2 = 13;
        }
        int size = this.A02.size();
        for (int i6 = 0; i6 < size; i6++) {
            int iKeyAt = this.A02.keyAt(i6);
            int iValueAt = this.A02.valueAt(i6);
            this.A04.A0C.put(iKeyAt, true);
            this.A04.A0D.put(iValueAt, true);
            YT ytValueAt = this.A01.valueAt(i6);
            if (ytValueAt != null) {
                if (ytValueAt != this.A04.A05) {
                    ytValueAt.AA3(c2461g4, this.A04.A03, new YS(iA0M, iKeyAt, 8192));
                }
                this.A04.A0B.put(iValueAt, ytValueAt);
            }
        }
        if (this.A04.A09 != 2) {
            this.A04.A0B.remove(this.A00);
            this.A04.A02 = this.A04.A09 != 1 ? this.A04.A02 - 1 : 0;
            if (this.A04.A02 == 0) {
                this.A04.A03.A6E();
                this.A04.A08 = true;
                return;
            }
            return;
        }
        if (this.A04.A08) {
            return;
        }
        this.A04.A03.A6E();
        S6 s6 = this.A04;
        if (A05[5].length() != 30) {
            throw new RuntimeException();
        }
        A05[4] = "rTvkxqDpJGCr29TVFwkztj3c1JBdgqxl";
        s6.A02 = 0;
        this.A04.A08 = true;
    }

    public S7(S6 s6, int i) {
        this.A04 = s6;
        this.A00 = i;
    }

    private YP A00(C2447fq c2447fq, int i) {
        int positionOfNextDescriptor = c2447fq.A09();
        int i2 = positionOfNextDescriptor + i;
        int descriptorLength = -1;
        String strTrim = null;
        List<TsPayloadReader.DvbSubtitleInfo> dvbSubtitleInfos = null;
        while (c2447fq.A09() < i2) {
            int descriptorsStartPosition = c2447fq.A0I();
            int descriptorTag = c2447fq.A09() + c2447fq.A0I();
            if (descriptorTag > i2) {
                break;
            }
            if (descriptorsStartPosition == 5) {
                long jA0Q = c2447fq.A0Q();
                if (jA0Q == 1094921523) {
                    descriptorLength = 129;
                } else if (jA0Q == 1161904947) {
                    descriptorLength = 135;
                } else if (jA0Q == 1094921524) {
                    descriptorLength = 172;
                } else if (jA0Q == 1212503619) {
                    descriptorLength = 36;
                }
            } else if (descriptorsStartPosition == 106) {
                descriptorLength = 129;
            } else if (descriptorsStartPosition == 122) {
                descriptorLength = 135;
            } else if (descriptorsStartPosition == 127) {
                if (c2447fq.A0I() == 21) {
                    descriptorLength = 172;
                }
            } else if (descriptorsStartPosition == 123) {
                descriptorLength = 138;
            } else if (descriptorsStartPosition == 10) {
                strTrim = c2447fq.A0W(3).trim();
            } else if (descriptorsStartPosition == 89) {
                descriptorLength = 89;
                dvbSubtitleInfos = new ArrayList<>();
                while (c2447fq.A09() < descriptorTag) {
                    String language = c2447fq.A0W(3).trim();
                    int streamType = c2447fq.A0I();
                    byte[] bArr = new byte[4];
                    c2447fq.A0k(bArr, 0, 4);
                    dvbSubtitleInfos.add(new YO(language, streamType, bArr));
                }
            } else if (descriptorsStartPosition == 111) {
                descriptorLength = 257;
            }
            c2447fq.A0g(descriptorTag - c2447fq.A09());
        }
        c2447fq.A0f(i2);
        return new YP(descriptorLength, strTrim, dvbSubtitleInfos, Arrays.copyOfRange(c2447fq.A0l(), positionOfNextDescriptor, i2));
    }

    @Override // com.facebook.ads.redexgen.core.YK
    public final void AA3(C2461g4 c2461g4, UL ul, YS ys) {
    }
}

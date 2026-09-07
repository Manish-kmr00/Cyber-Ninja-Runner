package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.google.android.exoplayer2.Timeline;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class QB extends AbstractC2289dG {
    public static String[] A01 = {"gHe6Ggz9iQvLoeqfI7z0Fxxa2bOPFJVC", "mRaRFCBn69tPfujuPAjRFPYxHQXp9RZc", "CSSFDgS5gh03TQ1AYsGOm7d", "zjwBQPent3AQFjnpPPQBXvHN2Tq8EaDX", "cDNJWjlLvsmdd9mkRSbb8bT", "", "", "QEHUtPc9dofNZwowDCRZe3wvjD0c8w3x"};
    public C2281d8 A00;

    public abstract Pair<C1857Ql[], QD[]> A0d(C2281d8 c2281d8, int[][][] iArr, int[] iArr2, R5 r5, Timeline timeline) throws EK;

    public static int A0Y(InterfaceC1854Qi[] interfaceC1854QiArr, C2046Yc c2046Yc, int[] iArr, boolean z) throws EK {
        int length = interfaceC1854QiArr.length;
        int formatSupportLevel = 0;
        int i = 1;
        for (int i2 = 0; i2 < bestRendererIndex; i2++) {
            InterfaceC1854Qi interfaceC1854Qi = interfaceC1854QiArr[i2];
            int iMax = 0;
            for (int bestFormatSupportLevel = 0; bestFormatSupportLevel < bestRendererIndex; bestFormatSupportLevel++) {
                int bestRendererIndex = interfaceC1854Qi.AJR(c2046Yc.A08(bestFormatSupportLevel));
                iMax = Math.max(iMax, AbstractC1847Qb.A03(bestRendererIndex));
            }
            int bestRendererIndex2 = iArr[i2];
            int bestRendererIndex3 = bestRendererIndex2 == 0 ? 1 : 0;
            if (iMax > formatSupportLevel || (iMax == formatSupportLevel && z && i == 0 && bestRendererIndex3 != 0)) {
                length = i2;
                formatSupportLevel = iMax;
                i = bestRendererIndex3;
            }
        }
        return length;
    }

    public static int[] A0Z(InterfaceC1854Qi interfaceC1854Qi, C2046Yc c2046Yc) throws EK {
        int[] iArr = new int[c2046Yc.A01];
        for (int i = 0; i < c2046Yc.A01; i++) {
            iArr[i] = interfaceC1854Qi.AJR(c2046Yc.A08(i));
        }
        return iArr;
    }

    public static int[] A0a(InterfaceC1854Qi[] interfaceC1854QiArr) throws EK {
        int[] iArr = new int[interfaceC1854QiArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = interfaceC1854QiArr[i].AJT();
        }
        return iArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2289dG
    public final C2290dH A0b(InterfaceC1854Qi[] interfaceC1854QiArr, C1863Qs c1863Qs, R5 r5, Timeline timeline) throws EK {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[interfaceC1854QiArr.length + 1];
        C2046Yc[][] c2046YcArr = new C2046Yc[interfaceC1854QiArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC1854QiArr.length + 1][][];
        for (int i = 0; i < c2046YcArr.length; i++) {
            c2046YcArr[i] = new C2046Yc[c1863Qs.A01];
            iArr2[i] = new int[c1863Qs.A01][];
        }
        int[] iArrA0a = A0a(interfaceC1854QiArr);
        int groupIndex = 0;
        while (true) {
            int i2 = c1863Qs.A01;
            if (A01[7].charAt(15) != 'w') {
                throw new RuntimeException();
            }
            A01[7] = "nXGM96RwffhgFmQwkLMDI9egGDlSsBJ3";
            if (groupIndex < i2) {
                C2046Yc c2046YcA05 = c1863Qs.A05(groupIndex);
                int iA0Y = A0Y(interfaceC1854QiArr, c2046YcA05, iArr, c2046YcA05.A02 == 5);
                if (iA0Y == interfaceC1854QiArr.length) {
                    rendererTrackGroupCounts = new int[c2046YcA05.A01];
                } else {
                    rendererTrackGroupCounts = A0Z(interfaceC1854QiArr[iA0Y], c2046YcA05);
                }
                int i3 = iArr[iA0Y];
                c2046YcArr[iA0Y][i3] = c2046YcA05;
                iArr2[iA0Y][i3] = rendererTrackGroupCounts;
                iArr[iA0Y] = iArr[iA0Y] + 1;
                groupIndex++;
            } else {
                C1863Qs[] c1863QsArr = new C1863Qs[interfaceC1854QiArr.length];
                String[] strArr = new String[interfaceC1854QiArr.length];
                int[] iArr3 = new int[interfaceC1854QiArr.length];
                for (int i4 = 0; i4 < interfaceC1854QiArr.length; i4++) {
                    int i5 = iArr[i4];
                    c1863QsArr[i4] = new C1863Qs((C2046Yc[]) AbstractC2471gE.A1I(c2046YcArr[i4], i5));
                    iArr2[i4] = (int[][]) AbstractC2471gE.A1I(iArr2[i4], i5);
                    strArr[i4] = interfaceC1854QiArr[i4].getName();
                    iArr3[i4] = interfaceC1854QiArr[i4].A9D();
                }
                C2281d8 c2281d8 = new C2281d8(strArr, iArr3, c1863QsArr, iArrA0a, iArr2, new C1863Qs((C2046Yc[]) AbstractC2471gE.A1I(c2046YcArr[interfaceC1854QiArr.length], iArr[interfaceC1854QiArr.length])));
                Pair<C1857Ql[], QD[]> pairA0d = A0d(c2281d8, iArr2, iArrA0a, r5, timeline);
                return new C2290dH((C1857Ql[]) pairA0d.first, (QD[]) pairA0d.second, AbstractC2286dD.A00(c2281d8, (InterfaceC2283dA[]) pairA0d.second), c2281d8);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2289dG
    public final void A0c(Object obj) {
        this.A00 = (C2281d8) obj;
    }
}

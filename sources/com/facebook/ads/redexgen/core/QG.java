package com.facebook.ads.redexgen.core;

import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QG extends AbstractC2274d1<QG> implements Comparable<QG> {
    public static String[] A09 = {"oqngY", "qMEFLQnO0Q8REuu02rd1rF5q2V4d4OQA", "z6RfqXu7lNsIR9Wafks52Ys6qdiWwLfM", "JoaONmxYGX01kLvx0aLrRWmeQi7T1Jw5", "2dQ11Kp8eWyx9xXzUEbW2", "anhUGieJSAV3cH3WtE2DMzo", "glHOpQ4ugmKXesfyj90OHOt", "qWOiwF8Y0gw"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A01(List<QG> list, List<QG> list2) {
        return list.get(0).compareTo(list2.get(0));
    }

    public QG(int i, C2046Yc c2046Yc, int i2, C13565v c13565v, int i3, String str) {
        List<String> listA03;
        super(i, c2046Yc, i2);
        int i4 = 0;
        this.A08 = C13555u.A0S(i3, false);
        int i5 = super.A02.A0H & (~((YN) c13565v).A00);
        this.A06 = (i5 & 1) != 0;
        this.A07 = (i5 & 2) != 0;
        int i6 = Integer.MAX_VALUE;
        int bestLanguageScore = 0;
        if (c13565v.A0K.isEmpty()) {
            listA03 = MetaExoPlayerCustomizedCollections.A03("");
        } else {
            listA03 = c13565v.A0K;
        }
        for (int bestLanguageIndex = 0; bestLanguageIndex < listA03.size(); bestLanguageIndex++) {
            int iA02 = C13555u.A02(super.A02, listA03.get(bestLanguageIndex), c13565v.A0P);
            if (iA02 > 0) {
                i6 = bestLanguageIndex;
                bestLanguageScore = iA02;
                break;
            }
        }
        this.A00 = i6;
        this.A01 = bestLanguageScore;
        this.A02 = C13555u.A00(super.A02.A0E, ((YN) c13565v).A0C);
        this.A05 = (super.A02.A0E & 1088) != 0;
        this.A03 = C13555u.A02(super.A02, str, C13555u.A0K(str) == null);
        boolean z = this.A01 > 0 || (c13565v.A0K.isEmpty() && this.A02 > 0) || this.A06 || (this.A07 && this.A03 > 0);
        if (C13555u.A0S(i3, c13565v.A0B) && z) {
            i4 = 1;
        }
        this.A04 = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(QG qg) {
        AbstractC2766l7 abstractC2766l7A06 = AbstractC2766l7.A01().A09(this.A08, qg.A08).A08(Integer.valueOf(this.A00), Integer.valueOf(qg.A00), AbstractC2912nY.A03().A06()).A06(this.A01, qg.A01).A06(this.A02, qg.A02).A09(this.A06, qg.A06).A08(Boolean.valueOf(this.A07), Boolean.valueOf(qg.A07), this.A01 == 0 ? AbstractC2912nY.A03() : AbstractC2912nY.A03().A06()).A06(this.A03, qg.A03);
        if (this.A02 == 0) {
            abstractC2766l7A06 = abstractC2766l7A06.A0A(this.A05, qg.A05);
        }
        int iA05 = abstractC2766l7A06.A05();
        String[] strArr = A09;
        if (strArr[1].charAt(30) == strArr[2].charAt(30)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[1] = "SY8E7kgrm9e0g6qoJVPzg9XsttDzkb0f";
        strArr2[2] = "8zxpMcslFpolnzCvDOLMWnvDxrTTFQxe";
        return iA05;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4T != com.google.common.collect.ImmutableList$Builder<com.google.android.exoplayer2.trackselection.DefaultTrackSelector$TextTrackInfo> */
    public static OI<QG> A02(int i, C2046Yc c2046Yc, C13565v c13565v, int[] iArr, String str) {
        C4T c4tA01 = OI.A01();
        for (int i2 = 0; i2 < c2046Yc.A01; i2++) {
            c4tA01.A04(new QG(i, c2046Yc, i2, c13565v, iArr[i2], str));
        }
        return c4tA01.A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC2274d1
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final boolean A09(QG qg) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2274d1
    public final int A08() {
        return this.A04;
    }
}

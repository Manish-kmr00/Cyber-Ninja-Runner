package com.facebook.ads.redexgen.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XY {
    public static byte[] A0D;
    public static String[] A0E = {"qQ2af1nC3sp6i564q4", "KwZkkXtnaEwcARXIpM5CxbFZIgt", "vRpFBJuaF8FNOVFokj0ryhPld5UVLrxW", "P9g", "IGGl8CPeRG6iOLlkYAjFy2Y8l0ATtgV9", "t0LSlopIzwWz8L4SMrD7DSrPXTUyZlLl", "Vnd4MO5DVUvnKgMnCBClQoUlnThJBpL0", "1xuauaF35bVXmGZPKfSXJhL7VnKUmz"};
    public List<XY> A00;
    public final long A01;
    public final long A02;
    public final XY A03;
    public final C2023Xf A04;
    public final String A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public final boolean A09;
    public final HashMap<String, Integer> A0A;
    public final HashMap<String, Integer> A0B;
    public final String[] A0C;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0D = new byte[]{112, 96, 48, Base64.padSymbol, 34, Ascii.RS, Ascii.SYN, 7, Ascii.DC2, Ascii.ETB, Ascii.DC2, 7, Ascii.DC2, 126};
    }

    static {
        A04();
    }

    public XY(String str, String str2, long j, long j2, C2023Xf c2023Xf, String[] strArr, String str3, String str4, XY xy) {
        this.A07 = str;
        this.A08 = str2;
        this.A05 = str4;
        this.A04 = c2023Xf;
        this.A0C = strArr;
        this.A09 = str2 != null;
        this.A02 = j;
        this.A01 = j2;
        this.A06 = (String) AbstractC2388es.A01(str3);
        this.A03 = xy;
        this.A0B = new HashMap<>();
        this.A0A = new HashMap<>();
    }

    public static SpannableStringBuilder A00(String str, Map<String, C2245cY> map) {
        if (!map.containsKey(str)) {
            C2245cY c2245cY = new C2245cY();
            c2245cY.A0G(new SpannableStringBuilder());
            map.put(str, c2245cY);
        }
        C2245cY regionOutput = map.get(str);
        return (SpannableStringBuilder) AbstractC2388es.A01(regionOutput.A0I());
    }

    public static XY A01(String str) {
        return new XY(null, AbstractC2018Xa.A04(str), -9223372036854775807L, -9223372036854775807L, null, null, A03(0, 0, 64), null, null);
    }

    public static XY A02(String str, long j, long j2, C2023Xf c2023Xf, String[] strArr, String str2, String str3, XY xy) {
        return new XY(str, null, j, j2, c2023Xf, strArr, str2, str3, xy);
    }

    private void A05(long j, String str, List<Pair<String, String>> regionImageList) {
        if (!A03(0, 0, 64).equals(this.A06)) {
            str = this.A06;
        }
        if (A0B(j)) {
            String strA03 = A03(2, 3, 120);
            String resolvedRegionId = this.A07;
            if (strA03.equals(resolvedRegionId)) {
                String resolvedRegionId2 = this.A05;
                if (resolvedRegionId2 != null) {
                    regionImageList.add(new Pair<>(str, this.A05));
                    return;
                }
            }
        }
        for (int i = 0; i < A0C(); i++) {
            A0D(i).A05(j, str, regionImageList);
        }
    }

    private void A06(long j, Map<String, C2023Xf> map, Map<String, XZ> map2, String str, Map<String, C2245cY> map3) {
        String str2 = str;
        if (!A0B(j)) {
            return;
        }
        if (!A03(0, 0, 64).equals(this.A06)) {
            str2 = this.A06;
        }
        Iterator<Map.Entry<String, Integer>> it = this.A0A.entrySet().iterator();
        while (true) {
            Map<String, C2023Xf> map4 = map;
            if (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                String regionId = next.getKey();
                int iIntValue = this.A0B.containsKey(regionId) ? this.A0B.get(regionId).intValue() : 0;
                Integer value = next.getValue();
                String[] strArr = A0E;
                if (strArr[5].charAt(26) != strArr[2].charAt(26)) {
                    break;
                }
                String[] strArr2 = A0E;
                strArr2[1] = "xyFoCu3m66uMaquczQy2LaakrWL";
                strArr2[3] = "RwT";
                int verticalType = value.intValue();
                if (iIntValue != verticalType) {
                    A09(map4, (C2245cY) AbstractC2388es.A01(map3.get(regionId)), iIntValue, verticalType, ((XZ) AbstractC2388es.A01(map2.get(str2))).A08);
                }
            } else {
                for (int i = 0; i < i; i++) {
                    XY xyA0D = A0D(i);
                    if (A0E[4].charAt(8) != 'R') {
                        break;
                    }
                    A0E[0] = "6QYhv5bOOrSTAVWTSg";
                    map4 = map4;
                    xyA0D.A06(j, map4, map2, str2, map3);
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cf A[SYNTHETIC] */
    private void A07(long j, boolean z, String str, Map<String, C2245cY> map) {
        HashMap<String, Integer> map2;
        String key;
        C2245cY value;
        String[] strArr;
        String str2 = str;
        this.A0B.clear();
        this.A0A.clear();
        if (A03(5, 8, 95).equals(this.A07)) {
            return;
        }
        if (!A03(0, 0, 64).equals(this.A06)) {
            str2 = this.A06;
        }
        if (this.A09 && z) {
            SpannableStringBuilder spannableStringBuilderA00 = A00(str2, map);
            String resolvedRegionId = this.A08;
            spannableStringBuilderA00.append((CharSequence) AbstractC2388es.A01(resolvedRegionId));
            return;
        }
        String strA03 = A03(0, 2, 62);
        String resolvedRegionId2 = this.A07;
        if (strA03.equals(resolvedRegionId2) && z) {
            SpannableStringBuilder spannableStringBuilderA01 = A00(str2, map);
            if (A0E[4].charAt(8) != 'R') {
                throw new RuntimeException();
            }
            A0E[6] = "ukEHThv2j4E0PRyOOSAIFvvIIVuZuGfH";
            spannableStringBuilderA01.append('\n');
            return;
        }
        if (!A0B(j)) {
            return;
        }
        Iterator<Map.Entry<String, C2245cY>> it = map.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0E[6].charAt(16) != 'm') {
                A0E[0] = "5mtSFV3Tf6N4tkXejt";
                if (!zHasNext) {
                    break;
                }
                Map.Entry<String, C2245cY> next = it.next();
                map2 = this.A0B;
                key = next.getKey();
                value = next.getValue();
                strArr = A0E;
                if (strArr[5].charAt(26) != strArr[2].charAt(26)) {
                    String[] strArr2 = A0E;
                    strArr2[5] = "86h9f1QTIfO1lfap1vxXBTWrVaUjAnkF";
                    strArr2[2] = "O3UvIfuzJFeQu3TcSOm6J9aUqVUseAuM";
                    map2.put(key, Integer.valueOf(((CharSequence) AbstractC2388es.A01(value.A0I())).length()));
                } else {
                    A0E[6] = "jtPnIiw3d9IIMJv2H3FRPIGshC3CJ3ue";
                    map2.put(key, Integer.valueOf(((CharSequence) AbstractC2388es.A01(value.A0I())).length()));
                }
            } else {
                if (!zHasNext) {
                    break;
                }
                Map.Entry<String, C2245cY> next2 = it.next();
                map2 = this.A0B;
                key = next2.getKey();
                value = next2.getValue();
                strArr = A0E;
                if (strArr[5].charAt(26) != strArr[2].charAt(26)) {
                    String[] strArr3 = A0E;
                    strArr3[5] = "86h9f1QTIfO1lfap1vxXBTWrVaUjAnkF";
                    strArr3[2] = "O3UvIfuzJFeQu3TcSOm6J9aUqVUseAuM";
                    map2.put(key, Integer.valueOf(((CharSequence) AbstractC2388es.A01(value.A0I())).length()));
                } else {
                    A0E[6] = "jtPnIiw3d9IIMJv2H3FRPIGshC3CJ3ue";
                    map2.put(key, Integer.valueOf(((CharSequence) AbstractC2388es.A01(value.A0I())).length()));
                }
            }
        }
        String strA04 = A03(13, 1, 34);
        String resolvedRegionId3 = this.A07;
        boolean zEquals = strA04.equals(resolvedRegionId3);
        for (int i = 0; i < A0C(); i++) {
            A0D(i).A07(j, z || zEquals, str2, map);
        }
        if (zEquals) {
            AbstractC2018Xa.A07(A00(str2, map));
        }
        for (Map.Entry<String, C2245cY> entry : map.entrySet()) {
            this.A0A.put(entry.getKey(), Integer.valueOf(((CharSequence) AbstractC2388es.A01(entry.getValue().A0I())).length()));
        }
    }

    public static void A08(SpannableStringBuilder spannableStringBuilder) {
        for (XR xr : (XR[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), XR.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(xr), spannableStringBuilder.getSpanEnd(xr), (CharSequence) A03(0, 0, 64));
        }
        for (int spacesToDelete = 0; spacesToDelete < spannableStringBuilder.length(); spacesToDelete++) {
            char cCharAt = spannableStringBuilder.charAt(spacesToDelete);
            String[] strArr = A0E;
            String str = strArr[5];
            String str2 = strArr[2];
            int i = str.charAt(26);
            if (i != str2.charAt(26)) {
                throw new RuntimeException();
            }
            A0E[6] = "tC17RDg6Hvof5kf7j25CQSuyUNpVd2Tb";
            if (cCharAt == ' ') {
                int i2 = spacesToDelete + 1;
                while (i2 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i2) == ' ') {
                    i2++;
                }
                int i3 = i2 - (spacesToDelete + 1);
                if (i3 > 0) {
                    spannableStringBuilder.delete(spacesToDelete, spacesToDelete + i3);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i4 = 0; i4 < spannableStringBuilder.length() - 1; i4++) {
            if (spannableStringBuilder.charAt(i4) == '\n' && spannableStringBuilder.charAt(i4 + 1) == ' ') {
                int i5 = i4 + 1;
                spannableStringBuilder.delete(i5, i4 + 2);
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i6 = 0; i6 < spannableStringBuilder.length() - 1; i6++) {
            if (spannableStringBuilder.charAt(i6) == ' ' && spannableStringBuilder.charAt(i6 + 1) == '\n') {
                spannableStringBuilder.delete(i6, i6 + 1);
            }
        }
        int length = spannableStringBuilder.length();
        if (A0E[6].charAt(16) != 'm') {
            A0E[6] = "TXpkebIqq2bhCZS8RwWkB9p2jCQ6zTDP";
            if (length <= 0) {
                return;
            }
        } else if (length <= 0) {
            return;
        }
        if (spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
    }

    private void A09(Map<String, C2023Xf> map, C2245cY c2245cY, int i, int i2, int i3) {
        C2023Xf c2023XfA02 = AbstractC2018Xa.A02(this.A04, this.A0C, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) c2245cY.A0I();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            c2245cY.A0G(spannableStringBuilder);
        }
        if (c2023XfA02 != null) {
            AbstractC2018Xa.A06(spannableStringBuilder, i, i2, c2023XfA02, this.A03, map, i3);
            if (A03(13, 1, 34).equals(this.A07)) {
                if (c2023XfA02.A04() != Float.MAX_VALUE) {
                    c2245cY.A05((c2023XfA02.A04() * (-90.0f)) / 100.0f);
                }
                if (c2023XfA02.A0C() != null) {
                    c2245cY.A0F(c2023XfA02.A0C());
                }
                if (c2023XfA02.A0B() != null) {
                    Layout.Alignment alignmentA0B = c2023XfA02.A0B();
                    if (A0E[0].length() != 18) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0E;
                    strArr[1] = "emVkUyppSgRxUoPafouBPBPzudl";
                    strArr[3] = "H1b";
                    c2245cY.A0E(alignmentA0B);
                }
            }
        }
    }

    private void A0A(TreeSet<Long> out, boolean z) {
        boolean zEquals = A03(13, 1, 34).equals(this.A07);
        boolean isPNode = A03(2, 3, 120).equals(this.A07);
        if (z || zEquals || (isPNode && this.A05 != null)) {
            if (this.A02 != -9223372036854775807L) {
                out.add(Long.valueOf(this.A02));
            }
            long j = this.A01;
            if (A0E[0].length() != 18) {
                throw new RuntimeException();
            }
            A0E[7] = "uJ110GDpm3v4QqcwcuG81IUTvh8SAb";
            if (j != -9223372036854775807L) {
                out.add(Long.valueOf(this.A01));
            }
        }
        if (this.A00 == null) {
            return;
        }
        for (int i = 0; i < this.A00.size(); i++) {
            XY xy = this.A00.get(i);
            boolean isPNode2 = z || zEquals;
            xy.A0A(out, isPNode2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0030  */
    private final boolean A0B(long j) {
        if (this.A02 != -9223372036854775807L) {
            return this.A02 <= j ? false : false;
        }
        long j2 = this.A01;
        if (A0E[0].length() != 18) {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[1] = "0O4PsdT19rUrsW8cFFDkquioTyi";
        strArr[3] = "Odq";
        if (j2 != -9223372036854775807L) {
            if ((this.A02 <= j || this.A01 != -9223372036854775807L) && ((this.A02 != -9223372036854775807L || j >= this.A01) && (this.A02 > j || j >= this.A01))) {
            }
        }
        return true;
    }

    public final int A0C() {
        if (this.A00 == null) {
            return 0;
        }
        return this.A00.size();
    }

    public final XY A0D(int i) {
        if (this.A00 != null) {
            return this.A00.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<C1853Qh> A0E(long j, Map<String, C2023Xf> map, Map<String, XZ> map2, Map<String, String> map3) {
        List<Pair<String, String>> arrayList = new ArrayList<>();
        A05(j, this.A06, arrayList);
        TreeMap treeMap = new TreeMap();
        A07(j, false, this.A06, treeMap);
        A06(j, map, map2, this.A06, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair<String, String> regionImagePair : arrayList) {
            String str = map3.get(regionImagePair.second);
            if (str != null) {
                byte[] bArrDecode = android.util.Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                XZ xz = (XZ) AbstractC2388es.A01(map2.get(regionImagePair.first));
                arrayList2.add(new C2245cY().A0D(bitmapDecodeByteArray).A04(xz.A02).A0A(0).A07(xz.A01, 0).A09(xz.A05).A06(xz.A04).A03(xz.A00).A0B(xz.A08).A0H());
            }
        }
        Set setEntrySet = treeMap.entrySet();
        if (A0E[6].charAt(16) == 'm') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[1] = "PJ2Eb4vxaDmikAtNVNRsk3kawRO";
        strArr[3] = "Jbu";
        Iterator it = setEntrySet.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr2 = A0E;
            if (strArr2[1].length() == strArr2[3].length()) {
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                XZ xz2 = (XZ) AbstractC2388es.A01(map2.get(entry.getKey()));
                C2245cY c2245cY = (C2245cY) entry.getValue();
                A08((SpannableStringBuilder) AbstractC2388es.A01(c2245cY.A0I()));
                c2245cY.A07(xz2.A01, xz2.A06);
                c2245cY.A09(xz2.A05);
                c2245cY.A04(xz2.A02);
                c2245cY.A06(xz2.A04);
                c2245cY.A08(xz2.A03, xz2.A07);
                c2245cY.A0B(xz2.A08);
                arrayList2.add(c2245cY.A0H());
            } else {
                String[] strArr3 = A0E;
                strArr3[5] = "JBi8F8oP2NpxvnjSRoMaykPtlvURiSyj";
                strArr3[2] = "wel2TOL6fBeZ5lmdXIxjLoGqEUURBQum";
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) it.next();
                XZ xz3 = (XZ) AbstractC2388es.A01(map2.get(entry2.getKey()));
                C2245cY c2245cY2 = (C2245cY) entry2.getValue();
                A08((SpannableStringBuilder) AbstractC2388es.A01(c2245cY2.A0I()));
                c2245cY2.A07(xz3.A01, xz3.A06);
                c2245cY2.A09(xz3.A05);
                c2245cY2.A04(xz3.A02);
                c2245cY2.A06(xz3.A04);
                c2245cY2.A08(xz3.A03, xz3.A07);
                c2245cY2.A0B(xz3.A08);
                arrayList2.add(c2245cY2.A0H());
            }
        }
        return arrayList2;
    }

    public final void A0F(XY xy) {
        if (this.A00 == null) {
            this.A00 = new ArrayList();
        }
        this.A00.add(xy);
    }

    public final long[] A0G() {
        TreeSet<Long> treeSet = new TreeSet<>();
        A0A(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        int i = 0;
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        return jArr;
    }

    public final String[] A0H() {
        return this.A0C;
    }
}

package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class V9 extends V5 {
    public static byte[] A03;
    public static String[] A04 = {"V82MeCyFK9EUzOcQv3aCHkcB5YGijFM0", "yRWTEy", "XXPNUk1p2fLnq6rVD1k8lFaa1VRn1Yuh", "cNGjD0ozRjs1pNHnGnCLhsBvQfkYvlwl", "KGWkiuPyqvtOX7EuFRSvOvrEFI4aP547", "9CnEkbJJ1mvqN35zkBKUphM32xCtiaaX", "CNkTVaXxwtTEhPjH9BmaKJQvNACCVyBM", "24i3lXOCXpDwGQjkfmGy0ndEt5hgSpnW"};
    public long A00;
    public long[] A01;
    public long[] A02;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        byte[] bArr = {124, 109, 106, 121, 108, 113, 119, 118, 92, 83, 86, 95, 74, 85, 73, 83, 78, 83, 85, 84, 73, Ascii.GS, 19, Ascii.SI, Ascii.DLE, 4, Ascii.ETB, Ascii.ESC, 19, 5, 123, 122, 89, 113, 96, 117, 80, 117, 96, 117, 106, 119, 115, 123, 109};
        if (A04[1].length() == 31) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[3] = "Y9iGrVu1LEiCE4YnE2lzq2bhBIFDqOkp";
        strArr[2] = "BW1TYfDIqaPoIIG9WB4E7s95ePhS2It5";
        A03 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0C(C2447fq c2447fq, long j) {
        if (A00(c2447fq) != 2) {
            return false;
        }
        if (!A04(30, 10, 116).equals(A05(c2447fq)) || c2447fq.A07() == 0 || A00(c2447fq) != 8) {
            return false;
        }
        HashMap<String, Object> mapA08 = A08(c2447fq);
        Object obj = mapA08.get(A04(0, 8, 120));
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.A00 = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapA08.get(A04(21, 9, 22));
        if (!(obj2 instanceof Map)) {
            return false;
        }
        Map map = (Map) obj2;
        Object obj3 = map.get(A04(8, 13, 90));
        Object obj4 = map.get(A04(40, 5, 126));
        if (!(obj3 instanceof List)) {
            return false;
        }
        boolean z = obj4 instanceof List;
        String[] strArr = A04;
        if (strArr[3].charAt(2) == strArr[2].charAt(2)) {
            throw new RuntimeException();
        }
        A04[1] = "TGROKAxMffc6qRBtmf";
        if (!z) {
            return false;
        }
        List list = (List) obj3;
        List list2 = (List) obj4;
        int size = list2.size();
        this.A02 = new long[size];
        this.A01 = new long[size];
        for (int i = 0; i < size; i++) {
            Object obj5 = list.get(i);
            Object obj6 = list2.get(i);
            if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                this.A02 = new long[0];
                this.A01 = new long[0];
                return false;
            }
            this.A02[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
            this.A01[i] = ((Double) obj5).longValue();
        }
        return false;
    }

    static {
        A0A();
    }

    public V9() {
        super(new WN());
        this.A00 = -9223372036854775807L;
        this.A02 = new long[0];
        this.A01 = new long[0];
    }

    public static int A00(C2447fq c2447fq) {
        return c2447fq.A0I();
    }

    public static Boolean A01(C2447fq c2447fq) {
        return Boolean.valueOf(c2447fq.A0I() == 1);
    }

    public static Double A02(C2447fq c2447fq) {
        return Double.valueOf(Double.longBitsToDouble(c2447fq.A0P()));
    }

    public static Object A03(C2447fq c2447fq, int i) {
        switch (i) {
            case 0:
                return A02(c2447fq);
            case 1:
                return A01(c2447fq);
            case 2:
                return A05(c2447fq);
            case 3:
                return A09(c2447fq);
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            default:
                if (A04[1].length() == 31) {
                    throw new RuntimeException();
                }
                String[] strArr = A04;
                strArr[0] = "FWcNTHb92xG2foGl8xEkp8XRdtuKcwkx";
                strArr[4] = "TpEVGstNvjQP5kRCNVcSZBXLTNWEPf2a";
                return null;
            case 8:
                return A08(c2447fq);
            case 10:
                return A06(c2447fq);
            case 11:
                return A07(c2447fq);
        }
    }

    public static String A05(C2447fq c2447fq) {
        int iA0M = c2447fq.A0M();
        int iA09 = c2447fq.A09();
        c2447fq.A0g(iA0M);
        return new String(c2447fq.A0l(), iA09, iA0M);
    }

    public static ArrayList<Object> A06(C2447fq c2447fq) {
        int iA0L = c2447fq.A0L();
        ArrayList<Object> arrayList = new ArrayList<>(iA0L);
        for (int i = 0; i < iA0L; i++) {
            int count = A00(c2447fq);
            Object objA03 = A03(c2447fq, count);
            if (objA03 != null) {
                arrayList.add(objA03);
            }
        }
        return arrayList;
    }

    public static Date A07(C2447fq c2447fq) {
        Date date = new Date((long) A02(c2447fq).doubleValue());
        c2447fq.A0g(2);
        return date;
    }

    public static HashMap<String, Object> A08(C2447fq c2447fq) {
        int iA0L = c2447fq.A0L();
        HashMap<String, Object> map = new HashMap<>(iA0L);
        for (int i = 0; i < iA0L; i++) {
            String strA05 = A05(c2447fq);
            int count = A00(c2447fq);
            Object objA03 = A03(c2447fq, count);
            if (objA03 != null) {
                map.put(strA05, objA03);
            }
        }
        return map;
    }

    public static HashMap<String, Object> A09(C2447fq c2447fq) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strA05 = A05(c2447fq);
            int iA00 = A00(c2447fq);
            if (iA00 == 9) {
                return map;
            }
            Object objA03 = A03(c2447fq, iA00);
            if (objA03 != null) {
                map.put(strA05, objA03);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.V5
    public final boolean A0B(C2447fq c2447fq) {
        return true;
    }

    public final long A0D() {
        return this.A00;
    }

    public final long[] A0E() {
        return this.A01;
    }

    public final long[] A0F() {
        return this.A02;
    }
}

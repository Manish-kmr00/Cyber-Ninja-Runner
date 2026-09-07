package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC13395d implements Runnable {
    public static Comparator<C13385c> A04;
    public static byte[] A05;
    public static String[] A06 = {"ZWObiMwNkhaZGfEgqHenCxQvRQCezgXM", "iKaB5ntiNbaiz6tgW", "JplxjEE1IYbCInXXNCkbxZV0", "UEoPOy6vCmPnpiXEMXmcZKvRtDoHf0nN", "JvUlYJe7lgtJoJN1gtwvhyIs", "RcG3r4ysor4dcgCWVGn8CFYsdgQ7jZkt", "cxmAjzJ", "EyohaYHYoMvb6y9gFGiucolIeU60NsdM"};
    public static final ThreadLocal<RunnableC13395d> A07;
    public long A00;
    public long A01;
    public ArrayList<MG> A02 = new ArrayList<>();
    public ArrayList<C13385c> A03 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{105, 109, Ascii.ESC, 117, 94, 72, 79, 94, 95, Ascii.ESC, 107, 73, 94, 93, 94, 79, 88, 83, 100, 96, Ascii.SYN, 102, 68, 83, 80, 83, 66, 85, 94};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new Comparator<C13385c>() { // from class: com.facebook.ads.redexgen.X.5b
            public static String[] A00 = {"RlDlwXS4AA55AOqx8zmN7uoMQ4", "FglEZvMIBCB6z", "AxTekMmYmWDdJoDxuavW255zDNKNRAPE", "pDpvZxom4p5NfzWuwibdxFCyrgD8wKok", "A10HdUhRMRjxQ62diLF5JQ0qPoODY0oj", "HiaacAz8KFEe90RKULVJfn7mD15J7Igj", "NHRqTP3H9N0qm1ewn1pnzRz0iIE8sZVk", "d5VyinGL3JDhuqMz7l90vG32rgbNgkhM"};

            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final int compare(C13385c c13385c, C13385c c13385c2) {
                if ((c13385c.A03 == null) != (c13385c2.A03 == null)) {
                    MG mg = c13385c.A03;
                    if (A00[1].length() == 18) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A00;
                    strArr[7] = "WTdcF3CBINcFCy4xHoe1W3dXr7HqLtJl";
                    strArr[3] = "sYvRb4Jfa5Xca5GLbtDoWdBBrccl9kaR";
                    return mg == null ? 1 : -1;
                }
                if (c13385c.A04 != c13385c2.A04) {
                    return c13385c.A04 ? -1 : 1;
                }
                int i = c13385c2.A02 - c13385c.A02;
                if (i != 0) {
                    return i;
                }
                int i2 = c13385c.A00;
                int deltaViewVelocity = c13385c2.A00;
                int i3 = i2 - deltaViewVelocity;
                if (i3 != 0) {
                    return i3;
                }
                return 0;
            }
        };
    }

    private C6K A00(MG mg, int i, long j) {
        if (A08(mg, i)) {
            return null;
        }
        C6A c6a = mg.A0r;
        try {
            mg.A1M();
            C6K c6kA0I = c6a.A0I(i, false, j);
            if (c6kA0I != null) {
                if (c6kA0I.A0Y() && !c6kA0I.A0Z()) {
                    c6a.A0T(c6kA0I.A0H);
                } else {
                    c6a.A0Z(c6kA0I, false);
                }
            }
            return c6kA0I;
        } finally {
            mg.A1o(false);
        }
    }

    private void A02() {
        C13385c c13385c;
        int size = this.A02.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            MG mg = this.A02.get(i2);
            int viewCount = mg.getWindowVisibility();
            if (viewCount == 0) {
                mg.A02.A04(mg, false);
                int viewCount2 = mg.A02.A00;
                i += viewCount2;
            }
        }
        this.A03.ensureCapacity(i);
        int j = 0;
        for (int i3 = 0; i3 < size; i3++) {
            MG mg2 = this.A02.get(i3);
            int viewCount3 = mg2.getWindowVisibility();
            if (viewCount3 == 0) {
                C2772lD c2772lD = mg2.A02;
                int viewCount4 = c2772lD.A01;
                int i4 = Math.abs(viewCount4);
                int viewCount5 = c2772lD.A02;
                int i5 = i4 + Math.abs(viewCount5);
                for (int i6 = 0; i6 < viewCount * 2; i6 += 2) {
                    int viewCount6 = this.A03.size();
                    if (j >= viewCount6) {
                        c13385c = new C13385c();
                        this.A03.add(c13385c);
                    } else {
                        c13385c = this.A03.get(j);
                    }
                    int totalTaskCount = i6 + 1;
                    int totalTaskIndex = c2772lD.A03[totalTaskCount];
                    c13385c.A04 = totalTaskIndex <= i5;
                    c13385c.A02 = i5;
                    c13385c.A00 = totalTaskIndex;
                    c13385c.A03 = mg2;
                    int totalTaskCount2 = c2772lD.A03[i6];
                    c13385c.A01 = totalTaskCount2;
                    j++;
                }
            }
        }
        Collections.sort(this.A03, A04);
    }

    private void A04(long j) {
        for (int i = 0; i < i; i++) {
            C13385c c13385c = this.A03.get(i);
            if (A06[7].charAt(15) != 'g') {
                throw new RuntimeException();
            }
            A06[6] = "gpZ2KV2";
            C13385c c13385c2 = c13385c;
            if (c13385c2.A03 == null) {
                return;
            }
            A06(c13385c2, j);
            c13385c2.A00();
        }
    }

    private final void A05(long j) {
        A02();
        A04(j);
    }

    private void A06(C13385c c13385c, long j) {
        C6K c6kA00 = A00(c13385c.A03, c13385c.A01, c13385c.A04 ? Long.MAX_VALUE : j);
        if (c6kA00 != null && c6kA00.A09 != null && c6kA00.A0Y() && !c6kA00.A0Z()) {
            MG mg = c6kA00.A09.get();
            if (A06[3].charAt(4) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "y01bdO2VJYUoPT1JEr7HCeGbjhjinZRt";
            strArr[5] = "ogbTL45N3M3fzw26YptkCantwmvhDLLM";
            A07(mg, j);
        }
    }

    private void A07(MG mg, long j) {
        if (mg == null) {
            return;
        }
        if (mg.A0C && mg.A01.A06() != 0) {
            mg.A1P();
        }
        C2772lD c2772lD = mg.A02;
        c2772lD.A04(mg, true);
        if (c2772lD.A00 != 0) {
            try {
                AnonymousClass44.A01(A01(0, 18, 83));
                mg.A0s.A05(mg.A04);
                for (int i = 0; i < c2772lD.A00 * 2; i += 2) {
                    A00(mg, c2772lD.A03[i], j);
                }
                AnonymousClass44.A00();
            } catch (Throwable th) {
                AnonymousClass44.A00();
                throw th;
            }
        }
    }

    public static boolean A08(MG mg, int i) {
        int iA06 = mg.A01.A06();
        for (int i2 = 0; i2 < iA06; i2++) {
            C6K c6kA0F = MG.A0F(mg.A01.A0A(i2));
            int childCount = c6kA0F.A03;
            if (childCount == i && !c6kA0F.A0Z()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(MG mg) {
        this.A02.add(mg);
    }

    public final void A0A(MG mg) {
        this.A02.remove(mg);
    }

    public final void A0B(MG mg, int i, int i2) {
        if (mg.isAttachedToWindow()) {
            long j = this.A01;
            String[] strArr = A06;
            if (strArr[0].charAt(20) != strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            A06[6] = "T8Y6UBY";
            if (j == 0) {
                this.A01 = mg.getNanoTime();
                mg.post(this);
            }
        }
        mg.A02.A03(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AnonymousClass44.A01(A01(18, 11, 94));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                if (A06[6].length() != 7) {
                    throw new RuntimeException();
                }
                A06[7] = "jOxF3Mzmcdx8L8GgZmI4I6pGAsyGGZV3";
                AnonymousClass44.A00();
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                MG mg = this.A02.get(i);
                if (mg.getWindowVisibility() == 0) {
                    jMax = Math.max(mg.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.A01 = 0L;
                AnonymousClass44.A00();
            } else {
                A05(TimeUnit.MILLISECONDS.toNanos(jMax) + this.A00);
                this.A01 = 0L;
                AnonymousClass44.A00();
            }
        } catch (Throwable th) {
            this.A01 = 0L;
            AnonymousClass44.A00();
            throw th;
        }
    }
}

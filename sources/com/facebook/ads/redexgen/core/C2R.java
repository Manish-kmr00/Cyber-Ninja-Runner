package com.facebook.ads.redexgen.core;

import android.graphics.Rect;
import androidx.core.util.Preconditions;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2R implements InterfaceC1780Nh {
    public static byte[] A09;
    public static String[] A0A = {"5g", "bfnfjiUri9kvxuLEKnZU3kJc1ieY23zz", "NIX", "B1MUzprhDDigVQ4p3NlPN3VyWdkPEAJB", "UzK", "rOCmuOM4l5uJjn2akKGm2JxYL79BUlOr", "kAulvLpzcmVynuK8kNGYEaaJbNqcwElD", "7ScKsdjGN77oK2tO1d"};
    public static final String A0B;
    public long A00;
    public InterfaceC2956oZ A01;
    public final InterfaceC2954oX A02;
    public final C2947oN A03;
    public final C2947oN A04;
    public final List<Rect> A05;
    public final Map<String, C2946oM> A06;
    public final boolean A07;
    public final boolean A08;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "GBjOApmdB9meVYu3h8dWYwSrfWPE5QmB";
            strArr2[6] = "rSzbUr5mB5cqWCHa6t40U5C3uIAdU8ry";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 73);
            i4++;
        }
    }

    public static void A03() {
        A09 = new byte[]{Ascii.DC4, 40, 41, 51, 96, 54, 41, 37, 55, 48, 47, 41, 46, 52, 96, 40, 33, 51, 96, 46, 47, 52, 96, 34, 37, 37, 46, 96, 45, 37, 33, 51, 53, 50, 37, 36, 96, 47, 50, 96, 41, 51, 96, 33, 96, 39, 50, 47, 53, 48, 96, 55, 40, 41, 35, 40, 96, 55, 41, 44, 44, 96, 46, 37, 54, 37, 50, 96, 50, 37, 52, 53, 50, 46, 96, 33, 96, 45, 37, 33, 51, 53, 50, 37, 45, 37, 46, 52, 96, 51, 41, 46, 35, 37, 96, 41, 52, 103, 51, 96, 45, 33, 36, 37, 96, 53, 48, 96, 47, 38, 96, 51, 53, 34, 54, 41, 37, 55, 51, 96, 52, 40, 33, 52, 96, 35, 47, 53, 44, 36, 96, 34, 37, 96, 47, 38, 38, 51, 35, 50, 37, 37, 46, Ascii.DLE, Ascii.ESC, 9, 45, Ascii.GS, Ascii.US, Ascii.DLE, Base64.padSymbol, 38, 63, 63, 115, 37, 58, 54, 36, 115, 35, 33, 60, 35, 54, 33, 39, 42, 115, 53, 60, 33, 115, 33, 54, 62, 60, 37, 54, 55, 115, 58, 39, 54, 62, 115, Ascii.RS, 2, Ascii.VT, Ascii.EM, 63, 8, Ascii.GS, 2, Ascii.US, Ascii.EM};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1780Nh
    public final void A6F(List<C2959oc<?, ?>> list) {
        A05(this.A04);
        A04(this.A04);
        A05(this.A03);
        A04(this.A03);
        if (list != null) {
            A06(list);
        }
        if (0 != 0) {
            new C2945oL(toString(), this, this.A05, this.A04.A00(), this.A03.A00());
            throw new NullPointerException(A02(143, 7, 55));
        }
    }

    static {
        A03();
        A0B = C2R.class.getSimpleName();
    }

    public C2R(InterfaceC2954oX interfaceC2954oX) {
        this(interfaceC2954oX, false, false);
    }

    public C2R(InterfaceC2954oX interfaceC2954oX, boolean z, boolean z2) {
        this.A06 = new HashMap();
        this.A04 = new C2947oN();
        this.A03 = new C2947oN();
        this.A05 = new ArrayList(1);
        this.A02 = interfaceC2954oX;
        this.A08 = z;
        this.A07 = z2;
    }

    public static Rect A00(C2946oM c2946oM) {
        if (c2946oM == null || c2946oM.A02.top == Integer.MIN_VALUE || c2946oM.A02.left == Integer.MIN_VALUE || c2946oM.A02.right == Integer.MIN_VALUE || c2946oM.A02.bottom == Integer.MIN_VALUE) {
            throw new IllegalStateException(A02(0, 143, 9));
        }
        return c2946oM.A02;
    }

    private C2946oM A01(C2959oc c2959oc, Rect rect, Rect rect2) {
        C2946oM c2946oMA03 = this.A06.get(c2959oc.A02);
        if (this.A04.A06(c2959oc)) {
            if (c2946oMA03 != null) {
                c2946oMA03.A01 = EnumC2950oQ.A04;
            } else {
                c2946oMA03 = C2946oM.A03(this.A00);
                this.A06.put(c2959oc.A02, c2946oMA03);
            }
        }
        C2946oM viewProperties = (C2946oM) Preconditions.checkNotNull(c2946oMA03);
        viewProperties.A02.set(rect2);
        c2946oMA03.A03.add(new Rect(rect));
        return c2946oMA03;
    }

    private void A04(C2947oN c2947oN) {
        for (C2959oc c2959oc : c2947oN.A01()) {
            C2946oM c2946oM = this.A06.get(c2959oc.A02);
            if (c2946oM == null) {
                if (0 != 0) {
                    String str = A02(150, 36, 26) + c2959oc.A02;
                    throw new NullPointerException(A02(186, 10, 36));
                }
            } else {
                c2946oM.A01 = EnumC2950oQ.A03;
                c2946oM.A03.clear();
                c2959oc.A03(this);
                if (this.A08) {
                    this.A06.remove(c2946oM);
                }
            }
        }
    }

    private void A05(C2947oN c2947oN) {
        Iterator it = c2947oN.A00().iterator();
        while (it.hasNext()) {
            ((C2959oc) it.next()).A03(this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    private void A06(List<C2959oc<?, ?>> list) {
        for (C2959oc<?, ?> c2959oc : list) {
            if (this.A06.get(c2959oc.A02) != null) {
                boolean z = c2959oc.A04;
                if (A0A[0].length() != 2) {
                    throw new RuntimeException();
                }
                A0A[7] = "nPwsVC";
                if (z) {
                    EnumC2950oQ enumC2950oQ = c2959oc.A01;
                    String[] strArr = A0A;
                    if (strArr[5].length() != strArr[6].length()) {
                        A0A[0] = "zj";
                        if (enumC2950oQ != null) {
                            if (c2959oc.A01 != EnumC2950oQ.A03) {
                                c2959oc.A03(this);
                            }
                        }
                    } else {
                        String[] strArr2 = A0A;
                        strArr2[4] = "4Gl";
                        strArr2[2] = "t26";
                        if (enumC2950oQ != null) {
                            if (c2959oc.A01 != EnumC2950oQ.A03) {
                                c2959oc.A03(this);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1780Nh
    public final void A3w(C2959oc c2959oc, Rect rect, Rect rect2) {
        A01(c2959oc, rect, rect2);
        C2959oc c2959oc2 = c2959oc.A05;
        C2959oc parentViewpointData = C2959oc.A0B;
        if (c2959oc2 == parentViewpointData || c2959oc2 == null) {
            return;
        }
        boolean zA06 = this.A03.A06(c2959oc2);
        C2946oM parentViewProperties = this.A06.get(c2959oc2.A02);
        if (zA06) {
            if (parentViewProperties == null) {
                parentViewProperties = C2946oM.A03(this.A00);
                parentViewProperties.A02.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
                this.A06.put(c2959oc2.A02, parentViewProperties);
            } else {
                parentViewProperties.A03.clear();
                if (!this.A07 || c2959oc2.A04()) {
                    parentViewProperties.A01 = EnumC2950oQ.A04;
                }
            }
        }
        Preconditions.checkNotNull(parentViewProperties);
        ((List) Preconditions.checkNotNull(parentViewProperties.A03)).add(new Rect(rect));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1780Nh
    public final void A4X(long j, List<Rect> list) {
        this.A00 = j;
        this.A05.clear();
        Iterator<Rect> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A0A;
            if (strArr[3].charAt(2) == strArr[1].charAt(2)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[4] = "xWg";
            strArr2[2] = "l5f";
            if (zHasNext) {
                this.A05.add(new Rect(it.next()));
            } else {
                Iterator it2 = this.A04.A01().iterator();
                while (true) {
                    boolean zHasNext2 = it2.hasNext();
                    if (A0A[0].length() == 2) {
                        String[] strArr3 = A0A;
                        strArr3[3] = "KXc0LwnJCEJYYpq44EYPYXvj71LHxLBt";
                        strArr3[1] = "SZ9db6jeJg1WeryC8zmRUBHGUrGxU8hd";
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C2959oc) it2.next()).A02);
                    } else {
                        if (!zHasNext2) {
                            break;
                        }
                        this.A06.remove(((C2959oc) it2.next()).A02);
                    }
                }
                Collection<C2959oc> collectionA01 = this.A03.A01();
                if (A0A[0].length() != 2) {
                    throw new RuntimeException();
                }
                A0A[0] = "Au";
                for (C2959oc viewpointData : collectionA01) {
                    this.A06.remove(viewpointData.A02);
                }
                Iterator<C2946oM> it3 = this.A06.values().iterator();
                while (it3.hasNext()) {
                    it3.next().A03.clear();
                }
                this.A04.A04();
                this.A03.A04();
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2949oP
    public final void A83(C2959oc c2959oc, Rect rect) {
        rect.setEmpty();
        Iterator it = ((C2946oM) Preconditions.checkNotNull(this.A06.get(c2959oc.A02))).A03.iterator();
        while (it.hasNext()) {
            rect.union((Rect) it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2949oP
    public final EnumC2950oQ A9K(C2959oc c2959oc) {
        EnumC2950oQ enumC2950oQ = ((C2946oM) Preconditions.checkNotNull(this.A06.get(c2959oc.A02))).A01;
        if (c2959oc.A04) {
            if (c2959oc.A00 == EnumC2960od.A04) {
                EnumC2950oQ viewState = EnumC2950oQ.A03;
                return viewState;
            }
            EnumC2950oQ viewState2 = EnumC2950oQ.A04;
            if (enumC2950oQ == viewState2 && !c2959oc.A04()) {
                EnumC2950oQ viewState3 = EnumC2950oQ.A02;
                return viewState3;
            }
        }
        return enumC2950oQ;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2949oP
    public final void A9M(Rect rect) {
        rect.setEmpty();
        Iterator<Rect> it = this.A05.iterator();
        while (it.hasNext()) {
            rect.union(it.next());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2949oP
    public final float A9N(C2959oc c2959oc) {
        C2946oM c2946oM = this.A06.get(c2959oc.A02);
        if (c2946oM != null) {
            Rect rectA00 = A00(c2946oM);
            int iHeight = rectA00.height() * rectA00.width();
            int totalVisibleArea = 0;
            for (Rect rect : c2946oM.A03) {
                totalVisibleArea += rect.height() * rect.width();
            }
            return totalVisibleArea / iHeight;
        }
        return 0.0f;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1780Nh
    public final void AJ0(InterfaceC2956oZ interfaceC2956oZ) {
        this.A01 = interfaceC2956oZ;
    }
}

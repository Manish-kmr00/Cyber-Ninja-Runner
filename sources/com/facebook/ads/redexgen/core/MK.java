package com.facebook.ads.redexgen.core;

import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class MK extends AbstractC2746km {
    public static String[] A02 = {"ZvwGPtqIyq", "yiAZi4T0ry", "MW2e2TOPDP9pjEe4rTD", "HlrRgmhjIEURNOsi3rdB558cP", "dU7euze3hj2U1ev62XjIRTQ2vrQriAnf", "8gl08jl5gi3EpiFcU", "SXjkVQ4wGxN0zpwvt09Xfw5qzXSeRw0d", "Y5nQdyuIxyo1Orqk0oN6DnQ8XCev4LBn"};
    public AbstractC13475m A00;
    public AbstractC13475m A01;

    private int A00(AnonymousClass62 anonymousClass62, View view, AbstractC13475m abstractC13475m) {
        int containerCenter;
        int iA0F = abstractC13475m.A0F(view) + (abstractC13475m.A0D(view) / 2);
        if (anonymousClass62.A1T()) {
            int iA0A = abstractC13475m.A0A();
            int childCenter = abstractC13475m.A0B();
            containerCenter = iA0A + (childCenter / 2);
        } else {
            int childCenter2 = abstractC13475m.A06();
            containerCenter = childCenter2 / 2;
        }
        return iA0F - containerCenter;
    }

    private View A01(AnonymousClass62 anonymousClass62, AbstractC13475m abstractC13475m) {
        int i;
        int iA0W = anonymousClass62.A0W();
        if (iA0W == 0) {
            return null;
        }
        View view = null;
        if (anonymousClass62.A1T()) {
            int iA0A = abstractC13475m.A0A();
            int childCount = abstractC13475m.A0B();
            i = iA0A + (childCount / 2);
        } else {
            int childCount2 = abstractC13475m.A06();
            i = childCount2 / 2;
        }
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < iA0W; i3++) {
            View viewA0t = anonymousClass62.A0t(i3);
            int iA0F = abstractC13475m.A0F(viewA0t);
            int childCount3 = abstractC13475m.A0D(viewA0t);
            int childCount4 = Math.abs((iA0F + (childCount3 / 2)) - i);
            if (childCount4 < i2) {
                i2 = childCount4;
                String[] strArr = A02;
                String str = strArr[0];
                String str2 = strArr[1];
                int length = str.length();
                int childCount5 = str2.length();
                if (length != childCount5) {
                    throw new RuntimeException();
                }
                A02[5] = "j4bRVUHHACnikA";
                view = viewA0t;
            }
        }
        return view;
    }

    private View A02(AnonymousClass62 anonymousClass62, AbstractC13475m abstractC13475m) {
        int iA0W = anonymousClass62.A0W();
        if (iA0W == 0) {
            return null;
        }
        View view = null;
        int i = Integer.MAX_VALUE;
        if (A02[7].charAt(21) == '9') {
            throw new RuntimeException();
        }
        A02[7] = "DwjJFjjR1ioErHTPj2QZ0AbXqU5bWHnc";
        for (int childCount = 0; childCount < iA0W; childCount++) {
            View viewA0t = anonymousClass62.A0t(childCount);
            int iA0F = abstractC13475m.A0F(viewA0t);
            if (iA0F < i) {
                i = iA0F;
                view = viewA0t;
            }
        }
        return view;
    }

    private AbstractC13475m A03(AnonymousClass62 anonymousClass62) {
        if (this.A00 == null || this.A00.A02 != anonymousClass62) {
            this.A00 = AbstractC13475m.A00(anonymousClass62);
        }
        return this.A00;
    }

    private AbstractC13475m A04(AnonymousClass62 anonymousClass62) {
        if (this.A01 == null || this.A01.A02 != anonymousClass62) {
            this.A01 = AbstractC13475m.A01(anonymousClass62);
        }
        return this.A01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.core.AbstractC2746km
    public final int A0C(AnonymousClass62 anonymousClass62, int i, int i2) {
        int iA0p;
        int centerPosition;
        int iA0Z = anonymousClass62.A0Z();
        if (iA0Z == 0) {
            return -1;
        }
        View viewA02 = null;
        if (anonymousClass62.A21()) {
            viewA02 = A02(anonymousClass62, A04(anonymousClass62));
        } else if (anonymousClass62.A20()) {
            viewA02 = A02(anonymousClass62, A03(anonymousClass62));
        }
        if (viewA02 == null || (iA0p = anonymousClass62.A0p(viewA02)) == -1) {
            return -1;
        }
        if (anonymousClass62.A20()) {
            centerPosition = i > 0 ? 1 : 0;
        } else {
            centerPosition = i2 > 0 ? 1 : 0;
        }
        boolean z = false;
        if (anonymousClass62 instanceof C6E) {
            int itemCount = iA0Z - 1;
            PointF pointFA4w = ((C6E) anonymousClass62).A4w(itemCount);
            if (pointFA4w != null) {
                z = pointFA4w.x < 0.0f || pointFA4w.y < 0.0f;
            }
        }
        if (z) {
            return centerPosition != 0 ? iA0p - 1 : iA0p;
        }
        return centerPosition != 0 ? iA0p + 1 : iA0p;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2746km
    public final View A0D(AnonymousClass62 anonymousClass62) {
        if (anonymousClass62.A21()) {
            return A01(anonymousClass62, A04(anonymousClass62));
        }
        if (anonymousClass62.A20()) {
            View viewA01 = A01(anonymousClass62, A03(anonymousClass62));
            if (A02[4].charAt(24) != 'v') {
                throw new RuntimeException();
            }
            A02[5] = "ku3zp";
            return viewA01;
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2746km
    public final C2770lB A0E(AnonymousClass62 anonymousClass62) {
        if (!(anonymousClass62 instanceof C6E)) {
            return null;
        }
        return new ML(this, super.A00.getContext());
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2746km
    public final int[] A0H(AnonymousClass62 anonymousClass62, View view) {
        int[] iArr = new int[2];
        if (anonymousClass62.A20()) {
            iArr[0] = A00(anonymousClass62, view, A03(anonymousClass62));
        } else {
            iArr[0] = 0;
        }
        if (anonymousClass62.A21()) {
            iArr[1] = A00(anonymousClass62, view, A04(anonymousClass62));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}

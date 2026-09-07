package com.facebook.ads.redexgen.core;

import android.graphics.Rect;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2646jA {
    public static String[] A02 = {"P6MYZTOvDAaFen8GvswQ7TN6uAA4LWVv", "hYZBnkN7eg3Goj1fCi2fLRcc1xaBLP0T", "hgTfm2gsKyXruwHhjUk", "Xl5p6SNgJSz0NngEgDitAc249tQNQ8ta", "gXDmJbn0MXLGD1TV1woO3x4WUye", "irvXIfdrm7YhWQVUx8qen3XIyPBMomv3", "r42H5ZZ7hG", "IBnhtff"};
    public final Rect A00 = new Rect();
    public final Rect A01 = new Rect();

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public static boolean A00(C2959oc<C14569t, C14619y> c2959oc) {
        if (c2959oc.A06.A05()) {
            return c2959oc.A07.A07();
        }
        if (!c2959oc.A06.A06()) {
            return true;
        }
        return c2959oc.A07.A06();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Code duplicated, block: B:24:0x0084  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    private boolean A01(C2959oc<C14569t, C14619y> c2959oc, InterfaceC2949oP interfaceC2949oP) {
        boolean z;
        int i;
        int i2;
        float fA9N = -1.0f;
        try {
            fA9N = interfaceC2949oP.A9N(c2959oc);
        } catch (IllegalStateException unused) {
        }
        if (A02[6].length() == 7) {
            throw new RuntimeException();
        }
        A02[5] = "l0GJDJ6h98NWCV6pJLy8cxtVoo076bMe";
        if (fA9N > 0.0f && A00(c2959oc)) {
            return true;
        }
        if (c2959oc.A06.A00().getGlobalVisibleRect(this.A01) && this.A01.bottom - this.A01.top > 0 && A00(c2959oc)) {
            return true;
        }
        interfaceC2949oP.A9M(this.A00);
        if (A02[2].length() != 2) {
            A02[2] = "WH3ZGQ";
            interfaceC2949oP.A83(c2959oc, this.A01);
            if (this.A00.bottom - this.A00.top > 0) {
                i = this.A01.bottom;
                i2 = this.A00.top;
                if (A02[7].length() != 7) {
                    throw new RuntimeException();
                }
                A02[1] = "8dStYXDidh9UFB7oEkGa7ohf6JNszk5F";
                z = i - i2 > 0;
            }
            return !z && A00(c2959oc);
        }
        interfaceC2949oP.A83(c2959oc, this.A01);
        if (this.A00.bottom - this.A00.top > 0) {
            i = this.A01.bottom;
            i2 = this.A00.top;
            if (A02[7].length() != 7) {
                throw new RuntimeException();
            }
            A02[1] = "8dStYXDidh9UFB7oEkGa7ohf6JNszk5F";
            if (i - i2 > 0) {
            }
        }
        if (z) {
        }
        if (z) {
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oc != com.instagram.common.viewpoint.core.ViewpointData<com.facebook.ads.internal.impressionsecondchannel.model.Impression, com.facebook.ads.internal.impressionsecondchannel.state.ImpressionState> */
    public final void A02(C2959oc<C14569t, C14619y> c2959oc, InterfaceC2949oP interfaceC2949oP) {
        if (c2959oc.A07.A04() && A01(c2959oc, interfaceC2949oP)) {
            c2959oc.A07.A01();
            c2959oc.A06.A02().ABK(c2959oc.A06.A03(), c2959oc.A06.A04());
        }
        if (c2959oc.A07.A05() && C14499m.A1e(c2959oc.A06.A01())) {
            c2959oc.A07.A02();
            c2959oc.A06.A02().AB2(c2959oc.A06.A03(), c2959oc.A06.A04());
        }
    }
}

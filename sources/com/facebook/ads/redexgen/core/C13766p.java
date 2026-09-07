package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13766p {
    public static String[] A00 = {"9O", "28H1kjICyCSP", "QKFmg3qmSW84YfLR5DXewrEtWZ47Hzy", "P", "Em", "YyES7HR0UsWs", "rGxFrAuyTsOha0QpVFZkpdTTHXBTZM0k", "CeAnScf1I32vhT13KQ6XZJy"};

    public static InterfaceC12391f A00(Context context, AnonymousClass87 anonymousClass87) {
        return A01(context, anonymousClass87, null);
    }

    public static InterfaceC12391f A01(Context context, AnonymousClass87 anonymousClass87, String str) {
        C2698k0 sdkContext = A09(context);
        InterfaceC12431j interfaceC12431jA82 = anonymousClass87.A82(sdkContext);
        if (interfaceC12431jA82 != null) {
            return str != null ? interfaceC12431jA82.ABj(str) : interfaceC12431jA82.ABi();
        }
        return new C2899nL();
    }

    public static C2699k1 A02(Activity activity) {
        return new C2699k1(activity, (AnonymousClass87) A0A(), A00(activity, A0A()));
    }

    public static C2699k1 A03(Context context) {
        return new C2699k1(context, A0A(), new C2899nL());
    }

    public static C2699k1 A04(Context context) {
        if (C14499m.A0v(context)) {
            return new C2699k1(context, A0A(), A00(context, A0A()));
        }
        C2699k1 c2699k1A03 = A03(context);
        if (A00[2].length() == 11) {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "B";
        strArr[7] = "J1bgC2YpAkuTguvKBul5HQJ";
        return c2699k1A03;
    }

    public static C2699k1 A05(Context context, String str) {
        InterfaceC12391f interfaceC12391fA01 = A01(context, A0A(), str);
        interfaceC12391fA01.AIZ(1000);
        return new C2699k1(context, A0A(), interfaceC12391fA01);
    }

    public static C2699k1 A06(Context context, String str) {
        return new C2699k1(context, A0A(), A01(context, A0A(), str));
    }

    public static C2699k1 A07(Context context, String str) {
        return new C2699k1(context, A0A(), A01(context, A0A(), str));
    }

    public static M5 A08(Context context) {
        return new M5(context, A0A(), A0A().A82(A09(context)));
    }

    public static C2698k0 A09(Context context) {
        return new C2698k0(context, A0A());
    }

    public static synchronized C2671jZ A0A() {
        return C2671jZ.A02();
    }
}

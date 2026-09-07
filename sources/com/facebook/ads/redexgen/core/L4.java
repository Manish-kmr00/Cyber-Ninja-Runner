package com.facebook.ads.redexgen.core;

import com.facebook.debug.log.BLogLevelCallback;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class L4 {
    public static volatile InterfaceC1728Kx A02 = F0.A00();
    public static volatile boolean A03 = false;
    public static boolean A00 = false;
    public static final List<BLogLevelCallback> A01 = new ArrayList();

    static {
        A02.AIe(5);
        AbstractC1727Kw.A00(A02);
    }

    public static void A00(@Nullable String str, String str2) {
        if (A02.AAN(4)) {
            A02.A9j(str, str2);
        }
    }

    public static void A01(@Nullable String str, String str2, Object obj) {
        if (A02.AAN(4)) {
            A00(str, AbstractC1730Kz.A0J(str2, obj));
        }
    }

    public static void A02(@Nullable String str, String str2, Throwable th) {
        if (A02.AAN(4)) {
            A02.A9k(str, str2, th);
        }
    }
}

package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1619Gs {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1618Gr>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1618Gr>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1618Gr A01(C2699k1 c2699k1, AbstractC2855md abstractC2855md, int i, InterfaceC1616Gp interfaceC1616Gp) {
        C1618Gr c1618Gr = new C1618Gr(c2699k1, abstractC2855md, c2699k1.A02().A0A(), i);
        c1618Gr.A0b(interfaceC1616Gp);
        c1618Gr.A0X();
        A01.put(abstractC2855md.A0r(), new WeakReference<>(c1618Gr));
        return c1618Gr;
    }

    public static C1618Gr A02(String str) {
        WeakReference<C1618Gr> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC2855md abstractC2855md, C1618Gr c1618Gr) {
        A01.put(abstractC2855md.A0r(), new WeakReference<>(c1618Gr));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}

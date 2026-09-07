package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public abstract class o0 {
    public static String a(String str) {
        com.fyber.inneractive.sdk.config.M m;
        UnitDisplayType unitDisplayType;
        UnitDisplayType unitDisplayType2;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        HashMap map = iAConfigManager.f1673a;
        com.fyber.inneractive.sdk.config.S s = (map == null || !map.containsKey(str)) ? null : (com.fyber.inneractive.sdk.config.S) iAConfigManager.f1673a.get(str);
        UnitDisplayType unitDisplayType3 = UnitDisplayType.BANNER;
        if (s == null) {
            return unitDisplayType3.name().toLowerCase(Locale.US);
        }
        for (int i = 0; i < s.f1680a.size(); i++) {
            com.fyber.inneractive.sdk.config.T t = (com.fyber.inneractive.sdk.config.T) s.f1680a.get(i);
            if (t != null && ((m = t.c) != null || t.f != null)) {
                if (m == null || (unitDisplayType2 = m.b) == null || unitDisplayType2.isDeprecated() || UnitDisplayType.DEFAULT == unitDisplayType2) {
                    com.fyber.inneractive.sdk.config.V v = t.f;
                    if (v != null && (unitDisplayType = v.j) != null && !unitDisplayType.isDeprecated() && UnitDisplayType.DEFAULT != unitDisplayType) {
                        unitDisplayType3 = t.f.j;
                    }
                } else {
                    unitDisplayType3 = t.c.b;
                }
                if (UnitDisplayType.MRECT == unitDisplayType3) {
                    unitDisplayType3 = UnitDisplayType.BANNER;
                }
                if (UnitDisplayType.REWARDED == unitDisplayType3 || UnitDisplayType.INTERSTITIAL == unitDisplayType3 || UnitDisplayType.BANNER == unitDisplayType3) {
                    return unitDisplayType3.name().toLowerCase(Locale.US);
                }
            }
        }
        return UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
    }
}

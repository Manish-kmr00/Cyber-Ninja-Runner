package com.fyber.inneractive.sdk.config.global.features;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes13.dex */
public final class k extends h {
    public k() {
        super("load_timeouts");
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        Iterator it = Arrays.asList(strArr).iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append("_");
            }
        }
        return sb.toString();
    }

    public static boolean d(String str) {
        return UnitDisplayType.INTERSTITIAL.name().equalsIgnoreCase(str) || UnitDisplayType.REWARDED.name().equalsIgnoreCase(str);
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? "all_mediators" : str.toLowerCase(Locale.US);
    }

    public final int b(String str, String str2) {
        String strA = a(str, "bidding", "global_timeout", e(str2));
        String strA2 = a(str, "bidding", "global_timeout", "all_mediators");
        int iIntValue = d(str) ? 30000 : 10000;
        Integer numA = a(a(str, "global_timeout", "all_mediators"));
        if (numA != null) {
            iIntValue = numA.intValue();
        }
        Integer numA2 = a(strA2);
        if (numA2 != null) {
            iIntValue = numA2.intValue();
        }
        Integer numA3 = a(strA);
        return numA3 != null ? numA3.intValue() : iIntValue;
    }

    public final int c(String str, String str2) {
        String strA = a(str, "global_timeout", e(str2));
        String strA2 = a(str, "global_timeout", "all_mediators");
        int iIntValue = d(str) ? 30000 : 10000;
        Integer numA = a(a(str, "global_timeout", "all_mediators"));
        if (numA != null) {
            iIntValue = numA.intValue();
        }
        Integer numA2 = a(strA2);
        if (numA2 != null) {
            iIntValue = numA2.intValue();
        }
        Integer numA3 = a(strA);
        return numA3 != null ? numA3.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.config.global.features.h
    public final h c() {
        k kVar = new k();
        a(kVar);
        return kVar;
    }
}

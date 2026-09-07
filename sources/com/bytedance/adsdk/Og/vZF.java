package com.bytedance.adsdk.Og;

import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class vZF {
    private boolean Og;
    private final Map<String, String> pA;

    public String pA(String str) {
        return str;
    }

    public String pA(String str, String str2) {
        return pA(str2);
    }

    public final String Og(String str, String str2) {
        if (this.Og && this.pA.containsKey(str2)) {
            return this.pA.get(str2);
        }
        String strPA = pA(str, str2);
        if (this.Og) {
            this.pA.put(str2, strPA);
        }
        return strPA;
    }
}

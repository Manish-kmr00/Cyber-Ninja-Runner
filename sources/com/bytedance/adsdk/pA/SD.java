package com.bytedance.adsdk.pA;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes14.dex */
public class SD {
    public static Object pA(com.bytedance.adsdk.pA.Og.pA.pA pAVar) {
        ML mlPA;
        if (pAVar == null || (mlPA = pA(pAVar.pA())) == null) {
            return null;
        }
        return mlPA.pA(null, pAVar.Og());
    }

    public static ML pA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "find":
                return new KZx();
            case "exist":
                return new Og();
            case "translate":
                return new JG();
            case "isDigit":
                return new ZZv();
            default:
                return null;
        }
    }
}

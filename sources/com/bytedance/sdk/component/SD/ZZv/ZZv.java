package com.bytedance.sdk.component.SD.ZZv;

import android.content.Context;
import com.bytedance.sdk.component.SD.KZx.omh;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class ZZv {
    public static void pA(Context context, int i, String str, int i2) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (i == 1) {
                linkedHashMap.put(pA(i2), str);
            }
            if (omh.pA().pA(i2).ZZv() != null) {
                omh.pA().pA(i2).ZZv().pA(context, linkedHashMap);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0029  */
    public static String pA(Context context, int i, int i2) {
        String strPA;
        if (i != 1) {
            strPA = "";
        } else {
            try {
                if (omh.pA().pA(i2).ZZv() != null) {
                    strPA = omh.pA().pA(i2).ZZv().pA(context, pA(i2), "");
                } else {
                    strPA = "";
                }
            } catch (Exception unused) {
            }
        }
        if (!(strPA instanceof String)) {
            return "";
        }
        return String.valueOf(strPA);
    }

    private static String pA(int i) {
        return "tnc_config".concat(String.valueOf(i));
    }
}

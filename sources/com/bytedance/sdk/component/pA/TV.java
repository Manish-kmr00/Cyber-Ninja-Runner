package com.bytedance.sdk.component.pA;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;

/* JADX INFO: loaded from: classes10.dex */
class TV {
    private static boolean pA;

    static String pA(Throwable th) {
        return "{\"code\":" + (th instanceof XT ? ((XT) th).pA : 0) + "}";
    }

    static String pA(String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (!pA) {
            strSubstring = "";
        } else {
            strSubstring = str.substring(1, str.length() - 1);
        }
        String strConcat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (!strSubstring.isEmpty()) {
            return strConcat + StringUtils.COMMA + strSubstring + "}";
        }
        return strConcat + "}";
    }

    static String pA() {
        return "";
    }

    static void pA(boolean z) {
        pA = z;
    }
}

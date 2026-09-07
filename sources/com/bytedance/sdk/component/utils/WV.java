package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import com.json.b9;

/* JADX INFO: loaded from: classes13.dex */
public class WV {
    private static com.bytedance.sdk.component.pA KZx = null;
    private static int Og = 4;
    private static String ZZv = "";
    private static boolean pA;

    public static void pA(String str) {
        ZZv = str;
    }

    public static void pA(int i) {
        Og = i;
    }

    public static boolean pA() {
        return Og <= 3;
    }

    public static void Og() {
        pA = true;
        pA(3);
    }

    public static void KZx() {
        pA = false;
        pA(7);
    }

    public static boolean ZZv() {
        return pA;
    }

    public static void Og(String str) {
        if (pA) {
            pA("Logger", str);
        }
    }

    public static void pA(String str, String str2) {
        if (KZx != null) {
            KZx(str);
        }
        if (pA && str2 != null && Og <= 6) {
            Log.e(KZx(str), str2);
        }
    }

    public static void pA(String str, String str2, String str3, Throwable th) {
        if (pA) {
            pA(Og(str, str2), str3, th);
        }
    }

    public static void pA(String str, String str2, Throwable th) {
        if (KZx != null) {
            KZx(str);
        }
        if (pA) {
            if (!(str2 == null && th == null) && Og <= 6) {
                Log.e(KZx(str), str2, th);
            }
        }
    }

    public static void pA(String str, Object... objArr) {
        if (KZx != null) {
            KZx(str);
            pA(objArr);
        }
        if (pA && objArr != null && Og <= 6) {
            Log.e(KZx(str), pA(objArr));
        }
    }

    private static String pA(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj != null) {
                sb.append(obj.toString());
            } else {
                sb.append(" null ");
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String KZx(String str) {
        return TextUtils.isEmpty(ZZv) ? str : pA(b9.i.d + ZZv + "]-[" + str + b9.i.e);
    }

    public static String Og(String str, String str2) {
        return TextUtils.isEmpty(ZZv) ? str : pA(str2 + "]-[" + str);
    }
}

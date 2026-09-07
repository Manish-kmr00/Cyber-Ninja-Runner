package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class KZx {
    private static HashMap<String, ArrayList<String>> pA = new HashMap<>();

    public static ArrayList<String> pA(Context context, String str) {
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (pA.get(str) != null) {
                return pA.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : Og(context, packageName)) {
                    String strPA = "error!";
                    if (SameMD5.TAG.equals(str)) {
                        strPA = pA(signature, SameMD5.TAG);
                    } else if ("SHA1".equals(str)) {
                        strPA = pA(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        strPA = pA(signature, "SHA256");
                    }
                    arrayList.add(strPA);
                }
            } catch (Exception e) {
                WV.Og(e.toString());
            }
            pA.put(str, arrayList);
        }
        return arrayList;
    }

    public static String pA(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayListPA = pA(context, "SHA1");
        if (arrayListPA != null && arrayListPA.size() != 0) {
            for (int i = 0; i < arrayListPA.size(); i++) {
                sb.append(arrayListPA.get(i));
                if (i < arrayListPA.size() - 1) {
                    sb.append(StringUtils.COMMA);
                }
            }
        }
        return sb.toString();
    }

    private static Signature[] Og(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            WV.Og(e.toString());
            return null;
        }
    }

    private static String pA(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest == null) {
                return "error!";
            }
            byte[] bArrDigest = messageDigest.digest(byteArray);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1).toString();
        } catch (Exception e) {
            WV.Og(e.toString());
            return "error!";
        }
    }
}

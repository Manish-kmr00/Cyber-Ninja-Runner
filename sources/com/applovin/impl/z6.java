package com.applovin.impl;

import android.text.TextUtils;
import com.smaato.sdk.core.dns.DnsName;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes13.dex */
public abstract class z6 {
    public static boolean a(String str, int i) {
        return str != null && i >= 0 && str.length() > i && str.charAt(i) == '1';
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : str.split(DnsName.ESCAPED_DOT)) {
            if (!c(str2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_-]*$");
    }

    public static boolean a(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        String[] strArrSplit = str.split("~", -1);
        if (strArrSplit.length == 2 && "1".equals(strArrSplit[0])) {
            return Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[1]);
        }
        return strArrSplit.length == 3 && "2".equals(strArrSplit[0]) && Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[1]) && strArrSplit[2].length() >= 3 && strArrSplit[2].startsWith("dv.") && Pattern.matches("(\\d+(\\.\\d+)*)?", strArrSplit[2].substring(3));
    }

    public static Boolean a(int i, String str) {
        if (!a(str)) {
            return null;
        }
        String[] strArrSplit = str.split("~", -1);
        List listAsList = Arrays.asList(strArrSplit[1].split(DnsName.ESCAPED_DOT));
        String strValueOf = String.valueOf(i);
        boolean zContains = listAsList.contains(strValueOf);
        if (strArrSplit[0].equals("1")) {
            return Boolean.valueOf(zContains);
        }
        if (zContains) {
            return Boolean.TRUE;
        }
        if (Arrays.asList(strArrSplit[2].split(DnsName.ESCAPED_DOT)).contains(strValueOf)) {
            return Boolean.FALSE;
        }
        return null;
    }
}

package com.safedk.android.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.json.b9;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes10.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8163a = "StringUtils";

    public static boolean a(String str, String str2) {
        return str.contains(str2) && str.indexOf(str2) != str.lastIndexOf(str2);
    }

    public static int b(String str, String str2) {
        if (!str.contains(str2)) {
            return -1;
        }
        int iIndexOf = str.indexOf(str2);
        String strSubstring = str.substring(iIndexOf + 1);
        if (strSubstring.contains(str2)) {
            return strSubstring.indexOf(str2) + iIndexOf + 1;
        }
        return -1;
    }

    public static boolean c(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        n.b(f8163a, "stringSimilarity: s1 is: " + str);
        n.b(f8163a, "stringSimilarity: s2 is: " + str2);
        if (str.length() != str2.length()) {
            Logger.d(f8163a, "stringSimilarity: they don't have the same length s1=" + str.length() + " s2=" + str2.length());
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                Logger.d(f8163a, "stringSimilarity: they are not equal at char number i: s1[i]=" + str.charAt(i) + " s2[i]=" + str2.charAt(i));
                return false;
            }
        }
        Logger.d(f8163a, "stringSimilarity: they are equal!");
        return true;
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return str.replace("\\\\x21", "!").replace("\\\\x22", "\"").replace("\\\\x23", "#").replace("\\\\x24", "$").replace("\\\\x25", "%").replace("\\\\x26", b9.i.c).replace("\\\\x27", "'").replace("\\\\x28", "(").replace("\\\\x29", ")").replace("\\\\x2a", "*").replace("\\\\x2b", Marker.ANY_NON_NULL_MARKER).replace("\\\\x2c", StringUtils.COMMA).replace("\\\\x2d", "-").replace("\\\\x2e", ".").replace("\\\\x2f", RemoteSettings.FORWARD_SLASH_STRING).replace("\\\\x3a", ":").replace("\\\\x3b", ";").replace("\\\\x3c", "<").replace("\\\\x3d", "=").replace("\\\\x3e", ">").replace("\\\\x3f", "?").replace("\\\\x40", "@").replace("\\\\x5b", b9.i.d).replace("\\\\x5d", b9.i.e).replace("\\x21", "!").replace("\\x22", "\"").replace("\\x23", "#").replace("\\x24", "$").replace("\\x25", "%").replace("\\x26", b9.i.c).replace("\\x27", "'").replace("\\x28", "(").replace("\\x29", ")").replace("\\x2a", "*").replace("\\x2b", Marker.ANY_NON_NULL_MARKER).replace("\\x2c", StringUtils.COMMA).replace("\\x2f", RemoteSettings.FORWARD_SLASH_STRING).replace("\\x3a", ":").replace("\\x3b", ";").replace("\\x3c", "<").replace("\\x3d", "=").replace("\\x3e", ">").replace("\\x3f", "?").replace("\\x40", "@").replace("\\x5b", b9.i.d).replace("\\x5d", b9.i.e).replace("&amp;", b9.i.c);
            } catch (Throwable th) {
                Logger.e(f8163a, "exception in unescapeUnicodeHex. input param is " + str + "' , error : " + th.getMessage());
                return str;
            }
        }
        return str;
    }

    public static Map<String, String> a(String str, boolean z) {
        try {
            if (!str.contains("?")) {
                return null;
            }
            String strSubstring = str.substring(str.indexOf("?") + 1);
            Logger.d(f8163a, "splitQuery query = " + strSubstring);
            return b(strSubstring, z);
        } catch (Throwable th) {
            Logger.e(f8163a, "Exception in splitQuery, url = " + str, th);
            return null;
        }
    }

    public static String d(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                Map<String, String> mapA = a(str, true);
                if (mapA != null && mapA.containsKey(str2)) {
                    return mapA.get(str2);
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            Logger.e(f8163a, "Exception in getting query param decoded : " + th.getMessage(), th);
        }
    }

    public static String e(String str, String str2) {
        Map<String, String> mapA;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (mapA = a(str, true)) == null || !mapA.containsKey(str2)) {
            return null;
        }
        Logger.d(f8163a, "param " + str2 + " value is " + mapA.get(str2));
        return mapA.get(str2);
    }

    public static Map<String, String> b(String str, boolean z) {
        String[] strArrSplit;
        String strSubstring;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str.contains(b9.i.c)) {
            strArrSplit = str.split(b9.i.c);
        } else {
            strArrSplit = new String[]{str};
        }
        try {
            Logger.d(f8163a, "splitQueryParams started , queryParams = " + str);
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("=");
                if (iIndexOf != -1) {
                    String strSubstring2 = str2.substring(0, iIndexOf);
                    String strDecode = z ? URLDecoder.decode(strSubstring2, "UTF-8") : strSubstring2;
                    if (iIndexOf + 1 < str2.length()) {
                        strSubstring = str2.substring(iIndexOf + 1);
                        if (z) {
                            strSubstring = URLDecoder.decode(strSubstring, "UTF-8");
                        }
                    } else {
                        strSubstring = null;
                    }
                    linkedHashMap.put(strDecode, strSubstring);
                }
            }
            return linkedHashMap;
        } catch (UnsupportedEncodingException e) {
            Logger.e(f8163a, "Exception in splitQuery, queryParams = " + str, e);
            return null;
        } catch (Throwable th) {
            Logger.e(f8163a, "Exception in splitQuery: " + th);
            return null;
        }
    }

    public static String f(String str, String str2) {
        return !str.contains("?") ? str : str.replaceFirst("(?<=[?&])" + str2 + "=.*?(&|$)", "").replaceFirst("[?&]$", "");
    }

    public static String b(String str) {
        if (str != null && str.contains("?")) {
            return str.substring(0, str.indexOf("?"));
        }
        return str;
    }

    public static String a(String str, String[] strArr) {
        if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            String str2 = str;
            while (i < length) {
                String str3 = strArr[i];
                String strF = f(str2, str3);
                if (!strF.equals(str2)) {
                    Logger.d(f8163a, "remove query param from Url removed query param '" + str3 + "', url = " + str);
                }
                i++;
                str2 = strF;
            }
            return str2;
        }
        return str;
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.substring(0, 1).toUpperCase() + str.substring(1, str.length());
        }
        return str;
    }

    public static String d(String str) {
        int iLastIndexOf;
        if (!TextUtils.isEmpty(str)) {
            int iLastIndexOf2 = str.lastIndexOf(35);
            if (iLastIndexOf2 > 0) {
                str = str.substring(0, iLastIndexOf2);
            }
            int iLastIndexOf3 = str.lastIndexOf(63);
            if (iLastIndexOf3 > 0) {
                str = str.substring(0, iLastIndexOf3);
            }
            int iLastIndexOf4 = str.lastIndexOf(47);
            if (iLastIndexOf4 >= 0) {
                str = str.substring(iLastIndexOf4 + 1);
            }
            if (!str.isEmpty() && (iLastIndexOf = str.lastIndexOf(46)) >= 0) {
                return str.substring(iLastIndexOf + 1);
            }
        }
        return "";
    }

    public static String e(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            i++;
            if (cCharAt == '\\' && i < str.length()) {
                char cCharAt2 = str.charAt(i);
                i++;
                if (cCharAt2 == '\\' || cCharAt2 == '/' || cCharAt2 == '\"' || cCharAt2 == '\'') {
                    sb.append(cCharAt2);
                } else if (cCharAt2 == 'n') {
                    sb.append('\n');
                } else if (cCharAt2 == 'r') {
                    sb.append('\r');
                } else if (cCharAt2 == 't') {
                    sb.append('\t');
                } else if (cCharAt2 == 'b') {
                    sb.append('\b');
                } else if (cCharAt2 == 'f') {
                    sb.append('\f');
                } else if (cCharAt2 == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    if (i + 4 > str.length()) {
                        throw new RuntimeException("Not enough unicode digits! ");
                    }
                    for (char c : str.substring(i, i + 4).toCharArray()) {
                        if (!Character.isLetterOrDigit(c)) {
                            throw new RuntimeException("Bad character in unicode escape.");
                        }
                        sb2.append(Character.toLowerCase(c));
                    }
                    i += 4;
                    sb.append((char) Integer.parseInt(sb2.toString(), 16));
                } else {
                    throw new RuntimeException("Illegal escape sequence: \\" + cCharAt2);
                }
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                System.currentTimeMillis();
                String strReplace = i(h(str)).replace("&amp;", b9.i.c).replace("\\/", RemoteSettings.FORWARD_SLASH_STRING);
                while (strReplace.contains("&amp;")) {
                    strReplace = strReplace.replace("&amp;", b9.i.c);
                }
                while (strReplace.contains("&apos;")) {
                    strReplace = strReplace.replace("&apos;", "'");
                }
                while (strReplace.contains("&#39;")) {
                    strReplace = strReplace.replace("&#39;", "'");
                }
                while (strReplace.contains("&nbsp;")) {
                    strReplace = strReplace.replace("&nbsp;", " ");
                }
                if (strReplace.contains("[CDATA[") && strReplace.contains("&lt;") && strReplace.contains("&gt;") && strReplace.contains("&quot;")) {
                    int iIndexOf = strReplace.indexOf("http");
                    int iLastIndexOf = strReplace.lastIndexOf("&quot;");
                    if (iLastIndexOf != -1 && iLastIndexOf > iIndexOf && !strReplace.substring(iLastIndexOf).contains("[CDATA[")) {
                        strReplace = strReplace.substring(0, iLastIndexOf);
                    }
                }
                return g(strReplace);
            } catch (Throwable th) {
                Logger.e(f8163a, "exception in selective decode. input param is " + str + "' , error : " + th.getMessage());
                return str;
            }
        }
        return str;
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("[\\u00A0\\u1680\\u180E\\u2000-\\u200A\\u202F\\u205F\\u3000\\uFEFF]", " ").replaceAll(" +", " ");
    }

    public static String h(String str) {
        Matcher matcher = g.y().matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf((char) Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String i(String str) {
        Matcher matcher = Pattern.compile("\\\\+x([0-9a-f]{2})").matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, String.valueOf((char) Integer.parseInt(matcher.group(1), 16)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean j(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.contains("<html") && lowerCase.contains("</html>")) || (lowerCase.contains("<div") && lowerCase.contains("</div>")) || ((lowerCase.contains("<script") && lowerCase.contains("</script>")) || (lowerCase.contains("<span") && lowerCase.contains("</span>")));
    }

    public static String a(String str, int i) {
        int i2 = 0;
        int iIndexOf = str.indexOf("<div", i);
        int iIndexOf2 = str.indexOf("</div", i);
        int i3 = i;
        while (i3 < str.length()) {
            if (iIndexOf < iIndexOf2) {
                i2++;
                i3 = iIndexOf + 1;
                iIndexOf = str.indexOf("<div", i3);
            } else {
                i2--;
                i3 = iIndexOf2 + 1;
                if (i2 == 0) {
                    return str.substring(i, iIndexOf2);
                }
                iIndexOf2 = str.indexOf("</div", i3);
            }
        }
        return null;
    }

    public static String k(String str) {
        if (str != null && str.length() != 0) {
            return str.replace("&nbsp;", " ").replace("&quot;", "\"").replace("&apos;", "'").replace("&#39;", "'").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", b9.i.c).replaceAll("<\\s*?br\\s*?" + RemoteSettings.FORWARD_SLASH_STRING + "\\s*?>", "\n").replaceAll("<\\s*?span\\s+?style\\s*?=\\s*?\"white-space:pre\"\\s*?>&#9;<\\s*?" + RemoteSettings.FORWARD_SLASH_STRING + "\\s*?span\\s*?>", "\t");
        }
        return str;
    }

    public static String l(String str) {
        return b(str, 0);
    }

    public static String b(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new String(Base64.decode(str, i));
            } catch (IllegalArgumentException e) {
                Logger.d(f8163a, "base64Decoder - failed to Base64 decode buffer (decoded): " + e.getMessage());
                return str;
            }
        }
        return str;
    }

    public static boolean m(String str) {
        if (str.contains("{") && str.contains("}") && str.contains(":") && str.contains("\"")) {
            return n.n(str);
        }
        return false;
    }

    public static String n(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.d(f8163a, "SHA-1 algorithm not found!", th);
            return null;
        }
    }

    public static String o(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.d(f8163a, "SHA-256 algorithm not found!", th);
            return null;
        }
    }

    public static HashSet<String> a(HashSet<String> hashSet, String str) {
        HashSet<String> hashSet2 = new HashSet<>();
        for (String str2 : hashSet) {
            if (!str2.startsWith(str)) {
                hashSet2.add(str2);
            }
        }
        return hashSet2;
    }

    public static HashSet<String> b(HashSet<String> hashSet, String str) {
        HashSet<String> hashSet2 = new HashSet<>();
        for (String str2 : hashSet) {
            if (str2.startsWith(str)) {
                hashSet2.add(str2);
            }
        }
        return hashSet2;
    }

    public static int c(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            if (str.charAt(i) == '{') {
                i2++;
            } else if (str.charAt(i) == '}' && (i2 = i2 - 1) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static String a(String str, String str2, String str3) {
        return a(str, str2, str3, false, false);
    }

    public static String a(String str, String str2, String str3, boolean z, boolean z2) {
        try {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf == -1) {
                return null;
            }
            int length = z ? iIndexOf : str2.length() + iIndexOf;
            if (str3.equals("")) {
                return str.substring(length);
            }
            int iIndexOf2 = str.indexOf(str3, iIndexOf + str2.length());
            if (iIndexOf2 == -1) {
                return str.substring(length);
            }
            if (z2) {
                iIndexOf2 += str3.length();
            }
            return str.substring(length, iIndexOf2);
        } catch (Throwable th) {
            Logger.d(f8163a, "Caught exception in safedkCreateSubstringWithPrefix: " + th.getMessage(), th);
            return null;
        }
    }

    public static String p(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(SameMD5.TAG).digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Integer.valueOf(b & 255)));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5 hashing failed", e);
        }
    }

    public static String q(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\\\/", RemoteSettings.FORWARD_SLASH_STRING).replaceAll("\\\\\\\\", "\\\\").replaceAll("\\\\\"", "\"").replaceAll("\\\\'", "'").replaceAll("\\\\n", "\n").replaceAll("\\\\r", "\r").replaceAll("\\\\t", "\t");
    }
}

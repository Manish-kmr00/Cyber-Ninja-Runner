package com.safedk.android.analytics.brandsafety.creatives;

import com.safedk.android.utils.Logger;
import com.safedk.android.utils.k;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8077a = "(?:%3E|\\\\+x3e|>|&gt;|&amp;gt;|\\*&quot;|&apos)";
    public static final String b = "(?:\\\\+x22|%22|\\\\*\"|&amp;quot;|\\\\*&quot;|\\\\*u0026|quot;|\\\\+x27|%27|\\\\*'|'|&amp;#39;|\\\\*&#39;)";
    private static final String c = "ParserBase";

    public static String a(String str, boolean z) {
        String strF;
        if (z) {
            try {
                strF = k.f(str);
            } catch (Throwable th) {
                Logger.d(c, "CDATA info decode failed: " + str);
                strF = str;
            }
        } else {
            strF = str;
        }
        List<String> listA = a(com.safedk.android.utils.g.x(), strF, 1, false);
        return (listA.size() > 0 ? listA.get(0) : str).trim();
    }

    public static List<String> a(Pattern pattern, String str, int i, boolean z) {
        String strGroup;
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            if (i >= 0) {
                strGroup = matcher.group(i);
            } else {
                strGroup = matcher.group();
            }
            if (strGroup != null) {
                if (z) {
                    arrayList.add(k.f(strGroup.trim()));
                } else {
                    arrayList.add(strGroup.trim());
                }
            }
        }
        return arrayList;
    }

    public static List<String> a(Pattern pattern, String str, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(i);
            String strGroup2 = matcher.group(i2);
            if (strGroup != null) {
                if (z) {
                    arrayList.add(k.f(strGroup.trim()));
                } else {
                    arrayList.add(strGroup.trim());
                }
            }
            if (strGroup2 != null) {
                if (z) {
                    arrayList.add(k.f(strGroup2.trim()));
                } else {
                    arrayList.add(strGroup2.trim());
                }
            }
        }
        return arrayList;
    }
}

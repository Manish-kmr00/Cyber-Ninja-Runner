package com.five_corp.ad.internal.http.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f1394a = Pattern.compile("bytes (\\d+)-(\\d+)/.*$");
    public static final Pattern b = Pattern.compile("bytes .+/(\\d+)");

    public static int a(String str, Pattern pattern, int i) {
        if (str == null) {
            return -1;
        }
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return -1;
        }
        String strGroup = matcher.group(i);
        if (strGroup.equals("*")) {
            return -1;
        }
        try {
            return Integer.parseInt(strGroup);
        } catch (Exception unused) {
            return -1;
        }
    }
}

package com.yandex.mobile.ads.impl;

import com.smaato.sdk.core.dns.DnsName;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class wj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10568a = 0;

    static {
        Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static long a(String str) throws NumberFormatException {
        int i = x82.f10629a;
        String[] strArrSplit = str.split(DnsName.ESCAPED_DOT, 2);
        long j = 0;
        for (String str2 : strArrSplit[0].split(":", -1)) {
            j = (j * 60) + Long.parseLong(str2);
        }
        long j2 = j * 1000;
        if (strArrSplit.length == 2) {
            j2 += Long.parseLong(strArrSplit[1]);
        }
        return j2 * 1000;
    }
}

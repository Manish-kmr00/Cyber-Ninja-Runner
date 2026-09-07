package com.fyber.inneractive.sdk.player.exoplayer2.text.webvtt;

import com.smaato.sdk.core.dns.DnsName;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes12.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f2140a = Pattern.compile("^NOTE(( |\t).*)?$");
    public static final Pattern b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static long a(String str) {
        String[] strArrSplit = str.split(DnsName.ESCAPED_DOT, 2);
        long j = 0;
        for (String str2 : strArrSplit[0].split(":")) {
            j = (j * 60) + Long.parseLong(str2);
        }
        return (Long.parseLong(strArrSplit[1]) + (j * 1000)) * 1000;
    }
}

package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.y;
import java.util.List;

/* JADX INFO: compiled from: HttpHeaders.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.mbridge.msdk.thrid.okio.f f5527a = com.mbridge.msdk.thrid.okio.f.c("\"\\");
    private static final com.mbridge.msdk.thrid.okio.f b = com.mbridge.msdk.thrid.okio.f.c("\t ,=");

    public static long a(y yVar) {
        return a(yVar.m());
    }

    public static boolean b(y yVar) {
        if (yVar.r().e().equals("HEAD")) {
            return false;
        }
        int iK = yVar.k();
        return (((iK >= 100 && iK < 200) || iK == 204 || iK == 304) && a(yVar) == -1 && !"chunked".equalsIgnoreCase(yVar.b(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    public static long a(p pVar) {
        return a(pVar.b("Content-Length"));
    }

    private static long a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static void a(com.mbridge.msdk.thrid.okhttp.k kVar, q qVar, p pVar) {
        if (kVar == com.mbridge.msdk.thrid.okhttp.k.f5568a) {
            return;
        }
        List<com.mbridge.msdk.thrid.okhttp.j> listA = com.mbridge.msdk.thrid.okhttp.j.a(qVar, pVar);
        if (listA.isEmpty()) {
            return;
        }
        kVar.a(qVar, listA);
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int a(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static int b(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }
}

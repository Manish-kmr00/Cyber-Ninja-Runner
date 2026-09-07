package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.android.volley.toolbox.HttpClientStack;

/* JADX INFO: compiled from: HttpMethod.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f {
    public static boolean a(String str) {
        return (str.equals("GET") || str.equals("HEAD")) ? false : true;
    }

    public static boolean b(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean c(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("POST") || str.equals(com.safedk.android.a.g.f) || str.equals(HttpClientStack.HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}

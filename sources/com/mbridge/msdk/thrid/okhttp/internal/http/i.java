package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.w;
import java.net.Proxy;

/* JADX INFO: compiled from: RequestLine.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i {
    public static String a(w wVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(wVar.e());
        sb.append(' ');
        if (b(wVar, type)) {
            sb.append(wVar.g());
        } else {
            sb.append(a(wVar.g()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(w wVar, Proxy.Type type) {
        return !wVar.d() && type == Proxy.Type.HTTP;
    }

    public static String a(q qVar) {
        String strC = qVar.c();
        String strE = qVar.e();
        return strE != null ? strC + '?' + strE : strC;
    }
}

package com.yandex.mobile.ads.impl;

import java.io.IOException;
import java.net.URL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class cd1 {
    public static URL a(np1 request, m82 m82Var) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        String strL = request.l();
        if (m82Var != null) {
            String strA = m82Var.a(strL);
            if (strA == null) {
                throw new IOException("URL blocked by rewriter: " + strL);
            }
            strL = strA;
        }
        return new URL(strL);
    }
}

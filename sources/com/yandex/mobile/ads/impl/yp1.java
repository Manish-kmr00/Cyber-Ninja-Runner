package com.yandex.mobile.ads.impl;

import com.android.volley.toolbox.HttpClientStack;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class yp1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final j11 f10762a;

    static {
        int i = j11.d;
        f10762a = j11.a.a();
    }

    public static void a(long j, np1 request, tc1 tc1Var) {
        String strDecodeToString;
        String str;
        String str2;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(request, "request");
        byte[] bArrB = request.b();
        String strDecodeToString2 = "UNKNOWN_CONTENT";
        if (bArrB != null) {
            try {
                strDecodeToString = StringsKt.decodeToString(bArrB);
            } catch (Exception unused) {
                strDecodeToString = "UNKNOWN_CONTENT";
            }
        } else {
            strDecodeToString = null;
        }
        if (tc1Var == null || (bArr = tc1Var.b) == null) {
            str = null;
        } else {
            if (request instanceof qj0) {
                strDecodeToString2 = "IMAGE_CONTENT";
            } else {
                try {
                    strDecodeToString2 = StringsKt.decodeToString(bArr);
                } catch (Exception unused2) {
                }
            }
            str = strDecodeToString2;
        }
        j11 j11Var = f10762a;
        int iF = request.f();
        if (iF == 0) {
            str2 = "GET";
        } else if (iF == 1) {
            str2 = "POST";
        } else if (iF == 2) {
            str2 = com.safedk.android.a.g.f;
        } else if (iF == 3) {
            str2 = "DELETE";
        } else if (iF == 4) {
            str2 = "HEAD";
        } else if (iF == 5) {
            str2 = "OPTIONS";
        } else if (iF == 6) {
            str2 = "TRACE";
        } else {
            str2 = iF == 7 ? HttpClientStack.HttpPatch.METHOD_NAME : "UNKNOWN";
        }
        String str3 = str2;
        String strL = request.l();
        Intrinsics.checkNotNullExpressionValue(strL, "getUrl(...)");
        j11Var.a(j, str3, strL, request.e(), strDecodeToString, tc1Var != null ? Integer.valueOf(tc1Var.f10286a) : null, tc1Var != null ? tc1Var.c : null, str);
    }
}

package com.moloco.sdk.internal;

import com.moloco.sdk.publisher.MediationInfo;
import io.ktor.http.HeadersBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n {
    public static /* synthetic */ void a(HeadersBuilder headersBuilder, String str, String str2, MediationInfo mediationInfo, int i, Object obj) {
        if ((i & 4) != 0) {
            mediationInfo = null;
        }
        a(headersBuilder, str, str2, mediationInfo);
    }

    public static final void a(HeadersBuilder headersBuilder, String str, String str2, MediationInfo mediationInfo) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("MolocoSDK/" + str + ';');
        }
        if (mediationInfo != null) {
            sb.append("Mediator/" + mediationInfo.getName() + ';');
        }
        if (str2 != null) {
            sb.append("Android/" + str2 + ';');
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply {\n…$it;\") }\n    }.toString()");
        headersBuilder.append("X-Moloco-User-Agent", string);
    }
}

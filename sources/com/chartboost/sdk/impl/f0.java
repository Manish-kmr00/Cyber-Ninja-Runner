package com.chartboost.sdk.impl;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"", "url", "a", "(Ljava/lang/String;)Ljava/lang/String;", "", "mtype", "Lcom/chartboost/sdk/impl/d7;", "(I)Lcom/chartboost/sdk/impl/d7;", "ChartboostMonetization-9.8.3_productionRelease"}, k = 2, mv = {1, 8, 0})
public final class f0 {
    public static final String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.length() <= 0) {
            return "";
        }
        if (!StringsKt.startsWith$default(url, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, com.safedk.android.analytics.brandsafety.creatives.discoveries.d.v, false, 2, (Object) null)) {
            url = "https://" + url;
        }
        Uri uri = Uri.parse(url);
        if (uri == null) {
            return "";
        }
        List<String> segments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(segments, "segments");
        return CollectionsKt.joinToString$default(segments, "_", null, null, 0, null, null, 62, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
    public static final d7 a(int i) {
        for (d7 d7Var : d7.values()) {
            if (d7Var.getIntValue() == i) {
                if (d7Var == null) {
                    return d7.UNKNOWN;
                }
                return d7Var;
            }
        }
        d7Var = null;
        if (d7Var == null) {
            return d7.UNKNOWN;
        }
        return d7Var;
    }
}

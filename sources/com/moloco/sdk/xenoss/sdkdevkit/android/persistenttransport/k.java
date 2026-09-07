package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.work.Data;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {
    public static final Data a(String str) throws Throwable {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Pair[] pairArr = {TuplesKt.to("url", str)};
            Data.Builder builder = new Data.Builder();
            Pair pair = pairArr[0];
            builder.put((String) pair.getFirst(), pair.getSecond());
            Data dataBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(dataBuild, "dataBuilder.build()");
            return dataBuild;
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, j.d, e.getMessage() + ". Url: " + str, null, false, 12, null);
            return null;
        }
    }
}

package com.chartboost.sdk.impl;

import android.util.Base64;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/chartboost/sdk/impl/n1;", "", "", "originalString", ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM, "(Ljava/lang/String;)Ljava/lang/String;", "encodedString", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "a", "<init>", "()V", "ChartboostMonetization-9.8.3_productionRelease"}, k = 1, mv = {1, 8, 0})
public final class n1 {
    public final String b(String encodedString) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(encodedString, "encodedString");
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bArrDecode = Base64.decode(a(encodedString), 2);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(encodedString.clean(), NO_WRAP)");
            objM7904constructorimpl = Result.m7904constructorimpl(new String(bArrDecode, Charsets.UTF_8));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot decode base64 string: " + thM7907exceptionOrNullimpl.getLocalizedMessage(), null, 2, null);
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = "";
        }
        return (String) objM7904constructorimpl;
    }

    public final String c(String originalString) {
        Object objM7904constructorimpl;
        Intrinsics.checkNotNullParameter(originalString, "originalString");
        try {
            Result.Companion companion = Result.INSTANCE;
            byte[] bytes = originalString.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(originalS…g.toByteArray(), NO_WRAP)");
            objM7904constructorimpl = Result.m7904constructorimpl(a(strEncodeToString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7904constructorimpl = Result.m7904constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7907exceptionOrNullimpl = Result.m7907exceptionOrNullimpl(objM7904constructorimpl);
        if (thM7907exceptionOrNullimpl != null) {
            b7.b("Cannot encode to base64 string: " + thM7907exceptionOrNullimpl.getLocalizedMessage(), null, 2, null);
        }
        if (Result.m7910isFailureimpl(objM7904constructorimpl)) {
            objM7904constructorimpl = "";
        }
        return (String) objM7904constructorimpl;
    }

    public final String a(String str) {
        String strReplace$default = StringsKt.replace$default(str, "\n", "", false, 4, (Object) null);
        int length = strReplace$default.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) strReplace$default.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return strReplace$default.subSequence(i, length + 1).toString();
    }
}

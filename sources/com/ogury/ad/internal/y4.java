package com.ogury.ad.internal;

import android.webkit.WebResourceResponse;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.io.ByteArrayInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes13.dex */
public final class y4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y4 f7449a = new y4();

    public static WebResourceResponse a(String str, String str2) {
        byte[] bytes = ("javascript:" + str2 + str).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new WebResourceResponse(POBCommonConstants.CONTENT_TYPE_JAVASCRIPT, "UTF-8", new ByteArrayInputStream(bytes));
    }
}

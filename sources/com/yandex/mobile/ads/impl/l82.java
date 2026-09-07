package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes7.dex */
public final class l82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final iw1 f9490a;
    private final Context b;

    public final String a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        cu1 cu1VarA = this.f9490a.a(this.b);
        if (cu1VarA == null || cu1VarA.P()) {
            return a(url, String.valueOf(System.currentTimeMillis()), StringsKt.indexOf$default((CharSequence) url, '?', 0, false, 6, (Object) null) == -1 ? '?' : Typography.amp);
        }
        return url;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l82(Context context) {
        this(context, iw1.a.a());
        int i = iw1.l;
    }

    public l82(Context context, iw1 sdkSettings) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkSettings, "sdkSettings");
        this.f9490a = sdkSettings;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.b = applicationContext;
    }

    private static String a(String str, String str2, char c) {
        return str + (str.length() == 0 ? "" : Character.valueOf(c)) + "ctime=" + str2;
    }
}

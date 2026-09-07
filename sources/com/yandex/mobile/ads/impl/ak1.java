package com.yandex.mobile.ads.impl;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class ak1 implements n82 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final mp1 f8414a;
    private final y32 b;
    private final l82 c;
    private String d;

    public ak1(Context context, mp1 reporter, y32 targetUrlHandler, l82 urlModifier) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(targetUrlHandler, "targetUrlHandler");
        Intrinsics.checkNotNullParameter(urlModifier, "urlModifier");
        this.f8414a = reporter;
        this.b = targetUrlHandler;
        this.c = urlModifier;
    }

    @Override // com.yandex.mobile.ads.impl.n82
    public final void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String strA = this.c.a(url);
        if (url.length() != 0) {
            url = strA;
        }
        this.d = url;
        String str = null;
        if (url == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetUrl");
            url = null;
        }
        if (url.length() == 0) {
            op0.b(new Object[0]);
            return;
        }
        y32 y32Var = this.b;
        mp1 mp1Var = this.f8414a;
        String str2 = this.d;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetUrl");
        } else {
            str = str2;
        }
        y32Var.a(mp1Var, str);
    }
}

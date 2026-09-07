package com.ogury.ad.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m4 f7461a;
    public final w9 b;
    public final b1 c;
    public final t7 d;
    public final Context e;

    public z4(Context context) {
        m4 mraidCacheStore = m4.f7354a;
        w9 webViewLoader = new w9();
        b1 chromeVersionHelper = new b1();
        t7 profigGateway = t7.f7405a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mraidCacheStore, "mraidCacheStore");
        Intrinsics.checkNotNullParameter(webViewLoader, "webViewLoader");
        Intrinsics.checkNotNullParameter(chromeVersionHelper, "chromeVersionHelper");
        Intrinsics.checkNotNullParameter(profigGateway, "profigGateway");
        this.f7461a = mraidCacheStore;
        this.b = webViewLoader;
        this.c = chromeVersionHelper;
        this.d = profigGateway;
        this.e = context.getApplicationContext();
    }
}

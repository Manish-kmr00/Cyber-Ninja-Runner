package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ca2 implements wp1<r92> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wp1<List<eb2>> f8583a;
    private final ia2 b;

    public ca2(Context context, uu1 sdkEnvironmentModule, w92 adsRequestListener, ia2 verificationResourcesLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkEnvironmentModule, "sdkEnvironmentModule");
        Intrinsics.checkNotNullParameter(adsRequestListener, "adsRequestListener");
        Intrinsics.checkNotNullParameter(verificationResourcesLoader, "verificationResourcesLoader");
        this.f8583a = adsRequestListener;
        this.b = verificationResourcesLoader;
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f8583a.a(error);
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(r92 result) {
        Intrinsics.checkNotNullParameter(result, "result");
        final List<eb2> listB = result.b().b();
        this.b.a(listB, new ua2() { // from class: com.yandex.mobile.ads.impl.ca2$$ExternalSyntheticLambda0
            @Override // com.yandex.mobile.ads.impl.ua2
            public final void a() {
                ca2.a(this.f$0, listB);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ca2 this$0, List videoAds) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoAds, "$videoAds");
        this$0.f8583a.a(videoAds);
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ik2 implements wp1<List<? extends eb2>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wp1<List<eb2>> f9232a;
    private final jk2 b;

    public ik2(Context context, eb2 wrapperAd, wp1<List<eb2>> requestListener, jk2 wrapperAdResponseConfigurator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wrapperAd, "wrapperAd");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        Intrinsics.checkNotNullParameter(wrapperAdResponseConfigurator, "wrapperAdResponseConfigurator");
        this.f9232a = requestListener;
        this.b = wrapperAdResponseConfigurator;
    }

    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(kb2 error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.f9232a.a(error);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.mobile.ads.impl.wp1
    public final void a(List<? extends eb2> list) {
        List<? extends eb2> response = list;
        Intrinsics.checkNotNullParameter(response, "response");
        this.f9232a.a(this.b.a(response));
    }
}

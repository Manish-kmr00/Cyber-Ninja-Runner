package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class ia2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ta2 f9195a;

    public ia2(Context context, va2 verificationResourcesLoaderProvider, ta2 ta2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(verificationResourcesLoaderProvider, "verificationResourcesLoaderProvider");
        this.f9195a = ta2Var;
    }

    public final void a(List<eb2> videoAds, ua2 listener) {
        Intrinsics.checkNotNullParameter(videoAds, "videoAds");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.f9195a != null && (!(videoAds instanceof Collection) || !videoAds.isEmpty())) {
            Iterator<T> it = videoAds.iterator();
            while (it.hasNext()) {
                if (!((eb2) it.next()).d().isEmpty()) {
                    this.f9195a.a(listener);
                    return;
                }
            }
        }
        listener.a();
    }
}

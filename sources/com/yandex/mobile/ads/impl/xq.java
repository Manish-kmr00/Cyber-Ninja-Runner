package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class xq<T extends View> implements zd<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<zd<T>> f10670a;

    /* JADX WARN: Multi-variable type inference failed */
    public xq(List<? extends zd<T>> animators) {
        Intrinsics.checkNotNullParameter(animators, "animators");
        this.f10670a = animators;
    }

    @Override // com.yandex.mobile.ads.impl.zd
    public final void a(T view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Iterator<zd<T>> it = this.f10670a.iterator();
        while (it.hasNext()) {
            it.next().a(view);
        }
    }

    @Override // com.yandex.mobile.ads.impl.zd
    public final void cancel() {
        Iterator<zd<T>> it = this.f10670a.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }
}

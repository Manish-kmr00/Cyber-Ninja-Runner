package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class yb1 implements kg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final jg2 f10721a;

    public yb1(jg2 videoViewAdapter) {
        Intrinsics.checkNotNullParameter(videoViewAdapter, "videoViewAdapter");
        this.f10721a = videoViewAdapter;
    }

    @Override // com.yandex.mobile.ads.impl.kg2
    public final List<pb2> a() {
        return CollectionsKt.emptyList();
    }

    @Override // com.yandex.mobile.ads.impl.kg2
    public final View getView() {
        return this.f10721a.b();
    }
}

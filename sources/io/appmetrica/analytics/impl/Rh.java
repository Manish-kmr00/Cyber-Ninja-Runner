package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class Rh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f11333a;
    public final /* synthetic */ Yh b;

    public Rh(Yh yh, List list) {
        this.b = yh;
        this.f11333a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.b;
        Yh.a(yh.f11439a, yh.d, yh.e).reportAnr(CollectionUtils.getMapFromList(this.f11333a));
    }
}

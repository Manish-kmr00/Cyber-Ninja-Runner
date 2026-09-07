package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.yh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class RunnableC4593yh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11861a;
    public final /* synthetic */ List b;
    public final /* synthetic */ Yh c;

    public RunnableC4593yh(Yh yh, String str, List list) {
        this.c = yh;
        this.f11861a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Yh yh = this.c;
        Yh.a(yh.f11439a, yh.d, yh.e).reportEvent(this.f11861a, CollectionUtils.getMapFromList(this.b));
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class RunnableC4079e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f11526a;
    public final /* synthetic */ C4278m1 b;

    public RunnableC4079e1(C4278m1 c4278m1, List list) {
        this.b = c4278m1;
        this.f11526a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.b).reportAnr(CollectionUtils.getMapFromList(this.f11526a));
    }
}

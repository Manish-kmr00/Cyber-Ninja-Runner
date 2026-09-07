package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import java.util.List;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.i1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class RunnableC4179i1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11592a;
    public final /* synthetic */ List b;
    public final /* synthetic */ C4278m1 c;

    public RunnableC4179i1(C4278m1 c4278m1, String str, List list) {
        this.c = c4278m1;
        this.f11592a = str;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4278m1.a(this.c).reportEvent(this.f11592a, CollectionUtils.getMapFromList(this.b));
    }
}

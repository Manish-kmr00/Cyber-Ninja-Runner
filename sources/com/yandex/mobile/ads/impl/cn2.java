package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class cn2 implements ta2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final me1 f8628a;
    private final Object b;
    private final ArrayList c;

    public cn2(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8628a = me1.g.a(context);
        this.b = new Object();
        this.c = new ArrayList();
    }

    @Override // com.yandex.mobile.ads.impl.ta2
    public final void a() {
        List list;
        synchronized (this.b) {
            list = CollectionsKt.toList(this.c);
            this.c.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.f8628a.a((ua2) it.next());
        }
    }

    @Override // com.yandex.mobile.ads.impl.ta2
    public final void a(ua2 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.b) {
            this.c.add(listener);
            this.f8628a.b(listener);
            Unit unit = Unit.INSTANCE;
        }
    }
}

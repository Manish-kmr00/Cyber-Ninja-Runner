package com.yandex.mobile.ads.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class fi implements di {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ci f8896a;
    private final gi b;
    private final Object c;
    private final ArrayList d;

    public fi(dx1 sensitiveModeChecker, ci autograbCollectionEnabledValidator, gi autograbProvider) {
        Intrinsics.checkNotNullParameter(sensitiveModeChecker, "sensitiveModeChecker");
        Intrinsics.checkNotNullParameter(autograbCollectionEnabledValidator, "autograbCollectionEnabledValidator");
        Intrinsics.checkNotNullParameter(autograbProvider, "autograbProvider");
        this.f8896a = autograbCollectionEnabledValidator;
        this.b = autograbProvider;
        this.c = new Object();
        this.d = new ArrayList();
    }

    @Override // com.yandex.mobile.ads.impl.di
    public final void a() {
        HashSet hashSet;
        synchronized (this.c) {
            hashSet = new HashSet(this.d);
            this.d.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.b.b((hi) it.next());
        }
    }

    @Override // com.yandex.mobile.ads.impl.di
    public final void a(Context context, hi autograbRequestListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(autograbRequestListener, "autograbRequestListener");
        if (this.f8896a.a(context)) {
            synchronized (this.c) {
                this.d.add(autograbRequestListener);
                this.b.a(autograbRequestListener);
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        autograbRequestListener.a(null);
    }
}

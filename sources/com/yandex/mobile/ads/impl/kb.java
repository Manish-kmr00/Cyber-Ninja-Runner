package com.yandex.mobile.ads.impl;

import android.view.View;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class kb implements z<jb> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final yb f9401a;
    private final v9 b;
    private final mp1 c;

    public kb(yb adtuneRenderer, v9 adTracker, mp1 reporter) {
        Intrinsics.checkNotNullParameter(adtuneRenderer, "adtuneRenderer");
        Intrinsics.checkNotNullParameter(adTracker, "adTracker");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        this.f9401a = adtuneRenderer;
        this.b = adTracker;
        this.c = reporter;
    }

    @Override // com.yandex.mobile.ads.impl.z
    public final df0 a(View view, x xVar) {
        jb action = (jb) xVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<String> it = action.b().iterator();
        while (it.hasNext()) {
            this.b.a(it.next(), s62.b);
        }
        this.f9401a.a(view, action);
        this.c.a(hp1.b.j);
        return new df0(false);
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap.KeySetView<l1, Boolean> f8750a;
    private final ConcurrentHashMap.KeySetView<f1, Boolean> b;
    private int c;

    public e1(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f8750a = ConcurrentHashMap.newKeySet();
        this.b = ConcurrentHashMap.newKeySet();
        this.c = a(context);
    }

    public final void a(f1 focusListener) {
        Intrinsics.checkNotNullParameter(focusListener, "focusListener");
        this.b.add(focusListener);
    }

    public final void b() {
        Iterator<f1> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public final void b(f1 focusListener) {
        Intrinsics.checkNotNullParameter(focusListener, "focusListener");
        this.b.remove(focusListener);
    }

    private static int a(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public final void a(Configuration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        int i = config.orientation;
        if (i != this.c) {
            Iterator<l1> it = this.f8750a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.c = i;
        }
    }

    public final void a() {
        Iterator<f1> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }
}

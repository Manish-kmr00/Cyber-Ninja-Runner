package com.yandex.mobile.ads.impl;

import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class sx0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<l51, Object> f10244a = new WeakHashMap<>();

    public final void a(l51 nativeAdEventController) {
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        this.f10244a.put(nativeAdEventController, null);
    }

    public final void b() {
        Iterator<l51> it = this.f10244a.keySet().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public final void a() {
        Iterator<l51> it = this.f10244a.keySet().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public final void c() {
        Iterator<l51> it = this.f10244a.keySet().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public final void d() {
        Iterator<l51> it = this.f10244a.keySet().iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    public final void a(t4 t4Var) {
        Iterator<l51> it = this.f10244a.keySet().iterator();
        while (it.hasNext()) {
            it.next().a(t4Var);
        }
    }
}

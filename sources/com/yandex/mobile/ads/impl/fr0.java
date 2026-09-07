package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class fr0<V extends ViewGroup> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<br0<V>> f8920a;

    public fr0(List<br0<V>> layoutDesigns) {
        Intrinsics.checkNotNullParameter(layoutDesigns, "layoutDesigns");
        this.f8920a = layoutDesigns;
    }

    public final br0<V> a(Context context) {
        Object next;
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = this.f8920a.iterator();
        while (it.hasNext()) {
            next = it.next();
            if (((br0) next).b().a(context)) {
                return (br0) next;
            }
        }
        next = null;
        return (br0) next;
    }
}

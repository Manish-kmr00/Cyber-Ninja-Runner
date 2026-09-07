package com.yandex.mobile.ads.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class zn1 implements ReadWriteProperty<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Object> f10837a;

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public final Object getValue(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f10837a.get();
    }

    @Override // kotlin.properties.ReadWriteProperty
    public final void setValue(Object obj, KProperty<?> property, Object obj2) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.f10837a = new WeakReference<>(obj2);
    }

    zn1(Object obj) {
        this.f10837a = new WeakReference<>(obj);
    }
}

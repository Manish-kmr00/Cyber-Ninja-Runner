package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class ad2 extends ObservableProperty<dd2.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bd2 f8395a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad2(bd2 bd2Var) {
        super(null);
        this.f8395a = bd2Var;
    }

    @Override // kotlin.properties.ObservableProperty
    protected final void afterChange(KProperty<?> property, dd2.a aVar, dd2.a aVar2) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.f8395a.f.a(aVar2);
    }
}

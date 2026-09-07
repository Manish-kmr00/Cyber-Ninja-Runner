package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class zc2 extends ObservableProperty<dd2.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bd2 f10807a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc2(bd2 bd2Var) {
        super(null);
        this.f10807a = bd2Var;
    }

    @Override // kotlin.properties.ObservableProperty
    protected final void afterChange(KProperty<?> property, dd2.b bVar, dd2.b bVar2) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.f10807a.f.a(bVar2);
    }
}

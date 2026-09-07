package com.yandex.mobile.ads.impl;

import com.monetization.ads.nativeads.CustomizableMediaView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class yv1 extends ObservableProperty<dx0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ wv1 f10773a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv1(vv1 vv1Var, wv1 wv1Var) {
        super(vv1Var);
        this.f10773a = wv1Var;
    }

    @Override // kotlin.properties.ObservableProperty
    protected final void afterChange(KProperty<?> property, dx0 dx0Var, dx0 dx0Var2) {
        CustomizableMediaView customizableMediaViewD;
        ax0 ax0VarC;
        Intrinsics.checkNotNullParameter(property, "property");
        dx0 dx0Var3 = dx0Var2;
        dx0 dx0Var4 = dx0Var;
        if (Intrinsics.areEqual(dx0Var3, dx0Var4) || (customizableMediaViewD = wv1.d(this.f10773a)) == null || (ax0VarC = wv1.c(this.f10773a)) == null) {
            return;
        }
        dx0Var4.a(customizableMediaViewD);
        customizableMediaViewD.post(new xv1(dx0Var3, customizableMediaViewD, ax0VarC));
    }
}

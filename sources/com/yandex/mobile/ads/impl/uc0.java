package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class uc0 implements ve1 {
    static final /* synthetic */ KProperty<Object>[] c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(uc0.class, "contentCloseListener", "getContentCloseListener()Lcom/monetization/ads/fullscreen/content/ContentCloseListener;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private s82 f10376a;
    private final zn1 b = ao1.a();

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void c() {
        wr wrVar = (wr) this.b.getValue(this, c[0]);
        if (wrVar != null) {
            wrVar.f();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ve1
    public final void a(boolean z) {
        s82 s82Var = this.f10376a;
        if (s82Var != null) {
            s82Var.a(z);
        }
    }

    public final void a(wr wrVar) {
        this.b.setValue(this, c[0], wrVar);
    }

    public final void a(xc0 useCustomCloseListener) {
        Intrinsics.checkNotNullParameter(useCustomCloseListener, "useCustomCloseListener");
        this.f10376a = useCustomCloseListener;
    }
}

package com.yandex.mobile.ads.impl;

import android.os.Bundle;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes4.dex */
public final class t8 implements q3 {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(t8.class, "adEventsReceiver", "getAdEventsReceiver()Lcom/monetization/ads/base/AdEventsReceiver;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn1 f10275a = ao1.a(null);

    @Override // com.yandex.mobile.ads.impl.q3
    public final void a(int i, Bundle bundle) {
        q3 q3Var = (q3) this.f10275a.getValue(this, b[0]);
        if (q3Var != null) {
            q3Var.a(i, bundle);
            op0.d(Integer.valueOf(i));
        }
    }

    public final void a(q3 q3Var) {
        this.f10275a.setValue(this, b[0], q3Var);
    }
}

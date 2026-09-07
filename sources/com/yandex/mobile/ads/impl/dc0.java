package com.yandex.mobile.ads.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes12.dex */
public final class dc0 implements ec0 {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(dc0.class, "forceImpressionTrackingListenerReference", "getForceImpressionTrackingListenerReference()Lcom/monetization/ads/base/impression/ForceImpressionTrackingListener;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zn1 f8679a = ao1.a();

    @Override // com.yandex.mobile.ads.impl.ec0
    public final void a() {
        ec0 ec0Var = (ec0) this.f8679a.getValue(this, b[0]);
        if (ec0Var != null) {
            ec0Var.a();
        }
    }

    public final void a(ec0 trackingListener) {
        Intrinsics.checkNotNullParameter(trackingListener, "trackingListener");
        this.f8679a.setValue(this, b[0], trackingListener);
    }
}

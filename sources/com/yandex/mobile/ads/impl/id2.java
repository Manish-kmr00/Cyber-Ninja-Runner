package com.yandex.mobile.ads.impl;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class id2 {
    static final /* synthetic */ KProperty<Object>[] c = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(id2.class, "status", "getStatus()Lcom/monetization/ads/instream/status/VideoAdStatus;", 0))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<hd2> f9204a = SetsKt.mutableSetOf(hd2.b);
    private final a b;

    public static final class a extends ObservableProperty<hd2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ id2 f9205a;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(id2 id2Var) {
            hd2 hd2Var = hd2.b;
            this.f9205a = id2Var;
            super(hd2Var);
        }

        @Override // kotlin.properties.ObservableProperty
        protected final void afterChange(KProperty<?> property, hd2 hd2Var, hd2 hd2Var2) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.f9205a.f9204a.add(hd2Var2);
        }
    }

    public id2() {
        Delegates delegates = Delegates.INSTANCE;
        this.b = new a(this);
    }

    public final hd2 a() {
        return this.b.getValue(this, c[0]);
    }

    public final boolean a(hd2 videoAdStatus) {
        Intrinsics.checkNotNullParameter(videoAdStatus, "videoAdStatus");
        return this.f9204a.contains(videoAdStatus);
    }

    public final void b() {
        this.f9204a.clear();
        hd2 hd2Var = hd2.b;
        Intrinsics.checkNotNullParameter(hd2Var, "<set-?>");
        this.b.setValue(this, c[0], hd2Var);
    }

    public final void b(hd2 hd2Var) {
        Intrinsics.checkNotNullParameter(hd2Var, "<set-?>");
        this.b.setValue(this, c[0], hd2Var);
    }
}

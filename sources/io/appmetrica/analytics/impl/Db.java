package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.ConfigProvider;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes13.dex */
public final class Db implements ConfigProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4282m5 f11104a;
    public final Lazy b = LazyKt.lazy(new Cb(this));

    public Db(C4282m5 c4282m5) {
        this.f11104a = c4282m5;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.ConfigProvider
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4045ch getConfig() {
        return (C4045ch) this.b.getValue();
    }
}

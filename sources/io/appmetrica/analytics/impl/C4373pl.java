package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.StartupParamsCallback;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.pl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4373pl implements H6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StartupParamsCallback f11727a;
    public final /* synthetic */ C4398ql b;

    public C4373pl(C4398ql c4398ql, StartupParamsCallback startupParamsCallback) {
        this.b = c4398ql;
        this.f11727a = startupParamsCallback;
    }

    @Override // io.appmetrica.analytics.impl.H6
    public final void a(int i, Bundle bundle) {
        this.b.b(bundle, this.f11727a);
    }
}

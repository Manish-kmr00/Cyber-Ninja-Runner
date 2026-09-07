package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ta, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4461ta implements Vj {
    @Override // io.appmetrica.analytics.impl.Vj
    public final void onCreate() {
        NetworkServiceLocator.getInstance().onCreate();
    }

    @Override // io.appmetrica.analytics.impl.Vj
    public final void onDestroy() {
        NetworkServiceLocator.getInstance().onDestroy();
    }
}

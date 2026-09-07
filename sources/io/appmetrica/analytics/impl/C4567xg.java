package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.networktasks.internal.NetworkServiceLocator;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4567xg implements InterfaceC4298ml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4075dm f11844a;

    public C4567xg(C4075dm c4075dm) {
        this.f11844a = c4075dm;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4298ml
    public final void a() {
        NetworkTask networkTaskC = this.f11844a.c();
        if (networkTaskC != null) {
            C4486ua.E.getClass();
            NetworkServiceLocator.getInstance().getNetworkCore().startTask(networkTaskC);
        }
    }
}

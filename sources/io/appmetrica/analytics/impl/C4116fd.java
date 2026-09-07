package io.appmetrica.analytics.impl;

import android.content.Intent;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController;
import io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleObserver;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.fd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4116fd implements ModuleServiceLifecycleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P1 f11549a;

    public C4116fd(P1 p1) {
        this.f11549a = p1;
    }

    public static final void a(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onFirstClientConnected();
    }

    public static final void b(ModuleServiceLifecycleObserver moduleServiceLifecycleObserver, Intent intent) {
        moduleServiceLifecycleObserver.onAllClientsDisconnected();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ModuleServiceLifecycleController
    public final void registerObserver(final ModuleServiceLifecycleObserver moduleServiceLifecycleObserver) {
        this.f11549a.b(new O1() { // from class: io.appmetrica.analytics.impl.fd$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.impl.O1
            public final void a(Intent intent) {
                C4116fd.a(moduleServiceLifecycleObserver, intent);
            }
        });
        this.f11549a.a(new O1() { // from class: io.appmetrica.analytics.impl.fd$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.impl.O1
            public final void a(Intent intent) {
                C4116fd.b(moduleServiceLifecycleObserver, intent);
            }
        });
    }
}

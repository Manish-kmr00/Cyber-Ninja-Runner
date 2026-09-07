package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;

/* JADX INFO: loaded from: classes13.dex */
public final class F1 implements InterfaceC4477u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICommonExecutor f11132a;
    public final InterfaceC4477u1 b;
    public boolean c;

    public F1(InterfaceC4477u1 interfaceC4477u1) {
        this(C4486ua.j().w().b(), interfaceC4477u1);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent, int i) {
        this.f11132a.execute(new C4552x1(this, intent, i));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void b(Intent intent) {
        this.f11132a.execute(new B1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void c(Intent intent) {
        this.f11132a.execute(new A1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void onConfigurationChanged(Configuration configuration) {
        this.f11132a.execute(new C4502v1(this, configuration));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final synchronized void onCreate() {
        this.c = true;
        this.f11132a.execute(new C4527w1(this));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void onDestroy() {
        this.f11132a.removeAll();
        synchronized (this) {
            this.c = false;
        }
        this.b.onDestroy();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void pauseUserSession(Bundle bundle) {
        this.f11132a.execute(new E1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void reportData(int i, Bundle bundle) {
        this.f11132a.execute(new C1(this, i, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void resumeUserSession(Bundle bundle) {
        this.f11132a.execute(new D1(this, bundle));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent, int i, int i2) {
        this.f11132a.execute(new C4577y1(this, intent, i, i2));
    }

    public F1(IHandlerExecutor iHandlerExecutor, InterfaceC4477u1 interfaceC4477u1) {
        this.c = false;
        this.f11132a = iHandlerExecutor;
        this.b = interfaceC4477u1;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(Intent intent) {
        this.f11132a.execute(new C4602z1(this, intent));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4477u1
    public final void a(InterfaceC4452t1 interfaceC4452t1) {
        this.b.a(interfaceC4452t1);
    }
}

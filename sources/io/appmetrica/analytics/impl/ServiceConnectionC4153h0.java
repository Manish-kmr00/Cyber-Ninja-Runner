package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import io.appmetrica.analytics.internal.IAppMetricaService;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class ServiceConnectionC4153h0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C4178i0 f11575a;

    public ServiceConnectionC4153h0(C4178i0 c4178i0) {
        this.f11575a = c4178i0;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f11575a) {
            this.f11575a.d = IAppMetricaService.Stub.asInterface(iBinder);
            this.f11575a.e.countDown();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f11575a) {
            this.f11575a.d = null;
        }
    }
}

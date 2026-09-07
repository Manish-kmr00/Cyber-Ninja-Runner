package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import io.appmetrica.analytics.internal.AppMetricaService;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock;
import java.util.HashMap;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.gk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4148gk implements ServiceWakeLock {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11573a;
    public final C4123fk b;
    public final HashMap c = new HashMap();

    public C4148gk(Context context, C4123fk c4123fk) {
        this.f11573a = context;
        this.b = c4123fk;
    }

    public final String a(String str) {
        return "io.appmetrica.analytics.ACTION_SERVICE_WAKELOCK." + str;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized boolean acquireWakeLock(String str) {
        if (this.c.get(str) == null) {
            HashMap map = this.c;
            C4123fk c4123fk = this.b;
            Context context = this.f11573a;
            String strA = a(str);
            c4123fk.f11555a.getClass();
            Intent intent = new Intent(context, (Class<?>) AppMetricaService.class);
            intent.setAction(strA);
            ServiceConnectionC4098ek serviceConnectionC4098ek = new ServiceConnectionC4098ek();
            try {
                context.bindService(intent, serviceConnectionC4098ek, 1);
            } catch (Throwable unused) {
                serviceConnectionC4098ek = null;
            }
            map.put(str, serviceConnectionC4098ek);
        }
        return this.c.get(str) != null;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceWakeLock
    public final synchronized void releaseWakeLock(String str) {
        ServiceConnection serviceConnection = (ServiceConnection) this.c.get(str);
        if (serviceConnection != null) {
            C4123fk c4123fk = this.b;
            a(str);
            Context context = this.f11573a;
            c4123fk.getClass();
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
        }
    }
}

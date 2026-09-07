package com.digitalturbine.ignite.authenticator.decorator;

import android.content.Context;
import android.content.Intent;
import com.digitalturbine.ignite.authenticator.logger.ILogger;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1227a;

    public b(e eVar) {
        this.f1227a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1227a.l) {
            Intent intent = new Intent();
            intent.setClassName(this.f1227a.h, "com.digitalturbine.ignite.cl.IgniteRemoteService");
            e eVar = this.f1227a;
            Context context = eVar.e;
            if (context != null) {
                try {
                    context.bindService(intent, eVar, 1);
                } catch (Throwable th) {
                    Object[] objArr = {th};
                    ILogger iLogger = com.digitalturbine.ignite.authenticator.logger.a.b.f1235a;
                    if (iLogger != null) {
                        iLogger.e("Failed to bind IgniteRemoteService", objArr);
                    }
                    if (th.getMessage() != null && th.getMessage().contains("Too many bind requests")) {
                    } else {
                        com.digitalturbine.ignite.authenticator.events.b.a(com.digitalturbine.ignite.authenticator.events.d.ONE_DT_GENERAL_ERROR, com.digitalturbine.ignite.authenticator.utils.events.a.a(th, com.digitalturbine.ignite.authenticator.events.c.IGNITE_SERVICE_UNAVAILABLE));
                    }
                }
            }
        }
    }
}

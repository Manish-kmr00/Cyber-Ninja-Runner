package com.digitalturbine.ignite.authenticator;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.digitalturbine.ignite.authenticator.decorator.h;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements com.digitalturbine.ignite.authenticator.listeners.internal.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.digitalturbine.ignite.authenticator.receiver.a f1224a = new com.digitalturbine.ignite.authenticator.receiver.a(this);
    public Context b;
    public com.digitalturbine.ignite.authenticator.decorator.a c;
    public h d;

    public c(Context context, com.digitalturbine.ignite.authenticator.decorator.a aVar, h hVar) {
        this.b = context.getApplicationContext();
        this.c = aVar;
        this.d = hVar;
    }

    public final void a() {
        com.digitalturbine.ignite.authenticator.receiver.a aVar;
        com.digitalturbine.ignite.authenticator.logger.a.a("%s : start", "OneDTPropertyWatchdog");
        Context context = this.b;
        if (context == null || (aVar = this.f1224a) == null || aVar.b) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter("com.dt.ignite.service.action.PROPERTY_CHANGED");
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(aVar, intentFilter, 4);
        } else {
            context.registerReceiver(aVar, intentFilter);
        }
        this.f1224a.b = true;
    }
}

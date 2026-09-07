package com.digitalturbine.ignite.authenticator;

import android.content.Context;
import com.digitalturbine.ignite.authenticator.decorator.e;
import com.digitalturbine.ignite.authenticator.decorator.f;
import com.digitalturbine.ignite.authenticator.decorator.h;
import com.digitalturbine.ignite.authenticator.listeners.api.AuthenticationServiceListener;
import com.digitalturbine.ignite.authenticator.logger.ILogger;

/* JADX INFO: loaded from: classes11.dex */
public class IgniteManager implements com.digitalturbine.ignite.authenticator.listeners.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f1221a;
    public b b;

    public IgniteManager(ILogger iLogger, com.digitalturbine.ignite.authenticator.events.a aVar) {
        com.digitalturbine.ignite.authenticator.logger.a.b.f1235a = iLogger;
        com.digitalturbine.ignite.authenticator.events.b.b.f1233a = aVar;
    }

    public void authenticate() {
        com.digitalturbine.ignite.authenticator.utils.concurency.c.f1238a.execute(new a(this));
    }

    public void destroy() {
        this.b = null;
        this.f1221a.destroy();
    }

    public String getOdt() {
        b bVar = this.b;
        return bVar != null ? bVar.f1223a : "";
    }

    public boolean isAuthenticated() {
        return this.f1221a.h();
    }

    public boolean isConnected() {
        return this.f1221a.a();
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestFailed(String str) {
        this.f1221a.onCredentialsRequestFailed(str);
    }

    @Override // com.digitalturbine.ignite.authenticator.listeners.api.a
    public void onCredentialsRequestSuccess(String str, String str2) {
        this.f1221a.onCredentialsRequestSuccess(str, str2);
    }

    public IgniteManager(Context context, ILogger iLogger, boolean z, AuthenticationServiceListener authenticationServiceListener) {
        this(iLogger, null);
        this.f1221a = new h(new e(context), false, z, authenticationServiceListener, this);
    }
}

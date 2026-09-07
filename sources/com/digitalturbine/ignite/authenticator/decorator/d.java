package com.digitalturbine.ignite.authenticator.decorator;

import android.content.ComponentName;
import android.os.IBinder;

/* JADX INFO: loaded from: classes6.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentName f1229a;
    public final /* synthetic */ IBinder b;
    public final /* synthetic */ e c;

    public d(e eVar, ComponentName componentName, IBinder iBinder) {
        this.c = eVar;
        this.f1229a = componentName;
        this.b = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f1229a, this.b);
    }
}

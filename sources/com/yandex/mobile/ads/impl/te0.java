package com.yandex.mobile.ads.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class te0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue f10292a = new LinkedBlockingQueue();

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder binder) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(binder, "binder");
        try {
            this.f10292a.put(binder);
        } catch (InterruptedException unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        try {
            this.f10292a.clear();
        } catch (UnsupportedOperationException unused) {
            op0.c(new Object[0]);
        }
    }

    public final IBinder a() throws InterruptedException {
        return (IBinder) this.f10292a.poll(5L, TimeUnit.SECONDS);
    }
}

package com.monetization.ads.core.identifiers.ad.huawei;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.yandex.mobile.ads.impl.op0;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue f7208a = new LinkedBlockingQueue();

    public final OpenDeviceIdentifierService a() throws InterruptedException {
        return (OpenDeviceIdentifierService) this.f7208a.poll(5L, TimeUnit.SECONDS);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder binder) {
        IInterface proxy;
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        Intrinsics.checkNotNullParameter(binder, "binder");
        try {
            int i = OpenDeviceIdentifierService.Stub.f7206a;
            if (binder == null) {
                proxy = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                proxy = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof OpenDeviceIdentifierService)) ? new OpenDeviceIdentifierService.Stub.Proxy(binder) : (OpenDeviceIdentifierService) iInterfaceQueryLocalInterface;
            }
            this.f7208a.put(proxy);
        } catch (Exception unused) {
            op0.c(new Object[0]);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Intrinsics.checkNotNullParameter(componentName, "componentName");
        try {
            this.f7208a.clear();
        } catch (UnsupportedOperationException unused) {
            op0.c(new Object[0]);
        }
    }
}

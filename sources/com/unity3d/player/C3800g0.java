package com.unity3d.player;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: renamed from: com.unity3d.player.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3800g0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC3797f0 f8276a;

    public C3800g0(Handler handler, InterfaceC3797f0 interfaceC3797f0) {
        super(handler);
        this.f8276a = interfaceC3797f0;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return super.deliverSelfNotifications();
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        InterfaceC3797f0 interfaceC3797f0 = this.f8276a;
        if (interfaceC3797f0 != null) {
            ((OrientationLockListener) interfaceC3797f0).b();
        }
    }
}

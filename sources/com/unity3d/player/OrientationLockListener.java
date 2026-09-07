package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: loaded from: classes10.dex */
public class OrientationLockListener implements InterfaceC3797f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3803h0 f8240a;
    private Context b;

    OrientationLockListener(Context context) {
        this.b = context;
        this.f8240a = new C3803h0(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.f8240a.a(this);
    }

    public final void a() {
        this.f8240a.a();
        this.f8240a = null;
    }

    public final void b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}

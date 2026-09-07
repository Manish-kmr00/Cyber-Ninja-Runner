package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* JADX INFO: renamed from: com.unity3d.player.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
final class C3803h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f8278a;
    private C3800g0 b;

    public C3803h0(Context context) {
        this.f8278a = context;
    }

    public final void a() {
        if (this.b != null) {
            this.f8278a.getContentResolver().unregisterContentObserver(this.b);
            this.b = null;
        }
    }

    public final void a(InterfaceC3797f0 interfaceC3797f0) {
        this.b = new C3800g0(new Handler(Looper.getMainLooper()), interfaceC3797f0);
        this.f8278a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.b);
    }
}

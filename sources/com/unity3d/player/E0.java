package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes12.dex */
final class E0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayerForActivityOrService f8214a;
    private Handler b;
    private int g;
    private int h;
    private boolean c = false;
    private boolean d = false;
    private int e = 2;
    private int f = 0;
    private int i = 5;

    E0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f8214a = unityPlayerForActivityOrService;
    }

    private void a(D0 d0) {
        Handler handler = this.b;
        if (handler != null) {
            Message.obtain(handler, 2269, d0).sendToTarget();
        }
    }

    public final void a() {
        a(D0.g);
    }

    public final void a(int i, int i2) {
        this.g = i;
        this.h = i2;
        a(D0.i);
    }

    public final void a(Runnable runnable) {
        if (this.b == null) {
            return;
        }
        a(D0.f8211a);
        Message.obtain(this.b, runnable).sendToTarget();
    }

    public final void b() {
        a(D0.f);
    }

    public final void b(Runnable runnable) {
        Handler handler = this.b;
        if (handler == null) {
            return;
        }
        Message.obtain(handler, runnable).sendToTarget();
        a(D0.e);
    }

    public final void c() {
        a(D0.c);
    }

    public final void c(Runnable runnable) {
        Handler handler = this.b;
        if (handler != null) {
            Message.obtain(handler, runnable).sendToTarget();
        }
    }

    public final void d() {
        a(D0.b);
    }

    public final void d(Runnable runnable) {
        if (this.b == null) {
            return;
        }
        a(D0.d);
        Message.obtain(this.b, runnable).sendToTarget();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.b = new Handler(Looper.myLooper(), new C0(this));
        Looper.loop();
    }
}

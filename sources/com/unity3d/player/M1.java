package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes9.dex */
final class M1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnityPlayer f8235a;
    private L1 c;
    private Context b = null;
    private final Semaphore d = new Semaphore(0);
    private final ReentrantLock e = new ReentrantLock();
    private E1 f = null;
    private int g = 2;
    private boolean h = false;
    private boolean i = false;

    M1(UnityPlayer unityPlayer) {
        this.f8235a = null;
        this.f8235a = unityPlayer;
    }

    public final void a() {
        this.e.lock();
        E1 e1 = this.f;
        if (e1 != null) {
            e1.updateVideoLayout();
        }
        this.e.unlock();
    }

    public final boolean a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, L1 l1) {
        this.e.lock();
        this.c = l1;
        this.b = context;
        this.d.drainPermits();
        this.g = 2;
        runOnUiThread(new H1(this, str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.e.unlock();
            this.d.acquire();
            this.e.lock();
            if (this.g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new I1(this));
        runOnUiThread((!z2 || this.g == 3) ? new K1(this) : new J1(this));
        this.e.unlock();
        return z2;
    }

    public final void b() {
        this.e.lock();
        E1 e1 = this.f;
        if (e1 != null) {
            if (this.g == 0) {
                e1.cancelOnPrepare();
            } else if (this.i) {
                boolean zA = e1.a();
                this.h = zA;
                if (!zA) {
                    this.f.pause();
                }
            }
        }
        this.e.unlock();
    }

    public final void c() {
        this.e.lock();
        E1 e1 = this.f;
        if (e1 != null && this.i && !this.h) {
            e1.start();
        }
        this.e.unlock();
    }

    protected void runOnUiThread(Runnable runnable) {
        Context context = this.b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            B.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}

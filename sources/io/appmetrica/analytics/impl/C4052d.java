package io.appmetrica.analytics.impl;

import android.os.Debug;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4052d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f11503a = new AtomicBoolean(true);
    public final /* synthetic */ C4077e b;

    public C4052d(C4077e c4077e) {
        this.b = c4077e;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted() && this.f11503a.get()) {
            this.b.e.set(false);
            C4077e c4077e = this.b;
            c4077e.c.postAtFrontOfQueue(c4077e.f);
            int i = this.b.b.get();
            while (i > 0) {
                try {
                    Thread.sleep(C4077e.g);
                    if (this.b.e.get()) {
                        break;
                    } else {
                        i--;
                    }
                } catch (InterruptedException unused) {
                    return;
                }
            }
            if (i == 0 && !Debug.isDebuggerConnected()) {
                Iterator it = this.b.f11524a.iterator();
                while (it.hasNext()) {
                    ((InterfaceC4027c) it.next()).onAppNotResponding();
                }
            }
            while (!this.b.e.get()) {
                try {
                    Thread.sleep(C4077e.g);
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }
}

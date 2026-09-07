package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.networktasks.impl.d;
import io.appmetrica.analytics.networktasks.impl.f;
import io.appmetrica.analytics.networktasks.impl.g;
import io.appmetrica.analytics.networktasks.impl.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes13.dex */
public class NetworkCore extends InterruptionSafeThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue f11948a;
    private final Object b;
    private final Object c;
    private volatile d d;
    private final g e;

    public NetworkCore() {
        this(new g());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        NetworkTask networkTask = null;
        while (isRunning()) {
            try {
                synchronized (this.c) {
                    try {
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.d = (d) this.f11948a.take();
                networkTask = this.d.f11937a;
                Executor executor = networkTask.getExecutor();
                this.e.getClass();
                executor.execute(new h(networkTask, this, new f()));
                networkTask.onTaskFinished();
                synchronized (this.c) {
                    if (this.d != null) {
                        this.d = null;
                        networkTask.onTaskRemoved();
                    }
                }
            } catch (InterruptedException unused) {
                if (networkTask != null) {
                    networkTask.onTaskFinished();
                    synchronized (this.c) {
                        if (this.d != null) {
                            this.d = null;
                            networkTask.onTaskRemoved();
                        }
                    }
                } else {
                    continue;
                }
            } catch (Throwable th2) {
                if (networkTask != null) {
                    networkTask.onTaskFinished();
                    synchronized (this.c) {
                        if (this.d != null) {
                            this.d = null;
                            networkTask.onTaskRemoved();
                        }
                    }
                }
                throw th2;
            }
        }
    }

    public void startTask(NetworkTask networkTask) {
        synchronized (this.b) {
            d dVar = new d(networkTask);
            if (isRunning() && !this.f11948a.contains(dVar) && !dVar.equals(this.d) && networkTask.onTaskAdded()) {
                this.f11948a.offer(dVar);
            }
        }
    }

    public void stopTasks() {
        synchronized (this.c) {
            d dVar = this.d;
            if (dVar != null) {
                dVar.f11937a.onTaskRemoved();
            }
            ArrayList arrayList = new ArrayList(this.f11948a.size());
            this.f11948a.drainTo(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((d) it.next()).f11937a.onTaskRemoved();
            }
        }
    }

    NetworkCore(g gVar) {
        this.f11948a = new LinkedBlockingQueue();
        this.b = new Object();
        this.c = new Object();
        this.e = gVar;
    }
}

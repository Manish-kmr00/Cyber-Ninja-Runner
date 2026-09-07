package com.pubmatic.sdk.common.utility;

import com.pubmatic.sdk.common.log.POBLog;
import com.pubmatic.sdk.common.network.POBNetworkMonitor;
import com.pubmatic.sdk.common.taskhandler.POBTaskHandler;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes9.dex */
public class POBLooper {
    private static final ScheduledThreadPoolExecutor i = new ScheduledThreadPoolExecutor(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7638a;
    private POBNetworkMonitor.POBConnectivityListener b;
    private POBNetworkMonitor c;
    private ScheduledFuture d = null;
    private LooperListener e;
    private boolean f;
    private boolean g;
    private long h;

    public interface LooperListener {
        void invoke();
    }

    class a implements POBNetworkMonitor.POBConnectivityListener {
        a() {
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkMonitor.POBConnectivityListener
        public void onNetworkConnectionChanged(boolean z) {
            POBLooper.this.f7638a = z;
            POBLog.debug("POBLooper", "Network connectivity = " + POBLooper.this.f7638a, new Object[0]);
            POBLooper pOBLooper = POBLooper.this;
            pOBLooper.a(pOBLooper.f7638a);
        }

        @Override // com.pubmatic.sdk.common.network.POBNetworkMonitor.POBConnectivityListener
        public void onNetworkRegistrationFailed() {
            POBLog.warn("POBLooper", "Network registration failed", new Object[0]);
        }
    }

    class b implements Runnable {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                POBLooper.this.a();
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            POBTaskHandler.getInstance().runOnMainThread(new a());
        }
    }

    private void c() {
        ScheduledFuture scheduledFuture = this.d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.d = null;
        }
    }

    private void d() {
        POBNetworkMonitor pOBNetworkMonitor;
        POBNetworkMonitor.POBConnectivityListener pOBConnectivityListener = this.b;
        if (pOBConnectivityListener == null || (pOBNetworkMonitor = this.c) == null) {
            return;
        }
        pOBNetworkMonitor.unregisterConnectivityListener(pOBConnectivityListener);
        this.b = null;
    }

    public synchronized void destroy() {
        d();
        c();
        this.f = false;
        this.g = false;
    }

    public synchronized void forcePause() {
        if (this.g) {
            POBLog.verbose("POBLooper", "Skipping pause as already in force-paused state.", new Object[0]);
        } else {
            POBLog.verbose("POBLooper", "Applying force-paused state.", new Object[0]);
            this.g = true;
            d();
            pause();
        }
    }

    public synchronized void forceResume() {
        if (this.g) {
            POBLog.verbose("POBLooper", "Removing force-paused state.", new Object[0]);
            this.g = false;
            b();
            resume();
        } else {
            POBLog.verbose("POBLooper", "Skipping resume as not in force-paused state.", new Object[0]);
        }
    }

    public synchronized void loop(long j) {
        this.f = true;
        this.h = j * 1000;
        c();
        if (this.g) {
            POBLog.verbose("POBLooper", "Deferring refresh, expecting resumeAutoRefresh to continue the refresh", new Object[0]);
        } else {
            POBLog.verbose("POBLooper", "Refreshing after %s seconds", a(this.h));
            a(this.h);
            b();
        }
    }

    public synchronized void pause() {
        if (this.f) {
            ScheduledFuture scheduledFuture = this.d;
            if (scheduledFuture != null) {
                this.h = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
                this.d.cancel(true);
                this.d = null;
                POBLog.verbose("POBLooper", "Pausing refresh at %s seconds", a(this.h));
            }
        } else {
            POBLog.verbose("POBLooper", "Deferring pausing as not yet looped.", new Object[0]);
        }
    }

    public synchronized void resume() {
        if (this.g) {
            POBLog.verbose("POBLooper", "Skipping resume as in force-paused state.", new Object[0]);
            return;
        }
        if (this.f && this.f7638a) {
            POBLog.verbose("POBLooper", "Resuming refresh from %s seconds", a(this.h));
            a(this.h);
        }
    }

    public void setListener(LooperListener looperListener) {
        this.e = looperListener;
    }

    public void setNetworkMonitor(POBNetworkMonitor pOBNetworkMonitor) {
        this.c = pOBNetworkMonitor;
        this.f7638a = pOBNetworkMonitor.isNetworkAvailable();
    }

    private synchronized void a(long j) {
        if (this.d == null) {
            this.d = i.schedule(new b(), j, TimeUnit.MILLISECONDS);
        }
    }

    private void b() {
        if (this.b != null || this.c == null) {
            return;
        }
        this.b = new a();
        this.f7638a = this.c.isNetworkAvailable();
        this.c.registerConnectivityListener(this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e != null) {
            this.f = false;
            POBLog.verbose("POBLooper", "Invoking scheduled method", new Object[0]);
            this.e.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            resume();
        } else {
            pause();
        }
    }

    private String a(double d) {
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(d / 1000.0d));
    }
}

package com.fyber.inneractive.sdk.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes7.dex */
public final class L implements F {
    public static final H g = new H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f1910a = new PriorityBlockingQueue(100, new K());
    public volatile boolean b = false;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final ThreadPoolExecutor d = new ThreadPoolExecutor(6, 6, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), g);
    public final I e = new I(this);
    public final j0 f = new j0();

    public static void a(U u, C3136l c3136l, O o) {
        try {
            if (u.f1914a || u.f() == null || o == null || c3136l == null || c3136l.f1924a != 200) {
                return;
            }
            u.a(o, u.f(), c3136l.e);
        } catch (Exception e) {
            IAlog.a("Failed cache network response data", e, new Object[0]);
        }
    }

    public final void b(U u) {
        P p;
        if (!this.f1910a.offer(u)) {
            IAlog.a("Request queue is full! current request is dropped! %s", u.p());
            return;
        }
        i0 i0Var = i0.QUEUED;
        u.f = i0Var;
        if (i0Var != i0.QUEUED_FOR_RETRY || (p = u.d) == null) {
            return;
        }
        p.a("sdkRequestEndedButWillBeRetried");
    }

    public final void c(U u) {
        j0 j0Var = this.f;
        j0Var.getClass();
        String str = u.g;
        IAlog.a("%s : NetworkRequestWatchdog : finalize request: %s", IAlog.a(j0Var), str);
        n0 n0Var = (n0) j0Var.f1922a.get(str);
        if (n0Var != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(n0Var.d);
        }
        j0Var.f1922a.remove(str);
    }

    public final boolean d(U u) {
        if (!u.s()) {
            return false;
        }
        u.f = i0.QUEUED_FOR_RETRY;
        P p = u.d;
        if (p != null) {
            p.a("sdkRequestEndedButWillBeRetried");
        }
        long jE = u.e();
        IAlog.e("retryNetworkRequest queue up in main thread - %s with delay of %d", u.getClass().getName(), Long.valueOf(jE));
        this.c.postDelayed(new J(this, u), jE);
        return true;
    }

    public static void a(U u, O o) {
        try {
            if (u.f1914a || o == null) {
                return;
            }
            u.a(o.f1911a, (Exception) null, false);
        } catch (Exception e) {
            IAlog.a("failed notifying the listener request complete", e, new Object[0]);
            if (u.f1914a) {
                return;
            }
            u.a((Object) null, e, false);
        }
    }

    public final O a(U u, C3136l c3136l) throws Exception {
        O oA = null;
        if (c3136l != null) {
            try {
                if (!u.f1914a) {
                    int i = c3136l.f1924a;
                    if (i == 200 || (i >= 300 && i < 304)) {
                        oA = u.a(c3136l, c3136l.d, i);
                    } else if (i == 304) {
                        u.a((Object) null, (Exception) new C3131g(), false);
                    } else {
                        u.a((Object) null, (Exception) new k0(c3136l.b, c3136l.f1924a), false);
                    }
                }
            } catch (t0 e) {
                IAlog.a("failed parsing network request but will retry", e, new Object[0]);
                if (d(u)) {
                    throw e;
                }
                throw new s0(e);
            } catch (Exception e2) {
                IAlog.a("failed parsing network request", e2, new Object[0]);
                throw e2;
            }
        }
        return oA;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x002f  */
    /* JADX WARN: Code duplicated, block: B:24:0x0035  */
    public final C3136l a(U u, C3125a c3125a) throws Exception {
        String str;
        try {
            if (u.f1914a) {
                return null;
            }
            if (c3125a != null) {
                str = c3125a.f1916a;
            } else {
                str = "";
            }
            a();
            return u.a(str);
        } catch (C3126b e) {
            e = e;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(u)) {
                throw new t0(e);
            }
            throw new s0(e);
        } catch (t0 e2) {
            IAlog.a("failed sending network request but will retry", e2, new Object[0]);
            if (d(u)) {
                throw e2;
            }
            throw new s0(e2);
        } catch (SocketTimeoutException e3) {
            e = e3;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(u)) {
                throw new t0(e);
            }
            throw new s0(e);
        } catch (UnknownHostException e4) {
            e = e4;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(u)) {
                throw new t0(e);
            }
            throw new s0(e);
        } catch (Exception e5) {
            IAlog.a("failed sending network request", e5, new Object[0]);
            throw e5;
        }
    }

    public static void a(U u) {
        P p;
        try {
            C3136l c3136l = u.e;
            if (c3136l != null) {
                c3136l.a();
            }
            u.c.getClass();
        } catch (Exception unused) {
        }
        i0 i0Var = i0.DONE;
        u.f = i0Var;
        if (i0Var != i0.QUEUED_FOR_RETRY || (p = u.d) == null) {
            return;
        }
        p.a("sdkRequestEndedButWillBeRetried");
    }

    public static void a() throws C3126b {
        Boolean boolC = ((com.fyber.inneractive.sdk.config.global.features.l) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.l.class)).c("should_use_is_network_connected");
        boolean z = false;
        if (boolC != null ? boolC.booleanValue() : false) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) AbstractC3251o.f2370a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (AbstractC3251o.a("android.permission.ACCESS_NETWORK_STATE") && activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    z = true;
                }
            } catch (Throwable unused) {
                IAlog.b("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.", new Object[0]);
            }
            if (!z) {
                throw new C3126b("No network connection");
            }
        }
    }
}

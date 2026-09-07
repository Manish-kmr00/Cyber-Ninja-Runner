package com.yandex.mobile.ads.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class lq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9559a;
    private final b b;
    private final kq1 c;
    private final Handler d;
    private int e;
    private c f;

    public interface b {
        void a(lq1 lq1Var, int i);
    }

    public lq1(Context context, b bVar) {
        kq1 kq1Var = v30.h;
        this.f9559a = context.getApplicationContext();
        this.b = bVar;
        this.c = kq1Var;
        this.d = x82.b();
    }

    public final int a() {
        this.e = this.c.a(this.f9559a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.c.e()) {
            if (x82.f10629a >= 24) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f9559a.getSystemService("connectivity");
                connectivityManager.getClass();
                c cVar = new c();
                this.f = cVar;
                connectivityManager.registerDefaultNetworkCallback(cVar);
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.c.c()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.c.d()) {
            if (x82.f10629a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.c.f()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        this.f9559a.registerReceiver(new a(), intentFilter, null, this.d);
        return this.e;
    }

    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            lq1 lq1Var = lq1.this;
            int iA = lq1Var.c.a(lq1Var.f9559a);
            if (lq1Var.e != iA) {
                lq1Var.e = iA;
                lq1Var.b.a(lq1Var, iA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class c extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f9561a;
        private boolean b;

        private c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network network) {
            c();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network network) {
            c();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onBlockedStatusChanged(Network network, boolean z) {
            if (z) {
                return;
            }
            d();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            if (this.f9561a && this.b == zHasCapability) {
                if (zHasCapability) {
                    d();
                }
            } else {
                this.f9561a = true;
                this.b = zHasCapability;
                c();
            }
        }

        private void c() {
            lq1.this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lq1$c$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            int iA;
            lq1 lq1Var = lq1.this;
            if (lq1Var.f == null || lq1Var.e == (iA = lq1Var.c.a(lq1Var.f9559a))) {
                return;
            }
            lq1Var.e = iA;
            lq1Var.b.a(lq1Var, iA);
        }

        private void d() {
            lq1.this.d.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.lq1$c$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            int iA;
            lq1 lq1Var = lq1.this;
            if (lq1Var.f == null || (lq1Var.e & 3) == 0 || lq1Var.e == (iA = lq1Var.c.a(lq1Var.f9559a))) {
                return;
            }
            lq1Var.e = iA;
            lq1Var.b.a(lq1Var, iA);
        }
    }
}

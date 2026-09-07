package com.chartboost.sdk.impl;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class qd {
    public static qd d = new qd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f1116a;
    public boolean b = false;
    public boolean c = false;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            qd qdVar;
            boolean z;
            boolean z2;
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                qdVar = qd.this;
                z = qdVar.c;
                z2 = true;
            } else {
                if (!intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    return;
                }
                qdVar = qd.this;
                z = qdVar.c;
                z2 = false;
            }
            qdVar.a(z2, z);
            qd.this.b = z2;
        }
    }

    public static qd b() {
        return d;
    }

    public void a() {
        Context context = this.f1116a.get();
        if (context == null) {
            return;
        }
        boolean zIsDeviceLocked = ((KeyguardManager) context.getSystemService("keyguard")).isDeviceLocked();
        a(this.b, zIsDeviceLocked);
        this.c = zIsDeviceLocked;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        this.f1116a = new WeakReference<>(context);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        context.registerReceiver(new a(), intentFilter);
    }

    public void a(boolean z, boolean z2) {
        if ((z2 || z) == (this.c || this.b)) {
            return;
        }
        Iterator<zb> it = tc.c().b().iterator();
        while (it.hasNext()) {
            it.next().f().b(z2 || z);
        }
    }
}

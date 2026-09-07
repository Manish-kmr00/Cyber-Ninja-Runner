package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class Z2 implements Vj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11445a;
    public Intent b;
    public final Context c;
    public final R5 d;

    public Z2(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f11445a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        R5 r5 = this.d;
        Context context = this.c;
        synchronized (r5) {
            if (r5.b) {
                try {
                    context.unregisterReceiver(r5.f11323a);
                    r5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Vj
    public final synchronized void onCreate() {
        Intent intentA = a();
        this.b = intentA;
        Iterator it = this.f11445a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(intentA);
        }
    }

    @Override // io.appmetrica.analytics.impl.Vj
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f11445a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public Z2(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.f11445a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = Q5.a(new D2(new Y2(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intentRegisterReceiver;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        R5 r5 = this.d;
        Context context = this.c;
        synchronized (r5) {
            try {
                intentRegisterReceiver = context.registerReceiver(r5.f11323a, intentFilter);
                try {
                    r5.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intentRegisterReceiver = null;
            }
        }
        return intentRegisterReceiver;
    }
}

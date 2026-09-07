package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.IntentFilter;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ I f2419a;

    public r(I i) {
        this.f2419a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        I i = this.f2419a;
        if (i.V == null) {
            try {
                i.getClass();
                IAlog.a("%sregistering orientation broadcast receiver", IAlog.a(i));
                this.f2419a.V = new E(this.f2419a);
                if (AbstractC3251o.a(this.f2419a.b) != null) {
                    I i2 = this.f2419a;
                    E e = i2.V;
                    Context contextA = AbstractC3251o.a(i2.b);
                    I i3 = e.c;
                    i3.getClass();
                    IAlog.a("%sregister screen broadcast receiver", IAlog.a(i3));
                    e.f2385a = contextA;
                    contextA.registerReceiver(e, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
                }
            } catch (Exception e2) {
                I i4 = this.f2419a;
                i4.getClass();
                IAlog.f("%sfailed registering orientation broadcast recevier", IAlog.a(i4));
                if (IAlog.f2345a >= 3) {
                    e2.printStackTrace();
                }
            }
        }
    }
}

package com.fyber.inneractive.sdk.web;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.AbstractC3251o;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes13.dex */
public final class E extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2385a;
    public int b = -1;
    public final /* synthetic */ I c;

    public E(I i) {
        this.c = i;
    }

    public final void a() {
        try {
            I i = this.c;
            i.getClass();
            IAlog.a("%sunregister screen broadcast receiver called", IAlog.a(i));
            if (this.f2385a != null) {
                I i2 = this.c;
                i2.getClass();
                IAlog.a("%sunregistering broadcast receiver", IAlog.a(i2));
                this.f2385a.unregisterReceiver(this);
                this.f2385a = null;
            }
        } catch (Throwable th) {
            IAlog.f("IAmraidWebViewControllerBase: OrientationBroadcastReceiver: unregister: exception: %s", th.toString());
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int iC;
        if (this.f2385a == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (iC = AbstractC3251o.c()) == this.b) {
            return;
        }
        this.b = iC;
        I i = this.c;
        C3274m c3274m = i.b;
        if (c3274m != null) {
            c3274m.getViewTreeObserver().removeOnPreDrawListener(i.n0);
            i.b.getViewTreeObserver().addOnPreDrawListener(i.n0);
        }
    }
}

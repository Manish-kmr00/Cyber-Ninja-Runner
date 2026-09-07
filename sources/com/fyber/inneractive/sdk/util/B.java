package com.fyber.inneractive.sdk.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes13.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f2343a = new CopyOnWriteArrayList();
    public boolean b;
    public Context c;
    public C3260y d;

    public static void a(B b, Context context, Intent intent) {
        boolean zIsKeyguardLocked;
        synchronized (b) {
            try {
                zIsKeyguardLocked = ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
            } catch (Exception unused) {
                IAlog.a("%sFailed to get lock screen status", IAlog.a(b));
                zIsKeyguardLocked = false;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                b.b = true;
            } else if (("android.intent.action.SCREEN_ON".equals(intent.getAction()) && !zIsKeyguardLocked) || "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                b.b = false;
            }
            IAlog.a("%sNew screen state is locked: %s. number of listeners: %d", IAlog.a(b), Boolean.valueOf(b.b), Integer.valueOf(b.f2343a.size()));
            for (A a2 : b.f2343a) {
                boolean z = b.b;
                com.fyber.inneractive.sdk.renderers.k kVar = (com.fyber.inneractive.sdk.renderers.k) a2;
                kVar.getClass();
                IAlog.a("%sgot onLockScreenStateChanged with: %s", IAlog.a(kVar), Boolean.valueOf(z));
                if (z) {
                    kVar.c(false);
                    com.fyber.inneractive.sdk.renderers.d dVar = kVar.y;
                    if (dVar != null && dVar.g) {
                        dVar.g = false;
                        r.b.removeCallbacks(dVar.j);
                    }
                } else {
                    kVar.K();
                    com.fyber.inneractive.sdk.renderers.d dVar2 = kVar.y;
                    if (dVar2 != null && !dVar2.h && !dVar2.g && dVar2.f != 0) {
                        dVar2.f = 0L;
                        dVar2.g = true;
                        dVar2.a();
                    }
                }
            }
        }
    }
}

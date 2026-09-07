package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.applovin.impl.c2;
import com.applovin.impl.k7;
import com.applovin.impl.v4;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public class h implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f649a;
    private final AtomicReference b;
    private final Handler c;
    private final Handler d;
    private final AtomicLong e = new AtomicLong(0);
    private long f;
    private long g;
    private long h;

    private enum b {
        INELIGIBLE,
        IDLE,
        MONITORING
    }

    private class c implements Runnable {
        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (h.this.b.get() != b.MONITORING) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - h.this.e.get();
            if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= h.this.f) {
                h.this.d.postDelayed(this, h.this.h);
                return;
            }
            h.this.b.set(b.INELIGIBLE);
            AppLovinBroadcastManager.unregisterReceiver(h.this);
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            if (stackTrace.length > 0) {
                StackTraceElement stackTraceElement = stackTrace[0];
                str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            } else {
                str = "None";
            }
            long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - k.n());
            HashMap map = new HashMap(3);
            map.put("top_main_method", str);
            map.put("source", h.this.f649a.A0() ? "non_first_session" : "first_session");
            map.put("details", "seconds_since_app_launch=" + seconds);
            h.this.f649a.E().d(c2.r0, map);
        }
    }

    private class d implements Runnable {
        private d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.b.get() != b.MONITORING) {
                return;
            }
            h.this.e.set(System.currentTimeMillis());
            h.this.c.postDelayed(this, h.this.g);
        }
    }

    public h(k kVar) {
        this.f649a = kVar;
        this.b = new AtomicReference(!k7.c(kVar) ? b.IDLE : b.INELIGIBLE);
        this.c = new Handler(k.o().getMainLooper());
        HandlerThread handlerThread = new HandlerThread("AppLovinSdk:anr_detector");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper());
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            b();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            c();
        }
    }

    private void b() {
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.b, b.MONITORING, b.IDLE)) {
            this.c.removeCallbacksAndMessages(null);
            this.d.removeCallbacksAndMessages(null);
        }
    }

    private void c() {
        if (!(((Boolean) this.f649a.a(v4.T5)).booleanValue() && this.f649a.n0().getCurrentApplicationState() == SessionTracker.e.PAUSED) && MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this.b, b.IDLE, b.MONITORING)) {
            this.c.post(new d());
            this.d.postDelayed(new c(), this.h / 2);
        }
    }

    private void d() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.f = ((Long) this.f649a.a(v4.Q5)).longValue();
        this.g = ((Long) this.f649a.a(v4.R5)).longValue();
        this.h = ((Long) this.f649a.a(v4.S5)).longValue();
        if (((Boolean) this.f649a.a(v4.T5)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
        }
    }

    public void a() {
        if (this.b.get() == b.INELIGIBLE) {
            return;
        }
        if (!((Boolean) this.f649a.a(v4.P5)).booleanValue()) {
            b();
        } else {
            d();
            c();
        }
    }
}

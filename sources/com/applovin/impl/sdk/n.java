package com.applovin.impl.sdk;

import com.applovin.impl.t3;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class n {
    private static final a j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f665a;
    private long c;
    private long f;
    private Object g;
    private final AtomicBoolean b = new AtomicBoolean();
    private final Object d = new Object();
    private final AtomicBoolean e = new AtomicBoolean();
    private final Map h = new HashMap();
    private final Object i = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f666a = -1;
        private int b;

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f666a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a((Object) this) && b() == aVar.b() && a() == aVar.a();
        }

        public int hashCode() {
            long jB = b();
            return ((((int) (jB ^ (jB >>> 32))) + 59) * 59) + a();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + b() + ", attemptCount=" + a() + ")";
        }

        static /* synthetic */ int a(a aVar) {
            int i = aVar.b;
            aVar.b = i + 1;
            return i;
        }

        public int a() {
            return this.b;
        }
    }

    n(k kVar) {
        this.f665a = kVar;
    }

    public void a(boolean z) {
        synchronized (this.d) {
            this.e.set(z);
            if (z) {
                this.f = System.currentTimeMillis();
                this.f665a.O();
                if (o.a()) {
                    this.f665a.O().a("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f);
                }
                final Long l = (Long) this.f665a.a(v4.H1);
                if (l.longValue() >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.n$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(l);
                        }
                    }, l.longValue());
                }
            } else {
                this.f = 0L;
                this.f665a.O();
                if (o.a()) {
                    this.f665a.O().a("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    public long b() {
        return this.c;
    }

    public boolean c() {
        return this.b.get();
    }

    public boolean d() {
        return this.e.get();
    }

    public void b(Object obj) {
        if (!t3.a(obj) && this.b.compareAndSet(true, false)) {
            this.g = null;
            this.f665a.O();
            if (o.a()) {
                this.f665a.O().a("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public void c(String str) {
        synchronized (this.i) {
            a aVar = (a) this.h.get(str);
            if (aVar == null) {
                aVar = new a();
                this.h.put(str, aVar);
            }
            aVar.f666a = System.currentTimeMillis();
            a.a(aVar);
        }
    }

    public a b(String str) {
        a aVar;
        synchronized (this.i) {
            aVar = (a) this.h.get(str);
            if (aVar == null) {
                aVar = j;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l) {
        if (d() && System.currentTimeMillis() - this.f >= l.longValue()) {
            this.f665a.O();
            if (o.a()) {
                this.f665a.O().a("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.e.set(false);
        }
    }

    public Object a() {
        return this.g;
    }

    public void a(final Object obj) {
        if (!t3.a(obj) && this.b.compareAndSet(false, true)) {
            this.g = obj;
            this.c = System.currentTimeMillis();
            this.f665a.O();
            if (o.a()) {
                this.f665a.O().a("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.c);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final Long l = (Long) this.f665a.a(v4.I1);
            if (l.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.n$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(l, obj);
                    }
                }, l.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l, Object obj) {
        if (this.b.get() && System.currentTimeMillis() - this.c >= l.longValue()) {
            this.f665a.O();
            if (o.a()) {
                this.f665a.O().a("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            b(obj);
        }
    }

    public void a(String str) {
        synchronized (this.i) {
            this.h.remove(str);
        }
    }
}

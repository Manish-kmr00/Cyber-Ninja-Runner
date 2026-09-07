package com.applovin.impl;

import androidx.media3.exoplayer.offline.DefaultDownloaderFactory$$ExternalSyntheticLambda0;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public final class q4 {
    public static final Executor h = new Executor() { // from class: com.applovin.impl.q4$$ExternalSyntheticLambda2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        }
    };
    public static final Executor i = new DefaultDownloaderFactory$$ExternalSyntheticLambda0();
    private final String b;
    private volatile Object f;
    private volatile Object g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f598a = new Object();
    private final List c = new ArrayList();
    private volatile boolean d = false;
    private volatile boolean e = false;

    public interface a {
        void a(Object obj);
    }

    public interface b {
        void a(boolean z, Object obj, Object obj2);
    }

    public q4(String str) {
        this.b = str;
    }

    public static q4 a(String str, Object obj) {
        return new q4(str).b(obj);
    }

    public q4 b(Object obj) {
        a(true, obj, null);
        return this;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.d && !this.e;
    }

    public String toString() {
        String str;
        if (this.d) {
            str = this.e ? "Success -> " + this.f : "Failed -> " + this.g;
        } else {
            str = "Waiting";
        }
        return "Promise(" + b() + ": " + str + ")";
    }

    private Runnable c(final Executor executor, final b bVar) {
        return new Runnable() { // from class: com.applovin.impl.q4$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(executor, bVar);
            }
        };
    }

    public q4 a(Object obj) {
        a(false, null, obj);
        return this;
    }

    public String b() {
        String str = this.b;
        return str != null ? str : super.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Executor executor, final b bVar) {
        try {
            executor.execute(new Runnable() { // from class: com.applovin.impl.q4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(bVar);
                }
            });
        } catch (Throwable th) {
            a(th);
        }
    }

    public void a(Executor executor, final Runnable runnable) {
        a(executor, new b() { // from class: com.applovin.impl.q4$$ExternalSyntheticLambda3
            @Override // com.applovin.impl.q4.b
            public final void a(boolean z, Object obj, Object obj2) {
                q4.a(runnable, z, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, boolean z, Object obj, Object obj2) {
        if (z) {
            runnable.run();
        }
    }

    public void a(Executor executor, final a aVar) {
        a(executor, new b() { // from class: com.applovin.impl.q4$$ExternalSyntheticLambda1
            @Override // com.applovin.impl.q4.b
            public final void a(boolean z, Object obj, Object obj2) {
                q4.a(aVar, z, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, boolean z, Object obj, Object obj2) {
        if (z) {
            return;
        }
        aVar.a(obj2);
    }

    public void a(Executor executor, b bVar) {
        Runnable runnableC = c(executor, bVar);
        synchronized (this.f598a) {
            if (!this.d) {
                this.c.add(runnableC);
            } else {
                runnableC.run();
            }
        }
    }

    public Object a() {
        k1.a(d());
        return this.g;
    }

    private void a(boolean z, Object obj, Object obj2) {
        synchronized (this.f598a) {
            if (this.d) {
                return;
            }
            this.f = obj;
            this.g = obj2;
            this.e = z;
            this.d = true;
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        try {
            bVar.a(this.e, this.f, this.g);
        } catch (Throwable th) {
            a(th);
        }
    }

    private void a(Throwable th) {
        k1.a(th);
        com.applovin.impl.sdk.k kVar = com.applovin.impl.sdk.k.D0;
        if (kVar != null) {
            kVar.E().a("Promise", "PromiseCallback: " + b(), th);
        }
    }
}

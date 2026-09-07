package com.json.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.json.environment.thread.IronSourceThreadManager;
import com.json.nk;
import com.json.ok;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class b implements Application.ActivityLifecycleCallbacks {
    private static final b m = new b();
    private static AtomicBoolean n = new AtomicBoolean(false);
    static final long o = 700;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3869a = 0;
    private int b = 0;
    private boolean c = true;
    private boolean d = true;
    private ok e = ok.NONE;
    private final List<nk> f = new CopyOnWriteArrayList();
    private final Runnable g = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.f();
        }
    };
    private final Runnable h = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.g();
        }
    };
    private final Runnable i = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.h();
        }
    };
    private final Runnable j = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda3
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.i();
        }
    };
    private final Runnable k = new Runnable() { // from class: com.ironsource.lifecycle.b$$ExternalSyntheticLambda4
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.j();
        }
    };
    private final com.json.lifecycle.a.InterfaceC0397a l = new a();

    class a implements com.json.lifecycle.a.InterfaceC0397a {
        a() {
        }

        @Override // com.json.lifecycle.a.InterfaceC0397a
        public void a(Activity activity) {
            b.this.c(activity);
        }

        @Override // com.json.lifecycle.a.InterfaceC0397a
        public void b(Activity activity) {
        }

        @Override // com.json.lifecycle.a.InterfaceC0397a
        public void onResume(Activity activity) {
            b.this.b(activity);
        }
    }

    private void a() {
        if (this.b == 0) {
            this.c = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.h);
            this.e = ok.PAUSED;
        }
    }

    private void b() {
        if (this.f3869a == 0 && this.c) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.i);
            this.d = true;
            this.e = ok.STOPPED;
        }
    }

    public static b d() {
        return m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        Iterator<nk> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator<nk> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        Iterator<nk> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Iterator<nk> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    void a(Activity activity) {
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.g, 700L);
        }
    }

    void a(Context context) {
        Application application;
        if (!n.compareAndSet(false, true) || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    public void a(nk nkVar) {
        if (!IronsourceLifecycleProvider.a() || nkVar == null || this.f.contains(nkVar)) {
            return;
        }
        this.f.add(nkVar);
    }

    void b(Activity activity) {
        int i = this.b + 1;
        this.b = i;
        if (i == 1) {
            if (!this.c) {
                IronSourceThreadManager.INSTANCE.removeUiThreadTask(this.g);
                return;
            }
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.j);
            this.c = false;
            this.e = ok.RESUMED;
        }
    }

    public void b(nk nkVar) {
        if (this.f.contains(nkVar)) {
            this.f.remove(nkVar);
        }
    }

    public ok c() {
        return this.e;
    }

    void c(Activity activity) {
        int i = this.f3869a + 1;
        this.f3869a = i;
        if (i == 1 && this.d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.k);
            this.d = false;
            this.e = ok.STARTED;
        }
    }

    void d(Activity activity) {
        this.f3869a--;
        b();
    }

    public boolean e() {
        return this.e == ok.STOPPED;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.json.lifecycle.a.b(activity);
        com.json.lifecycle.a aVarA = com.json.lifecycle.a.a(activity);
        if (aVarA != null) {
            aVarA.d(this.l);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        d(activity);
    }
}

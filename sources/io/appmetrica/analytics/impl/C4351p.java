package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes10.dex */
public final class C4351p extends H7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f11708a;
    public volatile EnumC4326o b = EnumC4326o.d;
    public final C4536wa c = new C4536wa(true);

    public final synchronized void a(Context context) {
        if (this.f11708a == null) {
            try {
                this.f11708a = (Application) context.getApplicationContext();
            } catch (Throwable unused) {
            }
        }
        b();
    }

    public final synchronized void b() {
        EnumC4326o enumC4326o = this.b;
        EnumC4326o enumC4326o2 = EnumC4326o.b;
        if (enumC4326o != enumC4326o2 && !this.c.f11830a.isEmpty()) {
            if (this.f11708a == null) {
                this.b = EnumC4326o.c;
            } else {
                this.b = enumC4326o2;
                this.f11708a.registerActivityLifecycleCallbacks(this);
            }
        }
    }

    public final synchronized void c() {
        if (this.b == EnumC4326o.b && this.c.f11830a.isEmpty()) {
            this.b = EnumC4326o.d;
            Application application = this.f11708a;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, EnumC4276m.CREATED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(activity, EnumC4276m.DESTROYED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, EnumC4276m.PAUSED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, EnumC4276m.RESUMED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, EnumC4276m.STARTED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, EnumC4276m.STOPPED);
    }

    public final synchronized void a(Application application) {
        if (this.f11708a == null) {
            this.f11708a = application;
        }
        b();
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0006 A[Catch: all -> 0x003e, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x000a, B:9:0x000e, B:11:0x001c, B:13:0x0022, B:15:0x0028, B:17:0x002c, B:18:0x0031, B:19:0x0036, B:20:0x0039, B:6:0x0006), top: B:26:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x000e A[Catch: all -> 0x003e, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x000a, B:9:0x000e, B:11:0x001c, B:13:0x0022, B:15:0x0028, B:17:0x002c, B:18:0x0031, B:19:0x0036, B:20:0x0039, B:6:0x0006), top: B:26:0x0003 }] */
    public final synchronized void b(InterfaceC4301n interfaceC4301n, EnumC4276m... enumC4276mArr) {
        int i;
        Collection collection;
        if (enumC4276mArr != null) {
            if (enumC4276mArr.length == 0) {
                enumC4276mArr = EnumC4276m.values();
            }
            for (EnumC4276m enumC4276m : enumC4276mArr) {
                C4536wa c4536wa = this.c;
                collection = (Collection) c4536wa.f11830a.get(enumC4276m);
                if (collection == null && collection.remove(interfaceC4301n)) {
                    if (collection.isEmpty() && c4536wa.b) {
                        c4536wa.f11830a.remove(enumC4276m);
                    }
                    new ArrayList(collection);
                }
            }
            c();
        } else {
            enumC4276mArr = EnumC4276m.values();
            while (i < r0) {
                C4536wa c4536wa2 = this.c;
                collection = (Collection) c4536wa2.f11830a.get(enumC4276m);
                if (collection == null) {
                }
            }
            c();
        }
        throw th;
    }

    public final EnumC4326o a() {
        return this.b;
    }

    public final void a(Activity activity, EnumC4276m enumC4276m) {
        Collection collection;
        synchronized (this) {
            collection = (Collection) this.c.f11830a.get(enumC4276m);
        }
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ((InterfaceC4301n) it.next()).a(activity, enumC4276m);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0006 A[Catch: all -> 0x001d, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x000a, B:9:0x000e, B:10:0x0018, B:6:0x0006), top: B:16:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:9:0x000e A[Catch: all -> 0x001d, LOOP:0: B:8:0x000c->B:9:0x000e, LOOP_END, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x000a, B:9:0x000e, B:10:0x0018, B:6:0x0006), top: B:16:0x0003 }] */
    public final synchronized void a(InterfaceC4301n interfaceC4301n, EnumC4276m... enumC4276mArr) {
        int i;
        if (enumC4276mArr != null) {
            if (enumC4276mArr.length == 0) {
                enumC4276mArr = EnumC4276m.values();
            }
            for (EnumC4276m enumC4276m : enumC4276mArr) {
                this.c.a(enumC4276m, interfaceC4301n);
            }
            b();
        } else {
            enumC4276mArr = EnumC4276m.values();
            while (i < r0) {
                this.c.a(enumC4276m, interfaceC4301n);
            }
            b();
        }
        throw th;
    }
}

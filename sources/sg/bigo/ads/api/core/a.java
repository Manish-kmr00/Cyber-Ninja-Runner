package sg.bigo.ads.api.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f13097a;
    private final List<WeakReference<InterfaceC0856a>> b;

    /* JADX INFO: renamed from: sg.bigo.ads.api.core.a$a, reason: collision with other inner class name */
    public interface InterfaceC0856a {
        void a();

        void b();
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f13099a = new a(0);
    }

    private a() {
        this.b = new ArrayList();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return b.f13099a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator<WeakReference<InterfaceC0856a>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Iterator<WeakReference<InterfaceC0856a>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Iterator<WeakReference<InterfaceC0856a>> it = this.b.iterator();
        while (it.hasNext()) {
            InterfaceC0856a interfaceC0856a = it.next().get();
            if (interfaceC0856a != null) {
                interfaceC0856a.b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.f13097a = new WeakReference<>(activity);
        Iterator<WeakReference<InterfaceC0856a>> it = this.b.iterator();
        while (it.hasNext()) {
            InterfaceC0856a interfaceC0856a = it.next().get();
            if (interfaceC0856a != null) {
                interfaceC0856a.a();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}

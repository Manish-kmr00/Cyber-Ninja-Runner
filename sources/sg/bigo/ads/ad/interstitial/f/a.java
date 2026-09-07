package sg.bigo.ads.ad.interstitial.f;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import sg.bigo.ads.controller.landing.LandingPageStyleConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<b> f12813a;
    protected final int b;
    protected final int c;
    protected final int d;
    protected final float e;

    /* JADX INFO: renamed from: sg.bigo.ads.ad.interstitial.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0845a {
        boolean a();
    }

    public interface b {
        void a(int i);

        void a(int i, int i2, int i3, int i4, int i5);

        boolean a(MotionEvent motionEvent, InterfaceC0845a interfaceC0845a, int i);

        void b(int i);

        void c(int i);

        void d(int i);
    }

    a(int i, int i2, int i3, float f) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static void a(LandingPageStyleConfig landingPageStyleConfig) {
        if (landingPageStyleConfig == null || !landingPageStyleConfig.a() || landingPageStyleConfig.b()) {
            return;
        }
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.a(landingPageStyleConfig.c);
        }
    }

    public final void a() {
        int i = this.b;
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public final void a(int i, int i2, int i3, int i4) {
        int i5 = this.b;
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.a(i, i2, i3, i4, i5);
        }
    }

    public final boolean a(MotionEvent motionEvent, InterfaceC0845a interfaceC0845a) {
        int i = this.b;
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            return bVar.a(motionEvent, interfaceC0845a, i);
        }
        return false;
    }

    public final void b() {
        int i = this.b;
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.c(i);
        }
    }

    public final void c() {
        int i = this.b;
        WeakReference<b> weakReference = f12813a;
        b bVar = weakReference != null ? weakReference.get() : null;
        if (bVar != null) {
            bVar.d(i);
        }
    }

    public final int d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public final boolean f() {
        int i = this.c;
        return i == 2 || i == 4 || i == 6;
    }

    public final boolean g() {
        int i = this.c;
        return (i == 3 || i == 4 || i == 5 || i == 6) ? false : true;
    }
}

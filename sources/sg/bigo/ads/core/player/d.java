package sg.bigo.ads.core.player;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import sg.bigo.ads.core.player.b.f;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements sg.bigo.ads.api.core.a.InterfaceC0856a, sg.bigo.ads.common.aa.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13715a;
    final Handler b;
    private final ArrayList<WeakReference<View>> c;
    private final Runnable d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f13717a = new d(0);
    }

    private d() {
        this.f13715a = false;
        this.b = new Handler(Looper.getMainLooper());
        this.c = new ArrayList<>();
        this.d = new Runnable() { // from class: sg.bigo.ads.core.player.d.1
            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.c()) {
                    d.this.b.postDelayed(this, 500L);
                }
            }
        };
        sg.bigo.ads.common.n.d.a(2, new Runnable() { // from class: sg.bigo.ads.api.core.a.1

            /* JADX INFO: renamed from: a */
            final /* synthetic */ InterfaceC0856a f13098a;

            public AnonymousClass1() {
                interfaceC0856a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = a.this.b.iterator();
                while (it.hasNext()) {
                    InterfaceC0856a interfaceC0856a = (InterfaceC0856a) ((WeakReference) it.next()).get();
                    if (interfaceC0856a != null && interfaceC0856a == interfaceC0856a) {
                        return;
                    }
                }
                a.this.b.add(new WeakReference(interfaceC0856a));
            }
        }, 1L);
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private synchronized void d() {
        e();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "startCheckTask called");
        this.b.post(this.d);
    }

    private synchronized void e() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "removeCheckTask called");
        this.b.removeCallbacksAndMessages(null);
        c();
    }

    @Override // sg.bigo.ads.api.core.a.InterfaceC0856a
    public final void a() {
        d();
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "onActivityResumed");
    }

    @Override // sg.bigo.ads.common.aa.b.a
    public final void a(int i) {
        if (i == 1) {
            d();
        }
    }

    public final synchronized void a(f fVar) {
        Iterator<WeakReference<View>> it = this.c.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view == null) {
                it.remove();
            } else if (view == fVar) {
                sg.bigo.ads.common.t.a.b("VideoPlayerManager", "register playerView exist already");
                return;
            }
        }
        this.c.add(new WeakReference<>(fVar));
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "register playerView, size = " + this.c.size());
        d();
        if (!this.f13715a) {
            this.f13715a = true;
            sg.bigo.ads.common.aa.b.a(fVar.getContext().getApplicationContext(), this);
        }
    }

    @Override // sg.bigo.ads.api.core.a.InterfaceC0856a
    public final void b() {
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "onActivityPaused");
        e();
    }

    public final synchronized void b(f fVar) {
        Iterator<WeakReference<View>> it = this.c.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                if (view == fVar) {
                    fVar.q();
                }
            }
            it.remove();
        }
        sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "unregister player, size = " + this.c.size());
        if (this.c.isEmpty()) {
            e();
        }
    }

    final synchronized boolean c() {
        f fVar;
        int playStatus;
        if (this.c.isEmpty()) {
            return false;
        }
        Iterator<WeakReference<View>> it = this.c.iterator();
        View view = null;
        boolean z = false;
        int i = 0;
        while (it.hasNext()) {
            View view2 = it.next().get();
            if (view2 instanceof f) {
                z = view2.getContext() != null && sg.bigo.ads.common.aa.b.a(view2.getContext().getApplicationContext());
                Rect rect = new Rect();
                float f = 0.0f;
                if (sg.bigo.ads.common.ab.a.a(view2, rect)) {
                    float height = view2.getHeight() * 1.0f * view2.getWidth();
                    float fHeight = rect.height() * 1.0f * rect.width();
                    if (height <= 0.0f) {
                        sg.bigo.ads.common.t.a.a(0, 3, "ImpressionChecker", "adView is not visible, width or height is 0");
                    } else {
                        f = fHeight / height;
                    }
                }
                int i2 = (int) (100.0f * f);
                if (i2 < i || i2 < 50 || !z) {
                    ((f) view2).q();
                } else {
                    if (i2 == i) {
                        ((f) view).q();
                    } else {
                        i = i2;
                    }
                    view = view2;
                }
            } else {
                it.remove();
                sg.bigo.ads.common.t.a.a(0, 3, "VideoPlayerManager", "playView is recycled, remove it");
            }
        }
        if (view != null && (playStatus = (fVar = (f) view).getPlayStatus()) != 2 && playStatus != 5 && playStatus != 0) {
            fVar.b();
        }
        return z;
    }
}

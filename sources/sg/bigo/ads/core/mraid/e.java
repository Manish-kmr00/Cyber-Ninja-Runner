package sg.bigo.ads.core.mraid;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.JsResult;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import sg.bigo.ads.common.utils.u;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements sg.bigo.ads.common.d.d {
    private final sg.bigo.ads.core.mraid.c.b A;
    private final sg.bigo.ads.core.mraid.c.b B;
    private int C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f13642a;
    final n b;
    final FrameLayout c;
    final sg.bigo.ads.core.mraid.a.a d;
    final j e;
    o f;
    public b g;
    sg.bigo.ads.core.mraid.c.C0899c h;
    public final sg.bigo.ads.core.mraid.c i;
    final sg.bigo.ads.core.mraid.c j;
    final c k;
    private WeakReference<Activity> l;
    private ViewGroup m;
    private final C0900e n;
    private l o;
    private sg.bigo.ads.core.mraid.c.C0899c p;
    private Integer q;
    private final int r;
    private int s;
    private boolean t;
    private i u;
    private final h v;
    private boolean w;
    private boolean x;
    private sg.bigo.ads.core.mraid.a y;
    private final Handler z;

    public interface a extends b {
        void a(String str, String str2);
    }

    public interface b {
        void a();

        void a(String str, sg.bigo.ads.common.i iVar);

        boolean a(Activity activity, int i);

        void b();

        boolean b(Activity activity, int i);

        void c();

        void d();

        void e();

        void f();

        void g();
    }

    class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13650a;
        int b;

        private c() {
            this.f13650a = -1;
            this.b = -1;
        }

        /* synthetic */ c(e eVar, byte b) {
            this();
        }

        final void a() {
            int measuredWidth = e.this.h.getMeasuredWidth();
            int measuredHeight = e.this.h.getMeasuredHeight();
            this.f13650a = measuredWidth;
            this.b = measuredHeight;
        }
    }

    public interface d {
        void a();
    }

    /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.e$e, reason: collision with other inner class name */
    static class C0900e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Handler f13651a = new Handler(Looper.getMainLooper());
        a b;

        /* JADX INFO: renamed from: sg.bigo.ads.core.mraid.e$e$a */
        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final View[] f13652a;
            final Handler b;
            Runnable c;
            int d;
            final Runnable e;

            private a(Handler handler, View[] viewArr) {
                this.e = new Runnable() { // from class: sg.bigo.ads.core.mraid.e.e.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        for (final View view : a.this.f13652a) {
                            if (view.getHeight() > 0 || view.getWidth() > 0) {
                                a.a(a.this);
                            } else {
                                view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: sg.bigo.ads.core.mraid.e.e.a.1.1
                                    @Override // android.view.ViewTreeObserver.OnPreDrawListener
                                    public final boolean onPreDraw() {
                                        view.getViewTreeObserver().removeOnPreDrawListener(this);
                                        a.a(a.this);
                                        return true;
                                    }
                                });
                            }
                        }
                    }
                };
                this.b = handler;
                this.f13652a = viewArr;
            }

            /* synthetic */ a(Handler handler, View[] viewArr, byte b) {
                this(handler, viewArr);
            }

            static /* synthetic */ void a(a aVar) {
                Runnable runnable;
                int i = aVar.d - 1;
                aVar.d = i;
                if (i != 0 || (runnable = aVar.c) == null) {
                    return;
                }
                runnable.run();
                aVar.c = null;
            }

            final void a() {
                this.b.removeCallbacks(this.e);
                this.c = null;
            }
        }

        C0900e() {
        }

        final void a() {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a();
                this.b = null;
            }
        }
    }

    public e(Context context, n nVar) {
        this(context, nVar, new sg.bigo.ads.core.mraid.c(nVar), new sg.bigo.ads.core.mraid.c(n.INTERSTITIAL), new C0900e());
    }

    private e(Context context, n nVar, sg.bigo.ads.core.mraid.c cVar, sg.bigo.ads.core.mraid.c cVar2, C0900e c0900e) {
        this.f = o.LOADING;
        this.t = true;
        this.u = i.NONE;
        this.w = true;
        byte b2 = 0;
        this.x = false;
        sg.bigo.ads.core.mraid.c.a aVar = new sg.bigo.ads.core.mraid.c.a() { // from class: sg.bigo.ads.core.mraid.e.3
            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a() {
                e eVar = e.this;
                eVar.i.a(h.b(eVar.f13642a), h.a(eVar.f13642a), h.d(eVar.f13642a), h.c(eVar.f13642a), eVar.c());
                eVar.i.a(eVar.b);
                eVar.i.a(eVar.i.b());
                eVar.i.a(eVar.e);
                eVar.k();
                eVar.a(o.DEFAULT);
                eVar.i.c("mraidbridge.notifyReadyEvent();");
                if (e.this.g != null) {
                    e.this.g.a();
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(int i, int i2, int i3, int i4, sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a, boolean z) throws sg.bigo.ads.core.mraid.d {
                e eVar = e.this;
                if (eVar.h == null) {
                    throw new sg.bigo.ads.core.mraid.d("Unable to resize after the WebView is destroyed");
                }
                if (eVar.f == o.LOADING || eVar.f == o.HIDDEN) {
                    return;
                }
                if (eVar.f == o.EXPANDED) {
                    throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an already expanded ad");
                }
                if (eVar.b == n.INTERSTITIAL) {
                    throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an interstitial ad");
                }
                eVar.k.a();
                Context context2 = eVar.f13642a;
                int iA = sg.bigo.ads.common.utils.e.a(context2, i);
                int iA2 = sg.bigo.ads.common.utils.e.a(context2, i2);
                int iA3 = sg.bigo.ads.common.utils.e.a(context2, i3);
                int iA4 = sg.bigo.ads.common.utils.e.a(context2, i4);
                int i5 = eVar.e.g.left + iA3;
                int i6 = eVar.e.g.top + iA4;
                Rect rect = new Rect(i5, i6, iA + i5, i6 + iA2);
                if (!z) {
                    Rect rect2 = eVar.e.c;
                    if (rect.width() > rect2.width() || rect.height() > rect2.height()) {
                        throw new sg.bigo.ads.core.mraid.d("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the ad to appear within the max allowed size (" + eVar.e.d.width() + ", " + eVar.e.d.height() + ")");
                    }
                    rect.offsetTo(e.a(rect2.left, rect.left, rect2.right - rect.width()), e.a(rect2.top, rect.top, rect2.bottom - rect.height()));
                }
                Rect rect3 = new Rect();
                eVar.d.a(enumC0898a, rect, rect3);
                if (!eVar.e.c.contains(rect3)) {
                    throw new sg.bigo.ads.core.mraid.d("resizeProperties specified a size (" + i + ", " + i2 + ") and offset (" + i3 + ", " + i4 + ") that doesn't allow the close region to appear within the max allowed size (" + eVar.e.d.width() + ", " + eVar.e.d.height() + ")");
                }
                if (!rect.contains(rect3)) {
                    throw new sg.bigo.ads.core.mraid.d("resizeProperties specified a size (" + i + ", " + iA2 + ") and offset (" + i3 + ", " + i4 + ") that don't allow the close region to appear within the resized ad.");
                }
                eVar.d.setCloseVisible(false);
                eVar.d.setClosePosition(enumC0898a);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
                layoutParams.leftMargin = rect.left - eVar.e.c.left;
                layoutParams.topMargin = rect.top - eVar.e.c.top;
                if (eVar.f == o.DEFAULT) {
                    eVar.c.removeView(eVar.h);
                    eVar.c.setVisibility(4);
                    eVar.d.addView(eVar.h, new FrameLayout.LayoutParams(-1, -1));
                    eVar.j().addView(eVar.d, layoutParams);
                } else if (eVar.f == o.RESIZED) {
                    eVar.d.setLayoutParams(layoutParams);
                }
                eVar.d.setClosePosition(enumC0898a);
                eVar.a(o.RESIZED);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str) {
                e.this.a(str);
            }

            @Override // sg.bigo.ads.core.mraid.c.a
            public final void a(String str, String str2) {
                if (e.this.g == null || !(e.this.g instanceof a)) {
                    return;
                }
                ((a) e.this.g).a(str, str2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, sg.bigo.ads.common.i iVar) {
                e.this.a(str, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, boolean z) throws sg.bigo.ads.core.mraid.d {
                e.this.a(str, z);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(sg.bigo.ads.core.mraid.b bVar) {
                if (e.this.j.c()) {
                    return;
                }
                e.this.i.a(bVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z) {
                if (e.this.j.c()) {
                    return;
                }
                e.this.i.a(z);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z, i iVar) throws sg.bigo.ads.core.mraid.d {
                e.this.a(z, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean a(JsResult jsResult) {
                return e.this.a(jsResult);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b() {
                if (e.this.g != null) {
                    e.this.g.b();
                }
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b(boolean z) {
                e.this.b(z);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void c() {
                e.this.h();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean d() {
                return e.this.a();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void e() {
                e.this.f();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void f() {
                e.this.g();
            }
        };
        this.A = aVar;
        sg.bigo.ads.core.mraid.c.b bVar = new sg.bigo.ads.core.mraid.c.b() { // from class: sg.bigo.ads.core.mraid.e.4
            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a() {
                final e eVar = e.this;
                eVar.a(new Runnable() { // from class: sg.bigo.ads.core.mraid.e.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.this.j.a(h.b(e.this.f13642a), h.a(e.this.f13642a), h.d(e.this.f13642a), h.c(e.this.f13642a), e.this.c());
                        e.this.j.a(e.this.f);
                        e.this.j.a(e.this.b);
                        e.this.j.a(e.this.j.b());
                        e.this.j.c("mraidbridge.notifyReadyEvent();");
                    }
                });
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(int i, int i2, int i3, int i4, sg.bigo.ads.core.mraid.a.a.EnumC0898a enumC0898a, boolean z) throws sg.bigo.ads.core.mraid.d {
                throw new sg.bigo.ads.core.mraid.d("Not allowed to resize from an expanded state");
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str) {
                e.this.a(str);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, sg.bigo.ads.common.i iVar) {
                e.this.a(str, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(String str, boolean z) {
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(sg.bigo.ads.core.mraid.b bVar2) {
                e.this.i.a(bVar2);
                e.this.j.a(bVar2);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z) {
                e.this.i.a(z);
                e.this.j.a(z);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void a(boolean z, i iVar) throws sg.bigo.ads.core.mraid.d {
                e.this.a(z, iVar);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean a(JsResult jsResult) {
                return e.this.a(jsResult);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b() {
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void b(boolean z) {
                e.this.b(z);
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void c() {
                e.this.h();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final boolean d() {
                return e.this.a();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void e() {
                e.this.f();
            }

            @Override // sg.bigo.ads.core.mraid.c.b
            public final void f() {
                e.this.g();
            }
        };
        this.B = bVar;
        this.C = -1;
        this.z = new Handler(Looper.getMainLooper());
        this.f13642a = context;
        this.l = context instanceof Activity ? new WeakReference<>((Activity) context) : new WeakReference<>(null);
        this.b = nVar;
        this.i = cVar;
        this.j = cVar2;
        this.n = c0900e;
        this.k = new c(this, b2);
        this.f = o.LOADING;
        this.e = new j(context, context.getResources().getDisplayMetrics().density);
        this.c = new FrameLayout(context);
        sg.bigo.ads.core.mraid.a.a aVar2 = new sg.bigo.ads.core.mraid.a.a(context);
        this.d = aVar2;
        aVar2.setOnCloseListener(new sg.bigo.ads.core.mraid.a.a.b() { // from class: sg.bigo.ads.core.mraid.e.1
            @Override // sg.bigo.ads.core.mraid.a.a.b
            public final void a() {
                e.this.g();
            }
        });
        View view = new View(context);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: sg.bigo.ads.core.mraid.e.2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        aVar2.addView(view, new FrameLayout.LayoutParams(-1, -1));
        sg.bigo.ads.common.d.a.a().a(context, this);
        cVar.f13633a = aVar;
        cVar2.f13633a = bVar;
        this.v = new h();
        this.r = 4871;
    }

    static int a(int i, int i2, int i3) {
        return Math.max(i, Math.min(i2, i3));
    }

    private void a(int i) throws sg.bigo.ads.core.mraid.d {
        Activity activity = this.l.get();
        if (activity == null || !a(this.u)) {
            throw new sg.bigo.ads.core.mraid.d("Attempted to lock orientation to unsupported value: " + this.u.name());
        }
        if (this.q == null) {
            this.q = Integer.valueOf(activity.getRequestedOrientation());
        }
        b bVar = this.g;
        if (bVar == null || !bVar.a(activity, i)) {
            activity.setRequestedOrientation(i);
        }
    }

    private static void a(WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        webView.onPause();
    }

    private static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    private boolean a(i iVar) {
        if (iVar == i.NONE) {
            return true;
        }
        Activity activity = this.l.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            return a(activityInfo.configChanges, 128) && a(activityInfo.configChanges, 1024);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private void l() {
        this.i.a();
        this.h = null;
    }

    private void m() {
        this.j.a();
        this.p = null;
    }

    private void n() throws sg.bigo.ads.core.mraid.d {
        int iA;
        if (this.u != i.NONE) {
            iA = this.u.d;
        } else {
            if (this.t) {
                o();
                return;
            }
            Activity activity = this.l.get();
            if (activity == null) {
                throw new sg.bigo.ads.core.mraid.d("Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
            }
            iA = sg.bigo.ads.common.aa.b.a(activity);
        }
        a(iA);
    }

    private void o() {
        Integer num;
        j().setSystemUiVisibility(this.s);
        Activity activity = this.l.get();
        if (activity != null && (num = this.q) != null) {
            b bVar = this.g;
            if (bVar != null && bVar.b(activity, num.intValue())) {
                return;
            } else {
                activity.setRequestedOrientation(this.q.intValue());
            }
        }
        this.q = null;
    }

    private boolean p() {
        return !this.d.f13629a.isVisible();
    }

    private void q() {
        if (this.y != null) {
            this.f13642a.getContentResolver().unregisterContentObserver(this.y);
            this.y = null;
        }
    }

    @Override // sg.bigo.ads.common.d.b
    public final void a(Context context, Intent intent) {
        int rotation;
        if (!"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (rotation = ((WindowManager) this.f13642a.getSystemService("window")).getDefaultDisplay().getRotation()) == this.C) {
            return;
        }
        this.C = rotation;
        a((Runnable) null);
    }

    final void a(final Runnable runnable) {
        this.n.a();
        final sg.bigo.ads.core.mraid.c.C0899c c0899cB = b();
        if (c0899cB == null) {
            return;
        }
        C0900e c0900e = this.n;
        c0900e.b = new C0900e.a(c0900e.f13651a, new View[]{this.c, c0899cB}, (byte) 0);
        C0900e.a aVar = c0900e.b;
        aVar.c = new Runnable() { // from class: sg.bigo.ads.core.mraid.e.6
            @Override // java.lang.Runnable
            public final void run() {
                DisplayMetrics displayMetrics = e.this.f13642a.getResources().getDisplayMetrics();
                j jVar = e.this.e;
                jVar.f13664a.set(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                jVar.a(jVar.f13664a, jVar.b);
                int[] iArr = new int[2];
                ViewGroup viewGroupI = e.this.i();
                viewGroupI.getLocationOnScreen(iArr);
                j jVar2 = e.this.e;
                int i = iArr[0];
                int i2 = iArr[1];
                jVar2.c.set(i, i2, viewGroupI.getWidth() + i, viewGroupI.getHeight() + i2);
                jVar2.a(jVar2.c, jVar2.d);
                e.this.c.getLocationOnScreen(iArr);
                j jVar3 = e.this.e;
                int i3 = iArr[0];
                int i4 = iArr[1];
                jVar3.g.set(i3, i4, e.this.c.getWidth() + i3, e.this.c.getHeight() + i4);
                jVar3.a(jVar3.g, jVar3.h);
                c0899cB.getLocationOnScreen(iArr);
                j jVar4 = e.this.e;
                int i5 = iArr[0];
                int i6 = iArr[1];
                jVar4.e.set(i5, i6, c0899cB.getWidth() + i5, c0899cB.getHeight() + i6);
                jVar4.a(jVar4.e, jVar4.f);
                e.this.i.a(e.this.e);
                if (e.this.j.c()) {
                    e.this.j.a(e.this.e);
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        };
        aVar.d = aVar.f13652a.length;
        aVar.b.post(aVar.e);
    }

    final void a(String str) {
        MraidVideoActivity.a(this.f13642a, str);
    }

    final void a(String str, sg.bigo.ads.common.i iVar) {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if ("tel".equalsIgnoreCase(scheme) || "voicemail".equalsIgnoreCase(scheme) || "sms".equalsIgnoreCase(scheme) || "mailto".equalsIgnoreCase(scheme) || "geo".equalsIgnoreCase(scheme) || "google.streetview".equalsIgnoreCase(scheme)) {
            sg.bigo.ads.common.t.a.a(2, "MraidController", String.format("Uri scheme %s is not allowed.", uri.getScheme()));
            return;
        }
        b bVar = this.g;
        if (bVar != null) {
            bVar.a(str, iVar);
        }
    }

    public final void a(String str, d dVar) {
        a(dVar);
        this.i.a(str);
    }

    final void a(String str, boolean z) throws sg.bigo.ads.core.mraid.d {
        sg.bigo.ads.core.mraid.a.a aVar;
        sg.bigo.ads.core.mraid.c.C0899c c0899c;
        if (this.h == null) {
            throw new sg.bigo.ads.core.mraid.d("Unable to expand after the WebView is destroyed");
        }
        if (this.b == n.INTERSTITIAL) {
            return;
        }
        if (this.f == o.DEFAULT || this.f == o.RESIZED) {
            n();
            boolean z2 = str != null;
            if (z2) {
                sg.bigo.ads.core.mraid.c.C0899c c0899cA = sg.bigo.ads.core.mraid.c.a(this.f13642a);
                this.p = c0899cA;
                if (c0899cA == null) {
                    return;
                }
                this.j.a(c0899cA);
                this.j.b(str);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (this.f == o.DEFAULT) {
                this.s = j().getSystemUiVisibility();
                j().setSystemUiVisibility(this.r);
                if (z2) {
                    aVar = this.d;
                    c0899c = this.p;
                } else {
                    this.k.a();
                    this.c.removeView(this.h);
                    this.c.setVisibility(4);
                    aVar = this.d;
                    c0899c = this.h;
                }
                aVar.addView(c0899c, layoutParams);
                j().addView(this.d, new FrameLayout.LayoutParams(-1, -1));
            } else if (this.f == o.RESIZED && z2) {
                this.d.removeView(this.h);
                this.c.addView(this.h, layoutParams);
                this.c.setVisibility(4);
                this.d.addView(this.p, layoutParams);
            }
            this.d.setLayoutParams(layoutParams);
            b(z);
            a(o.EXPANDED);
        }
    }

    public final void a(d dVar) {
        sg.bigo.ads.core.mraid.c.C0899c c0899cA = sg.bigo.ads.core.mraid.c.a(this.f13642a);
        this.h = c0899cA;
        if (c0899cA == null) {
            return;
        }
        if (dVar != null) {
            dVar.a();
        }
        this.i.a(this.h);
        this.c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
    }

    final void a(o oVar) {
        sg.bigo.ads.common.t.a.a(0, 3, "MraidController", "MRAID state set to ".concat(String.valueOf(oVar)));
        o oVar2 = this.f;
        this.f = oVar;
        this.i.a(oVar);
        if (this.j.c) {
            this.j.a(oVar);
        }
        b bVar = this.g;
        if (bVar != null) {
            if (oVar == o.EXPANDED) {
                bVar.d();
            } else if ((oVar2 == o.EXPANDED && oVar == o.DEFAULT) || oVar == o.HIDDEN) {
                bVar.f();
            } else if ((oVar2 == o.RESIZED && oVar == o.DEFAULT) || oVar == o.RESIZED) {
                bVar.e();
            }
        }
        a((Runnable) null);
    }

    public final void a(boolean z) {
        this.w = true;
        q();
        sg.bigo.ads.core.mraid.c.C0899c c0899c = this.h;
        if (c0899c != null) {
            a(c0899c, z);
        }
        sg.bigo.ads.core.mraid.c.C0899c c0899c2 = this.p;
        if (c0899c2 != null) {
            a(c0899c2, z);
        }
    }

    final void a(boolean z, i iVar) throws sg.bigo.ads.core.mraid.d {
        if (!a(iVar)) {
            throw new sg.bigo.ads.core.mraid.d("Unable to force orientation to ".concat(String.valueOf(iVar)));
        }
        this.t = z;
        this.u = iVar;
        if (this.f == o.EXPANDED || (this.b == n.INTERSTITIAL && !this.w)) {
            n();
        }
    }

    final boolean a() {
        l lVar = this.o;
        if (lVar != null) {
            return lVar.b();
        }
        return true;
    }

    final boolean a(JsResult jsResult) {
        l lVar = this.o;
        if (lVar != null) {
            return lVar.a();
        }
        jsResult.confirm();
        return true;
    }

    public final sg.bigo.ads.core.mraid.c.C0899c b() {
        return this.j.c() ? this.p : this.h;
    }

    protected final void b(boolean z) {
        if (z == p()) {
            return;
        }
        this.d.setCloseVisible(!z);
    }

    final boolean c() {
        Activity activity = this.l.get();
        if (activity == null || b() == null) {
            return false;
        }
        if (this.b != n.INLINE) {
            return true;
        }
        return h.a(activity);
    }

    public final void d() {
        this.w = false;
        k();
        sg.bigo.ads.core.mraid.c.C0899c c0899c = this.h;
        if (c0899c != null) {
            c0899c.onResume();
        }
        sg.bigo.ads.core.mraid.c.C0899c c0899c2 = this.p;
        if (c0899c2 != null) {
            c0899c2.onResume();
        }
    }

    public final void e() {
        this.n.a();
        try {
            sg.bigo.ads.common.d.a.a().a(this);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        if (!this.w) {
            a(true);
        }
        u.b(this.d);
        l();
        m();
        o();
        q();
        this.m = null;
        u.b(this.c);
        u.b(this.d);
        this.x = true;
    }

    final void f() {
        b bVar;
        if (this.b != n.INTERSTITIAL || (bVar = this.g) == null) {
            return;
        }
        bVar.g();
    }

    protected final void g() {
        ViewGroup.LayoutParams layoutParams;
        sg.bigo.ads.core.mraid.c.C0899c c0899c;
        if (this.h == null || this.f == o.LOADING || this.f == o.HIDDEN) {
            return;
        }
        if (this.f == o.EXPANDED || this.b == n.INTERSTITIAL) {
            o();
        }
        if (this.f != o.RESIZED && this.f != o.EXPANDED) {
            if (this.f == o.DEFAULT) {
                this.c.setVisibility(4);
                a(o.HIDDEN);
                return;
            }
            return;
        }
        if (!this.j.c() || (c0899c = this.p) == null) {
            this.d.removeView(this.h);
            this.c.addView(this.h, new FrameLayout.LayoutParams(-1, -1));
            this.c.setVisibility(0);
        } else {
            m();
            this.d.removeView(c0899c);
        }
        c cVar = this.k;
        if (e.this.h != null && cVar.f13650a > 0 && cVar.b > 0 && (layoutParams = e.this.h.getLayoutParams()) != null) {
            layoutParams.width = cVar.f13650a;
            layoutParams.height = cVar.b;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
            }
            e.this.h.setLayoutParams(layoutParams);
        }
        u.b(this.d);
        a(o.DEFAULT);
    }

    final void h() {
        b bVar = this.g;
        if (bVar != null) {
            bVar.c();
        }
    }

    final ViewGroup i() {
        ViewGroup viewGroup = this.m;
        if (viewGroup != null) {
            return viewGroup;
        }
        View viewA = u.a(this.l.get(), this.c);
        return viewA instanceof ViewGroup ? (ViewGroup) viewA : this.c;
    }

    final ViewGroup j() {
        if (this.m == null) {
            this.m = i();
        }
        return this.m;
    }

    final void k() {
        if (this.x || this.f == o.LOADING || this.f == o.HIDDEN || this.h == null) {
            return;
        }
        Context context = this.f13642a;
        if (this.y != null) {
            q();
        }
        this.y = new sg.bigo.ads.core.mraid.a(this.z, context.getApplicationContext(), new sg.bigo.ads.core.mraid.a.InterfaceC0897a() { // from class: sg.bigo.ads.core.mraid.e.7
            @Override // sg.bigo.ads.core.mraid.a.InterfaceC0897a
            public final void a(float f) {
                e.this.i.c("mraidbridge.notifyAudioVolumeChangeEvent(" + f + ");");
            }
        });
        context.getApplicationContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.y);
    }
}

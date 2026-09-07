package io.bidmachine.rendering.internal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.utils.VisibilityTracker;
import io.bidmachine.rendering.model.VisibilityParams;
import io.bidmachine.rendering.utils.UiUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes8.dex */
public class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f12393a;
    private final VisibilityParams b;
    private final v.a c;
    private final Runnable d;
    private final ViewTreeObserver.OnPreDrawListener e;
    private final Object f = new Object();
    private final AtomicBoolean g = new AtomicBoolean(false);
    private final AtomicBoolean h = new AtomicBoolean(false);
    private final AtomicBoolean i = new AtomicBoolean(false);

    private class b implements l {
        private b() {
        }

        @Override // io.bidmachine.rendering.utils.SafeRunnable
        public void onRun() {
            if (w.this.c()) {
                return;
            }
            w.this.d();
        }

        @Override // io.bidmachine.rendering.internal.l, io.bidmachine.rendering.utils.SafeRunnable
        public void onThrows(Throwable th) {
            super.onThrows(th);
            w.this.d();
        }
    }

    private class c implements ViewTreeObserver.OnPreDrawListener {
        private c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            w.this.h();
            return true;
        }
    }

    public w(View view, VisibilityParams visibilityParams, v.a aVar) {
        this.f12393a = new WeakReference(view);
        this.b = visibilityParams;
        this.c = aVar;
        this.d = new b();
        this.e = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.h.set(false);
        h();
    }

    private void f() {
        if (this.i.compareAndSet(false, true)) {
            this.c.a();
        }
    }

    private void g() {
        if (this.i.compareAndSet(true, false)) {
            this.c.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.h.compareAndSet(false, true)) {
            UiUtils.cancelOnUiThread(this.d);
            UiUtils.onUiThread(this.d, 100L);
        }
    }

    public View e() {
        return (View) this.f12393a.get();
    }

    @Override // io.bidmachine.rendering.internal.v
    public void start() {
        synchronized (this.f) {
            if (this.g.compareAndSet(false, true)) {
                View viewE = e();
                if (viewE == null) {
                    stop();
                    return;
                }
                m.b(VisibilityTracker.TAG, "Start tracking - %s", viewE);
                ViewTreeObserver viewTreeObserver = viewE.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.e);
                }
            }
        }
    }

    @Override // io.bidmachine.rendering.internal.v
    public void stop() {
        synchronized (this.f) {
            this.g.set(false);
            View viewE = e();
            if (viewE != null) {
                m.b(VisibilityTracker.TAG, "Stop tracking - %s", viewE);
                ViewTreeObserver viewTreeObserver = viewE.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.e);
                }
            }
            UiUtils.cancelOnUiThread(this.d);
            this.h.set(false);
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        View viewE = e();
        if (viewE == null) {
            stop();
            return true;
        }
        if (a(viewE, this.b.getVisibilityPercent(), this.b.isIgnoreWindowFocus(), this.b.isIgnoreOverlap())) {
            f();
            return false;
        }
        g();
        return false;
    }

    @Override // io.bidmachine.rendering.internal.v
    public void a() {
        stop();
        this.f12393a.clear();
    }

    @Override // io.bidmachine.rendering.internal.v
    public boolean b() {
        return this.i.get();
    }

    private View a(View view) {
        View view2 = null;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            view2 = (View) parent;
            if (view2.getId() == 16908290) {
                break;
            }
        }
        return view2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r14v4, types: [android.view.View, java.lang.Object] */
    private boolean a(View view, float f, boolean z, boolean z2) {
        try {
            if (!view.isShown()) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: view visibility verification failed - %s", view);
                return false;
            }
            if (UiUtils.isViewTransparent(view)) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: view transparent verification failed - %s", view);
                return false;
            }
            if (!z && !view.hasWindowFocus()) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: window focus verification failed - %s", view);
                return false;
            }
            float width = view.getWidth() * view.getHeight();
            if (width == 0.0f) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: view size verification failed - %s", view);
                return false;
            }
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect)) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: global visibility verification failed - %s", view);
                return false;
            }
            float fWidth = (rect.width() * rect.height()) / width;
            if (fWidth < f) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view not completely visible (%s / %s) - %s", Float.valueOf(fWidth), Float.valueOf(f), view);
                return false;
            }
            View viewA = a(view);
            if (viewA == null) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: content or root layout not found - %s", view);
                return false;
            }
            Rect rect2 = new Rect();
            viewA.getGlobalVisibleRect(rect2);
            if (!Rect.intersects(rect, rect2)) {
                m.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is out of current window - %s", view);
                return false;
            }
            if (!z2) {
                ViewGroup viewGroup = (ViewGroup) view.getRootView();
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                int i = 0;
                ?? r11 = view;
                loop0: while (true) {
                    ViewGroup viewGroup3 = viewGroup2;
                    ?? r14 = r11;
                    for (?? r12 = viewGroup3; r12 != 0; r12 = 0) {
                        for (int iIndexOfChild = r12.indexOfChild(r14) + 1; iIndexOfChild < r12.getChildCount(); iIndexOfChild++) {
                            View childAt = r12.getChildAt(iIndexOfChild);
                            if (UiUtils.isViewVisible(childAt)) {
                                Rect locationInWindow = UiUtils.getLocationInWindow(childAt);
                                if (Rect.intersects(rect, locationInWindow)) {
                                    float notOverlappedAreaPercent = UiUtils.getNotOverlappedAreaPercent(rect, locationInWindow);
                                    if (notOverlappedAreaPercent < f) {
                                        m.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is covered by another view (visible percent - %s / %s, ad view - %s, overlapping view - %s)", Float.valueOf(notOverlappedAreaPercent), Float.valueOf(f), r14, childAt);
                                        return false;
                                    }
                                    i++;
                                    if (i >= 3) {
                                        m.b(VisibilityTracker.TAG, "Show wasn't tracked: ad view is covered by too many views (overlapping views count - %s, ad view - %s)", Integer.valueOf(i), r14);
                                        return false;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (r12 != viewGroup) {
                            viewGroup2 = (ViewGroup) r12.getParent();
                            r11 = r12;
                        }
                    }
                    break loop0;
                }
            }
            return true;
        } catch (Exception e) {
            m.b(e);
        }
    }
}

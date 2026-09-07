package io.bidmachine.iab.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import io.bidmachine.iab.mraid.MraidLog;
import io.bidmachine.iab.mraid.MraidUtils;

/* JADX INFO: loaded from: classes9.dex */
public class VisibilityTracker {
    public static final String TAG = "VisibilityTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12251a;
    private final View b;
    private final Callback c;
    private final float d;
    private final Rect e;
    private final Rect f;
    private final Runnable g;
    private ViewTreeObserver.OnPreDrawListener h;
    private View.OnAttachStateChangeListener i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;

    public interface Callback {
        void onVisibilityChanged(boolean visible);
    }

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VisibilityTracker.this.a();
            VisibilityTracker.this.l = false;
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            VisibilityTracker.this.b();
            return true;
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            VisibilityTracker.this.a();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            VisibilityTracker.this.a();
        }
    }

    public VisibilityTracker(Context context, View view, Callback callback) {
        this(context, view, callback, 0.1f);
    }

    public boolean isVisible() {
        return this.j;
    }

    public void release() {
        this.n = true;
        this.m = false;
        this.l = false;
        this.b.getViewTreeObserver().removeOnPreDrawListener(this.h);
        this.b.removeOnAttachStateChangeListener(this.i);
        Utils.cancelOnUiThread(this.g);
    }

    public void start() {
        if (this.n || this.m) {
            return;
        }
        this.m = true;
        if (this.h == null) {
            this.h = new b();
        }
        if (this.i == null) {
            this.i = new c();
        }
        this.b.getViewTreeObserver().addOnPreDrawListener(this.h);
        this.b.addOnAttachStateChangeListener(this.i);
        a();
    }

    public VisibilityTracker(Context context, View view, Callback callback, float visibilityPercent) {
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.f12251a = context;
        this.b = view;
        this.c = callback;
        this.d = visibilityPercent;
        this.e = new Rect();
        this.f = new Rect();
        this.g = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.l) {
            return;
        }
        this.l = true;
        Utils.onUiThread(this.g, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (this.b.getVisibility() != 0) {
                a(this.b, "Visibility != View.VISIBLE");
                return;
            }
            if (this.b.getParent() == null) {
                a(this.b, "No parent");
                return;
            }
            if (!this.b.getGlobalVisibleRect(this.e)) {
                a(this.b, "Can't get global visible rect");
                return;
            }
            if (Utils.isViewTransparent(this.b)) {
                a(this.b, "View is transparent (alpha = 0)");
                return;
            }
            float width = this.b.getWidth() * this.b.getHeight();
            if (width <= 0.0f) {
                a(this.b, "Ad View width or height is zero, show wasn't tracked");
                return;
            }
            float fWidth = (this.e.width() * this.e.height()) / width;
            if (fWidth < this.d) {
                a(this.b, "Ad View is not completely visible (" + fWidth + "), show wasn't tracked");
                return;
            }
            View topmostView = MraidUtils.getTopmostView(this.f12251a, this.b);
            if (topmostView == null) {
                a(this.b, "Can't obtain root view");
                return;
            }
            topmostView.getGlobalVisibleRect(this.f);
            if (!Rect.intersects(this.e, this.f)) {
                a(this.b, "Ad View is out of current window, show wasn't tracked");
                return;
            }
            a(this.b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(View view, String str) {
        if (!this.k) {
            this.k = true;
            MraidLog.d(TAG, str, new Object[0]);
        }
        a(false);
    }

    private void a(View view) {
        this.k = false;
        a(true);
    }

    private void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.c.onVisibilityChanged(z);
        }
    }
}

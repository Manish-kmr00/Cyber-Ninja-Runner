package com.inmobi.media;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.inmobi.media.c3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C3323c3 extends fd {
    public final L4 n;
    public final String o;
    public final ViewTreeObserver.OnPreDrawListener p;
    public final WeakReference q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3323c3(Zc visibilityChecker, Activity activity, L4 l4) {
        super(visibilityChecker, (byte) 1, l4);
        Intrinsics.checkNotNullParameter(visibilityChecker, "visibilityChecker");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.n = l4;
        this.o = "c3";
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        this.q = new WeakReference(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.inmobi.media.c3$$ExternalSyntheticLambda0
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public final boolean onPreDraw() {
                    return C3323c3.a(this.f$0);
                }
            };
            this.p = onPreDrawListener;
            viewTreeObserver.addOnPreDrawListener(onPreDrawListener);
        } else if (l4 != null) {
            Intrinsics.checkNotNullExpressionValue("c3", "TAG");
            ((M4) l4).b("c3", "Visibility Tracker was unable to track views because the  root view tree observer was not alive");
        }
    }

    public static final boolean a(C3323c3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
        return true;
    }

    @Override // com.inmobi.media.fd
    public final void b() {
        L4 l4 = this.n;
        if (l4 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "unregisterPreDrawListener");
        }
        View view = (View) this.q.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.p);
            }
        }
        super.b();
    }

    @Override // com.inmobi.media.fd
    public final int c() {
        return 100;
    }

    @Override // com.inmobi.media.fd
    public final void d() {
    }

    @Override // com.inmobi.media.fd
    public final void e() {
        L4 l4 = this.n;
        if (l4 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "pause");
        }
        if (this.i.get()) {
            return;
        }
        L4 l5 = this.n;
        if (l5 != null) {
            String TAG2 = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((M4) l5).c(TAG2, "unregisterPreDrawListener");
        }
        View view = (View) this.q.get();
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.p);
            }
        }
        super.e();
    }

    @Override // com.inmobi.media.fd
    public final void f() {
        L4 l4 = this.n;
        if (l4 != null) {
            String TAG = this.o;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((M4) l4).c(TAG, "resume");
        }
        if (this.i.get()) {
            View view = (View) this.q.get();
            if (view != null) {
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnPreDrawListener(this.p);
                } else {
                    L4 l5 = this.n;
                    if (l5 != null) {
                        String TAG2 = this.o;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((M4) l5).b(TAG2, "Visibility Tracker was unable to track views because the root view tree observer was not alive");
                    }
                }
            }
            super.f();
        }
    }
}

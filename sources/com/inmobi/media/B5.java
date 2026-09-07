package com.inmobi.media;

import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class B5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f3032a;
    public final L4 b;
    public int c;
    public int d;

    public B5(FrameLayout view, L4 l4) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f3032a = view;
        this.b = l4;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        try {
            L4 l4 = this.b;
            if (l4 != null) {
                String str = E5.f3056a;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((M4) l4).a(str, "close called");
            }
            this.c = AbstractC3565t3.a(this.f3032a.getWidth());
            this.d = AbstractC3565t3.a(this.f3032a.getHeight());
            this.f3032a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Boolean bool = Boolean.FALSE;
            synchronized (bool) {
                bool.notify();
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception e) {
            L4 l5 = this.b;
            if (l5 != null) {
                String str2 = E5.f3056a;
                ((M4) l5).b(str2, ld.a(e, O5.a(str2, "access$getTAG$p(...)", "SDK encountered unexpected error in JavaScriptBridge$1.onGlobalLayout(); ")));
            }
        }
    }
}

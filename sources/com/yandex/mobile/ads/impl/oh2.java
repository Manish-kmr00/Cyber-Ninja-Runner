package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import kotlin.Deprecated;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes12.dex */
public final class oh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final zh2 f9817a = new zh2(new of1(), new ai2());
    public static final /* synthetic */ int b = 0;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver.OnPreDrawListener f9818a;
        final /* synthetic */ View b;

        a(View view, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
            this.f9818a = onPreDrawListener;
            this.b = view;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f9818a.onPreDraw();
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    @JvmStatic
    public static final float b(int i, float f) {
        return ((i + 0.0f) / f) + 0.5f;
    }

    @JvmStatic
    public static final boolean d(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.isShown()) {
            return (view.getAlpha() > 0.0f ? 1 : (view.getAlpha() == 0.0f ? 0 : -1)) == 0;
        }
        return true;
    }

    @JvmStatic
    public static final boolean e(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable background = view.getBackground();
        return (background == null || ((float) background.getAlpha()) == 0.0f) ? false : true;
    }

    @JvmStatic
    public static final int b(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.isShown()) {
            return f9817a.a(view);
        }
        return 0;
    }

    @JvmStatic
    public static final boolean c(View view) {
        if (view == null) {
            return false;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int width = view.getWidth() + i;
        int i2 = iArr[1];
        Rect rect = new Rect(i, i2, width, view.getHeight() + i2);
        Rect rect2 = new Rect();
        try {
            view.getWindowVisibleDisplayFrame(rect2);
        } catch (NullPointerException unused) {
        }
        return !((rect.bottom <= rect2.top || rect.top >= rect2.bottom) || (rect.right <= rect2.left || rect.left >= rect2.right));
    }

    @JvmStatic
    public static final int c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) b(context.getResources().getDisplayMetrics().widthPixels, bb0.a(context, "context").density);
    }

    @JvmStatic
    public static final int a(int i, float f) {
        return Color.argb(RangesKt.coerceAtLeast(0, RangesKt.coerceAtMost(255, (int) ((255 * (100 - f)) / 100.0f))), Color.red(i), Color.green(i), Color.blue(i));
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final int a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(i / context.getResources().getDisplayMetrics().density);
    }

    @JvmStatic
    public static final void a(View view, ViewTreeObserver.OnPreDrawListener callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        view.getViewTreeObserver().addOnPreDrawListener(new a(view, callback));
    }

    @JvmStatic
    public static final int b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) b(context.getResources().getDisplayMetrics().heightPixels, bb0.a(context, "context").density);
    }

    @Deprecated(message = "")
    @JvmStatic
    public static final int a(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        return MathKt.roundToInt(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
    }

    @JvmStatic
    public static final int a(View view) {
        int iB;
        if (view == null || !view.isShown() || (iB = b(view)) <= 0) {
            return 0;
        }
        int width = view.getLayoutParams().width > 0 ? view.getLayoutParams().width : view.getWidth();
        int height = view.getLayoutParams().height > 0 ? view.getLayoutParams().height : view.getHeight();
        if (height <= 0 || width <= 0) {
            return 0;
        }
        return (iB * 100) / (height * width);
    }

    @JvmStatic
    public static final boolean a(View view, int i) {
        return a(view) >= i;
    }

    @JvmStatic
    public static final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (viewGroup.getParent() instanceof ViewGroup) {
                    ViewParent parent = viewGroup.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(viewGroup);
                }
            } catch (Exception unused) {
            }
            try {
                viewGroup.removeAllViews();
            } catch (Exception unused2) {
            }
        }
    }

    @JvmStatic
    public static final int a(Context context) {
        return bb0.a(context, "context").densityDpi;
    }

    @JvmStatic
    public static final int a(Context context, gf1 requestedOrientation) {
        gf1 gf1Var;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(requestedOrientation, "requestedOrientation");
        gf1 gf1VarA = hs.a(context);
        if (gf1VarA != requestedOrientation && gf1VarA != (gf1Var = gf1.e) && (requestedOrientation != gf1Var || gf1VarA == gf1.c)) {
            return c(context);
        }
        return b(context);
    }
}

package com.inmobi.media;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes7.dex */
public abstract class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f3030a;
    public EnumC3501o9 b;
    public float c;
    public boolean d;

    public B(RelativeLayout adBackgroundView) {
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.f3030a = adBackgroundView;
        this.b = AbstractC3515p9.a(AbstractC3565t3.g());
        this.c = 1.0f;
    }

    public abstract void a();

    public void a(EnumC3501o9 orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.b = orientation;
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public final void e() {
        C3551s3 c3551s3;
        C3551s3 c3551s4;
        RelativeLayout.LayoutParams layoutParams;
        if (this.c == 1.0f) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(10);
            this.f3030a.setLayoutParams(layoutParams2);
            return;
        }
        if (this.d) {
            C3579u3 c3579u3 = AbstractC3565t3.f3431a;
            Context context = this.f3030a.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Intrinsics.checkNotNullParameter(context, "context");
            Display displayA = AbstractC3565t3.a(context);
            if (displayA == null) {
                c3551s4 = AbstractC3565t3.b;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                displayA.getRealMetrics(displayMetrics);
                c3551s3 = new C3551s3(displayMetrics.widthPixels, displayMetrics.heightPixels);
                c3551s4 = c3551s3;
            }
        } else {
            C3579u3 c3579u4 = AbstractC3565t3.f3431a;
            Context context2 = this.f3030a.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            Intrinsics.checkNotNullParameter(context2, "context");
            Display displayA2 = AbstractC3565t3.a(context2);
            if (displayA2 == null) {
                c3551s4 = AbstractC3565t3.b;
            } else {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                displayA2.getMetrics(displayMetrics2);
                c3551s3 = new C3551s3(displayMetrics2.widthPixels, displayMetrics2.heightPixels);
                c3551s4 = c3551s3;
            }
        }
        Objects.toString(this.b);
        if (AbstractC3515p9.b(this.b)) {
            layoutParams = new RelativeLayout.LayoutParams(MathKt.roundToInt(c3551s4.f3423a * this.c), -1);
            layoutParams.addRule(9);
        } else {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, MathKt.roundToInt(c3551s4.b * this.c));
            layoutParams3.addRule(10);
            layoutParams = layoutParams3;
        }
        this.f3030a.setLayoutParams(layoutParams);
    }

    public abstract void f();

    public abstract void g();
}

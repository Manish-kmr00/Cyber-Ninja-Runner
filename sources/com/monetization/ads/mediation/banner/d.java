package com.monetization.ads.mediation.banner;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.ao1;
import com.yandex.mobile.ads.impl.jp0;
import com.yandex.mobile.ads.impl.sg2;
import com.yandex.mobile.ads.impl.ta;
import com.yandex.mobile.ads.impl.zn1;
import com.yandex.mobile.ads.impl.zy1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    static final /* synthetic */ KProperty<Object>[] d = {ta.a(d.class, "adView", "getAdView()Landroid/view/ViewGroup;", 0)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zy1 f7223a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final zn1 c;

    public interface a {
        void a();
    }

    public static final ViewGroup a(d dVar) {
        return (ViewGroup) dVar.c.getValue(dVar, d[0]);
    }

    public d(jp0 jp0Var, zy1 zy1Var) {
        this.f7223a = zy1Var;
        this.c = ao1.a(jp0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d this$0, View contentView, a contentViewShowListener) {
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contentView, "$contentView");
        Intrinsics.checkNotNullParameter(contentViewShowListener, "$contentViewShowListener");
        ViewGroup viewGroup = (ViewGroup) this$0.c.getValue(this$0, d[0]);
        if (viewGroup != null && viewGroup.indexOfChild(contentView) == -1) {
            zy1 zy1Var = this$0.f7223a;
            if (zy1Var == null) {
                layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            } else {
                int height = zy1Var.getHeight();
                float f = Resources.getSystem().getDisplayMetrics().density;
                if (height >= 0) {
                    height = MathKt.roundToInt(height * f);
                }
                int width = this$0.f7223a.getWidth();
                float f2 = Resources.getSystem().getDisplayMetrics().density;
                if (width >= 0) {
                    width = MathKt.roundToInt(width * f2);
                }
                contentView.measure(0, 0);
                int measuredHeight = contentView.getMeasuredHeight();
                layoutParams = new RelativeLayout.LayoutParams(Math.min(width, contentView.getMeasuredWidth()), Math.min(height, measuredHeight));
            }
            layoutParams.addRule(13);
            sg2.a(contentView);
            viewGroup.addView(contentView, layoutParams);
            viewGroup.setVisibility(0);
            contentView.setVisibility(0);
        }
        contentView.getViewTreeObserver().addOnPreDrawListener(new e(this$0, contentView, contentViewShowListener));
    }

    public final void a(final View contentView, final a contentViewShowListener) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(contentViewShowListener, "contentViewShowListener");
        this.b.post(new Runnable() { // from class: com.monetization.ads.mediation.banner.d$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                d.a(this.f$0, contentView, contentViewShowListener);
            }
        });
    }
}

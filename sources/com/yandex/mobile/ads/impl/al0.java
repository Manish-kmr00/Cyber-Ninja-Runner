package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.core.internal.view.SupportMenu;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class al0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wh2 f8416a;
    private final zl b;
    private final l10 c;
    private final WeakHashMap<FrameLayout, WeakReference<yl>> d;
    private final WeakHashMap<FrameLayout, WeakReference<cl0>> e;

    public final void a(FrameLayout adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        WeakReference<yl> weakReference = this.d.get(adView);
        yl ylVar = weakReference != null ? weakReference.get() : null;
        if (ylVar != null) {
            this.d.remove(adView);
            adView.removeView(ylVar);
        }
        WeakReference<cl0> weakReference2 = this.e.get(adView);
        cl0 cl0Var = weakReference2 != null ? weakReference2.get() : null;
        if (cl0Var != null) {
            this.e.remove(adView);
            adView.removeView(cl0Var);
        }
    }

    public /* synthetic */ al0() {
        this(new wh2(), new zl(), new l10());
    }

    public al0(wh2 descriptionCreator, zl borderViewManager, l10 dimensionConverter) {
        Intrinsics.checkNotNullParameter(descriptionCreator, "descriptionCreator");
        Intrinsics.checkNotNullParameter(borderViewManager, "borderViewManager");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        this.f8416a = descriptionCreator;
        this.b = borderViewManager;
        this.c = dimensionConverter;
        this.d = new WeakHashMap<>();
        this.e = new WeakHashMap<>();
    }

    public final void a(FrameLayout adView, f92 validationResult, boolean z) {
        cl0 cl0Var;
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        Intrinsics.checkNotNullParameter(adView, "adView");
        WeakReference<yl> weakReference = this.d.get(adView);
        yl borderView = weakReference != null ? weakReference.get() : null;
        if (borderView == null) {
            Context context = adView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            borderView = new yl(context, this.c, new b50());
            this.d.put(adView, new WeakReference<>(borderView));
            adView.addView(borderView);
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(borderView, "borderView");
        borderView.setColor(z ? SupportMenu.CATEGORY_MASK : -16711936);
        if (z) {
            WeakReference<cl0> weakReference2 = this.e.get(adView);
            cl0Var = weakReference2 != null ? weakReference2.get() : null;
            if (cl0Var == null) {
                Context context2 = adView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                cl0Var = new cl0(context2, new l10());
                this.e.put(adView, new WeakReference<>(cl0Var));
                adView.addView(cl0Var);
            }
            this.f8416a.getClass();
            cl0Var.setDescription(wh2.a(validationResult));
            return;
        }
        WeakReference<cl0> weakReference3 = this.e.get(adView);
        cl0Var = weakReference3 != null ? weakReference3.get() : null;
        if (cl0Var != null) {
            this.e.remove(adView);
            adView.removeView(cl0Var);
        }
    }
}

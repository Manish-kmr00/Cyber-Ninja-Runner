package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class va0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o3 f10467a;
    private final mp1 b;
    private final c71 c;
    private final l51 d;
    private final ua0 e;

    public va0(o3 adConfiguration, mp1 reporter, c71 nativeAdViewAdapter, l51 nativeAdEventController, ua0 feedbackMenuCreator) {
        Intrinsics.checkNotNullParameter(adConfiguration, "adConfiguration");
        Intrinsics.checkNotNullParameter(reporter, "reporter");
        Intrinsics.checkNotNullParameter(nativeAdViewAdapter, "nativeAdViewAdapter");
        Intrinsics.checkNotNullParameter(nativeAdEventController, "nativeAdEventController");
        Intrinsics.checkNotNullParameter(feedbackMenuCreator, "feedbackMenuCreator");
        this.f10467a = adConfiguration;
        this.b = reporter;
        this.c = nativeAdViewAdapter;
        this.d = nativeAdEventController;
        this.e = feedbackMenuCreator;
    }

    public final void a(Context context, la0 action) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(action, "action");
        View viewA = this.c.g().a("feedback");
        ImageView imageView = viewA instanceof ImageView ? (ImageView) viewA : null;
        if (imageView == null) {
            return;
        }
        List<la0.a> listC = action.c();
        if (listC.isEmpty()) {
            return;
        }
        try {
            v9 v9Var = new v9(context, this.f10467a);
            this.e.getClass();
            PopupMenu popupMenuA = ua0.a(context, imageView, listC);
            popupMenuA.setOnMenuItemClickListener(new ij1(v9Var, listC, this.b, this.d));
            popupMenuA.show();
        } catch (Exception e) {
            Object[] args = new Object[0];
            int i = op0.b;
            Intrinsics.checkNotNullParameter(args, "args");
            this.f10467a.q().c().reportError("Failed to render feedback", e);
        }
    }
}

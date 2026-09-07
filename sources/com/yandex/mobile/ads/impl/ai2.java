package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class ai2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bk2 f8409a;

    public final Rect a(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            int i = iw1.l;
            cu1 cu1VarA = iw1.a.a().a(context);
            if (cu1VarA == null || !cu1VarA.t0()) {
                return rect;
            }
            this.f8409a.getClass();
            Rect rectA = bk2.a(view);
            Rect rect2 = new Rect(rect);
            if (rect2.intersect(rectA)) {
                return rect2;
            }
        }
        return null;
    }

    public /* synthetic */ ai2() {
        this(new bk2());
    }

    public ai2(bk2 windowVisibleRectProvider) {
        Intrinsics.checkNotNullParameter(windowVisibleRectProvider, "windowVisibleRectProvider");
        this.f8409a = windowVisibleRectProvider;
    }
}

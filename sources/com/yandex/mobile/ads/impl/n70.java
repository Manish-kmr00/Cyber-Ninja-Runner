package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class n70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final qh2 f9704a;

    public final <T extends View & qh2.a> m70 a(T view) {
        int iA;
        Intrinsics.checkNotNullParameter(view, "view");
        this.f9704a.getClass();
        RectF rectF = null;
        if (qh2.a(view)) {
            iA = oh2.a(view);
            Rect rect = new Rect();
            if (view.getLocalVisibleRect(rect)) {
                rect.offset(view.getLeft(), view.getTop());
            } else {
                rect = null;
            }
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (rect != null) {
                float fA = oh2.a(context, rect.left);
                float fA2 = oh2.a(context, rect.top);
                float fA3 = oh2.a(context, rect.right);
                float fA4 = oh2.a(context, rect.bottom);
                float f = fA4 - fA2;
                if (fA3 - fA > 0.0f && f > 0.0f) {
                    rectF = new RectF(fA, fA2, fA3, fA4);
                }
            }
        } else {
            iA = 0;
        }
        return new m70(iA, rectF);
    }

    public /* synthetic */ n70() {
        this(new qh2());
    }

    public n70(qh2 viewableChecker) {
        Intrinsics.checkNotNullParameter(viewableChecker, "viewableChecker");
        this.f9704a = viewableChecker;
    }
}

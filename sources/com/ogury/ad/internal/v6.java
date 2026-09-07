package com.ogury.ad.internal;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z9 f7422a;
    public final k8 b;
    public final List<t6> c;

    public v6() {
        this(0);
    }

    public final e8 a(ViewGroup viewGroup, Rect rect) {
        this.f7422a.getClass();
        Rect containerRect = z9.a(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(containerRect, "containerRect");
        if (containerRect.height() <= viewGroup.getRootView().getHeight() * 0.4f) {
            return null;
        }
        Iterator<t6> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().a(rect, containerRect);
        }
        k8 k8Var = this.b;
        k8Var.getClass();
        Intrinsics.checkNotNullParameter(rect, "adLayoutRect");
        k8Var.c = new Rect(rect);
        rect.offset(-containerRect.left, -containerRect.top);
        Intrinsics.checkNotNullParameter(rect, "rect");
        int i = rect.left;
        int i2 = rect.top;
        int iWidth = rect.width();
        int iHeight = rect.height();
        e8 e8Var = new e8();
        e8Var.f7292a = false;
        e8Var.d = i;
        e8Var.e = i2;
        e8Var.b = iWidth;
        e8Var.c = iHeight;
        return e8Var;
    }

    public v6(int i) {
        z9 rectHelper = new z9();
        Configuration configuration = Resources.getSystem().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        k8 screenRotationAdjustment = new k8(configuration);
        Intrinsics.checkNotNullParameter(rectHelper, "rectHelper");
        Intrinsics.checkNotNullParameter(screenRotationAdjustment, "screenRotationAdjustment");
        this.f7422a = rectHelper;
        this.b = screenRotationAdjustment;
        this.c = CollectionsKt.listOf((Object[]) new t6[]{new n5(), new f2(), screenRotationAdjustment, new h2(1.0f)});
    }
}

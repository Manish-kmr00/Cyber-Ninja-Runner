package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class lu0 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9568a;
    private final float b;
    private final Context c;
    private final ou0.a d;

    public /* synthetic */ lu0(View view, float f, Context context) {
        this(view, f, context, new ou0.a());
    }

    public lu0(View view, float f, Context context, ou0.a measureSpecHolder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(measureSpecHolder, "measureSpecHolder");
        this.f9568a = view;
        this.b = f;
        this.c = context;
        this.d = measureSpecHolder;
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        Context context = this.c;
        int i3 = oh2.b;
        int iRound = Math.round(bb0.a(context, "context").heightPixels * this.b);
        ViewGroup.LayoutParams layoutParams = this.f9568a.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            iRound = (iRound - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        }
        int iMax = (int) Math.max(Math.min(size, iRound), 0.0d);
        ou0.a aVar = this.d;
        aVar.f9859a = i;
        aVar.b = View.MeasureSpec.makeMeasureSpec(iMax, mode);
        return this.d;
    }
}

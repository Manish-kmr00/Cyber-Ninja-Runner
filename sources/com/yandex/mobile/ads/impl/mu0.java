package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class mu0 implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f9670a;
    private final float b;
    private final Context c;
    private final ou0.a d;

    public mu0(View view, float f, Context context, ou0.a measureSpecHolder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(measureSpecHolder, "measureSpecHolder");
        this.f9670a = view;
        this.b = f;
        this.c = context;
        this.d = measureSpecHolder;
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        Context context = this.c;
        int i3 = oh2.b;
        int iRound = Math.round(bb0.a(context, "context").widthPixels * this.b);
        ViewGroup.LayoutParams layoutParams = this.f9670a.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "getLayoutParams(...)");
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            iRound = (iRound - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        this.d.f9859a = View.MeasureSpec.makeMeasureSpec((int) Math.max(Math.min(size, iRound), 0.0d), mode);
        ou0.a aVar = this.d;
        aVar.b = i2;
        return aVar;
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class qb implements ou0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10004a;
    private final i10 b;
    private final l10 c;
    private final Context d;

    public /* synthetic */ qb(Context context, boolean z, int i) {
        this(context, (i & 2) != 0 ? false : z, new i10(), new l10());
    }

    public qb(Context context, boolean z, i10 deviceTypeProvider, l10 dimensionConverter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceTypeProvider, "deviceTypeProvider");
        Intrinsics.checkNotNullParameter(dimensionConverter, "dimensionConverter");
        this.f10004a = z;
        this.b = deviceTypeProvider;
        this.c = dimensionConverter;
        this.d = context.getApplicationContext();
    }

    @Override // com.yandex.mobile.ads.impl.ou0
    public final ou0.a a(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode != 0) {
            Context context = this.d;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            int i3 = oh2.b;
            int iMin = bb0.a(context, "context").widthPixels;
            l10 l10Var = this.c;
            Context context2 = this.d;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            l10Var.getClass();
            int iA = l10.a(context2, 420.0f);
            int i4 = this.d.getResources().getConfiguration().orientation;
            i10 i10Var = this.b;
            Context context3 = this.d;
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            if (i10Var.a(context3) != h10.b || i4 != 1) {
                iMin = (int) Math.min(iMin, iA);
            }
            i = View.MeasureSpec.makeMeasureSpec((int) Math.min(iMin, size), 1073741824);
        }
        if (mode2 != 0) {
            boolean z = this.f10004a;
            Context context4 = this.d;
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            int i5 = oh2.b;
            int iMin2 = bb0.a(context4, "context").heightPixels;
            l10 l10Var2 = this.c;
            Context context5 = this.d;
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            l10Var2.getClass();
            int iA2 = l10.a(context5, 350.0f);
            if (!z) {
                iMin2 = (int) Math.min(iMin2, iA2);
            }
            i2 = View.MeasureSpec.makeMeasureSpec((int) Math.min(iMin2, size2), 1073741824);
        }
        ou0.a aVar = new ou0.a();
        aVar.b = i2;
        aVar.f9859a = i;
        return aVar;
    }
}

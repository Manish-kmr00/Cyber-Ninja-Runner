package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import androidx.core.view.ViewCompat;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes8.dex */
public final class s30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l10 f10164a = new l10();

    public final LayerDrawable a(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f10164a.getClass();
        int iA = l10.a(context, 6.0f);
        this.f10164a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt = MathKt.roundToInt(TypedValue.applyDimension(1, 4.0f, context.getResources().getDisplayMetrics()));
        this.f10164a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt2 = MathKt.roundToInt(TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics()));
        this.f10164a.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        int iRoundToInt3 = MathKt.roundToInt(TypedValue.applyDimension(1, 12.0f, context.getResources().getDisplayMetrics()));
        int i3 = ((i2 + 1) * iRoundToInt) + (iA * i2);
        float f = iRoundToInt3;
        RectF rectF = new RectF(0.0f, 0.0f, i3, f);
        float[] fArr = new float[8];
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            fArr[i5] = f;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(fArr, rectF, null));
        shapeDrawable.setIntrinsicWidth(i3);
        shapeDrawable.setIntrinsicHeight(iRoundToInt3);
        shapeDrawable.getPaint().setColor(ViewCompat.MEASURED_STATE_MASK);
        shapeDrawable.setAlpha(102);
        ShapeDrawable[] shapeDrawableArr = new ShapeDrawable[i2];
        for (int i6 = 0; i6 < i2; i6++) {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
            shapeDrawable2.setIntrinsicHeight(iA);
            shapeDrawable2.setIntrinsicWidth(iA);
            shapeDrawable2.getPaint().setColor(-1);
            if (i6 != i) {
                shapeDrawable2.setAlpha(102);
            }
            Unit unit = Unit.INSTANCE;
            shapeDrawableArr[i6] = shapeDrawable2;
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(shapeDrawable);
        spreadBuilder.addSpread(shapeDrawableArr);
        LayerDrawable layerDrawable = new LayerDrawable((Drawable[]) spreadBuilder.toArray(new ShapeDrawable[spreadBuilder.size()]));
        while (i4 < i2) {
            int i7 = iRoundToInt + iA;
            int i8 = i4 + 1;
            layerDrawable.setLayerInset(i8, (i7 * i4) + iRoundToInt, iRoundToInt2, i3 - (i7 * i8), iRoundToInt2);
            i4 = i8;
        }
        return layerDrawable;
    }
}

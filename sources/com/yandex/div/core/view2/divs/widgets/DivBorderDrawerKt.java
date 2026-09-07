package com.yandex.div.core.view2.divs.widgets;

import android.graphics.Canvas;
import android.util.DisplayMetrics;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivStroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBorderDrawer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0002\u001a\u00020\u0003*\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bH\u0080\bø\u0001\u0000\u001aB\u0010\t\u001a\u00020\u0003*\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\bH\u0080\bø\u0001\u0000\u001a\u001e\u0010\r\u001a\u00020\u0001*\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"STROKE_OFFSET_PERCENTAGE", "", "drawClipped", "", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderDrawer;", "canvas", "Landroid/graphics/Canvas;", "drawCallback", "Lkotlin/Function1;", "drawClippedAndTranslated", "translationX", "", "translationY", "widthPx", "Lcom/yandex/div2/DivStroke;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "metrics", "Landroid/util/DisplayMetrics;", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivBorderDrawerKt {
    private static final float STROKE_OFFSET_PERCENTAGE = 0.1f;

    /* JADX INFO: compiled from: DivBorderDrawer.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DivSizeUnit.values().length];
            try {
                iArr[DivSizeUnit.DP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DivSizeUnit.SP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DivSizeUnit.PX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float widthPx(DivStroke divStroke, ExpressionResolver expressionResolver, DisplayMetrics metrics) {
        double dDoubleValue;
        Expression<Double> expression;
        Expression<DivSizeUnit> expression2;
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        DivSizeUnit divSizeUnitEvaluate = (divStroke == null || (expression2 = divStroke.unit) == null) ? null : expression2.evaluate(expressionResolver);
        int i = divSizeUnitEvaluate == null ? -1 : WhenMappings.$EnumSwitchMapping$0[divSizeUnitEvaluate.ordinal()];
        if (i == 1) {
            return BaseDivViewExtensionsKt.dpToPxF(divStroke.width.evaluate(expressionResolver), metrics);
        }
        if (i == 2) {
            return BaseDivViewExtensionsKt.spToPxF(divStroke.width.evaluate(expressionResolver), metrics);
        }
        if (i == 3) {
            dDoubleValue = divStroke.width.evaluate(expressionResolver).doubleValue();
        } else {
            if (divStroke == null || (expression = divStroke.width) == null) {
                return 0.0f;
            }
            dDoubleValue = expression.evaluate(expressionResolver).doubleValue();
        }
        return (float) dDoubleValue;
    }

    public static /* synthetic */ void drawClippedAndTranslated$default(DivBorderDrawer divBorderDrawer, Canvas canvas, int i, int i2, Function1 drawCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawCallback, "drawCallback");
        if (divBorderDrawer == null) {
            drawCallback.invoke(canvas);
            return;
        }
        float f = i;
        float f2 = i2;
        int iSave = canvas.save();
        try {
            canvas.translate(f, f2);
            divBorderDrawer.clipCorners(canvas);
            canvas.translate(-f, -f2);
            drawCallback.invoke(canvas);
            canvas.translate(f, f2);
            divBorderDrawer.drawBorder(canvas);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restoreToCount(iSave);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void drawClippedAndTranslated(DivBorderDrawer divBorderDrawer, Canvas canvas, int i, int i2, Function1<? super Canvas, Unit> drawCallback) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawCallback, "drawCallback");
        if (divBorderDrawer == null) {
            drawCallback.invoke(canvas);
            return;
        }
        float f = i;
        float f2 = i2;
        int iSave = canvas.save();
        try {
            canvas.translate(f, f2);
            divBorderDrawer.clipCorners(canvas);
            canvas.translate(-f, -f2);
            drawCallback.invoke(canvas);
            canvas.translate(f, f2);
            divBorderDrawer.drawBorder(canvas);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restoreToCount(iSave);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void drawClipped(DivBorderDrawer divBorderDrawer, Canvas canvas, Function1<? super Canvas, Unit> drawCallback) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(drawCallback, "drawCallback");
        if (divBorderDrawer == null) {
            drawCallback.invoke(canvas);
            return;
        }
        int iSave = canvas.save();
        try {
            divBorderDrawer.clipCorners(canvas);
            drawCallback.invoke(canvas);
            divBorderDrawer.drawBorder(canvas);
        } finally {
            InlineMarker.finallyStart(1);
            canvas.restoreToCount(iSave);
            InlineMarker.finallyEnd(1);
        }
    }
}

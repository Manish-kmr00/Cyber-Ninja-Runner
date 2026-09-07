package com.yandex.div.core.view2.divs.widgets;

import android.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivBorderSupports.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u001a<\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u001a,\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u001a<\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0006H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"dispatchDrawBorderClipped", "", "Lcom/yandex/div/core/view2/divs/widgets/DivBorderSupports;", "canvas", "Landroid/graphics/Canvas;", "callback", "Lkotlin/Function1;", "dispatchDrawBorderClippedAndTranslated", "translationX", "", "translationY", "drawBorderClipped", "drawBorderClippedAndTranslated", "div_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DivBorderSupportsKt {
    public static final void drawBorderClipped(DivBorderSupports divBorderSupports, Canvas canvas, Function1<? super Canvas, Unit> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(divBorderSupports, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(callback, "callback");
        divBorderSupports.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divBorderSupports.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            int iSave = canvas.save();
            try {
                divBorderDrawer.clipCorners(canvas);
                callback.invoke(canvas);
                divBorderDrawer.drawBorder(canvas);
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                unit = Unit.INSTANCE;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(canvas);
        }
        divBorderSupports.setDrawing(false);
    }

    public static final void dispatchDrawBorderClipped(DivBorderSupports divBorderSupports, Canvas canvas, Function1<? super Canvas, Unit> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(divBorderSupports, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divBorderSupports.isDrawing()) {
            callback.invoke(canvas);
            return;
        }
        DivBorderDrawer divBorderDrawer = divBorderSupports.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            int iSave = canvas.save();
            try {
                divBorderDrawer.clipCorners(canvas);
                callback.invoke(canvas);
                divBorderDrawer.drawBorder(canvas);
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                unit = Unit.INSTANCE;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(canvas);
        }
    }

    public static final void dispatchDrawBorderClippedAndTranslated(DivBorderSupports divBorderSupports, Canvas canvas, int i, int i2, Function1<? super Canvas, Unit> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(divBorderSupports, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (divBorderSupports.isDrawing()) {
            callback.invoke(canvas);
            return;
        }
        DivBorderDrawer divBorderDrawer = divBorderSupports.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            float f = i;
            float f2 = i2;
            int iSave = canvas.save();
            try {
                canvas.translate(f, f2);
                divBorderDrawer.clipCorners(canvas);
                canvas.translate(-f, -f2);
                callback.invoke(canvas);
                canvas.translate(f, f2);
                divBorderDrawer.drawBorder(canvas);
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                unit = Unit.INSTANCE;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(canvas);
        }
    }

    public static final void drawBorderClippedAndTranslated(DivBorderSupports divBorderSupports, Canvas canvas, int i, int i2, Function1<? super Canvas, Unit> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(divBorderSupports, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(callback, "callback");
        divBorderSupports.setDrawing(true);
        DivBorderDrawer divBorderDrawer = divBorderSupports.getDivBorderDrawer();
        if (divBorderDrawer != null) {
            float f = i;
            float f2 = i2;
            int iSave = canvas.save();
            try {
                canvas.translate(f, f2);
                divBorderDrawer.clipCorners(canvas);
                canvas.translate(-f, -f2);
                callback.invoke(canvas);
                canvas.translate(f, f2);
                divBorderDrawer.drawBorder(canvas);
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                unit = Unit.INSTANCE;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                canvas.restoreToCount(iSave);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.invoke(canvas);
        }
        divBorderSupports.setDrawing(false);
    }
}

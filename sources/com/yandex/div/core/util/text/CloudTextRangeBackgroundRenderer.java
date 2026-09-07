package com.yandex.div.core.util.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.util.DisplayMetrics;
import androidx.compose.material.OutlinedTextFieldKt;
import com.safedk.android.analytics.reporters.b;
import com.yandex.div.core.view2.divs.BaseDivViewExtensionsKt;
import com.yandex.div.json.expressions.Expression;
import com.yandex.div.json.expressions.ExpressionResolver;
import com.yandex.div2.DivCloudBackground;
import com.yandex.div2.DivEdgeInsets;
import com.yandex.div2.DivSizeUnit;
import com.yandex.div2.DivTextRangeBackground;
import com.yandex.div2.DivTextRangeBorder;
import io.appmetrica.analytics.impl.J2;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CloudTextRangeBackgroundRenderer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 42\u00020\u0001:\u00014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0017JK\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010!J+\u0010\"\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0017J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u0015H\u0002J\u001b\u0010&\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010'J\u001b\u0010(\u001a\u00020$2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002¢\u0006\u0002\u0010'J@\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0002JL\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/2\b\u0010,\u001a\u0004\u0018\u000100H\u0016JE\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020+2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00152\b\b\u0001\u00102\u001a\u00020\u0015H\u0002¢\u0006\u0002\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/yandex/div/core/util/text/CloudTextRangeBackgroundRenderer;", "Lcom/yandex/div/core/util/text/DivTextRangesBackgroundRenderer;", "context", "Landroid/content/Context;", "expressionResolver", "Lcom/yandex/div/json/expressions/ExpressionResolver;", "(Landroid/content/Context;Lcom/yandex/div/json/expressions/ExpressionResolver;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "()Landroid/util/DisplayMetrics;", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "buildLeftSegments", "", b.d, "", "Landroid/graphics/Rect;", "start", "", "lineCount", "([Landroid/graphics/Rect;II)[I", "buildLines", "layout", "Landroid/text/Layout;", "startLine", "endLine", "startOffset", "endOffset", "cornerRadius", VastAttributes.PADDING, "(Landroid/text/Layout;IIIIILandroid/graphics/Rect;)[Landroid/graphics/Rect;", "buildRightSegments", "coalesceCloseBounds", "", "minDelta", "coalesceInvisibleLeftBounds", "([Landroid/graphics/Rect;)V", "coalesceInvisibleRightBounds", "draw", "canvas", "Landroid/graphics/Canvas;", J2.g, "Lcom/yandex/div2/DivCloudBackground;", OutlinedTextFieldKt.BorderId, "Lcom/yandex/div2/DivTextRangeBorder;", "Lcom/yandex/div2/DivTextRangeBackground;", "drawLines", "fillColor", "(Landroid/graphics/Canvas;[Landroid/graphics/Rect;IIII)V", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloudTextRangeBackgroundRenderer extends DivTextRangesBackgroundRenderer {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int OFFSET_SEGMENT_DELTA_X = 0;

    @Deprecated
    public static final int OFFSET_SEGMENT_DELTA_Y = 1;

    @Deprecated
    public static final int SEGMENT_VALUES = 2;
    private final Context context;
    private final ExpressionResolver expressionResolver;
    private final Paint paint;
    private final Path path;

    public CloudTextRangeBackgroundRenderer(Context context, ExpressionResolver expressionResolver) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(expressionResolver, "expressionResolver");
        this.context = context;
        this.expressionResolver = expressionResolver;
        this.path = new Path();
        this.paint = new Paint();
    }

    private final DisplayMetrics getDisplayMetrics() {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        return displayMetrics;
    }

    @Override // com.yandex.div.core.util.text.DivTextRangesBackgroundRenderer
    public void draw(Canvas canvas, Layout layout, int startLine, int endLine, int startOffset, int endOffset, DivTextRangeBorder border, DivTextRangeBackground background) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(layout, "layout");
        Object objValue = background != null ? background.value() : null;
        DivCloudBackground divCloudBackground = objValue instanceof DivCloudBackground ? (DivCloudBackground) objValue : null;
        if (divCloudBackground == null) {
            return;
        }
        draw(canvas, layout, startLine, endLine, startOffset, endOffset, divCloudBackground);
    }

    private final void draw(Canvas canvas, Layout layout, int startLine, int endLine, int startOffset, int endOffset, DivCloudBackground background) {
        DivSizeUnit divSizeUnitEvaluate;
        Expression<Long> expression;
        Expression<Long> expression2;
        Expression<Long> expression3;
        Expression<Long> expression4;
        Expression<DivSizeUnit> expression5;
        DisplayMetrics displayMetrics = getDisplayMetrics();
        int iIntValue = background.color.evaluate(this.expressionResolver).intValue();
        int iDpToPx = BaseDivViewExtensionsKt.dpToPx(background.cornerRadius.evaluate(this.expressionResolver), displayMetrics);
        DivEdgeInsets divEdgeInsets = background.paddings;
        if (divEdgeInsets == null || (expression5 = divEdgeInsets.unit) == null || (divSizeUnitEvaluate = expression5.evaluate(this.expressionResolver)) == null) {
            divSizeUnitEvaluate = DivSizeUnit.DP;
        }
        DivEdgeInsets divEdgeInsets2 = background.paddings;
        int iUnitToPx = (divEdgeInsets2 == null || (expression4 = divEdgeInsets2.left) == null) ? 0 : BaseDivViewExtensionsKt.unitToPx(Long.valueOf(expression4.evaluate(this.expressionResolver).longValue()), displayMetrics, divSizeUnitEvaluate);
        DivEdgeInsets divEdgeInsets3 = background.paddings;
        int iUnitToPx2 = (divEdgeInsets3 == null || (expression3 = divEdgeInsets3.top) == null) ? 0 : BaseDivViewExtensionsKt.unitToPx(Long.valueOf(expression3.evaluate(this.expressionResolver).longValue()), displayMetrics, divSizeUnitEvaluate);
        DivEdgeInsets divEdgeInsets4 = background.paddings;
        int iUnitToPx3 = (divEdgeInsets4 == null || (expression2 = divEdgeInsets4.right) == null) ? 0 : BaseDivViewExtensionsKt.unitToPx(Long.valueOf(expression2.evaluate(this.expressionResolver).longValue()), displayMetrics, divSizeUnitEvaluate);
        DivEdgeInsets divEdgeInsets5 = background.paddings;
        Rect[] rectArrBuildLines = buildLines(layout, startLine, endLine, startOffset, endOffset, iDpToPx, new Rect(iUnitToPx, iUnitToPx2, iUnitToPx3, (divEdgeInsets5 == null || (expression = divEdgeInsets5.bottom) == null) ? 0 : BaseDivViewExtensionsKt.unitToPx(Long.valueOf(expression.evaluate(this.expressionResolver).longValue()), displayMetrics, divSizeUnitEvaluate)));
        if (rectArrBuildLines.length < 2) {
            drawLines(canvas, rectArrBuildLines, 0, rectArrBuildLines.length, iDpToPx, iIntValue);
            return;
        }
        int length = rectArrBuildLines.length - 1;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = i + 1;
            if (rectArrBuildLines[i].left > rectArrBuildLines[i4].right) {
                drawLines(canvas, rectArrBuildLines, i2, i3, iDpToPx, iIntValue);
                i3 = 0;
                i2 = i4;
            }
            i3++;
            i = i4;
        }
        drawLines(canvas, rectArrBuildLines, i2, i3, iDpToPx, iIntValue);
    }

    private final void coalesceInvisibleLeftBounds(Rect[] lines) {
        int i;
        int length = lines.length;
        int i2 = ((Rect) ArraysKt.first(lines)).left;
        int i3 = ((Rect) ArraysKt.first(lines)).top;
        int length2 = lines.length;
        int i4 = 0;
        while (i4 < length2) {
            Rect rect = lines[i4];
            int i5 = rect.bottom - i3;
            i4++;
            int i6 = i4;
            while (true) {
                if (i6 >= length || lines[i6].top >= rect.bottom) {
                    i = Integer.MIN_VALUE;
                    break;
                } else {
                    if (lines[i6].left <= rect.left) {
                        i5 -= rect.bottom - lines[i6].top;
                        i = lines[i6].left;
                        break;
                    }
                    i6++;
                }
            }
            if (i5 <= 0) {
                rect.left = Math.max(i2, i);
                i5 = 0;
            } else {
                i2 = rect.left;
            }
            i3 += i5;
        }
    }

    private final void coalesceInvisibleRightBounds(Rect[] lines) {
        int i;
        int length = lines.length;
        int i2 = ((Rect) ArraysKt.first(lines)).right;
        int i3 = ((Rect) ArraysKt.first(lines)).top;
        int length2 = lines.length;
        int i4 = 0;
        while (i4 < length2) {
            Rect rect = lines[i4];
            int i5 = rect.bottom - i3;
            i4++;
            int i6 = i4;
            while (true) {
                if (i6 >= length || lines[i6].top >= rect.bottom) {
                    i = Integer.MAX_VALUE;
                    break;
                } else {
                    if (lines[i6].right >= rect.right) {
                        i5 -= rect.bottom - lines[i6].top;
                        i = lines[i6].right;
                        break;
                    }
                    i6++;
                }
            }
            if (i5 <= 0) {
                rect.right = Math.min(i2, i);
                i5 = 0;
            } else {
                i2 = rect.right;
            }
            i3 += i5;
        }
    }

    private final void coalesceCloseBounds(int[] lines, int minDelta) {
        boolean z;
        int i = 0;
        do {
            IntRange indices = i % 2 == 0 ? ArraysKt.getIndices(lines) : RangesKt.reversed(ArraysKt.getIndices(lines));
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                z = false;
                while (true) {
                    int i2 = first == 0 ? 0 : lines[first - 1] - lines[first];
                    int i3 = first == ArraysKt.getLastIndex(lines) ? 0 : lines[first + 1] - lines[first];
                    if ((i2 <= 0 || i2 >= minDelta) && (i3 <= 0 || i3 >= minDelta)) {
                        if (first != 0 && i2 < 0 && Math.abs(i2) < minDelta) {
                            lines[first - 1] = lines[first];
                            z = true;
                        }
                        if (first != ArraysKt.getLastIndex(lines) && i3 < 0 && Math.abs(i3) < minDelta) {
                            lines[first + 1] = lines[first];
                            z = true;
                        }
                    }
                    if (first == last) {
                        break;
                    } else {
                        first += step;
                    }
                }
            } else {
                z = false;
            }
            i++;
        } while (z);
    }

    private final void drawLines(Canvas canvas, Rect[] lines, int start, int lineCount, int cornerRadius, int fillColor) {
        float fMin;
        boolean z = true;
        if (lineCount < 1) {
            return;
        }
        Rect rect = lines[start];
        Rect rect2 = lines[(start + lineCount) - 1];
        int[] iArrBuildLeftSegments = buildLeftSegments(lines, start, lineCount);
        int[] iArrBuildRightSegments = buildRightSegments(lines, start, lineCount);
        this.path.reset();
        float f = cornerRadius;
        float f2 = 2.0f;
        float fMin2 = Math.min(f, Math.min(rect.width() / 2.0f, iArrBuildRightSegments[1] / 2.0f));
        this.path.moveTo(rect.right - fMin2, rect.top);
        this.path.rQuadTo(fMin2 * 0.9f, fMin2 * 0.1f, fMin2, fMin2);
        boolean z2 = false;
        int i = 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, iArrBuildRightSegments.length - 1, 2);
        float f3 = 0.0f;
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                boolean z3 = i2 >= iArrBuildRightSegments.length - i ? z : z2;
                float f4 = iArrBuildRightSegments[i2];
                float f5 = iArrBuildRightSegments[i2 + 1];
                float f6 = z3 ? f3 : iArrBuildRightSegments[i2 + 3];
                fMin = Math.min(f, Math.min(Math.abs(f4) / f2, f5 / f2));
                this.path.rLineTo(f3, (f5 - fMin2) - fMin);
                this.path.rQuadTo(Math.signum(f4) * fMin2 * 0.1f, fMin * 0.9f, fMin * Math.signum(f4), fMin);
                if (!z3) {
                    fMin2 = Math.min(f, Math.min(Math.abs(f4) / 2.0f, f6 / 2.0f));
                    this.path.rLineTo(f4 - ((fMin2 + fMin) * Math.signum(f4)), 0.0f);
                    this.path.rQuadTo(fMin2 * 0.9f * Math.signum(f4), fMin2 * 0.1f, Math.signum(f4) * fMin2, fMin2);
                }
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
                z = true;
                f2 = 2.0f;
                z2 = false;
                i = 2;
                f3 = 0.0f;
            }
        } else {
            fMin = 0.0f;
        }
        boolean z4 = true;
        float fMin3 = Math.min(f, Math.min(rect2.width() / 2.0f, (-iArrBuildLeftSegments[1]) / 2.0f));
        this.path.rLineTo((-rect2.width()) + fMin + fMin3, 0.0f);
        float f7 = -0.9f;
        float f8 = -fMin3;
        this.path.rQuadTo(fMin3 * (-0.9f), fMin3 * (-0.1f), f8, f8);
        int i3 = 2;
        boolean z5 = false;
        int progressionLastElement2 = ProgressionUtilKt.getProgressionLastElement(0, iArrBuildLeftSegments.length - 1, 2);
        if (progressionLastElement2 >= 0) {
            int i4 = 0;
            while (true) {
                boolean z6 = i4 >= iArrBuildLeftSegments.length - i3 ? z4 : z5;
                float f9 = iArrBuildLeftSegments[i4];
                float f10 = iArrBuildLeftSegments[i4 + 1];
                float f11 = z6 ? 0.0f : iArrBuildLeftSegments[i4 + 3];
                float fMin4 = Math.min(f, Math.min(Math.abs(f9) / 2.0f, (-f10) / 2.0f));
                this.path.rLineTo(0.0f, f10 + fMin3 + fMin4);
                this.path.rQuadTo(fMin4 * 0.1f * Math.signum(f9), fMin4 * f7, fMin4 * Math.signum(f9), -fMin4);
                if (!z6) {
                    fMin3 = Math.min(f, Math.min(Math.abs(f9) / 2.0f, (-f11) / 2.0f));
                    this.path.rLineTo(f9 - ((fMin4 + fMin3) * Math.signum(f9)), 0.0f);
                    this.path.rQuadTo(fMin3 * 0.9f * Math.signum(f9), fMin3 * (-0.1f), Math.signum(f9) * fMin3, -fMin3);
                }
                if (i4 == progressionLastElement2) {
                    break;
                }
                i4 += 2;
                z4 = true;
                f7 = -0.9f;
                i3 = 2;
                z5 = false;
            }
        }
        this.path.close();
        this.paint.setColor(fillColor);
        canvas.drawPath(this.path, this.paint);
    }

    private final int[] buildLeftSegments(Rect[] lines, int start, int lineCount) {
        int i = (start + lineCount) - 1;
        if (lineCount == 1) {
            return new int[]{lines[i].width(), -lines[i].height()};
        }
        int i2 = lines[i].left;
        int i3 = lines[i].bottom;
        int[] iArr = new int[lineCount * 2];
        int i4 = 0;
        if (start <= i) {
            int i5 = 0;
            while (true) {
                Rect rect = lines[i];
                if (rect.left != i2) {
                    iArr[i5 * 2] = rect.left - i2;
                    i2 = rect.left;
                    i5++;
                }
                int i6 = rect.top - i3;
                for (int i7 = i - 1; i7 >= start && lines[i7].bottom > rect.top; i7--) {
                    if (lines[i7].left <= rect.left) {
                        i6 -= rect.top - lines[i7].bottom;
                        break;
                    }
                }
                int iCoerceAtMost = RangesKt.coerceAtMost(i6, 0);
                int i8 = (i5 * 2) + 1;
                iArr[i8] = iArr[i8] + iCoerceAtMost;
                i3 += iCoerceAtMost;
                if (i == start) {
                    break;
                }
                i--;
            }
            i4 = i5;
        }
        iArr[i4 * 2] = lines[start].width();
        int[] iArrCopyOf = Arrays.copyOf(iArr, (i4 + 1) * 2);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    private final int[] buildRightSegments(Rect[] lines, int start, int lineCount) {
        int i = (start + lineCount) - 1;
        if (lineCount == 1) {
            return new int[]{-lines[start].width(), lines[start].height()};
        }
        int i2 = lines[start].right;
        int i3 = lines[start].top;
        int[] iArr = new int[lineCount * 2];
        int i4 = 0;
        if (start <= i) {
            int i5 = 0;
            while (true) {
                Rect rect = lines[start];
                if (rect.right != i2) {
                    iArr[i5 * 2] = rect.right - i2;
                    i2 = rect.right;
                    i5++;
                }
                int i6 = rect.bottom - i3;
                int i7 = start + 1;
                for (int i8 = i7; i8 <= i && lines[i8].top < rect.bottom; i8++) {
                    if (lines[i8].right >= rect.right) {
                        i6 -= rect.bottom - lines[i8].top;
                        break;
                    }
                }
                int iCoerceAtLeast = RangesKt.coerceAtLeast(i6, 0);
                int i9 = (i5 * 2) + 1;
                iArr[i9] = iArr[i9] + iCoerceAtLeast;
                i3 += iCoerceAtLeast;
                if (start == i) {
                    break;
                }
                start = i7;
            }
            i4 = i5;
        }
        iArr[i4 * 2] = -lines[i].width();
        int[] iArrCopyOf = Arrays.copyOf(iArr, (i4 + 1) * 2);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        return iArrCopyOf;
    }

    /* JADX INFO: compiled from: CloudTextRangeBackgroundRenderer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/util/text/CloudTextRangeBackgroundRenderer$Companion;", "", "()V", "OFFSET_SEGMENT_DELTA_X", "", "OFFSET_SEGMENT_DELTA_Y", "SEGMENT_VALUES", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final Rect[] buildLines(Layout layout, int startLine, int endLine, int startOffset, int endOffset, int cornerRadius, Rect padding) {
        int i = endLine - startLine;
        int i2 = i + 1;
        if (i2 != 0) {
            Rect[] rectArr = new Rect[i2];
            int i3 = 0;
            while (i3 < i2) {
                int i4 = startLine + i3;
                rectArr[i3] = new Rect((i3 == 0 ? startOffset : MathKt.roundToInt(layout.getLineLeft(startLine + i3))) - padding.left, layout.getLineTop(i4) - padding.top, (i3 == i ? endOffset : MathKt.roundToInt(layout.getLineRight(i4))) + padding.right, layout.getLineBottom(i4) + padding.bottom);
                i3++;
            }
            coalesceInvisibleLeftBounds(rectArr);
            coalesceInvisibleRightBounds(rectArr);
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                iArr[i5] = -rectArr[i5].left;
                iArr2[i5] = rectArr[i5].right;
            }
            int i6 = cornerRadius * 2;
            coalesceCloseBounds(iArr, i6);
            coalesceCloseBounds(iArr2, i6);
            for (int i7 = 0; i7 < i2; i7++) {
                rectArr[i7].left = -iArr[i7];
                rectArr[i7].right = iArr2[i7];
            }
            return rectArr;
        }
        return new Rect[0];
    }
}

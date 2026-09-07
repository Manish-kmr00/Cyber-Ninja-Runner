package com.yandex.div.internal.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ScalingDrawable.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003789B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020%H\u0002J\u0010\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020)H\u0016J\u000e\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u0018J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u000e\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u001aR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/yandex/div/internal/drawable/ScalingDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "alignmentHorizontal", "Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentHorizontal;", "getAlignmentHorizontal", "()Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentHorizontal;", "setAlignmentHorizontal", "(Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentHorizontal;)V", "alignmentVertical", "Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentVertical;", "getAlignmentVertical", "()Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentVertical;", "setAlignmentVertical", "(Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentVertical;)V", "customScaleType", "Lcom/yandex/div/internal/drawable/ScalingDrawable$ScaleType;", "getCustomScaleType", "()Lcom/yandex/div/internal/drawable/ScalingDrawable$ScaleType;", "setCustomScaleType", "(Lcom/yandex/div/internal/drawable/ScalingDrawable$ScaleType;)V", "isDirtyRect", "", "originalBitmap", "Landroid/graphics/Bitmap;", "originalPicture", "Landroid/graphics/Picture;", "paint", "Landroid/graphics/Paint;", "thumbTransformMatrix", "Landroid/graphics/Matrix;", "xScale", "", "xTranslate", "yScale", "yTranslate", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", TimerController.RESET_COMMAND, "setAlpha", "value", "setBitmap", "bitmap", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setPicture", "picture", "AlignmentHorizontal", "AlignmentVertical", "ScaleType", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ScalingDrawable extends Drawable {
    private boolean isDirtyRect;
    private Bitmap originalBitmap;
    private Picture originalPicture;
    private float xTranslate;
    private float yTranslate;
    private ScaleType customScaleType = ScaleType.NO_SCALE;
    private AlignmentHorizontal alignmentHorizontal = AlignmentHorizontal.LEFT;
    private AlignmentVertical alignmentVertical = AlignmentVertical.TOP;
    private final Paint paint = new Paint(3);
    private Matrix thumbTransformMatrix = new Matrix();
    private float xScale = 1.0f;
    private float yScale = 1.0f;

    /* JADX INFO: compiled from: ScalingDrawable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentHorizontal;", "", "(Ljava/lang/String;I)V", "LEFT", "CENTER", "RIGHT", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum AlignmentHorizontal {
        LEFT,
        CENTER,
        RIGHT
    }

    /* JADX INFO: compiled from: ScalingDrawable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/internal/drawable/ScalingDrawable$AlignmentVertical;", "", "(Ljava/lang/String;I)V", "TOP", "CENTER", "BOTTOM", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum AlignmentVertical {
        TOP,
        CENTER,
        BOTTOM
    }

    /* JADX INFO: compiled from: ScalingDrawable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/internal/drawable/ScalingDrawable$ScaleType;", "", "(Ljava/lang/String;I)V", "NO_SCALE", "FIT", "FILL", "STRETCH", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ScaleType {
        NO_SCALE,
        FIT,
        FILL,
        STRETCH
    }

    /* JADX INFO: compiled from: ScalingDrawable.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ScaleType.values().length];
            try {
                iArr[ScaleType.FILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScaleType.FIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ScaleType.NO_SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AlignmentHorizontal.values().length];
            try {
                iArr2[AlignmentHorizontal.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AlignmentHorizontal.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[AlignmentVertical.values().length];
            try {
                iArr3[AlignmentVertical.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[AlignmentVertical.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final ScaleType getCustomScaleType() {
        return this.customScaleType;
    }

    public final void setCustomScaleType(ScaleType scaleType) {
        Intrinsics.checkNotNullParameter(scaleType, "<set-?>");
        this.customScaleType = scaleType;
    }

    public final AlignmentHorizontal getAlignmentHorizontal() {
        return this.alignmentHorizontal;
    }

    public final void setAlignmentHorizontal(AlignmentHorizontal alignmentHorizontal) {
        Intrinsics.checkNotNullParameter(alignmentHorizontal, "<set-?>");
        this.alignmentHorizontal = alignmentHorizontal;
    }

    public final AlignmentVertical getAlignmentVertical() {
        return this.alignmentVertical;
    }

    public final void setAlignmentVertical(AlignmentVertical alignmentVertical) {
        Intrinsics.checkNotNullParameter(alignmentVertical, "<set-?>");
        this.alignmentVertical = alignmentVertical;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int value) {
        this.paint.setAlpha(value);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.paint.getAlpha();
    }

    public final void setBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.originalBitmap = bitmap;
        this.originalPicture = null;
        reset();
    }

    public final void setPicture(Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        this.originalPicture = picture;
        this.originalBitmap = null;
        reset();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        reset();
    }

    private final void reset() {
        this.isDirtyRect = true;
        invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int width;
        int height;
        float f;
        float f2;
        float f3;
        int i;
        float f4;
        float f5;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.save();
        Bitmap bitmap = this.originalBitmap;
        if (bitmap != null) {
            width = bitmap.getWidth();
        } else {
            Picture picture = this.originalPicture;
            width = picture != null ? picture.getWidth() : 0;
        }
        Bitmap bitmap2 = this.originalBitmap;
        if (bitmap2 != null) {
            height = bitmap2.getHeight();
        } else {
            Picture picture2 = this.originalPicture;
            height = picture2 != null ? picture2.getHeight() : 0;
        }
        if (height <= 0 || width <= 0) {
            Bitmap bitmap3 = this.originalBitmap;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, this.thumbTransformMatrix, this.paint);
            }
            Picture picture3 = this.originalPicture;
            if (picture3 != null) {
                canvas.drawPicture(picture3);
            }
            canvas.restore();
            return;
        }
        if (this.isDirtyRect) {
            float fWidth = getBounds().width();
            float fHeight = getBounds().height();
            float f6 = width;
            this.xScale = fWidth / f6;
            float f7 = height;
            this.yScale = fHeight / f7;
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.customScaleType.ordinal()];
            if (i2 == 1) {
                float fCoerceAtLeast = RangesKt.coerceAtLeast(this.xScale, this.yScale);
                this.xScale = fCoerceAtLeast;
                this.yScale = fCoerceAtLeast;
            } else if (i2 == 2) {
                float fCoerceAtMost = RangesKt.coerceAtMost(this.xScale, this.yScale);
                this.xScale = fCoerceAtMost;
                this.yScale = fCoerceAtMost;
            } else if (i2 == 3) {
                this.xScale = 1.0f;
                this.yScale = 1.0f;
            }
            float f8 = f6 * this.xScale;
            float f9 = f7 * this.yScale;
            int i3 = WhenMappings.$EnumSwitchMapping$1[this.alignmentHorizontal.ordinal()];
            float f10 = 0.0f;
            if (i3 != 1) {
                if (i3 != 2) {
                    f3 = 0.0f;
                } else {
                    f = fWidth - f8;
                    f2 = this.xScale;
                }
                this.xTranslate = f3;
                i = WhenMappings.$EnumSwitchMapping$2[this.alignmentVertical.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        f4 = fHeight - f9;
                        f5 = this.yScale;
                    }
                    this.yTranslate = f10;
                    this.isDirtyRect = false;
                } else {
                    f4 = (fHeight - f9) / 2;
                    f5 = this.yScale;
                }
                f10 = f4 / f5;
                this.yTranslate = f10;
                this.isDirtyRect = false;
            } else {
                f = (fWidth - f8) / 2;
                f2 = this.xScale;
            }
            f3 = f / f2;
            this.xTranslate = f3;
            i = WhenMappings.$EnumSwitchMapping$2[this.alignmentVertical.ordinal()];
            if (i != 1) {
                if (i == 2) {
                    f4 = fHeight - f9;
                    f5 = this.yScale;
                }
                this.yTranslate = f10;
                this.isDirtyRect = false;
            } else {
                f4 = (fHeight - f9) / 2;
                f5 = this.yScale;
            }
            f10 = f4 / f5;
            this.yTranslate = f10;
            this.isDirtyRect = false;
        }
        canvas.scale(this.xScale, this.yScale);
        canvas.translate(this.xTranslate, this.yTranslate);
        Bitmap bitmap4 = this.originalBitmap;
        if (bitmap4 != null) {
            canvas.drawBitmap(bitmap4, this.thumbTransformMatrix, this.paint);
        }
        Picture picture4 = this.originalPicture;
        if (picture4 != null) {
            canvas.drawPicture(picture4);
        }
        canvas.restore();
    }
}

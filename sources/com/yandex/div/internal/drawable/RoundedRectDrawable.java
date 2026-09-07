package com.yandex.div.internal.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.yandex.div.internal.Assert;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundedRectDrawable.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\u001d\u001a\u00020\b*\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/yandex/div/internal/drawable/RoundedRectDrawable;", "Landroid/graphics/drawable/Drawable;", "params", "Lcom/yandex/div/internal/drawable/RoundedRectDrawable$Params;", "(Lcom/yandex/div/internal/drawable/RoundedRectDrawable$Params;)V", "mainPaint", "Landroid/graphics/Paint;", "offset", "", "radiusX", "radiusY", "rect", "Landroid/graphics/RectF;", "strokeOffset", "strokePaint", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "", "getIntrinsicWidth", "getOpacity", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "setRectWithOffset", "considerSize", ContentDisposition.Parameters.Size, "Params", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RoundedRectDrawable extends Drawable {
    private final Paint mainPaint;
    private final float offset;
    private final Params params;
    private final float radiusX;
    private final float radiusY;
    private final RectF rect;
    private final float strokeOffset;
    private final Paint strokePaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    public RoundedRectDrawable(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.params = params;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(params.getColor());
        this.mainPaint = paint;
        this.radiusX = considerSize(params.getRadius(), params.getHeight());
        this.radiusY = considerSize(params.getRadius(), params.getWidth());
        RectF rectF = new RectF(0.0f, 0.0f, params.getWidth(), params.getHeight());
        this.rect = rectF;
        if (params.getStrokeColor() != null && params.getStrokeWidth() != null) {
            Paint paint2 = new Paint(1);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setColor(params.getStrokeColor().intValue());
            paint2.setStrokeWidth(params.getStrokeWidth().floatValue());
            this.strokePaint = paint2;
            this.strokeOffset = params.getStrokeWidth().floatValue() / 2;
            this.offset = 1.0f;
        } else {
            this.strokePaint = null;
            this.strokeOffset = 0.0f;
            this.offset = 0.0f;
        }
        Rect rect = new Rect();
        rectF.roundOut(rect);
        setBounds(rect);
    }

    /* JADX INFO: compiled from: RoundedRectDrawable.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014JN\u0010\u001d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/yandex/div/internal/drawable/RoundedRectDrawable$Params;", "", "width", "", "height", "color", "", "radius", "strokeColor", "strokeWidth", "(FFIFLjava/lang/Integer;Ljava/lang/Float;)V", "getColor", "()I", "getHeight", "()F", "getRadius", "getStrokeColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStrokeWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(FFIFLjava/lang/Integer;Ljava/lang/Float;)Lcom/yandex/div/internal/drawable/RoundedRectDrawable$Params;", "equals", "", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Params {
        private final int color;
        private final float height;
        private final float radius;
        private final Integer strokeColor;
        private final Float strokeWidth;
        private final float width;

        public static /* synthetic */ Params copy$default(Params params, float f, float f2, int i, float f3, Integer num, Float f4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f = params.width;
            }
            if ((i2 & 2) != 0) {
                f2 = params.height;
            }
            float f5 = f2;
            if ((i2 & 4) != 0) {
                i = params.color;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                f3 = params.radius;
            }
            float f6 = f3;
            if ((i2 & 16) != 0) {
                num = params.strokeColor;
            }
            Integer num2 = num;
            if ((i2 & 32) != 0) {
                f4 = params.strokeWidth;
            }
            return params.copy(f, f5, i3, f6, num2, f4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getWidth() {
            return this.width;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getHeight() {
            return this.height;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getColor() {
            return this.color;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final float getRadius() {
            return this.radius;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getStrokeColor() {
            return this.strokeColor;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final Params copy(float width, float height, int color, float radius, Integer strokeColor, Float strokeWidth) {
            return new Params(width, height, color, radius, strokeColor, strokeWidth);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Float.compare(this.width, params.width) == 0 && Float.compare(this.height, params.height) == 0 && this.color == params.color && Float.compare(this.radius, params.radius) == 0 && Intrinsics.areEqual(this.strokeColor, params.strokeColor) && Intrinsics.areEqual((Object) this.strokeWidth, (Object) params.strokeWidth);
        }

        public int hashCode() {
            int iHashCode = ((((((Float.hashCode(this.width) * 31) + Float.hashCode(this.height)) * 31) + Integer.hashCode(this.color)) * 31) + Float.hashCode(this.radius)) * 31;
            Integer num = this.strokeColor;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Float f = this.strokeWidth;
            return iHashCode2 + (f != null ? f.hashCode() : 0);
        }

        public String toString() {
            return "Params(width=" + this.width + ", height=" + this.height + ", color=" + this.color + ", radius=" + this.radius + ", strokeColor=" + this.strokeColor + ", strokeWidth=" + this.strokeWidth + ')';
        }

        public Params(float f, float f2, int i, float f3, Integer num, Float f4) {
            this.width = f;
            this.height = f2;
            this.color = i;
            this.radius = f3;
            this.strokeColor = num;
            this.strokeWidth = f4;
        }

        public /* synthetic */ Params(float f, float f2, int i, float f3, Integer num, Float f4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, f2, i, f3, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? null : f4);
        }

        public final float getWidth() {
            return this.width;
        }

        public final float getHeight() {
            return this.height;
        }

        public final int getColor() {
            return this.color;
        }

        public final float getRadius() {
            return this.radius;
        }

        public final Integer getStrokeColor() {
            return this.strokeColor;
        }

        public final Float getStrokeWidth() {
            return this.strokeWidth;
        }
    }

    private final float considerSize(float f, float f2) {
        return f - (f >= f2 / ((float) 2) ? this.strokeOffset : 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.params.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.params.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        setRectWithOffset(this.offset);
        canvas.drawRoundRect(this.rect, this.radiusX, this.radiusY, this.mainPaint);
        Paint paint = this.strokePaint;
        if (paint != null) {
            setRectWithOffset(this.strokeOffset);
            canvas.drawRoundRect(this.rect, this.params.getRadius(), this.params.getRadius(), paint);
        }
    }

    private final void setRectWithOffset(float offset) {
        Rect bounds = getBounds();
        this.rect.set(bounds.left + offset, bounds.top + offset, bounds.right - offset, bounds.bottom - offset);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Assert.fail("Setting alpha is not implemented");
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Assert.fail("Setting color filter is not implemented");
    }
}

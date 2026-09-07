package com.yandex.div.internal.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RadialGradientDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 +2\u00020\u0001:\u0003*+,B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0014J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020!H\u0016J\u0012\u0010'\u001a\u00020\u001d2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable;", "Landroid/graphics/drawable/Drawable;", "radius", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "centerX", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "centerY", "colors", "", "(Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;[I)V", "getCenterX", "()Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "setCenterX", "(Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;)V", "getCenterY", "setCenterY", "getColors", "()[I", "setColors", "([I)V", "paint", "Landroid/graphics/Paint;", "getRadius", "()Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "setRadius", "(Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;)V", "rect", "Landroid/graphics/RectF;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Center", "Companion", "Radius", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RadialGradientDrawable extends Drawable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MIN_GRADIENT_RADIUS = 0.01f;
    private Center centerX;
    private Center centerY;
    private int[] colors;
    private final Paint paint;
    private Radius radius;
    private RectF rect;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public final void setRadius(Radius radius) {
        Intrinsics.checkNotNullParameter(radius, "<set-?>");
        this.radius = radius;
    }

    public final Center getCenterX() {
        return this.centerX;
    }

    public final void setCenterX(Center center) {
        Intrinsics.checkNotNullParameter(center, "<set-?>");
        this.centerX = center;
    }

    public final Center getCenterY() {
        return this.centerY;
    }

    public final void setCenterY(Center center) {
        Intrinsics.checkNotNullParameter(center, "<set-?>");
        this.centerY = center;
    }

    public final int[] getColors() {
        return this.colors;
    }

    public final void setColors(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.colors = iArr;
    }

    public RadialGradientDrawable(Radius radius, Center centerX, Center centerY, int[] colors) {
        Intrinsics.checkNotNullParameter(radius, "radius");
        Intrinsics.checkNotNullParameter(centerX, "centerX");
        Intrinsics.checkNotNullParameter(centerY, "centerY");
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
        this.colors = colors;
        this.paint = new Paint();
        this.rect = new RectF();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        this.paint.setShader(INSTANCE.createRadialGradient(this.radius, this.centerX, this.centerY, this.colors, bounds.width(), bounds.height()));
        this.rect.set(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.paint.getAlpha();
    }

    /* JADX INFO: compiled from: RadialGradientDrawable.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011²\u0006\u0010\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013X\u008a\u0084\u0002²\u0006\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013X\u008a\u0084\u0002"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Companion;", "", "()V", "MIN_GRADIENT_RADIUS", "", "createRadialGradient", "Landroid/graphics/RadialGradient;", "radius", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "centerX", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "centerY", "colors", "", "width", "", "height", "div_release", "distancesToCorners", "", "distancesToSides"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: RadialGradientDrawable.kt */
        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Radius.Relative.Type.values().length];
                try {
                    iArr[Radius.Relative.Type.NEAREST_CORNER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Radius.Relative.Type.FARTHEST_CORNER.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Radius.Relative.Type.NEAREST_SIDE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Radius.Relative.Type.FARTHEST_SIDE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private static final float createRadialGradient$value(Center center, int i) {
            if (center instanceof Center.Fixed) {
                return ((Center.Fixed) center).getValue();
            }
            if (center instanceof Center.Relative) {
                return ((Center.Relative) center).getValue() * i;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final RadialGradient createRadialGradient(Radius radius, Center centerX, Center centerY, int[] colors, int width, int height) {
            float fFloatValue;
            Intrinsics.checkNotNullParameter(radius, "radius");
            Intrinsics.checkNotNullParameter(centerX, "centerX");
            Intrinsics.checkNotNullParameter(centerY, "centerY");
            Intrinsics.checkNotNullParameter(colors, "colors");
            final float fCreateRadialGradient$value = createRadialGradient$value(centerX, width);
            final float fCreateRadialGradient$value2 = createRadialGradient$value(centerY, height);
            final float f = width;
            final float f2 = height;
            final float f3 = 0.0f;
            final float f4 = 0.0f;
            Lazy lazy = LazyKt.lazy(new Function0<Float[]>() { // from class: com.yandex.div.internal.drawable.RadialGradientDrawable$Companion$createRadialGradient$distancesToCorners$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float[] invoke() {
                    return new Float[]{Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distTo(fCreateRadialGradient$value, fCreateRadialGradient$value2, f3, f4)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distTo(fCreateRadialGradient$value, fCreateRadialGradient$value2, f, f4)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distTo(fCreateRadialGradient$value, fCreateRadialGradient$value2, f, f2)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distTo(fCreateRadialGradient$value, fCreateRadialGradient$value2, f3, f2))};
                }
            });
            Lazy lazy2 = LazyKt.lazy(new Function0<Float[]>() { // from class: com.yandex.div.internal.drawable.RadialGradientDrawable$Companion$createRadialGradient$distancesToSides$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float[] invoke() {
                    return new Float[]{Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distToVerticalSide(fCreateRadialGradient$value, f3)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distToVerticalSide(fCreateRadialGradient$value, f)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distToHorizontalSide(fCreateRadialGradient$value2, f2)), Float.valueOf(RadialGradientDrawable.Companion.createRadialGradient$distToHorizontalSide(fCreateRadialGradient$value2, f4))};
                }
            });
            if (radius instanceof Radius.Fixed) {
                fFloatValue = ((Radius.Fixed) radius).getValue();
            } else if (radius instanceof Radius.Relative) {
                int i = WhenMappings.$EnumSwitchMapping$0[((Radius.Relative) radius).getType().ordinal()];
                if (i == 1) {
                    Float fMinOrNull = ArraysKt.minOrNull(createRadialGradient$lambda$0(lazy));
                    Intrinsics.checkNotNull(fMinOrNull);
                    fFloatValue = fMinOrNull.floatValue();
                } else if (i == 2) {
                    Float fMaxOrNull = ArraysKt.maxOrNull(createRadialGradient$lambda$0(lazy));
                    Intrinsics.checkNotNull(fMaxOrNull);
                    fFloatValue = fMaxOrNull.floatValue();
                } else if (i == 3) {
                    Float fMinOrNull2 = ArraysKt.minOrNull(createRadialGradient$lambda$1(lazy2));
                    Intrinsics.checkNotNull(fMinOrNull2);
                    fFloatValue = fMinOrNull2.floatValue();
                } else {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Float fMaxOrNull2 = ArraysKt.maxOrNull(createRadialGradient$lambda$1(lazy2));
                    Intrinsics.checkNotNull(fMaxOrNull2);
                    fFloatValue = fMaxOrNull2.floatValue();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (fFloatValue <= 0.0f) {
                fFloatValue = 0.01f;
            }
            return new RadialGradient(fCreateRadialGradient$value, fCreateRadialGradient$value2, fFloatValue, colors, (float[]) null, Shader.TileMode.CLAMP);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float createRadialGradient$distTo(float f, float f2, float f3, float f4) {
            double d = 2;
            return (float) Math.sqrt(((float) Math.pow(f - f3, d)) + ((float) Math.pow(f2 - f4, d)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float createRadialGradient$distToVerticalSide(float f, float f2) {
            return Math.abs(f - f2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float createRadialGradient$distToHorizontalSide(float f, float f2) {
            return Math.abs(f - f2);
        }

        private static final Float[] createRadialGradient$lambda$0(Lazy<Float[]> lazy) {
            return lazy.getValue();
        }

        private static final Float[] createRadialGradient$lambda$1(Lazy<Float[]> lazy) {
            return lazy.getValue();
        }
    }

    /* JADX INFO: compiled from: RadialGradientDrawable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "", "()V", "Fixed", "Relative", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Fixed;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Radius {
        public /* synthetic */ Radius(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RadialGradientDrawable.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "type", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative$Type;", "(Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative$Type;)V", "getType", "()Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative$Type;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Type", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Relative extends Radius {
            private final Type type;

            /* JADX INFO: compiled from: RadialGradientDrawable.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Relative$Type;", "", "(Ljava/lang/String;I)V", "NEAREST_CORNER", "FARTHEST_CORNER", "NEAREST_SIDE", "FARTHEST_SIDE", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            public enum Type {
                NEAREST_CORNER,
                FARTHEST_CORNER,
                NEAREST_SIDE,
                FARTHEST_SIDE
            }

            public static /* synthetic */ Relative copy$default(Relative relative, Type type, int i, Object obj) {
                if ((i & 1) != 0) {
                    type = relative.type;
                }
                return relative.copy(type);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Type getType() {
                return this.type;
            }

            public final Relative copy(Type type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new Relative(type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Relative) && this.type == ((Relative) other).type;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "Relative(type=" + this.type + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Relative(Type type) {
                super(null);
                Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
            }

            public final Type getType() {
                return this.type;
            }
        }

        private Radius() {
        }

        /* JADX INFO: compiled from: RadialGradientDrawable.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius$Fixed;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Radius;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Fixed extends Radius {
            private final float value;

            public static /* synthetic */ Fixed copy$default(Fixed fixed, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fixed.value;
                }
                return fixed.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getValue() {
                return this.value;
            }

            public final Fixed copy(float value) {
                return new Fixed(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fixed) && Float.compare(this.value, ((Fixed) other).value) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.value);
            }

            public String toString() {
                return "Fixed(value=" + this.value + ')';
            }

            public Fixed(float f) {
                super(null);
                this.value = f;
            }

            public final float getValue() {
                return this.value;
            }
        }
    }

    /* JADX INFO: compiled from: RadialGradientDrawable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "", "()V", "Fixed", "Relative", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center$Fixed;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center$Relative;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Center {
        public /* synthetic */ Center(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RadialGradientDrawable.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center$Relative;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Relative extends Center {
            private final float value;

            public static /* synthetic */ Relative copy$default(Relative relative, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = relative.value;
                }
                return relative.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getValue() {
                return this.value;
            }

            public final Relative copy(float value) {
                return new Relative(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Relative) && Float.compare(this.value, ((Relative) other).value) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.value);
            }

            public String toString() {
                return "Relative(value=" + this.value + ')';
            }

            public Relative(float f) {
                super(null);
                this.value = f;
            }

            public final float getValue() {
                return this.value;
            }
        }

        private Center() {
        }

        /* JADX INFO: compiled from: RadialGradientDrawable.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center$Fixed;", "Lcom/yandex/div/internal/drawable/RadialGradientDrawable$Center;", "value", "", "(F)V", "getValue", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Fixed extends Center {
            private final float value;

            public static /* synthetic */ Fixed copy$default(Fixed fixed, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = fixed.value;
                }
                return fixed.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getValue() {
                return this.value;
            }

            public final Fixed copy(float value) {
                return new Fixed(value);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Fixed) && Float.compare(this.value, ((Fixed) other).value) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.value);
            }

            public String toString() {
                return "Fixed(value=" + this.value + ')';
            }

            public Fixed(float f) {
                super(null);
                this.value = f;
            }

            public final float getValue() {
                return this.value;
            }
        }
    }
}

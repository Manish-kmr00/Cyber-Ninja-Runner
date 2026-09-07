package com.yandex.div.internal.widget.indicator;

import androidx.webkit.Profile;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndicatorParams.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\b"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams;", "", "()V", "Animation", "ItemPlacement", "ItemSize", "Shape", "Style", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IndicatorParams {

    /* JADX INFO: compiled from: IndicatorParams.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Animation;", "", "(Ljava/lang/String;I)V", "SCALE", "WORM", "SLIDER", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Animation {
        SCALE,
        WORM,
        SLIDER
    }

    /* JADX INFO: compiled from: IndicatorParams.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Style;", "", "animation", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Animation;", "activeShape", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "inactiveShape", "minimumShape", "itemsPlacement", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;", "(Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Animation;Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;)V", "getActiveShape", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "getAnimation", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Animation;", "getInactiveShape", "getItemsPlacement", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;", "getMinimumShape", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Style {
        private final Shape activeShape;
        private final Animation animation;
        private final Shape inactiveShape;
        private final ItemPlacement itemsPlacement;
        private final Shape minimumShape;

        public static /* synthetic */ Style copy$default(Style style, Animation animation, Shape shape, Shape shape2, Shape shape3, ItemPlacement itemPlacement, int i, Object obj) {
            if ((i & 1) != 0) {
                animation = style.animation;
            }
            if ((i & 2) != 0) {
                shape = style.activeShape;
            }
            Shape shape4 = shape;
            if ((i & 4) != 0) {
                shape2 = style.inactiveShape;
            }
            Shape shape5 = shape2;
            if ((i & 8) != 0) {
                shape3 = style.minimumShape;
            }
            Shape shape6 = shape3;
            if ((i & 16) != 0) {
                itemPlacement = style.itemsPlacement;
            }
            return style.copy(animation, shape4, shape5, shape6, itemPlacement);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Animation getAnimation() {
            return this.animation;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Shape getActiveShape() {
            return this.activeShape;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Shape getInactiveShape() {
            return this.inactiveShape;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Shape getMinimumShape() {
            return this.minimumShape;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ItemPlacement getItemsPlacement() {
            return this.itemsPlacement;
        }

        public final Style copy(Animation animation, Shape activeShape, Shape inactiveShape, Shape minimumShape, ItemPlacement itemsPlacement) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNullParameter(activeShape, "activeShape");
            Intrinsics.checkNotNullParameter(inactiveShape, "inactiveShape");
            Intrinsics.checkNotNullParameter(minimumShape, "minimumShape");
            Intrinsics.checkNotNullParameter(itemsPlacement, "itemsPlacement");
            return new Style(animation, activeShape, inactiveShape, minimumShape, itemsPlacement);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Style)) {
                return false;
            }
            Style style = (Style) other;
            return this.animation == style.animation && Intrinsics.areEqual(this.activeShape, style.activeShape) && Intrinsics.areEqual(this.inactiveShape, style.inactiveShape) && Intrinsics.areEqual(this.minimumShape, style.minimumShape) && Intrinsics.areEqual(this.itemsPlacement, style.itemsPlacement);
        }

        public int hashCode() {
            return (((((((this.animation.hashCode() * 31) + this.activeShape.hashCode()) * 31) + this.inactiveShape.hashCode()) * 31) + this.minimumShape.hashCode()) * 31) + this.itemsPlacement.hashCode();
        }

        public String toString() {
            return "Style(animation=" + this.animation + ", activeShape=" + this.activeShape + ", inactiveShape=" + this.inactiveShape + ", minimumShape=" + this.minimumShape + ", itemsPlacement=" + this.itemsPlacement + ')';
        }

        public Style(Animation animation, Shape activeShape, Shape inactiveShape, Shape minimumShape, ItemPlacement itemsPlacement) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNullParameter(activeShape, "activeShape");
            Intrinsics.checkNotNullParameter(inactiveShape, "inactiveShape");
            Intrinsics.checkNotNullParameter(minimumShape, "minimumShape");
            Intrinsics.checkNotNullParameter(itemsPlacement, "itemsPlacement");
            this.animation = animation;
            this.activeShape = activeShape;
            this.inactiveShape = inactiveShape;
            this.minimumShape = minimumShape;
            this.itemsPlacement = itemsPlacement;
        }

        public final Animation getAnimation() {
            return this.animation;
        }

        public final Shape getActiveShape() {
            return this.activeShape;
        }

        public final Shape getInactiveShape() {
            return this.inactiveShape;
        }

        public final Shape getMinimumShape() {
            return this.minimumShape;
        }

        public final ItemPlacement getItemsPlacement() {
            return this.itemsPlacement;
        }
    }

    /* JADX INFO: compiled from: IndicatorParams.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "", "()V", "borderColor", "", "getBorderColor", "()I", "borderWidth", "", "getBorderWidth", "()F", "color", "getColor", "itemSize", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "getItemSize", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "Circle", "RoundedRect", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape$Circle;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape$RoundedRect;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Shape {
        public /* synthetic */ Shape(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getColor();

        public abstract ItemSize getItemSize();

        private Shape() {
        }

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape$RoundedRect;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "color", "", "itemSize", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$RoundedRect;", "strokeWidth", "", "strokeColor", "(ILcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$RoundedRect;FI)V", "getColor", "()I", "getItemSize", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$RoundedRect;", "getStrokeColor", "getStrokeWidth", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class RoundedRect extends Shape {
            private final int color;
            private final ItemSize.RoundedRect itemSize;
            private final int strokeColor;
            private final float strokeWidth;

            public static /* synthetic */ RoundedRect copy$default(RoundedRect roundedRect, int i, ItemSize.RoundedRect roundedRect2, float f, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = roundedRect.color;
                }
                if ((i3 & 2) != 0) {
                    roundedRect2 = roundedRect.itemSize;
                }
                if ((i3 & 4) != 0) {
                    f = roundedRect.strokeWidth;
                }
                if ((i3 & 8) != 0) {
                    i2 = roundedRect.strokeColor;
                }
                return roundedRect.copy(i, roundedRect2, f, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemSize.RoundedRect getItemSize() {
                return this.itemSize;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getStrokeWidth() {
                return this.strokeWidth;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getStrokeColor() {
                return this.strokeColor;
            }

            public final RoundedRect copy(int color, ItemSize.RoundedRect itemSize, float strokeWidth, int strokeColor) {
                Intrinsics.checkNotNullParameter(itemSize, "itemSize");
                return new RoundedRect(color, itemSize, strokeWidth, strokeColor);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RoundedRect)) {
                    return false;
                }
                RoundedRect roundedRect = (RoundedRect) other;
                return this.color == roundedRect.color && Intrinsics.areEqual(this.itemSize, roundedRect.itemSize) && Float.compare(this.strokeWidth, roundedRect.strokeWidth) == 0 && this.strokeColor == roundedRect.strokeColor;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.color) * 31) + this.itemSize.hashCode()) * 31) + Float.hashCode(this.strokeWidth)) * 31) + Integer.hashCode(this.strokeColor);
            }

            public String toString() {
                return "RoundedRect(color=" + this.color + ", itemSize=" + this.itemSize + ", strokeWidth=" + this.strokeWidth + ", strokeColor=" + this.strokeColor + ')';
            }

            @Override // com.yandex.div.internal.widget.indicator.IndicatorParams.Shape
            public int getColor() {
                return this.color;
            }

            @Override // com.yandex.div.internal.widget.indicator.IndicatorParams.Shape
            public ItemSize.RoundedRect getItemSize() {
                return this.itemSize;
            }

            public final float getStrokeWidth() {
                return this.strokeWidth;
            }

            public final int getStrokeColor() {
                return this.strokeColor;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoundedRect(int i, ItemSize.RoundedRect itemSize, float f, int i2) {
                super(null);
                Intrinsics.checkNotNullParameter(itemSize, "itemSize");
                this.color = i;
                this.itemSize = itemSize;
                this.strokeWidth = f;
                this.strokeColor = i2;
            }
        }

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape$Circle;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$Shape;", "color", "", "itemSize", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$Circle;", "(ILcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$Circle;)V", "getColor", "()I", "getItemSize", "()Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$Circle;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Circle extends Shape {
            private final int color;
            private final ItemSize.Circle itemSize;

            public static /* synthetic */ Circle copy$default(Circle circle, int i, ItemSize.Circle circle2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = circle.color;
                }
                if ((i2 & 2) != 0) {
                    circle2 = circle.itemSize;
                }
                return circle.copy(i, circle2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getColor() {
                return this.color;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemSize.Circle getItemSize() {
                return this.itemSize;
            }

            public final Circle copy(int color, ItemSize.Circle itemSize) {
                Intrinsics.checkNotNullParameter(itemSize, "itemSize");
                return new Circle(color, itemSize);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Circle)) {
                    return false;
                }
                Circle circle = (Circle) other;
                return this.color == circle.color && Intrinsics.areEqual(this.itemSize, circle.itemSize);
            }

            public int hashCode() {
                return (Integer.hashCode(this.color) * 31) + this.itemSize.hashCode();
            }

            public String toString() {
                return "Circle(color=" + this.color + ", itemSize=" + this.itemSize + ')';
            }

            @Override // com.yandex.div.internal.widget.indicator.IndicatorParams.Shape
            public int getColor() {
                return this.color;
            }

            @Override // com.yandex.div.internal.widget.indicator.IndicatorParams.Shape
            public ItemSize.Circle getItemSize() {
                return this.itemSize;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Circle(int i, ItemSize.Circle itemSize) {
                super(null);
                Intrinsics.checkNotNullParameter(itemSize, "itemSize");
                this.color = i;
                this.itemSize = itemSize;
            }
        }

        public final float getBorderWidth() {
            if (this instanceof RoundedRect) {
                return ((RoundedRect) this).getStrokeWidth();
            }
            return 0.0f;
        }

        public final int getBorderColor() {
            if (this instanceof RoundedRect) {
                return ((RoundedRect) this).getStrokeColor();
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: IndicatorParams.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0082\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "", "()V", "height", "", "getHeight", "()F", "width", "getWidth", "Circle", "RoundedRect", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$Circle;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$RoundedRect;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class ItemSize {
        public /* synthetic */ ItemSize(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private ItemSize() {
        }

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$RoundedRect;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "itemWidth", "", "itemHeight", "cornerRadius", "(FFF)V", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "getItemHeight", "setItemHeight", "getItemWidth", "setItemWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class RoundedRect extends ItemSize {
            private float cornerRadius;
            private float itemHeight;
            private float itemWidth;

            public static /* synthetic */ RoundedRect copy$default(RoundedRect roundedRect, float f, float f2, float f3, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = roundedRect.itemWidth;
                }
                if ((i & 2) != 0) {
                    f2 = roundedRect.itemHeight;
                }
                if ((i & 4) != 0) {
                    f3 = roundedRect.cornerRadius;
                }
                return roundedRect.copy(f, f2, f3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getItemWidth() {
                return this.itemWidth;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final float getItemHeight() {
                return this.itemHeight;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getCornerRadius() {
                return this.cornerRadius;
            }

            public final RoundedRect copy(float itemWidth, float itemHeight, float cornerRadius) {
                return new RoundedRect(itemWidth, itemHeight, cornerRadius);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RoundedRect)) {
                    return false;
                }
                RoundedRect roundedRect = (RoundedRect) other;
                return Float.compare(this.itemWidth, roundedRect.itemWidth) == 0 && Float.compare(this.itemHeight, roundedRect.itemHeight) == 0 && Float.compare(this.cornerRadius, roundedRect.cornerRadius) == 0;
            }

            public int hashCode() {
                return (((Float.hashCode(this.itemWidth) * 31) + Float.hashCode(this.itemHeight)) * 31) + Float.hashCode(this.cornerRadius);
            }

            public String toString() {
                return "RoundedRect(itemWidth=" + this.itemWidth + ", itemHeight=" + this.itemHeight + ", cornerRadius=" + this.cornerRadius + ')';
            }

            public final float getItemWidth() {
                return this.itemWidth;
            }

            public final void setItemWidth(float f) {
                this.itemWidth = f;
            }

            public final float getItemHeight() {
                return this.itemHeight;
            }

            public final void setItemHeight(float f) {
                this.itemHeight = f;
            }

            public final float getCornerRadius() {
                return this.cornerRadius;
            }

            public final void setCornerRadius(float f) {
                this.cornerRadius = f;
            }

            public RoundedRect(float f, float f2, float f3) {
                super(null);
                this.itemWidth = f;
                this.itemHeight = f2;
                this.cornerRadius = f3;
            }
        }

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize$Circle;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemSize;", "radius", "", "(F)V", "getRadius", "()F", "setRadius", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Circle extends ItemSize {
            private float radius;

            public static /* synthetic */ Circle copy$default(Circle circle, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = circle.radius;
                }
                return circle.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getRadius() {
                return this.radius;
            }

            public final Circle copy(float radius) {
                return new Circle(radius);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Circle) && Float.compare(this.radius, ((Circle) other).radius) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.radius);
            }

            public String toString() {
                return "Circle(radius=" + this.radius + ')';
            }

            public final float getRadius() {
                return this.radius;
            }

            public final void setRadius(float f) {
                this.radius = f;
            }

            public Circle(float f) {
                super(null);
                this.radius = f;
            }
        }

        public final float getWidth() {
            if (this instanceof RoundedRect) {
                return ((RoundedRect) this).getItemWidth();
            }
            if (this instanceof Circle) {
                return ((Circle) this).getRadius() * 2;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final float getHeight() {
            if (this instanceof RoundedRect) {
                return ((RoundedRect) this).getItemHeight();
            }
            if (this instanceof Circle) {
                return ((Circle) this).getRadius() * 2;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: compiled from: IndicatorParams.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;", "", Profile.DEFAULT_PROFILE_NAME, "Stretch", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement$Default;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement$Stretch;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface ItemPlacement {

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement$Default;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;", "spaceBetweenCenters", "", "(F)V", "getSpaceBetweenCenters", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Default implements ItemPlacement {
            private final float spaceBetweenCenters;

            public static /* synthetic */ Default copy$default(Default r0, float f, int i, Object obj) {
                if ((i & 1) != 0) {
                    f = r0.spaceBetweenCenters;
                }
                return r0.copy(f);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getSpaceBetweenCenters() {
                return this.spaceBetweenCenters;
            }

            public final Default copy(float spaceBetweenCenters) {
                return new Default(spaceBetweenCenters);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Default) && Float.compare(this.spaceBetweenCenters, ((Default) other).spaceBetweenCenters) == 0;
            }

            public int hashCode() {
                return Float.hashCode(this.spaceBetweenCenters);
            }

            public String toString() {
                return "Default(spaceBetweenCenters=" + this.spaceBetweenCenters + ')';
            }

            public Default(float f) {
                this.spaceBetweenCenters = f;
            }

            public final float getSpaceBetweenCenters() {
                return this.spaceBetweenCenters;
            }
        }

        /* JADX INFO: compiled from: IndicatorParams.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement$Stretch;", "Lcom/yandex/div/internal/widget/indicator/IndicatorParams$ItemPlacement;", "itemSpacing", "", "maxVisibleItems", "", "(FI)V", "getItemSpacing", "()F", "getMaxVisibleItems", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final /* data */ class Stretch implements ItemPlacement {
            private final float itemSpacing;
            private final int maxVisibleItems;

            public static /* synthetic */ Stretch copy$default(Stretch stretch, float f, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    f = stretch.itemSpacing;
                }
                if ((i2 & 2) != 0) {
                    i = stretch.maxVisibleItems;
                }
                return stretch.copy(f, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final float getItemSpacing() {
                return this.itemSpacing;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getMaxVisibleItems() {
                return this.maxVisibleItems;
            }

            public final Stretch copy(float itemSpacing, int maxVisibleItems) {
                return new Stretch(itemSpacing, maxVisibleItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Stretch)) {
                    return false;
                }
                Stretch stretch = (Stretch) other;
                return Float.compare(this.itemSpacing, stretch.itemSpacing) == 0 && this.maxVisibleItems == stretch.maxVisibleItems;
            }

            public int hashCode() {
                return (Float.hashCode(this.itemSpacing) * 31) + Integer.hashCode(this.maxVisibleItems);
            }

            public String toString() {
                return "Stretch(itemSpacing=" + this.itemSpacing + ", maxVisibleItems=" + this.maxVisibleItems + ')';
            }

            public Stretch(float f, int i) {
                this.itemSpacing = f;
                this.maxVisibleItems = i;
            }

            public final float getItemSpacing() {
                return this.itemSpacing;
            }

            public final int getMaxVisibleItems() {
                return this.maxVisibleItems;
            }
        }
    }
}

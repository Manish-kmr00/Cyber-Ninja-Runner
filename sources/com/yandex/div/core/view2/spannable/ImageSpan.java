package com.yandex.div.core.view2.spannable;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.internal.spannable.PositionAwareReplacementSpan;
import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ImageSpan.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002+,B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ2\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JP\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u0010R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/yandex/div/core/view2/spannable/ImageSpan;", "Lcom/yandex/div/internal/spannable/PositionAwareReplacementSpan;", "image", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "lineHeight", "alignment", "Lcom/yandex/div/core/view2/spannable/TextVerticalAlignment;", "accessibility", "Lcom/yandex/div/core/view2/spannable/ImageSpan$Accessibility;", "(Landroid/graphics/drawable/Drawable;IIILcom/yandex/div/core/view2/spannable/TextVerticalAlignment;Lcom/yandex/div/core/view2/spannable/ImageSpan$Accessibility;)V", "getAccessibility$div_release", "()Lcom/yandex/div/core/view2/spannable/ImageSpan$Accessibility;", "boundsInText", "Landroid/graphics/RectF;", "value", "getImage", "()Landroid/graphics/drawable/Drawable;", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "adjustSize", "paint", "Landroid/graphics/Paint;", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", VastAttributes.HORIZONTAL_POSITION, "", ViewHierarchyConstants.DIMENSION_TOP_KEY, VastAttributes.VERTICAL_POSITION, "bottom", "getBoundsInText", "Landroid/graphics/Rect;", "rect", "Accessibility", "OnAccessibilityClickAction", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImageSpan extends PositionAwareReplacementSpan {
    private final Accessibility accessibility;
    private final TextVerticalAlignment alignment;
    private final RectF boundsInText;
    private final int height;
    private Drawable image;
    private final int lineHeight;
    private final int width;

    /* JADX INFO: compiled from: ImageSpan.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/spannable/ImageSpan$OnAccessibilityClickAction;", "", "perform", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnAccessibilityClickAction {
        void perform();
    }

    /* JADX INFO: compiled from: ImageSpan.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextVerticalAlignment.values().length];
            try {
                iArr[TextVerticalAlignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextVerticalAlignment.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextVerticalAlignment.BASELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextVerticalAlignment.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ ImageSpan(Drawable drawable, int i, int i2, int i3, TextVerticalAlignment textVerticalAlignment, Accessibility accessibility, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable, i, i2, (i4 & 8) != 0 ? 0 : i3, textVerticalAlignment, accessibility);
    }

    /* JADX INFO: renamed from: getAccessibility$div_release, reason: from getter */
    public final Accessibility getAccessibility() {
        return this.accessibility;
    }

    public ImageSpan(Drawable drawable, int i, int i2, int i3, TextVerticalAlignment alignment, Accessibility accessibility) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        this.width = i;
        this.height = i2;
        this.lineHeight = i3;
        this.alignment = alignment;
        this.accessibility = accessibility;
        this.image = drawable;
        this.boundsInText = new RectF();
    }

    public final Drawable getImage() {
        return this.image;
    }

    public final void setImage(Drawable drawable) {
        if (Intrinsics.areEqual(this.image, drawable)) {
            return;
        }
        this.image = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.width, this.height);
        }
        this.boundsInText.setEmpty();
    }

    @Override // com.yandex.div.internal.spannable.PositionAwareReplacementSpan
    public int adjustSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Rect bounds;
        Rect bounds2;
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(text, "text");
        if (fm == null || this.lineHeight > 0) {
            return this.width;
        }
        int iRoundToInt = MathKt.roundToInt(paint.ascent());
        int iRoundToInt2 = MathKt.roundToInt(paint.descent());
        Drawable drawable = this.image;
        int iHeight = (drawable == null || (bounds2 = drawable.getBounds()) == null) ? this.height : bounds2.height();
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            iRoundToInt2 = iRoundToInt + iHeight;
        } else if (i == 2) {
            iRoundToInt2 = ((iRoundToInt + iRoundToInt2) + iHeight) / 2;
        } else if (i == 3) {
            iRoundToInt2 = 0;
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        int i2 = iRoundToInt2 - iHeight;
        int i3 = fm.top - fm.ascent;
        int i4 = fm.bottom - fm.descent;
        fm.ascent = Math.min(i2, fm.ascent);
        fm.descent = Math.max(iRoundToInt2, fm.descent);
        fm.top = fm.ascent + i3;
        fm.bottom = fm.descent + i4;
        Drawable drawable2 = this.image;
        return (drawable2 == null || (bounds = drawable2.getBounds()) == null) ? this.width : bounds.width();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Drawable drawable = this.image;
        if (drawable == null) {
            return;
        }
        canvas.save();
        int iHeight = drawable.getBounds().height();
        int i = WhenMappings.$EnumSwitchMapping$0[this.alignment.ordinal()];
        if (i == 1) {
            y = top + iHeight;
        } else if (i == 2) {
            y = ((top + bottom) + iHeight) / 2;
        } else if (i != 3) {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            y = bottom;
        }
        float f = y - iHeight;
        this.boundsInText.set(drawable.getBounds());
        this.boundsInText.offset(x, f);
        canvas.translate(x, f);
        drawable.draw(canvas);
        canvas.restore();
    }

    public final Rect getBoundsInText(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.set(MathKt.roundToInt(this.boundsInText.left), MathKt.roundToInt(this.boundsInText.top), MathKt.roundToInt(this.boundsInText.right), MathKt.roundToInt(this.boundsInText.bottom));
        return rect;
    }

    public final RectF getBoundsInText(RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.set(this.boundsInText);
        return rect;
    }

    /* JADX INFO: compiled from: ImageSpan.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/view2/spannable/ImageSpan$Accessibility;", "", "accessibilityType", "", "contentDescription", "onClickAction", "Lcom/yandex/div/core/view2/spannable/ImageSpan$OnAccessibilityClickAction;", "(Ljava/lang/String;Ljava/lang/String;Lcom/yandex/div/core/view2/spannable/ImageSpan$OnAccessibilityClickAction;)V", "getAccessibilityType", "()Ljava/lang/String;", "getContentDescription", "getOnClickAction", "()Lcom/yandex/div/core/view2/spannable/ImageSpan$OnAccessibilityClickAction;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Accessibility {
        private final String accessibilityType;
        private final String contentDescription;
        private final OnAccessibilityClickAction onClickAction;

        public Accessibility(String str, String str2, OnAccessibilityClickAction onAccessibilityClickAction) {
            this.accessibilityType = str;
            this.contentDescription = str2;
            this.onClickAction = onAccessibilityClickAction;
        }

        public final String getAccessibilityType() {
            return this.accessibilityType;
        }

        public final String getContentDescription() {
            return this.contentDescription;
        }

        public final OnAccessibilityClickAction getOnClickAction() {
            return this.onClickAction;
        }
    }
}

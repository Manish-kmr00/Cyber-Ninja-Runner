package com.yandex.div.internal.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.div.internal.Assert;
import io.ktor.http.ContentDisposition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SeparatorView.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0010\u0018\u00002\u00020\u0001:\u0001;B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0014J(\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0014J\u0010\u00102\u001a\u00020(2\b\b\u0001\u00103\u001a\u00020\u0007J\u0010\u00104\u001a\u00020(2\b\b\u0001\u00103\u001a\u00020\u0007J(\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020(H\u0002R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u00020\u00072\b\b\u0001\u0010\u000f\u001a\u00020\u00078\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001f\"\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lcom/yandex/div/internal/widget/SeparatorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "dividerColor", "getDividerColor", "()I", "setDividerColor", "(I)V", "dividerGravity", "getDividerGravity$annotations", "()V", "getDividerGravity", "setDividerGravity", "dividerPaint", "Landroid/graphics/Paint;", "dividerRect", "Landroid/graphics/Rect;", "height", "dividerThickness", "getDividerThickness", "setDividerThickness", "isDividerRectChanged", "", "isDividerVisible", "()Z", "value", "isHorizontal", "setHorizontal", "(Z)V", "calcSize", ContentDisposition.Parameters.Size, "measureSpec", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "width", "oldWidth", "oldHeight", "setDividerColorResource", "resId", "setDividerHeightResource", "setPadding", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, "right", "bottom", "updateDividerRect", "DividerGravity", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SeparatorView extends View {
    private int dividerGravity;
    private final Paint dividerPaint;
    private final Rect dividerRect;
    private int dividerThickness;
    private boolean isDividerRectChanged;
    private boolean isHorizontal;

    /* JADX INFO: compiled from: SeparatorView.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/yandex/div/internal/widget/SeparatorView$DividerGravity;", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public @interface DividerGravity {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SeparatorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SeparatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @DividerGravity
    public static /* synthetic */ void getDividerGravity$annotations() {
    }

    public /* synthetic */ SeparatorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeparatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setColor(0);
        this.dividerPaint = paint;
        this.dividerRect = new Rect();
        this.isHorizontal = true;
        this.dividerGravity = 17;
    }

    /* JADX INFO: renamed from: isHorizontal, reason: from getter */
    public final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    public final void setHorizontal(boolean z) {
        if (this.isHorizontal != z) {
            this.isHorizontal = z;
            this.isDividerRectChanged = true;
            requestLayout();
        }
    }

    public final int getDividerThickness() {
        return this.dividerThickness;
    }

    public final void setDividerThickness(int i) {
        if (this.dividerThickness != i) {
            this.dividerThickness = i;
            this.isDividerRectChanged = true;
            requestLayout();
        }
    }

    public final int getDividerGravity() {
        return this.dividerGravity;
    }

    public final void setDividerGravity(@DividerGravity int i) {
        if (this.dividerGravity != i) {
            this.dividerGravity = i;
            this.isDividerRectChanged = true;
            invalidate();
        }
    }

    public final int getDividerColor() {
        return this.dividerPaint.getColor();
    }

    public final void setDividerColor(int i) {
        if (this.dividerPaint.getColor() != i) {
            this.dividerPaint.setColor(i);
            invalidate();
        }
    }

    private final boolean isDividerVisible() {
        return Color.alpha(this.dividerPaint.getColor()) > 0;
    }

    public final void setDividerColorResource(int resId) {
        setDividerColor(ContextCompat.getColor(getContext(), resId));
    }

    public final void setDividerHeightResource(int resId) {
        setDividerThickness(getResources().getDimensionPixelSize(resId));
    }

    @Override // android.view.View
    public void setPadding(int left, int top, int right, int bottom) {
        super.setPadding(left, top, right, bottom);
        this.isDividerRectChanged = true;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.isHorizontal) {
            paddingTop += this.dividerThickness;
        } else {
            paddingLeft += this.dividerThickness;
        }
        setMeasuredDimension(calcSize(Math.max(paddingLeft, getSuggestedMinimumWidth()), widthMeasureSpec), calcSize(Math.max(paddingTop, getSuggestedMinimumHeight()), heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        this.isDividerRectChanged = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (isDividerVisible()) {
            updateDividerRect();
            canvas.drawRect(this.dividerRect, this.dividerPaint);
        }
    }

    private final void updateDividerRect() {
        if (this.isDividerRectChanged) {
            int paddingTop = this.isHorizontal ? getPaddingTop() : getPaddingLeft();
            int paddingBottom = this.isHorizontal ? getPaddingBottom() : getPaddingRight();
            int height = this.isHorizontal ? getHeight() : getWidth();
            int i = (height - paddingTop) - paddingBottom;
            int i2 = this.dividerGravity;
            if (i2 == 17) {
                paddingTop += (i - this.dividerThickness) / 2;
            } else if (i2 != 8388611) {
                if (i2 == 8388613) {
                    paddingTop = (height - paddingBottom) - this.dividerThickness;
                } else {
                    Assert.fail("Unknown divider gravity value");
                    paddingTop = 0;
                }
            }
            if (this.isHorizontal) {
                this.dividerRect.top = paddingTop;
                this.dividerRect.bottom = paddingTop + Math.min(i, this.dividerThickness);
                this.dividerRect.left = getPaddingLeft();
                this.dividerRect.right = getWidth() - getPaddingRight();
            } else {
                this.dividerRect.left = paddingTop;
                this.dividerRect.right = paddingTop + Math.min(i, this.dividerThickness);
                this.dividerRect.top = getPaddingTop();
                this.dividerRect.bottom = getHeight() - getPaddingBottom();
            }
            this.isDividerRectChanged = false;
        }
    }

    private final int calcSize(int size, int measureSpec) {
        int mode = View.MeasureSpec.getMode(measureSpec);
        int size2 = View.MeasureSpec.getSize(measureSpec);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? size : size2;
        }
        return Math.min(size, size2);
    }
}

package com.yandex.div.internal.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatEditText;
import com.yandex.div.core.widget.FixedLineHeightHelper;
import com.yandex.div.core.widget.FixedLineHeightView;
import com.yandex.div.core.widget.ViewsKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SuperLineHeightEditText.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0014J(\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\bH\u0014J*\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020\bH\u0014J\u0010\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u000201H\u0017J\b\u00102\u001a\u00020!H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u00020\u0016H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u00106\u001a\u00020\u0016H\u0016J\u0018\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020:H\u0016J\u0012\u0010;\u001a\u00020!2\b\b\u0002\u0010&\u001a\u00020\bH\u0002R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012*\u0004\b\r\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u001c\u001a\u00020\b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010¨\u0006<"}, d2 = {"Lcom/yandex/div/internal/widget/SuperLineHeightEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Lcom/yandex/div/core/widget/FixedLineHeightView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentLineCount", "<set-?>", "fixedLineHeight", "getFixedLineHeight$delegate", "(Lcom/yandex/div/internal/widget/SuperLineHeightEditText;)Ljava/lang/Object;", "getFixedLineHeight", "()I", "setFixedLineHeight", "(I)V", "fixedLineHeightHelper", "Lcom/yandex/div/core/widget/FixedLineHeightHelper;", "horizontalScrollingEnabled", "", "interceptTouchEventNeeded", "getInterceptTouchEventNeeded", "()Z", "isDisallowInterceptTouchEvent", "isTextFitting", "visibleLineCount", "getVisibleLineCount", "getCompoundPaddingBottom", "getCompoundPaddingTop", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "remeasureWrapContentConstrained", "requestDisallowInterceptTouchEvent", "enabled", "setHorizontallyScrolling", "whether", "setTextSize", "unit", ContentDisposition.Parameters.Size, "", "updateFittingText", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SuperLineHeightEditText extends AppCompatEditText implements FixedLineHeightView {
    private int currentLineCount;
    private final FixedLineHeightHelper fixedLineHeightHelper;
    private boolean horizontalScrollingEnabled;
    private boolean isDisallowInterceptTouchEvent;
    private boolean isTextFitting;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SuperLineHeightEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isTextFitting = true;
        this.fixedLineHeightHelper = new FixedLineHeightHelper(this);
    }

    private final boolean getInterceptTouchEventNeeded() {
        return (this.horizontalScrollingEnabled || this.isTextFitting) ? false : true;
    }

    private final int getVisibleLineCount() {
        if (getLineCount() == 0) {
            return 1;
        }
        return getLineCount() > getMaxLines() ? getMaxLines() : getLineCount();
    }

    @Override // com.yandex.div.core.widget.FixedLineHeightView
    public int getFixedLineHeight() {
        return this.fixedLineHeightHelper.getLineHeight();
    }

    @Override // com.yandex.div.core.widget.FixedLineHeightView
    public void setFixedLineHeight(int i) {
        this.fixedLineHeightHelper.setLineHeight(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        this.fixedLineHeightHelper.onFontSizeChanged();
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (Build.VERSION.SDK_INT < 28) {
            remeasureWrapContentConstrained();
        }
        updateFittingText$default(this, 0, 1, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxLines;
        int iMakeExactSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        FixedLineHeightHelper fixedLineHeightHelper = this.fixedLineHeightHelper;
        if (getLineCount() == 0) {
            maxLines = 1;
        } else {
            maxLines = getLineCount() > getMaxLines() ? getMaxLines() : getLineCount();
        }
        if (fixedLineHeightHelper.getLineHeight() == -1 || ViewsKt.isExact(heightMeasureSpec)) {
            return;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(TextViewsKt.textHeight(fixedLineHeightHelper.view, maxLines) + (maxLines >= fixedLineHeightHelper.view.getLineCount() ? fixedLineHeightHelper.textPaddingTop + fixedLineHeightHelper.textPaddingBottom : 0) + fixedLineHeightHelper.view.getPaddingTop() + fixedLineHeightHelper.view.getPaddingBottom(), fixedLineHeightHelper.view.getMinimumHeight());
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
            iMakeExactSpec = ViewsKt.makeAtMostSpec(Math.min(iCoerceAtLeast, View.MeasureSpec.getSize(heightMeasureSpec)));
        } else {
            iMakeExactSpec = ViewsKt.makeExactSpec(iCoerceAtLeast);
        }
        super.setMeasuredDimension(getMeasuredWidthAndState(), iMakeExactSpec);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateFittingText(h);
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop() + this.fixedLineHeightHelper.getTextPaddingTop();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() + this.fixedLineHeightHelper.getTextPaddingBottom();
    }

    @Override // android.widget.TextView
    public void setHorizontallyScrolling(boolean whether) {
        this.horizontalScrollingEnabled = whether;
        super.setHorizontallyScrolling(whether);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!getInterceptTouchEventNeeded()) {
            if (this.isDisallowInterceptTouchEvent) {
                requestDisallowInterceptTouchEvent(false);
            }
            return super.onTouchEvent(event);
        }
        int action = event.getAction() & 255;
        if (action == 0) {
            requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            requestDisallowInterceptTouchEvent(false);
        }
        return super.onTouchEvent(event);
    }

    private final void remeasureWrapContentConstrained() {
        int maxLines;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int maxLines2 = 1;
        if (layoutParams != null && layoutParams.height == -3) {
            int i = this.currentLineCount;
            if (getLineCount() == 0) {
                maxLines = 1;
            } else {
                maxLines = getLineCount() > getMaxLines() ? getMaxLines() : getLineCount();
            }
            if (i != maxLines) {
                if (getLineCount() != 0) {
                    maxLines2 = getLineCount() > getMaxLines() ? getMaxLines() : getLineCount();
                }
                this.currentLineCount = maxLines2;
                requestLayout();
                return;
            }
            return;
        }
        if (getLineCount() != 0) {
            maxLines2 = getLineCount() > getMaxLines() ? getMaxLines() : getLineCount();
        }
        this.currentLineCount = maxLines2;
    }

    static /* synthetic */ void updateFittingText$default(SuperLineHeightEditText superLineHeightEditText, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateFittingText");
        }
        if ((i2 & 1) != 0) {
            i = superLineHeightEditText.getHeight();
        }
        superLineHeightEditText.updateFittingText(i);
    }

    private final void updateFittingText(int h) {
        if (getLayout() == null || h == 0) {
            return;
        }
        this.isTextFitting = (h - getCompoundPaddingTop()) - getCompoundPaddingBottom() >= TextViewsKt.textHeight(this, getLayout().getLineCount());
    }

    private final void requestDisallowInterceptTouchEvent(boolean enabled) {
        this.isDisallowInterceptTouchEvent = enabled;
        getParent().requestDisallowInterceptTouchEvent(enabled);
    }
}

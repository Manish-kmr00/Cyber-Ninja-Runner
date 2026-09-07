package com.yandex.div.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.yandex.div.core.widget.FixedLineHeightHelper;
import com.yandex.div.core.widget.FixedLineHeightView;
import com.yandex.div.core.widget.ViewsKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SuperLineHeightTextView.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bH\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0016R+\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b8V@VX\u0096\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011*\u0004\b\f\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001a\u001a\u00020\b8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006&"}, d2 = {"Lcom/yandex/div/internal/widget/SuperLineHeightTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/yandex/div/core/widget/FixedLineHeightView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "fixedLineHeight", "getFixedLineHeight$delegate", "(Lcom/yandex/div/internal/widget/SuperLineHeightTextView;)Ljava/lang/Object;", "getFixedLineHeight", "()I", "setFixedLineHeight", "(I)V", "fixedLineHeightHelper", "Lcom/yandex/div/core/widget/FixedLineHeightHelper;", "value", "", "isTightenWidth", "()Z", "setTightenWidth", "(Z)V", "visibleLineCount", "getVisibleLineCount", "getCompoundPaddingBottom", "getCompoundPaddingTop", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setTextSize", "unit", ContentDisposition.Parameters.Size, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class SuperLineHeightTextView extends AppCompatTextView implements FixedLineHeightView {
    private final FixedLineHeightHelper fixedLineHeightHelper;
    private boolean isTightenWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SuperLineHeightTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLineHeightTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.fixedLineHeightHelper = new FixedLineHeightHelper(this);
    }

    private final int getVisibleLineCount() {
        return Math.min(getLineCount(), getMaxLines());
    }

    @Override // com.yandex.div.core.widget.FixedLineHeightView
    public int getFixedLineHeight() {
        return this.fixedLineHeightHelper.getLineHeight();
    }

    @Override // com.yandex.div.core.widget.FixedLineHeightView
    public void setFixedLineHeight(int i) {
        this.fixedLineHeightHelper.setLineHeight(i);
    }

    /* JADX INFO: renamed from: isTightenWidth, reason: from getter */
    public final boolean getIsTightenWidth() {
        return this.isTightenWidth;
    }

    public final void setTightenWidth(boolean z) {
        boolean z2 = this.isTightenWidth;
        this.isTightenWidth = z;
        if (z2 != z) {
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int unit, float size) {
        super.setTextSize(unit, size);
        this.fixedLineHeightHelper.onFontSizeChanged();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int iMakeExactSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        FixedLineHeightHelper fixedLineHeightHelper = this.fixedLineHeightHelper;
        int iMin = Math.min(getLineCount(), getMaxLines());
        if (fixedLineHeightHelper.getLineHeight() != -1 && !ViewsKt.isExact(heightMeasureSpec)) {
            int iCoerceAtLeast = RangesKt.coerceAtLeast(TextViewsKt.textHeight(fixedLineHeightHelper.view, iMin) + (iMin >= fixedLineHeightHelper.view.getLineCount() ? fixedLineHeightHelper.textPaddingTop + fixedLineHeightHelper.textPaddingBottom : 0) + fixedLineHeightHelper.view.getPaddingTop() + fixedLineHeightHelper.view.getPaddingBottom(), fixedLineHeightHelper.view.getMinimumHeight());
            if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
                iMakeExactSpec = ViewsKt.makeAtMostSpec(Math.min(iCoerceAtLeast, View.MeasureSpec.getSize(heightMeasureSpec)));
            } else {
                iMakeExactSpec = ViewsKt.makeExactSpec(iCoerceAtLeast);
            }
            super.setMeasuredDimension(getMeasuredWidthAndState(), iMakeExactSpec);
        }
        if (!this.isTightenWidth || getMaxWidth() <= 0) {
            return;
        }
        int lineCount = getLayout().getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        int iCeil = (int) Math.ceil(fMax + getCompoundPaddingLeft() + getCompoundPaddingRight());
        if (iCeil < getMeasuredWidth()) {
            super.setMeasuredDimension(View.MeasureSpec.makeMeasureSpec(iCeil, View.MeasureSpec.getMode(getMeasuredWidthAndState())), getMeasuredHeightAndState());
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingTop() {
        return super.getCompoundPaddingTop() + this.fixedLineHeightHelper.getTextPaddingTop();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingBottom() {
        return super.getCompoundPaddingBottom() + this.fixedLineHeightHelper.getTextPaddingBottom();
    }
}

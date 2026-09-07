package com.yandex.div.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.yandex.div.internal.widget.TextViewsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FixedLineHeightHelper.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0006H\u0002J0\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00130\u0018H\u0086\bø\u0001\u0000J\u0006\u0010\u0019\u001a\u00020\u0013J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001e"}, d2 = {"Lcom/yandex/div/core/widget/FixedLineHeightHelper;", "", "view", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "extraPaddingBottom", "", "getExtraPaddingBottom", "()I", "extraPaddingTop", "getExtraPaddingTop", "value", "lineHeight", "getLineHeight", "setLineHeight", "(I)V", "textPaddingBottom", "textPaddingTop", "applyLineHeight", "", "measureWithFixedLineHeight", "heightMeasureSpec", "visibleLineCount", "applySpec", "Lkotlin/Function1;", "onFontSizeChanged", "resetLineHeight", "setFallbackLineSpacing", "enabled", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FixedLineHeightHelper {
    private int lineHeight;
    private int textPaddingBottom;
    private int textPaddingTop;
    private final TextView view;

    public FixedLineHeightHelper(TextView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.lineHeight = -1;
        view.setIncludeFontPadding(false);
    }

    /* JADX INFO: renamed from: getExtraPaddingTop, reason: from getter */
    public final int getTextPaddingTop() {
        return this.textPaddingTop;
    }

    /* JADX INFO: renamed from: getExtraPaddingBottom, reason: from getter */
    public final int getTextPaddingBottom() {
        return this.textPaddingBottom;
    }

    public final int getLineHeight() {
        return this.lineHeight;
    }

    public final void setLineHeight(int i) {
        if (this.lineHeight == i) {
            return;
        }
        this.lineHeight = i;
        applyLineHeight(i);
    }

    public final void onFontSizeChanged() {
        applyLineHeight(this.lineHeight);
    }

    private final void applyLineHeight(int lineHeight) {
        if (lineHeight == -1) {
            resetLineHeight();
            return;
        }
        int fontHeightInt = lineHeight - TextViewsKt.getFontHeightInt(this.view);
        if (fontHeightInt < 0) {
            int i = fontHeightInt / 2;
            this.textPaddingTop = i;
            this.textPaddingBottom = fontHeightInt - i;
        } else {
            int i2 = fontHeightInt / 2;
            this.textPaddingBottom = i2;
            this.textPaddingTop = fontHeightInt - i2;
        }
        this.view.setLineSpacing(lineHeight - TextViewsKt.getFontHeight(this.view), 1.0f);
        setFallbackLineSpacing(false);
    }

    private final void resetLineHeight() {
        this.textPaddingTop = 0;
        this.textPaddingBottom = 0;
        this.view.setLineSpacing(0.0f, 1.0f);
        setFallbackLineSpacing(true);
    }

    private final void setFallbackLineSpacing(boolean enabled) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.view.setFallbackLineSpacing(enabled);
        }
    }

    public final void measureWithFixedLineHeight(int heightMeasureSpec, int visibleLineCount, Function1<? super Integer, Unit> applySpec) {
        int iMakeExactSpec;
        Intrinsics.checkNotNullParameter(applySpec, "applySpec");
        if (getLineHeight() == -1 || ViewsKt.isExact(heightMeasureSpec)) {
            return;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(TextViewsKt.textHeight(this.view, visibleLineCount) + (visibleLineCount >= this.view.getLineCount() ? this.textPaddingTop + this.textPaddingBottom : 0) + this.view.getPaddingTop() + this.view.getPaddingBottom(), this.view.getMinimumHeight());
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
            iMakeExactSpec = ViewsKt.makeAtMostSpec(Math.min(iCoerceAtLeast, View.MeasureSpec.getSize(heightMeasureSpec)));
        } else {
            iMakeExactSpec = ViewsKt.makeExactSpec(iCoerceAtLeast);
        }
        applySpec.invoke(Integer.valueOf(iMakeExactSpec));
    }
}

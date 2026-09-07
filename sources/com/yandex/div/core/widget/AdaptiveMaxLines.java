package com.yandex.div.core.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.yandex.div.core.timer.TimerController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdaptiveMaxLines.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0006\u0010\u0013\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/widget/AdaptiveMaxLines;", "", "textView", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "isAdaptLinesRequested", "", "params", "Lcom/yandex/div/core/widget/AdaptiveMaxLines$Params;", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "viewAttachListener", "Landroid/view/View$OnAttachStateChangeListener;", "addAttachListener", "", "addPreDrawListener", "apply", "removeAttachListener", "removePreDrawListener", TimerController.RESET_COMMAND, "Params", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AdaptiveMaxLines {
    private boolean isAdaptLinesRequested;
    private Params params;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private final TextView textView;
    private View.OnAttachStateChangeListener viewAttachListener;

    public AdaptiveMaxLines(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
    }

    public final void apply(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (Intrinsics.areEqual(this.params, params)) {
            return;
        }
        this.params = params;
        if (ViewCompat.isAttachedToWindow(this.textView)) {
            addPreDrawListener();
        }
        addAttachListener();
    }

    public final void reset() {
        removeAttachListener();
        removePreDrawListener();
    }

    private final void addAttachListener() {
        if (this.viewAttachListener != null) {
            return;
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.yandex.div.core.widget.AdaptiveMaxLines.addAttachListener.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                AdaptiveMaxLines.this.addPreDrawListener();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                AdaptiveMaxLines.this.removePreDrawListener();
            }
        };
        this.textView.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.viewAttachListener = onAttachStateChangeListener;
    }

    private final void removeAttachListener() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.viewAttachListener;
        if (onAttachStateChangeListener != null) {
            this.textView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        this.viewAttachListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addPreDrawListener() {
        if (this.preDrawListener != null) {
            return;
        }
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.div.core.widget.AdaptiveMaxLines.addPreDrawListener.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                Params params = AdaptiveMaxLines.this.params;
                if (params == null || TextUtils.isEmpty(AdaptiveMaxLines.this.textView.getText())) {
                    return true;
                }
                if (AdaptiveMaxLines.this.isAdaptLinesRequested) {
                    AdaptiveMaxLines.this.removePreDrawListener();
                    AdaptiveMaxLines.this.isAdaptLinesRequested = false;
                    return true;
                }
                Integer num = Integer.MAX_VALUE;
                AdaptiveMaxLines adaptiveMaxLines = AdaptiveMaxLines.this;
                num.intValue();
                num = adaptiveMaxLines.textView.getLineCount() > params.getTotalVisibleLines() ? null : Integer.MAX_VALUE;
                int iIntValue = num != null ? num.intValue() : params.getMaxLines();
                if (iIntValue != AdaptiveMaxLines.this.textView.getMaxLines()) {
                    AdaptiveMaxLines.this.textView.setMaxLines(iIntValue);
                    AdaptiveMaxLines.this.isAdaptLinesRequested = true;
                    return false;
                }
                AdaptiveMaxLines.this.removePreDrawListener();
                return true;
            }
        };
        ViewTreeObserver viewTreeObserver = this.textView.getViewTreeObserver();
        Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "textView.viewTreeObserver");
        ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = onPreDrawListener;
        viewTreeObserver.addOnPreDrawListener(onPreDrawListener2);
        this.preDrawListener = onPreDrawListener2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePreDrawListener() {
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            ViewTreeObserver viewTreeObserver = this.textView.getViewTreeObserver();
            Intrinsics.checkNotNullExpressionValue(viewTreeObserver, "textView.viewTreeObserver");
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
        }
        this.preDrawListener = null;
    }

    /* JADX INFO: compiled from: AdaptiveMaxLines.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/yandex/div/core/widget/AdaptiveMaxLines$Params;", "", "maxLines", "", "minHiddenLines", "(II)V", "getMaxLines", "()I", "getMinHiddenLines", "totalVisibleLines", "getTotalVisibleLines", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final /* data */ class Params {
        private final int maxLines;
        private final int minHiddenLines;

        public static /* synthetic */ Params copy$default(Params params, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = params.maxLines;
            }
            if ((i3 & 2) != 0) {
                i2 = params.minHiddenLines;
            }
            return params.copy(i, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getMaxLines() {
            return this.maxLines;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getMinHiddenLines() {
            return this.minHiddenLines;
        }

        public final Params copy(int maxLines, int minHiddenLines) {
            return new Params(maxLines, minHiddenLines);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return this.maxLines == params.maxLines && this.minHiddenLines == params.minHiddenLines;
        }

        public int hashCode() {
            return (Integer.hashCode(this.maxLines) * 31) + Integer.hashCode(this.minHiddenLines);
        }

        public String toString() {
            return "Params(maxLines=" + this.maxLines + ", minHiddenLines=" + this.minHiddenLines + ')';
        }

        public Params(int i, int i2) {
            this.maxLines = i;
            this.minHiddenLines = i2;
        }

        public final int getMaxLines() {
            return this.maxLines;
        }

        public final int getMinHiddenLines() {
            return this.minHiddenLines;
        }

        public final int getTotalVisibleLines() {
            return this.maxLines + this.minHiddenLines;
        }
    }
}

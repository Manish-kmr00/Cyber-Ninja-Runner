package com.yandex.div.internal.widget;

import android.view.ViewTreeObserver;
import com.yandex.div.internal.KLog;
import com.yandex.div.logging.Severity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoEllipsizeHelper.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0010\u001a\u00020\rH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/internal/widget/AutoEllipsizeHelper;", "", "textView", "Lcom/yandex/div/internal/widget/EllipsizedTextView;", "(Lcom/yandex/div/internal/widget/EllipsizedTextView;)V", "isEnabled", "", "()Z", "setEnabled", "(Z)V", "preDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "addListener", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "removeListener", "Companion", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutoEllipsizeHelper {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "AutoEllipsizeHelper";
    private boolean isEnabled;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    private final EllipsizedTextView textView;

    public AutoEllipsizeHelper(EllipsizedTextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        this.textView = textView;
    }

    /* JADX INFO: renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    public final void onViewAttachedToWindow() {
        if (this.isEnabled) {
            addListener();
        }
    }

    public final void onViewDetachedFromWindow() {
        removeListener();
    }

    private final void addListener() {
        if (this.preDrawListener != null) {
            return;
        }
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.div.internal.widget.AutoEllipsizeHelper$$ExternalSyntheticLambda0
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public final boolean onPreDraw() {
                return AutoEllipsizeHelper.addListener$lambda$2(this.f$0);
            }
        };
        this.textView.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean addListener$lambda$2(AutoEllipsizeHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isEnabled) {
            return true;
        }
        EllipsizedTextView ellipsizedTextView = this$0.textView;
        int height = (ellipsizedTextView.getHeight() - ellipsizedTextView.getCompoundPaddingTop()) - ellipsizedTextView.getCompoundPaddingBottom();
        EllipsizedTextView ellipsizedTextView2 = ellipsizedTextView;
        int iLineAt = TextViewsKt.lineAt(ellipsizedTextView2, height);
        int i = iLineAt + 1;
        if (height >= TextViewsKt.textHeight(ellipsizedTextView2, i)) {
            iLineAt = i;
        }
        if (iLineAt > 0 && iLineAt < this$0.textView.getLineCount()) {
            KLog kLog = KLog.INSTANCE;
            if (kLog.isAtLeast(Severity.DEBUG)) {
                kLog.print(3, TAG, "Trying to set new max lines " + iLineAt + ". Current drawing pass is canceled. ");
            }
            this$0.textView.setMaxLines(iLineAt);
            return false;
        }
        this$0.removeListener();
        return true;
    }

    private final void removeListener() {
        if (this.preDrawListener != null) {
            this.textView.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
            this.preDrawListener = null;
        }
    }

    /* JADX INFO: compiled from: AutoEllipsizeHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/yandex/div/internal/widget/AutoEllipsizeHelper$Companion;", "", "()V", "TAG", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.yandex.div.core.view2.reuse;

import android.view.View;
import com.yandex.div.core.actions.DivActionTypedUtilsKt;
import com.yandex.div.core.dagger.DivViewScope;
import com.yandex.div.core.downloader.PersistentDivDataObserver;
import com.yandex.div.core.view2.Div2View;
import com.yandex.div.core.view2.divs.widgets.DivInputView;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InputFocusTracker.kt */
/* JADX INFO: loaded from: classes.dex */
@DivViewScope
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/reuse/InputFocusTracker;", "", "div2View", "Lcom/yandex/div/core/view2/Div2View;", "(Lcom/yandex/div/core/view2/Div2View;)V", "changingState", "", "divDataChangedObserver", "Lcom/yandex/div/core/view2/reuse/InputFocusTracker$InputFocusPersistentDivDataChangedObserver;", "focusedInputTag", "inputFocusChanged", "", "tag", "view", "Lcom/yandex/div/core/view2/divs/widgets/DivInputView;", "focused", "removeFocusFromFocusedInput", "requestFocusIfNeeded", "Landroid/view/View;", "Companion", "InputFocusPersistentDivDataChangedObserver", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class InputFocusTracker {
    private static WeakReference<View> lastFocused;
    private boolean changingState;
    private final InputFocusPersistentDivDataChangedObserver divDataChangedObserver;
    private Object focusedInputTag;

    @Inject
    public InputFocusTracker(Div2View div2View) {
        Intrinsics.checkNotNullParameter(div2View, "div2View");
        InputFocusPersistentDivDataChangedObserver inputFocusPersistentDivDataChangedObserver = new InputFocusPersistentDivDataChangedObserver();
        this.divDataChangedObserver = inputFocusPersistentDivDataChangedObserver;
        div2View.addPersistentDivDataObserver$div_release(inputFocusPersistentDivDataChangedObserver);
    }

    public final void inputFocusChanged(Object tag, DivInputView view, boolean focused) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.changingState) {
            return;
        }
        if (focused) {
            this.focusedInputTag = tag;
            lastFocused = new WeakReference<>(view);
            view.setSelection(view.length());
        } else {
            if (focused) {
                return;
            }
            this.focusedInputTag = null;
            lastFocused = null;
        }
    }

    public final void requestFocusIfNeeded(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getTag() != null && Intrinsics.areEqual(view.getTag(), this.focusedInputTag) && this.changingState) {
            this.divDataChangedObserver.setFocusRequestedDuringChangeState(true);
            view.requestFocus();
        }
    }

    public final void removeFocusFromFocusedInput() {
        View view;
        WeakReference<View> weakReference = lastFocused;
        if (weakReference == null || (view = weakReference.get()) == null) {
            return;
        }
        view.clearFocus();
        DivActionTypedUtilsKt.closeKeyboard(view);
    }

    /* JADX INFO: compiled from: InputFocusTracker.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/yandex/div/core/view2/reuse/InputFocusTracker$InputFocusPersistentDivDataChangedObserver;", "Lcom/yandex/div/core/downloader/PersistentDivDataObserver;", "(Lcom/yandex/div/core/view2/reuse/InputFocusTracker;)V", "focusRequestedDuringChangeState", "", "getFocusRequestedDuringChangeState", "()Z", "setFocusRequestedDuringChangeState", "(Z)V", "onAfterDivDataChanged", "", "onBeforeDivDataChanged", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class InputFocusPersistentDivDataChangedObserver implements PersistentDivDataObserver {
        private boolean focusRequestedDuringChangeState;

        public InputFocusPersistentDivDataChangedObserver() {
        }

        public final boolean getFocusRequestedDuringChangeState() {
            return this.focusRequestedDuringChangeState;
        }

        public final void setFocusRequestedDuringChangeState(boolean z) {
            this.focusRequestedDuringChangeState = z;
        }

        @Override // com.yandex.div.core.downloader.PersistentDivDataObserver
        public void onBeforeDivDataChanged() {
            InputFocusTracker.this.changingState = true;
            this.focusRequestedDuringChangeState = false;
        }

        @Override // com.yandex.div.core.downloader.PersistentDivDataObserver
        public void onAfterDivDataChanged() {
            InputFocusTracker.this.changingState = false;
            if (this.focusRequestedDuringChangeState) {
                return;
            }
            InputFocusTracker.this.focusedInputTag = null;
        }
    }
}

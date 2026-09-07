package com.yandex.div.core.view2.backbutton;

import android.view.KeyEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BackKeyPressedHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bJ\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0013\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/yandex/div/core/view2/backbutton/BackKeyPressedHelper;", "", "mOwnerView", "Landroid/view/View;", "(Landroid/view/View;)V", "mOnBackClickListener", "Lcom/yandex/div/core/view2/backbutton/BackKeyPressedHelper$OnBackClickListener;", "onKeyAction", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "onVisibilityChanged", "", "onWindowFocusChanged", "hasWindowFocus", "setOnBackClickListener", "onBackClickListener", "setupFocus", "OnBackClickListener", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BackKeyPressedHelper {
    private OnBackClickListener mOnBackClickListener;
    private final View mOwnerView;

    /* JADX INFO: compiled from: BackKeyPressedHelper.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/backbutton/BackKeyPressedHelper$OnBackClickListener;", "", "onBackClick", "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface OnBackClickListener {
        boolean onBackClick();
    }

    public BackKeyPressedHelper(View mOwnerView) {
        Intrinsics.checkNotNullParameter(mOwnerView, "mOwnerView");
        this.mOwnerView = mOwnerView;
    }

    public final void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.mOnBackClickListener = onBackClickListener;
        setupFocus();
    }

    public final boolean onKeyAction(int keyCode, KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mOnBackClickListener == null || keyCode != 4) {
            return false;
        }
        if (event.getAction() == 0 && event.getRepeatCount() == 0) {
            KeyEvent.DispatcherState keyDispatcherState = this.mOwnerView.getKeyDispatcherState();
            if (keyDispatcherState != null) {
                keyDispatcherState.startTracking(event, this);
            }
            return true;
        }
        if (event.getAction() != 1) {
            return false;
        }
        KeyEvent.DispatcherState keyDispatcherState2 = this.mOwnerView.getKeyDispatcherState();
        if (keyDispatcherState2 != null) {
            keyDispatcherState2.handleUpEvent(event);
        }
        if (!event.isTracking() || event.isCanceled()) {
            return false;
        }
        OnBackClickListener onBackClickListener = this.mOnBackClickListener;
        Intrinsics.checkNotNull(onBackClickListener);
        return onBackClickListener.onBackClick();
    }

    public final void onWindowFocusChanged(boolean hasWindowFocus) {
        if (hasWindowFocus) {
            setupFocus();
        }
    }

    public final void onVisibilityChanged() {
        setupFocus();
    }

    private final void setupFocus() {
        View rootView;
        if (this.mOnBackClickListener == null || !this.mOwnerView.hasWindowFocus()) {
            return;
        }
        View view = this.mOwnerView;
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        if (view.isShown()) {
            view.requestFocus();
        } else {
            if (!view.hasFocus() || (rootView = view.getRootView()) == null) {
                return;
            }
            rootView.requestFocus(33);
        }
    }
}

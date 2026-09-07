package com.yandex.div.core.tooltip;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DivTooltipController.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/tooltip/PopupWindowTouchListener;", "Landroid/view/View$OnTouchListener;", "popupWindow", "Landroid/widget/PopupWindow;", "tooltipView", "Landroid/view/View;", "isModal", "", "shouldDismissByOutsideTouch", "(Landroid/widget/PopupWindow;Landroid/view/View;ZZ)V", "hitRect", "Landroid/graphics/Rect;", "onTouch", "view", "event", "Landroid/view/MotionEvent;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class PopupWindowTouchListener implements View.OnTouchListener {
    private final Rect hitRect;
    private final boolean isModal;
    private final PopupWindow popupWindow;
    private final boolean shouldDismissByOutsideTouch;
    private final View tooltipView;

    public PopupWindowTouchListener(PopupWindow popupWindow, View tooltipView, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        Intrinsics.checkNotNullParameter(tooltipView, "tooltipView");
        this.popupWindow = popupWindow;
        this.tooltipView = tooltipView;
        this.isModal = z;
        this.shouldDismissByOutsideTouch = z2;
        this.hitRect = new Rect();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        this.tooltipView.getHitRect(this.hitRect);
        if (this.hitRect.contains((int) event.getX(), (int) event.getY())) {
            return false;
        }
        if (this.shouldDismissByOutsideTouch) {
            this.popupWindow.dismiss();
        }
        return this.isModal;
    }
}

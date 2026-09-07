package com.yandex.div.core.view2.divs.widgets;

import android.view.KeyEvent;
import android.view.ViewGroup;
import kotlin.Metadata;

/* JADX INFO: compiled from: DivAnimator.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/DivAnimator;", "", "startDivAnimation", "", "stopDivAnimation", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DivAnimator {
    /* JADX WARN: Multi-variable type inference failed */
    default void startDivAnimation() {
        ViewGroup viewGroup;
        int childCount;
        if (!(this instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) this).getChildCount()) < 0) {
            return;
        }
        int i = 0;
        while (true) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i);
            DivAnimator divAnimator = childAt instanceof DivAnimator ? (DivAnimator) childAt : null;
            if (divAnimator != null) {
                divAnimator.startDivAnimation();
            }
            if (i == childCount) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    default void stopDivAnimation() {
        ViewGroup viewGroup;
        int childCount;
        if (!(this instanceof ViewGroup) || (childCount = (viewGroup = (ViewGroup) this).getChildCount()) < 0) {
            return;
        }
        int i = 0;
        while (true) {
            KeyEvent.Callback childAt = viewGroup.getChildAt(i);
            DivAnimator divAnimator = childAt instanceof DivAnimator ? (DivAnimator) childAt : null;
            if (divAnimator != null) {
                divAnimator.stopDivAnimation();
            }
            if (i == childCount) {
                return;
            } else {
                i++;
            }
        }
    }
}

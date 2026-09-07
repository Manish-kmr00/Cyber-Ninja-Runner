package com.yandex.div.core.view2.divs.widgets;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.internal.widget.OnInterceptTouchEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ParentScrollRestrictor.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/view2/divs/widgets/ParentScrollRestrictor;", "Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "()V", "onInterceptTouchEvent", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ParentScrollRestrictor implements OnInterceptTouchEventListener {
    public static final ParentScrollRestrictor INSTANCE = new ParentScrollRestrictor();

    private ParentScrollRestrictor() {
    }

    @Override // com.yandex.div.internal.widget.OnInterceptTouchEventListener
    public boolean onInterceptTouchEvent(ViewGroup target, MotionEvent event) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(event, "event");
        ViewParent parent = target.getParent();
        if (parent == null) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }
}

package com.yandex.div.internal.widget;

import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnInterceptTouchEventListener.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/div/internal/widget/OnInterceptTouchEventListener;", "", "onInterceptTouchEvent", "", TypedValues.AttributesType.S_TARGET, "Landroid/view/ViewGroup;", "event", "Landroid/view/MotionEvent;", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface OnInterceptTouchEventListener {
    boolean onInterceptTouchEvent(ViewGroup target, MotionEvent event);
}

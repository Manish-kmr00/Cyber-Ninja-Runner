package com.yandex.div.core.widget;

import com.yandex.div.core.timer.TimerController;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GridContainer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/core/widget/Resettable;", "T", "", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "initialized", "", "getInitialized", "()Z", "value", "Ljava/lang/Object;", "get", "()Ljava/lang/Object;", TimerController.RESET_COMMAND, "", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class Resettable<T> {
    private final Function0<T> initializer;
    private T value;

    /* JADX WARN: Multi-variable type inference failed */
    public Resettable(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
    }

    public final boolean getInitialized() {
        return this.value != null;
    }

    public final T get() {
        if (this.value == null) {
            this.value = this.initializer.invoke();
        }
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new ConcurrentModificationException("Set to null by another thread");
    }

    public final void reset() {
        this.value = null;
    }
}

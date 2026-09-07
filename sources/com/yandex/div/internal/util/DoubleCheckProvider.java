package com.yandex.div.internal.util;

import javax.inject.Provider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DoubleCheckProvider.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bR\u001b\u0010\u0006\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/yandex/div/internal/util/DoubleCheckProvider;", "T", "Ljavax/inject/Provider;", "init", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "get", "utils_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DoubleCheckProvider<T> implements Provider<T> {

    /* JADX INFO: renamed from: value$delegate, reason: from kotlin metadata */
    private final Lazy value;

    public DoubleCheckProvider(Function0<? extends T> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.value = LazyKt.lazy(init);
    }

    private final T getValue() {
        return (T) this.value.getValue();
    }

    @Override // javax.inject.Provider
    public T get() {
        return getValue();
    }
}

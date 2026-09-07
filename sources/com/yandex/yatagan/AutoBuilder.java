package com.yandex.yatagan;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AutoBuilder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\r\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0004J3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\b\b\u0001\u0010\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u0002H\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH&¢\u0006\u0002\u0010\nJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\u0002H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/yandex/yatagan/AutoBuilder;", "T", "", "create", "()Ljava/lang/Object;", "provideInput", "I", "input", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Lcom/yandex/yatagan/AutoBuilder;", "public"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AutoBuilder<T> {
    T create();

    <I> AutoBuilder<T> provideInput(I input, Class<I> clazz);

    default AutoBuilder<T> provideInput(Object input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return provideInput(input, input.getClass());
    }
}

package com.yandex.div.internal.util;

import java.lang.Number;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J$\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0086\u0002¢\u0006\u0002\u0010\fJ,\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\u00032\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0004\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000fR\u0010\u0010\u0005\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/yandex/div/internal/util/PositiveNumberDelegate;", "T", "", "", "value", "fallbackValue", "(Ljava/lang/Number;Ljava/lang/Number;)V", "Ljava/lang/Number;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Number;", "setValue", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Number;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PositiveNumberDelegate<T extends Number> {
    private final T fallbackValue;
    private T value;

    public PositiveNumberDelegate(T value, T fallbackValue) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(fallbackValue, "fallbackValue");
        this.value = value;
        this.fallbackValue = fallbackValue;
    }

    public /* synthetic */ PositiveNumberDelegate(Number number, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(number, (i & 2) != 0 ? (Number) 1 : number2);
    }

    public final T getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    public final void setValue(Object thisRef, KProperty<?> property, T value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.doubleValue() <= 0.0d) {
            value = this.fallbackValue;
        }
        this.value = value;
    }
}

package com.yandex.div.core.widget;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: Views.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0096\u0002¢\u0006\u0002\u0010\rJ*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/yandex/div/core/widget/AppearanceAffectingViewProperty;", "T", "Lkotlin/properties/ReadWriteProperty;", "Landroid/view/View;", "propertyValue", "modifier", "Lkotlin/Function1;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Landroid/view/View;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Landroid/view/View;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AppearanceAffectingViewProperty<T> implements ReadWriteProperty<View, T> {
    private final Function1<T, T> modifier;
    private T propertyValue;

    /* JADX WARN: Multi-variable type inference failed */
    public AppearanceAffectingViewProperty(T t, Function1<? super T, ? extends T> function1) {
        this.propertyValue = t;
        this.modifier = function1;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public /* bridge */ /* synthetic */ Object getValue(Object obj, KProperty kProperty) {
        return getValue((View) obj, (KProperty<?>) kProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.properties.ReadWriteProperty
    public /* bridge */ /* synthetic */ void setValue(View view, KProperty kProperty, Object obj) {
        setValue2(view, (KProperty<?>) kProperty, obj);
    }

    public T getValue(View thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        return this.propertyValue;
    }

    /* JADX INFO: renamed from: setValue, reason: avoid collision after fix types in other method */
    public void setValue2(View thisRef, KProperty<?> property, T value) {
        T tInvoke;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        Function1<T, T> function1 = this.modifier;
        if (function1 != null && (tInvoke = function1.invoke(value)) != null) {
            value = tInvoke;
        }
        if (Intrinsics.areEqual(this.propertyValue, value)) {
            return;
        }
        this.propertyValue = value;
        thisRef.invalidate();
    }
}

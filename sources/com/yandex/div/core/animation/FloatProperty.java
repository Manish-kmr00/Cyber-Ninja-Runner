package com.yandex.div.core.animation;

import android.util.Property;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatProperty.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0003H&¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/yandex/div/core/animation/FloatProperty;", "T", "Landroid/util/Property;", "", "name", "", "(Ljava/lang/String;)V", "set", "", TypedValues.AttributesType.S_TARGET, "value", "(Ljava/lang/Object;F)V", "setValue", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class FloatProperty<T> extends Property<T, Float> {
    public abstract void setValue(T target, float value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatProperty(String name) {
        super(Float.TYPE, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f) {
        set(obj, f.floatValue());
    }

    public void set(T target, float value) {
        setValue(target, value);
    }
}

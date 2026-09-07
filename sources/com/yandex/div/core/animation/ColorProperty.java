package com.yandex.div.core.animation;

import android.util.Property;
import com.yandex.div.evaluable.types.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ColorProperty.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/yandex/div/core/animation/ColorProperty;", "T", "Landroid/util/Property;", "Lcom/yandex/div/evaluable/types/Color;", "name", "", "(Ljava/lang/String;)V", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class ColorProperty<T> extends Property<T, Color> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorProperty(String name) {
        super(Color.class, name);
        Intrinsics.checkNotNullParameter(name, "name");
    }
}

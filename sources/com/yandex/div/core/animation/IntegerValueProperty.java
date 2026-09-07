package com.yandex.div.core.animation;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yandex.div.data.Variable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VariableProperties.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/yandex/div/core/animation/IntegerValueProperty;", "Lcom/yandex/div/core/animation/IntegerProperty;", "Lcom/yandex/div/data/Variable$IntegerVariable;", "()V", "get", "", TypedValues.AttributesType.S_TARGET, "(Lcom/yandex/div/data/Variable$IntegerVariable;)Ljava/lang/Integer;", "setValue", "", "value", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class IntegerValueProperty extends IntegerProperty<Variable.IntegerVariable> {
    public static final IntegerValueProperty INSTANCE = new IntegerValueProperty();

    private IntegerValueProperty() {
        super("value");
    }

    @Override // com.yandex.div.core.animation.IntegerProperty
    public void setValue(Variable.IntegerVariable target, int value) {
        Intrinsics.checkNotNullParameter(target, "target");
        target.setValueDirectly(Long.valueOf(value));
    }

    @Override // android.util.Property
    public Integer get(Variable.IntegerVariable target) {
        Intrinsics.checkNotNullParameter(target, "target");
        Object value = target.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Long");
        return Integer.valueOf((int) ((Long) value).longValue());
    }
}

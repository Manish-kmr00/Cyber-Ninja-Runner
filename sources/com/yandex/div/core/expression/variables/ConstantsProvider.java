package com.yandex.div.core.expression.variables;

import com.yandex.div.evaluable.VariableProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstantsProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yandex/div/core/expression/variables/ConstantsProvider;", "Lcom/yandex/div/evaluable/VariableProvider;", "constants", "", "", "", "(Ljava/util/Map;)V", "get", "name", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ConstantsProvider implements VariableProvider {
    private final Map<String, Object> constants;

    public ConstantsProvider(Map<String, ? extends Object> constants) {
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.constants = constants;
    }

    @Override // com.yandex.div.evaluable.VariableProvider
    public Object get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.constants.get(name);
    }
}

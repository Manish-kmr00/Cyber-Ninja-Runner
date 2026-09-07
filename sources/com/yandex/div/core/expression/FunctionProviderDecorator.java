package com.yandex.div.core.expression;

import com.json.mediationsdk.utils.IronSourceConstants;
import com.yandex.div.evaluable.EvaluableType;
import com.yandex.div.evaluable.Function;
import com.yandex.div.evaluable.FunctionProvider;
import com.yandex.div.evaluable.LocalFunctionProvider;
import com.yandex.div.evaluable.MissingLocalFunctionException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FunctionProviderDecorator.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0017\u0010\f\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yandex/div/core/expression/FunctionProviderDecorator;", "Lcom/yandex/div/evaluable/FunctionProvider;", IronSourceConstants.EVENTS_PROVIDER, "(Lcom/yandex/div/evaluable/FunctionProvider;)V", "get", "Lcom/yandex/div/evaluable/Function;", "name", "", "args", "", "Lcom/yandex/div/evaluable/EvaluableType;", "getMethod", "plus", "functions", "div_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FunctionProviderDecorator implements FunctionProvider {
    private final FunctionProvider provider;

    public FunctionProviderDecorator(FunctionProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.provider = provider;
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function get(String name, List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return this.provider.get(name, args);
    }

    @Override // com.yandex.div.evaluable.FunctionProvider
    public Function getMethod(String name, List<? extends EvaluableType> args) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        return this.provider.getMethod(name, args);
    }

    public final FunctionProviderDecorator plus(List<? extends Function> functions) {
        Intrinsics.checkNotNullParameter(functions, "functions");
        final LocalFunctionProvider localFunctionProvider = new LocalFunctionProvider(functions);
        return new FunctionProviderDecorator(new FunctionProvider() { // from class: com.yandex.div.core.expression.FunctionProviderDecorator.plus.1
            @Override // com.yandex.div.evaluable.FunctionProvider
            public Function get(String name, List<? extends EvaluableType> args) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    return localFunctionProvider.get(name, args);
                } catch (MissingLocalFunctionException unused) {
                    return this.provider.get(name, args);
                }
            }

            @Override // com.yandex.div.evaluable.FunctionProvider
            public Function getMethod(String name, List<? extends EvaluableType> args) {
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(args, "args");
                try {
                    return localFunctionProvider.getMethod(name, args);
                } catch (MissingLocalFunctionException unused) {
                    return this.provider.getMethod(name, args);
                }
            }
        });
    }
}

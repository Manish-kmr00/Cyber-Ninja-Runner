package com.smaato.sdk.core.util.fi;

/* JADX INFO: loaded from: classes7.dex */
public interface NullableFunction<T, R> {
    static /* synthetic */ Object lambda$identity$0(Object obj) {
        return obj;
    }

    R apply(T t);

    static <T> NullableFunction<T, T> identity() {
        return new NullableFunction() { // from class: com.smaato.sdk.core.util.fi.NullableFunction$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.NullableFunction
            public final Object apply(Object obj) {
                return NullableFunction.lambda$identity$0(obj);
            }
        };
    }
}

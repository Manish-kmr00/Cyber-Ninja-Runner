package com.smaato.sdk.video.fi;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes12.dex */
public final class CheckedFunctionUtils {
    static /* synthetic */ Object lambda$identity$0(Object obj) {
        return obj;
    }

    public static <T> CheckedFunction<T, T> identity() {
        return new CheckedFunction() { // from class: com.smaato.sdk.video.fi.CheckedFunctionUtils$$ExternalSyntheticLambda1
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return CheckedFunctionUtils.lambda$identity$0(obj);
            }
        };
    }

    public static <V, T, R> CheckedFunction<V, R> compose(final CheckedFunction<? super T, ? extends R> checkedFunction, final CheckedFunction<? super V, ? extends T> checkedFunction2) {
        Objects.requireNonNull(checkedFunction2);
        return new CheckedFunction() { // from class: com.smaato.sdk.video.fi.CheckedFunctionUtils$$ExternalSyntheticLambda2
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return checkedFunction.apply(checkedFunction2.apply(obj));
            }
        };
    }

    public static <V, T, R> CheckedFunction<T, V> andThen(final CheckedFunction<? super T, ? extends R> checkedFunction, final CheckedFunction<? super R, ? extends V> checkedFunction2) {
        Objects.requireNonNull(checkedFunction2);
        return new CheckedFunction() { // from class: com.smaato.sdk.video.fi.CheckedFunctionUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.CheckedFunction
            public final Object apply(Object obj) {
                return checkedFunction2.apply(checkedFunction.apply(obj));
            }
        };
    }
}

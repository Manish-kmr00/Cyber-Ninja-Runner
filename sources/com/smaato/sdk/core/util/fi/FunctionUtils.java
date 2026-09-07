package com.smaato.sdk.core.util.fi;

/* JADX INFO: loaded from: classes13.dex */
public final class FunctionUtils {
    private static final Runnable EMPTY_ACTION = new Runnable() { // from class: com.smaato.sdk.core.util.fi.FunctionUtils$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            FunctionUtils.lambda$static$0();
        }
    };
    private static final Consumer EMPTY_CONSUMER = new Consumer() { // from class: com.smaato.sdk.core.util.fi.FunctionUtils$$ExternalSyntheticLambda2
        @Override // com.smaato.sdk.core.util.fi.Consumer
        public final void accept(Object obj) {
            FunctionUtils.lambda$static$1(obj);
        }
    };

    static /* synthetic */ Object lambda$identity$2(Object obj) {
        return obj;
    }

    static /* synthetic */ void lambda$static$0() {
    }

    static /* synthetic */ void lambda$static$1(Object obj) {
    }

    public static <T> Function<T, T> identity() {
        return new Function() { // from class: com.smaato.sdk.core.util.fi.FunctionUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.fi.Function
            public final Object apply(Object obj) {
                return FunctionUtils.lambda$identity$2(obj);
            }
        };
    }

    public static <T> Consumer<T> emptyConsumer() {
        return EMPTY_CONSUMER;
    }

    public static Runnable emptyAction() {
        return EMPTY_ACTION;
    }
}

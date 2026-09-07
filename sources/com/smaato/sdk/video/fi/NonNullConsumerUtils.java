package com.smaato.sdk.video.fi;

import com.smaato.sdk.core.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class NonNullConsumerUtils {
    public static <T> NonNullConsumer<T> andThen(final NonNullConsumer<? super T> nonNullConsumer, final NonNullConsumer<? super T> nonNullConsumer2) {
        Objects.requireNonNull(nonNullConsumer2);
        return new NonNullConsumer() { // from class: com.smaato.sdk.video.fi.NonNullConsumerUtils$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.video.fi.NonNullConsumer
            public final void accept(Object obj) {
                NonNullConsumerUtils.lambda$andThen$0(nonNullConsumer, nonNullConsumer2, obj);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$0(NonNullConsumer nonNullConsumer, NonNullConsumer nonNullConsumer2, Object obj) {
        nonNullConsumer.accept(obj);
        nonNullConsumer2.accept(obj);
    }
}

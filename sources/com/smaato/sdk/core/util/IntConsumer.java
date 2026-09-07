package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes8.dex */
public interface IntConsumer {
    void accept(int i);

    default IntConsumer andThen(final IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new IntConsumer() { // from class: com.smaato.sdk.core.util.IntConsumer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.IntConsumer
            public final void accept(int i) {
                IntConsumer.lambda$andThen$0(this.f$0, intConsumer, i);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$0(IntConsumer _this, IntConsumer intConsumer, int i) {
        _this.accept(i);
        intConsumer.accept(i);
    }
}

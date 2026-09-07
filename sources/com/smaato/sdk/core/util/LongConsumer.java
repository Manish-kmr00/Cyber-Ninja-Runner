package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes8.dex */
public interface LongConsumer {
    void accept(long j);

    default LongConsumer andThen(final LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new LongConsumer() { // from class: com.smaato.sdk.core.util.LongConsumer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.LongConsumer
            public final void accept(long j) {
                LongConsumer.lambda$andThen$0(this.f$0, longConsumer, j);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$0(LongConsumer _this, LongConsumer longConsumer, long j) {
        _this.accept(j);
        longConsumer.accept(j);
    }
}

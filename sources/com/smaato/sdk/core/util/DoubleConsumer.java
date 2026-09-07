package com.smaato.sdk.core.util;

/* JADX INFO: loaded from: classes10.dex */
public interface DoubleConsumer {
    void accept(double d);

    default DoubleConsumer andThen(final DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new DoubleConsumer() { // from class: com.smaato.sdk.core.util.DoubleConsumer$$ExternalSyntheticLambda0
            @Override // com.smaato.sdk.core.util.DoubleConsumer
            public final void accept(double d) {
                DoubleConsumer.lambda$andThen$0(this.f$0, doubleConsumer, d);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$0(DoubleConsumer _this, DoubleConsumer doubleConsumer, double d) {
        _this.accept(d);
        doubleConsumer.accept(d);
    }
}

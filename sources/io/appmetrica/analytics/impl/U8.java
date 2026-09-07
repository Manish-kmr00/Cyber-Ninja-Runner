package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class U8 extends O2 {
    @Override // io.appmetrica.analytics.impl.O2
    /* JADX INFO: renamed from: a */
    public final MessageNano defaultValue() {
        return new A9();
    }

    public final A9 b() {
        return new A9();
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new A9();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final A9 toState(byte[] bArr) throws IOException {
        return (A9) MessageNano.mergeFrom(new A9(), bArr);
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: loaded from: classes4.dex */
public final class S3 extends O2 {
    @Override // io.appmetrica.analytics.impl.O2
    /* JADX INFO: renamed from: a */
    public final MessageNano defaultValue() {
        return new R3();
    }

    public final R3 b() {
        return new R3();
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new R3();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final R3 toState(byte[] bArr) {
        return (R3) MessageNano.mergeFrom(new R3(), bArr);
    }
}

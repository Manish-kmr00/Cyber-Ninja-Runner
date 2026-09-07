package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public final class Xe extends O2 {
    @Override // io.appmetrica.analytics.impl.O2
    /* JADX INFO: renamed from: a */
    public final MessageNano defaultValue() {
        return new C4043cf();
    }

    public final C4043cf b() {
        return new C4043cf();
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C4043cf();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4043cf toState(byte[] bArr) throws IOException {
        return (C4043cf) MessageNano.mergeFrom(new C4043cf(), bArr);
    }
}

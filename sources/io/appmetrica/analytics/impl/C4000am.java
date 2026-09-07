package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.am, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C4000am extends O2 {
    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Zl defaultValue() {
        Zl zl = new Zl();
        zl.i = new Ul();
        return zl;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Zl toState(byte[] bArr) throws IOException {
        return (Zl) MessageNano.mergeFrom(new Zl(), bArr);
    }
}

package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.io.IOException;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.c2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes5.dex */
public final class C4030c2 extends O2 {
    @Override // io.appmetrica.analytics.impl.O2
    /* JADX INFO: renamed from: a */
    public final MessageNano defaultValue() {
        return new C4005b2();
    }

    public final C4005b2 b() {
        return new C4005b2();
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C4005b2();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4005b2 toState(byte[] bArr) throws IOException {
        return (C4005b2) MessageNano.mergeFrom(new C4005b2(), bArr);
    }
}

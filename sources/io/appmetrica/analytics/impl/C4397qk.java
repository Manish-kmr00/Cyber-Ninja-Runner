package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.qk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4397qk extends O2 {
    @Override // io.appmetrica.analytics.impl.O2
    /* JADX INFO: renamed from: a */
    public final MessageNano defaultValue() {
        return new C4347ok();
    }

    public final C4347ok b() {
        return new C4347ok();
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    public final Object defaultValue() {
        return new C4347ok();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.StateSerializer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final C4347ok toState(byte[] bArr) {
        return (C4347ok) MessageNano.mergeFrom(new C4347ok(), bArr);
    }
}

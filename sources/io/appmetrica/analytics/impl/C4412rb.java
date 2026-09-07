package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.protobuf.nano.MessageNano;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.rb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4412rb implements Converter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sc f11748a;

    public C4412rb() {
        this(new Sc(new C4350on()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final byte[] fromModel(C4325nn c4325nn) {
        return MessageNano.toByteArray((MessageNano) this.f11748a.f11347a.fromModel(c4325nn));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        throw new UnsupportedOperationException();
    }

    public C4412rb(Sc sc) {
        this.f11748a = sc;
    }

    public final C4325nn a(byte[] bArr) {
        throw new UnsupportedOperationException();
    }
}

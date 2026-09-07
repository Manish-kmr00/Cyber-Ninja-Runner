package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.jn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes9.dex */
public final class C4225jn implements InterfaceC4504v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11624a;
    public final InterfaceC4504v3 b;

    public C4225jn(Object obj, InterfaceC4504v3 interfaceC4504v3) {
        this.f11624a = obj;
        this.b = interfaceC4504v3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4504v3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "TrimmingResult{value=" + this.f11624a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

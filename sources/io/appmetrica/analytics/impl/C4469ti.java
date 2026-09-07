package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.ti, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public final class C4469ti implements InterfaceC4504v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11783a;
    public final InterfaceC4504v3 b;

    public C4469ti(Object obj, InterfaceC4504v3 interfaceC4504v3) {
        this.f11783a = obj;
        this.b = interfaceC4504v3;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4504v3
    public final int getBytesTruncated() {
        return this.b.getBytesTruncated();
    }

    public final String toString() {
        return "Result{result=" + this.f11783a + ", metaInfo=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}

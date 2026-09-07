package io.appmetrica.analytics.impl;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: renamed from: io.appmetrica.analytics.impl.u3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes8.dex */
public class C4479u3 implements InterfaceC4504v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11790a;

    public C4479u3(int i) {
        this.f11790a = i;
    }

    public static InterfaceC4504v3 a(InterfaceC4504v3... interfaceC4504v3Arr) {
        return new C4479u3(b(interfaceC4504v3Arr));
    }

    public static int b(InterfaceC4504v3... interfaceC4504v3Arr) {
        int bytesTruncated = 0;
        for (InterfaceC4504v3 interfaceC4504v3 : interfaceC4504v3Arr) {
            if (interfaceC4504v3 != null) {
                bytesTruncated = interfaceC4504v3.getBytesTruncated() + bytesTruncated;
            }
        }
        return bytesTruncated;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC4504v3
    public final int getBytesTruncated() {
        return this.f11790a;
    }

    public String toString() {
        return "BytesTruncatedInfo{bytesTruncated=" + this.f11790a + AbstractJsonLexerKt.END_OBJ;
    }
}

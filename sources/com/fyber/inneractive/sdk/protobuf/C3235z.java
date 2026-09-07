package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;

/* JADX INFO: renamed from: com.fyber.inneractive.sdk.protobuf.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes13.dex */
public final class C3235z extends IOException {
    private static final long serialVersionUID = -6947486886997889499L;

    public C3235z(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    public C3235z(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
    }
}

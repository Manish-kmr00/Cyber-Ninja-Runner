package io.appmetrica.analytics.coreapi.internal.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes12.dex */
public interface Compressor {
    byte[] compress(byte[] bArr) throws IOException;

    byte[] uncompress(byte[] bArr) throws IOException;
}

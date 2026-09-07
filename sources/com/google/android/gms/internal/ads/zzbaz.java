package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzbaz extends PushbackInputStream {
    final /* synthetic */ zzbba zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbaz(zzbba zzbbaVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        this.zza = zzbbaVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        zzbbc.zze(this.zza.zzc);
        super.close();
    }
}

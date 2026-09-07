package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgcz {
    private final InputStream zza;

    private zzgcz(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgcz zzb(byte[] bArr) {
        return new zzgcz(new ByteArrayInputStream(bArr));
    }

    public final zzgtb zza() throws IOException {
        try {
            return zzgtb.zzg(this.zza, zzgxf.zza());
        } finally {
            this.zza.close();
        }
    }
}

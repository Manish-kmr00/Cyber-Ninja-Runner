package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgda {
    private final OutputStream zza;

    private zzgda(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgda zzb(OutputStream outputStream) {
        return new zzgda(outputStream);
    }

    public final void zza(zzgtb zzgtbVar) throws IOException {
        try {
            zzgtbVar.zzaU(this.zza);
        } finally {
            this.zza.close();
        }
    }
}

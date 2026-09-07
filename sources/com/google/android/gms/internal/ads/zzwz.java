package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzwz implements zzws {
    private final zzws zza;
    private final long zzb;

    public zzwz(zzws zzwsVar, long j) {
        this.zza = zzwsVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final int zza(zzkp zzkpVar, zzhn zzhnVar, int i) {
        int iZza = this.zza.zza(zzkpVar, zzhnVar, i);
        if (iZza != -4) {
            return iZza;
        }
        zzhnVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final int zzb(long j) {
        return this.zza.zzb(j - this.zzb);
    }

    public final zzws zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final void zzd() throws IOException {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final boolean zze() {
        return this.zza.zze();
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzwb implements zzws {
    final /* synthetic */ zzwe zza;
    private final int zzb;

    public zzwb(zzwe zzweVar, int i) {
        this.zza = zzweVar;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final int zza(zzkp zzkpVar, zzhn zzhnVar, int i) {
        return this.zza.zzj(this.zzb, zzkpVar, zzhnVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final int zzb(long j) {
        return this.zza.zzl(this.zzb, j);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final boolean zze() {
        return this.zza.zzQ(this.zzb);
    }
}

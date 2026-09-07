package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzuh implements zzwu {
    private final zzwu zza;
    private final zzfww zzb;

    public zzuh(zzwu zzwuVar, List list) {
        this.zza = zzwuVar;
        this.zzb = zzfww.zzl(list);
    }

    public final zzfww zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final long zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final long zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zzo(zzku zzkuVar) {
        return this.zza.zzo(zzkuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zzp() {
        return this.zza.zzp();
    }
}

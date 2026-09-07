package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfix extends com.google.android.gms.ads.internal.client.zzcg {
    private final zzfjd zza;

    zzfix(zzfjd zzfjdVar) {
        this.zza = zzfjdVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzbaa zze(String str) {
        return this.zza.zza(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final com.google.android.gms.ads.internal.client.zzbx zzf(String str) {
        return this.zza.zzb(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final zzbwd zzg(String str) {
        return this.zza.zzc(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzh(zzboy zzboyVar) {
        zzfjd zzfjdVar = this.zza;
        zzfjdVar.zzh(zzboyVar);
        zzfjdVar.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final void zzi(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        this.zza.zzi(list, zzceVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzj(String str) {
        return this.zza.zzj(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzk(String str) {
        return this.zza.zzk(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzch
    public final boolean zzl(String str) {
        return this.zza.zzl(str);
    }
}

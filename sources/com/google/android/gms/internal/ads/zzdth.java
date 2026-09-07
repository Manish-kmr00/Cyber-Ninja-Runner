package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
final class zzdth extends zzblk {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfgc zzd;
    final /* synthetic */ zzbzp zze;
    final /* synthetic */ zzdti zzf;

    zzdth(zzdti zzdtiVar, Object obj, String str, long j, zzfgc zzfgcVar, zzbzp zzbzpVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfgcVar;
        this.zze = zzbzpVar;
        this.zzf = zzdtiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbll
    public final void zze(String str) {
        synchronized (this.zza) {
            zzdti zzdtiVar = this.zzf;
            String str2 = this.zzb;
            zzdtiVar.zzv(str2, false, str, (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - this.zzc));
            zzdtiVar.zzl.zzb(str2, "error");
            zzdtiVar.zzo.zzb(str2, "error");
            zzfgq zzfgqVar = zzdtiVar.zzp;
            zzfgc zzfgcVar = this.zzd;
            zzfgcVar.zzc(str);
            zzfgcVar.zzg(false);
            zzfgqVar.zzc(zzfgcVar.zzm());
            this.zze.zzc(false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbll
    public final void zzf() {
        synchronized (this.zza) {
            zzdti zzdtiVar = this.zzf;
            String str = this.zzb;
            zzdtiVar.zzv(str, true, "", (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - this.zzc));
            zzdtiVar.zzl.zzd(str);
            zzdtiVar.zzo.zzd(str);
            zzfgq zzfgqVar = zzdtiVar.zzp;
            zzfgc zzfgcVar = this.zzd;
            zzfgcVar.zzg(true);
            zzfgqVar.zzc(zzfgcVar.zzm());
            this.zze.zzc(true);
        }
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzclw implements zzgbo {
    final /* synthetic */ zzfio zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv zzc;
    final /* synthetic */ zzclx zzd;

    zzclw(zzclx zzclxVar, zzfio zzfioVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.zza = zzfioVar;
        this.zzb = str;
        this.zzc = zzvVar;
        this.zzd = zzclxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(final Throwable th) {
        zzgcd zzgcdVar = this.zzd.zzg;
        final zzfio zzfioVar = this.zza;
        final String str = this.zzb;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgcdVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclu
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkt)).booleanValue();
                zzclw zzclwVar = this.zza;
                Throwable th2 = th;
                if (zBooleanValue) {
                    zzclx zzclxVar = zzclwVar.zzd;
                    zzclxVar.zzb = zzbtv.zzc(zzclxVar.zzc);
                    zzclxVar.zzb.zzh(th2, "AttributionReporting.registerSourceAndPingClickUrl");
                } else {
                    zzclx zzclxVar2 = zzclwVar.zzd;
                    zzclxVar2.zza = zzbtv.zza(zzclxVar2.zzc);
                    zzclxVar2.zza.zzh(th2, "AttributionReportingSampled.registerSourceAndPingClickUrl");
                }
                com.google.android.gms.ads.internal.util.client.zzv zzvVar2 = zzvVar;
                zzfioVar.zzd(str, zzvVar2, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        final zzfio zzfioVar = this.zza;
        final String str = (String) obj;
        zzgcd zzgcdVar = this.zzd.zzg;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.zzc;
        zzgcdVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzclv
            @Override // java.lang.Runnable
            public final void run() {
                zzfioVar.zzd(str, zzvVar, null, null);
            }
        });
    }
}

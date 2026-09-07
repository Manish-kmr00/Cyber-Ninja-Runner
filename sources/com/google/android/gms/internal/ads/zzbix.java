package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzbix implements zzgbo {
    final /* synthetic */ zzcel zza;

    zzbix(zzcel zzcelVar) {
        this.zza = zzcelVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgbo
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcel zzcelVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbw(zzcelVar.getContext(), zzcelVar.zzm().afmaVersion, str, null, zzcelVar.zzD() != null ? zzcelVar.zzD().zzax : null).zzb();
    }
}

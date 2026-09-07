package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzboc implements zzbzr {
    final /* synthetic */ zzbzp zza;
    final /* synthetic */ zzbng zzb;

    zzboc(zzboe zzboeVar, zzbzp zzbzpVar, zzbng zzbngVar) {
        this.zza = zzbzpVar;
        this.zzb = zzbngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzr
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbnp("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}

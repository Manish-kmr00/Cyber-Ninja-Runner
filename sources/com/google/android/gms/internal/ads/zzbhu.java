package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbhu {
    private final com.google.android.gms.ads.formats.zzg zza;
    private final com.google.android.gms.ads.formats.zzf zzb;
    private zzbgo zzc;

    public zzbhu(com.google.android.gms.ads.formats.zzg zzgVar, com.google.android.gms.ads.formats.zzf zzfVar) {
        this.zza = zzgVar;
        this.zzb = zzfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzbgo zzf(zzbgn zzbgnVar) {
        zzbgo zzbgoVar = this.zzc;
        if (zzbgoVar != null) {
            return zzbgoVar;
        }
        zzbgo zzbgoVar2 = new zzbgo(zzbgnVar);
        this.zzc = zzbgoVar2;
        return zzbgoVar2;
    }

    public final zzbgx zzc() {
        zzbht zzbhtVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzbhr(this, zzbhtVar);
    }

    public final zzbha zzd() {
        return new zzbhs(this, null);
    }
}

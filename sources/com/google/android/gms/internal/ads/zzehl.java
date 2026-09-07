package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzehl implements zzcwl {
    boolean zza = false;
    final /* synthetic */ zzeci zzb;
    final /* synthetic */ zzbzp zzc;

    zzehl(zzehm zzehmVar, zzeci zzeciVar, zzbzp zzbzpVar) {
        this.zzb = zzeciVar;
        this.zzc = zzbzpVar;
    }

    private final synchronized void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        int i = 1;
        if (true == ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfB)).booleanValue()) {
            i = 3;
        }
        this.zzc.zzd(new zzecj(i, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcwl
    public final synchronized void zza(int i) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(new com.google.android.gms.ads.internal.client.zze(i, zzehm.zze(this.zzb.zza, i), "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcwl
    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        zze(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcwl
    public final synchronized void zzc(int i, String str) {
        if (this.zza) {
            return;
        }
        this.zza = true;
        if (str == null) {
            str = zzehm.zze(this.zzb.zza, i);
        }
        zze(new com.google.android.gms.ads.internal.client.zze(i, str, "undefined", null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzcwl
    public final synchronized void zzd() {
        this.zzc.zzc(null);
    }
}

package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdab implements zzcya {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbt)).intValue();
    private int zzb = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmS)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final synchronized void zzdm(zzfbg zzfbgVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbu)).booleanValue()) {
            try {
                zzfax zzfaxVar = zzfbgVar.zzb.zzb;
                this.zza = zzfaxVar.zzc;
                this.zzb = zzfaxVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}

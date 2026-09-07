package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdvi implements zzcya, zzddo, zzcwq {
    private final Context zza;
    private final zzdre zzb;

    zzdvi(Context context, zzdre zzdreVar) {
        this.zza = context;
        this.zzb = zzdreVar;
    }

    private final void zzd(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeN)).booleanValue()) {
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvh
                @Override // java.lang.Runnable
                public final void run() {
                    com.google.android.gms.ads.internal.zzv.zzf().zzd(context, this.zza.zzb);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdl(zzbuy zzbuyVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeP)).booleanValue()) {
            zzd(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcya
    public final void zzdm(zzfbg zzfbgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeQ)).booleanValue()) {
            zzd(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddo
    public final void zzf(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzt() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeR)).booleanValue()) {
            zzd(this.zza);
        }
    }
}

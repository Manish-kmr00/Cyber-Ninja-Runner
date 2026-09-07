package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcik implements zzdso {
    private final zzchv zza;
    private Context zzb;
    private zzbki zzc;

    /* synthetic */ zzcik(zzchv zzchvVar, zzciz zzcizVar) {
        this.zza = zzchvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final zzdsp zzc() {
        zzhfg.zzc(this.zzb, Context.class);
        zzhfg.zzc(this.zzc, zzbki.class);
        return new zzcil(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final /* bridge */ /* synthetic */ zzdso zza(zzbki zzbkiVar) {
        zzbkiVar.getClass();
        this.zzc = zzbkiVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final /* bridge */ /* synthetic */ zzdso zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

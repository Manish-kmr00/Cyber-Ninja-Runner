package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcip implements zzeyz {
    private final zzchv zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzr zzd;

    /* synthetic */ zzcip(zzchv zzchvVar, zzciz zzcizVar) {
        this.zza = zzchvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeyz
    public final zzeza zzd() {
        zzhfg.zzc(this.zzb, Context.class);
        zzhfg.zzc(this.zzc, String.class);
        zzhfg.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzr.class);
        return new zzciq(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzeyz
    public final /* bridge */ /* synthetic */ zzeyz zza(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.zzd = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeyz
    public final /* bridge */ /* synthetic */ zzeyz zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeyz
    public final /* bridge */ /* synthetic */ zzeyz zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

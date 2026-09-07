package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcir implements zzfan {
    private final zzchv zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcir(zzchv zzchvVar, zzciz zzcizVar) {
        this.zza = zzchvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfan
    public final /* synthetic */ zzfan zza(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfan
    public final zzfao zzc() {
        zzhfg.zzc(this.zzb, Context.class);
        return new zzcis(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfan
    public final /* bridge */ /* synthetic */ zzfan zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

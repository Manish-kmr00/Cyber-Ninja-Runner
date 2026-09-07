package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzchz implements zzevu {
    private final zzchv zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzchz(zzchv zzchvVar, zzciz zzcizVar) {
        this.zza = zzchvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevu
    public final zzevv zzc() {
        zzhfg.zzc(this.zzb, Context.class);
        zzhfg.zzc(this.zzc, String.class);
        return new zzcia(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzevu
    public final /* bridge */ /* synthetic */ zzevu zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzevu
    public final /* bridge */ /* synthetic */ zzevu zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}

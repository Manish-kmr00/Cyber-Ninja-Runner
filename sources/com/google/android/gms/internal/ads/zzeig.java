package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzeig implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdeb zza;

    zzeig(zzeih zzeihVar, zzdeb zzdebVar) {
        this.zza = zzdebVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdeb zzdebVar = this.zza;
        zzdebVar.zzc().zza();
        zzdebVar.zzf().zza();
    }
}

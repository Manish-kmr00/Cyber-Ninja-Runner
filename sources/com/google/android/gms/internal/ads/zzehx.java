package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzehx implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzbzp zza;
    final /* synthetic */ zzfbg zzb;
    final /* synthetic */ zzfau zzc;
    final /* synthetic */ zzeid zzd;
    final /* synthetic */ zzehy zze;

    zzehx(zzehy zzehyVar, zzbzp zzbzpVar, zzfbg zzfbgVar, zzfau zzfauVar, zzeid zzeidVar) {
        this.zza = zzbzpVar;
        this.zzb = zzfbgVar;
        this.zzc = zzfauVar;
        this.zzd = zzeidVar;
        this.zze = zzehyVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        this.zza.zzc(this.zze.zzd.zza(this.zzb, this.zzc, view, this.zzd));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}

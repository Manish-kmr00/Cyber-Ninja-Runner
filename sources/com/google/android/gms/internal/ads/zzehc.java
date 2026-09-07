package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
final class zzehc extends zzbvu {
    final /* synthetic */ zzcxi zza;
    final /* synthetic */ zzcva zzb;
    final /* synthetic */ zzcwj zzc;
    final /* synthetic */ zzddl zzd;

    zzehc(zzehd zzehdVar, zzcxi zzcxiVar, zzcva zzcvaVar, zzcwj zzcwjVar, zzddl zzddlVar) {
        this.zza = zzcxiVar;
        this.zzb = zzcvaVar;
        this.zzc = zzcwjVar;
        this.zzd = zzddlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zze(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zza.zzds(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzg(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzdp();
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzk(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzl(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzm(IObjectWrapper iObjectWrapper, zzbvw zzbvwVar) {
        this.zzd.zza(zzbvwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzd.zza(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbvv
    public final void zzp(IObjectWrapper iObjectWrapper) {
        this.zzd.zzc();
    }
}

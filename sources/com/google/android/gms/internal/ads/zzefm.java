package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefm extends zzefj {
    private final zzcgl zza;
    private final zzcuj zzb;
    private final zzeia zzc;
    private final zzdaw zzd;
    private final zzdfv zze;
    private final zzcxv zzf;
    private final ViewGroup zzg;
    private final zzdab zzh;
    private final zzefu zzi;
    private final zzeck zzj;

    public zzefm(zzcgl zzcglVar, zzcuj zzcujVar, zzeia zzeiaVar, zzdaw zzdawVar, zzdfv zzdfvVar, zzcxv zzcxvVar, ViewGroup viewGroup, zzdab zzdabVar, zzefu zzefuVar, zzeck zzeckVar) {
        this.zza = zzcglVar;
        this.zzb = zzcujVar;
        this.zzc = zzeiaVar;
        this.zzd = zzdawVar;
        this.zze = zzdfvVar;
        this.zzf = zzcxvVar;
        this.zzg = viewGroup;
        this.zzh = zzdabVar;
        this.zzi = zzefuVar;
        this.zzj = zzeckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefj
    protected final ListenableFuture zzc(zzfbp zzfbpVar, Bundle bundle, zzfau zzfauVar, zzfbg zzfbgVar) {
        zzcuj zzcujVar = this.zzb;
        zzcujVar.zzk(zzfbpVar);
        zzcujVar.zzg(bundle);
        zzcujVar.zzh(new zzcuc(zzfbgVar, zzfauVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdO)).booleanValue()) {
            zzcujVar.zze(this.zzj);
        }
        zzcpc zzcpcVarZzd = this.zza.zzd();
        zzcpcVarZzd.zzi(zzcujVar.zzl());
        zzcpcVarZzd.zzf(this.zzd);
        zzcpcVarZzd.zze(this.zzc);
        zzcpcVarZzd.zzd(this.zze);
        zzcpcVarZzd.zzg(new zzcpy(this.zzf, this.zzh));
        zzcpcVarZzd.zzc(new zzcnw(this.zzg));
        zzcrk zzcrkVarZzc = zzcpcVarZzd.zzk().zzc();
        return zzcrkVarZzc.zzh(zzcrkVarZzc.zzi());
    }
}

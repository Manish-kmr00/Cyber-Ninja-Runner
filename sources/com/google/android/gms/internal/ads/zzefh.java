package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefh extends zzefj {
    private final zzcgl zza;
    private final zzdfv zzb;
    private final zzcuj zzc;
    private final zzdaw zzd;
    private final zzefu zze;
    private final zzeck zzf;

    public zzefh(zzcgl zzcglVar, zzdfv zzdfvVar, zzcuj zzcujVar, zzdaw zzdawVar, zzefu zzefuVar, zzeck zzeckVar) {
        this.zza = zzcglVar;
        this.zzb = zzdfvVar;
        this.zzc = zzcujVar;
        this.zzd = zzdawVar;
        this.zze = zzefuVar;
        this.zzf = zzeckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefj
    protected final ListenableFuture zzc(zzfbp zzfbpVar, Bundle bundle, zzfau zzfauVar, zzfbg zzfbgVar) {
        zzcuj zzcujVar = this.zzc;
        zzcujVar.zzk(zzfbpVar);
        zzcujVar.zzg(bundle);
        zzcujVar.zzh(new zzcuc(zzfbgVar, zzfauVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdO)).booleanValue()) {
            zzcujVar.zze(this.zzf);
        }
        zzdfz zzdfzVarZzg = this.zza.zzg();
        zzdfzVarZzg.zzf(zzcujVar.zzl());
        zzdfzVarZzg.zze(this.zzd);
        zzdfzVarZzg.zzd(this.zzb);
        zzdfzVarZzg.zzc(new zzcnw(null));
        zzcrk zzcrkVarZza = zzdfzVarZzg.zzg().zza();
        return zzcrkVarZza.zzh(zzcrkVarZza.zzi());
    }
}

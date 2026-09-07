package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefk extends zzefj {
    private final zzcgl zza;
    private final zzcuj zzb;
    private final zzdaw zzc;
    private final zzefu zzd;
    private final zzeck zze;

    zzefk(zzcgl zzcglVar, zzcuj zzcujVar, zzdaw zzdawVar, zzefu zzefuVar, zzeck zzeckVar) {
        this.zza = zzcglVar;
        this.zzb = zzcujVar;
        this.zzc = zzdawVar;
        this.zzd = zzefuVar;
        this.zze = zzeckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefj
    protected final ListenableFuture zzc(zzfbp zzfbpVar, Bundle bundle, zzfau zzfauVar, zzfbg zzfbgVar) {
        zzcuj zzcujVar = this.zzb;
        zzcujVar.zzk(zzfbpVar);
        zzcujVar.zzg(bundle);
        zzcujVar.zzh(new zzcuc(zzfbgVar, zzfauVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdO)).booleanValue()) {
            zzcujVar.zze(this.zze);
        }
        zzcnm zzcnmVarZzc = this.zza.zzc();
        zzcnmVarZzc.zzd(zzcujVar.zzl());
        zzcnmVarZzc.zzc(this.zzc);
        zzcrk zzcrkVarZzb = zzcnmVarZzc.zze().zzb();
        return zzcrkVarZzb.zzh(zzcrkVarZzb.zzi());
    }
}

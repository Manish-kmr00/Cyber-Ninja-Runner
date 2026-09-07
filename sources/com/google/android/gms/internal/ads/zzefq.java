package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzefq extends zzefj {
    private final zzcgl zza;
    private final zzcuj zzb;
    private final zzdaw zzc;
    private final zzefu zzd;

    @Nullable
    private final zzfbh zze;
    private final zzeck zzf;

    public zzefq(zzcgl zzcglVar, zzcuj zzcujVar, zzdaw zzdawVar, @Nullable zzfbh zzfbhVar, zzefu zzefuVar, zzeck zzeckVar) {
        this.zza = zzcglVar;
        this.zzb = zzcujVar;
        this.zzc = zzdawVar;
        this.zze = zzfbhVar;
        this.zzd = zzefuVar;
        this.zzf = zzeckVar;
    }

    @Override // com.google.android.gms.internal.ads.zzefj
    protected final ListenableFuture zzc(zzfbp zzfbpVar, Bundle bundle, zzfau zzfauVar, zzfbg zzfbgVar) {
        zzfbh zzfbhVar;
        zzcuj zzcujVar = this.zzb;
        zzcujVar.zzk(zzfbpVar);
        zzcujVar.zzg(bundle);
        zzcujVar.zzh(new zzcuc(zzfbgVar, zzfauVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdN)).booleanValue() && (zzfbhVar = this.zze) != null) {
            zzcujVar.zzj(zzfbhVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdO)).booleanValue()) {
            zzcujVar.zze(this.zzf);
        }
        zzdnm zzdnmVarZzh = this.zza.zzh();
        zzdnmVarZzh.zzd(zzcujVar.zzl());
        zzdnmVarZzh.zzc(this.zzc);
        zzcrk zzcrkVarZzb = zzdnmVarZzh.zze().zzb();
        return zzcrkVarZzb.zzh(zzcrkVarZzb.zzi());
    }
}

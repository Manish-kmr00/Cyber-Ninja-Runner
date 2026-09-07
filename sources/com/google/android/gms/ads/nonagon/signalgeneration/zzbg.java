package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzcuf;
import com.google.android.gms.internal.ads.zzcug;
import com.google.android.gms.internal.ads.zzcut;
import com.google.android.gms.internal.ads.zzddr;
import com.google.android.gms.internal.ads.zzdqm;
import com.google.android.gms.internal.ads.zzffn;
import com.google.android.gms.internal.ads.zzfft;
import com.google.android.gms.internal.ads.zzgbs;
import com.google.android.gms.internal.ads.zzhey;
import com.google.android.gms.internal.ads.zzhfg;
import com.google.android.gms.internal.ads.zzhfh;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzbg implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;
    private final zzhfh zzd;
    private final zzhfh zze;
    private final zzhfh zzf;
    private final zzhfh zzg;
    private final zzhfh zzh;
    private final zzhfh zzi;

    public zzbg(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4, zzhfh zzhfhVar5, zzhfh zzhfhVar6, zzhfh zzhfhVar7, zzhfh zzhfhVar8, zzhfh zzhfhVar9) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar3;
        this.zzd = zzhfhVar4;
        this.zze = zzhfhVar5;
        this.zzf = zzhfhVar6;
        this.zzg = zzhfhVar7;
        this.zzh = zzhfhVar8;
        this.zzi = zzhfhVar9;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        ListenableFuture listenableFutureZza;
        zzau zzauVar = (zzau) this.zza.zzb();
        zzfft zzfftVar = (zzfft) this.zzb.zzb();
        zzbi zzbiVarZzb = ((zzbj) this.zzc).zzb();
        zzcuf zzcufVarZzb = ((zzcug) this.zzd).zzb();
        zzddr zzddrVar = (zzddr) this.zze.zzb();
        zzb zzbVar = (zzb) this.zzf.zzb();
        zzbym zzbymVar = (zzbym) this.zzg.zzb();
        int iIntValue = ((Integer) this.zzh.zzb()).intValue();
        Bundle bundle = ((zzcut) this.zzi).zza().zzs;
        zzbk zzbkVarZza = null;
        if (iIntValue == 1 && zzbymVar != null) {
            bundle.putLong(zzdqm.READ_FROM_DISK_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
            zzbkVarZza = zzbVar.zza(zzbymVar, zzauVar, bundle);
            bundle.putLong(zzdqm.READ_FROM_DISK_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        if (zzbkVarZza != null) {
            zzddrVar.zza(zzbkVarZza);
            listenableFutureZza = zzgbs.zzh(zzbkVarZza);
        } else {
            listenableFutureZza = zzfftVar.zzb(zzffn.GENERATE_SIGNALS, zzcufVarZzb.zzc()).zzf(zzbiVarZzb).zzi(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfF)).intValue(), TimeUnit.SECONDS).zza();
            zzgbs.zzr(listenableFutureZza, new zzaw(zzddrVar), zzbzk.zza);
        }
        zzhfg.zzb(listenableFutureZza);
        return listenableFutureZza;
    }
}

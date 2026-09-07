package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzdqd implements zzhey {
    private final zzhfh zza;
    private final zzhfh zzb;
    private final zzhfh zzc;

    public zzdqd(zzhfh zzhfhVar, zzhfh zzhfhVar2, zzhfh zzhfhVar3, zzhfh zzhfhVar4) {
        this.zza = zzhfhVar;
        this.zzb = zzhfhVar2;
        this.zzc = zzhfhVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzhfn, com.google.android.gms.internal.ads.zzhfm
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet;
        final String strZza = ((zzevh) this.zza).zza();
        Context contextZza = ((zzcgs) this.zzb).zza();
        zzgcd zzgcdVarZzc = zzfen.zzc();
        Map mapZzb = ((zzhfc) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfg)).booleanValue()) {
            zzbbg zzbbgVar = new zzbbg(new zzbbm(contextZza));
            zzbbgVar.zzb(new zzbbf() { // from class: com.google.android.gms.internal.ads.zzdqe
                @Override // com.google.android.gms.internal.ads.zzbbf
                public final void zza(zzbbn.zzt.zza zzaVar) {
                    zzaVar.zzO(strZza);
                }
            });
            setEmptySet = Collections.singleton(new zzdcu(new zzdqg(zzbbgVar, mapZzb), zzgcdVarZzc));
        } else {
            setEmptySet = Collections.emptySet();
        }
        zzhfg.zzb(setEmptySet);
        return setEmptySet;
    }
}

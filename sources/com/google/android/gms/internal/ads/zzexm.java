package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexm implements zzeyl {
    private zzcui zza;
    private final Executor zzb = zzgck.zzc();

    public final zzcui zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzeym zzeymVar, zzeyk zzeykVar, zzcui zzcuiVar) {
        zzcuh zzcuhVarZza = zzeykVar.zza(zzeymVar.zzb);
        zzcuhVarZza.zzb(new zzeyp(true));
        zzcui zzcuiVar2 = (zzcui) zzcuhVarZza.zzh();
        this.zza = zzcuiVar2;
        final zzcrk zzcrkVarZzb = zzcuiVar2.zzb();
        final zzfdl zzfdlVar = new zzfdl();
        zzgbj zzgbjVarZzE = zzgbj.zzE(zzcrkVarZzb.zzi());
        zzgaz zzgazVar = new zzgaz(this) { // from class: com.google.android.gms.internal.ads.zzexk
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                zzfbg zzfbgVar = (zzfbg) obj;
                zzfdlVar.zzb = zzfbgVar;
                Iterator it = zzfbgVar.zzb.zza.iterator();
                boolean z = false;
                while (it.hasNext()) {
                    Iterator it2 = ((zzfau) it.next()).zza.iterator();
                    while (it2.hasNext()) {
                        if (!((String) it2.next()).contains("FirstPartyRenderer")) {
                            return zzgbs.zzh(null);
                        }
                        z = true;
                    }
                }
                if (z) {
                    return zzcrkVarZzb.zzh(zzgbs.zzh(zzfbgVar));
                }
                return zzgbs.zzh(null);
            }
        };
        Executor executor = this.zzb;
        return (zzgbj) zzgbs.zzm((zzgbj) zzgbs.zzn(zzgbjVarZzE, zzgazVar, executor), new zzftl() { // from class: com.google.android.gms.internal.ads.zzexl
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                zzfdl zzfdlVar2 = zzfdlVar;
                zzfdlVar2.zzc = (zzcqg) obj;
                return zzfdlVar2;
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzeym zzeymVar, zzeyk zzeykVar, Object obj) {
        return zzb(zzeymVar, zzeykVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzeyl
    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}

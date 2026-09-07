package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfio {
    private final Context zza;
    private final Executor zzb;
    private final zzgce zzc;
    private final com.google.android.gms.ads.internal.util.client.zzu zzd;
    private final zzfig zze;
    private final zzfgq zzf;

    zzfio(Context context, Executor executor, zzgce zzgceVar, com.google.android.gms.ads.internal.util.client.zzu zzuVar, zzfig zzfigVar, zzfgq zzfgqVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzgceVar;
        this.zzd = zzuVar;
        this.zze = zzfigVar;
        this.zzf = zzfgqVar;
    }

    public final void zzd(final String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar, zzfgn zzfgnVar, zzcxm zzcxmVar) {
        ListenableFuture listenableFutureZzb;
        zzfgc zzfgcVarZza = null;
        if (zzfgq.zza() && ((Boolean) zzbeb.zzd.zze()).booleanValue()) {
            zzfgcVarZza = zzfgb.zza(this.zza, 14);
            zzfgcVarZza.zzi();
        }
        if (zzvVar != null) {
            listenableFutureZzb = new zzfif(zzvVar.zzb(), this.zzd, this.zzc, this.zze).zzd(str);
        } else {
            listenableFutureZzb = this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzfim
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzd.zza(str);
                }
            });
        }
        zzgbs.zzr(listenableFutureZzb, new zzfin(this, zzfgcVarZza, zzfgnVar, zzcxmVar), this.zzb);
    }

    public final void zze(List list, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzd((String) it.next(), zzvVar, null, null);
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfee {
    private final zzfdx zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfee(final zzfdc zzfdcVar, final zzfdw zzfdwVar, final zzfdx zzfdxVar) {
        this.zza = zzfdxVar;
        this.zzb = zzgbs.zzf(zzgbs.zzn(zzfdwVar.zza(zzfdxVar), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzfec
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzfee.zzb(this.zza, zzfdwVar, zzfdcVar, zzfdxVar, (zzfdl) obj);
            }
        }, zzfdxVar.zzb()), Exception.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzfed
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzfee.zza(this.zza, zzfdwVar, (Exception) obj);
            }
        }, zzfdxVar.zzb());
    }

    public static /* synthetic */ ListenableFuture zza(zzfee zzfeeVar, zzfdw zzfdwVar, Exception exc) {
        synchronized (zzfeeVar) {
            zzfeeVar.zzd = true;
            throw exc;
        }
    }

    public static /* synthetic */ ListenableFuture zzb(zzfee zzfeeVar, zzfdw zzfdwVar, zzfdc zzfdcVar, zzfdx zzfdxVar, zzfdl zzfdlVar) {
        ListenableFuture listenableFutureZzh;
        synchronized (zzfeeVar) {
            zzfeeVar.zzd = true;
            zzfdwVar.zzb(zzfdlVar);
            if (zzfeeVar.zzc) {
                listenableFutureZzh = zzgbs.zzh(new zzfdv(zzfdlVar, zzfdxVar));
            } else {
                zzfdcVar.zzd(zzfdxVar.zza(), zzfdlVar);
                listenableFutureZzh = zzgbs.zzh(null);
            }
        }
        return listenableFutureZzh;
    }

    public final synchronized ListenableFuture zzc(zzfdx zzfdxVar) {
        if (!this.zzd && !this.zzc) {
            zzfdx zzfdxVar2 = this.zza;
            if (zzfdxVar2.zza() != null && zzfdxVar.zza() != null && zzfdxVar2.zza().equals(zzfdxVar.zza())) {
                this.zzc = true;
                return this.zzb;
            }
        }
        return null;
    }

    public final synchronized void zzd(zzgbo zzgboVar) {
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzfeb
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzi();
            }
        };
        zzfdx zzfdxVar = this.zza;
        zzgbs.zzr(zzgbs.zzn(this.zzb, zzgazVar, zzfdxVar.zzb()), zzgboVar, zzfdxVar.zzb());
    }
}

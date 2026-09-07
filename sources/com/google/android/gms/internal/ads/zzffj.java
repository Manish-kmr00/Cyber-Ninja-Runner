package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzffj {
    final /* synthetic */ zzffl zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzffj(zzffl zzfflVar, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfflVar;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    public final zzfez zza() {
        Object obj = this.zzb;
        String strZzf = this.zzc;
        if (strZzf == null) {
            strZzf = this.zza.zzf(obj);
        }
        final zzfez zzfezVar = new zzfez(obj, strZzf, this.zzf);
        this.zza.zzd.zza(zzfezVar);
        this.zzd.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zzd.zzc(zzfezVar);
            }
        }, zzbzk.zzg);
        zzgbs.zzr(zzfezVar, new zzffi(this, zzfezVar), zzbzk.zzg);
        return zzfezVar;
    }

    public final zzffj zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzffj zzc(Class cls, zzgaz zzgazVar) {
        zzffl zzfflVar = this.zza;
        return new zzffj(zzfflVar, this.zzb, this.zzc, this.zzd, this.zze, zzgbs.zzf(this.zzf, cls, zzgazVar, zzfflVar.zzb));
    }

    public final zzffj zzd(final ListenableFuture listenableFuture) {
        return zzg(new zzgaz() { // from class: com.google.android.gms.internal.ads.zzffg
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return listenableFuture;
            }
        }, zzbzk.zzg);
    }

    public final zzffj zze(final zzfex zzfexVar) {
        return zzf(new zzgaz() { // from class: com.google.android.gms.internal.ads.zzfff
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(zzfexVar.zza(obj));
            }
        });
    }

    public final zzffj zzf(zzgaz zzgazVar) {
        return zzg(zzgazVar, this.zza.zzb);
    }

    public final zzffj zzg(zzgaz zzgazVar, Executor executor) {
        return new zzffj(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgbs.zzn(this.zzf, zzgazVar, executor));
    }

    public final zzffj zzh(String str) {
        return new zzffj(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzffj zzi(long j, TimeUnit timeUnit) {
        zzffl zzfflVar = this.zza;
        return new zzffj(zzfflVar, this.zzb, this.zzc, this.zzd, this.zze, zzgbs.zzo(this.zzf, j, timeUnit, zzfflVar.zzc));
    }
}

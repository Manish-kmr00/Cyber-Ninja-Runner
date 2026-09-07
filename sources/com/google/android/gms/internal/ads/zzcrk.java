package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzcrk {
    private final zzdwu zza;
    private final zzfbp zzb;
    private final zzfft zzc;
    private final zzckl zzd;
    private final zzegb zze;
    private final zzdak zzf;
    private zzfbg zzg;
    private final zzdyc zzh;
    private final zzcuf zzi;
    private final Executor zzj;
    private final zzdxn zzk;
    private final zzeck zzl;

    zzcrk(zzdwu zzdwuVar, zzfbp zzfbpVar, zzfft zzfftVar, zzckl zzcklVar, zzegb zzegbVar, zzdak zzdakVar, zzfbg zzfbgVar, zzdyc zzdycVar, zzcuf zzcufVar, Executor executor, zzdxn zzdxnVar, zzeck zzeckVar) {
        this.zza = zzdwuVar;
        this.zzb = zzfbpVar;
        this.zzc = zzfftVar;
        this.zzd = zzcklVar;
        this.zze = zzegbVar;
        this.zzf = zzdakVar;
        this.zzg = zzfbgVar;
        this.zzh = zzdycVar;
        this.zzi = zzcufVar;
        this.zzj = executor;
        this.zzk = zzdxnVar;
        this.zzl = zzeckVar;
    }

    public static /* synthetic */ zzfbg zzd(zzcrk zzcrkVar, zzfbg zzfbgVar) throws Exception {
        zzcrkVar.zzd.zza(zzfbgVar);
        return zzfbgVar;
    }

    public static /* synthetic */ ListenableFuture zze(zzcrk zzcrkVar, zzfdj zzfdjVar, zzbuy zzbuyVar) {
        zzbuyVar.zzi = zzfdjVar;
        return zzcrkVar.zzh.zze(zzbuyVar);
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfcq.zzb(th, this.zzl);
    }

    public final zzdak zzc() {
        return this.zzf;
    }

    public final ListenableFuture zzf(final zzfdj zzfdjVar) {
        zzfez zzfezVarZza = this.zzc.zzb(zzffn.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzgaz() { // from class: com.google.android.gms.internal.ads.zzcrg
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzcrk.zze(this.zza, zzfdjVar, (zzbuy) obj);
            }
        }).zza();
        zzgbs.zzr(zzfezVarZza, new zzcri(this), this.zzj);
        return zzfezVarZza;
    }

    public final ListenableFuture zzg(zzbuy zzbuyVar) {
        zzfez zzfezVarZza = this.zzc.zzb(zzffn.NOTIFY_CACHE_HIT, this.zzh.zzf(zzbuyVar)).zza();
        zzgbs.zzr(zzfezVarZza, new zzcrj(this), this.zzj);
        return zzfezVarZza;
    }

    public final ListenableFuture zzh(ListenableFuture listenableFuture) {
        zzffj zzffjVarZzf = this.zzc.zzb(zzffn.RENDERER, listenableFuture).zze(new zzfex() { // from class: com.google.android.gms.internal.ads.zzcrf
            @Override // com.google.android.gms.internal.ads.zzfex
            public final Object zza(Object obj) throws Exception {
                zzfbg zzfbgVar = (zzfbg) obj;
                zzcrk.zzd(this.zza, zzfbgVar);
                return zzfbgVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfE)).booleanValue()) {
            zzffjVarZzf = zzffjVarZzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfF)).intValue(), TimeUnit.SECONDS);
        }
        return zzffjVarZzf.zza();
    }

    public final ListenableFuture zzi() {
        com.google.android.gms.ads.internal.client.zzm zzmVar = this.zzb.zzd;
        if (zzmVar.zzx == null && zzmVar.zzs == null) {
            return zzj(this.zzi.zzc());
        }
        zzfft zzfftVar = this.zzc;
        zzdwu zzdwuVar = this.zza;
        return zzffd.zzc(zzdwuVar.zzc(), zzffn.PRELOADED_LOADER, zzfftVar).zza();
    }

    public final ListenableFuture zzj(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzfft zzfftVar = this.zzc;
            return zzffd.zzc(zzgbs.zzh(this.zzg), zzffn.SERVER_TRANSACTION, zzfftVar).zza();
        }
        com.google.android.gms.ads.internal.zzv.zzc().zzj();
        zzffj zzffjVarZzb = this.zzc.zzb(zzffn.SERVER_TRANSACTION, listenableFuture);
        final zzdxn zzdxnVar = this.zzk;
        Objects.requireNonNull(zzdxnVar);
        return zzffjVarZzb.zzf(new zzgaz() { // from class: com.google.android.gms.internal.ads.zzcrh
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdxnVar.zzc((zzbuy) obj);
            }
        }).zza();
    }

    public final void zzk(zzfbg zzfbgVar) {
        this.zzg = zzfbgVar;
    }
}

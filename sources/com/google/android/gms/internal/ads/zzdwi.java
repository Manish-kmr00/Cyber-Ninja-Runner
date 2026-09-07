package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdwi {
    private final ScheduledExecutorService zza;
    private final zzgcd zzb;
    private final zzgcd zzc;
    private final zzdxd zzd;
    private final zzhes zze;

    public zzdwi(ScheduledExecutorService scheduledExecutorService, zzgcd zzgcdVar, zzgcd zzgcdVar2, zzdxd zzdxdVar, zzhes zzhesVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgcdVar;
        this.zzc = zzgcdVar2;
        this.zzd = zzdxdVar;
        this.zze = zzhesVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdxr zza(zzdwi zzdwiVar, zzbuy zzbuyVar) {
        return (zzdxr) zzdwiVar.zzd.zza(zzbuyVar).get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfF)).intValue(), TimeUnit.SECONDS);
    }

    public static /* synthetic */ ListenableFuture zzb(zzdwi zzdwiVar, final zzbuy zzbuyVar, int i, Throwable th) {
        Bundle bundle;
        if (zzbuyVar != null && (bundle = zzbuyVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgbs.zzn(((zzdyu) zzdwiVar.zze.zzb()).zzd(zzbuyVar, i), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwf
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(new zzdxr((InputStream) obj, zzbuyVar));
            }
        }, zzdwiVar.zzb);
    }

    public final ListenableFuture zzc(final zzbuy zzbuyVar) {
        ListenableFuture listenableFutureZzb;
        String str = zzbuyVar.zzd;
        com.google.android.gms.ads.internal.zzv.zzq();
        if (com.google.android.gms.ads.internal.util.zzs.zzD(str)) {
            listenableFutureZzb = zzgbs.zzg(new zzdxq(1));
        } else {
            listenableFutureZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhw)).booleanValue() ? this.zzc.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdwg
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzdwi.zza(this.zza, zzbuyVar);
                }
            }) : this.zzd.zza(zzbuyVar);
        }
        final int callingUid = Binder.getCallingUid();
        return (zzgbj) zzgbs.zzf((zzgbj) zzgbs.zzo(zzgbj.zzE(listenableFutureZzb), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfF)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwh
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdwi.zzb(this.zza, zzbuyVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }
}

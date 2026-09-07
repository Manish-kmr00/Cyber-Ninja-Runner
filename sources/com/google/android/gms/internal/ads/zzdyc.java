package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdyc {
    private final zzgcd zza;
    private final zzdxh zzb;
    private final zzhes zzc;

    public zzdyc(zzgcd zzgcdVar, zzdxh zzdxhVar, zzhes zzhesVar) {
        this.zza = zzgcdVar;
        this.zzb = zzdxhVar;
        this.zzc = zzhesVar;
    }

    private final ListenableFuture zzg(final zzbuy zzbuyVar, zzdyb zzdybVar, final zzdyb zzdybVar2, final zzgaz zzgazVar) {
        String str = zzbuyVar.zzd;
        com.google.android.gms.ads.internal.zzv.zzq();
        zzgbj zzgbjVarZzE = zzgbj.zzE(com.google.android.gms.ads.internal.util.zzs.zzD(str) ? zzgbs.zzg(new zzdxq(1)) : zzgbs.zzf(zzdybVar.zza(zzbuyVar), ExecutionException.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdya
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                ExecutionException executionException = (ExecutionException) obj;
                Throwable cause = executionException.getCause();
                ExecutionException cause2 = executionException;
                if (cause != null) {
                    cause2 = executionException.getCause();
                }
                return zzgbs.zzg(cause2);
            }
        }, this.zza));
        zzgaz zzgazVar2 = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(((zzdxr) obj).zzb());
            }
        };
        zzgcd zzgcdVar = this.zza;
        return (zzgbj) zzgbs.zzf((zzgbj) zzgbs.zzn((zzgbj) zzgbs.zzn(zzgbjVarZzE, zzgazVar2, zzgcdVar), zzgazVar, zzgcdVar), zzdxq.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdxz
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                zzdyc zzdycVar = this.zza;
                return zzgbs.zzn(zzdybVar2.zza(zzbuyVar), zzgazVar, zzdycVar.zza);
            }
        }, zzgcdVar);
    }

    public final ListenableFuture zze(final zzbuy zzbuyVar) {
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdxv
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                String str = new String(zzfzm.zzb((InputStream) obj), StandardCharsets.UTF_8);
                zzbuy zzbuyVar2 = zzbuyVar;
                zzbuyVar2.zzj = str;
                return zzgbs.zzh(zzbuyVar2);
            }
        };
        final zzdxh zzdxhVar = this.zzb;
        Objects.requireNonNull(zzdxhVar);
        return zzg(zzbuyVar, new zzdyb() { // from class: com.google.android.gms.internal.ads.zzdxw
            @Override // com.google.android.gms.internal.ads.zzdyb
            public final ListenableFuture zza(zzbuy zzbuyVar2) {
                return zzdxhVar.zza(zzbuyVar2);
            }
        }, new zzdyb() { // from class: com.google.android.gms.internal.ads.zzdxx
            @Override // com.google.android.gms.internal.ads.zzdyb
            public final ListenableFuture zza(zzbuy zzbuyVar2) {
                return ((zzdyu) this.zza.zzc.zzb()).zzb(zzbuyVar2, Binder.getCallingUid());
            }
        }, zzgazVar);
    }

    public final ListenableFuture zzf(zzbuy zzbuyVar) {
        return zzg(zzbuyVar, new zzdyb() { // from class: com.google.android.gms.internal.ads.zzdxt
            @Override // com.google.android.gms.internal.ads.zzdyb
            public final ListenableFuture zza(zzbuy zzbuyVar2) {
                return this.zza.zzb.zzd(zzbuyVar2.zzh);
            }
        }, new zzdyb() { // from class: com.google.android.gms.internal.ads.zzdxu
            @Override // com.google.android.gms.internal.ads.zzdyb
            public final ListenableFuture zza(zzbuy zzbuyVar2) {
                return ((zzdyu) this.zza.zzc.zzb()).zzj(zzbuyVar2.zzh);
            }
        }, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdxs
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzgbs.zzh(null);
            }
        });
    }
}

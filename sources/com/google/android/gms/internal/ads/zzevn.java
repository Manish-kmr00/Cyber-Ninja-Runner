package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzevn implements zzesv {
    private final zzbza zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgcd zze;
    private final int zzf;
    private final int zzg;

    zzevn(zzbza zzbzaVar, boolean z, boolean z2, zzbyp zzbypVar, zzgcd zzgcdVar, String str, ScheduledExecutorService scheduledExecutorService, int i, int i2) {
        this.zza = zzbzaVar;
        this.zzb = z;
        this.zzc = z2;
        this.zze = zzgcdVar;
        this.zzd = scheduledExecutorService;
        this.zzf = i;
        this.zzg = i2;
    }

    public static /* synthetic */ zzevo zzc(zzevn zzevnVar, Exception exc) {
        zzevnVar.zza.zzw(exc, "TrustlessTokenSignal");
        return new zzevo(null);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 50;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        boolean zContains;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgX)).booleanValue() && this.zzc) {
            return zzgbs.zzh(new zzevo(null));
        }
        if (this.zzg == 2) {
            return zzgbs.zzh(new zzevo(null));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgZ)).booleanValue()) {
            zContains = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzha)).split(StringUtils.COMMA)).contains(String.valueOf(this.zzf));
        } else {
            zContains = this.zzb;
        }
        if (!zContains) {
            return zzgbs.zzh(new zzevo(null));
        }
        ListenableFuture listenableFutureZzh = zzgbs.zzh(null);
        zzftl zzftlVar = new zzftl() { // from class: com.google.android.gms.internal.ads.zzevl
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzevo((String) obj);
            }
        };
        zzgcd zzgcdVar = this.zze;
        return zzgbs.zze(zzgbs.zzo(zzgbs.zzm(listenableFutureZzh, zzftlVar, zzgcdVar), ((Long) zzbew.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzevm
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return zzevn.zzc(this.zza, (Exception) obj);
            }
        }, zzgcdVar);
    }
}

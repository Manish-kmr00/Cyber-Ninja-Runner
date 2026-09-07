package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdwn implements zzdxp {
    private static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdvo zzb;
    private final zzgcd zzc;
    private final zzfbp zzd;
    private final ScheduledExecutorService zze;
    private final zzdzp zzf;
    private final zzfgn zzg;
    private final Context zzh;

    zzdwn(Context context, zzfbp zzfbpVar, zzdvo zzdvoVar, zzgcd zzgcdVar, ScheduledExecutorService scheduledExecutorService, zzdzp zzdzpVar, zzfgn zzfgnVar) {
        this.zzh = context;
        this.zzd = zzfbpVar;
        this.zzb = zzdvoVar;
        this.zzc = zzgcdVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzdzpVar;
        this.zzg = zzfgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final ListenableFuture zzc(zzbuy zzbuyVar) {
        Context context = this.zzh;
        ListenableFuture listenableFutureZzc = this.zzb.zzc(zzbuyVar);
        zzfgc zzfgcVarZza = zzfgb.zza(context, 11);
        zzfgm.zzd(listenableFutureZzc, zzfgcVarZza);
        ListenableFuture listenableFutureZzn = zzgbs.zzn(listenableFutureZzc, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwk
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                zzdxr zzdxrVar = (zzdxr) obj;
                return zzgbs.zzh(new zzfbg(new zzfbd(this.zza.zzd), zzfbf.zza(new InputStreamReader(zzdxrVar.zzb()), zzdxrVar.zza())));
            }
        }, this.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfE)).booleanValue()) {
            listenableFutureZzn = zzgbs.zzf(zzgbs.zzo(listenableFutureZzn, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzfF)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdwl
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    return zzgbs.zzg(new zzdvg(5));
                }
            }, zzbzk.zzg);
        }
        zzfgm.zza(listenableFutureZzn, this.zzg, zzfgcVarZza);
        zzgbs.zzr(listenableFutureZzn, new zzdwm(this), zzbzk.zzg);
        return listenableFutureZzn;
    }
}

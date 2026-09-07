package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzemm implements zzesv {
    final zzbza zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgcd zzd;
    private final Context zze;

    zzemm(Context context, zzbza zzbzaVar, ScheduledExecutorService scheduledExecutorService, zzgcd zzgcdVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdi)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzbzaVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzde)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdj)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdf)).booleanValue()) {
                    return zzgbs.zzm(zzfqs.zza(this.zzb.getAppSetIdInfo(), null), new zzftl() { // from class: com.google.android.gms.internal.ads.zzemj
                        @Override // com.google.android.gms.internal.ads.zzftl
                        public final Object apply(Object obj) {
                            AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                            return new zzemn(appSetIdInfo.getId(), appSetIdInfo.getScope());
                        }
                    }, zzbzk.zzg);
                }
                Task<AppSetIdInfo> taskZza = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdi)).booleanValue() ? zzfct.zza(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZza == null) {
                    return zzgbs.zzh(new zzemn(null, -1));
                }
                ListenableFuture listenableFutureZzn = zzgbs.zzn(zzfqs.zza(taskZza, null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzemk
                    @Override // com.google.android.gms.internal.ads.zzgaz
                    public final ListenableFuture zza(Object obj) {
                        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
                        return appSetIdInfo == null ? zzgbs.zzh(new zzemn(null, -1)) : zzgbs.zzh(new zzemn(appSetIdInfo.getId(), appSetIdInfo.getScope()));
                    }
                }, zzbzk.zzg);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdg)).booleanValue()) {
                    listenableFutureZzn = zzgbs.zzo(listenableFutureZzn, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdh)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgbs.zze(listenableFutureZzn, Exception.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzeml
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        this.zza.zza.zzw((Exception) obj, "AppSetIdInfoSignal");
                        return new zzemn(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgbs.zzh(new zzemn(null, -1));
    }
}

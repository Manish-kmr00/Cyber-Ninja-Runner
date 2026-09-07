package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetp implements zzesv {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgcd zzc;
    private final ScheduledExecutorService zzd;
    private final zzecd zze;
    private final zzfbp zzf;
    private final VersionInfoParcel zzg;

    zzetp(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgcd zzgcdVar, ScheduledExecutorService scheduledExecutorService, zzecd zzecdVar, zzfbp zzfbpVar, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgcdVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzecdVar;
        this.zzf = zzfbpVar;
        this.zzg = versionInfoParcel;
    }

    public static /* synthetic */ ListenableFuture zzc(zzetp zzetpVar, final Throwable th) {
        zzetr zzetrVar;
        zzetpVar.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetm
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkz)).booleanValue();
                Throwable th2 = th;
                if (zBooleanValue) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzx(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        if (th instanceof SecurityException) {
            zzetrVar = new zzetr("", 2, null);
        } else if (th instanceof IllegalStateException) {
            zzetrVar = new zzetr("", 3, null);
        } else if (th instanceof IllegalArgumentException) {
            zzetrVar = new zzetr("", 4, null);
        } else {
            zzetrVar = th instanceof TimeoutException ? new zzetr("", 5, null) : new zzetr("", 0, null);
        }
        return zzgbs.zzh(zzetrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003a  */
    /* JADX WARN: Code duplicated, block: B:12:0x0050  */
    /* JADX WARN: Code duplicated, block: B:14:0x0064  */
    /* JADX WARN: Code duplicated, block: B:17:0x0077  */
    /* JADX WARN: Code duplicated, block: B:20:0x008a  */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
    
        if (java.util.Arrays.asList(r0.split(io.appmetrica.analytics.coreutils.internal.StringUtils.COMMA)).contains(r5.zzb.getPackageName()) != false) goto L30;
     */
    @Override // com.google.android.gms.internal.ads.zzesv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzetp.zzb():com.google.common.util.concurrent.ListenableFuture");
    }
}

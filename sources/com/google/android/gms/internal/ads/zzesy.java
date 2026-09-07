package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzesy {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzfgn zzd;
    private final zzdre zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzesy(Context context, Executor executor, Set set, zzfgn zzfgnVar, zzdre zzdreVar) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzfgnVar;
        this.zze = zzdreVar;
    }

    public static /* synthetic */ void zzb(zzesy zzesyVar, long j, zzesv zzesvVar, Bundle bundle) {
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - j;
        if (((Boolean) zzbek.zza.zze()).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Signal runtime (ms) : " + zzfun.zzc(zzesvVar.getClass().getCanonicalName()) + " = " + jElapsedRealtime);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcu)).booleanValue()) {
                synchronized (zzesyVar) {
                    bundle.putLong("sig" + zzesvVar.zza(), jElapsedRealtime);
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzco)).booleanValue()) {
            zzdrd zzdrdVarZza = zzesyVar.zze.zza();
            zzdrdVarZza.zzb("action", "lat_ms");
            zzdrdVarZza.zzb("lat_grp", "sig_lat_grp");
            zzdrdVarZza.zzb("lat_id", String.valueOf(zzesvVar.zza()));
            zzdrdVarZza.zzb("clat_ms", String.valueOf(jElapsedRealtime));
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcp)).booleanValue()) {
                synchronized (zzesyVar) {
                    zzesyVar.zzg++;
                }
                zzdrdVarZza.zzb("seq_num", com.google.android.gms.ads.internal.zzv.zzp().zzh().zzd());
                synchronized (zzesyVar) {
                    if (zzesyVar.zzg == zzesyVar.zzb.size() && zzesyVar.zzf != 0) {
                        zzesyVar.zzg = 0;
                        String strValueOf = String.valueOf(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzesyVar.zzf);
                        if (zzesvVar.zza() <= 39 || zzesvVar.zza() >= 52) {
                            zzdrdVarZza.zzb("lat_clsg", strValueOf);
                        } else {
                            zzdrdVarZza.zzb("lat_gmssg", strValueOf);
                        }
                    }
                }
            }
            zzdrdVarZza.zzk();
        }
    }

    public final ListenableFuture zza(final Object obj, final Bundle bundle, final boolean z) {
        zzfgc zzfgcVarZza = zzfgb.zza(this.zza, 8);
        zzfgcVarZza.zzi();
        Set<zzesv> set = this.zzb;
        final ArrayList arrayList = new ArrayList(set.size());
        List arrayList2 = new ArrayList();
        if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlO)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlO)).split(StringUtils.COMMA));
        }
        List list = arrayList2;
        this.zzf = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
        final Bundle bundle2 = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && bundle != null) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
            if (obj instanceof zzcue) {
                bundle.putLong(zzdqm.CLIENT_SIGNALS_START.zza(), jCurrentTimeMillis);
            } else {
                bundle.putLong(zzdqm.GMS_SIGNALS_START.zza(), jCurrentTimeMillis);
            }
        }
        for (final zzesv zzesvVar : set) {
            if (!list.contains(String.valueOf(zzesvVar.zza()))) {
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
                ListenableFuture listenableFutureZzb = zzesvVar.zzb();
                listenableFutureZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzesw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzesy.zzb(this.zza, jElapsedRealtime, zzesvVar, bundle2);
                    }
                }, zzbzk.zzg);
                arrayList.add(listenableFutureZzb);
            }
        }
        ListenableFuture listenableFutureZza = zzgbs.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzesx
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object obj2;
                Bundle bundle3;
                Iterator it = arrayList.iterator();
                while (true) {
                    obj2 = obj;
                    if (!it.hasNext()) {
                        break;
                    }
                    zzesu zzesuVar = (zzesu) ((ListenableFuture) it.next()).get();
                    if (zzesuVar != null) {
                        boolean z2 = z;
                        zzesuVar.zzb(obj2);
                        if (z2) {
                            zzesuVar.zza(obj2);
                        }
                    }
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcq)).booleanValue() && (bundle3 = bundle) != null) {
                    Bundle bundle4 = bundle2;
                    long jCurrentTimeMillis2 = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
                    if (obj2 instanceof zzcue) {
                        bundle3.putLong(zzdqm.CLIENT_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("client_sig_latency_key", bundle4);
                    } else {
                        bundle3.putLong(zzdqm.GMS_SIGNALS_END.zza(), jCurrentTimeMillis2);
                        bundle3.putBundle("gms_sig_latency_key", bundle4);
                    }
                }
                return obj2;
            }
        }, this.zzc);
        if (zzfgq.zza()) {
            zzfgm.zza(listenableFutureZza, this.zzd, zzfgcVarZza);
        }
        return listenableFutureZza;
    }
}

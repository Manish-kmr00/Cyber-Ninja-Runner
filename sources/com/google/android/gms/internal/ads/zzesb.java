package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzesb implements zzesv {
    public static final /* synthetic */ int zzb = 0;
    private static final zzesc zzc = new zzesc(new JSONArray().toString(), new Bundle());
    final String zza;
    private final zzgcd zzd;
    private final ScheduledExecutorService zze;
    private final zzein zzf;
    private final Context zzg;
    private final zzfbp zzh;
    private final zzeij zzi;
    private final zzdou zzj;
    private final zzdtk zzk;
    private final int zzl;

    zzesb(zzgcd zzgcdVar, ScheduledExecutorService scheduledExecutorService, String str, zzein zzeinVar, Context context, zzfbp zzfbpVar, zzeij zzeijVar, zzdou zzdouVar, zzdtk zzdtkVar, int i) {
        this.zzd = zzgcdVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzeinVar;
        this.zzg = context;
        this.zzh = zzfbpVar;
        this.zzi = zzeijVar;
        this.zzj = zzdouVar;
        this.zzk = zzdtkVar;
        this.zzl = i;
    }

    public static /* synthetic */ ListenableFuture zzc(zzesb zzesbVar) {
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkY)).booleanValue() ? zzesbVar.zzh.zzf.toLowerCase(Locale.ROOT) : zzesbVar.zzh.zzf;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbP)).booleanValue() ? zzesbVar.zzk.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbY)).booleanValue()) {
            zzesbVar.zzi(arrayList, zzesbVar.zzf.zza(zzesbVar.zza, lowerCase));
        } else {
            zzein zzeinVar = zzesbVar.zzf;
            for (Map.Entry entry : ((zzfwz) zzeinVar.zzb(zzesbVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                arrayList.add(zzesbVar.zzg(str, (List) entry.getValue(), zzesbVar.zzf(str), true, true));
            }
            zzesbVar.zzi(arrayList, zzeinVar.zzc());
        }
        return zzgbs.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzerw
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                int i = zzesb.zzb;
                JSONArray jSONArray = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray.put(listenableFuture.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzesc(jSONArray.toString(), bundleZzg);
            }
        }, zzesbVar.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static /* synthetic */ ListenableFuture zzd(final zzesb zzesbVar, String str, final List list, final Bundle bundle, boolean z, boolean z2) throws RemoteException {
        zzbqx zzbqxVarZzb;
        final zzbzp zzbzpVar = new zzbzp();
        if (z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbQ)).booleanValue()) {
                try {
                    zzbqxVarZzb = zzesbVar.zzj.zzb(str);
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", e);
                    zzbqxVarZzb = null;
                }
            } else {
                zzeij zzeijVar = zzesbVar.zzi;
                zzeijVar.zzb(str);
                zzbqxVarZzb = zzeijVar.zza(str);
            }
        } else {
            zzbqxVarZzb = zzesbVar.zzj.zzb(str);
        }
        if (zzbqxVarZzb == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbG)).booleanValue()) {
                throw null;
            }
            zzeiq.zzb(str, zzbzpVar);
        } else {
            final zzeiq zzeiqVar = new zzeiq(str, zzbqxVarZzb, zzbzpVar, com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbL)).booleanValue()) {
                ScheduledExecutorService scheduledExecutorService = zzesbVar.zze;
                Objects.requireNonNull(zzeiqVar);
                scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzesa
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeiqVar.zzc();
                    }
                }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbE)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbS)).booleanValue()) {
                    final zzbqx zzbqxVar = zzbqxVarZzb;
                    zzesbVar.zzd.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzerx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzesb.zze(this.zza, zzbqxVar, bundle, list, zzeiqVar, zzbzpVar);
                        }
                    });
                } else {
                    zzesbVar.zzh(zzbqxVarZzb, bundle, list, zzeiqVar);
                }
            } else {
                zzeiqVar.zzd();
            }
        }
        return zzbzpVar;
    }

    public static /* synthetic */ void zze(zzesb zzesbVar, zzbqx zzbqxVar, Bundle bundle, List list, zzeiq zzeiqVar, zzbzp zzbzpVar) {
        try {
            zzesbVar.zzh(zzbqxVar, bundle, list, zzeiqVar);
        } catch (RemoteException e) {
            zzbzpVar.zzd(e);
        }
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzh.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgbj zzg(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzgay zzgayVar = new zzgay() { // from class: com.google.android.gms.internal.ads.zzery
            @Override // com.google.android.gms.internal.ads.zzgay
            public final ListenableFuture zza() {
                return zzesb.zzd(this.zza, str, list, bundle, z, z2);
            }
        };
        zzgcd zzgcdVar = this.zzd;
        zzgbj zzgbjVarZzE = zzgbj.zzE(zzgbs.zzk(zzgayVar, zzgcdVar));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbL)).booleanValue()) {
            zzgbjVarZzE = (zzgbj) zzgbs.zzo(zzgbjVarZzE, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbE)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzgbj) zzgbs.zze(zzgbjVarZzE, Throwable.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzerz
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i = zzesb.zzb;
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                String str2 = str;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zznb)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzgcdVar);
    }

    private final void zzh(zzbqx zzbqxVar, Bundle bundle, List list, zzeiq zzeiqVar) throws RemoteException {
        zzbqxVar.zzh(ObjectWrapper.wrap(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zze, zzeiqVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzeir zzeirVar = (zzeir) ((Map.Entry) it.next()).getValue();
            String str = zzeirVar.zza;
            list.add(zzg(str, Collections.singletonList(zzeirVar.zze), zzf(str), zzeirVar.zzb, zzeirVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        if (this.zzl == 2) {
            return zzgbs.zzh(zzc);
        }
        zzfbp zzfbpVar = this.zzh;
        if (zzfbpVar.zzr) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbR)).split(StringUtils.COMMA)).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfbpVar.zzd)))) {
                return zzgbs.zzh(zzc);
            }
        }
        return zzgbs.zzk(new zzgay() { // from class: com.google.android.gms.internal.ads.zzerv
            @Override // com.google.android.gms.internal.ads.zzgay
            public final ListenableFuture zza() {
                return zzesb.zzc(this.zza);
            }
        }, this.zzd);
    }
}

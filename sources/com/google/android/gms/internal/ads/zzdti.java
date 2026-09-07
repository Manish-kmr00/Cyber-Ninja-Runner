package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amazon.device.ads.DTBMetricsConfiguration;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdti {
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdou zzh;
    private final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    private final zzdrp zzl;
    private final VersionInfoParcel zzm;
    private final zzdcb zzo;
    private final zzfgq zzp;
    private boolean zza = false;
    private boolean zzb = false;
    private boolean zzc = false;
    private final zzbzp zze = new zzbzp();
    private final Map zzn = new ConcurrentHashMap();
    private boolean zzq = true;
    private final long zzd = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();

    public zzdti(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdou zzdouVar, ScheduledExecutorService scheduledExecutorService, zzdrp zzdrpVar, VersionInfoParcel versionInfoParcel, zzdcb zzdcbVar, zzfgq zzfgqVar) {
        this.zzh = zzdouVar;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdrpVar;
        this.zzm = versionInfoParcel;
        this.zzo = zzdcbVar;
        this.zzp = zzfgqVar;
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    public static /* synthetic */ Object zzf(zzdti zzdtiVar, zzfgc zzfgcVar) {
        zzdtiVar.zze.zzc(true);
        zzfgcVar.zzg(true);
        zzdtiVar.zzp.zzc(zzfgcVar.zzm());
        return null;
    }

    public static /* synthetic */ void zzi(zzdti zzdtiVar, Object obj, zzbzp zzbzpVar, String str, long j, zzfgc zzfgcVar) {
        synchronized (obj) {
            if (!zzbzpVar.isDone()) {
                zzdtiVar.zzv(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - j));
                zzdtiVar.zzl.zzb(str, "timeout");
                zzdtiVar.zzo.zzb(str, "timeout");
                zzfgq zzfgqVar = zzdtiVar.zzp;
                zzfgcVar.zzc(AndroidInitializeBoldSDK.MSG_TIMEOUT);
                zzfgcVar.zzg(false);
                zzfgqVar.zzc(zzfgcVar.zzm());
                zzbzpVar.zzc(false);
            }
        }
    }

    public static /* synthetic */ void zzj(zzdti zzdtiVar) {
        zzdtiVar.zzl.zze();
        zzdtiVar.zzo.zze();
        zzdtiVar.zzb = true;
    }

    public static /* synthetic */ void zzl(zzdti zzdtiVar) {
        synchronized (zzdtiVar) {
            if (zzdtiVar.zzc) {
                return;
            }
            zzdtiVar.zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime() - zzdtiVar.zzd));
            zzdtiVar.zzl.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            zzdtiVar.zzo.zzb("com.google.android.gms.ads.MobileAds", "timeout");
            zzdtiVar.zze.zzd(new Exception());
        }
    }

    public static /* synthetic */ void zzm(zzdti zzdtiVar, String str, zzbll zzbllVar, zzfcn zzfcnVar, List list) {
        try {
            try {
                if (Objects.equals(str, "com.google.ads.mediation.admob.AdMobAdapter")) {
                    zzbllVar.zzf();
                    return;
                }
                Context context = (Context) zzdtiVar.zzg.get();
                if (context == null) {
                    context = zzdtiVar.zzf;
                }
                zzfcnVar.zzi(context, zzbllVar, list);
            } catch (RemoteException e) {
                throw new zzfuu(e);
            } catch (zzfbw unused) {
                zzbllVar.zze("Failed to initialize adapter. " + str + " does not implement the initialize() method.");
            }
        } catch (RemoteException e2) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
        }
    }

    static /* bridge */ /* synthetic */ void zzo(final zzdti zzdtiVar, String str) {
        Context context = zzdtiVar.zzf;
        int i = 5;
        final zzfgc zzfgcVarZza = zzfgb.zza(context, 5);
        zzfgcVarZza.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject(DTBMetricsConfiguration.CONFIG_DIR);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final zzfgc zzfgcVarZza2 = zzfgb.zza(context, i);
                zzfgcVarZza2.zzi();
                zzfgcVarZza2.zzd(next);
                final Object obj = new Object();
                final zzbzp zzbzpVar = new zzbzp();
                ListenableFuture listenableFutureZzo = zzgbs.zzo(zzbzpVar, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzca)).longValue(), TimeUnit.SECONDS, zzdtiVar.zzk);
                zzdtiVar.zzl.zzc(next);
                zzdtiVar.zzo.zzc(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime();
                Context context2 = context;
                JSONObject jSONObject2 = jSONObject;
                listenableFutureZzo.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsy
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdti.zzi(this.zza, obj, zzbzpVar, next, jElapsedRealtime, zzfgcVarZza2);
                    }
                }, zzdtiVar.zzi);
                arrayList.add(listenableFutureZzo);
                final zzdth zzdthVar = new zzdth(zzdtiVar, obj, next, jElapsedRealtime, zzfgcVarZza2, zzbzpVar);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        int i2 = 0;
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            String strOptString = jSONObject3.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject3.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzblr(strOptString, bundle));
                            i2++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdtiVar.zzv(next, false, "", 0);
                try {
                    final zzfcn zzfcnVarZzc = zzdtiVar.zzh.zzc(next, new JSONObject());
                    zzdtiVar.zzj.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdtd
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdti.zzm(this.zza, next, zzdthVar, zzfcnVarZzc, arrayList2);
                        }
                    });
                } catch (zzfbw e) {
                    try {
                        String str2 = "Failed to create Adapter.";
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmZ)).booleanValue()) {
                            str2 = "Failed to create Adapter. " + e.getMessage();
                        }
                        zzdthVar.zze(str2);
                    } catch (RemoteException e2) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", e2);
                    }
                }
                jSONObject = jSONObject2;
                context = context2;
                i = 5;
            }
            zzgbs.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdsz
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdti.zzf(this.zza, zzfgcVarZza);
                    return null;
                }
            }, zzdtiVar.zzi);
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.zzb("Malformed CLD response", e3);
            zzdtiVar.zzo.zza("MalformedJson");
            zzdtiVar.zzl.zza("MalformedJson");
            zzdtiVar.zze.zzd(e3);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "AdapterInitializer.updateAdapterStatus");
            zzfgq zzfgqVar = zzdtiVar.zzp;
            zzfgcVarZza.zzh(e3);
            zzfgcVarZza.zzg(false);
            zzfgqVar.zzc(zzfgcVarZza.zzm());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String strZzc = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc();
        if (!TextUtils.isEmpty(strZzc)) {
            return zzgbs.zzh(strZzc);
        }
        final zzbzp zzbzpVar = new zzbzp();
        com.google.android.gms.ads.internal.zzv.zzp().zzi().zzo(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdta
            @Override // java.lang.Runnable
            public final void run() {
                zzdti zzdtiVar = this.zza;
                zzdtiVar.zzi.execute(new Runnable(zzdtiVar, zzbzpVar) { // from class: com.google.android.gms.internal.ads.zzdtc
                    public final /* synthetic */ zzbzp zza;

                    {
                        this.zza = zzbzpVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        String strZzc2 = com.google.android.gms.ads.internal.zzv.zzp().zzi().zzg().zzc();
                        boolean zIsEmpty = TextUtils.isEmpty(strZzc2);
                        zzbzp zzbzpVar2 = this.zza;
                        if (zIsEmpty) {
                            zzbzpVar2.zzd(new Exception());
                        } else {
                            zzbzpVar2.zzc(strZzc2);
                        }
                    }
                });
            }
        });
        return zzbzpVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzblh(str, z, i, str2));
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        Map map = this.zzn;
        for (String str : map.keySet()) {
            zzblh zzblhVar = (zzblh) map.get(str);
            arrayList.add(new zzblh(str, zzblhVar.zzb, zzblhVar.zzc, zzblhVar.zzd));
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzq = false;
    }

    public final void zzr() {
        if (!((Boolean) zzbeo.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbZ)).intValue() && this.zzq) {
                if (this.zza) {
                    return;
                }
                synchronized (this) {
                    if (this.zza) {
                        return;
                    }
                    this.zzl.zzf();
                    this.zzo.zzf();
                    zzbzp zzbzpVar = this.zze;
                    Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzdte
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdti.zzj(this.zza);
                        }
                    };
                    Executor executor = this.zzi;
                    zzbzpVar.addListener(runnable, executor);
                    this.zza = true;
                    ListenableFuture listenableFutureZzu = zzu();
                    this.zzk.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdsx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzdti.zzl(this.zza);
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcb)).longValue(), TimeUnit.SECONDS);
                    zzgbs.zzr(listenableFutureZzu, new zzdtg(this), executor);
                    return;
                }
            }
        }
        if (this.zza) {
            return;
        }
        zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zze.zzc(false);
        this.zza = true;
        this.zzb = true;
    }

    public final void zzs(final zzblo zzbloVar) {
        this.zze.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdtb
            @Override // java.lang.Runnable
            public final void run() {
                zzdti zzdtiVar = this.zza;
                try {
                    zzbloVar.zzb(zzdtiVar.zzg());
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                }
            }
        }, this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}

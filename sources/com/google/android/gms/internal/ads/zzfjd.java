package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfjd {
    private final ConcurrentMap zza = new ConcurrentHashMap();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final zzfjo zzc;
    private final zzfiz zzd;
    private final Context zze;
    private volatile ConnectivityManager zzf;
    private final Clock zzg;
    private AtomicInteger zzh;

    zzfjd(zzfjo zzfjoVar, zzfiz zzfizVar, Context context, Clock clock) {
        this.zzc = zzfjoVar;
        this.zzd = zzfizVar;
        this.zze = context;
        this.zzg = clock;
    }

    static String zzd(String str, AdFormat adFormat) {
        return str + "#" + (adFormat == null ? "NULL" : adFormat.name());
    }

    private final synchronized zzfjn zzm(String str, AdFormat adFormat) {
        return (zzfjn) this.zza.get(zzd(str, adFormat));
    }

    private final synchronized Object zzn(Class cls, String str, AdFormat adFormat) {
        zzfiz zzfizVar = this.zzd;
        Clock clock = this.zzg;
        zzfizVar.zze(adFormat, clock.currentTimeMillis());
        zzfjn zzfjnVarZzm = zzm(str, adFormat);
        if (zzfjnVarZzm == null) {
            return null;
        }
        try {
            String strZzk = zzfjnVarZzm.zzk();
            Object objZzi = zzfjnVarZzm.zzi();
            Object objCast = objZzi == null ? null : cls.cast(objZzi);
            if (objCast != null) {
                zzfizVar.zzf(adFormat, clock.currentTimeMillis(), zzfjnVarZzm.zze.zzd, zzfjnVarZzm.zzd(), strZzk);
            }
            return objCast;
        } catch (ClassCastException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "PreloadAdManager.pollAd");
            com.google.android.gms.ads.internal.util.zze.zzb("Unable to cast ad to the requested type:".concat(String.valueOf(cls.getName())), e);
            return null;
        }
    }

    private final synchronized List zzo(List list) {
        ArrayList arrayList;
        HashSet hashSet = new HashSet();
        arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.client.zzfp zzfpVar = (com.google.android.gms.ads.internal.client.zzfp) it.next();
            String strZzd = zzd(zzfpVar.zza, AdFormat.getAdFormat(zzfpVar.zzb));
            hashSet.add(strZzd);
            ConcurrentMap concurrentMap = this.zza;
            zzfjn zzfjnVar = (zzfjn) concurrentMap.get(strZzd);
            if (zzfjnVar == null) {
                ConcurrentMap concurrentMap2 = this.zzb;
                if (concurrentMap2.containsKey(strZzd)) {
                    zzfjn zzfjnVar2 = (zzfjn) concurrentMap2.get(strZzd);
                    if (zzfjnVar2.zze.equals(zzfpVar)) {
                        zzfjnVar2.zzw(zzfpVar.zzd);
                        zzfjnVar2.zzt();
                        concurrentMap.put(strZzd, zzfjnVar2);
                        concurrentMap2.remove(strZzd);
                    }
                } else {
                    arrayList.add(zzfpVar);
                }
            } else if (zzfjnVar.zze.equals(zzfpVar)) {
                zzfjnVar.zzw(zzfpVar.zzd);
            } else {
                this.zzb.put(strZzd, zzfjnVar);
                concurrentMap.remove(strZzd);
            }
        }
        Iterator it2 = this.zza.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            if (!hashSet.contains((String) entry.getKey())) {
                this.zzb.put((String) entry.getKey(), (zzfjn) entry.getValue());
                it2.remove();
            }
        }
        Iterator it3 = this.zzb.entrySet().iterator();
        while (it3.hasNext()) {
            zzfjn zzfjnVar3 = (zzfjn) ((Map.Entry) it3.next()).getValue();
            zzfjnVar3.zzv();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzx)).booleanValue()) {
                zzfjnVar3.zzq();
            }
            if (!zzfjnVar3.zzx()) {
                it3.remove();
            }
        }
        return arrayList;
    }

    private final synchronized void zzp(String str, zzfjn zzfjnVar) {
        zzfjnVar.zzf();
        this.zza.put(str, zzfjnVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzq(boolean z) {
        try {
            if (z) {
                Iterator it = this.zza.values().iterator();
                while (it.hasNext()) {
                    ((zzfjn) it.next()).zzt();
                }
            } else {
                Iterator it2 = this.zza.values().iterator();
                while (it2.hasNext()) {
                    ((zzfjn) it2.next()).zzf.set(false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzv)).booleanValue()) {
            zzq(z);
        }
    }

    private final synchronized boolean zzs(String str, AdFormat adFormat) {
        boolean z;
        Clock clock = this.zzg;
        long jCurrentTimeMillis = clock.currentTimeMillis();
        zzfjn zzfjnVarZzm = zzm(str, adFormat);
        z = zzfjnVarZzm != null && zzfjnVarZzm.zzx();
        this.zzd.zzb(adFormat, zzfjnVarZzm == null ? 0 : zzfjnVarZzm.zze.zzd, zzfjnVarZzm != null ? zzfjnVarZzm.zzd() : 0, jCurrentTimeMillis, z ? Long.valueOf(clock.currentTimeMillis()) : null, zzfjnVarZzm == null ? null : zzfjnVarZzm.zzk());
        return z;
    }

    public final synchronized zzbaa zza(String str) {
        return (zzbaa) zzn(zzbaa.class, str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzbx zzb(String str) {
        return (com.google.android.gms.ads.internal.client.zzbx) zzn(com.google.android.gms.ads.internal.client.zzbx.class, str, AdFormat.INTERSTITIAL);
    }

    public final synchronized zzbwd zzc(String str) {
        return (zzbwd) zzn(zzbwd.class, str, AdFormat.REWARDED);
    }

    public final void zzg() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    try {
                        this.zzf = (ConnectivityManager) this.zze.getSystemService("connectivity");
                    } catch (ClassCastException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to get connectivity manager", e);
                    }
                }
            }
        }
        if (!PlatformVersion.isAtLeastO() || this.zzf == null) {
            this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzB)).intValue());
            return;
        }
        try {
            this.zzf.registerDefaultNetworkCallback(new zzfjc(this));
        } catch (RuntimeException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to register network callback", e2);
            this.zzh = new AtomicInteger(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzB)).intValue());
        }
    }

    public final void zzh(zzboy zzboyVar) {
        this.zzc.zzb(zzboyVar);
    }

    public final synchronized void zzi(List list, com.google.android.gms.ads.internal.client.zzce zzceVar) {
        List<com.google.android.gms.ads.internal.client.zzfp> listZzo = zzo(list);
        EnumMap enumMap = new EnumMap(AdFormat.class);
        for (com.google.android.gms.ads.internal.client.zzfp zzfpVar : listZzo) {
            String str = zzfpVar.zza;
            AdFormat adFormat = AdFormat.getAdFormat(zzfpVar.zzb);
            zzfjn zzfjnVarZza = this.zzc.zza(zzfpVar, zzceVar);
            if (adFormat != null && zzfjnVarZza != null) {
                AtomicInteger atomicInteger = this.zzh;
                if (atomicInteger != null) {
                    zzfjnVarZza.zzs(atomicInteger.get());
                }
                zzfiz zzfizVar = this.zzd;
                zzfjnVarZza.zzu(zzfizVar);
                zzp(zzd(str, adFormat), zzfjnVarZza);
                enumMap.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zze(enumMap, adFormat, 0)).intValue() + 1));
                zzfizVar.zzi(adFormat, zzfpVar.zzd, this.zzg.currentTimeMillis());
            }
        }
        this.zzd.zzh(enumMap, this.zzg.currentTimeMillis());
        com.google.android.gms.ads.internal.zzv.zzb().zzc(new zzfjb(this));
    }

    public final synchronized boolean zzj(String str) {
        return zzs(str, AdFormat.APP_OPEN_AD);
    }

    public final synchronized boolean zzk(String str) {
        return zzs(str, AdFormat.INTERSTITIAL);
    }

    public final synchronized boolean zzl(String str) {
        return zzs(str, AdFormat.REWARDED);
    }
}

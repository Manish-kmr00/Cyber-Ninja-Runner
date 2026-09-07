package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzben;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzdrj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzo {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private final Context zzc;
    private final zzdrj zzd;
    private final ExecutorService zze;

    zzo(Context context, zzdrj zzdrjVar, ExecutorService executorService) {
        this.zzc = context;
        this.zzd = zzdrjVar;
        this.zze = executorService;
    }

    public static /* synthetic */ Object zza(zzo zzoVar, AdRequest adRequest, zzp zzpVar) {
        QueryInfo.generate(zzoVar.zzc, AdFormat.BANNER, adRequest, zzpVar);
        return true;
    }

    public static /* synthetic */ void zzb(zzo zzoVar, Object obj, Pair pair) {
        boolean zAcceptThirdPartyCookies = false;
        if (obj instanceof WebView) {
            CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzv.zzr().zza(zzoVar.zzc);
            if (cookieManagerZza != null) {
                zAcceptThirdPartyCookies = cookieManagerZza.acceptThirdPartyCookies((WebView) obj);
            }
        }
        Map map = zzoVar.zza;
        Boolean boolValueOf = Boolean.valueOf(zAcceptThirdPartyCookies);
        zzq zzqVar = (zzq) map.get(boolValueOf);
        if (zzqVar != null && !zzqVar.zze()) {
            zzoVar.zzi(zzqVar, pair, true);
            return;
        }
        Map map2 = zzoVar.zzb;
        List arrayList = (List) map2.get(boolValueOf);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map2.put(boolValueOf, arrayList);
        }
        arrayList.add(pair);
    }

    private final void zzh(final boolean z) {
        Map map = this.zzb;
        Boolean boolValueOf = Boolean.valueOf(z);
        if (map.containsKey(boolValueOf)) {
            return;
        }
        map.put(boolValueOf, new ArrayList());
        this.zze.submit(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(z, false);
            }
        });
    }

    private final void zzi(zzq zzqVar, Pair pair, boolean z) {
        zzqVar.zzd();
        QueryInfo queryInfoZzb = zzqVar.zzb();
        if (queryInfoZzb != null) {
            ((QueryInfoGenerationCallback) pair.first).onSuccess(queryInfoZzb);
        } else {
            ((QueryInfoGenerationCallback) pair.first).onFailure(zzqVar.zzc());
        }
        zzdrj zzdrjVar = this.zzd;
        Pair[] pairArr = new Pair[7];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair("ad_format", AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - ((Long) pair.second).longValue()));
        pairArr[5] = new Pair("sgpc_h", Boolean.toString(z));
        pairArr[6] = new Pair("sgpc_rs", Boolean.toString(zzqVar.zzb() != null));
        zzaa.zzd(zzdrjVar, null, "sgpcr", pairArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzj(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        bundle.putBoolean("accept_3p_cookie", z);
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z);
        zzq zzqVar = (zzq) map.get(boolValueOf);
        int iZza = 0;
        if (z2 && zzqVar != null) {
            iZza = zzqVar.zza() + 1;
        }
        zzq zzqVar2 = (zzq) map.get(boolValueOf);
        final zzp zzpVar = new zzp(this, z, iZza, zzqVar2 == null ? null : Boolean.valueOf(zzqVar2.zzf()), this.zzd);
        final AdRequest adRequestBuild = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzlh)).booleanValue()) {
            this.zze.submit(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzn
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzo.zza(this.zza, adRequestBuild, zzpVar);
                }
            });
        } else {
            QueryInfo.generate(this.zzc, AdFormat.BANNER, adRequestBuild, zzpVar);
        }
    }

    public final synchronized void zze() {
        zzh(true);
        zzh(false);
    }

    final synchronized void zzf(final boolean z, zzq zzqVar) {
        Map map = this.zza;
        Boolean boolValueOf = Boolean.valueOf(z);
        zzq zzqVar2 = (zzq) map.get(boolValueOf);
        if (zzqVar2 == null || zzqVar2.zze() || zzqVar2.zzb() == null || zzqVar.zzb() != null) {
            map.put(boolValueOf, zzqVar);
        }
        long jLongValue = (zzqVar.zzb() != null ? (Long) zzben.zzf.zze() : (Long) zzben.zzg.zze()).longValue();
        final boolean z2 = zzqVar.zzb() == null;
        zzbzk.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(z, z2);
            }
        }, jLongValue, TimeUnit.SECONDS);
        Map map2 = this.zzb;
        List list = (List) map2.get(boolValueOf);
        map2.put(boolValueOf, new ArrayList());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzi(zzqVar, (Pair) it.next(), false);
            }
        }
    }

    public final synchronized void zzg(final Object obj, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        final Pair pair = new Pair(queryInfoGenerationCallback, Long.valueOf(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis()));
        zzbzk.zzf.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzk
            @Override // java.lang.Runnable
            public final void run() {
                zzo.zzb(this.zza, obj, pair);
            }
        });
    }
}

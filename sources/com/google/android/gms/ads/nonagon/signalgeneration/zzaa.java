package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzdqy;
import com.google.android.gms.internal.ads.zzdrj;
import com.google.android.gms.internal.ads.zzfbg;
import com.google.android.gms.internal.ads.zzfbp;
import com.google.android.gms.internal.ads.zzfgs;
import com.google.firebase.ktx.BuildConfig;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.pubnative.lite.sdk.models.Protocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzaa {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    public static zzfgs zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle2 != null) {
            bundle = bundle2;
        }
        String string = bundle.getString("query_info_type");
        if (TextUtils.isEmpty(string)) {
            return zzfgs.SCAR_REQUEST_TYPE_UNSPECIFIED;
        }
        switch (string) {
            case "requester_type_0":
                return zzfgs.SCAR_REQUEST_TYPE_ADMOB;
            case "requester_type_1":
                return zzfgs.SCAR_REQUEST_TYPE_INBOUND_MEDIATION;
            case "requester_type_2":
                return zzfgs.SCAR_REQUEST_TYPE_GBID;
            case "requester_type_3":
                return zzfgs.SCAR_REQUEST_TYPE_GOLDENEYE;
            case "requester_type_4":
                return zzfgs.SCAR_REQUEST_TYPE_YAVIN;
            case "requester_type_5":
                return zzfgs.SCAR_REQUEST_TYPE_UNITY;
            case "requester_type_6":
                return zzfgs.SCAR_REQUEST_TYPE_PAW;
            case "requester_type_7":
                return zzfgs.SCAR_REQUEST_TYPE_GUILDER;
            case "requester_type_8":
                return zzfgs.SCAR_REQUEST_TYPE_GAM_S2S;
            default:
                return zzfgs.SCAR_REQUEST_TYPE_UNSPECIFIED;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    public static String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.VERSION_NAME;
        }
        switch (str) {
            case "requester_type_0":
                return "0";
            case "requester_type_1":
                return "1";
            case "requester_type_2":
                return "2";
            case "requester_type_3":
                return "3";
            case "requester_type_4":
                return Protocol.VAST_1_0_WRAPPER;
            case "requester_type_5":
                return "5";
            case "requester_type_6":
                return "6";
            case "requester_type_7":
                return "7";
            case "requester_type_8":
                return "8";
            default:
                return str;
        }
    }

    public static String zzc(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        return (zzmVar == null || (bundle = zzmVar.zzc) == null) ? BuildConfig.VERSION_NAME : bundle.getString("query_info_type");
    }

    public static void zzd(final zzdrj zzdrjVar, zzdqy zzdqyVar, final String str, final Pair... pairArr) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgT)).booleanValue()) {
            final zzdqy zzdqyVar2 = null;
            zzbzk.zza.execute(new Runnable(zzdqyVar2, str, pairArr) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzz
                public final /* synthetic */ String zzb;
                public final /* synthetic */ Pair[] zzc;

                {
                    this.zzb = str;
                    this.zzc = pairArr;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzaa.zze(this.zza, null, this.zzb, this.zzc);
                }
            });
        }
    }

    static void zze(zzdrj zzdrjVar, zzdqy zzdqyVar, String str, Pair... pairArr) {
        ConcurrentHashMap concurrentHashMapZzc = zzdrjVar.zzc();
        zzh(concurrentHashMapZzc, "action", str);
        for (Pair pair : pairArr) {
            zzh(concurrentHashMapZzc, (String) pair.first, (String) pair.second);
        }
        zzdrjVar.zzg(concurrentHashMapZzc);
    }

    public static boolean zzf(zzfbg zzfbgVar) {
        return zzg(zzfbgVar.zza.zza) != 1;
    }

    public static int zzg(zzfbp zzfbpVar) {
        if (zzfbpVar.zzr) {
            return 2;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfbpVar.zzd;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzmVar.zzs;
        if (zzcVar == null && zzmVar.zzx == null) {
            return 1;
        }
        if (zzcVar == null || zzmVar.zzx == null) {
            return zzcVar != null ? 3 : 4;
        }
        return 5;
    }

    private static void zzh(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }
}

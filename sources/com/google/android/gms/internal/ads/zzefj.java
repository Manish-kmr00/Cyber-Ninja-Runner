package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzefj implements zzecf {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(zzfbg zzfbgVar, zzfau zzfauVar) {
        JSONObject jSONObject = zzfauVar.zzv;
        String strOptString = jSONObject.optString("pubid", "");
        zzfbp zzfbpVar = zzfbgVar.zza.zza;
        zzfbn zzfbnVar = new zzfbn();
        zzfbnVar.zzq(zzfbpVar);
        zzfbnVar.zzt(strOptString);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfbpVar.zzd;
        Bundle bundleZzd = zzd(zzmVar.zzm);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = jSONObject.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = jSONObject.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        JSONObject jSONObject2 = zzfauVar.zzD;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = jSONObject2.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        zzfbnVar.zzH(new com.google.android.gms.ads.internal.client.zzm(zzmVar.zza, zzmVar.zzb, bundleZzd2, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, bundleZzd, zzmVar.zzn, zzmVar.zzo, zzmVar.zzp, zzmVar.zzq, zzmVar.zzr, zzmVar.zzs, zzmVar.zzt, zzmVar.zzu, zzmVar.zzv, zzmVar.zzw, zzmVar.zzx, zzmVar.zzy, zzmVar.zzz));
        zzfbp zzfbpVarZzJ = zzfbnVar.zzJ();
        Bundle bundle = new Bundle();
        zzfax zzfaxVar = zzfbgVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzfaxVar.zza));
        bundle2.putInt("refresh_interval", zzfaxVar.zzc);
        bundle2.putString("gws_query_id", zzfaxVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzfbpVar.zzf;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzfauVar.zzw);
        bundle3.putString("ad_source_name", zzfauVar.zzF);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzfauVar.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzfauVar.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfauVar.zzp));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzfauVar.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzfauVar.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzfauVar.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzfauVar.zzi));
        bundle3.putString("transaction_id", zzfauVar.zzj);
        bundle3.putString("valid_from_timestamp", zzfauVar.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzfauVar.zzP);
        bundle3.putString("recursive_server_response_data", zzfauVar.zzao);
        bundle3.putBoolean("is_analytics_logging_enabled", zzfauVar.zzW);
        zzbvw zzbvwVar = zzfauVar.zzl;
        if (zzbvwVar != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzbvwVar.zzb);
            bundle4.putString("rb_type", zzbvwVar.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzfbpVarZzJ, bundle, zzfauVar, zzfbgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        return !TextUtils.isEmpty(zzfauVar.zzv.optString("pubid", ""));
    }

    protected abstract ListenableFuture zzc(zzfbp zzfbpVar, Bundle bundle, zzfau zzfauVar, zzfbg zzfbgVar);
}

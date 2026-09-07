package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.b9;
import com.json.c9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes14.dex */
public final class zzdki {
    private final zzgcd zza;
    private final zzdkx zzb;
    private final zzdlc zzc;

    public zzdki(zzgcd zzgcdVar, zzdkx zzdkxVar, zzdlc zzdlcVar) {
        this.zza = zzgcdVar;
        this.zzb = zzdkxVar;
        this.zzc = zzdlcVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdhq zza(zzdki zzdkiVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        zzdhq zzdhqVar = (zzdhq) listenableFuture.get();
        zzdhqVar.zzP((List) listenableFuture2.get());
        zzdhqVar.zzM((zzbft) listenableFuture3.get());
        zzdhqVar.zzQ((zzbft) listenableFuture4.get());
        zzdhqVar.zzJ((zzbfm) listenableFuture5.get());
        zzdhqVar.zzS(zzdkx.zzj(jSONObject));
        zzdhqVar.zzL(zzdkx.zzi(jSONObject));
        zzcel zzcelVar = (zzcel) listenableFuture6.get();
        if (zzcelVar != null) {
            zzdhqVar.zzad(zzcelVar);
            zzdhqVar.zzac(zzcelVar.zzF());
            zzdhqVar.zzab(zzcelVar.zzq());
        }
        zzdhqVar.zzd().putAll((Bundle) listenableFuture7.get());
        zzcel zzcelVar2 = (zzcel) listenableFuture8.get();
        if (zzcelVar2 != null) {
            zzdhqVar.zzO(zzcelVar2);
            zzdhqVar.zzae(zzcelVar2.zzF());
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzft)).booleanValue() || zzc(jSONObject)) {
            zzcel zzcelVar3 = (zzcel) listenableFuture9.get();
            if (zzcelVar3 != null) {
                zzdhqVar.zzT(zzcelVar3);
            }
        } else {
            zzdhqVar.zzU(listenableFuture9);
            zzdhqVar.zzX(new zzbzp());
        }
        for (zzdlb zzdlbVar : (List) listenableFuture10.get()) {
            if (zzdlbVar.zza != 1) {
                zzdhqVar.zzN(zzdlbVar.zzb, zzdlbVar.zzd);
            } else {
                zzdhqVar.zzZ(zzdlbVar.zzb, zzdlbVar.zzc);
            }
        }
        return zzdhqVar;
    }

    private static final boolean zzc(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00a4  */
    public final ListenableFuture zzb(final zzfbg zzfbgVar, final zzfau zzfauVar, final JSONObject jSONObject) {
        ListenableFuture listenableFutureZzh;
        JSONObject jSONObjectOptJSONObject;
        ListenableFuture listenableFutureZzh2;
        JSONArray jSONArrayOptJSONArray;
        final ListenableFuture listenableFutureZzb = this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdkg
            @Override // java.util.concurrent.Callable
            public final Object call() throws zzefy {
                zzdhq zzdhqVar = new zzdhq();
                JSONObject jSONObject2 = jSONObject;
                zzdhqVar.zzaa(jSONObject2.optInt("template_id", -1));
                zzdhqVar.zzK(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                String strOptString = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null;
                zzfbg zzfbgVar2 = zzfbgVar;
                zzdhqVar.zzV(strOptString);
                zzfbp zzfbpVar = zzfbgVar2.zza.zza;
                if (!zzfbpVar.zzg.contains(Integer.toString(zzdhqVar.zzc()))) {
                    throw new zzefy(1, "Invalid template ID: " + zzdhqVar.zzc());
                }
                if (zzdhqVar.zzc() == 3) {
                    if (zzdhqVar.zzA() == null) {
                        throw new zzefy(1, "No custom template id for custom template ad response.");
                    }
                    if (!zzfbpVar.zzh.contains(zzdhqVar.zzA())) {
                        throw new zzefy(1, "Unexpected custom template id in the response.");
                    }
                }
                zzfau zzfauVar2 = zzfauVar;
                zzdhqVar.zzY(jSONObject2.optDouble("rating", -1.0d));
                String strOptString2 = jSONObject2.optString("headline", null);
                if (zzfauVar2.zzM) {
                    com.google.android.gms.ads.internal.zzv.zzq();
                    strOptString2 = com.google.android.gms.ads.internal.util.zzs.zzz() + " : " + strOptString2;
                }
                zzdhqVar.zzZ("headline", strOptString2);
                zzdhqVar.zzZ("body", jSONObject2.optString("body", null));
                zzdhqVar.zzZ("call_to_action", jSONObject2.optString("call_to_action", null));
                zzdhqVar.zzZ(b9.h.U, jSONObject2.optString(b9.h.U, null));
                zzdhqVar.zzZ("price", jSONObject2.optString("price", null));
                zzdhqVar.zzZ(b9.h.F0, jSONObject2.optString(b9.h.F0, null));
                return zzdhqVar;
            }
        });
        zzdkx zzdkxVar = this.zzb;
        final ListenableFuture listenableFutureZzf = zzdkxVar.zzf(jSONObject, "images");
        zzfax zzfaxVar = zzfbgVar.zzb.zzb;
        final ListenableFuture listenableFutureZzg = zzdkxVar.zzg(jSONObject, "images", zzfauVar, zzfaxVar);
        final ListenableFuture listenableFutureZze = zzdkxVar.zze(jSONObject, "secondary_image");
        final ListenableFuture listenableFutureZze2 = zzdkxVar.zze(jSONObject, "app_icon");
        final ListenableFuture listenableFutureZzd = zzdkxVar.zzd(jSONObject, c9.ATTRIBUTION);
        final ListenableFuture listenableFutureZzh3 = zzdkxVar.zzh(jSONObject, zzfauVar, zzfaxVar);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmY)).booleanValue() || !jSONObject.has("video")) {
            listenableFutureZzh = zzgbs.zzh(new Bundle());
            break;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject2.has("flags") && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("flags")) != null) {
            int i = 0;
            while (true) {
                if (i < jSONArrayOptJSONArray.length()) {
                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject3 == null || !jSONObjectOptJSONObject3.optString("key").equals("afma_video_player_type")) {
                        i++;
                    } else {
                        try {
                            if (Integer.parseInt(jSONObjectOptJSONObject3.optString("value")) == 3) {
                                zzdkx zzdkxVar2 = this.zzb;
                                zzbzp zzbzpVar = new zzbzp();
                                zzgbs.zzr(listenableFutureZzh3, new zzdkw(zzdkxVar2, zzbzpVar), zzbzk.zzf);
                                listenableFutureZzh = zzbzpVar;
                                break;
                            }
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
                listenableFutureZzh = zzgbs.zzh(new Bundle());
                break;
            }
        }
        listenableFutureZzh = zzgbs.zzh(new Bundle());
        break;
        final ListenableFuture listenableFutureZza = this.zzc.zza(jSONObject, "custom_assets");
        final zzdkx zzdkxVar3 = this.zzb;
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            listenableFutureZzh2 = TextUtils.isEmpty(strOptString) ? zzgbs.zzh(null) : zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdkm
                @Override // com.google.android.gms.internal.ads.zzgaz
                public final ListenableFuture zza(Object obj) {
                    return zzdkx.zzc(zzdkxVar3, strOptString, obj);
                }
            }, zzbzk.zzf);
        } else {
            listenableFutureZzh2 = zzgbs.zzh(null);
        }
        final ListenableFuture listenableFuture = listenableFutureZzh2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(listenableFutureZzb);
        arrayList.add(listenableFutureZzf);
        arrayList.add(listenableFutureZzg);
        arrayList.add(listenableFutureZze);
        arrayList.add(listenableFutureZze2);
        arrayList.add(listenableFutureZzd);
        arrayList.add(listenableFutureZzh3);
        arrayList.add(listenableFutureZzh);
        arrayList.add(listenableFutureZza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzft)).booleanValue() || zzc(jSONObject)) {
            arrayList.add(listenableFuture);
        }
        final ListenableFuture listenableFuture2 = listenableFutureZzh;
        return zzgbs.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdkh
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzdki.zza(this.zza, listenableFutureZzb, listenableFutureZzf, listenableFutureZze2, listenableFutureZze, listenableFutureZzd, jSONObject, listenableFutureZzh3, listenableFuture2, listenableFutureZzg, listenableFuture, listenableFutureZza);
            }
        }, this.zza);
    }
}

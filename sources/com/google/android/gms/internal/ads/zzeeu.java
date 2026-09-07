package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzeeu implements zzeeo {
    private final zzdga zza;
    private final zzgcd zzb;
    private final zzdki zzc;
    private final zzfco zzd;
    private final zzdmz zze;
    private final zzdqy zzf;

    public zzeeu(zzdga zzdgaVar, zzgcd zzgcdVar, zzdki zzdkiVar, zzfco zzfcoVar, zzdmz zzdmzVar, zzdqy zzdqyVar) {
        this.zza = zzdgaVar;
        this.zzb = zzgcdVar;
        this.zzc = zzdkiVar;
        this.zzd = zzfcoVar;
        this.zze = zzdmzVar;
        this.zzf = zzdqyVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ zzdhl zzc(zzeeu zzeeuVar, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfbg zzfbgVar, zzfau zzfauVar, JSONObject jSONObject) {
        zzdhq zzdhqVar = (zzdhq) listenableFuture.get();
        zzdmt zzdmtVar = (zzdmt) listenableFuture2.get();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            zzeeuVar.zzf.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzdhr zzdhrVarZzd = zzeeuVar.zza.zzd(new zzcqw(zzfbgVar, zzfauVar, null), new zzdic(zzdhqVar), new zzdgo(jSONObject, zzdmtVar));
        zzbbz zzbbzVar = zzbci.zzcs;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis();
            zzdqy zzdqyVar = zzeeuVar.zzf;
            zzdqyVar.zza().putLong(zzdqm.RENDERING_AD_COMPONENT_CREATION_END.zza(), jCurrentTimeMillis);
            zzdqyVar.zza().putLong(zzdqm.RENDERING_CONFIGURE_WEBVIEW_START.zza(), jCurrentTimeMillis);
        }
        zzdhrVarZzd.zzh().zzb();
        zzdhrVarZzd.zzi().zza(zzdmtVar);
        zzdhrVarZzd.zzg().zzc(zzdhqVar.zzs());
        zzdhrVarZzd.zzl().zza(zzeeuVar.zze, zzdhqVar.zzq());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbbzVar)).booleanValue()) {
            zzeeuVar.zzf.zza().putLong(zzdqm.RENDERING_CONFIGURE_WEBVIEW_END.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        return zzdhrVarZzd.zza();
    }

    public static /* synthetic */ ListenableFuture zzd(zzeeu zzeeuVar, zzfbg zzfbgVar, zzfau zzfauVar, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzgbs.zzg(new zzdvg(3));
        }
        int i = zzfbgVar.zza.zza.zzk;
        if (i <= 1) {
            return zzgbs.zzm(zzeeuVar.zzg(zzfbgVar, zzfauVar, jSONArray.getJSONObject(0)), new zzftl() { // from class: com.google.android.gms.internal.ads.zzeet
                @Override // com.google.android.gms.internal.ads.zzftl
                public final Object apply(Object obj) {
                    return Collections.singletonList(zzgbs.zzh((zzdhl) obj));
                }
            }, zzeeuVar.zzb);
        }
        int length = jSONArray.length();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzct)).booleanValue()) {
            zzeeuVar.zzf.zzd("nsl", String.valueOf(length));
        }
        zzeeuVar.zzd.zzc(Math.min(length, i));
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 < length) {
                arrayList.add(zzeeuVar.zzg(zzfbgVar, zzfauVar, jSONArray.getJSONObject(i2)));
            } else {
                arrayList.add(zzgbs.zzg(new zzdvg(3)));
            }
        }
        return zzgbs.zzh(arrayList);
    }

    public static /* synthetic */ ListenableFuture zze(final zzeeu zzeeuVar, zzfau zzfauVar, final zzdmt zzdmtVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zziL)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfauVar.zzs.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgbs.zzn(zzdmtVar.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzeeu.zzf(this.zza, zzdmtVar, (JSONObject) obj);
            }
        }, zzeeuVar.zzb);
    }

    public static /* synthetic */ ListenableFuture zzf(zzeeu zzeeuVar, zzdmt zzdmtVar, JSONObject jSONObject) throws zzbnp {
        zzeeuVar.zzd.zzb(zzgbs.zzh(zzdmtVar));
        if (jSONObject.optBoolean("success")) {
            return zzgbs.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbnp("process json failed");
    }

    private final ListenableFuture zzg(final zzfbg zzfbgVar, final zzfau zzfauVar, final JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcs)).booleanValue()) {
            this.zzf.zza().putLong(zzdqm.RENDERING_WEBVIEW_CREATION_START.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
        zzfco zzfcoVar = this.zzd;
        zzdki zzdkiVar = this.zzc;
        final ListenableFuture listenableFutureZza = zzfcoVar.zza();
        final ListenableFuture listenableFutureZzb = zzdkiVar.zzb(zzfbgVar, zzfauVar, jSONObject);
        return zzgbs.zzc(listenableFutureZza, listenableFutureZzb).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeep
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeeu.zzc(this.zza, listenableFutureZzb, listenableFutureZza, zzfbgVar, zzfauVar, jSONObject);
            }
        }, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final ListenableFuture zza(final zzfbg zzfbgVar, final zzfau zzfauVar) {
        ListenableFuture listenableFutureZza = this.zzd.zza();
        zzgaz zzgazVar = new zzgaz() { // from class: com.google.android.gms.internal.ads.zzeer
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzeeu.zze(this.zza, zzfauVar, (zzdmt) obj);
            }
        };
        zzgcd zzgcdVar = this.zzb;
        return zzgbs.zzn(zzgbs.zzn(listenableFutureZza, zzgazVar, zzgcdVar), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzees
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzeeu.zzd(this.zza, zzfbgVar, zzfauVar, (JSONArray) obj);
            }
        }, zzgcdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzecf
    public final boolean zzb(zzfbg zzfbgVar, zzfau zzfauVar) {
        zzfaz zzfazVar = zzfauVar.zzs;
        return (zzfazVar == null || zzfazVar.zzc == null) ? false : true;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.json.c9;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.pubmatic.sdk.common.POBCommonConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdkx {
    private final Context zza;
    private final zzdke zzb;
    private final zzauy zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbbg zzf;
    private final Executor zzg;
    private final zzbfi zzh;
    private final zzdlp zzi;
    private final zzdoe zzj;
    private final ScheduledExecutorService zzk;
    private final zzdmz zzl;
    private final zzdre zzm;
    private final zzfio zzn;
    private final zzeat zzo;
    private final zzebe zzp;
    private final zzfbt zzq;

    public zzdkx(Context context, zzdke zzdkeVar, zzauy zzauyVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbbg zzbbgVar, Executor executor, zzfbp zzfbpVar, zzdlp zzdlpVar, zzdoe zzdoeVar, ScheduledExecutorService scheduledExecutorService, zzdre zzdreVar, zzfio zzfioVar, zzeat zzeatVar, zzdmz zzdmzVar, zzebe zzebeVar, zzfbt zzfbtVar) {
        this.zza = context;
        this.zzb = zzdkeVar;
        this.zzc = zzauyVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbbgVar;
        this.zzg = executor;
        this.zzh = zzfbpVar.zzi;
        this.zzi = zzdlpVar;
        this.zzj = zzdoeVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdreVar;
        this.zzn = zzfioVar;
        this.zzo = zzeatVar;
        this.zzl = zzdmzVar;
        this.zzp = zzebeVar;
        this.zzq = zzfbtVar;
    }

    public static /* synthetic */ zzbfd zza(zzdkx zzdkxVar, JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzq = zzq(jSONObject, "bg_color");
        Integer numZzq2 = zzq(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbfd(strOptString, list, numZzq, numZzq2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, zzdkxVar.zzh.zze, zOptBoolean);
    }

    public static /* synthetic */ ListenableFuture zzb(zzdkx zzdkxVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfau zzfauVar, zzfax zzfaxVar, String str, String str2, Object obj) throws zzcex {
        zzcel zzcelVarZza = zzdkxVar.zzj.zza(zzrVar, zzfauVar, zzfaxVar);
        final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVarZza);
        zzdmw zzdmwVarZzb = zzdkxVar.zzl.zzb();
        zzcelVarZza.zzN().zzV(zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, zzdmwVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(zzdkxVar.zza, null, null), null, null, zzdkxVar.zzo, zzdkxVar.zzn, zzdkxVar.zzm, null, zzdmwVarZzb, null, null, null, null);
        zzcelVarZza.zzag("/getNativeAdViewSignals", zzbji.zzs);
        zzcelVarZza.zzag("/getNativeClickMeta", zzbji.zzt);
        zzcelVarZza.zzN().zzF(true);
        zzcelVarZza.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdku
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str3, String str4) {
                zzbzo zzbzoVar = zzbzoVarZza;
                if (z) {
                    zzbzoVar.zzb();
                    return;
                }
                zzbzoVar.zzd(new zzefy(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcelVarZza.zzae(str, str2, null);
        return zzbzoVarZza;
    }

    public static /* synthetic */ ListenableFuture zzc(zzdkx zzdkxVar, String str, Object obj) throws zzcex {
        com.google.android.gms.ads.internal.zzv.zzA();
        com.google.android.gms.ads.internal.zza zzaVar = zzdkxVar.zze;
        zzbbg zzbbgVar = zzdkxVar.zzf;
        Context context = zzdkxVar.zza;
        zzcgf zzcgfVarZza = zzcgf.zza();
        zzebe zzebeVar = zzdkxVar.zzp;
        zzfbt zzfbtVar = zzdkxVar.zzq;
        zzdre zzdreVar = zzdkxVar.zzm;
        zzcel zzcelVarZza = zzcey.zza(context, zzcgfVarZza, "native-omid", false, false, zzdkxVar.zzc, null, zzdkxVar.zzd, null, null, zzaVar, zzbbgVar, null, null, zzebeVar, zzfbtVar, zzdreVar);
        final zzbzo zzbzoVarZza = zzbzo.zza(zzcelVarZza);
        zzcelVarZza.zzN().zzC(new zzcgb() { // from class: com.google.android.gms.internal.ads.zzdkk
            @Override // com.google.android.gms.internal.ads.zzcgb
            public final void zza(boolean z, int i, String str2, String str3) {
                zzbzoVarZza.zzb();
            }
        });
        zzcelVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), POBCommonConstants.CONTENT_TYPE_HTML, "base64");
        return zzbzoVarZza;
    }

    public static final com.google.android.gms.ads.internal.client.zzev zzi(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(jSONObjectOptJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzfww.zzn();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfww.zzn();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzev zzevVarZzr = zzr(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzevVarZzr != null) {
                arrayList.add(zzevVarZzr);
            }
        }
        return zzfww.zzl(arrayList);
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        final Object obj2 = null;
        return zzgbs.zzf(listenableFuture, Exception.class, new zzgaz(obj2) { // from class: com.google.android.gms.internal.ads.zzdks
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgbs.zzh(null);
            }
        }, zzbzk.zzg);
    }

    private static ListenableFuture zzm(boolean z, final ListenableFuture listenableFuture, Object obj) {
        return z ? zzgbs.zzn(listenableFuture, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdkt
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj2) {
                return obj2 != null ? listenableFuture : zzgbs.zzg(new zzefy(1, "Retrieve required value in native ad response failed."));
            }
        }, zzbzk.zzg) : zzl(listenableFuture, null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgbs.zzh(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgbs.zzh(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgbs.zzh(new zzbfg(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgbs.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdkl
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return new zzbfg(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2);
            }
        }, this.zzg), null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgbs.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzgbs.zzm(zzgbs.zzd(arrayList), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdkq
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbfg zzbfgVar : (List) obj) {
                    if (zzbfgVar != null) {
                        arrayList2.add(zzbfgVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzfau zzfauVar, zzfax zzfaxVar) {
        final ListenableFuture listenableFutureZze = this.zzi.zze(jSONObject.optString("base_url"), jSONObject.optString("html"), zzfauVar, zzfaxVar, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgbs.zzn(listenableFutureZze, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdkn
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) throws zzefy {
                zzcel zzcelVar = (zzcel) obj;
                if (zzcelVar == null || zzcelVar.zzq() == null) {
                    throw new zzefy(1, "Retrieve video view in html5 ad response failed.");
                }
                return listenableFutureZze;
            }
        }, zzbzk.zzg);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final com.google.android.gms.ads.internal.client.zzev zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzev(strOptString, strOptString2);
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(c9.ATTRIBUTION);
        if (jSONObjectOptJSONObject == null) {
            return zzgbs.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzm(jSONObjectOptJSONObject.optBoolean("require"), zzgbs.zzm(zzo(jSONArrayOptJSONArray, false, true), new zzftl() { // from class: com.google.android.gms.internal.ads.zzdkr
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                return zzdkx.zza(this.zza, jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbfi zzbfiVar = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbfiVar.zzb, zzbfiVar.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, final zzfau zzfauVar, final zzfax zzfaxVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzke)).booleanValue()) {
            return zzgbs.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgbs.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgbs.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final com.google.android.gms.ads.internal.client.zzr zzrVarZzk = zzk(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgbs.zzh(null);
        }
        final ListenableFuture listenableFutureZzn = zzgbs.zzn(zzgbs.zzh(null), new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdko
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) {
                return zzdkx.zzb(this.zza, zzrVarZzk, zzfauVar, zzfaxVar, strOptString, strOptString2, obj);
            }
        }, zzbzk.zzf);
        return zzgbs.zzn(listenableFutureZzn, new zzgaz() { // from class: com.google.android.gms.internal.ads.zzdkp
            @Override // com.google.android.gms.internal.ads.zzgaz
            public final ListenableFuture zza(Object obj) throws zzefy {
                if (((zzcel) obj) != null) {
                    return listenableFutureZzn;
                }
                throw new zzefy(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzbzk.zzg);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzfau zzfauVar, zzfax zzfaxVar) {
        ListenableFuture listenableFutureZzd;
        boolean z = false;
        JSONObject jSONObjectZzh = com.google.android.gms.ads.internal.util.zzbs.zzh(jSONObject, "html_containers", "instream");
        if (jSONObjectZzh != null) {
            return zzp(jSONObjectZzh, zzfauVar, zzfaxVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzgbs.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkd)).booleanValue() && jSONObjectOptJSONObject.has("html")) {
            z = true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z) {
                listenableFutureZzd = this.zzi.zzd(jSONObjectOptJSONObject);
            }
            return zzl(zzgbs.zzo(listenableFutureZzd, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdZ)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Required field 'vast_xml' or 'html' is missing");
            return zzgbs.zzh(null);
        }
        listenableFutureZzd = zzp(jSONObjectOptJSONObject, zzfauVar, zzfaxVar);
        return zzl(zzgbs.zzo(listenableFutureZzd, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdZ)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }

    private final com.google.android.gms.ads.internal.client.zzr zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzr.zzc();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzr(this.zza, new AdSize(i, i2));
    }
}

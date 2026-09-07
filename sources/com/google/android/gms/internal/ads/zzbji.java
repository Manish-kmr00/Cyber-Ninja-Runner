package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzbji {
    public static final zzbjj zza = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbig
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzcfs zzcfsVar = (zzcfs) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] strArrSplit = str.split(StringUtils.COMMA);
            HashMap map2 = new HashMap();
            PackageManager packageManager = zzcfsVar.getContext().getPackageManager();
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split(";", 2);
                boolean z = true;
                if (packageManager.resolveActivity(new Intent(strArrSplit2.length > 1 ? strArrSplit2[1].trim() : "android.intent.action.VIEW", Uri.parse(strArrSplit2[0].trim())), 65536) == null) {
                    z = false;
                }
                Boolean boolValueOf = Boolean.valueOf(z);
                map2.put(str2, boolValueOf);
                com.google.android.gms.ads.internal.util.zze.zza("/canOpenURLs;" + str2 + ";" + boolValueOf);
            }
            ((zzbme) zzcfsVar).zzd("openableURLs", map2);
        }
    };
    public static final zzbjj zzb = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbii
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzcfs zzcfsVar = (zzcfs) obj;
            zzbjj zzbjjVar = zzbji.zza;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzio)).booleanValue()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("canOpenAppGmsgHandler disabled.");
                return;
            }
            String str = (String) map.get("package_name");
            if (TextUtils.isEmpty(str)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Package name missing in canOpenApp GMSG.");
                return;
            }
            HashMap map2 = new HashMap();
            Boolean boolValueOf = Boolean.valueOf(zzcfsVar.getContext().getPackageManager().getLaunchIntentForPackage(str) != null);
            map2.put(str, boolValueOf);
            com.google.android.gms.ads.internal.util.zze.zza("/canOpenApp;" + str + ";" + boolValueOf);
            ((zzbme) zzcfsVar).zzd("openableApp", map2);
        }
    };
    public static final zzbjj zzc = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbil
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzbji.zzb((zzcfs) obj, map);
        }
    };
    public static final zzbjj zzd = new zzbja();
    public static final zzbjj zze = new zzbjb();
    public static final zzbjj zzf = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbim
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzcfs zzcfsVar = (zzcfs) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
            if (str == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from httpTrack GMSG.");
            } else {
                zzcec zzcecVar = (zzcec) zzcfsVar;
                new com.google.android.gms.ads.internal.util.zzbw(zzcfsVar.getContext(), ((zzcfz) zzcfsVar).zzm().afmaVersion, str, null, zzcecVar.zzD() != null ? zzcecVar.zzD().zzax : null).zzb();
            }
        }
    };
    public static final zzbjj zzg = new zzbjc();
    public static final zzbjj zzh = new zzbjd();
    public static final zzbjj zzi = new zzbjj() { // from class: com.google.android.gms.internal.ads.zzbij
        @Override // com.google.android.gms.internal.ads.zzbjj
        public final void zza(Object obj, Map map) {
            zzcfy zzcfyVar = (zzcfy) obj;
            zzbjj zzbjjVar = zzbji.zza;
            String str = (String) map.get("tx");
            String str2 = (String) map.get("ty");
            String str3 = (String) map.get("td");
            try {
                int i = Integer.parseInt(str);
                int i2 = Integer.parseInt(str2);
                int i3 = Integer.parseInt(str3);
                zzauy zzauyVarZzI = zzcfyVar.zzI();
                if (zzauyVarZzI != null) {
                    zzauyVarZzI.zzc().zzl(i, i2, i3);
                }
            } catch (NumberFormatException unused) {
                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzbjj zzj = new zzbje();
    public static final zzbjj zzk = new zzbjf();
    public static final zzbjj zzl = new zzccg();
    public static final zzbjj zzm = new zzcch();
    public static final zzbjj zzn = new zzbic();
    public static final zzbjz zzo = new zzbjz();
    public static final zzbjj zzp = new zzbjg();
    public static final zzbjj zzq = new zzbjh();
    public static final zzbjj zzr = new zzbin();
    public static final zzbjj zzs = new zzbio();
    public static final zzbjj zzt = new zzbip();
    public static final zzbjj zzu = new zzbiq();
    public static final zzbjj zzv = new zzbir();
    public static final zzbjj zzw = new zzbis();
    public static final zzbjj zzx = new zzbit();
    public static final zzbjj zzy = new zzbiu();
    public static final zzbjj zzz = new zzbiv();
    public static final zzbjj zzA = new zzbiw();
    public static final zzbjj zzB = new zzbiy();
    public static final zzbjj zzC = new zzbiz();

    public static ListenableFuture zza(zzcel zzcelVar, String str) {
        Uri uriZza = Uri.parse(str);
        try {
            zzauy zzauyVarZzI = zzcelVar.zzI();
            zzfbt zzfbtVarZzS = zzcelVar.zzS();
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzmc)).booleanValue() || zzfbtVarZzS == null) {
                if (zzauyVarZzI != null && zzauyVarZzI.zzf(uriZza)) {
                    uriZza = zzauyVarZzI.zza(uriZza, zzcelVar.getContext(), zzcelVar.zzF(), zzcelVar.zzi());
                }
            } else if (zzauyVarZzI != null && zzauyVarZzI.zzf(uriZza)) {
                uriZza = zzfbtVarZzS.zza(uriZza, zzcelVar.getContext(), zzcelVar.zzF(), zzcelVar.zzi());
            }
        } catch (zzauz unused) {
            String strConcat = "Unable to append parameter to URL: ".concat(str);
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(strConcat);
        }
        Map map = new HashMap();
        if (zzcelVar.zzD() != null) {
            map = zzcelVar.zzD().zzaw;
        }
        final String strZzb = zzbxy.zzb(uriZza, zzcelVar.getContext(), map);
        long jLongValue = ((Long) zzbeh.zze.zze()).longValue();
        if (jLongValue <= 0 || jLongValue > 251310000) {
            return zzgbs.zzh(strZzb);
        }
        zzgbj zzgbjVar = (zzgbj) zzgbs.zze(zzgbj.zzE(zzcelVar.zzT()), Throwable.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzbid
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbjj zzbjjVar = zzbji.zza;
                if (!((Boolean) zzbeh.zzi.zze()).booleanValue()) {
                    return "failure_click_attok";
                }
                com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "prepareClickUrl.attestation1");
                return "failure_click_attok";
            }
        }, zzbzk.zzg);
        zzftl zzftlVar = new zzftl() { // from class: com.google.android.gms.internal.ads.zzbie
            /* JADX WARN: Code duplicated, block: B:15:0x0055  */
            /* JADX WARN: Code duplicated, block: B:18:0x005f  */
            /* JADX WARN: Code duplicated, block: B:20:0x006d  */
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                String str2;
                String str3;
                Uri uri;
                String str4 = (String) obj;
                zzbjj zzbjjVar = zzbji.zza;
                String strReplace = strZzb;
                if (str4 != null) {
                    if (((Boolean) zzbeh.zzf.zze()).booleanValue()) {
                        String[] strArr = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
                        String host = Uri.parse(strReplace).getHost();
                        for (int i2 = 0; i2 < 3; i2++) {
                            if (host.endsWith(strArr[i2])) {
                                str2 = (String) zzbeh.zza.zze();
                                str3 = (String) zzbeh.zzb.zze();
                                if (!TextUtils.isEmpty(str2)) {
                                    strReplace = strReplace.replace(str2, str4);
                                }
                                if (!TextUtils.isEmpty(str3)) {
                                    uri = Uri.parse(strReplace);
                                    if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                        break;
                                    }
                                    return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                                }
                                break;
                            }
                        }
                    } else {
                        str2 = (String) zzbeh.zza.zze();
                        str3 = (String) zzbeh.zzb.zze();
                        if (!TextUtils.isEmpty(str2)) {
                            strReplace = strReplace.replace(str2, str4);
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            uri = Uri.parse(strReplace);
                            if (!TextUtils.isEmpty(uri.getQueryParameter(str3))) {
                                return uri.buildUpon().appendQueryParameter(str3, str4).toString();
                            }
                        }
                    }
                }
                return strReplace;
            }
        };
        zzgcd zzgcdVar = zzbzk.zzg;
        return (zzgbj) zzgbs.zze((zzgbj) zzgbs.zzm(zzgbjVar, zzftlVar, zzgcdVar), Throwable.class, new zzftl() { // from class: com.google.android.gms.internal.ads.zzbif
            @Override // com.google.android.gms.internal.ads.zzftl
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbjj zzbjjVar = zzbji.zza;
                if (((Boolean) zzbeh.zzi.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "prepareClickUrl.attestation2");
                }
                return strZzb;
            }
        }, zzgcdVar);
    }

    static /* synthetic */ void zzb(zzcfs zzcfsVar, Map map) {
        Intent uri;
        PackageManager packageManager = zzcfsVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String strOptString = jSONObject2.optString("id");
                        String strOptString2 = jSONObject2.optString(ApsMetricsDataMap.APSMETRICS_FIELD_URL);
                        String strOptString3 = jSONObject2.optString("i");
                        String strOptString4 = jSONObject2.optString("m");
                        String strOptString5 = jSONObject2.optString("p");
                        String strOptString6 = jSONObject2.optString(ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
                        String strOptString7 = jSONObject2.optString("intent_url");
                        ResolveInfo resolveInfoResolveActivity = null;
                        if (TextUtils.isEmpty(strOptString7)) {
                            uri = null;
                        } else {
                            try {
                                uri = Intent.parseUri(strOptString7, 0);
                            } catch (URISyntaxException e) {
                                String strValueOf = String.valueOf(strOptString7);
                                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the url: ".concat(strValueOf), e);
                                uri = null;
                            }
                        }
                        if (uri == null) {
                            uri = new Intent();
                            if (!TextUtils.isEmpty(strOptString2)) {
                                uri.setData(Uri.parse(strOptString2));
                            }
                            if (!TextUtils.isEmpty(strOptString3)) {
                                uri.setAction(strOptString3);
                            }
                            if (!TextUtils.isEmpty(strOptString4)) {
                                uri.setType(strOptString4);
                            }
                            if (!TextUtils.isEmpty(strOptString5)) {
                                uri.setPackage(strOptString5);
                            }
                            if (!TextUtils.isEmpty(strOptString6)) {
                                String[] strArrSplit = strOptString6.split(RemoteSettings.FORWARD_SLASH_STRING, 2);
                                if (strArrSplit.length == 2) {
                                    uri.setComponent(new ComponentName(strArrSplit[0], strArrSplit[1]));
                                }
                            }
                        }
                        Intent intent = uri;
                        try {
                            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
                        } catch (NullPointerException e2) {
                            com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, intent.toString());
                        }
                        try {
                            jSONObject.put(strOptString, resolveInfoResolveActivity != null);
                        } catch (JSONException e3) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the intent data.", e4);
                    }
                }
                ((zzbme) zzcfsVar).zze("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzbme) zzcfsVar).zze("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzbme) zzcfsVar).zze("openableIntents", new JSONObject());
        }
    }

    public static void zzc(Map map, zzddc zzddcVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzkP)).booleanValue() && map.containsKey("sc") && ((String) map.get("sc")).equals("1") && zzddcVar != null) {
            zzddcVar.zzdd();
        }
    }
}

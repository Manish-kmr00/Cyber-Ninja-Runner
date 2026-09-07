package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzcct implements zzbjj {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = "Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str));
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzccs zzccvVar;
        zzcck zzcckVarZza;
        zzcbg zzcbgVar = (zzcbg) obj;
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzccl zzcclVarZzz = com.google.android.gms.ads.internal.zzv.zzz();
        if (map.containsKey("abort")) {
            if (zzcclVarZzz.zzd(zzcbgVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcbf zzcbfVar = new zzcbf((String) map.get("flags"));
        boolean z = zzcbfVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z) {
                Iterator it = zzcclVarZzz.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzcckVarZza = null;
                        break;
                    }
                    zzcck zzcckVar = (zzcck) it.next();
                    if (zzcckVar.zza == zzcbgVar && str.equals(zzcckVar.zze())) {
                        zzcckVarZza = zzcckVar;
                        break;
                    }
                }
            } else {
                zzcckVarZza = zzcclVarZzz.zza(zzcbgVar);
            }
            if (zzcckVarZza != null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache task is already running.");
                return;
            }
            if (zzcbgVar.zzj() == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = 0;
            }
            if (numZzb != null) {
                zzcbgVar.zzA(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzcbgVar.zzy(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzcbgVar.zzx(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzccd zzccdVar = zzcbgVar.zzj().zzb;
            if (iIntValue > 0) {
                int i2 = zzcbfVar.zzg;
                int iZzu = zzcax.zzu();
                if (iZzu < i2) {
                    zzccvVar = new zzcdb(zzcbgVar, zzcbfVar);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzo)).booleanValue()) {
                        iZzu = zzccy.zzi();
                    }
                    zzccvVar = iZzu < zzcbfVar.zzb ? new zzccy(zzcbgVar, zzcbfVar) : new zzccw(zzcbgVar);
                }
            } else {
                zzccvVar = new zzccv(zzcbgVar);
            }
            new zzcck(zzcbgVar, zzccvVar, str, strArr).zzb();
        } else {
            zzcck zzcckVarZza2 = zzcclVarZzz.zza(zzcbgVar);
            if (zzcckVarZza2 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache must specify a source.");
                return;
            }
            zzccvVar = zzcckVarZza2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzccvVar.zzs(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzccvVar.zzr(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzccvVar.zzp(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzccvVar.zzq(numZzb8.intValue());
        }
    }
}

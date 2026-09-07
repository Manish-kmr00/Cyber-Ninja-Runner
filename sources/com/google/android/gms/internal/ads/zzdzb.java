package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class zzdzb implements zzfex {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfgc zzc;
    private final zzfgn zzd;

    public zzdzb(String str, zzfgn zzfgnVar, zzfgc zzfgcVar) {
        this.zzb = str;
        this.zzd = zzfgnVar;
        this.zzc = zzfgcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfex
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdvg zzdvgVar;
        JSONObject jSONObject;
        String strConcat;
        zzdza zzdzaVar = (zzdza) obj;
        int iOptInt = zzdzaVar.zza.optInt("http_timeout_millis", 60000);
        zzbva zzbvaVar = zzdzaVar.zzb;
        String strJoin = "";
        if (zzbvaVar.zza() != -2) {
            if (zzbvaVar.zza() == 1) {
                if (zzbvaVar.zzh() != null) {
                    strJoin = TextUtils.join(", ", zzbvaVar.zzh());
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg(strJoin);
                }
                zzdvgVar = new zzdvg(2, "Error building request URL: ".concat(String.valueOf(strJoin)));
            } else {
                zzdvgVar = new zzdvg(1);
            }
            zzfgn zzfgnVar = this.zzd;
            zzfgc zzfgcVar = this.zzc;
            zzfgcVar.zzh(zzdvgVar);
            zzfgcVar.zzg(false);
            zzfgnVar.zza(zzfgcVar);
            throw zzdvgVar;
        }
        HashMap map = new HashMap();
        if (zzdzaVar.zzb.zzj()) {
            String str = this.zzb;
            if (!TextUtils.isEmpty(str)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzbd)).booleanValue()) {
                    if (TextUtils.isEmpty(str)) {
                        strConcat = "";
                    } else {
                        Matcher matcher = zza.matcher(str);
                        strConcat = "";
                        while (matcher.find()) {
                            String strGroup = matcher.group(1);
                            if (strGroup != null && (strGroup.toLowerCase(Locale.ROOT).startsWith("id=") || strGroup.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(strConcat)) {
                                    strConcat = strConcat.concat("; ");
                                }
                                strConcat = strConcat.concat(strGroup);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strConcat)) {
                        map.put(HttpHeaders.COOKIE, strConcat);
                    }
                } else {
                    map.put(HttpHeaders.COOKIE, str);
                }
            }
        }
        if (zzdzaVar.zzb.zzk() && (jSONObject = zzdzaVar.zza) != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("pii");
            if (jSONObjectOptJSONObject != null) {
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", jSONObjectOptJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", jSONObjectOptJSONObject.optString("doritos_v2", ""));
                }
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
            }
        }
        if (zzdzaVar.zzb != null && !TextUtils.isEmpty(zzdzaVar.zzb.zzf())) {
            strJoin = zzdzaVar.zzb.zzf();
        }
        zzfgn zzfgnVar2 = this.zzd;
        zzfgc zzfgcVar2 = this.zzc;
        zzfgcVar2.zzg(true);
        zzfgnVar2.zza(zzfgcVar2);
        return new zzdyw(zzdzaVar.zzb.zzg(), iOptInt, map, strJoin.getBytes(StandardCharsets.UTF_8), "", zzdzaVar.zzb.zzk());
    }
}

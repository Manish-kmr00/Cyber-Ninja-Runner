package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbcx {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbcx(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzbcu zzf() {
        return new zzbcu(com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime(), null, null);
    }

    public final zzbcw zza() {
        zzbcw zzbcwVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzcc)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.zzc) {
            List<zzbcu> list = this.zza;
            for (zzbcu zzbcuVar : list) {
                long jZza = zzbcuVar.zza();
                String strZzc = zzbcuVar.zzc();
                zzbcu zzbcuVarZzb = zzbcuVar.zzb();
                if (zzbcuVarZzb != null && jZza > 0) {
                    long jZza2 = jZza - zzbcuVarZzb.zza();
                    sb.append(strZzc);
                    sb.append('.');
                    sb.append(jZza2);
                    sb.append(AbstractJsonLexerKt.COMMA);
                    if (zBooleanValue) {
                        if (map.containsKey(Long.valueOf(zzbcuVarZzb.zza()))) {
                            StringBuilder sb2 = (StringBuilder) map.get(Long.valueOf(zzbcuVarZzb.zza()));
                            sb2.append('+');
                            sb2.append(strZzc);
                        } else {
                            map.put(Long.valueOf(zzbcuVarZzb.zza()), new StringBuilder(strZzc));
                        }
                    }
                }
            }
            list.clear();
            String string = null;
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (zBooleanValue) {
                for (Map.Entry entry : map.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() + (((Long) entry.getKey()).longValue() - com.google.android.gms.ads.internal.zzv.zzC().elapsedRealtime()));
                    sb3.append(AbstractJsonLexerKt.COMMA);
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                string = sb3.toString();
            }
            zzbcwVar = new zzbcw(sb.toString(), string);
        }
        return zzbcwVar;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            com.google.android.gms.ads.internal.zzv.zzp().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbcx zzbcxVar) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbcn zzbcnVarZzg;
        if (TextUtils.isEmpty(str2) || (zzbcnVarZzg = com.google.android.gms.ads.internal.zzv.zzp().zzg()) == null) {
            return;
        }
        synchronized (this.zzc) {
            zzbct zzbctVarZza = zzbcnVarZzg.zza(str);
            Map map = this.zzb;
            map.put(str, zzbctVarZza.zza((String) map.get(str), str2));
        }
    }

    public final boolean zze(zzbcu zzbcuVar, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbcu(j, strArr[0], zzbcuVar));
        }
        return true;
    }
}

package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import com.amazon.aps.shared.metrics.model.ApsMetricsDataMap;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.json.yk;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzfoc implements zzfmu {
    private final Object zza;
    private final zzfod zzb;
    private final zzfoo zzc;
    private final zzfmr zzd;

    zzfoc(Object obj, zzfod zzfodVar, zzfoo zzfooVar, zzfmr zzfmrVar) {
        this.zza = obj;
        this.zzb = zzfodVar;
        this.zzc = zzfooVar;
        this.zzd = zzfmrVar;
    }

    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzatk zzatkVarZza = zzatl.zza();
        zzatkVarZza.zzc(5);
        zzatkVarZza.zza(zzgwn.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzatl) zzatkVarZza.zzbr()).zzaV(), 11);
    }

    private final synchronized byte[] zzj(Map map, Map map2) {
        Object obj;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            obj = this.zza;
        } catch (Exception e) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e);
            return null;
        }
        return (byte[]) obj.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(obj, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put(InneractiveMediationDefs.GENDER_FEMALE, ApsMetricsDataMap.APSMETRICS_FIELD_CUSTOM);
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put(yk.SESSION_HISTORY_KEY_AD_ID, null);
        mapZza.put("view", view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put(InneractiveMediationDefs.GENDER_FEMALE, "v");
        mapZzc.put("ctx", context);
        mapZzc.put(yk.SESSION_HISTORY_KEY_AD_ID, null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put(InneractiveMediationDefs.GENDER_FEMALE, CampaignEx.JSON_KEY_AD_Q);
        mapZzb.put("ctx", context);
        mapZzb.put(yk.SESSION_HISTORY_KEY_AD_ID, null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfmu
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfom {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put(ApsMetricsDataMap.APSMETRICS_FIELD_TIMESTAMP, new Throwable());
            map.put(yk.SESSION_HISTORY_KEY_AD_ID, null);
            map.put("evt", motionEvent);
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("he", Map.class).invoke(obj, map);
            this.zzd.zzd(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfom(2005, e);
        }
    }

    public final synchronized int zze() throws zzfom {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfom(2006, e);
        }
        return ((Integer) obj.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(obj, new Object[0])).intValue();
    }

    final zzfod zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfom {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Object obj = this.zza;
            obj.getClass().getDeclaredMethod("close", new Class[0]).invoke(obj, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e) {
            throw new zzfom(2003, e);
        }
    }

    final synchronized boolean zzh() throws zzfom {
        Object obj;
        try {
            obj = this.zza;
        } catch (Exception e) {
            throw new zzfom(2001, e);
        }
        return ((Boolean) obj.getClass().getDeclaredMethod("init", new Class[0]).invoke(obj, new Object[0])).booleanValue();
    }
}

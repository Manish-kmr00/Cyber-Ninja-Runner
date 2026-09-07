package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzfun;
import com.json.fe;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfoParcel.afmaVersion;
    }

    public void set(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", "3");
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzv.zzq();
        map.put("device", zzs.zzs());
        map.put("app", this.zzb);
        zzv.zzq();
        Context context = this.zza;
        map.put("is_lite_sdk", true != zzs.zzF(context) ? "0" : "1");
        zzbbz zzbbzVar = zzbci.zza;
        List listZzb = zzbd.zza().zzb();
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzgP)).booleanValue()) {
            listZzb.addAll(zzv.zzp().zzi().zzg().zzd());
        }
        map.put("e", TextUtils.join(StringUtils.COMMA, listZzb));
        map.put("sdkVersion", this.zzc);
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzlu)).booleanValue()) {
            zzv.zzq();
            map.put("is_bstar", true == zzs.zzC(context) ? "1" : "0");
        }
        if (((Boolean) zzbd.zzc().zzb(zzbci.zzjy)).booleanValue()) {
            if (((Boolean) zzbd.zzc().zzb(zzbci.zzcz)).booleanValue()) {
                map.put(fe.K, zzfun.zzc(zzv.zzp().zzn()));
            }
        }
    }
}

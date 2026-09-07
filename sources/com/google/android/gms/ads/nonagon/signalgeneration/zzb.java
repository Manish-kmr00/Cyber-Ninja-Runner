package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.JsonReader;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbci;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzdqm;
import com.google.android.gms.internal.ads.zzfqj;
import com.google.android.gms.internal.ads.zzfqn;
import com.google.android.gms.internal.ads.zzfqo;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzb {
    private final Context zza;
    private final zzd zzb;
    private final long zzc;
    private final ScheduledExecutorService zzd;
    private final PackageInfo zze;

    zzb(Context context, long j, PackageInfo packageInfo, zzd zzdVar, ScheduledExecutorService scheduledExecutorService) {
        this.zza = context;
        this.zzc = j;
        this.zze = packageInfo;
        this.zzb = zzdVar;
        this.zzd = scheduledExecutorService;
    }

    public static String zzb(String str) {
        if (str == null) {
            return "";
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ "f8L7o2HxjA4p9Z1nQw3E5r6T8yU2iCv0B9kM4sD1f7G3hJ5lK2z0X9cW8vQ6b5N3m1Rg8F2o0Lp7A1e9I4u3Y2t0H8x6W5v4Z1n9Q2w7E3r5T8y6U1i0C9vB8k7M4s3D1f2G0h9J5l8K4z7X3cW2v1Q0b9N8m6A5r4F3o2Lp1E0u9I8y7Y6t5H4x3W2v1Z0n9Q8w7E6r5T4y3U2i1C0v9B8k7M6s5D4f3G2h1J0l9K8z7X6cW5v4Q3b2N1m0Rg9F8o7Lp6A5e4I3u2Y1t0H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2v1Z0n0Q9w8E7r6T5y4U3i2C1v0B9k8M7s6D5f4G3h2J1l0K9z8X7cW6v5Q4b3N2m1R0g9F8o7L6p5A4e3I2u1Y0t9H8x7W6v5Z4n3Q2w1E0r9T8y7U6i5C4v3B2k1M0s9D8f7G6h5J4l3K2z1X0cW9v8Q7b6N5m4A3r2F1o0Lp9E8u7I6y5T4h3W2".charAt(i % 555));
        }
        return new String(charArray);
    }

    public static /* synthetic */ void zzc(zzb zzbVar, String str, zzau zzauVar, zzbym zzbymVar) {
        if (zzbVar.zzb.zzj(str) || zzbVar.zze()) {
            return;
        }
        zzauVar.zzf(ObjectWrapper.wrap(zzbVar.zza), zzbymVar, null);
    }

    private final boolean zze() {
        return this.zzb.zzf().size() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhE)).intValue();
    }

    private static final void zzf(Bundle bundle, zzdqm zzdqmVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhF)).booleanValue()) {
            bundle.putLong(zzdqmVar.zza(), com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
        }
    }

    private static final void zzg(Bundle bundle, int i) {
        bundle.putBoolean("sod_h", false);
        bundle.putInt("cmr", i - 1);
    }

    public final zzbk zza(zzbym zzbymVar, final zzau zzauVar, Bundle bundle) {
        zzf(bundle, zzdqm.SIGNAL_ON_DISK_VALIDATION_START);
        if (com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN()) {
            this.zzb.zzg();
            zzg(bundle, 7);
        } else {
            PackageInfo packageInfo = this.zze;
            if (packageInfo != null) {
                zzd zzdVar = this.zzb;
                Context context = this.zza;
                String strZze = zzdVar.zze();
                int iZzb = zzdVar.zzb();
                String strZzd = zzdVar.zzd();
                int iZza = zzdVar.zza();
                if (TextUtils.equals(context.getApplicationInfo().packageName, strZze) && iZzb == packageInfo.versionCode && TextUtils.equals(Build.MODEL, strZzd) && iZza == Build.VERSION.SDK_INT) {
                    for (Map.Entry entry : zzdVar.zzf().entrySet()) {
                        try {
                            long j = new JSONObject((String) entry.getValue()).getLong("ts_ms");
                            if (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - j <= ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhD)).longValue()) {
                                zzfqj zzfqjVarZzh = zzfqn.zzj(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdw)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                                zzfqj zzfqjVarZzh2 = zzfqo.zzi(context).zzh(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzdx)).longValue(), com.google.android.gms.ads.internal.zzv.zzp().zzi().zzN());
                                if ((zzfqjVarZzh.zza() == -1 || zzfqjVarZzh.zza() <= j) && (zzfqjVarZzh2.zza() == -1 || zzfqjVarZzh2.zza() <= j)) {
                                }
                            }
                            zzdVar.zzc((String) entry.getKey());
                        } catch (IOException | JSONException unused) {
                        }
                    }
                } else {
                    zzdVar.zzg();
                    zzdVar.zzi(context.getApplicationInfo().packageName, packageInfo.versionCode, Build.MODEL, Build.VERSION.SDK_INT);
                }
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_VALIDATION_END);
                if (com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis() - this.zzc > ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhA)).longValue()) {
                    zzg(bundle, 2);
                    return null;
                }
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_CACHE_KEY_START);
                String str = zzbymVar.zza;
                String str2 = zzbymVar.zzb;
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzbymVar.zzd;
                final String strZzh = com.google.android.gms.ads.internal.util.client.zzf.zzh(str + str2 + zzmVar.zzn.toString() + zzmVar.zzc.toString() + zzmVar.zzi + zzmVar.zzp + String.valueOf(zzmVar.zzo));
                if (TextUtils.isEmpty(strZzh)) {
                    zzg(bundle, 3);
                    return null;
                }
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_CACHE_KEY_END);
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_READ_AND_REMOVE_START);
                String strZzc = this.zzb.zzc(strZzh);
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_READ_AND_REMOVE_END);
                if (!zze()) {
                    final zzbym zzbymVar2 = new zzbym(str, str2, zzbymVar.zzc, zzmVar, 2, strZzh);
                    this.zzd.schedule(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzb.zzc(this.zza, strZzh, zzauVar, zzbymVar2);
                        }
                    }, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhC)).longValue(), TimeUnit.MILLISECONDS);
                }
                if (TextUtils.isEmpty(strZzc)) {
                    zzg(bundle, 4);
                    return null;
                }
                zzf(bundle, zzdqm.SIGNAL_ON_DISK_DECODE_START);
                try {
                    JSONObject jSONObject = new JSONObject(strZzc);
                    String string = jSONObject.getString("sr");
                    if (TextUtils.isEmpty(string)) {
                        zzg(bundle, 8);
                        return null;
                    }
                    String string2 = jSONObject.getString("rs");
                    if (TextUtils.isEmpty(string2)) {
                        zzg(bundle, 9);
                        return null;
                    }
                    String strZzb = zzb(new String(Base64.decode(string2, 10), StandardCharsets.UTF_8));
                    zzf(bundle, zzdqm.SIGNAL_ON_DISK_DECODE_END);
                    try {
                        zzbk zzbkVar = new zzbk(new JsonReader(new StringReader(string)), null);
                        zzbkVar.zzc = strZzb;
                        zzbkVar.zze = bundle;
                        bundle.putBoolean("sod_h", true);
                        return zzbkVar;
                    } catch (IOException e) {
                        zzg(bundle, 6);
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DiskCachingManager.getSignalResponse");
                        return null;
                    }
                } catch (JSONException e2) {
                    zzg(bundle, 5);
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "DiskCachingManager.getSignalResponse");
                    return null;
                }
            }
            this.zzb.zzg();
            zzg(bundle, 10);
        }
        return null;
    }

    public final void zzd(String str, zzbk zzbkVar) {
        String string;
        if (TextUtils.isEmpty(str) || zze()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("params", zzbkVar.zza);
            jSONObject2.put("signal_dictionary", com.google.android.gms.ads.internal.client.zzbb.zzb().zzj(zzbkVar.zzf));
            jSONObject.put("sr", jSONObject2);
            String str2 = zzbkVar.zzc;
            if (TextUtils.isEmpty(str2)) {
                string = "";
            } else {
                jSONObject.put("rs", Base64.encodeToString(zzb(str2).getBytes(StandardCharsets.UTF_8), 10));
                jSONObject.put("ts_ms", com.google.android.gms.ads.internal.zzv.zzC().currentTimeMillis());
                string = jSONObject.toString();
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "DiskCachingManager.createStringToWrite");
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.zzb.zzh(str, string);
    }
}

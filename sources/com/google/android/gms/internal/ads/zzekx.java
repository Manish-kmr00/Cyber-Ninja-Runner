package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes7.dex */
public final class zzekx implements zzesu {
    final zzfbp zza;
    private final long zzb;

    public zzekx(zzfbp zzfbpVar, long j) {
        this.zza = zzfbpVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzcue) obj).zzb;
        zzfbp zzfbpVar = this.zza;
        bundle.putString("slotname", zzfbpVar.zzf);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfbpVar.zzd;
        if (zzmVar.zzf) {
            bundle.putBoolean("test_request", true);
        }
        int i = zzmVar.zzg;
        zzfcd.zze(bundle, "tag_for_child_directed_treatment", i, i != -1);
        if (zzmVar.zza >= 8) {
            int i2 = zzmVar.zzt;
            zzfcd.zze(bundle, "tag_for_under_age_of_consent", i2, i2 != -1);
        }
        zzfcd.zzc(bundle, "url", zzmVar.zzl);
        zzfcd.zzd(bundle, "neighboring_content_urls", zzmVar.zzv);
        Bundle bundle2 = zzmVar.zzc;
        Bundle bundle3 = (Bundle) bundle2.clone();
        HashSet hashSet = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzhB)).split(StringUtils.COMMA, -1)));
        for (String str : bundle2.keySet()) {
            if (!hashSet.contains(str)) {
                bundle3.remove(str);
            }
        }
        zzfcd.zzb(bundle, "extras", bundle3);
    }

    @Override // com.google.android.gms.internal.ads.zzesu
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcue) obj).zza;
        zzfbp zzfbpVar = this.zza;
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfbpVar.zzd;
        bundle.putInt("http_timeout_millis", zzmVar.zzw);
        bundle.putString("slotname", zzfbpVar.zzf);
        int i = zzfbpVar.zzo.zza;
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            bundle.putBoolean("is_new_rewarded", true);
        } else if (i2 == 2) {
            bundle.putBoolean("is_rewarded_interstitial", true);
        }
        bundle.putLong("start_signals_timestamp", this.zzb);
        zzfcd.zzg(bundle, "is_sdk_preload", true, zzmVar.zzb());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.US);
        long j = zzmVar.zzb;
        zzfcd.zzf(bundle, "cust_age", simpleDateFormat.format(new Date(j)), j != -1);
        zzfcd.zzb(bundle, "extras", zzmVar.zzc);
        int i3 = zzmVar.zzd;
        zzfcd.zze(bundle, "cust_gender", i3, i3 != -1);
        zzfcd.zzd(bundle, "kw", zzmVar.zze);
        int i4 = zzmVar.zzg;
        zzfcd.zze(bundle, "tag_for_child_directed_treatment", i4, i4 != -1);
        if (zzmVar.zzf) {
            bundle.putBoolean("test_request", true);
        }
        bundle.putInt("ppt_p13n", zzmVar.zzy);
        int i5 = zzmVar.zza;
        zzfcd.zze(bundle, "d_imp_hdr", 1, i5 >= 2 && zzmVar.zzh);
        String str = zzmVar.zzi;
        zzfcd.zzf(bundle, "ppid", str, i5 >= 2 && !TextUtils.isEmpty(str));
        Location location = zzmVar.zzk;
        if (location != null) {
            float accuracy = location.getAccuracy() * 1000.0f;
            long time = location.getTime() * 1000;
            double latitude = location.getLatitude() * 1.0E7d;
            double longitude = 1.0E7d * location.getLongitude();
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", accuracy);
            bundle2.putLong("lat", (long) latitude);
            bundle2.putLong(Constants.LONG, (long) longitude);
            bundle2.putLong("time", time);
            bundle.putBundle("uule", bundle2);
        }
        zzfcd.zzc(bundle, "url", zzmVar.zzl);
        zzfcd.zzd(bundle, "neighboring_content_urls", zzmVar.zzv);
        zzfcd.zzb(bundle, "custom_targeting", zzmVar.zzn);
        zzfcd.zzd(bundle, "category_exclusions", zzmVar.zzo);
        zzfcd.zzc(bundle, "request_agent", zzmVar.zzp);
        zzfcd.zzc(bundle, "request_pkg", zzmVar.zzq);
        zzfcd.zzg(bundle, "is_designed_for_families", zzmVar.zzr, i5 >= 7);
        if (i5 >= 8) {
            int i6 = zzmVar.zzt;
            zzfcd.zze(bundle, "tag_for_under_age_of_consent", i6, i6 != -1);
            zzfcd.zzc(bundle, "max_ad_content_rating", zzmVar.zzu);
        }
    }
}

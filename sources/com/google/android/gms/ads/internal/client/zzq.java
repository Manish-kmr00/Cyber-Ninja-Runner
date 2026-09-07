package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzq {
    public static final zzq zza = new zzq();

    protected zzq() {
    }

    public final zzm zza(Context context, zzeh zzehVar) {
        String strZzr;
        String strZzi = zzehVar.zzi();
        Set setZzn = zzehVar.zzn();
        List listUnmodifiableList = !setZzn.isEmpty() ? Collections.unmodifiableList(new ArrayList(setZzn)) : null;
        boolean zZzq = zzehVar.zzq(context);
        Bundle bundleZzf = zzehVar.zzf(AdMobAdapter.class);
        String strZzj = zzehVar.zzj();
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzbb.zzb();
            strZzr = com.google.android.gms.ads.internal.util.client.zzf.zzr(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZzr = null;
        }
        boolean zZzp = zzehVar.zzp();
        RequestConfiguration requestConfigurationZzc = zzet.zzf().zzc();
        return new zzm(8, -1L, bundleZzf, -1, listUnmodifiableList, zZzq, Math.max(zzehVar.zzb(), requestConfigurationZzc.getTagForChildDirectedTreatment()), false, strZzj, null, null, strZzi, zzehVar.zzg(), zzehVar.zze(), Collections.unmodifiableList(new ArrayList(zzehVar.zzm())), zzehVar.zzk(), strZzr, zZzp, null, requestConfigurationZzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, requestConfigurationZzc.getMaxAdContentRating()), new Comparator() { // from class: com.google.android.gms.ads.internal.client.zzp
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RequestConfiguration.zza.indexOf((String) obj) - RequestConfiguration.zza.indexOf((String) obj2);
            }
        }), zzehVar.zzl(), zzehVar.zza(), zzehVar.zzh(), requestConfigurationZzc.getPublisherPrivacyPersonalizationState().getValue(), zzehVar.zzc());
    }
}

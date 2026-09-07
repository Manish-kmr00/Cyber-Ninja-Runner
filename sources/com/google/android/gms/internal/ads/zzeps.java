package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.common.util.concurrent.ListenableFuture;
import io.bidmachine.IABSharedPreference;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeps implements zzesv {
    private final Context zza;
    private final zzgcd zzb;

    zzeps(Context context, zzgcd zzgcdVar) {
        this.zza = context;
        this.zzb = zzgcdVar;
    }

    public static /* synthetic */ zzepq zzc(zzeps zzepsVar) {
        Bundle bundle;
        com.google.android.gms.ads.internal.zzv.zzq();
        String string = !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgb)).booleanValue() ? "" : zzepsVar.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", "");
        String string2 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgd)).booleanValue() ? zzepsVar.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", "") : "";
        com.google.android.gms.ads.internal.zzv.zzq();
        Context context = zzepsVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzgc)).booleanValue()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {IABSharedPreference.IAB_SUBJECT_TO_GDPR, IABSharedPreference.IAB_CONSENT_STRING, "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str = strArr[i];
                if (defaultSharedPreferences.contains(str)) {
                    bundle.putString(str, defaultSharedPreferences.getString(str, null));
                }
            }
        } else {
            bundle = null;
        }
        return new zzepq(string, string2, bundle, null);
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final int zza() {
        return 18;
    }

    @Override // com.google.android.gms.internal.ads.zzesv
    public final ListenableFuture zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzepp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeps.zzc(this.zza);
            }
        });
    }
}

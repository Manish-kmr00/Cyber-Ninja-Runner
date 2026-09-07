package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.internal.measurement.zzoj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
/* JADX INFO: loaded from: classes14.dex */
final class zzki implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zziv zza;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    static /* synthetic */ void zza(zzki zzkiVar, boolean z, Uri uri, String str, String str2) {
        Bundle bundleZza;
        zzkiVar.zza.zzt();
        try {
            zznp zznpVarZzq = zzkiVar.zza.zzq();
            boolean z2 = zzoj.zza() && zzkiVar.zza.zze().zza(zzbf.zzcl);
            if (TextUtils.isEmpty(str2)) {
                bundleZza = null;
            } else if (str2.contains("gclid") || ((z2 && str2.contains("gbraid")) || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id"))) {
                bundleZza = zznpVarZzq.zza(Uri.parse("https://google.com/search?" + str2), z2);
                if (bundleZza != null) {
                    bundleZza.putString("_cis", Constants.REFERRER);
                }
            } else {
                zznpVarZzq.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                bundleZza = null;
            }
            if (z) {
                Bundle bundleZza2 = zzkiVar.zza.zzq().zza(uri, zzoj.zza() && zzkiVar.zza.zze().zza(zzbf.zzcl));
                if (bundleZza2 != null) {
                    bundleZza2.putString("_cis", SDKConstants.PARAM_INTENT);
                    if (!bundleZza2.containsKey("gclid") && bundleZza != null && bundleZza.containsKey("gclid")) {
                        bundleZza2.putString("_cer", String.format("gclid=%s", bundleZza.getString("gclid")));
                    }
                    zzkiVar.zza.zzc(str, "_cmp", bundleZza2);
                    zzkiVar.zza.zza.zza(str, bundleZza2);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            zzkiVar.zza.zzj().zzc().zza("Activity created with referrer", str2);
            if (zzkiVar.zza.zze().zza(zzbf.zzbl)) {
                if (bundleZza != null) {
                    zzkiVar.zza.zzc(str, "_cmp", bundleZza);
                    zzkiVar.zza.zza.zza(str, bundleZza);
                } else {
                    zzkiVar.zza.zzj().zzc().zza("Referrer does not contain valid parameters", str2);
                }
                zzkiVar.zza.zza("auto", "_ldl", (Object) null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                zzkiVar.zza.zzj().zzc().zza("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                zzkiVar.zza.zza("auto", "_ldl", (Object) str2, true);
            }
        } catch (RuntimeException e) {
            zzkiVar.zza.zzj().zzg().zza("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    zzki(zziv zzivVar) {
        this.zza = zzivVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0043  */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        String str;
        try {
            try {
                this.zza.zzj().zzp().zza("onActivityCreated");
                Intent intent = activity.getIntent();
                if (intent == null) {
                    return;
                }
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (TextUtils.isEmpty(string)) {
                            data = null;
                        } else {
                            data = Uri.parse(string);
                        }
                    } else {
                        data = null;
                    }
                }
                Uri uri = data;
                if (uri != null && uri.isHierarchical()) {
                    this.zza.zzq();
                    if (zznp.zza(intent)) {
                        str = "gs";
                    } else {
                        str = "auto";
                    }
                    this.zza.zzl().zzb(new zzkh(this, bundle == null, uri, str, uri.getQueryParameter(Constants.REFERRER)));
                    return;
                }
                return;
            } catch (RuntimeException e) {
                this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e);
                return;
            }
        } finally {
            this.zza.zzn().zza(activity, bundle);
        }
        this.zza.zzn().zza(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzn().zza(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.zza.zzn().zzb(activity);
        zzmh zzmhVarZzp = this.zza.zzp();
        zzmhVarZzp.zzl().zzb(new zzmj(zzmhVarZzp, zzmhVarZzp.zzb().elapsedRealtime()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzmh zzmhVarZzp = this.zza.zzp();
        zzmhVarZzp.zzl().zzb(new zzmk(zzmhVarZzp, zzmhVarZzp.zzb().elapsedRealtime()));
        this.zza.zzn().zzc(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzn().zzb(activity, bundle);
    }
}

package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzbdh extends CustomTabsServiceConnection {
    public static final /* synthetic */ int zza = 0;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private Context zzc;
    private zzdre zzd;
    private CustomTabsSession zze;
    private CustomTabsClient zzf;

    public static /* synthetic */ void zzb(zzbdh zzbdhVar, int i) {
        zzdre zzdreVar = zzbdhVar.zzd;
        if (zzdreVar != null) {
            zzdrd zzdrdVarZza = zzdreVar.zza();
            zzdrdVarZza.zzb("action", "cct_nav");
            zzdrdVarZza.zzb("cct_navs", String.valueOf(i));
            zzdrdVarZza.zzj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(Context context) {
        String packageName;
        if (this.zzf != null || context == null || (packageName = CustomTabsClient.getPackageName(context, null)) == null) {
            return;
        }
        CustomTabsClient.bindCustomTabsService(context, packageName, this);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        this.zzf = customTabsClient;
        customTabsClient.warmup(0L);
        this.zze = customTabsClient.newSession(new zzbdg(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf = null;
        this.zze = null;
    }

    public final CustomTabsSession zza() {
        if (this.zze == null) {
            zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdf
                @Override // java.lang.Runnable
                public final void run() {
                    zzbdh zzbdhVar = this.zza;
                    zzbdhVar.zzf(zzbdhVar.zzc);
                }
            });
        }
        return this.zze;
    }

    public final void zzd(Context context, zzdre zzdreVar) {
        if (this.zzb.getAndSet(true)) {
            return;
        }
        this.zzc = context;
        this.zzd = zzdreVar;
        zzf(context);
    }

    public final void zze(final int i) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbci.zzeM)).booleanValue() || this.zzd == null) {
            return;
        }
        zzbzk.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbde
            @Override // java.lang.Runnable
            public final void run() {
                zzbdh.zzb(this.zza, i);
            }
        });
    }
}

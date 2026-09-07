package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
public final class zzhfp extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhfp(zzbdj zzbdjVar) {
        this.zza = new WeakReference(zzbdjVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbdj zzbdjVar = (zzbdj) this.zza.get();
        if (zzbdjVar != null) {
            zzbdjVar.zzc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbdj zzbdjVar = (zzbdj) this.zza.get();
        if (zzbdjVar != null) {
            zzbdjVar.zzd();
        }
    }
}

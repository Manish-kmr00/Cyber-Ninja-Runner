package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzbdg extends CustomTabsCallback {
    final /* synthetic */ zzbdh zza;

    zzbdg(zzbdh zzbdhVar) {
        this.zza = zzbdhVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        this.zza.zze(i);
    }
}

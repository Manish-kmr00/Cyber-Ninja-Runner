package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzayv extends com.google.android.gms.ads.internal.client.zzck {
    private final AppEventListener zza;

    public zzayv(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final AppEventListener zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final void zzc(String str, String str2) {
        this.zza.onAppEvent(str, str2);
    }
}

package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzflk implements Runnable {
    final /* synthetic */ zzfll zza;
    private final WebView zzb;

    zzflk(zzfll zzfllVar) {
        this.zza = zzfllVar;
        this.zzb = zzfllVar.zza;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.destroy();
    }
}

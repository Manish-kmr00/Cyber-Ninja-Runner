package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzazc implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzazg zzb;

    zzazc(zzazg zzazgVar, View view) {
        this.zza = view;
        this.zzb = zzazgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb(this.zza);
    }
}

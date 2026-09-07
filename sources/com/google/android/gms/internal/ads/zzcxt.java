package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzcxt implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzcxv zzcxvVar = (zzcxv) this.zza.get();
        if (zzcxvVar != null) {
            zzcxvVar.zzq(new zzdas() { // from class: com.google.android.gms.internal.ads.zzcxr
                @Override // com.google.android.gms.internal.ads.zzdas
                public final void zza(Object obj) throws ExecutionException, InterruptedException {
                    ((zzcxp) obj).zzb();
                }
            });
        }
    }
}

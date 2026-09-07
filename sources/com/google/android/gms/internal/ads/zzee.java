package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzee {
    final /* synthetic */ zzei zza;
    private final WeakReference zzb;
    private final Executor zzc;

    public zzee(zzei zzeiVar, zzzf zzzfVar, Executor executor) {
        this.zza = zzeiVar;
        this.zzb = new WeakReference(zzzfVar);
        this.zzc = executor;
    }

    public static /* synthetic */ void zza(zzee zzeeVar) {
        zzzf zzzfVar = (zzzf) zzeeVar.zzb.get();
        if (zzzfVar != null) {
            zzzfVar.zza.zzl(zzeeVar.zza.zza());
        }
    }

    public final void zzb() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzed
            @Override // java.lang.Runnable
            public final void run() {
                zzee.zza(this.zza);
            }
        });
    }

    public final boolean zzc() {
        return this.zzb.get() == null;
    }
}

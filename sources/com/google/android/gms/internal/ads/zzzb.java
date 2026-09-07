package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzzb {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzzc zzzcVar) {
        zzc(zzzcVar);
        this.zza.add(new zzza(handler, zzzcVar));
    }

    public final void zzb(final int i, final long j, final long j2) {
        for (final zzza zzzaVar : this.zza) {
            if (!zzzaVar.zzc) {
                zzzaVar.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzyz
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzzaVar.zzb.zzZ(i, j, j2);
                    }
                });
            }
        }
    }

    public final void zzc(zzzc zzzcVar) {
        CopyOnWriteArrayList<zzza> copyOnWriteArrayList = this.zza;
        for (zzza zzzaVar : copyOnWriteArrayList) {
            if (zzzaVar.zzb == zzzcVar) {
                zzzaVar.zzc();
                copyOnWriteArrayList.remove(zzzaVar);
            }
        }
    }
}

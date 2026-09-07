package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
final class zzayy implements Runnable {
    final /* synthetic */ zzayz zza;

    zzayy(zzayz zzayzVar) {
        this.zza = zzayzVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzayz zzayzVar = this.zza;
        synchronized (zzayzVar.zzc) {
            if (zzayzVar.zzd && zzayzVar.zze) {
                zzayzVar.zzd = false;
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("App went background");
                Iterator it = zzayzVar.zzf.iterator();
                while (it.hasNext()) {
                    try {
                        ((zzaza) it.next()).zza(false);
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                    }
                }
            } else {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("App is still foreground");
            }
        }
    }
}

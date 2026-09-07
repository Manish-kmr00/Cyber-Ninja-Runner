package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes11.dex */
final class zzcmo implements zzbjj {
    final /* synthetic */ zzcmp zza;

    zzcmo(zzcmp zzcmpVar) {
        this.zza = zzcmpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zza(Object obj, Map map) {
        zzcmp zzcmpVar = this.zza;
        if (zzcmp.zzg(zzcmpVar, map)) {
            zzcmpVar.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmn
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zza.zzd.zzj();
                }
            });
        }
    }
}

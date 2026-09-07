package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfxd extends zzfux {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzftx zzb;

    zzfxd(Iterator it, zzftx zzftxVar) {
        this.zza = it;
        this.zzb = zzftxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfux
    protected final Object zza() {
        zzftx zzftxVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzftxVar = this.zzb;
            next = it.next();
        } while (!zzftxVar.zza(next));
        return next;
    }
}

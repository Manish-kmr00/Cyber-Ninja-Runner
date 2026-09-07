package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
@ParametersAreNonnullByDefault
public final class zzayx {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final void zza(zzayw zzaywVar) {
        synchronized (this.zzb) {
            List list = this.zzc;
            if (list.size() >= 10) {
                String str = "Queue is full, current size = " + list.size();
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze(str);
                list.remove(0);
            }
            int i2 = this.zza;
            this.zza = i2 + 1;
            zzaywVar.zzg(i2);
            zzaywVar.zzk();
            list.add(zzaywVar);
        }
    }

    public final boolean zzb(zzayw zzaywVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzayw zzaywVar2 = (zzayw) it.next();
                if (com.google.android.gms.ads.internal.zzv.zzp().zzi().zzK()) {
                    if (!com.google.android.gms.ads.internal.zzv.zzp().zzi().zzL() && !zzaywVar.equals(zzaywVar2) && zzaywVar2.zzd().equals(zzaywVar.zzd())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzaywVar.equals(zzaywVar2) && zzaywVar2.zzc().equals(zzaywVar.zzc())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzc(zzayw zzaywVar) {
        synchronized (this.zzb) {
            return this.zzc.contains(zzaywVar);
        }
    }
}

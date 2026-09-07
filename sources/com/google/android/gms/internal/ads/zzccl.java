package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzccl implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    final zzcck zza(zzcbg zzcbgVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcck zzcckVar = (zzcck) it.next();
            if (zzcckVar.zza == zzcbgVar) {
                return zzcckVar;
            }
        }
        return null;
    }

    public final void zzb(zzcck zzcckVar) {
        this.zza.add(zzcckVar);
    }

    public final void zzc(zzcck zzcckVar) {
        this.zza.remove(zzcckVar);
    }

    public final boolean zzd(zzcbg zzcbgVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcck zzcckVar = (zzcck) it.next();
            if (zzcckVar.zza == zzcbgVar) {
                arrayList.add(zzcckVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzcck) it2.next()).zzb.zzf();
        }
        return true;
    }
}

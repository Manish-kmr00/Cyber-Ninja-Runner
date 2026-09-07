package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes10.dex */
public final class zzfkr {
    private static final zzfkr zza = new zzfkr();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfkr() {
    }

    public static zzfkr zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfjz zzfjzVar) {
        this.zzb.add(zzfjzVar);
    }

    public final void zze(zzfjz zzfjzVar) {
        ArrayList arrayList = this.zzb;
        boolean zZzg = zzg();
        arrayList.remove(zzfjzVar);
        this.zzc.remove(zzfjzVar);
        if (!zZzg || zzg()) {
            return;
        }
        zzfkz.zzb().zzg();
    }

    public final void zzf(zzfjz zzfjzVar) {
        ArrayList arrayList = this.zzc;
        boolean zZzg = zzg();
        arrayList.add(zzfjzVar);
        if (zZzg) {
            return;
        }
        zzfkz.zzb().zzf();
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}

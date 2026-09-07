package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfva extends zzfxp {
    final /* synthetic */ zzfvc zza;

    zzfva(zzfvc zzfvcVar) {
        this.zza = zzfvcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return zzfvv.zza(this.zza.zza.entrySet(), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzfvb(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfxp, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        if (!contains(obj)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) Objects.requireNonNull((Map.Entry) obj);
        zzfvc zzfvcVar = this.zza;
        zzfvp.zzo(zzfvcVar.zzb, entry.getKey());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzfxp
    final Map zza() {
        return this.zza;
    }
}

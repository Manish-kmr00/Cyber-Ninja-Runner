package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfwd extends AbstractCollection {
    final /* synthetic */ zzfwf zza;

    zzfwd(zzfwf zzfwfVar) {
        this.zza = zzfwfVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        return mapZzl != null ? mapZzl.values().iterator() : new zzfvy(zzfwfVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size();
    }
}

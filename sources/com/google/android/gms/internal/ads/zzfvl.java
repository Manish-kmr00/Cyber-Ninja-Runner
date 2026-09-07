package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
class zzfvl implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfvm zzc;

    zzfvl(zzfvm zzfvmVar) {
        this.zzc = zzfvmVar;
        this.zzb = zzfvmVar.zzb;
        Collection collection = zzfvmVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    zzfvl(zzfvm zzfvmVar, Iterator it) {
        this.zzc = zzfvmVar;
        this.zzb = zzfvmVar.zzb;
        this.zza = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzfvm zzfvmVar = this.zzc;
        zzfvmVar.zze.zzb--;
        zzfvmVar.zzc();
    }

    final void zza() {
        zzfvm zzfvmVar = this.zzc;
        zzfvmVar.zzb();
        if (zzfvmVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}

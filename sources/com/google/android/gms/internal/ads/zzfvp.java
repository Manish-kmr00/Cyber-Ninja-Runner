package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
abstract class zzfvp extends zzfvs implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    protected zzfvp(Map map) {
        zzftw.zze(map.isEmpty());
        this.zza = map;
    }

    static /* bridge */ /* synthetic */ void zzo(zzfvp zzfvpVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzfvpVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfvpVar.zzb -= size;
        }
    }

    abstract Collection zza();

    Collection zzb(Collection collection) {
        throw null;
    }

    Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfvs
    final Collection zzf() {
        return new zzfvr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfvs
    final Iterator zzg() {
        return new zzfuz(this);
    }

    final List zzh(Object obj, List list, zzfvm zzfvmVar) {
        return list instanceof RandomAccess ? new zzfvi(this, obj, list, zzfvmVar) : new zzfvo(this, obj, list, zzfvmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfvs
    Map zzj() {
        throw null;
    }

    final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfvg(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfvj(this, (SortedMap) map) : new zzfvc(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfvs
    Set zzl() {
        throw null;
    }

    final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfvh(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfvk(this, (SortedMap) map) : new zzfvf(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfxu
    public final void zzp() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfvs, com.google.android.gms.internal.ads.zzfxu
    public final boolean zzq(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        map.put(obj, collectionZza);
        return true;
    }
}

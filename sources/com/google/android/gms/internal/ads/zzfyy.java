package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
public final class zzfyy {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static zzfyw zzb(Set set, Set set2) {
        zzftw.zzc(set, "set1");
        zzftw.zzc(set2, "set2");
        return new zzfys(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set zzc(Set set, zzftx zzftxVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzfyt)) {
                set.getClass();
                return new zzfyt(set, zzftxVar);
            }
            zzfyt zzfytVar = (zzfyt) set;
            return new zzfyt((Set) zzfytVar.zza, zzfua.zza(zzfytVar.zzb, zzftxVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzfyt)) {
            sortedSet.getClass();
            return new zzfyu(sortedSet, zzftxVar);
        }
        zzfyt zzfytVar2 = (zzfyt) sortedSet;
        return new zzfyu((SortedSet) zzfytVar2.zza, zzfua.zza(zzfytVar2.zzb, zzftxVar));
    }

    static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean zzf(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzfye) {
            collection = ((zzfye) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}

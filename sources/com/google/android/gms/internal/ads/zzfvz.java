package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfvz extends AbstractSet {
    final /* synthetic */ zzfwf zza;

    zzfvz(zzfwf zzfwfVar) {
        this.zza = zzfwfVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzw = zzfwfVar.zzw(entry.getKey());
            if (iZzw != -1 && zzftt.zza(zzfwf.zzj(zzfwfVar, iZzw), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        return mapZzl != null ? mapZzl.entrySet().iterator() : new zzfvx(zzfwfVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzfwf zzfwfVar = this.zza;
        Map mapZzl = zzfwfVar.zzl();
        if (mapZzl != null) {
            return mapZzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (zzfwfVar.zzr()) {
            return false;
        }
        int iZzv = zzfwfVar.zzv();
        int iZzb = zzfwg.zzb(entry.getKey(), entry.getValue(), iZzv, Objects.requireNonNull(zzfwfVar.zze), zzfwfVar.zzA(), zzfwfVar.zzB(), zzfwfVar.zzC());
        if (iZzb == -1) {
            return false;
        }
        zzfwfVar.zzq(iZzb, iZzv);
        zzfwfVar.zzg--;
        zzfwfVar.zzo();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}

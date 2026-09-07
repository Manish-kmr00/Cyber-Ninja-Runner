package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes8.dex */
final class zzfvn extends zzfvl implements ListIterator {
    final /* synthetic */ zzfvo zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfvn(zzfvo zzfvoVar) {
        super(zzfvoVar);
        this.zzd = zzfvoVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        zzfvo zzfvoVar = this.zzd;
        boolean zIsEmpty = zzfvoVar.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzfvoVar.zzf.zzb++;
        if (zIsEmpty) {
            zzfvoVar.zza();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfvn(zzfvo zzfvoVar, int i) {
        super(zzfvoVar, ((List) zzfvoVar.zzb).listIterator(i));
        this.zzd = zzfvoVar;
    }
}

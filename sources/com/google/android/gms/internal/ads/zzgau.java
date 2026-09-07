package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgau extends zzgat {
    private static final AtomicReferenceFieldUpdater zza;
    private static final AtomicIntegerFieldUpdater zzb;

    static {
        int i = zzgax.zza;
        zza = AtomicReferenceFieldUpdater.newUpdater(zzgax.class, Set.class, "seenExceptions");
        zzb = AtomicIntegerFieldUpdater.newUpdater(zzgax.class, "remaining");
    }

    private zzgau() {
        throw null;
    }

    /* synthetic */ zzgau(zzgaw zzgawVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgat
    final int zza(zzgax zzgaxVar) {
        return zzb.decrementAndGet(zzgaxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgat
    final void zzb(zzgax zzgaxVar, Set set, Set set2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = zza;
        while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, zzgaxVar, null, set2) && atomicReferenceFieldUpdater.get(zzgaxVar) == null) {
        }
    }
}

package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgax extends zzgag.zzf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgat zzbe;
    private static final zzgcb zzbf = new zzgcb(zzgax.class);
    private volatile int remaining;
    private volatile Set<Throwable> seenExceptions = null;

    static {
        Throwable th;
        zzgat zzgavVar;
        zzgaw zzgawVar = null;
        try {
            zzgavVar = new zzgau(zzgawVar);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzgavVar = new zzgav(zzgawVar);
        }
        zzbe = zzgavVar;
        if (th != null) {
            zzbf.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzgax(int i) {
        this.remaining = i;
    }

    abstract void zzE(Set set);

    final int zzK() {
        return zzbe.zza(this);
    }

    final Set zzM() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzE(setNewSetFromMap);
        zzbe.zzb(this, null, setNewSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    }

    final void zzP() {
        this.seenExceptions = null;
    }
}

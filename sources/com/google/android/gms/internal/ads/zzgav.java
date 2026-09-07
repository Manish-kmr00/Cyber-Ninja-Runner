package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgav extends zzgat {
    private zzgav() {
        throw null;
    }

    /* synthetic */ zzgav(zzgaw zzgawVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgat
    final int zza(zzgax zzgaxVar) {
        int i;
        synchronized (zzgaxVar) {
            i = zzgaxVar.remaining - 1;
            zzgaxVar.remaining = i;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzgat
    final void zzb(zzgax zzgaxVar, Set set, Set set2) {
        synchronized (zzgaxVar) {
            if (zzgaxVar.seenExceptions == null) {
                zzgaxVar.seenExceptions = set2;
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzmi {
    private final zzv zza;
    private final SparseArray zzb;

    public zzmi(zzv zzvVar, SparseArray sparseArray) {
        this.zza = zzvVar;
        SparseArray sparseArray2 = new SparseArray(zzvVar.zzb());
        for (int i = 0; i < zzvVar.zzb(); i++) {
            int iZza = zzvVar.zza(i);
            zzmh zzmhVar = (zzmh) sparseArray.get(iZza);
            zzmhVar.getClass();
            sparseArray2.append(iZza, zzmhVar);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzmh zzc(int i) {
        zzmh zzmhVar = (zzmh) this.zzb.get(i);
        zzmhVar.getClass();
        return zzmhVar;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}

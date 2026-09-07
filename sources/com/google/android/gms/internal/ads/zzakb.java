package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakb implements zzadf {
    private final zzadf zzb;
    private final zzajy zzc;
    private final SparseArray zzd = new SparseArray();
    private boolean zze;

    public zzakb(zzadf zzadfVar, zzajy zzajyVar) {
        this.zzb = zzadfVar;
        this.zzc = zzajyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzG() {
        this.zzb.zzG();
        if (!this.zze) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzd;
            if (i >= sparseArray.size()) {
                return;
            }
            ((zzakd) sparseArray.valueAt(i)).zzb(true);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzP(zzaeb zzaebVar) {
        this.zzb.zzP(zzaebVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzaei zzw(int i, int i2) {
        if (i2 != 3) {
            this.zze = true;
            return this.zzb.zzw(i, i2);
        }
        SparseArray sparseArray = this.zzd;
        zzakd zzakdVar = (zzakd) sparseArray.get(i);
        if (zzakdVar != null) {
            return zzakdVar;
        }
        zzakd zzakdVar2 = new zzakd(this.zzb.zzw(i, 3), this.zzc);
        sparseArray.put(i, zzakdVar2);
        return zzakdVar2;
    }
}

package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzya extends zzbq {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    public zzya() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    protected final zzya zzw(zzbr zzbrVar) {
        super.zzj(zzbrVar);
        return this;
    }

    public final zzya zzx(int i, boolean z) {
        SparseBooleanArray sparseBooleanArray = this.zzi;
        if (sparseBooleanArray.get(i) != z) {
            if (z) {
                sparseBooleanArray.put(i, true);
            } else {
                sparseBooleanArray.delete(i);
            }
        }
        return this;
    }

    /* synthetic */ zzya(zzyb zzybVar, zzym zzymVar) {
        super(zzybVar);
        this.zza = zzybVar.zzG;
        this.zzb = zzybVar.zzI;
        this.zzc = zzybVar.zzK;
        this.zzd = zzybVar.zzP;
        this.zze = zzybVar.zzQ;
        this.zzf = zzybVar.zzR;
        this.zzg = zzybVar.zzT;
        SparseArray sparseArray = zzybVar.zzV;
        SparseArray sparseArray2 = new SparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            sparseArray2.put(sparseArray.keyAt(i), new HashMap((Map) sparseArray.valueAt(i)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzybVar.zzW.clone();
    }
}

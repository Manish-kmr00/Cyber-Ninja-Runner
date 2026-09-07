package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzyw {
    public final int zza;
    public final zzly[] zzb;
    public final zzyp[] zzc;
    public final zzbt zzd;
    public final Object zze;

    public zzyw(zzly[] zzlyVarArr, zzyp[] zzypVarArr, zzbt zzbtVar, Object obj) {
        int length = zzlyVarArr.length;
        zzdc.zzd(length == zzypVarArr.length);
        this.zzb = zzlyVarArr;
        this.zzc = (zzyp[]) zzypVarArr.clone();
        this.zzd = zzbtVar;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(zzyw zzywVar, int i) {
        return zzywVar != null && Objects.equals(this.zzb[i], zzywVar.zzb[i]) && Objects.equals(this.zzc[i], zzywVar.zzc[i]);
    }

    public final boolean zzb(int i) {
        return this.zzb[i] != null;
    }
}

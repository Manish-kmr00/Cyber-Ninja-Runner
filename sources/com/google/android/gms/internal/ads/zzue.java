package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzue implements zzvj, zzru {
    final /* synthetic */ zzug zza;
    private final Object zzb;
    private zzvi zzc;
    private zzrt zzd;

    public zzue(zzug zzugVar, Object obj) {
        this.zza = zzugVar;
        this.zzc = zzugVar.zze(null);
        this.zzd = zzugVar.zzc(null);
        this.zzb = obj;
    }

    private final zzuu zzf(zzuu zzuuVar, zzuy zzuyVar) {
        zzug zzugVar = this.zza;
        Object obj = this.zzb;
        zzugVar.zzx(obj, zzuuVar.zzc, zzuyVar);
        zzugVar.zzx(obj, zzuuVar.zzd, zzuyVar);
        return zzuuVar;
    }

    private final boolean zzg(int i, zzuy zzuyVar) {
        zzuy zzuyVarZzy;
        if (zzuyVar != null) {
            zzuyVarZzy = this.zza.zzy(this.zzb, zzuyVar);
            if (zzuyVarZzy == null) {
                return false;
            }
        } else {
            zzuyVarZzy = null;
        }
        zzug zzugVar = this.zza;
        zzugVar.zzw(this.zzb, 0);
        zzvi zzviVar = this.zzc;
        int i2 = zzviVar.zza;
        if (!Objects.equals(zzviVar.zzb, zzuyVarZzy)) {
            this.zzc = zzugVar.zzf(0, zzuyVarZzy);
        }
        zzrt zzrtVar = this.zzd;
        int i3 = zzrtVar.zza;
        if (Objects.equals(zzrtVar.zzb, zzuyVarZzy)) {
            return true;
        }
        this.zzd = zzugVar.zzd(0, zzuyVarZzy);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzag(int i, zzuy zzuyVar, zzuu zzuuVar) {
        if (zzg(0, zzuyVar)) {
            zzvi zzviVar = this.zzc;
            zzf(zzuuVar, zzuyVar);
            zzviVar.zzd(zzuuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzah(int i, zzuy zzuyVar, zzup zzupVar, zzuu zzuuVar) {
        if (zzg(0, zzuyVar)) {
            zzvi zzviVar = this.zzc;
            zzf(zzuuVar, zzuyVar);
            zzviVar.zze(zzupVar, zzuuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzai(int i, zzuy zzuyVar, zzup zzupVar, zzuu zzuuVar) {
        if (zzg(0, zzuyVar)) {
            zzvi zzviVar = this.zzc;
            zzf(zzuuVar, zzuyVar);
            zzviVar.zzf(zzupVar, zzuuVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzaj(int i, zzuy zzuyVar, zzup zzupVar, zzuu zzuuVar, IOException iOException, boolean z) {
        if (zzg(0, zzuyVar)) {
            zzvi zzviVar = this.zzc;
            zzf(zzuuVar, zzuyVar);
            zzviVar.zzg(zzupVar, zzuuVar, iOException, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzak(int i, zzuy zzuyVar, zzup zzupVar, zzuu zzuuVar, int i2) {
        if (zzg(0, zzuyVar)) {
            zzvi zzviVar = this.zzc;
            zzf(zzuuVar, zzuyVar);
            zzviVar.zzh(zzupVar, zzuuVar, i2);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.util.Pair;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
public final class zzut extends zzxf {
    private final boolean zzb;
    private final zzbk zzc;
    private final zzbj zzd;
    private zzur zze;
    private zzuq zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzut(zzva zzvaVar, boolean z) {
        boolean z2;
        super(zzvaVar);
        if (z) {
            zzvaVar.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        zzvaVar.zzM();
        this.zze = zzur.zzq(zzvaVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zze == null || !obj.equals(zzur.zzc)) ? obj : this.zze.zze;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final boolean zzL(long j) {
        zzuq zzuqVar = this.zzf;
        int iZza = this.zze.zza(zzuqVar.zza.zza);
        if (iZza == -1) {
            return false;
        }
        zzur zzurVar = this.zze;
        zzbj zzbjVar = this.zzd;
        zzurVar.zzd(iZza, zzbjVar, false);
        long j2 = zzbjVar.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzuqVar.zzs(j);
        return true;
    }

    public final zzbl zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    protected final zzuy zzD(zzuy zzuyVar) {
        Object obj = this.zze.zze;
        Object obj2 = zzuyVar.zza;
        if (obj != null && this.zze.zze.equals(obj2)) {
            obj2 = zzur.zzc;
        }
        return zzuyVar.zza(obj2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzxf
    protected final void zzE(zzbl zzblVar) {
        long jZzq;
        zzuy zzuyVarZza = null;
        if (this.zzh) {
            this.zze = this.zze.zzp(zzblVar);
            zzuq zzuqVar = this.zzf;
            if (zzuqVar != null) {
                zzL(zzuqVar.zzn());
            }
        } else if (zzblVar.zzo()) {
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzur.zzr(zzblVar, zzbk.zza, zzur.zzc);
        } else {
            zzbk zzbkVar = this.zzc;
            zzblVar.zze(0, zzbkVar, 0L);
            Object obj = zzbkVar.zzb;
            zzuq zzuqVar2 = this.zzf;
            if (zzuqVar2 != null) {
                jZzq = zzuqVar2.zzq();
                this.zze.zzn(zzuqVar2.zza.zza, this.zzd);
                this.zze.zze(0, zzbkVar, 0L);
                if (jZzq == 0) {
                    jZzq = 0;
                }
            } else {
                jZzq = 0;
            }
            Pair pairZzl = zzblVar.zzl(zzbkVar, this.zzd, 0, jZzq);
            Object obj2 = pairZzl.first;
            long jLongValue = ((Long) pairZzl.second).longValue();
            this.zze = this.zzi ? this.zze.zzp(zzblVar) : zzur.zzr(zzblVar, obj, obj2);
            zzuq zzuqVar3 = this.zzf;
            if (zzuqVar3 != null && zzL(jLongValue)) {
                zzuy zzuyVar = zzuqVar3.zza;
                zzuyVarZza = zzuyVar.zza(zzK(zzuyVar.zza));
            }
        }
        this.zzi = true;
        this.zzh = true;
        zzo(this.zze);
        if (zzuyVarZza != null) {
            zzuq zzuqVar4 = this.zzf;
            zzuqVar4.getClass();
            zzuqVar4.zzr(zzuyVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxf
    public final void zzF() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzB(null, ((zzxf) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzxf, com.google.android.gms.internal.ads.zzva
    public final void zzG(zzuw zzuwVar) {
        ((zzuq) zzuwVar).zzt();
        if (zzuwVar == this.zzf) {
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxf, com.google.android.gms.internal.ads.zzva
    /* JADX INFO: renamed from: zzH, reason: merged with bridge method [inline-methods] */
    public final zzuq zzI(zzuy zzuyVar, zzze zzzeVar, long j) {
        zzuq zzuqVar = new zzuq(zzuyVar, zzzeVar, j);
        zzuqVar.zzu(this.zza);
        if (this.zzh) {
            zzuqVar.zzr(zzuyVar.zza(zzK(zzuyVar.zza)));
        } else {
            this.zzf = zzuqVar;
            if (!this.zzg) {
                this.zzg = true;
                zzB(null, ((zzxf) this).zza);
            }
        }
        return zzuqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zztx
    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zztx, com.google.android.gms.internal.ads.zzva
    public final void zzt(zzap zzapVar) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzxb(this.zze.zzb, zzapVar));
        } else {
            this.zze = zzur.zzq(zzapVar);
        }
        this.zza.zzt(zzapVar);
    }

    @Override // com.google.android.gms.internal.ads.zzug, com.google.android.gms.internal.ads.zzva
    public final void zzz() {
    }
}

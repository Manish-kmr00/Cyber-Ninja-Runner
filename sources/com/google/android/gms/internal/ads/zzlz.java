package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzlz {
    private final zzlu zza;
    private final int zzb;
    private final zzlu zzc;
    private int zzd = 0;
    private boolean zze = false;
    private boolean zzf = false;

    public zzlz(zzlu zzluVar, zzlu zzluVar2, int i) {
        this.zza = zzluVar;
        this.zzb = i;
        this.zzc = zzluVar2;
    }

    private final int zzJ(zzlu zzluVar, zzkw zzkwVar, zzyw zzywVar, zzig zzigVar) throws zzii {
        if (zzluVar != null && zzR(zzluVar)) {
            zzlu zzluVar2 = this.zza;
            boolean z = zzluVar != zzluVar2;
            if ((zzluVar != zzluVar2 || !zzQ()) && (zzluVar != this.zzc || !zzS())) {
                zzws zzwsVarZzp = zzluVar.zzp();
                zzws[] zzwsVarArr = zzkwVar.zzc;
                int i = this.zzb;
                zzws zzwsVar = zzwsVarArr[i];
                boolean zZzb = zzywVar.zzb(i);
                if (zZzb && zzwsVarZzp == zzwsVar) {
                    return 1;
                }
                if (!zzluVar.zzR()) {
                    zzz[] zzzVarArrZzT = zzT(zzywVar.zzc[i]);
                    zzws zzwsVar2 = zzwsVarArr[i];
                    zzwsVar2.getClass();
                    zzluVar.zzH(zzzVarArrZzT, zzwsVar2, zzkwVar.zzf(), zzkwVar.zze(), zzkwVar.zzg.zza);
                    return 3;
                }
                if (!zzluVar.zzW()) {
                    return 0;
                }
                zzL(zzluVar, zzigVar);
                if (!zZzb || zzF()) {
                    zzN(!z);
                }
                return 1;
            }
        }
        return 1;
    }

    private final zzlu zzK(zzkw zzkwVar) {
        if (zzkwVar != null) {
            int i = this.zzb;
            zzws[] zzwsVarArr = zzkwVar.zzc;
            if (zzwsVarArr[i] != null) {
                zzlu zzluVar = this.zza;
                zzws zzwsVarZzp = zzluVar.zzp();
                zzws zzwsVar = zzwsVarArr[i];
                if (zzwsVarZzp == zzwsVar) {
                    return zzluVar;
                }
                zzlu zzluVar2 = this.zzc;
                if (zzluVar2 != null && zzluVar2.zzp() == zzwsVar) {
                    return zzluVar2;
                }
            }
        }
        return null;
    }

    private final void zzL(zzlu zzluVar, zzig zzigVar) {
        boolean z = true;
        if (this.zza != zzluVar && this.zzc != zzluVar) {
            z = false;
        }
        zzdc.zzf(z);
        if (zzR(zzluVar)) {
            zzigVar.zzd(zzluVar);
            zzU(zzluVar);
            zzluVar.zzr();
        }
    }

    private final void zzM(zzlu zzluVar, zzws zzwsVar, zzig zzigVar, long j, boolean z) throws zzii {
        if (zzR(zzluVar)) {
            if (zzwsVar != zzluVar.zzp()) {
                zzL(zzluVar, zzigVar);
            } else if (z) {
                zzluVar.zzJ(j);
            }
        }
    }

    private final void zzN(boolean z) {
        if (z) {
            if (this.zze) {
                this.zza.zzI();
                this.zze = false;
                return;
            }
            return;
        }
        if (this.zzf) {
            zzlu zzluVar = this.zzc;
            zzluVar.getClass();
            zzluVar.zzI();
            this.zzf = false;
        }
    }

    private final boolean zzP(zzkw zzkwVar, zzlu zzluVar) {
        if (zzluVar == null) {
            return true;
        }
        zzws[] zzwsVarArr = zzkwVar.zzc;
        int i = this.zzb;
        zzws zzwsVar = zzwsVarArr[i];
        if (zzluVar.zzp() != null) {
            if (zzluVar.zzp() == zzwsVar) {
                if (zzwsVar != null && !zzluVar.zzQ()) {
                    zzkwVar.zzg();
                    boolean z = zzkwVar.zzg.zzg;
                }
            }
            zzkw zzkwVarZzg = zzkwVar.zzg();
            return zzkwVarZzg != null && zzkwVarZzg.zzc[i] == zzluVar.zzp();
        }
        return true;
    }

    private final boolean zzQ() {
        int i = this.zzd;
        return i == 2 || i == 4;
    }

    private static boolean zzR(zzlu zzluVar) {
        return zzluVar.zzcT() != 0;
    }

    private final boolean zzS() {
        return this.zzd == 3;
    }

    private static zzz[] zzT(zzyp zzypVar) {
        int iZzd = zzypVar != null ? zzypVar.zzd() : 0;
        zzz[] zzzVarArr = new zzz[iZzd];
        for (int i = 0; i < iZzd; i++) {
            zzypVar.getClass();
            zzzVarArr[i] = zzypVar.zze(i);
        }
        return zzzVarArr;
    }

    private static final void zzU(zzlu zzluVar) {
        if (zzluVar.zzcT() == 2) {
            zzluVar.zzP();
        }
    }

    private static final void zzV(zzlu zzluVar, long j) {
        zzluVar.zzK();
        if (zzluVar instanceof zzxh) {
            throw null;
        }
    }

    public final boolean zzA(zzkw zzkwVar) {
        zzlu zzluVarZzK = zzK(zzkwVar);
        return zzluVarZzK == null || zzluVarZzK.zzQ() || zzluVarZzK.zzX() || zzluVarZzK.zzW();
    }

    public final boolean zzB(zzkw zzkwVar) {
        return zzP(zzkwVar, this.zza) && zzP(zzkwVar, this.zzc);
    }

    public final boolean zzC(zzkw zzkwVar) {
        zzlu zzluVarZzK = zzK(zzkwVar);
        zzluVarZzK.getClass();
        return zzluVarZzK.zzQ();
    }

    public final boolean zzD() {
        return this.zzc != null;
    }

    public final boolean zzE() {
        zzlu zzluVar = this.zza;
        boolean zZzW = zzR(zzluVar) ? zzluVar.zzW() : true;
        zzlu zzluVar2 = this.zzc;
        return (zzluVar2 == null || !zzR(zzluVar2)) ? zZzW : zZzW & zzluVar2.zzW();
    }

    public final boolean zzF() {
        return zzQ() || zzS();
    }

    public final boolean zzG(zzkw zzkwVar) {
        return (zzQ() && zzK(zzkwVar) == this.zza) || (zzS() && zzK(zzkwVar) == this.zzc);
    }

    public final boolean zzH(zzkw zzkwVar) {
        return zzK(zzkwVar) != null;
    }

    public final boolean zzI() {
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            return zzR(this.zza);
        }
        zzlu zzluVar = this.zzc;
        zzluVar.getClass();
        return zzR(zzluVar);
    }

    public final int zza() {
        zzlu zzluVar = this.zzc;
        boolean zZzR = zzR(this.zza);
        int i = 0;
        if (zzluVar != null && zzR(zzluVar)) {
            i = 1;
        }
        return (zZzR ? 1 : 0) + i;
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final int zzc(zzkw zzkwVar, zzyw zzywVar, zzig zzigVar) throws zzii {
        int iZzJ = zzJ(this.zza, zzkwVar, zzywVar, zzigVar);
        return iZzJ == 1 ? zzJ(this.zzc, zzkwVar, zzywVar, zzigVar) : iZzJ;
    }

    public final long zzd(zzkw zzkwVar) {
        return ((zzlu) Objects.requireNonNull(zzK(zzkwVar))).zzcV();
    }

    public final void zze(zzig zzigVar) throws zzii {
        zzL(this.zza, zzigVar);
        zzlu zzluVar = this.zzc;
        if (zzluVar != null) {
            boolean z = zzR(zzluVar) && this.zzd != 3;
            zzL(zzluVar, zzigVar);
            zzN(false);
            if (z) {
                zzO(true);
            }
        }
        this.zzd = 0;
    }

    public final void zzg(zzly zzlyVar, zzyp zzypVar, zzws zzwsVar, long j, boolean z, boolean z2, long j2, long j3, zzuy zzuyVar, zzig zzigVar) throws zzii {
        zzz[] zzzVarArrZzT = zzT(zzypVar);
        int i = this.zzd;
        if (i == 0 || i == 2 || i == 4) {
            this.zze = true;
            zzlu zzluVar = this.zza;
            zzluVar.zzs(zzlyVar, zzzVarArrZzT, zzwsVar, j, z, z2, j2, j3, zzuyVar);
            zzigVar.zze(zzluVar);
            return;
        }
        this.zzf = true;
        zzlu zzluVar2 = this.zzc;
        zzluVar2.getClass();
        zzluVar2.zzs(zzlyVar, zzzVarArrZzT, zzwsVar, j, z, z2, j2, j3, zzuyVar);
        zzigVar.zze(zzluVar2);
    }

    public final void zzh() {
        zzlu zzluVar = this.zza;
        if (zzR(zzluVar)) {
            zzluVar.zzt();
            return;
        }
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 == null || !zzR(zzluVar2)) {
            return;
        }
        zzluVar2.zzt();
    }

    public final void zzi(int i, Object obj, zzkw zzkwVar) throws zzii {
        zzlu zzluVarZzK = zzK(zzkwVar);
        zzluVarZzK.getClass();
        zzluVarZzK.zzu(11, obj);
    }

    public final void zzj(zzws zzwsVar, zzig zzigVar, long j, boolean z) throws zzii {
        zzM(this.zza, zzwsVar, zzigVar, j, z);
        zzlu zzluVar = this.zzc;
        if (zzluVar != null) {
            zzM(zzluVar, zzwsVar, zzigVar, j, z);
        }
    }

    public final void zzk() throws zzii {
        int i = this.zzd;
        if (i == 3 || i == 4) {
            zzO(i == 4);
            this.zzd = this.zzd != 4 ? 1 : 0;
        } else if (i == 2) {
            this.zzd = 0;
        }
    }

    public final void zzl(zzyw zzywVar, zzyw zzywVar2, long j) {
        int i;
        int i2 = this.zzb;
        boolean zZzb = zzywVar.zzb(i2);
        boolean zZzb2 = zzywVar2.zzb(i2);
        zzlu zzluVar = this.zzc;
        if (zzluVar == null || (i = this.zzd) == 3 || (i == 0 && zzR(this.zza))) {
            zzluVar = this.zza;
        }
        if (!zZzb || zzluVar.zzR()) {
            return;
        }
        zzb();
        zzly zzlyVar = zzywVar.zzb[i2];
        zzly zzlyVar2 = zzywVar2.zzb[i2];
        if (zZzb2 && Objects.equals(zzlyVar2, zzlyVar) && !zzF()) {
            return;
        }
        zzV(zzluVar, j);
    }

    public final void zzm(zzkw zzkwVar) throws IOException {
        zzlu zzluVarZzK = zzK(zzkwVar);
        zzluVarZzK.getClass();
        zzluVarZzK.zzw();
    }

    public final void zzn() {
        this.zza.zzG();
        this.zze = false;
        zzlu zzluVar = this.zzc;
        if (zzluVar != null) {
            zzluVar.zzG();
            this.zzf = false;
        }
    }

    public final void zzo(long j, long j2) throws zzii {
        zzlu zzluVar = this.zza;
        if (zzR(zzluVar)) {
            zzluVar.zzV(j, j2);
        }
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 == null || !zzR(zzluVar2)) {
            return;
        }
        zzluVar2.zzV(j, j2);
    }

    public final void zzp() {
        if (!zzR(this.zza)) {
            zzN(true);
        }
        zzlu zzluVar = this.zzc;
        if (zzluVar == null || zzR(zzluVar)) {
            return;
        }
        zzN(false);
    }

    public final void zzq(zzkw zzkwVar, long j) throws zzii {
        zzlu zzluVarZzK = zzK(zzkwVar);
        if (zzluVarZzK != null) {
            zzluVarZzK.zzJ(j);
        }
    }

    public final void zzr(long j) {
        int i;
        zzlu zzluVar = this.zza;
        if (zzR(zzluVar) && (i = this.zzd) != 4 && i != 2) {
            zzV(zzluVar, j);
        }
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 == null || !zzR(zzluVar2) || this.zzd == 3) {
            return;
        }
        zzV(zzluVar2, j);
    }

    public final void zzs(zzkw zzkwVar, long j) {
        zzlu zzluVarZzK = zzK(zzkwVar);
        zzluVarZzK.getClass();
        zzV(zzluVarZzK, j);
    }

    public final void zzt(float f, float f2) throws zzii {
        this.zza.zzM(f, f2);
        zzlu zzluVar = this.zzc;
        if (zzluVar != null) {
            zzluVar.zzM(f, f2);
        }
    }

    public final void zzu(zzbl zzblVar) {
        this.zza.zzN(zzblVar);
        zzlu zzluVar = this.zzc;
        if (zzluVar != null) {
            zzluVar.zzN(zzblVar);
        }
    }

    public final void zzv(Object obj) throws zzii {
        if (zzb() != 2) {
            return;
        }
        int i = this.zzd;
        if (i != 4 && i != 1) {
            this.zza.zzu(1, obj);
            return;
        }
        zzlu zzluVar = this.zzc;
        zzluVar.getClass();
        zzluVar.zzu(1, obj);
    }

    public final void zzw(float f) throws zzii {
        if (zzb() != 1) {
            return;
        }
        zzlu zzluVar = this.zza;
        Float fValueOf = Float.valueOf(f);
        zzluVar.zzu(2, fValueOf);
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 != null) {
            zzluVar2.zzu(2, fValueOf);
        }
    }

    public final void zzx() throws zzii {
        zzlu zzluVar = this.zza;
        if (zzluVar.zzcT() == 1 && this.zzd != 4) {
            zzluVar.zzO();
            return;
        }
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 == null || zzluVar2.zzcT() != 1 || this.zzd == 3) {
            return;
        }
        zzluVar2.zzO();
    }

    public final void zzy() {
        int i;
        zzdc.zzf(!zzF());
        if (zzR(this.zza)) {
            i = 3;
        } else {
            zzlu zzluVar = this.zzc;
            i = (zzluVar == null || !zzR(zzluVar)) ? 2 : 4;
        }
        this.zzd = i;
    }

    public final void zzz() {
        zzlu zzluVar = this.zza;
        if (zzR(zzluVar)) {
            zzU(zzluVar);
        }
        zzlu zzluVar2 = this.zzc;
        if (zzluVar2 == null || !zzR(zzluVar2)) {
            return;
        }
        zzU(zzluVar2);
    }

    private final void zzO(boolean z) throws zzii {
        if (z) {
            zzlu zzluVar = this.zzc;
            zzluVar.getClass();
            zzluVar.zzu(17, this.zza);
        } else {
            zzlu zzluVar2 = this.zza;
            zzlu zzluVar3 = this.zzc;
            zzluVar3.getClass();
            zzluVar2.zzu(17, zzluVar3);
        }
    }

    public final void zzf(zzig zzigVar) {
        boolean z;
        zzlu zzluVar;
        if (zzF()) {
            int i = this.zzd;
            if (i == 4) {
                z = true;
            } else if (i == 2) {
                i = 2;
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zzluVar = this.zza;
            } else {
                zzluVar = this.zzc;
                zzluVar.getClass();
            }
            zzL(zzluVar, zzigVar);
            zzN(z);
            this.zzd = i == 4 ? 1 : 0;
        }
    }
}

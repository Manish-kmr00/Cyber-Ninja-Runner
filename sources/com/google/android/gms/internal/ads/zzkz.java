package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes12.dex */
final class zzkz {
    private final zzmg zzc;
    private final zzdq zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzis zzh;
    private zzkw zzi;
    private zzkw zzj;
    private zzkw zzk;
    private zzkw zzl;
    private zzkw zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzkd zzr;
    private final zzbj zza = new zzbj();
    private final zzbk zzb = new zzbk();
    private List zzq = new ArrayList();

    public zzkz(zzmg zzmgVar, zzdq zzdqVar, zzkd zzkdVar, zzis zzisVar) {
        this.zzc = zzmgVar;
        this.zzd = zzdqVar;
        this.zzr = zzkdVar;
        this.zzh = zzisVar;
    }

    private final int zzB(zzbl zzblVar) {
        zzkw zzkwVarZzg = this.zzi;
        if (zzkwVarZzg == null) {
            return 0;
        }
        int iZza = zzblVar.zza(zzkwVarZzg.zzb);
        while (true) {
            iZza = zzblVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkwVarZzg.getClass();
                if (zzkwVarZzg.zzg() == null || zzkwVarZzg.zzg.zzh) {
                    break;
                }
                zzkwVarZzg = zzkwVarZzg.zzg();
            }
            zzkw zzkwVarZzg2 = zzkwVarZzg.zzg();
            if (iZza == -1 || zzkwVarZzg2 == null || zzblVar.zza(zzkwVarZzg2.zzb) != iZza) {
                break;
            }
            zzkwVarZzg = zzkwVarZzg2;
        }
        int iZza2 = zza(zzkwVarZzg);
        zzkwVarZzg.zzg = zzp(zzblVar, zzkwVarZzg.zzg);
        return iZza2;
    }

    private final long zzC(zzbl zzblVar, Object obj, int i) {
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        zzbjVar.zzg(i);
        long j = zzbjVar.zzg.zza(i).zzh;
        return 0L;
    }

    private final long zzD(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkw zzkwVar = (zzkw) this.zzq.get(i);
            if (zzkwVar.zzb.equals(obj)) {
                return zzkwVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final zzkx zzE(zzbl zzblVar, zzkw zzkwVar, long j) {
        long j2;
        long j3;
        long j4;
        zzkx zzkxVar = zzkwVar.zzg;
        long jZze = zzkwVar.zze();
        long j5 = zzkxVar.zze;
        long j6 = (jZze + j5) - j;
        if (zzkxVar.zzh) {
            zzuy zzuyVar = zzkxVar.zza;
            Object obj = zzuyVar.zza;
            int iZza = zzblVar.zza(obj);
            int i = this.zzf;
            boolean z = this.zzg;
            zzbk zzbkVar = this.zzb;
            zzbj zzbjVar = this.zza;
            int iZzi = zzblVar.zzi(iZza, zzbjVar, zzbkVar, i, z);
            if (iZzi != -1) {
                int i2 = zzblVar.zzd(iZzi, zzbjVar, true).zzc;
                Object obj2 = zzbjVar.zzb;
                obj2.getClass();
                long jZzD = zzuyVar.zzd;
                if (zzblVar.zze(i2, zzbkVar, 0L).zzn == iZzi) {
                    Pair pairZzm = zzblVar.zzm(zzbkVar, zzbjVar, i2, -9223372036854775807L, Math.max(0L, j6));
                    if (pairZzm != null) {
                        obj2 = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzkw zzkwVarZzg = zzkwVar.zzg();
                        if (zzkwVarZzg == null || !zzkwVarZzg.zzb.equals(obj2)) {
                            jZzD = zzD(obj2);
                            if (jZzD == -1) {
                                jZzD = this.zze;
                                this.zze = 1 + jZzD;
                            }
                        } else {
                            jZzD = zzkwVarZzg.zzg.zza.zzd;
                        }
                        j4 = jLongValue;
                        j3 = -9223372036854775807L;
                    }
                } else {
                    j3 = 0;
                    j4 = 0;
                }
                zzuy zzuyVarZzI = zzI(zzblVar, obj2, j4, jZzD, zzbkVar, zzbjVar);
                if (j3 != -9223372036854775807L && zzkxVar.zzc != -9223372036854775807L) {
                    zzblVar.zzn(obj, zzbjVar).zzb();
                    int i3 = zzbjVar.zzg.zzd;
                }
                return zzF(zzblVar, zzuyVarZzI, j3, j4);
            }
        } else {
            zzuy zzuyVar2 = zzkxVar.zza;
            Object obj3 = zzuyVar2.zza;
            zzbj zzbjVar2 = this.zza;
            zzblVar.zzn(obj3, zzbjVar2);
            boolean z2 = zzkxVar.zzg;
            if (!zzuyVar2.zzb()) {
                int i4 = zzuyVar2.zze;
                if (i4 != -1) {
                    zzbjVar2.zzj(i4);
                }
                int iZze = zzbjVar2.zze(i4);
                zzbjVar2.zzk(i4);
                if (iZze != zzbjVar2.zza(i4)) {
                    return zzG(zzblVar, obj3, i4, iZze, j5, zzuyVar2.zzd, false);
                }
                zzC(zzblVar, obj3, i4);
                return zzH(zzblVar, obj3, 0L, j5, zzuyVar2.zzd, false);
            }
            int i5 = zzuyVar2.zzb;
            if (zzbjVar2.zza(i5) != -1) {
                int iZza2 = zzbjVar2.zzg.zza(i5).zza(zzuyVar2.zzc);
                if (iZza2 < 0) {
                    return zzG(zzblVar, obj3, i5, iZza2, zzkxVar.zzc, zzuyVar2.zzd, false);
                }
                long jLongValue2 = zzkxVar.zzc;
                if (jLongValue2 == -9223372036854775807L) {
                    Pair pairZzm2 = zzblVar.zzm(this.zzb, zzbjVar2, zzbjVar2.zzc, -9223372036854775807L, Math.max(0L, j6));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                        j2 = -9223372036854775807L;
                    }
                } else {
                    j2 = jLongValue2;
                }
                zzC(zzblVar, obj3, i5);
                return zzH(zzblVar, obj3, Math.max(0L, jLongValue2), j2, zzuyVar2.zzd, false);
            }
        }
        return null;
    }

    private final zzkx zzF(zzbl zzblVar, zzuy zzuyVar, long j, long j2) {
        Object obj = zzuyVar.zza;
        zzblVar.zzn(obj, this.zza);
        return zzuyVar.zzb() ? zzG(zzblVar, obj, zzuyVar.zzb, zzuyVar.zzc, j, zzuyVar.zzd, false) : zzH(zzblVar, obj, j2, j, zzuyVar.zzd, false);
    }

    private final zzkx zzG(zzbl zzblVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzuy zzuyVar = new zzuy(obj, i, i2, j2);
        Object obj2 = zzuyVar.zza;
        int i3 = zzuyVar.zzb;
        int i4 = zzuyVar.zzc;
        zzbj zzbjVar = this.zza;
        long jZzf = zzblVar.zzn(obj2, zzbjVar).zzf(i3, i4);
        if (i2 == zzbjVar.zze(i)) {
            zzbjVar.zzh();
        }
        zzbjVar.zzk(i3);
        return new zzkx(zzuyVar, (jZzf == -9223372036854775807L || jZzf > 0) ? 0L : Math.max(0L, (-1) + jZzf), j, -9223372036854775807L, jZzf, false, false, false, false, false);
    }

    private final zzkx zzH(zzbl zzblVar, Object obj, long j, long j2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        int iZzc = zzbjVar.zzc(jMax);
        if (iZzc != -1) {
            zzbjVar.zzj(iZzc);
        }
        if (iZzc == -1) {
            zzbjVar.zzb();
        } else {
            zzbjVar.zzk(iZzc);
        }
        zzuy zzuyVar = new zzuy(obj, j3, iZzc);
        boolean zZzM = zzM(zzuyVar);
        boolean zZzL = zzL(zzblVar, zzuyVar);
        boolean zZzK = zzK(zzblVar, zzuyVar, zZzM);
        if (iZzc != -1) {
            zzbjVar.zzk(iZzc);
        }
        if (iZzc != -1) {
            zzbjVar.zzg(iZzc);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = 0;
            j5 = 0;
        } else {
            j5 = zzbjVar.zzd;
            j6 = j4;
        }
        if (j5 != -9223372036854775807L && jMax >= j5) {
            jMax = Math.max(0L, j5 - 1);
        }
        return new zzkx(zzuyVar, jMax, j2, j6, j5, false, false, zZzM, zZzL, zZzK);
    }

    private static zzuy zzI(zzbl zzblVar, Object obj, long j, long j2, zzbk zzbkVar, zzbj zzbjVar) {
        zzblVar.zzn(obj, zzbjVar);
        zzblVar.zze(zzbjVar.zzc, zzbkVar, 0L);
        zzblVar.zza(obj);
        zzbjVar.zzb();
        zzblVar.zzn(obj, zzbjVar);
        int iZzd = zzbjVar.zzd(j);
        return iZzd == -1 ? new zzuy(obj, j2, zzbjVar.zzc(j)) : new zzuy(obj, iZzd, zzbjVar.zze(iZzd), j2);
    }

    private final void zzJ() {
        int i = zzfww.zzd;
        final zzfwt zzfwtVar = new zzfwt();
        for (zzkw zzkwVarZzg = this.zzi; zzkwVarZzg != null; zzkwVarZzg = zzkwVarZzg.zzg()) {
            zzfwtVar.zzf(zzkwVarZzg.zzg.zza);
        }
        zzkw zzkwVar = this.zzj;
        final zzuy zzuyVar = zzkwVar == null ? null : zzkwVar.zzg.zza;
        this.zzd.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzky
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc.zzU(zzfwtVar.zzi(), zzuyVar);
            }
        });
    }

    private final boolean zzK(zzbl zzblVar, zzuy zzuyVar, boolean z) {
        int iZza = zzblVar.zza(zzuyVar.zza);
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzd(iZza, zzbjVar, false).zzc;
        zzbk zzbkVar = this.zzb;
        return !zzblVar.zze(i, zzbkVar, 0L).zzi && zzblVar.zzi(iZza, zzbjVar, zzbkVar, this.zzf, this.zzg) == -1 && z;
    }

    private final boolean zzL(zzbl zzblVar, zzuy zzuyVar) {
        if (!zzM(zzuyVar)) {
            return false;
        }
        Object obj = zzuyVar.zza;
        return zzblVar.zze(zzblVar.zzn(obj, this.zza).zzc, this.zzb, 0L).zzo == zzblVar.zza(obj);
    }

    private static final boolean zzM(zzuy zzuyVar) {
        return !zzuyVar.zzb() && zzuyVar.zze == -1;
    }

    static boolean zzx(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public final boolean zzA() {
        zzkw zzkwVar = this.zzl;
        if (zzkwVar == null) {
            return true;
        }
        if (zzkwVar.zzg.zzj || !zzkwVar.zzs() || this.zzl.zzg.zze == -9223372036854775807L) {
            return false;
        }
        return this.zzn < 100;
    }

    public final int zza(zzkw zzkwVar) {
        zzdc.zzb(zzkwVar);
        int i = 0;
        if (zzkwVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzkwVar;
        while (zzkwVar.zzg() != null) {
            zzkwVar = zzkwVar.zzg();
            zzkwVar.getClass();
            if (zzkwVar == this.zzj) {
                zzkw zzkwVar2 = this.zzi;
                this.zzj = zzkwVar2;
                this.zzk = zzkwVar2;
                i = 3;
            }
            if (zzkwVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzkwVar.zzo();
            this.zzn--;
        }
        zzkw zzkwVar3 = this.zzl;
        zzkwVar3.getClass();
        zzkwVar3.zzp(null);
        zzJ();
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006c  */
    public final int zzb(zzbl zzblVar, long j, long j2, long j3) {
        zzkx zzkxVarZzp;
        int i;
        zzkw zzkwVarZzg = this.zzi;
        zzkw zzkwVar = null;
        while (true) {
            boolean z = false;
            if (zzkwVarZzg == null) {
                return 0;
            }
            zzkx zzkxVar = zzkwVarZzg.zzg;
            if (zzkwVar == null) {
                zzkxVarZzp = zzp(zzblVar, zzkxVar);
            } else {
                zzkx zzkxVarZzE = zzE(zzblVar, zzkwVar, j);
                if (zzkxVarZzE == null || zzkxVar.zzb != zzkxVarZzE.zzb || !zzkxVar.zza.equals(zzkxVarZzE.zza)) {
                    return zza(zzkwVar);
                }
                zzkxVarZzp = zzkxVarZzE;
            }
            zzkwVarZzg.zzg = zzkxVarZzp.zza(zzkxVar.zzc);
            long j4 = zzkxVar.zze;
            long j5 = zzkxVarZzp.zze;
            if (!zzx(j4, j5)) {
                zzkwVarZzg.zzr();
                long jZze = j5 == -9223372036854775807L ? Long.MAX_VALUE : zzkwVarZzg.zze() + j5;
                if (zzkwVarZzg == this.zzj) {
                    boolean z2 = zzkwVarZzg.zzg.zzg;
                    if (j2 == Long.MIN_VALUE || j2 >= jZze) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                if (zzkwVarZzg == this.zzk && (j3 == Long.MIN_VALUE || j3 >= jZze)) {
                    z = true;
                }
                int iZza = zza(zzkwVarZzg);
                if (iZza != 0) {
                    return iZza;
                }
                return z ? i | 2 : i;
            }
            zzkwVar = zzkwVarZzg;
            zzkwVarZzg = zzkwVarZzg.zzg();
        }
    }

    public final int zzc(zzbl zzblVar, int i) {
        this.zzf = i;
        return zzB(zzblVar);
    }

    public final int zzd(zzbl zzblVar, boolean z) {
        this.zzg = z;
        return zzB(zzblVar);
    }

    public final zzkw zze() {
        zzkw zzkwVar = this.zzi;
        if (zzkwVar == null) {
            return null;
        }
        if (zzkwVar == this.zzj) {
            this.zzj = zzkwVar.zzg();
        }
        if (zzkwVar == this.zzk) {
            this.zzk = zzkwVar.zzg();
        }
        zzkwVar.zzo();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzkw zzkwVar2 = this.zzi;
            this.zzo = zzkwVar2.zzb;
            this.zzp = zzkwVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzg();
        zzJ();
        return this.zzi;
    }

    public final zzkw zzf() {
        zzkw zzkwVar = this.zzk;
        zzdc.zzb(zzkwVar);
        this.zzk = zzkwVar.zzg();
        zzJ();
        zzkw zzkwVar2 = this.zzk;
        zzdc.zzb(zzkwVar2);
        return zzkwVar2;
    }

    public final zzkw zzg() {
        zzkw zzkwVar = this.zzk;
        zzkw zzkwVar2 = this.zzj;
        if (zzkwVar == zzkwVar2) {
            zzdc.zzb(zzkwVar2);
            this.zzk = zzkwVar2.zzg();
        }
        zzkw zzkwVar3 = this.zzj;
        zzdc.zzb(zzkwVar3);
        this.zzj = zzkwVar3.zzg();
        zzJ();
        zzkw zzkwVar4 = this.zzj;
        zzdc.zzb(zzkwVar4);
        return zzkwVar4;
    }

    public final zzkw zzi() {
        return this.zzl;
    }

    public final zzkw zzj() {
        return this.zzi;
    }

    public final zzkw zzk(zzuw zzuwVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkw zzkwVar = (zzkw) this.zzq.get(i);
            if (zzkwVar.zza == zzuwVar) {
                return zzkwVar;
            }
        }
        return null;
    }

    public final zzkw zzl() {
        return this.zzm;
    }

    public final zzkw zzm() {
        return this.zzk;
    }

    public final zzkw zzn() {
        return this.zzj;
    }

    public final zzkx zzo(long j, zzlm zzlmVar) {
        zzkw zzkwVar = this.zzl;
        return zzkwVar == null ? zzF(zzlmVar.zza, zzlmVar.zzb, zzlmVar.zzc, zzlmVar.zzs) : zzE(zzlmVar.zza, zzkwVar, j);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:20:0x005e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    public final zzkx zzp(zzbl zzblVar, zzkx zzkxVar) {
        long j;
        long jZzf;
        long j2;
        long j3;
        int i;
        int i2;
        zzuy zzuyVar = zzkxVar.zza;
        boolean zZzM = zzM(zzuyVar);
        boolean zZzL = zzL(zzblVar, zzuyVar);
        boolean zZzK = zzK(zzblVar, zzuyVar, zZzM);
        Object obj = zzuyVar.zza;
        zzbj zzbjVar = this.zza;
        zzblVar.zzn(obj, zzbjVar);
        if (zzuyVar.zzb() || (i2 = zzuyVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbjVar.zzg(i2);
            j = 0;
        }
        if (!zzuyVar.zzb()) {
            if (j != -9223372036854775807L) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzf = zzbjVar.zzd;
            }
            if (zzuyVar.zzb()) {
                zzbjVar.zzk(zzuyVar.zzb);
            } else {
                i = zzuyVar.zze;
                if (i != -1) {
                    zzbjVar.zzk(i);
                }
            }
            long j4 = zzkxVar.zzb;
            long j5 = zzkxVar.zzc;
            boolean z = zzkxVar.zzf;
            return new zzkx(zzuyVar, j4, j5, j3, j2, false, false, zZzM, zZzL, zZzK);
        }
        jZzf = zzbjVar.zzf(zzuyVar.zzb, zzuyVar.zzc);
        j3 = j;
        j2 = jZzf;
        if (zzuyVar.zzb()) {
            zzbjVar.zzk(zzuyVar.zzb);
        } else {
            i = zzuyVar.zze;
            if (i != -1) {
                zzbjVar.zzk(i);
            }
        }
        long j6 = zzkxVar.zzb;
        long j7 = zzkxVar.zzc;
        boolean z2 = zzkxVar.zzf;
        return new zzkx(zzuyVar, j6, j7, j3, j2, false, false, zZzM, zZzL, zZzK);
    }

    public final zzuy zzq(zzbl zzblVar, Object obj, long j) {
        long jZzD;
        int iZza;
        zzbj zzbjVar = this.zza;
        int i = zzblVar.zzn(obj, zzbjVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZza = zzblVar.zza(obj2)) == -1 || zzblVar.zzd(iZza, zzbjVar, false).zzc != i) {
            zzkw zzkwVarZzg = this.zzi;
            while (true) {
                if (zzkwVarZzg == null) {
                    zzkw zzkwVarZzg2 = this.zzi;
                    while (true) {
                        if (zzkwVarZzg2 == null) {
                            jZzD = zzD(obj);
                            if (jZzD != -1) {
                                break;
                            }
                            jZzD = this.zze;
                            this.zze = 1 + jZzD;
                            if (this.zzi != null) {
                                break;
                            }
                            this.zzo = obj;
                            this.zzp = jZzD;
                            break;
                        }
                        int iZza2 = zzblVar.zza(zzkwVarZzg2.zzb);
                        if (iZza2 != -1 && zzblVar.zzd(iZza2, zzbjVar, false).zzc == i) {
                            jZzD = zzkwVarZzg2.zzg.zza.zzd;
                            break;
                        }
                        zzkwVarZzg2 = zzkwVarZzg2.zzg();
                    }
                } else {
                    if (zzkwVarZzg.zzb.equals(obj)) {
                        jZzD = zzkwVarZzg.zzg.zza.zzd;
                        break;
                    }
                    zzkwVarZzg = zzkwVarZzg.zzg();
                }
            }
        } else {
            jZzD = this.zzp;
        }
        long j2 = jZzD;
        zzblVar.zzn(obj, zzbjVar);
        int i2 = zzbjVar.zzc;
        zzbk zzbkVar = this.zzb;
        zzblVar.zze(i2, zzbkVar, 0L);
        Object obj3 = obj;
        for (int iZza3 = zzblVar.zza(obj); iZza3 >= zzbkVar.zzn; iZza3--) {
            zzblVar.zzd(iZza3, zzbjVar, true);
            zzbjVar.zzb();
            if (zzbjVar.zzd(zzbjVar.zzd) != -1) {
                Object obj4 = zzbjVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzI(zzblVar, obj3, j, j2, zzbkVar, zzbjVar);
    }

    public final void zzs() {
        if (this.zzn == 0) {
            return;
        }
        zzkw zzkwVarZzg = this.zzi;
        zzdc.zzb(zzkwVarZzg);
        this.zzo = zzkwVarZzg.zzb;
        this.zzp = zzkwVarZzg.zzg.zza.zzd;
        while (zzkwVarZzg != null) {
            zzkwVarZzg.zzo();
            zzkwVarZzg = zzkwVarZzg.zzg();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzJ();
    }

    public final void zzt() {
        zzkw zzkwVar = this.zzm;
        if (zzkwVar == null || zzkwVar.zzt()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzkw zzkwVar2 = (zzkw) this.zzq.get(i);
                if (!zzkwVar2.zzt()) {
                    this.zzm = zzkwVar2;
                    return;
                }
            }
        }
    }

    public final void zzu(long j) {
        zzkw zzkwVar = this.zzl;
        if (zzkwVar != null) {
            zzkwVar.zzn(j);
        }
    }

    public final void zzv() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzkw) this.zzq.get(i)).zzo();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final void zzw(zzbl zzblVar, zzis zzisVar) {
        this.zzh = zzisVar;
        long j = zzisVar.zzb;
        zzv();
    }

    public final boolean zzy(zzuw zzuwVar) {
        zzkw zzkwVar = this.zzl;
        return zzkwVar != null && zzkwVar.zza == zzuwVar;
    }

    public final boolean zzz(zzuw zzuwVar) {
        zzkw zzkwVar = this.zzm;
        return zzkwVar != null && zzkwVar.zza == zzuwVar;
    }

    public final zzkw zzh(zzkx zzkxVar) {
        zzkw zzkwVarZzf;
        zzkw zzkwVar = this.zzl;
        long jZze = zzkwVar == null ? 1000000000000L : (zzkwVar.zze() + zzkwVar.zzg.zze) - zzkxVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzkwVarZzf = null;
                break;
            }
            zzkx zzkxVar2 = ((zzkw) this.zzq.get(i)).zzg;
            if (zzx(zzkxVar2.zze, zzkxVar.zze) && zzkxVar2.zzb == zzkxVar.zzb && zzkxVar2.zza.equals(zzkxVar.zza)) {
                zzkwVarZzf = (zzkw) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzkwVarZzf == null) {
            zzkwVarZzf = zzkn.zzf(this.zzr.zza, zzkxVar, jZze);
        } else {
            zzkwVarZzf.zzg = zzkxVar;
            zzkwVarZzf.zzq(jZze);
        }
        zzkw zzkwVar2 = this.zzl;
        if (zzkwVar2 != null) {
            zzkwVar2.zzp(zzkwVarZzf);
        } else {
            this.zzi = zzkwVarZzf;
            this.zzj = zzkwVarZzf;
            this.zzk = zzkwVarZzf;
        }
        this.zzo = null;
        this.zzl = zzkwVarZzf;
        this.zzn++;
        zzJ();
        return zzkwVarZzf;
    }
}

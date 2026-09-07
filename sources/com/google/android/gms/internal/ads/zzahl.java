package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahl implements zzadc {
    private final zzek zza;
    private final zzadu zzb;
    private final zzadq zzc;
    private final zzads zzd;
    private final zzaei zze;
    private zzadf zzf;
    private zzaei zzg;
    private zzaei zzh;
    private int zzi;
    private zzav zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private zzahn zzp;
    private boolean zzq;

    public zzahl() {
        throw null;
    }

    public zzahl(int i) {
        this.zza = new zzek(10);
        this.zzb = new zzadu();
        this.zzc = new zzadq();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzads();
        zzacx zzacxVar = new zzacx();
        this.zze = zzacxVar;
        this.zzh = zzacxVar;
        this.zzn = -1L;
    }

    /* JADX WARN: Code duplicated, block: B:123:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:124:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:128:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:24:0x005f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0067  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:29:0x0072  */
    /* JADX WARN: Code duplicated, block: B:34:0x007c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:56:0x0106  */
    /* JADX WARN: Code duplicated, block: B:58:0x010c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x011b  */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x00c8, please report this as an issue */
    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private final int zzg(zzadd zzaddVar) throws IOException {
        int iZzf;
        int i;
        int iZzg;
        zzahp zzahpVarZzb;
        zzadq zzadqVar;
        long jZzf;
        long jZzd;
        long jZza;
        long j;
        int i2;
        zzahn zzahiVar;
        long j2;
        long j3;
        int i3;
        int i4;
        zzahk zzahkVarZzb;
        zzahn zzahiVar2;
        long jZzs;
        if (this.zzi == 0) {
            try {
                zzm(zzaddVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzp == null) {
            zzadu zzaduVar = this.zzb;
            zzek zzekVar = new zzek(zzaduVar.zzc);
            zzaddVar.zzh(zzekVar.zzN(), 0, zzaduVar.zzc);
            int i5 = 21;
            if ((zzaduVar.zza & 1) != 0) {
                if (zzaduVar.zze != 1) {
                    i5 = 36;
                }
            } else if (zzaduVar.zze == 1) {
                i5 = 13;
            }
            if (zzekVar.zzd() >= i5 + 4) {
                zzekVar.zzL(i5);
                iZzg = zzekVar.zzg();
                if (iZzg != 1483304551) {
                    if (iZzg == 1231971951) {
                        iZzg = 1231971951;
                    } else if (zzekVar.zzd() >= 40) {
                        zzekVar.zzL(36);
                        if (zzekVar.zzg() == 1447187017) {
                            iZzg = 1447187017;
                        } else {
                            iZzg = 0;
                        }
                    } else {
                        iZzg = 0;
                    }
                }
            } else if (zzekVar.zzd() >= 40) {
                zzekVar.zzL(36);
                if (zzekVar.zzg() == 1447187017) {
                    iZzg = 1447187017;
                } else {
                    iZzg = 0;
                }
            } else {
                iZzg = 0;
            }
            if (iZzg == 1231971951) {
                zzahpVarZzb = zzahp.zzb(zzaduVar, zzekVar);
                zzadqVar = this.zzc;
                if (!zzadqVar.zza() && (i3 = zzahpVarZzb.zzd) != -1 && (i4 = zzahpVarZzb.zze) != -1) {
                    zzadqVar.zza = i3;
                    zzadqVar.zzb = i4;
                }
                jZzf = zzaddVar.zzf();
                if (zzaddVar.zzd() != -1) {
                    j2 = zzahpVarZzb.zzc;
                    if (j2 != -1) {
                        j3 = j2 + jZzf;
                        if (zzaddVar.zzd() != j3) {
                            zzdx.zze("Mp3Extractor", "Data size mismatch between stream (" + zzaddVar.zzd() + ") and Xing frame (" + j3 + "), using Xing value.");
                        }
                    }
                }
                zzaddVar.zzk(zzaduVar.zzc);
                if (iZzg == 1483304551) {
                    zzahiVar = zzahq.zzb(zzahpVarZzb, jZzf);
                } else {
                    jZzd = zzaddVar.zzd();
                    jZza = zzahpVarZzb.zza();
                    if (jZza != -9223372036854775807L) {
                        zzahiVar = null;
                    } else {
                        j = zzahpVarZzb.zzc;
                        if (j != -1) {
                            jZzd = jZzf + j;
                            i2 = zzahpVarZzb.zza.zzc;
                        } else if (jZzd != -1) {
                            j = jZzd - jZzf;
                            i2 = zzahpVarZzb.zza.zzc;
                        } else {
                            zzahiVar = null;
                        }
                        long j4 = j - ((long) i2);
                        zzahiVar = new zzahi(jZzd, jZzf + ((long) zzahpVarZzb.zza.zzc), zzfzz.zzb(zzeu.zzu(j4, 8000000L, jZza, RoundingMode.HALF_UP)), zzfzz.zzb(zzfzu.zzb(j4, zzahpVarZzb.zzb, RoundingMode.HALF_UP)), false);
                    }
                }
            } else if (iZzg != 1447187017) {
                if (iZzg != 1483304551) {
                    zzaddVar.zzj();
                } else {
                    zzahpVarZzb = zzahp.zzb(zzaduVar, zzekVar);
                    zzadqVar = this.zzc;
                    if (!zzadqVar.zza()) {
                        zzadqVar.zza = i3;
                        zzadqVar.zzb = i4;
                    }
                    jZzf = zzaddVar.zzf();
                    if (zzaddVar.zzd() != -1) {
                        j2 = zzahpVarZzb.zzc;
                        if (j2 != -1) {
                            j3 = j2 + jZzf;
                            if (zzaddVar.zzd() != j3) {
                                zzdx.zze("Mp3Extractor", "Data size mismatch between stream (" + zzaddVar.zzd() + ") and Xing frame (" + j3 + "), using Xing value.");
                            }
                        }
                    }
                    zzaddVar.zzk(zzaduVar.zzc);
                    if (iZzg == 1483304551) {
                        zzahiVar = zzahq.zzb(zzahpVarZzb, jZzf);
                    } else {
                        jZzd = zzaddVar.zzd();
                        jZza = zzahpVarZzb.zza();
                        if (jZza != -9223372036854775807L) {
                            j = zzahpVarZzb.zzc;
                            if (j != -1) {
                                jZzd = jZzf + j;
                                i2 = zzahpVarZzb.zza.zzc;
                            } else if (jZzd != -1) {
                                j = jZzd - jZzf;
                                i2 = zzahpVarZzb.zza.zzc;
                            }
                            long j5 = j - ((long) i2);
                            zzahiVar = new zzahi(jZzd, jZzf + ((long) zzahpVarZzb.zza.zzc), zzfzz.zzb(zzeu.zzu(j5, 8000000L, jZza, RoundingMode.HALF_UP)), zzfzz.zzb(zzfzu.zzb(j5, zzahpVarZzb.zzb, RoundingMode.HALF_UP)), false);
                        }
                    }
                }
                zzahiVar = null;
            } else {
                zzahiVar = zzaho.zzb(zzaddVar.zzd(), zzaddVar.zzf(), zzaduVar, zzekVar);
                zzaddVar.zzk(zzaduVar.zzc);
            }
            zzav zzavVar = this.zzj;
            long jZzf2 = zzaddVar.zzf();
            if (zzavVar == null) {
                zzahkVarZzb = null;
                break;
            }
            int iZza = zzavVar.zza();
            int i6 = 0;
            while (true) {
                if (i6 >= iZza) {
                    zzahkVarZzb = null;
                    break;
                }
                zzau zzauVarZzb = zzavVar.zzb(i6);
                if (zzauVarZzb instanceof zzagp) {
                    zzagp zzagpVar = (zzagp) zzauVarZzb;
                    int iZza2 = zzavVar.zza();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= iZza2) {
                            jZzs = -9223372036854775807L;
                            break;
                        }
                        zzau zzauVarZzb2 = zzavVar.zzb(i7);
                        if (zzauVarZzb2 instanceof zzagr) {
                            zzagr zzagrVar = (zzagr) zzauVarZzb2;
                            if (zzagrVar.zzf.equals("TLEN")) {
                                jZzs = zzeu.zzs(Long.parseLong((String) zzagrVar.zzb.get(0)));
                                break;
                            }
                        }
                        i7++;
                    }
                    zzahkVarZzb = zzahk.zzb(jZzf2, zzagpVar, jZzs);
                    break;
                }
                i6++;
            }
            if (this.zzq) {
                zzahiVar2 = new zzahm();
            } else {
                if (zzahkVarZzb != null) {
                    zzahiVar = zzahkVarZzb;
                } else if (zzahiVar == null) {
                    zzahiVar = null;
                }
                if (zzahiVar == null) {
                    zzek zzekVar2 = this.zza;
                    zzaddVar.zzh(zzekVar2.zzN(), 0, 4);
                    zzekVar2.zzL(0);
                    zzaduVar.zza(zzekVar2.zzg());
                    zzahiVar2 = new zzahi(zzaddVar.zzd(), zzaddVar.zzf(), zzaduVar.zzf, zzaduVar.zzc, false);
                } else {
                    zzahiVar2 = zzahiVar;
                }
                this.zzg.zzl(zzahiVar2.zza());
            }
            this.zzp = zzahiVar2;
            this.zzf.zzP(zzahiVar2);
            zzx zzxVar = new zzx();
            zzxVar.zzE("audio/mpeg");
            zzxVar.zzad(zzaduVar.zzb);
            zzxVar.zzT(4096);
            zzxVar.zzB(zzaduVar.zze);
            zzxVar.zzae(zzaduVar.zzd);
            zzadq zzadqVar2 = this.zzc;
            zzxVar.zzI(zzadqVar2.zza);
            zzxVar.zzJ(zzadqVar2.zzb);
            zzxVar.zzW(this.zzj);
            if (this.zzp.zzc() != -2147483647) {
                zzxVar.zzA(this.zzp.zzc());
            }
            this.zzh.zzm(zzxVar.zzaj());
            this.zzm = zzaddVar.zzf();
        } else {
            long j6 = this.zzm;
            if (j6 != 0) {
                long jZzf3 = zzaddVar.zzf();
                if (jZzf3 < j6) {
                    zzaddVar.zzk((int) (j6 - jZzf3));
                }
            }
        }
        int i8 = this.zzo;
        if (i8 == 0) {
            zzaddVar.zzj();
            if (zzl(zzaddVar)) {
                return -1;
            }
            zzek zzekVar3 = this.zza;
            zzekVar3.zzL(0);
            int iZzg2 = zzekVar3.zzg();
            if (!zzk(iZzg2, this.zzi) || zzadv.zzb(iZzg2) == -1) {
                zzaddVar.zzk(1);
                this.zzi = 0;
            } else {
                zzadu zzaduVar2 = this.zzb;
                zzaduVar2.zza(iZzg2);
                if (this.zzk == -9223372036854775807L) {
                    this.zzk = this.zzp.zze(zzaddVar.zzf());
                }
                i8 = zzaduVar2.zzc;
                this.zzo = i8;
                this.zzn = zzaddVar.zzf() + ((long) i8);
                zzahn zzahnVar = this.zzp;
                if (zzahnVar instanceof zzahj) {
                    zzh(this.zzl + ((long) zzaduVar2.zzg));
                    throw null;
                }
                iZzf = this.zzh.zzf(zzaddVar, i8, true);
                if (iZzf == -1) {
                    return -1;
                }
                i = this.zzo - iZzf;
                this.zzo = i;
                if (i <= 0) {
                    zzaei zzaeiVar = this.zzh;
                    long jZzh = zzh(this.zzl);
                    zzadu zzaduVar3 = this.zzb;
                    zzaeiVar.zzt(jZzh, 1, zzaduVar3.zzc, 0, null);
                    this.zzl += (long) zzaduVar3.zzg;
                    this.zzo = 0;
                    return 0;
                }
            }
        } else {
            iZzf = this.zzh.zzf(zzaddVar, i8, true);
            if (iZzf == -1) {
                return -1;
            }
            i = this.zzo - iZzf;
            this.zzo = i;
            if (i <= 0) {
                zzaei zzaeiVar2 = this.zzh;
                long jZzh2 = zzh(this.zzl);
                zzadu zzaduVar4 = this.zzb;
                zzaeiVar2.zzt(jZzh2, 1, zzaduVar4.zzc, 0, null);
                this.zzl += (long) zzaduVar4.zzg;
                this.zzo = 0;
                return 0;
            }
        }
        return 0;
    }

    private final long zzh(long j) {
        return this.zzk + ((j * 1000000) / ((long) this.zzb.zzd));
    }

    private final void zzj() {
        zzahn zzahnVar = this.zzp;
        if ((zzahnVar instanceof zzahi) && zzahnVar.zzh()) {
            long j = this.zzn;
            if (j == -1 || j == this.zzp.zzd()) {
                return;
            }
            this.zzp = ((zzahi) this.zzp).zzf(this.zzn);
            zzadf zzadfVar = this.zzf;
            zzadfVar.getClass();
            zzadfVar.zzP(this.zzp);
            this.zzg.getClass();
            this.zzp.zza();
        }
    }

    private static boolean zzk(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean zzl(zzadd zzaddVar) throws IOException {
        zzahn zzahnVar = this.zzp;
        if (zzahnVar != null) {
            long jZzd = zzahnVar.zzd();
            if (jZzd != -1 && zzaddVar.zze() > jZzd - 4) {
                return true;
            }
        }
        try {
            return !zzaddVar.zzm(this.zza.zzN(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzadd zzaddVar, boolean z) throws IOException {
        int iZze;
        int i;
        int iZzb;
        zzaddVar.zzj();
        if (zzaddVar.zzf() == 0) {
            zzav zzavVarZza = this.zzd.zza(zzaddVar, null);
            this.zzj = zzavVarZza;
            if (zzavVarZza != null) {
                this.zzc.zzb(zzavVarZza);
            }
            iZze = (int) zzaddVar.zze();
            if (!z) {
                zzaddVar.zzk(iZze);
            }
            i = 0;
        } else {
            iZze = 0;
            i = 0;
        }
        int i2 = i;
        int i3 = i2;
        while (true) {
            if (zzl(zzaddVar)) {
                if (i2 > 0) {
                    break;
                }
                zzj();
                throw new EOFException();
            }
            zzek zzekVar = this.zza;
            zzekVar.zzL(0);
            int iZzg = zzekVar.zzg();
            if ((i == 0 || zzk(iZzg, i)) && (iZzb = zzadv.zzb(iZzg)) != -1) {
                i2++;
                if (i2 != 1) {
                    if (i2 == 4) {
                        break;
                    }
                } else {
                    this.zzb.zza(iZzg);
                    i = iZzg;
                }
                zzaddVar.zzg(iZzb - 4);
            } else {
                int i4 = i3 + 1;
                if (i3 == (true != z ? 131072 : 32768)) {
                    if (z) {
                        return false;
                    }
                    zzj();
                    throw new EOFException();
                }
                if (z) {
                    zzaddVar.zzj();
                    zzaddVar.zzg(iZze + i4);
                } else {
                    zzaddVar.zzk(1);
                }
                i = 0;
                i3 = i4;
                i2 = 0;
            }
        }
        if (z) {
            zzaddVar.zzk(iZze + i3);
        } else {
            zzaddVar.zzj();
        }
        this.zzi = i;
        return true;
    }

    public final void zza() {
        this.zzq = true;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        zzdc.zzb(this.zzg);
        int i = zzeu.zza;
        int iZzg = zzg(zzaddVar);
        if (iZzg == -1 && (this.zzp instanceof zzahj)) {
            if (this.zzp.zza() != zzh(this.zzl)) {
                throw null;
            }
        }
        return iZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return zzfww.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        this.zzf = zzadfVar;
        zzaei zzaeiVarZzw = zzadfVar.zzw(0, 1);
        this.zzg = zzaeiVarZzw;
        this.zzh = zzaeiVarZzw;
        this.zzf.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0L;
        this.zzo = 0;
        zzahn zzahnVar = this.zzp;
        if (zzahnVar instanceof zzahj) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        return zzm(zzaddVar, true);
    }
}

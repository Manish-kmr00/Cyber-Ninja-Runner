package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzafq implements zzadc {
    private zzadf zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private zzagt zzg;
    private zzadd zzh;
    private zzaft zzi;
    private zzaiq zzj;
    private final zzek zza = new zzek(6);
    private long zzf = -1;

    private final int zza(zzadd zzaddVar) throws IOException {
        zzek zzekVar = this.zza;
        zzekVar.zzI(2);
        ((zzacr) zzaddVar).zzm(zzekVar.zzN(), 0, 2, false);
        return zzekVar.zzq();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0117  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i;
        String strZzy;
        zzafs zzafsVarZza;
        zzagt zzagtVar;
        long j;
        int i2 = this.zzc;
        if (i2 == 0) {
            zzek zzekVar = this.zza;
            zzekVar.zzI(2);
            zzaddVar.zzi(zzekVar.zzN(), 0, 2);
            int iZzq = zzekVar.zzq();
            this.zzd = iZzq;
            if (iZzq == 65498) {
                if (this.zzf != -1) {
                    this.zzc = 4;
                    return 0;
                }
                zzg();
                return 0;
            }
            if ((iZzq >= 65488 && iZzq <= 65497) || iZzq == 65281) {
                return 0;
            }
            this.zzc = 1;
            return 0;
        }
        if (i2 == 1) {
            zzek zzekVar2 = this.zza;
            zzekVar2.zzI(2);
            zzaddVar.zzi(zzekVar2.zzN(), 0, 2);
            this.zze = zzekVar2.zzq() - 2;
            this.zzc = 2;
            return 0;
        }
        if (i2 != 2) {
            if (i2 != 4) {
                if (i2 != 5) {
                    if (i2 == 6) {
                        return -1;
                    }
                    throw new IllegalStateException();
                }
                if (this.zzi == null || zzaddVar != this.zzh) {
                    this.zzh = zzaddVar;
                    this.zzi = new zzaft(zzaddVar, this.zzf);
                }
                zzaiq zzaiqVar = this.zzj;
                zzaiqVar.getClass();
                int iZzb = zzaiqVar.zzb(this.zzi, zzadyVar);
                if (iZzb == 1) {
                    zzadyVar.zza += this.zzf;
                }
                return iZzb;
            }
            long jZzf = zzaddVar.zzf();
            long j2 = this.zzf;
            if (jZzf != j2) {
                zzadyVar.zza = j2;
                return 1;
            }
            if (zzaddVar.zzm(this.zza.zzN(), 0, 1, true)) {
                zzaddVar.zzj();
                if (this.zzj == null) {
                    this.zzj = new zzaiq(zzajy.zza, 8);
                }
                zzaft zzaftVar = new zzaft(zzaddVar, this.zzf);
                this.zzi = zzaftVar;
                if (this.zzj.zzi(zzaftVar)) {
                    zzaiq zzaiqVar2 = this.zzj;
                    long j3 = this.zzf;
                    zzadf zzadfVar = this.zzb;
                    zzadfVar.getClass();
                    zzaiqVar2.zze(new zzafv(j3, zzadfVar));
                    zzagt zzagtVar2 = this.zzg;
                    zzagtVar2.getClass();
                    zzadf zzadfVar2 = this.zzb;
                    zzadfVar2.getClass();
                    zzaei zzaeiVarZzw = zzadfVar2.zzw(1024, 4);
                    zzx zzxVar = new zzx();
                    zzxVar.zzE("image/jpeg");
                    zzxVar.zzW(new zzav(-9223372036854775807L, zzagtVar2));
                    zzaeiVarZzw.zzm(zzxVar.zzaj());
                    this.zzc = 5;
                } else {
                    zzg();
                }
            } else {
                zzg();
            }
            return 0;
        }
        if (this.zzd == 65505) {
            zzek zzekVar3 = new zzek(this.zze);
            zzaddVar.zzi(zzekVar3.zzN(), 0, this.zze);
            if (this.zzg == null && "http://ns.adobe.com/xap/1.0/".equals(zzekVar3.zzy((char) 0)) && (strZzy = zzekVar3.zzy((char) 0)) != null) {
                long jZzd = zzaddVar.zzd();
                if (jZzd == -1 || (zzafsVarZza = zzafw.zza(strZzy)) == null) {
                    zzagtVar = null;
                } else {
                    List list = zzafsVarZza.zzb;
                    if (list.size() < 2) {
                        zzagtVar = null;
                    } else {
                        int size = list.size() - 1;
                        long j4 = -1;
                        long j5 = -1;
                        long j6 = -1;
                        long j7 = -1;
                        boolean z = false;
                        while (size >= 0) {
                            zzafr zzafrVar = (zzafr) list.get(size);
                            boolean zEquals = "video/mp4".equals(zzafrVar.zza) | z;
                            if (size == 0) {
                                jZzd -= zzafrVar.zzc;
                                j = 0;
                            } else {
                                j = jZzd - zzafrVar.zzb;
                            }
                            long j8 = jZzd;
                            jZzd = j;
                            if (zEquals && jZzd != j8) {
                                j7 = j8 - jZzd;
                                j6 = jZzd;
                                zEquals = false;
                            }
                            if (size == 0) {
                                j5 = j8;
                            }
                            if (size == 0) {
                                j4 = jZzd;
                            }
                            size--;
                            z = zEquals;
                        }
                        if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
                            zzagtVar = null;
                        } else {
                            zzagtVar = new zzagt(j4, j5, zzafsVarZza.zza, j6, j7);
                        }
                    }
                }
                this.zzg = zzagtVar;
                if (zzagtVar != null) {
                    this.zzf = zzagtVar.zzd;
                }
            } else {
                i = 0;
            }
            this.zzc = i;
            return i;
        }
        zzaddVar.zzk(this.zze);
        i = 0;
        this.zzc = i;
        return i;
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
        this.zzb = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        if (zza(zzaddVar) != 65496) {
            return false;
        }
        int iZza = zza(zzaddVar);
        this.zzd = iZza;
        if (iZza == 65504) {
            zzek zzekVar = this.zza;
            zzekVar.zzI(2);
            zzacr zzacrVar = (zzacr) zzaddVar;
            zzacrVar.zzm(zzekVar.zzN(), 0, 2, false);
            zzacrVar.zzl(zzekVar.zzq() - 2, false);
            iZza = zza(zzaddVar);
            this.zzd = iZza;
        }
        if (iZza == 65505) {
            zzacr zzacrVar2 = (zzacr) zzaddVar;
            zzacrVar2.zzl(2, false);
            zzek zzekVar2 = this.zza;
            zzekVar2.zzI(6);
            zzacrVar2.zzm(zzekVar2.zzN(), 0, 6, false);
            if (zzekVar2.zzu() == 1165519206 && zzekVar2.zzq() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzaiq zzaiqVar = this.zzj;
            zzaiqVar.getClass();
            zzaiqVar.zzf(j, j2);
        }
    }

    private final void zzg() {
        zzadf zzadfVar = this.zzb;
        zzadfVar.getClass();
        zzadfVar.zzG();
        this.zzb.zzP(new zzaea(-9223372036854775807L, 0L));
        this.zzc = 6;
    }
}

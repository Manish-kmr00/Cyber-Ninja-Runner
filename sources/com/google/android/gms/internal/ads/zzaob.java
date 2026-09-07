package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaob implements zzadc {
    private zzadf zza;
    private zzaei zzb;
    private zzanz zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    /* JADX WARN: Code duplicated, block: B:47:0x00f6  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i;
        zzdc.zzb(this.zzb);
        int i2 = zzeu.zza;
        int i3 = this.zzc;
        int iZzn = 4;
        if (i3 == 0) {
            zzdc.zzf(zzaddVar.zzf() == 0);
            int i4 = this.zzf;
            if (i4 != -1) {
                zzaddVar.zzk(i4);
                this.zzc = 4;
            } else {
                if (!zzaoe.zzc(zzaddVar)) {
                    throw zzaz.zza("Unsupported or unrecognized wav file type.", null);
                }
                zzaddVar.zzk((int) (zzaddVar.zze() - zzaddVar.zzf()));
                this.zzc = 1;
            }
            return 0;
        }
        long jZzr = -1;
        if (i3 == 1) {
            zzek zzekVar = new zzek(8);
            zzaod zzaodVarZza = zzaod.zza(zzaddVar, zzekVar);
            if (zzaodVarZza.zza != 1685272116) {
                zzaddVar.zzj();
            } else {
                zzaddVar.zzg(8);
                zzekVar.zzL(0);
                zzaddVar.zzh(zzekVar.zzN(), 0, 8);
                jZzr = zzekVar.zzr();
                zzaddVar.zzk(((int) zzaodVarZza.zzb) + 8);
            }
            this.zzd = jZzr;
            this.zzc = 2;
            return 0;
        }
        if (i3 == 2) {
            zzaoc zzaocVarZzb = zzaoe.zzb(zzaddVar);
            int i5 = zzaocVarZzb.zza;
            if (i5 == 17) {
                this.zze = new zzany(this.zza, this.zzb, zzaocVarZzb);
            } else if (i5 == 6) {
                this.zze = new zzaoa(this.zza, this.zzb, zzaocVarZzb, "audio/g711-alaw", -1);
            } else if (i5 == 7) {
                this.zze = new zzaoa(this.zza, this.zzb, zzaocVarZzb, "audio/g711-mlaw", -1);
            } else {
                int i6 = zzaocVarZzb.zze;
                if (i5 == 1) {
                    iZzn = zzeu.zzn(i6);
                    i = iZzn;
                } else {
                    if (i5 != 3) {
                        if (i5 == 65534) {
                            iZzn = zzeu.zzn(i6);
                            i = iZzn;
                        }
                    } else if (i6 == 32) {
                        i = iZzn;
                    }
                    i = 0;
                }
                if (i == 0) {
                    throw zzaz.zzc("Unsupported WAV format type: " + i5);
                }
                this.zze = new zzaoa(this.zza, this.zzb, zzaocVarZzb, "audio/raw", i);
            }
            this.zzc = 3;
            return 0;
        }
        if (i3 != 3) {
            zzdc.zzf(this.zzg != -1);
            long jZzf = this.zzg - zzaddVar.zzf();
            zzanz zzanzVar = this.zze;
            zzanzVar.getClass();
            return zzanzVar.zzc(zzaddVar, jZzf) ? -1 : 0;
        }
        Pair pairZza = zzaoe.zza(zzaddVar);
        this.zzf = ((Long) pairZza.first).intValue();
        long jLongValue = ((Long) pairZza.second).longValue();
        long j = this.zzd;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzf) + jLongValue;
        this.zzg = j2;
        long jZzd = zzaddVar.zzd();
        if (jZzd != -1 && j2 > jZzd) {
            zzdx.zzf("WavExtractor", "Data exceeds input length: " + j2 + ", " + jZzd);
            this.zzg = jZzd;
            j2 = jZzd;
        }
        zzanz zzanzVar2 = this.zze;
        zzanzVar2.getClass();
        zzanzVar2.zza(this.zzf, j2);
        this.zzc = 4;
        return 0;
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
        this.zza = zzadfVar;
        this.zzb = zzadfVar.zzw(0, 1);
        zzadfVar.zzG();
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzanz zzanzVar = this.zze;
        if (zzanzVar != null) {
            zzanzVar.zzb(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        return zzaoe.zzc(zzaddVar);
    }
}

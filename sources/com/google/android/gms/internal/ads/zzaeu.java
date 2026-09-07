package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaeu implements zzadc {
    private final zzek zza;
    private final zzaes zzb;
    private final boolean zzc;
    private final zzajy zzd;
    private int zze;
    private zzadf zzf;
    private zzaev zzg;
    private long zzh;
    private zzaex[] zzi;
    private long zzj;
    private zzaex zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaeu() {
        this(1, zzajy.zza);
    }

    private final zzaex zzg(int i) {
        for (zzaex zzaexVar : this.zzi) {
            if (zzaexVar.zzf(i)) {
                return zzaexVar;
            }
        }
        return null;
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
        this.zze = 0;
        if (this.zzc) {
            zzadfVar = new zzakb(zzadfVar, this.zzd);
        }
        this.zzf = zzadfVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzaex zzaexVar : this.zzi) {
            zzaexVar.zze(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzek zzekVar = this.zza;
        zzaddVar.zzh(zzekVar.zzN(), 0, 12);
        zzekVar.zzL(0);
        if (zzekVar.zzi() != 1179011410) {
            return false;
        }
        zzekVar.zzM(4);
        return zzekVar.zzi() == 541677121;
    }

    public zzaeu(int i, zzajy zzajyVar) {
        this.zzd = zzajyVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzek(12);
        this.zzb = new zzaes(null);
        this.zzf = new zzadw();
        this.zzi = new zzaex[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        boolean z;
        long j;
        long j2 = this.zzj;
        if (j2 != -1) {
            long jZzf = zzaddVar.zzf();
            if (j2 < jZzf || j2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + jZzf) {
                zzadyVar.zza = j2;
                z = true;
            } else {
                zzaddVar.zzk((int) (j2 - jZzf));
                z = false;
            }
        } else {
            z = false;
        }
        this.zzj = -1L;
        if (z) {
            return 1;
        }
        int i = this.zze;
        zzaex zzaexVar = null;
        if (i == 0) {
            if (!zzi(zzaddVar)) {
                throw zzaz.zza("AVI Header List not found", null);
            }
            zzaddVar.zzk(12);
            this.zze = 1;
            return 0;
        }
        if (i == 1) {
            zzek zzekVar = this.zza;
            zzaddVar.zzi(zzekVar.zzN(), 0, 12);
            zzekVar.zzL(0);
            zzaes zzaesVar = this.zzb;
            zzaesVar.zza(zzekVar);
            int i2 = zzaesVar.zza;
            if (i2 != 1414744396) {
                throw zzaz.zza("LIST expected, found: " + i2, null);
            }
            int iZzi = zzekVar.zzi();
            if (iZzi == 1819436136) {
                this.zzl = zzaesVar.zzb;
                this.zze = 2;
                return 0;
            }
            throw zzaz.zza("hdrl expected, found: " + iZzi, null);
        }
        if (i == 2) {
            int i3 = this.zzl - 4;
            zzek zzekVar2 = new zzek(i3);
            zzaddVar.zzi(zzekVar2.zzN(), 0, i3);
            zzaey zzaeyVarZzc = zzaey.zzc(1819436136, zzekVar2);
            if (zzaeyVarZzc.zza() != 1819436136) {
                throw zzaz.zza("Unexpected header list type " + zzaeyVarZzc.zza(), null);
            }
            zzaev zzaevVar = (zzaev) zzaeyVarZzc.zzb(zzaev.class);
            if (zzaevVar == null) {
                throw zzaz.zza("AviHeader not found", null);
            }
            this.zzg = zzaevVar;
            this.zzh = ((long) zzaevVar.zzc) * ((long) zzaevVar.zza);
            ArrayList arrayList = new ArrayList();
            zzfww zzfwwVar = zzaeyVarZzc.zza;
            int size = zzfwwVar.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                zzaeq zzaeqVar = (zzaeq) zzfwwVar.get(i4);
                if (zzaeqVar.zza() == 1819440243) {
                    zzaey zzaeyVar = (zzaey) zzaeqVar;
                    int i6 = i5 + 1;
                    zzaew zzaewVar = (zzaew) zzaeyVar.zzb(zzaew.class);
                    zzaez zzaezVar = (zzaez) zzaeyVar.zzb(zzaez.class);
                    if (zzaewVar == null) {
                        zzdx.zzf("AviExtractor", "Missing Stream Header");
                    } else if (zzaezVar == null) {
                        zzdx.zzf("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzc = zzaewVar.zzc();
                        zzz zzzVar = zzaezVar.zza;
                        zzx zzxVarZzb = zzzVar.zzb();
                        zzxVarZzb.zzN(i5);
                        int i7 = zzaewVar.zze;
                        if (i7 != 0) {
                            zzxVarZzb.zzT(i7);
                        }
                        zzafa zzafaVar = (zzafa) zzaeyVar.zzb(zzafa.class);
                        if (zzafaVar != null) {
                            zzxVarZzb.zzQ(zzafaVar.zza);
                        }
                        int iZzb = zzay.zzb(zzzVar.zzo);
                        if (iZzb == 1) {
                            zzaei zzaeiVarZzw = this.zzf.zzw(i5, iZzb);
                            zzaeiVarZzw.zzm(zzxVarZzb.zzaj());
                            zzaeiVarZzw.zzl(jZzc);
                            this.zzh = Math.max(this.zzh, jZzc);
                            zzaexVar = new zzaex(i5, zzaewVar, zzaeiVarZzw);
                        } else if (iZzb == 2) {
                            iZzb = 2;
                            zzaei zzaeiVarZzw2 = this.zzf.zzw(i5, iZzb);
                            zzaeiVarZzw2.zzm(zzxVarZzb.zzaj());
                            zzaeiVarZzw2.zzl(jZzc);
                            this.zzh = Math.max(this.zzh, jZzc);
                            zzaexVar = new zzaex(i5, zzaewVar, zzaeiVarZzw2);
                        } else {
                            zzaexVar = null;
                        }
                    }
                    if (zzaexVar != null) {
                        arrayList.add(zzaexVar);
                    }
                    i5 = i6;
                }
                i4++;
                zzaexVar = null;
            }
            this.zzi = (zzaex[]) arrayList.toArray(new zzaex[0]);
            this.zzf.zzG();
            this.zze = 3;
            return 0;
        }
        if (i == 3) {
            long j3 = this.zzm;
            if (j3 != -1 && zzaddVar.zzf() != j3) {
                this.zzj = j3;
                return 0;
            }
            zzek zzekVar3 = this.zza;
            zzaddVar.zzh(zzekVar3.zzN(), 0, 12);
            zzaddVar.zzj();
            zzekVar3.zzL(0);
            zzaes zzaesVar2 = this.zzb;
            zzaesVar2.zza(zzekVar3);
            int iZzi2 = zzekVar3.zzi();
            int i8 = zzaesVar2.zza;
            if (i8 == 1179011410) {
                zzaddVar.zzk(12);
                return 0;
            }
            if (i8 != 1414744396 || iZzi2 != 1769369453) {
                this.zzj = zzaddVar.zzf() + ((long) zzaesVar2.zzb) + 8;
                return 0;
            }
            long jZzf2 = zzaddVar.zzf();
            this.zzm = jZzf2;
            long j4 = jZzf2 + ((long) zzaesVar2.zzb) + 8;
            this.zzn = j4;
            if (!this.zzp) {
                zzaev zzaevVar2 = this.zzg;
                zzaevVar2.getClass();
                if ((zzaevVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j4;
                    return 0;
                }
                this.zzf.zzP(new zzaea(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzaddVar.zzf() + 12;
            this.zze = 6;
            return 0;
        }
        if (i == 4) {
            zzek zzekVar4 = this.zza;
            zzaddVar.zzi(zzekVar4.zzN(), 0, 8);
            zzekVar4.zzL(0);
            int iZzi3 = zzekVar4.zzi();
            int iZzi4 = zzekVar4.zzi();
            if (iZzi3 == 829973609) {
                this.zze = 5;
                this.zzo = iZzi4;
            } else {
                this.zzj = zzaddVar.zzf() + ((long) iZzi4);
            }
            return 0;
        }
        if (i == 5) {
            zzek zzekVar5 = new zzek(this.zzo);
            zzaddVar.zzi(zzekVar5.zzN(), 0, this.zzo);
            if (zzekVar5.zza() < 16) {
                j = 0;
            } else {
                int iZzc = zzekVar5.zzc();
                zzekVar5.zzM(8);
                long jZzi = zzekVar5.zzi();
                long j5 = this.zzm;
                j = jZzi > j5 ? 0L : j5 + 8;
                zzekVar5.zzL(iZzc);
            }
            while (zzekVar5.zza() >= 16) {
                int iZzi5 = zzekVar5.zzi();
                int iZzi6 = zzekVar5.zzi();
                long jZzi2 = ((long) zzekVar5.zzi()) + j;
                zzekVar5.zzM(4);
                zzaex zzaexVarZzg = zzg(iZzi5);
                if (zzaexVarZzg != null) {
                    zzaexVarZzg.zzb(jZzi2, (iZzi6 & 16) == 16);
                }
            }
            for (zzaex zzaexVar2 : this.zzi) {
                zzaexVar2.zzc();
            }
            this.zzp = true;
            if (this.zzi.length == 0) {
                this.zzf.zzP(new zzaea(this.zzh, 0L));
            } else {
                this.zzf.zzP(new zzaer(this, this.zzh));
            }
            this.zze = 6;
            this.zzj = this.zzm;
            return 0;
        }
        if (zzaddVar.zzf() >= this.zzn) {
            return -1;
        }
        zzaex zzaexVar3 = this.zzk;
        if (zzaexVar3 != null) {
            if (!zzaexVar3.zzg(zzaddVar)) {
                return 0;
            }
            this.zzk = null;
            return 0;
        }
        if ((zzaddVar.zzf() & 1) == 1) {
            zzaddVar.zzk(1);
        }
        zzek zzekVar6 = this.zza;
        zzaddVar.zzh(zzekVar6.zzN(), 0, 12);
        zzekVar6.zzL(0);
        int iZzi7 = zzekVar6.zzi();
        if (iZzi7 == 1414744396) {
            zzekVar6.zzL(8);
            zzaddVar.zzk(zzekVar6.zzi() != 1769369453 ? 8 : 12);
            zzaddVar.zzj();
            return 0;
        }
        int iZzi8 = zzekVar6.zzi();
        if (iZzi7 == 1263424842) {
            this.zzj = zzaddVar.zzf() + ((long) iZzi8) + 8;
            return 0;
        }
        zzaddVar.zzk(8);
        zzaddVar.zzj();
        zzaex zzaexVarZzg2 = zzg(iZzi7);
        if (zzaexVarZzg2 == null) {
            this.zzj = zzaddVar.zzf() + ((long) iZzi8);
            return 0;
        }
        zzaexVarZzg2.zzd(iZzi8);
        this.zzk = zzaexVarZzg2;
        return 0;
    }
}

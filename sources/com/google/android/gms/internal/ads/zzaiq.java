package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.2.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaiq implements zzadc, zzaeb {
    private long zzA;
    private int zzB;
    private zzagt zzC;
    private final zzajy zza;
    private final int zzb;
    private final zzek zzc;
    private final zzek zzd;
    private final zzek zze;
    private final zzek zzf;
    private final ArrayDeque zzg;
    private final zzaiu zzh;
    private final List zzi;
    private zzfww zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzek zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private long zzv;
    private zzadf zzw;
    private zzaip[] zzx;
    private long[][] zzy;
    private int zzz;

    @Deprecated
    public zzaiq() {
        this(zzajy.zza, 16);
    }

    private static int zzj(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzk(zzaiz zzaizVar, long j) {
        int iZza = zzaizVar.zza(j);
        return iZza == -1 ? zzaizVar.zzb(j) : iZza;
    }

    private static long zzl(zzaiz zzaizVar, long j, long j2) {
        int iZzk = zzk(zzaizVar, j);
        return iZzk == -1 ? j2 : Math.min(zzaizVar.zzc[iZzk], j2);
    }

    private final void zzm() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzn(long j) throws zzaz {
        zzav zzavVar;
        long j2;
        int i;
        zzadq zzadqVar;
        zzav zzavVar2;
        int i2;
        ArrayList arrayList;
        while (true) {
            ArrayDeque arrayDeque = this.zzg;
            if (arrayDeque.isEmpty() || ((zzex) arrayDeque.peek()).zza != j) {
                break;
            }
            zzex zzexVar = (zzex) arrayDeque.pop();
            if (zzexVar.zzd == 1836019574) {
                zzex zzexVarZza = zzexVar.zza(1835365473);
                new ArrayList();
                zzav zzavVarZzb = zzexVarZza != null ? zzaie.zzb(zzexVarZza) : null;
                ArrayList arrayList2 = new ArrayList();
                boolean z = this.zzB == 1;
                zzadq zzadqVar2 = new zzadq();
                zzey zzeyVarZzb = zzexVar.zzb(1969517665);
                if (zzeyVarZzb != null) {
                    zzav zzavVarZzc = zzaie.zzc(zzeyVarZzb);
                    zzadqVar2.zzb(zzavVarZzc);
                    zzavVar = zzavVarZzc;
                } else {
                    zzavVar = null;
                }
                zzey zzeyVarZzb2 = zzexVar.zzb(1836476516);
                zzeyVarZzb2.getClass();
                zzav zzavVar3 = new zzav(-9223372036854775807L, zzaie.zzd(zzeyVarZzb2.zza));
                int i3 = this.zzb;
                ArrayList arrayList3 = arrayList2;
                zzadq zzadqVar3 = zzadqVar2;
                List listZzf = zzaie.zzf(zzexVar, zzadqVar2, -9223372036854775807L, null, 1 == (i3 & 1), z, new zzftl() { // from class: com.google.android.gms.internal.ads.zzaio
                    @Override // com.google.android.gms.internal.ads.zzftl
                    public final Object apply(Object obj) {
                        return (zzaiw) obj;
                    }
                });
                String strZza = zzain.zza(listZzf);
                long j3 = -9223372036854775807L;
                int i4 = 0;
                int i5 = 0;
                int size = -1;
                while (true) {
                    j2 = 0;
                    if (i4 >= listZzf.size()) {
                        break;
                    }
                    zzaiz zzaizVar = (zzaiz) listZzf.get(i4);
                    int i6 = zzaizVar.zzb;
                    if (i6 == 0) {
                        i = i5;
                        zzadqVar = zzadqVar3;
                        arrayList = arrayList3;
                    } else {
                        zzaiw zzaiwVar = zzaizVar.zza;
                        zzadf zzadfVar = this.zzw;
                        int i7 = i5 + 1;
                        int i8 = zzaiwVar.zzb;
                        zzaip zzaipVar = new zzaip(zzaiwVar, zzaizVar, zzadfVar.zzw(i5, i8));
                        long j4 = zzaiwVar.zze;
                        if (j4 == -9223372036854775807L) {
                            j4 = zzaizVar.zzh;
                        }
                        i = i7;
                        zzaei zzaeiVar = zzaipVar.zzc;
                        zzaeiVar.zzl(j4);
                        long jMax = Math.max(j3, j4);
                        zzz zzzVar = zzaiwVar.zzg;
                        int i9 = "audio/true-hd".equals(zzzVar.zzo) ? zzaizVar.zze * 16 : zzaizVar.zze + 30;
                        zzx zzxVarZzb = zzzVar.zzb();
                        zzxVarZzb.zzT(i9);
                        if (i8 == 2) {
                            int i10 = zzzVar.zzf;
                            if ((i3 & 8) != 0) {
                                i10 |= size == -1 ? 1 : 2;
                            }
                            if (zzzVar.zzx == -1.0f && j4 > 0) {
                                zzxVarZzb.zzK(i6 / (j4 / 1000000.0f));
                            }
                            zzxVarZzb.zzab(i10);
                            i8 = 2;
                        }
                        if (i8 == 1 && zzadqVar3.zza()) {
                            zzadqVar = zzadqVar3;
                            zzxVarZzb.zzI(zzadqVar.zza);
                            zzxVarZzb.zzJ(zzadqVar.zzb);
                        } else {
                            zzadqVar = zzadqVar3;
                        }
                        List list = this.zzi;
                        zzav[] zzavVarArr = new zzav[3];
                        if (list.isEmpty()) {
                            i2 = 0;
                            zzavVar2 = null;
                        } else {
                            zzavVar2 = new zzav(list);
                            i2 = 0;
                        }
                        zzavVarArr[i2] = zzavVar2;
                        zzavVarArr[1] = zzavVar;
                        zzavVarArr[2] = zzavVar3;
                        zzav zzavVar4 = new zzav(-9223372036854775807L, new zzau[i2]);
                        if (zzavVarZzb != null) {
                            for (int i11 = 0; i11 < zzavVarZzb.zza(); i11++) {
                                zzau zzauVarZzb = zzavVarZzb.zzb(i11);
                                if (zzauVarZzb instanceof zzew) {
                                    zzew zzewVar = (zzew) zzauVarZzb;
                                    if (!zzewVar.zza.equals("com.android.capture.fps")) {
                                        zzavVar4 = zzavVar4.zzc(zzewVar);
                                    } else if (i8 == 2) {
                                        zzavVar4 = zzavVar4.zzc(zzewVar);
                                    }
                                }
                            }
                        }
                        for (int i12 = 0; i12 < 3; i12++) {
                            zzavVar4 = zzavVar4.zzd(zzavVarArr[i12]);
                        }
                        if (zzavVar4.zza() > 0) {
                            zzxVarZzb.zzW(zzavVar4);
                        }
                        zzxVarZzb.zzE(strZza);
                        zzaeiVar.zzm(zzxVarZzb.zzaj());
                        if (i8 == 2 && size == -1) {
                            size = arrayList3.size();
                        }
                        arrayList = arrayList3;
                        arrayList.add(zzaipVar);
                        j3 = jMax;
                    }
                    i4++;
                    zzadqVar3 = zzadqVar;
                    arrayList3 = arrayList;
                    listZzf = listZzf;
                    i5 = i;
                }
                this.zzz = size;
                this.zzA = j3;
                zzaip[] zzaipVarArr = (zzaip[]) arrayList3.toArray(new zzaip[0]);
                this.zzx = zzaipVarArr;
                int length = zzaipVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i13 = 0; i13 < zzaipVarArr.length; i13++) {
                    jArr[i13] = new long[zzaipVarArr[i13].zzb.zzb];
                    jArr2[i13] = zzaipVarArr[i13].zzb.zzf[0];
                }
                int i14 = 0;
                while (i14 < zzaipVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i15 = -1;
                    for (int i16 = 0; i16 < zzaipVarArr.length; i16++) {
                        if (!zArr[i16]) {
                            long j6 = jArr2[i16];
                            if (j6 <= j5) {
                                i15 = i16;
                                j5 = j6;
                            }
                        }
                    }
                    int i17 = iArr[i15];
                    long[] jArr3 = jArr[i15];
                    jArr3[i17] = j2;
                    zzaiz zzaizVar2 = zzaipVarArr[i15].zzb;
                    j2 += (long) zzaizVar2.zzd[i17];
                    int i18 = i17 + 1;
                    iArr[i15] = i18;
                    if (i18 < jArr3.length) {
                        jArr2[i15] = zzaizVar2.zzf[i18];
                    } else {
                        zArr[i15] = true;
                        i14++;
                    }
                }
                this.zzy = jArr;
                this.zzw.zzG();
                this.zzw.zzP(this);
                arrayDeque.clear();
                this.zzk = 2;
            } else if (!arrayDeque.isEmpty()) {
                ((zzex) arrayDeque.peek()).zzc(zzexVar);
            }
        }
        if (this.zzk != 2) {
            zzm();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final long zza() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ zzadc zzc() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zze(zzadf zzadfVar) {
        if ((this.zzb & 16) == 0) {
            zzadfVar = new zzakb(zzadfVar, this.zza);
        }
        this.zzw = zzadfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final void zzf(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = false;
        if (j == 0) {
            if (this.zzk != 3) {
                zzm();
                return;
            } else {
                this.zzh.zzb();
                this.zzi.clear();
                return;
            }
        }
        for (zzaip zzaipVar : this.zzx) {
            zzaiz zzaizVar = zzaipVar.zzb;
            int iZza = zzaizVar.zza(j2);
            if (iZza == -1) {
                iZza = zzaizVar.zzb(j2);
            }
            zzaipVar.zze = iZza;
            zzaej zzaejVar = zzaipVar.zzd;
            if (zzaejVar != null) {
                zzaejVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final zzadz zzg(long j) {
        long j2;
        long j3;
        long jZzl;
        long j4;
        int iZzb;
        long j5 = j;
        zzaip[] zzaipVarArr = this.zzx;
        if (zzaipVarArr.length == 0) {
            zzaec zzaecVar = zzaec.zza;
            return new zzadz(zzaecVar, zzaecVar);
        }
        int i = this.zzz;
        if (i != -1) {
            zzaiz zzaizVar = zzaipVarArr[i].zzb;
            int iZzk = zzk(zzaizVar, j5);
            if (iZzk == -1) {
                zzaec zzaecVar2 = zzaec.zza;
                return new zzadz(zzaecVar2, zzaecVar2);
            }
            long[] jArr = zzaizVar.zzf;
            long j6 = jArr[iZzk];
            long[] jArr2 = zzaizVar.zzc;
            j2 = jArr2[iZzk];
            if (j6 >= j5 || iZzk >= zzaizVar.zzb - 1 || (iZzb = zzaizVar.zzb(j5)) == -1 || iZzb == iZzk) {
                j4 = -9223372036854775807L;
                jZzl = -1;
            } else {
                j4 = jArr[iZzb];
                jZzl = jArr2[iZzb];
            }
            j3 = j4;
            j5 = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
            jZzl = -1;
        }
        int i2 = 0;
        while (true) {
            zzaip[] zzaipVarArr2 = this.zzx;
            if (i2 >= zzaipVarArr2.length) {
                break;
            }
            if (i2 != this.zzz) {
                zzaiz zzaizVar2 = zzaipVarArr2[i2].zzb;
                long jZzl2 = zzl(zzaizVar2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jZzl = zzl(zzaizVar2, j3, jZzl);
                }
                j2 = jZzl2;
            }
            i2++;
        }
        zzaec zzaecVar3 = new zzaec(j5, j2);
        return j3 == -9223372036854775807L ? new zzadz(zzaecVar3, zzaecVar3) : new zzadz(zzaecVar3, new zzaec(j3, jZzl));
    }

    @Override // com.google.android.gms.internal.ads.zzaeb
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final boolean zzi(zzadd zzaddVar) throws IOException {
        zzaef zzaefVarZzb = zzaiv.zzb(zzaddVar, (this.zzb & 2) != 0);
        this.zzj = zzaefVarZzb != null ? zzfww.zzo(zzaefVarZzb) : zzfww.zzn();
        return zzaefVarZzb == null;
    }

    public zzaiq(zzajy zzajyVar, int i) {
        this.zza = zzajyVar;
        this.zzb = i;
        this.zzj = zzfww.zzn();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzaiu();
        this.zzi = new ArrayList();
        this.zzf = new zzek(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzek(zzfq.zza);
        this.zzd = new zzek(6);
        this.zze = new zzek();
        this.zzp = -1;
        this.zzw = zzadf.zza;
        this.zzx = new zzaip[0];
    }

    /* JADX WARN: Code duplicated, block: B:299:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:302:0x017b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:0x0199 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0082  */
    /* JADX WARN: Code duplicated, block: B:38:0x0091  */
    /* JADX WARN: Code duplicated, block: B:77:0x0156  */
    /* JADX WARN: Code duplicated, block: B:79:0x0169  */
    /* JADX WARN: Code duplicated, block: B:81:0x0177  */
    @Override // com.google.android.gms.internal.ads.zzadc
    public final int zzb(zzadd zzaddVar, zzady zzadyVar) throws IOException {
        int i;
        int i2;
        int iZzb;
        int iZzg;
        boolean z;
        boolean z2;
        while (true) {
            int i3 = this.zzk;
            if (i3 == 0) {
                if (this.zzn == 0) {
                    zzek zzekVar = this.zzf;
                    if (!zzaddVar.zzn(zzekVar.zzN(), 0, 8, true)) {
                        if (this.zzB != 2 || (this.zzb & 2) == 0) {
                            return -1;
                        }
                        zzaei zzaeiVarZzw = this.zzw.zzw(0, 4);
                        zzagt zzagtVar = this.zzC;
                        zzav zzavVar = zzagtVar == null ? null : new zzav(-9223372036854775807L, zzagtVar);
                        zzx zzxVar = new zzx();
                        zzxVar.zzW(zzavVar);
                        zzaeiVarZzw.zzm(zzxVar.zzaj());
                        this.zzw.zzG();
                        this.zzw.zzP(new zzaea(-9223372036854775807L, 0L));
                        return -1;
                    }
                    this.zzn = 8;
                    zzekVar.zzL(0);
                    this.zzm = zzekVar.zzu();
                    this.zzl = zzekVar.zzg();
                }
                long j = this.zzm;
                if (j == 1) {
                    zzek zzekVar2 = this.zzf;
                    zzaddVar.zzi(zzekVar2.zzN(), 8, 8);
                    this.zzn += 8;
                    this.zzm = zzekVar2.zzw();
                } else if (j == 0) {
                    long jZzd = zzaddVar.zzd();
                    if (jZzd == -1) {
                        zzex zzexVar = (zzex) this.zzg.peek();
                        jZzd = zzexVar != null ? zzexVar.zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzm = (jZzd - zzaddVar.zzf()) + ((long) this.zzn);
                    }
                }
                long j2 = this.zzm;
                int i4 = this.zzn;
                if (j2 < i4) {
                    throw zzaz.zzc("Atom size less than header length (unsupported).");
                }
                int i5 = this.zzl;
                if (i5 == 1836019574 || i5 == 1953653099 || i5 == 1835297121 || i5 == 1835626086 || i5 == 1937007212 || i5 == 1701082227 || i5 == 1835365473 || i5 == 1635284069) {
                    long jZzf = zzaddVar.zzf();
                    long j3 = this.zzm;
                    long j4 = jZzf + j3;
                    long j5 = this.zzn;
                    if (j3 != j5 && this.zzl == 1835365473) {
                        zzek zzekVar3 = this.zze;
                        zzekVar3.zzI(8);
                        zzaddVar.zzh(zzekVar3.zzN(), 0, 8);
                        zzaie.zzg(zzekVar3);
                        zzaddVar.zzk(zzekVar3.zzc());
                        zzaddVar.zzj();
                    }
                    long j6 = j4 - j5;
                    this.zzg.push(new zzex(this.zzl, j6));
                    if (this.zzm == this.zzn) {
                        zzn(j6);
                    } else {
                        zzm();
                    }
                } else if (i5 == 1835296868 || i5 == 1836476516 || i5 == 1751411826 || i5 == 1937011556 || i5 == 1937011827 || i5 == 1937011571 || i5 == 1668576371 || i5 == 1701606260 || i5 == 1937011555 || i5 == 1937011578 || i5 == 1937013298 || i5 == 1937007471 || i5 == 1668232756 || i5 == 1953196132 || i5 == 1718909296 || i5 == 1969517665 || i5 == 1801812339 || i5 == 1768715124) {
                    zzdc.zzf(i4 == 8);
                    zzdc.zzf(this.zzm <= 2147483647L);
                    zzek zzekVar4 = new zzek((int) this.zzm);
                    System.arraycopy(this.zzf.zzN(), 0, zzekVar4.zzN(), 0, 8);
                    this.zzo = zzekVar4;
                    this.zzk = 1;
                } else {
                    long jZzf2 = zzaddVar.zzf();
                    long j7 = this.zzn;
                    long j8 = jZzf2 - j7;
                    if (this.zzl == 1836086884) {
                        this.zzC = new zzagt(0L, j8, -9223372036854775807L, j8 + j7, this.zzm - j7);
                    }
                    this.zzo = null;
                    this.zzk = 1;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.zzh.zza(zzaddVar, zzadyVar, this.zzi);
                        if (zzadyVar.zza == 0) {
                            zzm();
                        }
                        return 1;
                    }
                    long jZzf3 = zzaddVar.zzf();
                    int i6 = this.zzp;
                    if (i6 == -1) {
                        int i7 = -1;
                        int i8 = -1;
                        boolean z3 = true;
                        boolean z4 = true;
                        long j9 = Long.MAX_VALUE;
                        long j10 = Long.MAX_VALUE;
                        long j11 = Long.MAX_VALUE;
                        int i9 = 0;
                        while (true) {
                            zzaip[] zzaipVarArr = this.zzx;
                            if (i9 >= zzaipVarArr.length) {
                                break;
                            }
                            zzaip zzaipVar = zzaipVarArr[i9];
                            int i10 = zzaipVar.zze;
                            zzaiz zzaizVar = zzaipVar.zzb;
                            if (i10 != zzaizVar.zzb) {
                                long j12 = zzaizVar.zzc[i10];
                                long[][] jArr = this.zzy;
                                int i11 = zzeu.zza;
                                long j13 = jArr[i9][i10];
                                long j14 = j12 - jZzf3;
                                boolean z5 = j14 < 0 || j14 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                if (z5) {
                                    z = z4;
                                } else {
                                    if (z4) {
                                        z4 = z5;
                                        j10 = j13;
                                        i8 = i9;
                                        j11 = j14;
                                    } else {
                                        z = false;
                                    }
                                    if (j13 < j9) {
                                        z3 = z5;
                                        j9 = j13;
                                        i7 = i9;
                                    }
                                }
                                if (z5 != z || j14 >= j11) {
                                    z4 = z;
                                } else {
                                    z4 = z5;
                                    j10 = j13;
                                    i8 = i9;
                                    j11 = j14;
                                }
                                if (j13 < j9) {
                                    z3 = z5;
                                    j9 = j13;
                                    i7 = i9;
                                }
                            }
                            i9++;
                        }
                        i6 = (j9 == Long.MAX_VALUE || !z3 || j10 < j9 + 10485760) ? i8 : i7;
                        this.zzp = i6;
                        if (i6 == -1) {
                            return -1;
                        }
                    }
                    zzaip zzaipVar2 = this.zzx[i6];
                    zzaei zzaeiVar = zzaipVar2.zzc;
                    int i12 = zzaipVar2.zze;
                    zzaiz zzaizVar2 = zzaipVar2.zzb;
                    long j15 = zzaizVar2.zzc[i12] + this.zzv;
                    int[] iArr = zzaizVar2.zzd;
                    int i13 = iArr[i12];
                    zzaej zzaejVar = zzaipVar2.zzd;
                    long j16 = (j15 - jZzf3) + ((long) this.zzq);
                    if (j16 < 0 || j16 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzadyVar.zza = j15;
                        return 1;
                    }
                    zzaiw zzaiwVar = zzaipVar2.zza;
                    if (zzaiwVar.zzh == 1) {
                        j16 += 8;
                        i13 -= 8;
                    }
                    int i14 = i13;
                    zzaddVar.zzk((int) j16);
                    zzz zzzVar = zzaiwVar.zzg;
                    String str = zzzVar.zzo;
                    if (!Objects.equals(str, "video/avc")) {
                        Objects.equals(str, "video/hevc");
                    }
                    this.zzt = true;
                    int i15 = zzaiwVar.zzk;
                    if (i15 == 0) {
                        if ("audio/ac4".equals(str)) {
                            if (this.zzr == 0) {
                                zzek zzekVar5 = this.zze;
                                zzacf.zzc(i14, zzekVar5);
                                zzaeiVar.zzr(zzekVar5, 7);
                                this.zzr += 7;
                            }
                            i14 += 7;
                        } else if (zzaejVar != null) {
                            zzaejVar.zzd(zzaddVar);
                        }
                        while (true) {
                            int i16 = this.zzr;
                            if (i16 >= i14) {
                                break;
                            }
                            int iZzf = zzaeiVar.zzf(zzaddVar, i14 - i16, false);
                            this.zzq += iZzf;
                            this.zzr += iZzf;
                            this.zzs -= iZzf;
                        }
                    } else {
                        zzek zzekVar6 = this.zzd;
                        byte[] bArrZzN = zzekVar6.zzN();
                        bArrZzN[0] = 0;
                        bArrZzN[1] = 0;
                        bArrZzN[2] = 0;
                        int i17 = 4 - i15;
                        i14 += i17;
                        while (this.zzr < i14) {
                            int i18 = this.zzs;
                            if (i18 == 0) {
                                if (this.zzt) {
                                    i = i14;
                                } else {
                                    i = i14;
                                    if (zzfq.zzb(zzzVar) + i15 <= iArr[i12] - this.zzq) {
                                        iZzb = zzfq.zzb(zzzVar);
                                        i2 = i15 + iZzb;
                                    }
                                    zzaddVar.zzi(bArrZzN, i17, i2);
                                    this.zzq += i2;
                                    zzekVar6.zzL(0);
                                    iZzg = zzekVar6.zzg();
                                    if (iZzg >= 0) {
                                        throw zzaz.zza("Invalid NAL length", null);
                                    }
                                    this.zzs = iZzg - iZzb;
                                    zzek zzekVar7 = this.zzc;
                                    zzekVar7.zzL(0);
                                    zzaeiVar.zzr(zzekVar7, 4);
                                    this.zzr += 4;
                                    if (iZzb > 0) {
                                        zzaeiVar.zzr(zzekVar6, iZzb);
                                        this.zzr += iZzb;
                                        if (zzfq.zzj(bArrZzN, 4, iZzb, zzzVar)) {
                                            this.zzt = true;
                                        }
                                    }
                                }
                                i2 = i15;
                                iZzb = 0;
                                zzaddVar.zzi(bArrZzN, i17, i2);
                                this.zzq += i2;
                                zzekVar6.zzL(0);
                                iZzg = zzekVar6.zzg();
                                if (iZzg >= 0) {
                                    throw zzaz.zza("Invalid NAL length", null);
                                }
                                this.zzs = iZzg - iZzb;
                                zzek zzekVar8 = this.zzc;
                                zzekVar8.zzL(0);
                                zzaeiVar.zzr(zzekVar8, 4);
                                this.zzr += 4;
                                if (iZzb > 0) {
                                    zzaeiVar.zzr(zzekVar6, iZzb);
                                    this.zzr += iZzb;
                                    if (zzfq.zzj(bArrZzN, 4, iZzb, zzzVar)) {
                                        this.zzt = true;
                                    }
                                }
                            } else {
                                i = i14;
                                int iZzf2 = zzaeiVar.zzf(zzaddVar, i18, false);
                                this.zzq += iZzf2;
                                this.zzr += iZzf2;
                                this.zzs -= iZzf2;
                            }
                            i14 = i;
                        }
                    }
                    long j17 = zzaizVar2.zzf[i12];
                    int i19 = zzaizVar2.zzg[i12];
                    if (!this.zzt) {
                        i19 |= 67108864;
                    }
                    if (zzaejVar != null) {
                        zzaejVar.zzc(zzaeiVar, j17, i19, i14, 0, null);
                        if (i12 + 1 == zzaizVar2.zzb) {
                            zzaejVar.zza(zzaeiVar, null);
                        }
                    } else {
                        zzaeiVar.zzt(j17, i19, i14, 0, null);
                    }
                    zzaipVar2.zze++;
                    this.zzp = -1;
                    this.zzq = 0;
                    this.zzr = 0;
                    this.zzs = 0;
                    this.zzt = false;
                    return 0;
                }
                long j18 = this.zzm - ((long) this.zzn);
                long jZzf4 = zzaddVar.zzf() + j18;
                zzek zzekVar9 = this.zzo;
                if (zzekVar9 != null) {
                    zzaddVar.zzi(zzekVar9.zzN(), this.zzn, (int) j18);
                    if (this.zzl == 1718909296) {
                        this.zzu = true;
                        zzekVar9.zzL(8);
                        int iZzj = zzj(zzekVar9.zzg());
                        if (iZzj == 0) {
                            zzekVar9.zzM(4);
                            do {
                                if (zzekVar9.zza() <= 0) {
                                    iZzj = 0;
                                    break;
                                }
                                iZzj = zzj(zzekVar9.zzg());
                            } while (iZzj == 0);
                        }
                        this.zzB = iZzj;
                    } else {
                        ArrayDeque arrayDeque = this.zzg;
                        if (!arrayDeque.isEmpty()) {
                            ((zzex) arrayDeque.peek()).zzd(new zzey(this.zzl, zzekVar9));
                        }
                    }
                } else {
                    if (!this.zzu && this.zzl == 1835295092) {
                        this.zzB = 1;
                    }
                    if (j18 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzaddVar.zzk((int) j18);
                    } else {
                        zzadyVar.zza = zzaddVar.zzf() + j18;
                        z2 = true;
                    }
                    zzn(jZzf4);
                    if (z2 && this.zzk != 2) {
                        return 1;
                    }
                }
                z2 = false;
                zzn(jZzf4);
                if (z2) {
                    continue;
                }
            }
        }
    }
}
